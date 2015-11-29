package iggy.gen.parser;

/* This file has been generated. */

import com.intellij.lang.ASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiParser;
import com.intellij.psi.impl.source.tree.Factory;
import com.intellij.psi.tree.IElementType;
import iguana.parsetrees.sppf.NonterminalNode;
import iguana.parsetrees.tree.TermBuilder;
import iguana.utils.input.Input;
import org.iguana.grammar.Grammar;
import org.iguana.grammar.GrammarGraph;
import org.iguana.grammar.symbol.Nonterminal;
import org.iguana.grammar.transformation.DesugarPrecedenceAndAssociativity;
import org.iguana.grammar.transformation.EBNFToBNF;
import org.iguana.grammar.transformation.LayoutWeaver;
import org.iguana.parser.Iguana;
import org.iguana.parser.ParseResult;
import org.iguana.traversal.idea.Names;
import org.iguana.util.Configuration;

public class IGGYParser implements PsiParser {

    private Grammar grammar;
    private GrammarGraph graph;

    public ASTNode parse(IElementType root, PsiBuilder builder) {
        Input input = Input.fromString(builder.getOriginalText().toString());
        if (graph == null) {
            grammar = Grammar.load(this.getClass().getClassLoader().getResourceAsStream("iggy/gen/parser/grammar/IGGY"));
            DesugarPrecedenceAndAssociativity precedenceAndAssociativity = new DesugarPrecedenceAndAssociativity();
            precedenceAndAssociativity.setOP2();
            grammar = new EBNFToBNF().transform(grammar);
            grammar = precedenceAndAssociativity.transform(grammar);
            grammar = new Names().transform(grammar);
            grammar = new LayoutWeaver().transform(grammar);
            graph = GrammarGraph.from(grammar, input, Configuration.DEFAULT);
        }
        ParseResult result = Iguana.parse(input, graph, Nonterminal.withName("Definition"));
        if (result.isParseSuccess()) {
            System.out.println("Success...");
            NonterminalNode sppf = result.asParseSuccess().getSPPFNode();
            ASTNode ast = TermBuilder.build_no_memo(sppf, new IGGYTreeBuilder());
            return ast;
        } else {
            System.out.println("Parse error...");
            return Factory.createErrorElement("Sorry, you have a parse error.");
        }
    }
}

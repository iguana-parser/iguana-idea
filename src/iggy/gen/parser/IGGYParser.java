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
import org.iguana.parser.GLLParser;
import org.iguana.parser.ParseResult;
import org.iguana.parser.ParserFactory;
import org.iguana.util.Configuration;

public class IGGYParser implements PsiParser {

    private Grammar grammar;
    private GrammarGraph graph;
    private GLLParser parser;

    public ASTNode parse(IElementType root, PsiBuilder builder) {
        Input input = Input.fromString(builder.getOriginalText().toString());
        if (parser == null) {
            grammar = Grammar.load(this.getClass().getClassLoader().getResourceAsStream("iggy/gen/parser/grammar/IGGY"));
            DesugarPrecedenceAndAssociativity precedenceAndAssociativity = new DesugarPrecedenceAndAssociativity();
            precedenceAndAssociativity.setOP2();
            grammar = new EBNFToBNF().transform(grammar);
            grammar = precedenceAndAssociativity.transform(grammar);
            grammar = new LayoutWeaver().transform(grammar);
            graph = grammar.toGrammarGraph(input, Configuration.DEFAULT);
            parser = ParserFactory.getParser();
        }
        ParseResult result = parser.parse(input, graph, Nonterminal.withName("Definition"));
        if (result.isParseSuccess()) {
            System.out.println("Success...");
            NonterminalNode sppf = result.asParseSuccess().getSPPFNode();
            ASTNode ast = TermBuilder.build_no_memo(sppf, new IGGYTreeBuilder(input));
            System.out.println("Term has been built...");
            return ast;
        } else {
            System.out.println("Parse error...");
            return Factory.createErrorElement("Sorry, you have a parse error.");
        }
    }
}

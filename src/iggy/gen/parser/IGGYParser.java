package iggy.gen.parser;

import com.intellij.lang.ASTFactory;
import com.intellij.lang.ASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiParser;
import com.intellij.psi.impl.source.tree.Factory;
import com.intellij.psi.tree.IElementType;
import iguana.parsetrees.sppf.NonterminalNode;
import iguana.parsetrees.tree.TermBuilder;
import iguana.parsetrees.tree.TreeBuilder;
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
import org.jetbrains.annotations.NotNull;

import java.io.File;

/**
 * Created by Anastasia Izmaylova on 29/09/15.
 */

public class IGGYParser implements PsiParser {

    private Grammar grammar;
    private GrammarGraph graph;
    private GLLParser parser;


    @NotNull
    @Override
    public ASTNode parse(IElementType root, PsiBuilder builder) {

        Input input = Input.fromString(builder.getOriginalText().toString());
        // Input input = Input.fromString("A ::= B() [0] D() {0}");
        if (graph == null) {
            grammar = Grammar.load(new File("/Users/anastasiaizmaylova/git/iguana-idea/src/iggy/gen/parser/grammar/IGGY"));

            DesugarPrecedenceAndAssociativity precedenceAndAssociativity = new DesugarPrecedenceAndAssociativity();
            precedenceAndAssociativity.setOP2();

            grammar = new LayoutWeaver().transform(precedenceAndAssociativity.transform(new EBNFToBNF().transform(grammar)));

            System.out.println(grammar);

            graph = grammar.toGrammarGraph(input, Configuration.DEFAULT);
            parser = ParserFactory.getParser();
        }

        ParseResult result = parser.parse(input, graph, Nonterminal.withName("Definition"));

        if (result.isParseSuccess()) {
            System.out.println("Success...");
            NonterminalNode node = result.asParseSuccess().getSPPFNode();
            System.out.println(node);
            ASTNode astNode = TermBuilder.build(node, new IGGYTreeBuilder(input));
            return astNode;
        } else {
            System.out.println("Parse error...");
            return Factory.createErrorElement("Parse error");
        }
    }

    public static void main(String[] args) {
        new IGGYParser().parse(null, null);
    }
}

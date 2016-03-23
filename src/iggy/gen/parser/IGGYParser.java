package iggy.gen.parser;

/* This file has been generated. */

import com.intellij.lang.ASTFactory;
import com.intellij.lang.ASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiParser;
import com.intellij.lang.impl.PsiBuilderImpl;
import com.intellij.psi.impl.source.tree.CompositeElement;
import com.intellij.psi.impl.source.tree.Factory;
import com.intellij.psi.impl.source.tree.TreeElement;
import com.intellij.psi.tree.IElementType;
import iggy.gen.psi.IGGYElementTypes;
import iggy.gen.psi.IGGYTokenTypes;
import iguana.parsetrees.sppf.NonterminalNode;
import iguana.parsetrees.term.SPPFToTerms;
import iguana.utils.input.Input;
import org.iguana.grammar.Grammar;
import org.iguana.grammar.GrammarGraph;
import org.iguana.grammar.slot.NonterminalGrammarSlot;
import org.iguana.grammar.symbol.Nonterminal;
import org.iguana.grammar.symbol.Start;
import org.iguana.grammar.transformation.DesugarPrecedenceAndAssociativity;
import org.iguana.grammar.transformation.EBNFToBNF;
import org.iguana.grammar.transformation.LayoutWeaver;
import org.iguana.parser.Iguana;
import org.iguana.parser.ParseResult;
import org.iguana.traversal.idea.Names;
import org.iguana.util.Configuration;

import java.io.IOException;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IGGYParser implements PsiParser {

    private static final Grammar grammar;
    private static final Start start;

    private static final String ntName = "Definition";

    private GrammarGraph graph;

    static {
        Grammar g = Grammar.load(IGGYParser.class.getResourceAsStream("/IggyGrammar"));
        DesugarPrecedenceAndAssociativity precedenceAndAssociativity = new DesugarPrecedenceAndAssociativity();
        precedenceAndAssociativity.setOP2();
        g = new EBNFToBNF().transform(g);
        g = precedenceAndAssociativity.transform(g);
        g = new Names().transform(g);
        grammar = new LayoutWeaver().transform(g);
        start = grammar.getStartSymbol(Nonterminal.withName(ntName));
    }

    private static final Pattern pattern = java.util.regex.Pattern.compile("\\s++[^\\s]++\\s*+::=");

    public ASTNode parse(IElementType root, PsiBuilder builder) {
        Input input = Input.fromString(builder.getOriginalText().toString());
        graph = GrammarGraph.from(grammar, input, Configuration.DEFAULT);
        ParseResult result = Iguana.parse(input, graph, start);
        if (result.isParseSuccess()) {
            System.out.println("Success...");
            NonterminalNode sppf = result.asParseSuccess().getSPPFNode();
            ASTNode ast = SPPFToTerms.convertNoSharing(sppf, new IGGYTermBuilder());
            return ast;
        } else {
            System.out.println("Parse error..." + result);
            NonterminalNode l = graph.getHead(Nonterminal.withName("Layout"))
                    .getGSSNode(0).getNonterminalNode(input);
            if (l != null) {
                NonterminalNode sppf = graph.getHead(Nonterminal.withName("Rule+"))
                        .getGSSNode(l.getRightExtent()).getNonterminalNode(input);
                if (sppf != null) {
                    Matcher matcher = pattern.matcher(input.toString());
                    int index = -1;
                    ParseResult res = null;
                    if (matcher.find(sppf.getRightExtent())) {
                        index = matcher.start();
                        if (index <= result.asParseError().inputIndex()) {
                            if (matcher.find(matcher.end()))
                                index = matcher.start();
                        }
                        res = Iguana.parse(Input.fromString(input.subString(index, input.length())), graph, start);
                    }
                    CompositeElement startNode = ASTFactory.composite(IGGYElementTypes.get("START_"+ ntName.toUpperCase() + "_START"));
                    startNode.rawAddChildrenWithoutNotifications(SPPFToTerms.convertNoSharing(l, new IGGYTermBuilder()));
                    CompositeElement node = ASTFactory.composite(IGGYElementTypes.get(ntName.toUpperCase()));
                    CompositeElement child = (CompositeElement) SPPFToTerms.convertNoSharing(sppf, new IGGYTermBuilder());
                    CompositeElement error = Factory.createErrorElement("Sorry, you have a parse error.");
                    if (res != null && res.isParseSuccess()) {
                        child.rawAddChildrenWithoutNotifications(error);
                        error.rawAddChildrenWithoutNotifications(ASTFactory.leaf(IGGYTokenTypes.TERMINAL, input.subString(sppf.getRightExtent(), index)));
                        sppf = res.asParseSuccess().getSPPFNode();
                        TreeElement ast = SPPFToTerms.convertNoSharing(sppf, new IGGYTermBuilder());
                        TreeElement first = ast.getFirstChildNode();
                        ast.getFirstChildNode().rawRemove();
                        child.rawAddChildrenWithoutNotifications(first);
                        first = ast.getFirstChildNode();
                        ast.getFirstChildNode().rawRemove();
                        TreeElement list = first.getFirstChildNode();
                        first.getFirstChildNode().rawRemove();
                        first = list.getFirstChildNode();
                        while (first != null) {
                            list.getFirstChildNode().rawRemove();
                            child.rawAddChildrenWithoutNotifications(first);
                            first = list.getFirstChildNode();
                        }
                        node.rawAddChildrenWithoutNotifications(child);
                        startNode.rawAddChildrenWithoutNotifications(node);
                        first = ast.getFirstChildNode();
                        ast.getFirstChildNode().rawRemove();
                        startNode.rawAddChildrenWithoutNotifications(first);
                        return startNode;
                    }
                    node.rawAddChildrenWithoutNotifications(child);
                    startNode.rawAddChildrenWithoutNotifications(node);
                    startNode.rawAddChildrenWithoutNotifications(error);
                    error.rawAddChildrenWithoutNotifications(ASTFactory.leaf(IGGYTokenTypes.TERMINAL, input.subString(sppf.getRightExtent(), input.length())));
                    return startNode;
                }
            }
            CompositeElement ast = Factory.createErrorElement("Sorry, you have a parse error.");
            ast.rawAddChildrenWithoutNotifications(ASTFactory.leaf(IGGYTokenTypes.TERMINAL, input.toString()));
            return ast;
        }
    }
}

package iggy.gen.parser;

import com.intellij.lang.ASTFactory;
import com.intellij.lang.ASTNode;
import com.intellij.psi.impl.source.tree.CompositeElement;
import com.intellij.psi.impl.source.tree.TreeElement;
import com.intellij.psi.tree.IElementType;
import iggy.gen.psi.IGGYElementTypes;
import iggy.gen.psi.IGGYTokenTypes;
import iguana.parsetrees.tree.Branch;
import iguana.parsetrees.tree.TreeBuilder;
import iguana.utils.input.Input;
import org.iguana.grammar.symbol.Rule;
import scala.collection.*;

/**
 * Created by Anastasia Izmaylova on 04/10/15.
 */

public class IGGYTreeBuilder implements TreeBuilder<ASTNode> {

    private final Input input;

    public IGGYTreeBuilder(Input input) {
        this.input = input;
    }

    @Override
    public ASTNode terminalNode(int l, int r) {
        return ASTFactory.leaf(IGGYTokenTypes.CHARACTER, input.subString(l, r));
    }

    @Override
    public ASTNode terminalNode(String name, int l, int r) {
        IElementType tokenType = IGGYTokenTypes.get(name);

        if (tokenType == IGGYTokenTypes.WHITESPACE)
            return ASTFactory.whitespace(input.subString(l, r));

        return ASTFactory.leaf(tokenType, input.subString(l, r));
    }

    @Override
    public ASTNode nonterminalNode(Object ruleType, Seq<ASTNode> children, int l, int r) {
        Rule type = (Rule) ruleType;
        String nt = type.getHead().getName().toUpperCase() + (type.getLabel() == null? "" : "_" + type.getLabel().toUpperCase());
        CompositeElement node = ASTFactory.composite(IGGYElementTypes.get(nt));
        Iterator<ASTNode> iterator = children.iterator();
        while (iterator.hasNext())
            node.rawAddChildren((TreeElement) iterator.next());
        return node;
    }

    @Override
    public ASTNode ambiguityNode(scala.collection.Iterable<Branch<ASTNode>> children, int l, int r) {
        throw new RuntimeException("Not yet supported in the idea tree builder: ambiguity.");
    }

    @Override
    public ASTNode cycle() {
        throw new RuntimeException("Not yet supported in the idea tree builder: cycles.");
    }

    @Override
    public Branch<ASTNode> branch(Seq<ASTNode> children) {
        throw new RuntimeException("Not yet supported in the idea tree builder: ambiguity.");
    }

    @Override
    public ASTNode star(Seq<ASTNode> children) {
        CompositeElement node = ASTFactory.composite(IGGYElementTypes.LIST);
        Iterator<ASTNode> iterator = children.iterator();
        while (iterator.hasNext())
            node.rawAddChildren((TreeElement) iterator.next());
        return node;
    }

    @Override
    public ASTNode plus(Seq<ASTNode> children) {
        CompositeElement node = ASTFactory.composite(IGGYElementTypes.LIST);
        Iterator<ASTNode> iterator = children.iterator();
        while (iterator.hasNext())
            node.rawAddChildren((TreeElement) iterator.next());
        return node;
    }

    @Override
    public ASTNode opt(ASTNode child) {
        CompositeElement node = ASTFactory.composite(IGGYElementTypes.OPT);
        node.rawAddChildren((TreeElement) child);
        return node;
    }

    @Override
    public ASTNode group(Seq<ASTNode> children) {
        CompositeElement node = ASTFactory.composite(IGGYElementTypes.SEQ);
        Iterator<ASTNode> iterator = children.iterator();
        while (iterator.hasNext())
            node.rawAddChildren((TreeElement) iterator.next());
        return node;
    }

    @Override
    public ASTNode epsilon(int i) {
        return ASTFactory.leaf(IGGYTokenTypes.CHARACTER, "");
    }

}

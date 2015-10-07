package iggy.gen.parser;

/* This file has been generated. */

import com.intellij.lang.ASTFactory;
import com.intellij.psi.impl.source.tree.CompositeElement;
import com.intellij.psi.impl.source.tree.TreeElement;
import com.intellij.psi.tree.IElementType;
import iggy.gen.psi.IGGYElementTypes;
import iggy.gen.psi.IGGYTokenTypes;
import iguana.parsetrees.tree.Branch;
import iguana.parsetrees.tree.RuleType;
import iguana.parsetrees.tree.TreeBuilder;
import iguana.utils.input.Input;
import org.iguana.grammar.symbol.Rule;
import scala.collection.*;

public class IGGYTreeBuilder implements TreeBuilder<TreeElement> {

    private final Input input;

    public IGGYTreeBuilder(Input input) { this.input = input; }

    public TreeElement terminalNode(int l, int r) { return ASTFactory.leaf(IGGYTokenTypes.CHARACTER, input.subString(l, r)); }

    public TreeElement terminalNode(String name, int l, int r) {
        IElementType tokenType = IGGYTokenTypes.get(name);
        return ASTFactory.leaf(tokenType, input.subString(l, r));
    }

    public TreeElement nonterminalNode(RuleType type, Seq<TreeElement> children, int l, int r) {
        Rule rule = (Rule) type;
        String name = rule.getHead().getName().toUpperCase() + (rule.getLabel() == null? "" : "_" + rule.getLabel().toUpperCase());
        CompositeElement node = ASTFactory.composite(IGGYElementTypes.get(name));
        Iterator<TreeElement> iterator = children.iterator();
        while (iterator.hasNext()) node.rawAddChildrenWithoutNotifications(iterator.next());
        return node;
    }

    public TreeElement ambiguityNode(scala.collection.Iterable<Branch<TreeElement>> children, int l, int r) { throw new RuntimeException("Not yet supported in the idea tree builder: ambiguity."); }

    public TreeElement cycle() { throw new RuntimeException("Not yet supported in the idea tree builder: cycles."); }

    public Branch<TreeElement> branch(Seq<TreeElement> children) { throw new RuntimeException("Not yet supported in the idea tree builder: ambiguity."); } 

    public TreeElement star(Seq<TreeElement> children) {
        CompositeElement node = ASTFactory.composite(IGGYElementTypes.LIST);
        Iterator<TreeElement> iterator = children.iterator();
        while (iterator.hasNext()) node.rawAddChildrenWithoutNotifications(iterator.next());
        return node;
    }

    public TreeElement plus(Seq<TreeElement> children) { return star(children); }

    public TreeElement opt(TreeElement child) {
        CompositeElement node = ASTFactory.composite(IGGYElementTypes.OPT);
        node.rawAddChildrenWithoutNotifications(child);
        return node;
    }

    public TreeElement group(Seq<TreeElement> children) {
        CompositeElement node = ASTFactory.composite(IGGYElementTypes.SEQ);
        Iterator<TreeElement> iterator = children.iterator();
        while (iterator.hasNext()) node.rawAddChildrenWithoutNotifications(iterator.next());
        return node;
    }

    public TreeElement alt(Seq<TreeElement> children) {
        CompositeElement node = ASTFactory.composite(IGGYElementTypes.ALT);
        Iterator<TreeElement> iterator = children.iterator();
        while (iterator.hasNext()) node.rawAddChildrenWithoutNotifications(iterator.next());
        return node;
    }

    public TreeElement epsilon(int i) { return ASTFactory.leaf(IGGYTokenTypes.CHARACTER, ""); }
}

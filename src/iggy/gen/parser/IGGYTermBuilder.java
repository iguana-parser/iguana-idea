package iggy.gen.parser;

/* This file has been generated. */

import com.intellij.lang.ASTFactory;
import com.intellij.psi.impl.source.tree.CompositeElement;
import com.intellij.psi.impl.source.tree.TreeElement;
import com.intellij.psi.tree.IElementType;
import iggy.gen.psi.IGGYElementTypes;
import iggy.gen.psi.IGGYTokenTypes;
import iguana.parsetrees.slot.TerminalNodeType;
import iguana.parsetrees.term.RuleType;
import iguana.parsetrees.term.TermBuilder;
import iguana.parsetrees.term.TerminalType;
import iguana.utils.input.Input;
import org.iguana.grammar.symbol.Rule;
import scala.collection.*;

public class IGGYTermBuilder implements TermBuilder<TreeElement> {

    @Override
    public TreeElement terminalTerm(TerminalType type, int l, int r, Input input) {
        if (type.nodeType() == TerminalNodeType.Regex()) {
            IElementType tokenType = IGGYTokenTypes.get(type.name().toUpperCase());
            return ASTFactory.leaf(tokenType, input.subString(l, r));
        }
        if (type.nodeType() == TerminalNodeType.Keyword())
            return ASTFactory.leaf(IGGYTokenTypes.KEYWORD, input.subString(l, r));
        return ASTFactory.leaf(IGGYTokenTypes.TERMINAL, input.subString(l, r));
    }

    @Override
    public TreeElement nonterminalTerm(RuleType type, Seq<TreeElement> children, int l, int r, Input input) {
        Rule rule = (Rule) type;
        String name = rule.getHead().getName().toUpperCase() + (rule.getLabel() == null? "" : "_" + rule.getLabel().toUpperCase());
        CompositeElement node = ASTFactory.composite(IGGYElementTypes.get(name));
        Iterator<TreeElement> iterator = children.iterator();
        while (iterator.hasNext()) node.rawAddChildrenWithoutNotifications(iterator.next());
        return node;
    }

    @Override
    public TreeElement ambiguityTerm(scala.collection.Seq<scala.collection.Seq<TreeElement>> children) { throw new RuntimeException("Not yet supported in the idea tree builder: ambiguity."); }

    @Override
    public TreeElement cycle(String label) { throw new RuntimeException("Not yet supported in the idea tree builder: cycles."); }

    @Override
    public TreeElement star(Seq<TreeElement> children) {
        CompositeElement node = ASTFactory.composite(IGGYElementTypes.LIST);
        Iterator<TreeElement> iterator = children.iterator();
        while (iterator.hasNext()) node.rawAddChildrenWithoutNotifications(iterator.next());
        return node;
    }

    @Override
    public TreeElement plus(Seq<TreeElement> children) { return star(children); }

    @Override
    public TreeElement opt(TreeElement child) {
        CompositeElement node = ASTFactory.composite(IGGYElementTypes.OPT);
        node.rawAddChildrenWithoutNotifications(child);
        return node;
    }

    @Override
    public TreeElement group(Seq<TreeElement> children) {
        CompositeElement node = ASTFactory.composite(IGGYElementTypes.SEQ);
        Iterator<TreeElement> iterator = children.iterator();
        while (iterator.hasNext()) node.rawAddChildrenWithoutNotifications(iterator.next());
        return node;
    }

    @Override
    public TreeElement alt(Seq<TreeElement> children) {
        CompositeElement node = ASTFactory.composite(IGGYElementTypes.ALT);
        Iterator<TreeElement> iterator = children.iterator();
        while (iterator.hasNext()) node.rawAddChildrenWithoutNotifications(iterator.next());
        return node;
    }

    @Override
    public TreeElement epsilon(int i) { return ASTFactory.leaf(IGGYTokenTypes.TERMINAL, ""); }
}

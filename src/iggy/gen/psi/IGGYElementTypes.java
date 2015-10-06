package iggy.gen.psi;

/* This file has been generated. */

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import iggy.gen.psi.IGGYElementType;
import iggy.gen.psi.impl.*;

public interface IGGYElementTypes {

    public IElementType LIST = new IGGYElementType("LIST");
    public IElementType OPT = new IGGYElementType("OPT");
    public IElementType ALT = new IGGYElementType("ALT");
    public IElementType SEQ = new IGGYElementType("SEQ");

    public IElementType RETURN = new IGGYElementType("RETURN");
    public IElementType DEFINITION = new IGGYElementType("DEFINITION");
    public IElementType PARAMETERS = new IGGYElementType("PARAMETERS");
    public IElementType LAYOUT = new IGGYElementType("LAYOUT");
    public IElementType BINDING = new IGGYElementType("BINDING");
    public IElementType EXPRESSION_NUMBER = new IGGYElementType("EXPRESSION_NUMBER");
    public IElementType EXPRESSION_PLUS = new IGGYElementType("EXPRESSION_PLUS");
    public IElementType EXPRESSION_MULTIPLICATION = new IGGYElementType("EXPRESSION_MULTIPLICATION");
    public IElementType SYMBOL_NONTERMINAL = new IGGYElementType("SYMBOL_NONTERMINAL");
    public IElementType SYMBOL_CONSTRAINT = new IGGYElementType("SYMBOL_CONSTRAINT");
    public IElementType SYMBOL_TERMINAL = new IGGYElementType("SYMBOL_TERMINAL");
    public IElementType SYMBOL_BINDING = new IGGYElementType("SYMBOL_BINDING");
    public IElementType RULE = new IGGYElementType("RULE");
    public IElementType TERMINAL = new IGGYElementType("TERMINAL");
    public IElementType ARGUMENTS = new IGGYElementType("ARGUMENTS");

    public static IElementType get(String name) {
        switch (name) {
            case "LIST": return LIST;
            case "OPT": return OPT;
            case "ALT": return ALT;
            case "SEQ": return SEQ;
            case "RETURN": return RETURN;
            case "DEFINITION": return DEFINITION;
            case "PARAMETERS": return PARAMETERS;
            case "LAYOUT": return LAYOUT;
            case "BINDING": return BINDING;
            case "EXPRESSION_NUMBER": return EXPRESSION_NUMBER;
            case "EXPRESSION_PLUS": return EXPRESSION_PLUS;
            case "EXPRESSION_MULTIPLICATION": return EXPRESSION_MULTIPLICATION;
            case "SYMBOL_NONTERMINAL": return SYMBOL_NONTERMINAL;
            case "SYMBOL_CONSTRAINT": return SYMBOL_CONSTRAINT;
            case "SYMBOL_TERMINAL": return SYMBOL_TERMINAL;
            case "SYMBOL_BINDING": return SYMBOL_BINDING;
            case "RULE": return RULE;
            case "TERMINAL": return TERMINAL;
            case "ARGUMENTS": return ARGUMENTS;
            default:
                return null;
        }
    }

    // TODO: generate missing code to make the grammar easy changeable

    class Factory {

        public static PsiElement createElement(ASTNode node) {

            IElementType type = node.getElementType();

            if (type == LIST || type == OPT || type == ALT || type == SEQ)
                return new EbnfElementImpl(node);

            if (type == RETURN) return new ReturnImpl(node);
            if (type == DEFINITION) return new DefinitionImpl(node);
            if (type == PARAMETERS) return new DefinitionImpl(node);
            if (type == LAYOUT) return new LayoutImpl(node);
            if (type == BINDING) return new BindingImpl(node);
            if (type == EXPRESSION_NUMBER) return new ExpressionNumberImpl(node);
            if (type == EXPRESSION_PLUS) return new ExpressionPlusImpl(node);
            if (type == EXPRESSION_MULTIPLICATION) return new ExpressionMultiplicationImpl(node);
            if (type == SYMBOL_NONTERMINAL) return new SymbolNonterminalImpl(node);
            if (type == SYMBOL_CONSTRAINT) return new SymbolConstraintImpl(node);
            if (type == SYMBOL_TERMINAL) return new SymbolTerminalImpl(node);
            if (type == SYMBOL_BINDING) return new SymbolBindingImpl(node);
            if (type == RULE) return new RuleImpl(node);
            if (type == TERMINAL) return new TerminalImpl(node);
            if (type == ARGUMENTS) return new ArgumentsImpl(node);

            return null;
        }

    }
}

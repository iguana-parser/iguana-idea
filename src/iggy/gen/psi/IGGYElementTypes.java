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
    public IElementType LAYOUT = new IGGYElementType("LAYOUT");
    public IElementType BINDING = new IGGYElementType("BINDING");
    public IElementType EXPRESSION_BRACKET = new IGGYElementType("EXPRESSION_BRACKET");
    public IElementType EXPRESSION_MULTIPLICATION = new IGGYElementType("EXPRESSION_MULTIPLICATION");
    public IElementType EXPRESSION_OR = new IGGYElementType("EXPRESSION_OR");
    public IElementType EXPRESSION_NOTEQUAL = new IGGYElementType("EXPRESSION_NOTEQUAL");
    public IElementType EXPRESSION_GREATEREQ = new IGGYElementType("EXPRESSION_GREATEREQ");
    public IElementType EXPRESSION_NAME = new IGGYElementType("EXPRESSION_NAME");
    public IElementType EXPRESSION_LESSEQ = new IGGYElementType("EXPRESSION_LESSEQ");
    public IElementType EXPRESSION_NUMBER = new IGGYElementType("EXPRESSION_NUMBER");
    public IElementType EXPRESSION_FUNCALL = new IGGYElementType("EXPRESSION_FUNCALL");
    public IElementType EXPRESSION_EQUAL = new IGGYElementType("EXPRESSION_EQUAL");
    public IElementType EXPRESSION_AND = new IGGYElementType("EXPRESSION_AND");
    public IElementType EXPRESSION_DEVISION = new IGGYElementType("EXPRESSION_DEVISION");
    public IElementType EXPRESSION_GREATER = new IGGYElementType("EXPRESSION_GREATER");
    public IElementType EXPRESSION_PLUS = new IGGYElementType("EXPRESSION_PLUS");
    public IElementType EXPRESSION_LESS = new IGGYElementType("EXPRESSION_LESS");
    public IElementType EXPRESSION_MINUS = new IGGYElementType("EXPRESSION_MINUS");
    public IElementType SYMBOL_BINDING = new IGGYElementType("SYMBOL_BINDING");
    public IElementType SYMBOL_CONSTRAINT = new IGGYElementType("SYMBOL_CONSTRAINT");
    public IElementType SYMBOL_NONTERMINAL = new IGGYElementType("SYMBOL_NONTERMINAL");
    public IElementType SYMBOL_TERMINAL = new IGGYElementType("SYMBOL_TERMINAL");
    public IElementType VARNAME = new IGGYElementType("VARNAME");
    public IElementType NONTNAME = new IGGYElementType("NONTNAME");
    public IElementType RULE = new IGGYElementType("RULE");
    public IElementType TERMINAL = new IGGYElementType("TERMINAL");
    public IElementType LABEL = new IGGYElementType("LABEL");
    public IElementType DEFINITION = new IGGYElementType("DEFINITION");
    public IElementType WHITESPACEORCOMMENT = new IGGYElementType("WHITESPACEORCOMMENT");
    public IElementType ARGUMENTS = new IGGYElementType("ARGUMENTS");
    public IElementType PARAMETERS = new IGGYElementType("PARAMETERS");

    public static IElementType get(String name) {
        switch (name) {
            case "LIST": return LIST;
            case "OPT": return OPT;
            case "ALT": return ALT;
            case "SEQ": return SEQ;
            case "RETURN": return RETURN;
            case "LAYOUT": return LAYOUT;
            case "BINDING": return BINDING;
            case "EXPRESSION_BRACKET": return EXPRESSION_BRACKET;
            case "EXPRESSION_MULTIPLICATION": return EXPRESSION_MULTIPLICATION;
            case "EXPRESSION_OR": return EXPRESSION_OR;
            case "EXPRESSION_NOTEQUAL": return EXPRESSION_NOTEQUAL;
            case "EXPRESSION_GREATEREQ": return EXPRESSION_GREATEREQ;
            case "EXPRESSION_NAME": return EXPRESSION_NAME;
            case "EXPRESSION_LESSEQ": return EXPRESSION_LESSEQ;
            case "EXPRESSION_NUMBER": return EXPRESSION_NUMBER;
            case "EXPRESSION_FUNCALL": return EXPRESSION_FUNCALL;
            case "EXPRESSION_EQUAL": return EXPRESSION_EQUAL;
            case "EXPRESSION_AND": return EXPRESSION_AND;
            case "EXPRESSION_DEVISION": return EXPRESSION_DEVISION;
            case "EXPRESSION_GREATER": return EXPRESSION_GREATER;
            case "EXPRESSION_PLUS": return EXPRESSION_PLUS;
            case "EXPRESSION_LESS": return EXPRESSION_LESS;
            case "EXPRESSION_MINUS": return EXPRESSION_MINUS;
            case "SYMBOL_BINDING": return SYMBOL_BINDING;
            case "SYMBOL_CONSTRAINT": return SYMBOL_CONSTRAINT;
            case "SYMBOL_NONTERMINAL": return SYMBOL_NONTERMINAL;
            case "SYMBOL_TERMINAL": return SYMBOL_TERMINAL;
            case "VARNAME": return VARNAME;
            case "NONTNAME": return NONTNAME;
            case "RULE": return RULE;
            case "TERMINAL": return TERMINAL;
            case "LABEL": return LABEL;
            case "DEFINITION": return DEFINITION;
            case "WHITESPACEORCOMMENT": return WHITESPACEORCOMMENT;
            case "ARGUMENTS": return ARGUMENTS;
            case "PARAMETERS": return PARAMETERS;
        }
        throw new RuntimeException("Should not have happened!");
    }

    class Factory {
        public static PsiElement createElement(ASTNode node) {
            IElementType type = node.getElementType();
            if (type == LIST || type == OPT || type == ALT || type == SEQ) return new EbnfElementImpl(node);
            if (type == RETURN) return new ReturnImpl(node);
            if (type == LAYOUT) return new LayoutImpl(node);
            if (type == BINDING) return new BindingImpl(node);
            if (type == EXPRESSION_BRACKET) return new ExpressionBracketImpl(node);
            if (type == EXPRESSION_MULTIPLICATION) return new ExpressionMultiplicationImpl(node);
            if (type == EXPRESSION_OR) return new ExpressionOrImpl(node);
            if (type == EXPRESSION_NOTEQUAL) return new ExpressionNotEqualImpl(node);
            if (type == EXPRESSION_GREATEREQ) return new ExpressionGreaterEqImpl(node);
            if (type == EXPRESSION_NAME) return new ExpressionNameImpl(node);
            if (type == EXPRESSION_LESSEQ) return new ExpressionLessEqImpl(node);
            if (type == EXPRESSION_NUMBER) return new ExpressionNumberImpl(node);
            if (type == EXPRESSION_FUNCALL) return new ExpressionFunCallImpl(node);
            if (type == EXPRESSION_EQUAL) return new ExpressionEqualImpl(node);
            if (type == EXPRESSION_AND) return new ExpressionAndImpl(node);
            if (type == EXPRESSION_DEVISION) return new ExpressionDevisionImpl(node);
            if (type == EXPRESSION_GREATER) return new ExpressionGreaterImpl(node);
            if (type == EXPRESSION_PLUS) return new ExpressionPlusImpl(node);
            if (type == EXPRESSION_LESS) return new ExpressionLessImpl(node);
            if (type == EXPRESSION_MINUS) return new ExpressionMinusImpl(node);
            if (type == SYMBOL_BINDING) return new SymbolBindingImpl(node);
            if (type == SYMBOL_CONSTRAINT) return new SymbolConstraintImpl(node);
            if (type == SYMBOL_NONTERMINAL) return new SymbolNonterminalImpl(node);
            if (type == SYMBOL_TERMINAL) return new SymbolTerminalImpl(node);
            if (type == VARNAME) return new VarNameImpl(node);
            if (type == NONTNAME) return new NontNameImpl(node);
            if (type == RULE) return new RuleImpl(node);
            if (type == TERMINAL) return new TerminalImpl(node);
            if (type == LABEL) return new LabelImpl(node);
            if (type == DEFINITION) return new DefinitionImpl(node);
            if (type == WHITESPACEORCOMMENT) return new WhiteSpaceOrCommentImpl(node);
            if (type == ARGUMENTS) return new ArgumentsImpl(node);
            if (type == PARAMETERS) return new ParametersImpl(node);
            throw new RuntimeException("Should not have happened!");
        }
    }
}

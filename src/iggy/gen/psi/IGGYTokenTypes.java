package iggy.gen.psi;

/** This file has been generated. */

import com.intellij.psi.tree.IElementType;
import iggy.gen.psi.IGGYTokenType;

public interface IGGYTokenTypes {

    IElementType KEYWORD = new IGGYTokenType("KEYWORD");
    IElementType CHAR = new IGGYTokenType("CHAR");
    IElementType STRING = new IGGYTokenType("STRING");
    IElementType NUMBER = new IGGYTokenType("NUMBER");
    IElementType ASSOCIATIVITY = new IGGYTokenType("ASSOCIATIVITY");
    IElementType RANGECHAR = new IGGYTokenType("RANGECHAR");
    IElementType COMMENT = new IGGYTokenType("COMMENT");
    IElementType WHITESPACES = new IGGYTokenType("WHITESPACES");
    IElementType LETTERORDIGITS = new IGGYTokenType("LETTERORDIGITS");
    IElementType TERMINAL = new IGGYTokenType("TERMINAL");
    IElementType OPEN_PARENTHESIS = new IGGYTokenType("OPEN_PARENTHESIS");
    IElementType CLOSE_PARENTHESIS = new IGGYTokenType("CLOSE_PARENTHESIS");
    IElementType OPERATOR = new IGGYTokenType("OPERATOR");
    IElementType OPEN_BRACKET = new IGGYTokenType("OPEN_BRACKET");
    IElementType CLOSE_BRACKET = new IGGYTokenType("CLOSE_BRACKET");
    IElementType OPEN_BRACE = new IGGYTokenType("OPEN_BRACE");
    IElementType CLOSE_BRACE = new IGGYTokenType("CLOSE_BRACE");
    IElementType BAD_CHARACTER = new IGGYTokenType("BAD_CHARACTER");

    static IElementType get(String name) {
        switch (name) {
            case "TERMINAL": return TERMINAL;
            case "NUMBER": return NUMBER;
            case "RANGECHAR": return RANGECHAR;
            case "OPEN_PARENTHESIS": return OPEN_PARENTHESIS;
            case "CLOSE_PARENTHESIS": return CLOSE_PARENTHESIS;
            case "OPEN_BRACKET": return OPEN_BRACKET;
            case "KEYWORD": return KEYWORD;
            case "CHAR": return CHAR;
            case "CLOSE_BRACKET": return CLOSE_BRACKET;
            case "WHITESPACES": return WHITESPACES;
            case "COMMENT": return COMMENT;
            case "LETTERORDIGITS": return LETTERORDIGITS;
            case "OPERATOR": return OPERATOR;
            case "OPEN_BRACE": return OPEN_BRACE;
            case "CLOSE_BRACE": return CLOSE_BRACE;
            case "STRING": return STRING;
            case "BAD_CHARACTER": return BAD_CHARACTER;
            case "ASSOCIATIVITY": return ASSOCIATIVITY;
            default: return TERMINAL;
        }
    }
}


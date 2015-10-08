package iggy.gen.psi;

/** This file has been generated. */

import com.intellij.psi.tree.IElementType;
import iggy.gen.psi.IGGYTokenType;

public interface IGGYTokenTypes {
    public IElementType NUMBER = new IGGYTokenType("NUMBER");
    public IElementType IDENTIFIER = new IGGYTokenType("IDENTIFIER");
    public IElementType LETTERORDIGIT = new IGGYTokenType("LETTERORDIGIT");
    public IElementType COMMENT = new IGGYTokenType("COMMENT");
    public IElementType WHITESPACE = new IGGYTokenType("WHITESPACE");
    public IElementType OPEN_BRACE = new IGGYTokenType("OPEN_BRACE");
    public IElementType CLOSE_BRACE = new IGGYTokenType("CLOSE_BRACE");
    public IElementType CHARACTER = new IGGYTokenType("CHARACTER");
    public IElementType OPEN_PARENTHESIS = new IGGYTokenType("OPEN_PARENTHESIS");
    public IElementType CLOSE_PARENTHESIS = new IGGYTokenType("CLOSE_PARENTHESIS");
    public IElementType OPERATOR = new IGGYTokenType("OPERATOR");
    public IElementType OPEN_BRACKET = new IGGYTokenType("OPEN_BRACKET");
    public IElementType CLOSE_BRACKET = new IGGYTokenType("CLOSE_BRACKET");
    public IElementType BAD_CHARACTER = new IGGYTokenType("BAD_CHARACTER");

    public static IElementType get(String name) {
        switch (name) {
            case "NUMBER": return NUMBER;
            case "OPEN_PARENTHESIS": return OPEN_PARENTHESIS;
            case "CLOSE_PARENTHESIS": return CLOSE_PARENTHESIS;
            case "OPEN_BRACKET": return OPEN_BRACKET;
            case "CLOSE_BRACKET": return CLOSE_BRACKET;
            case "COMMENT": return COMMENT;
            case "LETTERORDIGIT": return LETTERORDIGIT;
            case "OPERATOR": return OPERATOR;
            case "WHITESPACE": return WHITESPACE;
            case "OPEN_BRACE": return OPEN_BRACE;
            case "CLOSE_BRACE": return CLOSE_BRACE;
            case "BAD_CHARACTER": return BAD_CHARACTER;
            case "CHARACTER": return CHARACTER;
            case "IDENTIFIER": return IDENTIFIER;
            default: return CHARACTER;
        }
    }
}


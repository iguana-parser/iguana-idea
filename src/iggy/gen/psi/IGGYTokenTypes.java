package iggy.gen.psi;

/** This file has been generated. */

import com.intellij.psi.tree.IElementType;
import iggy.gen.psi.IGGYTokenType;

public interface IGGYTokenTypes {
    public IElementType IDENTIFIER = new IGGYTokenType("IDENTIFIER");
    public IElementType COMMENT = new IGGYTokenType("COMMENT");
    public IElementType WHITESPACE = new IGGYTokenType("WHITESPACE");
    public IElementType NUMBER = new IGGYTokenType("NUMBER");
    public IElementType LETTER = new IGGYTokenType("LETTER");
    public IElementType OPEN_BRACE = new IGGYTokenType("OPEN_BRACE");
    public IElementType CLOSE_BRACE = new IGGYTokenType("CLOSE_BRACE");
    public IElementType OPEN_PARENTHESIS = new IGGYTokenType("OPEN_PARENTHESIS");
    public IElementType CHARACTER = new IGGYTokenType("CHARACTER");
    public IElementType CLOSE_PARENTHESIS = new IGGYTokenType("CLOSE_PARENTHESIS");
    public IElementType OPERATOR = new IGGYTokenType("OPERATOR");
    public IElementType OPEN_BRACKET = new IGGYTokenType("OPEN_BRACKET");
    public IElementType CLOSE_BRACKET = new IGGYTokenType("CLOSE_BRACKET");
    public IElementType BAD_CHARACTER = new IGGYTokenType("BAD_CHARACTER");

    public static IElementType get(String name) {

        if (name.equals("IDENTIFIER"))
            return IDENTIFIER;
        if (name.equals("COMMENT"))
            return COMMENT;
        if (name.equals("WHITESPACE"))
            return WHITESPACE;
        if (name.equals("NUMBER"))
            return NUMBER;
        if (name.equals("LETTER"))
            return LETTER;
        if (name.equals("OPEN_BRACE"))
            return OPEN_BRACE;
        if (name.equals("CLOSE_BRACE"))
            return CLOSE_BRACE;
        if (name.equals("OPEN_PARENTHESIS"))
            return OPEN_PARENTHESIS;
        if (name.equals("CHARACTER"))
            return CHARACTER;
        if (name.equals("CLOSE_PARENTHESIS"))
            return CLOSE_PARENTHESIS;
        if (name.equals("OPERATOR"))
            return OPERATOR;
        if (name.equals("OPEN_BRACKET"))
            return OPEN_BRACKET;
        if (name.equals("CLOSE_BRACKET"))
            return CLOSE_BRACKET;
        if (name.equals("BAD_CHARACTER"))
            return BAD_CHARACTER;

        return CHARACTER;
    }
}


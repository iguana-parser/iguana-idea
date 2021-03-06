package iggy.gen.editor;

/** This file has been generated. */

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import iggy.gen.lexer.IGGYLexer;
import iggy.gen.psi.IGGYTokenTypes;

public class IGGYSyntaxHighlighter extends SyntaxHighlighterBase {

    public Lexer getHighlightingLexer() { return new IGGYLexer(); }

    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(IGGYTokenTypes.TERMINAL))
            return new TextAttributesKey[] {TextAttributesKey.createTextAttributesKey("TERMINAL", DefaultLanguageHighlighterColors.IDENTIFIER)};
        else if (tokenType.equals(IGGYTokenTypes.NUMBER))
            return new TextAttributesKey[] {TextAttributesKey.createTextAttributesKey("NUMBER", DefaultLanguageHighlighterColors.IDENTIFIER)};
        else if (tokenType.equals(IGGYTokenTypes.RANGECHAR))
            return new TextAttributesKey[] {TextAttributesKey.createTextAttributesKey("RANGECHAR", DefaultLanguageHighlighterColors.IDENTIFIER)};
        else if (tokenType.equals(IGGYTokenTypes.OPEN_PARENTHESIS))
            return new TextAttributesKey[] {TextAttributesKey.createTextAttributesKey("OPEN_PARENTHESIS", DefaultLanguageHighlighterColors.PARENTHESES)};
        else if (tokenType.equals(IGGYTokenTypes.CLOSE_PARENTHESIS))
            return new TextAttributesKey[] {TextAttributesKey.createTextAttributesKey("CLOSE_PARENTHESIS", DefaultLanguageHighlighterColors.PARENTHESES)};
        else if (tokenType.equals(IGGYTokenTypes.OPEN_BRACKET))
            return new TextAttributesKey[] {TextAttributesKey.createTextAttributesKey("OPEN_BRACKET", DefaultLanguageHighlighterColors.BRACKETS)};
        else if (tokenType.equals(IGGYTokenTypes.KEYWORD))
            return new TextAttributesKey[] {TextAttributesKey.createTextAttributesKey("KEYWORD", DefaultLanguageHighlighterColors.IDENTIFIER)};
        else if (tokenType.equals(IGGYTokenTypes.CHAR))
            return new TextAttributesKey[] {TextAttributesKey.createTextAttributesKey("CHAR", DefaultLanguageHighlighterColors.IDENTIFIER)};
        else if (tokenType.equals(IGGYTokenTypes.CLOSE_BRACKET))
            return new TextAttributesKey[] {TextAttributesKey.createTextAttributesKey("CLOSE_BRACKET", DefaultLanguageHighlighterColors.BRACKETS)};
        else if (tokenType.equals(IGGYTokenTypes.WHITESPACES))
            return new TextAttributesKey[] {TextAttributesKey.createTextAttributesKey("WHITESPACES", DefaultLanguageHighlighterColors.IDENTIFIER)};
        else if (tokenType.equals(IGGYTokenTypes.COMMENT))
            return new TextAttributesKey[] {TextAttributesKey.createTextAttributesKey("COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)};
        else if (tokenType.equals(IGGYTokenTypes.LETTERORDIGITS))
            return new TextAttributesKey[] {TextAttributesKey.createTextAttributesKey("LETTERORDIGITS", DefaultLanguageHighlighterColors.IDENTIFIER)};
        else if (tokenType.equals(IGGYTokenTypes.OPERATOR))
            return new TextAttributesKey[] {TextAttributesKey.createTextAttributesKey("OPERATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN)};
        else if (tokenType.equals(IGGYTokenTypes.OPEN_BRACE))
            return new TextAttributesKey[] {TextAttributesKey.createTextAttributesKey("OPEN_BRACE", DefaultLanguageHighlighterColors.BRACES)};
        else if (tokenType.equals(IGGYTokenTypes.CLOSE_BRACE))
            return new TextAttributesKey[] {TextAttributesKey.createTextAttributesKey("CLOSE_BRACE", DefaultLanguageHighlighterColors.BRACES)};
        else if (tokenType.equals(IGGYTokenTypes.STRING))
            return new TextAttributesKey[] {TextAttributesKey.createTextAttributesKey("STRING", DefaultLanguageHighlighterColors.IDENTIFIER)};
        else if (tokenType.equals(IGGYTokenTypes.BAD_CHARACTER))
            return new TextAttributesKey[] {TextAttributesKey.createTextAttributesKey("BAD_CHARACTER", HighlighterColors.TEXT)};
        else if (tokenType.equals(IGGYTokenTypes.ASSOCIATIVITY))
            return new TextAttributesKey[] {TextAttributesKey.createTextAttributesKey("ASSOCIATIVITY", DefaultLanguageHighlighterColors.IDENTIFIER)};
        return new TextAttributesKey[0];
    }
}


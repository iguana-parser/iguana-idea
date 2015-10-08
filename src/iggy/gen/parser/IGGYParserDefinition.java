package iggy.gen.parser;

/* This file has been generated. */

import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.text.BlockSupport;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import iggy.gen.lang.IGGYFile;
import iggy.gen.lang.IGGYLang;
import iggy.gen.lexer.IGGYLexer;
import iggy.gen.psi.IGGYElementTypes;
import iggy.gen.psi.IGGYTokenTypes;

public class IGGYParserDefinition implements ParserDefinition {

    public static final IFileElementType FILE = new IFileElementType(Language.<IGGYLang>findInstance(IGGYLang.class));

    public Lexer createLexer(Project project) { return new IGGYLexer(); }

    public PsiParser createParser(Project project) { return new IGGYParser(); }

    public IFileElementType getFileNodeType() { return FILE; }

    public TokenSet getWhitespaceTokens() { return TokenSet.EMPTY; }

    public TokenSet getCommentTokens() { return TokenSet.EMPTY; }

    public TokenSet getStringLiteralElements() { return TokenSet.EMPTY; }

    public PsiElement createElement(ASTNode node) { return IGGYElementTypes.Factory.createElement(node); }

    public PsiFile createFile(FileViewProvider viewProvider) {
        IGGYFile file = new IGGYFile(viewProvider);
        file.putUserData(BlockSupport.DO_NOT_REPARSE_INCREMENTALLY, Boolean.TRUE);
        return file;
    }

    public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right) { return SpaceRequirements.MAY; }
}

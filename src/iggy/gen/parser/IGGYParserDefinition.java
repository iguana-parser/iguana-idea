package iggy.gen.parser;

import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import iggy.gen.lang.IGGYFile;
import iggy.gen.lang.IGGYLang;
import iggy.gen.lexer.IGGYLexer;
import iggy.gen.psi.IGGYElementTypes;
import iggy.gen.psi.IGGYTokenTypes;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Anastasia Izmaylova on 29/09/15.
 */

public class IGGYParserDefinition implements ParserDefinition {

    public static final TokenSet WHITESPACES = TokenSet.create(IGGYTokenTypes.WHITESPACE);
    public static final TokenSet COMMENTS = TokenSet.create(IGGYTokenTypes.COMMENT);

    public static final IFileElementType FILE = new IFileElementType(Language.<IGGYLang>findInstance(IGGYLang.class));

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new IGGYLexer();
    }

    @Override
    public PsiParser createParser(Project project) {
        return new IGGYParser();
    }

    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    @NotNull
    @Override
    public TokenSet getWhitespaceTokens() {
        return WHITESPACES;
    }

    @NotNull
    @Override
    public TokenSet getCommentTokens() {
        return COMMENTS;
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY;
    }

    @NotNull
    @Override
    public PsiElement createElement(ASTNode node) {
        return IGGYElementTypes.Factory.createElement(node);
    }

    @Override
    public PsiFile createFile(FileViewProvider viewProvider) {
        return new IGGYFile(viewProvider);
    }

    @Override
    public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right) {
        return SpaceRequirements.MAY;
    }
}

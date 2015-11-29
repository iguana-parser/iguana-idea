package iggy.gen.editor;

import com.intellij.lang.cacheBuilder.DefaultWordsScanner;
import com.intellij.lang.cacheBuilder.WordsScanner;
import com.intellij.lang.findUsages.FindUsagesProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.TokenSet;
import iggy.gen.lexer.IGGYLexer;
import iggy.gen.psi.IGGYTokenTypes;
import iggy.gen.psi.impl.NontName$DeclarationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by Anastasia Izmaylova on 12/10/15.
 */

public class IGGYFindUsesProvider implements FindUsagesProvider {

    WordsScanner scanner = new DefaultWordsScanner(new IGGYLexer(),
            TokenSet.create(IGGYTokenTypes.TERMINAL), TokenSet.create(IGGYTokenTypes.COMMENT), TokenSet.EMPTY);

    @Nullable
    @Override
    public WordsScanner getWordsScanner() {
        return scanner;
    }

    @Override
    public boolean canFindUsagesFor(PsiElement psiElement) {
        return psiElement instanceof NontName$DeclarationImpl;
    }

    @Nullable
    @Override
    public String getHelpId(PsiElement psiElement) {
        return null;
    }

    @NotNull
    @Override
    public String getType(PsiElement element) {
        return "Nonterminal name";
    }

    @NotNull
    @Override
    public String getDescriptiveName(@NotNull PsiElement element) {
        return element.getText();
    }

    @NotNull
    @Override
    public String getNodeText(@NotNull PsiElement element, boolean useFullName) {
        return element.getText();
    }
}

package iggy.gen.utils;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.indexing.FileBasedIndex;
import iggy.gen.lang.IGGYFile;
import iggy.gen.lang.IGGYFileType;
import iggy.gen.psi.INontName$Declaration;
import iggy.gen.psi.impl.EbnfElementImpl;
import iggy.gen.psi.impl.RuleSyntaxImpl;

import java.util.Collection;
import java.util.List;

/**
 * Created by Anastasia Izmaylova on 08/10/15.
 */

public class IGGYUtil {

    public static PsiElement findNontName(Project project, PsiElement element) {
        Collection<VirtualFile> files = FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME, IGGYFileType.instance, GlobalSearchScope.allScope(project));
        for (VirtualFile file : files) {
            IGGYFile iggyfile = (IGGYFile) PsiManager.getInstance(project).findFile(file);
            if (iggyfile != null) {
                EbnfElementImpl[] elements = PsiTreeUtil.getChildrenOfType(iggyfile, EbnfElementImpl.class);
                if (elements != null) {
                    List<PsiElement> rules = elements[0].getElements();
                    for (PsiElement rule : rules) {
                        if (rule instanceof RuleSyntaxImpl) {
                            INontName$Declaration decl = ((RuleSyntaxImpl) rule).getNontName$Declaration();
                            if (decl.getText().equals(element.getText()))
                                return decl;
                        }
                    }
                }
            }
        }
        return null;
    }

    public static PsiElement findVarName(Project project, PsiElement element) {
        return null;
    }
}

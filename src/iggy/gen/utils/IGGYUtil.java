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
import iggy.gen.psi.impl.EbnfElementImpl;
import iggy.gen.psi.impl.RuleImpl;

import java.util.Collection;
import java.util.List;

/**
 * Created by Anastasia Izmaylova on 08/10/15.
 */

public class IGGYUtil {

    public static boolean findNontName(Project project, String name) {
        boolean found = false;
        Collection<VirtualFile> files = FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME, IGGYFileType.instance, GlobalSearchScope.allScope(project));
        for (VirtualFile file : files) {
            IGGYFile iggyFile = (IGGYFile) PsiManager.getInstance(project).findFile(file);
            if (iggyFile != null) {
                EbnfElementImpl[] elements = PsiTreeUtil.getChildrenOfType(iggyFile, EbnfElementImpl.class);
                if (elements != null) {
                    List<PsiElement> rules = elements[0].getElements();
                    for (PsiElement rule : rules) {
                        if (rule instanceof RuleImpl) {
                            if (((RuleImpl) rule).getNontName().getText().equals(name))
                                return true;
                        }
                    }
                }
            }
        }
        return found;
    }
}

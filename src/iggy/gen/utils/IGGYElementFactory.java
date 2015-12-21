package iggy.gen.utils;

import com.intellij.lang.ASTNode;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFileFactory;
import com.intellij.psi.util.PsiTreeUtil;
import iggy.gen.lang.IGGYFile;
import iggy.gen.lang.IGGYFileType;
import iggy.gen.psi.IRule;
import iggy.gen.psi.impl.DefinitionImpl;

/**
 * Created by Anastasia Izmaylova on 29/11/15.
 */
public class IGGYElementFactory {

    public static ASTNode createNontName(Project project, String name) {
        IGGYFile file = createFile(project, name + "::=");
        DefinitionImpl definition = PsiTreeUtil.getChildOfType(file, DefinitionImpl.class);
        IRule rule = definition.getRuleList().get(0);
        PsiElement nont = rule.getNontName$Declaration().getFirstChild();
        return nont.getNode();
    }

    public static ASTNode createVarName(Project project, String name) {
        return null;
    }

    public static IGGYFile createFile(Project project, String text) {
        return (IGGYFile) PsiFileFactory.getInstance(project).createFileFromText("dummy.iggy", IGGYFileType.instance, text);
    }
}

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
import iggy.gen.psi.IRegexRule;
import iggy.gen.psi.IRule;
import iggy.gen.psi.impl.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Anastasia Izmaylova on 08/10/15.
 */

public class IGGYUtil {

    public static PsiElement findNontName(Project project, PsiElement element) {
        IGGYFile file = (IGGYFile) element.getContainingFile();
        if (file != null) {
            DefinitionImpl definition = PsiTreeUtil.getChildOfType(file, DefinitionImpl.class);
            List<IRule> elements = definition.getRuleList();
            for (IRule elem : elements) {
                if (elem instanceof RuleSyntaxImpl) {
                    INontName$Declaration decl = elem.getNontName$Declaration();
                    if (decl.getText().equals(element.getText()))
                        return decl;
                } else if (elem instanceof RuleImpl) {
                    IRegexRule rule = elem.getRegexRule();
                    if (rule == null) {
                        List<IRegexRule> elems = elem.getRegexRuleList();
                        for (IRegexRule e : elems) {
                            INontName$Declaration decl = e.getNontName$Declaration();
                            if (decl.getText().equals(element.getText()))
                                return decl;
                        }
                    } else {
                        INontName$Declaration decl = rule.getNontName$Declaration();
                        if (decl.getText().equals(element.getText()))
                            return decl;
                    }
                }
            }
        }
        return null;
    }

    public static String[] findNontNames(Project project, PsiElement element) {
        IGGYFile file = (IGGYFile) element.getContainingFile();
        List<String> names = new ArrayList<>();
        if (file != null) {
            DefinitionImpl definition = PsiTreeUtil.getChildOfType(file, DefinitionImpl.class);
            List<IRule> elements = definition.getRuleList();
            for (IRule elem : elements) {
                if (elem instanceof RuleSyntaxImpl) {
                    INontName$Declaration decl = elem.getNontName$Declaration();
                    names.add(decl.getText());
                } else if (elem instanceof RuleImpl) {
                    IRegexRule rule = elem.getRegexRule();
                    if (rule == null) {
                        List<IRegexRule> elems = elem.getRegexRuleList();
                        for (IRegexRule e : elems) {
                            INontName$Declaration decl = e.getNontName$Declaration();
                            names.add(decl.getText());
                        }
                    } else {
                        INontName$Declaration decl = rule.getNontName$Declaration();
                        names.add(decl.getText());
                    }
                }
            }
        }
        return names.stream().toArray(String[]::new);
    }

    public static PsiElement findVarName(Project project, PsiElement element) {
        return null;
    }
}

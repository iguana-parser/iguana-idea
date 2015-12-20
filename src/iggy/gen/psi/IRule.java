package iggy.gen.psi;

/* This file has been generated. */

import com.intellij.psi.PsiElement;
import java.util.List;

public interface IRule extends PsiElement {
    IRegexRule getRegexRule();
    List<IRegexRule> getRegexRuleList();
    INontName$Declaration getNontName$Declaration();
    List<List<PsiElement>> getAllElementList();
    IBody getBody();
}

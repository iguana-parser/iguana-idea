package iggy.gen.psi;

/* This file has been generated. */

import com.intellij.psi.PsiElement;
import java.util.List;

public interface IEbnfElement extends PsiElement {
    public List<PsiElement> getElements();
    public <T extends PsiElement> List<T> getElements(Class<T> type);
}

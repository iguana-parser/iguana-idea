package iggy.gen.psi;

/* This file has been generated. */

import com.intellij.psi.PsiElement;
import java.util.List;

public interface ISymbol extends PsiElement {
    public IArguments getArguments();
    public List<PsiElement> getExpressionList();
    public ITerminal getTerminal();
    public List<PsiElement> getBindingList();
}

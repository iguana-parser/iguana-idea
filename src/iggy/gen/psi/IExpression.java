package iggy.gen.psi;

/* This file has been generated. */

import com.intellij.psi.PsiElement;
import java.util.List;

public interface IExpression extends PsiElement {
    IVarName$Reference getVarName$Reference();
    IExpression getExpression();
    List<IExpression> getAllExpression();
    IArguments getArguments();
}

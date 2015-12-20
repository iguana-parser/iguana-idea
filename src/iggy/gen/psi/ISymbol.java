package iggy.gen.psi;

/* This file has been generated. */

import com.intellij.psi.PsiElement;
import java.util.List;

public interface ISymbol extends PsiElement {
    ISymbol getSymbol();
    List<ISymbol> getAllSymbol();
    ILabel getLabel();
    INontName$Reference getNontName$Reference();
    IRegex getRegex();
    List<PsiElement> getExpressionList();
    IVarName$Declaration getVarName$Declaration();
    List<PsiElement> getBindingList();
    IExpression getExpression();
    ISymbols getSymbols();
    List<PsiElement> getSymbolsList();
    List<PsiElement> getSymbolList();
    IArguments getArguments();
}

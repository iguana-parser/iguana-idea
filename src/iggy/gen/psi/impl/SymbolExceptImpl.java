package iggy.gen.psi.impl;

/* This file has been generated. */

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;



import java.util.List;
import java.util.ArrayList;

import iggy.gen.psi.*;

public class SymbolExceptImpl extends ASTWrapperPsiElement implements ISymbol {

    public SymbolExceptImpl(ASTNode node) { super(node); }

    public void accept(PsiElementVisitor visitor) { super.accept(visitor); }

    public ISymbol getSymbol() { return findNotNullChildByClass(ISymbol.class); }
    public List<ISymbol> getAllSymbol() { return null; }
    public ILabel getLabel() { return findNotNullChildByClass(ILabel.class); }
    public INontName$Reference getNontName$Reference() { return null; }
    public IRegex getRegex() { return null; }
    public List<PsiElement> getExpressionList() { return null; }
    public IVarName$Declaration getVarName$Declaration() { return null; }
    public List<PsiElement> getBindingList() { return null; }
    public IExpression getExpression() { return null; }
    public ISymbols getSymbols() { return null; }
    public List<PsiElement> getSymbolsList() { return null; }
    public List<PsiElement> getSymbolList() { return null; }
    public IArguments getArguments() { return null; }
}

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

public class ExpressionFunCallImpl extends ASTWrapperPsiElement implements IExpression {

    public ExpressionFunCallImpl(ASTNode node) { super(node); }

    public void accept(PsiElementVisitor visitor) { super.accept(visitor); }

    public IExpression getExpression() { return findNotNullChildByClass(IExpression.class); }
    public List<IExpression> getExpressions() { return null; }
    public List<PsiElement> getExpressionList() { return findNotNullChildByClass(IEbnfElement.class).getElements(); }
}

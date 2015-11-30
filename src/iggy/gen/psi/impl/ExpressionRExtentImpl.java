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

public class ExpressionRExtentImpl extends ASTWrapperPsiElement implements IExpression {

    public ExpressionRExtentImpl(ASTNode node) { super(node); }

    public void accept(PsiElementVisitor visitor) { super.accept(visitor); }

    public IVarName$Reference getVarName$Reference() { return findNotNullChildByClass(IVarName$Reference.class); }
    public IExpression getExpression() { return null; }
    public List<IExpression> getAllExpression() { return null; }
    public IArguments getArguments() { return null; }
}

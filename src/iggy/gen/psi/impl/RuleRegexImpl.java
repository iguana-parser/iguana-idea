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

public class RuleRegexImpl extends ASTWrapperPsiElement implements IRule {

    public RuleRegexImpl(ASTNode node) { super(node); }

    public void accept(PsiElementVisitor visitor) { super.accept(visitor); }

    public List<PsiElement> getElementList() { return findNotNullChildByClass(IEbnfElement.class).getElements(); }
    public List<List<PsiElement>> getAllElementList() { return null; }
    public INontName$Declaration getNontName$Declaration() { return null; }
    public IBody getBody() { return null; }
}

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

public class RegexRuleRegexImpl extends ASTWrapperPsiElement implements IRegexRule {

    public RegexRuleRegexImpl(ASTNode node) { super(node); }

    public void accept(PsiElementVisitor visitor) { super.accept(visitor); }

    public INontName$Declaration getNontName$Declaration() { return findNotNullChildByClass(INontName$Declaration.class); }
    public IRegexBody getRegexBody() { return findNotNullChildByClass(IRegexBody.class); }
}

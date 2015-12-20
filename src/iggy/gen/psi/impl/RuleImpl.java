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

public class RuleImpl extends ASTWrapperPsiElement implements IRule {

    public RuleImpl(ASTNode node) { super(node); }

    public void accept(PsiElementVisitor visitor) { super.accept(visitor); }

    public IRegexRule getRegexRule() { return findChildByClass(IRegexRule.class); }
    public List<IRegexRule> getRegexRuleList() { return findNotNullChildByClass(IEbnfElement.class).getElements(IRegexRule.class); }
    public INontName$Declaration getNontName$Declaration() { return null; }
    public List<List<PsiElement>> getAllElementList() { return null; }
    public IBody getBody() { return null; }
}

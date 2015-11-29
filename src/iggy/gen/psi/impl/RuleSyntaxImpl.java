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

public class RuleSyntaxImpl extends ASTWrapperPsiElement implements IRule {

    public RuleSyntaxImpl(ASTNode node) { super(node); }

    public void accept(PsiElementVisitor visitor) { super.accept(visitor); }

    public INontName$Declaration getNontName$Declaration() { return findNotNullChildByClass(INontName$Declaration.class); }
    public List<List<PsiElement>> getAllElementList() {
        List<List<PsiElement>> result = new ArrayList<>();
        for (IEbnfElement e : PsiTreeUtil.getChildrenOfTypeAsList(this, IEbnfElement.class))
            result.add(e.getElements());
        return result;
    }
    public IBody getBody() { return findNotNullChildByClass(IBody.class); }
    public IRegexBody getRegexBody() { return null; }
}

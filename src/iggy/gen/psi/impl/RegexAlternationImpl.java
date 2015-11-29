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

public class RegexAlternationImpl extends ASTWrapperPsiElement implements IRegex {

    public RegexAlternationImpl(ASTNode node) { super(node); }

    public void accept(PsiElementVisitor visitor) { super.accept(visitor); }

    public IRegex getRegex() { return null; }
    public List<PsiElement> getRegexList() { return null; }
    public INontName$Reference getNontName$Reference() { return null; }
    public ICharClass getCharClass() { return null; }
    public IRegexs getRegexs() { return findNotNullChildByClass(IRegexs.class); }
    public List<PsiElement> getRegexsList() { return findNotNullChildByClass(IEbnfElement.class).getElements(); }
}

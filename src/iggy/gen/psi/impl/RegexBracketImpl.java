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

public class RegexBracketImpl extends ASTWrapperPsiElement implements IRegex {

    public RegexBracketImpl(ASTNode node) { super(node); }

    public void accept(PsiElementVisitor visitor) { super.accept(visitor); }

    public IRegex getRegex() { return findNotNullChildByClass(IRegex.class); }
    public List<PsiElement> getRegexList() { return null; }
    public INontName$Reference getNontName$Reference() { return null; }
    public ICharClass getCharClass() { return null; }
    public IRegexs getRegexs() { return null; }
    public List<PsiElement> getRegexsList() { return null; }
}

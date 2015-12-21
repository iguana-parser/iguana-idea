package iggy.gen.psi.impl;

/* This file has been generated. */

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiReference;
import com.intellij.psi.util.PsiTreeUtil;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;

import com.intellij.util.IncorrectOperationException;

import iggy.gen.lang.IGGYFile;
import iggy.gen.lang.IGGYLang;
import iggy.gen.utils.IGGYElementFactory;
import iggy.gen.utils.IGGYUtil;

import java.util.List;
import java.util.ArrayList;

import iggy.gen.psi.*;

public class NontName$ReferenceImpl extends ASTWrapperPsiElement implements INontName$Reference {

    public NontName$ReferenceImpl(ASTNode node) {
        super(node);
    }

    public void accept(PsiElementVisitor visitor) { super.accept(visitor); }

    public INontName getNontName() { return findNotNullChildByClass(INontName.class); }

    public PsiReference[] getReferences() { return new PsiReference[] {this}; }

    public PsiReference getReference() { return this; }

    public PsiElement getElement() { return this; }

    public TextRange getRangeInElement() { return new TextRange(0, getTextLength()); }

    public PsiElement resolve() {
        PsiElement element = IGGYUtil.findNontName(getProject(), this);
        return element;
    }

    public String getCanonicalText() { return this.getText(); }

    public PsiElement handleElementRename(String name) throws IncorrectOperationException {
        ASTNode node = IGGYElementFactory.createNontName(getProject(), name);
        ASTNode child = getNode().getFirstChildNode();
        getNode().replaceChild(child, node);
        return this;
    }

    public PsiElement bindToElement(PsiElement element) throws IncorrectOperationException { return null; }

    public boolean isReferenceTo(PsiElement element) {
        return element instanceof NontName$DeclarationImpl
                 && element.getTextLength() == this.getTextLength()
                 && element.getText().equals(this.getText());
    }

    public Object[] getVariants() {
        return IGGYUtil.findNontNames(getProject(), this).stream()
                .map(v -> LookupElementBuilder.create(v)
                        .withIcon(IGGYLang.file)).toArray(LookupElement[]::new);
    }

    public boolean isSoft() { return false; }
}

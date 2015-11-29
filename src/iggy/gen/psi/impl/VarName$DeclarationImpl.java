package iggy.gen.psi.impl;

/* This file has been generated. */

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;

import com.intellij.util.IncorrectOperationException;

import iggy.gen.utils.IGGYElementFactory;

import java.util.List;
import java.util.ArrayList;

import iggy.gen.psi.*;

public class VarName$DeclarationImpl extends ASTWrapperPsiElement implements IVarName$Declaration {

    public VarName$DeclarationImpl(ASTNode node) { super(node); }

    public void accept(PsiElementVisitor visitor) { super.accept(visitor); }

    public IVarName getVarName() { return findNotNullChildByClass(IVarName.class); }

    public String getName() { return getNode().getText(); }

    public PsiElement setName(String name) throws IncorrectOperationException {
        ASTNode node = IGGYElementFactory.createVarName(getProject(), name);
        ASTNode child = getNode().getFirstChildNode();
        getNode().replaceChild(child, node);
        return this;
    }
}

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

public class Start_DefinitionStartImpl extends ASTWrapperPsiElement implements IStart_Definition {

    public Start_DefinitionStartImpl(ASTNode node) { super(node); }

    public void accept(PsiElementVisitor visitor) { super.accept(visitor); }

    public List<ILayout> getAllLayout() { return PsiTreeUtil.getChildrenOfTypeAsList(this, ILayout.class); }
    public IDefinition getDefinition() { return findNotNullChildByClass(IDefinition.class); }
}

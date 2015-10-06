package iggy.gen.psi.impl;

/* This file has been generated. */

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;

import java.util.List;
import java.util.ArrayList;
import iggy.gen.psi.IEbnfElement;

public class EbnfElementImpl extends ASTWrapperPsiElement implements IEbnfElement {

    public EbnfElementImpl(ASTNode node) { super(node); }

    public void accept(PsiElementVisitor visitor) { super.accept(visitor); }

    public List<PsiElement> getElements() {
        List<PsiElement> flattened = new ArrayList<>();
        for (PsiElement e : PsiTreeUtil.getChildrenOfTypeAsList(this, PsiElement.class)) {
            if (e instanceof IEbnfElement) 
                flattened.addAll(((IEbnfElement) e).getElements());
            else 
                flattened.add(e);
        }
        return flattened;
    }
}

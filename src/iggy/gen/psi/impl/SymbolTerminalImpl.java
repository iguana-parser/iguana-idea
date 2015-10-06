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

public class SymbolTerminalImpl extends ASTWrapperPsiElement implements ISymbol {

    public SymbolTerminalImpl(ASTNode node) { super(node); }

    public void accept(PsiElementVisitor visitor) { super.accept(visitor); }

    public IArguments getArguments() { return null; }
    public List<PsiElement> getExpressionList() { return null; }
    public ITerminal getTerminal() { return findNotNullChildByClass(ITerminal.class); }
    public List<PsiElement> getBindingList() { return null; }
}

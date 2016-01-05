package iggy.gen.editor;

import com.intellij.lang.annotation.Annotation;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import com.intellij.psi.impl.source.tree.java.PsiLocalVariableImpl;
import iggy.gen.lang.IGGYFile;
import iggy.gen.psi.IGGYTokenTypes;
import iggy.gen.psi.INontName$Declaration;
import iggy.gen.psi.impl.AAttributeAssocImpl;
import iggy.gen.psi.impl.NontName$ReferenceImpl;
import iggy.gen.utils.IGGYElementFactory;


/**
 * Created by Anastasia Izmaylova on 23/12/15.
 */
public class JavaIGGYAnnotator implements Annotator {
    @Override
    public void annotate(PsiElement element, AnnotationHolder holder) {
        if (element instanceof PsiLiteralExpression && hasIGGYAnnotation(element)) {
            String value = (String) ((PsiLiteralExpression) element).getValue();
            if (value != null) {
                IGGYFile file = IGGYElementFactory.createFile(element.getProject(), value);
                if (file != null)
                    file.accept(new Visitor(holder, element.getTextRange().getStartOffset() + 1));
            }
        }
    }

    public static boolean hasIGGYAnnotation(PsiElement element) {
        PsiElement context = element.getParent();
        while (!(context instanceof PsiLocalVariableImpl))
            context = context.getParent();
        if (context instanceof PsiLocalVariableImpl) {
            PsiModifierList modifiers = ((PsiLocalVariableImpl) context).getModifierList();
            if (modifiers != null) {
                PsiAnnotation[] annotations = modifiers.getAnnotations();
                if (annotations != null && annotations.length == 1 && annotations[0].getText().equals("@IGGY"))
                    return true;
            }
        }
        return false;
    }

    public static class Visitor extends PsiElementVisitor {

        final AnnotationHolder holder;
        final int offset;

        Visitor(AnnotationHolder holder, int offset) { this.holder = holder; this.offset = offset; }

        @Override
        public void visitElement(PsiElement element) {
            if (element instanceof INontName$Declaration) {
                int start = element.getTextRange().getStartOffset() + offset;
                int end = element.getTextRange().getEndOffset() + offset;
                Annotation annotation = holder.createInfoAnnotation(new TextRange(start, end), null);
                annotation.setTextAttributes(TextAttributesKey.createTextAttributesKey("NONTNAME_RESOLVED_NAME_IN_STRING_LITERAL",
                        HighlighterColors.TEXT));
            } else if (element instanceof NontName$ReferenceImpl) {
                int start = element.getTextRange().getStartOffset() + offset;
                int end = element.getTextRange().getEndOffset() + offset;
                if (((NontName$ReferenceImpl) element).resolve() != null) {
                    Annotation annotation = holder.createInfoAnnotation(new TextRange(start, end), null);
                    annotation.setTextAttributes(TextAttributesKey.createTextAttributesKey("NONTNAME_RESOLVED_NAME_IN_STRING_LITERAL",
                            HighlighterColors.TEXT));
                } else {
                    Annotation annotation = holder.createErrorAnnotation(new TextRange(start, end), "Unresolved nonterminal name.");
                    annotation.setTextAttributes(TextAttributesKey.createTextAttributesKey("NONTNAME_UNRESOLVED_NAME_IN_STRING_LITERAL",
                            HighlighterColors.TEXT));
                }
            } else if (element instanceof AAttributeAssocImpl) {
                int start = element.getTextRange().getStartOffset() + offset;
                int end = element.getTextRange().getEndOffset() + offset;
                Annotation annotation = holder.createInfoAnnotation(new TextRange(start, end), null);
                annotation.setTextAttributes(TextAttributesKey.createTextAttributesKey("KEYWORD_IN_STRING_LITERAL", HighlighterColors.TEXT));
            } else if (element instanceof PsiErrorElement) {
                int start = element.getTextRange().getStartOffset() + offset;
                int end = element.getTextRange().getEndOffset() + offset;
                holder.createErrorAnnotation(new TextRange(start, end), "Parse error.");
            }

            for (PsiElement child : element.getChildren()) // Only children of type CompositeElement
                child.accept(this);
        }
    }
}


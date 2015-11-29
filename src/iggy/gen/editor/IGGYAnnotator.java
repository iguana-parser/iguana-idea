package iggy.gen.editor;

import com.intellij.lang.annotation.Annotation;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import iggy.gen.psi.impl.*;

/**
 * Created by Anastasia Izmaylova on 08/10/15.
 */

public class IGGYAnnotator implements Annotator {
    @Override
    public void annotate(PsiElement element, AnnotationHolder holder) {
        if (element instanceof NontName$DeclarationImpl || element instanceof VarName$DeclarationImpl) {
            Annotation annotation = holder.createInfoAnnotation(element.getTextRange(), null);
            if (element instanceof  NontName$DeclarationImpl)
                annotation.setTextAttributes(TextAttributesKey.createTextAttributesKey("NONTNAME_RESOLVED_NAME", HighlighterColors.TEXT));
            else
                annotation.setTextAttributes(TextAttributesKey.createTextAttributesKey("VARNAME_RESOLVED_NAME", HighlighterColors.TEXT));
        }

        if (element instanceof NontName$ReferenceImpl || element instanceof VarName$ReferenceImpl) {

            if (element instanceof  NontName$ReferenceImpl) {
                if (((NontName$ReferenceImpl) element).resolve() != null) {
                    Annotation annotation = holder.createInfoAnnotation(element.getTextRange(), null);
                    annotation.setTextAttributes(TextAttributesKey.createTextAttributesKey("NONTNAME_RESOLVED_NAME", HighlighterColors.TEXT));
                } else {
                    Annotation annotation = holder.createErrorAnnotation(element.getTextRange(), "Unresolved nonterminal name.");
                    annotation.setTextAttributes(TextAttributesKey.createTextAttributesKey("NONTNAME_UNRESOLVED_NAME", HighlighterColors.TEXT));
                }
            } else {
                Annotation annotation = holder.createErrorAnnotation(element.getTextRange(), "Unresolved variable name.");
                annotation.setTextAttributes(TextAttributesKey.createTextAttributesKey("VARNAME_UNRESOLVED_NAME", HighlighterColors.TEXT));
            }
        }
    }
}

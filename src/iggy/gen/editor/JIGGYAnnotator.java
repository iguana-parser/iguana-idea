package iggy.gen.editor;

import com.intellij.lang.annotation.Annotation;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiErrorElement;
import com.intellij.psi.PsiLiteralExpression;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import iggy.gen.lang.IGGYFile;
import iggy.gen.psi.IGGYTokenTypes;
import iggy.gen.psi.INontName$Declaration;
import iggy.gen.psi.IRegexRule;
import iggy.gen.psi.IRule;
import iggy.gen.psi.impl.DefinitionImpl;
import iggy.gen.psi.impl.NontName$ReferenceImpl;
import iggy.gen.psi.impl.RuleImpl;
import iggy.gen.psi.impl.RuleSyntaxImpl;
import iggy.gen.utils.IGGYElementFactory;
import org.jetbrains.plugins.scala.lang.lexer.ScalaTokenTypes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anastasiaizmaylova on 23/12/15.
 */
public class JIGGYAnnotator implements Annotator {
    @Override
    public void annotate(PsiElement element, AnnotationHolder holder) {
        // element instanceof LeafPsiElement && element.getType() == ScalaTokenTypes.tSTRING
        if (element instanceof PsiLiteralExpression) {
            String value = (String) ((PsiLiteralExpression) element).getValue();
            int offset = 5;
            if (value != null && value.startsWith("IGGY:")) {
                Project project = element.getProject();
                IGGYFile file = IGGYElementFactory.createFile(project, value.substring(offset));
                if (file != null)
                    file.accept(new Visitor(holder, element.getTextRange().getStartOffset() + offset));
            }
        }

    }

    private static class Visitor extends PsiElementVisitor {

        final AnnotationHolder holder;
        final int offset;

        Visitor(AnnotationHolder holder, int offset) { this.holder = holder; this.offset = offset + 1; }

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
            } else if (element instanceof LeafPsiElement) {
                int start = element.getTextRange().getStartOffset() + offset;
                int end = element.getTextRange().getEndOffset() + offset;
                if (((LeafPsiElement) element).getElementType() == IGGYTokenTypes.KEYWORD) {
                    Annotation annotation = holder.createInfoAnnotation(new TextRange(start, end), null);
                    annotation.setTextAttributes(TextAttributesKey.createTextAttributesKey("KEYWORD", HighlighterColors.TEXT));
                }
            } else if (element instanceof PsiErrorElement) {
                int start = element.getTextRange().getStartOffset() + offset;
                int end = element.getTextRange().getEndOffset() + offset;
                holder.createErrorAnnotation(new TextRange(start, end), "Parse error.");
            }

            for (PsiElement child : element.getChildren())
                child.accept(this);
        }
    }
}


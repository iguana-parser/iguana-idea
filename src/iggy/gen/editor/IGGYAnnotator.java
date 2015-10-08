package iggy.gen.editor;

import com.intellij.lang.annotation.Annotation;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import iggy.gen.psi.ISymbol;
import iggy.gen.psi.impl.NontNameImpl;
import iggy.gen.utils.IGGYUtil;

/**
 * Created by Anastasia Izmaylova on 08/10/15.
 */

public class IGGYAnnotator implements Annotator {
    @Override
    public void annotate(PsiElement element, AnnotationHolder holder) {
        if (element instanceof NontNameImpl && element.getParent() instanceof ISymbol) {
            String ntName = ((NontNameImpl) element).getText();
            Project project = element.getProject();
            TextRange range = new TextRange(element.getTextRange().getStartOffset(), element.getTextRange().getEndOffset());
            if (!IGGYUtil.findNontName(project, ntName)) {
                Annotation annotation = holder.createErrorAnnotation(range, "Unresolved nonterminal name");
                annotation.setTextAttributes(DefaultLanguageHighlighterColors.LINE_COMMENT);
            }
        }
    }
}

package iggy.gen.editor;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.psi.PsiAnnotation;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import iggy.gen.lang.IGGYFile;
import iggy.gen.utils.IGGYElementFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.plugins.scala.lang.lexer.ScalaTokenTypes;
import org.jetbrains.plugins.scala.lang.psi.impl.statements.ScPatternDefinitionImpl;
import scala.collection.mutable.StringBuilder;

/**
 * Created by Anastasia Izmaylova on 04/01/16.
 */
public class ScalaIGGYAnnotator implements Annotator {
    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        IElementType type = element.getNode().getElementType();
        if (type == ScalaTokenTypes.tSTRING || type == ScalaTokenTypes.tMULTILINE_STRING) {
            if (hasIGGYAnnotation(element)) {
                if (type == ScalaTokenTypes.tSTRING) {
                    String text = element.getText().substring(1, element.getText().length() - 1);
                    IGGYFile file = IGGYElementFactory.createFile(element.getProject(), text);
                    if (file != null)
                        file.accept(new JavaIGGYAnnotator.Visitor(holder, element.getTextRange().getStartOffset() + 1));
                } else {
                    String text = strip(3, element.getText().length() - 3, element.getText());
                    IGGYFile file = IGGYElementFactory.createFile(element.getProject(), text);
                    if (file != null)
                        file.accept(new JavaIGGYAnnotator.Visitor(holder, element.getTextRange().getStartOffset() + 3));
                }
            }
        }
    }

    public static boolean hasIGGYAnnotation(PsiElement element) {
        PsiElement context = element.getParent();
        while (!(context instanceof ScPatternDefinitionImpl))
            context = context.getParent();
        if (context instanceof ScPatternDefinitionImpl) {
            PsiAnnotation[] annotations = ((ScPatternDefinitionImpl) context).getAnnotations();
            if (annotations != null && annotations.length == 1 && annotations[0].getText().equals("@IGGY"))
                return true;
        }
        return false;
    }

    public static String strip(int start, int end, String text) {
        char[] chars = text.toCharArray();
        StringBuilder b = new StringBuilder();
        int i = start;
        while (i < end) {
            b.append(chars[i]);
            if (chars[i] == '\n' || chars[i] == '\r') {
                i++;
                if (i == end) break;
                while (i < end && chars[i] == ' ') {
                    b.append(chars[i]);
                    i++;
                }
                if (i == end) break;
                if (chars[i] == '|')
                    b.append(' ');
                else
                    b.append(chars[i]);
            }
            i++;
        }
        return b.toString();
    }
}

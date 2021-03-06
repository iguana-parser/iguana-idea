package iggy.gen.editor;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.util.ProcessingContext;
import iggy.gen.lang.IGGYFile;
import iggy.gen.psi.impl.NontName$ReferenceImpl;
import iggy.gen.utils.IGGYElementFactory;
import iggy.gen.utils.IGGYUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.plugins.scala.ScalaLanguage;
import org.jetbrains.plugins.scala.lang.lexer.ScalaTokenTypes;

import static iggy.gen.editor.ScalaIGGYAnnotator.hasIGGYAnnotation;
import static iggy.gen.editor.ScalaIGGYAnnotator.strip;

import java.util.List;

/**
 * Created by Anastasia Izmaylova on 03/01/16.
 */
public class ScalaIGGYCompletionContributor extends CompletionContributor {
    public ScalaIGGYCompletionContributor() {
        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement(ScalaTokenTypes.tSTRING)
                        .withLanguage(ScalaLanguage.Instance),
                new CompletionProvider<CompletionParameters>() {
                    @Override
                    protected void addCompletions(@NotNull CompletionParameters completionParameters, ProcessingContext
                            processingContext, @NotNull CompletionResultSet completionResultSet) {
                        PsiElement element = completionParameters.getOriginalPosition();
                        if (hasIGGYAnnotation(element)) {
                            String text = element.getText().substring(1, element.getText().length() - 1);
                            int pos = completionParameters.getOffset() - (element.getTextRange().getStartOffset() + 1);
                            addCompletionElements(element.getProject(), text, pos, completionResultSet);
                        }
                    }
                });
        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement(ScalaTokenTypes.tMULTILINE_STRING)
                        .withLanguage(ScalaLanguage.Instance),
                new CompletionProvider<CompletionParameters>() {
                    @Override
                    protected void addCompletions(@NotNull CompletionParameters completionParameters, ProcessingContext
                            processingContext, @NotNull CompletionResultSet completionResultSet) {
                        PsiElement element = completionParameters.getOriginalPosition();
                        if (hasIGGYAnnotation(element)) {
                            String text = strip(3, element.getText().length() - 3, element.getText());
                            int pos = completionParameters.getOffset() - (element.getTextRange().getStartOffset() + 3);
                            addCompletionElements(element.getProject(), text, pos, completionResultSet);
                        }
                    }
                });
    }

    public static void addCompletionElements(Project project, String text, int pos, CompletionResultSet resultSet) {
        assert pos >=0 && pos < text.length();
        if (text.isEmpty()) return;
        IGGYFile file = IGGYElementFactory.createFile(project, text);
        if (file != null) {
            Visitor visitor = new Visitor(pos);
            file.accept(visitor);
            CompletionResultSet results = resultSet.withPrefixMatcher(visitor.prefix);
            for (Object variant : visitor.variants)
                results.addElement((LookupElement) variant);
            if (visitor.prefix.isEmpty() && visitor.variants.length == 0) {
                List<String> names = IGGYUtil.findNontNames(project, file);
                names.forEach(name -> results.addElement(LookupElementBuilder.create(name)));
            }
            results.addElement(LookupElementBuilder.create("left"));
            results.addElement(LookupElementBuilder.create("right"));
            results.addElement(LookupElementBuilder.create("non-assoc"));
            results.addElement(LookupElementBuilder.create("var"));
        }
    }

    private static class Visitor extends PsiElementVisitor {

        private int pos = 0;
        public String prefix = "";
        public Object[] variants = new LookupElement[0];

        public Visitor(int pos) {
            if (pos > 0) this.pos = pos;
        }

        @Override
        public void visitElement(PsiElement element) {
            if (pos < element.getTextRange().getStartOffset() || element.getTextRange().getEndOffset() < pos)
                return;
            if (element instanceof NontName$ReferenceImpl) {
                    prefix = element.getText().substring(0, pos - element.getTextRange().getStartOffset());
                    variants = ((NontName$ReferenceImpl) element).getVariants();
            }
            for (PsiElement child : element.getChildren())
                child.accept(this);
        }
    }

}

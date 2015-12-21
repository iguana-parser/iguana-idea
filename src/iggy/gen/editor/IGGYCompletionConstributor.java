package iggy.gen.editor;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import iggy.gen.lang.IGGYLang;
import iggy.gen.psi.IGGYElementTypes;
import iggy.gen.psi.IGGYTokenType;
import iggy.gen.psi.IGGYTokenTypes;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Anastasia Izmaylova on 20/12/15.
 */
public class IGGYCompletionConstributor extends CompletionContributor {

    public IGGYCompletionConstributor() {
        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement(IGGYTokenTypes.TERMINAL)
                        .withLanguage(IGGYLang.instance),
                new CompletionProvider<CompletionParameters>() {
                    @Override
                    protected void addCompletions(@NotNull CompletionParameters completionParameters, ProcessingContext processingContext, @NotNull CompletionResultSet completionResultSet) {
                        completionResultSet.addElement(LookupElementBuilder.create("left"));
                        completionResultSet.addElement(LookupElementBuilder.create("right"));
                        completionResultSet.addElement(LookupElementBuilder.create("non-assoc"));
                        completionResultSet.addElement(LookupElementBuilder.create("var"));
                    }
                });
    }

    @Override
    public void fillCompletionVariants(@NotNull CompletionParameters parameters, @NotNull CompletionResultSet result) {
        super.fillCompletionVariants(parameters, result);
    }
}

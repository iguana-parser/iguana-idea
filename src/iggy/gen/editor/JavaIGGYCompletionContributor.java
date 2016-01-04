package iggy.gen.editor;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.lang.java.JavaLanguage;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.JavaTokenType;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.util.ProcessingContext;
import iggy.gen.lang.IGGYFile;
import iggy.gen.lang.IGGYLang;
import iggy.gen.utils.IGGYElementFactory;
import iggy.gen.utils.IGGYUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.plugins.scala.ScalaLanguage;
import org.jetbrains.plugins.scala.lang.lexer.ScalaTokenTypes;

import java.util.List;

/**
 * Created by Anastasia Izmaylova on 24/12/15.
 */
public class JavaIGGYCompletionContributor extends CompletionContributor {
    public JavaIGGYCompletionContributor() {
        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement(JavaTokenType.STRING_LITERAL)
                        .withLanguage(JavaLanguage.INSTANCE),
                new CompletionProvider<CompletionParameters>() {
                    @Override
                    protected void addCompletions(@NotNull CompletionParameters completionParameters, ProcessingContext
                            processingContext, @NotNull CompletionResultSet completionResultSet) {
                        int position = completionParameters.getOffset();
                        CompletionResultSet resultSet = completionResultSet.withPrefixMatcher("");
                        PsiElement element = completionParameters.getOriginalPosition();
                        if (element.getText().startsWith("\"IGGY:")) {
                            IGGYFile file = IGGYElementFactory.createFile(element.getProject(), element.getText().substring(6, element.getText().length() - 1));
                            if (file != null) {
                                List<String> names = IGGYUtil.findNontNames(element.getProject(), file);
                                names.forEach(name -> {
                                    resultSet.addElement(LookupElementBuilder.create(name));
                                    resultSet.addElement(LookupElementBuilder.create("left"));
                                    resultSet.addElement(LookupElementBuilder.create("right"));
                                    resultSet.addElement(LookupElementBuilder.create("non-assoc"));
                                    resultSet.addElement(LookupElementBuilder.create("var"));
                                });
                            }
                        }
                    }
                });
    }

}

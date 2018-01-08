package com.linsir;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiPlainText;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GitCommitEmojiEngine extends CompletionContributor {


    public GitCommitEmojiEngine() throws IOException {

        HashMap<String, String> data = DataProcess.getData();

        extend(CompletionType.BASIC, PlatformPatterns.psiElement(PsiPlainText.class), new CompletionProvider<CompletionParameters>() {
            @Override
            protected void addCompletions(@NotNull CompletionParameters completionParameters, ProcessingContext processingContext, @NotNull CompletionResultSet completionResultSet) {

                if (completionParameters.getEditor().isOneLineMode()) {
                    return;
                }

                String message = completionParameters.getEditor().getDocument().getCharsSequence().toString();

                List<LookupElement> result = new LinkedList<LookupElement>();
                for (String key : data.keySet()) {
                    if (key.contains(message)) {
                        result.add(LookupElementBuilder.create(data.get(key) + " " + key + ":"));
                        completionResultSet.addElement(LookupElementBuilder.create(data.get(key) + " " + key + ":"));
                    }

                }

            }
        });


    }


}

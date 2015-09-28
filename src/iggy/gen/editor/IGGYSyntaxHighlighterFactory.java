package iggy.gen.editor;

/** This file has been generated. */

import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;

public class IGGYSyntaxHighlighterFactory extends SyntaxHighlighterFactory {
    public SyntaxHighlighter getSyntaxHighlighter(Project project, VirtualFile virtualFile) { return new IGGYSyntaxHighlighter(); }
}


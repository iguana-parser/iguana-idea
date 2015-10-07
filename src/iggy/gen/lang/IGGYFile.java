package iggy.gen.lang;

/* This file has been generated. */

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import javax.swing.Icon;

public class IGGYFile extends PsiFileBase {
    public IGGYFile(FileViewProvider viewProvider) { super(viewProvider, IGGYLang.instance); }
    public FileType getFileType() { return IGGYFileType.instance; }
    public String toString() { return "IGGY file"; }
    public Icon getIcon(int flags) { return super.getIcon(flags); }
}

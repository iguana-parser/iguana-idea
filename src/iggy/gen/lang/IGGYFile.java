package iggy.gen.lang;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Created by Anastasia Izmaylova on 05/10/15.
 */

public class IGGYFile extends PsiFileBase {

    public IGGYFile(FileViewProvider viewProvider) {
        super(viewProvider, IGGYLang.instance);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return IGGYFileType.instance;
    }

    @Override
    public String toString() {
        return "IGGY file";
    }

    @Nullable
    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }
}

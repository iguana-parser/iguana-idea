package iggy.gen.lang;

/** This file has been generated. */

import com.intellij.openapi.fileTypes.LanguageFileType;
import javax.swing.*;

public class IGGYFileType extends LanguageFileType {
    public static final IGGYFileType instance = new IGGYFileType();
    private IGGYFileType() { super(IGGYLang.instance); }

    public String getName() { return "IGGY"; }
    public String getDescription() { return "IGGY"; }
    public String getDefaultExtension() { return "iggy"; }
    public Icon getIcon() { return IGGYLang.file; }
}


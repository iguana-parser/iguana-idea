package iggy.gen.lang;

/** This file has been generated. */

import com.intellij.lang.Language;
import com.intellij.openapi.util.IconLoader;
import javax.swing.*;

public class IGGYLang extends Language {
    public static final IGGYLang instance = new IGGYLang();
    public static final Icon file = IconLoader.getIcon("/iggy/gen/icons/iconnewnew.png");
    private IGGYLang() { super("IGGY"); }
}


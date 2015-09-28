package iggy.gen.lang;

/** This file has been generated. */

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;

public class IGGYFileTypeFactory extends FileTypeFactory {
    public void createFileTypes(FileTypeConsumer fileTypeConsumer) { fileTypeConsumer.consume(IGGYFileType.instance, "iggy"); }
}


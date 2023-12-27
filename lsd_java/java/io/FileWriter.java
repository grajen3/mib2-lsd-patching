/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class FileWriter
extends OutputStreamWriter {
    public FileWriter(File file) {
        super(new FileOutputStream(file));
    }

    public FileWriter(File file, boolean bl) {
        super(new FileOutputStream(file, bl));
    }

    public FileWriter(FileDescriptor fileDescriptor) {
        super(new FileOutputStream(fileDescriptor));
    }

    public FileWriter(String string) {
        super(new FileOutputStream(new File(string)));
    }

    public FileWriter(String string, boolean bl) {
        super(new FileOutputStream(string, bl));
    }
}


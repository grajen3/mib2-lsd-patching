/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FileReader
extends InputStreamReader {
    public FileReader(File file) {
        super(new FileInputStream(file));
    }

    public FileReader(FileDescriptor fileDescriptor) {
        super(new FileInputStream(fileDescriptor));
    }

    public FileReader(String string) {
        super(new FileInputStream(string));
    }
}


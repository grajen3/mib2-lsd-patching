/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import java.io.File;

public interface FileFilter {
    default public boolean accept(File file) {
    }
}


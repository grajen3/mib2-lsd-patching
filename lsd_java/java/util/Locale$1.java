/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.io.File;
import java.io.FilenameFilter;

final class Locale$1
implements FilenameFilter {
    private final /* synthetic */ String val$classPrefix;

    Locale$1(String string) {
        this.val$classPrefix = string;
    }

    @Override
    public boolean accept(File file, String string) {
        return string.startsWith(this.val$classPrefix);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package arc.launcher;

import java.io.File;
import java.io.FilenameFilter;

class BundleLoader$1
implements FilenameFilter {
    private final /* synthetic */ String[] val$extensions;

    BundleLoader$1(String[] stringArray) {
        this.val$extensions = stringArray;
    }

    @Override
    public boolean accept(File file, String string) {
        int n = 0;
        while (n < this.val$extensions.length) {
            if (string.toLowerCase().endsWith(this.val$extensions[n])) {
                return true;
            }
            ++n;
        }
        return false;
    }
}


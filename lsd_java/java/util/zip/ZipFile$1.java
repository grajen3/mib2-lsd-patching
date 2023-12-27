/*
 * Decompiled with CFR 0.152.
 */
package java.util.zip;

import java.io.File;
import java.security.PrivilegedAction;
import java.util.zip.ZipFile;

final class ZipFile$1
implements PrivilegedAction {
    final /* synthetic */ ZipFile this$0;

    ZipFile$1(ZipFile zipFile) {
        this.this$0 = zipFile;
    }

    @Override
    public Object run() {
        new File(ZipFile.access$1(this.this$0)).delete();
        return null;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import java.io.File;
import java.io.FilePermission;
import java.io.IOException;
import java.security.PrivilegedAction;

final class FilePermission$1
implements PrivilegedAction {
    final /* synthetic */ FilePermission this$0;
    private final /* synthetic */ String val$path;

    FilePermission$1(FilePermission filePermission, String string) {
        this.this$0 = filePermission;
        this.val$path = string;
    }

    @Override
    public Object run() {
        try {
            return new File(this.val$path).getCanonicalPath();
        }
        catch (IOException iOException) {
            return this.val$path;
        }
    }
}


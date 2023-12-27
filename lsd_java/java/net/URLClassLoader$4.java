/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import java.net.URLClassLoader;
import java.security.PrivilegedAction;

final class URLClassLoader$4
implements PrivilegedAction {
    final /* synthetic */ URLClassLoader this$0;
    private final /* synthetic */ String val$clsName;

    URLClassLoader$4(URLClassLoader uRLClassLoader, String string) {
        this.this$0 = uRLClassLoader;
        this.val$clsName = string;
    }

    @Override
    public Object run() {
        return this.this$0.findClassImpl(this.this$0.urls, this.val$clsName);
    }
}


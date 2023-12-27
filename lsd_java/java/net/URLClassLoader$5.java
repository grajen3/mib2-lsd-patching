/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import java.net.URLClassLoader;
import java.security.PrivilegedAction;

final class URLClassLoader$5
implements PrivilegedAction {
    final /* synthetic */ URLClassLoader this$0;
    private final /* synthetic */ String val$name;

    URLClassLoader$5(URLClassLoader uRLClassLoader, String string) {
        this.this$0 = uRLClassLoader;
        this.val$name = string;
    }

    @Override
    public Object run() {
        return this.this$0.findResourceImpl(this.this$0.urls, this.val$name);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import java.net.URLClassLoader;
import java.security.PrivilegedAction;
import java.util.Vector;

final class URLClassLoader$1
implements PrivilegedAction {
    final /* synthetic */ URLClassLoader this$0;
    private final /* synthetic */ String val$name;

    URLClassLoader$1(URLClassLoader uRLClassLoader, String string) {
        this.this$0 = uRLClassLoader;
        this.val$name = string;
    }

    @Override
    public Object run() {
        return this.this$0.findResources(this.this$0.urls, this.val$name, new Vector());
    }
}


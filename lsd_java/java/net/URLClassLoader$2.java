/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import java.net.URL;
import java.net.URLClassLoader$SubURLClassLoader;
import java.security.PrivilegedAction;

final class URLClassLoader$2
implements PrivilegedAction {
    private final /* synthetic */ URL[] val$urls;

    URLClassLoader$2(URL[] uRLArray) {
        this.val$urls = uRLArray;
    }

    @Override
    public Object run() {
        return new URLClassLoader$SubURLClassLoader(this.val$urls);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import java.net.URL;
import java.net.URLClassLoader$SubURLClassLoader;
import java.security.PrivilegedAction;

final class URLClassLoader$3
implements PrivilegedAction {
    private final /* synthetic */ URL[] val$urls;
    private final /* synthetic */ ClassLoader val$parentCl;

    URLClassLoader$3(URL[] uRLArray, ClassLoader classLoader) {
        this.val$urls = uRLArray;
        this.val$parentCl = classLoader;
    }

    @Override
    public Object run() {
        return new URLClassLoader$SubURLClassLoader(this.val$urls, this.val$parentCl);
    }
}


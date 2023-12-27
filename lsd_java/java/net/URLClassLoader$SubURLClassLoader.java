/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import java.net.URL;
import java.net.URLClassLoader;

class URLClassLoader$SubURLClassLoader
extends URLClassLoader {
    private boolean checkingPackageAccess = false;

    URLClassLoader$SubURLClassLoader(URL[] uRLArray) {
        super(uRLArray, ClassLoader.getSystemClassLoader());
    }

    URLClassLoader$SubURLClassLoader(URL[] uRLArray, ClassLoader classLoader) {
        super(uRLArray, classLoader);
    }

    @Override
    protected synchronized Class loadClass(String string, boolean bl) {
        int n;
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null && !this.checkingPackageAccess && (n = string.lastIndexOf(46)) > 0) {
            try {
                this.checkingPackageAccess = true;
                securityManager.checkPackageAccess(string.substring(0, n));
            }
            finally {
                this.checkingPackageAccess = false;
            }
        }
        return super.loadClass(string, bl);
    }
}


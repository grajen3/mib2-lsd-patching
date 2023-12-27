/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.vm;

import com.ibm.oti.vm.AbstractClassLoader;
import com.ibm.oti.vm.VM;
import java.util.Hashtable;

public class AppClassLoader
extends AbstractClassLoader {
    private boolean checkingPackageAccess = false;
    private static Hashtable protectionDomainCache = new Hashtable(10);

    public AppClassLoader() {
        this(null);
    }

    public AppClassLoader(ClassLoader classLoader) {
        super(classLoader);
        String string = System.getProperty("java.class.path", ".");
        string = this.parsePath(string);
        VM.setClassPathImpl((ClassLoader)this, string);
    }

    AppClassLoader(boolean bl) {
        super(null);
    }

    @Override
    protected Class findClass(String string) {
        Class clazz = VM.findClassOrNull(string, this);
        if (clazz == null) {
            throw new ClassNotFoundException(string);
        }
        int n = VM.getCPIndexImpl(clazz);
        String string2 = this.getPackageName(clazz);
        if (string2 != null) {
            this.definePackage(string2, n);
        }
        VM.setPDImpl(clazz, this.getFilePD(n));
        return clazz;
    }

    @Override
    Hashtable getProtectionDomainCache() {
        return protectionDomainCache;
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


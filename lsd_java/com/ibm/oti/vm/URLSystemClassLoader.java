/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.vm;

import java.net.URL;
import java.net.URLClassLoader;
import java.security.CodeSource;
import java.security.PermissionCollection;

public abstract class URLSystemClassLoader
extends URLClassLoader {
    private boolean checkingPackageAccess = false;
    private static final RuntimePermission permissionToExitVM = new RuntimePermission("exitVM");

    URLSystemClassLoader() {
        super((URL[])null);
    }

    URLSystemClassLoader(URL[] uRLArray, ClassLoader classLoader) {
        super(uRLArray, classLoader);
    }

    @Override
    public Class findClass(String string) {
        Class clazz = super.findClass(string);
        return clazz;
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

    abstract boolean addExitPermission() {
    }

    @Override
    protected PermissionCollection getPermissions(CodeSource codeSource) {
        PermissionCollection permissionCollection = super.getPermissions(codeSource);
        if (this.addExitPermission()) {
            permissionCollection.add(permissionToExitVM);
        }
        return permissionCollection;
    }
}


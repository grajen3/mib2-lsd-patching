/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import java.security.CodeSource;
import java.security.PermissionCollection;
import java.security.Permissions;
import java.security.ProtectionDomain;
import java.util.Hashtable;

public class SecureClassLoader
extends ClassLoader {
    private Hashtable domainForCodeSource = new Hashtable(10);

    protected SecureClassLoader() {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkCreateClassLoader();
        }
    }

    protected SecureClassLoader(ClassLoader classLoader) {
        super(classLoader);
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkCreateClassLoader();
        }
    }

    protected final Class defineClass(String string, byte[] byArray, int n, int n2, CodeSource codeSource) {
        ProtectionDomain protectionDomain = null;
        if (codeSource != null && (protectionDomain = (ProtectionDomain)this.domainForCodeSource.get(codeSource)) == null) {
            protectionDomain = new ProtectionDomain(codeSource, this.getPermissions(codeSource), this, null);
            this.domainForCodeSource.put(codeSource, protectionDomain);
        }
        return this.defineClass(string, byArray, n, n2, protectionDomain);
    }

    protected PermissionCollection getPermissions(CodeSource codeSource) {
        return new Permissions();
    }
}


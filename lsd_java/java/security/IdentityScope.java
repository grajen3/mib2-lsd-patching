/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import com.ibm.oti.util.PriviAction;
import java.security.AccessController;
import java.security.Identity;
import java.security.Principal;
import java.security.PublicKey;
import java.util.Enumeration;

public abstract class IdentityScope
extends Identity {
    private static final long serialVersionUID;
    static IdentityScope systemScope;

    protected IdentityScope() {
    }

    public IdentityScope(String string) {
        super(string);
    }

    public IdentityScope(String string, IdentityScope identityScope) {
        super(string, identityScope);
    }

    public abstract void addIdentity(Identity identity) {
    }

    public abstract void removeIdentity(Identity identity) {
    }

    public abstract Enumeration identities() {
    }

    public Identity getIdentity(Principal principal) {
        Enumeration enumeration = this.identities();
        while (enumeration.hasMoreElements()) {
            Identity identity = (Identity)enumeration.nextElement();
            if (!identity.getName().equals(principal.getName())) continue;
            return identity;
        }
        return null;
    }

    public abstract Identity getIdentity(PublicKey publicKey) {
    }

    public abstract Identity getIdentity(String string) {
    }

    protected static void setSystemScope(IdentityScope identityScope) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkSecurityAccess("setSystemScope");
        }
        systemScope = identityScope;
    }

    public abstract int size() {
    }

    @Override
    public String toString() {
        String string = new StringBuffer("Name : ").append(this.getName()).toString();
        if (this.getScope() != null) {
            string = new StringBuffer(String.valueOf(string)).append("\nScope name : ").append(this.getScope().getName()).toString();
        }
        string = new StringBuffer(String.valueOf(string)).append("\nNumber of identities : ").append(this.size()).toString();
        return string;
    }

    public static IdentityScope getSystemScope() {
        if (systemScope != null) {
            return systemScope;
        }
        String string = (String)AccessController.doPrivileged(PriviAction.getSecurityProperty("system.scope"));
        if (string != null) {
            try {
                Class clazz = Class.forName(string);
                systemScope = (IdentityScope)clazz.newInstance();
            }
            catch (ClassNotFoundException classNotFoundException) {
            }
            catch (IllegalAccessException illegalAccessException) {
            }
            catch (InstantiationException instantiationException) {}
        }
        return systemScope;
    }
}


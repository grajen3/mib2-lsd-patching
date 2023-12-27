/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import java.io.Serializable;
import java.security.Guard;
import java.security.PermissionCollection;

public abstract class Permission
implements Guard,
Serializable {
    private static final long serialVersionUID;
    private String name;

    public Permission(String string) {
        this.name = string;
    }

    public abstract boolean equals(Object object) {
    }

    public abstract int hashCode() {
    }

    @Override
    public void checkGuard(Object object) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(this);
        }
    }

    public abstract String getActions() {
    }

    public final String getName() {
        return this.name;
    }

    public abstract boolean implies(Permission permission) {
    }

    public PermissionCollection newPermissionCollection() {
        return null;
    }

    public String toString() {
        String string = this.getActions();
        return new StringBuffer("(").append(super.getClass().getName()).append(" ").append(this.getName()).append(" ").append(string).append(")").toString();
    }
}


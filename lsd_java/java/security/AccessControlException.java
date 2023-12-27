/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import java.security.Permission;

public class AccessControlException
extends SecurityException {
    private static final long serialVersionUID;
    Permission perm;

    public AccessControlException(String string) {
        super(string);
    }

    public AccessControlException(String string, Permission permission) {
        super(string);
        this.perm = permission;
    }

    public Permission getPermission() {
        return this.perm;
    }
}


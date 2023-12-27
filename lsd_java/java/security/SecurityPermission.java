/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import java.security.BasicPermission;

public final class SecurityPermission
extends BasicPermission {
    private static final long serialVersionUID;
    static final SecurityPermission permissionToGetPolicy;
    static final SecurityPermission permissionToSetPolicy;

    static {
        permissionToGetPolicy = new SecurityPermission("getPolicy");
        permissionToSetPolicy = new SecurityPermission("setPolicy");
    }

    public SecurityPermission(String string) {
        super(string);
    }

    public SecurityPermission(String string, String string2) {
        super(string, string2);
    }
}


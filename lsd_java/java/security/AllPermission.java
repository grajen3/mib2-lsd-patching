/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import java.security.AllPermissionCollection;
import java.security.Permission;
import java.security.PermissionCollection;

public final class AllPermission
extends Permission {
    private static final long serialVersionUID;

    public AllPermission() {
        super("<all permissions>");
    }

    public AllPermission(String string, String string2) {
        super("<all permissions>");
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof AllPermission;
    }

    @Override
    public String getActions() {
        return "<all actions>";
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean implies(Permission permission) {
        return true;
    }

    @Override
    public PermissionCollection newPermissionCollection() {
        return new AllPermissionCollection();
    }
}


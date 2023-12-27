/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import java.security.Permission;
import java.security.PermissionCollection;
import java.util.Enumeration;
import java.util.Hashtable;

class PermissionsHash
extends PermissionCollection {
    private static final long serialVersionUID;
    Hashtable perms = new Hashtable(8);

    @Override
    public void add(Permission permission) {
        if (this.isReadOnly()) {
            throw new IllegalStateException();
        }
        this.perms.put(permission, permission);
    }

    @Override
    public Enumeration elements() {
        return this.perms.keys();
    }

    @Override
    public boolean implies(Permission permission) {
        Enumeration enumeration = this.elements();
        while (enumeration.hasMoreElements()) {
            if (!((Permission)enumeration.nextElement()).implies(permission)) continue;
            return true;
        }
        return false;
    }
}


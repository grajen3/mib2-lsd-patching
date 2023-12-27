/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import java.security.AllPermission;
import java.security.Permission;
import java.security.PermissionCollection;
import java.util.Enumeration;
import java.util.Vector;

class AllPermissionCollection
extends PermissionCollection {
    private static final long serialVersionUID;
    boolean all_allowed = false;

    AllPermissionCollection() {
    }

    @Override
    public void add(Permission permission) {
        if (!(permission instanceof AllPermission)) {
            throw new IllegalArgumentException(permission.toString());
        }
        if (this.isReadOnly()) {
            throw new IllegalStateException();
        }
        this.all_allowed = true;
    }

    @Override
    public Enumeration elements() {
        Vector vector = new Vector();
        if (this.all_allowed) {
            vector.addElement(new AllPermission());
        }
        return vector.elements();
    }

    @Override
    public boolean implies(Permission permission) {
        return this.all_allowed;
    }
}


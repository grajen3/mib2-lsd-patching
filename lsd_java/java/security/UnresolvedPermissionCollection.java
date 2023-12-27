/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import java.security.Permission;
import java.security.PermissionCollection;
import java.security.UnresolvedPermissionCollection$1;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

class UnresolvedPermissionCollection
extends PermissionCollection {
    private static final long serialVersionUID;
    Hashtable permissions = new Hashtable(8);

    UnresolvedPermissionCollection() {
    }

    @Override
    public void add(Permission permission) {
        if (this.isReadOnly()) {
            throw new IllegalStateException();
        }
        Vector vector = (Vector)this.permissions.get(permission.getName());
        if (vector == null) {
            vector = new Vector();
            this.permissions.put(permission.getName(), vector);
        }
        vector.addElement(permission);
    }

    @Override
    public Enumeration elements() {
        return new UnresolvedPermissionCollection$1(this);
    }

    @Override
    public boolean implies(Permission permission) {
        return false;
    }

    Vector getPermissions(String string) {
        return (Vector)this.permissions.get(string);
    }
}


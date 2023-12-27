/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import java.io.FilePermission;
import java.io.Serializable;
import java.security.Permission;
import java.security.PermissionCollection;
import java.util.Enumeration;
import java.util.Vector;

final class FilePermissionCollection
extends PermissionCollection
implements Serializable {
    private static final long serialVersionUID;
    Vector permissions = new Vector();

    @Override
    public void add(Permission permission) {
        if (!this.isReadOnly()) {
            if (!(permission instanceof FilePermission)) {
                throw new IllegalArgumentException(permission.toString());
            }
        } else {
            throw new IllegalStateException();
        }
        this.permissions.addElement(permission);
    }

    @Override
    public Enumeration elements() {
        return this.permissions.elements();
    }

    @Override
    public boolean implies(Permission permission) {
        if (permission instanceof FilePermission) {
            FilePermission filePermission = (FilePermission)permission;
            int n = 0;
            int n2 = 0;
            while (n2 < this.permissions.size() && (n & filePermission.mask) != filePermission.mask) {
                n |= ((FilePermission)this.permissions.elementAt(n2)).impliesMask(permission);
                ++n2;
            }
            return (n & filePermission.mask) == filePermission.mask;
        }
        return false;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import java.net.SocketPermission;
import java.security.Permission;
import java.security.PermissionCollection;
import java.util.Enumeration;
import java.util.Vector;

final class SocketPermissionCollection
extends PermissionCollection {
    private static final long serialVersionUID;
    public Vector permissions = new Vector();

    @Override
    public void add(Permission permission) {
        if (this.isReadOnly()) {
            throw new IllegalStateException();
        }
        if (!(permission instanceof SocketPermission)) {
            throw new IllegalArgumentException(permission.toString());
        }
        this.permissions.addElement(permission);
    }

    @Override
    public Enumeration elements() {
        return this.permissions.elements();
    }

    @Override
    public boolean implies(Permission permission) {
        if (!(permission instanceof SocketPermission)) {
            return false;
        }
        SocketPermission socketPermission = (SocketPermission)permission;
        int n = socketPermission.actionsMask;
        int n2 = 0;
        int n3 = 0;
        int n4 = this.permissions.size();
        while (n3 < n4 && (n2 & n) != n) {
            SocketPermission socketPermission2 = (SocketPermission)this.permissions.elementAt(n3);
            if (socketPermission2.checkHost(socketPermission)) {
                if ((socketPermission2.actionsMask & 8) == 8) {
                    n2 |= 8;
                }
                if (socketPermission.portMin >= socketPermission2.portMin && socketPermission.portMax <= socketPermission2.portMax) {
                    if ((socketPermission2.actionsMask & 1) == 1) {
                        n2 |= 1;
                    }
                    if ((socketPermission2.actionsMask & 4) == 4) {
                        n2 |= 4;
                    }
                    if ((socketPermission2.actionsMask & 2) == 2) {
                        n2 |= 2;
                    }
                }
            }
            ++n3;
        }
        return (n2 & n) == n;
    }
}


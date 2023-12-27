/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import java.security.Permission;
import java.security.PermissionCollection;
import java.security.Permissions;
import java.util.Enumeration;
import java.util.NoSuchElementException;

class Permissions$PermissionsEnumeration
implements Enumeration {
    Enumeration enumMap;
    PermissionCollection c;
    Enumeration enumC;
    Permission next;
    final /* synthetic */ Permissions this$0;

    Permissions$PermissionsEnumeration(Permissions permissions) {
        this.this$0 = permissions;
        this.enumMap = permissions.perms.elements();
        this.next = this.findNextPermission();
    }

    @Override
    public boolean hasMoreElements() {
        return this.next != null;
    }

    @Override
    public Object nextElement() {
        if (this.next == null) {
            throw new NoSuchElementException();
        }
        Permission permission = this.next;
        this.next = this.findNextPermission();
        return permission;
    }

    private Permission findNextPermission() {
        while (this.c == null && this.enumMap.hasMoreElements()) {
            this.c = (PermissionCollection)this.enumMap.nextElement();
            this.enumC = this.c.elements();
            if (this.enumC.hasMoreElements()) continue;
            this.c = null;
        }
        if (this.c == null) {
            return null;
        }
        Permission permission = (Permission)this.enumC.nextElement();
        if (!this.enumC.hasMoreElements()) {
            this.c = null;
        }
        return permission;
    }
}


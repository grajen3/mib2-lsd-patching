/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import java.io.Serializable;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.Permissions$PermissionsEnumeration;
import java.security.PermissionsHash;
import java.security.UnresolvedPermission;
import java.security.UnresolvedPermissionCollection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public final class Permissions
extends PermissionCollection
implements Serializable {
    private static final long serialVersionUID;
    Hashtable perms = new Hashtable(8);
    PermissionCollection allPermission;
    static /* synthetic */ Class class$0;
    static /* synthetic */ Class class$1;

    @Override
    public void add(Permission permission) {
        if (this.isReadOnly()) {
            throw new SecurityException();
        }
        Class clazz = super.getClass();
        Class clazz2 = class$0;
        if (clazz2 == null) {
            try {
                clazz2 = class$0 = Class.forName("java.security.AllPermission");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new NoClassDefFoundError(classNotFoundException.getMessage());
            }
        }
        if (clazz == clazz2) {
            this.allPermission = this.findCollection(permission);
            this.allPermission.add(permission);
        } else {
            this.findCollection(permission).add(permission);
        }
    }

    @Override
    public Enumeration elements() {
        Permissions$PermissionsEnumeration permissions$PermissionsEnumeration = new Permissions$PermissionsEnumeration(this);
        return permissions$PermissionsEnumeration;
    }

    private PermissionCollection findCollection(Permission permission) {
        Class clazz = super.getClass();
        PermissionCollection permissionCollection = (PermissionCollection)this.perms.get(clazz);
        if (permissionCollection == null) {
            permissionCollection = permission.newPermissionCollection();
            if (permissionCollection == null) {
                permissionCollection = new PermissionsHash();
            }
            this.perms.put(clazz, permissionCollection);
        }
        return permissionCollection;
    }

    @Override
    public boolean implies(Permission permission) {
        Vector vector;
        UnresolvedPermissionCollection unresolvedPermissionCollection;
        if (this.allPermission != null) {
            return true;
        }
        PermissionCollection permissionCollection = (PermissionCollection)this.perms.get(super.getClass());
        if (permissionCollection != null) {
            return permissionCollection.implies(permission);
        }
        Class clazz = class$1;
        if (clazz == null) {
            try {
                clazz = class$1 = Class.forName("java.security.UnresolvedPermission");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new NoClassDefFoundError(classNotFoundException.getMessage());
            }
        }
        if ((unresolvedPermissionCollection = (UnresolvedPermissionCollection)this.perms.get(clazz)) != null && (vector = unresolvedPermissionCollection.getPermissions(super.getClass().getName())) != null) {
            Enumeration enumeration = vector.elements();
            while (enumeration.hasMoreElements()) {
                Permission permission2 = ((UnresolvedPermission)enumeration.nextElement()).resolve(super.getClass().getClassLoader());
                if (permission2 == null) continue;
                permissionCollection = this.findCollection(permission2);
                permissionCollection.add(permission2);
            }
            if (permissionCollection != null) {
                return permissionCollection.implies(permission);
            }
        }
        return false;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package java.security.acl;

import java.security.Principal;
import java.security.acl.AclEntry;
import java.security.acl.Owner;
import java.security.acl.Permission;
import java.util.Enumeration;

public interface Acl
extends Owner {
    default public boolean addEntry(Principal principal, AclEntry aclEntry) {
    }

    default public boolean checkPermission(Principal principal, Permission permission) {
    }

    default public Enumeration entries() {
    }

    default public String getName() {
    }

    default public Enumeration getPermissions(Principal principal) {
    }

    default public boolean removeEntry(Principal principal, AclEntry aclEntry) {
    }

    default public void setName(Principal principal, String string) {
    }

    default public String toString() {
    }
}


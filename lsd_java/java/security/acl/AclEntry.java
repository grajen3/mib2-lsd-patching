/*
 * Decompiled with CFR 0.152.
 */
package java.security.acl;

import java.security.Principal;
import java.security.acl.Permission;
import java.util.Enumeration;

public interface AclEntry
extends Cloneable {
    default public boolean addPermission(Permission permission) {
    }

    default public boolean checkPermission(Permission permission) {
    }

    default public Object clone() {
    }

    default public Principal getPrincipal() {
    }

    default public boolean isNegative() {
    }

    default public Enumeration permissions() {
    }

    default public boolean removePermission(Permission permission) {
    }

    default public void setNegativePermissions() {
    }

    default public boolean setPrincipal(Principal principal) {
    }

    default public String toString() {
    }
}


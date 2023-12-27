/*
 * Decompiled with CFR 0.152.
 */
package java.security.acl;

import java.security.Principal;

public interface Owner {
    default public boolean addOwner(Principal principal, Principal principal2) {
    }

    default public boolean deleteOwner(Principal principal, Principal principal2) {
    }

    default public boolean isOwner(Principal principal) {
    }
}


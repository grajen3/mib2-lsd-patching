/*
 * Decompiled with CFR 0.152.
 */
package java.security.acl;

import java.security.Principal;
import java.util.Enumeration;

public interface Group
extends Principal {
    default public boolean addMember(Principal principal) {
    }

    default public boolean isMember(Principal principal) {
    }

    default public Enumeration members() {
    }

    default public boolean removeMember(Principal principal) {
    }
}


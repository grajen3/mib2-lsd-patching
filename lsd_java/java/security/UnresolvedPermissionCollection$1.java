/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import java.security.UnresolvedPermissionCollection;
import java.util.Enumeration;
import java.util.Vector;

final class UnresolvedPermissionCollection$1
implements Enumeration {
    Enumeration vEnum;
    Enumeration pEnum;
    Object next;
    final /* synthetic */ UnresolvedPermissionCollection this$0;

    UnresolvedPermissionCollection$1(UnresolvedPermissionCollection unresolvedPermissionCollection) {
        this.this$0 = unresolvedPermissionCollection;
        this.pEnum = unresolvedPermissionCollection.permissions.elements();
        this.next = this.findNext();
    }

    private Object findNext() {
        if (this.vEnum != null && this.vEnum.hasMoreElements()) {
            return this.vEnum.nextElement();
        }
        if (!this.pEnum.hasMoreElements()) {
            return null;
        }
        this.vEnum = ((Vector)this.pEnum.nextElement()).elements();
        return this.vEnum.nextElement();
    }

    @Override
    public boolean hasMoreElements() {
        return this.next != null;
    }

    @Override
    public Object nextElement() {
        Object object = this.next;
        this.next = this.findNext();
        return object;
    }
}


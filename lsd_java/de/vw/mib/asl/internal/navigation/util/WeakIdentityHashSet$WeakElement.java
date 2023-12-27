/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.util;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class WeakIdentityHashSet$WeakElement
extends WeakReference {
    private int hash;

    private WeakIdentityHashSet$WeakElement(Object object) {
        super(object);
        this.hash = System.identityHashCode(object);
    }

    private WeakIdentityHashSet$WeakElement(Object object, ReferenceQueue referenceQueue) {
        super(object, referenceQueue);
        this.hash = System.identityHashCode(object);
    }

    static WeakIdentityHashSet$WeakElement create(Object object) {
        return object == null ? null : new WeakIdentityHashSet$WeakElement(object);
    }

    static WeakIdentityHashSet$WeakElement create(Object object, ReferenceQueue referenceQueue) {
        return object == null ? null : new WeakIdentityHashSet$WeakElement(object, referenceQueue);
    }

    public boolean equals(Object object) {
        Object object2;
        if (this == object) {
            return true;
        }
        if (!(object instanceof WeakIdentityHashSet$WeakElement)) {
            return false;
        }
        Object object3 = this.get();
        return object3 == (object2 = ((WeakIdentityHashSet$WeakElement)object).get());
    }

    public int hashCode() {
        return this.hash;
    }
}


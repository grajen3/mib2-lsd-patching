/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.io.ObjectOutputStream;
import java.util.Collections$SynchronizedCollection;
import java.util.Set;

class Collections$SynchronizedSet
extends Collections$SynchronizedCollection
implements Set {
    private static final long serialVersionUID;

    Collections$SynchronizedSet(Set set) {
        super(set);
    }

    Collections$SynchronizedSet(Set set, Object object) {
        super(set, object);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean equals(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.c.equals(object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int hashCode() {
        Object object = this.mutex;
        synchronized (object) {
            return this.c.hashCode();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void writeObject(ObjectOutputStream objectOutputStream) {
        Object object = this.mutex;
        synchronized (object) {
            objectOutputStream.defaultWriteObject();
        }
    }
}


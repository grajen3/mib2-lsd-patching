/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.Collections$SynchronizedList;
import java.util.List;
import java.util.RandomAccess;

class Collections$SynchronizedRandomAccessList
extends Collections$SynchronizedList
implements RandomAccess {
    private static final long serialVersionUID;

    Collections$SynchronizedRandomAccessList(List list) {
        super(list);
    }

    Collections$SynchronizedRandomAccessList(List list, Object object) {
        super(list, object);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public List subList(int n, int n2) {
        Object object = this.mutex;
        synchronized (object) {
            return new Collections$SynchronizedRandomAccessList(this.list.subList(n, n2), this.mutex);
        }
    }

    private Object writeReplace() {
        return new Collections$SynchronizedList(this.list);
    }
}


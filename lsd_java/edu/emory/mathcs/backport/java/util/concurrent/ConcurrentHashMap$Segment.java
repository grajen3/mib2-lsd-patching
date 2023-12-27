/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentHashMap$HashEntry;
import edu.emory.mathcs.backport.java.util.concurrent.locks.ReentrantLock;
import java.io.Serializable;

final class ConcurrentHashMap$Segment
extends ReentrantLock
implements Serializable {
    private static final long serialVersionUID;
    volatile transient int count;
    transient int modCount;
    transient int threshold;
    volatile transient ConcurrentHashMap$HashEntry[] table;
    final float loadFactor;

    ConcurrentHashMap$Segment(int n, float f2) {
        this.loadFactor = f2;
        this.setTable(ConcurrentHashMap$HashEntry.newArray(n));
    }

    static final ConcurrentHashMap$Segment[] newArray(int n) {
        return new ConcurrentHashMap$Segment[n];
    }

    void setTable(ConcurrentHashMap$HashEntry[] concurrentHashMap$HashEntryArray) {
        this.threshold = (int)((float)concurrentHashMap$HashEntryArray.length * this.loadFactor);
        this.table = concurrentHashMap$HashEntryArray;
    }

    ConcurrentHashMap$HashEntry getFirst(int n) {
        ConcurrentHashMap$HashEntry[] concurrentHashMap$HashEntryArray = this.table;
        return concurrentHashMap$HashEntryArray[n & concurrentHashMap$HashEntryArray.length - 1];
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    Object readValueUnderLock(ConcurrentHashMap$HashEntry concurrentHashMap$HashEntry) {
        this.lock();
        try {
            Object object = concurrentHashMap$HashEntry.value;
            return object;
        }
        finally {
            this.unlock();
        }
    }

    Object get(Object object, int n) {
        if (this.count != 0) {
            ConcurrentHashMap$HashEntry concurrentHashMap$HashEntry = this.getFirst(n);
            while (concurrentHashMap$HashEntry != null) {
                if (concurrentHashMap$HashEntry.hash == n && object.equals(concurrentHashMap$HashEntry.key)) {
                    Object object2 = concurrentHashMap$HashEntry.value;
                    if (object2 != null) {
                        return object2;
                    }
                    return this.readValueUnderLock(concurrentHashMap$HashEntry);
                }
                concurrentHashMap$HashEntry = concurrentHashMap$HashEntry.next;
            }
        }
        return null;
    }

    boolean containsKey(Object object, int n) {
        if (this.count != 0) {
            ConcurrentHashMap$HashEntry concurrentHashMap$HashEntry = this.getFirst(n);
            while (concurrentHashMap$HashEntry != null) {
                if (concurrentHashMap$HashEntry.hash == n && object.equals(concurrentHashMap$HashEntry.key)) {
                    return true;
                }
                concurrentHashMap$HashEntry = concurrentHashMap$HashEntry.next;
            }
        }
        return false;
    }

    boolean containsValue(Object object) {
        if (this.count != 0) {
            for (ConcurrentHashMap$HashEntry concurrentHashMap$HashEntry : this.table) {
                while (concurrentHashMap$HashEntry != null) {
                    Object object2 = concurrentHashMap$HashEntry.value;
                    if (object2 == null) {
                        object2 = this.readValueUnderLock(concurrentHashMap$HashEntry);
                    }
                    if (object.equals(object2)) {
                        return true;
                    }
                    concurrentHashMap$HashEntry = concurrentHashMap$HashEntry.next;
                }
            }
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    boolean replace(Object object, int n, Object object2, Object object3) {
        this.lock();
        try {
            ConcurrentHashMap$HashEntry concurrentHashMap$HashEntry = this.getFirst(n);
            while (!(concurrentHashMap$HashEntry == null || concurrentHashMap$HashEntry.hash == n && object.equals(concurrentHashMap$HashEntry.key))) {
                concurrentHashMap$HashEntry = concurrentHashMap$HashEntry.next;
            }
            boolean bl = false;
            if (concurrentHashMap$HashEntry != null && object2.equals(concurrentHashMap$HashEntry.value)) {
                bl = true;
                concurrentHashMap$HashEntry.value = object3;
            }
            boolean bl2 = bl;
            return bl2;
        }
        finally {
            this.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    Object replace(Object object, int n, Object object2) {
        this.lock();
        try {
            ConcurrentHashMap$HashEntry concurrentHashMap$HashEntry = this.getFirst(n);
            while (!(concurrentHashMap$HashEntry == null || concurrentHashMap$HashEntry.hash == n && object.equals(concurrentHashMap$HashEntry.key))) {
                concurrentHashMap$HashEntry = concurrentHashMap$HashEntry.next;
            }
            Object object3 = null;
            if (concurrentHashMap$HashEntry != null) {
                object3 = concurrentHashMap$HashEntry.value;
                concurrentHashMap$HashEntry.value = object2;
            }
            Object object4 = object3;
            return object4;
        }
        finally {
            this.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    Object put(Object object, int n, Object object2, boolean bl) {
        this.lock();
        try {
            Object object3;
            ConcurrentHashMap$HashEntry concurrentHashMap$HashEntry;
            int n2 = this.count;
            if (n2++ > this.threshold) {
                this.rehash();
            }
            ConcurrentHashMap$HashEntry[] concurrentHashMap$HashEntryArray = this.table;
            int n3 = n & concurrentHashMap$HashEntryArray.length - 1;
            ConcurrentHashMap$HashEntry concurrentHashMap$HashEntry2 = concurrentHashMap$HashEntry = concurrentHashMap$HashEntryArray[n3];
            while (!(concurrentHashMap$HashEntry2 == null || concurrentHashMap$HashEntry2.hash == n && object.equals(concurrentHashMap$HashEntry2.key))) {
                concurrentHashMap$HashEntry2 = concurrentHashMap$HashEntry2.next;
            }
            if (concurrentHashMap$HashEntry2 != null) {
                object3 = concurrentHashMap$HashEntry2.value;
                if (!bl) {
                    concurrentHashMap$HashEntry2.value = object2;
                }
            } else {
                object3 = null;
                ++this.modCount;
                concurrentHashMap$HashEntryArray[n3] = new ConcurrentHashMap$HashEntry(object, n, concurrentHashMap$HashEntry, object2);
                this.count = n2;
            }
            Object object4 = object3;
            return object4;
        }
        finally {
            this.unlock();
        }
    }

    void rehash() {
        ConcurrentHashMap$HashEntry[] concurrentHashMap$HashEntryArray = this.table;
        int n = concurrentHashMap$HashEntryArray.length;
        if (n >= 64) {
            return;
        }
        ConcurrentHashMap$HashEntry[] concurrentHashMap$HashEntryArray2 = ConcurrentHashMap$HashEntry.newArray(n << 1);
        this.threshold = (int)((float)concurrentHashMap$HashEntryArray2.length * this.loadFactor);
        int n2 = concurrentHashMap$HashEntryArray2.length - 1;
        for (int i2 = 0; i2 < n; ++i2) {
            int n3;
            ConcurrentHashMap$HashEntry concurrentHashMap$HashEntry = concurrentHashMap$HashEntryArray[i2];
            if (concurrentHashMap$HashEntry == null) continue;
            ConcurrentHashMap$HashEntry concurrentHashMap$HashEntry2 = concurrentHashMap$HashEntry.next;
            int n4 = concurrentHashMap$HashEntry.hash & n2;
            if (concurrentHashMap$HashEntry2 == null) {
                concurrentHashMap$HashEntryArray2[n4] = concurrentHashMap$HashEntry;
                continue;
            }
            ConcurrentHashMap$HashEntry concurrentHashMap$HashEntry3 = concurrentHashMap$HashEntry;
            int n5 = n4;
            ConcurrentHashMap$HashEntry concurrentHashMap$HashEntry4 = concurrentHashMap$HashEntry2;
            while (concurrentHashMap$HashEntry4 != null) {
                n3 = concurrentHashMap$HashEntry4.hash & n2;
                if (n3 != n5) {
                    n5 = n3;
                    concurrentHashMap$HashEntry3 = concurrentHashMap$HashEntry4;
                }
                concurrentHashMap$HashEntry4 = concurrentHashMap$HashEntry4.next;
            }
            concurrentHashMap$HashEntryArray2[n5] = concurrentHashMap$HashEntry3;
            concurrentHashMap$HashEntry4 = concurrentHashMap$HashEntry;
            while (concurrentHashMap$HashEntry4 != concurrentHashMap$HashEntry3) {
                n3 = concurrentHashMap$HashEntry4.hash & n2;
                ConcurrentHashMap$HashEntry concurrentHashMap$HashEntry5 = concurrentHashMap$HashEntryArray2[n3];
                concurrentHashMap$HashEntryArray2[n3] = new ConcurrentHashMap$HashEntry(concurrentHashMap$HashEntry4.key, concurrentHashMap$HashEntry4.hash, concurrentHashMap$HashEntry5, concurrentHashMap$HashEntry4.value);
                concurrentHashMap$HashEntry4 = concurrentHashMap$HashEntry4.next;
            }
        }
        this.table = concurrentHashMap$HashEntryArray2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    Object remove(Object object, int n, Object object2) {
        this.lock();
        try {
            Object object3;
            ConcurrentHashMap$HashEntry concurrentHashMap$HashEntry;
            int n2 = this.count - 1;
            ConcurrentHashMap$HashEntry[] concurrentHashMap$HashEntryArray = this.table;
            int n3 = n & concurrentHashMap$HashEntryArray.length - 1;
            ConcurrentHashMap$HashEntry concurrentHashMap$HashEntry2 = concurrentHashMap$HashEntry = concurrentHashMap$HashEntryArray[n3];
            while (!(concurrentHashMap$HashEntry2 == null || concurrentHashMap$HashEntry2.hash == n && object.equals(concurrentHashMap$HashEntry2.key))) {
                concurrentHashMap$HashEntry2 = concurrentHashMap$HashEntry2.next;
            }
            Object object4 = null;
            if (concurrentHashMap$HashEntry2 != null) {
                object3 = concurrentHashMap$HashEntry2.value;
                if (object2 == null || object2.equals(object3)) {
                    object4 = object3;
                    ++this.modCount;
                    ConcurrentHashMap$HashEntry concurrentHashMap$HashEntry3 = concurrentHashMap$HashEntry2.next;
                    ConcurrentHashMap$HashEntry concurrentHashMap$HashEntry4 = concurrentHashMap$HashEntry;
                    while (concurrentHashMap$HashEntry4 != concurrentHashMap$HashEntry2) {
                        concurrentHashMap$HashEntry3 = new ConcurrentHashMap$HashEntry(concurrentHashMap$HashEntry4.key, concurrentHashMap$HashEntry4.hash, concurrentHashMap$HashEntry3, concurrentHashMap$HashEntry4.value);
                        concurrentHashMap$HashEntry4 = concurrentHashMap$HashEntry4.next;
                    }
                    concurrentHashMap$HashEntryArray[n3] = concurrentHashMap$HashEntry3;
                    this.count = n2;
                }
            }
            object3 = object4;
            return object3;
        }
        finally {
            this.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void clear() {
        if (this.count != 0) {
            this.lock();
            try {
                ConcurrentHashMap$HashEntry[] concurrentHashMap$HashEntryArray = this.table;
                for (int i2 = 0; i2 < concurrentHashMap$HashEntryArray.length; ++i2) {
                    concurrentHashMap$HashEntryArray[i2] = null;
                }
                ++this.modCount;
                this.count = 0;
            }
            finally {
                this.unlock();
            }
        }
    }
}


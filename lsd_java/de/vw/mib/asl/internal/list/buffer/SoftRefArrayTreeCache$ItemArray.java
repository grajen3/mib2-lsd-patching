/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list.buffer;

import de.vw.mib.asl.internal.list.buffer.SoftRefArrayTreeCache$Key;
import de.vw.mib.pool.PoorMansPool;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.Arrays;

final class SoftRefArrayTreeCache$ItemArray
extends SoftRefArrayTreeCache$Key {
    private static final boolean USE_POOL;
    private static final int MAX_POOL_SIZE;
    private static final PoorMansPool POOL;
    private final Reference[] arrayItems = new Reference[32];
    private int numElements;

    private SoftRefArrayTreeCache$ItemArray() {
    }

    SoftRefArrayTreeCache$ItemArray setData(int n, int n2) {
        this.startIndex = n;
        this.numElements = n2;
        return this;
    }

    static synchronized SoftRefArrayTreeCache$ItemArray borrow() {
        SoftRefArrayTreeCache$ItemArray softRefArrayTreeCache$ItemArray = (SoftRefArrayTreeCache$ItemArray)POOL.borrow();
        if (null == softRefArrayTreeCache$ItemArray) {
            softRefArrayTreeCache$ItemArray = new SoftRefArrayTreeCache$ItemArray();
        }
        return softRefArrayTreeCache$ItemArray;
    }

    static synchronized void release(SoftRefArrayTreeCache$ItemArray softRefArrayTreeCache$ItemArray) {
        POOL.release(softRefArrayTreeCache$ItemArray);
    }

    static void move(SoftRefArrayTreeCache$ItemArray softRefArrayTreeCache$ItemArray, int n, SoftRefArrayTreeCache$ItemArray softRefArrayTreeCache$ItemArray2, int n2, int n3) {
        if (null == softRefArrayTreeCache$ItemArray) {
            while (0 < n3--) {
                if (softRefArrayTreeCache$ItemArray2.arrayItems[n2] != null) {
                    --softRefArrayTreeCache$ItemArray2.numElements;
                    softRefArrayTreeCache$ItemArray2.arrayItems[n2] = null;
                }
                ++n2;
            }
        } else {
            int n4;
            int n5;
            int n6;
            if (softRefArrayTreeCache$ItemArray != softRefArrayTreeCache$ItemArray2 || n2 < n) {
                n6 = n;
                n5 = n2;
                n4 = 1;
            } else {
                if (n2 == n) {
                    return;
                }
                n6 = n + n3 - 1;
                n5 = n2 + n3 - 1;
                n4 = -1;
            }
            for (int i2 = 0; i2 < n3; ++i2) {
                Reference reference = softRefArrayTreeCache$ItemArray.arrayItems[n6];
                Reference reference2 = softRefArrayTreeCache$ItemArray2.arrayItems[n5];
                if (null != reference) {
                    --softRefArrayTreeCache$ItemArray.numElements;
                    if (null == reference.get()) {
                        reference = null;
                    }
                }
                if (null == reference && null != reference2) {
                    --softRefArrayTreeCache$ItemArray2.numElements;
                } else if (null != reference && null == reference2) {
                    ++softRefArrayTreeCache$ItemArray2.numElements;
                }
                softRefArrayTreeCache$ItemArray2.arrayItems[n5] = reference;
                softRefArrayTreeCache$ItemArray.arrayItems[n6] = null;
                n5 += n4;
                n6 += n4;
            }
        }
    }

    void clear() {
        Arrays.fill(this.arrayItems, null);
        this.numElements = 0;
    }

    boolean cutToSize(int n) {
        int n2;
        for (n2 = 0; 0 < this.numElements && n2 < n; ++n2) {
            Reference reference = this.arrayItems[n2];
            if (null == reference || null != reference.get()) continue;
            this.arrayItems[n2] = null;
            --this.numElements;
        }
        while (0 < this.numElements && n2 < 32) {
            if (null != this.arrayItems[n2]) {
                this.arrayItems[n2] = null;
                --this.numElements;
            }
            ++n2;
        }
        return 0 == this.numElements;
    }

    Object get(int n) {
        Reference reference = this.arrayItems[n];
        Object object = null;
        if (null != reference && null == (object = reference.get())) {
            this.arrayItems[n] = null;
            --this.numElements;
        }
        return object;
    }

    boolean getItems(int n, Object[] objectArray, int n2, int n3) {
        boolean bl = true;
        while (n3-- > 0) {
            Object object = this.get(n++);
            objectArray[n2++] = object;
            if (null != object) continue;
            bl = false;
        }
        return bl;
    }

    int getMaxOffset() {
        int n = -1;
        for (int i2 = 0; 0 < this.numElements && i2 < this.arrayItems.length; ++i2) {
            Reference reference = this.arrayItems[i2];
            if (null == reference) continue;
            if (null == reference.get()) {
                this.arrayItems[i2] = null;
                --this.numElements;
                continue;
            }
            n = i2;
        }
        return n;
    }

    int getMinOffset() {
        int n = -1;
        for (int i2 = this.arrayItems.length - 1; 0 < this.numElements && i2 >= 0; --i2) {
            Reference reference = this.arrayItems[i2];
            if (null == reference) continue;
            if (null == reference.get()) {
                this.arrayItems[i2] = null;
                --this.numElements;
                continue;
            }
            n = i2;
        }
        return n;
    }

    boolean purge() {
        for (int i2 = this.arrayItems.length - 1; 0 < this.numElements && 0 <= i2; --i2) {
            Reference reference = this.arrayItems[i2];
            if (null == reference || null != reference.get()) continue;
            --this.numElements;
            this.arrayItems[i2] = null;
        }
        return 0 == this.numElements;
    }

    void release() {
        this.clear();
        SoftRefArrayTreeCache$ItemArray.release(this);
    }

    boolean store(int n, Object[] objectArray, int n2, int n3) {
        if (null == objectArray) {
            while (0 < n3) {
                if (this.arrayItems[n] != null) {
                    --this.numElements;
                    this.arrayItems[n] = null;
                }
                ++n;
                --n3;
            }
        } else {
            while (0 < n3) {
                if (null == objectArray[n2]) {
                    if (this.arrayItems[n] != null) {
                        --this.numElements;
                        this.arrayItems[n] = null;
                    }
                } else {
                    if (null == this.arrayItems[n]) {
                        ++this.numElements;
                    }
                    this.arrayItems[n] = new SoftReference(objectArray[n2]);
                }
                ++n;
                ++n2;
                --n3;
            }
        }
        return 0 == this.numElements;
    }

    public String toString() {
        return new StringBuffer().append("[").append(this.startIndex).append("..").append(this.startIndex + 32 - 1).append("](").append(this.numElements).append(")").toString();
    }

    static {
        POOL = new PoorMansPool("SoftRefArrayTreeCache.ItemArray", 20);
    }
}


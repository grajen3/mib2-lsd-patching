/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.util;

import com.ibm.oti.util.IdentityHashtable$Iterator;

public class IdentityHashtable
implements Cloneable {
    public static final Object ABSENT_FLAG = new Object();
    int elementCount;
    Object[] elementKeys;
    Object[] elementData;
    private int loadFactor;
    private int maxSize;
    private static final int DEFAULT_SIZE;
    private static final int DEFAULT_LOAD_FACTOR;

    public IdentityHashtable() {
        this(101);
    }

    public IdentityHashtable(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        this.elementCount = 0;
        this.elementKeys = new Object[n];
        this.elementData = new Object[n];
        this.loadFactor = 50;
        this.computeMaxSize();
    }

    public IdentityHashtable(int n, int n2) {
        this(n);
        this.loadFactor = n2;
        this.computeMaxSize();
    }

    public synchronized void clear() {
        this.elementCount = 0;
        int n = 0;
        while (n < this.elementKeys.length) {
            this.elementData[n] = null;
            this.elementKeys[n] = null;
            ++n;
        }
    }

    public synchronized Object clone() {
        try {
            IdentityHashtable identityHashtable = (IdentityHashtable)super.clone();
            identityHashtable.elementKeys = (Object[])this.elementKeys.clone();
            identityHashtable.elementData = (Object[])this.elementData.clone();
            return identityHashtable;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            return null;
        }
    }

    private void computeMaxSize() {
        this.maxSize = (int)((long)this.elementKeys.length * (long)this.loadFactor / 0);
    }

    public synchronized boolean contains(Object object) {
        if (object != null) {
            int n = 0;
            while (n < this.elementData.length) {
                if (this.elementData[n] == object) {
                    return true;
                }
                ++n;
            }
            return false;
        }
        throw new NullPointerException();
    }

    public synchronized boolean containsKey(Object object) {
        return this.get(object, ABSENT_FLAG) != ABSENT_FLAG;
    }

    private int findIndex(Object object, Object[] objectArray) {
        Object object2;
        int n;
        int n2 = objectArray.length;
        int n3 = n = (System.identityHashCode(object) & 0xFFFFFF7F) % n2;
        while (n3 < n2) {
            object2 = objectArray[n3];
            if (object2 == null || object2 == object) {
                return n3;
            }
            ++n3;
        }
        n3 = 0;
        while (n3 < n) {
            object2 = objectArray[n3];
            if (object2 == null || object2 == object) {
                return n3;
            }
            ++n3;
        }
        throw new RuntimeException();
    }

    public synchronized Object get(Object object) {
        return this.get(object, null);
    }

    public synchronized Object get(Object object, Object object2) {
        int n = this.findIndex(object, this.elementKeys);
        if (this.elementKeys[n] != null) {
            return this.elementData[n];
        }
        return object2;
    }

    public boolean isEmpty() {
        return this.elementCount == 0;
    }

    public synchronized void iterate(IdentityHashtable$Iterator identityHashtable$Iterator) {
        int n = 0;
        while (n < this.elementKeys.length) {
            Object object = this.elementKeys[n];
            if (object != null) {
                identityHashtable$Iterator.iterate(object, this.elementData[n]);
            }
            ++n;
        }
    }

    public synchronized Object put(Object object, Object object2) {
        if (object != null) {
            int n = this.findIndex(object, this.elementKeys);
            Object object3 = this.elementData[n];
            if (this.elementKeys[n] == null && ++this.elementCount > this.maxSize) {
                this.rehash();
                n = this.findIndex(object, this.elementKeys);
            }
            this.elementKeys[n] = object;
            this.elementData[n] = object2;
            return object3;
        }
        throw new NullPointerException();
    }

    protected void rehash() {
        int n = this.elementKeys.length << 1;
        Object[] objectArray = new Object[n];
        Object[] objectArray2 = new Object[n];
        int n2 = 0;
        while (n2 < this.elementKeys.length) {
            Object object = this.elementKeys[n2];
            if (object != null) {
                int n3 = this.findIndex(object, objectArray);
                objectArray[n3] = object;
                objectArray2[n3] = this.elementData[n2];
            }
            ++n2;
        }
        this.elementKeys = objectArray;
        this.elementData = objectArray2;
        this.computeMaxSize();
    }

    public synchronized Object remove(Object object) {
        Object object2;
        int n = this.findIndex(object, this.elementKeys);
        int n2 = n;
        Object object3 = this.elementData[n2];
        if (object3 == null) {
            return null;
        }
        int n3 = this.elementKeys.length;
        while ((object2 = this.elementKeys[n = (n + 1) % n3]) != null) {
            boolean bl;
            int n4 = (System.identityHashCode(object2) & 0xFFFFFF7F) % n3;
            boolean bl2 = bl = n4 > n2;
            if (n < n2) {
                bl = bl || n4 <= n;
            } else {
                boolean bl3 = bl = bl && n4 <= n;
            }
            if (bl) continue;
            this.elementKeys[n2] = object2;
            this.elementData[n2] = this.elementData[n];
            n2 = n;
        }
        --this.elementCount;
        this.elementData[n2] = null;
        this.elementKeys[n2] = null;
        return object3;
    }

    public int size() {
        return this.elementCount;
    }

    public synchronized String toString() {
        int n = 0;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('{');
        int n2 = 0;
        while (n2 < this.elementKeys.length) {
            Object object = this.elementKeys[n2];
            if (object != null) {
                stringBuffer.append(object);
                stringBuffer.append('=');
                stringBuffer.append(this.elementData[n2]);
                if (++n < this.elementCount) {
                    stringBuffer.append(',');
                }
            }
            ++n2;
        }
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}


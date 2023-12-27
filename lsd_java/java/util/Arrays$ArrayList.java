/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

class Arrays$ArrayList
extends AbstractList
implements List,
Serializable,
RandomAccess {
    private static final long serialVersionUID;
    private final Object[] a;

    Arrays$ArrayList(Object[] objectArray) {
        if (objectArray == null) {
            throw new NullPointerException();
        }
        this.a = objectArray;
    }

    @Override
    public boolean contains(Object object) {
        if (object != null) {
            int n = 0;
            while (n < this.a.length) {
                if (object.equals(this.a[n])) {
                    return true;
                }
                ++n;
            }
        } else {
            int n = 0;
            while (n < this.a.length) {
                if (this.a[n] == null) {
                    return true;
                }
                ++n;
            }
        }
        return false;
    }

    @Override
    public Object get(int n) {
        try {
            return this.a[n];
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public int indexOf(Object object) {
        if (object != null) {
            int n = 0;
            while (n < this.a.length) {
                if (object.equals(this.a[n])) {
                    return n;
                }
                ++n;
            }
        } else {
            int n = 0;
            while (n < this.a.length) {
                if (this.a[n] == null) {
                    return n;
                }
                ++n;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        if (object != null) {
            int n = this.a.length - 1;
            while (n >= 0) {
                if (object.equals(this.a[n])) {
                    return n;
                }
                --n;
            }
        } else {
            int n = this.a.length - 1;
            while (n >= 0) {
                if (this.a[n] == null) {
                    return n;
                }
                --n;
            }
        }
        return -1;
    }

    @Override
    public Object set(int n, Object object) {
        try {
            Object object2 = this.a[n];
            this.a[n] = object;
            return object2;
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            throw new IndexOutOfBoundsException();
        }
        catch (ArrayStoreException arrayStoreException) {
            throw new ClassCastException();
        }
    }

    @Override
    public int size() {
        return this.a.length;
    }

    @Override
    public Object[] toArray() {
        return (Object[])this.a.clone();
    }

    @Override
    public Object[] toArray(Object[] objectArray) {
        int n = this.size();
        if (n > objectArray.length) {
            objectArray = (Object[])Array.newInstance(super.getClass().getComponentType(), n);
        }
        System.arraycopy((Object)this.a, 0, (Object)objectArray, 0, n);
        if (n < objectArray.length) {
            objectArray[n] = null;
        }
        return objectArray;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.AbstractList;
import java.util.AbstractList$SubAbstractList$SubAbstractListIterator;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;

class AbstractList$SubAbstractList
extends AbstractList {
    private final AbstractList fullList;
    private int offset;
    private int size;

    AbstractList$SubAbstractList(AbstractList abstractList, int n, int n2) {
        this.fullList = abstractList;
        this.modCount = this.fullList.modCount;
        this.offset = n;
        this.size = n2 - n;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void add(int n, Object object) {
        if (this.modCount != this.fullList.modCount) throw new ConcurrentModificationException();
        if (n < 0 || n > this.size) throw new IndexOutOfBoundsException();
        this.fullList.add(n + this.offset, object);
        ++this.size;
        this.modCount = this.fullList.modCount;
    }

    @Override
    public boolean addAll(int n, Collection collection) {
        if (this.modCount == this.fullList.modCount) {
            if (n >= 0 && n <= this.size) {
                boolean bl = this.fullList.addAll(n + this.offset, collection);
                if (bl) {
                    this.size += collection.size();
                    this.modCount = this.fullList.modCount;
                }
                return bl;
            }
            throw new IndexOutOfBoundsException();
        }
        throw new ConcurrentModificationException();
    }

    @Override
    public boolean addAll(Collection collection) {
        if (this.modCount == this.fullList.modCount) {
            boolean bl = this.fullList.addAll(this.size, collection);
            if (bl) {
                this.size += collection.size();
                this.modCount = this.fullList.modCount;
            }
            return bl;
        }
        throw new ConcurrentModificationException();
    }

    @Override
    public Object get(int n) {
        if (this.modCount == this.fullList.modCount) {
            if (n >= 0 && n <= this.size) {
                return this.fullList.get(n + this.offset);
            }
            throw new IndexOutOfBoundsException();
        }
        throw new ConcurrentModificationException();
    }

    @Override
    public Iterator iterator() {
        return this.listIterator(0);
    }

    @Override
    public ListIterator listIterator(int n) {
        if (this.modCount == this.fullList.modCount) {
            if (n >= 0 && n <= this.size) {
                return new AbstractList$SubAbstractList$SubAbstractListIterator(this.fullList.listIterator(n + this.offset), this, this.offset, this.size);
            }
            throw new IndexOutOfBoundsException();
        }
        throw new ConcurrentModificationException();
    }

    @Override
    public Object remove(int n) {
        if (this.modCount == this.fullList.modCount) {
            if (n >= 0 && n <= this.size) {
                Object object = this.fullList.remove(n + this.offset);
                --this.size;
                this.modCount = this.fullList.modCount;
                return object;
            }
            throw new IndexOutOfBoundsException();
        }
        throw new ConcurrentModificationException();
    }

    @Override
    protected void removeRange(int n, int n2) {
        if (n != n2) {
            if (this.modCount == this.fullList.modCount) {
                this.fullList.removeRange(n + this.offset, n2 + this.offset);
                this.size -= n2 - n;
                this.modCount = this.fullList.modCount;
            } else {
                throw new ConcurrentModificationException();
            }
        }
    }

    @Override
    public Object set(int n, Object object) {
        if (this.modCount == this.fullList.modCount) {
            if (n >= 0 && n <= this.size) {
                return this.fullList.set(n + this.offset, object);
            }
            throw new IndexOutOfBoundsException();
        }
        throw new ConcurrentModificationException();
    }

    @Override
    public int size() {
        return this.size;
    }

    void sizeChanged(boolean bl) {
        this.size = bl ? ++this.size : --this.size;
        this.modCount = this.fullList.modCount;
    }
}


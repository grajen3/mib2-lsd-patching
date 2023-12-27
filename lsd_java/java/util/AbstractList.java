/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.AbstractCollection;
import java.util.AbstractList$FullListIterator;
import java.util.AbstractList$SimpleListIterator;
import java.util.AbstractList$SubAbstractList;
import java.util.AbstractList$SubAbstractListRandomAccess;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public abstract class AbstractList
extends AbstractCollection
implements List {
    protected transient int modCount = 0;

    protected AbstractList() {
    }

    @Override
    public void add(int n, Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(Object object) {
        this.add(this.size(), object);
        return true;
    }

    @Override
    public boolean addAll(int n, Collection collection) {
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            this.add(n++, iterator.next());
        }
        return !collection.isEmpty();
    }

    @Override
    public void clear() {
        this.removeRange(0, this.size());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof List) {
            List list = (List)object;
            if (list.size() != this.size()) {
                return false;
            }
            Iterator iterator = this.iterator();
            Iterator iterator2 = list.iterator();
            while (iterator.hasNext()) {
                Object object2 = iterator.next();
                Object object3 = iterator2.next();
                if (!(object2 == null ? object3 != null : !object2.equals(object3))) continue;
                return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public abstract Object get(int n) {
    }

    @Override
    public int hashCode() {
        int n = 1;
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            n = 31 * n + (object == null ? 0 : object.hashCode());
        }
        return n;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public int indexOf(Object var1_1) {
        block2: {
            var2_2 = this.listIterator();
            if (var1_1 == null) ** GOTO lbl9
            while (var2_2.hasNext()) {
                if (!var1_1.equals(var2_2.next())) continue;
                return var2_2.previousIndex();
            }
            break block2;
lbl-1000:
            // 1 sources

            {
                if (var2_2.next() != null) continue;
                return var2_2.previousIndex();
lbl9:
                // 2 sources

                ** while (var2_2.hasNext())
            }
        }
        return -1;
    }

    @Override
    public Iterator iterator() {
        return new AbstractList$SimpleListIterator(this);
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public int lastIndexOf(Object var1_1) {
        block2: {
            var2_2 = this.listIterator(this.size());
            if (var1_1 == null) ** GOTO lbl9
            while (var2_2.hasPrevious()) {
                if (!var1_1.equals(var2_2.previous())) continue;
                return var2_2.nextIndex();
            }
            break block2;
lbl-1000:
            // 1 sources

            {
                if (var2_2.previous() != null) continue;
                return var2_2.nextIndex();
lbl9:
                // 2 sources

                ** while (var2_2.hasPrevious())
            }
        }
        return -1;
    }

    @Override
    public ListIterator listIterator() {
        return this.listIterator(0);
    }

    @Override
    public ListIterator listIterator(int n) {
        return new AbstractList$FullListIterator(this, n);
    }

    @Override
    public Object remove(int n) {
        throw new UnsupportedOperationException();
    }

    protected void removeRange(int n, int n2) {
        ListIterator listIterator = this.listIterator(n);
        int n3 = n;
        while (n3 < n2) {
            listIterator.next();
            listIterator.remove();
            ++n3;
        }
    }

    @Override
    public Object set(int n, Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List subList(int n, int n2) {
        if (n >= 0 && n2 <= this.size()) {
            if (n <= n2) {
                if (this instanceof RandomAccess) {
                    return new AbstractList$SubAbstractListRandomAccess(this, n, n2);
                }
                return new AbstractList$SubAbstractList(this, n, n2);
            }
            throw new IllegalArgumentException();
        }
        throw new IndexOutOfBoundsException();
    }
}


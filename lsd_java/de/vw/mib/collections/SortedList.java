/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import de.vw.mib.collections.SortedList$1;
import de.vw.mib.collections.SortedList$2;
import de.vw.mib.collections.SortedList$3;
import de.vw.mib.collections.SortedList$BidirectionalRingIterator;
import edu.emory.mathcs.backport.java.util.Collections;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class SortedList
implements List,
RandomAccess {
    private static final Comparator COMPARABLE_COMPARATOR = new SortedList$1();
    List backingList;
    Comparator comparator;

    public SortedList() {
        this(new ArrayList(), COMPARABLE_COMPARATOR);
    }

    public SortedList(List list) {
        this(list, COMPARABLE_COMPARATOR);
    }

    public SortedList(Comparator comparator) {
        this(new ArrayList(), comparator);
    }

    public SortedList(List list, Comparator comparator) {
        if (!(list instanceof RandomAccess)) {
            throw new IllegalArgumentException(new StringBuffer().append("The backing list is not a random access list: ").append(super.getClass()).toString());
        }
        this.backingList = list;
        this.comparator = comparator;
    }

    @Override
    public void add(int n, Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(Object object) {
        if (this.size() == 0) {
            return this.backingList.add(object);
        }
        this.backingList.add(this.getIndexFor(object), object);
        return true;
    }

    @Override
    public boolean addAll(int n, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            this.add(iterator.next());
        }
        return true;
    }

    @Override
    public void clear() {
        this.backingList.clear();
    }

    @Override
    public boolean contains(Object object) {
        int n = this.getIndexFor(object);
        return n < this.size() && object.equals(this.backingList.get(n));
    }

    @Override
    public boolean containsAll(Collection collection) {
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (this.contains(iterator.next())) continue;
            return false;
        }
        return true;
    }

    @Override
    public Object get(int n) {
        return this.backingList.get(n);
    }

    @Override
    public int indexOf(Object object) {
        int n = this.getIndexFor(object);
        if (n >= this.size() || !object.equals(this.backingList.get(n))) {
            return -1;
        }
        while (n > 0 && object.equals(this.backingList.get(n - 1))) {
            --n;
        }
        return n;
    }

    @Override
    public boolean isEmpty() {
        return this.backingList.isEmpty();
    }

    @Override
    public Iterator iterator() {
        return this.backingList.iterator();
    }

    public SortedList$BidirectionalRingIterator bidirectionalRingIterator() {
        return new SortedList$2(this);
    }

    @Override
    public int lastIndexOf(Object object) {
        int n = this.getIndexFor(object);
        if (n >= this.size() || !object.equals(this.backingList.get(n))) {
            return -1;
        }
        while (n < this.size() - 1 && object.equals(this.backingList.get(n + 1))) {
            ++n;
        }
        return n;
    }

    @Override
    public ListIterator listIterator() {
        return this.listIterator(0);
    }

    @Override
    public ListIterator listIterator(int n) {
        return new SortedList$3(this, n);
    }

    @Override
    public Object remove(int n) {
        return this.backingList.remove(n);
    }

    @Override
    public boolean remove(Object object) {
        return this.backingList.remove(object);
    }

    @Override
    public boolean removeAll(Collection collection) {
        return this.backingList.removeAll(collection);
    }

    @Override
    public boolean retainAll(Collection collection) {
        return this.backingList.retainAll(collection);
    }

    @Override
    public Object set(int n, Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return this.backingList.size();
    }

    @Override
    public List subList(int n, int n2) {
        return new SortedList(Collections.unmodifiableList(this.backingList.subList(n, n2)), COMPARABLE_COMPARATOR);
    }

    @Override
    public Object[] toArray() {
        return this.backingList.toArray();
    }

    @Override
    public Object[] toArray(Object[] objectArray) {
        return this.backingList.toArray(objectArray);
    }

    public String toString() {
        return this.backingList.toString();
    }

    private int getIndexFor(Object object) {
        int n = -1;
        int n2 = this.size();
        while (n + 1 < n2) {
            int n3 = n + n2 >>> 1;
            Object object2 = this.backingList.get(n3);
            if (this.comparator.compare(object2, object) < 0) {
                n = n3;
                continue;
            }
            n2 = n3;
        }
        return n2;
    }
}


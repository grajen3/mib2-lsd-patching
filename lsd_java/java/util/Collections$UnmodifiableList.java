/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.Collection;
import java.util.Collections$7;
import java.util.Collections$UnmodifiableCollection;
import java.util.Collections$UnmodifiableRandomAccessList;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

class Collections$UnmodifiableList
extends Collections$UnmodifiableCollection
implements List {
    private static final long serialVersionUID;
    final List list;

    Collections$UnmodifiableList(List list) {
        super(list);
        this.list = list;
    }

    @Override
    public void add(int n, Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int n, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object object) {
        return this.list.equals(object);
    }

    @Override
    public Object get(int n) {
        return this.list.get(n);
    }

    @Override
    public int hashCode() {
        return this.list.hashCode();
    }

    @Override
    public int indexOf(Object object) {
        return this.list.indexOf(object);
    }

    @Override
    public int lastIndexOf(Object object) {
        return this.list.lastIndexOf(object);
    }

    @Override
    public ListIterator listIterator() {
        return this.listIterator(0);
    }

    @Override
    public ListIterator listIterator(int n) {
        return new Collections$7(this, n);
    }

    @Override
    public Object remove(int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object set(int n, Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List subList(int n, int n2) {
        return new Collections$UnmodifiableList(this.list.subList(n, n2));
    }

    private Object readResolve() {
        if (this.list instanceof RandomAccess) {
            return new Collections$UnmodifiableRandomAccessList(this.list);
        }
        return this;
    }
}


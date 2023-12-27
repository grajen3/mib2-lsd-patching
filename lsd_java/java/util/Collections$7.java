/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.Collections$UnmodifiableList;
import java.util.ListIterator;

final class Collections$7
implements ListIterator {
    ListIterator iterator;
    final /* synthetic */ Collections$UnmodifiableList this$1;

    Collections$7(Collections$UnmodifiableList collections$UnmodifiableList, int n) {
        this.this$1 = collections$UnmodifiableList;
        this.iterator = collections$UnmodifiableList.list.listIterator(n);
    }

    @Override
    public void add(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override
    public boolean hasPrevious() {
        return this.iterator.hasPrevious();
    }

    @Override
    public Object next() {
        return this.iterator.next();
    }

    @Override
    public int nextIndex() {
        return this.iterator.nextIndex();
    }

    @Override
    public Object previous() {
        return this.iterator.previous();
    }

    @Override
    public int previousIndex() {
        return this.iterator.previousIndex();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void set(Object object) {
        throw new UnsupportedOperationException();
    }
}


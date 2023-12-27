/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

import edu.emory.mathcs.backport.java.util.Collections$CheckedList;
import java.util.ListIterator;

class Collections$CheckedList$ListItr
implements ListIterator {
    final ListIterator itr;
    private final /* synthetic */ Collections$CheckedList this$0;

    Collections$CheckedList$ListItr(Collections$CheckedList collections$CheckedList, ListIterator listIterator) {
        this.this$0 = collections$CheckedList;
        this.itr = listIterator;
    }

    @Override
    public boolean hasNext() {
        return this.itr.hasNext();
    }

    @Override
    public boolean hasPrevious() {
        return this.itr.hasPrevious();
    }

    @Override
    public int nextIndex() {
        return this.itr.nextIndex();
    }

    @Override
    public int previousIndex() {
        return this.itr.previousIndex();
    }

    @Override
    public Object next() {
        return this.itr.next();
    }

    @Override
    public Object previous() {
        return this.itr.previous();
    }

    @Override
    public void remove() {
        this.itr.remove();
    }

    @Override
    public void set(Object object) {
        this.this$0.typeCheck(object);
        this.itr.set(object);
    }

    @Override
    public void add(Object object) {
        this.this$0.typeCheck(object);
        this.itr.add(object);
    }
}


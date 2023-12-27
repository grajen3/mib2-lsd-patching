/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import de.vw.mib.collections.SortedList;
import java.util.ListIterator;

class SortedList$3
implements ListIterator {
    ListIterator backingIter;
    private final /* synthetic */ int val$location;
    private final /* synthetic */ SortedList this$0;

    SortedList$3(SortedList sortedList, int n) {
        this.this$0 = sortedList;
        this.val$location = n;
        this.backingIter = this.this$0.backingList.listIterator(this.val$location);
    }

    @Override
    public void set(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove() {
        this.backingIter.remove();
    }

    @Override
    public int previousIndex() {
        return this.backingIter.previousIndex();
    }

    @Override
    public Object previous() {
        return this.backingIter.previous();
    }

    @Override
    public int nextIndex() {
        return this.backingIter.nextIndex();
    }

    @Override
    public Object next() {
        return this.backingIter.next();
    }

    @Override
    public boolean hasPrevious() {
        return this.backingIter.hasPrevious();
    }

    @Override
    public boolean hasNext() {
        return this.backingIter.hasNext();
    }

    @Override
    public void add(Object object) {
        throw new UnsupportedOperationException();
    }
}


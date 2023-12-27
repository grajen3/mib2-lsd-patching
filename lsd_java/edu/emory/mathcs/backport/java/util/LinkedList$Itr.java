/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

import edu.emory.mathcs.backport.java.util.LinkedList;
import edu.emory.mathcs.backport.java.util.LinkedList$Entry;
import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.NoSuchElementException;

class LinkedList$Itr
implements ListIterator {
    int expectedModCount;
    int idx;
    LinkedList$Entry cursor;
    LinkedList$Entry lastRet;
    private final /* synthetic */ LinkedList this$0;

    LinkedList$Itr(LinkedList linkedList, LinkedList$Entry linkedList$Entry, int n) {
        this.this$0 = linkedList;
        this.cursor = linkedList$Entry;
        this.idx = n;
        this.expectedModCount = LinkedList.access$000(linkedList);
    }

    LinkedList$Itr(LinkedList linkedList) {
        this(linkedList, LinkedList.access$100((LinkedList)linkedList).next, 0);
    }

    @Override
    public boolean hasNext() {
        return this.cursor != LinkedList.access$100(this.this$0);
    }

    @Override
    public int nextIndex() {
        return this.idx;
    }

    @Override
    public boolean hasPrevious() {
        return this.cursor.prev != LinkedList.access$100(this.this$0);
    }

    @Override
    public int previousIndex() {
        return this.idx - 1;
    }

    @Override
    public Object next() {
        if (this.expectedModCount != LinkedList.access$000(this.this$0)) {
            throw new ConcurrentModificationException();
        }
        if (this.cursor == LinkedList.access$100(this.this$0)) {
            throw new NoSuchElementException();
        }
        this.lastRet = this.cursor;
        this.cursor = this.cursor.next;
        ++this.idx;
        return this.lastRet.val;
    }

    @Override
    public Object previous() {
        if (this.expectedModCount != LinkedList.access$000(this.this$0)) {
            throw new ConcurrentModificationException();
        }
        if (this.cursor.prev == LinkedList.access$100(this.this$0)) {
            throw new NoSuchElementException();
        }
        this.lastRet = this.cursor = this.cursor.prev;
        --this.idx;
        return this.lastRet.val;
    }

    @Override
    public void add(Object object) {
        if (this.expectedModCount != LinkedList.access$000(this.this$0)) {
            throw new ConcurrentModificationException();
        }
        LinkedList.access$200(this.this$0, this.cursor, object);
        this.lastRet = null;
        ++this.idx;
        ++this.expectedModCount;
    }

    @Override
    public void set(Object object) {
        if (this.lastRet == null) {
            throw new IllegalStateException();
        }
        this.lastRet.val = object;
    }

    @Override
    public void remove() {
        if (this.expectedModCount != LinkedList.access$000(this.this$0)) {
            throw new ConcurrentModificationException();
        }
        if (this.lastRet == null) {
            throw new IllegalStateException();
        }
        if (this.lastRet.next == this.cursor) {
            --this.idx;
        } else {
            this.cursor = this.lastRet.next;
        }
        LinkedList.access$300(this.this$0, this.lastRet);
        this.lastRet = null;
        ++this.expectedModCount;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

import edu.emory.mathcs.backport.java.util.ArrayDeque;
import edu.emory.mathcs.backport.java.util.ArrayDeque$1;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

class ArrayDeque$DescendingIterator
implements Iterator {
    private int cursor;
    private int fence;
    private int lastRet;
    private final /* synthetic */ ArrayDeque this$0;

    private ArrayDeque$DescendingIterator(ArrayDeque arrayDeque) {
        this.this$0 = arrayDeque;
        this.cursor = ArrayDeque.access$300(this.this$0);
        this.fence = ArrayDeque.access$200(this.this$0);
        this.lastRet = -1;
    }

    @Override
    public boolean hasNext() {
        return this.cursor != this.fence;
    }

    @Override
    public Object next() {
        if (this.cursor == this.fence) {
            throw new NoSuchElementException();
        }
        this.cursor = this.cursor - 1 & ArrayDeque.access$400(this.this$0).length - 1;
        Object object = ArrayDeque.access$400(this.this$0)[this.cursor];
        if (ArrayDeque.access$200(this.this$0) != this.fence || object == null) {
            throw new ConcurrentModificationException();
        }
        this.lastRet = this.cursor;
        return object;
    }

    @Override
    public void remove() {
        if (this.lastRet < 0) {
            throw new IllegalStateException();
        }
        if (!ArrayDeque.access$500(this.this$0, this.lastRet)) {
            this.cursor = this.cursor + 1 & ArrayDeque.access$400(this.this$0).length - 1;
            this.fence = ArrayDeque.access$200(this.this$0);
        }
        this.lastRet = -1;
    }

    /* synthetic */ ArrayDeque$DescendingIterator(ArrayDeque arrayDeque, ArrayDeque$1 arrayDeque$1) {
        this(arrayDeque);
    }
}


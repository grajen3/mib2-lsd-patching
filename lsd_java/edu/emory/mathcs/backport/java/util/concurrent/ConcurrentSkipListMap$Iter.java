/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentSkipListMap;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentSkipListMap$Node;
import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class ConcurrentSkipListMap$Iter
implements Iterator {
    ConcurrentSkipListMap$Node lastReturned;
    ConcurrentSkipListMap$Node next;
    Object nextValue;
    private final /* synthetic */ ConcurrentSkipListMap this$0;

    ConcurrentSkipListMap$Iter(ConcurrentSkipListMap concurrentSkipListMap) {
        block1: {
            Object object;
            this.this$0 = concurrentSkipListMap;
            do {
                this.next = concurrentSkipListMap.findFirst();
                if (this.next == null) break block1;
            } while ((object = this.next.value) == null || object == this.next);
            this.nextValue = object;
        }
    }

    @Override
    public final boolean hasNext() {
        return this.next != null;
    }

    final void advance() {
        block2: {
            Object object;
            if (this.next == null) {
                throw new NoSuchElementException();
            }
            this.lastReturned = this.next;
            do {
                this.next = this.next.next;
                if (this.next == null) break block2;
            } while ((object = this.next.value) == null || object == this.next);
            this.nextValue = object;
        }
    }

    @Override
    public void remove() {
        ConcurrentSkipListMap$Node concurrentSkipListMap$Node = this.lastReturned;
        if (concurrentSkipListMap$Node == null) {
            throw new IllegalStateException();
        }
        this.this$0.remove(concurrentSkipListMap$Node.key);
        this.lastReturned = null;
    }
}


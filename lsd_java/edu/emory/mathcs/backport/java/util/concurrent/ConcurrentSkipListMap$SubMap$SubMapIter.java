/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentSkipListMap$Node;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentSkipListMap$SubMap;
import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class ConcurrentSkipListMap$SubMap$SubMapIter
implements Iterator {
    ConcurrentSkipListMap$Node lastReturned;
    ConcurrentSkipListMap$Node next;
    Object nextValue;
    private final /* synthetic */ ConcurrentSkipListMap$SubMap this$0;

    ConcurrentSkipListMap$SubMap$SubMapIter(ConcurrentSkipListMap$SubMap concurrentSkipListMap$SubMap) {
        block3: {
            Object object;
            this.this$0 = concurrentSkipListMap$SubMap;
            do {
                ConcurrentSkipListMap$Node concurrentSkipListMap$Node = this.next = ConcurrentSkipListMap$SubMap.access$100(concurrentSkipListMap$SubMap) ? ConcurrentSkipListMap$SubMap.access$200(concurrentSkipListMap$SubMap) : ConcurrentSkipListMap$SubMap.access$300(concurrentSkipListMap$SubMap);
                if (this.next == null) break block3;
            } while ((object = this.next.value) == null || object == this.next);
            if (!ConcurrentSkipListMap$SubMap.access$400(concurrentSkipListMap$SubMap, this.next.key)) {
                this.next = null;
            } else {
                this.nextValue = object;
            }
        }
    }

    @Override
    public final boolean hasNext() {
        return this.next != null;
    }

    final void advance() {
        if (this.next == null) {
            throw new NoSuchElementException();
        }
        this.lastReturned = this.next;
        if (ConcurrentSkipListMap$SubMap.access$100(this.this$0)) {
            this.descend();
        } else {
            this.ascend();
        }
    }

    private void ascend() {
        block3: {
            Object object;
            do {
                this.next = this.next.next;
                if (this.next == null) break block3;
            } while ((object = this.next.value) == null || object == this.next);
            if (ConcurrentSkipListMap$SubMap.access$500(this.this$0, this.next.key)) {
                this.next = null;
            } else {
                this.nextValue = object;
            }
        }
    }

    private void descend() {
        block3: {
            Object object;
            do {
                this.next = ConcurrentSkipListMap$SubMap.access$600(this.this$0).findNear(this.lastReturned.key, 2);
                if (this.next == null) break block3;
            } while ((object = this.next.value) == null || object == this.next);
            if (ConcurrentSkipListMap$SubMap.access$700(this.this$0, this.next.key)) {
                this.next = null;
            } else {
                this.nextValue = object;
            }
        }
    }

    @Override
    public void remove() {
        ConcurrentSkipListMap$Node concurrentSkipListMap$Node = this.lastReturned;
        if (concurrentSkipListMap$Node == null) {
            throw new IllegalStateException();
        }
        ConcurrentSkipListMap$SubMap.access$600(this.this$0).remove(concurrentSkipListMap$Node.key);
        this.lastReturned = null;
    }
}


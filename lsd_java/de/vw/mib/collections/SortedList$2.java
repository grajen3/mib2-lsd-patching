/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import de.vw.mib.collections.SortedList;
import de.vw.mib.collections.SortedList$BidirectionalRingIterator;
import java.util.NoSuchElementException;

class SortedList$2
extends SortedList$BidirectionalRingIterator {
    int curr = -1;
    Object last = null;
    private final /* synthetic */ SortedList this$0;

    SortedList$2(SortedList sortedList) {
        this.this$0 = sortedList;
    }

    @Override
    public Object prev() {
        this.checkHasNext();
        this.checkLast();
        this.curr = this.curr <= 0 || this.curr >= this.this$0.size() ? this.this$0.size() - 1 : --this.curr;
        return this.getCurr();
    }

    @Override
    public Object next() {
        this.checkHasNext();
        this.checkLast();
        this.curr = this.curr < 0 || this.curr >= this.this$0.size() - 1 ? 0 : ++this.curr;
        return this.getCurr();
    }

    private void checkLast() {
        if (this.last == null) {
            return;
        }
        int n = this.this$0.size();
        if (this.curr < 0) {
            this.curr = 0;
        } else if (this.curr >= n) {
            this.curr = n - 1;
        }
        if (this.this$0.backingList.get(this.curr) == this.last) {
            return;
        }
        int n2 = (n + 1) / 2;
        int n3 = this.curr;
        int n4 = this.curr;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (++n3 >= n) {
                n3 = 0;
            }
            if (this.this$0.backingList.get(n3) == this.last) {
                this.curr = n3;
                return;
            }
            if (--n4 < 0) {
                n4 = n - 1;
            }
            if (this.this$0.backingList.get(n4) != this.last) continue;
            this.curr = n4;
            return;
        }
    }

    private Object getCurr() {
        this.last = this.this$0.backingList.get(this.curr);
        return this.last;
    }

    private void checkHasNext() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
    }

    @Override
    public boolean hasNext() {
        return this.this$0.backingList.size() > 0;
    }
}


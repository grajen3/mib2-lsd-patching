/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.AbstractList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

class AbstractList$SimpleListIterator
implements Iterator {
    int pos = -1;
    int expectedModCount;
    int lastPosition = -1;
    final /* synthetic */ AbstractList this$0;

    AbstractList$SimpleListIterator(AbstractList abstractList) {
        this.this$0 = abstractList;
        this.expectedModCount = abstractList.modCount;
    }

    @Override
    public boolean hasNext() {
        return this.pos + 1 < this.this$0.size();
    }

    @Override
    public Object next() {
        if (this.expectedModCount == this.this$0.modCount) {
            try {
                Object object = this.this$0.get(this.pos + 1);
                this.lastPosition = ++this.pos;
                return object;
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new NoSuchElementException();
            }
        }
        throw new ConcurrentModificationException();
    }

    @Override
    public void remove() {
        if (this.expectedModCount == this.this$0.modCount) {
            try {
                this.this$0.remove(this.lastPosition);
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new IllegalStateException();
            }
            if (this.this$0.modCount != this.expectedModCount) {
                ++this.expectedModCount;
            }
            if (this.pos == this.lastPosition) {
                --this.pos;
            }
        } else {
            throw new ConcurrentModificationException();
        }
        this.lastPosition = -1;
    }
}


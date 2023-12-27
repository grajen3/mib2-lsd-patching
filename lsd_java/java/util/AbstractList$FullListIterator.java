/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.AbstractList;
import java.util.AbstractList$SimpleListIterator;
import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.NoSuchElementException;

final class AbstractList$FullListIterator
extends AbstractList$SimpleListIterator
implements ListIterator {
    final /* synthetic */ AbstractList this$0;

    AbstractList$FullListIterator(AbstractList abstractList, int n) {
        super(abstractList);
        this.this$0 = abstractList;
        if (n < 0 || n > abstractList.size()) {
            throw new IndexOutOfBoundsException();
        }
        this.pos = n - 1;
    }

    @Override
    public void add(Object object) {
        if (this.expectedModCount == this.this$0.modCount) {
            try {
                this.this$0.add(this.pos + 1, object);
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new NoSuchElementException();
            }
            ++this.pos;
            this.lastPosition = -1;
            if (this.this$0.modCount != this.expectedModCount) {
                ++this.expectedModCount;
            }
        } else {
            throw new ConcurrentModificationException();
        }
    }

    @Override
    public boolean hasPrevious() {
        return this.pos >= 0;
    }

    @Override
    public int nextIndex() {
        return this.pos + 1;
    }

    @Override
    public Object previous() {
        if (this.expectedModCount == this.this$0.modCount) {
            try {
                Object object = this.this$0.get(this.pos);
                this.lastPosition = this.pos--;
                return object;
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new NoSuchElementException();
            }
        }
        throw new ConcurrentModificationException();
    }

    @Override
    public int previousIndex() {
        return this.pos;
    }

    @Override
    public void set(Object object) {
        if (this.expectedModCount == this.this$0.modCount) {
            try {
                this.this$0.set(this.lastPosition, object);
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new IllegalStateException();
            }
        } else {
            throw new ConcurrentModificationException();
        }
    }
}


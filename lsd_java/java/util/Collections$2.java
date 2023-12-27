/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.Collections$SingletonSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class Collections$2
implements Iterator {
    boolean hasNext = true;
    final /* synthetic */ Collections$SingletonSet this$1;

    Collections$2(Collections$SingletonSet collections$SingletonSet) {
        this.this$1 = collections$SingletonSet;
    }

    @Override
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override
    public Object next() {
        if (this.hasNext) {
            this.hasNext = false;
            return this.this$1.element;
        }
        throw new NoSuchElementException();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}


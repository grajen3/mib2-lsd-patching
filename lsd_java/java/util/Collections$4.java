/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.Collections$3;
import java.util.Collections$5;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class Collections$4
implements Iterator {
    boolean hasNext = true;
    final /* synthetic */ Collections$3 this$2;

    Collections$4(Collections$3 collections$3) {
        this.this$2 = collections$3;
    }

    @Override
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override
    public Object next() {
        if (this.hasNext) {
            this.hasNext = false;
            return new Collections$5(this);
        }
        throw new NoSuchElementException();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    static /* synthetic */ Collections$3 access$0(Collections$4 collections$4) {
        return collections$4.this$2;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.Collections$EmptySet;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class Collections$1
implements Iterator {
    final /* synthetic */ Collections$EmptySet this$1;

    Collections$1(Collections$EmptySet collections$EmptySet) {
        this.this$1 = collections$EmptySet;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        throw new NoSuchElementException();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}


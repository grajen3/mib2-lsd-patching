/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.Collections$UnmodifiableCollection;
import java.util.Iterator;

final class Collections$6
implements Iterator {
    Iterator iterator;
    final /* synthetic */ Collections$UnmodifiableCollection this$1;

    Collections$6(Collections$UnmodifiableCollection collections$UnmodifiableCollection) {
        this.this$1 = collections$UnmodifiableCollection;
        this.iterator = collections$UnmodifiableCollection.c.iterator();
    }

    @Override
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override
    public Object next() {
        return this.iterator.next();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}


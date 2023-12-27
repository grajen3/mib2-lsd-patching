/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.Collections$UnmodifiableMap$UnmodifiableEntrySet;
import java.util.Collections$UnmodifiableMap$UnmodifiableEntrySet$UnmodifiableMapEntry;
import java.util.Iterator;
import java.util.Map$Entry;

final class Collections$8
implements Iterator {
    Iterator iterator;
    final /* synthetic */ Collections$UnmodifiableMap$UnmodifiableEntrySet this$2;

    Collections$8(Collections$UnmodifiableMap$UnmodifiableEntrySet collections$UnmodifiableMap$UnmodifiableEntrySet) {
        this.this$2 = collections$UnmodifiableMap$UnmodifiableEntrySet;
        this.iterator = collections$UnmodifiableMap$UnmodifiableEntrySet.c.iterator();
    }

    @Override
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override
    public Object next() {
        return new Collections$UnmodifiableMap$UnmodifiableEntrySet$UnmodifiableMapEntry((Map$Entry)this.iterator.next());
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}


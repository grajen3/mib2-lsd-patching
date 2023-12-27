/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map$Entry;
import java.util.WeakHashMap;
import java.util.WeakHashMap$2;
import java.util.WeakHashMap$Entry;
import java.util.WeakHashMap$HashIterator;

final class WeakHashMap$1
extends AbstractSet {
    final /* synthetic */ WeakHashMap this$0;

    WeakHashMap$1(WeakHashMap weakHashMap) {
        this.this$0 = weakHashMap;
    }

    @Override
    public int size() {
        return this.this$0.size();
    }

    @Override
    public void clear() {
        this.this$0.clear();
    }

    @Override
    public boolean remove(Object object) {
        if (this.contains(object)) {
            this.this$0.remove(((Map$Entry)object).getKey());
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object object) {
        Object object2;
        WeakHashMap$Entry weakHashMap$Entry;
        if (object instanceof Map$Entry && (weakHashMap$Entry = this.this$0.getEntry(((Map$Entry)object).getKey())) != null && ((object2 = weakHashMap$Entry.get()) != null || weakHashMap$Entry.isNull)) {
            return object.equals(weakHashMap$Entry);
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return new WeakHashMap$HashIterator(this.this$0, new WeakHashMap$2(this));
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.WeakHashMap;
import java.util.WeakHashMap$6;
import java.util.WeakHashMap$HashIterator;

final class WeakHashMap$5
extends AbstractCollection {
    final /* synthetic */ WeakHashMap this$0;

    WeakHashMap$5(WeakHashMap weakHashMap) {
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
    public boolean contains(Object object) {
        return this.this$0.containsValue(object);
    }

    @Override
    public Iterator iterator() {
        return new WeakHashMap$HashIterator(this.this$0, new WeakHashMap$6(this));
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.WeakHashMap;
import java.util.WeakHashMap$4;
import java.util.WeakHashMap$HashIterator;

final class WeakHashMap$3
extends AbstractSet {
    final /* synthetic */ WeakHashMap this$0;

    WeakHashMap$3(WeakHashMap weakHashMap) {
        this.this$0 = weakHashMap;
    }

    @Override
    public boolean contains(Object object) {
        return this.this$0.containsKey(object);
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
        if (this.this$0.containsKey(object)) {
            this.this$0.remove(object);
            return true;
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return new WeakHashMap$HashIterator(this.this$0, new WeakHashMap$4(this));
    }
}


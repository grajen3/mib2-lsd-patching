/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.AbstractCollection;
import java.util.HashMap;
import java.util.HashMap$5;
import java.util.HashMap$HashMapIterator;
import java.util.Iterator;

final class HashMap$4
extends AbstractCollection {
    final /* synthetic */ HashMap this$0;

    HashMap$4(HashMap hashMap) {
        this.this$0 = hashMap;
    }

    @Override
    public boolean contains(Object object) {
        return this.this$0.containsValue(object);
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
    public Iterator iterator() {
        return new HashMap$HashMapIterator(new HashMap$5(this), this.this$0);
    }
}


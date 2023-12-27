/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.AbstractCollection;
import java.util.IdentityHashMap;
import java.util.IdentityHashMap$5;
import java.util.IdentityHashMap$IdentityHashMapIterator;
import java.util.Iterator;

final class IdentityHashMap$4
extends AbstractCollection {
    final /* synthetic */ IdentityHashMap this$0;

    IdentityHashMap$4(IdentityHashMap identityHashMap) {
        this.this$0 = identityHashMap;
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
        return new IdentityHashMap$IdentityHashMapIterator(new IdentityHashMap$5(this), this.this$0);
    }

    @Override
    public boolean remove(Object object) {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            if (object != iterator.next()) continue;
            iterator.remove();
            return true;
        }
        return false;
    }
}


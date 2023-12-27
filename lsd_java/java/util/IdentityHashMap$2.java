/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.AbstractSet;
import java.util.IdentityHashMap;
import java.util.IdentityHashMap$3;
import java.util.IdentityHashMap$IdentityHashMapIterator;
import java.util.Iterator;

final class IdentityHashMap$2
extends AbstractSet {
    final /* synthetic */ IdentityHashMap this$0;

    IdentityHashMap$2(IdentityHashMap identityHashMap) {
        this.this$0 = identityHashMap;
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
        return new IdentityHashMap$IdentityHashMapIterator(new IdentityHashMap$3(this), this.this$0);
    }
}


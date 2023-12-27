/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.AbstractSet;
import java.util.Collections$4;
import java.util.Collections$SingletonMap;
import java.util.Iterator;
import java.util.Map$Entry;

final class Collections$3
extends AbstractSet {
    final /* synthetic */ Collections$SingletonMap this$1;

    Collections$3(Collections$SingletonMap collections$SingletonMap) {
        this.this$1 = collections$SingletonMap;
    }

    @Override
    public boolean contains(Object object) {
        if (object instanceof Map$Entry) {
            Map$Entry map$Entry = (Map$Entry)object;
            return this.this$1.containsKey(map$Entry.getKey()) && this.this$1.containsValue(map$Entry.getValue());
        }
        return false;
    }

    @Override
    public int size() {
        return 1;
    }

    @Override
    public Iterator iterator() {
        return new Collections$4(this);
    }

    static /* synthetic */ Collections$SingletonMap access$0(Collections$3 collections$3) {
        return collections$3.this$1;
    }
}


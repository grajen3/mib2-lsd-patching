/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashMap$3;
import java.util.LinkedHashMap$LinkedHashIterator;
import java.util.MapEntry$Type;

final class LinkedHashMap$2
extends AbstractSet {
    final /* synthetic */ LinkedHashMap this$0;

    LinkedHashMap$2(LinkedHashMap linkedHashMap) {
        this.this$0 = linkedHashMap;
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
        return new LinkedHashMap$LinkedHashIterator((MapEntry$Type)new LinkedHashMap$3(this), this.this$0);
    }
}


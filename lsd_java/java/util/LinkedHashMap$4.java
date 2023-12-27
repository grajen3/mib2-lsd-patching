/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashMap$5;
import java.util.LinkedHashMap$LinkedHashIterator;
import java.util.MapEntry$Type;

final class LinkedHashMap$4
extends AbstractCollection {
    final /* synthetic */ LinkedHashMap this$0;

    LinkedHashMap$4(LinkedHashMap linkedHashMap) {
        this.this$0 = linkedHashMap;
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
        return new LinkedHashMap$LinkedHashIterator((MapEntry$Type)new LinkedHashMap$5(this), this.this$0);
    }
}


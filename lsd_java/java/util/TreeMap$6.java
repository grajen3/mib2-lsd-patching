/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map$Entry;
import java.util.TreeMap;
import java.util.TreeMap$7;
import java.util.TreeMap$TreeMapIterator;

final class TreeMap$6
extends AbstractSet {
    final /* synthetic */ TreeMap this$0;

    TreeMap$6(TreeMap treeMap) {
        this.this$0 = treeMap;
    }

    @Override
    public int size() {
        return this.this$0.size;
    }

    @Override
    public void clear() {
        this.this$0.clear();
    }

    @Override
    public boolean contains(Object object) {
        if (object instanceof Map$Entry) {
            Map$Entry map$Entry = (Map$Entry)object;
            Object object2 = this.this$0.get(map$Entry.getKey());
            Object object3 = map$Entry.getValue();
            return object2 == null ? object3 == null : object2.equals(object3);
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return new TreeMap$TreeMapIterator(this.this$0, new TreeMap$7(this));
    }
}


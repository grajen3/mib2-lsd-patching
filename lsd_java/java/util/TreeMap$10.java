/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeMap$11;
import java.util.TreeMap$TreeMapIterator;

final class TreeMap$10
extends AbstractCollection {
    final /* synthetic */ TreeMap this$0;

    TreeMap$10(TreeMap treeMap) {
        this.this$0 = treeMap;
    }

    @Override
    public boolean contains(Object object) {
        return this.this$0.containsValue(object);
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
    public Iterator iterator() {
        return new TreeMap$TreeMapIterator(this.this$0, new TreeMap$11(this));
    }
}


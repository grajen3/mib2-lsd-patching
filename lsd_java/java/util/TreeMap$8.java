/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeMap$9;
import java.util.TreeMap$TreeMapIterator;

final class TreeMap$8
extends AbstractSet {
    final /* synthetic */ TreeMap this$0;

    TreeMap$8(TreeMap treeMap) {
        this.this$0 = treeMap;
    }

    @Override
    public boolean contains(Object object) {
        return this.this$0.containsKey(object);
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
        return new TreeMap$TreeMapIterator(this.this$0, new TreeMap$9(this));
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.MapEntry$Type;
import java.util.TreeMap;
import java.util.TreeMap$SubMap;
import java.util.TreeMap$SubMap$SubMapSet;

final class TreeMap$4
extends TreeMap$SubMap$SubMapSet {
    final /* synthetic */ TreeMap$SubMap this$1;

    TreeMap$4(TreeMap$SubMap treeMap$SubMap, boolean bl, Object object, TreeMap treeMap, boolean bl2, Object object2, MapEntry$Type mapEntry$Type) {
        super(bl, object, treeMap, bl2, object2, mapEntry$Type);
        this.this$1 = treeMap$SubMap;
    }

    @Override
    public boolean contains(Object object) {
        return this.this$1.containsKey(object);
    }
}


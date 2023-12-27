/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.MapEntry;
import java.util.MapEntry$Type;
import java.util.TreeMap$SubMap;

final class TreeMap$1
implements MapEntry$Type {
    final /* synthetic */ TreeMap$SubMap this$1;

    TreeMap$1(TreeMap$SubMap treeMap$SubMap) {
        this.this$1 = treeMap$SubMap;
    }

    @Override
    public Object get(MapEntry mapEntry) {
        return mapEntry;
    }
}


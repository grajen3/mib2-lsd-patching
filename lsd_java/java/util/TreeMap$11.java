/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.MapEntry;
import java.util.MapEntry$Type;
import java.util.TreeMap$10;

final class TreeMap$11
implements MapEntry$Type {
    final /* synthetic */ TreeMap$10 this$1;

    TreeMap$11(TreeMap$10 treeMap$10) {
        this.this$1 = treeMap$10;
    }

    @Override
    public Object get(MapEntry mapEntry) {
        return mapEntry.value;
    }
}


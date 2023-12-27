/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.MapEntry;
import java.util.MapEntry$Type;
import java.util.TreeMap$8;

final class TreeMap$9
implements MapEntry$Type {
    final /* synthetic */ TreeMap$8 this$1;

    TreeMap$9(TreeMap$8 treeMap$8) {
        this.this$1 = treeMap$8;
    }

    @Override
    public Object get(MapEntry mapEntry) {
        return mapEntry.key;
    }
}


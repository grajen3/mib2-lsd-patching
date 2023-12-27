/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.LinkedHashMap$2;
import java.util.MapEntry;
import java.util.MapEntry$Type;

final class LinkedHashMap$3
implements MapEntry$Type {
    final /* synthetic */ LinkedHashMap$2 this$1;

    LinkedHashMap$3(LinkedHashMap$2 linkedHashMap$2) {
        this.this$1 = linkedHashMap$2;
    }

    @Override
    public Object get(MapEntry mapEntry) {
        return mapEntry.key;
    }
}


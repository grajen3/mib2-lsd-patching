/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.LinkedHashMap$4;
import java.util.MapEntry;
import java.util.MapEntry$Type;

final class LinkedHashMap$5
implements MapEntry$Type {
    final /* synthetic */ LinkedHashMap$4 this$1;

    LinkedHashMap$5(LinkedHashMap$4 linkedHashMap$4) {
        this.this$1 = linkedHashMap$4;
    }

    @Override
    public Object get(MapEntry mapEntry) {
        return mapEntry.value;
    }
}


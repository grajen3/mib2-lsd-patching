/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.LinkedHashMap$LinkedHashMapEntrySet;
import java.util.MapEntry;
import java.util.MapEntry$Type;

final class LinkedHashMap$1
implements MapEntry$Type {
    final /* synthetic */ LinkedHashMap$LinkedHashMapEntrySet this$1;

    LinkedHashMap$1(LinkedHashMap$LinkedHashMapEntrySet linkedHashMap$LinkedHashMapEntrySet) {
        this.this$1 = linkedHashMap$LinkedHashMapEntrySet;
    }

    @Override
    public Object get(MapEntry mapEntry) {
        return mapEntry;
    }
}


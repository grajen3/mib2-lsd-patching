/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.HashMap$HashMapEntrySet;
import java.util.MapEntry;
import java.util.MapEntry$Type;

final class HashMap$1
implements MapEntry$Type {
    final /* synthetic */ HashMap$HashMapEntrySet this$1;

    HashMap$1(HashMap$HashMapEntrySet hashMap$HashMapEntrySet) {
        this.this$1 = hashMap$HashMapEntrySet;
    }

    @Override
    public Object get(MapEntry mapEntry) {
        return mapEntry;
    }
}


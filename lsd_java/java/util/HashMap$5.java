/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.HashMap$4;
import java.util.MapEntry;
import java.util.MapEntry$Type;

final class HashMap$5
implements MapEntry$Type {
    final /* synthetic */ HashMap$4 this$1;

    HashMap$5(HashMap$4 hashMap$4) {
        this.this$1 = hashMap$4;
    }

    @Override
    public Object get(MapEntry mapEntry) {
        return mapEntry.value;
    }
}


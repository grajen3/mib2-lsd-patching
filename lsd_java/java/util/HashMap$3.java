/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.HashMap$2;
import java.util.MapEntry;
import java.util.MapEntry$Type;

final class HashMap$3
implements MapEntry$Type {
    final /* synthetic */ HashMap$2 this$1;

    HashMap$3(HashMap$2 hashMap$2) {
        this.this$1 = hashMap$2;
    }

    @Override
    public Object get(MapEntry mapEntry) {
        return mapEntry.key;
    }
}


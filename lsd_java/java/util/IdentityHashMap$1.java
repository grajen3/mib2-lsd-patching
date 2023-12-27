/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.IdentityHashMap$IdentityHashMapEntrySet;
import java.util.MapEntry;
import java.util.MapEntry$Type;

final class IdentityHashMap$1
implements MapEntry$Type {
    final /* synthetic */ IdentityHashMap$IdentityHashMapEntrySet this$1;

    IdentityHashMap$1(IdentityHashMap$IdentityHashMapEntrySet identityHashMap$IdentityHashMapEntrySet) {
        this.this$1 = identityHashMap$IdentityHashMapEntrySet;
    }

    @Override
    public Object get(MapEntry mapEntry) {
        return mapEntry;
    }
}


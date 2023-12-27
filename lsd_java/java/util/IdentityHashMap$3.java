/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.IdentityHashMap$2;
import java.util.MapEntry;
import java.util.MapEntry$Type;

final class IdentityHashMap$3
implements MapEntry$Type {
    final /* synthetic */ IdentityHashMap$2 this$1;

    IdentityHashMap$3(IdentityHashMap$2 identityHashMap$2) {
        this.this$1 = identityHashMap$2;
    }

    @Override
    public Object get(MapEntry mapEntry) {
        return mapEntry.key;
    }
}


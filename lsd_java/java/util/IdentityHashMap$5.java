/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.IdentityHashMap$4;
import java.util.MapEntry;
import java.util.MapEntry$Type;

final class IdentityHashMap$5
implements MapEntry$Type {
    final /* synthetic */ IdentityHashMap$4 this$1;

    IdentityHashMap$5(IdentityHashMap$4 identityHashMap$4) {
        this.this$1 = identityHashMap$4;
    }

    @Override
    public Object get(MapEntry mapEntry) {
        return mapEntry.value;
    }
}


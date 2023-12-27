/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.Map$Entry;
import java.util.WeakHashMap$3;
import java.util.WeakHashMap$Entry$Type;

final class WeakHashMap$4
implements WeakHashMap$Entry$Type {
    final /* synthetic */ WeakHashMap$3 this$1;

    WeakHashMap$4(WeakHashMap$3 weakHashMap$3) {
        this.this$1 = weakHashMap$3;
    }

    @Override
    public Object get(Map$Entry map$Entry) {
        return map$Entry.getKey();
    }
}


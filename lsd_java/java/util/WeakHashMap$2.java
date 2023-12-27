/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.Map$Entry;
import java.util.WeakHashMap$1;
import java.util.WeakHashMap$Entry$Type;

final class WeakHashMap$2
implements WeakHashMap$Entry$Type {
    final /* synthetic */ WeakHashMap$1 this$1;

    WeakHashMap$2(WeakHashMap$1 weakHashMap$1) {
        this.this$1 = weakHashMap$1;
    }

    @Override
    public Object get(Map$Entry map$Entry) {
        return map$Entry;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.Map$Entry;
import java.util.WeakHashMap$5;
import java.util.WeakHashMap$Entry$Type;

final class WeakHashMap$6
implements WeakHashMap$Entry$Type {
    final /* synthetic */ WeakHashMap$5 this$1;

    WeakHashMap$6(WeakHashMap$5 weakHashMap$5) {
        this.this$1 = weakHashMap$5;
    }

    @Override
    public Object get(Map$Entry map$Entry) {
        return map$Entry.getValue();
    }
}


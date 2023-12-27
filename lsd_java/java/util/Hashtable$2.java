/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.Hashtable$1;
import java.util.MapEntry;
import java.util.MapEntry$Type;

final class Hashtable$2
implements MapEntry$Type {
    final /* synthetic */ Hashtable$1 this$1;

    Hashtable$2(Hashtable$1 hashtable$1) {
        this.this$1 = hashtable$1;
    }

    @Override
    public Object get(MapEntry mapEntry) {
        return mapEntry;
    }
}


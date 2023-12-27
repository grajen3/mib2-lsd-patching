/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.Hashtable$3;
import java.util.MapEntry;
import java.util.MapEntry$Type;

final class Hashtable$4
implements MapEntry$Type {
    final /* synthetic */ Hashtable$3 this$1;

    Hashtable$4(Hashtable$3 hashtable$3) {
        this.this$1 = hashtable$3;
    }

    @Override
    public Object get(MapEntry mapEntry) {
        return mapEntry.key;
    }
}


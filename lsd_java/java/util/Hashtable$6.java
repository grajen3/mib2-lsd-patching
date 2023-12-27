/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.Hashtable$5;
import java.util.MapEntry;
import java.util.MapEntry$Type;

final class Hashtable$6
implements MapEntry$Type {
    final /* synthetic */ Hashtable$5 this$1;

    Hashtable$6(Hashtable$5 hashtable$5) {
        this.this$1 = hashtable$5;
    }

    @Override
    public Object get(MapEntry mapEntry) {
        return mapEntry.value;
    }
}


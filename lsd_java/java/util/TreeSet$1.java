/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.MapEntry;
import java.util.MapEntry$Type;

final class TreeSet$1
implements MapEntry$Type {
    TreeSet$1() {
    }

    @Override
    public Object get(MapEntry mapEntry) {
        return mapEntry.key;
    }
}


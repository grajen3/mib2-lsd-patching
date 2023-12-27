/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.HashMap$HashMapEntrySet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashMap$1;
import java.util.LinkedHashMap$LinkedHashIterator;
import java.util.MapEntry$Type;

final class LinkedHashMap$LinkedHashMapEntrySet
extends HashMap$HashMapEntrySet {
    public LinkedHashMap$LinkedHashMapEntrySet(LinkedHashMap linkedHashMap) {
        super(linkedHashMap);
    }

    @Override
    public Iterator iterator() {
        return new LinkedHashMap$LinkedHashIterator((MapEntry$Type)new LinkedHashMap$1(this), (LinkedHashMap)this.hashMap());
    }
}


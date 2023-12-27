/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.AbstractSet;
import java.util.HashMap;
import java.util.HashMap$1;
import java.util.HashMap$Entry;
import java.util.HashMap$HashMapIterator;
import java.util.Iterator;
import java.util.Map$Entry;

class HashMap$HashMapEntrySet
extends AbstractSet {
    private final HashMap associatedMap;

    public HashMap$HashMapEntrySet(HashMap hashMap) {
        this.associatedMap = hashMap;
    }

    HashMap hashMap() {
        return this.associatedMap;
    }

    @Override
    public int size() {
        return this.associatedMap.elementCount;
    }

    @Override
    public void clear() {
        this.associatedMap.clear();
    }

    @Override
    public boolean remove(Object object) {
        if (this.contains(object)) {
            this.associatedMap.remove(((Map$Entry)object).getKey());
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object object) {
        if (object instanceof Map$Entry) {
            HashMap$Entry hashMap$Entry = this.associatedMap.getEntry(((Map$Entry)object).getKey());
            return object.equals(hashMap$Entry);
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return new HashMap$HashMapIterator(new HashMap$1(this), this.associatedMap);
    }
}


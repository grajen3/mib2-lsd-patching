/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.AbstractSet;
import java.util.IdentityHashMap;
import java.util.IdentityHashMap$1;
import java.util.IdentityHashMap$IdentityHashMapEntry;
import java.util.IdentityHashMap$IdentityHashMapIterator;
import java.util.Iterator;
import java.util.Map$Entry;

class IdentityHashMap$IdentityHashMapEntrySet
extends AbstractSet {
    private final IdentityHashMap associatedMap;

    public IdentityHashMap$IdentityHashMapEntrySet(IdentityHashMap identityHashMap) {
        this.associatedMap = identityHashMap;
    }

    IdentityHashMap hashMap() {
        return this.associatedMap;
    }

    @Override
    public int size() {
        return this.associatedMap.size;
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
            IdentityHashMap$IdentityHashMapEntry identityHashMap$IdentityHashMapEntry = IdentityHashMap.access$1(this.associatedMap, ((Map$Entry)object).getKey());
            return identityHashMap$IdentityHashMapEntry != null && identityHashMap$IdentityHashMapEntry.equals(object);
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return new IdentityHashMap$IdentityHashMapIterator(new IdentityHashMap$1(this), this.associatedMap);
    }
}


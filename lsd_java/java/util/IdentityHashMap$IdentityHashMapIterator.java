/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.ConcurrentModificationException;
import java.util.IdentityHashMap;
import java.util.IdentityHashMap$IdentityHashMapEntry;
import java.util.Iterator;
import java.util.MapEntry$Type;
import java.util.NoSuchElementException;

class IdentityHashMap$IdentityHashMapIterator
implements Iterator {
    private int position = 0;
    private int lastPosition = 0;
    final IdentityHashMap associatedMap;
    int expectedModCount;
    final MapEntry$Type type;
    boolean canRemove = false;

    IdentityHashMap$IdentityHashMapIterator(MapEntry$Type mapEntry$Type, IdentityHashMap identityHashMap) {
        this.associatedMap = identityHashMap;
        this.type = mapEntry$Type;
        this.expectedModCount = identityHashMap.modCount;
    }

    @Override
    public boolean hasNext() {
        while (this.position < this.associatedMap.elementData.length) {
            if (this.associatedMap.elementData[this.position] == null) {
                this.position += 2;
                continue;
            }
            return true;
        }
        return false;
    }

    void checkConcurrentMod() {
        if (this.expectedModCount != this.associatedMap.modCount) {
            throw new ConcurrentModificationException();
        }
    }

    @Override
    public Object next() {
        this.checkConcurrentMod();
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        IdentityHashMap$IdentityHashMapEntry identityHashMap$IdentityHashMapEntry = IdentityHashMap.access$0(this.associatedMap, this.position);
        this.lastPosition = this.position;
        this.position += 2;
        this.canRemove = true;
        return this.type.get(identityHashMap$IdentityHashMapEntry);
    }

    @Override
    public void remove() {
        this.checkConcurrentMod();
        if (!this.canRemove) {
            throw new IllegalStateException();
        }
        this.canRemove = false;
        this.associatedMap.remove(this.associatedMap.elementData[this.lastPosition]);
        this.position = this.lastPosition;
        ++this.expectedModCount;
    }
}


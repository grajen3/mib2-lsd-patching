/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.HashMap$Entry;
import java.util.Iterator;
import java.util.MapEntry$Type;
import java.util.NoSuchElementException;

class HashMap$HashMapIterator
implements Iterator {
    private int position = 0;
    int expectedModCount;
    final MapEntry$Type type;
    boolean canRemove = false;
    HashMap$Entry entry;
    HashMap$Entry lastEntry;
    final HashMap associatedMap;

    HashMap$HashMapIterator(MapEntry$Type mapEntry$Type, HashMap hashMap) {
        this.associatedMap = hashMap;
        this.type = mapEntry$Type;
        this.expectedModCount = hashMap.modCount;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public boolean hasNext() {
        if (this.entry == null) ** GOTO lbl7
        return true;
lbl-1000:
        // 1 sources

        {
            if (this.associatedMap.elementData[this.position] == null) {
                ++this.position;
                continue;
            }
            return true;
lbl7:
            // 2 sources

            ** while (this.position < this.associatedMap.elementData.length)
        }
lbl8:
        // 1 sources

        return false;
    }

    void checkConcurrentMod() {
        if (this.expectedModCount != this.associatedMap.modCount) {
            throw new ConcurrentModificationException();
        }
    }

    @Override
    public Object next() {
        HashMap$Entry hashMap$Entry;
        this.checkConcurrentMod();
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        if (this.entry == null) {
            hashMap$Entry = this.lastEntry = this.associatedMap.elementData[this.position++];
            this.entry = this.lastEntry.next;
        } else {
            if (this.lastEntry.next != this.entry) {
                this.lastEntry = this.lastEntry.next;
            }
            hashMap$Entry = this.entry;
            this.entry = this.entry.next;
        }
        this.canRemove = true;
        return this.type.get(hashMap$Entry);
    }

    @Override
    public void remove() {
        this.checkConcurrentMod();
        if (!this.canRemove) {
            throw new IllegalStateException();
        }
        this.canRemove = false;
        ++this.associatedMap.modCount;
        if (this.lastEntry.next == this.entry) {
            while (this.associatedMap.elementData[--this.position] == null) {
            }
            this.associatedMap.elementData[this.position] = this.associatedMap.elementData[this.position].next;
            this.entry = null;
        } else {
            this.lastEntry.next = this.entry;
        }
        --this.associatedMap.elementCount;
        ++this.expectedModCount;
    }
}


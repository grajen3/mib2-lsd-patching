/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.HashMap$HashMapIterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashMap$LinkedHashMapEntry;
import java.util.MapEntry$Type;
import java.util.NoSuchElementException;

final class LinkedHashMap$LinkedHashIterator
extends HashMap$HashMapIterator {
    LinkedHashMap$LinkedHashIterator(MapEntry$Type mapEntry$Type, LinkedHashMap linkedHashMap) {
        super(mapEntry$Type, linkedHashMap);
        this.entry = LinkedHashMap.access$0(linkedHashMap);
    }

    @Override
    public boolean hasNext() {
        return this.entry != null;
    }

    @Override
    public Object next() {
        this.checkConcurrentMod();
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        Object object = this.type.get(this.entry);
        this.lastEntry = this.entry;
        this.entry = ((LinkedHashMap$LinkedHashMapEntry)this.entry).chainForward;
        this.canRemove = true;
        return object;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void remove() {
        block8: {
            this.checkConcurrentMod();
            if (!this.canRemove) {
                throw new IllegalStateException();
            }
            this.canRemove = false;
            ++this.associatedMap.modCount;
            var1_1 = this.associatedMap.getModuloHash(this.lastEntry.key);
            var2_2 = (LinkedHashMap$LinkedHashMapEntry)this.associatedMap.elementData[var1_1];
            if (var2_2 != this.lastEntry) ** GOTO lbl13
            this.associatedMap.elementData[var1_1] = this.lastEntry.next;
            break block8;
            while (var2_2.next != this.lastEntry) {
                var2_2 = (LinkedHashMap$LinkedHashMapEntry)var2_2.next;
lbl13:
                // 2 sources

                if (var2_2.next != null) continue;
            }
            var2_2.next = this.lastEntry.next;
        }
        var3_3 = (LinkedHashMap$LinkedHashMapEntry)this.lastEntry;
        var4_4 = var3_3.chainBackward;
        var5_5 = var3_3.chainForward;
        var6_6 = (LinkedHashMap)this.associatedMap;
        if (var4_4 != null) {
            var4_4.chainForward = var5_5;
            if (var5_5 != null) {
                var5_5.chainBackward = var4_4;
            } else {
                LinkedHashMap.access$1(var6_6, var4_4);
            }
        } else {
            LinkedHashMap.access$2(var6_6, var5_5);
            if (var5_5 != null) {
                var5_5.chainBackward = null;
            } else {
                LinkedHashMap.access$1(var6_6, null);
            }
        }
        --this.associatedMap.elementCount;
        ++this.expectedModCount;
    }
}


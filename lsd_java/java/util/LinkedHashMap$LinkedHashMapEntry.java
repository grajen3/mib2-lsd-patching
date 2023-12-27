/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.HashMap$Entry;

final class LinkedHashMap$LinkedHashMapEntry
extends HashMap$Entry {
    LinkedHashMap$LinkedHashMapEntry chainForward = null;
    LinkedHashMap$LinkedHashMapEntry chainBackward = null;

    LinkedHashMap$LinkedHashMapEntry(Object object, Object object2) {
        super(object, object2);
    }

    @Override
    public Object clone() {
        LinkedHashMap$LinkedHashMapEntry linkedHashMap$LinkedHashMapEntry = (LinkedHashMap$LinkedHashMapEntry)super.clone();
        linkedHashMap$LinkedHashMapEntry.chainBackward = this.chainBackward;
        linkedHashMap$LinkedHashMapEntry.chainForward = this.chainForward;
        LinkedHashMap$LinkedHashMapEntry linkedHashMap$LinkedHashMapEntry2 = (LinkedHashMap$LinkedHashMapEntry)linkedHashMap$LinkedHashMapEntry.next;
        if (linkedHashMap$LinkedHashMapEntry2 != null) {
            linkedHashMap$LinkedHashMapEntry.next = (LinkedHashMap$LinkedHashMapEntry)linkedHashMap$LinkedHashMapEntry2.clone();
        }
        return linkedHashMap$LinkedHashMapEntry;
    }
}


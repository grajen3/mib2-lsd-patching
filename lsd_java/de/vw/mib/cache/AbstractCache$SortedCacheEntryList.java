/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cache;

import de.vw.mib.cache.AbstractCache$Entry;
import de.vw.mib.collections.AbstractLinkedList;

final class AbstractCache$SortedCacheEntryList
extends AbstractLinkedList {
    public void add(AbstractCache$Entry abstractCache$Entry) {
        AbstractCache$Entry abstractCache$Entry2 = (AbstractCache$Entry)this.getFirst();
        if (abstractCache$Entry2 != null) {
            do {
                if (abstractCache$Entry2.compareTo(abstractCache$Entry) >= 0) continue;
                this.insert(abstractCache$Entry2, abstractCache$Entry);
                return;
            } while ((abstractCache$Entry2 = (AbstractCache$Entry)abstractCache$Entry2.next) != null);
        }
        this.addLast(abstractCache$Entry);
    }
}


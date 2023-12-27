/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.common.arrays;

import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.mqbpq.common.arrays.BAPArrayList$BAPArrayListElement;
import de.vw.mib.collections.ints.IntObjectOptHashMap;

public final class BAPArrayList$BAPArrayListIterator {
    private BAPArrayList$BAPArrayListElement currentElement;
    private IntObjectOptHashMap bapPosIDhashMap;
    private boolean forward;

    protected BAPArrayList$BAPArrayListIterator(BAPArrayList$BAPArrayListElement bAPArrayList$BAPArrayListElement, IntObjectOptHashMap intObjectOptHashMap, boolean bl) {
        this.currentElement = bAPArrayList$BAPArrayListElement;
        this.bapPosIDhashMap = intObjectOptHashMap;
        this.forward = bl;
    }

    public BAPArrayElement next() {
        return this.nextArrayListElement().listElement;
    }

    protected BAPArrayList$BAPArrayListElement nextArrayListElement() {
        BAPArrayList$BAPArrayListElement bAPArrayList$BAPArrayListElement = this.currentElement;
        this.currentElement = this.forward ? (BAPArrayList$BAPArrayListElement)this.bapPosIDhashMap.get(this.currentElement.nextBapPosID) : (BAPArrayList$BAPArrayListElement)this.bapPosIDhashMap.get(this.currentElement.prevBapPosID);
        return bAPArrayList$BAPArrayListElement;
    }

    protected BAPArrayList$BAPArrayListElement currentArrayListElement() {
        return this.currentElement;
    }

    public boolean hasNext() {
        return this.currentElement != null;
    }
}


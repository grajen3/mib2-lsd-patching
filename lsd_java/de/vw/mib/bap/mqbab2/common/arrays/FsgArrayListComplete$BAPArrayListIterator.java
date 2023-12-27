/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.arrays;

import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListComplete$BAPArrayListElement;
import de.vw.mib.collections.ints.IntObjectOptHashMap;

final class FsgArrayListComplete$BAPArrayListIterator {
    private FsgArrayListComplete$BAPArrayListElement currentElement;
    private IntObjectOptHashMap bapPosIDhashMap;
    private final boolean forward;

    protected FsgArrayListComplete$BAPArrayListIterator(FsgArrayListComplete$BAPArrayListElement fsgArrayListComplete$BAPArrayListElement, IntObjectOptHashMap intObjectOptHashMap, boolean bl) {
        this.currentElement = fsgArrayListComplete$BAPArrayListElement;
        this.bapPosIDhashMap = intObjectOptHashMap;
        this.forward = bl;
    }

    public BAPArrayElement next() {
        return this.nextArrayListElement().listElement;
    }

    protected FsgArrayListComplete$BAPArrayListElement nextArrayListElement() {
        FsgArrayListComplete$BAPArrayListElement fsgArrayListComplete$BAPArrayListElement = this.currentElement;
        this.currentElement = this.forward ? (FsgArrayListComplete$BAPArrayListElement)this.bapPosIDhashMap.get(this.currentElement.nextBapPosID) : (FsgArrayListComplete$BAPArrayListElement)this.bapPosIDhashMap.get(this.currentElement.prevBapPosID);
        return fsgArrayListComplete$BAPArrayListElement;
    }

    protected FsgArrayListComplete$BAPArrayListElement currentArrayListElement() {
        return this.currentElement;
    }

    public boolean hasNext() {
        return this.currentElement != null;
    }
}


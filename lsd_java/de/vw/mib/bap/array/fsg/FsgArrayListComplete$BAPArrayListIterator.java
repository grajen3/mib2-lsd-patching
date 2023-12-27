/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.array.fsg;

import de.vw.mib.bap.array.fsg.FsgArrayListComplete$BAPArrayListElement;
import de.vw.mib.bap.array.fsg.FsgArrayListIterator;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.collections.ints.IntObjectOptHashMap;

final class FsgArrayListComplete$BAPArrayListIterator
implements FsgArrayListIterator {
    private FsgArrayListComplete$BAPArrayListElement currentElement;
    private IntObjectOptHashMap bapPosIDhashMap;
    private final boolean forward;

    protected FsgArrayListComplete$BAPArrayListIterator(FsgArrayListComplete$BAPArrayListElement fsgArrayListComplete$BAPArrayListElement, IntObjectOptHashMap intObjectOptHashMap, boolean bl) {
        this.currentElement = fsgArrayListComplete$BAPArrayListElement;
        this.bapPosIDhashMap = intObjectOptHashMap;
        this.forward = bl;
    }

    @Override
    public BAPArrayElement next() {
        return this.nextArrayListElement().listElement;
    }

    @Override
    public FsgArrayListComplete$BAPArrayListElement nextArrayListElement() {
        FsgArrayListComplete$BAPArrayListElement fsgArrayListComplete$BAPArrayListElement = this.currentElement;
        this.currentElement = this.forward ? (FsgArrayListComplete$BAPArrayListElement)this.bapPosIDhashMap.get(this.currentElement.nextBapPosID) : (FsgArrayListComplete$BAPArrayListElement)this.bapPosIDhashMap.get(this.currentElement.prevBapPosID);
        return fsgArrayListComplete$BAPArrayListElement;
    }

    @Override
    public FsgArrayListComplete$BAPArrayListElement currentArrayListElement() {
        return this.currentElement;
    }

    @Override
    public boolean hasNext() {
        return this.currentElement != null;
    }
}


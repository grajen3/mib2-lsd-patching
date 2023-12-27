/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.array.fsg;

import de.vw.mib.bap.array.fsg.FsgArrayListComplete$BAPArrayListElement;
import de.vw.mib.bap.array.fsg.FsgArrayListComplete$BAPArrayListIterator;
import de.vw.mib.bap.array.fsg.FsgArrayListElementComparator;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import java.util.ArrayList;
import java.util.List;

public final class FsgArrayDeltaContext {
    private IntObjectOptHashMap bapPosIDhashMap;
    private FsgArrayListComplete$BAPArrayListElement firstElement;
    private FsgArrayListElementComparator comparator;
    private static final int TRACKED_ELEMENTS_INITIAL_SIZE;
    private List addedElements;
    private List removedElements;
    private List changedElements;

    FsgArrayDeltaContext(IntObjectOptHashMap intObjectOptHashMap, FsgArrayListComplete$BAPArrayListElement bAPArrayListElement, FsgArrayListElementComparator fsgArrayListElementComparator) {
        this.bapPosIDhashMap = intObjectOptHashMap;
        this.firstElement = bAPArrayListElement;
        this.comparator = fsgArrayListElementComparator;
        this.addedElements = new ArrayList(10);
        this.removedElements = new ArrayList(10);
        this.changedElements = new ArrayList(10);
    }

    FsgArrayListElementComparator getComparator() {
        return this.comparator;
    }

    List getAddedElements() {
        return this.addedElements;
    }

    List getRemovedElements() {
        return this.removedElements;
    }

    List getChangedElements() {
        return this.changedElements;
    }

    int getNextBAPIdOfElement(Object object) {
        FsgArrayListComplete$BAPArrayListElement fsgArrayListComplete$BAPArrayListElement = (FsgArrayListComplete$BAPArrayListElement)object;
        return fsgArrayListComplete$BAPArrayListElement.nextBapPosID;
    }

    int getPrevBAPIdOfElement(Object object) {
        FsgArrayListComplete$BAPArrayListElement fsgArrayListComplete$BAPArrayListElement = (FsgArrayListComplete$BAPArrayListElement)object;
        return fsgArrayListComplete$BAPArrayListElement.prevBapPosID;
    }

    int getBAPIdOfElement(Object object) {
        FsgArrayListComplete$BAPArrayListElement fsgArrayListComplete$BAPArrayListElement = (FsgArrayListComplete$BAPArrayListElement)object;
        return fsgArrayListComplete$BAPArrayListElement.bapPosID;
    }

    BAPArrayElement getBAPArrayElement(Object object) {
        FsgArrayListComplete$BAPArrayListElement fsgArrayListComplete$BAPArrayListElement = (FsgArrayListComplete$BAPArrayListElement)object;
        return fsgArrayListComplete$BAPArrayListElement.listElement;
    }

    FsgArrayListComplete$BAPArrayListIterator getIterator() {
        return new FsgArrayListComplete$BAPArrayListIterator(this.firstElement, this.bapPosIDhashMap, true);
    }

    boolean containsBapPosID(int n) {
        return this.bapPosIDhashMap.containsKey(n);
    }
}


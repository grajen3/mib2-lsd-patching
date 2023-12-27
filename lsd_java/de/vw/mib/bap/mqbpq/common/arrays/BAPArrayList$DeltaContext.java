/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.common.arrays;

import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.mqbpq.common.arrays.BAPArrayList$BAPArrayElementComparator;
import de.vw.mib.bap.mqbpq.common.arrays.BAPArrayList$BAPArrayListElement;
import de.vw.mib.bap.mqbpq.common.arrays.BAPArrayList$BAPArrayListIterator;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import java.util.ArrayList;
import java.util.List;

public final class BAPArrayList$DeltaContext {
    private IntObjectOptHashMap bapPosIDhashMap;
    private BAPArrayList$BAPArrayListElement firstElement;
    private BAPArrayList$BAPArrayElementComparator comparator;
    private static final int TRACKED_ELEMENTS_INITIAL_SIZE;
    private List addedElements;
    private List removedElements;
    private List changedElements;

    protected BAPArrayList$DeltaContext(IntObjectOptHashMap intObjectOptHashMap, BAPArrayList$BAPArrayListElement bAPArrayList$BAPArrayListElement, BAPArrayList$BAPArrayElementComparator bAPArrayList$BAPArrayElementComparator) {
        this.bapPosIDhashMap = intObjectOptHashMap;
        this.firstElement = bAPArrayList$BAPArrayListElement;
        this.comparator = bAPArrayList$BAPArrayElementComparator;
        this.addedElements = new ArrayList(10);
        this.removedElements = new ArrayList(10);
        this.changedElements = new ArrayList(10);
    }

    public BAPArrayList$BAPArrayElementComparator getComparator() {
        return this.comparator;
    }

    public List getAddedElements() {
        return this.addedElements;
    }

    public List getRemovedElements() {
        return this.removedElements;
    }

    public List getChangedElements() {
        return this.changedElements;
    }

    public int getNextBAPIdOfElement(Object object) {
        BAPArrayList$BAPArrayListElement bAPArrayList$BAPArrayListElement = (BAPArrayList$BAPArrayListElement)object;
        return bAPArrayList$BAPArrayListElement.nextBapPosID;
    }

    public int getPrevBAPIdOfElement(Object object) {
        BAPArrayList$BAPArrayListElement bAPArrayList$BAPArrayListElement = (BAPArrayList$BAPArrayListElement)object;
        return bAPArrayList$BAPArrayListElement.prevBapPosID;
    }

    public int getBAPIdOfElement(Object object) {
        BAPArrayList$BAPArrayListElement bAPArrayList$BAPArrayListElement = (BAPArrayList$BAPArrayListElement)object;
        return bAPArrayList$BAPArrayListElement.bapPosID;
    }

    public BAPArrayElement getBAPArrayElement(Object object) {
        BAPArrayList$BAPArrayListElement bAPArrayList$BAPArrayListElement = (BAPArrayList$BAPArrayListElement)object;
        return bAPArrayList$BAPArrayListElement.listElement;
    }

    protected BAPArrayList$BAPArrayListIterator getIterator() {
        return new BAPArrayList$BAPArrayListIterator(this.firstElement, this.bapPosIDhashMap, true);
    }

    protected boolean containsBapPosID(int n) {
        return this.bapPosIDhashMap.containsKey(n);
    }
}


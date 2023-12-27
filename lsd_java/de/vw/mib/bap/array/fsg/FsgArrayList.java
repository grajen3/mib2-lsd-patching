/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.array.fsg;

import de.vw.mib.bap.array.fsg.FsgArrayDeltaContext;
import de.vw.mib.bap.array.fsg.FsgArrayList$1;
import de.vw.mib.bap.array.fsg.FsgArrayListElementComparator;
import de.vw.mib.bap.array.fsg.FsgArrayListIdGenerator;
import de.vw.mib.bap.array.fsg.FsgArrayListIterator;
import de.vw.mib.bap.array.fsg.FsgArrayObjectId;
import de.vw.mib.bap.datatypes.BAPArrayElement;

public interface FsgArrayList {
    public static final int INVALID_INDEX_OF_POS;
    public static final int INVALID_BAP_POS_ID;
    public static final FsgArrayObjectId INVALID_OBJECT_ID;

    default public int firstBAPPosID() {
    }

    default public int lastBAPPosID() {
    }

    default public int previousBapPosID(int n) {
    }

    default public int nextBapPosID(int n) {
    }

    default public int nextBapPosID(int n, int n2) {
    }

    default public int getIndexOfBapPosId(int n) {
    }

    default public int numberOfElementsInDirection(int n, boolean bl, int n2) {
    }

    default public int getSize() {
    }

    default public FsgArrayListIdGenerator getIDGenerator() {
    }

    default public BAPArrayElement getElement(int n) {
    }

    default public int putElement(long l, BAPArrayElement bAPArrayElement, long l2) {
    }

    default public int putElement(long l, long l2, BAPArrayElement bAPArrayElement, long l3) {
    }

    default public FsgArrayListIterator getForwardIteratorStartingAt(int n) {
    }

    default public FsgArrayListIterator getBackwardIteratorStartingAt(int n) {
    }

    default public FsgArrayDeltaContext createNewDeltaContext(FsgArrayListElementComparator fsgArrayListElementComparator) {
    }

    static {
        INVALID_OBJECT_ID = new FsgArrayList$1();
    }
}


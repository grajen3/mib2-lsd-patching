/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.arrays;

import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayList$1;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListIdGenerator;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayObjectId;

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

    static {
        INVALID_OBJECT_ID = new FsgArrayList$1();
    }
}


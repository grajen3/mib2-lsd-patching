/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.array.fsg;

import de.vw.mib.bap.datatypes.BAPArrayElement;

public interface FsgArrayListElementComparator {
    public static final int ARRAYELEMENTCOMPARATOR_ELEMENTS_ARE_EQUAL;
    public static final int ARRAYELEMENTCOMPARATOR_NO_LAST_CHANGED_RECORD_ADDRESS;

    default public int compare(BAPArrayElement bAPArrayElement, BAPArrayElement bAPArrayElement2, int n) {
    }
}


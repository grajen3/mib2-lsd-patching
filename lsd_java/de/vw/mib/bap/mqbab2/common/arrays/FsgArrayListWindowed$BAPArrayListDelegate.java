/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.arrays;

import de.vw.mib.bap.array.requests.BAPGetArray;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListWindowed;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayPosIdIterator;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayRequestData;

public interface FsgArrayListWindowed$BAPArrayListDelegate {
    default public void getArrayAnswer(FsgArrayListWindowed fsgArrayListWindowed, FsgArrayPosIdIterator fsgArrayPosIdIterator, FsgArrayRequestData fsgArrayRequestData, int[] nArray, BAPGetArray bAPGetArray) {
    }

    default public void listWasChanged(FsgArrayListWindowed fsgArrayListWindowed) {
    }

    default public void listCacheCleared(FsgArrayListWindowed fsgArrayListWindowed) {
    }

    default public FsgArrayRequestData computeArrayRequestData(FsgArrayListWindowed fsgArrayListWindowed, BAPGetArray bAPGetArray) {
    }
}


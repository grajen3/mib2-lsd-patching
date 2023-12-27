/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.array.fsg;

import de.vw.mib.bap.array.fsg.FsgArrayListWindowed;
import de.vw.mib.bap.array.fsg.FsgArrayPosIdIterator;
import de.vw.mib.bap.array.fsg.FsgArrayRequestData;
import de.vw.mib.bap.array.requests.BAPGetArray;

public interface FSGArrayListDelegate {
    default public void getArrayAnswer(FsgArrayListWindowed fsgArrayListWindowed, FsgArrayPosIdIterator fsgArrayPosIdIterator, FsgArrayRequestData fsgArrayRequestData, int[] nArray, BAPGetArray bAPGetArray) {
    }

    default public void listWasChanged(FsgArrayListWindowed fsgArrayListWindowed) {
    }

    default public void listCacheCleared(FsgArrayListWindowed fsgArrayListWindowed) {
    }

    default public FsgArrayRequestData computeArrayRequestData(FsgArrayListWindowed fsgArrayListWindowed, BAPGetArray bAPGetArray) {
    }
}


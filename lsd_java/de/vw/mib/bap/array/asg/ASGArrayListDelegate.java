/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.array.asg;

import de.vw.mib.bap.array.asg.ASGArrayList;
import de.vw.mib.bap.array.logger.Logger;
import de.vw.mib.bap.array.requests.BAPGetArray;
import de.vw.mib.bap.array.requests.BAPSetGetArray;

public interface ASGArrayListDelegate {
    default public void requestGetArray(ASGArrayList aSGArrayList, BAPGetArray bAPGetArray) {
    }

    default public void requestSetGetArray(ASGArrayList aSGArrayList, BAPSetGetArray bAPSetGetArray) {
    }

    default public void requestTimeout(ASGArrayList aSGArrayList, int n, boolean bl) {
    }

    default public int getMaxRequestableElements(ASGArrayList aSGArrayList, int n) {
    }

    default public int getDefaultRecordAddress(ASGArrayList aSGArrayList) {
    }

    default public boolean continueLoading(ASGArrayList aSGArrayList) {
    }

    default public Logger getLogger(ASGArrayList aSGArrayList) {
    }
}


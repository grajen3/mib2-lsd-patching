/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.common.arrays;

import de.vw.mib.bap.array.requests.BAPStatusArray;
import de.vw.mib.bap.mqbpq.common.arrays.ArrayRequestData;
import de.vw.mib.bap.mqbpq.common.arrays.BAPWindowedArrayList;
import java.util.ArrayList;

public interface BAPWindowedArrayList$BAPArrayListDelegate {
    default public void getArrayAnswer(BAPWindowedArrayList bAPWindowedArrayList, ArrayRequestData arrayRequestData, ArrayList arrayList, BAPStatusArray bAPStatusArray) {
    }

    default public void listWasChanged(BAPWindowedArrayList bAPWindowedArrayList) {
    }
}


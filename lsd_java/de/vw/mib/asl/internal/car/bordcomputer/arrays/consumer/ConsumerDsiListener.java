/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.bordcomputer.arrays.consumer;

import org.dsi.ifc.careco.BCmEConsumerList;
import org.dsi.ifc.careco.BCmEListUpdateInfo;

public interface ConsumerDsiListener {
    default public void updateBCmEListUpdateInfo(BCmEListUpdateInfo bCmEListUpdateInfo, int n) {
    }

    default public void updateBCmEConsumerListTotalNumberOfElements(int n, int n2) {
    }

    default public void responseBCmEConsumerList(BCmEListUpdateInfo bCmEListUpdateInfo, BCmEConsumerList[] bCmEConsumerListArray) {
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.bordcomputer.arrays.consumerlistconsumption;

import org.dsi.ifc.careco.BCmEConsumerListConsumptionRA0;
import org.dsi.ifc.careco.BCmEConsumerListConsumptionRA1;
import org.dsi.ifc.careco.BCmEListUpdateInfo;

public interface ConsumerListConsuptionDsiListener {
    default public void updateBCmEConsumerListConsumptionUpdateInfo(BCmEListUpdateInfo bCmEListUpdateInfo, int n) {
    }

    default public void updateBCmEConsumerListConsumptionTotalNumberOfElements(int n, int n2) {
    }

    default public void responseBCmEConsumerListConsumptionRA0(BCmEListUpdateInfo bCmEListUpdateInfo, BCmEConsumerListConsumptionRA0[] bCmEConsumerListConsumptionRA0Array) {
    }

    default public void responseBCmEConsumerListConsumptionRA1(BCmEListUpdateInfo bCmEListUpdateInfo, BCmEConsumerListConsumptionRA1[] bCmEConsumerListConsumptionRA1Array) {
    }

    default public void responseBCmEConsumerListConsumptionRAF(BCmEListUpdateInfo bCmEListUpdateInfo, int[] nArray) {
    }
}


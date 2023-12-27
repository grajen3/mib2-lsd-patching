/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.navsd.functions;

import de.vw.mib.bap.mqbab2.generated.navsd.serializer.CurrentPositionInfo_Status;
import de.vw.mib.bap.mqbab2.navsd.functions.CurrentPositionInfo;

public class CurrentPositionInfoArabic
extends CurrentPositionInfo {
    @Override
    protected CurrentPositionInfo_Status computeCurrentPositionInfoStatus() {
        CurrentPositionInfo_Status currentPositionInfo_Status = super.computeCurrentPositionInfoStatus();
        if (currentPositionInfo_Status.positionInfo.isArabic()) {
            currentPositionInfo_Status.positionInfo.reset();
        }
        return currentPositionInfo_Status;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.navsd.functions;

import de.vw.mib.bap.mqbpq.generated.navsd.serializer.CurrentPositionInfo_Status;
import de.vw.mib.bap.mqbpq.navsd.functions.CurrentPositionInfo;

public final class CurrentPositionInfoArabic
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


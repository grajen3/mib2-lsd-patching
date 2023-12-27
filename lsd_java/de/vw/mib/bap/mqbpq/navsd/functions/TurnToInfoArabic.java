/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.navsd.functions;

import de.vw.mib.bap.mqbpq.generated.navsd.serializer.TurnToInfo_Status;
import de.vw.mib.bap.mqbpq.navsd.functions.TurnToInfo;

public final class TurnToInfoArabic
extends TurnToInfo {
    @Override
    protected void setTurnToInfoStatusData(TurnToInfo_Status turnToInfo_Status) {
        super.setTurnToInfoStatusData(turnToInfo_Status);
        if (turnToInfo_Status.turnToInfo.isArabic()) {
            turnToInfo_Status.turnToInfo.reset();
        }
    }
}


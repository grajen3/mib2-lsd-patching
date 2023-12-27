/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.navsd.functions;

import de.vw.mib.bap.mqbab2.generated.navsd.serializer.TurnToInfo_Status;
import de.vw.mib.bap.mqbab2.navsd.functions.TurnToInfo;

public class TurnToInfoArabic
extends TurnToInfo {
    @Override
    protected void setTurnToInfoStatusData(TurnToInfo_Status turnToInfo_Status) {
        super.setTurnToInfoStatusData(turnToInfo_Status);
        if (turnToInfo_Status.turnToInfo.isArabic()) {
            turnToInfo_Status.turnToInfo.reset();
        }
        if (turnToInfo_Status.signPost.isArabic()) {
            turnToInfo_Status.signPost.reset();
        }
    }
}


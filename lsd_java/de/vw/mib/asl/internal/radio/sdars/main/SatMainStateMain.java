/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.main;

import de.vw.mib.asl.internal.radio.sdars.database.IAslPoolRecord;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.asl.internal.radio.sdars.main.AbstractMainState;
import de.vw.mib.asl.internal.radio.sdars.main.SatMainTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.sdars.StationInfo;

final class SatMainStateMain
extends AbstractMainState {
    SatMainStateMain(SatDb satDb, SatMainTarget satMainTarget, Hsm hsm, HsmState hsmState) {
        super(satDb, satMainTarget, hsm, "stateMain", hsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.mPool.setString(39, this.getName());
                StationInfo stationInfo = this.mPool.getChannel(23);
                if (stationInfo == null) break;
                this.getMainChannelWalker().setCursor(stationInfo.stationNumber);
                break;
            }
            case 3: {
                this.mTarget.transStateMainIdle();
                break;
            }
            case 100014: {
                IAslPoolRecord iAslPoolRecord = (IAslPoolRecord)eventGeneric.getObject(0);
                int n = iAslPoolRecord.getInt();
                if (n == 0) {
                    this.mTarget.transStateMainNotFunctional();
                    break;
                }
                if (n != 1 || !this.mPool.getBoolean(64)) break;
                this.mTarget.transStateMainScan();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}


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

final class SatMainStateNotFunctional
extends AbstractMainState {
    SatMainStateNotFunctional(SatDb satDb, SatMainTarget satMainTarget, Hsm hsm, HsmState hsmState) {
        super(satDb, satMainTarget, hsm, "stateMainNoFunctional", hsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.mPool.setString(39, this.getName());
                this.mPool.setChannel(22, null);
                break;
            }
            case 100014: {
                IAslPoolRecord iAslPoolRecord = (IAslPoolRecord)eventGeneric.getObject(0);
                int n = iAslPoolRecord.getInt();
                if (n == 0) break;
                this.mTarget.transStateMainIdle();
                break;
            }
            case 1073743055: {
                this.getLogHandler().simpleTrace("No Scan while not functional");
                break;
            }
            case 0x40000470: {
                this.getLogHandler().simpleTrace("No Speller while not functional");
                break;
            }
            case 0x4000044C: 
            case 0x4000044E: 
            case 0x4000044F: 
            case 0x40000450: 
            case 1073742929: 
            case 1073742930: 
            case 1073742931: 
            case 1073742971: 
            case 1073742974: 
            case 1073744200: {
                this.getLogHandler().simpleTrace("No Tune while not functional");
                break;
            }
            case 4300068: 
            case 1073742947: {
                this.getLogHandler().simpleTrace("No Preview while not functional");
                break;
            }
            case 1073742949: {
                this.getLogHandler().simpleTrace("No View Mode Change while not functional");
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}


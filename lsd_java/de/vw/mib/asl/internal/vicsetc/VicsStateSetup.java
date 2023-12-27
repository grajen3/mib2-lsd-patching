/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.vicsetc;

import de.vw.mib.asl.internal.vicsetc.VicsTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class VicsStateSetup
extends AbstractHsmState {
    private final VicsTarget target;

    public VicsStateSetup(VicsTarget vicsTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = vicsTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.target.traceMsg("HSM_ENTRY - VicsStateSetup", this);
                break;
            }
            case 3: {
                this.target.traceMsg("HSM_START - VicsStateSetup", this);
                break;
            }
            case 4: {
                this.target.traceMsg("HSM_EXIT - VicsStateSetup", this);
                break;
            }
            case 1079341884: {
                this.target.stateMain.transStateMain();
                break;
            }
            case 1079341849: {
                this.target.setupHandler.handleToggleDrivingSupport();
                break;
            }
            case 1079341851: {
                this.target.setupHandler.handleToggleTrafficAnnouncement();
                break;
            }
            case 1079341850: {
                this.target.setupHandler.handleToggleTrafficInformation();
                break;
            }
            case 1079341833: {
                this.target.setupHandler.handleToggleDataUpload();
                break;
            }
            case 1079341848: {
                this.target.setupHandler.handleToggleBeaconGraphics();
                break;
            }
            case 1079341847: {
                this.target.setupHandler.handleToggleBeaconMessages();
                break;
            }
            case 1079341832: {
                this.target.setupHandler.handleToggleEventNoticeMap();
                break;
            }
            case 1079341852: {
                this.target.setupHandler.handleSetupPrefectureSelect(eventGeneric);
                break;
            }
            case 1079341853: {
                this.target.setupHandler.handleSetupDurationTimeSelect(eventGeneric);
                break;
            }
            case 1079341854: {
                this.target.setupHandler.handleSetupStationSelect(eventGeneric);
                break;
            }
            default: {
                this.target.traceMsg("default - VicsStateSetup", this);
                return this.myParent;
            }
        }
        return null;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.presets;

import de.vw.mib.asl.internal.phone.presets.HsmPhonePresetsHandling;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class StatePresetInit
extends AbstractHsmState {
    private final HsmPhonePresetsHandling target;

    public StatePresetInit(HsmPhonePresetsHandling hsmPhonePresetsHandling, GenericEvents genericEvents, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = hsmPhonePresetsHandling;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.target.init();
                this.target.dsiAdbSetup.setNotification(1, this.target.dsiAdbSetupListener);
                break;
            }
            case 1073744706: 
            case 1073744710: 
            case 1075141846: {
                this.target.spellerPresetNumber.handleEvent(eventGeneric);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void dsiAdbSetupUpdateAdbState(int n, int n2) {
        if (n == 2) {
            this.target.getSpeedDials();
            this.trans(this.target.statePresetHandling);
            this.target.dsiAdbUserProfile.setNotification(10, this.target.dsiAdbUserProfileListener);
        }
    }
}


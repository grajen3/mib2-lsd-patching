/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.radiotext2;

import de.vw.mib.asl.internal.radio.GuiApiTunerCommon;
import de.vw.mib.asl.internal.radio.dab.radiotext2.DabRadioTextTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

final class StateNoText
extends AbstractHsmState {
    private final DabRadioTextTarget mTarget;

    StateNoText(DabRadioTextTarget dabRadioTextTarget, HsmState hsmState) {
        super(dabRadioTextTarget.getHsm(), "NoText1", hsmState);
        this.mTarget = dabRadioTextTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.mTarget.trace("+++ RT State=", this.getName());
                GuiApiTunerCommon.setDabRadioTextLoadingStateToNotAvailable();
                this.mTarget.startTimer(109510912, (long)0, false);
                break;
            }
            case 4: {
                this.mTarget.stopTimer(109510912);
                break;
            }
            case 100102: 
            case 100106: {
                if (!this.mTarget.mRadioText.isRadioTextDirty()) break;
                this.mTarget.transStateTextAvailable1();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}


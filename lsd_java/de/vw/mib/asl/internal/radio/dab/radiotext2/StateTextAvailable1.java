/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.radiotext2;

import de.vw.mib.asl.internal.radio.GuiApiTunerCommon;
import de.vw.mib.asl.internal.radio.dab.radiotext2.DabRadioTextTarget;
import de.vw.mib.asl.internal.radio.dab.radiotext2.Events;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

final class StateTextAvailable1
extends AbstractHsmState {
    private final DabRadioTextTarget mTarget;

    StateTextAvailable1(DabRadioTextTarget dabRadioTextTarget, HsmState hsmState) {
        super(dabRadioTextTarget.getHsm(), "TextAvailable1", hsmState);
        this.mTarget = dabRadioTextTarget;
    }

    /*
     * Handled unverifiable bytecode (illegal stack merge).
     */
    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.mTarget.trace("+++ RT State=", this.getName());
                this.mTarget.mRadioText.updateHmi();
                GuiApiTunerCommon.setDabRadioTextLoadingStateToAvailable();
                this.mTarget.startTimer(126288128, Events.thresholdExceeded ? Events.thresholdTIMEOUT : (long)0, false);
                break;
            }
            case 4: {
                this.mTarget.stopTimer(126288128);
                break;
            }
            case 100103: {
                if (this.mTarget.mRadioText.isRadioTextDirty()) {
                    this.mTarget.mRadioText.updateHmi();
                    this.mTarget.startTimer(126288128, Events.thresholdExceeded ? Events.thresholdTIMEOUT : (long)0, false);
                    break;
                }
                this.mTarget.transStateTextAvailable2();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}


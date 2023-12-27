/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.radiotext2;

import de.vw.mib.asl.internal.radio.GuiApiTunerCommon;
import de.vw.mib.asl.internal.radio.dab.radiotext2.DabRadioTextTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

final class StateLoading1
extends AbstractHsmState {
    private final DabRadioTextTarget mTarget;

    StateLoading1(DabRadioTextTarget dabRadioTextTarget, HsmState hsmState) {
        super(dabRadioTextTarget.getHsm(), "Loading1", hsmState);
        this.mTarget = dabRadioTextTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.mTarget.trace("+++ RT State=", this.getName());
                GuiApiTunerCommon.setDabRadioTextLoadingStateToLoading();
                this.mTarget.startTimer(75956480, (long)0, false);
                break;
            }
            case 4: {
                this.mTarget.stopTimer(75956480);
                break;
            }
            case 100100: {
                if (this.mTarget.mRadioText.isRadioTextDirty()) {
                    this.mTarget.transStateTextAvailable1();
                    break;
                }
                this.mTarget.transStateLoading2();
                break;
            }
            case 100007: {
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}


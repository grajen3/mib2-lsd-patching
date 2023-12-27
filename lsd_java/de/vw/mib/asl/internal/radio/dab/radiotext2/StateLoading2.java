/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.radiotext2;

import de.vw.mib.asl.internal.radio.dab.radiotext2.DabRadioTextTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

final class StateLoading2
extends AbstractHsmState {
    private final DabRadioTextTarget mTarget;

    StateLoading2(DabRadioTextTarget dabRadioTextTarget, HsmState hsmState) {
        super(dabRadioTextTarget.getHsm(), "Loading2", hsmState);
        this.mTarget = dabRadioTextTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.mTarget.trace("+++ RT State=", this.getName());
                this.mTarget.startTimer(92733696, (long)0, false);
                break;
            }
            case 4: {
                this.mTarget.stopTimer(92733696);
                break;
            }
            case 100101: {
                if (this.mTarget.mRadioText.isRadioTextDirty()) {
                    this.mTarget.transStateTextAvailable1();
                    break;
                }
                this.mTarget.transStateNoText();
                break;
            }
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


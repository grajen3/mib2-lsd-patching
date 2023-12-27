/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.radiotext2;

import de.vw.mib.asl.internal.radio.dab.radiotext2.DabRadioTextTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

final class StateDABOff
extends AbstractHsmState {
    private final DabRadioTextTarget mTarget;

    StateDABOff(DabRadioTextTarget dabRadioTextTarget, HsmState hsmState) {
        super(dabRadioTextTarget.getHsm(), "DABOff", hsmState);
        this.mTarget = dabRadioTextTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.mTarget.trace("+++ RT State=", this.getName());
                break;
            }
            case 6: {
                this.mTarget.transStateDABOn();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}


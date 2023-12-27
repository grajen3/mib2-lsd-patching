/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.radiotext2;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.dab.radiotext2.DabRadioTextTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

final class StateTextAvailable2
extends AbstractHsmState {
    private final DabRadioTextTarget mTarget;

    StateTextAvailable2(DabRadioTextTarget dabRadioTextTarget, HsmState hsmState) {
        super(dabRadioTextTarget.getHsm(), "TextAvailable2", hsmState);
        this.mTarget = dabRadioTextTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.mTarget.trace("+++ RT State=", this.getName());
                if (!ServiceManager.configManagerDiag.getTUNERDABsupportsJumpLmBoolean()) break;
                this.mTarget.startTimer(143065344, (long)0, false);
                break;
            }
            case 4: {
                if (!ServiceManager.configManagerDiag.getTUNERDABsupportsJumpLmBoolean()) break;
                this.mTarget.stopTimer(143065344);
                break;
            }
            case 100105: {
                this.mTarget.trace("+++ RT SYNC LOST + 120");
                this.mTarget.mRadioText.clearAndUpdateRT();
                this.mTarget.transStateNoText();
                break;
            }
            case 100104: {
                this.mTarget.trace("+++ RT 300s no update");
                this.mTarget.mRadioText.clearAndUpdateRT();
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


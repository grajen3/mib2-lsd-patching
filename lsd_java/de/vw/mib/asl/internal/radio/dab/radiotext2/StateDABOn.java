/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.radiotext2;

import de.vw.mib.asl.internal.radio.dab.radiotext2.DabRadioTextTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

final class StateDABOn
extends AbstractHsmState {
    private final DabRadioTextTarget mTarget;

    StateDABOn(DabRadioTextTarget dabRadioTextTarget, HsmState hsmState) {
        super(dabRadioTextTarget.getHsm(), "DABOn", hsmState);
        this.mTarget = dabRadioTextTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.mTarget.trace("+++ RT State=", this.getName());
                if (this.mTarget.mRadioText.isRadioTextDirty()) {
                    this.mTarget.transStateTextAvailable1();
                    break;
                }
                this.mTarget.transStateLoading1();
                break;
            }
            case 7: {
                this.mTarget.transStateDABOff();
                break;
            }
            case 100005: {
                this.mTarget.trace("+++ RT Sync Lost");
                this.mTarget.startTimer(159842560, (long)0, false);
                this.mTarget.startTimer(193396992, (long)0, false);
                this.mTarget.mSyncAvailable = false;
                break;
            }
            case 100107: {
                this.mTarget.mRadioText.clearRTPlus();
                break;
            }
            case 100006: {
                this.mTarget.trace("+++ RT Sync Success");
                this.mTarget.stopTimer(159842560);
                this.mTarget.mSyncAvailable = true;
                break;
            }
            case 100007: {
                long l = eventGeneric.getLong(0);
                this.mTarget.stopTimer(193396992);
                if (l != 0L) {
                    this.mTarget.transStateLoading1();
                    break;
                }
                this.mTarget.transStateNoText();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}


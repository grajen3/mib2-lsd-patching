/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.radiotext;

import de.vw.mib.asl.internal.radio.amfm.radiotext.RadiotextTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

final class RadiotextStateWaitIdle
extends AbstractHsmState {
    private final RadiotextTarget mTarget;

    RadiotextStateWaitIdle(RadiotextTarget radiotextTarget, String string, HsmState hsmState) {
        super(radiotextTarget.getHsm(), string, hsmState);
        this.mTarget = radiotextTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.mTarget.startTimer(-1551499008, (long)0, false);
                break;
            }
            case 4: {
                this.mTarget.stopTimer(-1551499008);
                break;
            }
            case 100003: {
                this.mTarget.transNoneFreeze();
                break;
            }
            case 100006: {
                this.mTarget.transShowFreeze();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}


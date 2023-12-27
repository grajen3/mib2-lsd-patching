/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.radiotext2;

import de.vw.mib.asl.internal.radio.dab.radiotext2.DabRadioTextTarget;
import de.vw.mib.asl.internal.radio.dab.radiotext2.Events;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

final class StateTop
extends AbstractHsmState {
    private final DabRadioTextTarget mTarget;

    StateTop(DabRadioTextTarget dabRadioTextTarget, HsmState hsmState) {
        super(dabRadioTextTarget.getHsm(), "Top", hsmState);
        this.mTarget = dabRadioTextTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.mTarget.trace("+++ RT State=", this.getName());
                this.mTarget.transStateDABOff();
                break;
            }
            case 8: {
                this.mTarget.addObserver(-409190144);
                this.mTarget.addObserver(731726080);
                break;
            }
            case 9: {
                this.mTarget.removeObserver(-409190144);
                this.mTarget.removeObserver(731726080);
                break;
            }
            case 4300007: {
                Events.thresholdExceeded = eventGeneric.getBoolean(0);
                if (!this.mTarget.isTraceEnabled()) break;
                this.mTarget.trace(new StringBuffer().append("Threshold Exceeded = ").append(Events.thresholdExceeded).toString());
                break;
            }
            case 4300075: {
                int n = eventGeneric.getInt(0);
                if (n <= 0) break;
                Events.thresholdTIMEOUT = n * 1000;
                break;
            }
        }
        return hsmState;
    }
}


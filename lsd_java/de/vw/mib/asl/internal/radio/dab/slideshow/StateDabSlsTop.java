/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.slideshow;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.dab.slideshow.HsmDabSlsTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public final class StateDabSlsTop
extends AbstractHsmState {
    private final HsmDabSlsTarget mTarget;

    public StateDabSlsTop(HsmDabSlsTarget hsmDabSlsTarget, String string, HsmState hsmState) {
        super(hsmDabSlsTarget.getHsm(), string, hsmState);
        this.mTarget = hsmDabSlsTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger2.isTraceEnabled(256)) {
            ServiceManager.logger2.trace(256).append("StateDabSlsTop is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.trans(this.mTarget.stateDabSlsDabOff);
                break;
            }
            case 4300066: {
                if (this.mTarget.slsAllowed(eventGeneric)) break;
                this.trans(this.mTarget.stateDabSlsDiagOff);
                break;
            }
            case 4300065: {
                this.mTarget.mAboveLimit = eventGeneric.getBoolean(0);
                if (!this.mTarget.mAboveLimit) break;
                int n = this.mTarget.mDiagDuration2;
                super.getClass();
                if (n != -65536) break;
                this.trans(this.mTarget.stateDabSlsDiagOff);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}


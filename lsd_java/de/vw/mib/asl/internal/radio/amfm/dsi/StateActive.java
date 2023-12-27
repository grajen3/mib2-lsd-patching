/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.dsi;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.dsi.HsmAmFmDsi;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.Logger;

public final class StateActive
extends AbstractHsmState {
    private Logger logger = ServiceManager.logger;
    private final HsmAmFmDsi mTarget;

    StateActive(HsmAmFmDsi hsmAmFmDsi, String string, HsmState hsmState) {
        super(hsmAmFmDsi.getHsm(), string, hsmState);
        this.mTarget = hsmAmFmDsi;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.trans(this.mTarget.stateIdle);
                break;
            }
            case 4: {
                break;
            }
            case 100001: {
                this.trans(this.mTarget.stateInactive);
                this.mTarget.unregister();
                break;
            }
            case 101000: 
            case 101020: 
            case 101030: 
            case 101040: 
            case 101050: 
            case 101060: 
            case 101070: 
            case 101080: {
                this.mTarget.addEvent(eventGeneric);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void dsiAMFMTunerAsyncException(int n, String string, int n2) {
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_TUNER).append("[error]ASYNC:ErrorCode[").append(n).append("] Text:'").append(string).append("' RequestId[").append(n2).append("]").log();
        }
        this.trans(this.mTarget.stateIdle);
    }
}


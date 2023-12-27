/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.dsi;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.dsi.AmFmProxyHelper;
import de.vw.mib.asl.internal.radio.util.AbstractState;
import de.vw.mib.asl.internal.radio.util.StateMachineOwner;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.Logger;

public final class StateForceFmUpdate
extends AbstractState {
    private Logger logger = ServiceManager.logger;
    private static final long TIMEOUT;

    StateForceFmUpdate(StateMachineOwner stateMachineOwner, String string, HsmState hsmState) {
        super(stateMachineOwner, string, hsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.mOwner.getAmfmTuner().forceFMUpdate(1);
                break;
            }
            case 101071: {
                this.mOwner.getAmfmTuner().forceFMUpdate(2);
                break;
            }
            default: {
                hsmState = super.handle(eventGeneric);
            }
        }
        return hsmState;
    }

    @Override
    public long getTimeout() {
        return 0;
    }

    public void dsiAMFMTunerForceFMUpdateStatus(int n) {
        AmFmProxyHelper.forceFMUpdateStatus(this.mOwner.getTargetId(), n);
        if (n != 1) {
            this.getRequest().setResult(0);
            this.getRequest().setInt(0, n);
            if (this.logger.isTraceEnabled(128)) {
                this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_TUNER).append("force FM update status: ").append(n).log();
            }
            this.transitionToIdle();
        }
    }
}


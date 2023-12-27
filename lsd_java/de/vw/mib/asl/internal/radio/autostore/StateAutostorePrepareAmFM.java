/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.autostore;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.autostore.HsmTarget;
import de.vw.mib.asl.internal.radio.autostore.StateAutostoreDone;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.Logger;

final class StateAutostorePrepareAmFM
extends AbstractHsmState {
    private Logger logger = ServiceManager.logger;
    private final HsmTarget mTarget;

    StateAutostorePrepareAmFM(HsmTarget hsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.mTarget = hsmTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (this.logger.isTraceEnabled(256)) {
            this.logger.trace(256).append("StateAutostorePrepareAmFM - Event-ID:").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_AUTOSTORE).append("StateAutostorePrepareAmFM[HSM_ENTRY]").log();
                }
                StateAutostoreDone.suppressTuning = true;
                break;
            }
            case 3: {
                this.mTarget.prepareAmFmAutostore();
                break;
            }
            case 100101: {
                if (RadioData.getDabDatabase().getDabDeviceFitted()) {
                    this.trans(this.mTarget.stateAutostorePrepareDab);
                    break;
                }
                this.trans(this.mTarget.stateAutostoreAm);
                break;
            }
            case 4: {
                StateAutostoreDone.suppressTuning = false;
                if (!this.logger.isTraceEnabled(128)) break;
                this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_AUTOSTORE).append("StateAutostorePrepareAmFM[HSM_EXIT]").log();
                break;
            }
            case 4300053: 
            case 1073743062: {
                this.trans(this.mTarget.stateAutostoreAbort);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}


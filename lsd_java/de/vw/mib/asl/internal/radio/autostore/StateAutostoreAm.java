/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.autostore;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioCodingAdapter;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.dsi.AmFmDsiApi;
import de.vw.mib.asl.internal.radio.autostore.HsmTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.Logger;

final class StateAutostoreAm
extends AbstractHsmState {
    private Logger logger = ServiceManager.logger;
    private final HsmTarget mTarget;

    StateAutostoreAm(HsmTarget hsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.mTarget = hsmTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (this.logger.isTraceEnabled(256)) {
            this.logger.trace(256).append(RadioUtil.LOG_PREFIX_AMFM_AUTOSTORE).append("StateAutostoreAm - Event-ID:").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                if (!this.logger.isTraceEnabled(128)) break;
                this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_AUTOSTORE).append("StateAutostoreAm[HSM_ENTRY]").log();
                break;
            }
            case 3: {
                AmFmDsiApi.setSwitchLinkingDeviceUsageMode(2);
                if (RadioCodingAdapter.isAmDisabled()) {
                    this.trans(this.mTarget.stateAutostoreFm);
                    break;
                }
                AmFmDsiApi.doForceAmUpdate(this.mTarget.getTargetId(), 75956480);
                break;
            }
            case 100100: {
                if (eventGeneric.getInt(0) == 3) {
                    AmFmDsiApi.setSwitchLinkingDeviceUsageMode(1);
                    this.trans(this.mTarget.stateAutostoreAbort);
                    break;
                }
                this.trans(this.mTarget.stateAutostoreFm);
                break;
            }
            case 4300053: 
            case 1073743062: {
                AmFmDsiApi.abortAmUpdate(this.mTarget.getTargetId());
                break;
            }
            case 4: {
                if (!this.logger.isTraceEnabled(128)) break;
                this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_AUTOSTORE).append("StateAutostoreAm[HSM_EXIT]").log();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}


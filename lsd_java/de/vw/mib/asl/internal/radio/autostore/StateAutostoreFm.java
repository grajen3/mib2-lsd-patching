/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.autostore;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.dsi.AmFmDsiApi;
import de.vw.mib.asl.internal.radio.autostore.HsmTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.Logger;

final class StateAutostoreFm
extends AbstractHsmState {
    private final Logger logger = ServiceManager.logger;
    private final HsmTarget mTarget;

    StateAutostoreFm(HsmTarget hsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.mTarget = hsmTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (this.logger.isTraceEnabled(256)) {
            this.logger.trace(256).append("StateAutostoreFm - Event-ID:").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                break;
            }
            case 3: {
                AmFmDsiApi.doForceFmUpdate(this.mTarget.getTargetId(), 75956480);
                break;
            }
            case 100100: {
                if (eventGeneric.getInt(0) == 3) {
                    this.trans(this.mTarget.stateAutostoreAbort);
                    break;
                }
                if (RadioData.getDabDatabase().getDabDeviceFitted()) {
                    this.trans(this.mTarget.stateAutostoreDab);
                    break;
                }
                this.trans(this.mTarget.stateAutostoreDone);
                break;
            }
            case 4300053: 
            case 1073743062: {
                AmFmDsiApi.abortFmUpdate(this.mTarget.getTargetId());
                break;
            }
            case 4: {
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_AUTOSTORE).append("StateAutostoreFm[HSM_EXIT]").log();
                }
                AmFmDsiApi.setSwitchLinkingDeviceUsageMode(1);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}


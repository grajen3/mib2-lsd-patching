/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.autostore;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetApi;
import de.vw.mib.asl.internal.radio.appadapter.ApiAppAdapterGlobalSetupWizard;
import de.vw.mib.asl.internal.radio.autostore.HsmTarget;
import de.vw.mib.asl.internal.radio.autostore.StateAutostoreDone;
import de.vw.mib.asl.internal.radio.manager.RadioManagerApi;
import de.vw.mib.asl.internal.radio.util.RadioSystemEventsUtil;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.Logger;

final class StateAutostoreAbort
extends AbstractHsmState {
    private final HsmTarget mTarget;
    private Logger logger = ServiceManager.logger;

    StateAutostoreAbort(HsmTarget hsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.mTarget = hsmTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (this.logger.isTraceEnabled(256)) {
            this.logger.trace(256).append("StateAutostoreAbort - Event-ID:").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                break;
            }
            case 3: {
                this.mTarget.stopTimer(143065344);
                AmFmPresetApi.setBankIndex(1, this.mTarget.mCurrentBankIndex);
                RadioManagerApi.notifyAutostoreFinished(this.mTarget.mActiveTunerAtAbort);
                ApiAppAdapterGlobalSetupWizard.setPresetAutoStoreResult(1);
                this.trans(this.mTarget.stateAutostoreIdle);
                RadioSystemEventsUtil.sendAutoStoreCanceled();
                StateAutostoreDone.suppressTuning = false;
                HsmTarget.setTAStatus(false);
                break;
            }
            case 4300053: {
                break;
            }
            case 4: {
                if (!this.logger.isTraceEnabled(128)) break;
                this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_AUTOSTORE).append("StateAutostoreAbort[HSM_EXIT]").log();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}


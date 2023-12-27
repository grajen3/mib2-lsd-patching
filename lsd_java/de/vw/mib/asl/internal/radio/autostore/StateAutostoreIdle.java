/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.autostore;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetApi;
import de.vw.mib.asl.internal.radio.appadapter.ApiAppAdapterGlobalSetupWizard;
import de.vw.mib.asl.internal.radio.autostore.HsmTarget;
import de.vw.mib.asl.internal.radio.manager.RadioManagerApi;
import de.vw.mib.asl.internal.radio.util.RadioSystemEventsUtil;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.Logger;

final class StateAutostoreIdle
extends AbstractHsmState {
    private final HsmTarget mTarget;
    private Logger logger = ServiceManager.logger;

    StateAutostoreIdle(HsmTarget hsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.mTarget = hsmTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (this.logger.isTraceEnabled(256)) {
            this.logger.trace(256).append("StateAutostoreIdle - Event-ID:").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                break;
            }
            case 3: {
                break;
            }
            case 4: {
                break;
            }
            case 1073743054: {
                HsmTarget.setTAStatus(true);
                this.mTarget.mActiveTunerAtAbort = RadioCurrentWaveband.get();
                this.mTarget.mCurrentBankIndex = AmFmPresetApi.getBankIndex(1);
                AmFmPresetApi.setBankIndex(1, 0);
                RadioSystemEventsUtil.sendAutoStoreStarted();
                this.mTarget.startTimer(143065344, (long)0, false);
                RadioManagerApi.notifyAutostoreStarted();
                ApiAppAdapterGlobalSetupWizard.setPresetAutoStoreResult(2);
                this.trans(this.mTarget.stateAutostorePrepareAmFm);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}


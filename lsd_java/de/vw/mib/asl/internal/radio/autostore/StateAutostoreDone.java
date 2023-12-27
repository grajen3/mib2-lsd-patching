/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.autostore;

import de.vw.mib.asl.api.radio.ASLRadioTargetIds;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.amfm.AmFmFactory;
import de.vw.mib.asl.internal.radio.appadapter.ApiAppAdapterGlobalSetupWizard;
import de.vw.mib.asl.internal.radio.autostore.HsmTarget;
import de.vw.mib.asl.internal.radio.manager.RadioManagerApi;
import de.vw.mib.asl.internal.radio.util.RadioSystemEventsUtil;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.Logger;

public class StateAutostoreDone
extends AbstractHsmState {
    private final HsmTarget mTarget;
    private static boolean autoStoreDone = false;
    public static volatile boolean suppressTuning = false;
    private final Logger logger = ServiceManager.logger;

    StateAutostoreDone(HsmTarget hsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.mTarget = hsmTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (this.logger.isTraceEnabled(256)) {
            this.logger.trace(256).append("StateAutostoreDone - Event-ID:").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                if (this.mTarget.getTimerServer().isTimerActive(ASLRadioTargetIds.ASL_RADIO_HSMTARGET_AUTOSTORE, 143065344)) break;
                this.startAutoStore();
                break;
            }
            case 100104: {
                this.startAutoStore();
                break;
            }
            case 1073743062: {
                this.trans(this.mTarget.stateAutostoreAbort);
                break;
            }
            case 4: {
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    private void startAutoStore() {
        this.mTarget.doAutostore(this.mTarget.getTargetId());
        this.mTarget.setFirstStation();
        autoStoreDone = true;
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
            AmFmFactory.getAslAmfmModelController().updateLogoInStationView(null);
            RadioServiceManager.getServiceManager().getGuiBapApi().changeInFmHdStationLogosForKombi(null);
        }
        RadioManagerApi.notifyAutostoreFinished(1);
        HsmTarget.setTAStatus(false);
        ApiAppAdapterGlobalSetupWizard.setPresetAutoStoreResult(0);
        this.trans(this.mTarget.stateAutostoreIdle);
        RadioSystemEventsUtil.sendInitialAutoStoreFinished();
    }

    public static void setAutoStoreDone(boolean bl) {
        autoStoreDone = bl;
    }

    public static boolean getAutoStoreDone() {
        return autoStoreDone;
    }
}


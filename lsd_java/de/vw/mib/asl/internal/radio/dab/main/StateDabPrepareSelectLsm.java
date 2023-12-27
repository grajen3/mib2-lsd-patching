/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.main;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.dab.dsi.DabDsiApi;
import de.vw.mib.asl.internal.radio.dab.main.HsmTarget;
import de.vw.mib.asl.internal.radio.util.AudioConnectionUtils;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.ServiceInfo;

public final class StateDabPrepareSelectLsm
extends AbstractHsmState {
    private final HsmTarget mTarget;
    private boolean mIsFaded = false;

    public StateDabPrepareSelectLsm(HsmTarget hsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.mTarget = hsmTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger2.isTraceEnabled(256)) {
            ServiceManager.logger2.trace(256).append("StateDabPrepareSelectLsm is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                if (this.mTarget.isTunerAvailable()) {
                    this.mTarget.tuneLastService();
                    this.mTarget.startTimer(2072445184, (long)0, false);
                    this.mIsFaded = false;
                    break;
                }
                ServiceManager.logger.error(256).append("StateDabPrepareSelectLsm - DabTuner Not Available").log();
                this.mTarget.sendAnswer(0);
                break;
            }
            case 1028: {
                AudioConnectionUtils.requestFadeInForBand(RadioCurrentWaveband.get(), this.mTarget, 2089222400);
                this.mIsFaded = true;
                break;
            }
            case 101021: {
                EnsembleInfo ensembleInfo = (EnsembleInfo)eventGeneric.getObject(0);
                ServiceInfo serviceInfo = (ServiceInfo)eventGeneric.getObject(1);
                ComponentInfo componentInfo = (ComponentInfo)eventGeneric.getObject(2);
                this.mTarget.updateStationInfoLabels(ensembleInfo, serviceInfo, componentInfo);
                this.finishPrepareTuning();
                break;
            }
            case 101013: {
                this.finishPrepareTuning();
                break;
            }
            case 100219: {
                if (ServiceManager.logger2.isTraceEnabled(4)) {
                    ServiceManager.logger2.trace(4).append("Radio DAB PrepareTuning: no service is coming up so fade in!").log();
                }
                this.finishPrepareTuning();
                break;
            }
            case 100240: {
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    ServiceManager.logger.trace(256).append("StateDabPrepareSelectLsm - DEVICE_DEACTIVATE received").log();
                }
                if (!this.mTarget.isTunerAvailable()) {
                    eventGeneric.setInt(0, 2);
                    eventGeneric.setResult(0);
                    this.trans(this.mTarget.stateDabInactive);
                    break;
                }
                this.mTarget.setCurrentEvent(eventGeneric);
                DabDsiApi.abortSelectService();
                this.finishPrepareTuning();
                break;
            }
            case 1400006: {
                this.trans(this.mTarget.stateDabInactive);
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

    private void finishPrepareTuning() {
        if (this.mTarget.isDeactivated()) {
            this.trans(this.mTarget.stateDabDeactivate);
        } else if (this.mTarget.restoreAudio()) {
            this.trans(this.mTarget.stateDabPrepareAudio);
        } else {
            if (!this.mIsFaded) {
                AudioConnectionUtils.requestFadeInForBand(RadioCurrentWaveband.get(), this.mTarget, 2089222400);
            }
            this.mTarget.sendAnswer(0);
            this.trans(this.mTarget.stateDabActiveIdle);
        }
    }

    public HsmState dsiDABTunerUpdateAvailability(int n, int n2) {
        this.mTarget.getTextLogger().info(this.mTarget.getClassifier(), new StringBuffer().append("DabTuner:-UpdateAvailability in StateDabPrepareSelectLsm: ").append(n).toString());
        if (RadioData.getDabDatabase().getDabTunerAvailability() == 1 && n == 2) {
            if (this.mTarget.restoreAudio()) {
                this.trans(this.mTarget.stateDabPrepareAudio);
            } else {
                this.trans(this.mTarget.stateDabPrepareTuner);
            }
        } else if (n == 1 && this.mTarget.isDeactivated()) {
            this.mTarget.sendAnswer(0);
            this.trans(this.mTarget.stateDabInactive);
        }
        return this.myParent;
    }
}


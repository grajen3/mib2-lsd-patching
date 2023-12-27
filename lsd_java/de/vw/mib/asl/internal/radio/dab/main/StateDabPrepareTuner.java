/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.main;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioCodingAdapter;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.dab.dsi.DabDsiApi;
import de.vw.mib.asl.internal.radio.dab.main.HsmTarget;
import de.vw.mib.asl.internal.radio.tile.list.TileStationList;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public final class StateDabPrepareTuner
extends AbstractHsmState {
    private final HsmTarget mTarget;

    public StateDabPrepareTuner(HsmTarget hsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.mTarget = hsmTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger2.isTraceEnabled(256)) {
            ServiceManager.logger2.trace(256).append("StateDabPrepareTuner is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                if (this.mTarget.restoreAudio()) {
                    this.trans(this.mTarget.stateDabPrepareAudio);
                    break;
                }
                if (this.mTarget.isTunerAvailable()) {
                    DabDsiApi.activateTuner();
                    try {
                        TileStationList tileStationList;
                        if (!RadioCodingAdapter.isRadioTileFeatureActivated() || null == (tileStationList = RadioServiceManager.getServiceManager().getTileStationList())) break;
                        tileStationList.initTiles();
                    }
                    catch (Exception exception) {
                        ServiceManager.errorHandler.handleError(exception);
                    }
                    break;
                }
                if (this.mTarget.isTunerAvailable()) break;
                ServiceManager.logger.error(256).append("StateDabPrepareTuner - DabTuner Not Available").log();
                this.mTarget.sendAnswer(0);
                break;
            }
            case 101024: {
                if (this.mTarget.isDeactivated()) {
                    if (ServiceManager.logger.isTraceEnabled(256)) {
                        ServiceManager.logger.trace(256).append("StateDabPrepareTuner - Going to state stateDabDeactivate").log();
                    }
                    this.trans(this.mTarget.stateDabDeactivate);
                    break;
                }
                if (this.mTarget.restoreAudio()) {
                    this.trans(this.mTarget.stateDabPrepareAudio);
                    break;
                }
                this.trans(this.mTarget.stateDabPrepareSelectLSM);
                break;
            }
            case 1400006: {
                this.trans(this.mTarget.stateDabDeactivate);
                break;
            }
            case 100240: {
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    ServiceManager.logger.trace(256).append("StateDabPrepareTuner - DEVICE_DEACTIVATE received").log();
                }
                if (!this.mTarget.isTunerAvailable()) {
                    this.mTarget.setCurrentEvent(null);
                    eventGeneric.setInt(0, 2);
                    eventGeneric.setResult(0);
                    this.trans(this.mTarget.stateDabInactive);
                    break;
                }
                this.mTarget.setCurrentEvent(eventGeneric);
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

    public HsmState dsiDABTunerUpdateAvailability(int n, int n2) {
        this.mTarget.getTextLogger().info(this.mTarget.getClassifier(), new StringBuffer().append("DabTuner:-UpdateAvailability in StateDabPrepareTuner: ").append(n).toString());
        if (RadioData.getDabDatabase().getDabTunerAvailability() != 2 && n == 2) {
            if (this.mTarget.restoreAudio()) {
                this.trans(this.mTarget.stateDabPrepareAudio);
            } else {
                DabDsiApi.activateTuner();
            }
        } else if (n == 1 && this.mTarget.isDeactivated()) {
            this.mTarget.sendAnswer(0);
            this.trans(this.mTarget.stateDabInactive);
        }
        return this.myParent;
    }
}


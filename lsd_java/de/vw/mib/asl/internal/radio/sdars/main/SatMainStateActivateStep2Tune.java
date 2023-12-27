/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.main;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.sdars.helper.SatConfig;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.asl.internal.radio.sdars.main.AbstractMainState;
import de.vw.mib.asl.internal.radio.sdars.main.SatMainStateTop;
import de.vw.mib.asl.internal.radio.sdars.main.SatMainTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.sdars.StationInfo;

final class SatMainStateActivateStep2Tune
extends AbstractMainState {
    int timer = 5000;
    private StationInfo mLSM;
    private boolean entertainmentManagerCancelInTune = false;
    private boolean isDefaultChannelTunedAlready = false;

    SatMainStateActivateStep2Tune(SatDb satDb, SatMainTarget satMainTarget, Hsm hsm, HsmState hsmState) {
        super(satDb, satMainTarget, hsm, "stateActivate2", hsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.mTarget.setTuned(false);
                this.mPool.setString(39, this.getName());
                this.entertainmentManagerCancelInTune = false;
                break;
            }
            case 3: {
                SatDb.mLSMTuneFailed = false;
                this.mLSM = this.mDb.getTuneHandler().getLSM();
                if (SatMainStateTop.triggeredFromTopState) {
                    EventGeneric eventGeneric2 = this.mDb.newEvent();
                    eventGeneric2.setReceiverEventId(-1434058496);
                    eventGeneric2.setInt(2, SatDb.selectedStationStatus);
                    this.tuneLSMFeedback(eventGeneric2);
                    break;
                }
                int n = this.mTarget.getTargetId();
                boolean bl = this.mPool.getBoolean(5);
                if (bl) {
                    this.mDb.getModelApi().updateBapCurrentStationIndices(this.mLSM.getSID());
                    this.getTuneHandler().tuneChannel(3, this.mLSM, false, n, -1434058496);
                    this.mTarget.startTimer(-1266286336, (long)this.timer, false);
                    break;
                }
                SatDb.mLSMTuneFailed = true;
                this.mTarget.transStateActive();
                break;
            }
            case 4: {
                if (this.entertainmentManagerCancelInTune) {
                    EventGeneric eventGeneric3 = this.mDb.newEvent();
                    eventGeneric3.setBoolean(1652701952, true);
                    eventGeneric3.setInt(1669479168, RadioData.getAmfmDatabase().getSettingsPersistable().getWaveband());
                    this.mTarget.triggerObserver(1635924736, eventGeneric3);
                }
                SatMainStateTop.triggeredFromTopState = false;
                this.mTarget.stopTimer(-1266286336);
                break;
            }
            case 100010: {
                this.tuneLSMFeedback(eventGeneric);
                SatMainStateTop.triggeredFromTopState = false;
                break;
            }
            case 1400006: {
                this.entertainmentManagerCancelInTune = true;
                break;
            }
            case 100020: {
                this.mTarget.transActivate3();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void tuneLSMFeedback(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(2);
        if (this.entertainmentManagerCancelInTune) {
            if (ServiceManager.logger2.isTraceEnabled(4)) {
                ServiceManager.logger2.trace(4).append("Radio SDARS PrepareTuning: Tune failure!").log();
            }
            this.mTarget.transStateInactive();
        } else {
            int n2 = this.mTarget.getTargetId();
            if (n == 3 || n == 1) {
                this.mTarget.setTuned(true);
                this.mTarget.transActivate3();
            } else if (n == 5 && this.mLSM.getStationNumber() != 1 && !this.isDefaultChannelTunedAlready) {
                ServiceManager.logger.info(512).append("SatMainStateActivateStep2Tune: Subscription:").append(n).append("Default channel set").log();
                this.mLSM = SatConfig.DEFAULT_CHANNEL;
                this.isDefaultChannelTunedAlready = true;
                this.getTuneHandler().tuneChannel(2, this.mLSM, false, n2, -1434058496);
                this.mTarget.startTimer(-1266286336, (long)this.timer, false);
            } else {
                this.mTarget.transActivate3();
            }
        }
    }
}


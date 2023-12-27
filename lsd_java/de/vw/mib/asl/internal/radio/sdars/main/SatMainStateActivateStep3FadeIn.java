/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.main;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.asl.internal.radio.sdars.main.AbstractMainState;
import de.vw.mib.asl.internal.radio.sdars.main.SatMainStateTop;
import de.vw.mib.asl.internal.radio.sdars.main.SatMainTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

final class SatMainStateActivateStep3FadeIn
extends AbstractMainState {
    int timer = 5000;
    private boolean entertainmentManagerCancelInFadeIn = false;

    SatMainStateActivateStep3FadeIn(SatDb satDb, SatMainTarget satMainTarget, Hsm hsm, HsmState hsmState) {
        super(satDb, satMainTarget, hsm, "stateActivate3", hsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.mPool.setString(39, this.getName());
                this.entertainmentManagerCancelInFadeIn = false;
                break;
            }
            case 3: {
                if (SatMainStateTop.triggeredFromTopState) {
                    this.fadeInFeedback();
                    break;
                }
                EventGeneric eventGeneric2 = this.mPool.getEvent(44);
                if (eventGeneric2 != null) {
                    this.mPool.setString(45, "Deactivate in ActivateStep3.HSM_START");
                    this.mTarget.transStateInactive();
                    break;
                }
                if (this.mTarget.isAudioConnectionValid()) {
                    this.getLogHandler().simpleTrace("Request Fade In");
                    this.getAudioManager().requestFadeIn(this.mTarget, -1417281280);
                    this.mTarget.startTimer(-1266286336, (long)this.timer, false);
                    break;
                }
                this.mTarget.transStateActive();
                break;
            }
            case 4: {
                EventGeneric eventGeneric3 = this.mDb.newEvent();
                eventGeneric3.setBoolean(1652701952, true);
                eventGeneric3.setInt(1669479168, RadioData.getAmfmDatabase().getSettingsPersistable().getWaveband());
                this.mTarget.triggerObserver(1635924736, eventGeneric3);
                SatMainStateTop.triggeredFromTopState = false;
                this.mTarget.stopTimer(-1266286336);
                break;
            }
            case 1400006: {
                this.entertainmentManagerCancelInFadeIn = true;
                break;
            }
            case 100011: {
                this.fadeInFeedback();
                SatMainStateTop.triggeredFromTopState = false;
                break;
            }
            case 100020: {
                this.mTarget.transStateActive();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void fadeInFeedback() {
        if (this.entertainmentManagerCancelInFadeIn) {
            this.getLogHandler().simpleTrace("Radio SDARS Preparing fade in for Audio connection: Cancel requested by entertainment context!");
            this.mTarget.transStateInactive();
        } else {
            this.getAudioManager().setAudioAvailable(true);
            if (ServiceManager.logger2.isTraceEnabled(4)) {
                ServiceManager.logger2.trace(4).append("Radio SDARS PrepareTuning: got fade in -> activate tuner!").log();
            }
            this.mTarget.transStateActive();
        }
    }
}


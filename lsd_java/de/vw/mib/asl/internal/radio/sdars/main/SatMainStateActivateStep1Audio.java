/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.main;

import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.asl.internal.radio.sdars.main.AbstractMainState;
import de.vw.mib.asl.internal.radio.sdars.main.SatMainStateTop;
import de.vw.mib.asl.internal.radio.sdars.main.SatMainTarget;
import de.vw.mib.asl.internal.radio.util.AudioConnectionUtils;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

final class SatMainStateActivateStep1Audio
extends AbstractMainState {
    int timer = 5000;
    private boolean entertainmentManagerCancelInAudio = false;

    SatMainStateActivateStep1Audio(SatDb satDb, SatMainTarget satMainTarget, Hsm hsm, HsmState hsmState) {
        super(satDb, satMainTarget, hsm, "stateActivate1", hsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.mTarget.setAudioConnectionValid(false);
                this.mPool.setString(39, this.getName());
                this.entertainmentManagerCancelInAudio = false;
                break;
            }
            case 3: {
                if (SatMainStateTop.triggeredFromTopState) {
                    this.audioConnectionFeedback(eventGeneric);
                    break;
                }
                EventGeneric eventGeneric2 = this.mPool.getEvent(44);
                if (eventGeneric2 != null) {
                    this.mPool.setString(45, "Deactivate in ActivateStep2.HSM_START");
                    this.mTarget.transStateInactive();
                    break;
                }
                if (!this.mTarget.isAudioConnectionValid()) {
                    this.getLogHandler().simpleTrace("Request Audio Connection");
                    this.requestAudioConnection(-1568276224);
                    this.mTarget.startTimer(-1266286336, (long)this.timer, false);
                    break;
                }
                this.mTarget.transActivate3();
                break;
            }
            case 4: {
                if (this.entertainmentManagerCancelInAudio) {
                    EventGeneric eventGeneric3 = this.mDb.newEvent();
                    eventGeneric3.setBoolean(1652701952, true);
                    eventGeneric3.setInt(1669479168, RadioData.getAmfmDatabase().getSettingsPersistable().getWaveband());
                    this.mTarget.triggerObserver(1635924736, eventGeneric3);
                }
                SatMainStateTop.triggeredFromTopState = false;
                this.mTarget.stopTimer(-1266286336);
                break;
            }
            case 100002: {
                this.audioConnectionFeedback(eventGeneric);
                SatMainStateTop.triggeredFromTopState = false;
                break;
            }
            case 1400006: {
                this.entertainmentManagerCancelInAudio = true;
                break;
            }
            case 100020: {
                this.mTarget.transActivate2();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    private void requestAudioConnection(int n) {
        int n2 = AudioConnectionUtils.getCorrespondingAudioConnection(RadioCurrentWaveband.get());
        EventGeneric eventGeneric = this.mDb.newEvent();
        eventGeneric.setServiceId(34159872);
        eventGeneric.setInt(0, n2);
        eventGeneric.setBoolean(1, true);
        eventGeneric.setBoolean(2, true);
        eventGeneric.setSenderEventId(n);
        this.mTarget.send(eventGeneric);
    }

    public void audioConnectionFeedback(EventGeneric eventGeneric) {
        if (this.entertainmentManagerCancelInAudio) {
            this.getLogHandler().simpleTrace("Radio SDARS Preparing Audio connection: Cancel requested by entertainment context!");
            this.mTarget.transStateInactive();
        } else {
            if (eventGeneric.getResult() == 0) {
                this.mTarget.setAudioConnectionValid(true);
            }
            this.mPool.incInt(78);
            this.mTarget.transActivate2();
        }
    }
}


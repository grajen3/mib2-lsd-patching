/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.setup;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.phone.ASLPhoneData;
import de.vw.mib.asl.internal.phone.setup.HsmPhoneRingtoneHandling;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import generated.de.vw.mib.asl.internal.ListManager;

public class StatePhoneRingtoneInit
extends AbstractHsmState {
    private final HsmPhoneRingtoneHandling target;
    protected short selectedRingtone;

    public StatePhoneRingtoneInit(HsmPhoneRingtoneHandling hsmPhoneRingtoneHandling, GenericEvents genericEvents, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = hsmPhoneRingtoneHandling;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.target.init();
                this.target.setNotification();
                break;
            }
            case 3: {
                break;
            }
            case 1073742887: {
                EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(67714304);
                eventGeneric2.setInt(0, 87);
                this.target.ringtoneMenuConnectionSet = false;
                this.target.send(eventGeneric2);
                this.target.playEvent = null;
                this.target.stopAudioTriggerTimerIfActive();
                break;
            }
            case 1073742881: {
                int n = eventGeneric.getInt(0);
                Object[] objectArray = (Boolean[])ListManager.getGenericASLList(1244).getDSIObjects();
                objectArray[this.selectedRingtone] = Boolean.FALSE;
                objectArray[n] = Boolean.TRUE;
                this.selectedRingtone = (short)n;
                ListManager.getGenericASLList(1244).updateList(objectArray);
                this.target.dsiWavePlayer.setPlayTone(this.selectedRingtone);
                this.target.dsiPrimary.requestSetPhoneRingtone(n, "");
                break;
            }
            case 100400: {
                if (this.target.lastAudioTrigger != 1) break;
                this.target.dsiWavePlayer.audioTrigger(1);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void dsiMobileEquipmentUpdatePhoneRingtone(int n, String string, int n2) {
        Object[] objectArray = (Boolean[])ListManager.getGenericASLList(1244).getDSIObjects();
        objectArray[this.selectedRingtone] = Boolean.FALSE;
        this.selectedRingtone = n >= 0 && n < objectArray.length ? (short)n : this.selectedRingtone;
        objectArray[this.selectedRingtone] = Boolean.TRUE;
        ListManager.getGenericASLList(1244).updateList(objectArray);
        this.target.dsiWavePlayer.setPlayTone(this.selectedRingtone);
    }

    public void dsiWavePlayerUpdatePlayTone(int n, int n2) {
    }

    public void dsiWavePlayerUpdateAudioRequest(int n, int n2) {
        switch (n) {
            case 0: {
                this.trans(this.target.stateWaveplayerActive);
                break;
            }
            case 1: {
                this.trans(this.target.stateWaveplayerIdle);
                break;
            }
            default: {
                this.target.warn(new StringBuffer().append("PhoneRingtoneHandlingTop: Unexpected player state ").append(n).append("!").toString());
            }
        }
    }

    public void dsiWavePlayerAudioTriggerResponse(int n) {
        if (ASLPhoneData.getInstance().activePhoneAudioConnection == 98 || this.target.ringtoneMenuConnectionSet) {
            if (n == 7 && (this.target.getHsm().getState().equals(this.target.stateWaveplayerActive) || this.target.getHsm().getState().equals(this.target.stateWaveplayerTriggering))) {
                this.target.startTimer(814219520, (long)this.target.RESPONSE_AUDIOTRIGGER_TIMER, false);
            }
        } else if (!this.target.isStateActive(this.target.stateWaveplayerIdle)) {
            this.target.warn("dsiWavePlayerAudioTriggerResponse and no ringer outband connection active -> going to idle! audioMode=", n);
            this.target.dsiWavePlayer.audioTrigger(2);
            this.trans(this.target.stateWaveplayerIdle);
        }
    }
}


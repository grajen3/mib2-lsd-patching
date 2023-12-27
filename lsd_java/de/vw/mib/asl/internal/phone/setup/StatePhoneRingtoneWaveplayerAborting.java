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

public class StatePhoneRingtoneWaveplayerAborting
extends AbstractHsmState {
    private final HsmPhoneRingtoneHandling target;
    protected short selectedRingtone;
    private boolean receivedUpdateIdle = false;
    private boolean receivedResponseAborted = false;

    public StatePhoneRingtoneWaveplayerAborting(HsmPhoneRingtoneHandling hsmPhoneRingtoneHandling, GenericEvents genericEvents, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = hsmPhoneRingtoneHandling;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.receivedUpdateIdle = false;
                this.receivedResponseAborted = false;
                this.abortPlaying();
                break;
            }
            case 1073742879: {
                this.target.playEvent = ServiceManager.mGenericEventFactory.newEvent(eventGeneric);
                break;
            }
            case 3600005: {
                this.target.playEvent = ServiceManager.mGenericEventFactory.newEvent(eventGeneric);
                break;
            }
            case 1073742889: {
                this.abortPlaying();
                break;
            }
            case 4000015: {
                int n = eventGeneric.getInt(0);
                if (n != 87 || ASLPhoneData.getInstance().activePhoneAudioConnection == 98) break;
                this.target.ringtoneMenuConnectionSet = false;
                this.abortPlaying();
                break;
            }
            case 1073742888: {
                this.target.warn("PhoneRingtoneHandlingAborting: Received START_UP_RINGTONE. Unexpected HSM state! Emergency transition to idle!");
                this.receivedUpdateIdle = true;
                this.receivedResponseAborted = true;
                this.leaveState();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    private void abortPlaying() {
        if (this.target.isAudioTriggerTimerActive()) {
            this.target.stopAudioTriggerTimerIfActive();
            this.receivedUpdateIdle = true;
            this.receivedResponseAborted = true;
        }
        this.target.dsiWavePlayer.audioTrigger(2);
        this.target.lastAudioTrigger = 2;
        this.leaveState();
    }

    public void dsiWavePlayerUpdateAudioRequest(int n, int n2) {
        switch (n) {
            case 0: {
                break;
            }
            case 1: {
                this.receivedUpdateIdle = true;
                this.leaveState();
                break;
            }
            default: {
                this.target.warn(new StringBuffer().append("PhoneRingtoneHandlingAborting: Unexpected player state ").append(n).append("!").toString());
            }
        }
    }

    public HsmState dsiWavePlayerAudioTriggerResponse(int n) {
        if (n == 5 || n == 4 || n == 7) {
            this.receivedResponseAborted = true;
            this.leaveState();
            return null;
        }
        return this.myParent;
    }

    private void leaveState() {
        if (this.receivedResponseAborted && this.receivedUpdateIdle) {
            this.trans(this.target.stateWaveplayerIdle);
            if (this.target.playEvent != null) {
                this.target.send(this.target.playEvent);
                this.target.playEvent = null;
            }
        }
    }
}


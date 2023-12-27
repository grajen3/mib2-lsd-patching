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

public class StatePhoneRingtoneWaveplayerTriggering
extends AbstractHsmState {
    private final HsmPhoneRingtoneHandling target;
    protected short selectedRingtone;
    private boolean receivedUpdateActive = false;
    private boolean receivedResponseStarted = false;

    public StatePhoneRingtoneWaveplayerTriggering(HsmPhoneRingtoneHandling hsmPhoneRingtoneHandling, GenericEvents genericEvents, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = hsmPhoneRingtoneHandling;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.receivedUpdateActive = false;
                this.receivedResponseStarted = false;
                this.target.stopAudioTriggerTimerIfActive();
                this.target.dsiWavePlayer.audioTrigger(1);
                this.target.lastAudioTrigger = 1;
                break;
            }
            case 1073742879: {
                int n = eventGeneric.getInt(0);
                this.target.dsiWavePlayer.setPlayTone(n);
                this.target.playEvent = ServiceManager.mGenericEventFactory.newEvent(eventGeneric);
                this.trans(this.target.stateWaveplayerAborting);
                break;
            }
            case 3600005: {
                this.target.playEvent = ServiceManager.mGenericEventFactory.newEvent(eventGeneric);
                this.trans(this.target.stateWaveplayerAborting);
                break;
            }
            case 1073742889: {
                this.trans(this.target.stateWaveplayerAborting);
                break;
            }
            case 4000015: {
                int n = eventGeneric.getInt(0);
                if (n != 87 || ASLPhoneData.getInstance().activePhoneAudioConnection == 98) break;
                this.target.ringtoneMenuConnectionSet = false;
                this.trans(this.target.stateWaveplayerAborting);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void dsiWavePlayerUpdateAudioRequest(int n, int n2) {
        switch (n) {
            case 1: {
                break;
            }
            case 0: {
                this.receivedUpdateActive = true;
                this.leaveState();
                break;
            }
            default: {
                this.target.warn(new StringBuffer().append("PhoneRingtoneHandlingTriggering: Unexpected player state ").append(n).append("!").toString());
            }
        }
    }

    public HsmState dsiWavePlayerAudioTriggerResponse(int n) {
        if (n == 3 || n == 1 || n == 0) {
            this.receivedResponseStarted = true;
            this.leaveState();
            return null;
        }
        return this.myParent;
    }

    private HsmState leaveState() {
        if (this.receivedResponseStarted && this.receivedUpdateActive) {
            this.trans(this.target.stateWaveplayerActive);
            return null;
        }
        return this.myParent;
    }
}


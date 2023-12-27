/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.audio;

import de.vw.mib.asl.internal.navigation.guidance.audio.HsmTargetAudio;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class StateAudiomanagementNotAvailable
extends AbstractHsmState {
    private HsmTargetAudio target;

    StateAudiomanagementNotAvailable(HsmTargetAudio hsmTargetAudio, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = hsmTargetAudio;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.target.traceState(this, "HSM_ENTRY");
                break;
            }
            case 3: {
                this.target.traceState(this, "HSM_START");
                this.target.getDsiNavigation().requestAudioTrigger(2);
                break;
            }
            case 4: {
                this.target.traceState(this, "HSM_EXIT");
                break;
            }
            case 4000021: {
                this.target.traceState(this, "ASL_SOUND_AUDIOMNGMNT_STATUS");
                this.handleASLSoundAudioMNGMNTStatus(eventGeneric);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void dsiNavigationUpdateAudioRequest(int n, int n2) {
        this.target.traceState(this, "target.dsiNavigationUpdateAudioRequest");
        this.target.audioState = n;
        this.target.infoLogAudioState(this);
        switch (n) {
            case 1: {
                this.target.traceState(this, "AUDIOSTATE_ACTIVE");
                break;
            }
            case 4: {
                this.target.traceState(this, "AUDIOSTATE_ERROR");
                break;
            }
            case 2: {
                this.target.traceState(this, "AUDIOSTATE_IDLE");
                break;
            }
            case 3: {
                this.target.traceState(this, "AUDIOSTATE_REQUEST");
                this.target.getDsiNavigation().requestAudioTrigger(2);
                break;
            }
        }
    }

    void handleASLSoundAudioMNGMNTStatus(EventGeneric eventGeneric) {
        this.target.traceState(this, "handleASLSoundAudioMNGMNTStatus()");
        int n = eventGeneric.getInt(0);
        switch (n) {
            case 0: {
                this.target.traceState(this, "ASL_SOUND_AUDIOMNGMNT_STATUS_CO_UNAVAILABLE");
                break;
            }
            case 1: {
                this.target.traceState(this, "ASL_SOUND_AUDIOMNGMNT_STATUS_C1_AVAILABLE");
                this.trans(this.target.stateIdle);
                break;
            }
            case 2: {
                this.target.traceState(this, "ASL_SOUND_AUDIOMNGMNT_STATUS_C2_AVAILABLE_RESTORE_CONNECTIONS");
                this.trans(this.target.stateIdle);
                break;
            }
        }
    }
}


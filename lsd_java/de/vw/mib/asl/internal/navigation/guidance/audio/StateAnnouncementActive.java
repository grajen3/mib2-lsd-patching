/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.audio;

import de.vw.mib.asl.internal.navigation.guidance.audio.HsmTargetAudio;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class StateAnnouncementActive
extends AbstractHsmState {
    private HsmTargetAudio target;

    StateAnnouncementActive(HsmTargetAudio hsmTargetAudio, Hsm hsm, String string, HsmState hsmState) {
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
                this.target.getDsiNavigation().requestAudioTrigger(0);
                break;
            }
            case 4: {
                this.target.traceState(this, "HSM_EXIT");
                break;
            }
            case 1073742272: 
            case 1073742373: {
                this.target.traceState(this, "ASL_NAVIGATION_GUIDANCE_STOP_CURRENT_ANNOUNCEMENT");
                this.trans(this.target.stateStopAnnouncement);
                break;
            }
            case 0x40000224: {
                this.target.traceState(this, "STOP");
                if (!this.target.isRgActive) break;
                this.target.traceState(this, "rgActive=true -> Stop announcement");
                this.trans(this.target.stateStopAnnouncement);
                break;
            }
            case 4000015: {
                this.target.traceState(this, "ASL_SOUND_AUDIO_CONNECTION_RELEASED");
                this.handleASLSoundAudioConnectionReleased(eventGeneric);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    void handleASLSoundAudioConnectionReleased(EventGeneric eventGeneric) {
        this.target.traceState(this, "handleASLSoundAudioConnectionReleased()");
        int n = eventGeneric.getInt(0);
        if (n == 116 || n == 117) {
            this.target.traceState(this, "Audio connection released!");
            this.trans(this.target.stateAbortByAudioContext);
        }
    }

    public void dsiNavigationUpdateAudioRequest(int n, int n2) {
        this.target.traceState(this, "dsiNavigationUpdateAudioRequest()");
        this.target.audioState = n;
        this.target.infoLogAudioState(this);
        switch (n) {
            case 1: {
                this.target.traceState(this, "AUDIOSTATE_ACTIVE");
                break;
            }
            case 4: {
                this.target.traceState(this, "AUDIOSTATE_ERROR");
                this.trans(this.target.stateReleaseConnection);
                break;
            }
            case 2: {
                this.target.traceState(this, "AUDIOSTATE_IDLE");
                this.trans(this.target.stateReleaseConnection);
                break;
            }
            case 3: {
                this.target.traceState(this, "AUDIOSTATE_REQUEST");
                break;
            }
        }
    }
}


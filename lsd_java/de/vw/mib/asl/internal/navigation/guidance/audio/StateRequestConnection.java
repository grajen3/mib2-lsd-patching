/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.audio;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.guidance.PersistedGuidanceSetup;
import de.vw.mib.asl.internal.navigation.guidance.audio.HsmTargetAudio;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.LogMessage;

public class StateRequestConnection
extends AbstractHsmState {
    private HsmTargetAudio target;
    private boolean isStopped = false;

    StateRequestConnection(HsmTargetAudio hsmTargetAudio, Hsm hsm, String string, HsmState hsmState) {
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
                this.start();
                break;
            }
            case 4: {
                this.target.traceState(this, "HSM_EXIT");
                break;
            }
            case 100201: {
                this.target.traceState(this, "EV_ASL_INT_SOUND_SET_CONNECTION_RESULT");
                this.handleASLSoundSetConnectionResult(eventGeneric);
                break;
            }
            case 1073742272: 
            case 1073742373: {
                this.target.traceState(this, "ASL_NAVIGATION_GUIDANCE_STOP_CURRENT_ANNOUNCEMENT");
                this.isStopped = true;
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    private void start() {
        this.target.traceState(this, "start()");
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(34159872);
        eventGeneric.setSenderEventId(1770455296);
        this.isStopped = false;
        if (this.target.isRepeat) {
            this.target.isRepeat = false;
            this.target.connection = 116;
        } else {
            this.target.connection = PersistedGuidanceSetup.getInstance().isVoiceAnnouncementDuringPhoneCall() ? 116 : 117;
        }
        if (HsmTargetAudio.getLogger().isTraceEnabled()) {
            LogMessage logMessage = HsmTargetAudio.getLogger().makeTrace();
            logMessage.append("Navi Audio: Requesting connection with CL: ").append(this.target.connection);
            logMessage.log();
        }
        eventGeneric.setInt(0, this.target.connection);
        this.target.send(eventGeneric);
    }

    void handleASLSoundSetConnectionResult(EventGeneric eventGeneric) {
        this.target.traceState(this, "handleASLSoundSetConnectionResult");
        if (eventGeneric.getResult() == 0) {
            this.target.traceState(this, "Result==IdResult.OK");
            if (!this.isStopped) {
                this.target.traceState(this, "Trigger announcement!");
                this.trans(this.target.stateAnnouncementActive);
            } else {
                this.target.traceState(this, "Announcement has been stopped -> release connection");
                this.trans(this.target.stateReleaseConnection);
            }
        } else {
            HsmTargetAudio.getLogger().info("Aborting announcement due to invalid result in EV_ASL_INT_SOUND_SET_CONNECTION_RESULT.");
            this.trans(this.target.stateAbort);
        }
    }

    public void dsiNavigationUpdateAudioRequest(int n, int n2) {
        this.target.traceState(this, "dsiNavigationUpdateAudioRequest");
        this.target.audioState = n;
        this.target.infoLogAudioState(this);
        switch (this.target.audioState) {
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
                this.isStopped = true;
                break;
            }
            case 3: {
                this.target.traceState(this, "AUDIOSTATE_REQUEST");
                break;
            }
        }
    }
}


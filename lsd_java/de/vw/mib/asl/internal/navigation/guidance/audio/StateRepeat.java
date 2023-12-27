/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.audio;

import de.vw.mib.asl.internal.navigation.guidance.ASLNavGuidanceDP;
import de.vw.mib.asl.internal.navigation.guidance.PersistedGuidanceSetup;
import de.vw.mib.asl.internal.navigation.guidance.audio.HsmTargetAudio;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class StateRepeat
extends AbstractHsmState {
    private HsmTargetAudio target;
    private boolean isStopped;

    StateRepeat(HsmTargetAudio hsmTargetAudio, Hsm hsm, String string, HsmState hsmState) {
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

    void start() {
        this.target.traceState(this, "handleRepeatAnnouncement()");
        this.isStopped = false;
        if (!this.target.isRepeatAltRouteCalcAnnouncement) {
            this.target.traceState(this, "Trigger common repeat announcement");
            this.target.getDsiNavigation().afaRepeat(0);
            this.target.isRepeat = true;
        } else {
            this.target.traceState(this, "Trigger repeat announcement alternative route selection");
            this.target.getDsiNavigation().afaRepeat(3);
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
                break;
            }
            case 2: {
                this.target.traceState(this, "AUDIOSTATE_IDLE");
                break;
            }
            case 3: {
                this.target.traceState(this, "AUDIOSTATE_REQUEST");
                if (!this.isStopped && PersistedGuidanceSetup.getInstance().isSoundOn()) {
                    this.target.traceState(this, "Sound is on");
                    if (ASLNavGuidanceDP.getInstance().isVoicePromptRequired()) {
                        this.trans(this.target.stateRequestConnection);
                        break;
                    }
                    HsmTargetAudio.getLogger().info("One voice prompt was deactivated from Speech. Aborting request");
                    ASLNavGuidanceDP.getInstance().setVoicePromptRequired(true);
                    this.trans(this.target.stateAbort);
                    break;
                }
                HsmTargetAudio.getLogger().info("Sound is switched off or has been manually aborted. Aborting request.");
                this.trans(this.target.stateAbort);
                break;
            }
        }
    }
}


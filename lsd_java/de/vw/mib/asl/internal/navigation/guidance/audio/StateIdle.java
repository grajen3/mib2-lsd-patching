/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.audio;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.guidance.ASLNavGuidanceDP;
import de.vw.mib.asl.internal.navigation.guidance.PersistedGuidanceSetup;
import de.vw.mib.asl.internal.navigation.guidance.audio.HsmTargetAudio;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class StateIdle
extends AbstractHsmState {
    private HsmTargetAudio target;
    boolean isReleaseTriggered = false;

    StateIdle(HsmTargetAudio hsmTargetAudio, Hsm hsm, String string, HsmState hsmState) {
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
                ServiceManager.aslPropertyManager.valueChangedInteger(730, 0);
                this.target.traceState(this, "ASLNavigationBapListenerConstants.GUIDANCE_ANNOUNCEMENT_ACTIVE = Not active");
                this.target.connection = 0;
                if (!this.target.isTriggerAltRouteCalcAnnouncement) break;
                this.target.isTriggerAltRouteCalcAnnouncement = false;
                this.trans(this.target.stateRepeat);
                break;
            }
            case 4: {
                this.target.traceState(this, "HSM_EXIT");
                ServiceManager.aslPropertyManager.valueChangedInteger(730, 1);
                this.target.traceState(this, "ASLNavigationBapListenerConstants.GUIDANCE_ANNOUNCEMENT_ACTIVE = Active");
                break;
            }
            case 1073742271: 
            case 1073742352: {
                this.target.traceState(this, "REPEAT_LAST_ANNOUNCEMENT");
                this.trans(this.target.stateRepeat);
                break;
            }
            case 4000031: {
                this.target.traceState(this, "ASL_SOUND_ANNOUNCEMENT_CONNECTION_STARTED_UNREQUESTED");
                int n = eventGeneric.getInt(0);
                if (n != 117 && n != 116) break;
                this.target.traceState(this, "ASL_SOUND_ANNOUNCEMENT_CONNECTION_STARTED_UNREQUESTED");
                this.trans(this.target.stateRepeat);
                break;
            }
            case 100100: {
                this.target.traceState(this, "EV_ASL_INT_ALTERNATIVE_RC_SELECTROUTE_ANNOUNCEMENT_ON");
                this.target.isRepeatAltRouteCalcAnnouncement = true;
                this.trans(this.target.stateRepeat);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
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
                if (PersistedGuidanceSetup.getInstance().isSoundOn()) {
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
                HsmTargetAudio.getLogger().info("Sound is switched off. Aborting request.");
                this.trans(this.target.stateAbort);
                break;
            }
        }
    }
}


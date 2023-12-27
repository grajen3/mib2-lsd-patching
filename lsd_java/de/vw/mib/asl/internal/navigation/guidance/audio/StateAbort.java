/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.audio;

import de.vw.mib.asl.internal.navigation.guidance.audio.HsmTargetAudio;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class StateAbort
extends AbstractHsmState {
    private HsmTargetAudio target;

    StateAbort(HsmTargetAudio hsmTargetAudio, Hsm hsm, String string, HsmState hsmState) {
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
                if (this.target.audioState != 2) break;
                this.target.traceState(this, "Audio state already idle -> do not wait for updateAudioRequest");
                this.trans(this.target.stateIdle);
                break;
            }
            case 4: {
                this.target.traceState(this, "HSM_EXIT");
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void dsiNavigationUpdateAudioRequest(int n, int n2) {
        this.target.traceState(this, "dsiNavigationUpdateAudioRequest");
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
                this.trans(this.target.stateIdle);
                break;
            }
            case 3: {
                this.target.traceState(this, "AUDIOSTATE_REQUEST");
                break;
            }
        }
    }
}


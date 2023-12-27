/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.audio;

import de.vw.mib.asl.internal.navigation.guidance.audio.AudioUtils;
import de.vw.mib.asl.internal.navigation.guidance.audio.HsmTargetAudio;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class StateDSINotAvailable
extends AbstractHsmState {
    private final HsmTargetAudio target;

    StateDSINotAvailable(HsmTargetAudio hsmTargetAudio, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = hsmTargetAudio;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.target.traceState(this, "HSM_START");
                AudioUtils.releaseAudioConnection(this.target, this);
                break;
            }
            case 4000015: {
                this.target.traceState(this, "ASL_SOUND_AUDIO_CONNECTION_RELEASED");
                AudioUtils.handleASLSoundAudioConnectionReleased(this.target, this, eventGeneric, this.target.stateIdle);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.sound;

import de.vw.mib.asl.internal.sound.HsmSoundWaveplayerHandling;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class HsmSoundWaveplayerHandling$StateWaveplayerHandlingAborting
extends AbstractHsmState {
    EventGeneric playEvent;
    private HsmSoundWaveplayerHandling target;
    private final /* synthetic */ HsmSoundWaveplayerHandling this$0;

    public HsmSoundWaveplayerHandling$StateWaveplayerHandlingAborting(HsmSoundWaveplayerHandling hsmSoundWaveplayerHandling, Hsm hsm, String string, HsmState hsmState) {
        this.this$0 = hsmSoundWaveplayerHandling;
        super(hsm, string, hsmState);
        this.playEvent = null;
        this.target = this.this$0;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.abortPlaying();
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
            case 0: {
                break;
            }
            case 1: {
                this.trans(this.this$0.stateWaveplayerIdle);
                if (this.playEvent == null) break;
                this.this$0.send(this.playEvent);
                this.playEvent = null;
                break;
            }
            default: {
                this.this$0.warn(new StringBuffer().append("SoundWaveplayerHandlingAborting: Unexpected player state ").append(n).append("!").toString());
            }
        }
    }

    private void abortPlaying() {
        this.target.dsiWavePlayer.audioTrigger(2);
    }
}


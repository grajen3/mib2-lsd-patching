/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.sound;

import de.vw.mib.asl.internal.sound.HsmSoundWaveplayerHandling;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class HsmSoundWaveplayerHandling$StateWaveplayerHandlingActive
extends AbstractHsmState {
    private final /* synthetic */ HsmSoundWaveplayerHandling this$0;

    public HsmSoundWaveplayerHandling$StateWaveplayerHandlingActive(HsmSoundWaveplayerHandling hsmSoundWaveplayerHandling, Hsm hsm, String string, HsmState hsmState) {
        this.this$0 = hsmSoundWaveplayerHandling;
        super(hsm, string, hsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        return this.myParent;
    }

    public void dsiWavePlayerUpdateAudioRequest(int n, int n2) {
        switch (n) {
            case 1: {
                if (this.this$0.isStaticConnectionTone(HsmSoundWaveplayerHandling.actPlayTone)) {
                    this.trans(this.this$0.stateWaveplayerIdle);
                    break;
                }
                this.trans(this.this$0.stateWaveplayerDisconnecting);
                break;
            }
            default: {
                this.this$0.warn(new StringBuffer().append("SoundWaveplayerHandlingActive: Unexpected player state ").append(n).append("!").toString());
            }
        }
    }
}


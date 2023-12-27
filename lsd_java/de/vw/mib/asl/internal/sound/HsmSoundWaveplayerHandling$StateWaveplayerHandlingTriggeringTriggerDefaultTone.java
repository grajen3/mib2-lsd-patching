/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.sound;

import de.vw.mib.asl.internal.sound.HsmSoundWaveplayerHandling;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class HsmSoundWaveplayerHandling$StateWaveplayerHandlingTriggeringTriggerDefaultTone
extends AbstractHsmState {
    private HsmSoundWaveplayerHandling target;
    private final /* synthetic */ HsmSoundWaveplayerHandling this$0;

    public HsmSoundWaveplayerHandling$StateWaveplayerHandlingTriggeringTriggerDefaultTone(HsmSoundWaveplayerHandling hsmSoundWaveplayerHandling, Hsm hsm, String string, HsmState hsmState) {
        this.this$0 = hsmSoundWaveplayerHandling;
        super(hsm, string, hsmState);
        this.target = this.this$0;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.target.dsiWavePlayer.audioTriggerDefaultTone(0);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void dsiWavePlayerAudioTriggerResponse(int n) {
        switch (n) {
            case 5: 
            case 6: 
            case 7: 
            case 9: {
                if (this.this$0.isTraceEnabled()) {
                    this.this$0.trace().append("[HsmSoundWaveplayerHandling] audioTriggerResponse Error: ").append(n).log();
                }
                if (this.this$0.isStaticConnectionTone(HsmSoundWaveplayerHandling.actPlayTone)) {
                    this.trans(this.this$0.stateWaveplayerIdle);
                    break;
                }
                this.this$0.warn().append("SoundWaveplayerHandlingTriggerDefault: can not play TONE_NAV_POI; going to disconnecting.").log();
                this.trans(this.this$0.stateWaveplayerDisconnecting);
                break;
            }
        }
    }
}


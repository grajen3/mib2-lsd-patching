/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.sound;

import de.vw.mib.asl.internal.sound.HsmSoundWaveplayerHandling;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class HsmSoundWaveplayerHandling$StateWaveplayerHandlingTonesetting
extends AbstractHsmState {
    private HsmSoundWaveplayerHandling target;
    private final /* synthetic */ HsmSoundWaveplayerHandling this$0;

    public HsmSoundWaveplayerHandling$StateWaveplayerHandlingTonesetting(HsmSoundWaveplayerHandling hsmSoundWaveplayerHandling, Hsm hsm, String string, HsmState hsmState) {
        this.this$0 = hsmSoundWaveplayerHandling;
        super(hsm, string, hsmState);
        this.target = this.this$0;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                if (this.this$0.isTraceEnabled()) {
                    this.this$0.trace().append("SoundWaveplayerHandlingTonesetting: start").log();
                }
                this.setPlayTone();
                if (this.this$0.isStaticConnectionTone(HsmSoundWaveplayerHandling.newPlayTone)) {
                    this.trans(this.this$0.stateWaveplayerTriggeringTrigger);
                    break;
                }
                this.trans(this.this$0.stateWaveplayerFading);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    private void setPlayTone() {
        if (HsmSoundWaveplayerHandling.newPlayTone != HsmSoundWaveplayerHandling.actPlayTone) {
            this.target.dsiWavePlayer.setPlayTone(HsmSoundWaveplayerHandling.newPlayTone);
            HsmSoundWaveplayerHandling.actPlayTone = HsmSoundWaveplayerHandling.newPlayTone;
        }
    }
}


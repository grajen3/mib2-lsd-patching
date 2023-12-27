/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.sound;

import de.vw.mib.asl.internal.sound.HsmSoundWaveplayerHandling;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class HsmSoundWaveplayerHandling$StateWaveplayerHandlingMain
extends AbstractHsmState {
    private HsmSoundWaveplayerHandling target;
    private final /* synthetic */ HsmSoundWaveplayerHandling this$0;

    public HsmSoundWaveplayerHandling$StateWaveplayerHandlingMain(HsmSoundWaveplayerHandling hsmSoundWaveplayerHandling, Hsm hsm, String string, HsmState hsmState) {
        this.this$0 = hsmSoundWaveplayerHandling;
        super(hsm, string, hsmState);
        this.target = this.this$0;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 4000038: 
            case 0x400004EE: {
                if (this.this$0.isTraceEnabled()) {
                    this.this$0.trace().append(this.target.getHsm().getState().getName()).append("---SoundWaveplayerHandlingMain: buffering Beep ").append(this.this$0.getPlayTone(eventGeneric)).log();
                }
                eventGeneric.setBlocked(true);
                this.target.pendingSystemBeep = eventGeneric;
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.sound;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.sound.HsmSoundWaveplayerHandling;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class HsmSoundWaveplayerHandling$StateWaveplayerHandlingDisconnecting
extends AbstractHsmState {
    private final /* synthetic */ HsmSoundWaveplayerHandling this$0;

    public HsmSoundWaveplayerHandling$StateWaveplayerHandlingDisconnecting(HsmSoundWaveplayerHandling hsmSoundWaveplayerHandling, Hsm hsm, String string, HsmState hsmState) {
        this.this$0 = hsmSoundWaveplayerHandling;
        super(hsm, string, hsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                if (this.this$0.isTraceEnabled()) {
                    this.this$0.trace().append("SoundWaveplayerHandlingDisconnecting: start").log();
                }
                EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(67714304);
                eventGeneric2.setInt(0, 235);
                eventGeneric2.setSenderEventId(-1551499008);
                this.this$0.send(eventGeneric2);
                break;
            }
            case 100003: {
                if (this.this$0.isTraceEnabled()) {
                    this.this$0.trace().append("SoundWaveplayerHandlingDisconnecting: connection TONE_NAV_POI released, going to idle.").log();
                }
                this.trans(this.this$0.stateWaveplayerIdle);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}


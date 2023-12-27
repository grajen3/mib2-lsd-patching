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

public class HsmSoundWaveplayerHandling$StateWaveplayerHandlingFading
extends AbstractHsmState {
    private final /* synthetic */ HsmSoundWaveplayerHandling this$0;

    public HsmSoundWaveplayerHandling$StateWaveplayerHandlingFading(HsmSoundWaveplayerHandling hsmSoundWaveplayerHandling, Hsm hsm, String string, HsmState hsmState) {
        this.this$0 = hsmSoundWaveplayerHandling;
        super(hsm, string, hsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                if (this.this$0.isTraceEnabled()) {
                    this.this$0.trace().append("SoundWaveplayerHandlingFading: start").log();
                }
                EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(50937088);
                eventGeneric2.setInt(0, 235);
                eventGeneric2.setSenderEventId(-1568276224);
                this.this$0.send(eventGeneric2);
                break;
            }
            case 100002: {
                if (0 == eventGeneric.getResult()) {
                    if (this.this$0.isTraceEnabled()) {
                        this.this$0.trace().append("SoundWaveplayerHandlingFading: connection TONE_NAV_POI fadedIn, going to trigger.").log();
                    }
                    this.trans(this.this$0.stateWaveplayerTriggeringTrigger);
                    break;
                }
                this.this$0.warn().append("SoundWaveplayerHandlingFading: can not fade to connection TONE_NAV_POI; going to disconnecting.").log();
                this.trans(this.this$0.stateWaveplayerDisconnecting);
                break;
            }
            case 4000015: {
                int n = eventGeneric.getInt(0);
                if (n != 235) break;
                this.this$0.trace("SoundWaveplayerHandlingFading: connection NAV_POI_TONE stoped, going to idle.");
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


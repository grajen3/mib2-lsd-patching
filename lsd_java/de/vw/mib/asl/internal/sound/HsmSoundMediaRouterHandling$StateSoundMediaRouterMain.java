/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.sound;

import de.vw.mib.asl.internal.sound.HsmSoundMediaRouterHandling;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.media.AudioRoute;

public class HsmSoundMediaRouterHandling$StateSoundMediaRouterMain
extends AbstractHsmState {
    private final /* synthetic */ HsmSoundMediaRouterHandling this$0;

    public HsmSoundMediaRouterHandling$StateSoundMediaRouterMain(HsmSoundMediaRouterHandling hsmSoundMediaRouterHandling, Hsm hsm, String string, HsmState hsmState) {
        this.this$0 = hsmSoundMediaRouterHandling;
        super(hsm, string, hsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.this$0.addObservers(new int[]{403258624, 252263680});
                break;
            }
            case 4000024: {
                int n = eventGeneric.getInt(0);
                this.this$0.setRoutes(n);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void dsiMediaRouterUpdateActiveAudioRoutes(AudioRoute[] audioRouteArray, int n) {
        int n2 = this.this$0.getRoute(audioRouteArray);
        switch (n2) {
            case 1: {
                this.this$0.trace("[SoundMediaRouterMedia] updateActiveAudioRoutes found route media");
                HsmSoundMediaRouterHandling.internalMedia = true;
                break;
            }
            case 3: 
            case 4: 
            case 5: 
            case 33: {
                this.this$0.trace("[SoundMediaRouterMedia] updateActiveAudioRoutes found route smartphone entertainment");
                HsmSoundMediaRouterHandling.internalMedia = false;
                break;
            }
        }
    }
}


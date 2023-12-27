/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.sound;

import de.vw.mib.asl.internal.sound.HsmSoundMediaRouterHandling;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.media.AudioRoute;

public class HsmSoundMediaRouterHandling$StateSoundMediaRouterInit
extends AbstractHsmState {
    private final /* synthetic */ HsmSoundMediaRouterHandling this$0;

    public HsmSoundMediaRouterHandling$StateSoundMediaRouterInit(HsmSoundMediaRouterHandling hsmSoundMediaRouterHandling, Hsm hsm, String string, HsmState hsmState) {
        this.this$0 = hsmSoundMediaRouterHandling;
        super(hsm, string, hsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.this$0.trace("[HsmSoundMediaRouterHandling.Init] entered HSM_ENTRY");
                this.this$0.target.initDSI();
                this.this$0.target.dsiMediaRouter.setNotification(2, (DSIListener)this.this$0.target.dsiMediaRouterListener);
                break;
            }
            case 3: {
                this.this$0.trace("[HsmSoundMediaRouterHandling.Init] entered HSM_START");
                this.this$0.setAudioRoutes(this.this$0.mediaRoutes);
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
                this.this$0.trace("[HsmSoundMediaRouterInit] updateActiveAudioRoutes found route media, trans to state Media");
                this.trans(this.this$0.stateMain);
                break;
            }
            default: {
                this.this$0.warn().append("[HsmSoundMediaRouterInit] updateActiveAudioRoutes No route found!").log();
            }
        }
    }
}


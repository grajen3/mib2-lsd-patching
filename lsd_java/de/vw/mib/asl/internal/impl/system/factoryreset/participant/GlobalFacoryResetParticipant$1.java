/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system.factoryreset.participant;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListenerAdapter;
import de.vw.mib.asl.internal.impl.system.factoryreset.participant.GlobalFacoryResetParticipant;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.infotainmentrecorder.DSIInfotainmentRecorder;

class GlobalFacoryResetParticipant$1
extends DSIServiceStateListenerAdapter {
    private final /* synthetic */ DSIProxy val$internalDsiProxy;
    private final /* synthetic */ GlobalFacoryResetParticipant this$0;

    GlobalFacoryResetParticipant$1(GlobalFacoryResetParticipant globalFacoryResetParticipant, DSIProxy dSIProxy) {
        this.this$0 = globalFacoryResetParticipant;
        this.val$internalDsiProxy = dSIProxy;
    }

    @Override
    public void registered(String string, int n) {
        DSIBase dSIBase = this.val$internalDsiProxy.getService(null, GlobalFacoryResetParticipant.class$org$dsi$ifc$infotainmentrecorder$DSIInfotainmentRecorder == null ? (GlobalFacoryResetParticipant.class$org$dsi$ifc$infotainmentrecorder$DSIInfotainmentRecorder = GlobalFacoryResetParticipant.class$("org.dsi.ifc.infotainmentrecorder.DSIInfotainmentRecorder")) : GlobalFacoryResetParticipant.class$org$dsi$ifc$infotainmentrecorder$DSIInfotainmentRecorder);
        this.this$0.setDsiInfotainmentRecorder((DSIInfotainmentRecorder)dSIBase);
        this.val$internalDsiProxy.removeServiceStateListener(this);
    }
}


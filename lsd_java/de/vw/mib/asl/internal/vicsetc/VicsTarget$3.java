/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.vicsetc;

import de.vw.mib.asl.api.online.ASLOnlineServiceCallback;
import de.vw.mib.asl.api.online.ASLOnlineServiceIdentifier;
import de.vw.mib.asl.internal.vicsetc.VicsTarget;
import de.vw.mib.util.Util;
import org.dsi.ifc.global.ResourceLocator;

class VicsTarget$3
implements ASLOnlineServiceCallback {
    private final /* synthetic */ VicsTarget this$0;

    VicsTarget$3(VicsTarget vicsTarget) {
        this.this$0 = vicsTarget;
    }

    @Override
    public void updateImageInfo(ResourceLocator resourceLocator) {
    }

    @Override
    public void getServiceURLResponse(ASLOnlineServiceIdentifier aSLOnlineServiceIdentifier, String string) {
    }

    @Override
    public void checkOnlineServiceStatusResponse(ASLOnlineServiceIdentifier aSLOnlineServiceIdentifier, int n) {
        if (aSLOnlineServiceIdentifier != null && !Util.isNullOrEmpty(aSLOnlineServiceIdentifier.getServiceidentifier()) && aSLOnlineServiceIdentifier.getServiceidentifier().equals("onlinetraffic")) {
            if (n == 0) {
                this.this$0.handleServiceOnlineTrafficAvailable();
            } else {
                this.this$0.handleServiceOnlineTrafficNotAvailable();
            }
        }
    }
}


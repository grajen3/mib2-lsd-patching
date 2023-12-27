/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller;

import de.vw.mib.asl.api.online.ASLOnlineServiceCallback;
import de.vw.mib.asl.api.online.ASLOnlineServiceIdentifier;
import de.vw.mib.asl.internal.media.controller.OnlineMetaDataHandler;
import org.dsi.ifc.global.ResourceLocator;

class OnlineMetaDataHandler$2
implements ASLOnlineServiceCallback {
    private final /* synthetic */ OnlineMetaDataHandler this$0;

    OnlineMetaDataHandler$2(OnlineMetaDataHandler onlineMetaDataHandler) {
        this.this$0 = onlineMetaDataHandler;
    }

    @Override
    public void updateImageInfo(ResourceLocator resourceLocator) {
    }

    @Override
    public void getServiceURLResponse(ASLOnlineServiceIdentifier aSLOnlineServiceIdentifier, String string) {
    }

    @Override
    public void checkOnlineServiceStatusResponse(ASLOnlineServiceIdentifier aSLOnlineServiceIdentifier, int n) {
        OnlineMetaDataHandler.access$000(this.this$0, n == 0);
    }
}


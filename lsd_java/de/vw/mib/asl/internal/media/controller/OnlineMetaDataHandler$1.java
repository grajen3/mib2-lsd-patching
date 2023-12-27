/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller;

import de.vw.mib.asl.api.online.ASLOnlineServiceIdentifier;
import de.vw.mib.asl.internal.media.controller.OnlineMetaDataHandler;

class OnlineMetaDataHandler$1
implements ASLOnlineServiceIdentifier {
    private final /* synthetic */ OnlineMetaDataHandler this$0;

    OnlineMetaDataHandler$1(OnlineMetaDataHandler onlineMetaDataHandler) {
        this.this$0 = onlineMetaDataHandler;
    }

    @Override
    public void setServiceID(String string) {
    }

    @Override
    public void setApplicationID(String string) {
    }

    @Override
    public boolean isServiceValid() {
        return true;
    }

    @Override
    public String getServiceidentifier() {
        return "gracenote";
    }

    @Override
    public String getServiceID() {
        return null;
    }

    @Override
    public String getApplicationID() {
        return null;
    }
}


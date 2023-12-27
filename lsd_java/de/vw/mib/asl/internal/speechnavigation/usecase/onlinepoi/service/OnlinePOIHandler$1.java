/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.onlinepoi.service;

import de.vw.mib.asl.api.online.ASLOnlineServiceIdentifier;
import de.vw.mib.asl.internal.speechnavigation.usecase.onlinepoi.service.OnlinePOIHandler;

class OnlinePOIHandler$1
implements ASLOnlineServiceIdentifier {
    private final /* synthetic */ OnlinePOIHandler this$0;

    OnlinePOIHandler$1(OnlinePOIHandler onlinePOIHandler) {
        this.this$0 = onlinePOIHandler;
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
        return "poi-search";
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


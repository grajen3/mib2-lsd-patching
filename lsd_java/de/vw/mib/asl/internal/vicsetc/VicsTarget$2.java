/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.vicsetc;

import de.vw.mib.asl.api.online.ASLOnlineServiceIdentifier;
import de.vw.mib.asl.internal.vicsetc.VicsTarget;

class VicsTarget$2
implements ASLOnlineServiceIdentifier {
    private final /* synthetic */ VicsTarget this$0;

    VicsTarget$2(VicsTarget vicsTarget) {
        this.this$0 = vicsTarget;
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
        return "onlinetraffic";
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


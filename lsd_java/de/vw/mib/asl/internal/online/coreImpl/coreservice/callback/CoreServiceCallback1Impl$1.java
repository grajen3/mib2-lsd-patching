/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.coreservice.callback;

import de.vw.mib.asl.api.online.ASLOnlineServiceIdentifier;
import de.vw.mib.asl.internal.online.coreImpl.corecommon.CoreServiceMappingTable;
import de.vw.mib.asl.internal.online.coreImpl.coreservice.callback.CoreServiceCallback1Impl;

class CoreServiceCallback1Impl$1
implements ASLOnlineServiceIdentifier {
    private final /* synthetic */ String val$serviceID;
    private final /* synthetic */ CoreServiceCallback1Impl this$0;

    CoreServiceCallback1Impl$1(CoreServiceCallback1Impl coreServiceCallback1Impl, String string) {
        this.this$0 = coreServiceCallback1Impl;
        this.val$serviceID = string;
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
        return CoreServiceMappingTable.getServiceNameWithServiceID(this.val$serviceID);
    }

    @Override
    public String getServiceID() {
        return this.val$serviceID;
    }

    @Override
    public String getApplicationID() {
        return null;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.coreservice.services;

import de.vw.mib.asl.api.online.ASLOnlineServiceIdentifier;
import de.vw.mib.asl.internal.online.coreImpl.corecommon.CoreServiceMappingTable;
import de.vw.mib.asl.internal.online.coreImpl.coreservice.services.CoreServiceUrlHandler;

class CoreServiceUrlHandler$1
implements ASLOnlineServiceIdentifier {
    private final /* synthetic */ String val$serviceID;
    private final /* synthetic */ CoreServiceUrlHandler this$0;

    CoreServiceUrlHandler$1(CoreServiceUrlHandler coreServiceUrlHandler, String string) {
        this.this$0 = coreServiceUrlHandler;
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


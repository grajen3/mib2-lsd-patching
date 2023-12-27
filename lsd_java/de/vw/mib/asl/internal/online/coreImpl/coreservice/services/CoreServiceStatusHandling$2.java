/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.coreservice.services;

import de.vw.mib.asl.api.online.ASLOnlineServiceIdentifier;
import de.vw.mib.asl.internal.online.coreImpl.corecommon.CoreServiceMappingTable;
import de.vw.mib.asl.internal.online.coreImpl.coreservice.services.CoreServiceStatusHandling;

class CoreServiceStatusHandling$2
implements ASLOnlineServiceIdentifier {
    private final /* synthetic */ CoreServiceStatusHandling this$0;

    CoreServiceStatusHandling$2(CoreServiceStatusHandling coreServiceStatusHandling) {
        this.this$0 = coreServiceStatusHandling;
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
        return CoreServiceMappingTable.getServiceNameWithServiceID(CoreServiceStatusHandling.access$000(this.this$0).getServiceID());
    }

    @Override
    public String getServiceID() {
        return CoreServiceStatusHandling.access$000(this.this$0).getServiceID();
    }

    @Override
    public String getApplicationID() {
        return null;
    }
}


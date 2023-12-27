/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.clients.model.control;

import de.vw.mib.asl.api.connectivity.services.datavolume.DataTraffic;
import de.vw.mib.asl.api.connectivity.services.datavolume.DataTrafficResponse;
import de.vw.mib.asl.internal.online.clients.model.control.CoreServiceModelController;
import de.vw.mib.asl.internal.online.coreInterfaces.core.client.OnlineService;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.online.transformer.OnlineOnlineServiceInfoCollector;

class CoreServiceModelController$1
implements DataTrafficResponse {
    private final /* synthetic */ OnlineService val$_service;
    private final /* synthetic */ OnlineOnlineServiceInfoCollector[] val$_collector;
    private final /* synthetic */ CoreServiceModelController this$0;

    CoreServiceModelController$1(CoreServiceModelController coreServiceModelController, OnlineService onlineService, OnlineOnlineServiceInfoCollector[] onlineOnlineServiceInfoCollectorArray) {
        this.this$0 = coreServiceModelController;
        this.val$_service = onlineService;
        this.val$_collector = onlineOnlineServiceInfoCollectorArray;
    }

    @Override
    public void responseDataTraffic(DataTraffic[] dataTrafficArray) {
        if (!Util.isNullOrEmpty(dataTrafficArray)) {
            int n = dataTrafficArray.length;
            for (int i2 = 0; i2 < n; ++i2) {
                if (!this.val$_service.getServiceID().equalsIgnoreCase(dataTrafficArray[i2].getServiceId())) continue;
                this.val$_collector[0].online_online_service_info_data_usage = (int)dataTrafficArray[i2].getBytesReceived();
                this.this$0.getModelHandler().sendOnlineServiceDetailInfo(this.val$_collector);
                return;
            }
        }
        if (CoreServiceModelController.access$000(this.this$0).isTraceEnabled()) {
            CoreServiceModelController.access$000(this.this$0).trace().append("Service ").append(this.val$_service.getServiceID()).append(" not found in DataTrafficResponse.").log();
        }
    }
}


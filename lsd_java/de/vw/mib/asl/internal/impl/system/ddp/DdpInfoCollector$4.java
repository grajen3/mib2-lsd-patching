/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system.ddp;

import de.vw.mib.asl.framework.api.diagnosis.AdaptionResponse;
import de.vw.mib.asl.framework.api.diagnosis.config.Access;
import de.vw.mib.asl.internal.impl.system.ddp.DdpInfoCollector;

class DdpInfoCollector$4
implements AdaptionResponse {
    private final /* synthetic */ DdpInfoCollector this$0;

    DdpInfoCollector$4(DdpInfoCollector ddpInfoCollector) {
        this.this$0 = ddpInfoCollector;
    }

    @Override
    public void onSuccess(Access access) {
        if (access.contains(1115)) {
            DdpInfoCollector.access$802(this.this$0, access.getValue(1115) == 1);
        } else {
            DdpInfoCollector.access$500(this.this$0, "HmiFunctionBlockTbl.ID_MISC_23 not found in diagnosis data!");
        }
    }

    @Override
    public void onError() {
        DdpInfoCollector.access$500(this.this$0, new StringBuffer().append("Could not read diagnosis data from ").append((DdpInfoCollector.class$de$vw$mib$asl$framework$api$diagnosis$config$HmiFunctionBlockTbl == null ? (DdpInfoCollector.class$de$vw$mib$asl$framework$api$diagnosis$config$HmiFunctionBlockTbl = DdpInfoCollector.class$("de.vw.mib.asl.framework.api.diagnosis.config.HmiFunctionBlockTbl")) : DdpInfoCollector.class$de$vw$mib$asl$framework$api$diagnosis$config$HmiFunctionBlockTbl).getName()).append("!").toString());
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.fpk;

import de.vw.mib.asl.framework.api.diagnosis.AdaptionResponse;
import de.vw.mib.asl.framework.api.diagnosis.config.Access;
import de.vw.mib.asl.internal.car.fpk.ServiceBase;

class ServiceBase$1
implements AdaptionResponse {
    private final /* synthetic */ ServiceBase this$0;

    ServiceBase$1(ServiceBase serviceBase) {
        this.this$0 = serviceBase;
    }

    @Override
    public void onSuccess(Access access) {
        this.this$0.onSuccess_funcAdap(access);
    }

    @Override
    public void onError() {
        if (this.this$0.isTraceEnabled()) {
            this.this$0.trace().append("Error requesting CarFunctionAdap from AdaptionApi").log();
        }
    }
}


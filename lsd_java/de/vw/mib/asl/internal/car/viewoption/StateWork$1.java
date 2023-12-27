/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.viewoption;

import de.vw.mib.asl.framework.api.diagnosis.AdaptionResponse;
import de.vw.mib.asl.framework.api.diagnosis.config.Access;
import de.vw.mib.asl.internal.car.viewoption.StateWork;

class StateWork$1
implements AdaptionResponse {
    private final /* synthetic */ StateWork this$0;

    StateWork$1(StateWork stateWork) {
        this.this$0 = stateWork;
    }

    @Override
    public void onSuccess(Access access) {
        this.this$0.onSuccess_funcAdap(access);
    }

    @Override
    public void onError() {
        if (this.this$0.myTarget.isTraceEnabled()) {
            this.this$0.myTarget.trace().append("error requesting CarFunctionAdap from AdaptionApi").log();
        }
    }
}


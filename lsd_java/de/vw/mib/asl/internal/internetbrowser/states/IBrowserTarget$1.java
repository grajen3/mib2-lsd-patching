/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.internetbrowser.states;

import de.vw.mib.asl.framework.api.diagnosis.AdaptionResponse;
import de.vw.mib.asl.framework.api.diagnosis.config.Access;
import de.vw.mib.asl.internal.internetbrowser.states.IBrowserTarget;

class IBrowserTarget$1
implements AdaptionResponse {
    private final /* synthetic */ IBrowserTarget this$0;

    IBrowserTarget$1(IBrowserTarget iBrowserTarget) {
        this.this$0 = iBrowserTarget;
    }

    @Override
    public void onSuccess(Access access) {
        if (access != null) {
            // empty if block
        }
    }

    @Override
    public void onError() {
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.startup;

import de.vw.mib.asl.framework.api.diagnosis.AdaptionResponse;
import de.vw.mib.asl.framework.api.diagnosis.config.Access;
import de.vw.mib.asl.internal.speechengine.startup.DialogSystemHandler;

class DialogSystemHandler$1
implements AdaptionResponse {
    private final /* synthetic */ DialogSystemHandler this$0;

    DialogSystemHandler$1(DialogSystemHandler dialogSystemHandler) {
        this.this$0 = dialogSystemHandler;
    }

    @Override
    public void onSuccess(Access access) {
        this.this$0.onResponseRequestCoding(access);
    }

    @Override
    public void onError() {
        this.this$0.getStartupLogger().fatal().append("Error when requesting coding-data via 'adaptionApi.requestCoding'").log();
    }
}


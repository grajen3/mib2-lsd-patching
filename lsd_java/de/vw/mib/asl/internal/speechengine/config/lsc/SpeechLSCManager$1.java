/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.config.lsc;

import de.vw.mib.asl.framework.api.diagnosis.AdaptionResponse;
import de.vw.mib.asl.framework.api.diagnosis.config.Access;
import de.vw.mib.asl.internal.speechengine.config.lsc.SpeechLSCManager;

class SpeechLSCManager$1
implements AdaptionResponse {
    private final /* synthetic */ SpeechLSCManager this$0;

    SpeechLSCManager$1(SpeechLSCManager speechLSCManager) {
        this.this$0 = speechLSCManager;
    }

    @Override
    public void onSuccess(Access access) {
        this.this$0.processAdaptionsResponse(access);
    }

    @Override
    public void onError() {
        this.this$0.logger.error().append("Adaptation API signalled error. Default voice could not be retrieved.").log();
    }
}


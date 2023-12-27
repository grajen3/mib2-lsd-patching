/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechmedia.controller;

import de.vw.mib.asl.api.media.services.ResultCode;
import de.vw.mib.asl.api.media.services.SourceCallback;
import de.vw.mib.asl.api.media.services.sources.medialist.Source;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.speechmedia.controller.MediaServiceController;

class MediaServiceController$1
implements SourceCallback {
    private final /* synthetic */ MediaServiceController this$0;

    MediaServiceController$1(MediaServiceController mediaServiceController) {
        this.this$0 = mediaServiceController;
    }

    @Override
    public void response(ResultCode resultCode, Source source) {
        int n = source.getInsertion();
        if (n == 14) {
            if (this.this$0.logger.isTraceEnabled()) {
                this.this$0.logger.trace("No playable files on the source.");
            }
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-931057152);
            return;
        }
        if (resultCode == ResultCode.NOK) {
            if (this.this$0.logger.isTraceEnabled()) {
                this.this$0.logger.trace("Response from MediaService: ResultCode.NOK");
            }
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-914279936);
            return;
        }
        if (this.this$0.logger.isTraceEnabled()) {
            this.this$0.logger.trace("Response from MediaService: ResultCode.OK");
        }
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-897502720);
    }
}


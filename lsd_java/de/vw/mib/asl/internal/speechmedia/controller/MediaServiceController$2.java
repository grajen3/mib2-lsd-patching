/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechmedia.controller;

import de.vw.mib.asl.api.speechengine.result.service.AsyncCallback;
import de.vw.mib.asl.api.speechengine.result.service.DataService;
import de.vw.mib.asl.internal.speechmedia.controller.MediaServiceController;
import de.vw.mib.asl.internal.speechmedia.sources.util.SourceUtil;

class MediaServiceController$2
implements DataService {
    private final /* synthetic */ MediaServiceController this$0;

    MediaServiceController$2(MediaServiceController mediaServiceController) {
        this.this$0 = mediaServiceController;
    }

    @Override
    public void getDataRequest(AsyncCallback asyncCallback) {
        asyncCallback.onResponse(SourceUtil.fromSourceStates(this.this$0.sourceStates));
    }
}


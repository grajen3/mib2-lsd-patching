/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller;

import de.vw.mib.asl.api.media.services.Callback;
import de.vw.mib.asl.api.media.services.ResultCode;
import de.vw.mib.asl.api.media.services.SourceCallback;
import de.vw.mib.asl.api.media.services.sources.medialist.Source;
import de.vw.mib.asl.internal.media.controller.MediaController;

class MediaController$3
implements SourceCallback {
    private final /* synthetic */ Callback val$callback;
    private final /* synthetic */ MediaController this$0;

    MediaController$3(MediaController mediaController, Callback callback) {
        this.this$0 = mediaController;
        this.val$callback = callback;
    }

    @Override
    public void response(ResultCode resultCode, Source source) {
        this.val$callback.response(resultCode);
    }
}


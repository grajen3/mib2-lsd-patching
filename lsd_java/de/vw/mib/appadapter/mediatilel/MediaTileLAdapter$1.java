/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.mediatilel;

import de.vw.mib.appadapter.mediatilel.MediaTileLAdapter;
import de.vw.mib.asl.api.media.services.sources.medialist.MediaListService;
import de.vw.mib.asl.framework.api.framework.component.ASLComponentAPICallback;

class MediaTileLAdapter$1
implements ASLComponentAPICallback {
    private final /* synthetic */ MediaTileLAdapter this$0;

    MediaTileLAdapter$1(MediaTileLAdapter mediaTileLAdapter) {
        this.this$0 = mediaTileLAdapter;
    }

    @Override
    public void registered(Class clazz, Object object) {
        MediaListService mediaListService = (MediaListService)object;
        mediaListService.addSourceStateListener(this.this$0);
    }
}


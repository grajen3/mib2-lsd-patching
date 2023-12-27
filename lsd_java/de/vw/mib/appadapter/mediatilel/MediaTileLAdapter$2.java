/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.mediatilel;

import de.vw.mib.appadapter.mediatilel.MediaTileLAdapter;
import de.vw.mib.asl.api.media.services.sources.current.CurrentMediaSourceService;
import de.vw.mib.asl.framework.api.framework.component.ASLComponentAPICallback;

class MediaTileLAdapter$2
implements ASLComponentAPICallback {
    private final /* synthetic */ MediaTileLAdapter this$0;

    MediaTileLAdapter$2(MediaTileLAdapter mediaTileLAdapter) {
        this.this$0 = mediaTileLAdapter;
    }

    @Override
    public void registered(Class clazz, Object object) {
        CurrentMediaSourceService currentMediaSourceService = (CurrentMediaSourceService)object;
        currentMediaSourceService.registerListener(this.this$0);
    }
}


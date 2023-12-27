/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.mediatilel;

import de.vw.mib.appadapter.mediatilel.MediaTileLAdapter;
import de.vw.mib.asl.api.media.services.player.MediaPlayerService;
import de.vw.mib.asl.framework.api.framework.component.ASLComponentAPICallback;

class MediaTileLAdapter$3
implements ASLComponentAPICallback {
    private final /* synthetic */ MediaTileLAdapter this$0;

    MediaTileLAdapter$3(MediaTileLAdapter mediaTileLAdapter) {
        this.this$0 = mediaTileLAdapter;
    }

    @Override
    public void registered(Class clazz, Object object) {
        MediaTileLAdapter.access$002(this.this$0, (MediaPlayerService)object);
    }
}


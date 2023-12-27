/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.audiotiles;

import de.vw.mib.appadapter.audiotiles.AudioTileSAdapter;
import de.vw.mib.asl.framework.api.entertainmentmanager.EntertainmentManagerService;
import de.vw.mib.asl.framework.api.framework.component.ASLComponentAPICallback;

class AudioTileSAdapter$1
implements ASLComponentAPICallback {
    private final /* synthetic */ AudioTileSAdapter this$0;

    AudioTileSAdapter$1(AudioTileSAdapter audioTileSAdapter) {
        this.this$0 = audioTileSAdapter;
    }

    @Override
    public void registered(Class clazz, Object object) {
        EntertainmentManagerService entertainmentManagerService = (EntertainmentManagerService)object;
        entertainmentManagerService.addListener(this.this$0);
    }
}


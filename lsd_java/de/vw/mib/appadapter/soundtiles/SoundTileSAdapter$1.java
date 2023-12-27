/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.soundtiles;

import de.vw.mib.appadapter.soundtiles.SoundTileSAdapter;
import de.vw.mib.asl.api.sound.capabilities.SoundCapabilitiesService;
import de.vw.mib.asl.framework.api.framework.component.ASLComponentAPICallback;

class SoundTileSAdapter$1
implements ASLComponentAPICallback {
    private final /* synthetic */ SoundTileSAdapter this$0;

    SoundTileSAdapter$1(SoundTileSAdapter soundTileSAdapter) {
        this.this$0 = soundTileSAdapter;
    }

    @Override
    public void registered(Class clazz, Object object) {
        SoundCapabilitiesService soundCapabilitiesService = (SoundCapabilitiesService)object;
        soundCapabilitiesService.register(this.this$0);
    }
}


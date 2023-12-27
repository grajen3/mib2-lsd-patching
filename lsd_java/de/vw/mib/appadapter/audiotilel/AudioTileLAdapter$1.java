/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.audiotilel;

import de.vw.mib.appadapter.audiotilel.AudioTileLAdapter;
import de.vw.mib.asl.framework.api.entertainmentmanager.EntertainmentManagerService;
import de.vw.mib.asl.framework.api.framework.component.ASLComponentAPICallback;

class AudioTileLAdapter$1
implements ASLComponentAPICallback {
    private final /* synthetic */ AudioTileLAdapter this$0;

    AudioTileLAdapter$1(AudioTileLAdapter audioTileLAdapter) {
        this.this$0 = audioTileLAdapter;
    }

    @Override
    public void registered(Class clazz, Object object) {
        EntertainmentManagerService entertainmentManagerService = (EntertainmentManagerService)object;
        entertainmentManagerService.addListener(this.this$0);
    }
}


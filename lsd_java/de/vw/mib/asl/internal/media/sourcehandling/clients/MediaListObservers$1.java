/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.sourcehandling.clients;

import de.vw.mib.asl.api.devicehandling.Device;
import de.vw.mib.asl.api.devicehandling.clients.DeviceFilter;
import de.vw.mib.asl.internal.media.sourcehandling.clients.MediaListObservers;

class MediaListObservers$1
implements DeviceFilter {
    private final /* synthetic */ MediaListObservers this$0;

    MediaListObservers$1(MediaListObservers mediaListObservers) {
        this.this$0 = mediaListObservers;
    }

    @Override
    public boolean passes(Device device) {
        return device.getCurrentInfo().getDeviceType() == 2;
    }
}


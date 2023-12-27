/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.services;

import de.vw.mib.asl.api.mediacontrol.services.player.MediaControlListenerDevices;
import de.vw.mib.asl.internal.mediacontrol.common.Helper;
import de.vw.mib.asl.internal.mediacontrol.components.player.ListenerDevices;
import de.vw.mib.asl.internal.mediacontrol.components.player.PlayerState;
import de.vw.mib.asl.internal.mediacontrol.services.ServiceMediaControlPlayerImpl;

class ServiceMediaControlPlayerImpl$1
implements ListenerDevices {
    private final /* synthetic */ MediaControlListenerDevices val$listener;
    private final /* synthetic */ ServiceMediaControlPlayerImpl this$0;

    ServiceMediaControlPlayerImpl$1(ServiceMediaControlPlayerImpl serviceMediaControlPlayerImpl, MediaControlListenerDevices mediaControlListenerDevices) {
        this.this$0 = serviceMediaControlPlayerImpl;
        this.val$listener = mediaControlListenerDevices;
    }

    @Override
    public void updateDeviceList(PlayerState playerState) {
        this.val$listener.updateDeviceList(Helper.getMediaControlDevices(playerState.getDevices()), Helper.getMediaControlDevices(playerState.getRemovedDevices()));
    }
}


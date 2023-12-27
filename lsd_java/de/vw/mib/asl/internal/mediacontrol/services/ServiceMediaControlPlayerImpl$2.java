/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.services;

import de.vw.mib.asl.api.mediacontrol.services.player.MediaControlListenerPlaybackState;
import de.vw.mib.asl.internal.mediacontrol.common.Helper;
import de.vw.mib.asl.internal.mediacontrol.components.player.ListenerPlaybackState;
import de.vw.mib.asl.internal.mediacontrol.components.player.PlayerState;
import de.vw.mib.asl.internal.mediacontrol.services.ServiceMediaControlPlayerImpl;

class ServiceMediaControlPlayerImpl$2
implements ListenerPlaybackState {
    private final /* synthetic */ MediaControlListenerPlaybackState val$listener;
    private final /* synthetic */ ServiceMediaControlPlayerImpl this$0;

    ServiceMediaControlPlayerImpl$2(ServiceMediaControlPlayerImpl serviceMediaControlPlayerImpl, MediaControlListenerPlaybackState mediaControlListenerPlaybackState) {
        this.this$0 = serviceMediaControlPlayerImpl;
        this.val$listener = mediaControlListenerPlaybackState;
    }

    @Override
    public void updatePlaybackState(PlayerState playerState) {
        this.val$listener.updatePlaybackState(Helper.getMediaControlDevices(playerState.getDevices()));
    }
}


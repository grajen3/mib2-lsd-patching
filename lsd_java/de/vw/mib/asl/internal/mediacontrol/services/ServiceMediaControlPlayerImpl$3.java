/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.services;

import de.vw.mib.asl.api.mediacontrol.services.player.MediaControlListenerActiveTrack;
import de.vw.mib.asl.internal.mediacontrol.common.Helper;
import de.vw.mib.asl.internal.mediacontrol.components.player.ListenerActiveTrack;
import de.vw.mib.asl.internal.mediacontrol.components.player.PlayerState;
import de.vw.mib.asl.internal.mediacontrol.services.ServiceMediaControlPlayerImpl;

class ServiceMediaControlPlayerImpl$3
implements ListenerActiveTrack {
    private final /* synthetic */ MediaControlListenerActiveTrack val$listener;
    private final /* synthetic */ ServiceMediaControlPlayerImpl this$0;

    ServiceMediaControlPlayerImpl$3(ServiceMediaControlPlayerImpl serviceMediaControlPlayerImpl, MediaControlListenerActiveTrack mediaControlListenerActiveTrack) {
        this.this$0 = serviceMediaControlPlayerImpl;
        this.val$listener = mediaControlListenerActiveTrack;
    }

    @Override
    public void updateActiveTrack(PlayerState playerState) {
        this.val$listener.updateActiveTrack(Helper.getMediaControlDevices(playerState.getDevices()));
    }
}


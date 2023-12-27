/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.services;

import de.vw.mib.asl.api.mediacontrol.services.player.MediaControlListenerVolume;
import de.vw.mib.asl.internal.mediacontrol.common.Helper;
import de.vw.mib.asl.internal.mediacontrol.components.player.ListenerVolume;
import de.vw.mib.asl.internal.mediacontrol.components.player.PlayerState;
import de.vw.mib.asl.internal.mediacontrol.services.ServiceMediaControlPlayerImpl;

class ServiceMediaControlPlayerImpl$4
implements ListenerVolume {
    private final /* synthetic */ MediaControlListenerVolume val$listener;
    private final /* synthetic */ ServiceMediaControlPlayerImpl this$0;

    ServiceMediaControlPlayerImpl$4(ServiceMediaControlPlayerImpl serviceMediaControlPlayerImpl, MediaControlListenerVolume mediaControlListenerVolume) {
        this.this$0 = serviceMediaControlPlayerImpl;
        this.val$listener = mediaControlListenerVolume;
    }

    @Override
    public void updateVolume(PlayerState playerState) {
        this.val$listener.updateVolume(Helper.getMediaControlDevices(playerState.getDevices()));
    }
}


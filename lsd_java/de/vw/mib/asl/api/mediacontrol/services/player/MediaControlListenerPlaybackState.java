/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.mediacontrol.services.player;

import de.vw.mib.asl.api.mediacontrol.services.player.MediaControlDevice;

public interface MediaControlListenerPlaybackState {
    public static final int PLAYBACKSTATE_STOP;
    public static final int PLAYBACKSTATE_PLAYING;
    public static final int PLAYBACKSTATE_PAUSED;
    public static final int PLAYBACKSTATE_SEEK;

    default public void updatePlaybackState(MediaControlDevice[] mediaControlDeviceArray) {
    }
}


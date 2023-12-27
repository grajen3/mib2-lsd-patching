/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.mediacontrol.services.player;

import de.vw.mib.asl.api.mediacontrol.services.MediaControlCallback;
import de.vw.mib.asl.api.mediacontrol.services.player.MediaControlListenerActiveTrack;
import de.vw.mib.asl.api.mediacontrol.services.player.MediaControlListenerDevices;
import de.vw.mib.asl.api.mediacontrol.services.player.MediaControlListenerPlaybackState;
import de.vw.mib.asl.api.mediacontrol.services.player.MediaControlListenerVolume;

public interface MediaControlServicePlayer {
    default public void addDevicesListener(MediaControlListenerDevices mediaControlListenerDevices) {
    }

    default public void addPlaybackStateListener(MediaControlListenerPlaybackState mediaControlListenerPlaybackState) {
    }

    default public void addActiveTrackListener(MediaControlListenerActiveTrack mediaControlListenerActiveTrack) {
    }

    default public void addVolumeListener(MediaControlListenerVolume mediaControlListenerVolume) {
    }

    default public void pause(String string, MediaControlCallback mediaControlCallback) {
    }

    default public void resume(String string, MediaControlCallback mediaControlCallback) {
    }

    default public void skip(String string, int n, boolean bl, MediaControlCallback mediaControlCallback) {
    }

    default public void seekBw(String string, MediaControlCallback mediaControlCallback) {
    }

    default public void seekFw(String string, MediaControlCallback mediaControlCallback) {
    }

    default public void stopSeek(String string, MediaControlCallback mediaControlCallback) {
    }

    default public void setTimePosition(String string, int n, MediaControlCallback mediaControlCallback) {
    }

    default public void playTrack(String[] stringArray, String string, MediaControlCallback mediaControlCallback) {
    }

    default public void increaseVolume(String string, MediaControlCallback mediaControlCallback) {
    }

    default public void decreaseVolume(String string, MediaControlCallback mediaControlCallback) {
    }
}


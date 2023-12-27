/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.adapter.views.opendevice;

import de.vw.mib.asl.api.mediacontrol.services.MediaControlAPI;
import de.vw.mib.asl.api.mediacontrol.services.player.MediaControlDevice;
import de.vw.mib.asl.api.mediacontrol.services.player.MediaControlListenerPlaybackState;
import de.vw.mib.asl.api.mediacontrol.services.player.MediaControlListenerVolume;
import de.vw.mib.asl.api.mediacontrol.services.player.MediaControlServicePlayer;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.mediacontrol.adapter.views.Helper;

public class PlaybackState
implements MediaControlListenerPlaybackState,
MediaControlListenerVolume {
    private String mCurrentDeviceId;
    private MediaControlDevice[] mDevices;

    protected PlaybackState(MediaControlAPI mediaControlAPI) {
        MediaControlServicePlayer mediaControlServicePlayer = mediaControlAPI.getPlayerService();
        mediaControlServicePlayer.addPlaybackStateListener(this);
        mediaControlServicePlayer.addVolumeListener(this);
    }

    protected void setOpenDevice(String string) {
        this.mCurrentDeviceId = string;
        this.updatePlaybackState();
        this.updateVolume();
    }

    @Override
    public void updatePlaybackState(MediaControlDevice[] mediaControlDeviceArray) {
        this.mDevices = mediaControlDeviceArray;
        this.updatePlaybackState();
    }

    @Override
    public void updateVolume(MediaControlDevice[] mediaControlDeviceArray) {
        this.mDevices = mediaControlDeviceArray;
        this.updateVolume();
    }

    private void updatePlaybackState() {
        int n = 0;
        MediaControlDevice mediaControlDevice = Helper.getDevice(this.mDevices, this.mCurrentDeviceId);
        if (mediaControlDevice != null) {
            n = Helper.getOpenDevicePlaybackState(mediaControlDevice.playbackState);
        }
        ServiceManager.aslPropertyManager.valueChangedInteger(-1004513536, n);
    }

    private void updateVolume() {
        int n = 0;
        MediaControlDevice mediaControlDevice = Helper.getDevice(this.mDevices, this.mCurrentDeviceId);
        if (mediaControlDevice != null) {
            n = mediaControlDevice.volume;
        }
        ServiceManager.aslPropertyManager.valueChangedInteger(-1205840128, n);
    }
}


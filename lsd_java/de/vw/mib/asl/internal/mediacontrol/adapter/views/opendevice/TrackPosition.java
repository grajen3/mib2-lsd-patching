/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.adapter.views.opendevice;

import de.vw.mib.asl.api.mediacontrol.services.MediaControlAPI;
import de.vw.mib.asl.api.mediacontrol.services.player.MediaControlActiveTrack;
import de.vw.mib.asl.api.mediacontrol.services.player.MediaControlDevice;
import de.vw.mib.asl.api.mediacontrol.services.player.MediaControlListenerActiveTrack;
import de.vw.mib.asl.api.mediacontrol.services.player.MediaControlServicePlayer;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.mediacontrol.adapter.views.Helper;

public class TrackPosition
implements MediaControlListenerActiveTrack {
    private String mCurrentDeviceId;
    private MediaControlDevice[] mDevices;

    protected TrackPosition(MediaControlAPI mediaControlAPI) {
        MediaControlServicePlayer mediaControlServicePlayer = mediaControlAPI.getPlayerService();
        mediaControlServicePlayer.addActiveTrackListener(this);
    }

    @Override
    public void updateActiveTrack(MediaControlDevice[] mediaControlDeviceArray) {
        this.mDevices = mediaControlDeviceArray;
        this.update();
    }

    protected void setOpenedDevice(String string) {
        this.mCurrentDeviceId = string;
        this.update();
    }

    private void update() {
        int n = 0;
        int n2 = 0;
        MediaControlActiveTrack mediaControlActiveTrack = Helper.getActiveTrack(this.mDevices, this.mCurrentDeviceId);
        if (mediaControlActiveTrack != null) {
            n2 = mediaControlActiveTrack.totalPlayTime;
            n = mediaControlActiveTrack.playPosition;
        }
        ServiceManager.aslPropertyManager.valueChangedInteger(-1222617344, n2);
        ServiceManager.aslPropertyManager.valueChangedInteger(-1272948992, n);
    }
}


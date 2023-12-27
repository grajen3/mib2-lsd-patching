/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.components.player;

import de.vw.mib.asl.internal.mediacontrol.common.component.AbstractComponentState;
import de.vw.mib.asl.internal.mediacontrol.components.player.ListenerActiveTrack;
import de.vw.mib.asl.internal.mediacontrol.components.player.ListenerDevices;
import de.vw.mib.asl.internal.mediacontrol.components.player.ListenerPlaybackState;
import de.vw.mib.asl.internal.mediacontrol.components.player.ListenerVolume;
import de.vw.mib.asl.internal.mediacontrol.components.player.PlayerStateActiveTrack;
import de.vw.mib.asl.internal.mediacontrol.components.player.PlayerStateDevice;
import de.vw.mib.asl.internal.mediacontrol.components.player.PlayerStateDeviceList;
import java.util.ArrayList;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.upnp.DeviceInfo;
import org.dsi.ifc.upnp.EntryInfo;

public class PlayerState
extends AbstractComponentState {
    private PlayerStateDeviceList mDeviceList = new PlayerStateDeviceList();
    private ArrayList mDevicesListener = new ArrayList();
    private ArrayList mVolumeListener = new ArrayList();
    private ArrayList mPlaybackStateListener = new ArrayList();
    private ArrayList mActiveTrackListener = new ArrayList();

    public void addDevicesListener(ListenerDevices listenerDevices) {
        if (listenerDevices != null) {
            this.mDevicesListener.add(listenerDevices);
            listenerDevices.updateDeviceList(this);
        }
    }

    private void notifyDeviceListener() {
        for (int i2 = 0; i2 < this.mDevicesListener.size(); ++i2) {
            ListenerDevices listenerDevices = (ListenerDevices)this.mDevicesListener.get(i2);
            listenerDevices.updateDeviceList(this);
        }
    }

    protected void updateDevices(DeviceInfo[] deviceInfoArray, boolean bl) {
        this.mDeviceList.syncDevices(deviceInfoArray);
        this.notifyDeviceListener();
    }

    public PlayerStateDevice[] getDevices() {
        return this.mDeviceList.getDevices();
    }

    public PlayerStateDevice[] getRemovedDevices() {
        return this.mDeviceList.getRemovedDevices();
    }

    public void addVolumeListener(ListenerVolume listenerVolume) {
        if (listenerVolume != null) {
            this.mVolumeListener.add(listenerVolume);
            listenerVolume.updateVolume(this);
        }
    }

    private void notifyVolumeListener() {
        for (int i2 = 0; i2 < this.mVolumeListener.size(); ++i2) {
            ListenerVolume listenerVolume = (ListenerVolume)this.mVolumeListener.get(i2);
            listenerVolume.updateVolume(this);
        }
    }

    protected void updateVolume(String string, int n, boolean bl) {
        this.mDeviceList.syncVolume(string, n);
        this.notifyVolumeListener();
    }

    public void addPlaybackStateListener(ListenerPlaybackState listenerPlaybackState) {
        if (listenerPlaybackState != null) {
            this.mPlaybackStateListener.add(listenerPlaybackState);
            listenerPlaybackState.updatePlaybackState(this);
        }
    }

    private void notifyPlaybackStateListener() {
        for (int i2 = 0; i2 < this.mPlaybackStateListener.size(); ++i2) {
            ListenerPlaybackState listenerPlaybackState = (ListenerPlaybackState)this.mPlaybackStateListener.get(i2);
            listenerPlaybackState.updatePlaybackState(this);
        }
    }

    protected void updatePlaybackState(String string, int n, boolean bl) {
        this.mDeviceList.syncPlaybackState(string, n);
        this.notifyPlaybackStateListener();
    }

    public void addActiveTrackListener(ListenerActiveTrack listenerActiveTrack) {
        if (listenerActiveTrack != null) {
            this.mActiveTrackListener.add(listenerActiveTrack);
            listenerActiveTrack.updateActiveTrack(this);
        }
    }

    private void notifyActiveTrackListener() {
        for (int i2 = 0; i2 < this.mActiveTrackListener.size(); ++i2) {
            ListenerActiveTrack listenerActiveTrack = (ListenerActiveTrack)this.mActiveTrackListener.get(i2);
            listenerActiveTrack.updateActiveTrack(this);
        }
    }

    protected void updatePlayPosition(String string, String string2, int n, int n2, boolean bl) {
        this.mDeviceList.syncPlayPosition(string, string2, n, n2);
        this.notifyActiveTrackListener();
    }

    protected void updateDetailInfo(String string, EntryInfo entryInfo, ResourceLocator resourceLocator, boolean bl) {
        this.mDeviceList.syncDetailInfos(string, entryInfo, resourceLocator);
        this.notifyActiveTrackListener();
    }

    public int getPlaybackState(String string) {
        int n = 0;
        PlayerStateDevice playerStateDevice = this.mDeviceList.getDevice(string);
        if (playerStateDevice != null) {
            n = playerStateDevice.mPlaybackState;
        }
        return n;
    }

    public boolean isPaused(String string) {
        return this.getPlaybackState(string) == 2;
    }

    public boolean isPlaying(String string) {
        return this.getPlaybackState(string) == 1;
    }

    public PlayerStateActiveTrack getActiveTrack(String string) {
        PlayerStateActiveTrack playerStateActiveTrack = null;
        PlayerStateDevice playerStateDevice = this.mDeviceList.getDevice(string);
        if (playerStateDevice != null) {
            playerStateActiveTrack = playerStateDevice.mActiveTrack;
        }
        return playerStateActiveTrack;
    }

    public String getActiveTrackId(String string) {
        String string2 = null;
        PlayerStateActiveTrack playerStateActiveTrack = this.getActiveTrack(string);
        if (playerStateActiveTrack != null) {
            string2 = playerStateActiveTrack.entryId;
        }
        return string2;
    }

    public long getTimePosition(String string) {
        long l = -1L;
        PlayerStateActiveTrack playerStateActiveTrack = this.getActiveTrack(string);
        if (playerStateActiveTrack != null) {
            l = playerStateActiveTrack.timePosition;
        }
        return l;
    }
}


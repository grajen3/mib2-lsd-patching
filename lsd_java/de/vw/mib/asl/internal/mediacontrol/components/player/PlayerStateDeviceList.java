/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.components.player;

import de.vw.mib.asl.internal.mediacontrol.components.player.PlayerStateActiveTrack;
import de.vw.mib.asl.internal.mediacontrol.components.player.PlayerStateDevice;
import de.vw.mib.collections.ObjectObjectOptHashMap;
import java.util.Iterator;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.upnp.DeviceInfo;
import org.dsi.ifc.upnp.EntryInfo;

public class PlayerStateDeviceList {
    private static final int MAX_DEVICES;
    private final ObjectObjectOptHashMap mDeviceList = new ObjectObjectOptHashMap(7);
    private final ObjectObjectOptHashMap mRemovedDeviceList = new ObjectObjectOptHashMap(7);
    private DeviceInfo[] mDSIList;

    private boolean containsDeviceId(String string, DeviceInfo[] deviceInfoArray) {
        for (int i2 = 0; i2 < deviceInfoArray.length; ++i2) {
            if (!deviceInfoArray[i2].deviceID.equals(string)) continue;
            return true;
        }
        return false;
    }

    public PlayerStateDevice getDevice(String string) {
        Object object = this.mDeviceList.get(string);
        if (object != null) {
            return (PlayerStateDevice)object;
        }
        return null;
    }

    protected void syncDevices(DeviceInfo[] deviceInfoArray) {
        if (deviceInfoArray != null) {
            this.mDSIList = deviceInfoArray;
            Iterator iterator = this.mDeviceList.keyIterator();
            this.mRemovedDeviceList.clear();
            while (iterator.hasNext()) {
                String string = (String)iterator.next();
                if (this.containsDeviceId(string, deviceInfoArray)) continue;
                this.mRemovedDeviceList.put(string, this.mDeviceList.get(string));
                iterator.remove();
            }
            for (int i2 = 0; i2 < deviceInfoArray.length; ++i2) {
                PlayerStateDevice playerStateDevice = null;
                if (this.mDeviceList.containsKey(deviceInfoArray[i2].deviceID)) {
                    playerStateDevice = (PlayerStateDevice)this.mDeviceList.get(deviceInfoArray[i2].deviceID);
                    playerStateDevice.mDeviceName = deviceInfoArray[i2].deviceName;
                    playerStateDevice.mDeviceType = deviceInfoArray[i2].deviceType;
                    continue;
                }
                playerStateDevice = new PlayerStateDevice();
                playerStateDevice.mDeviceId = deviceInfoArray[i2].deviceID;
                playerStateDevice.mDeviceName = deviceInfoArray[i2].deviceName;
                playerStateDevice.mDeviceType = deviceInfoArray[i2].deviceType;
                this.mDeviceList.put(playerStateDevice.mDeviceId, playerStateDevice);
            }
        }
    }

    public void syncPlaybackState(String string, int n) {
        PlayerStateDevice playerStateDevice = this.getDevice(string);
        if (playerStateDevice != null) {
            playerStateDevice.mPlaybackState = n;
        }
    }

    public void syncVolume(String string, int n) {
        PlayerStateDevice playerStateDevice = this.getDevice(string);
        if (playerStateDevice != null) {
            playerStateDevice.mVolume = n;
        }
    }

    public void syncPlayPosition(String string, String string2, int n, int n2) {
        PlayerStateDevice playerStateDevice = this.getDevice(string);
        if (playerStateDevice != null) {
            if (playerStateDevice.mActiveTrack == null) {
                playerStateDevice.mActiveTrack = new PlayerStateActiveTrack();
            }
            playerStateDevice.mActiveTrack.entryId = string2;
            playerStateDevice.mActiveTrack.timePosition = n;
            playerStateDevice.mActiveTrack.totalPlayTime = n2;
        }
    }

    public void syncDetailInfos(String string, EntryInfo entryInfo, ResourceLocator resourceLocator) {
        PlayerStateDevice playerStateDevice = this.getDevice(string);
        if (playerStateDevice != null) {
            if (playerStateDevice.mActiveTrack == null) {
                playerStateDevice.mActiveTrack = new PlayerStateActiveTrack();
            }
            if (playerStateDevice.mActiveTrack != null) {
                playerStateDevice.mActiveTrack.entryInfo = entryInfo;
                playerStateDevice.mActiveTrack.coverArt = resourceLocator;
            }
        }
    }

    public PlayerStateDevice[] getDevices() {
        PlayerStateDevice[] playerStateDeviceArray = null;
        if (this.mDSIList != null && this.mDeviceList != null) {
            playerStateDeviceArray = new PlayerStateDevice[this.mDSIList.length];
            for (int i2 = 0; i2 < this.mDSIList.length; ++i2) {
                playerStateDeviceArray[i2] = this.getDevice(this.mDSIList[i2].getDeviceID());
            }
        }
        return playerStateDeviceArray;
    }

    public PlayerStateDevice[] getRemovedDevices() {
        PlayerStateDevice[] playerStateDeviceArray = null;
        if (this.mRemovedDeviceList != null) {
            playerStateDeviceArray = (PlayerStateDevice[])this.mRemovedDeviceList.valuesToArray(new PlayerStateDevice[this.mRemovedDeviceList.size()]);
        }
        return playerStateDeviceArray;
    }
}


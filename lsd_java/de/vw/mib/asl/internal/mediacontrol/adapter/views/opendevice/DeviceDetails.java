/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.adapter.views.opendevice;

import de.vw.mib.asl.api.mediacontrol.services.MediaControlAPI;
import de.vw.mib.asl.api.mediacontrol.services.player.MediaControlDevice;
import de.vw.mib.asl.api.mediacontrol.services.player.MediaControlListenerDevices;
import de.vw.mib.asl.api.mediacontrol.services.player.MediaControlServicePlayer;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.mediacontrol.adapter.views.Helper;
import de.vw.mib.util.Util;

public class DeviceDetails
implements MediaControlListenerDevices {
    private String mOpenedDeviceId;
    private MediaControlDevice[] mDevices;

    protected DeviceDetails(MediaControlAPI mediaControlAPI) {
        MediaControlServicePlayer mediaControlServicePlayer = mediaControlAPI.getPlayerService();
        mediaControlServicePlayer.addDevicesListener(this);
    }

    @Override
    public void updateDeviceList(MediaControlDevice[] mediaControlDeviceArray, MediaControlDevice[] mediaControlDeviceArray2) {
        if (!Util.isNullOrEmpty(mediaControlDeviceArray2)) {
            for (int i2 = 0; i2 < mediaControlDeviceArray2.length; ++i2) {
                MediaControlDevice mediaControlDevice = mediaControlDeviceArray2[i2];
                if (!mediaControlDevice.deviceID.equals(this.mOpenedDeviceId)) continue;
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-1289726208);
            }
        }
        this.mDevices = mediaControlDeviceArray;
        this.update();
    }

    protected void setOpenedDevice(String string) {
        this.mOpenedDeviceId = string;
        this.update();
    }

    private void update() {
        String string = "";
        MediaControlDevice mediaControlDevice = Helper.getDevice(this.mDevices, this.mOpenedDeviceId);
        if (mediaControlDevice != null) {
            string = mediaControlDevice.deviceName;
        }
        ServiceManager.aslPropertyManager.valueChangedString(-1105176832, string);
    }
}


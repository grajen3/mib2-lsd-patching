/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.adapter.views;

import de.vw.mib.asl.api.mediacontrol.services.player.MediaControlActiveTrack;
import de.vw.mib.asl.api.mediacontrol.services.player.MediaControlDevice;
import de.vw.mib.util.Util;

public final class Helper {
    public static int getOpenDevicePlaybackState(int n) {
        switch (n) {
            case 0: {
                return 0;
            }
            case 2: {
                return 1;
            }
            case 1: {
                return 2;
            }
            case 3: {
                return 3;
            }
        }
        return 0;
    }

    public static MediaControlDevice getDevice(MediaControlDevice[] mediaControlDeviceArray, String string) {
        MediaControlDevice mediaControlDevice = null;
        if (!Util.isNullOrEmpty(mediaControlDeviceArray)) {
            for (int i2 = 0; i2 < mediaControlDeviceArray.length; ++i2) {
                if (!Helper.isSameString(mediaControlDeviceArray[i2].deviceID, string)) continue;
                return mediaControlDeviceArray[i2];
            }
        }
        return mediaControlDevice;
    }

    public static boolean isSameString(String string, String string2) {
        if (string == null || string2 == null) {
            return string == null && string2 == null;
        }
        return string.equals(string2);
    }

    public static MediaControlActiveTrack getActiveTrack(MediaControlDevice[] mediaControlDeviceArray, String string) {
        MediaControlDevice mediaControlDevice = Helper.getDevice(mediaControlDeviceArray, string);
        if (mediaControlDevice != null) {
            return mediaControlDevice.activeTrack;
        }
        return null;
    }

    public static String getDirectionStr(int n) {
        switch (n) {
            case 1: {
                return "Backward";
            }
            case 0: {
                return "Forward";
            }
        }
        return "Unknown";
    }

    public static int getListState(int n) {
        switch (n) {
            case 0: {
                return 2;
            }
            case 1: {
                return 2;
            }
            case 2: {
                return 3;
            }
            case 3: {
                return 0;
            }
        }
        return 0;
    }
}


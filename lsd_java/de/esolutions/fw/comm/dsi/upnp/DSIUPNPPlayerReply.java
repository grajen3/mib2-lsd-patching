/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.upnp;

import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.upnp.DeviceInfo;
import org.dsi.ifc.upnp.EntryInfo;
import org.dsi.ifc.upnp.PlaybackMode;

public interface DSIUPNPPlayerReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updatePlaybackModeList(String string, PlaybackMode[] playbackModeArray, int n) {
    }

    default public void updatePlaybackMode(String string, int n, int n2) {
    }

    default public void updatePlaybackState(String string, int n, int n2) {
    }

    default public void updatePlayPosition(String string, String string2, int n, int n2, int n3) {
    }

    default public void updateDetailInfo(String string, EntryInfo entryInfo, ResourceLocator resourceLocator, int n) {
    }

    default public void updateDeviceList(DeviceInfo[] deviceInfoArray, int n) {
    }

    default public void updateVolume(String string, int n, int n2) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carplay;

import org.dsi.ifc.carplay.AppState;
import org.dsi.ifc.carplay.CallState;
import org.dsi.ifc.carplay.DeviceInfo;
import org.dsi.ifc.carplay.PlaybackInfo;
import org.dsi.ifc.carplay.Resource;
import org.dsi.ifc.carplay.TelephonyState;
import org.dsi.ifc.carplay.TrackData;
import org.dsi.ifc.global.ResourceLocator;

public interface DSICarplayReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updateMode(Resource[] resourceArray, AppState[] appStateArray, int n) {
    }

    default public void responseModeChange(Resource[] resourceArray, AppState[] appStateArray, int n) {
    }

    default public void requestBTDeactivation(String string, int n) {
    }

    default public void updateDeviceInfo(DeviceInfo deviceInfo, int n) {
    }

    default public void updateCallState(CallState[] callStateArray, int n) {
    }

    default public void updateTelephonyState(TelephonyState telephonyState, int n) {
    }

    default public void updateNowPlayingData(TrackData trackData, int n) {
    }

    default public void updatePlaybackState(PlaybackInfo playbackInfo, int n) {
    }

    default public void updatePlayposition(int n, int n2) {
    }

    default public void updateCoverArtUrl(ResourceLocator resourceLocator, int n) {
    }

    default public void updateTextInputState(int n, int n2) {
    }

    default public void duckAudio(int n, double d2) {
    }

    default public void unduckAudio(int n) {
    }

    default public void oemAppSelected() {
    }

    default public void updateMainAudioType(int n, int n2) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}


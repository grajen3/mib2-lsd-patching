/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.androidauto2;

import org.dsi.ifc.androidauto2.CallState;
import org.dsi.ifc.androidauto2.PlaybackInfo;
import org.dsi.ifc.androidauto2.TelephonyState;
import org.dsi.ifc.androidauto2.TrackData;
import org.dsi.ifc.global.ResourceLocator;

public interface DSIAndroidAuto2Reply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void videoFocusRequestNotification(int n, int n2) {
    }

    default public void videoAvailable(boolean bl, int n) {
    }

    default public void audioFocusRequestNotification(int n, int n2) {
    }

    default public void audioAvailable(int n, boolean bl, int n2) {
    }

    default public void voiceSessionNotification(int n, int n2) {
    }

    default public void microphoneRequestNotification(int n, int n2) {
    }

    default public void navFocusRequestNotification(int n, int n2) {
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

    default public void updateNavigationNextTurnEvent(String string, int n, int n2, int n3, int n4, int n5) {
    }

    default public void updateNavigationNextTurnDistance(int n, int n2, int n3) {
    }

    default public void setExternalDestination(double d2, double d3, String string, String string2, int n) {
    }

    default public void bluetoothPairingRequest(String string, int n) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}


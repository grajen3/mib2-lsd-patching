/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.androidauto;

import org.dsi.ifc.androidauto.AppState;
import org.dsi.ifc.androidauto.AppStateRequest;
import org.dsi.ifc.androidauto.CallState;
import org.dsi.ifc.androidauto.PlaybackInfo;
import org.dsi.ifc.androidauto.Resource;
import org.dsi.ifc.androidauto.ResourceRequest;
import org.dsi.ifc.androidauto.TelephonyState;
import org.dsi.ifc.androidauto.TrackData;
import org.dsi.ifc.global.ResourceLocator;

public interface DSIAndroidAutoReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void setMode(Resource[] resourceArray, AppState[] appStateArray, int n) {
    }

    default public void requestModeChange(ResourceRequest[] resourceRequestArray, AppStateRequest[] appStateRequestArray, int n) {
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

    default public void setExternalDestination(double d2, double d3, String string, String string2) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carlife;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carlife.AppState;
import org.dsi.ifc.carlife.CallState;
import org.dsi.ifc.carlife.DeviceInfo;
import org.dsi.ifc.carlife.PlaybackInfo;
import org.dsi.ifc.carlife.PlaymodeInfo;
import org.dsi.ifc.carlife.Resource;
import org.dsi.ifc.carlife.TrackData;
import org.dsi.ifc.global.ResourceLocator;

public interface DSICarlifeListener
extends DSIListener {
    default public void responseSetMode(Resource[] resourceArray, AppState[] appStateArray) {
    }

    default public void updateCallState(CallState callState, int n) {
    }

    default public void updateNowPlayingData(TrackData trackData, int n) {
    }

    default public void updatePlaybackState(PlaybackInfo playbackInfo, int n) {
    }

    default public void updatePlaymodeState(PlaymodeInfo playmodeInfo, int n) {
    }

    default public void updatePlayposition(int n, int n2) {
    }

    default public void updateCoverArtUrl(ResourceLocator resourceLocator, int n) {
    }

    default public void updateNavigationNextTurnInfo(String string, int n, int n2, int n3, int n4, int n5) {
    }

    default public void updateDeviceInfo(DeviceInfo deviceInfo, int n) {
    }

    default public void requestModeChange(Resource[] resourceArray, AppState[] appStateArray) {
    }

    default public void updateVideoAvailable(boolean bl, int n) {
    }
}


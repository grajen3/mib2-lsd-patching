/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.map;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.map.PosInfo;
import org.dsi.ifc.map.Rect;
import org.dsi.ifc.map.StreetViewThumbnail;

public interface DSIMapViewerStreetViewCtrlListener
extends DSIListener {
    default public void updateStreetViewLoadStatus(int n, int n2) {
    }

    default public void updateStreetViewAvailable(boolean bl, int n) {
    }

    default public void updateStreetViewZoomListIndex(int n, int n2) {
    }

    default public void updateStreetViewZoomList(float[] fArray, int n) {
    }

    default public void updateStreetViewThumbnails(StreetViewThumbnail[] streetViewThumbnailArray, int n) {
    }

    default public void streetViewEnabled(boolean bl) {
    }

    default public void streetViewVisible(boolean bl) {
    }

    default public void streetViewFreeze(boolean bl) {
    }

    default public void updatePosition(NavLocationWgs84 navLocationWgs84, int n) {
    }

    default public void updateRotation(int n, int n2, int n3) {
    }

    default public void getInfoForPosition(PosInfo[] posInfoArray) {
    }

    default public void snapshotResult(StreetViewThumbnail streetViewThumbnail, int n) {
    }

    default public void updateScreenViewPort(Rect rect, int n) {
    }

    default public void updateStreetViewZoomLevel(float f2, int n) {
    }

    default public void updateStreetViewPosition(NavLocationWgs84 navLocationWgs84, boolean bl, int n) {
    }
}


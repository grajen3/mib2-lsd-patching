/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.map;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.map.INavigationPosInfo;

public interface NavigationMapListener {
    default public void updateMapViewerUsedBy(Object object) {
    }

    default public void updateGoToLocationMapReady() {
    }

    default public void lockMapViewerResult(boolean bl) {
    }

    default public void clickInMapResult(INavigationPosInfo[] iNavigationPosInfoArray) {
    }

    default public void updateMapLayerAvailable(int[] nArray) {
    }

    default public void updateMapLayerVisible(int[] nArray) {
    }

    default public void updateMapPosition(INavigationLocation iNavigationLocation) {
    }

    default public void zoomInDone() {
    }

    default public void updateZoomLevel(int n, int n2) {
    }

    default public void updateZoomList(int[] nArray) {
    }

    default public void updateHeadingValue(int n) {
    }

    default public void updateZoomValue(int n) {
    }

    default public void updateAltitudeValue(int n) {
    }

    default public void updateAutozoom(boolean bl) {
    }

    default public void updateMapPerspective(int n) {
    }

    default public void updateMapMode(int n) {
    }

    default public void updateOrientation(int n) {
    }

    default public void updateViewType(int n) {
    }

    default public void handleMapServiceError(int n, int n2, int n3) {
    }

    default public void updateMapType(int n) {
    }

    default public void updateLastMapType(int n) {
    }

    default public void updateGoogleEarthDataStatus(int n) {
    }

    default public void updateMapViewerSwitchRunning(boolean bl) {
    }
}


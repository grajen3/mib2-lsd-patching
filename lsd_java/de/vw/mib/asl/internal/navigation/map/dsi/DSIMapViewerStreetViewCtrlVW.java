/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi;

import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.map.Rect;

public interface DSIMapViewerStreetViewCtrlVW {
    default public void goToView() {
    }

    default public void loadStreetView(boolean bl) {
    }

    default public void rotateView(short s, short s2) {
    }

    default public void setCrossHairsVisibility(boolean bl) {
    }

    default public void setDayNightView(boolean bl) {
    }

    default public void setPosition(NavLocationWgs84 navLocationWgs84) {
    }

    default public void setScreenViewport(Rect rect) {
    }

    default public void setStreetViewZoomIndex(int n) {
    }

    default public void setStreetViewZoomLevel(float f2) {
    }

    default public void streetViewEnabled(boolean bl) {
    }

    default public void streetViewFreeze(boolean bl) {
    }

    default public void streetViewVisible(boolean bl) {
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navmaptile.listener;

import de.vw.mib.asl.api.navigation.map.NavigationMapListenerAdapter;
import de.vw.mib.asl.internal.navmaptile.NavMapTileTargetHSM;

public class NavigationMapListenerImpl
extends NavigationMapListenerAdapter {
    private final NavMapTileTargetHSM target;

    public NavigationMapListenerImpl(NavMapTileTargetHSM navMapTileTargetHSM) {
        this.target = navMapTileTargetHSM;
    }

    @Override
    public void updateAltitudeValue(int n) {
        this.target.notifyAltitudeValueChanged(n);
    }

    @Override
    public void updateAutozoom(boolean bl) {
        this.target.setAutoozoom(bl);
    }

    @Override
    public void updateHeadingValue(int n) {
        this.target.updateHeadingValue(n);
    }

    @Override
    public void updateMapPerspective(int n) {
        this.target.setMapPerspective(n);
    }

    public void reinitMapView() {
        this.target.reinitMapView();
    }

    @Override
    public void updateMapViewerUsedBy(Object object) {
        this.target.updateMapViewerUsedBy(object);
    }

    @Override
    public void updateMapMode(int n) {
        this.target.updateMapMode(n);
    }

    @Override
    public void updateMapType(int n) {
        this.target.notifyMapTypeChanged(n - 1);
    }

    @Override
    public void updateLastMapType(int n) {
        this.target.notifyLastMapTypeChanged(n - 1);
    }

    @Override
    public void updateOrientation(int n) {
        this.target.updateOrientation(n);
    }

    @Override
    public void updateViewType(int n) {
        this.target.updateViewType(n);
    }

    @Override
    public void updateZoomValue(int n) {
        this.target.updateZoomValue(n);
    }

    @Override
    public void updateGoogleEarthDataStatus(int n) {
        this.target.updateGoogleEarthDataStatus(n);
    }

    @Override
    public void updateMapViewerSwitchRunning(boolean bl) {
        this.target.updateMapViewerSwitchRunning(bl);
    }
}


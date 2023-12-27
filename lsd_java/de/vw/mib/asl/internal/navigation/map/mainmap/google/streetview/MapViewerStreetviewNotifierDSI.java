/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.google.streetview;

import de.vw.mib.asl.internal.navigation.map.dsi.DSIMapViewerControlVW;
import de.vw.mib.asl.internal.navigation.map.dsi.DSIMapViewerStreetViewCtrlVW;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerStreetViewCtrlFactoryVW;
import de.vw.mib.genericevents.AbstractTarget;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;
import org.dsi.ifc.navigation.DSINavigation;

public class MapViewerStreetviewNotifierDSI {
    private DSIMapViewerControlVW dsiMapViewerControl;
    private DSIMapViewerStreetViewCtrlVW dsiMapViewerStreetViewCtrl;
    private DSINavigation dsiNavigation;

    public void mapViewerViewSetInvisible() {
        this.dsiMapViewerControl.viewSetVisible(false);
    }

    public void mapViewerGetInfoForScreenPosition(AbstractTarget abstractTarget, Point point) {
        this.dsiMapViewerControl.getInfoForScreenPosition(abstractTarget, point);
    }

    public void mapViewerViewSetVisible() {
        this.dsiMapViewerControl.viewSetVisible(true);
    }

    public void navigationLiGetLocationDescriptionTransform(NavLocation navLocation) {
        this.dsiNavigation.liGetLocationDescriptionTransform(navLocation);
    }

    public void setDsiMapViewerControl(DSIMapViewerControlVW dSIMapViewerControlVW) {
        this.dsiMapViewerControl = dSIMapViewerControlVW;
    }

    public void setDsiMapViewerStreetViewCtrl(DSIMapViewerStreetViewCtrlVW dSIMapViewerStreetViewCtrlVW) {
        this.dsiMapViewerStreetViewCtrl = dSIMapViewerStreetViewCtrlVW;
    }

    public void setDsiNavigation(DSINavigation dSINavigation) {
        this.dsiNavigation = dSINavigation;
    }

    public void streetViewDragged(short s, short s2) {
        if (!DSIMapViewerStreetViewCtrlFactoryVW.getStreetViewCtrlDataPool().isServiceAvailable()) {
            return;
        }
        this.dsiMapViewerStreetViewCtrl.rotateView(s, s2);
    }

    public void streetViewEnabled(boolean bl) {
        this.dsiMapViewerStreetViewCtrl.streetViewEnabled(bl);
    }

    public void streetViewGoToView() {
        if (!DSIMapViewerStreetViewCtrlFactoryVW.getStreetViewCtrlDataPool().isServiceAvailable()) {
            return;
        }
        this.dsiMapViewerStreetViewCtrl.goToView();
    }

    public void streetViewLoadFalse() {
        if (!DSIMapViewerStreetViewCtrlFactoryVW.getStreetViewCtrlDataPool().isServiceAvailable()) {
            return;
        }
        if (this.dsiMapViewerStreetViewCtrl == null) {
            return;
        }
        this.dsiMapViewerStreetViewCtrl.loadStreetView(false);
    }

    public void streetViewLoadTrue() {
        if (!DSIMapViewerStreetViewCtrlFactoryVW.getStreetViewCtrlDataPool().isServiceAvailable()) {
            return;
        }
        if (this.dsiMapViewerStreetViewCtrl == null) {
            return;
        }
        this.dsiMapViewerStreetViewCtrl.loadStreetView(true);
    }

    public void streetViewSetCrosshairInvisible() {
        if (!DSIMapViewerStreetViewCtrlFactoryVW.getStreetViewCtrlDataPool().isServiceAvailable()) {
            return;
        }
        this.dsiMapViewerStreetViewCtrl.setCrossHairsVisibility(false);
    }

    public void streetViewSetCrosshairVisible() {
        if (!DSIMapViewerStreetViewCtrlFactoryVW.getStreetViewCtrlDataPool().isServiceAvailable()) {
            return;
        }
        this.dsiMapViewerStreetViewCtrl.setCrossHairsVisibility(true);
    }

    public void streetViewSetDayView() {
        if (!DSIMapViewerStreetViewCtrlFactoryVW.getStreetViewCtrlDataPool().isServiceAvailable()) {
            return;
        }
        this.dsiMapViewerStreetViewCtrl.setDayNightView(true);
    }

    public void streetViewSetInvisible() {
        if (!DSIMapViewerStreetViewCtrlFactoryVW.getStreetViewCtrlDataPool().isServiceAvailable()) {
            return;
        }
        this.dsiMapViewerStreetViewCtrl.streetViewVisible(false);
    }

    public void streetViewSetPosition(NavLocationWgs84 navLocationWgs84) {
        if (!DSIMapViewerStreetViewCtrlFactoryVW.getStreetViewCtrlDataPool().isServiceAvailable()) {
            return;
        }
        if (this.dsiMapViewerStreetViewCtrl == null) {
            return;
        }
        this.dsiMapViewerStreetViewCtrl.setPosition(navLocationWgs84);
    }

    public void streetViewSetScreenViewport(Rect rect) {
        this.dsiMapViewerStreetViewCtrl.setScreenViewport(rect);
    }

    public void streetViewSetViewFreezeFalse() {
        if (!DSIMapViewerStreetViewCtrlFactoryVW.getStreetViewCtrlDataPool().isServiceAvailable()) {
            return;
        }
        this.dsiMapViewerStreetViewCtrl.streetViewFreeze(false);
    }

    public void streetViewSetViewFreezeTrue() {
        if (!DSIMapViewerStreetViewCtrlFactoryVW.getStreetViewCtrlDataPool().isServiceAvailable()) {
            return;
        }
        this.dsiMapViewerStreetViewCtrl.streetViewFreeze(true);
    }

    public void streetViewSetVisible() {
        if (!DSIMapViewerStreetViewCtrlFactoryVW.getStreetViewCtrlDataPool().isServiceAvailable()) {
            return;
        }
        this.dsiMapViewerStreetViewCtrl.streetViewVisible(true);
    }

    public void streetViewSetZoomIndex(int n) {
        if (!DSIMapViewerStreetViewCtrlFactoryVW.getStreetViewCtrlDataPool().isServiceAvailable()) {
            return;
        }
        this.dsiMapViewerStreetViewCtrl.setStreetViewZoomIndex(n);
    }

    public void streetViewSetZoomLevel(float f2) {
        this.dsiMapViewerStreetViewCtrl.setStreetViewZoomLevel(f2 -= 1.0f);
    }
}


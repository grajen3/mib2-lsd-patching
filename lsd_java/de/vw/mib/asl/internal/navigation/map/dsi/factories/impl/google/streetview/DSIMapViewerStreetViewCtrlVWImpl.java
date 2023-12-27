/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.google.streetview;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.dsi.DSIMapViewerStreetViewCtrlVW;
import de.vw.mib.asl.internal.navigation.map.mainmap.MapViewerDatapoolShared;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.map.DSIMapViewerStreetViewCtrl;
import org.dsi.ifc.map.Rect;

public class DSIMapViewerStreetViewCtrlVWImpl
implements DSIMapViewerStreetViewCtrlVW {
    private boolean facadeEnabled;
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[DSIMapViewerStreetViewCtrlVWImpl]");
    private DSIMapViewerStreetViewCtrl mapViewerStreetViewCtrl;
    private MapViewerDatapoolShared mapDatapoolShared = MapViewerDatapoolShared.getInstance();

    @Override
    public void goToView() {
        this.logger.trace("goToView()");
        if (!this.isFacadeEnabled()) {
            this.logger.warn("The DSIMapViewerStreetViewCtrlVWImpl facade is currently disabled, the call will be ignored");
            return;
        }
        this.mapViewerStreetViewCtrl.goToView();
    }

    public boolean isFacadeEnabled() {
        return this.facadeEnabled;
    }

    @Override
    public void loadStreetView(boolean bl) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("loadStreetView(loadStreetView=").append(bl).append(")").log();
        }
        if (!this.isFacadeEnabled()) {
            this.logger.warn("The MapViewerGooglCtrl facade is currently disabled, the call will be ignored");
            return;
        }
        this.mapViewerStreetViewCtrl.loadStreetView(bl);
    }

    @Override
    public void rotateView(short s, short s2) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("rotateView(diffX=").append(s).append(", diffY=").append(s2).append(")").log();
        }
        if (!this.isFacadeEnabled()) {
            this.logger.warn("The MapViewerGooglCtrl facade is currently disabled, the call will be ignored");
            return;
        }
        this.mapViewerStreetViewCtrl.rotateView(s, s2);
    }

    @Override
    public void setCrossHairsVisibility(boolean bl) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("setCrossHairsVisibility(visible=").append(bl).append(")").log();
        }
        if (!this.isFacadeEnabled()) {
            this.logger.warn("The MapViewerGooglCtrl facade is currently disabled, the call will be ignored");
            return;
        }
        this.mapViewerStreetViewCtrl.setCrossHairsVisibility(bl);
    }

    @Override
    public void setDayNightView(boolean bl) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("").append(bl).append(")").log();
        }
        this.mapViewerStreetViewCtrl.setDayNightView(bl);
    }

    public void setFacadeEnabled(boolean bl) {
        this.facadeEnabled = bl;
    }

    public void setMapViewerStreetViewCtrl(DSIMapViewerStreetViewCtrl dSIMapViewerStreetViewCtrl) {
        this.mapViewerStreetViewCtrl = dSIMapViewerStreetViewCtrl;
    }

    @Override
    public void setPosition(NavLocationWgs84 navLocationWgs84) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("setPosition(position=").append(navLocationWgs84.toString()).append(")").log();
        }
        if (!this.isFacadeEnabled()) {
            this.logger.warn("The MapViewerGooglCtrl facade is currently disabled, the call will be ignored");
            return;
        }
        this.mapViewerStreetViewCtrl.setPosition(navLocationWgs84);
    }

    @Override
    public void setScreenViewport(Rect rect) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("setScreenViewport(screenViewPort=").append(rect.toString()).append(")").log();
        }
        if (!this.isFacadeEnabled()) {
            this.logger.warn("The MapViewerGooglCtrl facade is currently disabled, the call will be ignored");
            return;
        }
        this.mapViewerStreetViewCtrl.setScreenViewport(rect);
    }

    @Override
    public void setStreetViewZoomIndex(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("setStreetViewZoomIndex(zoomIndex=").append(n).append(")").log();
        }
        if (!this.isFacadeEnabled()) {
            this.logger.warn("The MapViewerGooglCtrl facade is currently disabled, the call will be ignored");
            return;
        }
        this.mapViewerStreetViewCtrl.setStreetViewZoomIndex(n);
    }

    @Override
    public void setStreetViewZoomLevel(float f2) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("setStreetViewZoomLevel(zoomLevel=").append(f2).append(")").log();
        }
        if (!this.isFacadeEnabled()) {
            this.logger.warn("The MapViewerGooglCtrl facade is currently disabled, the call 'setStreetViewZoomLevel()' will be ignored");
            return;
        }
        this.mapViewerStreetViewCtrl.setStreetViewZoomLevel(f2);
    }

    @Override
    public void streetViewEnabled(boolean bl) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("streetViewEnabled(enabled=").append(bl).append(")").log();
        }
        if (!this.isFacadeEnabled()) {
            this.logger.warn("The MapViewerGooglCtrl facade is currently disabled, the call will be ignored");
            return;
        }
        this.mapViewerStreetViewCtrl.streetViewEnabled(bl);
    }

    @Override
    public void streetViewFreeze(boolean bl) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("streetViewFreeze(freeze=").append(bl).append(")").log();
        }
        if (!this.isFacadeEnabled()) {
            this.logger.warn("The MapViewerGooglCtrl facade is currently disabled, the call will be ignored");
            return;
        }
        this.mapViewerStreetViewCtrl.streetViewFreeze(bl);
    }

    @Override
    public void streetViewVisible(boolean bl) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("streetViewVisible(visible=").append(bl).append(")").log();
        }
        if (!this.isFacadeEnabled()) {
            this.logger.warn("The MapViewerGooglCtrl facade is currently disabled, the call will be ignored");
            return;
        }
        this.mapViewerStreetViewCtrl.streetViewVisible(bl);
        this.mapDatapoolShared.setStreetViewVisible(bl);
    }
}


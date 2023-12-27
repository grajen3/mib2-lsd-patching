/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.zoomengine;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.dsi.DSIMapViewerZoomEngineVW;
import org.dsi.ifc.map.DSIMapViewerZoomEngine;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;

public class DSIMapViewerZoomEngineVWImpl
implements DSIMapViewerZoomEngineVW {
    private boolean facadeEnabled;
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[DSIMapViewerZoomEngineVWImpl]");
    private DSIMapViewerZoomEngine mapViewerZoomEngine;

    @Override
    public void autoZoomEnable(boolean bl) {
        if (!this.facadeEnabled) {
            this.logger.warn("The DSIMapViewerZoomEngine facade is currently disabled, the call 'autoZoomEnable( boolean enable )' will be ignored");
            return;
        }
        this.mapViewerZoomEngine.autoZoomEnable(bl);
        this.mapViewerZoomEngine.manoeuvreZoomEnable(bl);
    }

    public DSIMapViewerZoomEngine getMapViewerZoomEngine() {
        return this.mapViewerZoomEngine;
    }

    public boolean isFacadeEnabled() {
        return this.facadeEnabled;
    }

    @Override
    public void setCarPosition(Point point) {
        if (!this.facadeEnabled) {
            this.logger.warn("The DSIMapViewerZoomEngine facade is currently disabled, the call 'setCarPosition( Point screenCarPosition )' will be ignored");
            return;
        }
        this.mapViewerZoomEngine.setCarPosition(point);
    }

    public void setFacadeEnabled(boolean bl) {
        this.facadeEnabled = bl;
    }

    @Override
    public void setMapOrientation(int n) {
        if (!this.facadeEnabled) {
            this.logger.warn("The DSIMapViewerZoomEngine facade is currently disabled, the call 'setMapOrientation( int orientation, Point orientationByPoint )' will be ignored");
            return;
        }
        this.mapViewerZoomEngine.setMapOrientation(n, null);
    }

    @Override
    public void setMapRotation(short s) {
        if (!this.facadeEnabled) {
            this.logger.warn("The DSIMapViewerZoomEngine facade is currently disabled, the call 'setMapRotation( short mapRotation )' will be ignored");
            return;
        }
        this.mapViewerZoomEngine.setMapRotation(s);
    }

    public void setMapViewerZoomEngine(DSIMapViewerZoomEngine dSIMapViewerZoomEngine) {
        this.mapViewerZoomEngine = dSIMapViewerZoomEngine;
    }

    @Override
    public void setViewType(int n) {
        if (!this.facadeEnabled) {
            this.logger.warn("The DSIMapViewerZoomEngine facade is currently disabled, the call 'setViewType( int viewtype )' will be ignored");
            return;
        }
        this.mapViewerZoomEngine.setViewType(n);
    }

    @Override
    public void setZoomArea(Rect rect) {
        if (!this.facadeEnabled) {
            this.logger.warn("The DSIMapViewerZoomEngine facade is currently disabled, the call 'setZoomArea( Rect zoomArea )' will be ignored");
            return;
        }
        this.mapViewerZoomEngine.setZoomArea(rect);
    }
}


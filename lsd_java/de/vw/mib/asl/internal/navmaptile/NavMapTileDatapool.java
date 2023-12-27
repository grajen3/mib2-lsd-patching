/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navmaptile;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.map.ASLNavigationMapConfiguration;
import de.vw.mib.asl.internal.navmaptile.variant.VariantConstants;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;

public class NavMapTileDatapool {
    private Rect zoomArea = null;
    private boolean autozoomMainMapActivated = false;
    private boolean guidanceActive;
    private int zoomLevel = 100;
    private int mapMode = 1;
    private int perspectiveNoGuidance;
    private int perspective = -1;
    private int perspectiveCurrent;
    private int orientation = 0;
    private int viewType = 3;
    private Point carPosition = null;
    private Point hotPoint;
    private INavigationLocation location;
    private int zoomLevelOverview;
    private int zoomLevelMain;
    private ASLNavigationMapConfiguration backupMapConfiguration;

    public NavMapTileDatapool(VariantConstants variantConstants) {
    }

    public ASLNavigationMapConfiguration createMapConfiguration() {
        ASLNavigationMapConfiguration aSLNavigationMapConfiguration = new ASLNavigationMapConfiguration();
        aSLNavigationMapConfiguration.setAutozoom(this.autozoomMainMapActivated);
        aSLNavigationMapConfiguration.setZoomLevel(this.zoomLevel);
        aSLNavigationMapConfiguration.setMapMode(this.mapMode);
        aSLNavigationMapConfiguration.setOrientation(this.orientation);
        aSLNavigationMapConfiguration.setViewType(this.viewType);
        if (this.getMapMode() == 1) {
            aSLNavigationMapConfiguration.setCarPosition(this.carPosition);
        }
        if (this.perspective == 7) {
            aSLNavigationMapConfiguration.setPerspective(this.perspective);
        }
        aSLNavigationMapConfiguration.setZoomArea(this.getZoomArea());
        aSLNavigationMapConfiguration.setHotPoint(this.getHotPoint());
        return aSLNavigationMapConfiguration;
    }

    public Rect getZoomArea() {
        return this.zoomArea;
    }

    public boolean isAutozoomActivated() {
        return this.autozoomMainMapActivated;
    }

    public int getZoomLevel() {
        return this.zoomLevel;
    }

    public int getMapMode() {
        return this.mapMode;
    }

    public int getPerspective() {
        return this.perspective;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public int getViewType() {
        return this.viewType;
    }

    public Point getCarPosition() {
        return this.carPosition;
    }

    public void setZoomArea(Rect rect) {
        this.zoomArea = rect;
    }

    public void setAutozoomActivated(boolean bl) {
        this.autozoomMainMapActivated = bl;
    }

    public void setZoomLevel(int n) {
        this.zoomLevel = n;
    }

    public void setMapMode(int n) {
        this.mapMode = n;
    }

    public void setPerspective(int n) {
        this.perspective = n;
    }

    public void setOrientation(int n) {
        this.orientation = n;
    }

    public void setViewType(int n) {
        this.viewType = n;
    }

    public void setCarPosition(Point point) {
        this.carPosition = point;
    }

    public void setHotPoint(Point point) {
        this.hotPoint = point;
    }

    public Point getHotPoint() {
        return this.hotPoint;
    }

    public boolean isAutozoomCurrentlyActivated() {
        if (this.perspective == 3 || this.perspective == 2 || this.perspective == 1 || this.perspective == 7) {
            return false;
        }
        return this.autozoomMainMapActivated;
    }

    public int getZoomLevelOverview() {
        return this.zoomLevelOverview;
    }

    public void setZoomLevelOverview(int n) {
        this.zoomLevelOverview = n;
    }

    public INavigationLocation getLocation() {
        return this.location;
    }

    public void setLocation(INavigationLocation iNavigationLocation) {
        this.location = iNavigationLocation;
    }

    public boolean isPerspectiveCurrentOverview() {
        return this.isPerspectiveOverviewType(this.perspectiveCurrent);
    }

    public boolean isPerspectiveCurrentMain() {
        return this.isPerspectiveMainType(this.perspectiveCurrent);
    }

    private boolean isPerspectiveMainType(int n) {
        if (n == 4) {
            return true;
        }
        if (n == 5) {
            return true;
        }
        return n == 6;
    }

    private boolean isPerspectiveOverviewType(int n) {
        if (n == 7) {
            return true;
        }
        if (n == 3) {
            return true;
        }
        if (n == 1) {
            return true;
        }
        return n == 2;
    }

    public boolean isPerspectiveOverview() {
        return this.isPerspectiveOverviewType(this.perspective);
    }

    public boolean isPerspectiveMain() {
        return this.isPerspectiveMainType(this.perspective);
    }

    public boolean isConfigureRequired() {
        if (this.perspective == 7) {
            return true;
        }
        if (this.perspective == 3) {
            return true;
        }
        if (this.perspective == 1) {
            return true;
        }
        if (this.perspective == 2) {
            return true;
        }
        if (this.perspective == 4) {
            return true;
        }
        if (this.perspective == 5) {
            return true;
        }
        return this.perspective == 6;
    }

    public void prepareDefaultConfiguration() {
        if (this.perspective == 4) {
            this.setMapMode(1);
            this.setViewType(0);
            this.setOrientation(0);
        }
        if (this.perspective == 5) {
            this.setMapMode(1);
            this.setViewType(0);
            this.setOrientation(2);
        }
        if (this.perspective == 6) {
            this.setMapMode(1);
            this.setViewType(3);
            this.setOrientation(0);
        }
        if (this.perspective == 7) {
            this.setMapMode(14);
            this.setViewType(0);
            this.setOrientation(2);
        }
        if (this.perspective == 3) {
            this.setMapMode(10);
            this.setViewType(0);
            this.setOrientation(2);
        }
        if (this.perspective == 1) {
            this.setMapMode(9);
            this.setViewType(0);
            this.setOrientation(2);
        }
    }

    public void prepareConfiguration() {
        if (this.perspective == 7) {
            if (this.mapMode == 1) {
                this.setMapMode(14);
            }
            this.setViewType(0);
            this.setOrientation(2);
        }
        if (this.perspective == 3) {
            this.setMapMode(this.mapMode);
            this.setViewType(0);
            this.setOrientation(2);
        }
        if (this.perspective == 1) {
            this.setMapMode(this.mapMode);
            this.setViewType(0);
            this.setOrientation(2);
        }
        if (this.perspective == 4) {
            this.setMapMode(this.mapMode);
            this.setViewType(0);
            this.setOrientation(0);
        }
        if (this.perspective == 5) {
            this.setMapMode(this.mapMode);
            this.setViewType(0);
            this.setOrientation(2);
        }
        if (this.perspective == 6) {
            this.setMapMode(this.mapMode);
            this.setViewType(3);
            this.setOrientation(0);
        }
    }

    public void backupMapConfiguration() {
        this.backupMapConfiguration = this.createMapConfiguration();
    }

    public int getPerspectiveCurrent() {
        return this.perspectiveCurrent;
    }

    public void setPerspectiveCurrent(int n) {
        this.perspectiveCurrent = n;
    }

    public boolean isGuidanceActive() {
        return this.guidanceActive;
    }

    public void setGuidanceActive(boolean bl) {
        this.guidanceActive = bl;
    }

    public int getPerspectiveNoGuidance() {
        return this.perspectiveNoGuidance;
    }

    public void setPerspectiveNoGuidance(int n) {
        this.perspectiveNoGuidance = n;
    }

    public int getZoomLevelMain() {
        return this.zoomLevelMain;
    }

    public void setZoomLevelMain(int n) {
        this.zoomLevelMain = n;
    }
}


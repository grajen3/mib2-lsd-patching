/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.map;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.navigation.traffic.INavRectangle;
import de.vw.mib.asl.api.navigation.util.INavigationLocationHelper;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;
import org.dsi.ifc.navigation.util.ILocationAccessor;
import org.dsi.ifc.navigation.util.ILocationAccessorFactory;

public class ASLNavigationMapConfiguration {
    public static final int FLAG_STYLETYP_DEFAULT;
    public static final int MAP_LAYER_NO_LAYER;
    public static final int MAP_LAYER_SDARS_ISOBAR;
    public static final int MAP_LAYER_SDARS_RADAR;
    public static final int MAP_LAYER_SDARS_WEATHER;
    public static final int MAP_LAYER_VISIBLE_DEFAULT;
    public static final int MAP_MODE_RANGEVIEW;
    public static final int MAP_MODE_POSITIONMAP;
    public static final int MAP_MODE_FREEMAP;
    public static final int MAP_MODE_DEFAULT;
    public static final int ORIENTATION_HEADINGUP;
    public static final int ORIENTATION_NORTHUP;
    public static final int ORIENTATION_DEFAULT;
    public static final int MAP_VIEW_TYPE_2D;
    public static final int MAP_VIEW_TYPE_3D;
    public static final int MAP_VIEW_TYPE_DEFAULT;
    public static final int PERSPECTIVE_DESTINATION;
    public static final int PERSPECTIVE_FINAL_DESTINATION;
    public static final int PERSPECTIVE_OVERVIEW;
    public static final int PERSPECTIVE_2D_CAR_UP;
    public static final int PERSPECTIVE_2D_NORTH_UP;
    public static final int PERSPECTIVE_3D_CAR_UP;
    public static final int PERSPECTIVE_RANGEVIEW;
    public static final int PERSPECTIVE_TRAFFIC;
    public static final int PERSPECTIVE_OTHER;
    public static final int PERSPECTIVE_DEFAULT;
    public static final Rect ZOOM_AREA_DEFAULT;
    public static final int ZOOM_LEVEL_DEFAULT;
    public static final int ZOOM_LEVEL_MAX_DEFAULT;
    public static final int ZOOM_LEVEL_MIN_DEFAULT;
    public static final Rect ZOOM_AREA_DEFAULT_FPK_ENTRY;
    public static final Rect ZOOM_AREA_2D3D_FPK_ENTRY;
    public static final Rect ZOOM_AREA_DESTINATION_FPK_ENTRY;
    public static final Rect ZOOM_AREA_OVERVIEW;
    public static final Rect ZOOM_AREA_OVERVIEW_FPK_ENTRY;
    public static final Point CAR_POSITION_DEFAULT;
    public static final Point CAR_POSITION_DEFAULT_NORTHUP_FPK_ENTRY;
    public static final Point CAR_POSITION_DEFAULT_HEADINGUP_FPK_ENTRY;
    public static final Point HOT_POINT_2D_NORTH_FPK_ENTRY;
    public static final Point HOT_POINT_2D_3D_HEADING_FPK_ENTRY;
    public static final Point HOTPOINT_DEFAULT;
    public static final Point HOT_POINT_3D_AND_2D_HEADING;
    public static final Point HOT_POINT_OTHERS;
    public static final Point HOT_POINT_OVERVIEW_FPK_ENTRY;
    public static final Rect SCREEN_VIEW_PORT_MAP_KOMBI_FPK_ENTRY_HIGH;
    public static final INavRectangle MAP_VIEWPORT_BY_WGS84_RECTANGLE_DEFAULT;
    public static final int FPK_ENTRY_RESOLUTION_CLASS;
    public static final NavLocation GO_TO_LOCATION_DEFAULT;
    private int flagStyleType;
    private NavLocation navLocation;
    private int layerVisible;
    private int mapMode;
    private Rect zoomArea;
    private int zoomLevel;
    private boolean isAutozoom;
    private int mapViewType;
    private Point carPosition;
    private Point hotPoint;
    private int orientation;
    private int perspective;
    private Rect screenViewport;
    private Rect screenViewportMaximum;
    private INavRectangle mapViewPortByWGS84Rectangle;

    public int getPerspective() {
        return this.perspective;
    }

    public void setPerspective(int n) {
        this.perspective = n;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public void setOrientation(int n) {
        this.orientation = n;
    }

    public Point getCarPosition() {
        return this.carPosition;
    }

    public void setCarPosition(Point point) {
        this.carPosition = point;
    }

    public Point getHotPoint() {
        return this.hotPoint;
    }

    public void setHotPoint(Point point) {
        this.hotPoint = point;
    }

    public int getMapViewType() {
        return this.mapViewType;
    }

    public void setViewType(int n) {
        this.mapViewType = n;
    }

    public boolean isAutozoom() {
        return this.isAutozoom;
    }

    public void setAutozoom(boolean bl) {
        this.isAutozoom = bl;
    }

    public Rect getScreenViewport() {
        return this.screenViewport;
    }

    public void setScreenViewport(Rect rect) {
        this.screenViewport = rect;
    }

    public Rect getScreenViewportMaximum() {
        return this.screenViewportMaximum;
    }

    public void setScreenViewportMaximum(Rect rect) {
        this.screenViewportMaximum = rect;
    }

    public INavRectangle getMapViewPortByWGS84Rectangle() {
        return this.mapViewPortByWGS84Rectangle;
    }

    public void setMapViewPortByWGS84Rectangle(INavRectangle iNavRectangle) {
        this.mapViewPortByWGS84Rectangle = iNavRectangle;
    }

    public ASLNavigationMapConfiguration() {
        this.setFlagStyleType(29);
        this.setNavLocation(GO_TO_LOCATION_DEFAULT);
        this.setZoomArea(ZOOM_AREA_DEFAULT);
        this.setZoomLevel(10000);
        this.setAutozoom(false);
        this.setOrientation(0);
        this.setMapLayerVisible(-1);
        this.setCarPosition(CAR_POSITION_DEFAULT);
        this.setHotPoint(HOTPOINT_DEFAULT);
        this.setPerspective(-1);
        this.setMapMode(2);
        this.setViewType(0);
        this.setMapViewPortByWGS84Rectangle(MAP_VIEWPORT_BY_WGS84_RECTANGLE_DEFAULT);
    }

    public ASLNavigationMapConfiguration(boolean bl, int n) {
        this.setFlagStyleType(29);
        this.setNavLocation(GO_TO_LOCATION_DEFAULT);
        if (bl && 2 == n) {
            this.setZoomArea(ZOOM_AREA_DEFAULT_FPK_ENTRY);
            this.setHotPoint(HOT_POINT_2D_NORTH_FPK_ENTRY);
            this.setCarPosition(CAR_POSITION_DEFAULT_NORTHUP_FPK_ENTRY);
        } else {
            this.setZoomArea(ZOOM_AREA_DEFAULT);
            this.setHotPoint(HOTPOINT_DEFAULT);
            this.setCarPosition(CAR_POSITION_DEFAULT);
        }
        this.setZoomLevel(10000);
        this.setAutozoom(false);
        this.setOrientation(0);
        this.setMapLayerVisible(-1);
        this.setPerspective(-1);
        this.setMapMode(2);
        this.setViewType(0);
        this.setMapViewPortByWGS84Rectangle(MAP_VIEWPORT_BY_WGS84_RECTANGLE_DEFAULT);
    }

    public int getFlagStyleType() {
        return this.flagStyleType;
    }

    public NavLocation getNavLocation() {
        return this.navLocation;
    }

    public int getMapLayerVisible() {
        return this.layerVisible;
    }

    public int getMapMode() {
        return this.mapMode;
    }

    public Rect getZoomArea() {
        return this.zoomArea;
    }

    public int getZoomLevel() {
        return this.zoomLevel;
    }

    public void setFlagStyleType(int n) {
        this.flagStyleType = n;
    }

    public void setNavigationLocation(INavigationLocation iNavigationLocation) {
        if (iNavigationLocation == null) {
            this.navLocation = null;
        } else if (iNavigationLocation instanceof INavigationLocationHelper) {
            this.navLocation = ((INavigationLocationHelper)((Object)iNavigationLocation)).getRealLocation();
        } else {
            throw new NavigationServiceException("illegal argument");
        }
    }

    public void setNavLocation(NavLocation navLocation) {
        this.navLocation = navLocation;
    }

    private int decimalToDsi(double d2) {
        return (int)(d2 * 1.1930464E7);
    }

    public void setNavLocation(double d2, double d3) {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        ILocationAccessorFactory iLocationAccessorFactory = dSIProxy.getLocationAccessorFactory();
        if (iLocationAccessorFactory != null) {
            ILocationAccessor iLocationAccessor = iLocationAccessorFactory.createLocationAccessorFromGeoPos(this.decimalToDsi(d2), this.decimalToDsi(d3));
            this.navLocation = iLocationAccessorFactory.toLocation(iLocationAccessor);
        }
    }

    public void setMapLayerVisible(int n) {
        this.layerVisible = n;
    }

    public void setMapMode(int n) {
        this.mapMode = n;
    }

    public void setZoomArea(Rect rect) {
        this.zoomArea = rect;
    }

    public void setZoomLevel(int n) {
        this.zoomLevel = n;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ASLNavigationMapConfiguration={").append("flagStyleType=").append(this.flagStyleType).append(", layer=").append(this.layerVisible).append(", navLocation=").append(this.navLocation == null ? "null" : this.navLocation.toString()).append(", mode=").append(this.mapMode).append(", orientation=").append(this.orientation).append(", viewType=").append(this.mapViewType).append(", perspective=").append(this.perspective).append(", isAutozoom=").append(this.isAutozoom).append(", zoomArea=").append(this.zoomArea == null ? "null" : this.zoomArea.toString()).append(", zoomLevel=").append(this.zoomLevel).append(", carPosition=").append(this.carPosition == null ? "null" : this.carPosition.toString()).append("}");
        return stringBuffer.toString();
    }

    static {
        ZOOM_AREA_DEFAULT = new Rect(0, 0, 800, 480);
        ZOOM_AREA_DEFAULT_FPK_ENTRY = new Rect(0, 0, 1010, 376);
        ZOOM_AREA_2D3D_FPK_ENTRY = new Rect(368, 111, 274, 194);
        ZOOM_AREA_DESTINATION_FPK_ENTRY = new Rect(0, 0, 1010, 376);
        ZOOM_AREA_OVERVIEW = new Rect(207, 91, 388, 327);
        ZOOM_AREA_OVERVIEW_FPK_ENTRY = new Rect(354, 105, 302, 244);
        CAR_POSITION_DEFAULT = new Point(400, 240);
        CAR_POSITION_DEFAULT_NORTHUP_FPK_ENTRY = new Point(505, 188);
        CAR_POSITION_DEFAULT_HEADINGUP_FPK_ENTRY = new Point(505, 249);
        HOT_POINT_2D_NORTH_FPK_ENTRY = new Point(505, 188);
        HOT_POINT_2D_3D_HEADING_FPK_ENTRY = new Point(505, 265);
        HOTPOINT_DEFAULT = new Point(0, 0);
        HOT_POINT_3D_AND_2D_HEADING = new Point(400, 353);
        HOT_POINT_OTHERS = new Point(400, 248);
        HOT_POINT_OVERVIEW_FPK_ENTRY = new Point(505, 198);
        SCREEN_VIEW_PORT_MAP_KOMBI_FPK_ENTRY_HIGH = new Rect(0, 0, 1010, 376);
        MAP_VIEWPORT_BY_WGS84_RECTANGLE_DEFAULT = null;
        GO_TO_LOCATION_DEFAULT = null;
    }
}


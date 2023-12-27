/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.setup;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IPersistenceDefaults;
import de.vw.mib.asl.api.navigation.util.PersistableMap;
import de.vw.mib.asl.api.navigation.util.ReloadPersistedDataListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.map.MapViewerUtils;
import de.vw.mib.asl.internal.navigation.map.setup.PersistedMapSetup$Holder;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;

public class PersistedMapSetup
implements ReloadPersistedDataListener {
    private static final String AUTOZOOM_MAIN_MAP;
    private static final int AUTOZOOM_MAIN_MAP_DEFAULT;
    private static final String AUTOZOOM_MAP_IN_MAP;
    private static final boolean AUTOZOOM_MAP_IN_MAP_DEFAULT;
    private static final String AUTOZOOM_RECOMMENDED_ZOOM_LAST;
    private static final int AUTOZOOM_RECOMMENDED_ZOOM_LAST_DEFAULT;
    private static final String DUALSCREEN_VISIBILITIES;
    private static final int[] DUALSCREEN_VISIBILITIES_DEFAULT;
    public static final int GOOGLE_EARTH_LAYER_BUSINESS;
    public static final int GOOGLE_EARTH_LAYER_PANORAMIO;
    public static final int GOOGLE_EARTH_LAYER_PLACES;
    public static final int GOOGLE_EARTH_LAYER_WIKIPEDIA;
    private static final String GOOGLE_EARTH_VISIBLE_LAYER;
    private static final int[] GOOGLE_EARTH_VISIBLE_LAYER_DEFAULT;
    private static final String LANE_GUIDANCE;
    private static final String MAP_IN_KOMBI_PERSPECTIVE;
    private static final int MAP_IN_KOMBI_PERSPECTIVE_DEFAULT;
    private static final String MAIN_MAP_CAR_POSITION;
    private static final Point MAIN_MAP_CAR_POSITION_DEFAULT;
    private static final String MAIN_MAP_CONTENT;
    private static final int MAIN_MAP_CONTENT_DEFAULT;
    private static final String MAIN_MAP_LAST_MAP_TYPE;
    private static final int MAIN_MAP_LAST_MAP_TYPE_DEFAULT;
    private static final String MAIN_MAP_MAP_MODE;
    private static final int MAIN_MAP_MAP_MODE_DEFAULT;
    private static final String MAIN_MAP_ORIENTATION;
    private static final int MAIN_MAP_ORIENTATION_DEFAULT;
    private static final String MAIN_MAP_SHOW_ICONS_BRANDS;
    private static final String MAIN_MAP_SHOW_ICONS_FAVORITES;
    private static final String MAIN_MAP_SHOW_ICONS_POIS;
    private static final boolean MAIN_MAP_SHOW_ICONS_POIS_DEFAULT;
    private static final String MAIN_MAP_LOCATED_IN_ABT;
    private static final boolean MAIN_MAP_LOCATED_IN_ABT_DEFAULT;
    private static final String MAIN_MAP_LOCATED_IN_KOMBI;
    private static final boolean MAIN_MAP_LOCATED_IN_KOMBI_DEFAULT;
    private static final String MAIN_MAP_ZOOM_LEVEL;
    private static final String KOMBI_MAP_ZOOM_LEVEL;
    private static final String KOMBI_MAP_AUTOZOOM;
    private static final int MAIN_MAP_ZOOM_LEVEL_DEFAULT;
    public static final int KOMBI_MAP_ZOOM_LEVEL_DEFAULT;
    private static final boolean KOMBI_MAP_AUTOZOOM_DEFAULT;
    private static final String MAP_IN_MAP_CAR_POSITION;
    private static final Point MAP_IN_MAP_CAR_POSITION_DEFAULT;
    private static final String MAP_IN_MAP_MODE;
    private static final int MAP_IN_MAP_MODE_DEFAULT;
    private static final String MAP_IN_MAP_ORIENTATION;
    private static final int MAP_IN_MAP_ORIENTATION_DEFAULT;
    private static final String MAP_IN_MAP_VIEW_PORT;
    private static final Rect MAP_IN_MAP_VIEW_PORT_DEFAULT;
    private static final String MAP_IN_MAP_ZOOM_LEVEL;
    private static final int MAP_IN_MAP_ZOOM_LEVEL_DEFAULT;
    private static final String MOBILITY_HORIZON_CONSIDERED_LOCATION_TYPES;
    private static final int[] MOBILITY_HORIZON_CONSIDERED_LOCATION_TYPES_DEFAULT;
    private static final String SPLIT_SCREEN_CONTENT_GUIDANCE;
    private static final int SPLIT_SCREEN_CONTENT_GUIDANCE_DEFAULT;
    private static final String SPLIT_SCREEN_CONTENT_GUIDANCE_NO;
    private static final int SPLIT_SCREEN_CONTENT_GUIDANCE_NO_DEFAULT;
    private static final String SPLIT_SCREEN_GUIDANCE;
    private static final boolean SPLIT_SCREEN_GUIDANCE_DEFAULT;
    private static final String SPLIT_SCREEN_GUIDANCE_NO;
    private static final boolean SPLIT_SCREEN_GUIDANCE_NO_DEFAULT;
    private static final int HMI_MAIN_MAP_AUTOZOOM_OFF;
    private static final int HMI_MAIN_MAP_AUTOZOOM_ON;
    private PersistableMap persistableMap = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getExtendedNavPersistence().getPersistableMap("map");
    private PersistableMap persistableMapAutozoom = this.persistableMap.getPersistableMap("autozoom");
    private PersistableMap persistableMapDualscreen = this.persistableMap.getPersistableMap("dualscreen");
    private PersistableMap persistableMapGoogle = this.persistableMap.getPersistableMap("google");
    private PersistableMap persistableMapMainMap = this.persistableMap.getPersistableMap("mainmap");
    private PersistableMap persistableMapKombi = this.persistableMap.getPersistableMap("kombimap");
    private PersistableMap persistableMapMapInMap = this.persistableMap.getPersistableMap("mapinmap");
    private PersistableMap persistableMapMobilityHorizon = this.persistableMap.getPersistableMap("mobilityhorizon");
    private PersistableMap persistableMapSplitscreen = this.persistableMap.getPersistableMap("splitscreen");

    public static final PersistedMapSetup getInstance() {
        return PersistedMapSetup$Holder.INSTANCE;
    }

    PersistedMapSetup() {
        for (int i2 = 0; i2 < DUALSCREEN_VISIBILITIES_DEFAULT.length; ++i2) {
            PersistedMapSetup.DUALSCREEN_VISIBILITIES_DEFAULT[i2] = 1;
        }
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().addReloadPersistedDataListener(this);
    }

    public void clear() {
        this.persistableMap.clear();
    }

    public int getAutoZoomRecommendedZoomLast() {
        int n = this.persistableMapAutozoom.getInt("recommendedzoom.last", 10000);
        n = (int)MapViewerUtils.checkZoomLevelIsInRange(n);
        return n;
    }

    public int[] getDualScreenVisibilities() {
        return this.persistableMapDualscreen.getIntArray("dualscreen.visibilities", DUALSCREEN_VISIBILITIES_DEFAULT);
    }

    public int[] getGoogleEarthVisibleLayer() {
        return this.persistableMapGoogle.getIntArray("earth.visible.layer", GOOGLE_EARTH_VISIBLE_LAYER_DEFAULT);
    }

    public int getMapInKombiPerspective() {
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            return ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().getMapOrientationKombiFpk();
        }
        return this.persistableMap.getInt("kombi.perspective", 2);
    }

    public Point getMainMapCarPosition() {
        return this.persistableMapMainMap.getPoint("carpos", MAIN_MAP_CAR_POSITION_DEFAULT);
    }

    public int getMainMapContent() {
        return this.persistableMapMainMap.getInt("content", 0);
    }

    public int getMainMapMapTypeLast() {
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            return ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().getMainMapTypeLast();
        }
        return this.persistableMapMainMap.getInt("last.map.type", 0);
    }

    public int getMainMapMapMode() {
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            return ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().getMainMapMapMode();
        }
        return this.persistableMapMainMap.getInt("map.mode", 1);
    }

    public int getMainMapPerspective() {
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            return ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().getMainMapOrientation();
        }
        return this.persistableMapMainMap.getInt("orientation", 0);
    }

    public int getKombiMapZoomLevel() {
        int n = this.persistableMapKombi.getInt("zoomlevelKombi", 10000);
        n = (int)MapViewerUtils.checkZoomLevelIsInRange(n);
        return n;
    }

    public boolean getKombiMapAutoZoom() {
        return this.persistableMapKombi.getBoolean("autozoomKombi", true);
    }

    public int getMainMapZoomLevel() {
        int n = this.persistableMapMainMap.getInt("zoomlevel", 10000);
        n = (int)MapViewerUtils.checkZoomLevelIsInRange(n);
        return n;
    }

    public Point getMapInMapCarPosition() {
        return this.persistableMapMapInMap.getPoint("carpos", MAP_IN_MAP_CAR_POSITION_DEFAULT);
    }

    public int getMapInMapMode() {
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            return ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().getMapInMapMode();
        }
        return this.persistableMapMapInMap.getInt("mode", 1);
    }

    public int getMapInMapOrientation() {
        return this.persistableMapMapInMap.getInt("orientation", 0);
    }

    public Rect getMapInMapScreenViewPort() {
        return this.persistableMapMapInMap.getRect("viewport", MAP_IN_MAP_VIEW_PORT_DEFAULT);
    }

    public int getMapInMapZoomLevel() {
        return this.persistableMapMapInMap.getInt("zoomlevel", 20000);
    }

    public int[] getMobilityHorizonConsideredLocationTypes() {
        return this.persistableMapMobilityHorizon.getIntArray("considered.location.types", MOBILITY_HORIZON_CONSIDERED_LOCATION_TYPES_DEFAULT);
    }

    public int getSplitScreenContentGuidance() {
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            return ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().getSplitScreenGuidanceContent();
        }
        return this.persistableMapSplitscreen.getInt("content.guidance", SPLIT_SCREEN_CONTENT_GUIDANCE_DEFAULT);
    }

    public int getSplitScreenContentNoGuidance() {
        int n = 1;
        n = ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE") ? ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().getSplitScreenNoGuidanceContent() : this.persistableMapSplitscreen.getInt("content.guidance.no", SPLIT_SCREEN_CONTENT_GUIDANCE_NO_DEFAULT);
        if (n < 0 || n > 5) {
            ServiceManager.logger.error(16384).append("SPLIT_SCREEN_CONTENT_GUIDANCE_NO out of range: ").append(n).append(" setting to: ").append(1).log();
            n = 1;
            this.setSplitScreenContentNoGuidance(n);
        }
        return n;
    }

    public int getMainMapAutoZoomMode() {
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            return ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().getMainMapAutoZoomMode();
        }
        return this.persistableMapAutozoom.getInt("mainmap", 1);
    }

    public boolean isAutoZoomMapInMap() {
        return this.persistableMapAutozoom.getBoolean("mapinmap", true);
    }

    public boolean isLaneGuidance() {
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            return ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().isMapMainLaneGuidance();
        }
        return this.persistableMapMainMap.getBoolean("laneguidance", true);
    }

    public boolean isMainMapShowBrandIcons() {
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            return ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().isMapMainMapShowBrandIcons();
        }
        return this.persistableMapMainMap.getBoolean("show.icons.brands", true);
    }

    public boolean isMainMapShowFavoritesIcons() {
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            return ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().isMapMainMapShowFavoriteIcons();
        }
        return this.persistableMapMainMap.getBoolean("show.icons.favorites", true);
    }

    public boolean isMainMapShowPoiIcons() {
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            return ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().isMainMapShowPoiIcons();
        }
        return this.persistableMapMainMap.getBoolean("show.icons.pois", true);
    }

    public boolean isMapLocatedInABT() {
        return this.persistableMapMainMap.getBoolean("map.located.abt", true);
    }

    public boolean isMapLocatedInKombi() {
        return this.persistableMapMainMap.getBoolean("map.located.kombi", false);
    }

    public boolean isSplitScreenGuidance() {
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            return ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().isSplitScreenGuidanceVisible();
        }
        return this.persistableMapSplitscreen.getBoolean("guidance", SPLIT_SCREEN_GUIDANCE_DEFAULT);
    }

    public boolean isSplitScreenNoGuidance() {
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            return ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().isSplitScreenNoGuidanceVisible();
        }
        return this.persistableMapSplitscreen.getBoolean("guidance.no", SPLIT_SCREEN_GUIDANCE_NO_DEFAULT);
    }

    @Override
    public void reloadPersistedData() {
    }

    public void setMainMapAutoZoomMode(int n) {
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().setMainMapAutoZoomMode(n);
        } else {
            this.persistableMapAutozoom.setInt("mainmap", n);
        }
    }

    public void setAutoZoomMainMap(boolean bl) {
        if (bl) {
            this.setMainMapAutoZoomMode(1);
        } else {
            this.setMainMapAutoZoomMode(0);
        }
    }

    public void setAutoZoomMapInMap(boolean bl) {
        this.persistableMapAutozoom.setBoolean("mapinmap", bl);
    }

    public void setAutozoomRecommendedZoomLast(int n) {
        this.persistableMapAutozoom.setInt("recommendedzoom.last", n);
        this.persistableMapAutozoom.setSurviving("recommendedzoom.last", true);
    }

    public void setDualScreenVisibilities(int[] nArray) {
    }

    public void setGoogleEarthVisibleLayer(int[] nArray) {
        this.persistableMapGoogle.setIntArray("earth.visible.layer", nArray);
    }

    public void setLaneGuidance(boolean bl) {
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().setMapMainLaneGuidance(bl);
        } else {
            this.persistableMapMainMap.setBoolean("laneguidance", bl);
        }
    }

    public void setMainMapCarPosition(Point point) {
        this.persistableMapMainMap.setPoint("carpos", point);
    }

    public void setMainMapContent(int n) {
        this.persistableMapMainMap.setInt("content", n);
    }

    public void setMainMapLastMapType(int n) {
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().setMainMapTypeLast(n);
        } else {
            this.persistableMapMainMap.setInt("last.map.type", n);
        }
    }

    public void setMainMapOrientation(int n) {
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().setMainMapOrientation(n);
        } else {
            this.persistableMapMainMap.setInt("orientation", n);
        }
    }

    public void setMainMapShowBrandIcons(boolean bl) {
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().setMapMainMapShowBrandIcons(bl);
        } else {
            this.persistableMapMainMap.setBoolean("show.icons.brands", bl);
        }
    }

    public void setMainMapShowFavorites(boolean bl) {
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().setMapMainMapShowFavoriteIcons(bl);
        } else {
            this.persistableMapMainMap.setBoolean("show.icons.favorites", bl);
        }
    }

    public void setMainMapShowPoiIcons(boolean bl) {
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().setMainMapShowPoiIcons(bl);
        } else {
            this.persistableMapMainMap.setBoolean("show.icons.pois", bl);
        }
    }

    public void setMainMapLocatedInAbt(boolean bl) {
        this.persistableMapMainMap.setBoolean("map.located.abt", bl);
    }

    public void setMainMapLocatedInKombi(boolean bl) {
        this.persistableMapMainMap.setBoolean("map.located.kombi", bl);
    }

    public void setMainMapMapMode(int n) {
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().setMainMapMode(n);
        } else {
            this.persistableMapMainMap.setInt("map.mode", n);
        }
    }

    public void setKombiMapAutoZoom(boolean bl) {
        this.persistableMapKombi.setBoolean("autozoomKombi", bl);
    }

    public void setKombiMapZoomLevel(int n) {
        this.persistableMapKombi.setInt("zoomlevelKombi", n);
    }

    public void setMainMapZoomLevel(int n) {
        this.persistableMapMainMap.setInt("zoomlevel", n);
    }

    public void setMapInMapCarPosition(Point point) {
        this.persistableMapMapInMap.setPoint("carpos", point);
    }

    public void setMapInMapMode(int n) {
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().setMapInMapMode(n);
        } else {
            this.persistableMapMapInMap.setInt("mode", n);
        }
    }

    public void setMapInMapOrientation(int n) {
        this.persistableMapMapInMap.setInt("orientation", n);
    }

    public void setMapInMapScreenViewPort(Rect rect) {
        this.persistableMapMapInMap.setRect("viewport", rect);
    }

    public void setMapInMapZoomLevel(int n) {
        this.persistableMapMapInMap.setInt("zoomlevel", n);
    }

    public void setMobilityHorizonConsideredLocationTypes(int[] nArray) {
        this.persistableMapMobilityHorizon.setIntArray("considered.location.types", nArray);
    }

    public void setMapInKombiPerspective(int n) {
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().setMapOrientationKombiFpk(n);
        } else {
            this.persistableMap.setInt("kombi.perspective", n);
        }
    }

    public void setSplitScreenContentGuidance(int n) {
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().setSplitScreenGuidanceContent(n);
        } else {
            this.persistableMapSplitscreen.setInt("content.guidance", n);
        }
    }

    public void setSplitScreenContentNoGuidance(int n) {
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().setSplitScreenNoGuidanceContent(n);
        } else {
            this.persistableMapSplitscreen.setInt("content.guidance.no", n);
        }
    }

    public void setSplitScreenGuidance(boolean bl) {
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().setSplitScreenGuidanceVisibility(bl);
        } else {
            this.persistableMapSplitscreen.setBoolean("guidance", bl);
        }
    }

    public void setSplitScreenNoGuidance(boolean bl) {
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().setSplitScreenNoGuidanceVisibility(bl);
        } else {
            this.persistableMapSplitscreen.setBoolean("guidance.no", bl);
        }
    }

    public boolean isAutoZoomMainMap() {
        return this.getMainMapAutoZoomMode() == 1;
    }

    public void setDayNightModeMainMap(int n) {
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().setDayNightMainMapMode(n);
    }

    public int getDayNightModeMainMap() {
        return ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().getDayNightMainMapMode();
    }

    static {
        DUALSCREEN_VISIBILITIES_DEFAULT = new int[14];
        GOOGLE_EARTH_VISIBLE_LAYER_DEFAULT = new int[]{0, 1, 2, 3};
        MAIN_MAP_CAR_POSITION_DEFAULT = new Point(400, 200);
        MAP_IN_MAP_CAR_POSITION_DEFAULT = new Point(50, 100);
        MAP_IN_MAP_VIEW_PORT_DEFAULT = new Rect(0, 0, 100, 200);
        MOBILITY_HORIZON_CONSIDERED_LOCATION_TYPES_DEFAULT = new int[]{1};
        SPLIT_SCREEN_CONTENT_GUIDANCE_DEFAULT = IPersistenceDefaults.HMI_SPLIT_SCREEN_GUIDANCE_CONTENT_DEFAULT;
        SPLIT_SCREEN_CONTENT_GUIDANCE_NO_DEFAULT = IPersistenceDefaults.HMI_SPLIT_SCREEN_NO_GUIDANCE_CONTENT_DEFAULT;
        SPLIT_SCREEN_GUIDANCE_DEFAULT = IPersistenceDefaults.HMI_SPLIT_SCREEN_GUIDANCE_VISIBILITY_DEFAULT;
        SPLIT_SCREEN_GUIDANCE_NO_DEFAULT = IPersistenceDefaults.HMI_SPLIT_SCREEN_NO_GUIDANCE_VISIBILITY_DEFAULT;
    }
}


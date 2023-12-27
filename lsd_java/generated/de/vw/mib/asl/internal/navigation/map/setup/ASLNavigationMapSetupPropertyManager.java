/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.map.setup;

import org.dsi.ifc.global.ResourceLocator;

public interface ASLNavigationMapSetupPropertyManager {
    public static final int BRAND_MARKER;
    public static final boolean BRAND_MARKER__DEFAULT_VALUE;
    public static final boolean BRAND_MARKER__C0_FALSE;
    public static final boolean BRAND_MARKER__C1_TRUE;
    public static final int PERSPECTIVE;
    public static final int PERSPECTIVE__DEFAULT_VALUE;
    public static final int PERSPECTIVE__C0_2DNORTH;
    public static final int PERSPECTIVE__C1_2DHEADING;
    public static final int PERSPECTIVE__C2_25DHEADING;
    public static final int PERSPECTIVE__C3_3DHEADING;
    public static final int PERSPECTIVE__C4_3DDTM;
    public static final int AUTO_ZOOM;
    public static final boolean AUTO_ZOOM__DEFAULT_VALUE;
    public static final boolean AUTO_ZOOM__C0_FALSE;
    public static final boolean AUTO_ZOOM__C1_TRUE;
    public static final int LANE_GUIDANCE;
    public static final boolean LANE_GUIDANCE__DEFAULT_VALUE;
    public static final boolean LANE_GUIDANCE__C0_FALSE;
    public static final boolean LANE_GUIDANCE__C1_TRUE;
    public static final int MANEUVER_ZOOM;
    public static final boolean MANEUVER_ZOOM__DEFAULT_VALUE;
    public static final boolean MANEUVER_ZOOM__C0_FALSE;
    public static final boolean MANEUVER_ZOOM__C1_TRUE;
    public static final int SHOW_FAVORITES;
    public static final boolean SHOW_FAVORITES__DEFAULT_VALUE;
    public static final boolean SHOW_FAVORITES__C0_FALSE;
    public static final boolean SHOW_FAVORITES__C1_TRUE;
    public static final int SHOW_POI;
    public static final boolean SHOW_POI__DEFAULT_VALUE;
    public static final boolean SHOW_POI__C0_FALSE;
    public static final boolean SHOW_POI__C1_TRUE;
    public static final int SHOW_TMC_EVENTS;
    public static final boolean SHOW_TMC_EVENTS__DEFAULT_VALUE;
    public static final boolean SHOW_TMC_EVENTS__C0_FALSE;
    public static final boolean SHOW_TMC_EVENTS__C1_TRUE;
    public static final int SPEED_AND_FLOW_DATA_VISIBLE;
    public static final boolean SPEED_AND_FLOW_DATA_VISIBLE__DEFAULT_VALUE;
    public static final boolean SPEED_AND_FLOW_DATA_VISIBLE__C0_FALSE;
    public static final boolean SPEED_AND_FLOW_DATA_VISIBLE__C1_TRUE;
    public static final int RANGE_VIEW_TYPE;
    public static final int RANGE_VIEW_TYPE__DEFAULT_VALUE;
    public static final int RANGE_VIEW_TYPE__C0_COMBINED;
    public static final int RANGE_VIEW_TYPE__C1_ONE_WAY;
    public static final int RANGE_VIEW_TYPE__C2_SAVE_RETURN;
    public static final int RANGE_VIEW_SERVICE_AVAILABLE;
    public static final boolean RANGE_VIEW_SERVICE_AVAILABLE__DEFAULT_VALUE;
    public static final boolean RANGE_VIEW_SERVICE_AVAILABLE__C0_FALSE;
    public static final boolean RANGE_VIEW_SERVICE_AVAILABLE__C1_TRUE;
    public static final int SHOW_TRAFFIC_FREE_FLOW;
    public static final boolean SHOW_TRAFFIC_FREE_FLOW__DEFAULT_VALUE;
    public static final boolean SHOW_TRAFFIC_FREE_FLOW__C0_FALSE;
    public static final boolean SHOW_TRAFFIC_FREE_FLOW__C1_TRUE;
    public static final int SHOW_TRAFFIC_CONGESTIONS;
    public static final boolean SHOW_TRAFFIC_CONGESTIONS__DEFAULT_VALUE;
    public static final boolean SHOW_TRAFFIC_CONGESTIONS__C0_FALSE;
    public static final boolean SHOW_TRAFFIC_CONGESTIONS__C1_TRUE;
    public static final int SHOW_TRAFFIC_INCIDENTS;
    public static final boolean SHOW_TRAFFIC_INCIDENTS__DEFAULT_VALUE;
    public static final boolean SHOW_TRAFFIC_INCIDENTS__C0_FALSE;
    public static final boolean SHOW_TRAFFIC_INCIDENTS__C1_TRUE;
    public static final int SHOW_GOOGLE_EARTH_LAYER_PLACES;
    public static final boolean SHOW_GOOGLE_EARTH_LAYER_PLACES__DEFAULT_VALUE;
    public static final boolean SHOW_GOOGLE_EARTH_LAYER_PLACES__C0_FALSE;
    public static final boolean SHOW_GOOGLE_EARTH_LAYER_PLACES__C1_TRUE;
    public static final int SHOW_GOOGLE_EARTH_LAYER_BUSINESS;
    public static final boolean SHOW_GOOGLE_EARTH_LAYER_BUSINESS__DEFAULT_VALUE;
    public static final boolean SHOW_GOOGLE_EARTH_LAYER_BUSINESS__C0_FALSE;
    public static final boolean SHOW_GOOGLE_EARTH_LAYER_BUSINESS__C1_TRUE;
    public static final int SHOW_GOOGLE_EARTH_LAYER_PANORAMIO;
    public static final boolean SHOW_GOOGLE_EARTH_LAYER_PANORAMIO__DEFAULT_VALUE;
    public static final boolean SHOW_GOOGLE_EARTH_LAYER_PANORAMIO__C0_FALSE;
    public static final boolean SHOW_GOOGLE_EARTH_LAYER_PANORAMIO__C1_TRUE;
    public static final int SHOW_GOOGLE_EARTH_LAYER_WIKIPEDIA;
    public static final boolean SHOW_GOOGLE_EARTH_LAYER_WIKIPEDIA__DEFAULT_VALUE;
    public static final boolean SHOW_GOOGLE_EARTH_LAYER_WIKIPEDIA__C0_FALSE;
    public static final boolean SHOW_GOOGLE_EARTH_LAYER_WIKIPEDIA__C1_TRUE;
    public static final int GOOGLE_EARTH_PLACES_ICON;
    public static final ResourceLocator GOOGLE_EARTH_PLACES_ICON__DEFAULT_VALUE;
    public static final int GOOGLE_EARTH_BUSINESS_ICON;
    public static final ResourceLocator GOOGLE_EARTH_BUSINESS_ICON__DEFAULT_VALUE;
    public static final int GOOGLE_EARTH_PANORAMIO_ICON;
    public static final ResourceLocator GOOGLE_EARTH_PANORAMIO_ICON__DEFAULT_VALUE;
    public static final int GOOGLE_EARTH_WIKIPEDIA_ICON;
    public static final ResourceLocator GOOGLE_EARTH_WIKIPEDIA_ICON__DEFAULT_VALUE;
    public static final int GOOGLE_EARTH_BUSINESS_AVAILABLE;
    public static final boolean GOOGLE_EARTH_BUSINESS_AVAILABLE__DEFAULT_VALUE;
    public static final boolean GOOGLE_EARTH_BUSINESS_AVAILABLE__C0_FALSE;
    public static final boolean GOOGLE_EARTH_BUSINESS_AVAILABLE__C1_TRUE;
    public static final int GOOGLE_EARTH_PANORAMIO_AVAILABLE;
    public static final boolean GOOGLE_EARTH_PANORAMIO_AVAILABLE__DEFAULT_VALUE;
    public static final boolean GOOGLE_EARTH_PANORAMIO_AVAILABLE__C0_FALSE;
    public static final boolean GOOGLE_EARTH_PANORAMIO_AVAILABLE__C1_TRUE;
    public static final int GOOGLE_EARTH_PLACES_AVAILABLE;
    public static final boolean GOOGLE_EARTH_PLACES_AVAILABLE__DEFAULT_VALUE;
    public static final boolean GOOGLE_EARTH_PLACES_AVAILABLE__C0_FALSE;
    public static final boolean GOOGLE_EARTH_PLACES_AVAILABLE__C1_TRUE;
    public static final int GOOGLE_EARTH_WIKIPEDIA_AVAILABLE;
    public static final boolean GOOGLE_EARTH_WIKIPEDIA_AVAILABLE__DEFAULT_VALUE;
    public static final boolean GOOGLE_EARTH_WIKIPEDIA_AVAILABLE__C0_FALSE;
    public static final boolean GOOGLE_EARTH_WIKIPEDIA_AVAILABLE__C1_TRUE;
    public static final int POI_CATEGORIES_AVAILABLE;
    public static final boolean POI_CATEGORIES_AVAILABLE__DEFAULT_VALUE;
    public static final boolean POI_CATEGORIES_AVAILABLE__C0_FALSE;
    public static final boolean POI_CATEGORIES_AVAILABLE__C1_TRUE;
    public static final int FPK_MAP_PERSPECTIVE;
    public static final int FPK_MAP_PERSPECTIVE__DEFAULT_VALUE;
    public static final int FPK_MAP_PERSPECTIVE__C0_2DNORTH;
    public static final int FPK_MAP_PERSPECTIVE__C1_2DHEADING;
    public static final int FPK_MAP_PERSPECTIVE__C2_3DHEADING;
    public static final int VICS_TRAFFIC_FLOW_TYPE;
    public static final int VICS_TRAFFIC_FLOW_TYPE__DEFAULT_VALUE;
    public static final int VICS_TRAFFIC_FLOW_TYPE__C0_ALL_ROADS;
    public static final int VICS_TRAFFIC_FLOW_TYPE__C1_HIGHWAYS;
    public static final int VICS_TRAFFIC_FLOW_TYPE__C2_NORMAL_ROADS;
    public static final int VICS_TRAFFIC_FLOW_TYPE__C3_AUTOMATIC;

    static {
        GOOGLE_EARTH_PLACES_ICON__DEFAULT_VALUE = null;
        GOOGLE_EARTH_BUSINESS_ICON__DEFAULT_VALUE = null;
        GOOGLE_EARTH_PANORAMIO_ICON__DEFAULT_VALUE = null;
        GOOGLE_EARTH_WIKIPEDIA_ICON__DEFAULT_VALUE = null;
    }
}

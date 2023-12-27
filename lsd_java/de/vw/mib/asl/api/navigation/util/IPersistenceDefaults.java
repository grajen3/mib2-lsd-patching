/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.util;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;

public interface IPersistenceDefaults {
    public static final boolean ROUTEOPTIONS_HMI_ALTERNATIVE_ROUTE_CALCULATION_DEFAULT = ServiceManager.configManagerDiag.getNaviRouteOptionDefaultBoolean(0);
    public static final int ROUTEOPTIONS_HMI_ROUTECALCULATION_TYPE_DEFAULT;
    public static final int ROUTEOPTIONS_HMI_DYNAMIC_ROUTE_CALCULATION_DEFAULT;
    public static final boolean LANE_GUIDANCE_DEFAULT;
    public static final boolean MAIN_MAP_SHOW_ICONS_BRANDS_DEFAULT;
    public static final boolean MAIN_MAP_SHOW_ICONS_FAVORITES_DEFAULT;
    public static final boolean POI_FUEL_OPTIONS_FUEL_WARNING_DEFAULT;
    public static final boolean BORDER_CHANGE_POPUP_ACTIVE_DEFAULT;
    public static final int HMI_AUDIO_ANNOUNCEMENT_TYPE_DEFAULT;
    public static final int HMI_TRAFFIC_SIGN_MODE_DEFAULT;
    public static final int HMI_VOICE_ANNOUNCEMENTS_DURING_PHONE_SET_DEFAULT;
    public static final int HMI_GUIDANCE_TIME_FORMAT_DEFAULT;
    public static final boolean STATUS_LINE_INFO_DEFAULT;
    public static final boolean SOUND_NAV_ANNOUNCEMENT_STATE_DEFAULT;
    public static final boolean HOV_USAGE_DEFAULT;
    public static final boolean HMI_SHOW_POIS_DEFAULT;
    public static final boolean HMI_NAV_LOCATION_VALID_DEFAULT;
    public static final int HMI_MAIN_MAP_ORIENTATION_DEFAULT;
    public static final int HMI_MAIN_MAP_MAP_MODE_DEFAULT;
    public static final int HMI_MAIN_MAP_TYPE_LAST_DEFAULT;
    public static final boolean HMI_MAIN_MAP_SHOW_SPEED_AND_FLOW_DEFAULT;
    public static final boolean HMI_TRAFFIC_SHOW_FREE_FLOW_DEFAULT;
    public static final boolean HMI_TRAFFIC_SHOW_CONGESTION_DEFAULT;
    public static final boolean HMI_TRAFFIC_SHOW_INCIDENTS_DEFAULT;
    public static final boolean HMI_MAIN_MAP_KDK_ACTIVE_DEFAULT;
    public static final int HMI_MAP_IN_MAP_MODE_DEFAULT;
    public static final int HMI_MAIN_MAP_AUTOZOOM_MODE_DEFAULT;
    public static final boolean HMI_SPEED_CAMERA_WARNING_DEFAULT;
    public static final boolean HMI_MAIN_MAP_VISIBLE_IN_KOMBI_DEFAULT;
    public static final int HMI_MAP_TYPE_KOMBI_FPK_DEFAULT;
    public static final int HMI_MAP_ORIENTATION_KOMBI_FPK_DEFAULT;
    public static final int HMI_MAP_CONTENT_KOMBI_FPK_DEFAULT;
    public static final boolean HMI_KDK_ACTIVE_IN_KOMBI_FPK_DEFAULT;
    public static final int HMI_AUTO_ZOOM_MODE_IN_KOMBI_FPK_DEFAULT;
    public static final boolean HMI_PRIVACY_MODE_DEFAULT;
    public static final boolean HMI_SPLIT_SCREEN_GUIDANCE_VISIBILITY_DEFAULT;
    public static final boolean HMI_SPLIT_SCREEN_NO_GUIDANCE_VISIBILITY_DEFAULT;
    public static final int HMI_SPLIT_SCREEN_GUIDANCE_CONTENT_DEFAULT;
    public static final int HMI_SPLIT_SCREEN_NO_GUIDANCE_CONTENT_DEFAULT;
    public static final boolean HMI_AUDIBLE_APPROACH_PPOI_HINT_STATUS_DEFAULT;
    public static final int HMI_GUIDANCE_ONLINE_TOUR_IMPORT_AVAILABLE_DEFAULT;
    public static final boolean HMI_ROUTEOPTIONS_HMI_USE_SEASONAL_RESTRICTIONS_DEFAULT;
    public static final boolean HMI_ROUTEOPTIONS_HMI_USE_STATISTICAL_DATA_DEFAULT;
    public static final int HMI_MAIN_MAP_DAY_NIGHT_MODE_DEFAULT;
    public static final boolean WARNING_SIGNS_JPN_MERGING_TRAFFIC_ACTIVE_DEFAULT;
    public static final boolean WARNING_SIGNS_JPN_REDUCE_LANE_ACTIVE_DEFAULT;
    public static final boolean WARNING_SIGNS_JPN_RAILWAY_CROSSING_ACTIVE_DEFAULT;
    public static final int WARNING_SIGNS_JPN_SPEED_CAMERA_WARNING_TYPE_ACTIVE_DEFAULT;
    public static final boolean HMI_PNAV_ENABLED_DEFAULT;
    public static final boolean HMI_SHOW_SLDE_HELP_DEFAULT;
    public static final int HMI_LAST_MODE_DESTINATION_INPUT_DEFAULT;
    public static final int HMI_LAST_MODE_DESTINATION_INPUT_DEFAULT_JPN;
    public static final long HMI_LAST_TIME_STAMP_BEFORE_HMI_OFF_DEFAULT;

    static {
        HMI_GUIDANCE_TIME_FORMAT_DEFAULT = ServiceManager.configManagerDiag.getNaviCommonOptionDefault(2);
        HMI_SPLIT_SCREEN_GUIDANCE_VISIBILITY_DEFAULT = ServiceManager.configManagerDiag.getNaviSplitScreenOptionDefaultBoolean(1);
        HMI_SPLIT_SCREEN_NO_GUIDANCE_VISIBILITY_DEFAULT = ServiceManager.configManagerDiag.getNaviSplitScreenOptionDefaultBoolean(0);
        HMI_SPLIT_SCREEN_GUIDANCE_CONTENT_DEFAULT = ServiceManager.configManagerDiag.getNaviSplitScreenOptionDefaultInteger(1);
        HMI_SPLIT_SCREEN_NO_GUIDANCE_CONTENT_DEFAULT = ServiceManager.configManagerDiag.getNaviSplitScreenOptionDefaultInteger(0);
    }
}


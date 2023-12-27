/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;

public final class NavigationConfiguration {
    public static final boolean CROSSHAIR_FEATURE_AVAILABLE = ServiceManager.configManagerDiag.getNaviCommonOptionDefaultBoolean(2);
    public static final boolean THREEPLUS1BOX_FEATURE_AVAILABLE = ServiceManager.configManagerDiag.getNaviCommonOptionDefaultBoolean(1);
    public static final boolean TOUCH_APPROACH_IN_MAP_FEATURE_AVAILABLE = ServiceManager.configManagerDiag.getNaviCommonOptionDefaultBoolean(0);
    public static final boolean LOCATIONINPUT_FEATURE_AVAILABLE = ServiceManager.configManagerDiag.getNaviLocationOptionDefaultBoolean(2);
    public static final boolean POI_IS_SORT_ORDER_FOR_CATEGORY_CLASSES_NATURAL = ServiceManager.configManagerDiag.getNaviPoiSortOrderBoolean(0);
    public static final boolean POI_IS_SORT_ORDER_FOR_CATEGORY_GROUPS_NATURAL = ServiceManager.configManagerDiag.getNaviPoiSortOrderBoolean(3);
    public static final boolean POI_IS_SORT_ORDER_FOR_CATEGORY_PREFERRED_BRANDS_NATURAL = ServiceManager.configManagerDiag.getNaviPoiSortOrderBoolean(2);
    public static final boolean POI_IS_SORT_ORDER_FOR_CATEGORY_TOP_CATEGORIES_NATURAL = ServiceManager.configManagerDiag.getNaviPoiSortOrderBoolean(1);
    public static final boolean COUNTRY_OVERVIEW_FEATURE_AVAILABLE = ServiceManager.configManagerDiag.getNaviCommonOptionDefaultBoolean(6);
    public static final double COUNTRY_OVERVIEW_LOCATION_LATITUDE_DEGREES = ServiceManager.configManagerDiag.getNaviCountryOverviewLocationOptionDefault(3);
    public static final double COUNTRY_OVERVIEW_LOCATION_LATITUDE_MINUTES = ServiceManager.configManagerDiag.getNaviCountryOverviewLocationOptionDefault(4);
    public static final double COUNTRY_OVERVIEW_LOCATION_LATITUDE_SECONDS = (double)ServiceManager.configManagerDiag.getNaviCountryOverviewLocationOptionDefault(5) / 10.0;
    public static final double COUNTRY_OVERVIEW_LOCATION_LONGITUDE_DEGREES = ServiceManager.configManagerDiag.getNaviCountryOverviewLocationOptionDefault(2);
    public static final double COUNTRY_OVERVIEW_LOCATION_LONGITUDE_MINUTES = ServiceManager.configManagerDiag.getNaviCountryOverviewLocationOptionDefault(1);
    public static final double COUNTRY_OVERVIEW_LOCATION_LONGITUDE_SECONDS = (double)ServiceManager.configManagerDiag.getNaviCountryOverviewLocationOptionDefault(0) / 10.0;
    public static final boolean LOCATIONINPUT_CHN_FEATURES_AVAILABLE = ServiceManager.configManagerDiag.getNaviLocationOptionDefaultBoolean(1);
    public static final boolean LOCATIONINPUT_JPY_FEATURES_AVAILABLE = ServiceManager.configManagerDiag.isFeatureFlagSet(125);
    public static final boolean IS_HWR_AVAILABLE = ServiceManager.configManagerDiag.getNaviLocationOptionDefaultBoolean(1);

    private NavigationConfiguration() {
    }
}


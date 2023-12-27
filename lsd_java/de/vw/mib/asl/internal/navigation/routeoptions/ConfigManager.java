/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.routeoptions;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;

public final class ConfigManager {
    public static final int DSI_ROUTE_TYPE = ServiceManager.configManagerDiag.getNaviRouteOptionDefault(5);
    public static final int DSI_WEIGHTING = ServiceManager.configManagerDiag.getNaviRouteOptionDefault(1);
    public static final int DSI_HYBRID_MODE = ServiceManager.configManagerDiag.getNaviRouteOptionDefault(4);
    public static final int DSI_DYNAMIC = ServiceManager.configManagerDiag.getNaviRouteOptionDefault(27);
    public static final int DSI_DYNAMIC_SPEED_FLOW = ServiceManager.configManagerDiag.getNaviRouteOptionDefault(23);
    public static final int DSI_DYNAMIC_TRAFFIC_PATTERN = ServiceManager.configManagerDiag.getNaviRouteOptionDefault(13);
    public static final int DSI_DYNAMIC_TRAFFIC_PATTERN_ONLINE = ServiceManager.configManagerDiag.getNaviRouteOptionDefault(26);
    public static final int DSI_DYNAMIC_TRAFFIC_PATTERN_RECORDED = ServiceManager.configManagerDiag.getNaviRouteOptionDefault(7);
    public static final int DSI_MOTORWAYS = ServiceManager.configManagerDiag.getNaviRouteOptionDefault(22);
    public static final int DSI_FERRIES = ServiceManager.configManagerDiag.getNaviRouteOptionDefault(16);
    public static final int DSI_TOLLROADS = ServiceManager.configManagerDiag.getNaviRouteOptionDefault(19);
    public static final int DSI_TOLLROADS_COST_PENALTY = ServiceManager.configManagerDiag.getNaviRouteOptionDefault(25);
    public static final int DSI_TUNNELS = ServiceManager.configManagerDiag.getNaviRouteOptionDefault(20);
    public static final int DSI_LEFT_RIGHT_TURN = ServiceManager.configManagerDiag.getNaviRouteOptionDefault(12);
    public static final int DSI_SLOPES = ServiceManager.configManagerDiag.getNaviRouteOptionDefault(11);
    public static final int DSI_SLOPES_MAX_FACTOR = ServiceManager.configManagerDiag.getNaviRouteOptionDefault(8);
    public static final int DSI_VIGNETTE = ServiceManager.configManagerDiag.getNaviRouteOptionDefault(14);
    public static final int[] DSI_VIGNETTE_COUNTRY_LIST = ServiceManager.configManagerDiag.getNaviRouteOptionDefaultVignettCountryList();
    public static final int DSI_CITY_MAUT = ServiceManager.configManagerDiag.getNaviRouteOptionDefault(2);
    public static final int[] DSI_CITY_MAUT_LIST = ServiceManager.configManagerDiag.getNaviRouteOptionDefaultCityMautList();
    public static final int DSI_CARTRAIN = ServiceManager.configManagerDiag.getNaviRouteOptionDefault(28);
    public static final int DSI_TIME_DOMAIN = ServiceManager.configManagerDiag.getNaviRouteOptionDefault(9);
    public static final int DSI_SEASONAL_TIME_DOMAIN = ServiceManager.configManagerDiag.getNaviRouteOptionDefault(31);
    public static final int DSI_UNPAVED = ServiceManager.configManagerDiag.getNaviRouteOptionDefault(6);
    public static final int DSI_RESIDENTIAL_AREA_HANDLING = ServiceManager.configManagerDiag.getNaviRouteOptionDefault(10);
    public static final int DSI_TRAILER = ServiceManager.configManagerDiag.getNaviRouteOptionDefault(17);
    public static final int DSI_HOV_CAR_POOLS_LANE = ServiceManager.configManagerDiag.getNaviRouteOptionDefault(3);
    public static final int DSI_BORDER = ServiceManager.configManagerDiag.getNaviRouteOptionDefault(15);
    public static final int DSI_IPD = ServiceManager.configManagerDiag.getNaviRouteOptionDefault(24);
    public static final int DSI_TRAIL = ServiceManager.configManagerDiag.getNaviRouteOptionDefault(21);
    public static final int DSI_WAYPOINT_MODE = ServiceManager.configManagerDiag.getNaviRouteOptionDefault(30);
    public static final int DSI_ECO_TURNS = ServiceManager.configManagerDiag.getNaviRouteOptionDefault(18);
    public static final boolean HMI_ALTERNATIVE_ROUTE_CALCULATION = ServiceManager.configManagerDiag.getNaviRouteOptionDefaultBoolean(0);
    public static final boolean FEAT_IS_NAV_5_ROUTE_CALCULATION = ServiceManager.configManagerDiag.isFeatureFlagSet(107);
}


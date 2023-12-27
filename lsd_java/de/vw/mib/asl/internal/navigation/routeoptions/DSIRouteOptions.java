/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.routeoptions;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.routeoptions.ConfigManager;
import org.dsi.ifc.navigation.RouteOptions;

public class DSIRouteOptions {
    private IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16384, super.getClass().toString());
    private RouteOptions routeOptionsData = new RouteOptions();

    public DSIRouteOptions() {
        this.initDefaultDSIRouteOptions();
    }

    public void initDefaultDSIRouteOptions() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(" initDefaultRouteOptions()");
        }
        this.routeOptionsData.routeType = ConfigManager.DSI_ROUTE_TYPE;
        this.routeOptionsData.weighting = ConfigManager.DSI_WEIGHTING;
        this.routeOptionsData.hybridMode = ConfigManager.DSI_HYBRID_MODE;
        this.routeOptionsData.dynamic = ConfigManager.DSI_DYNAMIC;
        this.routeOptionsData.dynamicSpeedFlow = ConfigManager.DSI_DYNAMIC_SPEED_FLOW;
        this.routeOptionsData.dynamicTrafficPattern = ConfigManager.DSI_DYNAMIC_TRAFFIC_PATTERN;
        this.routeOptionsData.dynamicTrafficPatternOnline = ConfigManager.DSI_DYNAMIC_TRAFFIC_PATTERN_ONLINE;
        this.routeOptionsData.dynamicTrafficPatternRecorded = ConfigManager.DSI_DYNAMIC_TRAFFIC_PATTERN_RECORDED;
        this.routeOptionsData.motorways = ConfigManager.DSI_MOTORWAYS;
        this.routeOptionsData.ferries = ConfigManager.DSI_FERRIES;
        this.routeOptionsData.tollroads = ConfigManager.DSI_TOLLROADS;
        this.routeOptionsData.tollroadsCostPenalty = ConfigManager.DSI_TOLLROADS_COST_PENALTY;
        this.routeOptionsData.tunnels = ConfigManager.DSI_TUNNELS;
        this.routeOptionsData.leftRightTurn = ConfigManager.DSI_LEFT_RIGHT_TURN;
        this.routeOptionsData.slopes = ConfigManager.DSI_SLOPES;
        this.routeOptionsData.slopesMaxFactor = ConfigManager.DSI_SLOPES_MAX_FACTOR;
        this.routeOptionsData.vignette = ConfigManager.DSI_VIGNETTE;
        this.routeOptionsData.vignetteCountryList = ConfigManager.DSI_VIGNETTE_COUNTRY_LIST;
        this.routeOptionsData.cityMaut = ConfigManager.DSI_CITY_MAUT;
        this.routeOptionsData.cityMautList = ConfigManager.DSI_CITY_MAUT_LIST;
        this.routeOptionsData.cartrain = ConfigManager.DSI_CARTRAIN;
        this.routeOptionsData.timeDomain = ConfigManager.DSI_TIME_DOMAIN;
        this.routeOptionsData.seasonalTimeDomain = ConfigManager.DSI_SEASONAL_TIME_DOMAIN;
        this.routeOptionsData.unpaved = ConfigManager.DSI_UNPAVED;
        this.routeOptionsData.residentialAreaHandling = ConfigManager.DSI_RESIDENTIAL_AREA_HANDLING;
        this.routeOptionsData.trailer = ConfigManager.DSI_TRAILER;
        this.routeOptionsData.hovCarPoolsLane = ConfigManager.DSI_HOV_CAR_POOLS_LANE;
        this.routeOptionsData.border = ConfigManager.DSI_BORDER;
        this.routeOptionsData.ipd = ConfigManager.DSI_IPD;
        this.routeOptionsData.trail = ConfigManager.DSI_TRAIL;
        this.routeOptionsData.waypointMode = ConfigManager.DSI_WAYPOINT_MODE;
        this.routeOptionsData.economicTurns = ConfigManager.DSI_ECO_TURNS;
    }

    public RouteOptions getRouteOptions() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(" getDsiRouteOptions()");
        }
        return this.routeOptionsData;
    }

    public void setRouteOptions(RouteOptions routeOptions) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(" setDsiRouteOptions()");
        }
        this.routeOptionsData = routeOptions;
    }
}


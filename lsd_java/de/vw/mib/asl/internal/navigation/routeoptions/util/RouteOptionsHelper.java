/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.routeoptions.util;

import org.dsi.ifc.navigation.RouteOptions;

public final class RouteOptionsHelper {
    private RouteOptionsHelper() {
    }

    public static RouteOptions copyRouteOptions(RouteOptions routeOptions) {
        int n;
        RouteOptions routeOptions2 = new RouteOptions();
        routeOptions2.border = routeOptions.border;
        routeOptions2.cartrain = routeOptions.cartrain;
        routeOptions2.cityMaut = routeOptions.cityMaut;
        if (routeOptions.cityMautList != null) {
            routeOptions2.cityMautList = new int[routeOptions.cityMautList.length];
            for (n = 0; n < routeOptions.cityMautList.length; ++n) {
                routeOptions2.cityMautList[n] = routeOptions.cityMautList[n];
            }
        }
        routeOptions2.dynamic = routeOptions.dynamic;
        routeOptions2.dynamicSpeedFlow = routeOptions.dynamicSpeedFlow;
        routeOptions2.dynamicTrafficPattern = routeOptions.dynamicTrafficPattern;
        routeOptions2.dynamicTrafficPatternOnline = routeOptions.dynamicTrafficPatternOnline;
        routeOptions2.dynamicTrafficPatternRecorded = routeOptions.dynamicTrafficPatternRecorded;
        routeOptions2.economicTurns = routeOptions.economicTurns;
        routeOptions2.ferries = routeOptions.ferries;
        routeOptions2.hovCarPoolsLane = routeOptions.hovCarPoolsLane;
        routeOptions2.hybridMode = routeOptions.hybridMode;
        routeOptions2.ipd = routeOptions.ipd;
        routeOptions2.leftRightTurn = routeOptions.leftRightTurn;
        routeOptions2.motorways = routeOptions.motorways;
        routeOptions2.residentialAreaHandling = routeOptions.residentialAreaHandling;
        routeOptions2.routeType = routeOptions.routeType;
        routeOptions2.seasonalTimeDomain = routeOptions.seasonalTimeDomain;
        routeOptions2.slopes = routeOptions.slopes;
        routeOptions2.slopesMaxFactor = routeOptions.slopesMaxFactor;
        routeOptions2.styleId = routeOptions.styleId;
        routeOptions2.timeDomain = routeOptions.timeDomain;
        routeOptions2.tollroads = routeOptions.tollroads;
        routeOptions2.tollroadsCostPenalty = routeOptions.tollroadsCostPenalty;
        routeOptions2.trail = routeOptions.trail;
        routeOptions2.trailer = routeOptions.trailer;
        routeOptions2.tunnels = routeOptions.tunnels;
        routeOptions2.unpaved = routeOptions.unpaved;
        routeOptions2.vignette = routeOptions.vignette;
        if (routeOptions.vignetteCountryList != null) {
            routeOptions2.vignetteCountryList = new int[routeOptions.vignetteCountryList.length];
            for (n = 0; n < routeOptions.vignetteCountryList.length; ++n) {
                routeOptions2.vignetteCountryList[n] = routeOptions.vignetteCountryList[n];
            }
        }
        routeOptions2.waypointMode = routeOptions.waypointMode;
        routeOptions2.weighting = routeOptions.weighting;
        return routeOptions2;
    }
}


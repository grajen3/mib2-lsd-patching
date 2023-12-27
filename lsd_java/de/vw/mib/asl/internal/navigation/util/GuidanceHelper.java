/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.util;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteDestination;

public class GuidanceHelper {
    public static NavLocation getFinalDestinationNavLocation() {
        RouteDestination[] routeDestinationArray;
        NavLocation navLocation = null;
        Route route = ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().getRgCurrentRoute();
        if (route != null && (routeDestinationArray = route.getRoutelist()) != null && routeDestinationArray.length != 0) {
            navLocation = routeDestinationArray[routeDestinationArray.length - 1].getRouteLocation();
        }
        return navLocation;
    }
}


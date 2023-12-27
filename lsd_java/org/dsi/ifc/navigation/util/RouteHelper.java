/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation.util;

import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteDestination;

public class RouteHelper {
    public static void addDestinationAtPosition(Route route, RouteDestination routeDestination, int n) {
        if (route.routelist == null && n != 0 || route.routelist != null && (n < 0 || n > route.routelist.length)) {
            throw new ArrayIndexOutOfBoundsException(n);
        }
        if (route.routelist == null && n == 0) {
            route.routelist = new RouteDestination[]{routeDestination};
            RouteHelper.correctDestinationType(route);
            return;
        }
        RouteDestination[] routeDestinationArray = new RouteDestination[route.routelist.length + 1];
        System.arraycopy((Object)route.routelist, 0, (Object)routeDestinationArray, 0, n);
        System.arraycopy((Object)route.routelist, n, (Object)routeDestinationArray, n + 1, route.routelist.length - n);
        routeDestinationArray[n] = routeDestination;
        route.routelist = routeDestinationArray;
        RouteHelper.correctDestinationType(route);
    }

    private static void correctDestinationType(Route route) {
        if (route.routelist == null || route.routelist.length == 0) {
            return;
        }
        if (route.routelist[route.routelist.length - 1].getDestinationType() == 2) {
            route.routelist[route.routelist.length - 1].setDestinationType(1);
        }
    }

    public static void deleteAllStopovers(Route route) {
        if (route.routelist == null || route.routelist.length <= 1) {
            return;
        }
        route.routelist = new RouteDestination[]{route.routelist[route.routelist.length - 1]};
    }

    public static void deleteDestinationAtPosition(Route route, int n) {
        if (route.routelist == null || n < 0 || n >= route.routelist.length) {
            throw new ArrayIndexOutOfBoundsException(n);
        }
        RouteDestination[] routeDestinationArray = new RouteDestination[route.routelist.length - 1];
        System.arraycopy((Object)route.routelist, 0, (Object)routeDestinationArray, 0, n);
        System.arraycopy((Object)route.routelist, n + 1, (Object)routeDestinationArray, n, route.routelist.length - n - 1);
        route.routelist = routeDestinationArray;
        RouteHelper.correctDestinationType(route);
    }

    public static RouteDestination getDestinationAtPosition(Route route, int n) {
        if (route.routelist == null || n < 0 || n >= route.routelist.length) {
            throw new ArrayIndexOutOfBoundsException(n);
        }
        return route.routelist[n];
    }

    public static void moveDestination(Route route, int n, int n2) {
        RouteDestination routeDestination = RouteHelper.getDestinationAtPosition(route, n);
        RouteHelper.deleteDestinationAtPosition(route, n);
        RouteHelper.addDestinationAtPosition(route, routeDestination, n2);
    }

    public static void replaceDestinationAtPosition(Route route, RouteDestination routeDestination, int n) {
        if (route.routelist == null || n < 0 || n >= route.routelist.length) {
            throw new ArrayIndexOutOfBoundsException(n);
        }
        route.routelist[n] = routeDestination;
        RouteHelper.correctDestinationType(route);
    }
}


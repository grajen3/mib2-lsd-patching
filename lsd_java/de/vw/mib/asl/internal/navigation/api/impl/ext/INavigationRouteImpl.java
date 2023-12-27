/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.api.impl.ext;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.INavigationRoute;
import de.vw.mib.asl.api.navigation.guidance.ASLNavigationGuidanceFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.INavigationLocationHelper;
import de.vw.mib.asl.internal.navigation.api.impl.ext.INavigationLocationImpl;
import java.util.ArrayList;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteDestination;
import org.dsi.ifc.navigation.util.RouteHelper;

public class INavigationRouteImpl
implements INavigationRoute {
    Route realRoute;

    public INavigationRouteImpl(Route route) {
        this.realRoute = route == null ? new Route() : ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().copyRoute(route);
    }

    public Route getRealRoute() {
        return this.realRoute;
    }

    @Override
    public int getIndexOfCurrentDestination() {
        if (this.realRoute != null) {
            return (int)this.realRoute.getIndexOfCurrentDestination();
        }
        return 0;
    }

    @Override
    public void addDestinationAtPosition(INavigationLocation iNavigationLocation, int n) {
        if (this.realRoute != null) {
            RouteDestination routeDestination = new RouteDestination();
            routeDestination.setRouteLocation(((INavigationLocationHelper)((Object)iNavigationLocation)).getRealLocation());
            RouteHelper.addDestinationAtPosition(this.realRoute, routeDestination, n);
        }
    }

    @Override
    public INavigationLocation[] getRoutelist() {
        if (this.realRoute != null) {
            RouteDestination[] routeDestinationArray = this.realRoute.getRoutelist();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; routeDestinationArray != null && i2 < routeDestinationArray.length; ++i2) {
                arrayList.add(new INavigationLocationImpl(routeDestinationArray[i2].getRouteLocation()));
            }
            return (INavigationLocation[])arrayList.toArray(new INavigationLocation[0]);
        }
        return null;
    }

    @Override
    public int getNumberOfDestinations() {
        RouteDestination[] routeDestinationArray;
        if (this.realRoute != null && (routeDestinationArray = this.realRoute.getRoutelist()) != null) {
            return routeDestinationArray.length;
        }
        return 0;
    }

    @Override
    public void deleteDestinationAtPosition(int n) {
        if (this.realRoute != null) {
            RouteHelper.deleteDestinationAtPosition(this.realRoute, n);
        }
    }

    @Override
    public void deleteAllStopovers() {
        if (this.realRoute != null) {
            RouteHelper.deleteAllStopovers(this.realRoute);
        }
    }

    @Override
    public int getMaximumNumberOfDestinations() {
        return ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getMaxNumberOfDestinations();
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.bap.api.impl;

import de.vw.mib.asl.api.navbap.IRouteDestinationsNavBap;
import de.vw.mib.asl.api.navbap.IRouteNavBap;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.bap.api.impl.IRouteDestinationsNavBapImpl;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteDestination;

public class IRouteNavBapImpl
implements IRouteNavBap {
    private IRouteDestinationsNavBap[] routeList;
    private long indexOfCurrentDestination;

    public IRouteNavBapImpl(Route route) {
        if (route != null) {
            RouteDestination[] routeDestinationArray = route.getRoutelist();
            this.routeList = new IRouteDestinationsNavBap[routeDestinationArray.length];
            for (int i2 = 0; i2 < routeDestinationArray.length; ++i2) {
                this.routeList[i2] = new IRouteDestinationsNavBapImpl(routeDestinationArray[i2]);
            }
            this.indexOfCurrentDestination = route.getIndexOfCurrentDestination();
        } else {
            ServiceManager.logger.error(16384, "[IRouteNavBapImpl] rgCurrentRoute was null");
        }
    }

    @Override
    public IRouteDestinationsNavBap[] getRoutelist() {
        return this.routeList;
    }

    @Override
    public long getIndexOfCurrentDestination() {
        return this.indexOfCurrentDestination;
    }
}


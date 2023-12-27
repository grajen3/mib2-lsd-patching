/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.bap.api.impl;

import de.vw.mib.asl.api.navbap.IRouteDestinationsNavBap;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.RouteDestination;

public class IRouteDestinationsNavBapImpl
implements IRouteDestinationsNavBap {
    private NavLocation navLocation;

    public IRouteDestinationsNavBapImpl(RouteDestination routeDestination) {
        if (routeDestination != null) {
            this.navLocation = routeDestination.getRouteLocation();
        } else {
            ServiceManager.logger.error(16384, "[IRouteDestinationsNavBapImpl] routeDestination was null");
        }
    }

    @Override
    public NavLocation getRouteLocation() {
        return this.navLocation;
    }
}


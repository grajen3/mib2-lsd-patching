/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.dsi.global.impl.NavLocationSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.RouteOptionsSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.RouteDestination;
import org.dsi.ifc.navigation.RouteOptions;

public class RouteDestinationSerializer {
    public static void putOptionalRouteDestination(ISerializer iSerializer, RouteDestination routeDestination) {
        boolean bl = routeDestination == null;
        iSerializer.putBool(bl);
        if (!bl) {
            NavLocation navLocation = routeDestination.getRouteLocation();
            NavLocationSerializer.putOptionalNavLocation(iSerializer, navLocation);
            RouteOptions[] routeOptionsArray = routeDestination.getRouteOptions();
            RouteOptionsSerializer.putOptionalRouteOptionsVarArray(iSerializer, routeOptionsArray);
            int n = routeDestination.getDestinationType();
            iSerializer.putInt32(n);
        }
    }

    public static void putOptionalRouteDestinationVarArray(ISerializer iSerializer, RouteDestination[] routeDestinationArray) {
        boolean bl = routeDestinationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(routeDestinationArray.length);
            for (int i2 = 0; i2 < routeDestinationArray.length; ++i2) {
                RouteDestinationSerializer.putOptionalRouteDestination(iSerializer, routeDestinationArray[i2]);
            }
        }
    }

    public static RouteDestination getOptionalRouteDestination(IDeserializer iDeserializer) {
        RouteDestination routeDestination = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            NavLocation navLocation;
            routeDestination = new RouteDestination();
            routeDestination.routeLocation = navLocation = NavLocationSerializer.getOptionalNavLocation(iDeserializer);
            RouteOptions[] routeOptionsArray = RouteOptionsSerializer.getOptionalRouteOptionsVarArray(iDeserializer);
            routeDestination.routeOptions = routeOptionsArray;
            routeDestination.destinationType = n = iDeserializer.getInt32();
        }
        return routeDestination;
    }

    public static RouteDestination[] getOptionalRouteDestinationVarArray(IDeserializer iDeserializer) {
        RouteDestination[] routeDestinationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            routeDestinationArray = new RouteDestination[n];
            for (int i2 = 0; i2 < n; ++i2) {
                routeDestinationArray[i2] = RouteDestinationSerializer.getOptionalRouteDestination(iDeserializer);
            }
        }
        return routeDestinationArray;
    }
}


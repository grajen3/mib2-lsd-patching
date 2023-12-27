/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.dsi.navigation.impl.RouteDestinationSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteDestination;

public class RouteSerializer {
    public static void putOptionalRoute(ISerializer iSerializer, Route route) {
        boolean bl = route == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = route.getIndexOfCurrentDestination();
            iSerializer.putInt64(l);
            long l2 = route.getRouteID();
            iSerializer.putInt64(l2);
            RouteDestination[] routeDestinationArray = route.getRoutelist();
            RouteDestinationSerializer.putOptionalRouteDestinationVarArray(iSerializer, routeDestinationArray);
            String string = route.getRoutename();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalRouteVarArray(ISerializer iSerializer, Route[] routeArray) {
        boolean bl = routeArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(routeArray.length);
            for (int i2 = 0; i2 < routeArray.length; ++i2) {
                RouteSerializer.putOptionalRoute(iSerializer, routeArray[i2]);
            }
        }
    }

    public static Route getOptionalRoute(IDeserializer iDeserializer) {
        Route route = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            long l;
            long l2;
            route = new Route();
            route.indexOfCurrentDestination = l2 = iDeserializer.getInt64();
            route.routeID = l = iDeserializer.getInt64();
            RouteDestination[] routeDestinationArray = RouteDestinationSerializer.getOptionalRouteDestinationVarArray(iDeserializer);
            route.routelist = routeDestinationArray;
            route.routename = string = iDeserializer.getOptionalString();
        }
        return route;
    }

    public static Route[] getOptionalRouteVarArray(IDeserializer iDeserializer) {
        Route[] routeArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            routeArray = new Route[n];
            for (int i2 = 0; i2 < n; ++i2) {
                routeArray[i2] = RouteSerializer.getOptionalRoute(iDeserializer);
            }
        }
        return routeArray;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map.impl;

import de.esolutions.fw.comm.dsi.global.impl.NavSegmentIDSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.map.AvailableRoute;

public class AvailableRouteSerializer {
    public static void putOptionalAvailableRoute(ISerializer iSerializer, AvailableRoute availableRoute) {
        boolean bl = availableRoute == null;
        iSerializer.putBool(bl);
        if (!bl) {
            NavSegmentID navSegmentID = availableRoute.getNavSegmentID();
            NavSegmentIDSerializer.putOptionalNavSegmentID(iSerializer, navSegmentID);
            long l = availableRoute.getChangeIndicator();
            iSerializer.putInt64(l);
            boolean bl2 = availableRoute.isIsComplete();
            iSerializer.putBool(bl2);
        }
    }

    public static void putOptionalAvailableRouteVarArray(ISerializer iSerializer, AvailableRoute[] availableRouteArray) {
        boolean bl = availableRouteArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(availableRouteArray.length);
            for (int i2 = 0; i2 < availableRouteArray.length; ++i2) {
                AvailableRouteSerializer.putOptionalAvailableRoute(iSerializer, availableRouteArray[i2]);
            }
        }
    }

    public static AvailableRoute getOptionalAvailableRoute(IDeserializer iDeserializer) {
        AvailableRoute availableRoute = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            long l;
            NavSegmentID navSegmentID;
            availableRoute = new AvailableRoute();
            availableRoute.navSegmentID = navSegmentID = NavSegmentIDSerializer.getOptionalNavSegmentID(iDeserializer);
            availableRoute.changeIndicator = l = iDeserializer.getInt64();
            availableRoute.isComplete = bl2 = iDeserializer.getBool();
        }
        return availableRoute;
    }

    public static AvailableRoute[] getOptionalAvailableRouteVarArray(IDeserializer iDeserializer) {
        AvailableRoute[] availableRouteArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            availableRouteArray = new AvailableRoute[n];
            for (int i2 = 0; i2 < n; ++i2) {
                availableRouteArray[i2] = AvailableRouteSerializer.getOptionalAvailableRoute(iDeserializer);
            }
        }
        return availableRouteArray;
    }
}


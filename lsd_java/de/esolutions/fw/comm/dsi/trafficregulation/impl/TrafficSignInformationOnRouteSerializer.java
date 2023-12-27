/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.trafficregulation.impl;

import de.esolutions.fw.comm.dsi.trafficregulation.impl.TrafficSignInformationSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.trafficregulation.TrafficSignInformation;
import org.dsi.ifc.trafficregulation.TrafficSignInformationOnRoute;

public class TrafficSignInformationOnRouteSerializer {
    public static void putOptionalTrafficSignInformationOnRoute(ISerializer iSerializer, TrafficSignInformationOnRoute trafficSignInformationOnRoute) {
        boolean bl = trafficSignInformationOnRoute == null;
        iSerializer.putBool(bl);
        if (!bl) {
            TrafficSignInformation trafficSignInformation = trafficSignInformationOnRoute.getInfo();
            TrafficSignInformationSerializer.putOptionalTrafficSignInformation(iSerializer, trafficSignInformation);
            long l = trafficSignInformationOnRoute.getDistance();
            iSerializer.putInt64(l);
            long l2 = trafficSignInformationOnRoute.getRemainingTime();
            iSerializer.putInt64(l2);
        }
    }

    public static void putOptionalTrafficSignInformationOnRouteVarArray(ISerializer iSerializer, TrafficSignInformationOnRoute[] trafficSignInformationOnRouteArray) {
        boolean bl = trafficSignInformationOnRouteArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(trafficSignInformationOnRouteArray.length);
            for (int i2 = 0; i2 < trafficSignInformationOnRouteArray.length; ++i2) {
                TrafficSignInformationOnRouteSerializer.putOptionalTrafficSignInformationOnRoute(iSerializer, trafficSignInformationOnRouteArray[i2]);
            }
        }
    }

    public static TrafficSignInformationOnRoute getOptionalTrafficSignInformationOnRoute(IDeserializer iDeserializer) {
        TrafficSignInformationOnRoute trafficSignInformationOnRoute = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            long l;
            long l2;
            TrafficSignInformation trafficSignInformation;
            trafficSignInformationOnRoute = new TrafficSignInformationOnRoute();
            trafficSignInformationOnRoute.info = trafficSignInformation = TrafficSignInformationSerializer.getOptionalTrafficSignInformation(iDeserializer);
            trafficSignInformationOnRoute.distance = l2 = iDeserializer.getInt64();
            trafficSignInformationOnRoute.remainingTime = l = iDeserializer.getInt64();
        }
        return trafficSignInformationOnRoute;
    }

    public static TrafficSignInformationOnRoute[] getOptionalTrafficSignInformationOnRouteVarArray(IDeserializer iDeserializer) {
        TrafficSignInformationOnRoute[] trafficSignInformationOnRouteArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            trafficSignInformationOnRouteArray = new TrafficSignInformationOnRoute[n];
            for (int i2 = 0; i2 < n; ++i2) {
                trafficSignInformationOnRouteArray[i2] = TrafficSignInformationOnRouteSerializer.getOptionalTrafficSignInformationOnRoute(iDeserializer);
            }
        }
        return trafficSignInformationOnRouteArray;
    }
}


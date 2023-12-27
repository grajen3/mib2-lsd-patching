/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.RouteProperties;

public class RoutePropertiesSerializer {
    public static void putOptionalRouteProperties(ISerializer iSerializer, RouteProperties routeProperties) {
        boolean bl = routeProperties == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = routeProperties.isIsolatedMapArea();
            iSerializer.putBool(bl2);
            boolean bl3 = routeProperties.isVignetteDuty();
            iSerializer.putBool(bl3);
            boolean bl4 = routeProperties.isRestrictedArea();
            iSerializer.putBool(bl4);
            float f2 = routeProperties.getEnergyConsumption();
            iSerializer.putFloat(f2);
        }
    }

    public static void putOptionalRoutePropertiesVarArray(ISerializer iSerializer, RouteProperties[] routePropertiesArray) {
        boolean bl = routePropertiesArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(routePropertiesArray.length);
            for (int i2 = 0; i2 < routePropertiesArray.length; ++i2) {
                RoutePropertiesSerializer.putOptionalRouteProperties(iSerializer, routePropertiesArray[i2]);
            }
        }
    }

    public static RouteProperties getOptionalRouteProperties(IDeserializer iDeserializer) {
        RouteProperties routeProperties = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            float f2;
            boolean bl2;
            boolean bl3;
            boolean bl4;
            routeProperties = new RouteProperties();
            routeProperties.isolatedMapArea = bl4 = iDeserializer.getBool();
            routeProperties.vignetteDuty = bl3 = iDeserializer.getBool();
            routeProperties.restrictedArea = bl2 = iDeserializer.getBool();
            routeProperties.energyConsumption = f2 = iDeserializer.getFloat();
        }
        return routeProperties;
    }

    public static RouteProperties[] getOptionalRoutePropertiesVarArray(IDeserializer iDeserializer) {
        RouteProperties[] routePropertiesArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            routePropertiesArray = new RouteProperties[n];
            for (int i2 = 0; i2 < n; ++i2) {
                routePropertiesArray[i2] = RoutePropertiesSerializer.getOptionalRouteProperties(iDeserializer);
            }
        }
        return routePropertiesArray;
    }
}


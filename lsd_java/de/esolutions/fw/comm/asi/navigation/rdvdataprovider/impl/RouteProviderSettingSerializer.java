/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.rdvdataprovider.impl;

import de.esolutions.fw.comm.asi.navigation.rdvdataprovider.RouteProviderSetting;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class RouteProviderSettingSerializer {
    public static void putOptionalRouteProviderSetting(ISerializer iSerializer, RouteProviderSetting routeProviderSetting) {
        boolean bl = routeProviderSetting == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = routeProviderSetting.getClientID();
            iSerializer.putInt32(n);
            int n2 = routeProviderSetting.getResolutionInMeter();
            iSerializer.putInt32(n2);
            int n3 = routeProviderSetting.getMaxRangeInMeter();
            iSerializer.putInt32(n3);
            int n4 = routeProviderSetting.getOffsetInMeter();
            iSerializer.putInt32(n4);
            int n5 = routeProviderSetting.getIncludeStopOvers();
            iSerializer.putInt32(n5);
        }
    }

    public static void putOptionalRouteProviderSettingVarArray(ISerializer iSerializer, RouteProviderSetting[] routeProviderSettingArray) {
        boolean bl = routeProviderSettingArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(routeProviderSettingArray.length);
            for (int i2 = 0; i2 < routeProviderSettingArray.length; ++i2) {
                RouteProviderSettingSerializer.putOptionalRouteProviderSetting(iSerializer, routeProviderSettingArray[i2]);
            }
        }
    }

    public static RouteProviderSetting getOptionalRouteProviderSetting(IDeserializer iDeserializer) {
        RouteProviderSetting routeProviderSetting = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            routeProviderSetting = new RouteProviderSetting();
            routeProviderSetting.clientID = n5 = iDeserializer.getInt32();
            routeProviderSetting.resolutionInMeter = n4 = iDeserializer.getInt32();
            routeProviderSetting.maxRangeInMeter = n3 = iDeserializer.getInt32();
            routeProviderSetting.offsetInMeter = n2 = iDeserializer.getInt32();
            routeProviderSetting.includeStopOvers = n = iDeserializer.getInt32();
        }
        return routeProviderSetting;
    }

    public static RouteProviderSetting[] getOptionalRouteProviderSettingVarArray(IDeserializer iDeserializer) {
        RouteProviderSetting[] routeProviderSettingArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            routeProviderSettingArray = new RouteProviderSetting[n];
            for (int i2 = 0; i2 < n; ++i2) {
                routeProviderSettingArray[i2] = RouteProviderSettingSerializer.getOptionalRouteProviderSetting(iDeserializer);
            }
        }
        return routeProviderSettingArray;
    }
}


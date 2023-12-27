/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.dsi.global.impl.NavLocationSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.NavRouteListDataIconSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.NavPoiInfo;
import org.dsi.ifc.navigation.NavRouteListDataIcon;

public class NavPoiInfoSerializer {
    public static void putOptionalNavPoiInfo(ISerializer iSerializer, NavPoiInfo navPoiInfo) {
        boolean bl = navPoiInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = navPoiInfo.getDistance();
            iSerializer.putInt64(l);
            long l2 = navPoiInfo.getRemainingTime();
            iSerializer.putInt64(l2);
            NavLocation[] navLocationArray = navPoiInfo.getPoiLocations();
            NavLocationSerializer.putOptionalNavLocationVarArray(iSerializer, navLocationArray);
            String string = navPoiInfo.getExitNumber();
            iSerializer.putOptionalString(string);
            String string2 = navPoiInfo.getSignpostInfo();
            iSerializer.putOptionalString(string2);
            int n = navPoiInfo.getExitIconId();
            iSerializer.putInt32(n);
            boolean bl2 = navPoiInfo.isSideOfStreet();
            iSerializer.putBool(bl2);
            int n2 = navPoiInfo.getDestinationIndex();
            iSerializer.putInt32(n2);
            int n3 = navPoiInfo.getType();
            iSerializer.putInt32(n3);
            NavLocation navLocation = navPoiInfo.getExitPoiLocation();
            NavLocationSerializer.putOptionalNavLocation(iSerializer, navLocation);
            NavRouteListDataIcon[] navRouteListDataIconArray = navPoiInfo.getPoiIcons();
            NavRouteListDataIconSerializer.putOptionalNavRouteListDataIconVarArray(iSerializer, navRouteListDataIconArray);
        }
    }

    public static void putOptionalNavPoiInfoVarArray(ISerializer iSerializer, NavPoiInfo[] navPoiInfoArray) {
        boolean bl = navPoiInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(navPoiInfoArray.length);
            for (int i2 = 0; i2 < navPoiInfoArray.length; ++i2) {
                NavPoiInfoSerializer.putOptionalNavPoiInfo(iSerializer, navPoiInfoArray[i2]);
            }
        }
    }

    public static NavPoiInfo getOptionalNavPoiInfo(IDeserializer iDeserializer) {
        NavPoiInfo navPoiInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            NavLocation navLocation;
            int n;
            int n2;
            boolean bl2;
            int n3;
            String string;
            String string2;
            long l;
            long l2;
            navPoiInfo = new NavPoiInfo();
            navPoiInfo.distance = l2 = iDeserializer.getInt64();
            navPoiInfo.remainingTime = l = iDeserializer.getInt64();
            NavLocation[] navLocationArray = NavLocationSerializer.getOptionalNavLocationVarArray(iDeserializer);
            navPoiInfo.poiLocations = navLocationArray;
            navPoiInfo.exitNumber = string2 = iDeserializer.getOptionalString();
            navPoiInfo.signpostInfo = string = iDeserializer.getOptionalString();
            navPoiInfo.exitIconId = n3 = iDeserializer.getInt32();
            navPoiInfo.sideOfStreet = bl2 = iDeserializer.getBool();
            navPoiInfo.destinationIndex = n2 = iDeserializer.getInt32();
            navPoiInfo.type = n = iDeserializer.getInt32();
            navPoiInfo.exitPoiLocation = navLocation = NavLocationSerializer.getOptionalNavLocation(iDeserializer);
            NavRouteListDataIcon[] navRouteListDataIconArray = NavRouteListDataIconSerializer.getOptionalNavRouteListDataIconVarArray(iDeserializer);
            navPoiInfo.poiIcons = navRouteListDataIconArray;
        }
        return navPoiInfo;
    }

    public static NavPoiInfo[] getOptionalNavPoiInfoVarArray(IDeserializer iDeserializer) {
        NavPoiInfo[] navPoiInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            navPoiInfoArray = new NavPoiInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                navPoiInfoArray[i2] = NavPoiInfoSerializer.getOptionalNavPoiInfo(iDeserializer);
            }
        }
        return navPoiInfoArray;
    }
}


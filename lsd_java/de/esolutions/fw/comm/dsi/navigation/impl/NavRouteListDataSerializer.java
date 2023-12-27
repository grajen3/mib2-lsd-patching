/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.dsi.navigation.impl.NavRouteListDataIconSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.NavRouteListData;
import org.dsi.ifc.navigation.NavRouteListDataIcon;

public class NavRouteListDataSerializer {
    public static void putOptionalNavRouteListData(ISerializer iSerializer, NavRouteListData navRouteListData) {
        boolean bl = navRouteListData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            NavRouteListDataIcon[] navRouteListDataIconArray = navRouteListData.getIcons();
            NavRouteListDataIconSerializer.putOptionalNavRouteListDataIconVarArray(iSerializer, navRouteListDataIconArray);
            int n = navRouteListData.getStartDistance();
            iSerializer.putInt32(n);
            int n2 = navRouteListData.getEndDistance();
            iSerializer.putInt32(n2);
            int n3 = navRouteListData.getRemainingTravelTime();
            iSerializer.putInt32(n3);
            int n4 = navRouteListData.getTimeLagToNextDest();
            iSerializer.putInt32(n4);
            String string = navRouteListData.getStreetname();
            iSerializer.putOptionalString(string);
            boolean bl2 = navRouteListData.isInProgressData();
            iSerializer.putBool(bl2);
            long l = navRouteListData.getMotorwayLength();
            iSerializer.putInt64(l);
            long l2 = navRouteListData.getTollLength();
            iSerializer.putInt64(l2);
            long l3 = navRouteListData.getTollCostAmount();
            iSerializer.putInt64(l3);
            int n5 = navRouteListData.getTollCostCurrency();
            iSerializer.putInt32(n5);
            boolean bl3 = navRouteListData.isTunnelOnWay();
            iSerializer.putBool(bl3);
            boolean bl4 = navRouteListData.isFerryOnWay();
            iSerializer.putBool(bl4);
            boolean bl5 = navRouteListData.isTimeRestricted();
            iSerializer.putBool(bl5);
            boolean bl6 = navRouteListData.isCarTrainOnWay();
            iSerializer.putBool(bl6);
            boolean bl7 = navRouteListData.isSeasonalRestricted();
            iSerializer.putBool(bl7);
            boolean bl8 = navRouteListData.isVignetteNeededOnWay();
            iSerializer.putBool(bl8);
            int n6 = navRouteListData.getRemainingTravelTimeStatus();
            iSerializer.putInt32(n6);
        }
    }

    public static void putOptionalNavRouteListDataVarArray(ISerializer iSerializer, NavRouteListData[] navRouteListDataArray) {
        boolean bl = navRouteListDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(navRouteListDataArray.length);
            for (int i2 = 0; i2 < navRouteListDataArray.length; ++i2) {
                NavRouteListDataSerializer.putOptionalNavRouteListData(iSerializer, navRouteListDataArray[i2]);
            }
        }
    }

    public static NavRouteListData getOptionalNavRouteListData(IDeserializer iDeserializer) {
        NavRouteListData navRouteListData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            boolean bl7;
            int n2;
            long l;
            long l2;
            long l3;
            boolean bl8;
            String string;
            int n3;
            int n4;
            int n5;
            int n6;
            navRouteListData = new NavRouteListData();
            NavRouteListDataIcon[] navRouteListDataIconArray = NavRouteListDataIconSerializer.getOptionalNavRouteListDataIconVarArray(iDeserializer);
            navRouteListData.icons = navRouteListDataIconArray;
            navRouteListData.startDistance = n6 = iDeserializer.getInt32();
            navRouteListData.endDistance = n5 = iDeserializer.getInt32();
            navRouteListData.remainingTravelTime = n4 = iDeserializer.getInt32();
            navRouteListData.timeLagToNextDest = n3 = iDeserializer.getInt32();
            navRouteListData.streetname = string = iDeserializer.getOptionalString();
            navRouteListData.inProgressData = bl8 = iDeserializer.getBool();
            navRouteListData.motorwayLength = l3 = iDeserializer.getInt64();
            navRouteListData.tollLength = l2 = iDeserializer.getInt64();
            navRouteListData.tollCostAmount = l = iDeserializer.getInt64();
            navRouteListData.tollCostCurrency = n2 = iDeserializer.getInt32();
            navRouteListData.tunnelOnWay = bl7 = iDeserializer.getBool();
            navRouteListData.ferryOnWay = bl6 = iDeserializer.getBool();
            navRouteListData.timeRestricted = bl5 = iDeserializer.getBool();
            navRouteListData.carTrainOnWay = bl4 = iDeserializer.getBool();
            navRouteListData.seasonalRestricted = bl3 = iDeserializer.getBool();
            navRouteListData.vignetteNeededOnWay = bl2 = iDeserializer.getBool();
            navRouteListData.remainingTravelTimeStatus = n = iDeserializer.getInt32();
        }
        return navRouteListData;
    }

    public static NavRouteListData[] getOptionalNavRouteListDataVarArray(IDeserializer iDeserializer) {
        NavRouteListData[] navRouteListDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            navRouteListDataArray = new NavRouteListData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                navRouteListDataArray[i2] = NavRouteListDataSerializer.getOptionalNavRouteListData(iDeserializer);
            }
        }
        return navRouteListDataArray;
    }
}


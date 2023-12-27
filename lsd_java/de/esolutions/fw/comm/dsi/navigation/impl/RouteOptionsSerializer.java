/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.RouteOptions;

public class RouteOptionsSerializer {
    public static void putOptionalRouteOptions(ISerializer iSerializer, RouteOptions routeOptions) {
        boolean bl = routeOptions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = routeOptions.getRouteType();
            iSerializer.putInt32(n);
            int n2 = routeOptions.getWeighting();
            iSerializer.putInt32(n2);
            int n3 = routeOptions.getHybridMode();
            iSerializer.putInt32(n3);
            int n4 = routeOptions.getDynamic();
            iSerializer.putInt32(n4);
            int n5 = routeOptions.getDynamicSpeedFlow();
            iSerializer.putInt32(n5);
            int n6 = routeOptions.getDynamicTrafficPattern();
            iSerializer.putInt32(n6);
            int n7 = routeOptions.getDynamicTrafficPatternOnline();
            iSerializer.putInt32(n7);
            int n8 = routeOptions.getDynamicTrafficPatternRecorded();
            iSerializer.putInt32(n8);
            int n9 = routeOptions.getMotorways();
            iSerializer.putInt32(n9);
            int n10 = routeOptions.getFerries();
            iSerializer.putInt32(n10);
            int n11 = routeOptions.getTollroads();
            iSerializer.putInt32(n11);
            int n12 = routeOptions.getTollroadsCostPenalty();
            iSerializer.putInt32(n12);
            int n13 = routeOptions.getTunnels();
            iSerializer.putInt32(n13);
            int n14 = routeOptions.getLeftRightTurn();
            iSerializer.putInt32(n14);
            int n15 = routeOptions.getSlopes();
            iSerializer.putInt32(n15);
            int n16 = routeOptions.getSlopesMaxFactor();
            iSerializer.putInt32(n16);
            int n17 = routeOptions.getVignette();
            iSerializer.putInt32(n17);
            int[] nArray = routeOptions.getVignetteCountryList();
            iSerializer.putOptionalInt32VarArray(nArray);
            int n18 = routeOptions.getCityMaut();
            iSerializer.putInt32(n18);
            int[] nArray2 = routeOptions.getCityMautList();
            iSerializer.putOptionalInt32VarArray(nArray2);
            int n19 = routeOptions.getCartrain();
            iSerializer.putInt32(n19);
            int n20 = routeOptions.getTimeDomain();
            iSerializer.putInt32(n20);
            int n21 = routeOptions.getSeasonalTimeDomain();
            iSerializer.putInt32(n21);
            int n22 = routeOptions.getUnpaved();
            iSerializer.putInt32(n22);
            int n23 = routeOptions.getResidentialAreaHandling();
            iSerializer.putInt32(n23);
            int n24 = routeOptions.getTrailer();
            iSerializer.putInt32(n24);
            int n25 = routeOptions.getHovCarPoolsLane();
            iSerializer.putInt32(n25);
            int n26 = routeOptions.getBorder();
            iSerializer.putInt32(n26);
            int n27 = routeOptions.getIpd();
            iSerializer.putInt32(n27);
            int n28 = routeOptions.getTrail();
            iSerializer.putInt32(n28);
            int n29 = routeOptions.getWaypointMode();
            iSerializer.putInt32(n29);
            int n30 = routeOptions.getEconomicTurns();
            iSerializer.putInt32(n30);
            int n31 = routeOptions.getStyleId();
            iSerializer.putInt32(n31);
        }
    }

    public static void putOptionalRouteOptionsVarArray(ISerializer iSerializer, RouteOptions[] routeOptionsArray) {
        boolean bl = routeOptionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(routeOptionsArray.length);
            for (int i2 = 0; i2 < routeOptionsArray.length; ++i2) {
                RouteOptionsSerializer.putOptionalRouteOptions(iSerializer, routeOptionsArray[i2]);
            }
        }
    }

    public static RouteOptions getOptionalRouteOptions(IDeserializer iDeserializer) {
        RouteOptions routeOptions = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            int n9;
            int n10;
            int n11;
            int n12;
            int n13;
            int n14;
            int n15;
            int n16;
            int n17;
            int n18;
            int n19;
            int n20;
            int n21;
            int n22;
            int n23;
            int n24;
            int n25;
            int n26;
            int n27;
            int n28;
            int n29;
            int n30;
            int n31;
            routeOptions = new RouteOptions();
            routeOptions.routeType = n31 = iDeserializer.getInt32();
            routeOptions.weighting = n30 = iDeserializer.getInt32();
            routeOptions.hybridMode = n29 = iDeserializer.getInt32();
            routeOptions.dynamic = n28 = iDeserializer.getInt32();
            routeOptions.dynamicSpeedFlow = n27 = iDeserializer.getInt32();
            routeOptions.dynamicTrafficPattern = n26 = iDeserializer.getInt32();
            routeOptions.dynamicTrafficPatternOnline = n25 = iDeserializer.getInt32();
            routeOptions.dynamicTrafficPatternRecorded = n24 = iDeserializer.getInt32();
            routeOptions.motorways = n23 = iDeserializer.getInt32();
            routeOptions.ferries = n22 = iDeserializer.getInt32();
            routeOptions.tollroads = n21 = iDeserializer.getInt32();
            routeOptions.tollroadsCostPenalty = n20 = iDeserializer.getInt32();
            routeOptions.tunnels = n19 = iDeserializer.getInt32();
            routeOptions.leftRightTurn = n18 = iDeserializer.getInt32();
            routeOptions.slopes = n17 = iDeserializer.getInt32();
            routeOptions.slopesMaxFactor = n16 = iDeserializer.getInt32();
            routeOptions.vignette = n15 = iDeserializer.getInt32();
            int[] nArray = iDeserializer.getOptionalInt32VarArray();
            routeOptions.vignetteCountryList = nArray;
            routeOptions.cityMaut = n14 = iDeserializer.getInt32();
            int[] nArray2 = iDeserializer.getOptionalInt32VarArray();
            routeOptions.cityMautList = nArray2;
            routeOptions.cartrain = n13 = iDeserializer.getInt32();
            routeOptions.timeDomain = n12 = iDeserializer.getInt32();
            routeOptions.seasonalTimeDomain = n11 = iDeserializer.getInt32();
            routeOptions.unpaved = n10 = iDeserializer.getInt32();
            routeOptions.residentialAreaHandling = n9 = iDeserializer.getInt32();
            routeOptions.trailer = n8 = iDeserializer.getInt32();
            routeOptions.hovCarPoolsLane = n7 = iDeserializer.getInt32();
            routeOptions.border = n6 = iDeserializer.getInt32();
            routeOptions.ipd = n5 = iDeserializer.getInt32();
            routeOptions.trail = n4 = iDeserializer.getInt32();
            routeOptions.waypointMode = n3 = iDeserializer.getInt32();
            routeOptions.economicTurns = n2 = iDeserializer.getInt32();
            routeOptions.styleId = n = iDeserializer.getInt32();
        }
        return routeOptions;
    }

    public static RouteOptions[] getOptionalRouteOptionsVarArray(IDeserializer iDeserializer) {
        RouteOptions[] routeOptionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            routeOptionsArray = new RouteOptions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                routeOptionsArray[i2] = RouteOptionsSerializer.getOptionalRouteOptions(iDeserializer);
            }
        }
        return routeOptionsArray;
    }
}


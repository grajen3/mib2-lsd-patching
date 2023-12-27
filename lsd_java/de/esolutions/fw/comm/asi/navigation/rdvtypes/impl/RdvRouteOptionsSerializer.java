/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.rdvtypes.impl;

import de.esolutions.fw.comm.asi.navigation.rdvtypes.RdvRouteOptions;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class RdvRouteOptionsSerializer {
    public static void putOptionalRdvRouteOptions(ISerializer iSerializer, RdvRouteOptions rdvRouteOptions) {
        boolean bl = rdvRouteOptions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = rdvRouteOptions.getRouteType();
            iSerializer.putInt32(n);
            int n2 = rdvRouteOptions.getWeighting();
            iSerializer.putInt32(n2);
            int n3 = rdvRouteOptions.getHybridMode();
            iSerializer.putInt32(n3);
            int n4 = rdvRouteOptions.getDynamic();
            iSerializer.putInt32(n4);
            int n5 = rdvRouteOptions.getDynamicSpeedFlow();
            iSerializer.putInt32(n5);
            int n6 = rdvRouteOptions.getDynamicTrafficPattern();
            iSerializer.putInt32(n6);
            int n7 = rdvRouteOptions.getDynamicTrafficPatternOnline();
            iSerializer.putInt32(n7);
            int n8 = rdvRouteOptions.getDynamicTrafficPatternRecorded();
            iSerializer.putInt32(n8);
            int n9 = rdvRouteOptions.getMotorways();
            iSerializer.putInt32(n9);
            int n10 = rdvRouteOptions.getFerries();
            iSerializer.putInt32(n10);
            int n11 = rdvRouteOptions.getTollroads();
            iSerializer.putInt32(n11);
            int n12 = rdvRouteOptions.getTollroadsCostPenalty();
            iSerializer.putInt32(n12);
            int n13 = rdvRouteOptions.getTunnels();
            iSerializer.putInt32(n13);
            int n14 = rdvRouteOptions.getLeftRightTurn();
            iSerializer.putInt32(n14);
            int n15 = rdvRouteOptions.getSlopes();
            iSerializer.putInt32(n15);
            int n16 = rdvRouteOptions.getSlopesMaxFactor();
            iSerializer.putInt32(n16);
            int n17 = rdvRouteOptions.getVignette();
            iSerializer.putInt32(n17);
            int n18 = rdvRouteOptions.getCityMaut();
            iSerializer.putInt32(n18);
            int n19 = rdvRouteOptions.getCartrain();
            iSerializer.putInt32(n19);
            int n20 = rdvRouteOptions.getTimeDomain();
            iSerializer.putInt32(n20);
            int n21 = rdvRouteOptions.getSeasonalTimeDomain();
            iSerializer.putInt32(n21);
            int n22 = rdvRouteOptions.getUnpaved();
            iSerializer.putInt32(n22);
            int n23 = rdvRouteOptions.getResidentialAreaHandling();
            iSerializer.putInt32(n23);
            int n24 = rdvRouteOptions.getTrailer();
            iSerializer.putInt32(n24);
            int n25 = rdvRouteOptions.getBorder();
            iSerializer.putInt32(n25);
            int n26 = rdvRouteOptions.getIpd();
            iSerializer.putInt32(n26);
            int n27 = rdvRouteOptions.getTrail();
            iSerializer.putInt32(n27);
            int n28 = rdvRouteOptions.getWaypointMode();
            iSerializer.putInt32(n28);
            int n29 = rdvRouteOptions.getEconomicTurns();
            iSerializer.putInt32(n29);
            int n30 = rdvRouteOptions.getStyleId();
            iSerializer.putInt32(n30);
        }
    }

    public static void putOptionalRdvRouteOptionsVarArray(ISerializer iSerializer, RdvRouteOptions[] rdvRouteOptionsArray) {
        boolean bl = rdvRouteOptionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(rdvRouteOptionsArray.length);
            for (int i2 = 0; i2 < rdvRouteOptionsArray.length; ++i2) {
                RdvRouteOptionsSerializer.putOptionalRdvRouteOptions(iSerializer, rdvRouteOptionsArray[i2]);
            }
        }
    }

    public static RdvRouteOptions getOptionalRdvRouteOptions(IDeserializer iDeserializer) {
        RdvRouteOptions rdvRouteOptions = null;
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
            rdvRouteOptions = new RdvRouteOptions();
            rdvRouteOptions.routeType = n30 = iDeserializer.getInt32();
            rdvRouteOptions.weighting = n29 = iDeserializer.getInt32();
            rdvRouteOptions.hybridMode = n28 = iDeserializer.getInt32();
            rdvRouteOptions.dynamic = n27 = iDeserializer.getInt32();
            rdvRouteOptions.dynamicSpeedFlow = n26 = iDeserializer.getInt32();
            rdvRouteOptions.dynamicTrafficPattern = n25 = iDeserializer.getInt32();
            rdvRouteOptions.dynamicTrafficPatternOnline = n24 = iDeserializer.getInt32();
            rdvRouteOptions.dynamicTrafficPatternRecorded = n23 = iDeserializer.getInt32();
            rdvRouteOptions.motorways = n22 = iDeserializer.getInt32();
            rdvRouteOptions.ferries = n21 = iDeserializer.getInt32();
            rdvRouteOptions.tollroads = n20 = iDeserializer.getInt32();
            rdvRouteOptions.tollroadsCostPenalty = n19 = iDeserializer.getInt32();
            rdvRouteOptions.tunnels = n18 = iDeserializer.getInt32();
            rdvRouteOptions.leftRightTurn = n17 = iDeserializer.getInt32();
            rdvRouteOptions.slopes = n16 = iDeserializer.getInt32();
            rdvRouteOptions.slopesMaxFactor = n15 = iDeserializer.getInt32();
            rdvRouteOptions.vignette = n14 = iDeserializer.getInt32();
            rdvRouteOptions.cityMaut = n13 = iDeserializer.getInt32();
            rdvRouteOptions.cartrain = n12 = iDeserializer.getInt32();
            rdvRouteOptions.timeDomain = n11 = iDeserializer.getInt32();
            rdvRouteOptions.seasonalTimeDomain = n10 = iDeserializer.getInt32();
            rdvRouteOptions.unpaved = n9 = iDeserializer.getInt32();
            rdvRouteOptions.residentialAreaHandling = n8 = iDeserializer.getInt32();
            rdvRouteOptions.trailer = n7 = iDeserializer.getInt32();
            rdvRouteOptions.border = n6 = iDeserializer.getInt32();
            rdvRouteOptions.ipd = n5 = iDeserializer.getInt32();
            rdvRouteOptions.trail = n4 = iDeserializer.getInt32();
            rdvRouteOptions.waypointMode = n3 = iDeserializer.getInt32();
            rdvRouteOptions.economicTurns = n2 = iDeserializer.getInt32();
            rdvRouteOptions.styleId = n = iDeserializer.getInt32();
        }
        return rdvRouteOptions;
    }

    public static RdvRouteOptions[] getOptionalRdvRouteOptionsVarArray(IDeserializer iDeserializer) {
        RdvRouteOptions[] rdvRouteOptionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            rdvRouteOptionsArray = new RdvRouteOptions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                rdvRouteOptionsArray[i2] = RdvRouteOptionsSerializer.getOptionalRdvRouteOptions(iDeserializer);
            }
        }
        return rdvRouteOptionsArray;
    }
}


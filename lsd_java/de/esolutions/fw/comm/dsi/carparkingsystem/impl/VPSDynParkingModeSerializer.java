/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.VPSDynParkingMode;

public class VPSDynParkingModeSerializer {
    public static void putOptionalVPSDynParkingMode(ISerializer iSerializer, VPSDynParkingMode vPSDynParkingMode) {
        boolean bl = vPSDynParkingMode == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = vPSDynParkingMode.isParkbox();
            iSerializer.putBool(bl2);
            boolean bl3 = vPSDynParkingMode.isParallelToRoad();
            iSerializer.putBool(bl3);
            boolean bl4 = vPSDynParkingMode.isOffroad();
            iSerializer.putBool(bl4);
            boolean bl5 = vPSDynParkingMode.isRightSideview();
            iSerializer.putBool(bl5);
            boolean bl6 = vPSDynParkingMode.isLeftSideview();
            iSerializer.putBool(bl6);
            boolean bl7 = vPSDynParkingMode.isCrossing();
            iSerializer.putBool(bl7);
            boolean bl8 = vPSDynParkingMode.isTrailerAssist();
            iSerializer.putBool(bl8);
        }
    }

    public static void putOptionalVPSDynParkingModeVarArray(ISerializer iSerializer, VPSDynParkingMode[] vPSDynParkingModeArray) {
        boolean bl = vPSDynParkingModeArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(vPSDynParkingModeArray.length);
            for (int i2 = 0; i2 < vPSDynParkingModeArray.length; ++i2) {
                VPSDynParkingModeSerializer.putOptionalVPSDynParkingMode(iSerializer, vPSDynParkingModeArray[i2]);
            }
        }
    }

    public static VPSDynParkingMode getOptionalVPSDynParkingMode(IDeserializer iDeserializer) {
        VPSDynParkingMode vPSDynParkingMode = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            boolean bl7;
            boolean bl8;
            vPSDynParkingMode = new VPSDynParkingMode();
            vPSDynParkingMode.parkbox = bl8 = iDeserializer.getBool();
            vPSDynParkingMode.parallelToRoad = bl7 = iDeserializer.getBool();
            vPSDynParkingMode.offroad = bl6 = iDeserializer.getBool();
            vPSDynParkingMode.rightSideview = bl5 = iDeserializer.getBool();
            vPSDynParkingMode.leftSideview = bl4 = iDeserializer.getBool();
            vPSDynParkingMode.crossing = bl3 = iDeserializer.getBool();
            vPSDynParkingMode.trailerAssist = bl2 = iDeserializer.getBool();
        }
        return vPSDynParkingMode;
    }

    public static VPSDynParkingMode[] getOptionalVPSDynParkingModeVarArray(IDeserializer iDeserializer) {
        VPSDynParkingMode[] vPSDynParkingModeArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            vPSDynParkingModeArray = new VPSDynParkingMode[n];
            for (int i2 = 0; i2 < n; ++i2) {
                vPSDynParkingModeArray[i2] = VPSDynParkingModeSerializer.getOptionalVPSDynParkingMode(iDeserializer);
            }
        }
        return vPSDynParkingModeArray;
    }
}


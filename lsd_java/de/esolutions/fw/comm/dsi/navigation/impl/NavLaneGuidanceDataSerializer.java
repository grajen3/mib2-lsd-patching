/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.NavLaneGuidanceData;

public class NavLaneGuidanceDataSerializer {
    public static void putOptionalNavLaneGuidanceData(ISerializer iSerializer, NavLaneGuidanceData navLaneGuidanceData) {
        boolean bl = navLaneGuidanceData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            short s = navLaneGuidanceData.getPos();
            iSerializer.putInt16(s);
            short s2 = navLaneGuidanceData.getLaneDirection();
            iSerializer.putInt16(s2);
            byte[] byArray = navLaneGuidanceData.getLaneSideStreets();
            iSerializer.putOptionalInt8VarArray(byArray);
            short s3 = navLaneGuidanceData.getLaneType();
            iSerializer.putInt16(s3);
            byte by = navLaneGuidanceData.getLaneMarkingLeft();
            iSerializer.putInt8(by);
            byte by2 = navLaneGuidanceData.getLaneMarkingRight();
            iSerializer.putInt8(by2);
            byte by3 = navLaneGuidanceData.getLaneDescription();
            iSerializer.putInt8(by3);
            byte by4 = navLaneGuidanceData.getGuidanceInfo();
            iSerializer.putInt8(by4);
        }
    }

    public static void putOptionalNavLaneGuidanceDataVarArray(ISerializer iSerializer, NavLaneGuidanceData[] navLaneGuidanceDataArray) {
        boolean bl = navLaneGuidanceDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(navLaneGuidanceDataArray.length);
            for (int i2 = 0; i2 < navLaneGuidanceDataArray.length; ++i2) {
                NavLaneGuidanceDataSerializer.putOptionalNavLaneGuidanceData(iSerializer, navLaneGuidanceDataArray[i2]);
            }
        }
    }

    public static NavLaneGuidanceData getOptionalNavLaneGuidanceData(IDeserializer iDeserializer) {
        NavLaneGuidanceData navLaneGuidanceData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            byte by;
            byte by2;
            byte by3;
            byte by4;
            short s;
            short s2;
            short s3;
            navLaneGuidanceData = new NavLaneGuidanceData();
            navLaneGuidanceData.pos = s3 = iDeserializer.getInt16();
            navLaneGuidanceData.laneDirection = s2 = iDeserializer.getInt16();
            byte[] byArray = iDeserializer.getOptionalInt8VarArray();
            navLaneGuidanceData.laneSideStreets = byArray;
            navLaneGuidanceData.laneType = s = iDeserializer.getInt16();
            navLaneGuidanceData.laneMarkingLeft = by4 = iDeserializer.getInt8();
            navLaneGuidanceData.laneMarkingRight = by3 = iDeserializer.getInt8();
            navLaneGuidanceData.laneDescription = by2 = iDeserializer.getInt8();
            navLaneGuidanceData.guidanceInfo = by = iDeserializer.getInt8();
        }
        return navLaneGuidanceData;
    }

    public static NavLaneGuidanceData[] getOptionalNavLaneGuidanceDataVarArray(IDeserializer iDeserializer) {
        NavLaneGuidanceData[] navLaneGuidanceDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            navLaneGuidanceDataArray = new NavLaneGuidanceData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                navLaneGuidanceDataArray[i2] = NavLaneGuidanceDataSerializer.getOptionalNavLaneGuidanceData(iDeserializer);
            }
        }
        return navLaneGuidanceDataArray;
    }
}


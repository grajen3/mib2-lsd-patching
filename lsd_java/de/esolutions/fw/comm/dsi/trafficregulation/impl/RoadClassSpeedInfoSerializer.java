/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.trafficregulation.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.trafficregulation.RoadClassSpeedInfo;

public class RoadClassSpeedInfoSerializer {
    public static void putOptionalRoadClassSpeedInfo(ISerializer iSerializer, RoadClassSpeedInfo roadClassSpeedInfo) {
        boolean bl = roadClassSpeedInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = roadClassSpeedInfo.getCountryAbbreviation();
            iSerializer.putOptionalString(string);
            int n = roadClassSpeedInfo.getRoadClassIconReference();
            iSerializer.putInt32(n);
            int n2 = roadClassSpeedInfo.getRoadClassType();
            iSerializer.putInt32(n2);
            int n3 = roadClassSpeedInfo.getRoadSignIconReference();
            iSerializer.putInt32(n3);
            int n4 = roadClassSpeedInfo.getSpeedLimit();
            iSerializer.putInt32(n4);
            int n5 = roadClassSpeedInfo.getSpeedUnit();
            iSerializer.putInt32(n5);
            int n6 = roadClassSpeedInfo.getVariant();
            iSerializer.putInt32(n6);
        }
    }

    public static void putOptionalRoadClassSpeedInfoVarArray(ISerializer iSerializer, RoadClassSpeedInfo[] roadClassSpeedInfoArray) {
        boolean bl = roadClassSpeedInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(roadClassSpeedInfoArray.length);
            for (int i2 = 0; i2 < roadClassSpeedInfoArray.length; ++i2) {
                RoadClassSpeedInfoSerializer.putOptionalRoadClassSpeedInfo(iSerializer, roadClassSpeedInfoArray[i2]);
            }
        }
    }

    public static RoadClassSpeedInfo getOptionalRoadClassSpeedInfo(IDeserializer iDeserializer) {
        RoadClassSpeedInfo roadClassSpeedInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            String string;
            roadClassSpeedInfo = new RoadClassSpeedInfo();
            roadClassSpeedInfo.countryAbbreviation = string = iDeserializer.getOptionalString();
            roadClassSpeedInfo.roadClassIconReference = n6 = iDeserializer.getInt32();
            roadClassSpeedInfo.roadClassType = n5 = iDeserializer.getInt32();
            roadClassSpeedInfo.roadSignIconReference = n4 = iDeserializer.getInt32();
            roadClassSpeedInfo.speedLimit = n3 = iDeserializer.getInt32();
            roadClassSpeedInfo.speedUnit = n2 = iDeserializer.getInt32();
            roadClassSpeedInfo.variant = n = iDeserializer.getInt32();
        }
        return roadClassSpeedInfo;
    }

    public static RoadClassSpeedInfo[] getOptionalRoadClassSpeedInfoVarArray(IDeserializer iDeserializer) {
        RoadClassSpeedInfo[] roadClassSpeedInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            roadClassSpeedInfoArray = new RoadClassSpeedInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                roadClassSpeedInfoArray[i2] = RoadClassSpeedInfoSerializer.getOptionalRoadClassSpeedInfo(iDeserializer);
            }
        }
        return roadClassSpeedInfoArray;
    }
}


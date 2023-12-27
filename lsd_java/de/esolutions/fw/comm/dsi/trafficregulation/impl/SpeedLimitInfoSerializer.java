/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.trafficregulation.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.trafficregulation.SpeedLimitInfo;

public class SpeedLimitInfoSerializer {
    public static void putOptionalSpeedLimitInfo(ISerializer iSerializer, SpeedLimitInfo speedLimitInfo) {
        boolean bl = speedLimitInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = speedLimitInfo.getSpeedLimit();
            iSerializer.putInt32(n);
            int n2 = speedLimitInfo.getSpeedLimitType();
            iSerializer.putInt32(n2);
            int n3 = speedLimitInfo.getSpeedUnit();
            iSerializer.putInt32(n3);
        }
    }

    public static void putOptionalSpeedLimitInfoVarArray(ISerializer iSerializer, SpeedLimitInfo[] speedLimitInfoArray) {
        boolean bl = speedLimitInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(speedLimitInfoArray.length);
            for (int i2 = 0; i2 < speedLimitInfoArray.length; ++i2) {
                SpeedLimitInfoSerializer.putOptionalSpeedLimitInfo(iSerializer, speedLimitInfoArray[i2]);
            }
        }
    }

    public static SpeedLimitInfo getOptionalSpeedLimitInfo(IDeserializer iDeserializer) {
        SpeedLimitInfo speedLimitInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            speedLimitInfo = new SpeedLimitInfo();
            speedLimitInfo.speedLimit = n3 = iDeserializer.getInt32();
            speedLimitInfo.speedLimitType = n2 = iDeserializer.getInt32();
            speedLimitInfo.speedUnit = n = iDeserializer.getInt32();
        }
        return speedLimitInfo;
    }

    public static SpeedLimitInfo[] getOptionalSpeedLimitInfoVarArray(IDeserializer iDeserializer) {
        SpeedLimitInfo[] speedLimitInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            speedLimitInfoArray = new SpeedLimitInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                speedLimitInfoArray[i2] = SpeedLimitInfoSerializer.getOptionalSpeedLimitInfo(iDeserializer);
            }
        }
        return speedLimitInfoArray;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.RrdCalculationInfo;

public class RrdCalculationInfoSerializer {
    public static void putOptionalRrdCalculationInfo(ISerializer iSerializer, RrdCalculationInfo rrdCalculationInfo) {
        boolean bl = rrdCalculationInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = rrdCalculationInfo.getRrdInfo();
            iSerializer.putInt32(n);
            long l = rrdCalculationInfo.getRttInfo();
            iSerializer.putInt64(l);
        }
    }

    public static void putOptionalRrdCalculationInfoVarArray(ISerializer iSerializer, RrdCalculationInfo[] rrdCalculationInfoArray) {
        boolean bl = rrdCalculationInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(rrdCalculationInfoArray.length);
            for (int i2 = 0; i2 < rrdCalculationInfoArray.length; ++i2) {
                RrdCalculationInfoSerializer.putOptionalRrdCalculationInfo(iSerializer, rrdCalculationInfoArray[i2]);
            }
        }
    }

    public static RrdCalculationInfo getOptionalRrdCalculationInfo(IDeserializer iDeserializer) {
        RrdCalculationInfo rrdCalculationInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            long l;
            int n;
            rrdCalculationInfo = new RrdCalculationInfo();
            rrdCalculationInfo.rrdInfo = n = iDeserializer.getInt32();
            rrdCalculationInfo.rttInfo = l = iDeserializer.getInt64();
        }
        return rrdCalculationInfo;
    }

    public static RrdCalculationInfo[] getOptionalRrdCalculationInfoVarArray(IDeserializer iDeserializer) {
        RrdCalculationInfo[] rrdCalculationInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            rrdCalculationInfoArray = new RrdCalculationInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                rrdCalculationInfoArray[i2] = RrdCalculationInfoSerializer.getOptionalRrdCalculationInfo(iDeserializer);
            }
        }
        return rrdCalculationInfoArray;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl;

import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.SCRefLapData;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class SCRefLapDataSerializer {
    public static void putOptionalSCRefLapData(ISerializer iSerializer, SCRefLapData sCRefLapData) {
        boolean bl = sCRefLapData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sCRefLapData.getUid();
            iSerializer.putInt64(l);
            byte[] byArray = sCRefLapData.getData();
            iSerializer.putOptionalInt8VarArray(byArray);
        }
    }

    public static void putOptionalSCRefLapDataVarArray(ISerializer iSerializer, SCRefLapData[] sCRefLapDataArray) {
        boolean bl = sCRefLapDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sCRefLapDataArray.length);
            for (int i2 = 0; i2 < sCRefLapDataArray.length; ++i2) {
                SCRefLapDataSerializer.putOptionalSCRefLapData(iSerializer, sCRefLapDataArray[i2]);
            }
        }
    }

    public static SCRefLapData getOptionalSCRefLapData(IDeserializer iDeserializer) {
        SCRefLapData sCRefLapData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            long l;
            sCRefLapData = new SCRefLapData();
            sCRefLapData.uid = l = iDeserializer.getInt64();
            byte[] byArray = iDeserializer.getOptionalInt8VarArray();
            sCRefLapData.data = byArray;
        }
        return sCRefLapData;
    }

    public static SCRefLapData[] getOptionalSCRefLapDataVarArray(IDeserializer iDeserializer) {
        SCRefLapData[] sCRefLapDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sCRefLapDataArray = new SCRefLapData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sCRefLapDataArray[i2] = SCRefLapDataSerializer.getOptionalSCRefLapData(iDeserializer);
            }
        }
        return sCRefLapDataArray;
    }
}


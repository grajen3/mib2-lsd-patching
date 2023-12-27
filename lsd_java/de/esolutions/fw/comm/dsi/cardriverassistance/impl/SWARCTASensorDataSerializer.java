/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardriverassistance.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardriverassistance.SWARCTASensorData;

public class SWARCTASensorDataSerializer {
    public static void putOptionalSWARCTASensorData(ISerializer iSerializer, SWARCTASensorData sWARCTASensorData) {
        boolean bl = sWARCTASensorData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = sWARCTASensorData.getStatusLevelRearRight();
            iSerializer.putInt32(n);
            int n2 = sWARCTASensorData.getDistanceRearRight();
            iSerializer.putInt32(n2);
            int n3 = sWARCTASensorData.getStatusLevelRearLeft();
            iSerializer.putInt32(n3);
            int n4 = sWARCTASensorData.getDistanceRearLeft();
            iSerializer.putInt32(n4);
        }
    }

    public static void putOptionalSWARCTASensorDataVarArray(ISerializer iSerializer, SWARCTASensorData[] sWARCTASensorDataArray) {
        boolean bl = sWARCTASensorDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sWARCTASensorDataArray.length);
            for (int i2 = 0; i2 < sWARCTASensorDataArray.length; ++i2) {
                SWARCTASensorDataSerializer.putOptionalSWARCTASensorData(iSerializer, sWARCTASensorDataArray[i2]);
            }
        }
    }

    public static SWARCTASensorData getOptionalSWARCTASensorData(IDeserializer iDeserializer) {
        SWARCTASensorData sWARCTASensorData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            sWARCTASensorData = new SWARCTASensorData();
            sWARCTASensorData.statusLevelRearRight = n4 = iDeserializer.getInt32();
            sWARCTASensorData.distanceRearRight = n3 = iDeserializer.getInt32();
            sWARCTASensorData.statusLevelRearLeft = n2 = iDeserializer.getInt32();
            sWARCTASensorData.distanceRearLeft = n = iDeserializer.getInt32();
        }
        return sWARCTASensorData;
    }

    public static SWARCTASensorData[] getOptionalSWARCTASensorDataVarArray(IDeserializer iDeserializer) {
        SWARCTASensorData[] sWARCTASensorDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sWARCTASensorDataArray = new SWARCTASensorData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sWARCTASensorDataArray[i2] = SWARCTASensorDataSerializer.getOptionalSWARCTASensorData(iDeserializer);
            }
        }
        return sWARCTASensorDataArray;
    }
}


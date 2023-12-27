/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardriverassistance.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardriverassistance.FTASensorData;

public class FTASensorDataSerializer {
    public static void putOptionalFTASensorData(ISerializer iSerializer, FTASensorData fTASensorData) {
        boolean bl = fTASensorData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = fTASensorData.getStatusLevelFrontRight();
            iSerializer.putInt32(n);
            int n2 = fTASensorData.getStatusLevelFrontLeft();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalFTASensorDataVarArray(ISerializer iSerializer, FTASensorData[] fTASensorDataArray) {
        boolean bl = fTASensorDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(fTASensorDataArray.length);
            for (int i2 = 0; i2 < fTASensorDataArray.length; ++i2) {
                FTASensorDataSerializer.putOptionalFTASensorData(iSerializer, fTASensorDataArray[i2]);
            }
        }
    }

    public static FTASensorData getOptionalFTASensorData(IDeserializer iDeserializer) {
        FTASensorData fTASensorData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            fTASensorData = new FTASensorData();
            fTASensorData.statusLevelFrontRight = n2 = iDeserializer.getInt32();
            fTASensorData.statusLevelFrontLeft = n = iDeserializer.getInt32();
        }
        return fTASensorData;
    }

    public static FTASensorData[] getOptionalFTASensorDataVarArray(IDeserializer iDeserializer) {
        FTASensorData[] fTASensorDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            fTASensorDataArray = new FTASensorData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                fTASensorDataArray[i2] = FTASensorDataSerializer.getOptionalFTASensorData(iDeserializer);
            }
        }
        return fTASensorDataArray;
    }
}


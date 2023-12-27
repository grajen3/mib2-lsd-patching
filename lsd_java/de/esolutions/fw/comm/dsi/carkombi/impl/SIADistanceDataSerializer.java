/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.SIADistanceData;

public class SIADistanceDataSerializer {
    public static void putOptionalSIADistanceData(ISerializer iSerializer, SIADistanceData sIADistanceData) {
        boolean bl = sIADistanceData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = sIADistanceData.getState();
            iSerializer.putInt32(n);
            int n2 = sIADistanceData.getDistance();
            iSerializer.putInt32(n2);
            int n3 = sIADistanceData.getUnit();
            iSerializer.putInt32(n3);
        }
    }

    public static void putOptionalSIADistanceDataVarArray(ISerializer iSerializer, SIADistanceData[] sIADistanceDataArray) {
        boolean bl = sIADistanceDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sIADistanceDataArray.length);
            for (int i2 = 0; i2 < sIADistanceDataArray.length; ++i2) {
                SIADistanceDataSerializer.putOptionalSIADistanceData(iSerializer, sIADistanceDataArray[i2]);
            }
        }
    }

    public static SIADistanceData getOptionalSIADistanceData(IDeserializer iDeserializer) {
        SIADistanceData sIADistanceData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            sIADistanceData = new SIADistanceData();
            sIADistanceData.state = n3 = iDeserializer.getInt32();
            sIADistanceData.distance = n2 = iDeserializer.getInt32();
            sIADistanceData.unit = n = iDeserializer.getInt32();
        }
        return sIADistanceData;
    }

    public static SIADistanceData[] getOptionalSIADistanceDataVarArray(IDeserializer iDeserializer) {
        SIADistanceData[] sIADistanceDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sIADistanceDataArray = new SIADistanceData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sIADistanceDataArray[i2] = SIADistanceDataSerializer.getOptionalSIADistanceData(iDeserializer);
            }
        }
        return sIADistanceDataArray;
    }
}


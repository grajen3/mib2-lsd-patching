/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.RGSBeltPretensionData;

public class RGSBeltPretensionDataSerializer {
    public static void putOptionalRGSBeltPretensionData(ISerializer iSerializer, RGSBeltPretensionData rGSBeltPretensionData) {
        boolean bl = rGSBeltPretensionData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = rGSBeltPretensionData.isLeft();
            iSerializer.putBool(bl2);
            boolean bl3 = rGSBeltPretensionData.isRight();
            iSerializer.putBool(bl3);
        }
    }

    public static void putOptionalRGSBeltPretensionDataVarArray(ISerializer iSerializer, RGSBeltPretensionData[] rGSBeltPretensionDataArray) {
        boolean bl = rGSBeltPretensionDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(rGSBeltPretensionDataArray.length);
            for (int i2 = 0; i2 < rGSBeltPretensionDataArray.length; ++i2) {
                RGSBeltPretensionDataSerializer.putOptionalRGSBeltPretensionData(iSerializer, rGSBeltPretensionDataArray[i2]);
            }
        }
    }

    public static RGSBeltPretensionData getOptionalRGSBeltPretensionData(IDeserializer iDeserializer) {
        RGSBeltPretensionData rGSBeltPretensionData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            rGSBeltPretensionData = new RGSBeltPretensionData();
            rGSBeltPretensionData.left = bl3 = iDeserializer.getBool();
            rGSBeltPretensionData.right = bl2 = iDeserializer.getBool();
        }
        return rGSBeltPretensionData;
    }

    public static RGSBeltPretensionData[] getOptionalRGSBeltPretensionDataVarArray(IDeserializer iDeserializer) {
        RGSBeltPretensionData[] rGSBeltPretensionDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            rGSBeltPretensionDataArray = new RGSBeltPretensionData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                rGSBeltPretensionDataArray[i2] = RGSBeltPretensionDataSerializer.getOptionalRGSBeltPretensionData(iDeserializer);
            }
        }
        return rGSBeltPretensionDataArray;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.LIExtData;

public class LIExtDataSerializer {
    public static void putOptionalLIExtData(ISerializer iSerializer, LIExtData lIExtData) {
        boolean bl = lIExtData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = lIExtData.getType();
            iSerializer.putInt32(n);
            String string = lIExtData.getData();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalLIExtDataVarArray(ISerializer iSerializer, LIExtData[] lIExtDataArray) {
        boolean bl = lIExtDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(lIExtDataArray.length);
            for (int i2 = 0; i2 < lIExtDataArray.length; ++i2) {
                LIExtDataSerializer.putOptionalLIExtData(iSerializer, lIExtDataArray[i2]);
            }
        }
    }

    public static LIExtData getOptionalLIExtData(IDeserializer iDeserializer) {
        LIExtData lIExtData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            int n;
            lIExtData = new LIExtData();
            lIExtData.type = n = iDeserializer.getInt32();
            lIExtData.data = string = iDeserializer.getOptionalString();
        }
        return lIExtData;
    }

    public static LIExtData[] getOptionalLIExtDataVarArray(IDeserializer iDeserializer) {
        LIExtData[] lIExtDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            lIExtDataArray = new LIExtData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                lIExtDataArray[i2] = LIExtDataSerializer.getOptionalLIExtData(iDeserializer);
            }
        }
        return lIExtDataArray;
    }
}


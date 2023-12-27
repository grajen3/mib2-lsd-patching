/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carvehiclestates.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carvehiclestates.KeyData;

public class KeyDataSerializer {
    public static void putOptionalKeyData(ISerializer iSerializer, KeyData keyData) {
        boolean bl = keyData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = keyData.getTargetValue();
            iSerializer.putInt32(n);
            int n2 = keyData.getActualValue();
            iSerializer.putInt32(n2);
            int n3 = keyData.getActiveKey();
            iSerializer.putInt32(n3);
        }
    }

    public static void putOptionalKeyDataVarArray(ISerializer iSerializer, KeyData[] keyDataArray) {
        boolean bl = keyDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(keyDataArray.length);
            for (int i2 = 0; i2 < keyDataArray.length; ++i2) {
                KeyDataSerializer.putOptionalKeyData(iSerializer, keyDataArray[i2]);
            }
        }
    }

    public static KeyData getOptionalKeyData(IDeserializer iDeserializer) {
        KeyData keyData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            keyData = new KeyData();
            keyData.targetValue = n3 = iDeserializer.getInt32();
            keyData.actualValue = n2 = iDeserializer.getInt32();
            keyData.activeKey = n = iDeserializer.getInt32();
        }
        return keyData;
    }

    public static KeyData[] getOptionalKeyDataVarArray(IDeserializer iDeserializer) {
        KeyData[] keyDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            keyDataArray = new KeyData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                keyDataArray[i2] = KeyDataSerializer.getOptionalKeyData(iDeserializer);
            }
        }
        return keyDataArray;
    }
}


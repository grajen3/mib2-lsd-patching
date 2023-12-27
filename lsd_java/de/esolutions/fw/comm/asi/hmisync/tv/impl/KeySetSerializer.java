/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.tv.impl;

import de.esolutions.fw.comm.asi.hmisync.tv.KeySet;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class KeySetSerializer {
    public static void putOptionalKeySet(ISerializer iSerializer, KeySet keySet) {
        boolean bl = keySet == null;
        iSerializer.putBool(bl);
        if (!bl) {
            byte by = keySet.getTerminalID();
            iSerializer.putInt8(by);
            byte[] byArray = keySet.getKeyIDs();
            iSerializer.putOptionalInt8VarArray(byArray);
        }
    }

    public static void putOptionalKeySetVarArray(ISerializer iSerializer, KeySet[] keySetArray) {
        boolean bl = keySetArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(keySetArray.length);
            for (int i2 = 0; i2 < keySetArray.length; ++i2) {
                KeySetSerializer.putOptionalKeySet(iSerializer, keySetArray[i2]);
            }
        }
    }

    public static KeySet getOptionalKeySet(IDeserializer iDeserializer) {
        KeySet keySet = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            byte by;
            keySet = new KeySet();
            keySet.terminalID = by = iDeserializer.getInt8();
            byte[] byArray = iDeserializer.getOptionalInt8VarArray();
            keySet.keyIDs = byArray;
        }
        return keySet;
    }

    public static KeySet[] getOptionalKeySetVarArray(IDeserializer iDeserializer) {
        KeySet[] keySetArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            keySetArray = new KeySet[n];
            for (int i2 = 0; i2 < n; ++i2) {
                keySetArray[i2] = KeySetSerializer.getOptionalKeySet(iDeserializer);
            }
        }
        return keySetArray;
    }
}


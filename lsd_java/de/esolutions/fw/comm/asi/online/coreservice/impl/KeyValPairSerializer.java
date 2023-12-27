/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.online.coreservice.impl;

import de.esolutions.fw.comm.asi.online.coreservice.KeyValPair;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class KeyValPairSerializer {
    public static void putOptionalKeyValPair(ISerializer iSerializer, KeyValPair keyValPair) {
        boolean bl = keyValPair == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = keyValPair.getKey();
            iSerializer.putOptionalString(string);
            String string2 = keyValPair.getVal();
            iSerializer.putOptionalString(string2);
        }
    }

    public static void putOptionalKeyValPairVarArray(ISerializer iSerializer, KeyValPair[] keyValPairArray) {
        boolean bl = keyValPairArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(keyValPairArray.length);
            for (int i2 = 0; i2 < keyValPairArray.length; ++i2) {
                KeyValPairSerializer.putOptionalKeyValPair(iSerializer, keyValPairArray[i2]);
            }
        }
    }

    public static KeyValPair getOptionalKeyValPair(IDeserializer iDeserializer) {
        KeyValPair keyValPair = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            keyValPair = new KeyValPair();
            keyValPair.key = string2 = iDeserializer.getOptionalString();
            keyValPair.val = string = iDeserializer.getOptionalString();
        }
        return keyValPair;
    }

    public static KeyValPair[] getOptionalKeyValPairVarArray(IDeserializer iDeserializer) {
        KeyValPair[] keyValPairArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            keyValPairArray = new KeyValPair[n];
            for (int i2 = 0; i2 < n; ++i2) {
                keyValPairArray[i2] = KeyValPairSerializer.getOptionalKeyValPair(iDeserializer);
            }
        }
        return keyValPairArray;
    }
}


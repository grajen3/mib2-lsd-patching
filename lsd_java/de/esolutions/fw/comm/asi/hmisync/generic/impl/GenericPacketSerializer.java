/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.generic.impl;

import de.esolutions.fw.comm.asi.hmisync.generic.GenericPacket;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class GenericPacketSerializer {
    public static void putOptionalGenericPacket(ISerializer iSerializer, GenericPacket genericPacket) {
        boolean bl = genericPacket == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = genericPacket.getKeyword();
            iSerializer.putInt32(n);
            String[] stringArray = genericPacket.getData();
            iSerializer.putOptionalStringVarArray(stringArray);
        }
    }

    public static void putOptionalGenericPacketVarArray(ISerializer iSerializer, GenericPacket[] genericPacketArray) {
        boolean bl = genericPacketArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(genericPacketArray.length);
            for (int i2 = 0; i2 < genericPacketArray.length; ++i2) {
                GenericPacketSerializer.putOptionalGenericPacket(iSerializer, genericPacketArray[i2]);
            }
        }
    }

    public static GenericPacket getOptionalGenericPacket(IDeserializer iDeserializer) {
        GenericPacket genericPacket = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            genericPacket = new GenericPacket();
            genericPacket.keyword = n = iDeserializer.getInt32();
            String[] stringArray = iDeserializer.getOptionalStringVarArray();
            genericPacket.data = stringArray;
        }
        return genericPacket;
    }

    public static GenericPacket[] getOptionalGenericPacketVarArray(IDeserializer iDeserializer) {
        GenericPacket[] genericPacketArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            genericPacketArray = new GenericPacket[n];
            for (int i2 = 0; i2 < n; ++i2) {
                genericPacketArray[i2] = GenericPacketSerializer.getOptionalGenericPacket(iDeserializer);
            }
        }
        return genericPacketArray;
    }
}


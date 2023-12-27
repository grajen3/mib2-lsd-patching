/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.comm.broker.v4.impl;

import de.esolutions.fw.comm.comm.broker.v4.UUID844412Blob;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class UUID844412BlobSerializer {
    public static void putOptionalUUID844412Blob(ISerializer iSerializer, UUID844412Blob uUID844412Blob) {
        boolean bl = uUID844412Blob == null;
        iSerializer.putBool(bl);
        if (!bl) {
            short[] sArray = uUID844412Blob.getBytes();
            iSerializer.putOptionalUInt8VarArray(sArray);
        }
    }

    public static void putOptionalUUID844412BlobVarArray(ISerializer iSerializer, UUID844412Blob[] uUID844412BlobArray) {
        boolean bl = uUID844412BlobArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(uUID844412BlobArray.length);
            for (int i2 = 0; i2 < uUID844412BlobArray.length; ++i2) {
                UUID844412BlobSerializer.putOptionalUUID844412Blob(iSerializer, uUID844412BlobArray[i2]);
            }
        }
    }

    public static UUID844412Blob getOptionalUUID844412Blob(IDeserializer iDeserializer) {
        UUID844412Blob uUID844412Blob = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            uUID844412Blob = new UUID844412Blob();
            short[] sArray = iDeserializer.getOptionalUInt8VarArray();
            uUID844412Blob.bytes = sArray;
        }
        return uUID844412Blob;
    }

    public static UUID844412Blob[] getOptionalUUID844412BlobVarArray(IDeserializer iDeserializer) {
        UUID844412Blob[] uUID844412BlobArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            uUID844412BlobArray = new UUID844412Blob[n];
            for (int i2 = 0; i2 < n; ++i2) {
                uUID844412BlobArray[i2] = UUID844412BlobSerializer.getOptionalUUID844412Blob(iDeserializer);
            }
        }
        return uUID844412BlobArray;
    }
}


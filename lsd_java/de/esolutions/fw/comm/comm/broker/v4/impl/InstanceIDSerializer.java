/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.comm.broker.v4.impl;

import de.esolutions.fw.comm.comm.broker.v4.InstanceID;
import de.esolutions.fw.comm.comm.broker.v4.UUID844412Blob;
import de.esolutions.fw.comm.comm.broker.v4.impl.UUID844412BlobSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class InstanceIDSerializer {
    public static void putOptionalInstanceID(ISerializer iSerializer, InstanceID instanceID) {
        boolean bl = instanceID == null;
        iSerializer.putBool(bl);
        if (!bl) {
            UUID844412Blob uUID844412Blob = instanceID.getId();
            UUID844412BlobSerializer.putOptionalUUID844412Blob(iSerializer, uUID844412Blob);
            long l = instanceID.getHandle();
            iSerializer.putUInt32(l);
            UUID844412Blob uUID844412Blob2 = instanceID.getKey();
            UUID844412BlobSerializer.putOptionalUUID844412Blob(iSerializer, uUID844412Blob2);
        }
    }

    public static void putOptionalInstanceIDVarArray(ISerializer iSerializer, InstanceID[] instanceIDArray) {
        boolean bl = instanceIDArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(instanceIDArray.length);
            for (int i2 = 0; i2 < instanceIDArray.length; ++i2) {
                InstanceIDSerializer.putOptionalInstanceID(iSerializer, instanceIDArray[i2]);
            }
        }
    }

    public static InstanceID getOptionalInstanceID(IDeserializer iDeserializer) {
        InstanceID instanceID = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            UUID844412Blob uUID844412Blob;
            long l;
            UUID844412Blob uUID844412Blob2;
            instanceID = new InstanceID();
            instanceID.id = uUID844412Blob2 = UUID844412BlobSerializer.getOptionalUUID844412Blob(iDeserializer);
            instanceID.handle = l = iDeserializer.getUInt32();
            instanceID.key = uUID844412Blob = UUID844412BlobSerializer.getOptionalUUID844412Blob(iDeserializer);
        }
        return instanceID;
    }

    public static InstanceID[] getOptionalInstanceIDVarArray(IDeserializer iDeserializer) {
        InstanceID[] instanceIDArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            instanceIDArray = new InstanceID[n];
            for (int i2 = 0; i2 < n; ++i2) {
                instanceIDArray[i2] = InstanceIDSerializer.getOptionalInstanceID(iDeserializer);
            }
        }
        return instanceIDArray;
    }
}


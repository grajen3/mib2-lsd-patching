/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.persistence.impl;

import de.esolutions.fw.comm.persistence.PartitionHandle;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class PartitionHandleSerializer {
    public static void putOptionalPartitionHandle(ISerializer iSerializer, PartitionHandle partitionHandle) {
        boolean bl = partitionHandle == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = partitionHandle.getIndex();
            iSerializer.putUInt32(l);
        }
    }

    public static void putOptionalPartitionHandleVarArray(ISerializer iSerializer, PartitionHandle[] partitionHandleArray) {
        boolean bl = partitionHandleArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(partitionHandleArray.length);
            for (int i2 = 0; i2 < partitionHandleArray.length; ++i2) {
                PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, partitionHandleArray[i2]);
            }
        }
    }

    public static PartitionHandle getOptionalPartitionHandle(IDeserializer iDeserializer) {
        PartitionHandle partitionHandle = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            long l;
            partitionHandle = new PartitionHandle();
            partitionHandle.index = l = iDeserializer.getUInt32();
        }
        return partitionHandle;
    }

    public static PartitionHandle[] getOptionalPartitionHandleVarArray(IDeserializer iDeserializer) {
        PartitionHandle[] partitionHandleArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            partitionHandleArray = new PartitionHandle[n];
            for (int i2 = 0; i2 < n; ++i2) {
                partitionHandleArray[i2] = PartitionHandleSerializer.getOptionalPartitionHandle(iDeserializer);
            }
        }
        return partitionHandleArray;
    }
}


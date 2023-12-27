/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.persistence.impl;

import de.esolutions.fw.comm.persistence.PartitionHandle;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAProxy;
import de.esolutions.fw.comm.persistence.impl.PartitionHandleSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class IPersistenceAProxy$18
implements ISerializable {
    private final /* synthetic */ PartitionHandle val$handle;
    private final /* synthetic */ long val$key;
    private final /* synthetic */ short[] val$val;
    private final /* synthetic */ IPersistenceAProxy this$0;

    IPersistenceAProxy$18(IPersistenceAProxy iPersistenceAProxy, PartitionHandle partitionHandle, long l, short[] sArray) {
        this.this$0 = iPersistenceAProxy;
        this.val$handle = partitionHandle;
        this.val$key = l;
        this.val$val = sArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, this.val$handle);
        iSerializer.putUInt32(this.val$key);
        iSerializer.putOptionalUInt8VarArray(this.val$val);
    }
}


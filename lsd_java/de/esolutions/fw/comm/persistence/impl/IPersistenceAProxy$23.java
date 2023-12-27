/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.persistence.impl;

import de.esolutions.fw.comm.persistence.PartitionHandle;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAProxy;
import de.esolutions.fw.comm.persistence.impl.PartitionHandleSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class IPersistenceAProxy$23
implements ISerializable {
    private final /* synthetic */ PartitionHandle val$handle;
    private final /* synthetic */ long[] val$keys;
    private final /* synthetic */ int val$timeout;
    private final /* synthetic */ IPersistenceAProxy this$0;

    IPersistenceAProxy$23(IPersistenceAProxy iPersistenceAProxy, PartitionHandle partitionHandle, long[] lArray, int n) {
        this.this$0 = iPersistenceAProxy;
        this.val$handle = partitionHandle;
        this.val$keys = lArray;
        this.val$timeout = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, this.val$handle);
        iSerializer.putOptionalUInt32VarArray(this.val$keys);
        iSerializer.putInt32(this.val$timeout);
    }
}


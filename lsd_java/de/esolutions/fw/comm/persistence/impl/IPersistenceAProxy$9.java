/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.persistence.impl;

import de.esolutions.fw.comm.persistence.PartitionHandle;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAProxy;
import de.esolutions.fw.comm.persistence.impl.PartitionHandleSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class IPersistenceAProxy$9
implements ISerializable {
    private final /* synthetic */ PartitionHandle val$handle;
    private final /* synthetic */ long val$key;
    private final /* synthetic */ int val$timeout;
    private final /* synthetic */ IPersistenceAProxy this$0;

    IPersistenceAProxy$9(IPersistenceAProxy iPersistenceAProxy, PartitionHandle partitionHandle, long l, int n) {
        this.this$0 = iPersistenceAProxy;
        this.val$handle = partitionHandle;
        this.val$key = l;
        this.val$timeout = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, this.val$handle);
        iSerializer.putUInt32(this.val$key);
        iSerializer.putInt32(this.val$timeout);
    }
}


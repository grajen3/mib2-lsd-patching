/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.persistence.impl;

import de.esolutions.fw.comm.persistence.PartitionHandle;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAProxy;
import de.esolutions.fw.comm.persistence.impl.PartitionHandleSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class IPersistenceAProxy$13
implements ISerializable {
    private final /* synthetic */ PartitionHandle val$handle;
    private final /* synthetic */ long val$key;
    private final /* synthetic */ String val$val;
    private final /* synthetic */ IPersistenceAProxy this$0;

    IPersistenceAProxy$13(IPersistenceAProxy iPersistenceAProxy, PartitionHandle partitionHandle, long l, String string) {
        this.this$0 = iPersistenceAProxy;
        this.val$handle = partitionHandle;
        this.val$key = l;
        this.val$val = string;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, this.val$handle);
        iSerializer.putUInt32(this.val$key);
        iSerializer.putOptionalString(this.val$val);
    }
}


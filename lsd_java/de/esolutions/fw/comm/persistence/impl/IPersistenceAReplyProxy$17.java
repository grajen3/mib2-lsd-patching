/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.persistence.impl;

import de.esolutions.fw.comm.persistence.PartitionHandle;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAReplyProxy;
import de.esolutions.fw.comm.persistence.impl.PartitionHandleSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class IPersistenceAReplyProxy$17
implements ISerializable {
    private final /* synthetic */ PartitionHandle val$handle;
    private final /* synthetic */ long val$key;
    private final /* synthetic */ short[] val$val;
    private final /* synthetic */ int val$result;
    private final /* synthetic */ IPersistenceAReplyProxy this$0;

    IPersistenceAReplyProxy$17(IPersistenceAReplyProxy iPersistenceAReplyProxy, PartitionHandle partitionHandle, long l, short[] sArray, int n) {
        this.this$0 = iPersistenceAReplyProxy;
        this.val$handle = partitionHandle;
        this.val$key = l;
        this.val$val = sArray;
        this.val$result = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, this.val$handle);
        iSerializer.putUInt32(this.val$key);
        iSerializer.putOptionalUInt8VarArray(this.val$val);
        iSerializer.putEnum(this.val$result);
    }
}


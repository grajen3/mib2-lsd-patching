/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.persistence.impl;

import de.esolutions.fw.comm.persistence.PartitionHandle;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAReplyProxy;
import de.esolutions.fw.comm.persistence.impl.PartitionHandleSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class IPersistenceAReplyProxy$22
implements ISerializable {
    private final /* synthetic */ PartitionHandle val$handle;
    private final /* synthetic */ long[] val$keys;
    private final /* synthetic */ long[] val$values;
    private final /* synthetic */ int[] val$status;
    private final /* synthetic */ IPersistenceAReplyProxy this$0;

    IPersistenceAReplyProxy$22(IPersistenceAReplyProxy iPersistenceAReplyProxy, PartitionHandle partitionHandle, long[] lArray, long[] lArray2, int[] nArray) {
        this.this$0 = iPersistenceAReplyProxy;
        this.val$handle = partitionHandle;
        this.val$keys = lArray;
        this.val$values = lArray2;
        this.val$status = nArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, this.val$handle);
        iSerializer.putOptionalUInt32VarArray(this.val$keys);
        iSerializer.putOptionalUInt32VarArray(this.val$values);
        iSerializer.putOptionalEnumVarArray(this.val$status);
    }
}


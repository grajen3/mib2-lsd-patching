/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.persistence.impl;

import de.esolutions.fw.comm.persistence.PartitionHandle;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAReplyProxy;
import de.esolutions.fw.comm.persistence.impl.PartitionHandleSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class IPersistenceAReplyProxy$23
implements ISerializable {
    private final /* synthetic */ PartitionHandle val$handle;
    private final /* synthetic */ long[] val$keys;
    private final /* synthetic */ short[][] val$values;
    private final /* synthetic */ int[] val$status;
    private final /* synthetic */ IPersistenceAReplyProxy this$0;

    IPersistenceAReplyProxy$23(IPersistenceAReplyProxy iPersistenceAReplyProxy, PartitionHandle partitionHandle, long[] lArray, short[][] sArray, int[] nArray) {
        this.this$0 = iPersistenceAReplyProxy;
        this.val$handle = partitionHandle;
        this.val$keys = lArray;
        this.val$values = sArray;
        this.val$status = nArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, this.val$handle);
        iSerializer.putOptionalUInt32VarArray(this.val$keys);
        boolean bl = this.val$values != null;
        iSerializer.putBool(!bl);
        if (bl) {
            iSerializer.putUInt32(this.val$values.length);
            for (int i2 = 0; i2 < this.val$values.length; ++i2) {
                iSerializer.putOptionalUInt8VarArray(this.val$values[i2]);
            }
        }
        iSerializer.putOptionalEnumVarArray(this.val$status);
    }
}


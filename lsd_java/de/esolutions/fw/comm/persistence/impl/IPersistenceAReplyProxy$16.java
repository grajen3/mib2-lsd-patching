/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.persistence.impl;

import de.esolutions.fw.comm.persistence.PartitionHandle;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAReplyProxy;
import de.esolutions.fw.comm.persistence.impl.PartitionHandleSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class IPersistenceAReplyProxy$16
implements ISerializable {
    private final /* synthetic */ PartitionHandle val$handle;
    private final /* synthetic */ long[] val$keys;
    private final /* synthetic */ String[] val$vals;
    private final /* synthetic */ int[] val$results;
    private final /* synthetic */ IPersistenceAReplyProxy this$0;

    IPersistenceAReplyProxy$16(IPersistenceAReplyProxy iPersistenceAReplyProxy, PartitionHandle partitionHandle, long[] lArray, String[] stringArray, int[] nArray) {
        this.this$0 = iPersistenceAReplyProxy;
        this.val$handle = partitionHandle;
        this.val$keys = lArray;
        this.val$vals = stringArray;
        this.val$results = nArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, this.val$handle);
        iSerializer.putOptionalUInt32VarArray(this.val$keys);
        iSerializer.putOptionalStringVarArray(this.val$vals);
        iSerializer.putOptionalEnumVarArray(this.val$results);
    }
}


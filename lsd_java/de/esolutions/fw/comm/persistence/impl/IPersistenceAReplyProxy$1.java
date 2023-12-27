/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.persistence.impl;

import de.esolutions.fw.comm.persistence.PartitionHandle;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAReplyProxy;
import de.esolutions.fw.comm.persistence.impl.PartitionHandleSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class IPersistenceAReplyProxy$1
implements ISerializable {
    private final /* synthetic */ long val$partition;
    private final /* synthetic */ String val$version;
    private final /* synthetic */ PartitionHandle val$handle;
    private final /* synthetic */ int val$result;
    private final /* synthetic */ IPersistenceAReplyProxy this$0;

    IPersistenceAReplyProxy$1(IPersistenceAReplyProxy iPersistenceAReplyProxy, long l, String string, PartitionHandle partitionHandle, int n) {
        this.this$0 = iPersistenceAReplyProxy;
        this.val$partition = l;
        this.val$version = string;
        this.val$handle = partitionHandle;
        this.val$result = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putUInt32(this.val$partition);
        iSerializer.putOptionalString(this.val$version);
        PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, this.val$handle);
        iSerializer.putEnum(this.val$result);
    }
}


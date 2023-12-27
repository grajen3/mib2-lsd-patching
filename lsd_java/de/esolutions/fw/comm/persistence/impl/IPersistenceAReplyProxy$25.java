/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.persistence.impl;

import de.esolutions.fw.comm.persistence.PartitionHandle;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAReplyProxy;
import de.esolutions.fw.comm.persistence.impl.PartitionHandleSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class IPersistenceAReplyProxy$25
implements ISerializable {
    private final /* synthetic */ String val$partition;
    private final /* synthetic */ String val$from_version;
    private final /* synthetic */ String val$to_version;
    private final /* synthetic */ PartitionHandle val$handle;
    private final /* synthetic */ int val$result;
    private final /* synthetic */ IPersistenceAReplyProxy this$0;

    IPersistenceAReplyProxy$25(IPersistenceAReplyProxy iPersistenceAReplyProxy, String string, String string2, String string3, PartitionHandle partitionHandle, int n) {
        this.this$0 = iPersistenceAReplyProxy;
        this.val$partition = string;
        this.val$from_version = string2;
        this.val$to_version = string3;
        this.val$handle = partitionHandle;
        this.val$result = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putOptionalString(this.val$partition);
        iSerializer.putOptionalString(this.val$from_version);
        iSerializer.putOptionalString(this.val$to_version);
        PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, this.val$handle);
        iSerializer.putEnum(this.val$result);
    }
}


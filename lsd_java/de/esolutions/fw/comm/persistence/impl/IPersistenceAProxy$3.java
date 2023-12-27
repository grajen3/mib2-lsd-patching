/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.persistence.impl;

import de.esolutions.fw.comm.persistence.PartitionHandle;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAProxy;
import de.esolutions.fw.comm.persistence.impl.PartitionHandleSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class IPersistenceAProxy$3
implements ISerializable {
    private final /* synthetic */ PartitionHandle val$handle;
    private final /* synthetic */ boolean val$flush;
    private final /* synthetic */ IPersistenceAProxy this$0;

    IPersistenceAProxy$3(IPersistenceAProxy iPersistenceAProxy, PartitionHandle partitionHandle, boolean bl) {
        this.this$0 = iPersistenceAProxy;
        this.val$handle = partitionHandle;
        this.val$flush = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, this.val$handle);
        iSerializer.putBool(this.val$flush);
    }
}


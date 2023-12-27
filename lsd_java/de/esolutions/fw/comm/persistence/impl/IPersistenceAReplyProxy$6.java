/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.persistence.impl;

import de.esolutions.fw.comm.persistence.impl.IPersistenceAReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class IPersistenceAReplyProxy$6
implements ISerializable {
    private final /* synthetic */ long val$partition;
    private final /* synthetic */ int val$result;
    private final /* synthetic */ IPersistenceAReplyProxy this$0;

    IPersistenceAReplyProxy$6(IPersistenceAReplyProxy iPersistenceAReplyProxy, long l, int n) {
        this.this$0 = iPersistenceAReplyProxy;
        this.val$partition = l;
        this.val$result = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putUInt32(this.val$partition);
        iSerializer.putEnum(this.val$result);
    }
}


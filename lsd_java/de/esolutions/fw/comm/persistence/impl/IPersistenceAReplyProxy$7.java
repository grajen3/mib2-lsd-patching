/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.persistence.impl;

import de.esolutions.fw.comm.persistence.impl.IPersistenceAReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class IPersistenceAReplyProxy$7
implements ISerializable {
    private final /* synthetic */ String val$partition;
    private final /* synthetic */ int val$result;
    private final /* synthetic */ IPersistenceAReplyProxy this$0;

    IPersistenceAReplyProxy$7(IPersistenceAReplyProxy iPersistenceAReplyProxy, String string, int n) {
        this.this$0 = iPersistenceAReplyProxy;
        this.val$partition = string;
        this.val$result = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putOptionalString(this.val$partition);
        iSerializer.putEnum(this.val$result);
    }
}


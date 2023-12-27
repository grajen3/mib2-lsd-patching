/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec.impl;

import de.esolutions.fw.comm.asi.fec.impl.FecManagerReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class FecManagerReplyProxy$4
implements ISerializable {
    private final /* synthetic */ int val$result;
    private final /* synthetic */ FecManagerReplyProxy this$0;

    FecManagerReplyProxy$4(FecManagerReplyProxy fecManagerReplyProxy, int n) {
        this.this$0 = fecManagerReplyProxy;
        this.val$result = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$result);
    }
}


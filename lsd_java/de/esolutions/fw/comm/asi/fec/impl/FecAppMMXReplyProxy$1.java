/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec.impl;

import de.esolutions.fw.comm.asi.fec.impl.FecAppMMXReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class FecAppMMXReplyProxy$1
implements ISerializable {
    private final /* synthetic */ int val$err;
    private final /* synthetic */ FecAppMMXReplyProxy this$0;

    FecAppMMXReplyProxy$1(FecAppMMXReplyProxy fecAppMMXReplyProxy, int n) {
        this.this$0 = fecAppMMXReplyProxy;
        this.val$err = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putEnum(this.val$err);
    }
}


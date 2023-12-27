/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec.impl;

import de.esolutions.fw.comm.asi.fec.impl.FecManagerReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class FecManagerReplyProxy$1
implements ISerializable {
    private final /* synthetic */ String val$identifier;
    private final /* synthetic */ boolean val$result;
    private final /* synthetic */ FecManagerReplyProxy this$0;

    FecManagerReplyProxy$1(FecManagerReplyProxy fecManagerReplyProxy, String string, boolean bl) {
        this.this$0 = fecManagerReplyProxy;
        this.val$identifier = string;
        this.val$result = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putOptionalString(this.val$identifier);
        iSerializer.putBool(this.val$result);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec.impl;

import de.esolutions.fw.comm.asi.fec.impl.FecAppMMXReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class FecAppMMXReplyProxy$3
implements ISerializable {
    private final /* synthetic */ String val$identifier;
    private final /* synthetic */ boolean val$result;
    private final /* synthetic */ FecAppMMXReplyProxy this$0;

    FecAppMMXReplyProxy$3(FecAppMMXReplyProxy fecAppMMXReplyProxy, String string, boolean bl) {
        this.this$0 = fecAppMMXReplyProxy;
        this.val$identifier = string;
        this.val$result = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putOptionalString(this.val$identifier);
        iSerializer.putBool(this.val$result);
    }
}


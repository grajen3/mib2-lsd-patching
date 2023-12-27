/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec.impl;

import de.esolutions.fw.comm.asi.fec.impl.FecManagerReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class FecManagerReplyProxy$6
implements ISerializable {
    private final /* synthetic */ String val$filename;
    private final /* synthetic */ int val$errorCode;
    private final /* synthetic */ FecManagerReplyProxy this$0;

    FecManagerReplyProxy$6(FecManagerReplyProxy fecManagerReplyProxy, String string, int n) {
        this.this$0 = fecManagerReplyProxy;
        this.val$filename = string;
        this.val$errorCode = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putOptionalString(this.val$filename);
        iSerializer.putInt32(this.val$errorCode);
    }
}


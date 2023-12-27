/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.online.coreservice.impl;

import de.esolutions.fw.comm.asi.online.coreservice.impl.ExtOnlineCoreServiceReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ExtOnlineCoreServiceReplyProxy$5
implements ISerializable {
    private final /* synthetic */ int val$transactionID;
    private final /* synthetic */ byte[] val$data;
    private final /* synthetic */ ExtOnlineCoreServiceReplyProxy this$0;

    ExtOnlineCoreServiceReplyProxy$5(ExtOnlineCoreServiceReplyProxy extOnlineCoreServiceReplyProxy, int n, byte[] byArray) {
        this.this$0 = extOnlineCoreServiceReplyProxy;
        this.val$transactionID = n;
        this.val$data = byArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$transactionID);
        iSerializer.putOptionalInt8VarArray(this.val$data);
    }
}


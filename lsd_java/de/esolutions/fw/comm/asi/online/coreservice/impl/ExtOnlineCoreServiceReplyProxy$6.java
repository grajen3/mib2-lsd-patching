/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.online.coreservice.impl;

import de.esolutions.fw.comm.asi.online.coreservice.Result;
import de.esolutions.fw.comm.asi.online.coreservice.impl.ExtOnlineCoreServiceReplyProxy;
import de.esolutions.fw.comm.asi.online.coreservice.impl.ResultSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ExtOnlineCoreServiceReplyProxy$6
implements ISerializable {
    private final /* synthetic */ int val$transactionID;
    private final /* synthetic */ Result val$result;
    private final /* synthetic */ ExtOnlineCoreServiceReplyProxy this$0;

    ExtOnlineCoreServiceReplyProxy$6(ExtOnlineCoreServiceReplyProxy extOnlineCoreServiceReplyProxy, int n, Result result) {
        this.this$0 = extOnlineCoreServiceReplyProxy;
        this.val$transactionID = n;
        this.val$result = result;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$transactionID);
        ResultSerializer.putOptionalResult(iSerializer, this.val$result);
    }
}


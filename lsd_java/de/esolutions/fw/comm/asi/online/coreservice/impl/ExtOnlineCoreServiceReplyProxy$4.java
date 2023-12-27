/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.online.coreservice.impl;

import de.esolutions.fw.comm.asi.online.coreservice.KeyValPair;
import de.esolutions.fw.comm.asi.online.coreservice.impl.ExtOnlineCoreServiceReplyProxy;
import de.esolutions.fw.comm.asi.online.coreservice.impl.KeyValPairSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ExtOnlineCoreServiceReplyProxy$4
implements ISerializable {
    private final /* synthetic */ int val$transactionID;
    private final /* synthetic */ KeyValPair[] val$responseParam;
    private final /* synthetic */ ExtOnlineCoreServiceReplyProxy this$0;

    ExtOnlineCoreServiceReplyProxy$4(ExtOnlineCoreServiceReplyProxy extOnlineCoreServiceReplyProxy, int n, KeyValPair[] keyValPairArray) {
        this.this$0 = extOnlineCoreServiceReplyProxy;
        this.val$transactionID = n;
        this.val$responseParam = keyValPairArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$transactionID);
        KeyValPairSerializer.putOptionalKeyValPairVarArray(iSerializer, this.val$responseParam);
    }
}


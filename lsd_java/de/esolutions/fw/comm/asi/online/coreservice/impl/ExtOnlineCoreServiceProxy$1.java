/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.online.coreservice.impl;

import de.esolutions.fw.comm.asi.online.coreservice.KeyValPair;
import de.esolutions.fw.comm.asi.online.coreservice.RequestDescriptor;
import de.esolutions.fw.comm.asi.online.coreservice.impl.ExtOnlineCoreServiceProxy;
import de.esolutions.fw.comm.asi.online.coreservice.impl.KeyValPairSerializer;
import de.esolutions.fw.comm.asi.online.coreservice.impl.RequestDescriptorSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ExtOnlineCoreServiceProxy$1
implements ISerializable {
    private final /* synthetic */ RequestDescriptor val$descriptor;
    private final /* synthetic */ int val$transactionID;
    private final /* synthetic */ KeyValPair[] val$reqProp;
    private final /* synthetic */ KeyValPair[] val$urlParam;
    private final /* synthetic */ byte[] val$data;
    private final /* synthetic */ ExtOnlineCoreServiceProxy this$0;

    ExtOnlineCoreServiceProxy$1(ExtOnlineCoreServiceProxy extOnlineCoreServiceProxy, RequestDescriptor requestDescriptor, int n, KeyValPair[] keyValPairArray, KeyValPair[] keyValPairArray2, byte[] byArray) {
        this.this$0 = extOnlineCoreServiceProxy;
        this.val$descriptor = requestDescriptor;
        this.val$transactionID = n;
        this.val$reqProp = keyValPairArray;
        this.val$urlParam = keyValPairArray2;
        this.val$data = byArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        RequestDescriptorSerializer.putOptionalRequestDescriptor(iSerializer, this.val$descriptor);
        iSerializer.putInt32(this.val$transactionID);
        KeyValPairSerializer.putOptionalKeyValPairVarArray(iSerializer, this.val$reqProp);
        KeyValPairSerializer.putOptionalKeyValPairVarArray(iSerializer, this.val$urlParam);
        iSerializer.putOptionalInt8VarArray(this.val$data);
    }
}


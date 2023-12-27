/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2SSEDiagService;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2SSEDiagServiceC;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2SSEDiagServiceReply;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2SSEDiagServiceProxy$1;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2SSEDiagServiceReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class MMX2SSEDiagServiceProxy
implements MMX2SSEDiagService,
MMX2SSEDiagServiceC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.diagnosis.mmx2app.MMX2SSEDiagService");
    private Proxy proxy;

    public MMX2SSEDiagServiceProxy(int n, MMX2SSEDiagServiceReply mMX2SSEDiagServiceReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("244251e4-1310-11e4-b506-bf7ecd99c5a4", n, "2fd4d7ca-1076-542d-af3f-1bc9d3bd54a8", "asi.diagnosis.mmx2app.MMX2SSEDiagService");
        MMX2SSEDiagServiceReplyService mMX2SSEDiagServiceReplyService = new MMX2SSEDiagServiceReplyService(mMX2SSEDiagServiceReply);
        this.proxy = new Proxy(serviceInstanceID, mMX2SSEDiagServiceReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void responseErrorSSE(sClientResponseError sClientResponseError2) {
        MMX2SSEDiagServiceProxy$1 mMX2SSEDiagServiceProxy$1 = new MMX2SSEDiagServiceProxy$1(this, sClientResponseError2);
        this.proxy.remoteCallMethod((short)2, mMX2SSEDiagServiceProxy$1);
    }

    @Override
    public void responseClippingCounterMic1(long l, long l2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putUInt32(l);
            genericSerializable.putUInt32(l2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)1, genericSerializable);
    }
}


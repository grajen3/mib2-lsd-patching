/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2SSEDiagServiceReply;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class MMX2SSEDiagServiceReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.diagnosis.mmx2app.MMX2SSEDiagService");
    private static int dynamicHandle = 0;
    private MMX2SSEDiagServiceReply p_MMX2SSEDiagServiceReply;

    public MMX2SSEDiagServiceReplyService(MMX2SSEDiagServiceReply mMX2SSEDiagServiceReply) {
        super(new ServiceInstanceID("24b0b774-1310-11e4-8dc2-17f19a7b4b74", MMX2SSEDiagServiceReplyService.nextDynamicHandle(), "d68f008c-dad8-5ab1-bd45-f09f0f019586", "asi.diagnosis.mmx2app.MMX2SSEDiagService"));
        this.p_MMX2SSEDiagServiceReply = mMX2SSEDiagServiceReply;
    }

    private static synchronized int nextDynamicHandle() {
        int n = ++dynamicHandle;
        return n;
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 0: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2SSEDiagServiceReply.requestClippingCounterMic1(l);
                    break;
                }
                default: {
                    throw new MethodException(new StringBuffer().append("Invalid Method Id ").append(s).toString());
                }
            }
        }
        catch (SerializerException serializerException) {
            throw new MethodException(new StringBuffer().append("Deserialization failed: method=").append(s).append(", error=").append(serializerException.getMessage()).toString());
        }
    }
}


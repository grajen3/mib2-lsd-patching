/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2OlsDiagServiceReply;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class MMX2OlsDiagServiceReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.diagnosis.mmx2app.MMX2OlsDiagService");
    private static int dynamicHandle = 0;
    private MMX2OlsDiagServiceReply p_MMX2OlsDiagServiceReply;

    public MMX2OlsDiagServiceReplyService(MMX2OlsDiagServiceReply mMX2OlsDiagServiceReply) {
        super(new ServiceInstanceID("415815e1-22dc-44f2-8c3e-cc8470ffeaf7", MMX2OlsDiagServiceReplyService.nextDynamicHandle(), "612a308a-aae1-5fc9-a4d8-fa53e3ea8080", "asi.diagnosis.mmx2app.MMX2OlsDiagService"));
        this.p_MMX2OlsDiagServiceReply = mMX2OlsDiagServiceReply;
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
                case 1: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2OlsDiagServiceReply.requestConnectionState(l);
                    break;
                }
                case 0: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2OlsDiagServiceReply.requestActivationState(l);
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


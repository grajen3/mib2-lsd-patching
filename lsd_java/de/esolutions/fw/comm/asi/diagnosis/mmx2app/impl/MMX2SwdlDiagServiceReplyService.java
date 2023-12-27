/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2SwdlDiagServiceReply;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class MMX2SwdlDiagServiceReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.diagnosis.mmx2app.MMX2SwdlDiagService");
    private static int dynamicHandle = 0;
    private MMX2SwdlDiagServiceReply p_MMX2SwdlDiagServiceReply;

    public MMX2SwdlDiagServiceReplyService(MMX2SwdlDiagServiceReply mMX2SwdlDiagServiceReply) {
        super(new ServiceInstanceID("26548633-0750-4d14-a851-46e73b79a1c8", MMX2SwdlDiagServiceReplyService.nextDynamicHandle(), "ab446ad8-f728-5ed0-a70c-e5dcfab87f63", "asi.diagnosis.mmx2app.MMX2SwdlDiagService"));
        this.p_MMX2SwdlDiagServiceReply = mMX2SwdlDiagServiceReply;
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
                    this.p_MMX2SwdlDiagServiceReply.requestModuleVersionNumbers(l);
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


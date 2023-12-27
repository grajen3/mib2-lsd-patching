/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2OocDiagServiceReply;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class MMX2OocDiagServiceReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.diagnosis.mmx2app.MMX2OocDiagService");
    private static int dynamicHandle = 0;
    private MMX2OocDiagServiceReply p_MMX2OocDiagServiceReply;

    public MMX2OocDiagServiceReplyService(MMX2OocDiagServiceReply mMX2OocDiagServiceReply) {
        super(new ServiceInstanceID("04ffae27-a8b4-4847-ae17-d9c692c6e219", MMX2OocDiagServiceReplyService.nextDynamicHandle(), "70c9dba5-1723-5b89-8b9c-0e21ad580cf1", "asi.diagnosis.mmx2app.MMX2OocDiagService"));
        this.p_MMX2OocDiagServiceReply = mMX2OocDiagServiceReply;
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
                    this.p_MMX2OocDiagServiceReply.requestTemperatureMMX(l);
                    break;
                }
                case 4: {
                    long l = iDeserializer.getUInt32();
                    int n = iDeserializer.getEnum();
                    this.p_MMX2OocDiagServiceReply.requestDeleteMemory(l, n);
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


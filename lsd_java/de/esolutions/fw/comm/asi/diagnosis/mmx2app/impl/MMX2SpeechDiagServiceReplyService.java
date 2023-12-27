/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2SpeechDiagServiceReply;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class MMX2SpeechDiagServiceReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.diagnosis.mmx2app.MMX2SpeechDiagService");
    private static int dynamicHandle = 0;
    private MMX2SpeechDiagServiceReply p_MMX2SpeechDiagServiceReply;

    public MMX2SpeechDiagServiceReplyService(MMX2SpeechDiagServiceReply mMX2SpeechDiagServiceReply) {
        super(new ServiceInstanceID("4f78da63-d498-4434-ab5e-fa9f885161d9", MMX2SpeechDiagServiceReplyService.nextDynamicHandle(), "a2d49b2d-4c62-50ff-80c8-74891c1909b9", "asi.diagnosis.mmx2app.MMX2SpeechDiagService"));
        this.p_MMX2SpeechDiagServiceReply = mMX2SpeechDiagServiceReply;
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
                    this.p_MMX2SpeechDiagServiceReply.requestCommandSDS(l);
                    break;
                }
                case 12: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2SpeechDiagServiceReply.requestCountryRegionVersion(l);
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


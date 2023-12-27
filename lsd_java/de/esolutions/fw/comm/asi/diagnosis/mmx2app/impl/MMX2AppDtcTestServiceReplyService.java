/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2AppDtcTestServiceReply;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class MMX2AppDtcTestServiceReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.diagnosis.mmx2app.MMX2AppDtcTestService");
    private static int dynamicHandle = 0;
    private MMX2AppDtcTestServiceReply p_MMX2AppDtcTestServiceReply;

    public MMX2AppDtcTestServiceReplyService(MMX2AppDtcTestServiceReply mMX2AppDtcTestServiceReply) {
        super(new ServiceInstanceID("9e79c740-f61e-42bd-a575-c0c06d5f623b", MMX2AppDtcTestServiceReplyService.nextDynamicHandle(), "48e93f98-718a-5f3c-9e06-ed7a0c0371b1", "asi.diagnosis.mmx2app.MMX2AppDtcTestService"));
        this.p_MMX2AppDtcTestServiceReply = mMX2AppDtcTestServiceReply;
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
                case 4: {
                    int n = iDeserializer.getEnum();
                    this.p_MMX2AppDtcTestServiceReply.registerForDiagnosisAck(n);
                    break;
                }
                case 2: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2AppDtcTestServiceReply.performTest(l);
                    break;
                }
                case 1: {
                    this.p_MMX2AppDtcTestServiceReply.performAllTests();
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


/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2DisplayManagerDiagServiceReply;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class MMX2DisplayManagerDiagServiceReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.diagnosis.mmx2app.MMX2DisplayManagerDiagService");
    private static int dynamicHandle = 0;
    private MMX2DisplayManagerDiagServiceReply p_MMX2DisplayManagerDiagServiceReply;

    public MMX2DisplayManagerDiagServiceReplyService(MMX2DisplayManagerDiagServiceReply mMX2DisplayManagerDiagServiceReply) {
        super(new ServiceInstanceID("900f45af-5513-436c-bd60-0747c447c61f", MMX2DisplayManagerDiagServiceReplyService.nextDynamicHandle(), "e2f5022d-4f99-5bb8-b4a4-a30a4c93d62a", "asi.diagnosis.mmx2app.MMX2DisplayManagerDiagService"));
        this.p_MMX2DisplayManagerDiagServiceReply = mMX2DisplayManagerDiagServiceReply;
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
                    this.p_MMX2DisplayManagerDiagServiceReply.requestVideoInputState(l);
                    break;
                }
                case 15: {
                    long l = iDeserializer.getUInt32();
                    int n = iDeserializer.getEnum();
                    int n2 = iDeserializer.getEnum();
                    short s2 = iDeserializer.getUInt8();
                    this.p_MMX2DisplayManagerDiagServiceReply.requestTrunkOfferFBAS(l, n, n2, s2);
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


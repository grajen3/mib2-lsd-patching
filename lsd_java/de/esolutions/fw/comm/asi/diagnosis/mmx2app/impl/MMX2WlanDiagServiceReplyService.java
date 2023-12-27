/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2WlanDiagServiceReply;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class MMX2WlanDiagServiceReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.diagnosis.mmx2app.MMX2WlanDiagService");
    private static int dynamicHandle = 0;
    private MMX2WlanDiagServiceReply p_MMX2WlanDiagServiceReply;

    public MMX2WlanDiagServiceReplyService(MMX2WlanDiagServiceReply mMX2WlanDiagServiceReply) {
        super(new ServiceInstanceID("989f8f89-44c6-4314-b598-2523e0a7fcbb", MMX2WlanDiagServiceReplyService.nextDynamicHandle(), "4c16b9b4-44a6-5f3a-8651-b5a02c1ed480", "asi.diagnosis.mmx2app.MMX2WlanDiagService"));
        this.p_MMX2WlanDiagServiceReply = mMX2WlanDiagServiceReply;
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
                    this.p_MMX2WlanDiagServiceReply.requestWlanProperties(l);
                    break;
                }
                case 14: {
                    long l = iDeserializer.getUInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_MMX2WlanDiagServiceReply.requestSetWlanHotSpotActive(l, bl);
                    break;
                }
                case 16: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2WlanDiagServiceReply.requestWlanHotSpotActive(l);
                    break;
                }
                case 21: {
                    long l = iDeserializer.getUInt32();
                    boolean bl = iDeserializer.getBool();
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    int n = iDeserializer.getEnum();
                    this.p_MMX2WlanDiagServiceReply.requestWlanConnectToAP(l, bl, string, string2, n);
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


/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.uotanaviservice.impl;

import de.esolutions.fw.comm.asi.navigation.uotanaviservice.UOTANaviServiceReply;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class UOTANaviServiceReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.navigation.uotanaviservice.UOTANaviService");
    private static int dynamicHandle = 0;
    private UOTANaviServiceReply p_UOTANaviServiceReply;

    public UOTANaviServiceReplyService(UOTANaviServiceReply uOTANaviServiceReply) {
        super(new ServiceInstanceID("0d894ae4-0f7c-48e6-a7e3-0b9f0d32c51a", UOTANaviServiceReplyService.nextDynamicHandle(), "5e467618-909a-51d8-837e-36f5bbfa36a1", "asi.navigation.uotanaviservice.UOTANaviService"));
        this.p_UOTANaviServiceReply = uOTANaviServiceReply;
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
                    short s2 = iDeserializer.getInt16();
                    this.p_UOTANaviServiceReply.getVersionInfo(s2);
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


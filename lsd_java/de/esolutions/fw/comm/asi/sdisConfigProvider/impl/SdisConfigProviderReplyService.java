/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.sdisConfigProvider.impl;

import de.esolutions.fw.comm.asi.sdisConfigProvider.SdisConfigProviderReply;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class SdisConfigProviderReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.sdisConfigProvider.SdisConfigProvider");
    private static int dynamicHandle = 0;
    private SdisConfigProviderReply p_SdisConfigProviderReply;

    public SdisConfigProviderReplyService(SdisConfigProviderReply sdisConfigProviderReply) {
        super(new ServiceInstanceID("4005e13e-09f0-11e5-94dc-54ee7547f476", SdisConfigProviderReplyService.nextDynamicHandle(), "417013af-3c71-5487-8fc9-6d656a950fc5", "asi.sdisConfigProvider.SdisConfigProvider"));
        this.p_SdisConfigProviderReply = sdisConfigProviderReply;
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
                case 7: {
                    int n = iDeserializer.getInt32();
                    long l = iDeserializer.getUInt32();
                    this.p_SdisConfigProviderReply.updateConfig(n, l);
                    break;
                }
                case 6: {
                    String string = iDeserializer.getOptionalString();
                    boolean bl = iDeserializer.getBool();
                    this.p_SdisConfigProviderReply.updateASIVersion(string, bl);
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


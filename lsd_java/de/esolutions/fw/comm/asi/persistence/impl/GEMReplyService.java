/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.persistence.impl;

import de.esolutions.fw.comm.asi.persistence.GEMReply;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class GEMReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.persistence.GEM");
    private static int dynamicHandle = 0;
    private GEMReply p_GEMReply;

    public GEMReplyService(GEMReply gEMReply) {
        super(new ServiceInstanceID("116d951a-df12-5d02-93b4-69573b9d69b5", GEMReplyService.nextDynamicHandle(), "eddb9230-0b3c-558e-b321-dbb0a049fbfb", "asi.persistence.GEM"));
        this.p_GEMReply = gEMReply;
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
                    boolean bl = iDeserializer.getBool();
                    this.p_GEMReply.gemActive(bl);
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


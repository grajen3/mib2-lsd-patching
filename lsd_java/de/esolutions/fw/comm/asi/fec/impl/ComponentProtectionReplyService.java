/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec.impl;

import de.esolutions.fw.comm.asi.fec.ComponentProtectionReply;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ComponentProtectionReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.fec.ComponentProtection");
    private static int dynamicHandle = 0;
    private ComponentProtectionReply p_ComponentProtectionReply;

    public ComponentProtectionReplyService(ComponentProtectionReply componentProtectionReply) {
        super(new ServiceInstanceID("9e66ab21-39b4-11e0-9e42-0800200c9a66", ComponentProtectionReplyService.nextDynamicHandle(), "73f457d8-4826-5389-912d-2ec567427974", "asi.fec.ComponentProtection"));
        this.p_ComponentProtectionReply = componentProtectionReply;
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
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    byte by = iDeserializer.getInt8();
                    this.p_ComponentProtectionReply.authStringResult(string, string2, by);
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


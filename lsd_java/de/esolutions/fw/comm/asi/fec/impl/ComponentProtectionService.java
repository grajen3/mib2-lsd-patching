/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec.impl;

import de.esolutions.fw.comm.asi.fec.ComponentProtectionS;
import de.esolutions.fw.comm.asi.fec.impl.ComponentProtectionReplyProxy;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ComponentProtectionService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.fec.ComponentProtection");
    private ComponentProtectionS p_ComponentProtection;

    public ComponentProtectionService(int n, ComponentProtectionS componentProtectionS) {
        super(new ServiceInstanceID("9e66ab20-39b4-11e0-9e42-0800200c9a66", n, "ff4289cb-25d7-57d5-9068-5614ad250529", "asi.fec.ComponentProtection"));
        this.p_ComponentProtection = componentProtectionS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new ComponentProtectionReplyProxy();
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
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_ComponentProtection.authString(string, n, n2, (ComponentProtectionReplyProxy)iProxyFrontend);
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


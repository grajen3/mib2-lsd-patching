/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec.impl;

import de.esolutions.fw.comm.asi.fec.ComponentProtection;
import de.esolutions.fw.comm.asi.fec.ComponentProtectionC;
import de.esolutions.fw.comm.asi.fec.ComponentProtectionReply;
import de.esolutions.fw.comm.asi.fec.impl.ComponentProtectionReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ComponentProtectionProxy
implements ComponentProtection,
ComponentProtectionC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.fec.ComponentProtection");
    private Proxy proxy;

    public ComponentProtectionProxy(int n, ComponentProtectionReply componentProtectionReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("9e66ab20-39b4-11e0-9e42-0800200c9a66", n, "ff4289cb-25d7-57d5-9068-5614ad250529", "asi.fec.ComponentProtection");
        ComponentProtectionReplyService componentProtectionReplyService = new ComponentProtectionReplyService(componentProtectionReply);
        this.proxy = new Proxy(serviceInstanceID, componentProtectionReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void authString(String string, int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)0, genericSerializable);
    }
}


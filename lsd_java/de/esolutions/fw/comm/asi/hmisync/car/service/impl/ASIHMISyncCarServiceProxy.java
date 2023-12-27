/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.service.impl;

import de.esolutions.fw.comm.asi.hmisync.car.service.ASIHMISyncCarService;
import de.esolutions.fw.comm.asi.hmisync.car.service.ASIHMISyncCarServiceC;
import de.esolutions.fw.comm.asi.hmisync.car.service.ASIHMISyncCarServiceReply;
import de.esolutions.fw.comm.asi.hmisync.car.service.impl.ASIHMISyncCarServiceReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncCarServiceProxy
implements ASIHMISyncCarService,
ASIHMISyncCarServiceC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.hmisync.car.service.ASIHMISyncCarService");
    private Proxy proxy;

    public ASIHMISyncCarServiceProxy(int n, ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("8ccf0676-352e-4fe1-a86e-ed15a11ea69e", n, "a5b91462-5820-555c-8411-698e8ac5864d", "asi.hmisync.car.service.ASIHMISyncCarService");
        ASIHMISyncCarServiceReplyService aSIHMISyncCarServiceReplyService = new ASIHMISyncCarServiceReplyService(aSIHMISyncCarServiceReply);
        this.proxy = new Proxy(serviceInstanceID, aSIHMISyncCarServiceReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)3, null);
    }

    @Override
    public void setNotification(long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putUInt32(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)5, genericSerializable);
    }

    @Override
    public void setNotification(long[] lArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalUInt32VarArray(lArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)4, genericSerializable);
    }

    @Override
    public void clearNotification() {
        this.proxy.remoteCallMethod((short)0, null);
    }

    @Override
    public void clearNotification(long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putUInt32(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)2, genericSerializable);
    }

    @Override
    public void clearNotification(long[] lArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalUInt32VarArray(lArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)1, genericSerializable);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.ooc.app.impl;

import de.esolutions.fw.comm.asi.ooc.app.IOocApplication;
import de.esolutions.fw.comm.asi.ooc.app.IOocApplicationC;
import de.esolutions.fw.comm.asi.ooc.app.IOocApplicationReply;
import de.esolutions.fw.comm.asi.ooc.app.impl.IOocApplicationReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class IOocApplicationProxy
implements IOocApplication,
IOocApplicationC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.ooc.app.IOocApplication");
    private Proxy proxy;

    public IOocApplicationProxy(int n, IOocApplicationReply iOocApplicationReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("17b8d9e8-c125-4a29-9049-8e3cb4bfef59", n, "d9d2930f-88a6-55d1-912f-75f103b57a0c", "asi.ooc.app.IOocApplication");
        IOocApplicationReplyService iOocApplicationReplyService = new IOocApplicationReplyService(iOocApplicationReply);
        this.proxy = new Proxy(serviceInstanceID, iOocApplicationReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void setCarWakeup(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)11, genericSerializable);
    }

    @Override
    public void setCallActive(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)1, genericSerializable);
    }

    @Override
    public void setPhonePowerDelay(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)3, genericSerializable);
    }

    @Override
    public void setNavigationPowerDelay(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)2, genericSerializable);
    }

    @Override
    public void setApplicationState(int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putEnum(n);
            genericSerializable.putEnum(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)16, genericSerializable);
    }

    @Override
    public void setZrActive(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)9, genericSerializable);
    }

    @Override
    public void registerPowerEventListener() {
        this.proxy.remoteCallMethod((short)0, null);
    }

    @Override
    public void shutdownResponseFinal(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putEnum(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)17, genericSerializable);
    }
}


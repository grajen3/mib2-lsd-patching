/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.sdisConfigProvider.impl;

import de.esolutions.fw.comm.asi.sdisConfigProvider.SdisConfigProvider;
import de.esolutions.fw.comm.asi.sdisConfigProvider.SdisConfigProviderC;
import de.esolutions.fw.comm.asi.sdisConfigProvider.SdisConfigProviderReply;
import de.esolutions.fw.comm.asi.sdisConfigProvider.impl.SdisConfigProviderReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class SdisConfigProviderProxy
implements SdisConfigProvider,
SdisConfigProviderC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.sdisConfigProvider.SdisConfigProvider");
    private Proxy proxy;

    public SdisConfigProviderProxy(int n, SdisConfigProviderReply sdisConfigProviderReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("32a49c92-09f0-11e5-ab17-54ee7547f476", n, "55d7aa2c-01c8-521e-badb-7fa67d18f6b4", "asi.sdisConfigProvider.SdisConfigProvider");
        SdisConfigProviderReplyService sdisConfigProviderReplyService = new SdisConfigProviderReplyService(sdisConfigProviderReply);
        this.proxy = new Proxy(serviceInstanceID, sdisConfigProviderReplyService, context);
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


/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.esoposproviderfull.impl;

import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.EsoPosProviderFull;
import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.EsoPosProviderFullC;
import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.EsoPosProviderFullReply;
import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.impl.EsoPosProviderFullProxy$1;
import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.impl.EsoPosProviderFullReplyService;
import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.sConfig;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class EsoPosProviderFullProxy
implements EsoPosProviderFull,
EsoPosProviderFullC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.navigation.esoposproviderfull.EsoPosProviderFull");
    private Proxy proxy;

    public EsoPosProviderFullProxy(int n, EsoPosProviderFullReply esoPosProviderFullReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("3a8ac390-4251-11e3-9434-000c29e68a4a", n, "2c5da29e-82ab-5b99-8f06-68cfdd97c847", "asi.navigation.esoposproviderfull.EsoPosProviderFull");
        EsoPosProviderFullReplyService esoPosProviderFullReplyService = new EsoPosProviderFullReplyService(esoPosProviderFullReply);
        this.proxy = new Proxy(serviceInstanceID, esoPosProviderFullReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void setActive(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)8, genericSerializable);
    }

    @Override
    public void setConfig(sConfig sConfig2) {
        EsoPosProviderFullProxy$1 esoPosProviderFullProxy$1 = new EsoPosProviderFullProxy$1(this, sConfig2);
        this.proxy.remoteCallMethod((short)15, esoPosProviderFullProxy$1);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)16, null);
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
        this.proxy.remoteCallMethod((short)18, genericSerializable);
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
        this.proxy.remoteCallMethod((short)17, genericSerializable);
    }

    @Override
    public void clearNotification() {
        this.proxy.remoteCallMethod((short)12, null);
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
        this.proxy.remoteCallMethod((short)14, genericSerializable);
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
        this.proxy.remoteCallMethod((short)13, genericSerializable);
    }
}


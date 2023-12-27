/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.has.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.has.DSIHAS;
import de.esolutions.fw.comm.dsi.has.DSIHASC;
import de.esolutions.fw.comm.dsi.has.DSIHASReply;
import de.esolutions.fw.comm.dsi.has.impl.DSIHASProxy$1;
import de.esolutions.fw.comm.dsi.has.impl.DSIHASProxy$2;
import de.esolutions.fw.comm.dsi.has.impl.DSIHASReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.has.HASDataContainer;

public class DSIHASProxy
implements DSIHAS,
DSIHASC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.has.DSIHAS");
    private Proxy proxy;

    public DSIHASProxy(int n, DSIHASReply dSIHASReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("9aa7fbc8-ef68-52c8-b441-39d5bc8cc9e1", n, "569dc367-0d8b-5f26-9c24-740e5ab0b2d5", "dsi.has.DSIHAS");
        DSIHASReplyService dSIHASReplyService = new DSIHASReplyService(dSIHASReply);
        this.proxy = new Proxy(serviceInstanceID, dSIHASReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void hmiReady() {
        this.proxy.remoteCallMethod((short)7, null);
    }

    @Override
    public void actionResult(int n, int n2, HASDataContainer[] hASDataContainerArray, int n3) {
        DSIHASProxy$1 dSIHASProxy$1 = new DSIHASProxy$1(this, n, n2, hASDataContainerArray, n3);
        this.proxy.remoteCallMethod((short)22, dSIHASProxy$1);
    }

    @Override
    public void propertyUpdate(int n, HASDataContainer[] hASDataContainerArray, int n2) {
        DSIHASProxy$2 dSIHASProxy$2 = new DSIHASProxy$2(this, n, hASDataContainerArray, n2);
        this.proxy.remoteCallMethod((short)23, dSIHASProxy$2);
    }

    @Override
    public void subscribeResult(int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)13, genericSerializable);
    }

    @Override
    public void setNotification(int[] nArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)10, genericSerializable);
    }

    @Override
    public void setNotification(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)11, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)9, null);
    }

    @Override
    public void clearNotification(int[] nArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)4, genericSerializable);
    }

    @Override
    public void clearNotification(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)5, genericSerializable);
    }

    @Override
    public void clearNotification() {
        this.proxy.remoteCallMethod((short)3, null);
    }

    @Override
    public void yySet(String string, String string2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)17, genericSerializable);
    }
}


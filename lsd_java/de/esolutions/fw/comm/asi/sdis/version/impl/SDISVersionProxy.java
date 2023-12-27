/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.sdis.version.impl;

import de.esolutions.fw.comm.asi.sdis.version.SDISVersion;
import de.esolutions.fw.comm.asi.sdis.version.SDISVersionC;
import de.esolutions.fw.comm.asi.sdis.version.SDISVersionReply;
import de.esolutions.fw.comm.asi.sdis.version.impl.SDISVersionReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class SDISVersionProxy
implements SDISVersion,
SDISVersionC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.sdis.version.SDISVersion");
    private Proxy proxy;

    public SDISVersionProxy(int n, SDISVersionReply sDISVersionReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("9f423a8a-9d3b-11e3-8d05-425861b86ab6", n, "e18d49e8-df08-5653-82f0-9f73b0153623", "asi.sdis.version.SDISVersion");
        SDISVersionReplyService sDISVersionReplyService = new SDISVersionReplyService(sDISVersionReply);
        this.proxy = new Proxy(serviceInstanceID, sDISVersionReplyService, context);
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


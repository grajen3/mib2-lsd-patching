/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.exlap.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.exlap.DSIExlap;
import de.esolutions.fw.comm.dsi.exlap.DSIExlapC;
import de.esolutions.fw.comm.dsi.exlap.DSIExlapReply;
import de.esolutions.fw.comm.dsi.exlap.impl.DSIExlapReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSIExlapProxy
implements DSIExlap,
DSIExlapC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.exlap.DSIExlap");
    private Proxy proxy;

    public DSIExlapProxy(int n, DSIExlapReply dSIExlapReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("9c413fda-de26-578b-883c-0fc452876daf", n, "22d11892-c07e-5572-9794-313e05ce6279", "dsi.exlap.DSIExlap");
        DSIExlapReplyService dSIExlapReplyService = new DSIExlapReplyService(dSIExlapReply);
        this.proxy = new Proxy(serviceInstanceID, dSIExlapReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void start() {
        this.proxy.remoteCallMethod((short)9, null);
    }

    @Override
    public void stop() {
        this.proxy.remoteCallMethod((short)11, null);
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
        this.proxy.remoteCallMethod((short)7, genericSerializable);
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
        this.proxy.remoteCallMethod((short)8, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)6, null);
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
        this.proxy.remoteCallMethod((short)3, genericSerializable);
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
        this.proxy.remoteCallMethod((short)4, genericSerializable);
    }

    @Override
    public void clearNotification() {
        this.proxy.remoteCallMethod((short)2, null);
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
        this.proxy.remoteCallMethod((short)13, genericSerializable);
    }
}


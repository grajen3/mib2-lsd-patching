/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.startup.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.startup.DSIStartup;
import de.esolutions.fw.comm.dsi.startup.DSIStartupC;
import de.esolutions.fw.comm.dsi.startup.DSIStartupReply;
import de.esolutions.fw.comm.dsi.startup.impl.DSIStartupReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSIStartupProxy
implements DSIStartup,
DSIStartupC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.startup.DSIStartup");
    private Proxy proxy;

    public DSIStartupProxy(int n, DSIStartupReply dSIStartupReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("f6db1c7c-7ff9-5fd1-97ba-7298745f1eb1", n, "be1098f9-5f0f-5616-b7e3-b9ca49a0507c", "dsi.startup.DSIStartup");
        DSIStartupReplyService dSIStartupReplyService = new DSIStartupReplyService(dSIStartupReply);
        this.proxy = new Proxy(serviceInstanceID, dSIStartupReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void startDomain(int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)6, genericSerializable);
    }

    @Override
    public void hmiCompletelyStarted() {
        this.proxy.remoteCallMethod((short)38, null);
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
        this.proxy.remoteCallMethod((short)4, genericSerializable);
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
        this.proxy.remoteCallMethod((short)5, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)3, null);
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
        this.proxy.remoteCallMethod((short)1, genericSerializable);
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
        this.proxy.remoteCallMethod((short)2, genericSerializable);
    }

    @Override
    public void clearNotification() {
        this.proxy.remoteCallMethod((short)0, null);
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
        this.proxy.remoteCallMethod((short)7, genericSerializable);
    }
}


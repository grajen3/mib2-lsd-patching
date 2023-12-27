/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.online.DSIOnlinePicNav;
import de.esolutions.fw.comm.dsi.online.DSIOnlinePicNavC;
import de.esolutions.fw.comm.dsi.online.DSIOnlinePicNavReply;
import de.esolutions.fw.comm.dsi.online.impl.DSIOnlinePicNavReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSIOnlinePicNavProxy
implements DSIOnlinePicNav,
DSIOnlinePicNavC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.online.DSIOnlinePicNav");
    private Proxy proxy;

    public DSIOnlinePicNavProxy(int n, DSIOnlinePicNavReply dSIOnlinePicNavReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("329cbce3-6f99-5a6f-8338-88e6919e07fb", n, "29244511-a9ef-569a-9665-841afa8f88ad", "dsi.online.DSIOnlinePicNav");
        DSIOnlinePicNavReplyService dSIOnlinePicNavReplyService = new DSIOnlinePicNavReplyService(dSIOnlinePicNavReply);
        this.proxy = new Proxy(serviceInstanceID, dSIOnlinePicNavReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void synchronize() {
        this.proxy.remoteCallMethod((short)7, null);
    }

    @Override
    public void abortSync() {
        this.proxy.remoteCallMethod((short)0, null);
    }

    @Override
    public void getPendingTransactions() {
        this.proxy.remoteCallMethod((short)9, null);
    }

    @Override
    public void setActiveProfile(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)10, genericSerializable);
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
        this.proxy.remoteCallMethod((short)5, genericSerializable);
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
        this.proxy.remoteCallMethod((short)6, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)4, null);
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
        this.proxy.remoteCallMethod((short)2, genericSerializable);
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
        this.proxy.remoteCallMethod((short)3, genericSerializable);
    }

    @Override
    public void clearNotification() {
        this.proxy.remoteCallMethod((short)1, null);
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
        this.proxy.remoteCallMethod((short)8, genericSerializable);
    }
}


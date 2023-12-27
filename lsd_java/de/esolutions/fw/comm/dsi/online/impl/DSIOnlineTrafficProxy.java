/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.online.DSIOnlineTraffic;
import de.esolutions.fw.comm.dsi.online.DSIOnlineTrafficC;
import de.esolutions.fw.comm.dsi.online.DSIOnlineTrafficReply;
import de.esolutions.fw.comm.dsi.online.impl.DSIOnlineTrafficReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSIOnlineTrafficProxy
implements DSIOnlineTraffic,
DSIOnlineTrafficC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.online.DSIOnlineTraffic");
    private Proxy proxy;

    public DSIOnlineTrafficProxy(int n, DSIOnlineTrafficReply dSIOnlineTrafficReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("12bc15c1-5424-583d-92e1-5442fafc4f7f", n, "f3a652c2-a019-53a6-b8d4-710ffeff48f3", "dsi.online.DSIOnlineTraffic");
        DSIOnlineTrafficReplyService dSIOnlineTrafficReplyService = new DSIOnlineTrafficReplyService(dSIOnlineTrafficReply);
        this.proxy = new Proxy(serviceInstanceID, dSIOnlineTrafficReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void setOnlineTrafficDataStatus(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)9, genericSerializable);
    }

    @Override
    public void getNewData() {
        this.proxy.remoteCallMethod((short)12, null);
    }

    @Override
    public void setNewData(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)4, genericSerializable);
    }

    @Override
    public void setTimeoutForFallback(long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)13, genericSerializable);
    }

    @Override
    public void setNewSession() {
        this.proxy.remoteCallMethod((short)5, null);
    }

    @Override
    public void getNewFCDInformation() {
        this.proxy.remoteCallMethod((short)15, null);
    }

    @Override
    public void getInventory() {
        this.proxy.remoteCallMethod((short)14, null);
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
        this.proxy.remoteCallMethod((short)11, genericSerializable);
    }
}


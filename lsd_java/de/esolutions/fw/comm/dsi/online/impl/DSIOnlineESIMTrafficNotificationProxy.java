/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.online.DSIOnlineESIMTrafficNotification;
import de.esolutions.fw.comm.dsi.online.DSIOnlineESIMTrafficNotificationC;
import de.esolutions.fw.comm.dsi.online.DSIOnlineESIMTrafficNotificationReply;
import de.esolutions.fw.comm.dsi.online.impl.DSIOnlineESIMTrafficNotificationReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSIOnlineESIMTrafficNotificationProxy
implements DSIOnlineESIMTrafficNotification,
DSIOnlineESIMTrafficNotificationC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.online.DSIOnlineESIMTrafficNotification");
    private Proxy proxy;

    public DSIOnlineESIMTrafficNotificationProxy(int n, DSIOnlineESIMTrafficNotificationReply dSIOnlineESIMTrafficNotificationReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("bcc69e7f-d107-5b5a-a6a5-0216a2cdb952", n, "9263ea87-4f96-5e7a-9cc4-c26720d77907", "dsi.online.DSIOnlineESIMTrafficNotification");
        DSIOnlineESIMTrafficNotificationReplyService dSIOnlineESIMTrafficNotificationReplyService = new DSIOnlineESIMTrafficNotificationReplyService(dSIOnlineESIMTrafficNotificationReply);
        this.proxy = new Proxy(serviceInstanceID, dSIOnlineESIMTrafficNotificationReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
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
        this.proxy.remoteCallMethod((short)9, genericSerializable);
    }
}


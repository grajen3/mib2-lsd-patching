/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.swdllogging.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.swdllogging.DSISwdlLogging;
import de.esolutions.fw.comm.dsi.swdllogging.DSISwdlLoggingC;
import de.esolutions.fw.comm.dsi.swdllogging.DSISwdlLoggingReply;
import de.esolutions.fw.comm.dsi.swdllogging.impl.DSISwdlLoggingReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSISwdlLoggingProxy
implements DSISwdlLogging,
DSISwdlLoggingC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.swdllogging.DSISwdlLogging");
    private Proxy proxy;

    public DSISwdlLoggingProxy(int n, DSISwdlLoggingReply dSISwdlLoggingReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("a9a00c44-4e80-5bc7-bbef-2760e73ab96a", n, "d668926e-197a-5ae1-aea0-870b7f2dbf21", "dsi.swdllogging.DSISwdlLogging");
        DSISwdlLoggingReplyService dSISwdlLoggingReplyService = new DSISwdlLoggingReplyService(dSISwdlLoggingReply);
        this.proxy = new Proxy(serviceInstanceID, dSISwdlLoggingReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void getHistory() {
        this.proxy.remoteCallMethod((short)6, null);
    }

    @Override
    public void setUpdate(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)17, genericSerializable);
    }

    @Override
    public void selectSubUpdate(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)12, genericSerializable);
    }

    @Override
    public void getGeneralInformation() {
        this.proxy.remoteCallMethod((short)4, null);
    }

    @Override
    public void getUnusualEvents() {
        this.proxy.remoteCallMethod((short)10, null);
    }

    @Override
    public void getUnusualEvent(int n) {
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
    public void setNotification(int[] nArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)14, genericSerializable);
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
        this.proxy.remoteCallMethod((short)15, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)13, null);
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
        this.proxy.remoteCallMethod((short)19, genericSerializable);
    }
}


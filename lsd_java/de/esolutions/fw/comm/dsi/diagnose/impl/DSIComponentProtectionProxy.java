/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.diagnose.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.diagnose.DSIComponentProtection;
import de.esolutions.fw.comm.dsi.diagnose.DSIComponentProtectionC;
import de.esolutions.fw.comm.dsi.diagnose.DSIComponentProtectionReply;
import de.esolutions.fw.comm.dsi.diagnose.impl.DSIComponentProtectionReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSIComponentProtectionProxy
implements DSIComponentProtection,
DSIComponentProtectionC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.diagnose.DSIComponentProtection");
    private Proxy proxy;

    public DSIComponentProtectionProxy(int n, DSIComponentProtectionReply dSIComponentProtectionReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("11968057-7d03-5bf2-a680-ea43e050b90a", n, "a530ecf3-88a7-5913-b5d3-8c90a4a76837", "dsi.diagnose.DSIComponentProtection");
        DSIComponentProtectionReplyService dSIComponentProtectionReplyService = new DSIComponentProtectionReplyService(dSIComponentProtectionReply);
        this.proxy = new Proxy(serviceInstanceID, dSIComponentProtectionReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void authString(String string, int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)1, genericSerializable);
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
        this.proxy.remoteCallMethod((short)10, genericSerializable);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.online.DSIOperatorCall;
import de.esolutions.fw.comm.dsi.online.DSIOperatorCallC;
import de.esolutions.fw.comm.dsi.online.DSIOperatorCallReply;
import de.esolutions.fw.comm.dsi.online.impl.DSIOperatorCallProxy$1;
import de.esolutions.fw.comm.dsi.online.impl.DSIOperatorCallReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.online.OperatorCallData;

public class DSIOperatorCallProxy
implements DSIOperatorCall,
DSIOperatorCallC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.online.DSIOperatorCall");
    private Proxy proxy;

    public DSIOperatorCallProxy(int n, DSIOperatorCallReply dSIOperatorCallReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("2a1c5862-a6e9-5faf-8fb0-01c3e94a7f64", n, "5affe99d-9abb-58f1-9773-f236212f5c83", "dsi.online.DSIOperatorCall");
        DSIOperatorCallReplyService dSIOperatorCallReplyService = new DSIOperatorCallReplyService(dSIOperatorCallReply);
        this.proxy = new Proxy(serviceInstanceID, dSIOperatorCallReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void requestOperatorCallResult(String string, int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)14, genericSerializable);
    }

    @Override
    public void requestOperatorPhoneNumber(int n, OperatorCallData operatorCallData, boolean bl) {
        DSIOperatorCallProxy$1 dSIOperatorCallProxy$1 = new DSIOperatorCallProxy$1(this, n, operatorCallData, bl);
        this.proxy.remoteCallMethod((short)15, dSIOperatorCallProxy$1);
    }

    @Override
    public void setLanguage(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
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
        this.proxy.remoteCallMethod((short)13, genericSerializable);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.instance.impl;

import de.esolutions.fw.comm.asi.hmisync.instance.ASIHMISyncInstance;
import de.esolutions.fw.comm.asi.hmisync.instance.ASIHMISyncInstanceC;
import de.esolutions.fw.comm.asi.hmisync.instance.ASIHMISyncInstanceReply;
import de.esolutions.fw.comm.asi.hmisync.instance.impl.ASIHMISyncInstanceReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncInstanceProxy
implements ASIHMISyncInstance,
ASIHMISyncInstanceC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.hmisync.instance.ASIHMISyncInstance");
    private Proxy proxy;

    public ASIHMISyncInstanceProxy(int n, ASIHMISyncInstanceReply aSIHMISyncInstanceReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("ec3859ab-0660-4557-8339-69dc874fe86b", n, "b0085475-d550-520a-8dc6-1d1e3293432f", "asi.hmisync.instance.ASIHMISyncInstance");
        ASIHMISyncInstanceReplyService aSIHMISyncInstanceReplyService = new ASIHMISyncInstanceReplyService(aSIHMISyncInstanceReply);
        this.proxy = new Proxy(serviceInstanceID, aSIHMISyncInstanceReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void requestInstanceId(String string, String string2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)3, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)5, null);
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
        this.proxy.remoteCallMethod((short)7, genericSerializable);
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
        this.proxy.remoteCallMethod((short)6, genericSerializable);
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


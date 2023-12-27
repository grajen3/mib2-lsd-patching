/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.mastercontrol.impl;

import de.esolutions.fw.comm.asi.hmisync.mastercontrol.ASIHMISyncMasterControl;
import de.esolutions.fw.comm.asi.hmisync.mastercontrol.ASIHMISyncMasterControlC;
import de.esolutions.fw.comm.asi.hmisync.mastercontrol.ASIHMISyncMasterControlReply;
import de.esolutions.fw.comm.asi.hmisync.mastercontrol.impl.ASIHMISyncMasterControlReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncMasterControlProxy
implements ASIHMISyncMasterControl,
ASIHMISyncMasterControlC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.hmisync.mastercontrol.ASIHMISyncMasterControl");
    private Proxy proxy;

    public ASIHMISyncMasterControlProxy(int n, ASIHMISyncMasterControlReply aSIHMISyncMasterControlReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("bacc7eeb-475f-4a14-ad22-d3b237ca4c1b", n, "5e04952b-b55c-5075-a09b-d930bfab035a", "asi.hmisync.mastercontrol.ASIHMISyncMasterControl");
        ASIHMISyncMasterControlReplyService aSIHMISyncMasterControlReplyService = new ASIHMISyncMasterControlReplyService(aSIHMISyncMasterControlReply);
        this.proxy = new Proxy(serviceInstanceID, aSIHMISyncMasterControlReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
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


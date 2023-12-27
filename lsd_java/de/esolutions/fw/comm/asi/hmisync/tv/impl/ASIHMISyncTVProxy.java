/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.tv.impl;

import de.esolutions.fw.comm.asi.hmisync.tv.ASIHMISyncTV;
import de.esolutions.fw.comm.asi.hmisync.tv.ASIHMISyncTVC;
import de.esolutions.fw.comm.asi.hmisync.tv.ASIHMISyncTVReply;
import de.esolutions.fw.comm.asi.hmisync.tv.impl.ASIHMISyncTVReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncTVProxy
implements ASIHMISyncTV,
ASIHMISyncTVC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.hmisync.tv.ASIHMISyncTV");
    private Proxy proxy;

    public ASIHMISyncTVProxy(int n, ASIHMISyncTVReply aSIHMISyncTVReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("3b9b7c34-a5a9-4acd-a935-dde0b43bf263", n, "625d5dc3-8ed0-5a34-9759-b22cba16e480", "asi.hmisync.tv.ASIHMISyncTV");
        ASIHMISyncTVReplyService aSIHMISyncTVReplyService = new ASIHMISyncTVReplyService(aSIHMISyncTVReply);
        this.proxy = new Proxy(serviceInstanceID, aSIHMISyncTVReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void setActiveStation(long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)7, genericSerializable);
    }

    @Override
    public void logonToTV() {
        this.proxy.remoteCallMethod((short)4, null);
    }

    @Override
    public void logoffFromTV() {
        this.proxy.remoteCallMethod((short)3, null);
    }

    @Override
    public void sendPressedPanelKey(byte by) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt8(by);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)6, genericSerializable);
    }

    @Override
    public void searchChannel(byte by) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt8(by);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)5, genericSerializable);
    }

    @Override
    public void setTerminalMode(byte by) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt8(by);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)11, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)8, null);
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
        this.proxy.remoteCallMethod((short)10, genericSerializable);
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
        this.proxy.remoteCallMethod((short)9, genericSerializable);
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


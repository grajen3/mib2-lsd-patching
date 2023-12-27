/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.climate.impl;

import de.esolutions.fw.comm.asi.hmisync.car.climate.ASIHMISyncCarClimate;
import de.esolutions.fw.comm.asi.hmisync.car.climate.ASIHMISyncCarClimateC;
import de.esolutions.fw.comm.asi.hmisync.car.climate.ASIHMISyncCarClimateReply;
import de.esolutions.fw.comm.asi.hmisync.car.climate.impl.ASIHMISyncCarClimateReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncCarClimateProxy
implements ASIHMISyncCarClimate,
ASIHMISyncCarClimateC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.hmisync.car.climate.ASIHMISyncCarClimate");
    private Proxy proxy;

    public ASIHMISyncCarClimateProxy(int n, ASIHMISyncCarClimateReply aSIHMISyncCarClimateReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("ff03f2f6-eceb-470b-8239-62939e77c4ac", n, "c5ac76c2-2476-5a12-9346-cccd09428a82", "asi.hmisync.car.climate.ASIHMISyncCarClimate");
        ASIHMISyncCarClimateReplyService aSIHMISyncCarClimateReplyService = new ASIHMISyncCarClimateReplyService(aSIHMISyncCarClimateReply);
        this.proxy = new Proxy(serviceInstanceID, aSIHMISyncCarClimateReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void setAirconAC(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)3, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)4, null);
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
        this.proxy.remoteCallMethod((short)6, genericSerializable);
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
        this.proxy.remoteCallMethod((short)5, genericSerializable);
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


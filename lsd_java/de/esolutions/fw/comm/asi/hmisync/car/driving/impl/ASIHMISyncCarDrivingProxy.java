/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.driving.impl;

import de.esolutions.fw.comm.asi.hmisync.car.driving.ASIHMISyncCarDriving;
import de.esolutions.fw.comm.asi.hmisync.car.driving.ASIHMISyncCarDrivingC;
import de.esolutions.fw.comm.asi.hmisync.car.driving.ASIHMISyncCarDrivingReply;
import de.esolutions.fw.comm.asi.hmisync.car.driving.impl.ASIHMISyncCarDrivingReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncCarDrivingProxy
implements ASIHMISyncCarDriving,
ASIHMISyncCarDrivingC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.hmisync.car.driving.ASIHMISyncCarDriving");
    private Proxy proxy;

    public ASIHMISyncCarDrivingProxy(int n, ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("4100596a-a26d-4625-84dc-0b3013890cde", n, "a3a2eb6d-2c8e-59dd-b6c4-6d6508e2f15f", "asi.hmisync.car.driving.ASIHMISyncCarDriving");
        ASIHMISyncCarDrivingReplyService aSIHMISyncCarDrivingReplyService = new ASIHMISyncCarDrivingReplyService(aSIHMISyncCarDrivingReply);
        this.proxy = new Proxy(serviceInstanceID, aSIHMISyncCarDrivingReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)3, null);
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
        this.proxy.remoteCallMethod((short)5, genericSerializable);
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
        this.proxy.remoteCallMethod((short)4, genericSerializable);
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


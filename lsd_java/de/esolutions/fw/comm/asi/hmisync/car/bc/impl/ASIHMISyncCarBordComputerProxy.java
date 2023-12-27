/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.bc.impl;

import de.esolutions.fw.comm.asi.hmisync.car.bc.ASIHMISyncCarBordComputer;
import de.esolutions.fw.comm.asi.hmisync.car.bc.ASIHMISyncCarBordComputerC;
import de.esolutions.fw.comm.asi.hmisync.car.bc.ASIHMISyncCarBordComputerReply;
import de.esolutions.fw.comm.asi.hmisync.car.bc.impl.ASIHMISyncCarBordComputerReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncCarBordComputerProxy
implements ASIHMISyncCarBordComputer,
ASIHMISyncCarBordComputerC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.hmisync.car.bc.ASIHMISyncCarBordComputer");
    private Proxy proxy;

    public ASIHMISyncCarBordComputerProxy(int n, ASIHMISyncCarBordComputerReply aSIHMISyncCarBordComputerReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("7bf67018-bebb-46f4-bf0f-0d5345fcf213", n, "2a6a543b-0fe6-5170-9fb4-6c05144dfe9c", "asi.hmisync.car.bc.ASIHMISyncCarBordComputer");
        ASIHMISyncCarBordComputerReplyService aSIHMISyncCarBordComputerReplyService = new ASIHMISyncCarBordComputerReplyService(aSIHMISyncCarBordComputerReply);
        this.proxy = new Proxy(serviceInstanceID, aSIHMISyncCarBordComputerReplyService, context);
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


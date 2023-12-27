/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl;

import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.ASIHMISyncCarSportChrono;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.ASIHMISyncCarSportChronoC;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.ASIHMISyncCarSportChronoReply;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.SCData;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.SCHeader;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl.ASIHMISyncCarSportChronoProxy$1;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl.ASIHMISyncCarSportChronoProxy$2;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl.ASIHMISyncCarSportChronoReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncCarSportChronoProxy
implements ASIHMISyncCarSportChrono,
ASIHMISyncCarSportChronoC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.hmisync.car.sportchrono.ASIHMISyncCarSportChrono");
    private Proxy proxy;

    public ASIHMISyncCarSportChronoProxy(int n, ASIHMISyncCarSportChronoReply aSIHMISyncCarSportChronoReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("f6e30936-2963-4f91-ac52-c32bdac06478", n, "206974b6-62b0-5276-9413-00d6e1532c16", "asi.hmisync.car.sportchrono.ASIHMISyncCarSportChrono");
        ASIHMISyncCarSportChronoReplyService aSIHMISyncCarSportChronoReplyService = new ASIHMISyncCarSportChronoReplyService(aSIHMISyncCarSportChronoReply);
        this.proxy = new Proxy(serviceInstanceID, aSIHMISyncCarSportChronoReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void requestRecordData(long l, long l2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
            genericSerializable.putInt64(l2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)4, genericSerializable);
    }

    @Override
    public void setRecord(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)13, genericSerializable);
    }

    @Override
    public void requestTrackData(int n) {
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
    public void initTrackTransfer(SCHeader sCHeader, String string) {
        ASIHMISyncCarSportChronoProxy$1 aSIHMISyncCarSportChronoProxy$1 = new ASIHMISyncCarSportChronoProxy$1(this, sCHeader, string);
        this.proxy.remoteCallMethod((short)3, aSIHMISyncCarSportChronoProxy$1);
    }

    @Override
    public void setTrackData(int n, SCData[] sCDataArray, int n2) {
        ASIHMISyncCarSportChronoProxy$2 aSIHMISyncCarSportChronoProxy$2 = new ASIHMISyncCarSportChronoProxy$2(this, n, sCDataArray, n2);
        this.proxy.remoteCallMethod((short)14, aSIHMISyncCarSportChronoProxy$2);
    }

    @Override
    public void setReferenceLap(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)31, genericSerializable);
    }

    @Override
    public void requestReferenceLapData(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)26, genericSerializable);
    }

    @Override
    public void saveReferenceLap(int n, short s) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt16(s);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)30, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)10, null);
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
        this.proxy.remoteCallMethod((short)12, genericSerializable);
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
        this.proxy.remoteCallMethod((short)11, genericSerializable);
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


/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sRoutineResponse;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2TelephoneDiagService;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2TelephoneDiagServiceC;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2TelephoneDiagServiceReply;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2TelephoneDiagServiceProxy$1;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2TelephoneDiagServiceProxy$2;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2TelephoneDiagServiceProxy$3;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2TelephoneDiagServiceProxy$4;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2TelephoneDiagServiceProxy$5;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2TelephoneDiagServiceProxy$6;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2TelephoneDiagServiceProxy$7;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2TelephoneDiagServiceProxy$8;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2TelephoneDiagServiceProxy$9;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2TelephoneDiagServiceReplyService;
import de.esolutions.fw.comm.asi.diagnosis.telephone.sConnectedBtHandset;
import de.esolutions.fw.comm.asi.diagnosis.telephone.sNadIMEI;
import de.esolutions.fw.comm.asi.diagnosis.telephone.sNumberHandsetsHUCs;
import de.esolutions.fw.comm.asi.diagnosis.telephone.sSimState;
import de.esolutions.fw.comm.asi.diagnosis.telephone.sTelephoneAntennaState;
import de.esolutions.fw.comm.asi.diagnosis.telephone.sTelephoneNetworkState;
import de.esolutions.fw.comm.asi.diagnosis.telephone.sTelephoneTemperature;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class MMX2TelephoneDiagServiceProxy
implements MMX2TelephoneDiagService,
MMX2TelephoneDiagServiceC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.diagnosis.mmx2app.MMX2TelephoneDiagService");
    private Proxy proxy;

    public MMX2TelephoneDiagServiceProxy(int n, MMX2TelephoneDiagServiceReply mMX2TelephoneDiagServiceReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("1875f7e5-0255-4283-8265-93dd91cd564d", n, "18c56909-7a93-5017-a939-9202333ba69e", "asi.diagnosis.mmx2app.MMX2TelephoneDiagService");
        MMX2TelephoneDiagServiceReplyService mMX2TelephoneDiagServiceReplyService = new MMX2TelephoneDiagServiceReplyService(mMX2TelephoneDiagServiceReply);
        this.proxy = new Proxy(serviceInstanceID, mMX2TelephoneDiagServiceReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void responseErrorTelephone(sClientResponseError sClientResponseError2) {
        MMX2TelephoneDiagServiceProxy$1 mMX2TelephoneDiagServiceProxy$1 = new MMX2TelephoneDiagServiceProxy$1(this, sClientResponseError2);
        this.proxy.remoteCallMethod((short)43, mMX2TelephoneDiagServiceProxy$1);
    }

    @Override
    public void responseSimState(sSimState sSimState2) {
        MMX2TelephoneDiagServiceProxy$2 mMX2TelephoneDiagServiceProxy$2 = new MMX2TelephoneDiagServiceProxy$2(this, sSimState2);
        this.proxy.remoteCallMethod((short)42, mMX2TelephoneDiagServiceProxy$2);
    }

    @Override
    public void responseNadIMEI(sNadIMEI sNadIMEI2) {
        MMX2TelephoneDiagServiceProxy$3 mMX2TelephoneDiagServiceProxy$3 = new MMX2TelephoneDiagServiceProxy$3(this, sNadIMEI2);
        this.proxy.remoteCallMethod((short)10, mMX2TelephoneDiagServiceProxy$3);
    }

    @Override
    public void responseTelephoneAntennaState(sTelephoneAntennaState sTelephoneAntennaState2) {
        MMX2TelephoneDiagServiceProxy$4 mMX2TelephoneDiagServiceProxy$4 = new MMX2TelephoneDiagServiceProxy$4(this, sTelephoneAntennaState2);
        this.proxy.remoteCallMethod((short)31, mMX2TelephoneDiagServiceProxy$4);
    }

    @Override
    public void responseConnectedBtHandset(sConnectedBtHandset sConnectedBtHandset2) {
        MMX2TelephoneDiagServiceProxy$5 mMX2TelephoneDiagServiceProxy$5 = new MMX2TelephoneDiagServiceProxy$5(this, sConnectedBtHandset2);
        this.proxy.remoteCallMethod((short)7, mMX2TelephoneDiagServiceProxy$5);
    }

    @Override
    public void responseNumberHandsetsHUCs(sNumberHandsetsHUCs sNumberHandsetsHUCs2) {
        MMX2TelephoneDiagServiceProxy$6 mMX2TelephoneDiagServiceProxy$6 = new MMX2TelephoneDiagServiceProxy$6(this, sNumberHandsetsHUCs2);
        this.proxy.remoteCallMethod((short)11, mMX2TelephoneDiagServiceProxy$6);
    }

    @Override
    public void responseTelephoneNetworkState(sTelephoneNetworkState sTelephoneNetworkState2) {
        MMX2TelephoneDiagServiceProxy$7 mMX2TelephoneDiagServiceProxy$7 = new MMX2TelephoneDiagServiceProxy$7(this, sTelephoneNetworkState2);
        this.proxy.remoteCallMethod((short)29, mMX2TelephoneDiagServiceProxy$7);
    }

    @Override
    public void responseTelephoneTemperature(sTelephoneTemperature sTelephoneTemperature2) {
        MMX2TelephoneDiagServiceProxy$8 mMX2TelephoneDiagServiceProxy$8 = new MMX2TelephoneDiagServiceProxy$8(this, sTelephoneTemperature2);
        this.proxy.remoteCallMethod((short)27, mMX2TelephoneDiagServiceProxy$8);
    }

    @Override
    public void responseDeleteMemory(sRoutineResponse sRoutineResponse2) {
        MMX2TelephoneDiagServiceProxy$9 mMX2TelephoneDiagServiceProxy$9 = new MMX2TelephoneDiagServiceProxy$9(this, sRoutineResponse2);
        this.proxy.remoteCallMethod((short)25, mMX2TelephoneDiagServiceProxy$9);
    }

    @Override
    public void responseNetworkName(long l, String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putUInt32(l);
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)38, genericSerializable);
    }

    @Override
    public void responseNetworkType(long l, int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putUInt32(l);
            genericSerializable.putEnum(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)39, genericSerializable);
    }

    @Override
    public void responseDialNumber(long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putUInt32(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)37, genericSerializable);
    }

    @Override
    public void responseCallStatus(long l, boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putUInt32(l);
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)36, genericSerializable);
    }

    @Override
    public void responseInternalSimIdentification(long l, String string, String string2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putUInt32(l);
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)41, genericSerializable);
    }
}


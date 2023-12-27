/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sApplicationSoftwareVersionNumber;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSerialNumber;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSparePartNumber;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSubsystemState;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSystemName;
import de.esolutions.fw.comm.asi.diagnosis.media.sActiveMediaSourceState;
import de.esolutions.fw.comm.asi.diagnosis.media.sDTCPState;
import de.esolutions.fw.comm.asi.diagnosis.media.sMediaDBVersion;
import de.esolutions.fw.comm.asi.diagnosis.media.sMediaRegionCodes;
import de.esolutions.fw.comm.asi.diagnosis.media.sMediaTypeOpticalDrive;
import de.esolutions.fw.comm.asi.diagnosis.media.sPmlState;
import de.esolutions.fw.comm.asi.diagnosis.media.sUsbOvercurrent;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2MediaDiagService;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2MediaDiagServiceC;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2MediaDiagServiceReply;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2MediaDiagServiceProxy$1;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2MediaDiagServiceProxy$10;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2MediaDiagServiceProxy$11;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2MediaDiagServiceProxy$12;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2MediaDiagServiceProxy$13;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2MediaDiagServiceProxy$2;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2MediaDiagServiceProxy$3;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2MediaDiagServiceProxy$4;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2MediaDiagServiceProxy$5;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2MediaDiagServiceProxy$6;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2MediaDiagServiceProxy$7;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2MediaDiagServiceProxy$8;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2MediaDiagServiceProxy$9;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2MediaDiagServiceReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class MMX2MediaDiagServiceProxy
implements MMX2MediaDiagService,
MMX2MediaDiagServiceC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.diagnosis.mmx2app.MMX2MediaDiagService");
    private Proxy proxy;

    public MMX2MediaDiagServiceProxy(int n, MMX2MediaDiagServiceReply mMX2MediaDiagServiceReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("a99c34a4-b437-42f3-89c0-ac0cee7d9eed", n, "90b1f04c-32af-51b8-b1a2-aedf7704b6ce", "asi.diagnosis.mmx2app.MMX2MediaDiagService");
        MMX2MediaDiagServiceReplyService mMX2MediaDiagServiceReplyService = new MMX2MediaDiagServiceReplyService(mMX2MediaDiagServiceReply);
        this.proxy = new Proxy(serviceInstanceID, mMX2MediaDiagServiceReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void responseErrorMedia(sClientResponseError sClientResponseError2) {
        MMX2MediaDiagServiceProxy$1 mMX2MediaDiagServiceProxy$1 = new MMX2MediaDiagServiceProxy$1(this, sClientResponseError2);
        this.proxy.remoteCallMethod((short)42, mMX2MediaDiagServiceProxy$1);
    }

    @Override
    public void responseSubsystemState(sSubsystemState sSubsystemState2) {
        MMX2MediaDiagServiceProxy$2 mMX2MediaDiagServiceProxy$2 = new MMX2MediaDiagServiceProxy$2(this, sSubsystemState2);
        this.proxy.remoteCallMethod((short)34, mMX2MediaDiagServiceProxy$2);
    }

    @Override
    public void responseMediaDBVersion(sMediaDBVersion sMediaDBVersion2) {
        MMX2MediaDiagServiceProxy$3 mMX2MediaDiagServiceProxy$3 = new MMX2MediaDiagServiceProxy$3(this, sMediaDBVersion2);
        this.proxy.remoteCallMethod((short)8, mMX2MediaDiagServiceProxy$3);
    }

    @Override
    public void responseActiveMediaSourceState(sActiveMediaSourceState sActiveMediaSourceState2) {
        MMX2MediaDiagServiceProxy$4 mMX2MediaDiagServiceProxy$4 = new MMX2MediaDiagServiceProxy$4(this, sActiveMediaSourceState2);
        this.proxy.remoteCallMethod((short)6, mMX2MediaDiagServiceProxy$4);
    }

    @Override
    public void responseMediaRegionCodes(sMediaRegionCodes sMediaRegionCodes2) {
        MMX2MediaDiagServiceProxy$5 mMX2MediaDiagServiceProxy$5 = new MMX2MediaDiagServiceProxy$5(this, sMediaRegionCodes2);
        this.proxy.remoteCallMethod((short)9, mMX2MediaDiagServiceProxy$5);
    }

    @Override
    public void responseMediaTypeOpticalDrive(sMediaTypeOpticalDrive sMediaTypeOpticalDrive2) {
        MMX2MediaDiagServiceProxy$6 mMX2MediaDiagServiceProxy$6 = new MMX2MediaDiagServiceProxy$6(this, sMediaTypeOpticalDrive2);
        this.proxy.remoteCallMethod((short)29, mMX2MediaDiagServiceProxy$6);
    }

    @Override
    public void responseUsbOvercurrent(sUsbOvercurrent sUsbOvercurrent2) {
        MMX2MediaDiagServiceProxy$7 mMX2MediaDiagServiceProxy$7 = new MMX2MediaDiagServiceProxy$7(this, sUsbOvercurrent2);
        this.proxy.remoteCallMethod((short)17, mMX2MediaDiagServiceProxy$7);
    }

    @Override
    public void responsePmlState(sPmlState sPmlState2) {
        MMX2MediaDiagServiceProxy$8 mMX2MediaDiagServiceProxy$8 = new MMX2MediaDiagServiceProxy$8(this, sPmlState2);
        this.proxy.remoteCallMethod((short)33, mMX2MediaDiagServiceProxy$8);
    }

    @Override
    public void responseSparePartNumberMediaDB(sSparePartNumber sSparePartNumber2) {
        MMX2MediaDiagServiceProxy$9 mMX2MediaDiagServiceProxy$9 = new MMX2MediaDiagServiceProxy$9(this, sSparePartNumber2);
        this.proxy.remoteCallMethod((short)36, mMX2MediaDiagServiceProxy$9);
    }

    @Override
    public void responseApplicationSoftwareVersionNumberMediaDB(sApplicationSoftwareVersionNumber sApplicationSoftwareVersionNumber2) {
        MMX2MediaDiagServiceProxy$10 mMX2MediaDiagServiceProxy$10 = new MMX2MediaDiagServiceProxy$10(this, sApplicationSoftwareVersionNumber2);
        this.proxy.remoteCallMethod((short)22, mMX2MediaDiagServiceProxy$10);
    }

    @Override
    public void responseSerialNumberMediaDB(sSerialNumber sSerialNumber2) {
        MMX2MediaDiagServiceProxy$11 mMX2MediaDiagServiceProxy$11 = new MMX2MediaDiagServiceProxy$11(this, sSerialNumber2);
        this.proxy.remoteCallMethod((short)25, mMX2MediaDiagServiceProxy$11);
    }

    @Override
    public void responseSystemNameMediaDB(sSystemName sSystemName2) {
        MMX2MediaDiagServiceProxy$12 mMX2MediaDiagServiceProxy$12 = new MMX2MediaDiagServiceProxy$12(this, sSystemName2);
        this.proxy.remoteCallMethod((short)26, mMX2MediaDiagServiceProxy$12);
    }

    @Override
    public void responseStatusUSBCommunication(long l, int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putUInt32(l);
            genericSerializable.putEnum(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)40, genericSerializable);
    }

    @Override
    public void responseUSBHubIdentification(long l, short[] sArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putUInt32(l);
            genericSerializable.putOptionalUInt8VarArray(sArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)41, genericSerializable);
    }

    @Override
    public void responseDTCPEncryptionState(long l, sDTCPState[] sDTCPStateArray) {
        MMX2MediaDiagServiceProxy$13 mMX2MediaDiagServiceProxy$13 = new MMX2MediaDiagServiceProxy$13(this, l, sDTCPStateArray);
        this.proxy.remoteCallMethod((short)50, mMX2MediaDiagServiceProxy$13);
    }

    @Override
    public void responseDTCPKeytypeMMX(long l, int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putUInt32(l);
            genericSerializable.putEnum(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)51, genericSerializable);
    }

    @Override
    public void responseDTCPSRMInfo(long l, short s, int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putUInt32(l);
            genericSerializable.putUInt8(s);
            genericSerializable.putUInt16(n);
            genericSerializable.putUInt16(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)52, genericSerializable);
    }
}


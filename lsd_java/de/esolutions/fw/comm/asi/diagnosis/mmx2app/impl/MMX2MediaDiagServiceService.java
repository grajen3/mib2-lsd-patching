/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sApplicationSoftwareVersionNumberSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sClientResponseErrorSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sSerialNumberSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sSparePartNumberSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sSubsystemStateSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sSystemNameSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sApplicationSoftwareVersionNumber;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSerialNumber;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSparePartNumber;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSubsystemState;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSystemName;
import de.esolutions.fw.comm.asi.diagnosis.media.impl.sActiveMediaSourceStateSerializer;
import de.esolutions.fw.comm.asi.diagnosis.media.impl.sDTCPStateSerializer;
import de.esolutions.fw.comm.asi.diagnosis.media.impl.sMediaDBVersionSerializer;
import de.esolutions.fw.comm.asi.diagnosis.media.impl.sMediaRegionCodesSerializer;
import de.esolutions.fw.comm.asi.diagnosis.media.impl.sMediaTypeOpticalDriveSerializer;
import de.esolutions.fw.comm.asi.diagnosis.media.impl.sPmlStateSerializer;
import de.esolutions.fw.comm.asi.diagnosis.media.impl.sUsbOvercurrentSerializer;
import de.esolutions.fw.comm.asi.diagnosis.media.sActiveMediaSourceState;
import de.esolutions.fw.comm.asi.diagnosis.media.sDTCPState;
import de.esolutions.fw.comm.asi.diagnosis.media.sMediaDBVersion;
import de.esolutions.fw.comm.asi.diagnosis.media.sMediaRegionCodes;
import de.esolutions.fw.comm.asi.diagnosis.media.sMediaTypeOpticalDrive;
import de.esolutions.fw.comm.asi.diagnosis.media.sPmlState;
import de.esolutions.fw.comm.asi.diagnosis.media.sUsbOvercurrent;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2MediaDiagServiceS;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2MediaDiagServiceReplyProxy;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class MMX2MediaDiagServiceService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.diagnosis.mmx2app.MMX2MediaDiagService");
    private MMX2MediaDiagServiceS p_MMX2MediaDiagService;

    public MMX2MediaDiagServiceService(int n, MMX2MediaDiagServiceS mMX2MediaDiagServiceS) {
        super(new ServiceInstanceID("a99c34a4-b437-42f3-89c0-ac0cee7d9eed", n, "90b1f04c-32af-51b8-b1a2-aedf7704b6ce", "asi.diagnosis.mmx2app.MMX2MediaDiagService"));
        this.p_MMX2MediaDiagService = mMX2MediaDiagServiceS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new MMX2MediaDiagServiceReplyProxy();
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 42: {
                    sClientResponseError sClientResponseError2 = sClientResponseErrorSerializer.getOptionalsClientResponseError(iDeserializer);
                    this.p_MMX2MediaDiagService.responseErrorMedia(sClientResponseError2, (MMX2MediaDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 34: {
                    sSubsystemState sSubsystemState2 = sSubsystemStateSerializer.getOptionalsSubsystemState(iDeserializer);
                    this.p_MMX2MediaDiagService.responseSubsystemState(sSubsystemState2, (MMX2MediaDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 8: {
                    sMediaDBVersion sMediaDBVersion2 = sMediaDBVersionSerializer.getOptionalsMediaDBVersion(iDeserializer);
                    this.p_MMX2MediaDiagService.responseMediaDBVersion(sMediaDBVersion2, (MMX2MediaDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 6: {
                    sActiveMediaSourceState sActiveMediaSourceState2 = sActiveMediaSourceStateSerializer.getOptionalsActiveMediaSourceState(iDeserializer);
                    this.p_MMX2MediaDiagService.responseActiveMediaSourceState(sActiveMediaSourceState2, (MMX2MediaDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 9: {
                    sMediaRegionCodes sMediaRegionCodes2 = sMediaRegionCodesSerializer.getOptionalsMediaRegionCodes(iDeserializer);
                    this.p_MMX2MediaDiagService.responseMediaRegionCodes(sMediaRegionCodes2, (MMX2MediaDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 29: {
                    sMediaTypeOpticalDrive sMediaTypeOpticalDrive2 = sMediaTypeOpticalDriveSerializer.getOptionalsMediaTypeOpticalDrive(iDeserializer);
                    this.p_MMX2MediaDiagService.responseMediaTypeOpticalDrive(sMediaTypeOpticalDrive2, (MMX2MediaDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 17: {
                    sUsbOvercurrent sUsbOvercurrent2 = sUsbOvercurrentSerializer.getOptionalsUsbOvercurrent(iDeserializer);
                    this.p_MMX2MediaDiagService.responseUsbOvercurrent(sUsbOvercurrent2, (MMX2MediaDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 33: {
                    sPmlState sPmlState2 = sPmlStateSerializer.getOptionalsPmlState(iDeserializer);
                    this.p_MMX2MediaDiagService.responsePmlState(sPmlState2, (MMX2MediaDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 36: {
                    sSparePartNumber sSparePartNumber2 = sSparePartNumberSerializer.getOptionalsSparePartNumber(iDeserializer);
                    this.p_MMX2MediaDiagService.responseSparePartNumberMediaDB(sSparePartNumber2, (MMX2MediaDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 22: {
                    sApplicationSoftwareVersionNumber sApplicationSoftwareVersionNumber2 = sApplicationSoftwareVersionNumberSerializer.getOptionalsApplicationSoftwareVersionNumber(iDeserializer);
                    this.p_MMX2MediaDiagService.responseApplicationSoftwareVersionNumberMediaDB(sApplicationSoftwareVersionNumber2, (MMX2MediaDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 25: {
                    sSerialNumber sSerialNumber2 = sSerialNumberSerializer.getOptionalsSerialNumber(iDeserializer);
                    this.p_MMX2MediaDiagService.responseSerialNumberMediaDB(sSerialNumber2, (MMX2MediaDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 26: {
                    sSystemName sSystemName2 = sSystemNameSerializer.getOptionalsSystemName(iDeserializer);
                    this.p_MMX2MediaDiagService.responseSystemNameMediaDB(sSystemName2, (MMX2MediaDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 40: {
                    long l = iDeserializer.getUInt32();
                    int n = iDeserializer.getEnum();
                    this.p_MMX2MediaDiagService.responseStatusUSBCommunication(l, n, (MMX2MediaDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 41: {
                    long l = iDeserializer.getUInt32();
                    short[] sArray = iDeserializer.getOptionalUInt8VarArray();
                    this.p_MMX2MediaDiagService.responseUSBHubIdentification(l, sArray, (MMX2MediaDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 50: {
                    long l = iDeserializer.getUInt32();
                    sDTCPState[] sDTCPStateArray = sDTCPStateSerializer.getOptionalsDTCPStateVarArray(iDeserializer);
                    this.p_MMX2MediaDiagService.responseDTCPEncryptionState(l, sDTCPStateArray, (MMX2MediaDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 51: {
                    long l = iDeserializer.getUInt32();
                    int n = iDeserializer.getEnum();
                    this.p_MMX2MediaDiagService.responseDTCPKeytypeMMX(l, n, (MMX2MediaDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 52: {
                    long l = iDeserializer.getUInt32();
                    short s2 = iDeserializer.getUInt8();
                    int n = iDeserializer.getUInt16();
                    int n2 = iDeserializer.getUInt16();
                    this.p_MMX2MediaDiagService.responseDTCPSRMInfo(l, s2, n, n2, (MMX2MediaDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                default: {
                    throw new MethodException(new StringBuffer().append("Invalid Method Id ").append(s).toString());
                }
            }
        }
        catch (SerializerException serializerException) {
            throw new MethodException(new StringBuffer().append("Deserialization failed: method=").append(s).append(", error=").append(serializerException.getMessage()).toString());
        }
    }
}


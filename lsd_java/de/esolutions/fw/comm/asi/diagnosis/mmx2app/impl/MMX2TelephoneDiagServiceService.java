/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sClientResponseErrorSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sRoutineResponseSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sRoutineResponse;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2TelephoneDiagServiceS;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2TelephoneDiagServiceReplyProxy;
import de.esolutions.fw.comm.asi.diagnosis.telephone.impl.sConnectedBtHandsetSerializer;
import de.esolutions.fw.comm.asi.diagnosis.telephone.impl.sNadIMEISerializer;
import de.esolutions.fw.comm.asi.diagnosis.telephone.impl.sNumberHandsetsHUCsSerializer;
import de.esolutions.fw.comm.asi.diagnosis.telephone.impl.sSimStateSerializer;
import de.esolutions.fw.comm.asi.diagnosis.telephone.impl.sTelephoneAntennaStateSerializer;
import de.esolutions.fw.comm.asi.diagnosis.telephone.impl.sTelephoneNetworkStateSerializer;
import de.esolutions.fw.comm.asi.diagnosis.telephone.impl.sTelephoneTemperatureSerializer;
import de.esolutions.fw.comm.asi.diagnosis.telephone.sConnectedBtHandset;
import de.esolutions.fw.comm.asi.diagnosis.telephone.sNadIMEI;
import de.esolutions.fw.comm.asi.diagnosis.telephone.sNumberHandsetsHUCs;
import de.esolutions.fw.comm.asi.diagnosis.telephone.sSimState;
import de.esolutions.fw.comm.asi.diagnosis.telephone.sTelephoneAntennaState;
import de.esolutions.fw.comm.asi.diagnosis.telephone.sTelephoneNetworkState;
import de.esolutions.fw.comm.asi.diagnosis.telephone.sTelephoneTemperature;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class MMX2TelephoneDiagServiceService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.diagnosis.mmx2app.MMX2TelephoneDiagService");
    private MMX2TelephoneDiagServiceS p_MMX2TelephoneDiagService;

    public MMX2TelephoneDiagServiceService(int n, MMX2TelephoneDiagServiceS mMX2TelephoneDiagServiceS) {
        super(new ServiceInstanceID("1875f7e5-0255-4283-8265-93dd91cd564d", n, "18c56909-7a93-5017-a939-9202333ba69e", "asi.diagnosis.mmx2app.MMX2TelephoneDiagService"));
        this.p_MMX2TelephoneDiagService = mMX2TelephoneDiagServiceS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new MMX2TelephoneDiagServiceReplyProxy();
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 43: {
                    sClientResponseError sClientResponseError2 = sClientResponseErrorSerializer.getOptionalsClientResponseError(iDeserializer);
                    this.p_MMX2TelephoneDiagService.responseErrorTelephone(sClientResponseError2, (MMX2TelephoneDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 42: {
                    sSimState sSimState2 = sSimStateSerializer.getOptionalsSimState(iDeserializer);
                    this.p_MMX2TelephoneDiagService.responseSimState(sSimState2, (MMX2TelephoneDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 10: {
                    sNadIMEI sNadIMEI2 = sNadIMEISerializer.getOptionalsNadIMEI(iDeserializer);
                    this.p_MMX2TelephoneDiagService.responseNadIMEI(sNadIMEI2, (MMX2TelephoneDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 31: {
                    sTelephoneAntennaState sTelephoneAntennaState2 = sTelephoneAntennaStateSerializer.getOptionalsTelephoneAntennaState(iDeserializer);
                    this.p_MMX2TelephoneDiagService.responseTelephoneAntennaState(sTelephoneAntennaState2, (MMX2TelephoneDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 7: {
                    sConnectedBtHandset sConnectedBtHandset2 = sConnectedBtHandsetSerializer.getOptionalsConnectedBtHandset(iDeserializer);
                    this.p_MMX2TelephoneDiagService.responseConnectedBtHandset(sConnectedBtHandset2, (MMX2TelephoneDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 11: {
                    sNumberHandsetsHUCs sNumberHandsetsHUCs2 = sNumberHandsetsHUCsSerializer.getOptionalsNumberHandsetsHUCs(iDeserializer);
                    this.p_MMX2TelephoneDiagService.responseNumberHandsetsHUCs(sNumberHandsetsHUCs2, (MMX2TelephoneDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 29: {
                    sTelephoneNetworkState sTelephoneNetworkState2 = sTelephoneNetworkStateSerializer.getOptionalsTelephoneNetworkState(iDeserializer);
                    this.p_MMX2TelephoneDiagService.responseTelephoneNetworkState(sTelephoneNetworkState2, (MMX2TelephoneDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 27: {
                    sTelephoneTemperature sTelephoneTemperature2 = sTelephoneTemperatureSerializer.getOptionalsTelephoneTemperature(iDeserializer);
                    this.p_MMX2TelephoneDiagService.responseTelephoneTemperature(sTelephoneTemperature2, (MMX2TelephoneDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 25: {
                    sRoutineResponse sRoutineResponse2 = sRoutineResponseSerializer.getOptionalsRoutineResponse(iDeserializer);
                    this.p_MMX2TelephoneDiagService.responseDeleteMemory(sRoutineResponse2, (MMX2TelephoneDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 38: {
                    long l = iDeserializer.getUInt32();
                    String string = iDeserializer.getOptionalString();
                    this.p_MMX2TelephoneDiagService.responseNetworkName(l, string, (MMX2TelephoneDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 39: {
                    long l = iDeserializer.getUInt32();
                    int n = iDeserializer.getEnum();
                    this.p_MMX2TelephoneDiagService.responseNetworkType(l, n, (MMX2TelephoneDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 37: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2TelephoneDiagService.responseDialNumber(l, (MMX2TelephoneDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 36: {
                    long l = iDeserializer.getUInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_MMX2TelephoneDiagService.responseCallStatus(l, bl, (MMX2TelephoneDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 41: {
                    long l = iDeserializer.getUInt32();
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_MMX2TelephoneDiagService.responseInternalSimIdentification(l, string, string2, (MMX2TelephoneDiagServiceReplyProxy)iProxyFrontend);
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


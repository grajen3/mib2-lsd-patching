/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sApplicationSoftwareVersionNumberSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sClientResponseErrorSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sHardwareNumberSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sHardwareVersionNumberSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sRoutineResponseSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sSerialNumberSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sSparePartNumberSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sSubsystemStateSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sSystemNameSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sApplicationSoftwareVersionNumber;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sHardwareNumber;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sHardwareVersionNumber;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sRoutineResponse;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSerialNumber;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSparePartNumber;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSubsystemState;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSystemName;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2NavigationDiagServiceS;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationDiagServiceReplyProxy;
import de.esolutions.fw.comm.asi.diagnosis.navigation.impl.sActiveNavDBSerializer;
import de.esolutions.fw.comm.asi.diagnosis.navigation.impl.sGPSNoSatelliteSerializer;
import de.esolutions.fw.comm.asi.diagnosis.navigation.impl.sGPSOffroadSerializer;
import de.esolutions.fw.comm.asi.diagnosis.navigation.impl.sNavCalibrationStateSerializer;
import de.esolutions.fw.comm.asi.diagnosis.navigation.impl.sNavCorrectedDirectionSerializer;
import de.esolutions.fw.comm.asi.diagnosis.navigation.impl.sNavCorrectedPositionSerializer;
import de.esolutions.fw.comm.asi.diagnosis.navigation.impl.sNavCountryRegionVersionSerializer;
import de.esolutions.fw.comm.asi.diagnosis.navigation.impl.sVersionsNavDBSerializer;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sActiveNavDB;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sGPSNoSatellite;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sGPSOffroad;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sNavCalibrationState;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sNavCorrectedDirection;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sNavCorrectedPosition;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sNavCountryRegionVersion;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sVersionsNavDB;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class MMX2NavigationDiagServiceService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.diagnosis.mmx2app.MMX2NavigationDiagService");
    private MMX2NavigationDiagServiceS p_MMX2NavigationDiagService;

    public MMX2NavigationDiagServiceService(int n, MMX2NavigationDiagServiceS mMX2NavigationDiagServiceS) {
        super(new ServiceInstanceID("3a0f97f7-4596-4e19-9184-8b0609943a55", n, "add52511-ec64-5161-8bcb-0540c6ab2e22", "asi.diagnosis.mmx2app.MMX2NavigationDiagService"));
        this.p_MMX2NavigationDiagService = mMX2NavigationDiagServiceS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new MMX2NavigationDiagServiceReplyProxy();
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
                    this.p_MMX2NavigationDiagService.responseErrorNavigation(sClientResponseError2, (MMX2NavigationDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 38: {
                    sSubsystemState sSubsystemState2 = sSubsystemStateSerializer.getOptionalsSubsystemState(iDeserializer);
                    this.p_MMX2NavigationDiagService.responseSubsystemState(sSubsystemState2, (MMX2NavigationDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 16: {
                    sVersionsNavDB sVersionsNavDB2 = sVersionsNavDBSerializer.getOptionalsVersionsNavDB(iDeserializer);
                    this.p_MMX2NavigationDiagService.responseVersionsNavDB(sVersionsNavDB2, (MMX2NavigationDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 8: {
                    sActiveNavDB sActiveNavDB2 = sActiveNavDBSerializer.getOptionalsActiveNavDB(iDeserializer);
                    this.p_MMX2NavigationDiagService.responseActiveNavDB(sActiveNavDB2, (MMX2NavigationDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 10: {
                    sGPSNoSatellite sGPSNoSatellite2 = sGPSNoSatelliteSerializer.getOptionalsGPSNoSatellite(iDeserializer);
                    this.p_MMX2NavigationDiagService.responseGPSNoSatellite(sGPSNoSatellite2, (MMX2NavigationDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 11: {
                    sGPSOffroad sGPSOffroad2 = sGPSOffroadSerializer.getOptionalsGPSOffroad(iDeserializer);
                    this.p_MMX2NavigationDiagService.responseGPSOffroad(sGPSOffroad2, (MMX2NavigationDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 12: {
                    sNavCalibrationState sNavCalibrationState2 = sNavCalibrationStateSerializer.getOptionalsNavCalibrationState(iDeserializer);
                    this.p_MMX2NavigationDiagService.responseNavCalibrationState(sNavCalibrationState2, (MMX2NavigationDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 20: {
                    sNavCorrectedPosition sNavCorrectedPosition2 = sNavCorrectedPositionSerializer.getOptionalsNavCorrectedPosition(iDeserializer);
                    this.p_MMX2NavigationDiagService.responseNavCorrectedPosition(sNavCorrectedPosition2, (MMX2NavigationDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 13: {
                    sNavCorrectedDirection sNavCorrectedDirection2 = sNavCorrectedDirectionSerializer.getOptionalsNavCorrectedDirection(iDeserializer);
                    this.p_MMX2NavigationDiagService.responseNavCorrectedDirection(sNavCorrectedDirection2, (MMX2NavigationDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 32: {
                    sRoutineResponse sRoutineResponse2 = sRoutineResponseSerializer.getOptionalsRoutineResponse(iDeserializer);
                    this.p_MMX2NavigationDiagService.responseResetCalibration(sRoutineResponse2, (MMX2NavigationDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 34: {
                    sSparePartNumber sSparePartNumber2 = sSparePartNumberSerializer.getOptionalsSparePartNumber(iDeserializer);
                    this.p_MMX2NavigationDiagService.responseSparePartNumberNavDB(sSparePartNumber2, (MMX2NavigationDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 28: {
                    sApplicationSoftwareVersionNumber sApplicationSoftwareVersionNumber2 = sApplicationSoftwareVersionNumberSerializer.getOptionalsApplicationSoftwareVersionNumber(iDeserializer);
                    this.p_MMX2NavigationDiagService.responseApplicationSoftwareVersionNumberNavDB(sApplicationSoftwareVersionNumber2, (MMX2NavigationDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 30: {
                    sHardwareNumber sHardwareNumber2 = sHardwareNumberSerializer.getOptionalsHardwareNumber(iDeserializer);
                    this.p_MMX2NavigationDiagService.responseHardwareNumberNavDB(sHardwareNumber2, (MMX2NavigationDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 31: {
                    sHardwareVersionNumber sHardwareVersionNumber2 = sHardwareVersionNumberSerializer.getOptionalsHardwareVersionNumber(iDeserializer);
                    this.p_MMX2NavigationDiagService.responseHardwareVersionNumberNavDB(sHardwareVersionNumber2, (MMX2NavigationDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 33: {
                    sSerialNumber sSerialNumber2 = sSerialNumberSerializer.getOptionalsSerialNumber(iDeserializer);
                    this.p_MMX2NavigationDiagService.responseSerialNumberNavDB(sSerialNumber2, (MMX2NavigationDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 35: {
                    sSystemName sSystemName2 = sSystemNameSerializer.getOptionalsSystemName(iDeserializer);
                    this.p_MMX2NavigationDiagService.responseSystemNameNavDB(sSystemName2, (MMX2NavigationDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 41: {
                    sNavCountryRegionVersion sNavCountryRegionVersion2 = sNavCountryRegionVersionSerializer.getOptionalsNavCountryRegionVersion(iDeserializer);
                    this.p_MMX2NavigationDiagService.responseCountryRegionVersion(sNavCountryRegionVersion2, (MMX2NavigationDiagServiceReplyProxy)iProxyFrontend);
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


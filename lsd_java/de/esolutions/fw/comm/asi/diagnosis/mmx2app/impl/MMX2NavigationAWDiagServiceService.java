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
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sSystemNameSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sApplicationSoftwareVersionNumber;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sHardwareNumber;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sHardwareVersionNumber;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sRoutineResponse;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSerialNumber;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSparePartNumber;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSystemName;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2NavigationAWDiagServiceS;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceReplyProxy;
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
import de.esolutions.fw.comm.asi.diagnosis.navigationAW.impl.sAntennaStateDSRCSerializer;
import de.esolutions.fw.comm.asi.diagnosis.navigationAW.impl.sAntennaStateVICSSerializer;
import de.esolutions.fw.comm.asi.diagnosis.navigationAW.impl.sInfraredBeaconStateVICSSerializer;
import de.esolutions.fw.comm.asi.diagnosis.navigationAW.impl.sRadioBeaconStateVICSSerializer;
import de.esolutions.fw.comm.asi.diagnosis.navigationAW.impl.sSubsystemStatesSerializer;
import de.esolutions.fw.comm.asi.diagnosis.navigationAW.impl.sUnitStateDSRCSerializer;
import de.esolutions.fw.comm.asi.diagnosis.navigationAW.sAntennaStateDSRC;
import de.esolutions.fw.comm.asi.diagnosis.navigationAW.sAntennaStateVICS;
import de.esolutions.fw.comm.asi.diagnosis.navigationAW.sInfraredBeaconStateVICS;
import de.esolutions.fw.comm.asi.diagnosis.navigationAW.sRadioBeaconStateVICS;
import de.esolutions.fw.comm.asi.diagnosis.navigationAW.sSubsystemStates;
import de.esolutions.fw.comm.asi.diagnosis.navigationAW.sUnitStateDSRC;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class MMX2NavigationAWDiagServiceService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.diagnosis.mmx2app.MMX2NavigationAWDiagService");
    private MMX2NavigationAWDiagServiceS p_MMX2NavigationAWDiagService;

    public MMX2NavigationAWDiagServiceService(int n, MMX2NavigationAWDiagServiceS mMX2NavigationAWDiagServiceS) {
        super(new ServiceInstanceID("55ad22a1-cc94-4954-a4b5-26b3aa66a601", n, "0465a088-2c21-52dd-9089-0d4a3c078909", "asi.diagnosis.mmx2app.MMX2NavigationAWDiagService"));
        this.p_MMX2NavigationAWDiagService = mMX2NavigationAWDiagServiceS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new MMX2NavigationAWDiagServiceReplyProxy();
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 47: {
                    sClientResponseError sClientResponseError2 = sClientResponseErrorSerializer.getOptionalsClientResponseError(iDeserializer);
                    this.p_MMX2NavigationAWDiagService.responseErrorNavigation(sClientResponseError2, (MMX2NavigationAWDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 37: {
                    sSubsystemStates sSubsystemStates2 = sSubsystemStatesSerializer.getOptionalsSubsystemStates(iDeserializer);
                    this.p_MMX2NavigationAWDiagService.responseSubsystemStates(sSubsystemStates2, (MMX2NavigationAWDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 40: {
                    sVersionsNavDB sVersionsNavDB2 = sVersionsNavDBSerializer.getOptionalsVersionsNavDB(iDeserializer);
                    this.p_MMX2NavigationAWDiagService.responseVersionsNavDB(sVersionsNavDB2, (MMX2NavigationAWDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 20: {
                    sActiveNavDB sActiveNavDB2 = sActiveNavDBSerializer.getOptionalsActiveNavDB(iDeserializer);
                    this.p_MMX2NavigationAWDiagService.responseActiveNavDB(sActiveNavDB2, (MMX2NavigationAWDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 25: {
                    sGPSNoSatellite sGPSNoSatellite2 = sGPSNoSatelliteSerializer.getOptionalsGPSNoSatellite(iDeserializer);
                    this.p_MMX2NavigationAWDiagService.responseGPSNoSatellite(sGPSNoSatellite2, (MMX2NavigationAWDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 26: {
                    sGPSOffroad sGPSOffroad2 = sGPSOffroadSerializer.getOptionalsGPSOffroad(iDeserializer);
                    this.p_MMX2NavigationAWDiagService.responseGPSOffroad(sGPSOffroad2, (MMX2NavigationAWDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 30: {
                    sNavCalibrationState sNavCalibrationState2 = sNavCalibrationStateSerializer.getOptionalsNavCalibrationState(iDeserializer);
                    this.p_MMX2NavigationAWDiagService.responseNavCalibrationState(sNavCalibrationState2, (MMX2NavigationAWDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 32: {
                    sNavCorrectedPosition sNavCorrectedPosition2 = sNavCorrectedPositionSerializer.getOptionalsNavCorrectedPosition(iDeserializer);
                    this.p_MMX2NavigationAWDiagService.responseNavCorrectedPosition(sNavCorrectedPosition2, (MMX2NavigationAWDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 31: {
                    sNavCorrectedDirection sNavCorrectedDirection2 = sNavCorrectedDirectionSerializer.getOptionalsNavCorrectedDirection(iDeserializer);
                    this.p_MMX2NavigationAWDiagService.responseNavCorrectedDirection(sNavCorrectedDirection2, (MMX2NavigationAWDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 41: {
                    sUnitStateDSRC sUnitStateDSRC2 = sUnitStateDSRCSerializer.getOptionalsUnitStateDSRC(iDeserializer);
                    this.p_MMX2NavigationAWDiagService.responseUnitStateDSRC(sUnitStateDSRC2, (MMX2NavigationAWDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 21: {
                    sAntennaStateDSRC sAntennaStateDSRC2 = sAntennaStateDSRCSerializer.getOptionalsAntennaStateDSRC(iDeserializer);
                    this.p_MMX2NavigationAWDiagService.responseAntennaStateDSRC(sAntennaStateDSRC2, (MMX2NavigationAWDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 22: {
                    sAntennaStateVICS sAntennaStateVICS2 = sAntennaStateVICSSerializer.getOptionalsAntennaStateVICS(iDeserializer);
                    this.p_MMX2NavigationAWDiagService.responseAntennaStateVICS(sAntennaStateVICS2, (MMX2NavigationAWDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 33: {
                    sRadioBeaconStateVICS sRadioBeaconStateVICS2 = sRadioBeaconStateVICSSerializer.getOptionalsRadioBeaconStateVICS(iDeserializer);
                    this.p_MMX2NavigationAWDiagService.responseRadioBeaconStateVICS(sRadioBeaconStateVICS2, (MMX2NavigationAWDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 29: {
                    sInfraredBeaconStateVICS sInfraredBeaconStateVICS2 = sInfraredBeaconStateVICSSerializer.getOptionalsInfraredBeaconStateVICS(iDeserializer);
                    this.p_MMX2NavigationAWDiagService.responseInfraredBeaconStateVICS(sInfraredBeaconStateVICS2, (MMX2NavigationAWDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 34: {
                    sRoutineResponse sRoutineResponse2 = sRoutineResponseSerializer.getOptionalsRoutineResponse(iDeserializer);
                    this.p_MMX2NavigationAWDiagService.responseResetCalibration(sRoutineResponse2, (MMX2NavigationAWDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 36: {
                    sSparePartNumber sSparePartNumber2 = sSparePartNumberSerializer.getOptionalsSparePartNumber(iDeserializer);
                    this.p_MMX2NavigationAWDiagService.responseSparePartNumber(sSparePartNumber2, (MMX2NavigationAWDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 23: {
                    sApplicationSoftwareVersionNumber sApplicationSoftwareVersionNumber2 = sApplicationSoftwareVersionNumberSerializer.getOptionalsApplicationSoftwareVersionNumber(iDeserializer);
                    this.p_MMX2NavigationAWDiagService.responseApplicationSoftwareVersionNumber(sApplicationSoftwareVersionNumber2, (MMX2NavigationAWDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 27: {
                    sHardwareNumber sHardwareNumber2 = sHardwareNumberSerializer.getOptionalsHardwareNumber(iDeserializer);
                    this.p_MMX2NavigationAWDiagService.responseHardwareNumber(sHardwareNumber2, (MMX2NavigationAWDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 28: {
                    sHardwareVersionNumber sHardwareVersionNumber2 = sHardwareVersionNumberSerializer.getOptionalsHardwareVersionNumber(iDeserializer);
                    this.p_MMX2NavigationAWDiagService.responseHardwareVersionNumber(sHardwareVersionNumber2, (MMX2NavigationAWDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 35: {
                    sSerialNumber sSerialNumber2 = sSerialNumberSerializer.getOptionalsSerialNumber(iDeserializer);
                    this.p_MMX2NavigationAWDiagService.responseSerialNumber(sSerialNumber2, (MMX2NavigationAWDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 38: {
                    sSystemName sSystemName2 = sSystemNameSerializer.getOptionalsSystemName(iDeserializer);
                    this.p_MMX2NavigationAWDiagService.responseSystemName(sSystemName2, (MMX2NavigationAWDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 46: {
                    sNavCountryRegionVersion sNavCountryRegionVersion2 = sNavCountryRegionVersionSerializer.getOptionalsNavCountryRegionVersion(iDeserializer);
                    this.p_MMX2NavigationAWDiagService.responseCountryRegionVersion(sNavCountryRegionVersion2, (MMX2NavigationAWDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 43: {
                    sRoutineResponse sRoutineResponse3 = sRoutineResponseSerializer.getOptionalsRoutineResponse(iDeserializer);
                    this.p_MMX2NavigationAWDiagService.responseDeleteMemory(sRoutineResponse3, (MMX2NavigationAWDiagServiceReplyProxy)iProxyFrontend);
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


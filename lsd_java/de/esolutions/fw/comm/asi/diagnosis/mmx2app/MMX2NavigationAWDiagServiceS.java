/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sApplicationSoftwareVersionNumber;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sHardwareNumber;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sHardwareVersionNumber;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sRoutineResponse;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSerialNumber;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSparePartNumber;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSystemName;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2NavigationAWDiagServiceReply;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sActiveNavDB;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sGPSNoSatellite;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sGPSOffroad;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sNavCalibrationState;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sNavCorrectedDirection;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sNavCorrectedPosition;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sNavCountryRegionVersion;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sVersionsNavDB;
import de.esolutions.fw.comm.asi.diagnosis.navigationAW.sAntennaStateDSRC;
import de.esolutions.fw.comm.asi.diagnosis.navigationAW.sAntennaStateVICS;
import de.esolutions.fw.comm.asi.diagnosis.navigationAW.sInfraredBeaconStateVICS;
import de.esolutions.fw.comm.asi.diagnosis.navigationAW.sRadioBeaconStateVICS;
import de.esolutions.fw.comm.asi.diagnosis.navigationAW.sSubsystemStates;
import de.esolutions.fw.comm.asi.diagnosis.navigationAW.sUnitStateDSRC;

public interface MMX2NavigationAWDiagServiceS {
    default public void responseErrorNavigation(sClientResponseError sClientResponseError2, MMX2NavigationAWDiagServiceReply mMX2NavigationAWDiagServiceReply) {
    }

    default public void responseSubsystemStates(sSubsystemStates sSubsystemStates2, MMX2NavigationAWDiagServiceReply mMX2NavigationAWDiagServiceReply) {
    }

    default public void responseVersionsNavDB(sVersionsNavDB sVersionsNavDB2, MMX2NavigationAWDiagServiceReply mMX2NavigationAWDiagServiceReply) {
    }

    default public void responseActiveNavDB(sActiveNavDB sActiveNavDB2, MMX2NavigationAWDiagServiceReply mMX2NavigationAWDiagServiceReply) {
    }

    default public void responseGPSNoSatellite(sGPSNoSatellite sGPSNoSatellite2, MMX2NavigationAWDiagServiceReply mMX2NavigationAWDiagServiceReply) {
    }

    default public void responseGPSOffroad(sGPSOffroad sGPSOffroad2, MMX2NavigationAWDiagServiceReply mMX2NavigationAWDiagServiceReply) {
    }

    default public void responseNavCalibrationState(sNavCalibrationState sNavCalibrationState2, MMX2NavigationAWDiagServiceReply mMX2NavigationAWDiagServiceReply) {
    }

    default public void responseNavCorrectedPosition(sNavCorrectedPosition sNavCorrectedPosition2, MMX2NavigationAWDiagServiceReply mMX2NavigationAWDiagServiceReply) {
    }

    default public void responseNavCorrectedDirection(sNavCorrectedDirection sNavCorrectedDirection2, MMX2NavigationAWDiagServiceReply mMX2NavigationAWDiagServiceReply) {
    }

    default public void responseUnitStateDSRC(sUnitStateDSRC sUnitStateDSRC2, MMX2NavigationAWDiagServiceReply mMX2NavigationAWDiagServiceReply) {
    }

    default public void responseAntennaStateDSRC(sAntennaStateDSRC sAntennaStateDSRC2, MMX2NavigationAWDiagServiceReply mMX2NavigationAWDiagServiceReply) {
    }

    default public void responseAntennaStateVICS(sAntennaStateVICS sAntennaStateVICS2, MMX2NavigationAWDiagServiceReply mMX2NavigationAWDiagServiceReply) {
    }

    default public void responseRadioBeaconStateVICS(sRadioBeaconStateVICS sRadioBeaconStateVICS2, MMX2NavigationAWDiagServiceReply mMX2NavigationAWDiagServiceReply) {
    }

    default public void responseInfraredBeaconStateVICS(sInfraredBeaconStateVICS sInfraredBeaconStateVICS2, MMX2NavigationAWDiagServiceReply mMX2NavigationAWDiagServiceReply) {
    }

    default public void responseResetCalibration(sRoutineResponse sRoutineResponse2, MMX2NavigationAWDiagServiceReply mMX2NavigationAWDiagServiceReply) {
    }

    default public void responseSparePartNumber(sSparePartNumber sSparePartNumber2, MMX2NavigationAWDiagServiceReply mMX2NavigationAWDiagServiceReply) {
    }

    default public void responseApplicationSoftwareVersionNumber(sApplicationSoftwareVersionNumber sApplicationSoftwareVersionNumber2, MMX2NavigationAWDiagServiceReply mMX2NavigationAWDiagServiceReply) {
    }

    default public void responseHardwareNumber(sHardwareNumber sHardwareNumber2, MMX2NavigationAWDiagServiceReply mMX2NavigationAWDiagServiceReply) {
    }

    default public void responseHardwareVersionNumber(sHardwareVersionNumber sHardwareVersionNumber2, MMX2NavigationAWDiagServiceReply mMX2NavigationAWDiagServiceReply) {
    }

    default public void responseSerialNumber(sSerialNumber sSerialNumber2, MMX2NavigationAWDiagServiceReply mMX2NavigationAWDiagServiceReply) {
    }

    default public void responseSystemName(sSystemName sSystemName2, MMX2NavigationAWDiagServiceReply mMX2NavigationAWDiagServiceReply) {
    }

    default public void responseCountryRegionVersion(sNavCountryRegionVersion sNavCountryRegionVersion2, MMX2NavigationAWDiagServiceReply mMX2NavigationAWDiagServiceReply) {
    }

    default public void responseDeleteMemory(sRoutineResponse sRoutineResponse2, MMX2NavigationAWDiagServiceReply mMX2NavigationAWDiagServiceReply) {
    }
}


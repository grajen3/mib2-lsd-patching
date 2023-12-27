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

public interface MMX2NavigationAWDiagServiceC {
    default public void responseErrorNavigation(sClientResponseError sClientResponseError2) {
    }

    default public void responseSubsystemStates(sSubsystemStates sSubsystemStates2) {
    }

    default public void responseVersionsNavDB(sVersionsNavDB sVersionsNavDB2) {
    }

    default public void responseActiveNavDB(sActiveNavDB sActiveNavDB2) {
    }

    default public void responseGPSNoSatellite(sGPSNoSatellite sGPSNoSatellite2) {
    }

    default public void responseGPSOffroad(sGPSOffroad sGPSOffroad2) {
    }

    default public void responseNavCalibrationState(sNavCalibrationState sNavCalibrationState2) {
    }

    default public void responseNavCorrectedPosition(sNavCorrectedPosition sNavCorrectedPosition2) {
    }

    default public void responseNavCorrectedDirection(sNavCorrectedDirection sNavCorrectedDirection2) {
    }

    default public void responseUnitStateDSRC(sUnitStateDSRC sUnitStateDSRC2) {
    }

    default public void responseAntennaStateDSRC(sAntennaStateDSRC sAntennaStateDSRC2) {
    }

    default public void responseAntennaStateVICS(sAntennaStateVICS sAntennaStateVICS2) {
    }

    default public void responseRadioBeaconStateVICS(sRadioBeaconStateVICS sRadioBeaconStateVICS2) {
    }

    default public void responseInfraredBeaconStateVICS(sInfraredBeaconStateVICS sInfraredBeaconStateVICS2) {
    }

    default public void responseResetCalibration(sRoutineResponse sRoutineResponse2) {
    }

    default public void responseSparePartNumber(sSparePartNumber sSparePartNumber2) {
    }

    default public void responseApplicationSoftwareVersionNumber(sApplicationSoftwareVersionNumber sApplicationSoftwareVersionNumber2) {
    }

    default public void responseHardwareNumber(sHardwareNumber sHardwareNumber2) {
    }

    default public void responseHardwareVersionNumber(sHardwareVersionNumber sHardwareVersionNumber2) {
    }

    default public void responseSerialNumber(sSerialNumber sSerialNumber2) {
    }

    default public void responseSystemName(sSystemName sSystemName2) {
    }

    default public void responseCountryRegionVersion(sNavCountryRegionVersion sNavCountryRegionVersion2) {
    }

    default public void responseDeleteMemory(sRoutineResponse sRoutineResponse2) {
    }
}


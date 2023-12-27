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
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSubsystemState;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSystemName;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2NavigationDiagServiceReply;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sActiveNavDB;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sGPSNoSatellite;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sGPSOffroad;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sNavCalibrationState;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sNavCorrectedDirection;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sNavCorrectedPosition;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sNavCountryRegionVersion;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sVersionsNavDB;

public interface MMX2NavigationDiagServiceS {
    default public void responseErrorNavigation(sClientResponseError sClientResponseError2, MMX2NavigationDiagServiceReply mMX2NavigationDiagServiceReply) {
    }

    default public void responseSubsystemState(sSubsystemState sSubsystemState2, MMX2NavigationDiagServiceReply mMX2NavigationDiagServiceReply) {
    }

    default public void responseVersionsNavDB(sVersionsNavDB sVersionsNavDB2, MMX2NavigationDiagServiceReply mMX2NavigationDiagServiceReply) {
    }

    default public void responseActiveNavDB(sActiveNavDB sActiveNavDB2, MMX2NavigationDiagServiceReply mMX2NavigationDiagServiceReply) {
    }

    default public void responseGPSNoSatellite(sGPSNoSatellite sGPSNoSatellite2, MMX2NavigationDiagServiceReply mMX2NavigationDiagServiceReply) {
    }

    default public void responseGPSOffroad(sGPSOffroad sGPSOffroad2, MMX2NavigationDiagServiceReply mMX2NavigationDiagServiceReply) {
    }

    default public void responseNavCalibrationState(sNavCalibrationState sNavCalibrationState2, MMX2NavigationDiagServiceReply mMX2NavigationDiagServiceReply) {
    }

    default public void responseNavCorrectedPosition(sNavCorrectedPosition sNavCorrectedPosition2, MMX2NavigationDiagServiceReply mMX2NavigationDiagServiceReply) {
    }

    default public void responseNavCorrectedDirection(sNavCorrectedDirection sNavCorrectedDirection2, MMX2NavigationDiagServiceReply mMX2NavigationDiagServiceReply) {
    }

    default public void responseResetCalibration(sRoutineResponse sRoutineResponse2, MMX2NavigationDiagServiceReply mMX2NavigationDiagServiceReply) {
    }

    default public void responseSparePartNumberNavDB(sSparePartNumber sSparePartNumber2, MMX2NavigationDiagServiceReply mMX2NavigationDiagServiceReply) {
    }

    default public void responseApplicationSoftwareVersionNumberNavDB(sApplicationSoftwareVersionNumber sApplicationSoftwareVersionNumber2, MMX2NavigationDiagServiceReply mMX2NavigationDiagServiceReply) {
    }

    default public void responseHardwareNumberNavDB(sHardwareNumber sHardwareNumber2, MMX2NavigationDiagServiceReply mMX2NavigationDiagServiceReply) {
    }

    default public void responseHardwareVersionNumberNavDB(sHardwareVersionNumber sHardwareVersionNumber2, MMX2NavigationDiagServiceReply mMX2NavigationDiagServiceReply) {
    }

    default public void responseSerialNumberNavDB(sSerialNumber sSerialNumber2, MMX2NavigationDiagServiceReply mMX2NavigationDiagServiceReply) {
    }

    default public void responseSystemNameNavDB(sSystemName sSystemName2, MMX2NavigationDiagServiceReply mMX2NavigationDiagServiceReply) {
    }

    default public void responseCountryRegionVersion(sNavCountryRegionVersion sNavCountryRegionVersion2, MMX2NavigationDiagServiceReply mMX2NavigationDiagServiceReply) {
    }
}


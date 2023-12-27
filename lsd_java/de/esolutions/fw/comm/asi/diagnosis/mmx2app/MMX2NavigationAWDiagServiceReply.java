/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app;

public interface MMX2NavigationAWDiagServiceReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void requestSubsystemStates(long l) {
    }

    default public void requestVersionsNavDB(long l) {
    }

    default public void requestActiveNavDB(long l) {
    }

    default public void requestGPSNoSatellite(long l) {
    }

    default public void requestGPSOffroad(long l) {
    }

    default public void requestNavCalibrationState(long l) {
    }

    default public void requestNavCorrectedPosition(long l) {
    }

    default public void requestNavCorrectedDirection(long l) {
    }

    default public void requestUnitStateDSRC(long l) {
    }

    default public void requestAntennaStateDSRC(long l) {
    }

    default public void requestAntennaStateVICS(long l) {
    }

    default public void requestRadioBeaconStateVICS(long l) {
    }

    default public void requestInfraredBeaconStateVICS(long l) {
    }

    default public void requestResetCalibration(long l, int n) {
    }

    default public void requestSparePartNumber(long l, int n) {
    }

    default public void requestApplicationSoftwareVersionNumber(long l, int n) {
    }

    default public void requestHardwareNumber(long l, int n) {
    }

    default public void requestHardwareVersionNumber(long l, int n) {
    }

    default public void requestSerialNumber(long l, int n) {
    }

    default public void requestSystemName(long l, int n) {
    }

    default public void requestCountryRegionVersion(long l) {
    }

    default public void requestDeleteMemory(long l, int n) {
    }
}


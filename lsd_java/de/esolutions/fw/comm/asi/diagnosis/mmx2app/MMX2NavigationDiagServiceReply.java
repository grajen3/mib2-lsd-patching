/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app;

public interface MMX2NavigationDiagServiceReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void requestSubsystemState(long l) {
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

    default public void requestResetCalibration(long l, int n) {
    }

    default public void requestSparePartNumberNavDB(long l) {
    }

    default public void requestApplicationSoftwareVersionNumberNavDB(long l) {
    }

    default public void requestHardwareNumberNavDB(long l) {
    }

    default public void requestHardwareVersionNumberNavDB(long l) {
    }

    default public void requestSerialNumberNavDB(long l) {
    }

    default public void requestSystemNameNavDB(long l) {
    }

    default public void requestCountryRegionVersion(long l) {
    }
}


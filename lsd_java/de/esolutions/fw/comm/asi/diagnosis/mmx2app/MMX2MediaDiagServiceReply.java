/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app;

public interface MMX2MediaDiagServiceReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void requestSubsystemState(long l) {
    }

    default public void requestMediaDBVersion(long l) {
    }

    default public void requestActiveMediaSourceState(long l, int n) {
    }

    default public void requestMediaRegionCodes(long l) {
    }

    default public void requestMediaTypeOpticalDrive(long l) {
    }

    default public void requestUsbOvercurrent(long l) {
    }

    default public void requestPmlState(long l) {
    }

    default public void requestSparePartNumberMediaDB(long l) {
    }

    default public void requestApplicationSoftwareVersionNumberMediaDB(long l) {
    }

    default public void requestSerialNumberMediaDB(long l) {
    }

    default public void requestSystemNameMediaDB(long l) {
    }

    default public void requestStatusUSBCommunication(long l) {
    }

    default public void requestUSBHubIdentification(long l) {
    }

    default public void requestDTCPEncryptionState(long l) {
    }

    default public void requestDTCPKeytypeMMX(long l) {
    }

    default public void requestDTCPSRMInfo(long l) {
    }
}


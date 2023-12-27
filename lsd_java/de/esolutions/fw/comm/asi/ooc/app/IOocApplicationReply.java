/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.ooc.app;

public interface IOocApplicationReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updatePowerState(long l) {
    }

    default public void updateShutdownRequest(int n) {
    }

    default public void updateClampSignal(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
    }

    default public void updateVoltageLevel(int n) {
    }

    default public void updateRunMode(int n) {
    }

    default public void updateCarLockSignal(boolean bl) {
    }

    default public void updatePowerOnPinStatus(boolean bl) {
    }
}


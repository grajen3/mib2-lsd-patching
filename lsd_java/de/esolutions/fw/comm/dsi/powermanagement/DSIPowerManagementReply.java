/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.powermanagement;

import org.dsi.ifc.powermanagement.ClampSignal;

public interface DSIPowerManagementReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updatePowerManagementState(int n, int n2, int n3) {
    }

    default public void updatePowerManagementStateRight(int n, int n2, int n3) {
    }

    default public void updateBEMState(int n, int n2) {
    }

    default public void updateTelMaxPopup(boolean bl, int n) {
    }

    default public void updateTStandbyPopup(boolean bl, int n) {
    }

    default public void updateClampSignal(ClampSignal clampSignal, int n) {
    }

    default public void updateRVCActive(boolean bl, int n) {
    }

    default public void updateChildLockState(int n, int n2) {
    }

    default public void updateLastOn(int n, int n2) {
    }

    default public void updateSplashScreenAnimation(int n, int n2) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}


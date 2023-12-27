/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.powermanagement;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.powermanagement.ClampSignal;

public interface DSIPowerManagementListener
extends DSIListener {
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
}


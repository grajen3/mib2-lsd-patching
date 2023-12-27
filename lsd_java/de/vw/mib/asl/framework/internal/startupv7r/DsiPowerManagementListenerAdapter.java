/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r;

import org.dsi.ifc.powermanagement.ClampSignal;
import org.dsi.ifc.powermanagement.DSIPowerManagementListener;

public class DsiPowerManagementListenerAdapter
implements DSIPowerManagementListener {
    @Override
    public void asyncException(int n, String string, int n2) {
    }

    @Override
    public void updatePowerManagementState(int n, int n2, int n3) {
    }

    @Override
    public void updatePowerManagementStateRight(int n, int n2, int n3) {
    }

    @Override
    public void updateBEMState(int n, int n2) {
    }

    @Override
    public void updateTelMaxPopup(boolean bl, int n) {
    }

    @Override
    public void updateTStandbyPopup(boolean bl, int n) {
    }

    @Override
    public void updateClampSignal(ClampSignal clampSignal, int n) {
    }

    @Override
    public void updateRVCActive(boolean bl, int n) {
    }

    @Override
    public void updateChildLockState(int n, int n2) {
    }

    @Override
    public void updateLastOn(int n, int n2) {
    }

    @Override
    public void updateSplashScreenAnimation(int n, int n2) {
    }
}


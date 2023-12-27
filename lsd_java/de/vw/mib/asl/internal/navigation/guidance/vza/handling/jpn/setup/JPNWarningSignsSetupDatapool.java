/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.vza.handling.jpn.setup;

import de.vw.mib.asl.internal.navigation.guidance.vza.handling.jpn.setup.PersistedJPNWarningSignsSetup;

public class JPNWarningSignsSetupDatapool {
    private final PersistedJPNWarningSignsSetup persistedJPNWarningSignsSetup = PersistedJPNWarningSignsSetup.getInstance();

    public boolean isMergingTraffic() {
        return this.persistedJPNWarningSignsSetup.isMergingTraffic();
    }

    public boolean isRailwayCrossing() {
        return this.persistedJPNWarningSignsSetup.isRailwayCrossing();
    }

    public boolean isReduceLane() {
        return this.persistedJPNWarningSignsSetup.isReduceLane();
    }

    public int getSpeedCameraWarningType() {
        return this.persistedJPNWarningSignsSetup.getSpeedCameraWarningType();
    }

    public void setMergingTraffic(boolean bl) {
        this.persistedJPNWarningSignsSetup.setMergingTraffic(bl);
    }

    public void setRailwayCrossing(boolean bl) {
        this.persistedJPNWarningSignsSetup.setRailwayCrossing(bl);
    }

    public void setReduceLane(boolean bl) {
        this.persistedJPNWarningSignsSetup.setReduceLane(bl);
    }

    public void setSpeedCameraWarningSignType(int n) {
        this.persistedJPNWarningSignsSetup.setSpeedCameraWarningSignType(n);
    }
}


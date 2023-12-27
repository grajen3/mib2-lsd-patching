/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.vza.handling.jpn.setup;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IPersonalNaviPersistence;

public class PersistedJPNWarningSignsSetup {
    private static PersistedJPNWarningSignsSetup instance = new PersistedJPNWarningSignsSetup();
    private IPersonalNaviPersistence personalNaviPersistence = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence();

    public static PersistedJPNWarningSignsSetup getInstance() {
        return instance;
    }

    public boolean isMergingTraffic() {
        return this.personalNaviPersistence.isMergingTraffic();
    }

    public boolean isRailwayCrossing() {
        return this.personalNaviPersistence.isRailwayCrossing();
    }

    public boolean isReduceLane() {
        return this.personalNaviPersistence.isReduceLane();
    }

    public int getSpeedCameraWarningType() {
        return this.personalNaviPersistence.getSpeedCameraWarningType();
    }

    public void setMergingTraffic(boolean bl) {
        this.personalNaviPersistence.setMergingTraffic(bl);
    }

    public void setRailwayCrossing(boolean bl) {
        this.personalNaviPersistence.setRailwayCrossing(bl);
    }

    public void setReduceLane(boolean bl) {
        this.personalNaviPersistence.setReduceLane(bl);
    }

    public void setSpeedCameraWarningSignType(int n) {
        this.personalNaviPersistence.setSpeedCameraWarningType(n);
    }
}


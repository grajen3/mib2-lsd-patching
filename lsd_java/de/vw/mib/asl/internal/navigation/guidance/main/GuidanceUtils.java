/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.main;

import de.vw.mib.asl.api.navigation.guidance.ASLCalculationState;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.guidance.PersistedGuidanceSetup;
import de.vw.mib.asl.internal.navigation.guidance.main.HsmTargetGuidance;

public class GuidanceUtils {
    public static boolean wasDemoGuidance() {
        int n = PersistedGuidanceSetup.getInstance().getLastGuidanceMode();
        return n == 520224832 || n == 553779264 || n == 1963393088 || n == 0x20020040;
    }

    public static void notifyGuidanceDeactivated(HsmTargetGuidance hsmTargetGuidance, boolean bl) {
        hsmTargetGuidance.rcProgressHandling.resetDefaults();
        PersistedGuidanceSetup.getInstance().setWasGuidanceActive(false, false);
        hsmTargetGuidance.navigationDp.setGuidanceType(1);
        ServiceManager.aslPropertyManager.valueChangedInteger(-2114973696, 0);
        ServiceManager.aslPropertyManager.valueChangedInteger(806, 0);
        ServiceManager.aslPropertyManager.valueChangedInteger(803, 0);
        ServiceManager.aslPropertyManager.valueChangedInteger(997, 0);
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().isPNavActive()) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setPNavActive(false);
            if (PersistedGuidanceSetup.getInstance().isSoundOn()) {
                hsmTargetGuidance.getDsiNavigation().rgSetRouteGuidanceMode(PersistedGuidanceSetup.getInstance().getDsiAudioAnnouncementType());
            }
        }
        hsmTargetGuidance.updateCalculationState(new ASLCalculationState[]{new ASLCalculationState()});
        hsmTargetGuidance.updateGuidanceState(0);
        hsmTargetGuidance.isGuidanceRestartAfterDemo = false;
        hsmTargetGuidance.isResumeGuidance = bl;
    }

    public static boolean isSystemTimestampValid(long l) {
        return l != -1L;
    }

    public static boolean isNaviTimestampValid(long l) {
        return l != -1L;
    }

    public static int calculateHmiOffTimeMinutes(long l, long l2) {
        return (int)((l - l2) / 0);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.online.testbridge;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;

public final class ASLOnlineServicesUtil {
    private ASLOnlineServicesUtil() {
    }

    public static boolean checkServiceId(int n) {
        boolean bl;
        switch (n) {
            case 0: 
            case 1: 
            case 2: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 13: 
            case 14: 
            case 15: {
                bl = true;
                break;
            }
            default: {
                bl = false;
            }
        }
        return bl;
    }

    public static boolean getFeatureFlagValueForServiceId(int n) {
        boolean bl;
        switch (n) {
            case 0: {
                bl = ServiceManager.configManagerDiag.isFeatureFlagSet(184);
                break;
            }
            case 1: {
                bl = ServiceManager.configManagerDiag.isFeatureFlagSet(195);
                break;
            }
            case 2: {
                bl = ServiceManager.configManagerDiag.isFeatureFlagSet(191);
                break;
            }
            case 13: {
                bl = ServiceManager.configManagerDiag.isFeatureFlagSet(186);
                break;
            }
            case 14: {
                bl = ServiceManager.configManagerDiag.isFeatureFlagSet(186);
                break;
            }
            case 4: {
                bl = ServiceManager.configManagerDiag.isFeatureFlagSet(185);
                break;
            }
            case 15: {
                bl = ServiceManager.configManagerDiag.isFeatureFlagSet(192);
                break;
            }
            case 5: {
                bl = ServiceManager.configManagerDiag.isFeatureFlagSet(197);
                break;
            }
            case 6: {
                bl = ServiceManager.configManagerDiag.isFeatureFlagSet(183);
                break;
            }
            case 7: {
                bl = ServiceManager.configManagerDiag.isFeatureFlagSet(193);
                break;
            }
            case 8: {
                bl = ServiceManager.configManagerDiag.isFeatureFlagSet(187);
                break;
            }
            case 9: {
                bl = ServiceManager.configManagerDiag.isFeatureFlagSet(188);
                break;
            }
            case 10: {
                bl = ServiceManager.configManagerDiag.isFeatureFlagSet(196);
                break;
            }
            default: {
                bl = false;
            }
        }
        return bl;
    }
}


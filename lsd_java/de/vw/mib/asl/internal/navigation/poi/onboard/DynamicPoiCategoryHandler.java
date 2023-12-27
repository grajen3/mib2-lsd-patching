/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.onboard;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiDatapool;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiNotifierModel;
import de.vw.mib.asl.internal.navigation.poi.setup.PersistedPoiSetup;
import de.vw.mib.log4mib.LogMessage;

public final class DynamicPoiCategoryHandler {
    private static IExtLogger LOGGER = null;

    private static IExtLogger getLogger() {
        if (LOGGER == null) {
            LOGGER = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(512, "DynamicPoiCategoryHandler:");
        }
        return LOGGER;
    }

    private DynamicPoiCategoryHandler() {
    }

    public static boolean isValidOnlinePoiCategory(int n) {
        return n == 4 || n == 1 || n == 3 || n == 6 || n == 5 || n == 2;
    }

    public static void hideOnlineSearchButton() {
        DynamicPoiCategoryHandler.getLogger().makeTrace().append("hideOnlineSearchButton").log();
        PoiNotifierModel.notifyDynamicPoiCategory(4);
    }

    static void updateByOnboardUid(int n) {
        DynamicPoiCategoryHandler.getLogger().makeTrace().append("--== Selection of onboard POI ==--").log();
        DynamicPoiCategoryHandler.getLogger().makeTrace().append("updateByOnboardUid").log();
        int n2 = DynamicPoiCategoryHandler.getDynamicPoiCategoryByOnboardUid(n);
        PoiNotifierModel.notifyDynamicPoiCategory(n2);
        DynamicPoiCategoryHandler.getLogger().makeTrace().append("Onboard POI UID: ").append(n).log();
        if (n2 != 4) {
            DynamicPoiCategoryHandler.getLogger().makeTrace().append("Dynamic POI UID: ").append(n2).log();
        }
        DynamicPoiCategoryHandler.getLogger().makeTrace().append("Special handling for dynamic POI?: ").append(4 == n2 ? "No" : "Yes").log();
    }

    static void updateByOnlineUid(int n) {
        DynamicPoiCategoryHandler.getLogger().makeTrace().append("--== Selection of online POI ==--").log();
        DynamicPoiCategoryHandler.getLogger().makeTrace().append("updateByOnlineUid").log();
        int n2 = n;
        int n3 = DynamicPoiCategoryHandler.getDynamicPoiCategoryByOnlineId(n2);
        PoiDatapool.getInstance().setLastSelectedTopPoiUid(DynamicPoiCategoryHandler.getOnboardCategoryByDynamicCategory(n2));
        PoiDatapool.getInstance().setFilterCategoryUid(PoiDatapool.getInstance().getLastSelectedTopPoiUid());
        PoiNotifierModel.notifyDynamicPoiCategory(n3);
        DynamicPoiCategoryHandler.getLogger().makeTrace().append("Dynamic DSI   POI UID: ").append(n2).log();
        DynamicPoiCategoryHandler.getLogger().makeTrace().append("Dynamic model POI category: ").append(n3).log();
    }

    static int getOnboardCategoryUidByUsecase(int n) {
        DynamicPoiCategoryHandler.getLogger().makeTrace().append("getOnboardCategoryUidByUsecase(").append(n).append(")").log();
        switch (n) {
            case 5: {
                return 101;
            }
            case 6: {
                return 121;
            }
            case 8: {
                return 136;
            }
            case 7: {
                return 135;
            }
            case 9: {
                return 134;
            }
        }
        return -1;
    }

    static int[] getPreferredChargingStationCategoryUids() {
        int[] nArray;
        int n = PersistedPoiSetup.getInstance().getPreferredChargingSpeed();
        switch (n) {
            case 0: {
                nArray = new int[]{132, 133, 150, 151};
                break;
            }
            case 1: {
                nArray = new int[]{132, 150};
                break;
            }
            case 2: {
                nArray = new int[]{133, 151};
                break;
            }
            default: {
                DynamicPoiCategoryHandler.getLogger().makeTrace().append("getChargingStationCategoryUids() got unknown option").log();
                nArray = new int[]{};
            }
        }
        LogMessage logMessage = DynamicPoiCategoryHandler.getLogger().makeTrace().append("getChargingStationCategoryUids(").append(n).append(") -> [");
        int n2 = nArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            logMessage = logMessage.append(nArray[i2]);
            if (i2 + 1 >= n2) continue;
            logMessage = logMessage.append(",");
        }
        logMessage.append("]").log();
        return nArray;
    }

    static boolean isUseCaseTopPoiSearch() {
        return PoiDatapool.getInstance().getCurrentUseCase() == 4;
    }

    static boolean isUseCaseFuelWarningSearch() {
        switch (PoiDatapool.getInstance().getCurrentUseCase()) {
            case 4: 
            case 5: 
            case 6: 
            case 9: {
                return true;
            }
        }
        return false;
    }

    private static int getDynamicPoiCategoryByOnboardUid(int n) {
        int n2;
        DynamicPoiCategoryHandler.getLogger().makeTrace().append("getDynamicPoiCategoryByOnboardUid(").append(n).append(")").log();
        boolean bl = ServiceManager.configManagerDiag.isFeatureFlagSet(75);
        boolean bl2 = ServiceManager.configManagerDiag.isFeatureFlagSet(70);
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(26) ? n != 102 : !ServiceManager.configManagerDiag.isFeatureFlagSet(59) && !bl) {
            return 4;
        }
        switch (n) {
            case 101: 
            case 121: 
            case 137: {
                n2 = 1;
                break;
            }
            case 134: {
                if (bl && !bl2) {
                    n2 = 4;
                    break;
                }
                n2 = 0;
                break;
            }
            case 132: {
                if (bl && !bl2) {
                    n2 = 4;
                    break;
                }
                n2 = 6;
                break;
            }
            case 133: {
                if (bl && !bl2) {
                    n2 = 4;
                    break;
                }
                n2 = 5;
                break;
            }
            case 135: 
            case 136: {
                n2 = 4;
                break;
            }
            case 102: {
                n2 = 2;
                break;
            }
            default: {
                n2 = 4;
            }
        }
        DynamicPoiCategoryHandler.getLogger().makeTrace().append("getDynamicPoiCategoryByOnboardUid(").append(n).append(") -> ").append(n2).log();
        return n2;
    }

    private static int getDynamicPoiCategoryByOnlineId(int n) {
        int n2;
        DynamicPoiCategoryHandler.getLogger().makeTrace().append("getDynamicPoiCategoryByOnlineId(").append(n).append(")").log();
        switch (n) {
            case 4: {
                n2 = 0;
                break;
            }
            case 6: {
                n2 = 6;
                break;
            }
            case 5: {
                n2 = 5;
                break;
            }
            case 1: {
                n2 = 1;
                break;
            }
            case 2: {
                n2 = 3;
                break;
            }
            default: {
                n2 = 1;
            }
        }
        DynamicPoiCategoryHandler.getLogger().makeTrace().append("getDynamicPoiCategoryByOnlineId(").append(n).append(") -> ").append(n2).log();
        return n2;
    }

    private static int getOnboardCategoryByDynamicCategory(int n) {
        switch (n) {
            case 2: {
                return 102;
            }
            case 4: {
                return 134;
            }
            case 6: {
                return 132;
            }
            case 5: {
                return 133;
            }
            case 3: {
                return 135;
            }
        }
        return 101;
    }

    public static int modelToDsiCategory(int n) {
        DynamicPoiCategoryHandler.getLogger().makeTrace().append(new StringBuffer().append("DynamicPoiCategoryHandler: handle model category ").append(n).toString()).log();
        switch (n) {
            case 0: {
                return 4;
            }
            case 1: {
                return 1;
            }
            case 3: {
                return 3;
            }
            case 2: {
                return 2;
            }
            case 4: {
                return 6;
            }
            case 5: {
                return 5;
            }
        }
        DynamicPoiCategoryHandler.getLogger().warn("DynamicPoiCategoryHandler: modelToDsiCategory: no/wrong category given -> use fuel stations instead");
        return 1;
    }
}


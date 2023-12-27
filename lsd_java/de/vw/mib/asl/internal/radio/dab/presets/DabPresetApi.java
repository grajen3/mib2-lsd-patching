/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.presets;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.dab.presets.DabPreset;
import de.vw.mib.genericevents.EventGeneric;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radio.ServiceInfo;
import org.dsi.ifc.radiodata.RadioStationDataRequest;
import org.dsi.ifc.radiodata.RadioStationLogoResponse;

public final class DabPresetApi {
    private static boolean dabPresetsLoadedAndInitialized = false;
    private static int dabPresetCountFromModel = 15;
    private static boolean dabPresetCountTriggeredFromModel = false;
    private static boolean deletePresetsDatabaseIdsRequested = false;
    private static boolean deletePresetsLogoRequested = false;

    private DabPresetApi() {
    }

    public static boolean isDabPresetsLoadedAndInitialized() {
        return dabPresetsLoadedAndInitialized;
    }

    public static void setDabPresetsLoadedAndInitialized(boolean bl) {
        ServiceManager.logger.info(256).append("DAB Presets are Initialized").log();
        dabPresetsLoadedAndInitialized = bl;
    }

    public static int getDabPresetCountFromModel() {
        if (dabPresetCountFromModel >= 15 && dabPresetCountFromModel <= 18) {
            return dabPresetCountFromModel;
        }
        return 15;
    }

    public static void setDabPresetCountFromModel(int n) {
        if (n >= 15 && n <= 18) {
            dabPresetCountFromModel = n;
        }
    }

    public static boolean isDabPresetCountTriggeredFromModel() {
        return dabPresetCountTriggeredFromModel;
    }

    public static void setDabPresetCountTriggeredFromModel(boolean bl) {
        dabPresetCountTriggeredFromModel = bl;
    }

    public static void createNewDabPresets() {
        try {
            if (ServiceManager.logger.isTraceEnabled(256)) {
                ServiceManager.logger.trace(256).append(RadioUtil.LOG_PREFIX_DAB_PRESETS).append("DabPresetApi - createNewDabPresets()").log();
            }
            if (DabPresetApi.isDabPresetsLoadedAndInitialized() && DabPresetApi.isDabPresetCountTriggeredFromModel()) {
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    ServiceManager.logger.trace(256).append("Create new DAB Presets with new preset count: : ").append(DabPresetApi.getDabPresetCountFromModel()).log();
                }
                RadioData.getAmfmDatabase().getSettingsPersistable().setDabNoOfPresets(DabPresetApi.getDabPresetCountFromModel());
                if (null != RadioData.getDabDatabase().dabPresetList) {
                    RadioData.getDabDatabase().dabPresetList.createNewNoOfPresets();
                    RadioData.getDabDatabase().dabPresetList.notifyHmi();
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static DabPreset getCurrentPreset() {
        return RadioData.getDabDatabase().dabPresetList.getCurrentPreset();
    }

    public static void setDabStationLogoFromDatabaseSouthSide(ResourceLocator resourceLocator, RadioStationDataRequest radioStationDataRequest, int n) {
        try {
            if (null != RadioData.getDabDatabase().dabPresetList && null != radioStationDataRequest && null != resourceLocator) {
                RadioData.getDabDatabase().dabPresetList.setDabStationLogoFromDatabaseSouthSide(resourceLocator, radioStationDataRequest, n);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void setDatabaseDataForDabPreset(RadioStationLogoResponse radioStationLogoResponse, RadioStationDataRequest radioStationDataRequest, int n) {
        try {
            if (null != RadioData.getDabDatabase().dabPresetList && null != radioStationDataRequest && null != radioStationLogoResponse) {
                RadioData.getDabDatabase().dabPresetList.setDatabaseDataForDabPreset(radioStationLogoResponse, radioStationDataRequest, n);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void setManualAssignedDabStationLogoForAllPresets(ResourceLocator resourceLocator, ServiceInfo serviceInfo) {
        try {
            if (null != RadioData.getDabDatabase().dabPresetList && null != serviceInfo) {
                RadioData.getDabDatabase().dabPresetList.setManualAssignedDabStationLogoForAllPresets(resourceLocator, serviceInfo);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static DabPreset[] getValidPresetStationList() {
        try {
            return RadioData.getDabDatabase().mPersistable.mPresets;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    public static void setDabPresetCountFromModel(EventGeneric eventGeneric) {
        try {
            if (null == eventGeneric) {
                return;
            }
            if (!DabPresetApi.isDabPresetCountTriggeredFromModel() && null != eventGeneric) {
                DabPresetApi.setDabPresetCountTriggeredFromModel(true);
                int n = eventGeneric.getInt(1);
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    ServiceManager.logger.trace(256).append("DabPresetApi - SET_NUMBER_OF_PRESETS with newPresetCount : ").append(n).log();
                }
                if (n >= 15 && n <= 18) {
                    DabPresetApi.setDabPresetCountFromModel(n);
                    DabPresetApi.createNewDabPresets();
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static ResourceLocator getImage(ServiceInfo serviceInfo) {
        try {
            if (null != RadioData.getDabDatabase().dabPresetList && null != serviceInfo) {
                return RadioData.getDabDatabase().dabPresetList.getImage(serviceInfo);
            }
            return null;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    public static boolean isDeletePresetsDatabaseIdsRequested() {
        return deletePresetsDatabaseIdsRequested;
    }

    public static void setDeletePresetsDatabaseIdsRequested(boolean bl) {
        deletePresetsDatabaseIdsRequested = bl;
        if (ServiceManager.logger.isTraceEnabled(256)) {
            ServiceManager.logger.info(256).append("DabPresetApi - setDeletePresetsDatabaseIdsRequested() - ").append(bl).log();
        }
    }

    public static boolean isDeletePresetsLogoRequested() {
        return deletePresetsLogoRequested;
    }

    public static void setDeletePresetsLogoRequested(boolean bl) {
        deletePresetsLogoRequested = bl;
        if (ServiceManager.logger.isTraceEnabled(256)) {
            ServiceManager.logger.info(256).append("DabPresetApi - setDeletePresetsLogoRequested() - ").append(bl).log();
        }
    }
}


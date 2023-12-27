/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.download.swdl2;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.framework.api.diagnosis.config.Identification;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyAdapterFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.startupv7r.ASLStartupv7rAPI;
import de.vw.mib.asl.framework.api.startupv7r.ASLStartupv7rFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.download.PopUpInfo;
import de.vw.mib.asl.internal.download.SoftwareDownloadServices;
import de.vw.mib.asl.internal.download.swdl2.AslTargetCustomerDownload;
import de.vw.mib.asl.internal.download.transformer.SwdlUpdateDataCollector;
import de.vw.mib.asl.internal.impl.download.SoftwareDownloadServicesProvider;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.properties.values.SpellerData;
import edu.emory.mathcs.backport.java.util.Arrays;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.download.transformer.DownloadPopupInfoCollector;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.media.DeviceInfo;
import org.dsi.ifc.media.MediaInfo;
import org.dsi.ifc.persistence.DSIPersistence;
import org.dsi.ifc.powermanagement.DSIPowerManagement;
import org.dsi.ifc.swdldeviceinfo.DSISwdlDeviceInfo;
import org.dsi.ifc.swdllogging.DSISwdlLogging;
import org.dsi.ifc.swdlprogress.DSISwdlProgress;
import org.dsi.ifc.swdlprogress.DeviceOverviewProgress;
import org.dsi.ifc.swdlprogress.GeneralProgress;
import org.dsi.ifc.swdlselection.DSISwdlSelection;
import org.dsi.ifc.swdlselection.LameClient;

public final class AslTargetCarWorkshopDownload
extends AbstractASLTarget {
    public static boolean swdlHighOmitPowerStateChangeIndicationUntilStartSwdlWasCalled = false;
    public static boolean cSwdlIsRunning = false;
    static boolean sourceViewIsShown = false;
    static boolean cSwdlIsInhibited = false;
    static boolean dsiSwdlHasFocus = false;
    static int lastKnownServiceModeState = 0;
    static DeviceInfo[] lastKnownMediaDeviceList = null;
    static MediaInfo[] lastKnownMediaMediaList = null;
    final int HIGH_NAMESPACE_MU_AND_TRAIN;
    final long HIGH_KEY_MU_VERSION;
    final long HIGH_KEY_TRAIN_VERSION;
    final int STD_NAMESPACE_MU_AND_TRAIN;
    final long STD_KEY_MU_VERSION;
    final long STD_KEY_TRAIN_VERSION;
    boolean validAvailableMediaUpdateReceived = false;
    boolean validAvailableDevicesListReceived = false;
    byte lastDevicesUpdated = 0;
    byte lastMediaUpdated = 0;
    boolean setMediumIsPending = false;
    boolean retryReadingMetaInfoWasRequestedStartSetMediumImmediately = false;
    SwdlUpdateDataCollector[] installedFwCollector = new SwdlUpdateDataCollector[]{new SwdlUpdateDataCollector("SW _Train_", "----"), new SwdlUpdateDataCollector("MU", "----")};
    boolean powerOnWasRecievedSoTargetMayWork = false;
    boolean initSwdlPending = false;
    StringBuffer customerVersions = new StringBuffer();
    private static final int FIRMWARE_COLLECTOR_BOOTLOADER_SLOT;
    private static final int FIRMWARE_COLLECTOR_APPLICATION_SLOT;
    private static final long DELAY_RELEASE_EVENT_TIME;
    private static final int ADDITIONAL_INFO_MODE_INVALID;
    private static final int ADDITIONAL_INFO_MODE_DEVICE;
    private static final int ADDITIONAL_INFO_MODE_MODULE;
    private static final int ADDITIONAL_INFO_MODE_FIRMWARE;
    private static final int ADDITIONAL_INFO_MODE_SUMMARY_DEVICE;
    private static final int ADDITIONAL_INFO_MODE_SUMMARY_MODULE;
    private static final int ADDITIONAL_INFO_MODE_SUMMARY_FIRMWARE;
    private static final int HMI_FLAG_VECTOR_INDICATOR_CD;
    private static final int HMI_FLAG_VECTOR_INDICATOR_USB;
    private static final int HMI_FLAG_VECTOR_INDICATOR_SD;
    private static final int HMI_FLAG_VECTOR_INDICATOR_IP;
    private static final int SERVICEMODESTATE_C0_OFF;
    private static final int SERVICEMODESTATE_C1_SERVICEMODE_ON;
    private static final byte MEDIA_NFS;
    private static final byte MEDIA_CDDVD;
    private static final byte MEDIA_USB;
    private static final byte MEDIA_SD1;
    private static final byte MEDIA_SD2;
    private static final byte MEDIA_CIFS;
    private static final int EV_DELAYED_RELEASE_EVENT;
    private static final int EV_LOCAL_EVENT_READ_CODING;
    private static final int EV_LOCAL_EVENT_DELAYED_POPUP_CHECK;
    private static final int EV_LOCAL_EVENT_DELAYED_MEDIA_UPDATE;
    private static final int EV_LOCAL_EVENT_CSWDL_INHIBIT_TIMEOUT;
    private static final int POPUP_DELAY_SECONDS;
    private static final int INVALID_SOURCE_MEDIUM_ID;
    private static boolean sdCardOneIsAvailable;
    private static boolean sdCardTwoIsAvailable;
    private final StringBuffer actualIpAddress = new StringBuffer(16);
    private final HashSet mDelayedPopupInfo;
    private final ASLStartupv7rAPI aslStartupv7rAPI = ASLStartupv7rFactory.getStartupv7rApi();
    private int activeSourceMediumId = -1;
    private int currentSwdlAccessType = 0;
    private int currentlySelectedDeviceId = -1;
    private int currentlySelectedModuleId = -1;
    private int actualIpAddressStringIndex = 0;
    private boolean useCifsForEthernetIfTrueElseNfs = true;
    private boolean releaseFoundOnMedium = false;
    private String[] loggedUpdatesStringArray;
    private SwdlUpdateDataCollector[] firmwarePartUpdateCollector = null;
    private int remainingItemsOfCurrentDownload;
    private boolean isCurrentlySelectedModuleDataModule = false;
    private boolean summaryReachedSendNoRemainingUpdate = false;
    private boolean inhibitMetainfoSuccessEvent = false;
    private boolean loggingIsActive;
    private PopUpInfo activePopupInfo;
    private String currentTrainVersion = "";
    private int numberOfDevicesInCurrentSwdlSelection = 0;
    private boolean swdlStartWasRequested = false;
    private boolean notificationForNormalSwdlAreSet = false;
    private String nameOfCurrentlyInstalledRelease = "----";
    private DSISwdlProgress dsiSwdlProgress;
    private DSISwdlSelection dsiSwdlSelection;
    private DSISwdlDeviceInfo dsiSwdlDeviceInfo;
    private DSISwdlLogging dsiSwdlLogging;
    private DSIPersistence dsiPersistence;
    private DSIListener swdlProgressListener;
    private DSIListener swdlSelectionListener;
    private DSIListener swdlDeviceInfoListener;
    private DSIListener swdlLoggingListener;
    private DSIListener persistenceListener;
    private boolean initiallySent;
    private boolean userAbortIsPendingSoShowRebootScreenAfterPopupAndTriggerPanel = false;
    private ConfigurationManagerDiag configManagerDiag;
    private ASLPropertyManager propertyManager;
    private Logger logger;
    static /* synthetic */ Class class$org$dsi$ifc$swdldeviceinfo$DSISwdlDeviceInfo;
    static /* synthetic */ Class class$org$dsi$ifc$swdlprogress$DSISwdlProgress;
    static /* synthetic */ Class class$org$dsi$ifc$swdllogging$DSISwdlLogging;
    static /* synthetic */ Class class$org$dsi$ifc$swdlselection$DSISwdlSelection;
    static /* synthetic */ Class class$org$dsi$ifc$persistence$DSIPersistence;
    static /* synthetic */ Class class$org$dsi$ifc$swdldeviceinfo$DSISwdlDeviceInfoListener;
    static /* synthetic */ Class class$org$dsi$ifc$swdlprogress$DSISwdlProgressListener;
    static /* synthetic */ Class class$org$dsi$ifc$swdllogging$DSISwdlLoggingListener;
    static /* synthetic */ Class class$org$dsi$ifc$swdlselection$DSISwdlSelectionListener;
    static /* synthetic */ Class class$org$dsi$ifc$persistence$DSIPersistenceListener;
    static /* synthetic */ Class class$org$dsi$ifc$powermanagement$DSIPowerManagement;

    private void processDsiResponseSetUpdate(int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetSWDL] processDsiResponseSetUpdate(").append(n).append(")").log();
        }
        this.currentSwdlAccessType = 4;
        this.dsiSwdlDeviceInfo.setAccessType(this.currentSwdlAccessType);
        this.dsiSwdlDeviceInfo.getDevices();
    }

    private void processDsiResponseCheckConsistency(int n, boolean bl, String string, int n2) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetSWDL] processDsiResponseCheckConsistency(").append(n).append(", ").append(bl).append(", ").append(string).append(", ").append(n2).append(", ").log();
        }
        AslTargetCarWorkshopDownload.writeBooleanToDatapool(376, n == 1);
        AslTargetCarWorkshopDownload.writeBooleanToDatapool(368, bl);
    }

    private void processDsiUpdateSummaryChanged(String string) {
        this.trace("[AslTargetSWDL] processDsiUpdateSummaryChanged");
    }

    private void processDsiResponseStoreNfsIpAddress(String string) {
        this.trace("[AslTargetSWDL] processDsiResponseStoreNfsIpAddress");
        this.updateHmiGetterGetNWAddress(string);
    }

    private void processDsiResponseGetMedia(int[] nArray) {
        this.trace("[AslTargetSWDL] processDsiResponseGetMedia");
        Object[] objectArray = new Boolean[]{Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE};
        this.lastDevicesUpdated = 0;
        block8: for (int i2 = 0; i2 < nArray.length; ++i2) {
            switch (nArray[i2]) {
                case 6: {
                    this.trace("[AslTargetSWDL] processDsiResponseGetMedia CIFS Available as device");
                    this.lastDevicesUpdated = (byte)(this.lastDevicesUpdated | 0x20);
                    objectArray[3] = Boolean.TRUE;
                    continue block8;
                }
                case 1: {
                    this.trace("[AslTargetSWDL] processDsiResponseGetMedia NFS Available as device");
                    this.lastDevicesUpdated = (byte)(this.lastDevicesUpdated | 1);
                    objectArray[3] = Boolean.TRUE;
                    continue block8;
                }
                case 2: {
                    this.trace("[AslTargetSWDL] processDsiResponseGetMedia CD Available as device");
                    this.lastDevicesUpdated = (byte)(this.lastDevicesUpdated | 2);
                    objectArray[0] = Boolean.TRUE;
                    continue block8;
                }
                case 3: {
                    this.trace("[AslTargetSWDL] processDsiResponseGetMedia USB Available as device");
                    this.lastDevicesUpdated = (byte)(this.lastDevicesUpdated | 4);
                    objectArray[1] = Boolean.TRUE;
                    continue block8;
                }
                case 4: {
                    this.trace("[AslTargetSWDL] processDsiResponseGetMedia SDCard1 Available as device");
                    this.lastDevicesUpdated = (byte)(this.lastDevicesUpdated | 8);
                    objectArray[2] = Boolean.TRUE;
                    continue block8;
                }
                case 5: {
                    this.trace("[AslTargetSWDL] processDsiResponseGetMedia SDCard2 Available as device");
                    this.lastDevicesUpdated = (byte)(this.lastDevicesUpdated | 0x10);
                    objectArray[2] = Boolean.TRUE;
                    continue block8;
                }
            }
        }
        if (this.validAvailableMediaUpdateReceived && this.aslStartupv7rAPI.isHighActivatorStarted()) {
            objectArray[0] = (this.lastDevicesUpdated & 2 & this.lastMediaUpdated) != 0 ? Boolean.TRUE : Boolean.FALSE;
            objectArray[3] = (this.lastDevicesUpdated & 0x21 & this.lastMediaUpdated) != 0 ? Boolean.TRUE : Boolean.FALSE;
            objectArray[2] = (this.lastDevicesUpdated & 0x18 & this.lastMediaUpdated) != 0 ? Boolean.TRUE : Boolean.FALSE;
            objectArray[1] = (this.lastDevicesUpdated & 4 & this.lastMediaUpdated) != 0 ? Boolean.TRUE : Boolean.FALSE;
        }
        ListManager.getGenericASLList(399).updateList(objectArray);
        this.validAvailableDevicesListReceived = true;
    }

    private void processDsiUpdateAvailableMedia(byte by) {
        this.trace("[AslTargetSWDL] processDsiUpdateAvailableMedia");
        this.lastMediaUpdated = by;
        Object[] objectArray = new Boolean[]{Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE};
        if (this.validAvailableDevicesListReceived && this.aslStartupv7rAPI.isHighActivatorStarted()) {
            objectArray[0] = (this.lastDevicesUpdated & 2 & this.lastMediaUpdated) != 0 ? Boolean.TRUE : Boolean.FALSE;
            objectArray[3] = (this.lastDevicesUpdated & 0x21 & this.lastMediaUpdated) != 0 ? Boolean.TRUE : Boolean.FALSE;
            objectArray[2] = (this.lastDevicesUpdated & 0x18 & this.lastMediaUpdated) != 0 ? Boolean.TRUE : Boolean.FALSE;
            objectArray[1] = (this.lastDevicesUpdated & 4 & this.lastMediaUpdated) != 0 ? Boolean.TRUE : Boolean.FALSE;
        } else {
            objectArray[0] = (2 & this.lastMediaUpdated) != 0 ? Boolean.TRUE : Boolean.FALSE;
            objectArray[3] = (0x21 & this.lastMediaUpdated) != 0 ? Boolean.TRUE : Boolean.FALSE;
            objectArray[2] = (0x18 & this.lastMediaUpdated) != 0 ? Boolean.TRUE : Boolean.FALSE;
            objectArray[1] = (4 & this.lastMediaUpdated) != 0 ? Boolean.TRUE : Boolean.FALSE;
        }
        ListManager.getGenericASLList(399).updateList(objectArray);
        this.validAvailableMediaUpdateReceived = true;
    }

    private int evaluateAdditionalInfoForUpdateToHmi(int n, int n2) {
        int n3 = -1;
        if (n2 == 2) {
            switch (n) {
                case 1: {
                    this.trace("[AslTargetSWDL] DSISwdlDeviceInfo.MODULE_YES");
                    n3 = 0;
                    break;
                }
                case 2: 
                case 14: {
                    this.trace("[AslTargetSWDL] DSISwdlDeviceInfo.MODULE_NO");
                    n3 = 1;
                    break;
                }
                case 5: {
                    this.trace("[AslTargetSWDL] DSISwdlDeviceInfo.MODULE_PARTIAL");
                    n3 = 3;
                    break;
                }
                case 0: 
                case 3: 
                case 4: 
                case 9: {
                    this.trace("[AslTargetSWDL] DSISwdlDeviceInfo.MODULE_NA");
                    n3 = 2;
                    break;
                }
                default: {
                    n3 = 2;
                    this.error("[AslTargetSWDL] Error while evaluating module state of additionalUpdateInfoContainer");
                    break;
                }
            }
        } else if (n2 == 1) {
            switch (n) {
                case 1: {
                    n3 = 0;
                    break;
                }
                case 2: 
                case 14: {
                    n3 = 1;
                    break;
                }
                case 5: {
                    n3 = 3;
                    break;
                }
                case 3: 
                case 6: 
                case 8: 
                case 12: 
                case 13: {
                    n3 = 2;
                    break;
                }
                case 4: 
                case 7: 
                case 9: {
                    n3 = 4;
                    break;
                }
                default: {
                    this.error("[AslTargetSWDL] Error while evaluating device state of additionalUpdateInfoContainer");
                    n3 = 2;
                    break;
                }
            }
        } else if (n2 == 3) {
            switch (n) {
                case 1: {
                    n3 = 0;
                    break;
                }
                case 2: 
                case 14: {
                    n3 = 1;
                    break;
                }
                case 3: 
                case 4: 
                case 9: {
                    n3 = 2;
                    break;
                }
                default: {
                    this.error("[AslTargetSWDL] Error while evaluating device state of additionalUpdateInfoContainer");
                    n3 = 2;
                    break;
                }
            }
        } else if (n2 == 4) {
            switch (n) {
                case 4: {
                    n3 = 2;
                    break;
                }
                case 2: {
                    n3 = 0;
                    break;
                }
                case 3: {
                    n3 = 1;
                    break;
                }
                case 1: {
                    n3 = 4;
                    break;
                }
                case 5: {
                    n3 = 3;
                    break;
                }
                default: {
                    this.error("[AslTargetSWDL] Error while evaluating device state of additionalUpdateInfoContainer");
                    n3 = -1;
                    break;
                }
            }
        } else if (n2 == 5) {
            switch (n) {
                case 4: {
                    n3 = 2;
                    break;
                }
                case 2: {
                    n3 = 0;
                    break;
                }
                case 3: {
                    n3 = 1;
                    break;
                }
                case 1: {
                    n3 = 4;
                    break;
                }
                case 5: {
                    n3 = 3;
                    break;
                }
                default: {
                    this.error("[AslTargetSWDL] Error while evaluating device state of additionalUpdateInfoContainer");
                    n3 = -1;
                    break;
                }
            }
        } else if (n2 == 6) {
            switch (n) {
                case 4: {
                    n3 = 2;
                    break;
                }
                case 2: {
                    n3 = 0;
                    break;
                }
                case 3: {
                    n3 = 1;
                    break;
                }
                case 1: {
                    n3 = 4;
                    break;
                }
                case 5: {
                    n3 = 3;
                    break;
                }
                default: {
                    this.error("[AslTargetSWDL] Error while evaluating device state of additionalUpdateInfoContainer");
                    n3 = -1;
                }
            }
        }
        return n3;
    }

    private String evaluateAdditionalInfoAsStringForUpdateToHmi(int n, int n2) {
        String string = "";
        if (n2 == 2) {
            string = this.getReturnValueForEvaluationUpdateamout(n);
        } else if (n2 == 1) {
            string = this.getReturnValueForEvaluationUpdateamout(n);
        } else if (n2 == 3) {
            string = this.getReturnValueForEvaluationUpdateamout(n);
        } else if (n2 == 4) {
            string = this.getReturnValueForEvaluationSummaryResult(n);
        } else if (n2 == 5) {
            string = this.getReturnValueForEvaluationSummaryResult(n);
        } else if (n2 == 6) {
            string = this.getReturnValueForEvaluationSummaryResult(n);
        }
        return string;
    }

    private String getReturnValueForEvaluationUpdateamout(int n) {
        String string;
        switch (n) {
            case 1: {
                this.trace("[AslTargetSWDL] DSISwdlDeviceInfo.UPDATEAMOUT_YES: Y");
                string = "Y";
                break;
            }
            case 14: {
                this.trace("[AslTargetSWDL] DSISwdlDeviceInfo.UPDATEAMOUT_DOWNGRADE: D");
                string = "D";
                break;
            }
            case 2: {
                this.trace("[AslTargetSWDL] DSISwdlDeviceInfo.UPDATEAMOUT_NO");
                string = "N";
                break;
            }
            case 5: {
                this.trace("[AslTargetSWDL] DSISwdlDeviceInfo.MODULE_PARTIAL: S(OME)");
                string = "Some";
                break;
            }
            case 9: {
                this.trace("[AslTargetSWDL] DSISwdlDeviceInfo.UPDATEAMOUT_NOT_ACTIVATED: F");
                string = "F";
                break;
            }
            case 6: {
                this.trace("[AslTargetSWDL] DSISwdlDeviceInfo.UPDATEAMOUT_INCOMPATIBLE: I");
                string = "I";
                break;
            }
            case 8: {
                this.trace("[AslTargetSWDL] DSISwdlDeviceInfo.UPDATEAMOUT_CORRUPTED: C");
                string = "C";
                break;
            }
            case 3: {
                this.trace("[AslTargetSWDL] DSISwdlDeviceInfo.UPDATEAMOUT_NOT_EXISTING: --");
                string = "--";
                break;
            }
            case 0: 
            case 4: 
            case 10: 
            case 11: {
                this.trace("[AslTargetSWDL] DSISwdlDeviceInfo.MODULE_NA: N/A");
                string = "N/A";
                break;
            }
            case 7: 
            case 12: 
            case 13: 
            case 15: {
                this.trace("[AslTargetSWDL] DSISwdlDeviceInfo.(*)ERROR: ERR");
                string = "ERR";
                break;
            }
            default: {
                string = "ERR";
                this.error("[AslTargetSWDL] Error while evaluating module state of additionalUpdateInfoContainer");
            }
        }
        return string;
    }

    private String getReturnValueForEvaluationSummaryResult(int n) {
        String string;
        switch (n) {
            case 4: {
                string = "NEW";
                break;
            }
            case 2: {
                string = "OK";
                break;
            }
            case 3: {
                string = "NOK";
                break;
            }
            case 5: {
                string = "OLD";
                break;
            }
            case 0: 
            case 1: {
                string = "--";
                break;
            }
            default: {
                this.error("[AslTargetSWDL] Error while evaluating device state of additionalUpdateInfoContainer");
                string = "ERR";
            }
        }
        return string;
    }

    private void helperMethodStartCustomerSwdlInhibitTimer() {
        if (!cSwdlIsRunning) {
            cSwdlIsInhibited = true;
            ServiceManager.eventMain.getTimerServer().restartOrStartTimedEvent(this.getTargetId(), -1484390144, 0, false);
        } else {
            cSwdlIsInhibited = false;
        }
    }

    private boolean helperMethodCheckIfHumanReadableAlphabetWasUsed(byte by) {
        return by >= 48 && by <= 122;
    }

    private boolean helperMethodIsFirmwareCollectorComplete() {
        if (this.isCurrentlySelectedModuleDataModule) {
            if (this.firmwarePartUpdateCollector[0].doneCollectingDataState && this.firmwarePartUpdateCollector[0].doneCollectingDataTargetVersion && this.firmwarePartUpdateCollector[0].doneCollectingDataVersion && this.firmwarePartUpdateCollector[0].doneCollectingDataNames) {
                if (this.currentSwdlAccessType == 1 || this.currentSwdlAccessType == 3) {
                    this.storeFirmwarePartUpdateCollectorDataState();
                }
                return true;
            }
        } else if (this.firmwarePartUpdateCollector[0].doneCollectingDataState && this.firmwarePartUpdateCollector[0].doneCollectingDataTargetVersion && this.firmwarePartUpdateCollector[0].doneCollectingDataVersion) {
            if (this.currentSwdlAccessType == 1 || this.currentSwdlAccessType == 3) {
                this.storeFirmwarePartUpdateCollectorDataState();
            }
            this.firmwarePartUpdateCollector[1].dataName = "Application";
            this.firmwarePartUpdateCollector[0].dataName = "Bootloader";
            return true;
        }
        return false;
    }

    private void storeFirmwarePartUpdateCollectorDataState() {
        for (int i2 = 0; i2 < this.firmwarePartUpdateCollector.length; ++i2) {
            if (!this.firmwarePartUpdateCollector[i2].dataTargetVersion.equals("0")) continue;
            this.firmwarePartUpdateCollector[i2].dataState = 2;
        }
    }

    private void helperMethodPrintCollectorArray(SwdlUpdateDataCollector[] swdlUpdateDataCollectorArray) {
        this.trace("[AslTargetSWDL] Number of Slots: ", swdlUpdateDataCollectorArray.length);
        for (int i2 = 0; i2 < swdlUpdateDataCollectorArray.length; ++i2) {
            if (!this.isTraceEnabled()) continue;
            this.trace().append("[AslTargetSWDL] ").append(swdlUpdateDataCollectorArray[i2].toString()).log();
        }
    }

    private void processDsiResponseGetDevices(String[] stringArray, int[] nArray) {
        this.trace("[AslTargetSWDL] processDsiResponseGetDevices");
        this.numberOfDevicesInCurrentSwdlSelection = stringArray.length;
        SwdlUpdateDataCollector[] swdlUpdateDataCollectorArray = this.getDeviceUpdateList(stringArray, nArray);
        if (!this.loggingIsActive && this.currentSwdlAccessType == 1 || this.currentSwdlAccessType == 3) {
            boolean bl = false;
            for (int i2 = 0; i2 < swdlUpdateDataCollectorArray.length; ++i2) {
                if (swdlUpdateDataCollectorArray[i2].dataState != 0 && swdlUpdateDataCollectorArray[i2].dataState != 3) continue;
                bl = true;
            }
            AslTargetCarWorkshopDownload.writeBooleanToDatapool(401, bl);
            this.updateHmiListGetUpdateableDevices(swdlUpdateDataCollectorArray);
            if (!this.inhibitMetainfoSuccessEvent) {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(23);
                this.inhibitMetainfoSuccessEvent = false;
            }
        } else if (this.currentSwdlAccessType == 2 || this.currentSwdlAccessType == 4) {
            this.updateHmiListGetLoggedDevices(swdlUpdateDataCollectorArray);
        } else if (this.loggingIsActive && this.currentSwdlAccessType == 1) {
            for (int i3 = 0; i3 < swdlUpdateDataCollectorArray.length; ++i3) {
                swdlUpdateDataCollectorArray[i3].dataState = 0;
            }
            this.updateHmiListGetLoggedDevices(swdlUpdateDataCollectorArray);
        }
    }

    private SwdlUpdateDataCollector[] getDeviceUpdateList(String[] stringArray, int[] nArray) {
        String[] stringArray2 = stringArray;
        int[] nArray2 = nArray;
        SwdlUpdateDataCollector[] swdlUpdateDataCollectorArray = new SwdlUpdateDataCollector[stringArray2.length];
        for (int i2 = swdlUpdateDataCollectorArray.length - 1; i2 >= 0; --i2) {
            String string;
            swdlUpdateDataCollectorArray[i2] = new SwdlUpdateDataCollector();
            swdlUpdateDataCollectorArray[i2].dataName = string = stringArray2[i2];
            if (this.currentSwdlAccessType == 1 || this.currentSwdlAccessType == 3) {
                swdlUpdateDataCollectorArray[i2].dataState = this.evaluateAdditionalInfoForUpdateToHmi(nArray2[i2], 1);
                swdlUpdateDataCollectorArray[i2].stateAbbreviation = this.evaluateAdditionalInfoAsStringForUpdateToHmi(nArray2[i2], 1);
            } else if (this.currentSwdlAccessType == 2 || this.currentSwdlAccessType == 4) {
                swdlUpdateDataCollectorArray[i2].dataState = this.evaluateAdditionalInfoForUpdateToHmi(nArray2[i2], 4);
                swdlUpdateDataCollectorArray[i2].stateAbbreviation = this.evaluateAdditionalInfoAsStringForUpdateToHmi(nArray2[i2], 4);
            }
            if (swdlUpdateDataCollectorArray[i2].dataState != -1 || !this.isTraceEnabled()) continue;
            this.trace().append("[AslTargetSWDL] ").append("no valid data: tempUpdateStateArray[").append(i2).append("] = ").append(nArray2[i2]).log();
        }
        return swdlUpdateDataCollectorArray;
    }

    private void processDsiResponseGetFileNames(int n, int n2, String[] stringArray) {
        int n3;
        this.trace("[AslTargetSWDL] processDsiResponseGetFileNames");
        if (null == this.firmwarePartUpdateCollector) {
            this.firmwarePartUpdateCollector = new SwdlUpdateDataCollector[stringArray.length];
            for (n3 = 0; n3 < stringArray.length; ++n3) {
                this.firmwarePartUpdateCollector[n3] = new SwdlUpdateDataCollector();
            }
        }
        for (n3 = 0; n3 < this.firmwarePartUpdateCollector.length; ++n3) {
            this.firmwarePartUpdateCollector[n3].dataName = stringArray[n3];
        }
        this.firmwarePartUpdateCollector[0].doneCollectingDataNames = true;
        if (this.helperMethodIsFirmwareCollectorComplete()) {
            this.trace("[AslTargetSWDL] Update List: DOWNLOAD_UPDATEABLE_FIRMWARE_PART");
            this.helperMethodPrintCollectorArray(this.firmwarePartUpdateCollector);
            ListManager.getGenericASLList(405).updateList(this.firmwarePartUpdateCollector);
            ListManager.getGenericASLList(-1800724992).updateList(this.firmwarePartUpdateCollector);
            this.updateHmiListLoggedFirmwarePart(this.firmwarePartUpdateCollector);
        }
    }

    private void processDsiResponseGetFirmwareStatesOrAdditionalInfo(int n, int n2, int[] nArray) {
        int n3;
        this.trace("[AslTargetSWDL] processDsiResponseGetFirmwareStatesOrAdditionalInfo");
        if (null == this.firmwarePartUpdateCollector) {
            this.firmwarePartUpdateCollector = new SwdlUpdateDataCollector[nArray.length];
            for (n3 = 0; n3 < nArray.length; ++n3) {
                this.firmwarePartUpdateCollector[n3] = new SwdlUpdateDataCollector();
            }
        }
        for (n3 = 0; n3 < this.firmwarePartUpdateCollector.length; ++n3) {
            if (this.currentSwdlAccessType == 1 || this.currentSwdlAccessType == 3) {
                this.firmwarePartUpdateCollector[n3].dataState = this.evaluateAdditionalInfoForUpdateToHmi(nArray[n3], 3);
                this.firmwarePartUpdateCollector[n3].stateAbbreviation = this.evaluateAdditionalInfoAsStringForUpdateToHmi(nArray[n3], 3);
                continue;
            }
            if (this.currentSwdlAccessType != 2 && this.currentSwdlAccessType != 4) continue;
            this.firmwarePartUpdateCollector[n3].dataState = this.evaluateAdditionalInfoForUpdateToHmi(nArray[n3], 6);
            this.firmwarePartUpdateCollector[n3].stateAbbreviation = this.evaluateAdditionalInfoAsStringForUpdateToHmi(nArray[n3], 6);
            this.firmwarePartUpdateCollector[n3].plannedResult = this.firmwarePartUpdateCollector[n3].dataState == 0 ? 0 : 4;
        }
        this.firmwarePartUpdateCollector[0].doneCollectingDataState = true;
        if (this.helperMethodIsFirmwareCollectorComplete()) {
            if (this.loggingIsActive && this.currentSwdlAccessType == 1) {
                for (n3 = 0; n3 < this.firmwarePartUpdateCollector.length; ++n3) {
                    this.firmwarePartUpdateCollector[n3].dataState = 0;
                    this.firmwarePartUpdateCollector[n3].dataTargetVersion = this.firmwarePartUpdateCollector[n3].dataVersion;
                }
                ListManager.getGenericASLList(409).updateList(this.firmwarePartUpdateCollector);
                ListManager.getGenericASLList(-1750393344).updateList(this.firmwarePartUpdateCollector);
            }
            this.trace("[AslTargetSWDL] Update List: DOWNLOAD_UPDATEABLE_FIRMWARE_PART");
            this.helperMethodPrintCollectorArray(this.firmwarePartUpdateCollector);
            if (this.currentSwdlAccessType == 1 || this.currentSwdlAccessType == 3) {
                ListManager.getGenericASLList(405).updateList(this.firmwarePartUpdateCollector);
                ListManager.getGenericASLList(-1800724992).updateList(this.firmwarePartUpdateCollector);
            } else if (this.currentSwdlAccessType == 2 || this.currentSwdlAccessType == 4) {
                this.updateHmiListLoggedFirmwarePart(this.firmwarePartUpdateCollector);
            }
        }
    }

    private void processDsiResponseGetFirmwareTargetVersions(int n, int n2, long[] lArray) {
        int n3;
        this.trace("[AslTargetSWDL] processDsiResponseGetFirmwareTargetVersions");
        long[] lArray2 = lArray;
        if (null == this.firmwarePartUpdateCollector) {
            this.firmwarePartUpdateCollector = new SwdlUpdateDataCollector[lArray2.length];
            for (n3 = 0; n3 < lArray2.length; ++n3) {
                this.firmwarePartUpdateCollector[n3] = new SwdlUpdateDataCollector();
            }
        }
        for (n3 = 0; n3 < this.firmwarePartUpdateCollector.length; ++n3) {
            this.firmwarePartUpdateCollector[n3].dataTargetVersion = String.valueOf(lArray2[n3]);
        }
        this.firmwarePartUpdateCollector[0].doneCollectingDataTargetVersion = true;
        if (this.helperMethodIsFirmwareCollectorComplete()) {
            if (this.loggingIsActive && this.currentSwdlAccessType == 1) {
                for (n3 = 0; n3 < this.firmwarePartUpdateCollector.length; ++n3) {
                    this.firmwarePartUpdateCollector[n3].dataState = 0;
                    this.firmwarePartUpdateCollector[n3].dataVersion = this.firmwarePartUpdateCollector[n3].dataTargetVersion;
                }
                ListManager.getGenericASLList(409).updateList(this.firmwarePartUpdateCollector);
                ListManager.getGenericASLList(-1750393344).updateList(this.firmwarePartUpdateCollector);
            }
            this.trace("[AslTargetSWDL] Update List: DOWNLOAD_UPDATEABLE_FIRMWARE_PART");
            this.helperMethodPrintCollectorArray(this.firmwarePartUpdateCollector);
            ListManager.getGenericASLList(405).updateList(this.firmwarePartUpdateCollector);
            ListManager.getGenericASLList(-1800724992).updateList(this.firmwarePartUpdateCollector);
            this.updateHmiListLoggedFirmwarePart(this.firmwarePartUpdateCollector);
        }
    }

    private void processDsiResponseGetFirmwareVersions(int n, int n2, long[] lArray) {
        int n3;
        this.trace("[AslTargetSWDL] processDsiResponseGetFirmwareVersions");
        if (null == this.firmwarePartUpdateCollector) {
            this.firmwarePartUpdateCollector = new SwdlUpdateDataCollector[lArray.length];
            for (n3 = 0; n3 < lArray.length; ++n3) {
                this.firmwarePartUpdateCollector[n3] = new SwdlUpdateDataCollector();
            }
        }
        for (n3 = 0; n3 < this.firmwarePartUpdateCollector.length; ++n3) {
            this.firmwarePartUpdateCollector[n3].dataVersion = String.valueOf(lArray[n3]);
        }
        this.firmwarePartUpdateCollector[0].doneCollectingDataVersion = true;
        if (this.helperMethodIsFirmwareCollectorComplete()) {
            if (this.loggingIsActive && this.currentSwdlAccessType == 1) {
                for (n3 = 0; n3 < this.firmwarePartUpdateCollector.length; ++n3) {
                    this.firmwarePartUpdateCollector[n3].dataState = 0;
                    this.firmwarePartUpdateCollector[n3].dataVersion = this.firmwarePartUpdateCollector[n3].dataTargetVersion;
                }
                ListManager.getGenericASLList(409).updateList(this.firmwarePartUpdateCollector);
                ListManager.getGenericASLList(-1750393344).updateList(this.firmwarePartUpdateCollector);
            }
            this.trace("[AslTargetSWDL] Update List: DOWNLOAD_UPDATEABLE_FIRMWARE_PART");
            this.helperMethodPrintCollectorArray(this.firmwarePartUpdateCollector);
            ListManager.getGenericASLList(405).updateList(this.firmwarePartUpdateCollector);
            ListManager.getGenericASLList(-1800724992).updateList(this.firmwarePartUpdateCollector);
            this.updateHmiListLoggedFirmwarePart(this.firmwarePartUpdateCollector);
        }
    }

    private void processDsiResponseGetHistory(String[] stringArray, int[] nArray) {
        this.trace("[AslTargetSWDL] processDsiResponseGetHistory");
        this.updateHmiListGetLoggingList(stringArray, nArray);
    }

    private void processDsiResponseGetModules(int n, String[] stringArray, int[] nArray, short[] sArray) {
        int n2;
        this.trace("[AslTargetSWDL] processDsiResponseGetModules");
        Object[] objectArray = new SwdlUpdateDataCollector[stringArray.length];
        for (n2 = objectArray.length - 1; n2 >= 0; --n2) {
            objectArray[n2] = new SwdlUpdateDataCollector();
            if (sArray.length == stringArray.length) {
                ((SwdlUpdateDataCollector)objectArray[n2]).dataName = new StringBuffer().append(stringArray[n2]).append(" (").append(sArray[n2]).append(")").toString();
            } else {
                this.warn().append("[AslTargetSWDL] no hwIndices were sent / had wrong length");
                ((SwdlUpdateDataCollector)objectArray[n2]).dataName = stringArray[n2];
            }
            if (this.currentSwdlAccessType == 3 || this.currentSwdlAccessType == 1) {
                ((SwdlUpdateDataCollector)objectArray[n2]).dataState = this.evaluateAdditionalInfoForUpdateToHmi(nArray[n2], 2);
                ((SwdlUpdateDataCollector)objectArray[n2]).stateAbbreviation = this.evaluateAdditionalInfoAsStringForUpdateToHmi(nArray[n2], 2);
            } else if (this.currentSwdlAccessType == 4 || this.currentSwdlAccessType == 2) {
                ((SwdlUpdateDataCollector)objectArray[n2]).dataState = this.evaluateAdditionalInfoForUpdateToHmi(nArray[n2], 5);
                ((SwdlUpdateDataCollector)objectArray[n2]).stateAbbreviation = this.evaluateAdditionalInfoAsStringForUpdateToHmi(nArray[n2], 5);
            }
            if (((SwdlUpdateDataCollector)objectArray[n2]).dataState != -1) continue;
            ((SwdlUpdateDataCollector)objectArray[n2]).dataState = 0;
            this.trace("[AslTargetSWDL] DSISwdlDeviceInfo.UPDATEAMOUT_ERROR ", nArray[n2]);
        }
        if (!(this.loggingIsActive || this.currentSwdlAccessType != 3 && this.currentSwdlAccessType != 1)) {
            ListManager.getGenericASLList(404).updateList(objectArray);
            ListManager.getGenericASLList(-1716838912).updateList(objectArray);
        } else if (this.currentSwdlAccessType == 4 || this.currentSwdlAccessType == 2) {
            ListManager.getGenericASLList(408).updateList(objectArray);
            ListManager.getGenericASLList(-1683284480).updateList(objectArray);
        } else if (this.loggingIsActive && this.currentSwdlAccessType == 1) {
            for (n2 = 0; n2 < objectArray.length; ++n2) {
                ((SwdlUpdateDataCollector)objectArray[n2]).dataState = 0;
            }
            ListManager.getGenericASLList(408).updateList(objectArray);
            ListManager.getGenericASLList(-1683284480).updateList(objectArray);
        }
    }

    private void processDsiResponseIsDataModule(int n, int n2, boolean bl) {
        this.isCurrentlySelectedModuleDataModule = bl;
        this.firmwarePartUpdateCollector = null;
        if (this.isCurrentlySelectedModuleDataModule) {
            this.dsiSwdlDeviceInfo.getFileNames(this.currentlySelectedDeviceId, this.currentlySelectedModuleId);
        }
        this.dsiSwdlDeviceInfo.getVersions(this.currentlySelectedDeviceId, this.currentlySelectedModuleId);
        this.dsiSwdlDeviceInfo.getTargetVersions(this.currentlySelectedDeviceId, this.currentlySelectedModuleId);
        this.dsiSwdlDeviceInfo.getAdditionalInfo(this.currentlySelectedDeviceId, this.currentlySelectedModuleId);
        this.dsiSwdlDeviceInfo.isNoExclusiveBoloUpdate(this.currentlySelectedDeviceId, this.currentlySelectedModuleId);
    }

    private void processDsiResponseIsNoExclusiveBoloUpdate() {
        this.trace("[AslTargetSWDL] processDsiResponseIsNoExclusiveBoloUpdate");
    }

    private void processDsiResponseSetMediumAndRequestAvailableReleaseNames(int n, String string, String[] stringArray) {
        this.setMediumIsPending = false;
        if (this.retryReadingMetaInfoWasRequestedStartSetMediumImmediately) {
            this.retryReadingMetaInfoWasRequestedStartSetMediumImmediately = false;
            this.setMediumIsPending = true;
            this.dsiSwdlSelection.setMedium(this.activeSourceMediumId);
            return;
        }
        this.propertyManager.valueChangedString(2558, string);
        boolean bl = false;
        this.trace("[AslTargetSWDL] processDsiResponseSetMediumAndRequestAvailableReleaseNames");
        if (this.activeSourceMediumId == 4 && n != 1 && sdCardOneIsAvailable == sdCardTwoIsAvailable) {
            this.trace("[AslTargetSWDL] Two Cards found, No valid data in SD 1, Set SD slot 2 active...");
            this.activeSourceMediumId = 5;
            this.setMediumIsPending = true;
            this.dsiSwdlSelection.setMedium(this.activeSourceMediumId);
            return;
        }
        this.releaseFoundOnMedium = false;
        switch (n) {
            case 6: {
                this.trace("[AslTargetSWDL] DSISwdlSelection.RELEASERESULT_ERROR_CRC");
                this.error().append("[AslTargetSWDL] CRC Error in release: ").append(string).append(" detected!").log();
                AslTargetCarWorkshopDownload.writeIntegerToDatapool(386, 3);
                bl = true;
                break;
            }
            case 8: {
                this.trace("[AslTargetSWDL] DSISwdlSelection.RELEASERESULT_ERROR_MEDIUM_UNAVAILABLE");
                this.error().append("[AslTargetSWDL] Error while reading medium: \"").append(string).append("\"").log();
                AslTargetCarWorkshopDownload.writeIntegerToDatapool(386, 1);
                bl = true;
                break;
            }
            case 11: {
                this.trace("[AslTargetSWDL] DSISwdlSelection.RELEASERESULT_ERROR_MEMORY");
                this.error("[AslTargetSWDL] Out of Memory!");
                AslTargetCarWorkshopDownload.writeIntegerToDatapool(386, 4);
                bl = true;
                break;
            }
            case 7: {
                this.trace("[AslTargetSWDL] DSISwdlSelection.RELEASERESULT_ERROR_NO_RELEASES");
                this.error("[AslTargetSWDL] No releases found on medium!");
                AslTargetCarWorkshopDownload.writeIntegerToDatapool(386, 2);
                bl = true;
                break;
            }
            case 2: {
                this.trace("[AslTargetSWDL] DSISwdlSelection.RELEASERESULT_ERROR_OPEN");
                this.error().append("[AslTargetSWDL] Error while reading metaInfo, could not open file: ").append(string).log();
                AslTargetCarWorkshopDownload.writeIntegerToDatapool(386, 4);
                bl = true;
                break;
            }
            case 4: {
                this.trace("[AslTargetSWDL] DSISwdlSelection.RELEASERESULT_ERROR_PARSE");
                this.error().append("[AslTargetSWDL] Error while reading metaInfo, could not parse file: ").append(string).log();
                AslTargetCarWorkshopDownload.writeIntegerToDatapool(386, 3);
                bl = true;
                break;
            }
            case 3: {
                this.trace("[AslTargetSWDL] DSISwdlSelection.RELEASERESULT_ERROR_READ");
                this.error().append("[AslTargetSWDL] Error while reading metaInfo, could not read file: ").append(string).log();
                AslTargetCarWorkshopDownload.writeIntegerToDatapool(386, 3);
                bl = true;
                break;
            }
            case 10: {
                this.trace("[AslTargetSWDL] DSISwdlSelection.RELEASERESULT_ERROR_REGION");
                this.error().append("[AslTargetSWDL] Error in region, wrong update for country-variant: ").append(string).log();
                AslTargetCarWorkshopDownload.writeIntegerToDatapool(386, 5);
                bl = true;
                break;
            }
            case 5: {
                this.trace("[AslTargetSWDL] DSISwdlSelection.RELEASERESULT_ERROR_SIGNATURE");
                this.error().append("[AslTargetSWDL] Wrong signature for update: ").append(string).log();
                AslTargetCarWorkshopDownload.writeIntegerToDatapool(386, 3);
                bl = true;
                break;
            }
            case 9: {
                this.trace("[AslTargetSWDL] DSISwdlSelection.RELEASERESULT_ERROR_VARIANT");
                StringTokenizer stringTokenizer = new StringTokenizer(string, " ");
                int n2 = stringTokenizer.countTokens();
                String string2 = "";
                if (n2 == 0) {
                    this.error("No Variant detected whether on target nor on Medium");
                } else if (n2 == 1) {
                    this.warn("No variant detected on medium");
                    string2 = new StringBuffer().append("Medium: N/A | MainUnit: ").append(string).toString();
                } else {
                    String string3 = string.substring(0, string.lastIndexOf(" "));
                    String string4 = string.substring(string.lastIndexOf(" "));
                    string2 = new StringBuffer().append("Medium: ").append(string3).append(" (MainUnit: ").append(string4).append(")").toString();
                }
                this.error().append("[AslTargetSWDL] Error in region, wrong update for variant: ").append(string2).log();
                this.propertyManager.valueChangedString(2558, string2);
                AslTargetCarWorkshopDownload.writeIntegerToDatapool(386, 6);
                bl = true;
                break;
            }
            case 0: {
                this.trace("[AslTargetSWDL] DSISwdlSelection.RELEASERESULT_NOT_INITIALIZED");
                this.error().append("[AslTargetSWDL] Init failed, please retry ").append(string).log();
                AslTargetCarWorkshopDownload.writeIntegerToDatapool(386, 1);
                bl = true;
                break;
            }
            case 1: {
                this.trace("[AslTargetSWDL] DSISwdlSelection.RELEASERESULT_OK");
                if (this.isTraceEnabled()) {
                    for (int i2 = 0; i2 < stringArray.length; ++i2) {
                        this.trace().append("[AslTargetSWDL] ").append(stringArray[i2]).log();
                    }
                }
                this.updateHmiListGetAvailableReleaseNames(stringArray);
                this.releaseFoundOnMedium = true;
                break;
            }
            default: {
                this.trace("[AslTargetSWDL] default: dsiSwdlSelectionListener.setMedium(result) = ", n);
                this.error("[AslTargetSWDL] An unknown error occurred while reading medium!");
                bl = true;
            }
        }
        if (!bl) {
            AslTargetCarWorkshopDownload.writeBooleanToDatapool(368, true);
            this.startTimer(-1585053440, (long)0, false);
        } else {
            this.trace("[AslTargetSWDL] sending RELEASE_INFO_FAILED");
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(22);
        }
    }

    private void processDsiResponseSetReleaseAndRequestUserDefinedAllowed(int n, String string) {
        this.propertyManager.valueChangedString(2559, string);
        boolean bl = true;
        this.trace("[AslTargetSWDL] processDsiResponseSetReleaseAndRequestUserDefinedAllowed");
        switch (n) {
            case 6: {
                this.trace("[AslTargetSWDL] DSISwdlSelection.METAINFORESULT_ERROR_CRC");
                this.error().append("[AslTargetSWDL] CRC Error in metaInfo: ").append(string).append(" detected!").log();
                break;
            }
            case 10: {
                this.trace("[AslTargetSWDL] DSISwdlSelection.METAINFORESULT_ERROR_CRC_CHANGED");
                this.error().append("[AslTargetSWDL] Error CRC has changed on metaInfo: ").append(string).log();
                AslTargetCarWorkshopDownload.writeIntegerToDatapool(387, 1);
                break;
            }
            case 8: {
                this.trace("[AslTargetSWDL] DSISwdlSelection.METAINFORESULT_ERROR_MEDIUM_UNAVAILABLE");
                this.error().append("[AslTargetSWDL] Error while reading medium: ").append(string).log();
                AslTargetCarWorkshopDownload.writeIntegerToDatapool(387, 2);
                break;
            }
            case 2: {
                this.trace("[AslTargetSWDL] DSISwdlSelection.METAINFORESULT_ERROR_OPEN_METAINFO");
                this.error().append("[AslTargetSWDL] Error while opening metaInfo, could not open file: ").append(string).log();
                AslTargetCarWorkshopDownload.writeIntegerToDatapool(387, 4);
                break;
            }
            case 4: {
                this.trace("[AslTargetSWDL] DSISwdlSelection.METAINFORESULT_ERROR_PARSE");
                this.error().append("[AslTargetSWDL] Error while reading metaInfo, could not parse file: ").append(string).log();
                break;
            }
            case 3: {
                this.trace("[AslTargetSWDL] DSISwdlSelection.METAINFORESULT_ERROR_READ");
                this.error().append("[AslTargetSWDL] Error while reading metaInfo, could not read file: ").append(string).log();
                AslTargetCarWorkshopDownload.writeIntegerToDatapool(387, 3);
                break;
            }
            case 7: {
                this.trace("[AslTargetSWDL] DSISwdlSelection.METAINFORESULT_ERROR_REGION");
                this.error().append("[AslTargetSWDL] Error in region for metaInfo: ").append(string).log();
                AslTargetCarWorkshopDownload.writeIntegerToDatapool(387, 5);
                break;
            }
            case 5: {
                this.trace("[AslTargetSWDL] DSISwdlSelection.METAINFORESULT_ERROR_SIGNATURE");
                this.error().append("[AslTargetSWDL] Wrong signature for update in metaInfo: ").append(string).log();
                break;
            }
            case 9: {
                this.trace("[AslTargetSWDL] DSISwdlSelection.METAINFORESULT_ERROR_VARIANT");
                this.error().append("[AslTargetSWDL] Error in metaInfo, wrong update for variant: ").append(string).log();
                AslTargetCarWorkshopDownload.writeIntegerToDatapool(387, 6);
                break;
            }
            case 0: {
                this.trace("[AslTargetSWDL] DSISwdlSelection.METAINFORESULT_NOT_INITIALIZED");
                this.error().append("[AslTargetSWDL] Init failed, please retry ").append(string).log();
                break;
            }
            case 1: {
                bl = false;
                this.trace("[AslTargetSWDL] DSISwdlSelection.METAINFORESULT_OK");
                this.dsiSwdlSelection.getUserDefinedAllowed();
                break;
            }
            default: {
                this.trace("[AslTargetSWDL] default branch: ", n);
            }
        }
        if (bl) {
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(24);
        }
    }

    private void updateHmiListGetAvailableReleaseNames(String[] stringArray) {
        this.trace("[AslTargetSWDL] updateHmiGetterGetAvailableReleaseNames");
        ListManager.getGenericASLList(375).updateList(stringArray);
    }

    private void updateHmiGetterGetNWAddress(String string) {
        this.trace("[AslTargetSWDL] updateHmiGetterGetNWAddress");
        AslTargetCarWorkshopDownload.writeStringToDatapool(394, string);
    }

    private void updateHmiGetterGetSpellerData() {
        this.trace("[AslTargetSWDL] updateHmiGetterGetSpellerData");
        SpellerData spellerData = new SpellerData();
        spellerData.setCursorPosition(this.actualIpAddressStringIndex);
        spellerData.setEnteredText(this.actualIpAddress.toString());
        this.propertyManager.valueChangedSpellerData(395, spellerData);
    }

    public AslTargetCarWorkshopDownload(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.HIGH_NAMESPACE_MU_AND_TRAIN = 30;
        this.HIGH_KEY_MU_VERSION = 0;
        this.HIGH_KEY_TRAIN_VERSION = 0;
        this.STD_NAMESPACE_MU_AND_TRAIN = 553765890;
        this.STD_KEY_MU_VERSION = 0;
        this.STD_KEY_TRAIN_VERSION = 0;
        this.mDelayedPopupInfo = new HashSet();
    }

    public AslTargetCarWorkshopDownload(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.HIGH_NAMESPACE_MU_AND_TRAIN = 30;
        this.HIGH_KEY_MU_VERSION = 0;
        this.HIGH_KEY_TRAIN_VERSION = 0;
        this.STD_NAMESPACE_MU_AND_TRAIN = 553765890;
        this.STD_KEY_MU_VERSION = 0;
        this.STD_KEY_TRAIN_VERSION = 0;
        this.mDelayedPopupInfo = new HashSet();
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        if (this.isTraceEnabled()) {
            this.trace().append("Start target TARGET_CAR_WORKSHOP_DOWNLOAD with ID = ").append(this.getDefaultTargetId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                SoftwareDownloadServices softwareDownloadServices = SoftwareDownloadServicesProvider.getSoftwareDownloadServices();
                DSIProxy dSIProxy = softwareDownloadServices.getDsiProxy();
                this.configManagerDiag = softwareDownloadServices.getConfigManagerDiag();
                this.propertyManager = softwareDownloadServices.getPropertyManager();
                this.logger = softwareDownloadServices.getLogger();
                this.dsiSwdlDeviceInfo = (DSISwdlDeviceInfo)dSIProxy.getService(this, class$org$dsi$ifc$swdldeviceinfo$DSISwdlDeviceInfo == null ? (class$org$dsi$ifc$swdldeviceinfo$DSISwdlDeviceInfo = AslTargetCarWorkshopDownload.class$("org.dsi.ifc.swdldeviceinfo.DSISwdlDeviceInfo")) : class$org$dsi$ifc$swdldeviceinfo$DSISwdlDeviceInfo);
                this.dsiSwdlProgress = (DSISwdlProgress)dSIProxy.getService(this, class$org$dsi$ifc$swdlprogress$DSISwdlProgress == null ? (class$org$dsi$ifc$swdlprogress$DSISwdlProgress = AslTargetCarWorkshopDownload.class$("org.dsi.ifc.swdlprogress.DSISwdlProgress")) : class$org$dsi$ifc$swdlprogress$DSISwdlProgress);
                this.dsiSwdlLogging = (DSISwdlLogging)dSIProxy.getService(this, class$org$dsi$ifc$swdllogging$DSISwdlLogging == null ? (class$org$dsi$ifc$swdllogging$DSISwdlLogging = AslTargetCarWorkshopDownload.class$("org.dsi.ifc.swdllogging.DSISwdlLogging")) : class$org$dsi$ifc$swdllogging$DSISwdlLogging);
                this.dsiSwdlSelection = (DSISwdlSelection)dSIProxy.getService(this, class$org$dsi$ifc$swdlselection$DSISwdlSelection == null ? (class$org$dsi$ifc$swdlselection$DSISwdlSelection = AslTargetCarWorkshopDownload.class$("org.dsi.ifc.swdlselection.DSISwdlSelection")) : class$org$dsi$ifc$swdlselection$DSISwdlSelection);
                this.dsiPersistence = (DSIPersistence)dSIProxy.getService(this, class$org$dsi$ifc$persistence$DSIPersistence == null ? (class$org$dsi$ifc$persistence$DSIPersistence = AslTargetCarWorkshopDownload.class$("org.dsi.ifc.persistence.DSIPersistence")) : class$org$dsi$ifc$persistence$DSIPersistence);
                DSIProxyAdapterFactory dSIProxyAdapterFactory = dSIProxy.getAdapterFactory();
                this.swdlDeviceInfoListener = dSIProxyAdapterFactory.createDSIListenerMethodAdapter(this, class$org$dsi$ifc$swdldeviceinfo$DSISwdlDeviceInfoListener == null ? (class$org$dsi$ifc$swdldeviceinfo$DSISwdlDeviceInfoListener = AslTargetCarWorkshopDownload.class$("org.dsi.ifc.swdldeviceinfo.DSISwdlDeviceInfoListener")) : class$org$dsi$ifc$swdldeviceinfo$DSISwdlDeviceInfoListener);
                this.swdlProgressListener = dSIProxyAdapterFactory.createDSIListenerMethodAdapter(this, class$org$dsi$ifc$swdlprogress$DSISwdlProgressListener == null ? (class$org$dsi$ifc$swdlprogress$DSISwdlProgressListener = AslTargetCarWorkshopDownload.class$("org.dsi.ifc.swdlprogress.DSISwdlProgressListener")) : class$org$dsi$ifc$swdlprogress$DSISwdlProgressListener);
                this.swdlLoggingListener = dSIProxyAdapterFactory.createDSIListenerMethodAdapter(this, class$org$dsi$ifc$swdllogging$DSISwdlLoggingListener == null ? (class$org$dsi$ifc$swdllogging$DSISwdlLoggingListener = AslTargetCarWorkshopDownload.class$("org.dsi.ifc.swdllogging.DSISwdlLoggingListener")) : class$org$dsi$ifc$swdllogging$DSISwdlLoggingListener);
                this.swdlSelectionListener = dSIProxyAdapterFactory.createDSIListenerMethodAdapter(this, class$org$dsi$ifc$swdlselection$DSISwdlSelectionListener == null ? (class$org$dsi$ifc$swdlselection$DSISwdlSelectionListener = AslTargetCarWorkshopDownload.class$("org.dsi.ifc.swdlselection.DSISwdlSelectionListener")) : class$org$dsi$ifc$swdlselection$DSISwdlSelectionListener);
                this.persistenceListener = dSIProxyAdapterFactory.createDSIListenerMethodAdapter(this, class$org$dsi$ifc$persistence$DSIPersistenceListener == null ? (class$org$dsi$ifc$persistence$DSIPersistenceListener = AslTargetCarWorkshopDownload.class$("org.dsi.ifc.persistence.DSIPersistenceListener")) : class$org$dsi$ifc$persistence$DSIPersistenceListener);
                dSIProxy.addResponseListener(this, class$org$dsi$ifc$swdldeviceinfo$DSISwdlDeviceInfoListener == null ? (class$org$dsi$ifc$swdldeviceinfo$DSISwdlDeviceInfoListener = AslTargetCarWorkshopDownload.class$("org.dsi.ifc.swdldeviceinfo.DSISwdlDeviceInfoListener")) : class$org$dsi$ifc$swdldeviceinfo$DSISwdlDeviceInfoListener, this.swdlDeviceInfoListener);
                dSIProxy.addResponseListener(this, class$org$dsi$ifc$swdlprogress$DSISwdlProgressListener == null ? (class$org$dsi$ifc$swdlprogress$DSISwdlProgressListener = AslTargetCarWorkshopDownload.class$("org.dsi.ifc.swdlprogress.DSISwdlProgressListener")) : class$org$dsi$ifc$swdlprogress$DSISwdlProgressListener, this.swdlProgressListener);
                dSIProxy.addResponseListener(this, class$org$dsi$ifc$swdllogging$DSISwdlLoggingListener == null ? (class$org$dsi$ifc$swdllogging$DSISwdlLoggingListener = AslTargetCarWorkshopDownload.class$("org.dsi.ifc.swdllogging.DSISwdlLoggingListener")) : class$org$dsi$ifc$swdllogging$DSISwdlLoggingListener, this.swdlLoggingListener);
                dSIProxy.addResponseListener(this, class$org$dsi$ifc$swdlselection$DSISwdlSelectionListener == null ? (class$org$dsi$ifc$swdlselection$DSISwdlSelectionListener = AslTargetCarWorkshopDownload.class$("org.dsi.ifc.swdlselection.DSISwdlSelectionListener")) : class$org$dsi$ifc$swdlselection$DSISwdlSelectionListener, this.swdlSelectionListener);
                dSIProxy.addResponseListener(this, class$org$dsi$ifc$persistence$DSIPersistenceListener == null ? (class$org$dsi$ifc$persistence$DSIPersistenceListener = AslTargetCarWorkshopDownload.class$("org.dsi.ifc.persistence.DSIPersistenceListener")) : class$org$dsi$ifc$persistence$DSIPersistenceListener, this.persistenceListener);
                this.trace("[AslTargetSWDL] Received POWER_ON");
                this.powerOnWasRecievedSoTargetMayWork = true;
                this.remainingItemsOfCurrentDownload = 0;
                this.helperMethodInitializeNecessaryDatapoolValues();
                this.initLogList();
                this.addObserver(1098324736);
                this.addObserver(-976868096);
                this.addObserver(-1043976960);
                this.addObserver(-1060754176);
                this.addObserver(839254080);
                this.registerService(1679303424);
                this.addObserver(1679303424);
                if (!this.initSwdlPending) break;
                this.initSwdlPending = false;
                this.dsiSwdlSelection.setNotification(new int[]{6, 3, 4}, this.swdlSelectionListener);
                this.requestVersionInformation();
                break;
            }
            case 2300004: {
                this.dsiSwdlProgressIndicatePopUp(eventGeneric.getInt(0), eventGeneric.getString(1), eventGeneric.getByte(2), eventGeneric.getInt(3), eventGeneric.getInt(4), eventGeneric.getString(5));
                break;
            }
            case 3000005: {
                if (eventGeneric.getObject(-976868096) == null) break;
                if (((DeviceInfo)eventGeneric.getObject((int)-976868096)).deviceID == 0L) {
                    if (!sourceViewIsShown) break;
                    this.info("[AslTargetSWDL] Source removed, rereading Media");
                    this.startTimer(-1501167360, (long)0, false);
                    break;
                }
                if (!sourceViewIsShown) break;
                this.info("[AslTargetSWDL] Source added, rereading Media in 3 seconds");
                this.startTimer(-1501167360, (long)0, false);
                break;
            }
            case 3000001: {
                lastKnownMediaDeviceList = (DeviceInfo[])eventGeneric.getObject(0);
                break;
            }
            case 3000000: {
                lastKnownMediaMediaList = (MediaInfo[])eventGeneric.getObject(0);
                break;
            }
            case 100006: {
                this.dsiSwdlSelection.getMedia();
                break;
            }
            case 1073743410: {
                this.processHmiSetterServicemodeChanged(eventGeneric.getInt(0));
                break;
            }
            case 1800001: {
                if (this.powerOnWasRecievedSoTargetMayWork) {
                    this.dsiSwdlSelection.setNotification(new int[]{6, 3, 4}, this.swdlSelectionListener);
                    this.requestVersionInformation();
                    break;
                }
                this.initSwdlPending = true;
                break;
            }
            case 100007: {
                cSwdlIsInhibited = false;
                break;
            }
            case 1073742114: {
                this.processHmiSetterStartDownload();
                break;
            }
            case 1073744455: {
                this.processHmiSetterToggleEthernetCifs();
                break;
            }
            case 1073744454: {
                this.processHmiSetterToggleEthernetNfs();
                break;
            }
            case 1073742128: {
                break;
            }
            case 1073742131: {
                this.processHmiSetterEditNwAddress();
                break;
            }
            case 1073742132: {
                this.processHmiSetterSetNwAddress(eventGeneric);
                break;
            }
            case 1073742133: {
                this.processHmiSetterSpellerDeleteChar();
                break;
            }
            case 1073742134: {
                this.processHmiSetterSpellerSetChar(eventGeneric);
                break;
            }
            case 1073742135: {
                this.processHmiSetterSetVersionBackDocumentation(eventGeneric);
                break;
            }
            case 1073742136: {
                this.processHmiSetterTriggerCustomerDownload();
                break;
            }
            case 1073742115: {
                this.processHmiSetterRestartSystem();
                break;
            }
            case 1073743799: {
                this.processHmiSetterRebootAfterBackDocumentation2();
                break;
            }
            case 1073742116: {
                this.processHmiSetterSelectSourceAndRequestSetMedium(eventGeneric);
                break;
            }
            case 100001: {
                if (this.releaseFoundOnMedium) {
                    this.trace("[AslTargetSWDL] Release Found on current device");
                    ServiceManager.eventDispatcher.createAndSubmitHMIEvent(21);
                    break;
                }
                this.trace("[AslTargetSWDL] There was no release on the device");
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(22);
                break;
            }
            case 1073742117: {
                this.processHmiSetterSelectRelease(eventGeneric);
                break;
            }
            case 1073742118: {
                this.processHmiSetterSelectDeviceAndRequestGetModules(eventGeneric);
                break;
            }
            case 1073742119: {
                this.processHmiSetterSelectModuleAndRequestAppAndBoloInformation(eventGeneric);
                break;
            }
            case 1073742120: {
                this.processHmiSetterSelectFirmwarePartAndRequestUpdateInfoLists(eventGeneric);
                break;
            }
            case 1073742121: {
                this.processHmiSetterRetryReadingMetaInfo();
                break;
            }
            case 1073742122: {
                this.processHmiSetterSetSelectedDownloadOptions(eventGeneric);
                break;
            }
            case 1073743798: {
                this.processHmiSetterSetSelectSourceViewState(eventGeneric);
                break;
            }
            case 1073742123: {
                this.processHmiSetterSelectLog(eventGeneric);
                break;
            }
            case 1073742124: {
                this.processHmiSetterSelectLoggedDevices(eventGeneric);
                break;
            }
            case 1073742125: {
                this.processHmiSetterSelectLoggedModule(eventGeneric);
                break;
            }
            case 1073742126: {
                this.processHmiSetterUserAbort(eventGeneric);
                break;
            }
            case 1073742127: {
                break;
            }
            case 1073742129: {
                this.processHmiSetterExitPowerstateSwdl();
                break;
            }
            case 1073742130: {
                this.processHmiSetterPrepareInstalledSoftware();
                break;
            }
            case 1073742137: {
                this.processHmiSetterEnterLogging();
                break;
            }
            case 1073742138: {
                this.trace("processHmiSetterExitLogging");
                this.loggingIsActive = false;
                break;
            }
            case 1073742139: {
                this.processHmiSetterSetPopupType(eventGeneric);
                break;
            }
            case 1073742140: {
                this.processHmiSetterSetPopupTypeButton(eventGeneric);
                break;
            }
            case 1073742141: {
                this.processHmiSetterSelectAll();
                break;
            }
            case 1073742142: {
                this.processHmiSetterDeSelectAll();
                break;
            }
            case 100004: {
                Identification identification;
                long l = eventGeneric.getLong(3);
                int n = eventGeneric.getInt(2);
                if (n != 553765890 || l != 0 || (identification = (Identification)eventGeneric.getObject(1)) == null) break;
                this.currentTrainVersion = new String(identification.getByteArray(840));
                if (!this.isTraceEnabled()) break;
                this.trace().append("Current train version detected via adaption: ").append(this.currentTrainVersion).log();
                break;
            }
            case 100005: {
                Iterator iterator = this.mDelayedPopupInfo.iterator();
                PopUpInfo popUpInfo = this.activePopupInfo;
                while (iterator.hasNext()) {
                    PopUpInfo popUpInfo2 = (PopUpInfo)iterator.next();
                    if (popUpInfo2.delayCount >= 3 && (popUpInfo == null || popUpInfo.prio < popUpInfo2.prio)) {
                        popUpInfo = popUpInfo2;
                    }
                    ++popUpInfo2.delayCount;
                }
                if (this.activePopupInfo != popUpInfo) {
                    int n;
                    if (this.activePopupInfo != null && (n = this.convertPopUpType2SystemEventClosed(this.activePopupInfo)) != -1) {
                        this.sendHMIEvent(n);
                    }
                    if (popUpInfo != null) {
                        this.processDelayedIndicatePopup(popUpInfo);
                    }
                }
                if (popUpInfo != null) {
                    this.mDelayedPopupInfo.remove(popUpInfo);
                }
                if (!this.mDelayedPopupInfo.isEmpty()) break;
                this.stopTimer(-1517944576);
                this.info("Stopping timer checking for reached popup delay.");
                break;
            }
            default: {
                this.trace("[AslTargetSWDL] default: ev.receiver.getEventId() = ", eventGeneric.getReceiverEventId());
            }
        }
    }

    @Override
    public int getSubClassifier() {
        return 4096;
    }

    @Override
    public int getDefaultTargetId() {
        return -1566764544;
    }

    public void dsiSwdlLoggingGetHistory(String[] stringArray, int[] nArray) {
        this.processDsiResponseGetHistory(stringArray, nArray);
    }

    public void dsiSwdlLoggingSetUpdate(int n) {
        this.processDsiResponseSetUpdate(n);
    }

    public void dsiSwdlLoggingGetGeneralInformation(boolean bl, String string, String string2, boolean bl2, String string3, String string4, int[] nArray, boolean bl3, int n, int[] nArray2) {
        this.trace("[AslTargetSWDL] dsiSwdlLoggingGetGeneralInformation");
    }

    public void dsiSwdlLoggingGetUnusualEvents(int[] nArray, String[] stringArray) {
        this.trace("[AslTargetSWDL] dsiSwdlLoggingGetUnusualEvents");
    }

    public void dsiSwdlLoggingGetUnusualEvent(int n, String string, String string2, String string3, byte by, int n2) {
        this.trace("[AslTargetSWDL] dsiSwdlLoggingGetUnusualEvent");
    }

    public void dsiSwdlDeviceInfoUpdateSummaryChanged(String string, int n) {
        if (n == 1) {
            this.processDsiUpdateSummaryChanged(string);
        }
    }

    public void dsiSwdlDeviceInfoGetDevices(String[] stringArray, int[] nArray) {
        this.processDsiResponseGetDevices(stringArray, nArray);
    }

    public void dsiSwdlDeviceInfoGetModules(int n, String[] stringArray, int[] nArray, short[] sArray) {
        this.processDsiResponseGetModules(n, stringArray, nArray, sArray);
    }

    public void dsiSwdlDeviceInfoGetLanguages(int n, String[] stringArray, short s, short s2, short s3) {
        this.trace("[AslTargetSWDL] dsiSwdlDeviceInfoGetLanguages");
    }

    public void dsiSwdlDeviceInfoGetErrors(int n, int[] nArray, short[] sArray) {
        this.trace("[AslTargetSWDL] dsiSwdlDeviceInfoGetErrors");
    }

    public void dsiSwdlDeviceInfoIsDataModule(int n, int n2, boolean bl) {
        this.processDsiResponseIsDataModule(n, n2, bl);
    }

    public void dsiSwdlDeviceInfoIsNoExclusiveBoloUpdate(int n, int n2, boolean bl) {
        this.processDsiResponseIsNoExclusiveBoloUpdate();
    }

    public void dsiSwdlDeviceInfoGetVersions(int n, int n2, long[] lArray) {
        this.processDsiResponseGetFirmwareVersions(n, n2, lArray);
    }

    public void dsiSwdlDeviceInfoGetTargetVersions(int n, int n2, long[] lArray) {
        this.processDsiResponseGetFirmwareTargetVersions(n, n2, lArray);
    }

    public void dsiSwdlDeviceInfoGetAdditionalInfo(int n, int n2, int[] nArray) {
        this.processDsiResponseGetFirmwareStatesOrAdditionalInfo(n, n2, nArray);
    }

    public void dsiSwdlDeviceInfoGetFileNames(int n, int n2, String[] stringArray) {
        this.processDsiResponseGetFileNames(n, n2, stringArray);
    }

    public void dsiSwdlDeviceInfoGetFileDetails(int n, int n2, int n3, long l, long l2, long l3, boolean bl, boolean bl2, String string, String string2) {
        this.trace("[AslTargetSWDL] dsiSwdlDeviceInfoGetFileDetails");
    }

    public void dsiSwdlDeviceInfoGetInfoFilePath(int n, String string, String string2) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetSWDL] dsiSwdlDeviceInfoGetInfoFilePath \r\nDevice: ").append(n).append("\r\nSrc: ").append(string).append("\r\nTgt: ").append(string2).log();
        }
    }

    public void dsiSwdlProgressUpdateGeneralProgress(GeneralProgress generalProgress, int n) {
        if (n == 1) {
            this.processDsiUpdateGeneralDownloadProgress(generalProgress);
        }
    }

    public void dsiSwdlProgressUpdateDevicesOverviewProgress(DeviceOverviewProgress[] deviceOverviewProgressArray, int n) {
        if (n == 1) {
            this.processDsiUpdateDeviceOverviewProgress(deviceOverviewProgressArray);
        }
    }

    public void dsiSwdlProgressUpdateTriggerPanel(int n, int n2) {
        if (n2 == 1) {
            this.processDsiUpdateTriggerPanel(n);
        }
    }

    public void dsiSwdlProgressUpdateLostDevices(String[] stringArray, int n) {
        if (n == 1) {
            this.processDsiUpdateLostOrUnreadyDevices(stringArray);
        }
    }

    public void dsiSwdlProgressUpdateOverviewStatus(int n, int n2) {
        if (n2 == 1) {
            this.trace("[AslTargetSWDL] dsiSwdlProgressUpdateOverviewStatus");
        }
    }

    public void dsiSwdlProgressUpdateActiveDevices(String[] stringArray, int n) {
        if (n == 1) {
            this.processDsiUpdateCurrentDevices(stringArray, n);
        }
    }

    public void dsiSwdlProgressGetStaticProgressDetails(int n, int n2, short s, String string) {
        this.trace("[AslTargetSWDL] dsiSwdlProgressGetStaticProgressDetails");
    }

    public void dsiSwdlProgressGetDynamicProgressDetails(int n, byte by, String string) {
        this.trace("[AslTargetSWDL] dsiSwdlProgressGetDynamicProgressDetails");
    }

    public void dsiSwdlProgressIndicatePopUp(int n, String string, byte by, int n2, int n3, String string2) {
        if (cSwdlIsRunning) {
            this.info("cSWDL is running, preventing popup");
            return;
        }
        PopUpInfo popUpInfo = new PopUpInfo(n, string, by, n2, n3, string2);
        this.mDelayedPopupInfo.add(popUpInfo);
        this.retriggerOrStartTimer(-1517944576, (long)0, true);
    }

    public void dsiSwdlProgressIndicateDismissPopUp(int n, String string) {
        this.processDsiUpdateIndicateDismissPopup(n, string);
    }

    public void dsiSwdlSelectionUpdateLameClients(LameClient[] lameClientArray, int n) {
        if (n == 1) {
            this.trace("[AslTargetSWDL] dsiSwdlSelectionUpdateLameClients");
        }
    }

    public void dsiSwdlSelectionUpdateEngineering(boolean bl, int n) {
        if (n == 1) {
            this.trace("[AslTargetSWDL] dsiSwdlSelectionUpdateEngineering");
        }
    }

    public void dsiSwdlSelectionUpdateUserSwdl(boolean bl, int n) {
        if (n == 1) {
            this.trace("[AslTargetSWDL] dsiSwdlSelectionUpdateUserSwdl");
            if (!bl && !this.notificationForNormalSwdlAreSet) {
                this.info("[AslTargetSWDL] normal SWDL detected .. setting notifications");
                this.dsiSwdlDeviceInfo.setNotification(1, this.swdlDeviceInfoListener);
                this.dsiSwdlProgress.setNotification(new int[]{3, 5, 6, 2, 1, 4}, this.swdlProgressListener);
                this.notificationForNormalSwdlAreSet = true;
            } else if (bl && this.notificationForNormalSwdlAreSet) {
                this.info("[AslTargetSWDL] user SWDL detected .. clearing notifications");
                this.dsiSwdlDeviceInfo.clearNotification(1, this.swdlDeviceInfoListener);
                this.dsiSwdlProgress.clearNotification(new int[]{3, 5, 6, 2, 1, 4}, this.swdlProgressListener);
                this.notificationForNormalSwdlAreSet = false;
            }
            if (this.aslStartupv7rAPI.isNonCustomerSwdlIsInProgress() && !this.initiallySent) {
                dsiSwdlHasFocus = true;
                this.dsiSwdlSelection.setGotFocus(true);
                this.dsiSwdlSelection.setUserSwdl(bl);
                this.initiallySent = true;
            }
        }
    }

    public void dsiSwdlSelectionUpdateRingNotOK(boolean bl, int n) {
        if (n == 1) {
            this.trace("[AslTargetSWDL] dsiSwdlSelectionUpdateRingNotOK");
        }
    }

    public void dsiSwdlSelectionUpdateEndDownload(boolean bl, int n) {
        if (n == 1) {
            this.trace("[AslTargetSWDL] dsiSwdlSelectionUpdateEndDownload");
        }
    }

    public void dsiSwdlSelectionUpdateAvailableMedia(byte by, int n) {
        if (n == 1) {
            this.processDsiUpdateAvailableMedia(by);
        }
    }

    public void dsiSwdlSelectionUpdateUnitType(int n, int n2) {
        if (n2 == 1) {
            this.trace("[AslTargetSWDL] dsiSwdlSelectionUpdateUnitType");
        }
    }

    public void dsiSwdlSelectionGetMedia(int[] nArray) {
        this.processDsiResponseGetMedia(nArray);
    }

    public void dsiSwdlSelectionStoreNfsIpAddress(String string) {
        this.processDsiResponseStoreNfsIpAddress(string);
    }

    public void dsiSwdlSelectionStoreNfsPath(String string) {
    }

    public void dsiSwdlSelectionStoreFsPath(String string) {
    }

    public void dsiSwdlSelectionSetMedium(int n, String string, String[] stringArray) {
        this.processDsiResponseSetMediumAndRequestAvailableReleaseNames(n, string, stringArray);
    }

    public void dsiSwdlSelectionSetRelease(int n, String string) {
        this.processDsiResponseSetReleaseAndRequestUserDefinedAllowed(n, string);
    }

    public void dsiSwdlSelectionGetUserDefinedAllowed(boolean bl) {
        this.processDsiUpdateIsUserDefinedAllowedAndRequestSetAccessTypeAndGetDevices(bl);
    }

    public void dsiSwdlSelectionSetTargetLanguage(short s) {
        this.trace("[AslTargetSWDL] dsiSwdlSelectionSetTargetLanguage");
    }

    public void dsiSwdlSelectionGetIncompatibleDevices(String[] stringArray, String[] stringArray2) {
        this.trace("[AslTargetSWDL] dsiSwdlSelectionGetIncompatibleDevices");
    }

    public void dsiSwdlSelectionStartVersionUpload(boolean bl) {
        this.trace("[AslTargetSWDL] dsiSwdlSelectionStartVersionUpload");
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(431);
    }

    public void dsiSwdlSelectionCheckConsistency(int n, boolean bl, String string, int n2) {
        this.processDsiResponseCheckConsistency(n, bl, string, n2);
    }

    public void dsiSwdlSelectionAbortSetMedium() {
        this.trace("[AslTargetSWDL] dsiSwdlSelectionAbortSetMedium");
        this.setMediumIsPending = true;
        this.dsiSwdlSelection.setMedium(this.activeSourceMediumId);
    }

    public void dsiSwdlSelectionAbortSetRelease() {
        this.trace("[AslTargetSWDL] dsiSwdlSelectionAbortSetRelease");
    }

    public void dsiSwdlSelectionGetFinalizeTargets(int[] nArray) {
        this.trace("[AslTargetSWDL] dsiSwdlSelectionGetFinalizeTargets");
    }

    public void dsiSwdlSelectionSetFinalizeTarget(int n, long l, long l2, long l3) {
        this.trace("[AslTargetSWDL] dsiSwdlSelectionSetFinalizeTarget");
    }

    public void dsiPersistenceReadBuffer(int n, long l, byte[] byArray, int n2) {
        if (n2 == 0) {
            if (n == 30 || n == 553765890) {
                if (l == 0) {
                    if (byArray.length >= 29) {
                        StringBuffer stringBuffer = new StringBuffer(29);
                        for (int i2 = 0; i2 < byArray.length; ++i2) {
                            stringBuffer.append((char)byArray[i2]);
                        }
                        this.info("STD_KEY_MU_VERSION: ", stringBuffer.toString());
                        if (this.helperMethodCheckIfHumanReadableAlphabetWasUsed(byArray[22]) && this.helperMethodCheckIfHumanReadableAlphabetWasUsed(byArray[23]) && this.helperMethodCheckIfHumanReadableAlphabetWasUsed(byArray[24]) && this.helperMethodCheckIfHumanReadableAlphabetWasUsed(byArray[25])) {
                            stringBuffer = new StringBuffer(4);
                            stringBuffer.append((char)byArray[22]).append((char)byArray[23]).append((char)byArray[24]).append((char)byArray[25]);
                            if (this.installedFwCollector[0].dataVersion.equals("")) {
                                this.installedFwCollector[0].dataVersion = "N/A";
                            }
                            this.installedFwCollector[1].dataVersion = stringBuffer.toString();
                            this.propertyManager.valueChangedString(1627, stringBuffer.toString());
                            stringBuffer = new StringBuffer();
                            stringBuffer.append(this.installedFwCollector[0].dataVersion).append(" (").append(this.installedFwCollector[1].dataVersion).append(")");
                            this.nameOfCurrentlyInstalledRelease = stringBuffer.toString();
                        } else {
                            this.installedFwCollector[0].dataVersion = "DIAG ERROR";
                            this.installedFwCollector[1].dataVersion = "DIAG ERROR";
                            this.propertyManager.valueChangedString(1627, "DIAG ERROR");
                        }
                        ListManager.getGenericASLList(402).updateList(this.installedFwCollector);
                        if (!(this.helperMethodCheckIfHumanReadableAlphabetWasUsed(byArray[26]) && this.helperMethodCheckIfHumanReadableAlphabetWasUsed(byArray[27]) && this.helperMethodCheckIfHumanReadableAlphabetWasUsed(byArray[28]))) {
                            this.propertyManager.valueChangedString(1606, "DIAG ERROR");
                        }
                    } else {
                        this.installedFwCollector[0].dataVersion = "DIAG ERROR";
                        this.installedFwCollector[1].dataVersion = "DIAG ERROR";
                        ListManager.getGenericASLList(402).updateList(this.installedFwCollector);
                        this.propertyManager.valueChangedString(1627, "DIAG ERROR");
                        this.propertyManager.valueChangedString(1606, "DIAG ERROR");
                        this.error("Length mismatch in STD_NAMESPACE_MU_AND_TRAIN / STD_KEY_MU_VERSION: too short!");
                    }
                } else if (l == 0 && n == 553765890) {
                    StringBuffer stringBuffer = new StringBuffer(byArray.length);
                    for (int i3 = 0; i3 < byArray.length; ++i3) {
                        stringBuffer.append((char)byArray[i3]);
                    }
                    this.installedFwCollector[0].dataVersion = stringBuffer.toString();
                    if (this.installedFwCollector[0].dataVersion.equals("")) {
                        this.installedFwCollector[0].dataVersion = "N/A";
                    }
                    this.info("STD_KEY_TRAIN_VERSION: ", this.installedFwCollector[0].dataVersion);
                    ListManager.getGenericASLList(402).updateList(this.installedFwCollector);
                    stringBuffer = new StringBuffer();
                    stringBuffer.append(this.installedFwCollector[0].dataVersion).append(" (").append(this.installedFwCollector[1].dataVersion).append(")");
                    this.nameOfCurrentlyInstalledRelease = stringBuffer.toString();
                }
            } else if (n == 570543106 && l == 0) {
                this.addCustomerVersion(n, byArray, "Bluetooth version");
            } else if (n == 587320322 && l == 0) {
                this.addCustomerVersion(n, byArray, "Radio database version");
            } else if (n == 604097538 && l == 0) {
                if (this.configManagerDiag.isFeatureFlagSet(353)) {
                    this.addCustomerVersion(n, byArray, "Full Link");
                } else if (this.configManagerDiag.isFeatureFlagSet(360)) {
                    this.addCustomerVersion(n, byArray, "SmartLink");
                } else {
                    this.addCustomerVersion(n, byArray, "App-Connect");
                }
            } else if (n == 620874754 && l == 0) {
                this.addCustomerVersion(n, byArray, "USB surfstick version");
            } else if (n == 637651970 && l == 0) {
                this.addCustomerVersion(n, byArray, "PersonalPOI version");
            } else if (n == 654429186 && l == 0) {
                this.addCustomerVersion(n, byArray, "NavCardUpdate version");
            } else if (n == 671206402 && l == 0) {
                this.addCustomerVersion(n, byArray, "Gracenote version");
            }
        }
    }

    public void dsiPersistenceReadString(int n, long l, String string, int n2) {
        if (n2 == 0) {
            if (n == 30 || n == 553765890) {
                if (l == 0) {
                    this.installedFwCollector[1].dataVersion = string;
                    ListManager.getGenericASLList(402).updateList(this.installedFwCollector);
                    this.propertyManager.valueChangedString(1627, string);
                    this.trace("Current Value MU:", string);
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(this.installedFwCollector[0].dataVersion).append(" (").append(this.installedFwCollector[1].dataVersion).append(")");
                    this.nameOfCurrentlyInstalledRelease = stringBuffer.toString();
                } else if (l == 0) {
                    this.installedFwCollector[0].dataVersion = string;
                    this.nameOfCurrentlyInstalledRelease = string;
                    ListManager.getGenericASLList(402).updateList(this.installedFwCollector);
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(this.installedFwCollector[0].dataVersion).append(" (").append(this.installedFwCollector[1].dataVersion).append(")");
                    this.nameOfCurrentlyInstalledRelease = stringBuffer.toString();
                    this.trace("Current Value Train:", string);
                }
            }
        } else {
            this.warn().append("[SWDL]Error occured while reading NS ").append(n).append(" KEY ").append(l).append(" [ERROR: ").append(n2).append("]").log();
        }
    }

    private void addCustomerVersion(int n, byte[] byArray, String string) {
        StringBuffer stringBuffer = new StringBuffer(byArray.length);
        for (int i2 = 0; i2 < byArray.length; ++i2) {
            stringBuffer.append((char)byArray[i2]);
        }
        this.trace(new StringBuffer().append("[AslTargetSWDL]").append(string).append(" Received: ").append(Arrays.toString(byArray)).append(" Buffer Len:").append(stringBuffer.toString().length()).toString());
        String string2 = stringBuffer.toString().trim();
        if (string2.length() > 0) {
            this.customerVersions.append(new StringBuffer().append(string).append(":\n").toString());
            this.customerVersions.append(new StringBuffer().append(string2).append("\n").toString());
            this.propertyManager.valueChangedString(1177690112, this.customerVersions.toString());
        }
    }

    private void updateHmiListGetInstalledSW() {
        this.trace("[AslTargetSWDL] updateHmiListGetInstalledSW");
        Object[] objectArray = new SwdlUpdateDataCollector[]{new SwdlUpdateDataCollector()};
        objectArray[0].dataMarkerDataInSlotIsCurrentVersion = !this.summaryReachedSendNoRemainingUpdate;
        objectArray[0].dataName = "";
        objectArray[0].dataVersion = "";
        objectArray[0].dataTargetVersion = this.nameOfCurrentlyInstalledRelease;
        ListManager.getGenericASLList(406).updateList(objectArray);
    }

    private void updateHmiListGetUpdateableDevices(SwdlUpdateDataCollector[] swdlUpdateDataCollectorArray) {
        this.trace("[AslTargetSWDL] updateHmiListGetUpdateableDevices");
        ListManager.getGenericASLList(403).updateList(swdlUpdateDataCollectorArray);
        ListManager.getGenericASLList(-1733616128).updateList(swdlUpdateDataCollectorArray);
    }

    private void updateHmiListLoggedFirmwarePart(SwdlUpdateDataCollector[] swdlUpdateDataCollectorArray) {
        if (this.loggingIsActive && this.currentSwdlAccessType == 1) {
            for (int i2 = 0; i2 < swdlUpdateDataCollectorArray.length; ++i2) {
                swdlUpdateDataCollectorArray[i2].dataState = 4;
                swdlUpdateDataCollectorArray[i2].plannedResult = 4;
                swdlUpdateDataCollectorArray[i2].dataTargetVersion = "";
            }
        }
        ListManager.getGenericASLList(409).updateList(swdlUpdateDataCollectorArray);
        ListManager.getGenericASLList(-1750393344).updateList(swdlUpdateDataCollectorArray);
    }

    private void updateHmiListGetLoggingList(String[] stringArray, int[] nArray) {
        this.trace("[AslTargetSWDL] updateHmiListGetLoggingList");
        this.loggedUpdatesStringArray = stringArray;
        int n = this.loggedUpdatesStringArray.length;
        Object[] objectArray = new SwdlUpdateDataCollector[n + 1];
        String string = "";
        if (n <= 0) {
            boolean bl = false;
            objectArray = new SwdlUpdateDataCollector[]{new SwdlUpdateDataCollector()};
            objectArray[0].dataMarkerDataInSlotIsCurrentVersion = false;
            objectArray[0].dataName = "";
            objectArray[0].dataVersion = "";
            objectArray[0].dataTargetVersion = this.nameOfCurrentlyInstalledRelease;
            string = "";
        } else if (this.aslStartupv7rAPI.isHighActivatorStarted()) {
            boolean bl = false;
            int n2 = 0;
            for (int i2 = n - 1; i2 > 0 && !bl; --i2) {
                if (this.loggedUpdatesStringArray[i2].indexOf("User:") != -1) continue;
                bl = true;
                n2 = i2;
                break;
            }
            objectArray[0] = new SwdlUpdateDataCollector();
            StringTokenizer stringTokenizer = new StringTokenizer(this.loggedUpdatesStringArray[n2], " ");
            String string2 = stringTokenizer.nextToken();
            String string3 = stringTokenizer.nextToken();
            String string4 = this.loggedUpdatesStringArray[n2].substring(string2.length() + string3.length() + 2);
            ((SwdlUpdateDataCollector)objectArray[0]).dataMarkerDataInSlotIsCurrentVersion = !this.summaryReachedSendNoRemainingUpdate;
            ((SwdlUpdateDataCollector)objectArray[0]).dataName = new StringBuffer().append(string2).append(" ").append(string3).toString();
            ((SwdlUpdateDataCollector)objectArray[0]).dataVersion = string;
            ((SwdlUpdateDataCollector)objectArray[0]).dataTargetVersion = this.nameOfCurrentlyInstalledRelease;
            for (int i3 = 0; i3 < n; ++i3) {
                int n3 = objectArray.length - (i3 + 1);
                objectArray[n3] = new SwdlUpdateDataCollector();
                stringTokenizer = new StringTokenizer(this.loggedUpdatesStringArray[i3], " ");
                string2 = stringTokenizer.nextToken();
                string3 = stringTokenizer.nextToken();
                string4 = this.loggedUpdatesStringArray[i3].substring(string2.length() + string3.length() + 2);
                ((SwdlUpdateDataCollector)objectArray[n3]).dataMarkerDataInSlotIsCurrentVersion = false;
                ((SwdlUpdateDataCollector)objectArray[n3]).dataName = new StringBuffer().append(string2).append(" ").append(string3).toString();
                ((SwdlUpdateDataCollector)objectArray[n3]).dataVersion = string;
                ((SwdlUpdateDataCollector)objectArray[n3]).dataTargetVersion = string4;
                string = string4;
            }
        } else {
            objectArray[0] = new SwdlUpdateDataCollector();
            StringTokenizer stringTokenizer = new StringTokenizer(this.loggedUpdatesStringArray[0], " ");
            String string5 = stringTokenizer.nextToken();
            String string6 = stringTokenizer.nextToken();
            String string7 = this.loggedUpdatesStringArray[0].substring(string5.length() + string6.length() + 2);
            ((SwdlUpdateDataCollector)objectArray[0]).dataMarkerDataInSlotIsCurrentVersion = !this.summaryReachedSendNoRemainingUpdate;
            ((SwdlUpdateDataCollector)objectArray[0]).dataName = new StringBuffer().append(string5).append(" ").append(string6).toString();
            ((SwdlUpdateDataCollector)objectArray[0]).dataVersion = string;
            ((SwdlUpdateDataCollector)objectArray[0]).dataTargetVersion = this.nameOfCurrentlyInstalledRelease;
            for (int i4 = n; i4 >= 1; --i4) {
                objectArray[i4] = new SwdlUpdateDataCollector();
                stringTokenizer = new StringTokenizer(this.loggedUpdatesStringArray[i4 - 1], " ");
                string5 = stringTokenizer.nextToken();
                string6 = stringTokenizer.nextToken();
                string7 = this.loggedUpdatesStringArray[i4 - 1].substring(string5.length() + string6.length() + 2);
                ((SwdlUpdateDataCollector)objectArray[i4]).dataMarkerDataInSlotIsCurrentVersion = false;
                ((SwdlUpdateDataCollector)objectArray[i4]).dataName = new StringBuffer().append(string5).append(" ").append(string6).toString();
                ((SwdlUpdateDataCollector)objectArray[i4]).dataVersion = string;
                ((SwdlUpdateDataCollector)objectArray[i4]).dataTargetVersion = string7;
                string = string7;
            }
        }
        ListManager.getGenericASLList(406).updateList(objectArray);
    }

    private void updateHmiListGetLoggedDevices(SwdlUpdateDataCollector[] swdlUpdateDataCollectorArray) {
        this.trace("[AslTargetSWDL] updateHmiListGetLoggedDevices");
        ListManager.getGenericASLList(407).updateList(swdlUpdateDataCollectorArray);
        ListManager.getGenericASLList(-1700061696).updateList(swdlUpdateDataCollectorArray);
    }

    private void processHmiSetterToggleEthernetCifs() {
        this.trace("[AslTargetSWDL] processHmiSetterToggleEthernetCifs");
        this.useCifsForEthernetIfTrueElseNfs = true;
        AslTargetCarWorkshopDownload.writeBooleanToDatapool(3680, this.useCifsForEthernetIfTrueElseNfs);
        AslTargetCarWorkshopDownload.writeBooleanToDatapool(3681, !this.useCifsForEthernetIfTrueElseNfs);
    }

    private void processHmiSetterToggleEthernetNfs() {
        this.trace("[AslTargetSWDL] processHmiSetterToggleEthernetNfs");
        this.useCifsForEthernetIfTrueElseNfs = false;
        AslTargetCarWorkshopDownload.writeBooleanToDatapool(3680, this.useCifsForEthernetIfTrueElseNfs);
        AslTargetCarWorkshopDownload.writeBooleanToDatapool(3681, !this.useCifsForEthernetIfTrueElseNfs);
    }

    private void processHmiSetterEditNwAddress() {
        this.trace("[AslTargetSWDL] processEditNwAddress");
        this.helperMethodStartCustomerSwdlInhibitTimer();
    }

    private void processHmiSetterEnterLogging() {
        this.trace("processHmiSetterEnterLogging");
        this.helperMethodStartCustomerSwdlInhibitTimer();
        this.loggingIsActive = true;
        this.dsiSwdlLogging.getHistory();
    }

    private void processHmiSetterExitPowerstateSwdl() {
        this.info("[AslTargetSWDL] processHmiSetterExitPowerstateSwdl");
        this.dsiSwdlSelection.abortVersionUpload();
    }

    private void processHmiSetterPrepareInstalledSoftware() {
        this.trace("[AslTargetSWDL] processHmiSetterPrepareInstalledSoftware");
        this.helperMethodStartCustomerSwdlInhibitTimer();
        if (this.aslStartupv7rAPI.isHighActivatorStarted()) {
            swdlHighOmitPowerStateChangeIndicationUntilStartSwdlWasCalled = true;
        }
        AslTargetCarWorkshopDownload.writeBooleanToDatapool(368, true);
        this.updateHmiListGetInstalledSW();
        this.dsiSwdlSelection.getMedia();
        this.updateHmiGetterGetNWAddress("Set IP Address");
    }

    private void processHmiSetterRestartSystem() {
        this.trace("[AslTargetSWDL] processHmiSetterRestartSystem");
        ((DSIPowerManagement)DSIProxyFactory.getDSIProxyAPI().getDSIProxy().getService(this, class$org$dsi$ifc$powermanagement$DSIPowerManagement == null ? (class$org$dsi$ifc$powermanagement$DSIPowerManagement = AslTargetCarWorkshopDownload.class$("org.dsi.ifc.powermanagement.DSIPowerManagement")) : class$org$dsi$ifc$powermanagement$DSIPowerManagement)).rebootSystem();
    }

    private void processHmiSetterRebootAfterBackDocumentation2() {
        this.trace("[AslTargetSWDL] rebootAfterBackDocumentation2");
        this.dsiSwdlSelection.endVersionUpload();
    }

    private void processHmiSetterRetryReadingMetaInfo() {
        this.trace("[AslTargetSWDL] processHmiSetterRetryReadingMetaInfo");
        this.helperMethodStartCustomerSwdlInhibitTimer();
        if (!this.setMediumIsPending) {
            this.setMediumIsPending = true;
            this.dsiSwdlSelection.setMedium(this.activeSourceMediumId);
        } else {
            this.retryReadingMetaInfoWasRequestedStartSetMediumImmediately = true;
        }
    }

    private void processHmiSetterSelectDeviceAndRequestGetModules(EventGeneric eventGeneric) {
        this.trace("[AslTargetSWDL] processHmiSetterSelectDeviceAndRequestGetModules");
        this.helperMethodStartCustomerSwdlInhibitTimer();
        this.currentlySelectedDeviceId = (short)eventGeneric.getInt(0);
        this.dsiSwdlDeviceInfo.getModules(this.currentlySelectedDeviceId);
    }

    private void processHmiSetterSelectFirmwarePartAndRequestUpdateInfoLists(EventGeneric eventGeneric) {
        this.trace("[AslTargetSWDL] processHmiSetterSelectFirmwarePart;toggleSelection on ", eventGeneric.getInt(0));
        this.helperMethodStartCustomerSwdlInhibitTimer();
        this.dsiSwdlDeviceInfo.toggleSelection(this.currentlySelectedDeviceId, this.currentlySelectedModuleId, (short)eventGeneric.getInt(0));
        this.inhibitMetainfoSuccessEvent = true;
        this.dsiSwdlDeviceInfo.getDevices();
        this.dsiSwdlDeviceInfo.getModules(this.currentlySelectedDeviceId);
        this.dsiSwdlDeviceInfo.getAdditionalInfo(this.currentlySelectedDeviceId, this.currentlySelectedModuleId);
        this.dsiSwdlSelection.checkConsistency();
    }

    private void processHmiSetterSelectLog(EventGeneric eventGeneric) {
        this.trace("[AslTargetSWDL] processHmiSetterSelectLog with currentAccessType", this.currentSwdlAccessType);
        this.helperMethodStartCustomerSwdlInhibitTimer();
        int n = eventGeneric.getInt(0);
        if (this.loggingIsActive && n == 0) {
            this.currentSwdlAccessType = 1;
            this.dsiSwdlDeviceInfo.setAccessType(this.currentSwdlAccessType);
            this.dsiSwdlDeviceInfo.getDevices();
        } else {
            if (this.currentSwdlAccessType == 1 || this.currentSwdlAccessType == 0) {
                this.currentSwdlAccessType = 4;
                this.dsiSwdlDeviceInfo.setAccessType(this.currentSwdlAccessType);
            }
            if (this.currentSwdlAccessType == 4 || this.currentSwdlAccessType == 3) {
                if (this.aslStartupv7rAPI.isHighActivatorStarted()) {
                    this.dsiSwdlLogging.setUpdate(this.loggedUpdatesStringArray[this.loggedUpdatesStringArray.length - n]);
                } else {
                    this.dsiSwdlLogging.setUpdate(this.loggedUpdatesStringArray[n - 1]);
                }
                this.dsiSwdlLogging.getGeneralInformation();
            }
        }
    }

    private void processHmiSetterSelectLoggedDevices(EventGeneric eventGeneric) {
        this.trace("[AslTargetSWDL] processHmiSetterSelectLoggedDevices");
        this.helperMethodStartCustomerSwdlInhibitTimer();
        this.currentlySelectedDeviceId = eventGeneric.getInt(0);
        this.dsiSwdlDeviceInfo.getModules(this.currentlySelectedDeviceId);
    }

    private void processHmiSetterSelectLoggedModule(EventGeneric eventGeneric) {
        this.trace("[AslTargetSWDL] processHmiSetterSelectLoggedModule");
        this.helperMethodStartCustomerSwdlInhibitTimer();
        this.currentlySelectedModuleId = eventGeneric.getInt(0);
        this.dsiSwdlDeviceInfo.isDataModule(this.currentlySelectedDeviceId, this.currentlySelectedModuleId);
    }

    private void processHmiSetterSelectModuleAndRequestAppAndBoloInformation(EventGeneric eventGeneric) {
        this.trace("[AslTargetSWDL] processHmiSetterSelectModuleAndRequestAppAndBoloInformation");
        this.helperMethodStartCustomerSwdlInhibitTimer();
        this.firmwarePartUpdateCollector = null;
        this.currentlySelectedModuleId = eventGeneric.getInt(0);
        this.dsiSwdlDeviceInfo.isDataModule(this.currentlySelectedDeviceId, this.currentlySelectedModuleId);
        this.dsiSwdlDeviceInfo.getVersions(this.currentlySelectedDeviceId, this.currentlySelectedModuleId);
        this.dsiSwdlDeviceInfo.getTargetVersions(this.currentlySelectedDeviceId, this.currentlySelectedModuleId);
        this.dsiSwdlDeviceInfo.getAdditionalInfo(this.currentlySelectedDeviceId, this.currentlySelectedModuleId);
        this.dsiSwdlDeviceInfo.isNoExclusiveBoloUpdate(this.currentlySelectedDeviceId, this.currentlySelectedModuleId);
    }

    private void processHmiSetterSelectRelease(EventGeneric eventGeneric) {
        this.trace("[AslTargetSWDL] processHmiSetterSelectRelease");
        this.helperMethodStartCustomerSwdlInhibitTimer();
        if (this.activeSourceMediumId != -1) {
            this.inhibitMetainfoSuccessEvent = false;
            this.dsiSwdlSelection.abortSetRelease();
            this.dsiSwdlSelection.setRelease(eventGeneric.getInt(0));
        } else {
            this.error("[AslTargetSWDL] No source was selected before, aborting selectRelease call!");
        }
    }

    private void processHmiSetterSelectSourceAndRequestSetMedium(EventGeneric eventGeneric) {
        this.trace("[AslTargetSWDL] processHmiSetterSelectSourceAndRequestSetMedium");
        this.helperMethodStartCustomerSwdlInhibitTimer();
        this.helperMethodCheckMediaDataForSdCards();
        dsiSwdlHasFocus = true;
        this.dsiSwdlSelection.setGotFocus(true);
        this.dsiSwdlSelection.setUserSwdl(false);
        this.selectedActiveSourceMediumId(eventGeneric);
        if (this.activeSourceMediumId != -1) {
            this.dsiSwdlSelection.abortSetMedium();
        }
    }

    private void selectedActiveSourceMediumId(EventGeneric eventGeneric) {
        switch (eventGeneric.getInt(0)) {
            case 0: {
                this.trace("[AslTargetSWDL] selected medium is: CD");
                this.activeSourceMediumId = 2;
                break;
            }
            case 1: {
                this.trace("[AslTargetSWDL] selected medium is: USB");
                this.activeSourceMediumId = 3;
                break;
            }
            case 2: {
                if (!sdCardOneIsAvailable && sdCardTwoIsAvailable) {
                    this.trace("[AslTargetSWDL] selected medium is: SDCard2");
                    this.activeSourceMediumId = 5;
                    break;
                }
                this.trace("[AslTargetSWDL] selected medium is: SDCard1");
                this.activeSourceMediumId = 4;
                break;
            }
            case 3: {
                this.trace("[AslTargetSWDL] selected medium is: NFS");
                this.activeSourceMediumId = 1;
                break;
            }
            default: {
                this.trace("[AslTargetSWDL] default case: activeSourceMedium=", this.activeSourceMediumId);
                this.error("[AslTargetSWDL] Wrong Enum Id, won't send selectMedium to DSI!");
                this.activeSourceMediumId = -1;
            }
        }
    }

    private void helperMethodInitializeNecessaryDatapoolValues() {
        AslTargetCarWorkshopDownload.writeIntegerToDatapool(379, this.remainingItemsOfCurrentDownload);
        AslTargetCarWorkshopDownload.writeBooleanToDatapool(378, false);
        AslTargetCarWorkshopDownload.writeBooleanToDatapool(373, false);
        ListManager.getGenericASLList(399).updateList(new Boolean[]{Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE});
        AslTargetCarWorkshopDownload.writeBooleanToDatapool(3680, this.useCifsForEthernetIfTrueElseNfs);
        AslTargetCarWorkshopDownload.writeBooleanToDatapool(3681, !this.useCifsForEthernetIfTrueElseNfs);
    }

    private void helperMethodCheckMediaDataForSdCards() {
        this.trace("[AslTargetSWDL] helperMethodCheckMediaData");
        long[] lArray = new long[]{-1L, -1L};
        int n = 0;
        boolean bl = false;
        boolean bl2 = false;
        if (lastKnownMediaDeviceList != null) {
            int n2;
            for (n2 = 0; n2 < lastKnownMediaDeviceList.length; ++n2) {
                if (AslTargetCarWorkshopDownload.lastKnownMediaDeviceList[n2].deviceType != 1) continue;
                lArray[n] = AslTargetCarWorkshopDownload.lastKnownMediaDeviceList[n2].deviceID;
                ++n;
            }
            n = 0;
            if (lastKnownMediaMediaList != null) {
                for (n2 = 0; n2 < lastKnownMediaMediaList.length; ++n2) {
                    if (lArray[0] == AslTargetCarWorkshopDownload.lastKnownMediaMediaList[n2].deviceID && AslTargetCarWorkshopDownload.lastKnownMediaMediaList[n2].mediaType == 17) {
                        this.trace("Update found in SD1");
                        bl = true;
                    }
                    if (lArray[1] != AslTargetCarWorkshopDownload.lastKnownMediaMediaList[n2].deviceID || AslTargetCarWorkshopDownload.lastKnownMediaMediaList[n2].mediaType != 17) continue;
                    this.trace("Update found in SD2");
                    bl2 = true;
                }
            }
        }
        sdCardOneIsAvailable = bl;
        sdCardTwoIsAvailable = bl2;
    }

    private void processHmiSetterSetNwAddress(EventGeneric eventGeneric) {
        this.trace("[AslTargetSWDL] processHmiSetterSetNwAddress");
        this.helperMethodStartCustomerSwdlInhibitTimer();
        String string = this.actualIpAddress.toString();
        if (this.useCifsForEthernetIfTrueElseNfs) {
            this.dsiSwdlSelection.storeCifsServer(new StringBuffer().append("CIFS:").append(string).toString());
            this.dsiSwdlSelection.storeCifsPath("\\CIFS");
            this.dsiSwdlSelection.storeCifsUser("Gast");
            this.dsiSwdlSelection.storeCifsPassword("");
        } else {
            this.dsiSwdlSelection.storeNfsIpAddress(string);
            this.dsiSwdlSelection.storeNfsPath("/NFS");
        }
        this.updateHmiGetterGetNWAddress(string);
    }

    private void processHmiSetterSetSelectedDownloadOptions(EventGeneric eventGeneric) {
        this.trace("[AslTargetSWDL] processSetSelectedDownloadOptions");
        this.helperMethodStartCustomerSwdlInhibitTimer();
        switch (eventGeneric.getInt(0)) {
            case 0: {
                break;
            }
            case 1: {
                break;
            }
            case 2: {
                break;
            }
        }
    }

    private void processHmiSetterSetSelectSourceViewState(EventGeneric eventGeneric) {
        this.trace("[AslTargetSWDL] processHmiSetterSetSelectSourceViewState");
        this.helperMethodStartCustomerSwdlInhibitTimer();
        sourceViewIsShown = eventGeneric.getBoolean(0);
        if (sourceViewIsShown) {
            dsiSwdlHasFocus = true;
            this.dsiSwdlSelection.setUserSwdl(false);
            this.dsiSwdlSelection.setGotFocus(true);
            this.dsiSwdlSelection.getMedia();
        }
    }

    private void processHmiSetterSetVersionBackDocumentation(EventGeneric eventGeneric) {
        if (eventGeneric.getBoolean(0)) {
            this.trace("[AslTargetSWDL] processHmiSetterSetVersionBackDocumentation - Do Version upload");
            this.dsiSwdlSelection.startVersionUpload();
        } else {
            this.trace("[AslTargetSWDL] processHmiSetterSetVersionBackDocumentation - ABORT Version upload");
            this.dsiSwdlSelection.abortVersionUpload();
        }
    }

    private void processHmiSetterSpellerDeleteChar() {
        this.trace("[AslTargetSWDL] processHmiSetterSpellerDeleteChar");
        this.helperMethodStartCustomerSwdlInhibitTimer();
        --this.actualIpAddressStringIndex;
        this.actualIpAddress.deleteCharAt(this.actualIpAddressStringIndex);
        this.updateHmiGetterGetSpellerData();
    }

    private void processHmiSetterSpellerSetChar(EventGeneric eventGeneric) {
        this.trace("[AslTargetSWDL] processHmiSetterSpellerSetChar");
        this.helperMethodStartCustomerSwdlInhibitTimer();
        this.actualIpAddress.append(eventGeneric.getString(0));
        ++this.actualIpAddressStringIndex;
        this.updateHmiGetterGetSpellerData();
    }

    private void processHmiSetterStartDownload() {
        this.trace("[AslTargetSWDL] processHmiSetterStartDownload");
        if (this.aslStartupv7rAPI.isHighActivatorStarted()) {
            swdlHighOmitPowerStateChangeIndicationUntilStartSwdlWasCalled = false;
        }
        AslTargetCarWorkshopDownload.writeBooleanToDatapool(378, false);
        AslTargetCarWorkshopDownload.writeBooleanToDatapool(373, true);
        AslTargetCarWorkshopDownload.writeIntegerToDatapool(370, 1);
        this.triggerObserver(362627328, null);
        this.swdlStartWasRequested = true;
        this.dsiSwdlSelection.startDownload();
    }

    private void processHmiSetterTriggerCustomerDownload() {
        this.trace("[AslTargetSWDL] processHmiSetterTriggerCustomerDownload");
    }

    private void processHmiSetterUserAbort(EventGeneric eventGeneric) {
        if (eventGeneric.getInt(0) == 2) {
            this.trace("[AslTargetSWDL] EV_SWDL_USER_ABORT_ALL");
            this.userAbortIsPendingSoShowRebootScreenAfterPopupAndTriggerPanel = true;
            this.dsiSwdlProgress.handleUserSelection(1, "", 2);
        } else {
            this.info("Skip device will not be handled, as it is deprecated");
        }
    }

    private void processDsiUpdateCurrentDevices(String[] stringArray, int n) {
        if (cSwdlIsRunning) {
            return;
        }
        LogMessage logMessage = null;
        if (this.isTraceEnabled()) {
            logMessage = this.trace().append("[AslTargetSWDL] processDsiUpdateCurrentDevices:");
            if (stringArray.length != 0 && this.isTraceEnabled()) {
                for (int i2 = 0; i2 < stringArray.length; ++i2) {
                    logMessage.append(stringArray[i2]);
                }
            }
            logMessage.log();
        }
        if (stringArray.length != 0) {
            AslTargetCarWorkshopDownload.writeStringToDatapool(388, stringArray[0]);
        }
    }

    private void processDsiUpdateDeviceOverviewProgress(DeviceOverviewProgress[] deviceOverviewProgressArray) {
        if (cSwdlIsRunning) {
            return;
        }
        this.trace("[AslTargetSWDL] processDsiUpdateDeviceOverviewProgress");
        int n = 0;
        int n2 = 0;
        for (int i2 = 0; i2 < deviceOverviewProgressArray.length; ++i2) {
            if (!this.checkProgressType(deviceOverviewProgressArray[i2])) continue;
            ++n;
        }
        Object[] objectArray = new SwdlUpdateDataCollector[n];
        for (int i3 = 0; i3 < deviceOverviewProgressArray.length && n2 < n; ++i3) {
            if (this.isTraceEnabled()) {
                this.trace().append(deviceOverviewProgressArray[i3].fileName).append(": ").append(deviceOverviewProgressArray[i3].value).append("%").log();
            }
            if (!this.checkProgressType(deviceOverviewProgressArray[i3])) continue;
            this.propertyManager.valueChangedInteger(369, deviceOverviewProgressArray[i3].value);
            objectArray[n2] = new SwdlUpdateDataCollector(deviceOverviewProgressArray[i3].value, 0, "", deviceOverviewProgressArray[i3].fileName, false);
            ++n2;
        }
        ListManager.getGenericASLList(410).updateList(objectArray);
    }

    private boolean checkProgressType(DeviceOverviewProgress deviceOverviewProgress) {
        return deviceOverviewProgress.value != -1 && deviceOverviewProgress.type == 1;
    }

    private void processDsiUpdateGeneralDownloadProgress(GeneralProgress generalProgress) {
        if (cSwdlIsRunning) {
            return;
        }
        this.trace("[AslTargetSWDL] processDsiUpdateGeneralDownloadProgress");
        this.remainingItemsOfCurrentDownload = generalProgress.updatingDevices - (generalProgress.finishedDevicesWithError + generalProgress.finishedDevicesWithoutError + generalProgress.unavailableDevices);
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetSWDL] maxStage:").append(generalProgress.maxStage).log();
            this.trace().append("[AslTargetSWDL] currentStage:").append(generalProgress.currentStage).log();
            this.trace().append("[AslTargetSWDL] activedevices:").append(generalProgress.activeDevices).log();
            this.trace().append("[AslTargetSWDL] fwoerrdevices:").append(generalProgress.finishedDevicesWithoutError).log();
            this.trace().append("[AslTargetSWDL] fwierrdevices:").append(generalProgress.finishedDevicesWithError).log();
            this.trace().append("[AslTargetSWDL] unavailablede:").append(generalProgress.unavailableDevices).log();
        }
        if (!this.summaryReachedSendNoRemainingUpdate) {
            this.trace("[AslTargetSWDL] Remaining: ", this.remainingItemsOfCurrentDownload);
            AslTargetCarWorkshopDownload.writeIntegerToDatapool(379, this.remainingItemsOfCurrentDownload);
        }
        AslTargetCarWorkshopDownload.writeBooleanToDatapool(373, true);
        AslTargetCarWorkshopDownload.writeIntegerToDatapool(380, generalProgress.finishedDevicesWithoutError);
        AslTargetCarWorkshopDownload.writeIntegerToDatapool(381, generalProgress.finishedDevicesWithError);
        AslTargetCarWorkshopDownload.writeIntegerToDatapool(382, generalProgress.unavailableDevices);
        AslTargetCarWorkshopDownload.writeBooleanToDatapool(384, generalProgress.finishedDevicesWithError > 0 || generalProgress.unavailableDevices > 0);
    }

    private void processDsiUpdateIsUserDefinedAllowedAndRequestSetAccessTypeAndGetDevices(boolean bl) {
        if (cSwdlIsRunning) {
            return;
        }
        this.trace("[AslTargetSWDL] processDsiUpdateIsUserDefinedAllowedAndRequestSetAccessTypeAndGetDevices");
        this.dsiSwdlSelection.setInstallationType(!bl);
        AslTargetCarWorkshopDownload.writeBooleanToDatapool(371, !bl);
        this.currentSwdlAccessType = 1;
        this.dsiSwdlDeviceInfo.setAccessType(this.currentSwdlAccessType);
        this.dsiSwdlDeviceInfo.getDevices();
        this.dsiSwdlSelection.checkConsistency();
    }

    private void processDsiUpdateLostOrUnreadyDevices(String[] stringArray) {
        this.trace("[AslTargetSWDL] processDsiUpdateLostOrUnreadyDevices");
        if (stringArray != null) {
            ListManager.getGenericASLList(374).updateList(stringArray);
            this.info().append("Lost devices: ").append(Arrays.toString(stringArray)).log();
            AslTargetCarWorkshopDownload.writeBooleanToDatapool(373, stringArray.length == 0);
        } else {
            this.info().append("Lost devices: NONE").log();
            AslTargetCarWorkshopDownload.writeBooleanToDatapool(373, true);
        }
    }

    private void processDsiUpdateIndicateDismissPopup(int n, String string) {
        if (cSwdlIsRunning) {
            return;
        }
        this.trace("[AslTargetSWDL] dsiSwdlProgress.indicateDismissPopup");
        PopUpInfo popUpInfo = new PopUpInfo(n, string);
        if (this.mDelayedPopupInfo.remove(popUpInfo)) {
            this.info().append("Dismiss popup received before popup was handled: popUp: ").append(n).append(", id \"").append(string).append("\"").log();
        } else if (this.activePopupInfo != null && string.equals(this.activePopupInfo.id)) {
            this.activePopupInfo = null;
            int n2 = this.convertPopUpType2SystemEventClosed(popUpInfo);
            if (n2 != -1) {
                this.sendHMIEvent(n2);
            }
        }
        this.triggerMe(-1517944576);
    }

    private int convertPopUpTypeASL2DSI(int n) {
        int n2 = -1;
        switch (n) {
            case 1: {
                n2 = 3;
                break;
            }
            case 2: {
                n2 = 4;
                break;
            }
            case 3: {
                n2 = 5;
                break;
            }
            case 4: {
                n2 = 6;
                break;
            }
            case 5: {
                n2 = 9;
                break;
            }
            case 6: {
                n2 = 21;
                break;
            }
            case 7: {
                n2 = 10;
                break;
            }
            case 8: {
                n2 = 2;
                break;
            }
            case 9: {
                n2 = 7;
                break;
            }
            case 10: {
                n2 = 11;
                break;
            }
        }
        return n2;
    }

    private int convertPopUpType2SystemEventClosed(PopUpInfo popUpInfo) {
        int n = -1;
        switch (popUpInfo.popupType) {
            case 0: 
            case 1: 
            case 5: 
            case 8: {
                this.warn().append("Dismiss received for automatically handled popup! popUp: ").append(popUpInfo.popupType).append(", id \"").append(popUpInfo.id).append("\"").log();
                break;
            }
            case 3: {
                n = 31;
                break;
            }
            case 2: {
                n = 45;
                break;
            }
            case 4: {
                n = 33;
                break;
            }
            case 12: {
                n = 47;
                break;
            }
            case 10: {
                n = 43;
                break;
            }
            case 6: {
                n = 37;
                break;
            }
            case 9: {
                n = 39;
                break;
            }
            case 21: {
                n = 41;
                break;
            }
            case 11: {
                n = 49;
                break;
            }
            default: {
                this.warn("convertPopUpType2SystemEventClosed: unknown/unexpected popup!");
            }
        }
        return n;
    }

    private void processDelayedIndicatePopup(PopUpInfo popUpInfo) {
        int n = -1;
        boolean bl = false;
        this.info().append("[AslTargetDownload]").append("SWDL: POPUP/INFO is activated: Id: \"").append(popUpInfo.id).append("\", popupType: ").append(popUpInfo.popupType).append(", prio: ").append(popUpInfo.prio).append(", errorCode: ").append(popUpInfo.errorCode).append(", errorCodeDetailed: ").append(popUpInfo.errorCodeDetailed).append(", info: ").append(popUpInfo.info).log();
        DownloadPopupInfoCollector downloadPopupInfoCollector = (DownloadPopupInfoCollector)ListManager.getGenericASLList(411).getRowItem(0);
        downloadPopupInfoCollector.download_popup_additional_info = popUpInfo.info;
        downloadPopupInfoCollector.download_popup_detail_error_code = String.valueOf(popUpInfo.errorCodeDetailed);
        downloadPopupInfoCollector.download_popup_device_name = popUpInfo.id;
        downloadPopupInfoCollector.download_popup_error_code = String.valueOf(popUpInfo.errorCode);
        ListManager.getGenericASLList(411).updateListItem(0, downloadPopupInfoCollector);
        switch (popUpInfo.popupType) {
            case 0: {
                this.info("POPUPTYPES_NOT_INITIALIZED: Selection will be CANCEL");
                n = 4;
                break;
            }
            case 8: {
                this.info("POPUPTYPES_START_APPLICATIONS: Selection will be CONTINUE");
                n = 5;
                break;
            }
            case 5: {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(34);
                bl = true;
                break;
            }
            case 1: {
                this.info("POPUPTYPES_ABORT_DOWNLOAD: Selection will be CONTINUE");
                n = 5;
                break;
            }
            case 3: {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(30);
                bl = true;
                break;
            }
            case 2: {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(44);
                bl = true;
                break;
            }
            case 4: {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(32);
                bl = true;
                break;
            }
            case 12: {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(46);
                bl = true;
                break;
            }
            case 10: {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(42);
                bl = true;
                break;
            }
            case 6: {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(36);
                bl = true;
                break;
            }
            case 9: {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(38);
                bl = true;
                break;
            }
            case 21: {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(40);
                bl = true;
                break;
            }
            case 11: {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(48);
                bl = true;
                break;
            }
            default: {
                this.warn("NO Selection will be set for unknown/unexpected popup");
            }
        }
        if (n != -1) {
            this.dsiSwdlProgress.handleUserSelection(popUpInfo.popupType, popUpInfo.id, n);
            this.info("Selection sent!");
            this.triggerMe(-1517944576);
        }
        if (bl) {
            this.activePopupInfo = popUpInfo;
        }
    }

    private void processHmiSetterSetPopupType(EventGeneric eventGeneric) {
        this.helperMethodStartCustomerSwdlInhibitTimer();
        int n = eventGeneric.getInt(0);
        if (n != 0 && (this.activePopupInfo == null || this.convertPopUpTypeASL2DSI(n) != this.activePopupInfo.popupType)) {
            this.warn().append("Currently active popup type (").append(this.activePopupInfo.popupType).append(") and selected popup type (").append(this.convertPopUpTypeASL2DSI(n)).append(" ) do not match!");
        }
    }

    private void processHmiSetterSetPopupTypeButton(EventGeneric eventGeneric) {
        this.trace("processHmiSetterSetPopupTypeButton");
        this.helperMethodStartCustomerSwdlInhibitTimer();
        int n = -1;
        if (this.activePopupInfo != null) {
            n = this.convertButtonTypeASL2DSI(eventGeneric.getInt(0));
            if (this.activePopupInfo != null && n != -1) {
                this.dsiSwdlProgress.handleUserSelection(this.activePopupInfo.popupType, this.activePopupInfo.id, n);
                this.activePopupInfo = null;
            }
        } else {
            this.warn("User selection on popup will be ignored, because already dismissed!");
        }
    }

    private void processHmiSetterSelectAll() {
        this.trace("processHmiSetterSelectAll");
        this.helperMethodStartCustomerSwdlInhibitTimer();
        for (int i2 = 0; i2 < this.numberOfDevicesInCurrentSwdlSelection; ++i2) {
            this.dsiSwdlDeviceInfo.setDeviceSelection(i2, 1);
        }
        this.dsiSwdlDeviceInfo.getDevices();
    }

    private void processHmiSetterDeSelectAll() {
        this.trace("processHmiSetterDeSelectAll");
        this.helperMethodStartCustomerSwdlInhibitTimer();
        for (int i2 = 0; i2 < this.numberOfDevicesInCurrentSwdlSelection; ++i2) {
            this.dsiSwdlDeviceInfo.setDeviceSelection(i2, 0);
        }
        this.dsiSwdlDeviceInfo.getDevices();
    }

    private void processHmiSetterServicemodeChanged(int n) {
        this.trace("processHmiSetterServicemodeChanged: ", n);
        if (lastKnownServiceModeState == 1 && n == 0 && dsiSwdlHasFocus && !cSwdlIsRunning && !this.swdlStartWasRequested) {
            dsiSwdlHasFocus = false;
            this.dsiSwdlSelection.setGotFocus(false);
        }
        lastKnownServiceModeState = n;
    }

    private int convertButtonTypeASL2DSI(int n) {
        switch (n) {
            case 0: {
                if (this.activePopupInfo.popupType == 5) {
                    this.trace("PopupACTION selected by user is: USERSELECTION_SELECTED_CONTINUE");
                    return 5;
                }
                this.trace("PopupACTION selected by user is: USERSELECTION_SELECTED_OK");
                return 6;
            }
            case 1: {
                this.trace("PopupACTION selected by user is: USERSELECTION_SELECTED_CANCEL");
                return 4;
            }
            case 2: {
                this.trace("PopupACTION selected by user is: USERSELECTION_SELECTED_RETRY");
                return 3;
            }
            case 3: {
                this.trace("PopupACTION selected by user is: USERSELECTION_SELECTED_ABORT_COMPLETELY");
                return 2;
            }
        }
        this.warn("NO Selection will be set for unknown/unexpected popup button");
        return -1;
    }

    private void processDsiUpdateTriggerPanel(int n) {
        if (cSwdlIsRunning) {
            return;
        }
        this.trace("[AslTargetSWDL] processDsiUpdateTriggerPanel trigger Panel ", n);
        if (n == 1) {
            if (!AslTargetCustomerDownload.customerSwdlFinishedDuringThisClamp15Cycle) {
                AslTargetCarWorkshopDownload.writeIntegerToDatapool(379, this.remainingItemsOfCurrentDownload);
                AslTargetCarWorkshopDownload.writeBooleanToDatapool(378, true);
                this.info("[AslTargetSWDL] Send Event: SWDL_SYSTEM_FINISHED for reboot popup");
                AslTargetCarWorkshopDownload.writeBooleanToDatapool(400, false);
                this.stopTimer(-1517944576);
            }
            if (this.userAbortIsPendingSoShowRebootScreenAfterPopupAndTriggerPanel) {
                this.userAbortIsPendingSoShowRebootScreenAfterPopupAndTriggerPanel = false;
                this.sendHMIEvent(-1851056640);
            }
        } else if (n == 2) {
            this.summaryReachedSendNoRemainingUpdate = true;
            this.info("[AslTargetSWDL] Set DOWNLOAD_ERROR_OCCURRED_BOOLEAN to: false");
            AslTargetCarWorkshopDownload.writeBooleanToDatapool(384, false);
            this.info("[AslTargetSWDL] Set DOWNLOAD_DOWNLOAD_ITEMS_REMAINING_INTEGER to: 0");
            this.remainingItemsOfCurrentDownload = 0;
            AslTargetCarWorkshopDownload.writeIntegerToDatapool(379, this.remainingItemsOfCurrentDownload);
            this.info("[AslTargetSWDL] Set DOWNLOAD_REBOOT_NECESSARY_BOOLEAN to: false");
            AslTargetCarWorkshopDownload.writeBooleanToDatapool(378, false);
            this.info("[AslTargetSWDL] Set DOWNLOAD_RECENT_REBOOT_CONDITION_INTEGER to: RECENTREBOOTCONDITION_C2_DOWNLOADFINISHEDREBOOT");
            AslTargetCarWorkshopDownload.writeIntegerToDatapool(370, 2);
            AslTargetCarWorkshopDownload.writeBooleanToDatapool(400, true);
            this.logger.info(4096, "[AslTargetSWDL] Software download is finished");
            this.dsiSwdlLogging.getHistory();
            this.doSummary();
            this.stopTimer(-1517944576);
        } else if (n == 3) {
            // empty if block
        }
    }

    private void requestVersionInformation() {
        this.trace("Reading target version strings...");
        if (this.aslStartupv7rAPI.isHighActivatorStarted()) {
            this.dsiPersistence.readString(30, 0);
            this.dsiPersistence.readString(30, 0);
        } else {
            this.dsiPersistence.readBuffer(553765890, 0);
            this.dsiPersistence.readBuffer(553765890, 0);
        }
        this.trace("Reading Customer Update Version strings...");
        this.dsiPersistence.readBuffer(570543106, 0);
        this.dsiPersistence.readBuffer(671206402, 0);
        this.dsiPersistence.readBuffer(604097538, 0);
        this.dsiPersistence.readBuffer(654429186, 0);
        this.dsiPersistence.readBuffer(637651970, 0);
        this.dsiPersistence.readBuffer(587320322, 0);
        this.dsiPersistence.readBuffer(620874754, 0);
    }

    private void doSummary() {
        this.trace("[AslTargetSWDL] doing the summary");
        this.currentSwdlAccessType = 2;
        this.dsiSwdlDeviceInfo.setAccessType(this.currentSwdlAccessType);
        this.dsiSwdlDeviceInfo.getDevices();
    }

    private void initLogList() {
        Object[] objectArray = new SwdlUpdateDataCollector[]{new SwdlUpdateDataCollector()};
        objectArray[0].dataVersion = "";
        objectArray[0].dataTargetVersion = this.aslStartupv7rAPI.getPersistableEarlyData().getCurrentVersion();
        objectArray[0].dataName = "Loading";
        ListManager.getGenericASLList(406).updateList(objectArray);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        sdCardOneIsAvailable = false;
        sdCardTwoIsAvailable = false;
    }
}


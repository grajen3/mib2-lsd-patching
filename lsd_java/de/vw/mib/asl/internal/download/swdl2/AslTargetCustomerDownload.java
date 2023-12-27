/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.download.swdl2;

import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.valetparking.ValetParkingService;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyAdapterFactory;
import de.vw.mib.asl.framework.api.startupv7r.ASLStartupv7rAPI;
import de.vw.mib.asl.framework.api.startupv7r.ASLStartupv7rFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.download.PopUpInfo;
import de.vw.mib.asl.internal.download.SoftwareDownloadServices;
import de.vw.mib.asl.internal.download.swdl2.AslTargetCarWorkshopDownload;
import de.vw.mib.asl.internal.download.swdl2.CancelCustomerDownloadProcess;
import de.vw.mib.asl.internal.download.swdl2.DeviceManager;
import de.vw.mib.asl.internal.impl.download.PropagatingDownloadStateService;
import de.vw.mib.asl.internal.impl.download.SoftwareDownloadServicesProvider;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.Logger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Vector;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.media.DeviceInfo;
import org.dsi.ifc.media.MediaInfo;
import org.dsi.ifc.powermanagement.DSIPowerManagement;
import org.dsi.ifc.swdldeviceinfo.DSISwdlDeviceInfo;
import org.dsi.ifc.swdlprogress.DSISwdlProgress;
import org.dsi.ifc.swdlprogress.DeviceOverviewProgress;
import org.dsi.ifc.swdlprogress.GeneralProgress;
import org.dsi.ifc.swdlselection.DSISwdlSelection;

public final class AslTargetCustomerDownload
extends AbstractASLTarget {
    public static boolean customerSwdlStateIsActive = false;
    static boolean customerSwdlFinishedDuringThisClamp15Cycle = false;
    String cSwdlDeviceName = "";
    String cSwdlName = "";
    String cSwdlVersion = "";
    String cSwdlInfoFilePath = "";
    int cSwdlModuleCountForUpdate = 0;
    int cSwdlFinishedModuleCountForUpdate = 0;
    int cSwdlLastProgressValue = 0;
    int currentlyKnownPowerState = 1;
    boolean errorOccurredDuringUnnormalPowerState = false;
    int currentCustomerSwdlDevice = 0;
    int retriesForSetMedium = 0;
    private static final String CUSTOMER_SWDL_TRACE_LITERAL;
    private static final String EOL;
    private static final int CUSTOMER_SWDL_ASSURANCE_STATE_0_NOT_RUNNING__START_IS_ALLOWED;
    private static final int CUSTOMER_SWDL_ASSURANCE_STATE_1_MAYBE_RUNNING__START_IS_NOT_ALLOWED;
    private static final int CUSTOMER_SWDL_ASSURANCE_STATE_2_DEFINITELY_RUNNING__START_IS_NOT_ALLOWED;
    private static final byte ISMEDIAAVAILABLE_C0_NOT_SET;
    private static final byte ISMEDIAAVAILABLE_C1_YES;
    private static final byte ISMEDIAAVAILABLE_C2_NO;
    private static int MAX_NUMBER_OF_CSWDL_MEDIA;
    private static int PACKET_CATEGORY_NAVIDATA;
    private static final int EV_DELAYED_RELEASE_EVENT;
    private static final int EV_WAIT_AND_SET_RELEASE_EVENT;
    private static final int EV_TIMEOUT_PROTECTION_FOR_SECOND_TRIGGER;
    private static final int EV_TIMEOUT_PROTECTION_STATE_CHANGE_FLICKER_PREVENTION;
    private static final int EV_TIMEOUT_PROTECTION_FOR_ERROR_POPUP_AFTER_POWERSTATE_CHANGE;
    private static final int EV_TIMEOUT_PROTECTION_FOR_ERROR_NO_MEDIA_SO_SHOW_POPUP_THE_FULL_TIME;
    private static final int EV_TIMEOUT_PROTECTION_FOR_FAST_CSWDL_ENTRY;
    private static final byte MEDIA_NFS;
    private static final byte MEDIA_CDDVD;
    private static final byte MEDIA_USB;
    private static final byte MEDIA_SD1;
    private static final byte MEDIA_SD2;
    private static final byte MEDIA_CIFS;
    private final Vector modulesInRccUpdateTxt = new Vector(10, 1);
    private final boolean gotAvailableMediaUpdate;
    private final boolean customerDownloadRestartDisabledInGeneral = System.getProperty("de.vw.mib.asl.download.disableCustomerDownloadRestart") != null;
    private final ASLStartupv7rAPI aslStartupv7rAPI = ASLStartupv7rFactory.getStartupv7rApi();
    private final SoftwareDownloadServices downloadServices = SoftwareDownloadServicesProvider.getSoftwareDownloadServices();
    private final PropagatingDownloadStateService downloadStateService = this.downloadServices.getDownloadStateService();
    private Logger logger;
    private DeviceManager deviceManager;
    private boolean foundValueableData = false;
    private boolean searchRequestCancelled = false;
    private int awaitedSwdlMediaType = -1;
    private boolean notificationForCustomerSwdlAreSet = false;
    private boolean customerSwdlNameSuccessfullyResolved = false;
    private int doWeKnowForSureThatACustomerSwdlIsRunning = 0;
    private byte isMediaAvailable = 0;
    private PopUpInfo cSwdlPopUp = null;
    private boolean preventTriggerCustomerDownload = false;
    private boolean abortIsPending = false;
    private boolean rebootAllowed = false;
    private boolean wasAbortedDuringThisClamp15Cycle = false;
    private boolean abortVersionUploadAlreadySent = false;
    private boolean showRebootPopup = false;
    private boolean isTriggerReadingMetainfoActive = false;
    private boolean tempTriggerErrorPending = false;
    private int temporaryState = 0;
    private int lastValidVisibleCustomerDownloadState = 0;
    private boolean unwantedRebootDetectedSoEvaluatePosition = false;
    private boolean errorOccuredDuringThisClamp15Cycle = false;
    private boolean cSwdlStartWasRequestedByUser = false;
    private boolean cSwdlUserLeftMenuAndNotStartedDownloadSoFreshRunMayGetNecessary = false;
    private boolean cSwdlAtLeastOneRelevantProgressUpdateForSwdlWasReceivedSinceUserInteraction = false;
    private boolean uotaModeIsActiveSoIgnoreOtherMedia = false;
    private String currentOtaPackageName = "";
    private DSISwdlProgress dsiSwdlProgress;
    private DSISwdlSelection dsiSwdlSelection;
    private DSISwdlDeviceInfo dsiSwdlDeviceInfo;
    private DSIPowerManagement dsiPowerManagement;
    private DSIListener swdlProgressListener;
    private DSIListener swdlSelectionListener;
    private DSIListener swdlDeviceInfoListener;
    private DSIListener powerManagementListener;
    private int[] cSwdlFoundDevices;
    private int currentDeviceIndexForInfoFileSearch = -1;
    private byte availableMediaGlobal = 0;
    private int[] currentSearchDevicesFound = new int[]{0, 0, 0, 0};
    private int currentSearchDevicesFoundIndexPointer = -1;
    private int[] gotMediaForCurrentSession = null;
    private int numberOfReleasesOnCurrentDevice = 0;
    private int currentReleaseIndexPointer = -1;
    private boolean foundCDDVDInternalUpdateMediaInMediaList = false;
    private boolean foundSDCardOneUpdateMediaInMediaList = false;
    private boolean foundSDCardTwoUpdateMediaInMediaList = false;
    private boolean foundUSBUpdateMediaInMediaList = false;
    private boolean mediaDataCouldBeValidated = false;
    private boolean searchOrUserChoiceInProgressUserSwdlIsNotRunningNow = false;
    private int currentCustomerSwdlSourceDevice = -1;
    private String uotaFsPath = "";
    private int openVisiblePopupCount = 0;
    private boolean inhibitNextRetryUntilInitializationWasDone = false;
    private boolean mediaAvailableNotPerformingWasShownSinceLastInitialization = false;
    private int uotaDownloadCategory;
    private String[] cSwdlFoundDeviceNames;
    static /* synthetic */ Class class$org$dsi$ifc$swdldeviceinfo$DSISwdlDeviceInfo;
    static /* synthetic */ Class class$org$dsi$ifc$swdlprogress$DSISwdlProgress;
    static /* synthetic */ Class class$org$dsi$ifc$swdlselection$DSISwdlSelection;
    static /* synthetic */ Class class$org$dsi$ifc$powermanagement$DSIPowerManagement;
    static /* synthetic */ Class class$org$dsi$ifc$swdldeviceinfo$DSISwdlDeviceInfoListener;
    static /* synthetic */ Class class$org$dsi$ifc$swdlprogress$DSISwdlProgressListener;
    static /* synthetic */ Class class$org$dsi$ifc$swdlselection$DSISwdlSelectionListener;
    static /* synthetic */ Class class$org$dsi$ifc$powermanagement$DSIPowerManagementListener;

    private void processDsiResponseGetMedia(int[] nArray) {
        this.cSwdlStepTwoHandleResponseGetMediaBySwdl(nArray);
    }

    private void processDsiResponseStoreFsPath(String string) {
        this.info().append("[AslTargetCustomerDownload] ").append(" Received answer for storeFsPath: ").append(string).log();
    }

    private void processDsiResponseGetDevices(String[] stringArray, int[] nArray) {
        if (customerSwdlFinishedDuringThisClamp15Cycle) {
            this.helperMethodResolveUpdateStateAfterTriggerSummary(nArray);
            if (!this.abortVersionUploadAlreadySent) {
                this.abortVersionUploadAlreadySent = true;
                this.dsiSwdlSelection.abortVersionUpload();
            }
            AslTargetCarWorkshopDownload.dsiSwdlHasFocus = false;
            this.dsiSwdlSelection.setGotFocus(false);
            this.dsiSwdlSelection.setGotFocus(false);
            customerSwdlFinishedDuringThisClamp15Cycle = false;
        } else {
            this.cSwdlStepEightHandleResponseGetDevices(stringArray, nArray);
        }
    }

    private void processDsiResponseGetModules(int n, String[] stringArray, int[] nArray, short[] sArray) {
        this.trace("processDsiResponseGetModules");
        this.info().append("[AslTargetCustomerDownload] ").append("Step 12: parse InfoFile from Device").log();
        if (this.searchRequestCancelled) {
            this.info("search aborted by user");
            this.initializeFieldValues();
            return;
        }
        if (AslTargetCarWorkshopDownload.cSwdlIsInhibited) {
            this.info("cSWDL is inhibited by normal SWDL");
            return;
        }
        this.cSwdlModuleCountForUpdate += stringArray.length;
        this.updateHmiGetterCustomerDownloadItemsRemaining(this.cSwdlModuleCountForUpdate);
        this.helperMethodParseInfoFile(this.cSwdlInfoFilePath);
    }

    private void processDsiResponseSetMediumAndRequestAvailableReleaseNames(int n, String string, String[] stringArray) {
        this.cSwdlStepFourHandleResponseSetMedium(n, string, stringArray);
    }

    private void processDsiResponseSetRelease(int n, String string) {
        this.cSwdlStepSixHandleResponseSetRelease(n, string);
    }

    private void processDsiIndicationPopUp(int n, String string, byte by, int n2, int n3, String string2) {
        this.trace("processDsiIndicationPopUp");
        this.warn().append("[AslTargetCustomerDownload] ").append("A Popup (south side error indication) came up {popup:").append(n).append(", id: ").append(string).append(", prio: ").append(by).append(", errorCode: ").append(n2).append(", detailError: ").append(n3).append(",info: ").append(string2).append("}").log();
        if (this.currentlyKnownPowerState == 8) {
            this.normal("Redirecting SWDL popup to main target due to powerstate restrictions");
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
            eventGeneric.setInt(0, n);
            eventGeneric.setString(1, string);
            eventGeneric.setByte(2, by);
            eventGeneric.setInt(3, n2);
            eventGeneric.setInt(4, n3);
            eventGeneric.setString(5, string2);
            this.triggerObserver(1679303424, eventGeneric);
            return;
        }
        if (this.isTriggerReadingMetainfoActive && n == 10 && !this.abortIsPending) {
            this.cSwdlPopUp = new PopUpInfo(n, string, by, n2, n3, string2);
            this.updateHmiGetterCustomerDownloadPerforming(true);
            this.updateHmiGetterCustomerDownloadAvailable(true);
            this.tempTriggerErrorPending = true;
        } else if (this.currentlyKnownPowerState != 1 && this.currentlyKnownPowerState != 6 && !this.aslStartupv7rAPI.isNonCustomerSwdlIsInProgress() && customerSwdlStateIsActive) {
            this.cSwdlPopUp = new PopUpInfo(n, string, by, n2, n3, string2);
            this.errorOccurredDuringUnnormalPowerState = true;
            this.info("Error occurred during !powerOn, storing it for later");
        } else if (!this.aslStartupv7rAPI.isNonCustomerSwdlIsInProgress() && customerSwdlStateIsActive && !this.abortIsPending) {
            this.cSwdlPopUp = new PopUpInfo(n, string, by, n2, n3, string2);
            this.errorOccuredDuringThisClamp15Cycle = true;
            this.updateHmiGetterCustomerDownloadAvailable(false);
            this.sendHmiEventCustomerSwdl(448);
        } else if (this.abortIsPending) {
            this.info().append("[AslTargetCustomerDownload] ").append("Abort already issued, dismissing following errors").log();
        }
    }

    private void helperMethodParseInfoFile(String string) {
        Object object;
        StringBuffer stringBuffer = new StringBuffer(1000);
        String string2 = "";
        String string3 = "device";
        String string4 = "name.";
        String string5 = "version.";
        if (this.foundValueableData) {
            this.info().append("[AslTargetCustomerDownload] ").append("ID data found already").log();
            this.cSwdlStepNineSearchForInfoFiles();
            return;
        }
        try {
            object = new FileReader(string);
            BufferedReader bufferedReader = new BufferedReader((Reader)object);
            String string6 = "";
            while ((string6 = bufferedReader.readLine()) != null) {
                stringBuffer.append(string6).append(EOL);
            }
            bufferedReader.close();
            ((InputStreamReader)object).close();
        }
        catch (Exception exception) {
            this.warn().append("[AslTargetCustomerDownload] ").append("An unforeseen issue occured while reading the data").log();
            this.cSwdlInfoFilePath = "";
            this.cSwdlStepNineSearchForInfoFiles();
            return;
        }
        string2 = stringBuffer.toString();
        stringBuffer = null;
        object = ServiceManager.configManagerDiag.getCurrentGuiLanguage();
        this.cSwdlDeviceName = this.helperMethodGetValueFromString("device", string2);
        this.cSwdlName = this.helperMethodIsLocaleProvided(new StringBuffer().append("name.").append((String)object).toString(), string2) ? this.helperMethodGetValueFromString(new StringBuffer().append("name.").append((String)object).toString(), string2) : this.helperMethodGetValueFromString("name.default", string2);
        this.cSwdlVersion = this.helperMethodIsLocaleProvided(new StringBuffer().append("version.").append((String)object).toString(), string2) ? this.helperMethodGetValueFromString(new StringBuffer().append("version.").append((String)object).toString(), string2) : this.helperMethodGetValueFromString("version.default", string2);
        if (this.cSwdlName.toLowerCase().indexOf("nav") != -1) {
            this.updateHmiGetterCustomerDownloadActiveContext(4);
            this.customerSwdlNameSuccessfullyResolved = true;
            this.cSwdlName = "NavDB";
        } else if (this.cSwdlName.toLowerCase().indexOf("grace") != -1) {
            this.updateHmiGetterCustomerDownloadActiveContext(3);
            this.customerSwdlNameSuccessfullyResolved = true;
            this.cSwdlName = "Gracenote";
        } else if (this.cSwdlName.toLowerCase().indexOf("poi") != -1) {
            this.updateHmiGetterCustomerDownloadActiveContext(4);
            this.customerSwdlNameSuccessfullyResolved = true;
        } else if (this.cSwdlName.toLowerCase().indexOf("p.o.i.") != -1) {
            this.updateHmiGetterCustomerDownloadActiveContext(4);
            this.customerSwdlNameSuccessfullyResolved = true;
        } else if (this.cSwdlName.toLowerCase().indexOf("interest") != -1) {
            this.updateHmiGetterCustomerDownloadActiveContext(4);
            this.customerSwdlNameSuccessfullyResolved = true;
        } else if (this.cSwdlName.toLowerCase().indexOf("phone") != -1) {
            this.updateHmiGetterCustomerDownloadActiveContext(5);
            this.customerSwdlNameSuccessfullyResolved = true;
        } else if (this.cSwdlName.indexOf("parrot") != -1) {
            this.updateHmiGetterCustomerDownloadActiveContext(5);
            this.customerSwdlNameSuccessfullyResolved = true;
        } else if (this.cSwdlName.toLowerCase().indexOf("bluetooth") != -1) {
            this.updateHmiGetterCustomerDownloadActiveContext(5);
            this.customerSwdlNameSuccessfullyResolved = true;
        } else if (this.cSwdlName.toLowerCase().indexOf("alps") != -1) {
            this.updateHmiGetterCustomerDownloadActiveContext(5);
            this.customerSwdlNameSuccessfullyResolved = true;
        } else {
            this.warn("Could not Resolve name for cSWDL from InfoFile");
            this.customerSwdlNameSuccessfullyResolved = false;
        }
        this.info(this.cSwdlDeviceName);
        this.info(this.cSwdlName);
        this.info(this.cSwdlVersion);
        if (!this.currentOtaPackageName.equals("")) {
            this.updateHmiGetterCustomerDownloadName(new StringBuffer().append(this.cSwdlName).append(" (").append(this.currentOtaPackageName).append(") ").append(this.cSwdlVersion).toString());
        } else {
            this.updateHmiGetterCustomerDownloadName(new StringBuffer().append(this.cSwdlName).append(" ").append(this.cSwdlVersion).toString());
        }
        this.updateHmiGetterCustomerDownloadAvailable(true);
        this.foundValueableData = true;
        this.cSwdlStepNineSearchForInfoFiles();
    }

    private void helperMethodResolveUpdateStateAfterTriggerSummary(int[] nArray) {
        if (this.checkErrorDevice(nArray) && !this.wasAbortedDuringThisClamp15Cycle) {
            if (this.currentCustomerSwdlSourceDevice == 7) {
                ServiceManager.eventMain.getServiceRegister().triggerObserver(1662526208);
                this.downloadStateService.applyCurrentProgressState(0);
            }
            if (this.uotaModeIsActiveSoIgnoreOtherMedia && this.uotaDownloadCategory == PACKET_CATEGORY_NAVIDATA) {
                this.logger.info(4096).append("CSWDL finished in UOTA case - Simulating OK button press").log();
                this.preventTriggerCustomerDownload = false;
                this.handleCustomerDownloadFinishedOkButtonPressedEvent();
            } else {
                this.logger.info(4096).append("CSWDL finished in non-UOTA case - Showing finish popup").log();
                this.sendHmiEventCustomerSwdl(27);
            }
            this.logger.info(4096, "[AslTargetCustomerDownload] Software download is finished");
        } else {
            this.rebootAllowed = true;
            this.sendHmiEventCustomerSwdl(447);
            this.downloadStateService.applyCurrentProgressState(2);
        }
    }

    private boolean checkErrorDevice(int[] nArray) {
        int n = 0;
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (nArray[i2] != 3) continue;
            ++n;
        }
        return n == 0;
    }

    private void updateHmiGetterCustomerDownloadName(String string) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetCustomerDownload] ").append("updateHmiGetterCustomerDownloadName: ").append(string).log();
        }
        ServiceManager.aslPropertyManager.valueChangedString(398, string);
    }

    private void updateHmiGetterCustomerDownloadAvailable(boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetCustomerDownload] ").append("updateHmiGetterCustomerDownloadAvailable: ").append(bl).log();
        }
        if (bl && this.isMediaAvailable != 1) {
            this.isMediaAvailable = 1;
            ServiceManager.aslPropertyManager.valueChangedBoolean(397, bl);
        } else if (!bl && this.isMediaAvailable != 2) {
            this.isMediaAvailable = (byte)2;
            ServiceManager.aslPropertyManager.valueChangedBoolean(397, bl);
        }
    }

    private void updateHmiGetterCustomerDownloadPerforming(boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetCustomerDownload] ").append("updateHmiGetterCustomerDownloadPerforming: ").append(bl).log();
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(2506, bl);
    }

    private void updateHmiGetterCustomerDownloadActiveContext(int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetCustomerDownload] ").append("updateHmiGetterCustomerDownloadActiveContext: ").append(n).log();
        }
        if (n == 4) {
            this.currentCustomerSwdlDevice = n;
            ServiceManager.aslPropertyManager.valueChangedInteger(396, 0);
        } else if (n == 3) {
            ServiceManager.aslPropertyManager.valueChangedInteger(396, 0);
        } else {
            ServiceManager.aslPropertyManager.valueChangedInteger(396, n);
        }
    }

    private void updateHmiGetterCustomerDownloadItemRetries(int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetCustomerDownload] ").append("updateHmiGetterCustomerDownloadItemRetries: ").append(n).log();
        }
        ServiceManager.aslPropertyManager.valueChangedInteger(383, n);
    }

    private void updateHmiGetterCustomerDownloadItemPercent(int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetCustomerDownload] ").append("updateHmiGetterCustomerDownloadItemPercent: ").append(n).log();
        }
        ServiceManager.aslPropertyManager.valueChangedInteger(369, n);
    }

    private void updateHmiGetterCustomerDownloadItemsRemaining(int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetCustomerDownload] ").append("updateHmiGetterCustomerDownloadItemsRemaining: ").append(n).log();
        }
        ServiceManager.aslPropertyManager.valueChangedInteger(379, n);
    }

    private void updateHmiGetterCustomerDownloadItemsSucceeded(int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetCustomerDownload] ").append("updateHmiGetterCustomerDownloadItemsSucceeded: ").append(n).log();
        }
        ServiceManager.aslPropertyManager.valueChangedInteger(380, n);
    }

    private void sendHmiEventCustomerSwdl(int n) {
        if (this.isTraceEnabled()) {
            String string = "";
            switch (n) {
                case 27: {
                    string = "SWDL_CUSTOMER_DOWNLOAD_FINISHED";
                    break;
                }
                case 455: {
                    string = "SYSTEM_CUSTOMER_DOWNLOAD_SEARCH_FINISHED";
                    break;
                }
                case 447: {
                    string = "SWDL_CUSTOMER_DOWNLOAD_FINISHED_ERROR";
                    break;
                }
                case 448: {
                    string = "SWDL_CUSTOMER_DOWNLOAD_ERROR_WHILE_RUNNING";
                    break;
                }
                case 449: {
                    string = "SWDL_CUSTOMER_DOWNLOAD_RESTART_NECESSARY";
                    break;
                }
                default: {
                    string = new StringBuffer().append("Could not resolve: ").append(n).toString();
                }
            }
            this.trace().append("[AslTargetCustomerDownload] ").append("sendHmiEvent: ").append(string).log();
        }
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(n);
    }

    private boolean helperMethodCheckIfRCCUpdateTxtExists() {
        return new File("/net/rcc/mnt/efs-persist/SWDL/update.txt").exists();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean helperMethodParseRCCUpdateTxt() {
        Object object;
        String string = "/net/rcc/mnt/efs-persist/SWDL/update.txt";
        int n = 0;
        this.unwantedRebootDetectedSoEvaluatePosition = true;
        StringBuffer stringBuffer = new StringBuffer(500);
        if (!new File("/net/rcc/mnt/efs-persist/SWDL/update.txt").exists()) {
            return false;
        }
        try {
            object = new FileReader("/net/rcc/mnt/efs-persist/SWDL/update.txt");
            BufferedReader bufferedReader = new BufferedReader((Reader)object);
            String string2 = "";
            while ((string2 = bufferedReader.readLine()) != null) {
                if (string2.indexOf("TODO") == -1) continue;
                ++n;
                stringBuffer.append(string2);
                this.modulesInRccUpdateTxt.add(string2);
            }
            bufferedReader.close();
            ((InputStreamReader)object).close();
        }
        catch (Exception exception) {
            this.warn().append("[AslTargetCustomerDownload] ").append("An exception occured while reading the data from RCC->update.txt").log();
        }
        object = stringBuffer.toString();
        if (((String)object).toLowerCase().indexOf("nav") != -1) {
            this.updateHmiGetterCustomerDownloadActiveContext(4);
            this.customerSwdlNameSuccessfullyResolved = true;
            this.cSwdlName = "NavDB";
        } else if (((String)object).toLowerCase().indexOf("grace") != -1) {
            this.updateHmiGetterCustomerDownloadActiveContext(3);
            this.customerSwdlNameSuccessfullyResolved = true;
            this.cSwdlName = "Gracenote";
        } else if (((String)object).toLowerCase().indexOf("poi") != -1) {
            this.updateHmiGetterCustomerDownloadActiveContext(4);
            this.customerSwdlNameSuccessfullyResolved = true;
        } else if (((String)object).toLowerCase().indexOf("p.o.i.") != -1) {
            this.updateHmiGetterCustomerDownloadActiveContext(4);
            this.customerSwdlNameSuccessfullyResolved = true;
        } else if (((String)object).toLowerCase().indexOf("interest") != -1) {
            this.updateHmiGetterCustomerDownloadActiveContext(4);
            this.customerSwdlNameSuccessfullyResolved = true;
        } else if (((String)object).toLowerCase().indexOf("phone") != -1) {
            this.updateHmiGetterCustomerDownloadActiveContext(5);
            this.customerSwdlNameSuccessfullyResolved = true;
        } else if (((String)object).toLowerCase().indexOf("parrot") != -1) {
            this.updateHmiGetterCustomerDownloadActiveContext(5);
            this.customerSwdlNameSuccessfullyResolved = true;
        } else if (((String)object).toLowerCase().indexOf("bluetooth") != -1) {
            this.updateHmiGetterCustomerDownloadActiveContext(5);
            this.customerSwdlNameSuccessfullyResolved = true;
        } else if (((String)object).toLowerCase().indexOf("alps") != -1) {
            this.updateHmiGetterCustomerDownloadActiveContext(5);
            this.customerSwdlNameSuccessfullyResolved = true;
        } else {
            this.warn("Could not Resolve name for cSWDL from RCC Update.txt");
            this.customerSwdlNameSuccessfullyResolved = false;
        }
        this.updateHmiGetterCustomerDownloadItemRetries(0);
        this.updateHmiGetterCustomerDownloadItemPercent(0);
        if (!this.currentOtaPackageName.equals("")) {
            this.updateHmiGetterCustomerDownloadName(new StringBuffer().append("Ongoing download: ").append(this.cSwdlName).append(" (").append(this.currentOtaPackageName).append(")").toString());
        } else {
            this.updateHmiGetterCustomerDownloadName(new StringBuffer().append("Ongoing download: ").append(this.cSwdlName).toString());
        }
        this.cSwdlModuleCountForUpdate = n;
        this.updateHmiGetterCustomerDownloadItemsRemaining(this.cSwdlModuleCountForUpdate);
        return true;
    }

    private boolean helperMethodIsLocaleProvided(String string, String string2) {
        return string2.indexOf(string) != -1;
    }

    private String helperMethodGetValueFromString(String string, String string2) {
        if (string2 == null || string2.equals("")) {
            return "";
        }
        int n = string2.indexOf(string);
        return string2.substring(n + string.length() + 1, string2.indexOf(EOL, n));
    }

    public AslTargetCustomerDownload(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.gotAvailableMediaUpdate = false;
    }

    public AslTargetCustomerDownload(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.gotAvailableMediaUpdate = false;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        if (this.isTraceEnabled()) {
            this.trace().append("Start target TARGET_CUSTOMER_DOWNLOAD with ID = ").append(this.getDefaultTargetId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                DSIProxy dSIProxy = this.downloadServices.getDsiProxy();
                this.logger = this.downloadServices.getLogger();
                this.dsiSwdlDeviceInfo = (DSISwdlDeviceInfo)dSIProxy.getService(this, class$org$dsi$ifc$swdldeviceinfo$DSISwdlDeviceInfo == null ? (class$org$dsi$ifc$swdldeviceinfo$DSISwdlDeviceInfo = AslTargetCustomerDownload.class$("org.dsi.ifc.swdldeviceinfo.DSISwdlDeviceInfo")) : class$org$dsi$ifc$swdldeviceinfo$DSISwdlDeviceInfo);
                this.dsiSwdlProgress = (DSISwdlProgress)dSIProxy.getService(this, class$org$dsi$ifc$swdlprogress$DSISwdlProgress == null ? (class$org$dsi$ifc$swdlprogress$DSISwdlProgress = AslTargetCustomerDownload.class$("org.dsi.ifc.swdlprogress.DSISwdlProgress")) : class$org$dsi$ifc$swdlprogress$DSISwdlProgress);
                this.dsiSwdlSelection = (DSISwdlSelection)dSIProxy.getService(this, class$org$dsi$ifc$swdlselection$DSISwdlSelection == null ? (class$org$dsi$ifc$swdlselection$DSISwdlSelection = AslTargetCustomerDownload.class$("org.dsi.ifc.swdlselection.DSISwdlSelection")) : class$org$dsi$ifc$swdlselection$DSISwdlSelection);
                this.dsiPowerManagement = (DSIPowerManagement)dSIProxy.getService(this, class$org$dsi$ifc$powermanagement$DSIPowerManagement == null ? (class$org$dsi$ifc$powermanagement$DSIPowerManagement = AslTargetCustomerDownload.class$("org.dsi.ifc.powermanagement.DSIPowerManagement")) : class$org$dsi$ifc$powermanagement$DSIPowerManagement);
                DSIProxyAdapterFactory dSIProxyAdapterFactory = dSIProxy.getAdapterFactory();
                this.swdlDeviceInfoListener = dSIProxyAdapterFactory.createDSIListenerMethodAdapter(this, class$org$dsi$ifc$swdldeviceinfo$DSISwdlDeviceInfoListener == null ? (class$org$dsi$ifc$swdldeviceinfo$DSISwdlDeviceInfoListener = AslTargetCustomerDownload.class$("org.dsi.ifc.swdldeviceinfo.DSISwdlDeviceInfoListener")) : class$org$dsi$ifc$swdldeviceinfo$DSISwdlDeviceInfoListener);
                this.swdlProgressListener = dSIProxyAdapterFactory.createDSIListenerMethodAdapter(this, class$org$dsi$ifc$swdlprogress$DSISwdlProgressListener == null ? (class$org$dsi$ifc$swdlprogress$DSISwdlProgressListener = AslTargetCustomerDownload.class$("org.dsi.ifc.swdlprogress.DSISwdlProgressListener")) : class$org$dsi$ifc$swdlprogress$DSISwdlProgressListener);
                this.swdlSelectionListener = dSIProxyAdapterFactory.createDSIListenerMethodAdapter(this, class$org$dsi$ifc$swdlselection$DSISwdlSelectionListener == null ? (class$org$dsi$ifc$swdlselection$DSISwdlSelectionListener = AslTargetCustomerDownload.class$("org.dsi.ifc.swdlselection.DSISwdlSelectionListener")) : class$org$dsi$ifc$swdlselection$DSISwdlSelectionListener);
                this.powerManagementListener = dSIProxyAdapterFactory.createDSIListenerMethodAdapter(this, class$org$dsi$ifc$powermanagement$DSIPowerManagementListener == null ? (class$org$dsi$ifc$powermanagement$DSIPowerManagementListener = AslTargetCustomerDownload.class$("org.dsi.ifc.powermanagement.DSIPowerManagementListener")) : class$org$dsi$ifc$powermanagement$DSIPowerManagementListener);
                dSIProxy.addResponseListener(this, class$org$dsi$ifc$swdldeviceinfo$DSISwdlDeviceInfoListener == null ? (class$org$dsi$ifc$swdldeviceinfo$DSISwdlDeviceInfoListener = AslTargetCustomerDownload.class$("org.dsi.ifc.swdldeviceinfo.DSISwdlDeviceInfoListener")) : class$org$dsi$ifc$swdldeviceinfo$DSISwdlDeviceInfoListener, this.swdlDeviceInfoListener);
                dSIProxy.addResponseListener(this, class$org$dsi$ifc$swdlprogress$DSISwdlProgressListener == null ? (class$org$dsi$ifc$swdlprogress$DSISwdlProgressListener = AslTargetCustomerDownload.class$("org.dsi.ifc.swdlprogress.DSISwdlProgressListener")) : class$org$dsi$ifc$swdlprogress$DSISwdlProgressListener, this.swdlProgressListener);
                dSIProxy.addResponseListener(this, class$org$dsi$ifc$swdlselection$DSISwdlSelectionListener == null ? (class$org$dsi$ifc$swdlselection$DSISwdlSelectionListener = AslTargetCustomerDownload.class$("org.dsi.ifc.swdlselection.DSISwdlSelectionListener")) : class$org$dsi$ifc$swdlselection$DSISwdlSelectionListener, this.swdlSelectionListener);
                dSIProxy.addResponseListener(this, class$org$dsi$ifc$powermanagement$DSIPowerManagementListener == null ? (class$org$dsi$ifc$powermanagement$DSIPowerManagementListener = AslTargetCustomerDownload.class$("org.dsi.ifc.powermanagement.DSIPowerManagementListener")) : class$org$dsi$ifc$powermanagement$DSIPowerManagementListener, this.powerManagementListener);
                this.dsiSwdlSelection.setNotification(new int[]{6, 3}, this.swdlSelectionListener);
                this.dsiPowerManagement.setNotification(1, this.powerManagementListener);
                this.addObserver(-976868096);
                this.addObserver(939589696);
                this.addObserver(1476919360);
                this.addObserver(1493696576);
                this.addObserver(1460142144);
                this.addObserver(-1844969408);
                this.addObserver(-1190657984);
                this.addObserver(-1828192192);
                this.addObserver(1645748992);
                this.addObserver(-2138825152);
                this.addObserver(87968000);
                this.addObserver(-2105270720);
                this.addObserver(-2071716288);
                this.addObserver(-2038161856);
                this.addObserver(-2004607424);
                this.addObserver(-1971052992);
                this.addObserver(722149440);
                this.addObserver(-2122047936);
                this.addObserver(-2088493504);
                this.addObserver(-2054939072);
                this.addObserver(-2021384640);
                this.addObserver(-1987830208);
                this.addObserver(705372224);
                this.trace("Received POWER_ON");
                this.trackValetParking();
                this.deviceManager = new DeviceManager(this.dsiSwdlDeviceInfo, this.logger);
                AslTargetCustomerDownload.writeBooleanToDatapool(-1666507264, true);
                break;
            }
            case 1075741826: {
                --this.openVisiblePopupCount;
                this.normal("POPUP_CUSTOMER_DOWNLOAD_AFTER_REBOOT_DEACTIVATED");
                if (this.openVisiblePopupCount != 0) break;
                this.helperMethodSetCustomerSwdlTextVisible(true);
                break;
            }
            case 1075741828: {
                --this.openVisiblePopupCount;
                this.normal("POPUP_CUSTOMER_DOWNLOAD_FINISHED_DEACTIVATED");
                this.triggerObserver(1696080640, null);
                if (this.openVisiblePopupCount != 0) break;
                this.helperMethodSetCustomerSwdlTextVisible(true);
                break;
            }
            case 1075741830: {
                --this.openVisiblePopupCount;
                this.normal("POPUP_CUSTOMER_DOWNLOAD_FINISHED_ERROR_DEACTIVATED");
                this.triggerObserver(1696080640, null);
                if (this.openVisiblePopupCount != 0) break;
                this.helperMethodSetCustomerSwdlTextVisible(true);
                break;
            }
            case 1075741832: {
                --this.openVisiblePopupCount;
                this.normal("POPUP_CUSTOMER_DOWNLOAD_PROCESS_ERROR_DEACTIVATED");
                if (this.openVisiblePopupCount != 0) break;
                this.helperMethodSetCustomerSwdlTextVisible(true);
                break;
            }
            case 1075741834: {
                --this.openVisiblePopupCount;
                this.normal("POPUP_CUSTOMER_DOWNLOAD_RESTART_DEACTIVATED");
                if (this.openVisiblePopupCount != 0) break;
                this.helperMethodSetCustomerSwdlTextVisible(true);
                break;
            }
            case 1075841835: {
                --this.openVisiblePopupCount;
                this.normal("PO_SYS_ALERT_REQUEST_CUSTOMER_DOWNLOAD_DEACTIVATED");
                if (this.openVisiblePopupCount != 0) break;
                this.helperMethodSetCustomerSwdlTextVisible(true);
                break;
            }
            case 1075741825: {
                ++this.openVisiblePopupCount;
                this.normal("POPUP_CUSTOMER_DOWNLOAD_AFTER_REBOOT_DEACTIVATED");
                this.helperMethodSetCustomerSwdlTextVisible(false);
                break;
            }
            case 1075741827: {
                ++this.openVisiblePopupCount;
                this.normal("POPUP_CUSTOMER_DOWNLOAD_FINISHED_ACTIVATED");
                this.helperMethodSetCustomerSwdlTextVisible(false);
                break;
            }
            case 1075741829: {
                ++this.openVisiblePopupCount;
                this.normal("POPUP_CUSTOMER_DOWNLOAD_FINISHED_ERROR_DEACTIVATED");
                this.helperMethodSetCustomerSwdlTextVisible(false);
                break;
            }
            case 1075741831: {
                ++this.openVisiblePopupCount;
                this.normal("POPUP_CUSTOMER_DOWNLOAD_PROCESS_ERROR_DEACTIVATED");
                this.helperMethodSetCustomerSwdlTextVisible(false);
                break;
            }
            case 1075741833: {
                ++this.openVisiblePopupCount;
                this.normal("POPUP_CUSTOMER_DOWNLOAD_RESTART_DEACTIVATED");
                this.helperMethodSetCustomerSwdlTextVisible(false);
                break;
            }
            case 1075841834: {
                ++this.openVisiblePopupCount;
                this.normal("PO_SYS_ALERT_REQUEST_CUSTOMER_DOWNLOAD_DEACTIVATED");
                this.helperMethodSetCustomerSwdlTextVisible(false);
                break;
            }
            case 100004: {
                this.processHmiPreventionTimeoutSetCustomerDownloadState();
                break;
            }
            case 100003: {
                this.preventTriggerCustomerDownload = false;
                break;
            }
            case 4800005: {
                this.uotaFsPath = eventGeneric.getString(0);
                this.uotaDownloadCategory = eventGeneric.getInt(1);
                this.info().append("[AslTargetCustomerDownload] ").append("extracted fsPath from UOTA-Finished-Event: ").append(this.uotaFsPath).log();
                this.info().append("[AslTargetCustomerDownload] ").append("extracted download category from UOTA-Finished-Event: ").append(this.uotaDownloadCategory).log();
                break;
            }
            case 4800014: {
                boolean bl = eventGeneric.getBoolean(0);
                if (this.isTraceEnabled()) {
                    this.trace().append("[AslTargetCustomerDownload] ").append("Received ASL_ONLINE_UOTA_SERVICE_FINAL_POPUP. Installation successful: ").append(bl).log();
                }
                if (bl) {
                    this.sendHmiEventCustomerSwdl(27);
                    break;
                }
                this.sendHmiEventCustomerSwdl(447);
                break;
            }
            case 100005: {
                this.errorOccuredDuringThisClamp15Cycle = true;
                this.updateHmiGetterCustomerDownloadAvailable(false);
                this.sendHmiEventCustomerSwdl(448);
                break;
            }
            case 100006: {
                this.updateHmiGetterCustomerDownloadPerforming(false);
                this.updateHmiGetterCustomerDownloadAvailable(false);
                this.sendHmiEventCustomerSwdl(455);
                this.initializeFieldValues();
                break;
            }
            case 100007: {
                this.inhibitNextRetryUntilInitializationWasDone = true;
                this.info().append("[AslTargetCustomerDownload] ").append("Retrying start cSWDL...").log();
                this.processHmiSetterTriggerCustomerDownload();
                break;
            }
            case 3000005: {
                this.processHmiIndicationSwdlMediumHasChanged(((DeviceInfo)eventGeneric.getObject((int)0)).deviceID == 0L);
                break;
            }
            case 2300002: {
                this.info().append("[AslTargetCustomerDownload] ").append("ASLDownloadServiceIds.ASL_SWDL_OTA_OVER_THE_AIR_UPDATE_IS_AVAILABLE was received, searching for OTA customer SWDL...").log();
                break;
            }
            case 1073742136: {
                this.processHmiSetterTriggerCustomerDownload();
                break;
            }
            case 1073743960: {
                this.processHmiSetterAbortCustomerDownload();
                break;
            }
            case 1073744019: {
                this.processHmiSetterCancelRequestCustomerDownload();
                break;
            }
            case 1073743961: {
                this.processHmiSetterCustomerDownloadReboot();
                break;
            }
            case 1073743959: {
                this.processHmiSetterSetCustomerDownloadState(eventGeneric.getInt(0));
                break;
            }
            case 1073744018: {
                this.processHmiSetterRequestCustomerDownload();
                break;
            }
            case 1075741824: {
                this.currentOtaPackageName = eventGeneric.getString(0);
                this.updateHmiGetterCustomerDownloadPerforming(true);
                if (!this.isTriggerReadingMetainfoActive) {
                    this.processHmiSetterRequestUotACustomerDownload();
                    break;
                }
                this.processHmiResumeUotaCustomerDownload();
                break;
            }
            case 1073744057: {
                if (this.isTraceEnabled()) {
                    this.trace().append("[AslTargetCustomerDownload] ").append("Received event CUSTOMER_DOWNLOAD_FINISHED_OK_BUTTON_PRESSED.").append(eventGeneric.getReceiverEventId()).log();
                }
                this.handleCustomerDownloadFinishedOkButtonPressedEvent();
                break;
            }
            case 100002: {
                this.dsiSwdlSelection.setRelease(this.currentReleaseIndexPointer);
                break;
            }
            case 100001: {
                break;
            }
            default: {
                if (!this.isTraceEnabled()) break;
                this.trace().append("[AslTargetCustomerDownload] ").append(" default: ev.receiver.getEventId() = ").append(eventGeneric.getReceiverEventId()).log();
            }
        }
    }

    @Override
    public void trace(String string) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetCustomerDownload] ").append(string).log();
        }
    }

    @Override
    public int getDefaultTargetId() {
        return -1583541760;
    }

    @Override
    public int getSubClassifier() {
        return 4096;
    }

    public void dsiSwdlDeviceInfoGetDevices(String[] stringArray, int[] nArray) {
        this.processDsiResponseGetDevices(stringArray, nArray);
    }

    public void dsiSwdlDeviceInfoGetModules(int n, String[] stringArray, int[] nArray, short[] sArray) {
        this.processDsiResponseGetModules(n, stringArray, nArray, sArray);
    }

    public void dsiSwdlDeviceInfoGetInfoFilePath(int n, String string, String string2) {
        this.info().append("[AslTargetCustomerDownload] ").append("Step 10: dsiSwdlDeviceInfoGetInfoFilePath").log();
        if (string != null && !string.equals("")) {
            this.info().append("[AslTargetCustomerDownload] ").append("Step 11: retrieve Modules").log();
            this.cSwdlInfoFilePath = string;
            String[] stringArray = this.deviceManager.extractDeviceNames(string);
            if (stringArray != null) {
                String string3 = this.cSwdlFoundDeviceNames[n];
                this.selectionDeviceForInstallation(n, stringArray, string3);
            } else {
                this.error().append("[AslTargetCustomerDownload] ").append("Device names of Info-file could not be retrieved.").log();
                this.cSwdlStepNineSearchForInfoFiles();
            }
        } else {
            this.info().append("[AslTargetCustomerDownload] ").append("No info file found, party on wayne...").log();
            this.cSwdlStepNineSearchForInfoFiles();
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

    public void dsiSwdlSelectionUpdateUserSwdl(boolean bl, int n) {
        if (n == 1) {
            this.trace("dsiSwdlSelectionUpdateUserSwdl");
            if (bl && !this.searchOrUserChoiceInProgressUserSwdlIsNotRunningNow) {
                this.helperMethodSetCustomerSwdlRunningAssurenceState(1);
            }
            if (!bl && this.notificationForCustomerSwdlAreSet) {
                this.info("[AslTargetCustomerDownload] normal SWDL detected .. clearing notifications");
                this.dsiSwdlDeviceInfo.clearNotification(1, this.swdlDeviceInfoListener);
                this.dsiSwdlProgress.clearNotification(new int[]{3, 5, 6, 2, 1, 4}, this.swdlProgressListener);
                this.notificationForCustomerSwdlAreSet = false;
                customerSwdlStateIsActive = false;
                if (this.doWeKnowForSureThatACustomerSwdlIsRunning == 2) {
                    this.updateHmiGetterCustomerDownloadPerforming(true);
                } else {
                    this.updateHmiGetterCustomerDownloadPerforming(false);
                }
            } else if (bl && !this.notificationForCustomerSwdlAreSet) {
                this.info("[AslTargetCustomerDownload] customer SWDL detected .. setting notifications");
                this.dsiSwdlDeviceInfo.setNotification(1, this.swdlDeviceInfoListener);
                this.dsiSwdlProgress.setNotification(new int[]{3, 5, 6, 2, 1, 4}, this.swdlProgressListener);
                this.notificationForCustomerSwdlAreSet = true;
                customerSwdlStateIsActive = true;
                if (this.doWeKnowForSureThatACustomerSwdlIsRunning == 2) {
                    this.updateHmiGetterCustomerDownloadPerforming(true);
                } else {
                    this.updateHmiGetterCustomerDownloadPerforming(false);
                }
            }
        } else {
            ServiceManager.logger.normal(4096).append("[AslTargetCustomerDownload] ").append("INVALID UPDATE USER SWDL RECEIVED").log();
        }
    }

    public void dsiSwdlSelectionUpdateAvailableMedia(byte by, int n) {
        if (n == 1) {
            if (this.isTraceEnabled()) {
                this.trace().append("dsiSwdlSelectionUpdateAvailableMedia: ").append(by).log();
            }
            this.availableMediaGlobal = by;
        }
    }

    public void dsiSwdlProgressIndicatePopUp(int n, String string, byte by, int n2, int n3, String string2) {
        this.processDsiIndicationPopUp(n, string, by, n2, n3, string2);
    }

    public void dsiSwdlProgressIndicateDismissPopUp(int n, String string) {
        this.info().append("[AslTargetCustomerDownload] ").append("dsiSwdlProgressIndicateDismissPopUp").append(n).append(string).log();
    }

    public void dsiSwdlProgressUpdateActiveDevices(String[] stringArray, int n) {
    }

    public void dsiSwdlSelectionGetMedia(int[] nArray) {
        this.processDsiResponseGetMedia(nArray);
    }

    public void dsiSwdlSelectionStoreFsPath(String string) {
        this.processDsiResponseStoreFsPath(string);
    }

    public void dsiSwdlSelectionSetMedium(int n, String string, String[] stringArray) {
        this.processDsiResponseSetMediumAndRequestAvailableReleaseNames(n, string, stringArray);
    }

    public void dsiSwdlSelectionSetRelease(int n, String string) {
        this.processDsiResponseSetRelease(n, string);
    }

    public void dsiPowerManagementUpdatePowerManagementState(int n, int n2, int n3) {
        this.processDsiUpdatePowerManagementState(n);
    }

    private void selectionDeviceForInstallation(int n, String[] stringArray, String string) {
        if (this.deviceManager.checkIsDeviceNameInInfoFile(this.cSwdlFoundDeviceNames, stringArray)) {
            this.deviceManager.selectDevice(n, string, this.cSwdlFoundDevices);
        } else {
            this.deviceManager.deSelectDevice(n, string, this.cSwdlFoundDevices);
        }
    }

    private void trackValetParking() {
        ValetParkingService valetParkingService = ASLSystemFactory.getSystemApi().getValetParkingService();
        new CancelCustomerDownloadProcess(this.dsiSwdlProgress).initValetParkingListener(valetParkingService);
    }

    private void cSwdlUotAStepZeroCheckDeviceAndMediaInformation() {
        this.info().append("[AslTargetCustomerDownload] ").append("(UotA) Step 0: collecting general media information").log();
        this.uotaModeIsActiveSoIgnoreOtherMedia = true;
        this.helperMethodSetCustomerSwdlTextVisible(false);
        if (this.searchRequestCancelled) {
            this.info("(UotA) search aborted by user");
            this.initializeFieldValues();
            return;
        }
        if (AslTargetCarWorkshopDownload.cSwdlIsInhibited) {
            this.info("(UotA) cSWDL is inhibited by normal SWDL");
            return;
        }
        if (!this.aslStartupv7rAPI.isNonCustomerSwdlIsInProgress() && !AslTargetCarWorkshopDownload.cSwdlIsRunning) {
            this.currentSearchDevicesFound = new int[]{7};
            MAX_NUMBER_OF_CSWDL_MEDIA = this.currentSearchDevicesFound.length;
            this.cSwdlStepXGetMediaBySwdl();
        } else {
            this.info().append("[AslTargetCustomerDownload] ").append("(UotA) Aborting .. not all conditions for safe customer SWDL were met").log();
        }
    }

    private void cSwdlStepZeroCheckDeviceAndMediaInformation() {
        this.info().append("[AslTargetCustomerDownload] ").append("Step 0: collecting general media information").log();
        if (this.searchRequestCancelled) {
            this.info("search aborted by user");
            this.initializeFieldValues();
            return;
        }
        if (AslTargetCarWorkshopDownload.cSwdlIsInhibited) {
            this.info("cSWDL is inhibited by normal SWDL");
            return;
        }
        this.helperMethodCheckMediaDataForCustomerSWDL();
        if (!this.aslStartupv7rAPI.isNonCustomerSwdlIsInProgress() && !AslTargetCarWorkshopDownload.cSwdlIsRunning) {
            int n = 0;
            if (this.mediaDataCouldBeValidated) {
                this.info().append("[AslTargetCustomerDownload] ").append("no valid updateAvailableMedia was received, but valid MediaInfo was received instead").log();
                if (this.foundUSBUpdateMediaInMediaList) {
                    this.trace("Will start Search at USB");
                    this.currentSearchDevicesFound[0] = 3;
                    this.currentSearchDevicesFound[1] = 2;
                    this.currentSearchDevicesFound[2] = 4;
                    this.currentSearchDevicesFound[3] = 5;
                } else if (this.foundSDCardOneUpdateMediaInMediaList) {
                    this.trace("Will start Search at SD Left");
                    this.currentSearchDevicesFound[0] = 4;
                    this.currentSearchDevicesFound[1] = 5;
                    this.currentSearchDevicesFound[2] = 2;
                    this.currentSearchDevicesFound[3] = 3;
                } else if (this.foundSDCardTwoUpdateMediaInMediaList) {
                    this.trace("Will start Search at SD Right");
                    this.currentSearchDevicesFound[0] = 5;
                    this.currentSearchDevicesFound[1] = 4;
                    this.currentSearchDevicesFound[2] = 2;
                    this.currentSearchDevicesFound[3] = 3;
                } else {
                    this.trace("Will start Search at CD/DVD");
                    this.currentSearchDevicesFound[0] = 2;
                    this.currentSearchDevicesFound[1] = 4;
                    this.currentSearchDevicesFound[2] = 5;
                    this.currentSearchDevicesFound[3] = 3;
                }
                n = 3;
            } else {
                this.info().append("[AslTargetCustomerDownload] ").append("no valid updateAvailableMedia was received, checking all relevant devices").log();
                this.currentSearchDevicesFound[0] = 2;
                this.currentSearchDevicesFound[1] = 4;
                this.currentSearchDevicesFound[2] = 5;
                this.currentSearchDevicesFound[3] = 3;
                n = 3;
            }
            if (n != 0) {
                this.cSwdlStepXGetMediaBySwdl();
            }
        } else {
            this.info().append("[AslTargetCustomerDownload] ").append("Aborting .. not all conditions for safe customer SWDL were met").log();
        }
    }

    private void cSwdlStepXGetMediaBySwdl() {
        this.info().append("[AslTargetCustomerDownload] ").append("Step 0.5: setting new medium for search").log();
        if (this.searchRequestCancelled) {
            this.info("search aborted by user");
            this.initializeFieldValues();
            return;
        }
        if (AslTargetCarWorkshopDownload.cSwdlIsInhibited) {
            this.info("cSWDL is inhibited by normal SWDL");
            return;
        }
        ++this.currentSearchDevicesFoundIndexPointer;
        if (this.currentSearchDevicesFoundIndexPointer < MAX_NUMBER_OF_CSWDL_MEDIA && this.currentSearchDevicesFound[this.currentSearchDevicesFoundIndexPointer] != 0) {
            this.currentCustomerSwdlSourceDevice = this.awaitedSwdlMediaType = this.currentSearchDevicesFound[this.currentSearchDevicesFoundIndexPointer];
            this.cSwdlStepOneGetMediaBySwdl();
        } else {
            this.info().append("[AslTargetCustomerDownload] ").append("Final: No customer update data found, exiting CustomerSWDL now.").log();
            this.startTimer(-1501167360, (long)0, false);
            if (this.currentCustomerSwdlSourceDevice == 7) {
                ServiceManager.eventMain.getServiceRegister().triggerObserver(1662526208);
                this.downloadStateService.applyCurrentProgressState(2);
                this.updateHmiGetterCustomerDownloadPerforming(false);
            }
        }
    }

    private void cSwdlStepOneGetMediaBySwdl() {
        this.info().append("[AslTargetCustomerDownload] ").append("Step 1: Calling getMedia").log();
        if (this.searchRequestCancelled) {
            this.info("search aborted by user");
            this.initializeFieldValues();
            return;
        }
        if (AslTargetCarWorkshopDownload.cSwdlIsInhibited) {
            this.info("cSWDL is inhibited by normal SWDL");
            return;
        }
        if (this.uotaModeIsActiveSoIgnoreOtherMedia) {
            if (!this.uotaFsPath.equals("")) {
                this.info().append("[AslTargetCustomerDownload] ").append("using uotaFsPath: ").append(this.uotaFsPath).log();
            } else {
                this.error().append("[AslTargetCustomerDownload] ").append("ERROR: uotaFsPath was empty!!!").log();
            }
            this.dsiSwdlSelection.storeFsPath(this.uotaFsPath);
            this.dsiSwdlSelection.getMedia();
        } else if (this.gotMediaForCurrentSession == null) {
            this.dsiSwdlSelection.getMedia();
        } else {
            this.info().append("[AslTargetCustomerDownload] ").append("Media already received for this run, skipping request...").log();
            this.cSwdlStepTwoHandleResponseGetMediaBySwdl(this.gotMediaForCurrentSession);
        }
    }

    private void cSwdlStepTwoHandleResponseGetMediaBySwdl(int[] nArray) {
        int n;
        this.info().append("[AslTargetCustomerDownload] ").append("Step 2: processDsiResponseGetMedia").log();
        if (this.searchRequestCancelled) {
            this.info("search aborted by user");
            this.initializeFieldValues();
            return;
        }
        if (this.gotMediaForCurrentSession == null) {
            this.gotMediaForCurrentSession = nArray;
        }
        boolean bl = false;
        for (n = 0; n < this.gotMediaForCurrentSession.length; ++n) {
            if (this.gotMediaForCurrentSession[n] != this.awaitedSwdlMediaType) continue;
            bl = true;
        }
        if (!bl) {
            this.info().append("[AslTargetCustomerDownload] ").append("Media list does not contain next device for search, skipping...").log();
            this.cSwdlStepXGetMediaBySwdl();
            return;
        }
        if (AslTargetCarWorkshopDownload.cSwdlIsInhibited) {
            this.info("cSWDL is inhibited by normal SWDL");
            return;
        }
        n = 0;
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = false;
        boolean bl5 = false;
        block15: for (int i2 = 0; i2 < nArray.length; ++i2) {
            switch (nArray[i2]) {
                case 2: {
                    this.trace("processDsiResponseGetMedia CD Available as I/O device");
                    n = 1;
                    continue block15;
                }
                case 3: {
                    this.trace("processDsiResponseGetMedia USB Available as I/O device");
                    bl2 = true;
                    continue block15;
                }
                case 4: {
                    this.trace("processDsiResponseGetMedia SDCard1 Available as I/O device");
                    bl3 = true;
                    continue block15;
                }
                case 5: {
                    this.trace("processDsiResponseGetMedia SDCard2 Available as I/O device");
                    bl4 = true;
                    continue block15;
                }
                case 7: {
                    this.trace("processDsiResponseGetMedia OTA Available as I/O device");
                    bl5 = this.uotaModeIsActiveSoIgnoreOtherMedia;
                    continue block15;
                }
            }
        }
        switch (this.awaitedSwdlMediaType) {
            case 2: {
                if (n == 0) break;
                this.cSwdlStepThreeSetMediumAfterEvaluation();
                break;
            }
            case 3: {
                if (!bl2) break;
                this.cSwdlStepThreeSetMediumAfterEvaluation();
                break;
            }
            case 4: {
                if (!bl3) break;
                this.cSwdlStepThreeSetMediumAfterEvaluation();
                break;
            }
            case 5: {
                if (!bl4) break;
                this.cSwdlStepThreeSetMediumAfterEvaluation();
                break;
            }
            case 7: {
                if (!bl5) break;
                this.cSwdlStepThreeSetMediumAfterEvaluation();
                break;
            }
            default: {
                this.info().append("Medium not found, trying next one");
                this.cSwdlStepXGetMediaBySwdl();
            }
        }
    }

    private void helperMethodCheckMediaDataForCustomerSWDL() {
        int n;
        this.trace("helperMethodCheckMediaDataForCustomerSWDL");
        this.mediaDataCouldBeValidated = false;
        DeviceInfo[] deviceInfoArray = AslTargetCarWorkshopDownload.lastKnownMediaDeviceList;
        MediaInfo[] mediaInfoArray = AslTargetCarWorkshopDownload.lastKnownMediaMediaList;
        long[] lArray = new long[]{0L, 0L};
        long[] lArray2 = new long[]{0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L};
        int n2 = 0;
        boolean bl = false;
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = false;
        if (deviceInfoArray != null) {
            for (n = 0; n < deviceInfoArray.length; ++n) {
                if (deviceInfoArray[n].deviceType != 1) continue;
                lArray[n2] = deviceInfoArray[n].deviceID;
                ++n2;
            }
        } else {
            return;
        }
        n2 = 0;
        if (mediaInfoArray != null) {
            for (n = 0; n < mediaInfoArray.length; ++n) {
                if (mediaInfoArray[n].mediaType != 17) continue;
                lArray2[n2] = mediaInfoArray[n].deviceID;
                ++n2;
            }
            n = -1;
            if (n2 == 0) {
                return;
            }
            n = n2;
            n2 = 0;
            for (int i2 = 0; i2 < deviceInfoArray.length; ++i2) {
                block8: for (int i3 = 0; i3 < n; ++i3) {
                    if (deviceInfoArray[i2].deviceID != lArray2[i3]) continue;
                    switch (deviceInfoArray[i2].deviceType) {
                        case 3: 
                        case 4: 
                        case 5: 
                        case 6: {
                            this.trace("Found Cd/Dvd in MediaList");
                            bl3 = true;
                            continue block8;
                        }
                        case 1: {
                            if (lArray2[i3] == lArray[0]) {
                                this.trace("Found SDCard1 in MediaList");
                                bl = true;
                            }
                            if (lArray2[i3] != lArray[1]) continue block8;
                            this.trace("Found SDCard2 in MediaList");
                            bl2 = true;
                            continue block8;
                        }
                        case 2: {
                            this.trace("Found USB in MediaList");
                            bl4 = true;
                            continue block8;
                        }
                    }
                }
            }
        }
        this.foundCDDVDInternalUpdateMediaInMediaList = bl3;
        this.foundSDCardOneUpdateMediaInMediaList = bl;
        this.foundSDCardTwoUpdateMediaInMediaList = bl2;
        this.foundUSBUpdateMediaInMediaList = bl4;
        this.mediaDataCouldBeValidated = true;
    }

    private String helperMethodGetMediaTypeName(int n) {
        String string;
        switch (n) {
            case 2: {
                string = "CD/DVD";
                break;
            }
            case 4: {
                string = "Left SDCard";
                break;
            }
            case 5: {
                string = "Right SDCard";
                break;
            }
            case 3: {
                string = "USB";
                break;
            }
            case 7: {
                string = "OTA";
                break;
            }
            default: {
                string = "NONE";
            }
        }
        return string;
    }

    private void cSwdlStepThreeSetMediumAfterEvaluation() {
        this.info().append("[AslTargetCustomerDownload] ").append("Step 3: Calling setMedium: ").append(this.helperMethodGetMediaTypeName(this.awaitedSwdlMediaType)).log();
        if (this.searchRequestCancelled) {
            this.info("search aborted by user");
            this.initializeFieldValues();
            return;
        }
        if (AslTargetCarWorkshopDownload.cSwdlIsInhibited) {
            this.info("cSWDL is inhibited by normal SWDL");
            return;
        }
        this.dsiSwdlSelection.setUserSwdl(true);
        AslTargetCarWorkshopDownload.dsiSwdlHasFocus = true;
        this.dsiSwdlSelection.setGotFocus(true);
        this.dsiSwdlSelection.abortSetMedium();
        this.dsiSwdlSelection.setMedium(this.awaitedSwdlMediaType);
    }

    private void cSwdlStepFourHandleResponseSetMedium(int n, String string, String[] stringArray) {
        this.info().append("[AslTargetCustomerDownload] ").append("step 4: processDsiResponseSetMediumAndRequestAvailableReleaseNames").log();
        if (this.searchRequestCancelled) {
            this.info("search aborted by user");
            this.initializeFieldValues();
            return;
        }
        if (AslTargetCarWorkshopDownload.cSwdlIsInhibited) {
            this.info("cSWDL is inhibited by normal SWDL");
            return;
        }
        boolean bl = false;
        this.trace("processDsiResponseSetMediumAndRequestAvailableReleaseNames");
        switch (n) {
            case 6: {
                this.trace("DSISwdlSelection.RELEASERESULT_ERROR_CRC");
                this.error().append("[AslTargetCustomerDownload] ").append("CRC Error in release: ").append(string).append(" detected!").log();
                bl = true;
                break;
            }
            case 8: {
                this.trace("DSISwdlSelection.RELEASERESULT_ERROR_MEDIUM_UNAVAILABLE");
                this.error().append("[AslTargetCustomerDownload] ").append("RELEASEERROR: Error while reading medium: ").append(string).log();
                AslTargetCustomerDownload.writeIntegerToDatapool(386, 1);
                bl = true;
                break;
            }
            case 11: {
                this.trace("DSISwdlSelection.RELEASERESULT_ERROR_MEMORY");
                this.error().append("[AslTargetCustomerDownload] ").append("Out of Memory!").log();
                bl = true;
                break;
            }
            case 7: {
                this.trace("DSISwdlSelection.RELEASERESULT_ERROR_NO_RELEASES");
                this.error().append("[AslTargetCustomerDownload] ").append("No releases found on medium!").log();
                AslTargetCustomerDownload.writeIntegerToDatapool(386, 2);
                bl = true;
                break;
            }
            case 2: {
                this.trace("DSISwdlSelection.RELEASERESULT_ERROR_OPEN");
                this.error().append("[AslTargetCustomerDownload] ").append("Error while reading metaInfo, could not OPEN file: ").append(string).log();
                AslTargetCustomerDownload.writeIntegerToDatapool(386, 4);
                bl = true;
                break;
            }
            case 4: {
                this.trace("DSISwdlSelection.RELEASERESULT_ERROR_PARSE");
                this.error().append("[AslTargetCustomerDownload] ").append("Error while reading metaInfo, could not PARSE file: ").append(string).log();
                bl = true;
                break;
            }
            case 3: {
                this.trace("DSISwdlSelection.RELEASERESULT_ERROR_READ");
                this.error().append("[AslTargetCustomerDownload] ").append("Error while reading metaInfo, could not READ file: ").append(string).log();
                AslTargetCustomerDownload.writeIntegerToDatapool(386, 3);
                bl = true;
                break;
            }
            case 10: {
                this.trace("DSISwdlSelection.RELEASERESULT_ERROR_REGION");
                this.error().append("[AslTargetCustomerDownload] ").append("Error in region, wrong update for country-variant(REGION): ").append(string).log();
                AslTargetCustomerDownload.writeIntegerToDatapool(386, 5);
                bl = true;
                break;
            }
            case 5: {
                this.trace("DSISwdlSelection.RELEASERESULT_ERROR_SIGNATURE");
                this.error().append("[AslTargetCustomerDownload] ").append("Wrong signature for update: ").append(string).log();
                bl = true;
                break;
            }
            case 9: {
                this.trace("DSISwdlSelection.RELEASERESULT_ERROR_VARIANT");
                this.error().append("[AslTargetCustomerDownload] ").append("Error in region, wrong update for variant: ").append(string).log();
                AslTargetCustomerDownload.writeIntegerToDatapool(386, 6);
                bl = true;
                break;
            }
            case 0: {
                this.trace("DSISwdlSelection.RELEASERESULT_NOT_INITIALIZED");
                this.error().append("[AslTargetCustomerDownload] ").append("Init failed, please retry ").append(string).log();
                AslTargetCustomerDownload.writeIntegerToDatapool(386, 1);
                bl = true;
                break;
            }
            case 1: {
                if (this.isTraceEnabled()) {
                    this.trace("DSISwdlSelection.RELEASERESULT_OK");
                    for (int i2 = 0; i2 < stringArray.length; ++i2) {
                        this.trace().append("[AslTargetCustomerDownload] ").append(stringArray[i2]).log();
                    }
                }
                this.numberOfReleasesOnCurrentDevice = stringArray.length;
                this.currentReleaseIndexPointer = -1;
                this.cSwdlStepFiveCheckReleases();
                break;
            }
            default: {
                if (this.isTraceEnabled()) {
                    this.trace().append("[AslTargetCustomerDownload] ").append("default: ev.getInt(DSISwdlSelectionListenerWrapper.SETMEDIUM_P0_RESULT_INT) = ").append(n).log();
                }
                this.error().append("[AslTargetCustomerDownload] ").append("An unknown error occurred while reading medium!").log();
                bl = true;
            }
        }
        if (bl) {
            this.warn().append("[AslTargetCustomerDownload] ").append("ERROR while reading releaseresult in cSWDL MEDIUM").log();
            this.cSwdlStepXGetMediaBySwdl();
        }
    }

    private void helperMethodSetCustomerSwdlRunningAssurenceState(int n) {
        this.trace().append("[AslTargetCustomerDownload] ").append("set cSWDL assurance state: ").append(n).log();
        if (this.doWeKnowForSureThatACustomerSwdlIsRunning != n) {
            this.doWeKnowForSureThatACustomerSwdlIsRunning = n;
            if (n == 2) {
                ServiceManager.eventMain.getServiceRegister().triggerObserver(1612194560);
            }
            if (n == 0) {
                AslTargetCarWorkshopDownload.cSwdlIsRunning = false;
            } else {
                AslTargetCustomerDownload.writeBooleanToDatapool(3544, false);
                AslTargetCarWorkshopDownload.cSwdlIsRunning = true;
            }
        }
    }

    private void helperMethodSetReleaseWithWait(int n) {
        this.startTimer(-1568276224, (long)n, false);
    }

    private void helperMethodSetCustomerSwdlTextVisible(boolean bl) {
        this.info().append("[AslTargetCustomerDownload] ").append("Setting cSWDL Text visible: ").append(bl).log();
        AslTargetCustomerDownload.writeBooleanToDatapool(-1851056640, bl);
    }

    private void cSwdlStepFiveCheckReleases() {
        this.info().append("[AslTargetCustomerDownload] ").append("Step 5: Calling setRelease").log();
        if (this.searchRequestCancelled) {
            this.info("search aborted by user");
            this.initializeFieldValues();
            return;
        }
        if (AslTargetCarWorkshopDownload.cSwdlIsInhibited) {
            this.info("cSWDL is inhibited by normal SWDL");
            return;
        }
        if (this.numberOfReleasesOnCurrentDevice != 0 && this.currentReleaseIndexPointer + 1 < this.numberOfReleasesOnCurrentDevice) {
            ++this.currentReleaseIndexPointer;
            this.helperMethodSetReleaseWithWait(1500);
        } else {
            this.info().append("[AslTargetCustomerDownload] ").append("Step 5: All Releases were searched, going to next Medium").log();
            this.numberOfReleasesOnCurrentDevice = 0;
            this.currentReleaseIndexPointer = -1;
            this.cSwdlStepXGetMediaBySwdl();
        }
    }

    private void cSwdlStepSixHandleResponseSetRelease(int n, String string) {
        this.info().append("[AslTargetCustomerDownload] ").append("Step 6:processDsiResponseSetRelease").log();
        if (this.searchRequestCancelled) {
            this.info("search aborted by user");
            this.initializeFieldValues();
            return;
        }
        if (AslTargetCarWorkshopDownload.cSwdlIsInhibited) {
            this.info("cSWDL is inhibited by normal SWDL");
            return;
        }
        boolean bl = true;
        switch (n) {
            case 6: {
                this.trace("DSISwdlSelection.METAINFORESULT_ERROR_CRC");
                this.error().append("[AslTargetCustomerDownload] ").append("CRC Error in metaInfo: ").append(string).append(" detected!").log();
                break;
            }
            case 10: {
                this.trace("DSISwdlSelection.METAINFORESULT_ERROR_CRC_CHANGED");
                this.error().append("[AslTargetCustomerDownload] ").append("Error CRC has changed on metaInfo: ").append(string).log();
                AslTargetCustomerDownload.writeIntegerToDatapool(387, 1);
                break;
            }
            case 8: {
                if (this.retriesForSetMedium++ >= MAX_NUMBER_OF_CSWDL_MEDIA) break;
                this.info().append("[AslTargetCustomerDownload] ").append("Retry...").log();
                --this.currentReleaseIndexPointer;
                this.cSwdlStepFiveCheckReleases();
                return;
            }
            case 2: {
                this.trace("DSISwdlSelection.METAINFORESULT_ERROR_OPEN_METAINFO");
                this.error().append("[AslTargetCustomerDownload] ").append("Error while opening metaInfo, could not OPEN file: ").append(string).log();
                AslTargetCustomerDownload.writeIntegerToDatapool(387, 4);
                break;
            }
            case 4: {
                this.trace("DSISwdlSelection.METAINFORESULT_ERROR_PARSE");
                this.error().append("[AslTargetCustomerDownload] ").append("Error while reading metaInfo, could not PARSE file: ").append(string).log();
                break;
            }
            case 3: {
                this.trace("DSISwdlSelection.METAINFORESULT_ERROR_READ");
                this.error().append("[AslTargetCustomerDownload] ").append("Error while reading metaInfo, could not READ file: ").append(string).log();
                AslTargetCustomerDownload.writeIntegerToDatapool(387, 3);
                break;
            }
            case 7: {
                this.trace("DSISwdlSelection.METAINFORESULT_ERROR_REGION");
                this.error().append("[AslTargetCustomerDownload] ").append("Error in region for metaInfo: ").append(string).log();
                AslTargetCustomerDownload.writeIntegerToDatapool(387, 5);
                break;
            }
            case 5: {
                this.trace("DSISwdlSelection.METAINFORESULT_ERROR_SIGNATURE");
                this.error().append("[AslTargetCustomerDownload] ").append("Wrong signature for update in metaInfo: ").append(string).log();
                break;
            }
            case 9: {
                this.trace("DSISwdlSelection.METAINFORESULT_ERROR_VARIANT");
                this.error().append("[AslTargetCustomerDownload] ").append("Error in metaInfo, wrong update for variant: ").append(string).log();
                AslTargetCustomerDownload.writeIntegerToDatapool(387, 6);
                break;
            }
            case 0: {
                this.trace("DSISwdlSelection.METAINFORESULT_NOT_INITIALIZED");
                this.error().append("[AslTargetCustomerDownload] ").append("Init failed, please retry ").append(string).log();
                break;
            }
            case 1: {
                bl = false;
                this.trace("DSISwdlSelection.METAINFORESULT_OK");
                this.cSwdlStepSevenGetDevices();
                break;
            }
            default: {
                this.trace().append("[AslTargetCustomerDownload] ").append("default branch: ").append(n).log();
            }
        }
        if (bl) {
            this.warn().append("[AslTargetCustomerDownload] ").append("ERROR while reading metadata in cSWDL RELEASE, trying next release").log();
            this.cSwdlStepFiveCheckReleases();
        }
    }

    private void cSwdlStepSevenGetDevices() {
        this.info().append("[AslTargetCustomerDownload] ").append("Step 7: Calling getDevices").log();
        if (this.searchRequestCancelled) {
            this.info("search aborted by user");
            this.initializeFieldValues();
            return;
        }
        if (AslTargetCarWorkshopDownload.cSwdlIsInhibited) {
            this.info("cSWDL is inhibited by normal SWDL");
            return;
        }
        this.dsiSwdlSelection.setInstallationType(true);
        this.dsiSwdlDeviceInfo.setAccessType(1);
        this.dsiSwdlDeviceInfo.getDevices();
    }

    private void cSwdlStepEightHandleResponseGetDevices(String[] stringArray, int[] nArray) {
        this.info().append("[AslTargetCustomerDownload] ").append("Step 8: processDsiResponseGetDevices").log();
        if (this.searchRequestCancelled) {
            this.info("search aborted by user");
            this.initializeFieldValues();
            return;
        }
        if (AslTargetCarWorkshopDownload.cSwdlIsInhibited) {
            this.info("cSWDL is inhibited by normal SWDL");
            return;
        }
        this.cSwdlFoundDeviceNames = stringArray;
        this.cSwdlFoundDevices = nArray;
        this.cSwdlStepNineSearchForInfoFiles();
    }

    private void cSwdlStepNineSearchForInfoFiles() {
        this.info().append("[AslTargetCustomerDownload] ").append("Step 9a: searching InfoFiles").log();
        if (this.searchRequestCancelled) {
            this.info("search aborted by user");
            this.initializeFieldValues();
            return;
        }
        if (AslTargetCarWorkshopDownload.cSwdlIsInhibited) {
            this.info("cSWDL is inhibited by normal SWDL");
            return;
        }
        ++this.currentDeviceIndexForInfoFileSearch;
        while (this.currentDeviceIndexForInfoFileSearch < this.cSwdlFoundDevices.length && this.checkDeviceInfo(5) && this.checkDeviceInfo(1) && this.checkDeviceInfo(2) && this.checkDeviceInfo(14)) {
            if (this.cSwdlFoundDevices[this.currentDeviceIndexForInfoFileSearch] == 8 || this.cSwdlFoundDevices[this.currentDeviceIndexForInfoFileSearch] == 7 || this.cSwdlFoundDevices[this.currentDeviceIndexForInfoFileSearch] == 6 || this.cSwdlFoundDevices[this.currentDeviceIndexForInfoFileSearch] == 12 || this.cSwdlFoundDevices[this.currentDeviceIndexForInfoFileSearch] == 9 || this.cSwdlFoundDevices[this.currentDeviceIndexForInfoFileSearch] == 13) {
                this.info().append("[AslTargetCustomerDownload] ").append("DSI result contained errors for at least one device during search request .. ABORTING CURRENT DEVICE").log();
                this.cSwdlStepFiveCheckReleases();
                return;
            }
            ++this.currentDeviceIndexForInfoFileSearch;
        }
        this.info().append("[AslTargetCustomerDownload] ").append("Step 9a2 ").log();
        if (this.currentDeviceIndexForInfoFileSearch >= this.cSwdlFoundDevices.length) {
            if (this.foundValueableData) {
                this.sendHmiEventCustomerSwdl(455);
                if (this.uotaDownloadCategory == PACKET_CATEGORY_NAVIDATA) {
                    this.info().append("[AslTargetCustomerDownload] ").append("OTA updates are perfomred without user interaction").log();
                    this.processHmiSetterSetCustomerDownloadState(3);
                    this.lastValidVisibleCustomerDownloadState = this.temporaryState;
                    this.processHmiSetterTriggerCustomerDownload();
                }
            } else {
                this.cSwdlStepFiveCheckReleases();
            }
            return;
        }
        this.info().append("[AslTargetCustomerDownload] ").append(" Step 9b: searching InfoFile on Index: ").append(this.currentDeviceIndexForInfoFileSearch).log();
        this.dsiSwdlDeviceInfo.getInfoFilePath(this.currentDeviceIndexForInfoFileSearch);
    }

    private boolean checkDeviceInfo(int n) {
        return this.cSwdlFoundDevices[this.currentDeviceIndexForInfoFileSearch] != n;
    }

    private void processHmiSetterTriggerCustomerDownload() {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetCustomerDownload] ").append("processHmiSetterTriggerCustomerDownload").log();
        }
        if (this.searchRequestCancelled) {
            this.info("search aborted by user");
            this.initializeFieldValues();
            return;
        }
        if (AslTargetCarWorkshopDownload.cSwdlIsInhibited) {
            this.info("cSWDL is inhibited by normal SWDL");
            return;
        }
        if (this.preventTriggerCustomerDownload) {
            this.warn("cSWDL is inhibited by prevention timeout");
            return;
        }
        if (this.lastValidVisibleCustomerDownloadState != 3) {
            if (!this.inhibitNextRetryUntilInitializationWasDone) {
                this.warn().append("[AslTargetCustomerDownload] ").append("cSWDL is inhibited by as this trigger was not sent from the correct view .. retrying in 1000 ms").log();
                this.startTimer(-1484390144, (long)0, false);
                return;
            }
            if (!this.mediaAvailableNotPerformingWasShownSinceLastInitialization) {
                this.error().append("[AslTargetCustomerDownload] ").append("cSWDL is inhibited by as this trigger was not sent from the correct view .. there will be no further retry").log();
                this.updateHmiGetterCustomerDownloadPerforming(false);
                this.updateHmiGetterCustomerDownloadAvailable(false);
                this.initializeFieldValues();
                return;
            }
            this.info().append("[AslTargetCustomerDownload] ").append("RETRY SUCCESSFUL .. moving on").log();
        }
        if (this.doWeKnowForSureThatACustomerSwdlIsRunning == 0) {
            if (this.cSwdlName.toLowerCase().indexOf("nav") != -1) {
                this.updateHmiGetterCustomerDownloadActiveContext(4);
                this.customerSwdlNameSuccessfullyResolved = true;
            } else if (this.cSwdlName.toLowerCase().indexOf("grace") != -1) {
                this.updateHmiGetterCustomerDownloadActiveContext(3);
                this.customerSwdlNameSuccessfullyResolved = true;
            } else if (this.cSwdlName.toLowerCase().indexOf("poi") != -1) {
                this.updateHmiGetterCustomerDownloadActiveContext(4);
                this.customerSwdlNameSuccessfullyResolved = true;
            } else if (this.cSwdlName.toLowerCase().indexOf("p.o.i.") != -1) {
                this.updateHmiGetterCustomerDownloadActiveContext(4);
                this.customerSwdlNameSuccessfullyResolved = true;
            } else if (this.cSwdlName.toLowerCase().indexOf("interest") != -1) {
                this.updateHmiGetterCustomerDownloadActiveContext(4);
                this.customerSwdlNameSuccessfullyResolved = true;
            } else if (this.cSwdlName.toLowerCase().indexOf("phone") != -1) {
                this.updateHmiGetterCustomerDownloadActiveContext(5);
                this.customerSwdlNameSuccessfullyResolved = true;
            } else if (this.cSwdlName.toLowerCase().indexOf("parrot") != -1) {
                this.updateHmiGetterCustomerDownloadActiveContext(5);
                this.customerSwdlNameSuccessfullyResolved = true;
            } else if (this.cSwdlName.toLowerCase().indexOf("bluetooth") != -1) {
                this.updateHmiGetterCustomerDownloadActiveContext(5);
                this.customerSwdlNameSuccessfullyResolved = true;
            } else if (this.cSwdlName.toLowerCase().indexOf("alps") != -1) {
                this.updateHmiGetterCustomerDownloadActiveContext(5);
                this.customerSwdlNameSuccessfullyResolved = true;
            } else {
                this.warn("Could not Resolve name for cSWDL on Trigger cSWDL");
                this.customerSwdlNameSuccessfullyResolved = false;
            }
            this.updateHmiGetterCustomerDownloadItemRetries(0);
            this.updateHmiGetterCustomerDownloadItemPercent(0);
            this.info().append("[AslTargetCustomerDownload] ").append("ACTIVE CUSTOMER SWDL!").log();
            AslTargetCarWorkshopDownload.cSwdlIsRunning = true;
            this.aslStartupv7rAPI.setNonCustomerSwdlIsInProgress(false);
            customerSwdlStateIsActive = true;
            this.updateHmiGetterCustomerDownloadPerforming(true);
            if (!this.currentOtaPackageName.equals("")) {
                this.updateHmiGetterCustomerDownloadName(new StringBuffer().append("Ongoing download: ").append(this.cSwdlName).append(" (").append(this.currentOtaPackageName).append(")").toString());
            } else {
                this.updateHmiGetterCustomerDownloadName(new StringBuffer().append("Ongoing download: ").append(this.cSwdlName).toString());
            }
            this.searchOrUserChoiceInProgressUserSwdlIsNotRunningNow = false;
            this.helperMethodSetCustomerSwdlRunningAssurenceState(1);
            this.cSwdlStartWasRequestedByUser = true;
            this.dsiSwdlSelection.startDownload();
        } else {
            this.warn().append("[AslTargetCustomerDownload] ").append("cSWDL is (maybe) running, not sending startDownload()").log();
        }
    }

    private void processHmiIndicationSwdlMediumHasChanged(boolean bl) {
        this.trace("processHmiIndicationSwdlMediumHasChanged");
        if (!bl && this.cSwdlPopUp != null && !this.aslStartupv7rAPI.isNonCustomerSwdlIsInProgress() && customerSwdlStateIsActive) {
            this.info().append("[AslTargetCustomerDownload] ").append("Media changed, going to retry...").log();
            this.dsiSwdlProgress.handleUserSelection(this.cSwdlPopUp.popupType, this.cSwdlPopUp.id, 3);
            this.cSwdlPopUp = null;
            this.updateHmiGetterCustomerDownloadPerforming(true);
            this.updateHmiGetterCustomerDownloadAvailable(true);
            this.errorOccuredDuringThisClamp15Cycle = false;
        } else {
            this.info().append("[AslTargetCustomerDownload] ").append("Not all conditions were met for customer SWDL retry trigger Popup set: ").append(this.cSwdlPopUp != null).append(" SWDL in Progress: ").append(!this.aslStartupv7rAPI.isNonCustomerSwdlIsInProgress()).append(" customerSwdl is Active: ").append(customerSwdlStateIsActive).append(" mediaWasRemoved: ").append(bl).log();
        }
    }

    private void processHmiSetterAbortCustomerDownload() {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetCustomerDownload] ").append("processHmiSetterAbortCustomerDownload").log();
        }
        this.abortIsPending = true;
        if (this.cSwdlPopUp != null && !this.aslStartupv7rAPI.isNonCustomerSwdlIsInProgress() && customerSwdlStateIsActive) {
            this.info().append("[AslTargetCustomerDownload] ").append("Complete Abort requested").log();
            this.dsiSwdlProgress.handleUserSelection(1, "", 2);
            this.cSwdlPopUp = null;
        } else {
            this.warn().append("[AslTargetCustomerDownload] ").append("Could not abort, trying general popup for abort").log();
            this.dsiSwdlProgress.handleUserSelection(1, "", 2);
        }
    }

    private void processHmiSetterCancelRequestCustomerDownload() {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetCustomerDownload] ").append("processHmiSetterCancelRequestCustomerDownload").log();
        }
        this.searchRequestCancelled = true;
        this.dsiSwdlSelection.setGotFocus(false);
    }

    private void processHmiSetterCustomerDownloadReboot() {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetCustomerDownload] ").append("processHmiSetterCustomerDownloadReboot").log();
        }
        if (this.rebootAllowed) {
            this.trace("Reboot Allowed, rebooting now...");
            ((DSIPowerManagement)ServiceManager.dsiServiceLocator.getService(this, class$org$dsi$ifc$powermanagement$DSIPowerManagement == null ? (class$org$dsi$ifc$powermanagement$DSIPowerManagement = AslTargetCustomerDownload.class$("org.dsi.ifc.powermanagement.DSIPowerManagement")) : class$org$dsi$ifc$powermanagement$DSIPowerManagement)).rebootSystem();
        } else {
            this.trace("Reboot is not Allowed!!!");
        }
    }

    private void processHmiSetterSetCustomerDownloadState(int n) {
        this.temporaryState = n;
        if (n == 3) {
            this.info().append("[AslTargetCustomerDownload] ").append("mediaAvailableNotPerformingWasShownSinceLastInitialization").log();
            this.mediaAvailableNotPerformingWasShownSinceLastInitialization = true;
            this.updateHmiGetterCustomerDownloadItemPercent(0);
        }
        this.retriggerOrStartTimer(-1534721792, (long)0, false);
    }

    private void processHmiPreventionTimeoutSetCustomerDownloadState() {
        String string = "";
        if (!(this.doWeKnowForSureThatACustomerSwdlIsRunning == 2 || customerSwdlStateIsActive || this.lastValidVisibleCustomerDownloadState != 2 && this.lastValidVisibleCustomerDownloadState != 3 || this.temporaryState != 0)) {
            this.initializeFieldValues();
        }
        if (!this.cSwdlStartWasRequestedByUser && this.temporaryState == 0 && this.lastValidVisibleCustomerDownloadState == 3) {
            this.cSwdlUserLeftMenuAndNotStartedDownloadSoFreshRunMayGetNecessary = true;
        }
        switch (this.temporaryState) {
            case 0: {
                string = "NO_STATE";
                break;
            }
            case 1: {
                string = "MEDIA_REMOVED_PERFORMING";
                this.lastValidVisibleCustomerDownloadState = this.temporaryState;
                break;
            }
            case 2: {
                string = "MEDIA_REMOVED_NOT_PERFORMING";
                this.lastValidVisibleCustomerDownloadState = this.temporaryState;
                break;
            }
            case 3: {
                string = "MEDIA_AVAILABLE_NOT_PERFORMING";
                this.lastValidVisibleCustomerDownloadState = this.temporaryState;
                this.helperMethodSetCustomerSwdlTextVisible(true);
                break;
            }
            case 4: {
                string = "MEDIA_AVAILABLE_PERFORMING";
                this.lastValidVisibleCustomerDownloadState = this.temporaryState;
                if (!this.tempTriggerErrorPending) break;
                this.tempTriggerErrorPending = false;
                this.errorOccuredDuringThisClamp15Cycle = true;
                this.updateHmiGetterCustomerDownloadAvailable(false);
                if (this.aslStartupv7rAPI.isHighActivatorStarted()) {
                    this.helperMethodParseRCCUpdateTxt();
                    this.customerSwdlNameSuccessfullyResolved = true;
                }
                this.sendHmiEventCustomerSwdl(448);
                break;
            }
        }
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetCustomerDownload] ").append("processHmiSetterSetCustomerDownloadState state: ").append(string).log();
        }
    }

    private void processHmiSetterRequestCustomerDownload() {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetCustomerDownload] ").append("processHmiSetterRequestCustomerDownload").log();
        }
        if (AslTargetCarWorkshopDownload.cSwdlIsInhibited) {
            this.info().append("[AslTargetCustomerDownload] ").append("cSWDL is inhibited by normal SWDL").log();
            return;
        }
        if (this.cSwdlUserLeftMenuAndNotStartedDownloadSoFreshRunMayGetNecessary) {
            this.cSwdlUserLeftMenuAndNotStartedDownloadSoFreshRunMayGetNecessary = false;
            if (!this.cSwdlAtLeastOneRelevantProgressUpdateForSwdlWasReceivedSinceUserInteraction) {
                this.initializeFieldValues();
            }
        }
        if (!this.aslStartupv7rAPI.isNonCustomerSwdlIsInProgress() && customerSwdlStateIsActive && this.doWeKnowForSureThatACustomerSwdlIsRunning != 0) {
            this.info().append("[AslTargetCustomerDownload] ").append("cSWDL is already running, skipping request").log();
            if (!this.errorOccuredDuringThisClamp15Cycle) {
                this.info().append("[AslTargetCustomerDownload] ").append("set cSWDL available").log();
                this.updateHmiGetterCustomerDownloadAvailable(true);
            } else {
                this.info().append("[AslTargetCustomerDownload] ").append("cSWDL ERROR pending...").log();
            }
            this.sendHmiEventCustomerSwdl(455);
            return;
        }
        this.info().append("[AslTargetCustomerDownload] ").append("Got trigger ... and GO!!").log();
        this.initializeFieldValues();
        this.searchOrUserChoiceInProgressUserSwdlIsNotRunningNow = true;
        this.helperMethodSetCustomerSwdlTextVisible(false);
        this.cSwdlStepZeroCheckDeviceAndMediaInformation();
    }

    private void processHmiSetterRequestUotACustomerDownload() {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetCustomerDownload] ").append("processHmiSetterRequestUotACustomerDownload").log();
        }
        if (AslTargetCarWorkshopDownload.cSwdlIsInhibited) {
            this.info().append("[AslTargetCustomerDownload] ").append("UotA cSWDL is inhibited by normal SWDL").log();
            return;
        }
        if (this.cSwdlUserLeftMenuAndNotStartedDownloadSoFreshRunMayGetNecessary) {
            this.cSwdlUserLeftMenuAndNotStartedDownloadSoFreshRunMayGetNecessary = false;
            if (!this.cSwdlAtLeastOneRelevantProgressUpdateForSwdlWasReceivedSinceUserInteraction) {
                this.initializeFieldValues();
            }
        }
        if (!this.aslStartupv7rAPI.isNonCustomerSwdlIsInProgress() && customerSwdlStateIsActive && this.doWeKnowForSureThatACustomerSwdlIsRunning == 2) {
            this.info().append("[AslTargetCustomerDownload] ").append("(UotA ) cSWDL is already running, skipping request").log();
            if (!this.errorOccuredDuringThisClamp15Cycle) {
                this.updateHmiGetterCustomerDownloadAvailable(true);
            } else {
                this.info().append("[AslTargetCustomerDownload] ").append("(UotA) cSWDL ERROR pending...").log();
            }
            this.sendHmiEventCustomerSwdl(455);
            return;
        }
        this.info().append("[AslTargetCustomerDownload] ").append("(UotA) Got trigger ... and GO!!").log();
        this.initializeFieldValues();
        this.searchOrUserChoiceInProgressUserSwdlIsNotRunningNow = true;
        this.cSwdlUotAStepZeroCheckDeviceAndMediaInformation();
    }

    private void processHmiResumeUotaCustomerDownload() {
        this.logger.warn(4096).append("After an incomplete installation the download will be resumed - Uota not trigger").log();
        this.currentCustomerSwdlSourceDevice = 7;
        this.isTriggerReadingMetainfoActive = false;
    }

    private void handleCustomerDownloadFinishedOkButtonPressedEvent() {
        ServiceManager.eventMain.getServiceRegister().triggerObserver(1628971776);
        this.rebootAllowed = true;
        this.showRebootPopup = true;
        if (this.currentCustomerSwdlDevice != 4 && !this.uotaModeIsActiveSoIgnoreOtherMedia && !this.customerDownloadRestartDisabledInGeneral) {
            this.initializeFieldValues();
            this.sendHmiEventCustomerSwdl(449);
        } else {
            this.initializeFieldValues();
            if (this.customerDownloadRestartDisabledInGeneral) {
                this.info("Restart will be omitted, as it is disabled by runtime config");
            } else if (this.uotaModeIsActiveSoIgnoreOtherMedia) {
                this.info("Restart will be omitted, as it is UOtA SWDL");
            } else {
                this.info("Restart will be omitted for Nav cSWDL");
            }
        }
    }

    private void processDsiUpdateDeviceOverviewProgress(DeviceOverviewProgress[] deviceOverviewProgressArray) {
        this.cSwdlAtLeastOneRelevantProgressUpdateForSwdlWasReceivedSinceUserInteraction = true;
        if (AslTargetCarWorkshopDownload.cSwdlIsInhibited) {
            this.info("cSWDL is inhibited by normal SWDL");
            return;
        }
        if (!this.aslStartupv7rAPI.isNonCustomerSwdlIsInProgress() && customerSwdlStateIsActive) {
            int n;
            this.updateHmiGetterCustomerDownloadPerforming(true);
            this.updateHmiGetterCustomerDownloadAvailable(true);
            if (!this.customerSwdlNameSuccessfullyResolved) {
                this.info("Trying to resolve CSWDL from update file");
                this.customerSwdlNameSuccessfullyResolved = this.helperMethodParseRCCUpdateTxt();
                int n2 = n = deviceOverviewProgressArray[0].type == 1 ? 1 : 0;
                if (!this.customerSwdlNameSuccessfullyResolved && n != 0) {
                    String string = deviceOverviewProgressArray[0].fileName;
                    if (string.toLowerCase().indexOf("nav") != -1) {
                        this.updateHmiGetterCustomerDownloadActiveContext(4);
                        this.customerSwdlNameSuccessfullyResolved = true;
                        this.cSwdlName = "NavDB";
                    } else if (string.toLowerCase().indexOf("grace") != -1) {
                        this.updateHmiGetterCustomerDownloadActiveContext(3);
                        this.customerSwdlNameSuccessfullyResolved = true;
                        this.cSwdlName = "Gracenote";
                    } else if (string.toLowerCase().indexOf("poi") != -1) {
                        this.updateHmiGetterCustomerDownloadActiveContext(4);
                        this.customerSwdlNameSuccessfullyResolved = true;
                    } else if (this.cSwdlName.toLowerCase().indexOf("p.o.i.") != -1) {
                        this.updateHmiGetterCustomerDownloadActiveContext(4);
                        this.customerSwdlNameSuccessfullyResolved = true;
                    } else if (this.cSwdlName.toLowerCase().indexOf("interest") != -1) {
                        this.updateHmiGetterCustomerDownloadActiveContext(4);
                        this.customerSwdlNameSuccessfullyResolved = true;
                    } else if (string.toLowerCase().indexOf("phone") != -1) {
                        this.updateHmiGetterCustomerDownloadActiveContext(5);
                        this.customerSwdlNameSuccessfullyResolved = true;
                    } else if (string.toLowerCase().indexOf("parrot") != -1) {
                        this.updateHmiGetterCustomerDownloadActiveContext(5);
                        this.customerSwdlNameSuccessfullyResolved = true;
                    } else if (string.toLowerCase().indexOf("bluetooth") != -1) {
                        this.updateHmiGetterCustomerDownloadActiveContext(5);
                        this.customerSwdlNameSuccessfullyResolved = true;
                    } else if (string.toLowerCase().indexOf("alps") != -1) {
                        this.updateHmiGetterCustomerDownloadActiveContext(5);
                        this.customerSwdlNameSuccessfullyResolved = true;
                    } else {
                        this.warn("Could not Resolve name for cSWDL from update");
                        this.customerSwdlNameSuccessfullyResolved = false;
                    }
                }
            }
            this.trace("processDsiUpdateDeviceOverviewProgress");
            for (n = 0; n < deviceOverviewProgressArray.length; ++n) {
                if (this.unwantedRebootDetectedSoEvaluatePosition && deviceOverviewProgressArray[n].getValue() > 0 && deviceOverviewProgressArray[n].getValue() < 100) {
                    this.unwantedRebootDetectedSoEvaluatePosition = false;
                    for (int i2 = 0; i2 < this.modulesInRccUpdateTxt.size(); ++i2) {
                        if (((String)this.modulesInRccUpdateTxt.elementAt(i2)).indexOf(deviceOverviewProgressArray[n].fileName) <= -1) continue;
                        this.trace("Found a valid position: ", i2);
                        this.cSwdlModuleCountForUpdate = this.modulesInRccUpdateTxt.size() - i2;
                        this.cSwdlFinishedModuleCountForUpdate = i2;
                        this.updateHmiGetterCustomerDownloadItemsRemaining(this.cSwdlModuleCountForUpdate);
                        this.updateHmiGetterCustomerDownloadItemsSucceeded(this.cSwdlFinishedModuleCountForUpdate);
                    }
                }
                if (this.isTraceEnabled()) {
                    this.trace().append("[AslTargetCustomerDownload] ").append(deviceOverviewProgressArray[n].fileName).append(": ").append(deviceOverviewProgressArray[n].value).append("percent").log();
                }
                if (deviceOverviewProgressArray[n].type == 1) {
                    this.updateHmiGetterCustomerDownloadItemPercent(deviceOverviewProgressArray[n].value);
                } else if (deviceOverviewProgressArray[n].type == 2) {
                    this.warn().append("[AslTargetCustomerDownload] ").append("South side provides PrgressTimeout values");
                }
                if (!AslTargetCarWorkshopDownload.cSwdlIsRunning && deviceOverviewProgressArray[n].value > 0) {
                    this.info().append("[AslTargetCustomerDownload] ").append("DETECTED ONGOING CUSTOMER SWDL!").log();
                    AslTargetCarWorkshopDownload.cSwdlIsRunning = true;
                }
                if (this.cSwdlLastProgressValue == 100 && this.cSwdlLastProgressValue > deviceOverviewProgressArray[n].value) {
                    --this.cSwdlModuleCountForUpdate;
                    ++this.cSwdlFinishedModuleCountForUpdate;
                    this.updateHmiGetterCustomerDownloadItemsRemaining(this.cSwdlModuleCountForUpdate);
                    this.updateHmiGetterCustomerDownloadItemsSucceeded(this.cSwdlFinishedModuleCountForUpdate);
                }
                this.cSwdlLastProgressValue = deviceOverviewProgressArray[n].value;
            }
        }
    }

    private void processDsiUpdateGeneralDownloadProgress(GeneralProgress generalProgress) {
        this.cSwdlAtLeastOneRelevantProgressUpdateForSwdlWasReceivedSinceUserInteraction = true;
        if (!this.aslStartupv7rAPI.isNonCustomerSwdlIsInProgress() && customerSwdlStateIsActive) {
            this.updateHmiGetterCustomerDownloadPerforming(true);
            this.helperMethodSetCustomerSwdlRunningAssurenceState(2);
            this.trace("processDsiUpdateGeneralDownloadProgress");
            int n = this.aslStartupv7rAPI.isHighActivatorStarted() ? generalProgress.updatingDevices - (generalProgress.finishedDevicesWithError + generalProgress.finishedDevicesWithoutError + generalProgress.unavailableDevices) : generalProgress.maxStage - generalProgress.activeDevices + 1 - generalProgress.finishedDevicesWithError - generalProgress.finishedDevicesWithoutError - generalProgress.unavailableDevices;
            if (this.isTraceEnabled()) {
                this.trace().append("[AslTargetCustomerDownload] ").append("maxStage:").append(generalProgress.maxStage).log();
                this.trace().append("[AslTargetCustomerDownload] ").append("currentStage:").append(generalProgress.currentStage).log();
                this.trace().append("[AslTargetCustomerDownload] ").append("activedevices:").append(generalProgress.activeDevices).log();
                this.trace().append("[AslTargetCustomerDownload] ").append("fwoerrdevices:").append(generalProgress.finishedDevicesWithoutError).log();
                this.trace().append("[AslTargetCustomerDownload] ").append("fwierrdevices:").append(generalProgress.finishedDevicesWithError).log();
                this.trace().append("[AslTargetCustomerDownload] ").append("unavailablede:").append(generalProgress.unavailableDevices).log();
            }
            if (n == 0) {
                if (this.isTraceEnabled()) {
                    this.trace().append("[AslTargetCustomerDownload] ").append("activedevices:").append(generalProgress.activeDevices).log();
                    this.trace().append("[AslTargetCustomerDownload] ").append("fwoerrdevices:").append(generalProgress.finishedDevicesWithoutError).log();
                    this.trace().append("[AslTargetCustomerDownload] ").append("fwierrdevices:").append(generalProgress.finishedDevicesWithError).log();
                    this.trace().append("[AslTargetCustomerDownload] ").append("unavailablede:").append(generalProgress.unavailableDevices).log();
                    this.trace("Warn: FALLBACK REMAINING ELEMENTS USED");
                }
                n = 1;
            }
            if (this.isTraceEnabled()) {
                this.trace().append("[AslTargetCustomerDownload] ").append(" Remaining: ").append(n).log();
            }
            AslTargetCustomerDownload.writeIntegerToDatapool(380, generalProgress.finishedDevicesWithoutError);
            AslTargetCustomerDownload.writeIntegerToDatapool(381, generalProgress.finishedDevicesWithError);
            AslTargetCustomerDownload.writeIntegerToDatapool(382, generalProgress.unavailableDevices);
            AslTargetCustomerDownload.writeBooleanToDatapool(384, generalProgress.finishedDevicesWithError > 0 || generalProgress.unavailableDevices > 0);
        }
    }

    private void processDsiUpdateTriggerPanel(int n) {
        this.cSwdlAtLeastOneRelevantProgressUpdateForSwdlWasReceivedSinceUserInteraction = true;
        if (AslTargetCarWorkshopDownload.cSwdlIsInhibited) {
            this.info("cSWDL is inhibited by normal SWDL");
            return;
        }
        if (!this.aslStartupv7rAPI.isNonCustomerSwdlIsInProgress() && customerSwdlStateIsActive) {
            if (this.isTraceEnabled()) {
                this.trace().append("[AslTargetCustomerDownload] ").append("processDsiUpdateTriggerPanel trigger Panel ").append(n).log();
            }
            if (n != 1) {
                if (n == 2) {
                    if (!this.abortVersionUploadAlreadySent) {
                        this.abortVersionUploadAlreadySent = true;
                        this.dsiSwdlSelection.abortVersionUpload();
                    }
                    this.helperMethodSetCustomerSwdlTextVisible(false);
                    this.updateHmiGetterCustomerDownloadPerforming(false);
                    this.updateHmiGetterCustomerDownloadActiveContext(0);
                    this.trace("Starting protection timer to circumvent a wrong TriggerUpdateCondition");
                    this.preventTriggerCustomerDownload = true;
                    this.startTimer(-1551499008, (long)0, false);
                    if (this.abortIsPending) {
                        this.wasAbortedDuringThisClamp15Cycle = true;
                        this.abortIsPending = false;
                        this.rebootAllowed = true;
                        ServiceManager.eventMain.getServiceRegister().triggerObserver(1628971776);
                        if (this.currentCustomerSwdlSourceDevice == 7) {
                            ServiceManager.eventMain.getServiceRegister().triggerObserver(1662526208);
                        }
                        ((DSIPowerManagement)this.downloadServices.getDsiProxy().getService(this, class$org$dsi$ifc$powermanagement$DSIPowerManagement == null ? (class$org$dsi$ifc$powermanagement$DSIPowerManagement = AslTargetCustomerDownload.class$("org.dsi.ifc.powermanagement.DSIPowerManagement")) : class$org$dsi$ifc$powermanagement$DSIPowerManagement)).rebootSystem();
                    }
                    this.info().append("[AslTargetCustomerDownload] ").append("DONE!!! Installed data can be used now").log();
                    customerSwdlFinishedDuringThisClamp15Cycle = true;
                    AslTargetCarWorkshopDownload.cSwdlIsRunning = false;
                    this.dsiSwdlDeviceInfo.setAccessType(2);
                    this.dsiSwdlDeviceInfo.getDevices();
                } else if (n == 3) {
                    this.dsiSwdlSelection.setUserSwdl(true);
                    AslTargetCarWorkshopDownload.dsiSwdlHasFocus = true;
                    this.dsiSwdlSelection.setGotFocus(true);
                    AslTargetCarWorkshopDownload.cSwdlIsRunning = true;
                    this.isTriggerReadingMetainfoActive = true;
                }
            }
        }
    }

    private void processDsiUpdatePowerManagementState(int n) {
        this.trace("Received update PowerManagement");
        this.currentlyKnownPowerState = n;
        if (n != 0 && this.showRebootPopup) {
            this.info().append("[AslTargetCustomerDownload] ").append("Powerstate Changed while showing reboot Popup, retriggering...").log();
            this.sendHmiEventCustomerSwdl(449);
        } else if ((n == 1 || n == 6) && this.errorOccurredDuringUnnormalPowerState && !this.abortIsPending) {
            this.info("Error occurred during !powerOn, commiting it after 3 sec timeout");
            this.errorOccurredDuringUnnormalPowerState = false;
            this.startTimer(-1517944576, (long)0, false);
        } else if (this.abortIsPending) {
            this.info().append("[AslTargetCustomerDownload] ").append("Abort already issued, dismissing following errors").log();
        }
    }

    private void initializeFieldValues() {
        this.trace("Reinitializing all customerSWDL related fields");
        this.uotaModeIsActiveSoIgnoreOtherMedia = false;
        this.searchOrUserChoiceInProgressUserSwdlIsNotRunningNow = false;
        customerSwdlStateIsActive = false;
        this.updateHmiGetterCustomerDownloadPerforming(false);
        this.awaitedSwdlMediaType = -1;
        this.cSwdlDeviceName = "";
        this.cSwdlName = "";
        this.cSwdlVersion = "";
        this.cSwdlInfoFilePath = "";
        this.cSwdlModuleCountForUpdate = 0;
        this.cSwdlFinishedModuleCountForUpdate = 0;
        this.cSwdlLastProgressValue = 0;
        this.cSwdlStartWasRequestedByUser = false;
        this.cSwdlAtLeastOneRelevantProgressUpdateForSwdlWasReceivedSinceUserInteraction = false;
        this.currentCustomerSwdlDevice = 0;
        this.cSwdlFoundDevices = null;
        this.errorOccurredDuringUnnormalPowerState = false;
        this.currentDeviceIndexForInfoFileSearch = -1;
        this.currentSearchDevicesFound = new int[]{0, 0, 0, 0};
        this.currentSearchDevicesFoundIndexPointer = -1;
        MAX_NUMBER_OF_CSWDL_MEDIA = this.currentSearchDevicesFound.length;
        this.gotMediaForCurrentSession = null;
        this.helperMethodSetCustomerSwdlRunningAssurenceState(0);
        this.updateHmiGetterCustomerDownloadActiveContext(0);
        this.updateHmiGetterCustomerDownloadName("---");
        if (!customerSwdlFinishedDuringThisClamp15Cycle) {
            this.updateHmiGetterCustomerDownloadAvailable(false);
        }
        this.abortIsPending = false;
        this.foundValueableData = false;
        this.searchRequestCancelled = false;
        this.showRebootPopup = false;
        this.abortVersionUploadAlreadySent = false;
        this.wasAbortedDuringThisClamp15Cycle = false;
        this.helperMethodSetCustomerSwdlTextVisible(true);
        this.inhibitNextRetryUntilInitializationWasDone = false;
        this.mediaAvailableNotPerformingWasShownSinceLastInitialization = false;
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
        EOL = System.getProperty("line.separator");
        MAX_NUMBER_OF_CSWDL_MEDIA = 4;
        PACKET_CATEGORY_NAVIDATA = 1;
    }
}


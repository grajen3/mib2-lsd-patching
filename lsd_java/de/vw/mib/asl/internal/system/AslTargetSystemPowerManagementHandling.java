/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system;

import de.vw.mib.asl.api.download.ASLDownloadFactory;
import de.vw.mib.asl.api.speechengine.messenger.dialog.DialogStateRouter;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponents;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetService;
import de.vw.mib.asl.framework.api.displaymanagement.ASLDisplaymanagementFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyAdapterFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.api.persistence.IPersistableEarlyData;
import de.vw.mib.asl.framework.api.persistence2.ProfileChangeListener;
import de.vw.mib.asl.framework.api.startupv7r.ASLStartupv7rFactory;
import de.vw.mib.asl.framework.api.startupv7r.startupstate.StartupStateService;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.asl.internal.impl.system.SystemServicesProvider;
import de.vw.mib.asl.internal.impl.system.powerstate.PropagatingPowerStateService;
import de.vw.mib.asl.internal.system.AslTargetSystemPowerManagementHandling$1;
import de.vw.mib.asl.internal.system.AslTargetSystemPowerManagementHandling$2;
import de.vw.mib.asl.internal.system.AslTargetSystemPowerManagementHandling$3;
import de.vw.mib.asl.internal.system.AslTargetSystemPowerManagementHandling$4;
import de.vw.mib.asl.internal.system.AslTargetSystemPowerManagementHandling$5;
import de.vw.mib.asl.internal.system.AslTargetSystemPowerManagementHandling$6;
import de.vw.mib.asl.internal.system.PowerManagementStartupListener;
import de.vw.mib.asl.internal.system.SystemAccessor;
import de.vw.mib.asl.internal.system.SystemServices;
import de.vw.mib.asl.internal.system.emergency.EmergencyAnnouncementServiceImpl;
import de.vw.mib.asl.internal.system.processor.manager.ClockManager;
import de.vw.mib.asl.internal.system.proximity.ProximityServiceImpl;
import de.vw.mib.asl.internal.system.proximity.component.AbstractProximityComponent;
import de.vw.mib.asl.internal.system.util.SystemLogger;
import de.vw.mib.asl.systemcommon.persistence.SystemCommonPersistenceService;
import de.vw.mib.asl.systemcommon.persistence.SystemCommonPersistenceServiceImpl;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.event.PopupStackChangeEvent;
import de.vw.mib.event.consumer.PopupStackChangeEventConsumer;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.GenericEvents;
import org.dsi.ifc.audio.DSISound;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.displaymanagement.DSIDisplayManagement;
import org.dsi.ifc.powermanagement.ClampSignal;
import org.dsi.ifc.powermanagement.DSIPowerManagement;
import org.dsi.ifc.powermanagement.DSIPowerManagementListener;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public final class AslTargetSystemPowerManagementHandling
extends AbstractASLTarget
implements PopupStackChangeEventConsumer,
DSIServiceStateListener {
    static final int EV_ASL_CANCEL_TEMP_SHUTDOWN_TIMER;
    private static final int SOUND_STATE_MUTE;
    private static final int SOUND_STATE_UNMUTE;
    private static final long DISPLAY_NIGHTMODE_TIME;
    private static final long TEMPERATURE_SHUTDOWN_TIME;
    static final int EV_ASL_DISPLAY_NIGHTMODE_TIMER;
    private static final int EV_POPUP_EVENT;
    private static final int EV_POPUP_EVENT_NUM_POPUPS;
    private static final int EV_POPUP_EVENT_NUM_USERPERCEIVEDOFF_POPUPS;
    private static final int DISPLAY_WAKEUP_REASON_MASK_C0_SPEECH_ACTIVE;
    private static final int DISPLAY_WAKEUP_REASON_MASK_C1_KEYBOARD_INTERACTION;
    private static final int DISPLAY_WAKEUP_REASON_MASK_C2_PROXIMITY_SENSOR_APPROXIMATED;
    private static final int DISPLAY_WAKEUP_REASON_MASK_C3_POPUP_COUNT_INCREMENT;
    private static final int DISPLAY_WAKEUP_REASON_MASK_C4_RVC_ACTIVE;
    private static final int DISPLAY_WAKEUP_REASON_MASK_C5_POWERSTATE_CHANGED;
    private static final int DISPLAY_WAKEUP_REASON_MASK_C6_MEDIA_CHANGED;
    private static final int DISPLAY_SLEEP_REASON_MASK_C0_SPEECH_INACTIVE;
    private static final int DISPLAY_SLEEP_REASON_MASK_C1_KEYBOARD_INTERACTION_HAS_ENDED;
    private static final int DISPLAY_SLEEP_REASON_MASK_C2_PROXIMITY_SENSOR_NOT_APPROXIMATED;
    private static final int DISPLAY_SLEEP_REASON_MASK_C3_POPUP_COUNT_DECREMENT;
    private static final int DISPLAY_SLEEP_REASON_MASK_C4_RVC_INACTIVE;
    private static final int DISPLAY_SLEEP_REASON_MASK_C5_POWERSTATE_CHANGED;
    private static final int DISPLAY_SLEEP_REASON_MASK_C6_MEDIA_CHANGED;
    private static final int DISPLAY_SLEEP_REASON_MASK_C7_DISPLAY_OFF_MODE_WAS_ACTIVATED;
    private DSIPowerManagement dsiPowerManagement;
    private DSIDisplayManagement dsiDisplayManagement = null;
    private boolean useOnErrorScreen = false;
    private boolean isDisplayManagementReady = false;
    private boolean displayState = false;
    private boolean pendingDisplayState = false;
    private boolean isDisplayStatePending = false;
    private int pendingAudioState = -1;
    private boolean soundConnectionTargetIsReady = false;
    private boolean guidanceTargetIsReady = false;
    private boolean koreaExBoxMTargetIsReady = false;
    private boolean timeIsValid = false;
    private boolean clamp15IsValid = false;
    private final IPersistableEarlyData persistableEarlyData = SystemServicesProvider.getSystemServices().getPersistableEarlyData();
    private int minutesSinceLastClamp15Off = -1;
    private boolean valueClamp15 = false;
    private boolean valueClampS = false;
    private boolean valueClamp50 = false;
    private boolean isMuteTheftProtectionActive = false;
    private boolean isComponentProtectionInitialPopupShown = false;
    private boolean isComponentProtectionPermanentPopupShown = false;
    private boolean climaContextIsActive = false;
    private boolean displayNightMode = false;
    private boolean backlightOn = true;
    private int currentBEMState = -1;
    private boolean batteryShutdownActive = false;
    private boolean bemPrewarningPopupShown = false;
    private boolean temperatureShutdownActive = false;
    private int hmiState = 5;
    private int soundState = -1;
    private boolean rvcOpsIsActive = false;
    private int powerManagementState;
    private int lastKnownPowerManagementState = this.powerManagementState = -1;
    private boolean displayNightmodeTimerActive = false;
    private boolean displayManagementDimDisplayPending = false;
    private boolean displayManagementPendingDimDisplayValue = false;
    private int currentCountOfDisplayedPopups = 0;
    private int currentCountOfUserPerceivedOffPopups = 0;
    private int currentlyActiveWakeupReasons = 0;
    private long lastRvcActivationTime = -1L;
    private final SystemCommonPersistenceService systemCommonPersistenceService = SystemCommonPersistenceServiceImpl.getInstance();
    private ClockManager standByClockManager;
    private ConfigurationManagerDiag configManagerDiag;
    private ClockManager displayOffClockManager;
    private SystemServices systemServices;
    private SystemLogger systemLogger;
    static /* synthetic */ Class class$org$dsi$ifc$audio$DSISound;
    static /* synthetic */ Class class$org$dsi$ifc$displaymanagement$DSIDisplayManagement;
    static /* synthetic */ Class class$de$vw$mib$event$consumer$PopupStackChangeEventConsumer;
    static /* synthetic */ Class class$org$dsi$ifc$powermanagement$DSIPowerManagement;
    static /* synthetic */ Class class$org$dsi$ifc$powermanagement$DSIPowerManagementListener;
    static /* synthetic */ Class class$org$dsi$ifc$audio$DSISoundListener;
    static /* synthetic */ Class class$de$vw$mib$asl$api$speechengine$SpeechEngine;

    public AslTargetSystemPowerManagementHandling(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.initializeTarget();
    }

    public AslTargetSystemPowerManagementHandling(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.initializeTarget();
    }

    private void initializeTarget() {
        SystemAccessor.setPowerManagementTarget(this);
        DSIProxy dSIProxy = SystemServicesProvider.getSystemServices().getDsiProxy();
        dSIProxy.addServiceStateListener(class$org$dsi$ifc$audio$DSISound == null ? (class$org$dsi$ifc$audio$DSISound = AslTargetSystemPowerManagementHandling.class$("org.dsi.ifc.audio.DSISound")) : class$org$dsi$ifc$audio$DSISound, this);
        dSIProxy.addServiceStateListener(class$org$dsi$ifc$displaymanagement$DSIDisplayManagement == null ? (class$org$dsi$ifc$displaymanagement$DSIDisplayManagement = AslTargetSystemPowerManagementHandling.class$("org.dsi.ifc.displaymanagement.DSIDisplayManagement")) : class$org$dsi$ifc$displaymanagement$DSIDisplayManagement, this);
        this.systemLogger = new SystemLogger(this.getTextLogger(), super.getClass());
    }

    @Override
    public int getSubClassifier() {
        return 2048;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 5: {
                this.processPing(eventGeneric);
                break;
            }
            case 106: {
                this.processPowerOn();
                break;
            }
            case 4300046: {
                boolean bl = this.configManagerDiag.isFeatureFlagSet(69);
                boolean bl2 = this.retrieveShowDisplayablesProperty();
                if (!bl2 || !bl) {
                    this.systemLogger.info("Received SET_HMI_READY, Call DSIPowerManagement.setHMIReady");
                    this.dsiPowerManagement.setHMIReady();
                    EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(this.getTargetId(), 0x171100, 245186816);
                    this.send(eventGeneric2);
                }
                this.switchPendingDisplayState();
                break;
            }
            case 4300052: {
                this.timeIsValid = true;
                if (this.clamp15IsValid) {
                    long l = this.persistableEarlyData.getLastClamp15OffTimestamp();
                    if (l != -1L) {
                        this.minutesSinceLastClamp15Off = (int)((SystemAccessor.getDateTarget().getCurrentTimestamp() - l) / 0);
                        if (this.minutesSinceLastClamp15Off < 0) {
                            this.minutesSinceLastClamp15Off = -1;
                        }
                    } else {
                        this.minutesSinceLastClamp15Off = -1;
                    }
                    this.systemLogger.trace(new Object[]{"VALID_TIME_DATE_AVAILABLE lastClamp15OffTimestamp: ", new Long(l), " minutesSinceLastClamp15Off ", new Integer(this.minutesSinceLastClamp15Off)});
                }
                this.setMinutesSinceLastClamp15Off();
                break;
            }
            case 4300061: {
                this.systemLogger.trace("ASLSystemServiceIds.CANCEL_PARKING_POPUP received!");
                this.putDisplayAsleep(16);
                this.rvcOpsIsActive = false;
                this.calculateHMIAndDisplayState();
                break;
            }
            case 4300085: {
                this.systemLogger.trace("ASLSystemServiceIds.OPEN_PARKING_POPUP received!");
                this.putDisplayAwake(16);
                this.rvcOpsIsActive = true;
                this.calculateHMIAndDisplayState();
                break;
            }
            case 4300090: {
                this.climaContextIsActive = true;
                this.systemLogger.trace(new Object[]{"ASLSystemServiceIds.OPEN_CLIMATE_VIEW climaContextIsActive: ", new Boolean(this.climaContextIsActive)});
                this.calculateHMIAndDisplayState();
                break;
            }
            case 4300091: {
                this.climaContextIsActive = false;
                this.systemLogger.trace(new Object[]{"ASLSystemServiceIds.CLOSE_CLIMATE_VIEW climaContextIsActive: ", new Boolean(this.climaContextIsActive)});
                this.calculateHMIAndDisplayState();
                break;
            }
            case 4300062: {
                this.systemLogger.trace("ASLSystemServiceIds.RELOAD_PERSISTABLES received!");
                this.initDataFromPersistence();
                break;
            }
            case 100003: {
                this.processPopupEvent(eventGeneric);
                break;
            }
            case 4300083: {
                this.processErrorState();
                break;
            }
            case 1073743193: {
                if (this.displayNightMode) {
                    this.stopDisplayNightModeTimer();
                    this.displayNightMode = false;
                    this.systemLogger.trace("TOGGLE_DISPLAY_OFF_MODE: Now off");
                } else {
                    this.systemLogger.trace("TOGGLE_DISPLAY_OFF_MODE: Now on");
                    this.displayNightMode = true;
                    this.putDisplayAsleep(128);
                }
                AslTargetSystemPowerManagementHandling.writeBooleanToDatapool(1661, this.displayNightMode);
                break;
            }
            case 100001: {
                if (!this.displayNightmodeTimerActive) break;
                this.displayNightmodeTimerActive = false;
                if (this.hmiState != 2) break;
                this.systemLogger.trace("nightmode timer elapsed!!!, call setBacklight(false)!");
                this.setBacklight(false);
                break;
            }
            case 100002: {
                this.stopCancelTempShutdownTimer();
                break;
            }
            case 4300044: {
                this.putDisplayAwake(2);
                break;
            }
            case 4300045: {
                this.putDisplayAsleep(2);
                break;
            }
            case 3000000: {
                this.putDisplayAwake(64);
                this.putDisplayAsleep(64);
                break;
            }
        }
    }

    @Override
    public void consumeEvent(PopupStackChangeEvent popupStackChangeEvent) {
        int n = this.getTargetId();
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(n, n, -1551499008);
        eventGeneric.setInt(0, popupStackChangeEvent.getNumberOfPopups());
        eventGeneric.setInt(1, popupStackChangeEvent.getNumberOfUserPerceivedOffPopups());
        try {
            this.send(eventGeneric);
        }
        catch (GenericEventException genericEventException) {
            this.error(genericEventException);
        }
    }

    public void dsiPowerManagementAsyncException(int n, String string, int n2) {
        this.systemLogger.warn(new StringBuffer().append("dsiPowerManagementAsyncException! Error code = ").append(n).append(", message = ").append(string).append(", request type = ").append(n2).toString());
    }

    public void dsiPowerManagementUpdateBEMState(int n, int n2) {
        if (n2 == 1) {
            this.systemLogger.info(new StringBuffer().append("dsiPowerManagementUpdateBEMState ").append(n).toString());
            if (n != this.currentBEMState) {
                switch (n) {
                    case 0: 
                    case 1: 
                    case 6: {
                        this.updateUncriticalBemState(n);
                        break;
                    }
                    case 2: 
                    case 3: {
                        this.updateCriticalBemState(n);
                        break;
                    }
                    case 4: {
                        this.systemLogger.info("BEM State: Transport Mode");
                        break;
                    }
                    case 5: {
                        this.systemLogger.info("BEM State: Ruhestrommessmodus");
                        break;
                    }
                    default: {
                        this.systemLogger.error(new StringBuffer().append("Unknown BEM State: ").append(n).toString());
                    }
                }
            }
        }
        this.updateAudioState();
    }

    public void dsiPowerManagementUpdateClampSignal(ClampSignal clampSignal, int n) {
        if (n == 1) {
            boolean bl;
            boolean bl2;
            this.systemLogger.info(new StringBuffer().append("dsiPowerManagementUpdateClampSignal ").append(clampSignal).toString());
            boolean bl3 = clampSignal.clampS;
            if (bl3 != this.valueClampS) {
                AslTargetSystemPowerManagementHandling.writeBooleanToDatapool(1685, bl3);
                if (bl3 && this.displayNightMode) {
                    this.displayNightMode = false;
                    this.stopDisplayNightModeTimer();
                    AslTargetSystemPowerManagementHandling.writeBooleanToDatapool(1661, false);
                    this.setBacklight(true);
                }
                this.valueClampS = bl3;
                EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-476299008);
                eventGeneric.setBoolean(0, bl3);
                this.sendSafe(eventGeneric);
            }
            if ((bl2 = clampSignal.clamp50) != this.valueClamp50) {
                this.valueClamp50 = bl2;
                EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-442744576);
                eventGeneric.setBoolean(0, bl2);
                this.sendSafe(eventGeneric);
            }
            if ((bl = clampSignal.clamp15) != this.valueClamp15) {
                long l;
                if (bl) {
                    this.clamp15IsValid = true;
                    l = this.persistableEarlyData.getLastClamp15OffTimestamp();
                    if (l == -1L) {
                        this.minutesSinceLastClamp15Off = -1;
                    } else if (this.timeIsValid) {
                        this.minutesSinceLastClamp15Off = (int)((SystemAccessor.getDateTarget().getCurrentTimestamp() - l) / 0);
                        if (this.minutesSinceLastClamp15Off < 0) {
                            this.minutesSinceLastClamp15Off = -1;
                        }
                    }
                    this.systemLogger.info(new StringBuffer().append("dsiPowerManagementUpdateClampSignal lastClamp15OffTimestamp: ").append(l).append(" minutesSinceLastClamp15Off ").append(this.minutesSinceLastClamp15Off).toString());
                    this.setMinutesSinceLastClamp15Off();
                } else {
                    if (this.timeIsValid) {
                        l = SystemAccessor.getDateTarget().getCurrentTimestamp();
                        this.persistableEarlyData.setLastClamp15OffTimestamp(l);
                        this.systemLogger.info(new StringBuffer().append("dsiPowerManagementUpdateClampSignal setting last clamp 15 off time: ").append(l).toString());
                    } else {
                        this.persistableEarlyData.setLastClamp15OffTimestamp(-1L);
                        this.systemLogger.info("dsiPowerManagementUpdateClampSignal reverting last clamp 15 off timer!");
                    }
                    this.triggerObserver(10305792, null);
                }
                this.valueClamp15 = bl;
                AslTargetSystemPowerManagementHandling.writeBooleanToDatapool(1651, bl);
                EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-459521792);
                eventGeneric.setBoolean(0, bl);
                this.sendSafe(eventGeneric);
            }
            this.calculateHMIAndDisplayState();
            this.processTheftProtection();
        }
    }

    public void dsiPowerManagementUpdatePowerManagementState(int n, int n2, int n3) {
        if (n3 == 1) {
            this.systemLogger.trace(new Object[]{"dsiPowerManagementUpdatePowerManagementState paramPowerManagementState ", new Integer(n), " oldPowerManagementState ", new Integer(this.powerManagementState)});
            if (ASLStartupv7rFactory.getStartupv7rApi().isHighActivatorStarted() && ASLDownloadFactory.getDownloadApi().swdlHighOmitPowerStateChangeIndicationUntilStartSwdlWasCalled() && n == 8) {
                return;
            }
            if (n == 3) {
                this.systemLogger.info("Update Power State: POWERSTATE_CRIT_TEMPR");
                this.sendHMIEvent(378);
                this.startCancelTempShutdownTimer();
            } else {
                if (this.powerManagementState == 8 && (this.currentBEMState == 2 || this.currentBEMState == 3)) {
                    this.processCriticalBemState();
                }
                switch (n) {
                    case 0: {
                        this.systemLogger.info("Update Power State: POWERSTATE_OFF (Or MMI_IOC)");
                        break;
                    }
                    case 1: {
                        this.systemLogger.info("Update Power State: POWERSTATE_ON");
                        break;
                    }
                    case 2: {
                        this.systemLogger.info("Update Power State: POWERSTATE_STANDBY");
                        if (!this.isPowerstateOn()) break;
                        this.systemLogger.trace("Power state was POWERSTATE_ON.");
                        ((EmergencyAnnouncementServiceImpl)this.systemServices.getEmergencyAnnouncementService()).setEmergencyAnnouncementState(false);
                        this.triggerObserver(362627328, null);
                        break;
                    }
                    case 4: {
                        this.systemLogger.info("Update Power State: POWERSTATE_STANDBY_RESTRICTED");
                        break;
                    }
                    case 5: {
                        this.systemLogger.info("Update Power State: POWERSTATE_ON_DIAG");
                        break;
                    }
                    case 6: {
                        this.systemLogger.info("Update Power State: POWERSTATE_CUSTOMER_SWDL");
                        break;
                    }
                    case 7: {
                        this.systemLogger.info("Update Power State: POWERSTATE_ON_TEL");
                        break;
                    }
                    case 8: {
                        this.systemLogger.info("Update Power State: POWERSTATE_ON_SWDL");
                        break;
                    }
                    case 9: {
                        this.systemLogger.info("Update Power State: POWERSTATE_STANDBY_PWR_SAVE");
                        if (this.powerManagementState == 2) {
                            if (this.batteryShutdownActive || this.temperatureShutdownActive) break;
                            this.triggerObserver(178077952, null);
                            this.systemLogger.trace("triggerObserver ASLSystemServiceIds.SHUTDOWN_IMMINENT");
                            break;
                        }
                        if (this.powerManagementState != -1) break;
                        this.triggerObserver(396181760, null);
                        this.systemLogger.trace("triggerObserver ASLSystemServiceIds.TRANSITION_TO_STANDBY_PWR_SAVE_DURING_STARTUP");
                        break;
                    }
                    default: {
                        this.systemLogger.error(new StringBuffer().append("Unknown Powerstate on update received: ").append(n).toString());
                    }
                }
                this.lastKnownPowerManagementState = this.powerManagementState;
                this.powerManagementState = n;
                this.triggerPowerstateOnTel();
                this.calculateHMIAndDisplayState();
                this.processTheftProtection();
                this.putDisplayAwake(32);
                this.putDisplayAsleep(32);
                if (this.isPowerstateOn()) {
                    this.triggerObserver(379404544, null);
                }
            }
            this.updateAudioState();
        }
    }

    public void dsiPowerManagementUpdateRVCActive(boolean bl, int n) {
        if (n == 1) {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
            eventGeneric.setBoolean(0, bl);
            this.triggerObserver(966607104, eventGeneric);
            if (ServiceManager.perfService != null) {
                ServiceManager.perfService.performanceLogRvcStateUpdate(bl);
            }
        }
    }

    public void dsiSoundUpdateMuteTheftProtection(boolean bl, int n) {
        if (n == 1) {
            this.isMuteTheftProtectionActive = bl;
            this.processTheftProtection();
        }
    }

    @Override
    public void registered(String string, int n) {
        String string2 = string.intern();
        if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[38]) {
            this.setServiceForDisplay();
            ServiceManager.dsiServiceLocator.removeServiceStateListener(class$org$dsi$ifc$displaymanagement$DSIDisplayManagement == null ? (class$org$dsi$ifc$displaymanagement$DSIDisplayManagement = AslTargetSystemPowerManagementHandling.class$("org.dsi.ifc.displaymanagement.DSIDisplayManagement")) : class$org$dsi$ifc$displaymanagement$DSIDisplayManagement, this);
        } else if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[6]) {
            this.setNotificationForSound();
            ServiceManager.dsiServiceLocator.removeServiceStateListener(class$org$dsi$ifc$audio$DSISound == null ? (class$org$dsi$ifc$audio$DSISound = AslTargetSystemPowerManagementHandling.class$("org.dsi.ifc.audio.DSISound")) : class$org$dsi$ifc$audio$DSISound, this);
        }
    }

    @Override
    public void unregistered(String string, int n) {
    }

    public void switchPendingDisplayState() {
        this.systemLogger.trace(new Object[]{"switchPendingDisplayState isDisplayStatePending: ", new Boolean(this.isDisplayStatePending)});
        if (this.isDisplayStatePending) {
            this.isDisplayStatePending = false;
            this.switchDisplay(this.pendingDisplayState);
        }
    }

    @Override
    public int getDefaultTargetId() {
        return 5603;
    }

    void pingByDisplayManagement() {
        this.systemLogger.trace("pingByDisplayManagement, send pending messages");
        this.isDisplayManagementReady = true;
        this.dimPendingDisplayState();
    }

    void loadPersistenceData() {
        this.systemCommonPersistenceService.loadSystemCommon();
    }

    void initDataFromPersistence() {
        this.calculateHMIAndDisplayState();
    }

    void putDisplayAwake(int n) {
        this.systemLogger.trace(new Object[]{"Put display awake, reason: 0x", Integer.toHexString(n)});
        this.currentlyActiveWakeupReasons |= n;
        this.systemLogger.trace(new Object[]{"Active awake reasons are: 0x", Integer.toHexString(this.currentlyActiveWakeupReasons)});
        if (!this.displayNightMode) {
            this.systemLogger.trace("DisplayNightMode is OFF .. NOP NOW");
            return;
        }
        this.stopDisplayNightModeTimer();
        switch (n) {
            case 16: {
                this.lastRvcActivationTime = ServiceManager.framework4U.system.currentTimeMillis();
                break;
            }
        }
        if (this.isPowerstateOn() && this.displayNightMode) {
            this.setBacklight(true);
            this.stopDisplayNightModeTimer();
        }
    }

    void putDisplayAsleep(int n) {
        this.systemLogger.trace(new Object[]{"Put display asleep, reason: 0x", Integer.toHexString(n)});
        if (n != 128) {
            this.currentlyActiveWakeupReasons &= ~n;
        }
        this.systemLogger.trace(new Object[]{"Remaining awake reasons are: 0x", Integer.toHexString(this.currentlyActiveWakeupReasons)});
        if (!this.displayNightMode) {
            this.systemLogger.trace("DisplayNightMode is OFF .. NOP NOW");
            return;
        }
        if (this.currentlyActiveWakeupReasons == 0) {
            switch (n) {
                case 1: {
                    this.startDisplayNightModeVariableTimer(0);
                    break;
                }
                case 2: {
                    this.startDisplayNightModeVariableTimer(0);
                    break;
                }
                case 4: {
                    this.startDisplayNightModeVariableTimer(0 - AbstractProximityComponent.DEFAULT_PROXMITY_TIMEOUT);
                    break;
                }
                case 8: {
                    this.startDisplayNightModeVariableTimer(0);
                    break;
                }
                case 16: {
                    if (this.lastRvcActivationTime != -1L) {
                        long l = ServiceManager.framework4U.system.currentTimeMillis() - this.lastRvcActivationTime;
                        if (l > 0) {
                            this.setBacklight(false);
                            this.stopDisplayNightModeTimer();
                        } else {
                            this.startDisplayNightModeVariableTimer(0 - l);
                        }
                        this.lastRvcActivationTime = -1L;
                        break;
                    }
                    this.startDisplayNightModeVariableTimer(0);
                    break;
                }
                case 32: {
                    this.startDisplayNightModeVariableTimer(0);
                    break;
                }
                case 64: {
                    this.startDisplayNightModeVariableTimer(0);
                    break;
                }
                case 128: {
                    this.startDisplayNightModeVariableTimer(0);
                    break;
                }
            }
        }
    }

    void installDialogStateRouter(DialogStateRouter dialogStateRouter) {
        dialogStateRouter.register(new AslTargetSystemPowerManagementHandling$1(this));
    }

    void processRevertSystemPower() {
        this.systemLogger.trace("processRevertSystemPower");
        this.persistableEarlyData.setLastClamp15OffTimestamp(-1L);
        AslTargetSystemPowerManagementHandling.writeIntegerToDatapool(1611, -1);
        this.calculateHMIAndDisplayState();
        if (this.displayNightMode) {
            this.displayNightMode = false;
            AslTargetSystemPowerManagementHandling.writeBooleanToDatapool(1661, false);
            this.stopDisplayNightModeTimer();
        }
    }

    private boolean retrieveShowDisplayablesProperty() {
        boolean bl = Boolean.getBoolean("de.vw.mib.showDisplayablesEnable");
        this.systemLogger.trace(new Object[]{"retrieveShowDisplayablesProperty showDisplayablesEnable ", new Boolean(bl)});
        return bl;
    }

    private void callSwitchDisplay(boolean bl) {
        this.systemLogger.trace("callSwitchDisplay");
        if (bl != this.displayState) {
            this.displayState = bl;
            this.dsiDisplayManagement.switchDisplayPower(0, bl ? 1 : 0);
        }
    }

    private ProfileChangeListener createProfileChangeListener() {
        return new AslTargetSystemPowerManagementHandling$2(this);
    }

    private void initPersistence() {
        this.loadPersistenceData();
        this.systemCommonPersistenceService.addProfileChangeListener(this.createProfileChangeListener());
    }

    private void enablePersistenceDueToError(boolean bl) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getTargetId(), 5120, 144523520);
        eventGeneric.setBoolean(0, bl);
        try {
            this.send(eventGeneric);
        }
        catch (GenericEventException genericEventException) {
            this.error(genericEventException);
        }
    }

    private void processCriticalBemState() {
        this.systemLogger.trace("processCriticalBemState");
        if (this.bemPrewarningPopupShown) {
            this.sendHMIEvent(371);
        }
        this.enablePersistenceDueToError(false);
        this.batteryShutdownActive = true;
        this.sendHMIEvent(375);
    }

    private void soundTransitionTo(int n) {
        this.systemLogger.trace(new Object[]{"soundTransitionTo newSoundState ", new Integer(n), " oldSoundState ", new Integer(this.soundState)});
        if (n != this.soundState) {
            this.sendAudioState(n);
            this.soundState = n;
        }
    }

    private void startCancelTempShutdownTimer() {
        this.temperatureShutdownActive = true;
        this.enablePersistenceDueToError(false);
        this.startTimer(-1568276224, (long)0, false);
        this.systemLogger.info("startCancelTempShutdownTimer");
    }

    private void stopCancelTempShutdownTimer() {
        if (this.temperatureShutdownActive) {
            this.temperatureShutdownActive = false;
            this.enablePersistenceDueToError(true);
            this.stopTimer(-1568276224);
            this.updateAudioState();
            this.systemLogger.info("stopCancelTempShutdownTimer");
        }
    }

    private void startDisplayNightModeVariableTimer(long l) {
        if (this.displayNightMode && this.hmiState == 2) {
            this.stopDisplayNightModeTimer();
            this.displayNightmodeTimerActive = true;
            this.startTimer(-1585053440, l, false);
            this.systemLogger.trace("startDisplayNightModeTimer");
        }
    }

    private void stopDisplayNightModeTimer() {
        if (this.displayNightmodeTimerActive) {
            this.stopTimer(-1585053440);
            this.displayNightmodeTimerActive = false;
            this.systemLogger.trace("stopDisplayNightModeTimer");
        }
    }

    private void setBacklight(boolean bl) {
        if (bl != this.backlightOn) {
            this.backlightOn = bl;
            SystemAccessor.getKeyPanelTarget().setDisplayOffModeActive(!bl);
            if (this.rvcOpsIsActive && !bl) {
                this.systemLogger.trace("Don't dim display due to rvc/ops!");
                return;
            }
            if (this.isDisplayManagementReady) {
                this.propagateBacklightState(bl);
            } else {
                this.systemLogger.trace("Dim Display is pending, call later");
                this.displayManagementDimDisplayPending = true;
                this.displayManagementPendingDimDisplayValue = !bl;
            }
        }
    }

    private void propagateBacklightState(boolean bl) {
        boolean bl2;
        boolean bl3 = ServiceManager.configManagerDiag.isFeatureFlagSet(360);
        boolean bl4 = bl2 = bl3 && this.displayOffClockManager.isClockOn();
        if (bl2) {
            this.triggerObserver(bl ? 1033715968 : 1016938752, null);
            if (bl) {
                this.sendDimDisplayEvent(false);
                ServiceManager.eventDispatcher.createAndSubmitDisplayEvent(1);
            }
        } else {
            this.sendDimDisplayEvent(!bl);
            ServiceManager.eventDispatcher.createAndSubmitDisplayEvent(bl ? 1 : 0);
            if (bl && bl3) {
                this.triggerObserver(1033715968, null);
            }
        }
        AslTargetSystemPowerManagementHandling.writeBooleanToDatapool(1660, !bl);
    }

    private void dimPendingDisplayState() {
        if (this.displayManagementDimDisplayPending) {
            this.displayManagementDimDisplayPending = false;
            this.systemLogger.trace("dimPendingDisplayState, call sendDimDisplayEvent");
            this.sendDimDisplayEvent(this.displayManagementPendingDimDisplayValue);
        }
    }

    private void sendDimDisplayEvent(boolean bl) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getTargetId(), 0x171100, 567677696);
        eventGeneric.setBoolean(0, bl);
        try {
            this.send(eventGeneric);
        }
        catch (GenericEventException genericEventException) {
            this.error(genericEventException);
        }
    }

    private void processPowerOn() {
        this.systemLogger.trace("processPowerOn");
        this.systemServices = SystemServicesProvider.getSystemServices();
        this.standByClockManager = this.systemServices.getClockManager();
        this.displayOffClockManager = this.systemServices.getDisplayOffClockManager();
        this.configManagerDiag = this.systemServices.getConfigManagerDiag();
        this.initializeDsi();
        this.initPersistence();
        this.initDataFromPersistence();
        this.systemServices.getBundleContext().registerService((class$de$vw$mib$event$consumer$PopupStackChangeEventConsumer == null ? (class$de$vw$mib$event$consumer$PopupStackChangeEventConsumer = AslTargetSystemPowerManagementHandling.class$("de.vw.mib.event.consumer.PopupStackChangeEventConsumer")) : class$de$vw$mib$event$consumer$PopupStackChangeEventConsumer).getName(), (Object)this, null);
        StartupStateService startupStateService = this.systemServices.getAslStartupv7rAPI().getStartupStateService();
        startupStateService.addListener(new PowerManagementStartupListener(this.systemServices));
        this.addObserver(-1060754176);
        String string = System.getProperty("useOnErrorScreen");
        if (string != null) {
            this.useOnErrorScreen = Boolean.valueOf(string);
        }
        this.trackSpeechEngine(this.systemServices);
        this.registerFactoryResetParticipant();
        this.registerApproximationListener(this.systemServices);
    }

    private void initializeDsi() {
        DSIProxy dSIProxy = this.systemServices.getDsiProxy();
        this.dsiPowerManagement = (DSIPowerManagement)this.systemServices.getDsiProxy().getService(this, class$org$dsi$ifc$powermanagement$DSIPowerManagement == null ? (class$org$dsi$ifc$powermanagement$DSIPowerManagement = AslTargetSystemPowerManagementHandling.class$("org.dsi.ifc.powermanagement.DSIPowerManagement")) : class$org$dsi$ifc$powermanagement$DSIPowerManagement);
        DSIPowerManagementListener dSIPowerManagementListener = this.createDsiPowerManagementListener();
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$powermanagement$DSIPowerManagementListener == null ? (class$org$dsi$ifc$powermanagement$DSIPowerManagementListener = AslTargetSystemPowerManagementHandling.class$("org.dsi.ifc.powermanagement.DSIPowerManagementListener")) : class$org$dsi$ifc$powermanagement$DSIPowerManagementListener, dSIPowerManagementListener);
        this.dsiPowerManagement.setNotification(new int[]{1, 3, 4, 7}, (DSIListener)dSIPowerManagementListener);
    }

    private DSIPowerManagementListener createDsiPowerManagementListener() {
        return new AslTargetSystemPowerManagementHandling$3(this);
    }

    private void registerApproximationListener(SystemServices systemServices) {
        ProximityServiceImpl proximityServiceImpl = systemServices.getProximityService();
        proximityServiceImpl.addListener(new AslTargetSystemPowerManagementHandling$4(this, proximityServiceImpl));
    }

    private void registerFactoryResetParticipant() {
        FactoryResetService factoryResetService = SystemServicesProvider.getSystemServices().getFactoryResetService();
        AslTargetSystemPowerManagementHandling$5 aslTargetSystemPowerManagementHandling$5 = new AslTargetSystemPowerManagementHandling$5(this);
        factoryResetService.addParticipant(aslTargetSystemPowerManagementHandling$5, FactoryResetComponents.SYSTEM);
    }

    private void processErrorState() {
        if (this.useOnErrorScreen) {
            this.systemLogger.warn("processErrorState change to state HMI_ON_ERROR!");
            this.writeHMIStateAndCreatePowerStateEvent(8, 6);
        } else {
            this.systemLogger.info("processErrorState: Property useOnErrorScreen not set, don't change to state HMI_ON_ERROR");
        }
    }

    private void processPopupEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        this.currentCountOfUserPerceivedOffPopups = eventGeneric.getInt(1);
        AslTargetSystemPowerManagementHandling.writeIntegerToDatapool(3443, n);
        this.systemLogger.trace(new Object[]{"processPopupEvent getNumberOfPopups ", new Integer(n), " currentCountOfUserPerceivedOffPopups ", new Integer(this.currentCountOfUserPerceivedOffPopups)});
        if (n > this.currentCountOfDisplayedPopups) {
            this.putDisplayAwake(8);
        } else {
            this.putDisplayAsleep(8);
        }
        this.calculateHMIAndDisplayState();
        this.currentCountOfDisplayedPopups = n;
    }

    private void calculateHMIAndDisplayState() {
        this.systemLogger.trace(new Object[]{"calculateHMIAndDisplayState for: powerstate=", new Integer(this.powerManagementState), ", valueClamp15=", new Boolean(this.valueClamp15), ", isShowClock=", new Boolean(this.standByClockManager.isClockOn()), ", climaContextIsActive=", new Boolean(this.climaContextIsActive), ", currentCountOfUserPerceivedOffPopups=", new Integer(this.currentCountOfUserPerceivedOffPopups), ", rvcOpsIsActive=", new Boolean(this.rvcOpsIsActive)});
        int n = 5;
        int n2 = -1;
        boolean bl = true;
        switch (this.powerManagementState) {
            case 1: 
            case 5: 
            case 7: {
                n = 2;
                n2 = 1;
                bl = true;
                break;
            }
            case 2: 
            case 9: {
                n = 1;
                n2 = 2;
                boolean bl2 = bl = this.valueClamp15 && (this.standByClockManager.isClockOn() || this.climaContextIsActive);
                if (this.rvcOpsIsActive) {
                    bl = true;
                }
                this.setBacklight(true);
                break;
            }
            case 8: {
                n = 4;
                n2 = 4;
                bl = true;
                break;
            }
            case 4: {
                n = 7;
                n2 = 5;
                bl = false;
                break;
            }
            case 0: 
            case 6: {
                if (ServiceManager.configManagerDiag.isFeatureFlagSet(395) && this.lastKnownPowerManagementState == 8) break;
                n = 0;
                n2 = 0;
                bl = false;
                break;
            }
        }
        if (n != 5) {
            if (this.currentCountOfUserPerceivedOffPopups > 0 && this.isPowerstateStandbyOrRestricted()) {
                bl = true;
            }
            this.systemLogger.trace(new Object[]{"calculateHMIAndDisplayState -> writeHMIStateAndCreatePowerStateEvent: ", new Integer(n), " powerStateEvent ", new Integer(n2), "-> switchDisplay: ", new Boolean(bl)});
            this.writeHMIStateAndCreatePowerStateEvent(n, n2);
            this.switchDisplay(bl);
        }
    }

    private void writeHMIStateAndCreatePowerStateEvent(int n, int n2) {
        if (this.hmiState != n) {
            if (n2 == 1 || n2 == 4) {
                ServiceManager.eventDispatcher.createAndSubmitPowerStateEvent(n2);
                AslTargetSystemPowerManagementHandling.writeIntegerToDatapool(1632, n);
            } else {
                AslTargetSystemPowerManagementHandling.writeIntegerToDatapool(1632, n);
                ServiceManager.eventDispatcher.createAndSubmitPowerStateEvent(n2);
            }
            this.hmiState = n;
            PropagatingPowerStateService propagatingPowerStateService = SystemServicesProvider.getSystemServices().getPowerStateService();
            propagatingPowerStateService.applyAslApiPowerState(n);
            this.sendHMIStateToKoreaExBoxTarget();
        }
    }

    private void updateAudioState() {
        this.systemLogger.trace(new Object[]{"calculateAudioState for powerstate ", new Integer(this.powerManagementState), " temperatureShutdownActive ", new Boolean(this.temperatureShutdownActive), " batteryShutdownActive ", new Boolean(this.batteryShutdownActive)});
        int n = this.powerManagementState == 1 || this.powerManagementState == 5 || this.powerManagementState == 7 ? 1 : 0;
        if (this.temperatureShutdownActive) {
            n = 0;
            this.systemLogger.info("calculateAudioState Mute due to critical temperature");
        }
        if (this.batteryShutdownActive) {
            n = 0;
            this.systemLogger.info("calculateAudioState Mute due to BEM critical");
        }
        this.systemLogger.trace(new Object[]{"calculateAudioState -> soundTransitionTo: ", new Integer(n)});
        this.soundTransitionTo(n);
    }

    private void sendAudioState(int n) {
        if (this.soundConnectionTargetIsReady) {
            this.systemLogger.trace(new Object[]{"sendAudioState: ", new Integer(n)});
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getTargetId(), -1338698496, 94191872);
            eventGeneric.setBoolean(0, n == 1);
            try {
                this.send(eventGeneric);
            }
            catch (GenericEventException genericEventException) {
                this.error(genericEventException);
            }
        } else {
            this.pendingAudioState = n;
            this.systemLogger.trace(new Object[]{"set pendingAudioState to: ", new Integer(n)});
        }
    }

    private boolean isPowerstateStandbyOrRestricted() {
        return this.powerManagementState == 2 || this.powerManagementState == 9 || this.powerManagementState == 4;
    }

    private boolean isPowerstateOn() {
        return this.powerManagementState == 1 || this.powerManagementState == 7;
    }

    private void processPing(EventGeneric eventGeneric) {
        int n = eventGeneric.getSenderTargetId();
        switch (n) {
            case 1390000: {
                this.systemLogger.trace("processPing Sound Connection target is ready, send first audio state: mute");
                this.soundConnectionTargetIsReady = true;
                this.sendAudioState(0);
                if (this.pendingAudioState == -1) break;
                this.systemLogger.trace(new Object[]{"send pending audio state ", new Integer(this.pendingAudioState)});
                this.sendAudioState(this.pendingAudioState);
                break;
            }
            case 1330034: {
                this.systemLogger.trace("processPing Guidance target is ready, send minutesSinceLastClamp15Off");
                this.guidanceTargetIsReady = true;
                this.setMinutesSinceLastClamp15Off();
                break;
            }
            case 1230000: {
                this.systemLogger.trace("processPing KoreaExBoxM target is ready, send hmiStatus");
                this.koreaExBoxMTargetIsReady = true;
                this.sendHMIStateToKoreaExBoxTarget();
                break;
            }
        }
    }

    private void sendHMIStateToKoreaExBoxTarget() {
        if (this.koreaExBoxMTargetIsReady && this.hmiState != 5) {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getTargetId(), -1329327616, -6536960);
            eventGeneric.setInt(0, this.hmiState);
            try {
                this.send(eventGeneric);
            }
            catch (GenericEventException genericEventException) {
                this.error(genericEventException);
            }
        }
    }

    private void setMinutesSinceLastClamp15Off() {
        if (this.guidanceTargetIsReady && this.timeIsValid && this.clamp15IsValid) {
            AslTargetSystemPowerManagementHandling.writeIntegerToDatapool(1611, this.minutesSinceLastClamp15Off);
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
            eventGeneric.setInt(0, this.minutesSinceLastClamp15Off);
            this.triggerObserver(446513408, eventGeneric);
        }
    }

    private void triggerPowerstateOnTel() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setBoolean(0, this.powerManagementState == 7);
        this.triggerObserver(798834944, eventGeneric);
    }

    private void processTheftProtection() {
        boolean bl = false;
        boolean bl2 = false;
        this.systemLogger.trace(new Object[]{"processTheftProtection isMuteTheftProtectionActive: ", new Boolean(this.isMuteTheftProtectionActive), " clamp15: ", new Boolean(this.valueClamp15), " hmiState ", new Integer(this.hmiState)});
        AslTargetSystemPowerManagementHandling.writeIntegerToDatapool(1652, this.isMuteTheftProtectionActive ? 1 : 0);
        if (this.isMuteTheftProtectionActive && this.hmiState == 2) {
            bl2 = true;
            if (!this.valueClamp15) {
                bl = true;
            }
        }
        if (bl != this.isComponentProtectionInitialPopupShown) {
            this.isComponentProtectionInitialPopupShown = bl;
            if (bl) {
                this.sendHMIEvent(496);
            } else {
                this.sendHMIEvent(497);
            }
        }
        if (bl2 != this.isComponentProtectionPermanentPopupShown) {
            this.isComponentProtectionPermanentPopupShown = bl2;
            if (bl2) {
                this.sendHMIEvent(498);
            } else {
                this.sendHMIEvent(499);
            }
        }
    }

    private void setServiceForDisplay() {
        this.systemLogger.trace("setServiceForDisplay");
        DSIProxy dSIProxy = SystemServicesProvider.getSystemServices().getDsiProxy();
        this.dsiDisplayManagement = (DSIDisplayManagement)dSIProxy.getService(this, class$org$dsi$ifc$displaymanagement$DSIDisplayManagement == null ? (class$org$dsi$ifc$displaymanagement$DSIDisplayManagement = AslTargetSystemPowerManagementHandling.class$("org.dsi.ifc.displaymanagement.DSIDisplayManagement")) : class$org$dsi$ifc$displaymanagement$DSIDisplayManagement);
    }

    private void setNotificationForSound() {
        this.systemLogger.trace("setNotificationForSound");
        DSIProxy dSIProxy = SystemServicesProvider.getSystemServices().getDsiProxy();
        DSIProxyAdapterFactory dSIProxyAdapterFactory = SystemServicesProvider.getSystemServices().getDsiProxyAdapterFactory();
        DSIListener dSIListener = dSIProxyAdapterFactory.createDSIListenerMethodAdapter(this, class$org$dsi$ifc$audio$DSISoundListener == null ? (class$org$dsi$ifc$audio$DSISoundListener = AslTargetSystemPowerManagementHandling.class$("org.dsi.ifc.audio.DSISoundListener")) : class$org$dsi$ifc$audio$DSISoundListener);
        DSISound dSISound = (DSISound)dSIProxy.getService(this, class$org$dsi$ifc$audio$DSISound == null ? (class$org$dsi$ifc$audio$DSISound = AslTargetSystemPowerManagementHandling.class$("org.dsi.ifc.audio.DSISound")) : class$org$dsi$ifc$audio$DSISound);
        dSISound.setNotification(36, dSIListener);
    }

    private void switchDisplay(boolean bl) {
        this.systemLogger.trace(new Object[]{"switchDisplay ", new Boolean(bl)});
        if (this.dsiDisplayManagement != null && !ASLDisplaymanagementFactory.getDisplaymanagementApi().isInitialSwitchContextPending()) {
            this.callSwitchDisplay(bl);
        } else {
            this.systemLogger.trace(new Object[]{"don't call switchDisplay (too early), pendingDisplayState: ", new Boolean(bl)});
            this.isDisplayStatePending = true;
            this.pendingDisplayState = bl;
        }
    }

    private void updateCriticalBemState(int n) {
        this.currentBEMState = n;
        if (this.powerManagementState != 8 && !this.batteryShutdownActive) {
            this.processCriticalBemState();
        }
    }

    private void updateUncriticalBemState(int n) {
        this.currentBEMState = n;
        if (this.batteryShutdownActive) {
            this.batteryShutdownActive = false;
            this.enablePersistenceDueToError(true);
            this.sendHMIEvent(373);
            this.systemLogger.trace("Update BEM State: Cancel Battery Shutdown, remove bem shutdown popup");
        }
        if (n == 6) {
            this.systemLogger.trace("BEM Prewarning active");
            this.bemPrewarningPopupShown = true;
            if (!this.isPowerstateStandbyOrRestricted()) {
                this.sendHMIEvent(372);
            }
        } else if (this.bemPrewarningPopupShown) {
            this.sendHMIEvent(371);
            this.bemPrewarningPopupShown = false;
        }
    }

    private void trackSpeechEngine(SystemServices systemServices) {
        BundleContext bundleContext = systemServices.getBundleContext();
        new ServiceTracker(bundleContext, (class$de$vw$mib$asl$api$speechengine$SpeechEngine == null ? (class$de$vw$mib$asl$api$speechengine$SpeechEngine = AslTargetSystemPowerManagementHandling.class$("de.vw.mib.asl.api.speechengine.SpeechEngine")) : class$de$vw$mib$asl$api$speechengine$SpeechEngine).getName(), (ServiceTrackerCustomizer)new AslTargetSystemPowerManagementHandling$6(this, bundleContext)).open();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}


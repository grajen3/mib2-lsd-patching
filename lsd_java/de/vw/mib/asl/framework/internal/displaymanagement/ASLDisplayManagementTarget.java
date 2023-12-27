/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.displaymanagement;

import de.vw.mib.asl.ASLDisplayManagerTarget;
import de.vw.mib.asl.api.system.ASLSystemAPI;
import de.vw.mib.asl.api.system.SharedSystemCommonPersistence;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponents;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetService;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.internal.displaymanagement.ASLDisplayManagementKomonavTarget;
import de.vw.mib.asl.framework.internal.displaymanagement.ASLDisplayManagementTarget$1;
import de.vw.mib.asl.framework.internal.displaymanagement.DisplayBrightness;
import de.vw.mib.asl.framework.internal.displaymanagement.DisplayManagementServices;
import de.vw.mib.asl.framework.internal.displaymanagement.DisplayTimer;
import de.vw.mib.asl.framework.internal.displaymanagement.DisplayableComponentData;
import de.vw.mib.asl.framework.internal.displaymanagement.PersistableDisplayManagementData;
import de.vw.mib.asl.framework.internal.displaymanagement.ScreenshotService;
import de.vw.mib.asl.framework.internal.displaymanagement.api.impl.ASLDisplaymanagementAPIImpl;
import de.vw.mib.asl.framework.internal.displaymanagement.displayoperation.SetDisplayTypeOperation;
import de.vw.mib.asl.framework.internal.displaymanagement.displayoperation.SetUpdateRateOpertation;
import de.vw.mib.asl.framework.internal.displaymanagement.factoryreset.CarParkingFactoryResetAssistanceParticipant;
import de.vw.mib.asl.framework.internal.displaymanagement.factoryreset.MediaFactoryResetParticipant;
import de.vw.mib.asl.framework.internal.displaymanagement.factoryreset.SystemFactoryResetParticipant;
import de.vw.mib.asl.framework.internal.displaymanagement.factoryreset.TvTunerFactoryResetParticipant;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.impl.displaymanagement.DisplayManagementServicesProvider;
import de.vw.mib.asl.framework.internal.impl.displaymanagement.screenshot.AbstractScreenshotService;
import de.vw.mib.asl.framework.internal.impl.displaymanagement.screenshot.ExternalScreenshotService;
import de.vw.mib.asl.framework.internal.impl.displaymanagement.screenshot.OldScreenshotService;
import de.vw.mib.asl.framework.internal.impl.displaymanagement.screenshot.ScreenshotKeyListener;
import de.vw.mib.collections.ints.IntBooleanMap;
import de.vw.mib.collections.ints.IntBooleanOptHashMap;
import de.vw.mib.collections.ints.IntIntMap;
import de.vw.mib.collections.ints.IntIntOptHashMap;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.collections.ints.IntOptHashSet;
import de.vw.mib.collections.ints.IntSet;
import de.vw.mib.display.DisplayManagementResponse;
import de.vw.mib.display.DisplayManagementService;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.graphics.Dimension;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.perf.service.PerfService;
import de.vw.mib.threads.AsyncServiceFactory;
import java.util.Arrays;
import java.util.Dictionary;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.displaymanagement.DSIDisplayManagement;
import org.dsi.ifc.displaymanagement.DSIDisplayManagementListener;
import org.dsi.ifc.displaymanagement.DisplayContext;
import org.dsi.ifc.powermanagement.DSIPowerManagement;
import org.osgi.framework.BundleContext;

public final class ASLDisplayManagementTarget
extends AbstractASLTarget
implements ASLDisplayManagerTarget,
DisplayManagementService,
DSIDisplayManagementListener {
    private static final String LOGGING_DELIM;
    private static final int DEFAULT_SET_HMI_READY_DELAY;
    private final int setHmiReadyDelay = Integer.getInteger("de.vw.mib.setHmiReadyDelay", 0);
    private boolean useKomonav = false;
    static Dimension DEFAULT_RESOLUTION;
    private DSIDisplayManagement dsiDisplayManagement;
    private int splashScreenAnimationStatus = 0;
    private boolean mapIsReady = false;
    private boolean hasBeginDisplayContextSwitchBeenCalled = false;
    private final IntSet displayableSet = new IntOptHashSet();
    private int oldDisplayLayerGroup = -1;
    private int pendingDisplayLayerGroup = -1;
    private final DisplayTimer displayTimer;
    private boolean animationSplashScreenTimerActive = false;
    static final int EV_VIDEO_SETUP_TIMER;
    static final int EV_VIDEO_RESPONSE_TIMER;
    static final int EV_ANIMATION_SPLASHSCREEN_TIMER;
    private static final int EV_SWITCH_CONTEXT_FALLBACK;
    static final int TIMER_RVC_CONTEXT_CONFORM_FALLBACK;
    static final int TIMER_SET_HMI_READY_DELAY;
    private static final long ANIMATION_SPLASHSCREEN_TIMER_DURATION;
    private static final long SWITCH_CONTEXT_FALLBACK_TIMER_DURATION;
    private static final long RVC_CONFORM_CHECK_TIMER_DURATION;
    private boolean initialSwitchContextPending = true;
    private int pendingContextId = -1;
    private int currentContextId = -1;
    private boolean isSwitchContextSequenceActive = false;
    private boolean isFallbackSwitchContextToBeDone = false;
    private int queuedContextId = -1;
    private boolean switchContextPending = false;
    private boolean switchContextPendingAfterLockDisplay = false;
    private boolean unlockDisplayPending = false;
    private boolean displayIsLocked = false;
    private boolean secondUnlockDisplayCalled = false;
    private boolean isSetHMIReadyHasBeenSent = false;
    private boolean isHmiReadyBeenAckowledged = false;
    private boolean hmiReadyIsPending = false;
    private DisplayableComponentData activeDisplayableComponent = new DisplayableComponentData(-1);
    private ScreenshotService screenshotService;
    private final PersistableDisplayManagementData persistableData = new PersistableDisplayManagementData();
    private boolean persistedDataAvailable = false;
    static final int SESSION_DEFAULT;
    static IntObjectMap displayableExtents;
    private DisplayContext[] displayContexts;
    private int defaultDisplayContextId;
    private int defaultRvcDisplayContextId;
    private final DisplayBrightness displayBrightness;
    private final IntIntMap displayableMap = new IntIntOptHashMap();
    private final IntIntMap displayContextGroups = new IntIntOptHashMap();
    private final IntObjectMap displayContextNames = new IntObjectOptHashMap();
    private final IntObjectMap displayableNames = new IntObjectOptHashMap();
    private boolean displaySetToDimmedResponsePending = false;
    private boolean displaySetToNormalResponsePending = false;
    public static final int DSI_DISPLAY_BRIGHTNESS_MIN;
    public static final int DSI_DISPLAY_BRIGHTNESS_MAX;
    private static int DSI_DISPLAY_BRIGHTNESS_DIMMED;
    private int flagRVCAvailable = -1;
    private boolean persistedRVCDataSent = false;
    private boolean flagAmiAvailable = false;
    private boolean flagTvAvailable = false;
    private final IntBooleanMap displayableInfoMap = new IntBooleanOptHashMap();
    private final int[] RVC_OBSERVERS = new int[]{235667520, 252444736, 269221952, 285999168};
    private boolean isRvcActive;
    private boolean ignoreRvcConform;
    private boolean firstContextSwitchWasRequested;
    private boolean startupGuiReadyRecieved;
    private boolean setHmiDelayPassed;
    private final ASLSystemAPI systemApi;
    private MediaFactoryResetParticipant mediaParticipant;
    private CarParkingFactoryResetAssistanceParticipant carParkingFactoryResetparticipant;
    private final DisplayManagementServices services;
    private boolean firstContextSwitchWasPerformed;
    private SetDisplayTypeOperation setDisplayTypeOperation;
    private SetUpdateRateOpertation setUpdateRateOpertation;
    static /* synthetic */ Class class$org$dsi$ifc$displaymanagement$DSIDisplayManagement;
    static /* synthetic */ Class class$org$dsi$ifc$displaymanagement$DSIDisplayManagementListener;
    static /* synthetic */ Class class$org$dsi$ifc$powermanagement$DSIPowerManagementListener;
    static /* synthetic */ Class class$org$dsi$ifc$powermanagement$DSIPowerManagement;
    static /* synthetic */ Class class$de$vw$mib$display$DisplayManagementService;
    static /* synthetic */ Class class$de$vw$mib$asl$ASLDisplayManagerTarget;
    static /* synthetic */ Class class$de$vw$mib$debug$screenshot$ScreenshotProvider;

    public ASLDisplayManagementTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        ASLDisplaymanagementAPIImpl.displayManagementTarget = this;
        this.services = DisplayManagementServicesProvider.getServices();
        this.systemApi = this.services.getAslSystemApi();
        this.displayTimer = this.services.getDisplayTimer();
        this.displayBrightness = new DisplayBrightness(this.persistableData, this.services);
    }

    private void initResetParticipants(DisplayManagementServices displayManagementServices) {
        FactoryResetService factoryResetService = this.systemApi.getFactoryResetService();
        factoryResetService.addParticipant(new SystemFactoryResetParticipant(displayManagementServices, this.dsiDisplayManagement), FactoryResetComponents.SYSTEM);
        factoryResetService.addParticipant(new TvTunerFactoryResetParticipant(displayManagementServices, this.dsiDisplayManagement), FactoryResetComponents.TVTUNER);
        this.mediaParticipant = new MediaFactoryResetParticipant(displayManagementServices, this.dsiDisplayManagement);
        this.mediaParticipant.setFlagAmiAvailable(this.flagAmiAvailable);
        factoryResetService.addParticipant(this.mediaParticipant, FactoryResetComponents.MEDIA);
        this.carParkingFactoryResetparticipant = new CarParkingFactoryResetAssistanceParticipant(displayManagementServices, this.dsiDisplayManagement);
        this.carParkingFactoryResetparticipant.setFlagRVCAvailable(this.isRearViewCamAvailable());
        factoryResetService.addParticipant(this.carParkingFactoryResetparticipant, FactoryResetComponents.CAR_PARKING_ASSISTANCE);
    }

    public boolean isInitialSwitchContextPending() {
        return this.initialSwitchContextPending;
    }

    @Override
    public void setPosition(int n, int n2, int n3, int n4) {
        if (n == 56) {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
            eventGeneric.setReceiverEventId(-1517944576);
            eventGeneric.setInt(1, n);
            eventGeneric.setInt(0, n2);
            eventGeneric.setInt(2, n3);
            eventGeneric.setInt(3, n4);
            eventGeneric.setSenderTargetId(this.getTargetId());
            eventGeneric.setReceiverTargetId(821891840);
            try {
                this.send(eventGeneric);
            }
            catch (GenericEventException genericEventException) {
                this.error(genericEventException);
            }
        }
        if (this.isTraceEnabled()) {
            this.trace().append("[ASLDisplayManagementTarget] ").append("setPosition displayId ").append(n2).append(" displayableId ").append(n).append(" x ").append(n3).append(" y ").append(n4).log();
        }
        if (n2 != 0) {
            this.error().append("[ASLDisplayManagementTarget] ").append("setPosition called with displayId != 0").log();
        }
        this.dsiDisplayManagement.setPosition(n, 0, n3, n4);
    }

    @Override
    public void setCropping(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10) {
        if (this.isTraceEnabled()) {
            this.trace().append("[ASLDisplayManagementTarget] ").append("cropDisplayable displayId ").append(n2).append(" displayableId ").append(n).append(" srcX ").append(n3).append(" srcY ").append(n4).append(" srcWidth ").append(n5).append(" srcHeight ").append(n6).append(" tgtX ").append(n7).append(" tgtY ").append(n8).append(" tgtWidth ").append(n9).append(" tgtHeight ").append(n10).log();
        }
        if (n2 != 0) {
            this.error().append("[ASLDisplayManagementTarget] ").append("cropDisplayable called with displayId != 0").log();
        }
        this.dsiDisplayManagement.setCropping(n2, n, n3, n4, n5, n6, n7, n8, n9, n10);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Dimension getExtents(int n) {
        Dimension dimension;
        IntObjectMap intObjectMap = displayableExtents;
        synchronized (intObjectMap) {
            dimension = displayableExtents.containsKey(n) ? (Dimension)displayableExtents.get(n) : DEFAULT_RESOLUTION;
        }
        if (dimension == DEFAULT_RESOLUTION) {
            this.createAsyncDisplayManagement().getExtents(n);
        }
        return dimension;
    }

    @Override
    public void setOpacity(int n, int n2, int n3) {
        if (this.isTraceEnabled()) {
            this.trace().append("[ASLDisplayManagementTarget] ").append("setOpacity displayId ").append(n2).append(" displayableId ").append(n).append(" percentage ").append(n3).log();
        }
        if (n2 != 0) {
            this.error().append("[ASLDisplayManagementTarget] ").append("setOpacity called with displayId != 0").log();
        }
        this.dsiDisplayManagement.setOpacity(n, 0, n3);
    }

    @Override
    public int getSubClassifier() {
        return 4096;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.processPowerOn();
                break;
            }
            case 1300004: {
                if (this.isTraceEnabled()) {
                    this.trace().append("[ASLDisplayManagementTarget] ").append("ASLDisplaymanagementServiceIds.MAP_READY received").log();
                }
                this.mapIsReady = true;
                if (!this.isMapDisplayContext(this.queuedContextId)) break;
                this.info().append("[ASLDisplayManagementTarget] ").append("Map is now ready, switch to map display context: ").append(this.queuedContextId).log();
                this.pendingContextId = this.queuedContextId;
                this.queuedContextId = -1;
                this.switchContext();
                break;
            }
            case 4300046: {
                if (this.isTraceEnabled()) {
                    this.trace().append("[ASLDisplayManagementTarget] ").append("ASLSystemServiceIds.SET_HMI_READY has been acknowledged!").log();
                }
                this.isHmiReadyBeenAckowledged = true;
                this.displayBrightness.setHmiReadyBeenAckowledged(this.isHmiReadyBeenAckowledged);
                this.displayBrightness.writePendingDisplayBrightnessToDsi();
                this.checkForSwitchContext();
                break;
            }
            case 4300062: {
                if (this.isTraceEnabled()) {
                    this.trace().append("[ASLDisplayManagementTarget] ").append("ASLSystemServiceIds.RELOAD_PERSISTABLES received!").log();
                }
                this.loadDataFromSharedPersistence();
                this.initFromPersistence();
                break;
            }
            case 1300003: {
                String string = eventGeneric.getString(0);
                this.info().append("[ASLDisplayManagementTarget] ").append("DEBUG: Take Screenshot requested, filename: ").append(string).log();
                boolean bl = this.readScreenshotProperty();
                if (bl) break;
                this.dsiDisplayManagement.takeScreenshotOnExternalStorage(0, string);
                break;
            }
            case 1300001: {
                boolean bl;
                if (this.isTraceEnabled()) {
                    this.trace().append("[ASLDisplayManagementTarget] ").append("ASL_DISPLAY_DIM_ON_OFF").log();
                }
                this.displaySetToDimmedResponsePending = bl = eventGeneric.getBoolean(0);
                this.displaySetToNormalResponsePending = !bl;
                int n = this.systemApi.getSharedSystemCommonPersistence().getDisplayBrigtness();
                int n2 = bl ? DSI_DISPLAY_BRIGHTNESS_DIMMED : this.systemApi.mapValue(n, 0, 4, 100, 0);
                this.displayBrightness.writeDefaultDisplayBrightnessToDsi(n2);
                break;
            }
            case 1300005: {
                this.processRvcFlag(eventGeneric);
                break;
            }
            case 1300002: {
                this.processAmiFlag(eventGeneric);
                break;
            }
            case 100101: {
                this.processVideoSetupTimer();
                break;
            }
            case 100102: {
                this.processVideoResponseTimer();
                break;
            }
            case 100103: {
                if (this.isTraceEnabled()) {
                    this.trace().append("[ASLDisplayManagementTarget] ").append("EV_ANIMATION_SPLASHSCREEN_TIMER elapsed!").log();
                }
                this.splashScreenAnimationStatus = 2;
                this.animationSplashScreenTimerActive = false;
                this.setHMIReady();
                this.checkForSwitchContext();
                break;
            }
            case 100104: {
                if (this.isTraceEnabled()) {
                    this.trace().append("[ASLDisplayManagementTarget] ").append("EV_SWITCH_CONTEXT_FALLBACK timer elapsed!").log();
                }
                if (this.displayIsLocked) {
                    if (this.isTraceEnabled()) {
                        this.trace().append("[ASLDisplayManagementTarget] ").append("display still locked, unlock!").log();
                    }
                    this.dsiDisplayManagement.unlockDisplay(0);
                    this.isFallbackSwitchContextToBeDone = true;
                    break;
                }
                this.fallbackSwitchContext();
                break;
            }
            case 1073743164: {
                this.changeBrightness(eventGeneric);
                break;
            }
            case 1073741947: {
                if (!this.activeDisplayableComponent.isDisplayableComponentIDSet()) break;
                int n = eventGeneric.getInt(0);
                this.setBrightness(n, this.activeDisplayableComponent.getDisplayableComponentId());
                break;
            }
            case 1073741948: {
                int n;
                if (!this.activeDisplayableComponent.isDisplayableComponentIDSet() || (n = eventGeneric.getInt(0)) == this.activeDisplayableComponent.getCachedContrast()) break;
                this.setDisplayableContrast(this.activeDisplayableComponent.getDisplayableComponentId(), n, true);
                break;
            }
            case 0x40000080: {
                int n;
                if (!this.activeDisplayableComponent.isDisplayableComponentIDSet() || (n = eventGeneric.getInt(0)) == this.activeDisplayableComponent.getCachedColor()) break;
                this.setDisplayableColor(this.activeDisplayableComponent.getDisplayableComponentId(), n, true);
                break;
            }
            case 1073741953: {
                int n;
                if (!this.activeDisplayableComponent.isDisplayableComponentIDSet() || (n = eventGeneric.getInt(0)) == this.activeDisplayableComponent.getCachedTint()) break;
                this.setDisplayableTint(this.activeDisplayableComponent.getDisplayableComponentId(), n, true);
                break;
            }
            case 1073741934: {
                this.displayBrightness.changeBrightness(true, this.activeDisplayableComponent);
                break;
            }
            case 1073741935: {
                this.changeContrastForVideo(true);
                break;
            }
            case 0x40000070: {
                this.changeSaturationForVideo(true);
                break;
            }
            case 1073741937: {
                this.changeTintForVideo(true);
                break;
            }
            case 1073741929: {
                this.displayBrightness.changeBrightness(false, this.activeDisplayableComponent);
                break;
            }
            case 1073741930: {
                this.changeContrastForVideo(false);
                break;
            }
            case 1073741931: {
                this.changeSaturationForVideo(false);
                break;
            }
            case 1073741932: {
                this.changeTintForVideo(false);
                break;
            }
            case 3000006: {
                String[] stringArray = (String[])eventGeneric.getObject(0);
                this.screenshotService.setExternalScreenshotPaths(stringArray);
                break;
            }
            case 1073744910: {
                this.processSetRVCBrightness(eventGeneric);
                break;
            }
            case 1073744911: {
                this.processSetRVCColor(eventGeneric);
                break;
            }
            case 1073744912: {
                this.processSetRVCContrast(eventGeneric);
                break;
            }
            case 1073744913: {
                this.processDeIncreaseRearViewCameraSettings(eventGeneric);
                break;
            }
            case 4300078: {
                this.processKomonav(eventGeneric.getBoolean(0));
                break;
            }
            case 1300007: {
                if (this.isTraceEnabled()) {
                    this.trace().append("[ASLDisplayManagementTarget] ").append("Service START_TV_COMPONENT received").log();
                }
                this.dsiDisplayManagement.startComponent(26, 0, 0);
                break;
            }
            case 1300008: {
                if (this.isTraceEnabled()) {
                    this.trace().append("[ASLDisplayManagementTarget] ").append("Service STOP_TV_COMPONENT received").log();
                }
                this.dsiDisplayManagement.stopComponent(26, 0, 0);
                break;
            }
            case 4300084: {
                if (this.isTraceEnabled()) {
                    this.trace().append("[ASLDisplayManagementTarget] ").append("ASLSystemServiceIds.GATEWAY_COMPONENT_LIST received").log();
                }
                this.flagTvAvailable = true;
                if (!ServiceManager.configManagerDiag.isFeatureFlagSet(425)) break;
                if (this.persistedDataAvailable) {
                    this.sendPersistedVideoOrTvDisplayableData(26);
                    this.sendPersistedVideoOrTvDisplayableData(29);
                    break;
                }
                if (!this.isTraceEnabled()) break;
                this.trace().append("[ASLDisplayManagementTarget] ").append("persistedDataAvailable is still false, call sendPersistedVideoOrTvDisplayableData later").log();
                break;
            }
            case 4300089: {
                this.isRvcActive = eventGeneric.getBoolean(0);
                if (!this.isTraceEnabled()) break;
                this.trace().append("[ASLDisplayManagementTarget] ").append("RVC state was updated, new state = ").append(this.isRvcActive).log();
                break;
            }
            case 100200: {
                this.warn().append("[ASLDisplayManagementTarget] ").append("RVC state does still not conform. Forcing setHMIReady.").log();
                this.ignoreRvcConform = true;
                this.setHMIReady();
                this.checkForSwitchContext();
                break;
            }
            case 1800004: {
                if (this.isTraceEnabled()) {
                    this.trace().append("[ASLDisplayManagementTarget] ").append("Recieved STARTUP_GUI_READY").log();
                }
                this.startupGuiReadyRecieved = true;
                this.setHMIReady();
                this.checkForSwitchContext();
                break;
            }
            case 100201: {
                if (this.isTraceEnabled()) {
                    this.trace().append("[ASLDisplayManagementTarget] ").append("Timer TIMER_SET_HMI_READY_DELAY elapsed.").append(this.setHmiDelayPassed).log();
                }
                this.setHmiDelayPassed = true;
                this.setHMIReady();
                this.checkForSwitchContext();
                break;
            }
        }
    }

    @Override
    public void setDimension(int n, int n2, int n3, int n4) {
        if (n == 56) {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
            eventGeneric.setInt(1, n);
            eventGeneric.setInt(0, n2);
            eventGeneric.setInt(2, n3);
            eventGeneric.setInt(3, n4);
            eventGeneric.setReceiverEventId(-1450835712);
            eventGeneric.setSenderTargetId(this.getTargetId());
            eventGeneric.setReceiverTargetId(821891840);
            try {
                this.send(eventGeneric);
            }
            catch (GenericEventException genericEventException) {
                this.error(genericEventException);
            }
        } else {
            if (this.isTraceEnabled()) {
                this.trace().append("[ASLDisplayManagementTarget] ").append("setDimension displayId ").append(n2).append(" displayableId ").append(n).append(" width ").append(n3).append(" height ").append(n4).log();
            }
            if (n2 != 0) {
                this.error().append("[ASLDisplayManagementTarget] ").append("setDimension called with displayId != 0").log();
            }
            this.dsiDisplayManagement.setDimension(n, n2, n3, n4);
        }
    }

    @Override
    public void setScaleMode(int n, int n2, int n3) {
        if (n == 56) {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
            eventGeneric.setInt(1, n);
            eventGeneric.setInt(0, n2);
            eventGeneric.setInt(2, n3);
            eventGeneric.setReceiverEventId(-1434058496);
            eventGeneric.setSenderTargetId(this.getTargetId());
            eventGeneric.setReceiverTargetId(821891840);
            try {
                this.send(eventGeneric);
            }
            catch (GenericEventException genericEventException) {
                this.error(genericEventException);
            }
        } else {
            if (this.isTraceEnabled()) {
                this.trace().append("[ASLDisplayManagementTarget] ").append("setScaleMode displayId ").append(n2).append(" displayableId ").append(n).append(" scaleEnum ").append(n3).log();
            }
            if (n2 != 0) {
                this.error().append("[ASLDisplayManagementTarget] ").append("setScaleMode called with displayId != 0").log();
            }
            this.dsiDisplayManagement.setScaleMode(n, n2, n3);
        }
    }

    @Override
    public int getDefaultTargetId() {
        return 0x171100;
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.warn().append("[ASLDisplayManagementTarget] ").append("DSIDisplayManagement-ASYNC:ErrorCode[").append(n).append("] Text:'").append(string).append("' RequestId[").append(n2).append("]").log();
    }

    @Override
    public void activeContext(int n, int n2, int n3) {
        this.processFirstContextSwitch();
        if (n2 != 0) {
            this.error().append("[ASLDisplayManagementTarget] ").append("activeContext with displayID != 0").log();
        }
        this.currentContextId = n;
        this.oldDisplayLayerGroup = this.getGroupForContext(n);
        this.activeDisplayableComponent.unsetCachedBrightness();
        this.activeDisplayableComponent.unsetCachedColor();
        this.activeDisplayableComponent.unsetCachedContrast();
        this.activeDisplayableComponent.unsetCachedTint();
        this.displayTimer.stopDisplayResponseTimer();
        this.displayTimer.stopDisplaySetupTimer();
        if (this.isTraceEnabled()) {
            this.trace().append("[ASLDisplayManagementTarget] ").append("activeContext displayContextId ").append(n).log();
        }
        if (this.unlockDisplayPending) {
            this.unlockDisplayPending = false;
            if (this.isTraceEnabled()) {
                this.trace().append("[ASLDisplayManagementTarget] ").append("Call DSIDisplayManagement.unlockDisplay").log();
            }
            this.dsiDisplayManagement.unlockDisplay(0);
        } else {
            this.endSwitchSequence();
        }
        this.applyContextToDisplayableService(n);
    }

    private void applyContextToDisplayableService(int n) {
        for (int i2 = 0; i2 < this.displayContexts.length; ++i2) {
            DisplayContext displayContext = this.displayContexts[i2];
            if (displayContext.id != n) continue;
            this.services.getDisplayableService().updateDisplayables(displayContext.displayableList);
        }
    }

    @Override
    public void getBrightness(int n, int n2) {
        boolean bl = true;
        if (this.isTraceEnabled()) {
            this.trace().append("[ASLDisplayManagementTarget] ").append("getBrightness cid ").append(n).append(" brightness ").append(n2).log();
        }
        if (this.displayTimer.isDisplayResponseTimerActive()) {
            if (this.activeDisplayableComponent.isCachedColorSet() || this.activeDisplayableComponent.isCachedColorSet() || this.activeDisplayableComponent.isCachedTintSet()) {
                this.displayTimer.triggerDisplayResponseTimer();
                bl = false;
            } else {
                this.displayTimer.setDisplayResponseTimerActive(false);
                this.stopTimer(109510912);
            }
            this.activeDisplayableComponent.unsetCachedBrightness();
        }
        if (this.activeDisplayableComponent.isVideoOrTvDisplayableComponent(n)) {
            this.persistableData.setVideoDisplayableBrightness(n, n2);
        } else if (n == 17) {
            int n3 = this.systemApi.mapValue(n2, -128, 127, 0, 100);
            this.persistableData.setRVCDisplayableBrightness(n3);
        }
        if (bl) {
            this.persistableData.store();
        }
    }

    @Override
    public void getColor(int n, int n2) {
        boolean bl = true;
        if (this.isTraceEnabled()) {
            this.trace().append("[ASLDisplayManagementTarget] ").append("getColor displayableID ").append(n).append(" color ").append(n2).log();
        }
        if (this.displayTimer.isDisplayResponseTimerActive()) {
            if (this.activeDisplayableComponent.isCachedBrightnessSet() || this.activeDisplayableComponent.isCachedContrastSet() || this.activeDisplayableComponent.isCachedTintSet()) {
                this.displayTimer.triggerDisplayResponseTimer();
                bl = false;
            } else {
                this.displayTimer.setDisplayResponseTimerActive(false);
                this.stopTimer(109510912);
            }
            this.activeDisplayableComponent.unsetCachedColor();
        }
        if (this.activeDisplayableComponent.isVideoOrTvDisplayableComponent(n)) {
            this.persistableData.setVideoDisplayableSaturation(n, n2);
        } else if (n == 17) {
            int n3 = this.systemApi.mapValue(n2, -128, 127, 0, 100);
            this.persistableData.setRVCDisplayableColor(n3);
        }
        if (bl) {
            this.persistableData.store();
        }
    }

    @Override
    public void getContrast(int n, int n2) {
        boolean bl = true;
        if (this.isTraceEnabled()) {
            this.trace().append("[ASLDisplayManagementTarget] ").append("getContrast cid ").append(n).append(" contrast ").append(n2).log();
        }
        if (this.displayTimer.isDisplayResponseTimerActive()) {
            if (this.activeDisplayableComponent.isCachedBrightnessSet() || this.activeDisplayableComponent.isCachedColorSet() || this.activeDisplayableComponent.isCachedTintSet()) {
                this.displayTimer.triggerDisplayResponseTimer();
                bl = false;
            } else {
                this.displayTimer.setDisplayResponseTimerActive(false);
                this.stopTimer(109510912);
            }
            this.activeDisplayableComponent.unsetCachedContrast();
        }
        if (this.activeDisplayableComponent.isVideoOrTvDisplayableComponent(n)) {
            this.persistableData.setVideoDisplayableContrast(n, n2);
        } else if (n == 17) {
            int n3 = this.systemApi.mapValue(n2, -128, 127, 0, 100);
            this.persistableData.setRVCDisplayableContrast(n3);
        }
        if (bl) {
            this.persistableData.store();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void getExtents(int n, int n2, int n3) {
        if (this.isTraceEnabled()) {
            this.trace().append("[ASLDisplayManagementTarget] ").append("getExtents").log();
        }
        Object object = displayableExtents;
        synchronized (object) {
            if (displayableExtents.containsKey(n)) {
                Dimension dimension = (Dimension)displayableExtents.get(n);
                dimension.height = n3;
                dimension.width = n2;
            } else {
                displayableExtents.put(n, new Dimension(n2, n3));
            }
        }
        if (n == 16) {
            object = (Dimension)displayableExtents.get(n);
            this.systemApi.setXResolution(((Dimension)object).width);
            this.systemApi.setYResolution(((Dimension)object).height);
        }
    }

    @Override
    public void fadeStarted(int n, int n2) {
    }

    @Override
    public void fadeComplete(int n, int n2) {
    }

    @Override
    public void getDisplayPower(int n, int n2) {
    }

    @Override
    public void getDisplayBrightness(int n, int n2) {
        if (this.isTraceEnabled()) {
            this.trace().append("[ASLDisplayManagementTarget] ").append("getDisplayBrightness").log();
        }
        if (n != 0) {
            this.error("getDisplayBrightness displayId is != 0: ", n);
        } else {
            this.processGetDisplayBrightnessResponse(n, n2);
        }
    }

    @Override
    public void getTint(int n, int n2) {
        boolean bl = true;
        if (this.isTraceEnabled()) {
            this.trace().append("[ASLDisplayManagementTarget] ").append("getTint cid ").append(n).append(" tint ").append(n2).log();
        }
        if (this.displayTimer.isDisplayResponseTimerActive()) {
            if (this.activeDisplayableComponent.isCachedBrightnessSet() || this.activeDisplayableComponent.getCachedColor() != -65536 || this.activeDisplayableComponent.getCachedContrast() != -65536) {
                this.displayTimer.triggerDisplayResponseTimer();
                bl = false;
            } else {
                this.displayTimer.setDisplayResponseTimerActive(false);
                this.stopTimer(109510912);
            }
            this.activeDisplayableComponent.unsetCachedTint();
        }
        if (this.activeDisplayableComponent.isVideoOrTvDisplayableComponent(n)) {
            this.persistableData.setVideoDisplayableTint(n, n2);
        }
        if (bl) {
            this.persistableData.store();
        }
    }

    @Override
    public void lockDisplayResult(int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("[ASLDisplayManagementTarget] ").append("lockDisplayResult ").append(n).log();
        }
        if (n != 0) {
            this.warn().append("[ASLDisplayManagementTarget] ").append("lockDisplayResult not successful, switchContext without lock/unlock!").log();
            this.unlockDisplayPending = false;
        }
        if (this.switchContextPendingAfterLockDisplay) {
            this.switchContextPendingAfterLockDisplay = false;
            if (this.isTraceEnabled()) {
                this.trace().append("[ASLDisplayManagementTarget] ").append("Call DSIDisplayManagement.switchContext").log();
            }
            this.performContextSwitch();
        }
    }

    @Override
    public void unlockDisplayResult(int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("[ASLDisplayManagementTarget] ").append("unlockDisplayResult ").append(n).log();
        }
        if (n == 0) {
            this.displayIsLocked = false;
            if (this.secondUnlockDisplayCalled) {
                this.secondUnlockDisplayCalled = false;
            }
            this.endSwitchSequence();
            if (this.isFallbackSwitchContextToBeDone) {
                this.isFallbackSwitchContextToBeDone = false;
                this.fallbackSwitchContext();
            }
        } else if (!this.secondUnlockDisplayCalled) {
            this.error().append("[ASLDisplayManagementTarget] ").append("unlockDisplayResult unlock not successful! Try again").log();
            this.secondUnlockDisplayCalled = true;
            this.dsiDisplayManagement.unlockDisplay(0);
        } else {
            this.fatal().append("[ASLDisplayManagementTarget] ").append("unlockDisplayResult unlock not successful!!!").log();
        }
    }

    @Override
    public void setCroppingResult(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11) {
        if (this.isTraceEnabled()) {
            this.trace().append("[ASLDisplayManagementTarget] ").append("setCroppingResult result: ").append(n11).log();
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setInt(0, n);
        eventGeneric.setInt(1, n2);
        eventGeneric.setInt(2, n3);
        eventGeneric.setInt(3, n4);
        eventGeneric.setInt(4, n5);
        eventGeneric.setInt(5, n6);
        eventGeneric.setInt(6, n7);
        eventGeneric.setInt(7, n8);
        eventGeneric.setInt(8, n9);
        eventGeneric.setInt(9, n10);
        eventGeneric.setInt(10, n11);
        this.triggerObserver(651563776, eventGeneric);
    }

    @Override
    public void getDisplayableInfo(int n, int n2, int n3) {
        if (this.isTraceEnabled()) {
            this.trace().append("[ASLDisplayManagementTarget] ").append("getDisplayableInfo cid: ").append(n2).append(" displayableInfo ").append(n3).log();
        }
        boolean bl = n3 == 1;
        this.displayableInfoMap.put(n2, bl);
        ASLDisplayManagementTarget.writeBooleanToDatapool(4000, bl);
    }

    @Override
    public void takeScreenshotOnExternalStorageResult(int n, int n2, String string) {
        this.info().append("[ASLDisplayManagementTarget] ").append("takeScreenshotOnExternalStorageResult resultCode ").append(n2).append(" absolutePath ").append(string).log();
    }

    @Override
    public void setDisplayTypeResult(int n, int n2) {
    }

    @Override
    public void getDisplayTypeResult(int n, int n2) {
    }

    @Override
    public void setUpdateRateResult(int n, int n2) {
    }

    @Override
    public void getUpdateRateResult(int n, int n2) {
    }

    @Override
    public void startComponentResult(int n, int n2, int n3, int n4) {
        if (n4 == 0) {
            this.trace().append("[ASLDisplayManagementTarget] ").append("startComponentResult OK for displayableID ").append(n).append(" displayID ").append(n2).log();
        } else {
            this.error().append("[ASLDisplayManagementTarget] ").append("startComponentResult: ").append(n4).append(" for displayableID ").append(n).append(" displayID ").append(n2).log();
        }
    }

    @Override
    public void stopComponentResult(int n, int n2, int n3, int n4) {
        if (n4 == 0) {
            this.trace().append("[ASLDisplayManagementTarget] ").append("stopComponentResult OK for displayableID ").append(n).append(" displayID ").append(n2).log();
        } else {
            this.error().append("[ASLDisplayManagementTarget] ").append("stopComponentResult: ").append(n4).append(" for displayableID ").append(n).append(" displayID ").append(n2).log();
        }
    }

    @Override
    public void setAnnotationDataResponse(int n, int n2) {
    }

    @Override
    public void initAnnotationsResponse(int n, int n2) {
    }

    @Override
    public void destroyImageDisplayableResponse(int n, int n2) {
    }

    @Override
    public void requestUpdateImageDisplayableResponse(int n, int n2) {
    }

    @Override
    public void createImageDisplayableResponse(int n, int n2) {
    }

    @Override
    public void beginDisplayContextSwitch(int n) {
        if (n != 0) {
            this.error().append("[ASLDisplayManagementTarget] ").append("beginDisplayContextSwitch called with displayId != 0").log();
        }
        if (this.isTraceEnabled()) {
            this.trace().append("[ASLDisplayManagementTarget] ").append("beginDisplayContextSwitch").log();
        }
        this.displayableSet.clear();
        this.hasBeginDisplayContextSwitchBeenCalled = true;
    }

    @Override
    public void endDisplayContextSwitch(int n) {
        if (n != 0) {
            this.error().append("[ASLDisplayManagementTarget] ").append("endDisplayContextSwitch called with displayId != 0").log();
        }
        if (this.isTraceEnabled()) {
            this.trace().append("[ASLDisplayManagementTarget] ").append("endDisplayContextSwitch").log();
        }
        this.hasBeginDisplayContextSwitchBeenCalled = false;
        this.switchContextPending = true;
        this.hmiReadyIsPending = true;
        this.setHMIReady();
        this.triggerFirstContextSwitchWasRequested();
        this.checkForSwitchContext();
    }

    @Override
    public void enableDisplayable(int n, int n2) {
        if (n2 != 0) {
            this.error().append("[ASLDisplayManagementTarget] ").append("enableDisplayable called with displayId != 0").log();
        }
        if (this.isTraceEnabled()) {
            this.trace().append("[ASLDisplayManagementTarget] ").append("enableDisplayable ").append(n).log();
        }
        this.displayableSet.add(n);
        if (!this.hasBeginDisplayContextSwitchBeenCalled) {
            this.switchContextPending = true;
            this.checkForSwitchContext();
        }
    }

    @Override
    public void disableDisplayable(int n, int n2) {
        if (n2 != 0) {
            this.error().append("[ASLDisplayManagementTarget] ").append("disableDisplayable called with displayId != 0").log();
        }
        if (this.isTraceEnabled()) {
            this.trace().append("[ASLDisplayManagementTarget] ").append("disableDisplayable ").append(n).log();
        }
        this.displayableSet.remove(n);
        this.switchContextPending = true;
        this.checkForSwitchContext();
    }

    public void dsiPowerManagementUpdateSplashScreenAnimation(int n, int n2) {
        if (n2 == 1) {
            this.splashScreenAnimationStatus = n;
            switch (n) {
                case 0: {
                    if (this.isTraceEnabled()) {
                        this.trace().append("[ASLDisplayManagementTarget] ").append("dsiPowerManagementUpdateSplashScreenAnimation: Animation has not been shown yet!").log();
                    }
                    this.triggerAnimationSplashScreenTimer();
                    break;
                }
                case 1: {
                    if (this.isTraceEnabled()) {
                        this.trace().append("[ASLDisplayManagementTarget] ").append("dsiPowerManagementUpdateSplashScreenAnimation: Animation is just shown!").log();
                    }
                    this.triggerAnimationSplashScreenTimer();
                    break;
                }
                case 2: {
                    this.processSplashscreenAnimationEnded();
                    break;
                }
            }
            this.setHMIReady();
            this.checkForSwitchContext();
        }
    }

    public void showDisplayablesResult(int n, int[] nArray, int n2, int n3) {
    }

    @Override
    public void showDisplayables(int n, int[] nArray) {
        this.displayableSet.clear();
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            this.displayableSet.add(nArray[i2]);
        }
        this.endDisplayContextSwitch(n);
    }

    @Override
    public int getDisplayCount() {
        throw new UnsupportedOperationException("Not implemented getDisplayCount");
    }

    @Override
    public int[] getDisplayExtents(int n) {
        throw new UnsupportedOperationException("Not implemented getDisplayExtents");
    }

    @Override
    public int[] getDisplayableExtents(int n, int n2) {
        Dimension dimension = this.getExtents(n2);
        return new int[]{dimension.width, dimension.height};
    }

    @Override
    public void setDisplayableOpacity(int n, int n2, int n3) {
        this.setOpacity(n2, n, n3);
    }

    @Override
    public void setDisplayable(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10) {
        this.setCropping(n2, n, n3, n4, n5, n6, n7, n8, n9, n10);
    }

    @Override
    public void deferDisplayUpdates(int n, int n2) {
        throw new UnsupportedOperationException("Not implemented deferDisplayUpdates");
    }

    @Override
    public void beginSync(int n, boolean bl) {
        this.unlockDisplayPending = bl;
        if (bl) {
            this.activateLockDisplay(n);
        }
    }

    @Override
    public void endSync(int n) {
        if (this.unlockDisplayPending) {
            this.unlockDisplayPending = false;
            if (this.isTraceEnabled()) {
                this.trace().append("[ASLDisplayManagementTarget] ").append("Call DSIDisplayManagement.unlockDisplay").log();
            }
            this.dsiDisplayManagement.unlockDisplay(n);
        }
    }

    public void dumpDisplayableResult(int n, int n2) {
    }

    public void getDisplaySizeResult(int n, int n2, int n3, int n4) {
    }

    public void getAvailableDisplayablesResult(int[] nArray) {
    }

    @Override
    public void showDisplayables(int n, int[] nArray, DisplayManagementResponse displayManagementResponse) {
        throw new UnsupportedOperationException("Not implemented showDisplayables");
    }

    @Override
    public void setDisplayType(int n, int n2, DisplayManagementResponse displayManagementResponse) {
        this.setDisplayTypeOperation.run(displayManagementResponse, n, n2);
    }

    @Override
    public void setUpdateRate(int n, int n2, DisplayManagementResponse displayManagementResponse) {
        this.setUpdateRateOpertation.run(displayManagementResponse, n, n2);
    }

    private void processFirstContextSwitch() {
        if (!this.firstContextSwitchWasPerformed) {
            this.firstContextSwitchWasPerformed = true;
            EventGeneric eventGeneric = null;
            this.triggerObserver(718672640, eventGeneric);
            this.info().append("[ASLDisplayManagementTarget] ").append("First context switch was performed. HMI is displayed now.").log();
        }
    }

    private void setBrightness(int n, int n2) {
        if (n != this.activeDisplayableComponent.getCachedBrightness()) {
            this.activeDisplayableComponent.setCachedBrightness(n);
            DisplayableComponentData displayableComponentData = new DisplayableComponentData(n2);
            displayableComponentData.setCachedBrightness(n);
            this.displayBrightness.setBrightness(displayableComponentData, true);
        }
    }

    private void processSplashscreenAnimationEnded() {
        if (this.isTraceEnabled()) {
            this.trace().append("[ASLDisplayManagementTarget] ").append("dsiPowerManagementUpdateSplashScreenAnimation: Animation has already been shown!").log();
        }
        if (this.animationSplashScreenTimerActive) {
            this.animationSplashScreenTimerActive = false;
            this.stopTimer(126288128);
        }
        PerfService perfService = DisplayManagementServicesProvider.getServices().getPerfService();
        perfService.performanceLogMsgByID(21);
    }

    private void changeBrightness(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        int n2 = this.systemApi.getSharedSystemCommonPersistence().getDisplayBrigtness();
        if (n2 != n) {
            if (this.isTraceEnabled()) {
                this.trace().append("[ASLDisplayManagementTarget] ").append("changeBrightness change data pool value to ").append(n).log();
            }
            int n3 = this.systemApi.mapValue(n, 0, 4, 100, 0);
            this.displayBrightness.writeDefaultDisplayBrightnessToDsi(n3);
        }
    }

    private void writeDisplayableContrastToDSI(int n, int n2) {
        if (this.isTraceEnabled()) {
            this.trace().append("[ASLDisplayManagementTarget] ").append("writeDisplayableContrastToDSI displayableId ").append(n).append(" contrast ").append(n2).log();
        }
        int n3 = this.activeDisplayableComponent.isVideoOrTvDisplayableComponent(n) ? n2 : this.systemApi.mapValue(n2, 0, 100, -128, 127);
        this.dsiDisplayManagement.setContrast(n, n3);
        this.dsiDisplayManagement.getContrast(n);
        this.displayTimer.triggerDisplayResponseTimer();
    }

    private void writeDisplayableColorToDSI(int n, int n2) {
        if (this.isTraceEnabled()) {
            this.trace().append("[ASLDisplayManagementTarget] ").append("writeDisplayableColorToDSI displayableId ").append(n).append(" color ").append(n2).log();
        }
        int n3 = this.activeDisplayableComponent.isVideoOrTvDisplayableComponent(n) ? n2 : this.systemApi.mapValue(n2, 0, 100, -128, 127);
        this.dsiDisplayManagement.setColor(n, n3);
        this.dsiDisplayManagement.getColor(n);
        this.displayTimer.triggerDisplayResponseTimer();
    }

    private void writeDisplayableTintToDSI(int n, int n2) {
        if (this.isTraceEnabled()) {
            this.trace().append("[ASLDisplayManagementTarget] ").append("writeDisplayableTintToDSI displayableId ").append(n).append(" tint ").append(n2).log();
        }
        this.dsiDisplayManagement.setTint(n, n2);
        this.dsiDisplayManagement.getTint(n);
        this.displayTimer.triggerDisplayResponseTimer();
    }

    private void changeContrastForVideo(boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace().append("[ASLDisplayManagementTarget] ").append("changeContrastForVideo increase ").append(bl).log();
            this.trace("activeVideoDisplayableId ", this.activeDisplayableComponent.getDisplayableComponentId());
        }
        if (this.activeDisplayableComponent.isDisplayableComponentIDSet()) {
            if (!this.activeDisplayableComponent.isCachedContrastSet()) {
                this.activeDisplayableComponent.setCachedContrast(this.persistableData.getVideoDisplayableContrast(this.activeDisplayableComponent.getDisplayableComponentId()));
            }
            int n = this.activeDisplayableComponent.getCachedContrast();
            if (bl) {
                if (n < 127) {
                    ++n;
                }
            } else if (n > -128) {
                --n;
            }
            if (n != this.activeDisplayableComponent.getCachedContrast()) {
                this.setDisplayableContrast(this.activeDisplayableComponent.getDisplayableComponentId(), n, true);
            }
        }
    }

    private void setDisplayableContrast(int n, int n2, boolean bl) {
        boolean bl2 = this.activeDisplayableComponent.isVideoOrTvDisplayableComponent(n);
        if (this.isTraceEnabled()) {
            this.trace().append("[ASLDisplayManagementTarget] ").append("setDisplayableContrast id ").append(n).append(" contrast ").append(n2).log();
        }
        this.activeDisplayableComponent.setCachedContrast(n2);
        if (bl) {
            if (bl2) {
                ASLDisplayManagementTarget.writeIntegerToDatapool(117, n2);
            } else {
                ASLDisplayManagementTarget.writeIntegerToDatapool(10183, n2);
            }
            this.displayTimer.triggerDisplaySetupTimer();
        } else {
            this.writeDisplayableContrastToDSI(n, n2);
            if (!bl2) {
                ASLDisplayManagementTarget.writeIntegerToDatapool(10183, n2);
            }
        }
    }

    private void changeSaturationForVideo(boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace().append("[ASLDisplayManagementTarget] ").append("changeSaturationForVideo increase ").append(bl).log();
            this.trace("activeVideoDisplayableId ", this.activeDisplayableComponent.getDisplayableComponentId());
        }
        if (this.activeDisplayableComponent.isDisplayableComponentIDSet()) {
            if (!this.activeDisplayableComponent.isCachedColorSet()) {
                this.activeDisplayableComponent.setCachedColor(this.persistableData.getVideoDisplayableSaturation(this.activeDisplayableComponent.getDisplayableComponentId()));
            }
            int n = this.activeDisplayableComponent.getCachedColor();
            if (bl) {
                if (n < 127) {
                    ++n;
                }
            } else if (n > -128) {
                --n;
            }
            if (n != this.activeDisplayableComponent.getCachedColor()) {
                this.setDisplayableColor(this.activeDisplayableComponent.getDisplayableComponentId(), n, true);
            }
        }
    }

    private void setDisplayableColor(int n, int n2, boolean bl) {
        boolean bl2 = this.activeDisplayableComponent.isVideoOrTvDisplayableComponent(n);
        if (this.isTraceEnabled()) {
            this.trace().append("[ASLDisplayManagementTarget] ").append("setDisplayableColor id ").append(n).append(" color ").append(n2).log();
        }
        this.activeDisplayableComponent.setCachedColor(n2);
        if (bl) {
            if (bl2) {
                ASLDisplayManagementTarget.writeIntegerToDatapool(133, n2);
            } else {
                ASLDisplayManagementTarget.writeIntegerToDatapool(10182, n2);
            }
            this.displayTimer.triggerDisplaySetupTimer();
        } else {
            this.writeDisplayableColorToDSI(n, n2);
            if (!bl2) {
                ASLDisplayManagementTarget.writeIntegerToDatapool(10182, n2);
            }
        }
    }

    private void changeTintForVideo(boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace().append("[ASLDisplayManagementTarget] ").append("changeTintForVideo increase ").append(bl).log();
            this.trace("activeVideoDisplayableId ", this.activeDisplayableComponent.getDisplayableComponentId());
        }
        if (this.activeDisplayableComponent.isDisplayableComponentIDSet()) {
            if (!this.activeDisplayableComponent.isCachedTintSet()) {
                this.activeDisplayableComponent.setCachedTint(this.persistableData.getVideoDisplayableTint(this.activeDisplayableComponent.getDisplayableComponentId()));
            }
            int n = this.activeDisplayableComponent.getCachedTint();
            if (bl) {
                if (n < 127) {
                    ++n;
                }
            } else if (n > -128) {
                --n;
            }
            if (n != this.activeDisplayableComponent.getCachedTint()) {
                this.setDisplayableTint(this.activeDisplayableComponent.getDisplayableComponentId(), n, true);
            }
        }
    }

    private void setDisplayableTint(int n, int n2, boolean bl) {
        boolean bl2 = this.activeDisplayableComponent.isVideoOrTvDisplayableComponent(n);
        if (this.isTraceEnabled()) {
            this.trace().append("[ASLDisplayManagementTarget] ").append("setDisplayableTint id ").append(n).append(" tint ").append(n2).log();
        }
        this.activeDisplayableComponent.setCachedTint(n2);
        if (bl) {
            if (bl2) {
                ASLDisplayManagementTarget.writeIntegerToDatapool(134, n2);
            }
            this.displayTimer.triggerDisplaySetupTimer();
        } else {
            this.writeDisplayableTintToDSI(n, n2);
        }
    }

    private void processKomonav(boolean bl) {
        if (this.useKomonav) {
            if (!bl) {
                this.useKomonav = bl;
            }
        } else if (bl) {
            this.useKomonav = bl;
            try {
                new ASLDisplayManagementKomonavTarget(this.getMainObject());
            }
            catch (Exception exception) {
                this.error().append("Target ASLDisplayManagementKomonavTarget could not be instantiated").append(exception).log();
            }
        }
    }

    private void declareDisplayContexts() {
        this.readDisplayContextsFromConfigManager();
        this.dsiDisplayManagement.declareContexts(this.displayContexts);
    }

    private void fallbackSwitchContext() {
        if (this.isTraceEnabled()) {
            this.trace().append("[ASLDisplayManagementTarget] ").append("fallbackSwitchContext").log();
        }
        if (this.queuedContextId == -1) {
            if (this.currentContextId == -1) {
                this.pendingContextId = this.defaultDisplayContextId;
                this.warn().append("[ASLDisplayManagementTarget] ").append("context switch not successful! switching to default context: ").append(this.pendingContextId).log();
            } else {
                this.warn().append("[ASLDisplayManagementTarget] ").append("context switch not successful! switching to last context: ").append(this.currentContextId).log();
                this.pendingContextId = this.currentContextId;
            }
        } else {
            this.warn().append("[ASLDisplayManagementTarget] ").append("context switch not successful! switching to queued context: ").append(this.queuedContextId).log();
            this.pendingContextId = this.queuedContextId;
            this.queuedContextId = -1;
        }
        this.switchContext();
    }

    private void processDeIncreaseRearViewCameraSettings(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        boolean bl = eventGeneric.getBoolean(1);
        switch (n) {
            case 0: {
                if (!this.activeDisplayableComponent.isCachedBrightnessSet()) {
                    this.activeDisplayableComponent.setCachedBrightness(this.persistableData.getRVCDisplayableBrightness());
                }
                int n2 = this.activeDisplayableComponent.getCachedBrightness();
                if (bl) {
                    if (++n2 > 70) {
                        n2 = 70;
                    }
                } else if (--n2 < 30) {
                    n2 = 30;
                }
                if (this.isTraceEnabled()) {
                    this.trace().append("[ASLDisplayManagementTarget] ").append("processDeIncreaseRVCSettings old Brighntess: ").append(this.activeDisplayableComponent.getCachedBrightness()).append(" new Value: ").append(n2).log();
                }
                this.setBrightness(n2, 17);
                break;
            }
            case 1: {
                if (!this.activeDisplayableComponent.isCachedContrastSet()) {
                    this.activeDisplayableComponent.setCachedContrast(this.persistableData.getRVCDisplayableContrast());
                }
                int n3 = this.activeDisplayableComponent.getCachedContrast();
                if (bl) {
                    if (++n3 > 70) {
                        n3 = 70;
                    }
                } else if (--n3 < 30) {
                    n3 = 30;
                }
                if (this.isTraceEnabled()) {
                    this.trace().append("[ASLDisplayManagementTarget] ").append("processDeIncreaseRVCSettings old Contrast: ").append(this.activeDisplayableComponent.getCachedContrast()).append(" new Value: ").append(n3).log();
                }
                if (n3 == this.activeDisplayableComponent.getCachedContrast()) break;
                this.setDisplayableContrast(17, n3, true);
                break;
            }
            case 2: {
                if (!this.activeDisplayableComponent.isCachedColorSet()) {
                    this.activeDisplayableComponent.setCachedColor(this.persistableData.getRVCDisplayableColor());
                }
                int n4 = this.activeDisplayableComponent.getCachedColor();
                if (bl) {
                    if (++n4 > 70) {
                        n4 = 70;
                    }
                } else if (--n4 < 30) {
                    n4 = 30;
                }
                if (this.isTraceEnabled()) {
                    this.trace().append("[ASLDisplayManagementTarget] ").append("processDeIncreaseRVCSettings old Color: ").append(this.activeDisplayableComponent.getCachedColor()).append(" new Value: ").append(n4).log();
                }
                if (n4 == this.activeDisplayableComponent.getCachedColor()) break;
                this.setDisplayableColor(17, n4, true);
                break;
            }
        }
    }

    private void loadDataFromSharedPersistence() {
        if (this.isTraceEnabled()) {
            this.trace().append("[ASLDisplayManagementTarget] ").append("[ASLDisplayManagementTarget] Init Data from PersistenceNsEarly").log();
        }
        int n = this.systemApi.getSharedSystemCommonPersistence().getDisplayBrigtness();
        int n2 = this.systemApi.mapValue(n, 0, 4, 100, 0);
        this.displayBrightness.writeDefaultDisplayBrightnessToDsi(n2);
    }

    private void initFromPersistence() {
        if (this.isTraceEnabled()) {
            this.trace().append("[ASLDisplayManagementTarget] ").append("Init Data from PersistenceNsDisplay").log();
        }
        this.persistableData.load();
        this.persistedDataAvailable = true;
        if (this.flagAmiAvailable) {
            this.sendPersistedVideoOrTvDisplayableData(27);
        } else if (this.isTraceEnabled()) {
            this.trace().append("[ASLDisplayManagementTarget] ").append("flagAmiAvailable not yet set, call sendPersistedAMIDisplayableData later if coded").log();
        }
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(70)) {
            this.sendPersistedVideoOrTvDisplayableData(43);
        }
        if (this.flagTvAvailable) {
            if (ServiceManager.configManagerDiag.isFeatureFlagSet(425)) {
                this.sendPersistedVideoOrTvDisplayableData(26);
                this.sendPersistedVideoOrTvDisplayableData(29);
            }
        } else if (this.isTraceEnabled()) {
            this.trace().append("[ASLDisplayManagementTarget] ").append("flagTvAvailable not yet set, call sendPersistedVideoOrTvDisplayableData later if coded").log();
        }
        if (this.isRearViewCamAvailable()) {
            this.sendPersistedRVCDisplayableData();
        } else if (this.isTraceEnabled()) {
            this.trace().append("[ASLDisplayManagementTarget] ").append("flagRVCAvailable not yet set, call sendPersistedRVCDisplayableData later if coded").log();
        }
    }

    private void sendPersistedVideoOrTvDisplayableData(int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("[ASLDisplayManagementTarget] ").append("sendPersistedVideoOrTvDisplayableData send persisted video displayable data to DSI").log();
        }
        DisplayableComponentData displayableComponentData = new DisplayableComponentData(n);
        displayableComponentData.setCachedBrightness(this.displayBrightness.getBrightnessFromPersistence(n));
        int n2 = this.persistableData.getVideoDisplayableContrast(n);
        int n3 = this.persistableData.getVideoDisplayableSaturation(n);
        int n4 = this.persistableData.getVideoDisplayableTint(n);
        this.displayBrightness.setBrightness(displayableComponentData, false);
        this.setDisplayableContrast(n, n2, false);
        this.setDisplayableColor(n, n3, false);
        this.setDisplayableTint(n, n4, false);
    }

    private void sendPersistedRVCDisplayableData() {
        if (this.isTraceEnabled()) {
            this.trace().append("[ASLDisplayManagementTarget] ").append("sendPersistedRVCDisplayableData send persisted rvc displayable data to DSI").log();
        }
        DisplayableComponentData displayableComponentData = new DisplayableComponentData(17);
        displayableComponentData.setCachedBrightness(this.persistableData.getRVCDisplayableBrightness());
        int n = this.persistableData.getRVCDisplayableContrast();
        int n2 = this.persistableData.getRVCDisplayableColor();
        this.persistedRVCDataSent = true;
        this.displayBrightness.setBrightness(displayableComponentData, false);
        this.setDisplayableContrast(17, n, false);
        this.setDisplayableColor(17, n2, false);
    }

    private void processRvcFlag(EventGeneric eventGeneric) {
        this.flagRVCAvailable = eventGeneric.getInt(0);
        if (this.isTraceEnabled()) {
            this.trace().append("[ASLDisplayManagementTarget] ").append("IdService.ASL_SYSTEM_DISPLAYMANAGEMENT_RVC flagRVCAvailable ").append(this.flagRVCAvailable).log();
        }
        if (this.flagRVCAvailable == 3) {
            this.flagRVCAvailable = 1;
        }
        if (this.carParkingFactoryResetparticipant != null) {
            this.carParkingFactoryResetparticipant.setFlagRVCAvailable(this.isRearViewCamAvailable());
        }
        if (this.isRearViewCamAvailable()) {
            this.addObservers(this.RVC_OBSERVERS);
            if (this.persistedDataAvailable && !this.persistedRVCDataSent) {
                this.sendPersistedRVCDisplayableData();
            } else if (this.isTraceEnabled()) {
                this.trace().append("[ASLDisplayManagementTarget] ").append("persistedDataAvailable is still false, call sendPersistedRVCDisplayableData later").log();
            }
        }
    }

    private boolean isRearViewCamAvailable() {
        return this.flagRVCAvailable == 1;
    }

    private void processAmiFlag(EventGeneric eventGeneric) {
        this.flagAmiAvailable = eventGeneric.getBoolean(0);
        if (this.mediaParticipant != null) {
            this.mediaParticipant.setFlagAmiAvailable(this.flagAmiAvailable);
        }
        if (this.isTraceEnabled()) {
            this.trace().append("[ASLDisplayManagementTarget] ").append("IdService.ASL_SYSTEM_DISPLAYMANAGEMENT_AMI flagAmiAvailable ").append(this.flagAmiAvailable).log();
        }
        if (this.flagAmiAvailable) {
            if (this.persistedDataAvailable) {
                this.sendPersistedVideoOrTvDisplayableData(27);
            } else if (this.isTraceEnabled()) {
                this.trace().append("[ASLDisplayManagementTarget] ").append("persistedDataAvailable is still false, call sendPersistedAMIDisplayableData later").log();
            }
        }
    }

    private void processSetRVCContrast(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        if (this.isTraceEnabled()) {
            this.trace().append("[ASLDisplayManagementTarget] ").append("processSetRVCContrast ").append(n).log();
        }
        if (n != this.activeDisplayableComponent.getCachedContrast()) {
            this.setDisplayableContrast(17, n, true);
        }
    }

    private void processSetRVCColor(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        if (this.isTraceEnabled()) {
            this.trace().append("[ASLDisplayManagementTarget] ").append("processSetRVCColor ").append(n).log();
        }
        if (n != this.activeDisplayableComponent.getCachedColor()) {
            this.setDisplayableColor(17, n, true);
        }
    }

    private void processSetRVCBrightness(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        if (this.isTraceEnabled()) {
            this.trace().append("[ASLDisplayManagementTarget] ").append("processSetRVCBrightness ").append(n).log();
        }
        this.setBrightness(n, 17);
    }

    private void processGetDisplayBrightnessResponse(int n, int n2) {
        if (this.displaySetToDimmedResponsePending) {
            if (this.isTraceEnabled() && n2 == DSI_DISPLAY_BRIGHTNESS_DIMMED && this.isTraceEnabled()) {
                this.trace().append("[ASLDisplayManagementTarget] ").append("processGetDisplayBrightness: Display is dimmed! (Backlight Off)").log();
            }
            this.displaySetToDimmedResponsePending = false;
            return;
        }
        if (this.displaySetToNormalResponsePending) {
            if (this.isTraceEnabled()) {
                this.trace().append("[ASLDisplayManagementTarget] ").append("processGetDisplayBrightness: Display is set to normal! (Backlight On), brightness: ").append(n2).log();
            }
            this.displaySetToNormalResponsePending = false;
            return;
        }
        int n3 = this.systemApi.mapValue(n2, 0, 100, 4, 0);
        if (this.isTraceEnabled()) {
            this.trace().append("[ASLDisplayManagementTarget] ").append("Datapool value Display Brightness value is now ").append(n3).log();
        }
        ASLDisplayManagementTarget.writeIntegerToDatapool(1605, n3);
        this.systemApi.getSharedSystemCommonPersistence().setDisplayBrightness(n3);
    }

    private void readDisplayContextsFromConfigManager() {
        int[] nArray = ServiceManager.configManagerDiag.getUsedDisplayContextData();
        this.defaultDisplayContextId = ServiceManager.configManagerDiag.getDefaultDisplayContextId();
        this.defaultRvcDisplayContextId = ServiceManager.configManagerDiag.getDefaultRvcDisplayContextId();
        boolean bl = false;
        if (nArray != null) {
            int n = 0;
            try {
                int n2 = nArray[n++];
                this.displayContexts = new DisplayContext[n2];
                for (int i2 = 0; i2 < n2; ++i2) {
                    int n3;
                    int n4 = nArray[n++];
                    int n5 = nArray[n++];
                    int[] nArray2 = new int[n5];
                    for (n3 = 0; n3 < nArray2.length; ++n3) {
                        nArray2[n3] = nArray[n++];
                        int n6 = nArray2[n3];
                        if (this.displayableNames.containsKey(n6)) continue;
                        this.displayableNames.put(n6, ServiceManager.configManagerDiag.getDisplayableName(n6));
                    }
                    this.displayContexts[i2] = new DisplayContext(n4, nArray2);
                    this.displayContextGroups.put(n4, ServiceManager.configManagerDiag.getContextGroupForContext(n4));
                    this.displayContextNames.put(n4, ServiceManager.configManagerDiag.getDisplayContextName(n4));
                    n3 = this.calculateDisplayableKeyForMap(nArray2);
                    this.displayableMap.put(n3, n4);
                    if (!this.isTraceEnabled()) continue;
                    this.trace().append("[ASLDisplayManagementTarget] ").append("DisplayContext ").append(i2).append(" Key ").append(n3).append(" ").append(this.displayContexts[i2]).append(" group ").append(this.displayContextGroups.get(n4)).log();
                }
            }
            catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                bl = true;
            }
        } else {
            bl = true;
        }
        if (bl) {
            this.fatal().append("[ASLDisplayManagementTarget] ").append("readDisplayContextsFromConfigManager WRONG DATA").log();
        }
    }

    private int calculateDisplayableKeyForMap(int[] nArray) {
        int n = 0;
        int n2 = nArray.length;
        int[] nArray2 = new int[n2];
        System.arraycopy((Object)nArray, 0, (Object)nArray2, 0, n2);
        Arrays.sort(nArray2);
        for (int i2 = 0; i2 < n2; ++i2) {
            n += nArray2[i2] << 8 * i2;
        }
        return n;
    }

    private void processPowerOn() {
        this.registerAsyncDisplayManagerTarget();
        DSIProxy dSIProxy = this.services.getDsiProxy();
        this.dsiDisplayManagement = (DSIDisplayManagement)dSIProxy.getService(this, class$org$dsi$ifc$displaymanagement$DSIDisplayManagement == null ? (class$org$dsi$ifc$displaymanagement$DSIDisplayManagement = ASLDisplayManagementTarget.class$("org.dsi.ifc.displaymanagement.DSIDisplayManagement")) : class$org$dsi$ifc$displaymanagement$DSIDisplayManagement);
        this.displayBrightness.setDsiDisplayManagement(this.dsiDisplayManagement);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$displaymanagement$DSIDisplayManagementListener == null ? (class$org$dsi$ifc$displaymanagement$DSIDisplayManagementListener = ASLDisplayManagementTarget.class$("org.dsi.ifc.displaymanagement.DSIDisplayManagementListener")) : class$org$dsi$ifc$displaymanagement$DSIDisplayManagementListener, this);
        DSIListener dSIListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$powermanagement$DSIPowerManagementListener == null ? (class$org$dsi$ifc$powermanagement$DSIPowerManagementListener = ASLDisplayManagementTarget.class$("org.dsi.ifc.powermanagement.DSIPowerManagementListener")) : class$org$dsi$ifc$powermanagement$DSIPowerManagementListener);
        DSIPowerManagement dSIPowerManagement = (DSIPowerManagement)dSIProxy.getService(this, class$org$dsi$ifc$powermanagement$DSIPowerManagement == null ? (class$org$dsi$ifc$powermanagement$DSIPowerManagement = ASLDisplayManagementTarget.class$("org.dsi.ifc.powermanagement.DSIPowerManagement")) : class$org$dsi$ifc$powermanagement$DSIPowerManagement);
        dSIPowerManagement.setNotification(9, dSIListener);
        this.triggerAnimationSplashScreenTimer();
        if (this.isTraceEnabled()) {
            this.trace().append("[ASLDisplayManagementTarget] ").append("Call setNotification(DSIPowerManagement.ATTR_SPLASHSCREENANIMATION)").log();
        }
        this.loadDataFromSharedPersistence();
        this.setupProfileChangeListener();
        this.dsiDisplayManagement.getExtents(16);
        this.initFromPersistence();
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getTargetId(), 5602, 5);
        this.send(eventGeneric);
        this.setupScreenshotService();
        this.setupDisplayManagementService();
        this.setupDisplayOperation(dSIProxy, this.services.getLogger());
        this.addObservers(new int[]{-960090880, 782057728, 966607104, 1148656384, 882721024});
        this.declareDisplayContexts();
        this.initResetParticipants(this.services);
    }

    private void setupDisplayOperation(DSIProxy dSIProxy, Logger logger) {
        this.setDisplayTypeOperation = new SetDisplayTypeOperation(dSIProxy, logger);
        this.setUpdateRateOpertation = new SetUpdateRateOpertation(dSIProxy, logger);
    }

    private void setupDisplayManagementService() {
        DisplayManagementService displayManagementService = (DisplayManagementService)this.services.getAslAsyncServiceFactory().create(this);
        Dictionary dictionary = null;
        this.services.getBundleContext().registerService((class$de$vw$mib$display$DisplayManagementService == null ? (class$de$vw$mib$display$DisplayManagementService = ASLDisplayManagementTarget.class$("de.vw.mib.display.DisplayManagementService")) : class$de$vw$mib$display$DisplayManagementService).getName(), (Object)displayManagementService, dictionary);
    }

    private void registerAsyncDisplayManagerTarget() {
        AsyncServiceFactory asyncServiceFactory = this.services.getAslAsyncServiceFactory();
        ASLDisplayManagerTarget aSLDisplayManagerTarget = (ASLDisplayManagerTarget)asyncServiceFactory.create(this);
        BundleContext bundleContext = this.services.getBundleContext();
        bundleContext.registerService((class$de$vw$mib$asl$ASLDisplayManagerTarget == null ? (class$de$vw$mib$asl$ASLDisplayManagerTarget = ASLDisplayManagementTarget.class$("de.vw.mib.asl.ASLDisplayManagerTarget")) : class$de$vw$mib$asl$ASLDisplayManagerTarget).getName(), (Object)aSLDisplayManagerTarget, null);
    }

    private DSIDisplayManagement createAsyncDisplayManagement() {
        DSIDisplayManagement dSIDisplayManagement = (DSIDisplayManagement)this.services.getDsiProxy().getService(this, class$org$dsi$ifc$displaymanagement$DSIDisplayManagement == null ? (class$org$dsi$ifc$displaymanagement$DSIDisplayManagement = ASLDisplayManagementTarget.class$("org.dsi.ifc.displaymanagement.DSIDisplayManagement")) : class$org$dsi$ifc$displaymanagement$DSIDisplayManagement);
        AsyncServiceFactory asyncServiceFactory = this.services.getAslAsyncServiceFactory();
        DSIDisplayManagement dSIDisplayManagement2 = (DSIDisplayManagement)asyncServiceFactory.create(dSIDisplayManagement);
        return dSIDisplayManagement2;
    }

    private void setupScreenshotService() {
        this.screenshotService = this.createScreenshotService();
        ScreenshotKeyListener screenshotKeyListener = new ScreenshotKeyListener(this.screenshotService);
        this.systemApi.addKeyListener(1, screenshotKeyListener);
        this.systemApi.addKeyListener(12, screenshotKeyListener);
        this.systemApi.addKeyListener(33, screenshotKeyListener);
        Dictionary dictionary = null;
        this.services.getBundleContext().registerService((class$de$vw$mib$debug$screenshot$ScreenshotProvider == null ? (class$de$vw$mib$debug$screenshot$ScreenshotProvider = ASLDisplayManagementTarget.class$("de.vw.mib.debug.screenshot.ScreenshotProvider")) : class$de$vw$mib$debug$screenshot$ScreenshotProvider).getName(), (Object)this.screenshotService, dictionary);
    }

    private ScreenshotService createScreenshotService() {
        boolean bl = this.readScreenshotProperty();
        AbstractScreenshotService abstractScreenshotService = bl ? new OldScreenshotService(this.services, this.persistableData) : new ExternalScreenshotService(this.services, this.persistableData);
        return (ScreenshotService)this.services.getAslAsyncServiceFactory().create(abstractScreenshotService);
    }

    private void setupProfileChangeListener() {
        ASLSystemAPI aSLSystemAPI = this.systemApi;
        SharedSystemCommonPersistence sharedSystemCommonPersistence = this.systemApi.getSharedSystemCommonPersistence();
        DisplayBrightness displayBrightness = this.displayBrightness;
        sharedSystemCommonPersistence.addProfileChangeListener(new ASLDisplayManagementTarget$1(this, sharedSystemCommonPersistence, aSLSystemAPI, displayBrightness));
    }

    private boolean readScreenshotProperty() {
        boolean bl = Boolean.getBoolean("useOldScreenshotMethod");
        if (this.isTraceEnabled()) {
            this.trace().append("[ASLDisplayManagementTarget] ").append("readScreenshotProperty useOldScreenshotMethod ").append(bl).log();
        }
        return bl;
    }

    private void triggerFirstContextSwitchWasRequested() {
        if (!this.firstContextSwitchWasRequested) {
            EventGeneric eventGeneric = null;
            this.triggerObserver(701895424, eventGeneric);
            this.firstContextSwitchWasRequested = true;
        }
    }

    private int[] getDisplayableArray(IntSet intSet) {
        int[] nArray = new int[intSet.size()];
        IntIterator intIterator = intSet.iterator();
        int n = 0;
        while (intIterator.hasNext()) {
            nArray[n++] = intIterator.next();
        }
        Arrays.sort(nArray);
        return nArray;
    }

    private int getDisplayContext(int[] nArray) {
        int n;
        int n2;
        int n3;
        if (this.isTraceEnabled()) {
            LogMessage logMessage = this.trace().append("[ASLDisplayManagementTarget] ").append("getDisplayContext for");
            for (n3 = 0; n3 < nArray.length; ++n3) {
                logMessage.append(" ").append(nArray[n3]);
                logMessage.append(" ").append(this.getNameForDisplayable(nArray[n3]));
            }
            logMessage.log();
        }
        this.activeDisplayableComponent = new DisplayableComponentData(-1);
        for (n2 = 0; n2 < nArray.length; ++n2) {
            this.activeDisplayableComponent = new DisplayableComponentData(nArray[n2]);
            if (!this.activeDisplayableComponent.isVideoOrTvDisplayableComponent()) continue;
            ASLDisplayManagementTarget.writeIntegerToDatapool(116, this.displayBrightness.getBrightnessFromPersistence(this.activeDisplayableComponent.getDisplayableComponentId()));
            ASLDisplayManagementTarget.writeIntegerToDatapool(117, this.persistableData.getVideoDisplayableContrast(this.activeDisplayableComponent.getDisplayableComponentId()));
            ASLDisplayManagementTarget.writeIntegerToDatapool(133, this.persistableData.getVideoDisplayableSaturation(this.activeDisplayableComponent.getDisplayableComponentId()));
            ASLDisplayManagementTarget.writeIntegerToDatapool(134, this.persistableData.getVideoDisplayableTint(this.activeDisplayableComponent.getDisplayableComponentId()));
            if (this.displayableInfoMap.containsKey(this.activeDisplayableComponent.getDisplayableComponentId())) {
                ASLDisplayManagementTarget.writeBooleanToDatapool(4000, this.displayableInfoMap.get(this.activeDisplayableComponent.getDisplayableComponentId()));
                continue;
            }
            this.dsiDisplayManagement.getDisplayableInfo(0, this.activeDisplayableComponent.getDisplayableComponentId());
        }
        n2 = this.calculateDisplayableKeyForMap(nArray);
        if (this.displayableMap.containsKey(n2)) {
            return this.displayableMap.get(n2);
        }
        for (n3 = 0; n3 < nArray.length; ++n3) {
            n = nArray[n3];
            if (n != 17) continue;
            LogMessage logMessage = this.warn().append("[ASLDisplayManagementTarget] ").append("no display Context found, using default rvc display context! requested displayables: ");
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                logMessage.append(" ").append(nArray[i2]);
                logMessage.append(" ").append(this.getNameForDisplayable(nArray[i2]));
            }
            logMessage.log();
            return this.defaultRvcDisplayContextId;
        }
        LogMessage logMessage = this.warn().append("[ASLDisplayManagementTarget] ").append("no display Context found, using default display context! requested displayables: ");
        for (n = 0; n < nArray.length; ++n) {
            logMessage.append(" ").append(nArray[n]);
            logMessage.append(" ").append(this.getNameForDisplayable(nArray[n]));
        }
        logMessage.log();
        return this.defaultDisplayContextId;
    }

    private String getNameForDisplayable(int n) {
        String string = this.displayableNames.containsKey(n) ? this.displayableNames.get(n).toString() : "UNDECLARED";
        return string;
    }

    private void startSwitchSequence() {
        if (this.isTraceEnabled()) {
            this.trace().append("[ASLDisplayManagementTarget] ").append("startSwitchSequence").log();
        }
        this.isSwitchContextSequenceActive = true;
        this.startTimer(143065344, (long)0, false);
    }

    private void endSwitchSequence() {
        if (this.isTraceEnabled()) {
            this.trace().append("[ASLDisplayManagementTarget] ").append("endSwitchSequence").log();
        }
        if (this.initialSwitchContextPending) {
            if (this.isTraceEnabled()) {
                this.trace().append("[ASLDisplayManagementTarget] ").append("initialSwitchContextPending, call switchDisplay").log();
            }
            this.initialSwitchContextPending = false;
            this.systemApi.switchPendingDisplayState();
        }
        this.isSwitchContextSequenceActive = false;
        this.stopTimer(143065344);
        if (this.queuedContextId != -1) {
            if (this.queuedContextId != this.currentContextId) {
                if (this.isTraceEnabled()) {
                    this.trace().append("[ASLDisplayManagementTarget] ").append("endSwitchSequence: switching to queuedContextId: ").append(this.queuedContextId).log();
                }
                this.pendingContextId = this.queuedContextId;
                this.queuedContextId = -1;
                this.switchContext();
            } else {
                if (this.isTraceEnabled()) {
                    this.trace().append("[ASLDisplayManagementTarget] ").append("endSwitchSequence: queuedContextId already reached: ").append(this.queuedContextId).log();
                }
                this.queuedContextId = -1;
            }
        } else {
            this.pendingContextId = -1;
            this.pendingDisplayLayerGroup = -1;
        }
    }

    private void switchContext() {
        if (this.isTraceEnabled()) {
            this.trace().append("[ASLDisplayManagementTarget] ").append("switchContext").log();
        }
        this.pendingDisplayLayerGroup = this.getGroupForContext(this.pendingContextId);
        this.startSwitchSequence();
        boolean bl = this.hasDisplayToBeLockedDuringSwitchContext();
        this.switchContext(bl);
    }

    private void checkForSwitchContext() {
        boolean bl;
        if (this.isTraceEnabled()) {
            this.trace().append("[ASLDisplayManagementTarget] ").append("checkForSwitchContext").log();
        }
        boolean bl2 = this.splashScreenAnimationStatus == 2 || this.isRvcActive;
        boolean bl3 = bl = bl2 && this.switchContextPending && this.isHmiReadyBeenAckowledged;
        if (bl) {
            int[] nArray = this.getDisplayableArray(this.displayableSet);
            int n = this.getDisplayContext(nArray);
            boolean bl4 = false;
            this.queuedContextId = -1;
            if (this.isMapDisplayContext(n)) {
                if (this.mapIsReady) {
                    bl4 = true;
                } else {
                    this.info().append("[ASLDisplayManagementTarget] ").append("switch to map display context but map not ready, queuedContextId: ").append(n).log();
                    this.queuedContextId = n;
                }
            } else {
                bl4 = true;
            }
            if (bl4) {
                if (this.isSwitchContextSequenceActive) {
                    if (this.isTraceEnabled()) {
                        this.trace().append("[ASLDisplayManagementTarget] ").append("Context change sequence has not yet been finished, don't switch but store contextId: ").append(n).log();
                    }
                    this.queuedContextId = n;
                } else {
                    this.switchContextPending = false;
                    if (n != this.currentContextId) {
                        this.pendingContextId = n;
                        if (this.isTraceEnabled()) {
                            this.trace().append("[ASLDisplayManagementTarget] ").append("switch to display context, context Id: ").append(n).append(" ").append(this.displayContextNames.get(n)).log();
                        }
                        this.switchContext();
                    } else {
                        if (this.isTraceEnabled()) {
                            this.trace().append("[ASLDisplayManagementTarget] ").append("don't switch, context Id not changed: ").append(n).log();
                        }
                        this.pendingContextId = -1;
                        this.pendingDisplayLayerGroup = -1;
                    }
                }
            }
        }
    }

    private void switchContext(boolean bl) {
        this.unlockDisplayPending = bl;
        this.switchContextPendingAfterLockDisplay = bl;
        if (bl) {
            this.activateLockDisplay(0);
        } else {
            if (this.isTraceEnabled()) {
                this.trace().append("[ASLDisplayManagementTarget] ").append("Call DSIDisplayManagement.switchContext ").append(this.pendingContextId).log();
            }
            this.performContextSwitch();
        }
    }

    private void activateLockDisplay(int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("[ASLDisplayManagementTarget] ").append("Call DSIDisplayManagement.lockDisplay").log();
        }
        this.displayIsLocked = true;
        this.dsiDisplayManagement.lockDisplay(n);
    }

    private int getGroupForContext(int n) {
        return this.displayContextGroups.get(n);
    }

    private boolean isMapDisplayContext(int n) {
        return 1 == this.getGroupForContext(n);
    }

    private boolean hasDisplayToBeLockedDuringSwitchContext() {
        boolean bl;
        switch (this.oldDisplayLayerGroup) {
            case -1: {
                bl = false;
                break;
            }
            case 0: {
                bl = false;
                break;
            }
            case 1: {
                bl = this.pendingDisplayLayerGroup == 3;
                break;
            }
            case 2: {
                bl = false;
                break;
            }
            case 3: {
                bl = this.pendingDisplayLayerGroup == 1;
                break;
            }
            case 4: {
                bl = false;
                break;
            }
            default: {
                bl = false;
            }
        }
        return bl;
    }

    private void setHMIReady() {
        if (this.hmiReadyIsPending && !this.isSetHMIReadyHasBeenSent) {
            boolean bl;
            boolean bl2;
            boolean bl3 = this.checkRvcStateConfroms();
            boolean bl4 = this.displayableSet.contains(17);
            if (this.isTraceEnabled()) {
                if (this.splashScreenAnimationStatus == 0) {
                    this.trace().append("[ASLDisplayManagementTarget] ").append("setHMIReady: Splashcreen animation has not been shown!").log();
                } else if (this.splashScreenAnimationStatus == 1) {
                    this.trace().append("[ASLDisplayManagementTarget] ").append("setHMIReady: Splashcreen animation is still running, don't call setHMIReady yet").log();
                }
                if (this.splashScreenAnimationStatus != 2 && bl4) {
                    this.trace().append("[ASLDisplayManagementTarget] ").append("setHMIReady: Ignoring the splash screen animation since RVC was requested").log();
                }
                this.trace().append("[ASLDisplayManagementTarget] ").append("setHMIReady: RVC state conforms? ").append(bl3).log();
                this.trace().append("[ASLDisplayManagementTarget] ").append("startupGuiReadyRecieved = ").append(this.startupGuiReadyRecieved).log();
                this.trace().append("[ASLDisplayManagementTarget] ").append("setHmiDelayPassed = ").append(this.setHmiDelayPassed).log();
            }
            boolean bl5 = this.getTimerServer().isTimerActive(this.getTargetId(), 1753678080);
            boolean bl6 = !bl3 && !bl5;
            boolean bl7 = bl2 = this.splashScreenAnimationStatus == 2 || bl4;
            if (bl6) {
                bl = false;
                this.startTimer(1753678080, (long)0, bl);
            }
            boolean bl8 = bl = bl2 && bl3 && this.startupGuiReadyRecieved;
            if (bl) {
                boolean bl9;
                boolean bl10 = this.setHmiReadyDelay != 0;
                boolean bl11 = bl9 = !this.setHmiDelayPassed && bl10 && bl4;
                if (bl9) {
                    boolean bl12 = this.getTimerServer().isTimerActive(this.getTargetId(), 1770455296);
                    if (!bl12) {
                        if (this.isTraceEnabled()) {
                            this.trace().append("[ASLDisplayManagementTarget] ").append("starting timer TIMER_SET_HMI_READY_DELAY").append(this.setHmiDelayPassed).log();
                        }
                        this.startTimer(1770455296, (long)this.setHmiReadyDelay, false);
                    }
                } else {
                    if (this.isTraceEnabled()) {
                        this.trace().append("[ASLDisplayManagementTarget] ").append("setHMIReady: Splashcreen animation has been running, First switch context imminent, send Event ASL_SYSTEM_SET_HMI_READY to PowerManagement").log();
                    }
                    try {
                        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getTargetId(), 5603, 245186816);
                        this.send(eventGeneric);
                    }
                    catch (GenericEventException genericEventException) {
                        this.error(genericEventException);
                    }
                    if (bl5) {
                        if (this.isTraceEnabled()) {
                            this.trace().append("[ASLDisplayManagementTarget] ").append("setHMIReady: Stopping rvc confroms fallback timer").log();
                        }
                        this.stopTimer(1753678080);
                    }
                    this.isSetHMIReadyHasBeenSent = true;
                }
            }
        }
    }

    private boolean checkRvcStateConfroms() {
        boolean bl = this.displayableSet.contains(17);
        return this.ignoreRvcConform || this.isRvcActive == bl;
    }

    private void triggerAnimationSplashScreenTimer() {
        if (this.animationSplashScreenTimerActive) {
            if (this.isTraceEnabled()) {
                this.trace().append("[ASLDisplayManagementTarget] ").append("triggerAnimationSplashScreenTimer, retriggerTimer( EV_ANIMATION_SPLASHSCREEN_TIMER )!").log();
            }
            this.retriggerTimer(126288128);
        } else {
            if (this.isTraceEnabled()) {
                this.trace().append("[ASLDisplayManagementTarget] ").append("triggerAnimationSplashScreenTimer, startTimer( EV_ANIMATION_SPLASHSCREEN_TIMER )").log();
            }
            this.animationSplashScreenTimerActive = true;
            this.startTimer(126288128, (long)0, false);
        }
    }

    private void processVideoSetupTimer() {
        if (this.isTraceEnabled()) {
            this.trace().append("[ASLDisplayManagementTarget] ").append("processVideoSetupTimer").log();
        }
        if (this.displayTimer.isDisplaySetupTimerActive()) {
            this.displayTimer.setDisplaySetupTimerActive(false);
            if (this.activeDisplayableComponent.isCachedBrightnessSet()) {
                this.displayBrightness.writeDisplayableComponentBrightnessToDsi(this.activeDisplayableComponent);
            }
            if (this.activeDisplayableComponent.getCachedColor() != -65536) {
                this.writeDisplayableColorToDSI(this.activeDisplayableComponent.getDisplayableComponentId(), this.activeDisplayableComponent.getCachedColor());
            }
            if (this.activeDisplayableComponent.getCachedContrast() != -65536) {
                this.writeDisplayableContrastToDSI(this.activeDisplayableComponent.getDisplayableComponentId(), this.activeDisplayableComponent.getCachedContrast());
            }
            if (this.activeDisplayableComponent.getCachedTint() != -65536) {
                this.writeDisplayableTintToDSI(this.activeDisplayableComponent.getDisplayableComponentId(), this.activeDisplayableComponent.getCachedTint());
            }
        }
    }

    private void processVideoResponseTimer() {
        if (this.displayTimer.isDisplayResponseTimerActive() && this.activeDisplayableComponent.isDisplayableComponentIDSet()) {
            this.displayTimer.setDisplayResponseTimerActive(false);
            if (this.activeDisplayableComponent.isCachedBrightnessSet()) {
                this.activeDisplayableComponent.unsetCachedBrightness();
                if (this.activeDisplayableComponent.isVideoOrTvDisplayableComponent()) {
                    ASLDisplayManagementTarget.writeIntegerToDatapool(116, this.displayBrightness.getBrightnessFromPersistence(this.activeDisplayableComponent.getDisplayableComponentId()));
                } else if (this.activeDisplayableComponent.isRearViewCamDisplayableComponent()) {
                    ASLDisplayManagementTarget.writeIntegerToDatapool(10181, this.persistableData.getRVCDisplayableBrightness());
                }
            }
            if (this.activeDisplayableComponent.isCachedColorSet()) {
                this.activeDisplayableComponent.unsetCachedColor();
                if (this.activeDisplayableComponent.isVideoOrTvDisplayableComponent()) {
                    ASLDisplayManagementTarget.writeIntegerToDatapool(133, this.persistableData.getVideoDisplayableSaturation(this.activeDisplayableComponent.getDisplayableComponentId()));
                } else if (this.activeDisplayableComponent.isRearViewCamDisplayableComponent()) {
                    ASLDisplayManagementTarget.writeIntegerToDatapool(10182, this.persistableData.getRVCDisplayableColor());
                }
            }
            if (this.activeDisplayableComponent.isCachedContrastSet()) {
                this.activeDisplayableComponent.unsetCachedContrast();
                if (this.activeDisplayableComponent.isVideoOrTvDisplayableComponent()) {
                    ASLDisplayManagementTarget.writeIntegerToDatapool(117, this.persistableData.getVideoDisplayableContrast(this.activeDisplayableComponent.getDisplayableComponentId()));
                } else if (this.activeDisplayableComponent.isRearViewCamDisplayableComponent()) {
                    ASLDisplayManagementTarget.writeIntegerToDatapool(10183, this.persistableData.getRVCDisplayableContrast());
                }
            }
            if (this.activeDisplayableComponent.isCachedTintSet()) {
                this.activeDisplayableComponent.unsetCachedTint();
                if (this.activeDisplayableComponent.isVideoOrTvDisplayableComponent()) {
                    ASLDisplayManagementTarget.writeIntegerToDatapool(134, this.persistableData.getVideoDisplayableTint(this.activeDisplayableComponent.getDisplayableComponentId()));
                }
            }
        }
    }

    private void performContextSwitch() {
        this.dsiDisplayManagement.switchContext(this.pendingContextId, 0, 0);
        PerfService perfService = DisplayManagementServicesProvider.getServices().getPerfService();
        if (perfService != null) {
            perfService.performanceLogContextSwitch(this.displayableSet.toArray());
        }
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
        DEFAULT_RESOLUTION = new Dimension(ServiceManager.configManagerDiag.getDisplayDefault(0), ServiceManager.configManagerDiag.getDisplayDefault(1));
        displayableExtents = new IntObjectOptHashMap();
        DSI_DISPLAY_BRIGHTNESS_DIMMED = 0;
    }
}


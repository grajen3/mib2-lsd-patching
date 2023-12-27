/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system;

import de.vw.mib.asl.api.system.ASLSystemAPI;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.DriverDistractionPreventionService;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponents;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetService;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyAdapterFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListenerAdapter;
import de.vw.mib.asl.framework.api.startupv7r.ASLStartupv7rAPI;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.asl.internal.impl.system.SystemServicesProvider;
import de.vw.mib.asl.internal.impl.system.ddp.DdpFrameworkNotifierInstaller;
import de.vw.mib.asl.internal.system.AslTargetSystemVehicleStates$1;
import de.vw.mib.asl.internal.system.AslTargetSystemVehicleStates$2;
import de.vw.mib.asl.internal.system.AslTargetSystemVehicleStates$3;
import de.vw.mib.asl.internal.system.AslTargetSystemVehicleStates$4;
import de.vw.mib.asl.internal.system.AslTargetSystemVehicleStates$5;
import de.vw.mib.asl.internal.system.SystemAccessor;
import de.vw.mib.asl.internal.system.has.SystemHasBridgeImpl;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carvehiclestates.DSICarVehicleStates;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoHighFrequent;
import org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates;
import org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener;
import org.dsi.ifc.global.CarBCSpeed;
import org.dsi.ifc.powermanagement.ClampSignal;
import org.dsi.ifc.powermanagement.DSIPowerManagement;
import org.dsi.ifc.powermanagement.DSIPowerManagementListener;
import org.osgi.framework.BundleContext;

public final class AslTargetSystemVehicleStates
extends AbstractASLTarget
implements DSIServiceStateListener {
    private static final String LOGGING_DELIM;
    private boolean valueClamp15 = false;
    private boolean videoThresholdExceeded = false;
    private boolean messagingThresholdExceeded = false;
    private boolean destinationInputThresholdExceeded = false;
    private boolean btBondingThresholdExceeded = false;
    private boolean slideshowThresholdExceeded = false;
    private boolean demoGuidanceVelocityThresholdExceeded = false;
    private boolean demoGuidanceVelocityThresholdTriggered = false;
    private int oldVelocity = 0;
    private boolean spellerIsShown = false;
    private boolean spellerDisclaimerIsShown = false;
    private boolean spellerDisclaimerWasShown = false;
    private boolean messagingTextEditorActive = false;
    private boolean dabSlideShowActive = false;
    private boolean dabSlideShowLimited = false;
    private boolean btAuthProcedureBlockingState = true;
    private final ASLSystemAPI systemApi = ASLSystemFactory.getSystemApi();
    private DSIListener dsiGeneralVehicleStatesListener;
    private DSIGeneralVehicleStates dsiGeneralVehicleStates;
    static /* synthetic */ Class class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates;
    static /* synthetic */ Class class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates;
    static /* synthetic */ Class class$org$dsi$ifc$powermanagement$DSIPowerManagement;
    static /* synthetic */ Class class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener;

    public AslTargetSystemVehicleStates(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        SystemAccessor.setVehicleStatesTarget(this);
        ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates == null ? (class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates = AslTargetSystemVehicleStates.class$("org.dsi.ifc.carvehiclestates.DSICarVehicleStates")) : class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates, this);
    }

    public AslTargetSystemVehicleStates(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        SystemAccessor.setVehicleStatesTarget(this);
        ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates == null ? (class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates = AslTargetSystemVehicleStates.class$("org.dsi.ifc.carvehiclestates.DSICarVehicleStates")) : class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates, this);
    }

    @Override
    public int getSubClassifier() {
        return 2048;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.processPowerOn();
                break;
            }
            case 4300047: {
                this.processSetAuthProcedureBlocking(eventGeneric.getBoolean(0));
                break;
            }
            case 4300064: {
                this.dabSlideShowActive = eventGeneric.getBoolean(0);
                this.sendDabSlideshowStatus();
                break;
            }
            case 1073743208: {
                this.processAslDownUserConfirmedSpellerDisclaimer();
                break;
            }
            case 1073743191: {
                this.spellerIsShown = eventGeneric.getBoolean(0);
                this.setShowSpellerDisclaimer();
                break;
            }
            case 1073742242: {
                this.messagingTextEditorActive = true;
                this.setShowSpellerDisclaimer();
                break;
            }
            case 1073742239: {
                this.messagingTextEditorActive = false;
                this.setShowSpellerDisclaimer();
                break;
            }
        }
    }

    void dsiGeneralVehicleStatesUpdateDestinationInputVelocityThreshold(boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetSystemVehicleStates] ").append("dsiGeneralVehicleStatesUpdateDestinationInputVelocityThreshold ").append(bl).log();
        }
        this.destinationInputThresholdExceeded = bl;
        this.setShowSpellerDisclaimer();
    }

    void dsiGeneralVehicleStatesUpdateBrowserSlideShowVelocityThreshold(boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetSystemVehicleStates] ").append("dsiGeneralVehicleStatesUpdateBrowserSlideShowVelocityThreshold ").append(bl).append(" velocity: ").append(this.oldVelocity).log();
        }
        this.slideshowThresholdExceeded = bl;
        this.sendDabSlideshowStatus();
    }

    void dsiGeneralVehicleStatesUpdateRadiotextVelocityThreshold(boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetSystemVehicleStates] ").append("dsiGeneralVehicleStatesUpdateRadiotextVelocityThreshold ").append(bl).append(" velocity: ").append(this.oldVelocity).log();
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setBoolean(0, bl);
        this.triggerObserver(-409190144, eventGeneric);
    }

    void dsiGeneralVehicleStatesUpdateTVVelocityThreshold(boolean bl, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetSystemVehicleStates] ").append("dsiGeneralVehicleStatesUpdateTVVelocityThreshold ").append(bl).append(" velocity: ").append(this.oldVelocity).log();
        }
        if (this.videoThresholdExceeded != bl) {
            this.videoThresholdExceeded = bl;
            AslTargetSystemVehicleStates.writeBooleanToDatapool(1644, bl);
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
            eventGeneric.setBoolean(0, this.videoThresholdExceeded);
            this.triggerObserver(312295680, eventGeneric);
        }
    }

    void dsiGeneralVehicleStatesUpdateBTBondingVelocityThreshold(boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetSystemVehicleStates] ").append("dsiGeneralVehicleStatesUpdateBTBondingVelocityThreshold ").append(bl).append(" velocity: ").append(this.oldVelocity).log();
        }
        this.btBondingThresholdExceeded = bl;
        this.checkBtAuthProcedureBlockingState();
    }

    void dsiGeneralVehicleStatesUpdateMessagingVelocityThreshold(boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetSystemVehicleStates] ").append("dsiGeneralVehicleStatesUpdateMessagingVelocityThreshold ").append(bl).append(" velocity: ").append(this.oldVelocity).log();
        }
        this.messagingThresholdExceeded = bl;
        this.setShowSpellerDisclaimer();
    }

    void dsiGeneralVehicleStatesUpdateBrowserWebVelocityThreshold(boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetSystemVehicleStates] ").append("dsiGeneralVehicleStatesUpdateBrowserWebVelocityThreshold ").append(bl).append(" velocity: ").append(this.oldVelocity).log();
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setBoolean(0, bl);
        this.triggerObserver(849166592, eventGeneric);
    }

    void dsiGeneralVehicleStatesUpdateVehicleStandstill(boolean bl, int n) {
        SystemHasBridgeImpl.getInstance().setPropertyDrivingState(!bl);
    }

    public void dsiCarVehicleStatesUpdateDynamicVehicleInfoHighFrequent(DynamicVehicleInfoHighFrequent dynamicVehicleInfoHighFrequent, int n) {
        CarBCSpeed carBCSpeed;
        int n2;
        if (n == 1 && (n2 = (carBCSpeed = dynamicVehicleInfoHighFrequent.getVehicleSpeed()).getSpeedValueState()) == 1) {
            float f2 = carBCSpeed.getSpeedValue();
            int n3 = carBCSpeed.getSpeedUnit() == 0 ? (int)f2 : (int)(f2 / -620835521);
            this.oldVelocity = n3;
            AslTargetSystemVehicleStates.writeIntegerToDatapool(1595, this.oldVelocity);
            this.checkForDemoguidanceVelocityThreshold();
        }
    }

    public void dsiCarVehicleStatesUpdateVINData(String string, int n) {
        if (n == 1) {
            SystemHasBridgeImpl.getInstance().setPropertyVIN(string);
        }
    }

    void dsiPowerManagementUpdateClampSignal(ClampSignal clampSignal) {
        if (!clampSignal.clamp15 && this.valueClamp15) {
            this.spellerDisclaimerWasShown = false;
            this.btAuthProcedureBlockingState = true;
            AslTargetSystemVehicleStates.writeBooleanToDatapool(1615, this.btAuthProcedureBlockingState);
        }
        this.valueClamp15 = clampSignal.clamp15;
    }

    @Override
    public void registered(String string, int n) {
        String string2 = string.intern();
        if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[31]) {
            this.setNotificationForCarVehicleStates();
            ServiceManager.dsiServiceLocator.removeServiceStateListener(class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates == null ? (class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates = AslTargetSystemVehicleStates.class$("org.dsi.ifc.carvehiclestates.DSICarVehicleStates")) : class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates, this);
        }
    }

    @Override
    public void unregistered(String string, int n) {
    }

    @Override
    public int getDefaultTargetId() {
        return 5610;
    }

    void updateVelocityExceedance(boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetSystemVehicleStates] ").append("updateVelocityExceedance ").append(bl).append(" velocity: ").append(this.oldVelocity).log();
        }
    }

    void processRevertSystemVehicleStates() {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetSystemVehicleStates] ").append("processRevertSystemVehicleStates").log();
        }
        this.btAuthProcedureBlockingState = true;
        AslTargetSystemVehicleStates.writeBooleanToDatapool(1615, this.btAuthProcedureBlockingState);
        this.spellerDisclaimerWasShown = false;
    }

    void connectToDsiGeneralVehicleStates() {
        try {
            DSIProxy dSIProxy = SystemServicesProvider.getSystemServices().getDsiProxy();
            if (this.dsiGeneralVehicleStatesListener == null) {
                this.dsiGeneralVehicleStatesListener = this.createDsiGeneralVehicleStatesListener();
                this.dsiGeneralVehicleStates = (DSIGeneralVehicleStates)dSIProxy.getService(this, class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = AslTargetSystemVehicleStates.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates);
            }
            this.dsiGeneralVehicleStates.setNotification(new int[]{10, 15, 8, 17, 18, 13, 22, 19}, this.dsiGeneralVehicleStatesListener);
        }
        catch (Throwable throwable) {
            this.info("Could not connect to DSIGeneralVehicleStates");
        }
    }

    private void installDdpFrameworkNotifier() {
        DriverDistractionPreventionService driverDistractionPreventionService = this.systemApi.getDriverDistractionPreventionService();
        BundleContext bundleContext = SystemServicesProvider.getSystemServices().getBundleContext();
        ThreadSwitchingTarget threadSwitchingTarget = SystemServicesProvider.getSystemServices().getThreadSwitcher();
        new DdpFrameworkNotifierInstaller(threadSwitchingTarget, driverDistractionPreventionService, bundleContext).install();
    }

    private void registerDdpServiceHandler() {
        DriverDistractionPreventionService driverDistractionPreventionService = this.systemApi.getDriverDistractionPreventionService();
        driverDistractionPreventionService.addDriverDistractionPreventionListener(new AslTargetSystemVehicleStates$1(this));
    }

    private void processAslDownUserConfirmedSpellerDisclaimer() {
        this.spellerDisclaimerIsShown = false;
        if (SystemAccessor.getFeaturesAndCodingTarget().getSpellerDisclaimerDiagMode() != 1) {
            this.spellerDisclaimerWasShown = true;
        }
        AslTargetSystemVehicleStates.writeIntegerToDatapool(1628, 3);
    }

    private DSIServiceStateListenerAdapter createDsiServiceStateAdapter() {
        return new AslTargetSystemVehicleStates$2(this);
    }

    private void sendDabSlideshowStatus() {
        if (SystemAccessor.getFeaturesAndCodingTarget().isDabFeatureFlagValue()) {
            boolean bl;
            boolean bl2 = bl = this.dabSlideShowActive && this.slideshowThresholdExceeded;
            if (this.dabSlideShowLimited != bl) {
                this.dabSlideShowLimited = bl;
                EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
                eventGeneric.setBoolean(0, bl);
                this.triggerObserver(563953920, eventGeneric);
            }
        }
    }

    private void checkBtAuthProcedureBlockingState() {
        if (this.btAuthProcedureBlockingState) {
            this.setShowBTBondingDisclaimer(this.btBondingThresholdExceeded);
        } else if (this.btBondingThresholdExceeded) {
            this.setShowBTBondingDisclaimer(false);
        }
    }

    private void setShowBTBondingDisclaimer(boolean bl) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setBoolean(0, bl);
        this.triggerObserver(530399488, eventGeneric);
        int n = bl ? 1 : 0;
        AslTargetSystemVehicleStates.writeIntegerToDatapool(1578, n);
    }

    private void setShowSpellerDisclaimer() {
        boolean bl = false;
        boolean bl2 = false;
        boolean bl3 = false;
        if (SystemAccessor.getFeaturesAndCodingTarget().getSpellerDisclaimerDiagMode() != 2 && !this.spellerDisclaimerWasShown) {
            if (this.spellerIsShown) {
                bl2 = this.destinationInputThresholdExceeded;
            }
            if (this.messagingTextEditorActive) {
                bl3 = this.messagingThresholdExceeded;
            }
            boolean bl4 = bl = bl2 || bl3;
        }
        if (this.spellerDisclaimerIsShown != bl) {
            if (bl) {
                AslTargetSystemVehicleStates.writeIntegerToDatapool(1628, SystemAccessor.getFeaturesAndCodingTarget().getSpellerDisclaimerDiagMode());
            } else if (this.spellerDisclaimerIsShown) {
                AslTargetSystemVehicleStates.writeIntegerToDatapool(1628, 3);
                if (SystemAccessor.getFeaturesAndCodingTarget().getSpellerDisclaimerDiagMode() != 1) {
                    this.spellerDisclaimerWasShown = true;
                }
            }
            this.spellerDisclaimerIsShown = bl;
        }
    }

    private void processPowerOn() {
        this.registerDdpServiceHandler();
        this.installDdpFrameworkNotifier();
        this.registerFactoryResetParticipant();
        ASLStartupv7rAPI aSLStartupv7rAPI = SystemServicesProvider.getSystemServices().getAslStartupv7rAPI();
        if (!aSLStartupv7rAPI.isNonCustomerSwdlIsInProgress()) {
            if (this.isTraceEnabled()) {
                this.trace().append("[AslTargetSystemVehicleStates] ").append("processPowerOn").log();
            }
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            this.connectToDsiPowerManagement();
            this.connectToDsiGeneralVehicleStates();
            dSIProxy.addServiceStateListener(class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = AslTargetSystemVehicleStates.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates, this.createDsiServiceStateAdapter());
            AslTargetSystemVehicleStates.writeBooleanToDatapool(2683, true);
        }
    }

    private void registerFactoryResetParticipant() {
        FactoryResetService factoryResetService = SystemServicesProvider.getSystemServices().getFactoryResetService();
        AslTargetSystemVehicleStates$3 aslTargetSystemVehicleStates$3 = new AslTargetSystemVehicleStates$3(this);
        factoryResetService.addParticipant(aslTargetSystemVehicleStates$3, FactoryResetComponents.SYSTEM);
    }

    private void connectToDsiPowerManagement() {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetSystemVehicleStates] ").append("setNotificationForPowerManagement").log();
        }
        DSIProxy dSIProxy = SystemServicesProvider.getSystemServices().getDsiProxy();
        DSIPowerManagementListener dSIPowerManagementListener = this.createDsiPowerManagementListener();
        DSIPowerManagement dSIPowerManagement = (DSIPowerManagement)dSIProxy.getService(this, class$org$dsi$ifc$powermanagement$DSIPowerManagement == null ? (class$org$dsi$ifc$powermanagement$DSIPowerManagement = AslTargetSystemVehicleStates.class$("org.dsi.ifc.powermanagement.DSIPowerManagement")) : class$org$dsi$ifc$powermanagement$DSIPowerManagement);
        dSIPowerManagement.setNotification(4, (DSIListener)dSIPowerManagementListener);
    }

    private void setNotificationForCarVehicleStates() {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetSystemVehicleStates] ").append("setNotificationForCarVehicleStates").log();
        }
        DSIProxy dSIProxy = SystemServicesProvider.getSystemServices().getDsiProxy();
        DSIProxyAdapterFactory dSIProxyAdapterFactory = SystemServicesProvider.getSystemServices().getDsiProxyAdapterFactory();
        DSIListener dSIListener = dSIProxyAdapterFactory.createDSIListenerMethodAdapter(this, class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener == null ? (class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener = AslTargetSystemVehicleStates.class$("org.dsi.ifc.carvehiclestates.DSICarVehicleStatesListener")) : class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener);
        DSICarVehicleStates dSICarVehicleStates = (DSICarVehicleStates)dSIProxy.getService(this, class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates == null ? (class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates = AslTargetSystemVehicleStates.class$("org.dsi.ifc.carvehiclestates.DSICarVehicleStates")) : class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates);
        dSICarVehicleStates.setNotification(new int[]{14, 4}, dSIListener);
    }

    private void processSetAuthProcedureBlocking(boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetSystemVehicleStates] ").append("processSetAuthProcedureBlocking: ").append(bl).log();
        }
        this.btAuthProcedureBlockingState = bl;
        this.checkBtAuthProcedureBlockingState();
    }

    private void checkForDemoguidanceVelocityThreshold() {
        boolean bl;
        int n = 5;
        boolean bl2 = bl = this.oldVelocity > 5;
        if (!this.demoGuidanceVelocityThresholdTriggered || this.demoGuidanceVelocityThresholdExceeded != bl) {
            this.demoGuidanceVelocityThresholdTriggered = true;
            this.demoGuidanceVelocityThresholdExceeded = bl;
            AslTargetSystemVehicleStates.writeBooleanToDatapool(2683, !bl);
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
            eventGeneric.setBoolean(0, bl);
            this.triggerObserver(-493076224, eventGeneric);
        }
    }

    private DSIPowerManagementListener createDsiPowerManagementListener() {
        return new AslTargetSystemVehicleStates$4(this);
    }

    private DSIGeneralVehicleStatesListener createDsiGeneralVehicleStatesListener() {
        return new AslTargetSystemVehicleStates$5(this);
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


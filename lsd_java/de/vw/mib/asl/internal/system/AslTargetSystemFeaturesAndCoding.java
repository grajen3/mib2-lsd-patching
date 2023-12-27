/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system;

import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.SystemFeaturesAndCodingConstants;
import de.vw.mib.asl.framework.api.diagnosis.config.Access;
import de.vw.mib.asl.framework.api.diagnosis.config.Adaptation;
import de.vw.mib.asl.framework.api.diagnosis.config.CarFuncAdap;
import de.vw.mib.asl.framework.api.diagnosis.config.CarFuncListBap;
import de.vw.mib.asl.framework.api.diagnosis.config.Coding;
import de.vw.mib.asl.framework.api.diagnosis.config.DashboardDisplayConfig;
import de.vw.mib.asl.framework.api.diagnosis.config.HmiFunctionBlockTbl;
import de.vw.mib.asl.framework.api.diagnosis.config.Identification;
import de.vw.mib.asl.framework.api.diagnosis.config.InCarCommunication;
import de.vw.mib.asl.framework.api.diagnosis.config.LoadSpeedThreshold;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyAdapterFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.api.lsc.ASLLscFactory;
import de.vw.mib.asl.framework.api.persistence.AslPersistenceSyncApi;
import de.vw.mib.asl.framework.api.persistence.IPersistableEarlyData;
import de.vw.mib.asl.framework.api.startupv7r.ASLStartupv7rFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.DSIServiceLocator;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.asl.internal.impl.system.SystemServicesProvider;
import de.vw.mib.asl.internal.impl.system.ddp.DdpFunctionBlockingListenerInstaller;
import de.vw.mib.asl.internal.impl.system.ddp.FunctionBlockingInfoProvider;
import de.vw.mib.asl.internal.system.AslTargetSystemDate;
import de.vw.mib.asl.internal.system.AslTargetSystemFeaturesAndCoding$1;
import de.vw.mib.asl.internal.system.PersistableEngineType;
import de.vw.mib.asl.internal.system.SystemAccessor;
import de.vw.mib.asl.internal.system.SystemServices;
import de.vw.mib.asl.internal.system.diag.AslDiagDataFetcher;
import de.vw.mib.asl.internal.system.featureflags.AbtFeatureFlagSetter;
import de.vw.mib.asl.internal.system.featureflags.AdaptationSetter;
import de.vw.mib.asl.internal.system.featureflags.CarFuncAdapSetter;
import de.vw.mib.asl.internal.system.featureflags.CarFuncListBapSetter;
import de.vw.mib.asl.internal.system.featureflags.CodingSetter;
import de.vw.mib.asl.internal.system.featureflags.DashboardDisplayConfigSetter;
import de.vw.mib.asl.internal.system.featureflags.DeveloperTestmodeActivatedSetter;
import de.vw.mib.asl.internal.system.featureflags.HmiFunctionBlockTblSetter;
import de.vw.mib.asl.internal.system.featureflags.SpeechFeatureFlagSetter;
import de.vw.mib.asl.internal.system.has.SystemHasBridgeImpl;
import de.vw.mib.asl.internal.system.util.SystemLogger;
import de.vw.mib.asl.systemearly.persistence.SystemEarly;
import de.vw.mib.asl.systemearly.persistence.SystemEarlyPersistenceServiceImpl;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.util.Util;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.bluetooth.DSIBluetooth;
import org.dsi.ifc.media.DSIMediaBase;
import org.dsi.ifc.networking.DSIWLAN;
import org.dsi.ifc.radio.DSIDABTuner;
import org.dsi.ifc.speechrec.DSISpeechRec;

public final class AslTargetSystemFeaturesAndCoding
extends AbstractASLTarget
implements DSIServiceStateListener,
SystemFeaturesAndCodingConstants {
    private static final String DIAG_DELIM;
    private static final String WLAN;
    private static final String RVC;
    private static final String SDS;
    private static final String DAB;
    private static final String BT;
    private static final String VW;
    private static final String SEAT;
    private static final String SKODA;
    private static final String BRAND_IS_TRUE;
    private static final String BRAND_IS_FALSE;
    private static final String AVAILABLE_AND_DETECTED;
    private static final String DETECTED_BUT_NOT_CODED;
    private static final String CODED_BUT_NOT_DETECTED;
    private static final String NOT_AVAILABLE;
    private static final String CODED_BUT_NOT_YET_DETECTED;
    private static final String ACTIVE;
    private static final String NOT_ACTIVE;
    private final PersistableEngineType persistableEngineType = PersistableEngineType.getInstance();
    private Coding storedCodingData = null;
    private Adaptation storedAdaptationData = null;
    private CarFuncAdap storedCarFuncAdap = null;
    private LoadSpeedThreshold storedSpeedThreshold = null;
    private boolean didSetSdsStateAlready;
    private DeveloperTestmodeActivatedSetter developerTestmodeActivatedSetter = null;
    private AslDiagDataFetcher diagFetcher;
    private boolean writingDiagDataToConsole = false;
    private boolean clockDisplayActivated = false;
    private boolean unitMasterDisplayActivated = false;
    private boolean speedThresholdSpellerDeactivatedInTableUpDownLoad = false;
    private int speedLimitSlideshowActive = 255;
    private int spellerDisclaimerDiagMode = 2;
    private int dabSlsDuration1 = -1;
    private int dabSlsDuration2 = -1;
    private int radiotextDuration = -1;
    private boolean isTableCodingAlreadyRead = false;
    private boolean isTableAdaptationAlreadyRead = false;
    private boolean isTableCarFunctionsAdaptationAlreadyRead = false;
    private boolean isSDSCodedAvailable = false;
    private boolean sdsServiceListener = false;
    private boolean dabFeatureFlagValue = false;
    private boolean diagSpeedThresholdsRead = false;
    private boolean isBTStateAlreadyReceived = false;
    private boolean isBTDetectedInSystem = false;
    private boolean isBTCodedAvailable = false;
    private boolean isBTAdaptationModuleActivated = false;
    private boolean isExtPhoneFeatureFlagAlreadySet = false;
    private boolean extPhoneFeatureFlagValue = false;
    private boolean isNADCodedAvailable = false;
    private boolean isInternalPhoneAdaptationModuleActivated = false;
    private boolean internalPhoneFeatureFlagValue = false;
    private boolean isWLANCodedActive = false;
    private boolean isWLANAdaptationModuleActivated = false;
    private boolean isWLANTargetReady = false;
    private boolean isWLANDetectedInSystem = false;
    private boolean isWLANActivationStateAlreadyReceived = false;
    private boolean isAMICodedActive = false;
    private boolean isFPK = false;
    private boolean isMOST = false;
    private boolean isTVInstalled = false;
    private int rvcFeatureFlag = -1;
    private boolean displayManagementReady = false;
    private final IPersistableEarlyData persistableEarlyData = ASLStartupv7rFactory.getStartupv7rApi().getPersistableEarlyData();
    private final boolean[] factorySettingsFlags = new boolean[]{true, true, true, false, true, false, false, false, false, false, false, true, false, false, false};
    private HmiFunctionBlockTblSetter driverDistractionFeatureSets;
    private DashboardDisplayConfigSetter dashboardDisplayConfigSetter;
    private SystemServices services = SystemServicesProvider.getSystemServices();
    private SystemLogger systemLogger;
    static /* synthetic */ Class class$org$dsi$ifc$bluetooth$DSIBluetooth;
    static /* synthetic */ Class class$org$dsi$ifc$radio$DSIDABTuner;
    static /* synthetic */ Class class$org$dsi$ifc$networking$DSIWLAN;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMediaBase;
    static /* synthetic */ Class class$org$dsi$ifc$speechrec$DSISpeechRec;
    static /* synthetic */ Class class$org$dsi$ifc$radio$DSIDABTunerListener;
    static /* synthetic */ Class class$org$dsi$ifc$speechrec$DSISpeechRecListener;
    static /* synthetic */ Class class$org$dsi$ifc$networking$DSIWLANListener;
    static /* synthetic */ Class class$org$dsi$ifc$bluetooth$DSIBluetoothListener;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMediaBaseListener;

    public AslTargetSystemFeaturesAndCoding(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.initializeTarget();
    }

    private void initializeTarget() {
        this.systemLogger = new SystemLogger(this.services.getAsl1Logger(), super.getClass());
        SystemAccessor.setFeaturesAndCodingTarget(this);
        DSIServiceLocator dSIServiceLocator = ServiceManager.dsiServiceLocator;
        dSIServiceLocator.addServiceStateListener(class$org$dsi$ifc$bluetooth$DSIBluetooth == null ? (class$org$dsi$ifc$bluetooth$DSIBluetooth = AslTargetSystemFeaturesAndCoding.class$("org.dsi.ifc.bluetooth.DSIBluetooth")) : class$org$dsi$ifc$bluetooth$DSIBluetooth, this);
        dSIServiceLocator.addServiceStateListener(class$org$dsi$ifc$radio$DSIDABTuner == null ? (class$org$dsi$ifc$radio$DSIDABTuner = AslTargetSystemFeaturesAndCoding.class$("org.dsi.ifc.radio.DSIDABTuner")) : class$org$dsi$ifc$radio$DSIDABTuner, this);
        dSIServiceLocator.addServiceStateListener(class$org$dsi$ifc$networking$DSIWLAN == null ? (class$org$dsi$ifc$networking$DSIWLAN = AslTargetSystemFeaturesAndCoding.class$("org.dsi.ifc.networking.DSIWLAN")) : class$org$dsi$ifc$networking$DSIWLAN, this);
        dSIServiceLocator.addServiceStateListener(class$org$dsi$ifc$media$DSIMediaBase == null ? (class$org$dsi$ifc$media$DSIMediaBase = AslTargetSystemFeaturesAndCoding.class$("org.dsi.ifc.media.DSIMediaBase")) : class$org$dsi$ifc$media$DSIMediaBase, this);
        this.developerTestmodeActivatedSetter = new DeveloperTestmodeActivatedSetter(ServiceManager.aslPropertyManager, ServiceManager.configManagerDiag, this.getTextLogger(), this.getSubClassifier());
        this.driverDistractionFeatureSets = new HmiFunctionBlockTblSetter(ServiceManager.aslPropertyManager, ServiceManager.configManagerDiag, ServiceManager.logger);
        this.dashboardDisplayConfigSetter = new DashboardDisplayConfigSetter(this.services);
    }

    @Override
    public int getSubClassifier() {
        return 2048;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.systemLogger.trace("Received POWER_ON event.");
                this.processPowerOn();
                break;
            }
            case 4300062: {
                this.systemLogger.trace("ASLSystemServiceIds.RELOAD_PERSISTABLES received.");
                this.initDataFromNamespaceEarly();
                break;
            }
            case 1200004: {
                this.systemLogger.info("ASLDiagnosisServiceIds.DIAG_MODE_PERSISTENT_VALUE_CHANGED received.");
                this.requestDiagData(eventGeneric.getInt(2), eventGeneric.getLong(3));
                break;
            }
            case 100033: {
                this.processDiagData(eventGeneric);
                break;
            }
            case 1073744385: {
                this.systemLogger.info("ENTER_DIAG_DATA_VIEW received");
                this.diagFetcher = new AslDiagDataFetcher();
                break;
            }
            case 1073744386: {
                this.systemLogger.info("LEAVE_DIAG_DATA_VIEW received");
                if (this.diagFetcher == null) break;
                this.diagFetcher.close();
                this.diagFetcher = null;
                break;
            }
            case 1073744419: {
                if (!this.writingDiagDataToConsole) {
                    this.writingDiagDataToConsole = true;
                    this.diagFetcher.writeDataToConsole();
                    break;
                }
                this.systemLogger.trace("LOG_DIAG_DATA twice received, ignoring second time");
                break;
            }
            case 100001: {
                this.diagFetcher.writeBlockToConsole();
                break;
            }
            case 4200001: {
                this.triggerSportHMIEvent();
                break;
            }
            case 1800001: {
                this.developerTestmodeActivatedSetter.processStartupIsDone();
                break;
            }
        }
    }

    public void resetWritingDiagDataToConsole() {
        this.writingDiagDataToConsole = false;
    }

    public Coding getCodingData() {
        return this.storedCodingData;
    }

    public Adaptation getAdaptationData() {
        return this.storedAdaptationData;
    }

    public CarFuncAdap getCarFuncAdap() {
        return this.storedCarFuncAdap;
    }

    public LoadSpeedThreshold getLoadSpeedThreshold() {
        return this.storedSpeedThreshold;
    }

    @Override
    public void registered(String string, int n) {
        String string2 = string.intern();
        if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[115]) {
            this.setNotificationForDab();
            ServiceManager.dsiServiceLocator.removeServiceStateListener(class$org$dsi$ifc$radio$DSIDABTuner == null ? (class$org$dsi$ifc$radio$DSIDABTuner = AslTargetSystemFeaturesAndCoding.class$("org.dsi.ifc.radio.DSIDABTuner")) : class$org$dsi$ifc$radio$DSIDABTuner, this);
        } else if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[126]) {
            this.setNotificationForSDS();
            ServiceManager.dsiServiceLocator.removeServiceStateListener(class$org$dsi$ifc$speechrec$DSISpeechRec == null ? (class$org$dsi$ifc$speechrec$DSISpeechRec = AslTargetSystemFeaturesAndCoding.class$("org.dsi.ifc.speechrec.DSISpeechRec")) : class$org$dsi$ifc$speechrec$DSISpeechRec, this);
        } else if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[8]) {
            this.setNotificationForBT();
            ServiceManager.dsiServiceLocator.removeServiceStateListener(class$org$dsi$ifc$bluetooth$DSIBluetooth == null ? (class$org$dsi$ifc$bluetooth$DSIBluetooth = AslTargetSystemFeaturesAndCoding.class$("org.dsi.ifc.bluetooth.DSIBluetooth")) : class$org$dsi$ifc$bluetooth$DSIBluetooth, this);
        } else if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[87]) {
            this.setNotificationForWLAN();
            ServiceManager.dsiServiceLocator.removeServiceStateListener(class$org$dsi$ifc$networking$DSIWLAN == null ? (class$org$dsi$ifc$networking$DSIWLAN = AslTargetSystemFeaturesAndCoding.class$("org.dsi.ifc.networking.DSIWLAN")) : class$org$dsi$ifc$networking$DSIWLAN, this);
        } else if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[63]) {
            this.setNotificationForMediaBase();
            ServiceManager.dsiServiceLocator.removeServiceStateListener(class$org$dsi$ifc$media$DSIMediaBase == null ? (class$org$dsi$ifc$media$DSIMediaBase = AslTargetSystemFeaturesAndCoding.class$("org.dsi.ifc.media.DSIMediaBase")) : class$org$dsi$ifc$media$DSIMediaBase, this);
        }
    }

    @Override
    public void unregistered(String string, int n) {
    }

    public void dsiDABTunerUpdateDetectedDevice(int n, int n2) {
    }

    public void dsiBluetoothUpdateBTState(int n, int n2) {
        if (n2 == 1) {
            this.systemLogger.trace(new Object[]{"dsiBluetoothUpdateBTState ", new Integer(n)});
            this.isBTStateAlreadyReceived = true;
            this.isBTDetectedInSystem = n != 2 && n != 5;
            this.writeExtPhoneFeatureFlag();
            AslTargetSystemFeaturesAndCoding.writeFlagVectorToDatapool(1664, this.factorySettingsFlags);
        }
    }

    public void dsiSpeechRecUpdateSDSAvailability(int n, int n2) {
        if (n2 == 1) {
            AslTargetSystemFeaturesAndCoding.writeBooleanToDatapool(1692, n == 1);
            boolean bl = 2 == n;
            this.systemLogger.trace(new Object[]{"dsiSpeechRecUpdateSDSAvailability ", new Boolean(bl)});
            boolean bl2 = bl && this.isSDSCodedAvailable;
            this.writeSDSFeatureFlag(bl2);
        }
    }

    public void dsiWLANUpdateStartupState(int n, int n2) {
        if (n2 == 1) {
            this.systemLogger.trace(new Object[]{"dsiWLANUpdateStartupState: ", new Integer(n)});
            if (n != 1) {
                this.isWLANDetectedInSystem = n == 2;
                this.isWLANActivationStateAlreadyReceived = true;
                this.writeWLANFeatureFlag();
                AslTargetSystemFeaturesAndCoding.writeFlagVectorToDatapool(1664, this.factorySettingsFlags);
            }
        }
    }

    public void dsiMediaBaseUpdateApplicationVersion(String string, int n) {
        if (n == 1) {
            this.systemLogger.info(new StringBuffer().append("dsiMediaBaseUpdateApplicationVersion: ").append(string).toString());
            AslTargetSystemFeaturesAndCoding.writeStringToDatapool(3586, string);
            AslTargetSystemFeaturesAndCoding.writeBooleanToDatapool(4125, !string.trim().equals(""));
        }
    }

    public void dsiMediaBaseUpdateMetadataDBVersion(String string, int n) {
        if (n == 1) {
            this.systemLogger.info(new StringBuffer().append("dsiMediaBaseUpdateMetadataDBVersion: ").append(string).toString());
            AslTargetSystemFeaturesAndCoding.writeStringToDatapool(3585, string);
        }
    }

    @Override
    public int getDefaultTargetId() {
        return 5609;
    }

    public void setSWaPStatusForApplication(int n, boolean bl) {
        this.systemLogger.trace(new Object[]{"setSWaPStatusForApplication applicationID ", new Integer(n), " status ", new Boolean(bl)});
        if (n == 1) {
            int n2 = bl ? 1 : 3;
            AslTargetSystemFeaturesAndCoding.writeIntegerToDatapool(825368576, n2);
        }
    }

    public void setExternalApps(boolean bl) {
        this.systemLogger.trace(new Object[]{"setExternalApps active = ", new Boolean(bl)});
        AslTargetSystemFeaturesAndCoding.writeBooleanToDatapool(1009917952, bl);
    }

    boolean isUnitMasterDisplayActivated() {
        return this.unitMasterDisplayActivated;
    }

    boolean isClockDisplayActivated() {
        return this.clockDisplayActivated;
    }

    int getSpellerDisclaimerDiagMode() {
        return this.spellerDisclaimerDiagMode;
    }

    boolean isTableAdaptationAlreadyRead() {
        return this.isTableAdaptationAlreadyRead;
    }

    boolean isTableCarFunctionsAdaptationAlreadyRead() {
        return this.isTableCarFunctionsAdaptationAlreadyRead;
    }

    boolean isDabFeatureFlagValue() {
        return this.dabFeatureFlagValue;
    }

    boolean isDiagSpeedThresholdsRead() {
        return this.diagSpeedThresholdsRead;
    }

    void pingByWlan() {
        this.systemLogger.trace("pingByWlan");
        this.isWLANTargetReady = true;
        this.sendWLANAvailabilityToTarget();
    }

    void pingByDisplayManagement() {
        this.systemLogger.trace("pingByDisplayManagement");
        this.displayManagementReady = true;
        if (this.rvcFeatureFlag != -1) {
            this.sendRVCStateToDisplayManagement();
        }
        this.updateAMIState();
    }

    private void triggerSportHMIEvent() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setBoolean(0, this.persistableEarlyData.getSportHMIEnabled());
        this.triggerObserver(1108754432, eventGeneric);
    }

    private void requestDiagData(int n, long l) {
        int n2 = this.getTargetId();
        block0 : switch (n) {
            case -1: {
                ServiceManager.adaptionApi.requestConfigManagerPersCoding(n2, -1048182528);
                ServiceManager.adaptionApi.requestConfigManagerPersLoadSpeedThreshold(n2, -1048182528);
                ServiceManager.adaptionApi.requestConfigManagerPersCarFuncListBap(n2, -1048182528);
                ServiceManager.adaptionApi.requestConfigManagerPersCarFuncAdap(n2, -1048182528);
                ServiceManager.adaptionApi.requestConfigManagerPersIdentification(n2, -1048182528);
                ServiceManager.adaptionApi.requestConfigManagerPersAdaptation(n2, -1048182528);
                ServiceManager.adaptionApi.requestConfigManagerHmiFuncBlockTbl(n2, -1048182528);
                ServiceManager.adaptionApi.requestConfigManagerPersLoadInCarCommunication(n2, -1048182528);
                ServiceManager.adaptionApi.requestConfigManagerPersLoadDashboardDisplayConfig(n2, -1048182528);
                break;
            }
            case 28180695: {
                if (l != 1L) break;
                ServiceManager.adaptionApi.requestConfigManagerPersCoding(n2, -1048182528);
                break;
            }
            case 28442848: {
                switch ((int)l) {
                    case 100: {
                        ServiceManager.adaptionApi.requestConfigManagerPersAdaptation(n2, -1048182528);
                        break block0;
                    }
                    case 101: {
                        ServiceManager.adaptionApi.requestConfigManagerPersCarFuncAdap(n2, -1048182528);
                        break block0;
                    }
                    case 103: {
                        ServiceManager.adaptionApi.requestConfigManagerPersCarFuncListBap(n2, -1048182528);
                        break block0;
                    }
                    case 105: {
                        ServiceManager.adaptionApi.requestConfigManagerHmiFuncBlockTbl(n2, -1048182528);
                        break block0;
                    }
                    case 106: {
                        ServiceManager.adaptionApi.requestConfigManagerPersLoadDashboardDisplayConfig(n2, -1048182528);
                        break block0;
                    }
                }
                break;
            }
            case 52166966: {
                if (l == 0) {
                    ServiceManager.adaptionApi.requestConfigManagerPersLoadSpeedThreshold(n2, -1048182528);
                    break;
                }
                if (l != 0) break;
                ServiceManager.adaptionApi.requestConfigManagerPersLoadInCarCommunication(n2, -1048182528);
                break;
            }
            case 46924065: {
                if (l != 0) break;
                ServiceManager.adaptionApi.requestConfigManagerPersIdentification(n2, -1048182528);
                break;
            }
        }
    }

    private void initDataFromNamespaceEarly() {
        this.writeSDSFeatureFlag(this.persistableEarlyData.isSDSActive());
    }

    private void processPowerOn() {
        this.writeTestFeatureFlags();
        this.updateIntPhoneAvailability(this.services.getConfigManagerDiag());
        if (!this.services.getAslStartupv7rAPI().isNonCustomerSwdlIsInProgress()) {
            this.systemLogger.trace("processPowerOn");
            this.initDataFromNamespaceEarly();
            this.requestDiagData(-1, -1L);
            AslPersistenceSyncApi aslPersistenceSyncApi = this.services.getPersistence();
            aslPersistenceSyncApi.registerSharedPersistable(this.persistableEngineType);
            boolean bl = aslPersistenceSyncApi.loadPersistable(5000, 0, this.persistableEngineType);
            if (!bl) {
                this.systemLogger.info("No initial coding received (south side), using default");
            }
            this.addObserver(1098324736);
            this.writeNetworkingModuleStatus();
        } else {
            EventGeneric eventGeneric = this.services.getEventFactory().newEvent();
            eventGeneric.setBoolean(0, false);
            this.triggerObserver(782057728, eventGeneric);
        }
        this.installPersistedSpeechFeatureFlags();
        new AbtFeatureFlagSetter(this.services).update();
    }

    private void installPersistedSpeechFeatureFlags() {
        SystemEarlyPersistenceServiceImpl systemEarlyPersistenceServiceImpl = SystemEarlyPersistenceServiceImpl.getInstance();
        SystemEarly systemEarly = systemEarlyPersistenceServiceImpl.loadSystemEarly();
        SpeechFeatureFlagSetter speechFeatureFlagSetter = new SpeechFeatureFlagSetter(systemEarly, ServiceManager.configManagerDiag, ServiceManager.aslPropertyManager);
        speechFeatureFlagSetter.installPersistedValues();
    }

    private void processDiagData(EventGeneric eventGeneric) {
        this.systemLogger.trace("processDiagData (enter)");
        int n = eventGeneric.getInt(2);
        long l = eventGeneric.getLong(3);
        boolean bl = false;
        block0 : switch (n) {
            case 28442848: {
                switch ((int)l) {
                    case 100: {
                        Adaptation adaptation = (Adaptation)eventGeneric.getObject(1);
                        this.processDiagAdaptation(adaptation);
                        break block0;
                    }
                    case 101: {
                        CarFuncAdap carFuncAdap = (CarFuncAdap)eventGeneric.getObject(1);
                        this.processDiagCarFunctionsAdaptations(carFuncAdap);
                        break block0;
                    }
                    case 103: {
                        CarFuncListBap carFuncListBap = (CarFuncListBap)eventGeneric.getObject(1);
                        this.processDiagCarFunctionsBapList(carFuncListBap);
                        break block0;
                    }
                    case 105: {
                        HmiFunctionBlockTbl hmiFunctionBlockTbl = (HmiFunctionBlockTbl)eventGeneric.getObject(1);
                        this.processDiagHmiFunctionBlockTbl(hmiFunctionBlockTbl);
                        break block0;
                    }
                    case 106: {
                        DashboardDisplayConfig dashboardDisplayConfig = (DashboardDisplayConfig)eventGeneric.getObject(1);
                        this.processDiagDashboardDisplayConfig(dashboardDisplayConfig);
                        break block0;
                    }
                }
                break;
            }
            case 28180695: {
                if (l != 1L) break;
                bl = true;
                Coding coding = (Coding)eventGeneric.getObject(1);
                this.processDiagCoding(coding);
                break;
            }
            case 52166966: {
                switch ((int)l) {
                    case 200: {
                        LoadSpeedThreshold loadSpeedThreshold = (LoadSpeedThreshold)eventGeneric.getObject(1);
                        this.processDiagSpeedThresholds(loadSpeedThreshold);
                        break block0;
                    }
                    case 209: {
                        InCarCommunication inCarCommunication = (InCarCommunication)eventGeneric.getObject(1);
                        this.processInCarCommunication(inCarCommunication);
                        break block0;
                    }
                }
                break;
            }
            case 46924065: {
                if (l != 0) break;
                bl = true;
                Identification identification = (Identification)eventGeneric.getObject(1);
                this.processDiagIdentification(identification);
                break;
            }
        }
        if (!bl) {
            this.systemLogger.trace(new Object[]{"Unrequested Diag Data received (namespace/key): (", new Integer(n), "/", new Long(l), ")"});
        }
        this.systemLogger.trace("processDiagData (exit)");
    }

    private void processSummertimeShiftMethod(Adaptation adaptation) {
        int n = adaptation.getValue(123);
        boolean bl = false;
        boolean bl2 = false;
        this.systemLogger.trace("processSummertimeShiftMethod");
        if (n == 0) {
            this.systemLogger.trace("None");
        } else if (n == 1) {
            this.systemLogger.trace("Manual");
            bl = true;
        } else if (n == 2) {
            this.systemLogger.trace("CET");
            bl2 = true;
        } else if (n == 3) {
            this.systemLogger.trace("USA");
            bl2 = true;
        }
        AslTargetSystemFeaturesAndCoding.writeBooleanToDatapool(1696, bl);
        AslTargetSystemFeaturesAndCoding.writeBooleanToDatapool(1649, bl2);
        AslTargetSystemDate aslTargetSystemDate = SystemAccessor.getDateTarget();
        if (bl2) {
            boolean bl3 = this.persistableEarlyData.isAutoDaylightSaving();
            aslTargetSystemDate.setClockDayLightSaving(bl3);
            AslTargetSystemFeaturesAndCoding.writeBooleanToDatapool(1648, bl3);
        }
        aslTargetSystemDate.setManualDSTAvailable(bl);
        aslTargetSystemDate.setAutoDSTAvailable(bl2);
        aslTargetSystemDate.updateDaylightSavingAvailability();
    }

    private void processDiagAdaptation(Adaptation adaptation) {
        if (adaptation != null) {
            this.isTableAdaptationAlreadyRead = true;
            this.developerTestmodeActivatedSetter.processDiagAdaptationData(adaptation);
            this.processSummertimeShiftMethod(adaptation);
            this.isWLANAdaptationModuleActivated = adaptation.contains(129) ? adaptation.getValue(129) == 1 : false;
            this.writeWLANFeatureFlag();
            this.isInternalPhoneAdaptationModuleActivated = adaptation.contains(166) ? adaptation.getValue(166) == 1 : false;
            this.systemLogger.trace(new Object[]{"isTelephoneActivated ", new Boolean(this.isInternalPhoneAdaptationModuleActivated)});
            this.isBTAdaptationModuleActivated = adaptation.contains(116) ? adaptation.getValue(116) == 1 : false;
            this.systemLogger.trace(new Object[]{"isBTAdaptationModuleActivated ", new Boolean(this.isBTAdaptationModuleActivated)});
            this.writeExtPhoneFeatureFlag();
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
            eventGeneric.setBoolean(0, this.getDiagnosisValue(adaptation, 127));
            this.triggerObserver(-509853440, eventGeneric);
            boolean bl = this.getDiagnosisValue(adaptation, 139);
            AslTargetSystemFeaturesAndCoding.writeBooleanToDatapool(546379776, bl);
            ServiceManager.configManagerDiag.setFeatureFlagValue("ASL.Configuration.isPictureNavigationAvailable", bl);
            this.evaluateAdaptationPhoneData(adaptation);
            this.writeOnlineFeatureFlags(adaptation);
            this.evaluateCountrycodeHMI(adaptation);
            this.evaluateSollverbauListe(adaptation);
            AslTargetSystemFeaturesAndCoding.writeFlagVectorToDatapool(1664, this.factorySettingsFlags);
            new AdaptationSetter(SystemHasBridgeImpl.getInstance(), this.services.getPropertyManager(), this.services.getConfigManagerDiag()).update(adaptation);
            this.updateAppConnectAvailability();
            this.storedAdaptationData = adaptation;
        } else {
            this.systemLogger.error("processDiagAdaptation adaptation data could not be read");
        }
    }

    private void updateAppConnectAvailability() {
        boolean bl;
        this.factorySettingsFlags[14] = bl = this.services.getConfigManagerDiag().isFeatureFlagSet(451);
        AslTargetSystemFeaturesAndCoding.writeFlagVectorToDatapool(1664, this.factorySettingsFlags);
    }

    private void evaluateSollverbauListe(Adaptation adaptation) {
        this.isTVInstalled = this.getDiagnosisValue(adaptation, 850);
        this.writeTVFeatureFlag();
    }

    private void writeTVFeatureFlag() {
        if (this.isTableAdaptationAlreadyRead && this.isTableCodingAlreadyRead) {
            boolean bl = this.isTVInstalled && this.isMOST;
            AslTargetSystemFeaturesAndCoding.writeBooleanToDatapool(529602560, bl);
            ServiceManager.configManagerDiag.setFeatureFlagValue("ASL.Configuration.isTVTuner", bl);
            this.factorySettingsFlags[12] = bl;
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
            eventGeneric.setBoolean(0, bl);
            this.triggerObserver(882721024, eventGeneric);
        }
    }

    private void evaluateAdaptationPhoneData(Adaptation adaptation) {
        boolean bl = this.getDiagnosisValue(adaptation, 151);
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setBoolean(0, this.getDiagnosisValue(adaptation, 152));
        eventGeneric.setBoolean(1, this.getDiagnosisValue(adaptation, 153));
        eventGeneric.setBoolean(2, bl);
        eventGeneric.setBoolean(3, this.getDiagnosisValue(adaptation, 154));
        this.triggerObserver(765280512, eventGeneric);
        AslTargetSystemFeaturesAndCoding.writeBooleanToDatapool(512825344, bl);
        ServiceManager.configManagerDiag.setFeatureFlagValue("ASL.Configuration.isThreeWayCallingSupported", bl);
    }

    private void evaluateCountrycodeHMI(Adaptation adaptation) {
        byte[] byArray = adaptation.getByteArray(165);
        String string = new String(byArray);
        this.systemLogger.trace(new Object[]{"Read country code from adaptation: ", string});
        ServiceManager.configManagerDiag.setMediaCountryCodeHmi(string);
        boolean bl = "JP".equals(string) || "KR".equals(string);
        boolean bl2 = !bl;
        AslTargetSystemFeaturesAndCoding.writeBooleanToDatapool(445716480, bl);
        ServiceManager.configManagerDiag.setFeatureFlagValue("ASL.Configuration.isSellCountryJPorKR", bl);
        AslTargetSystemFeaturesAndCoding.writeBooleanToDatapool(462493696, bl2);
        ServiceManager.configManagerDiag.setFeatureFlagValue("ASL.Configuration.isNotSellCountryJPorKR", bl2);
    }

    private void writeOnlineFeatureFlags(Adaptation adaptation) {
        String string;
        boolean bl = adaptation.getValue(157) == 1;
        this.systemLogger.info(new StringBuffer().append("writeOnlineFeatureFlags isOnlineServicesHmiAvailability from adaptation: ").append(bl).toString());
        boolean bl2 = this.persistableEarlyData.getNavOverwriteEnableOnlineFunctions();
        if (bl2) {
            this.systemLogger.info("writeOnlineFeatureFlags: navOverwriteEnableOnlineFeatures has been set in GEM, ignore diag data, set all online services to true!");
        }
        boolean bl3 = (string = System.getProperty("de.vw.mib.onlineAvailability")) != null ? (string.equals("true") ? true : (string.equals("false") ? false : bl)) : bl;
        AslTargetSystemFeaturesAndCoding.writeBooleanToDatapool(395384832, bl3 |= bl2);
        ServiceManager.configManagerDiag.setFeatureFlagValue("ASL.Configuration.isOnlineService", bl3);
        ASLStartupv7rFactory.getStartupv7rApi().setOnlineServiceCodingStateForStartup(bl3);
        this.factorySettingsFlags[13] = bl3;
    }

    private void processDiagCarFunctionsAdaptations(CarFuncAdap carFuncAdap) {
        this.systemLogger.trace("processDiagCarFunctionsAdaptations");
        if (carFuncAdap != null) {
            this.isTableCarFunctionsAdaptationAlreadyRead = true;
            boolean bl = ServiceManager.configManagerDiag.isFeatureFlagSet(402);
            boolean bl2 = ServiceManager.configManagerDiag.isFeatureFlagSet(401);
            this.clockDisplayActivated = carFuncAdap.getBoolean(290) && bl2;
            this.unitMasterDisplayActivated = carFuncAdap.getBoolean(305) && bl;
            SystemAccessor.getUnitsTarget().updateUnitsMenuAvailability();
            SystemAccessor.getDateTarget().updateDaylightSavingAvailability();
            SystemAccessor.getDateTarget().updateClockMenuAvailability();
            this.systemLogger.trace(new Object[]{"clockDisplayActivated", new Boolean(this.clockDisplayActivated)});
            this.systemLogger.trace(new Object[]{"centralUnitMasterActivated", new Boolean(this.unitMasterDisplayActivated)});
            boolean bl3 = carFuncAdap.getBoolean(310);
            AslTargetSystemFeaturesAndCoding.writeBooleanToDatapool(496048128, bl3);
            ServiceManager.configManagerDiag.setFeatureFlagValue("ASL.Configuration.isHybridCar", bl3);
            ServiceManager.configManagerDiag.setFeatureFlagValue("ASL.Configuration.isAdaptionHybrid", bl3);
            CarFuncAdapSetter carFuncAdapSetter = new CarFuncAdapSetter(ServiceManager.aslPropertyManager, ServiceManager.configManagerDiag);
            carFuncAdapSetter.update(carFuncAdap);
            this.storedCarFuncAdap = carFuncAdap;
        } else {
            this.systemLogger.error("CarFuncAdap Data could not be read");
        }
    }

    private void processDiagDashboardDisplayConfig(DashboardDisplayConfig dashboardDisplayConfig) {
        this.systemLogger.trace("processDiagDashboardDisplayConfig");
        this.dashboardDisplayConfigSetter.update(dashboardDisplayConfig);
    }

    private void processDiagHmiFunctionBlockTbl(HmiFunctionBlockTbl hmiFunctionBlockTbl) {
        this.systemLogger.trace("processDiagHmiFunctionBlockTbl");
        this.driverDistractionFeatureSets.update(hmiFunctionBlockTbl);
        DdpFunctionBlockingListenerInstaller ddpFunctionBlockingListenerInstaller = new DdpFunctionBlockingListenerInstaller(this.services.getAsl1Logger(), this.services.getConfigManagerDiag(), this.services.getPropertyManager(), ASLSystemFactory.getSystemApi().getDriverDistractionPreventionService());
        ddpFunctionBlockingListenerInstaller.install((Access)hmiFunctionBlockTbl, FunctionBlockingInfoProvider.provide());
    }

    private void processInCarCommunication(InCarCommunication inCarCommunication) {
        this.systemLogger.trace("processInCarCommunication");
        if (inCarCommunication != null) {
            byte[] byArray = inCarCommunication.getRawData();
            if (byArray.length != 0) {
                this.writeIccFeatureFlag(inCarCommunication);
            } else {
                this.systemLogger.trace("processInCarCommunication South side returns no data");
            }
        } else {
            this.systemLogger.error("processInCarCommunication Data could not be read");
        }
    }

    private void writeIccFeatureFlag(InCarCommunication inCarCommunication) {
        byte[] byArray = inCarCommunication.getByteArray(1149);
        boolean bl = Util.isBitSet(1, (int)byArray[0]);
        AslTargetSystemFeaturesAndCoding.writeBooleanToDatapool(747706368, bl);
        ServiceManager.configManagerDiag.setFeatureFlagValue("ASL.Configuration.isSoundICC", bl);
    }

    private void processDiagCarFunctionsBapList(CarFuncListBap carFuncListBap) {
        this.systemLogger.trace("processDiagCarFunctionsBapList");
        if (carFuncListBap != null) {
            boolean bl;
            ServiceManager.logger.info(16384).append("DIAGNOSTIC ").append("Car Functions BAP List:").log();
            if (carFuncListBap.getValue(518) == 1) {
                ServiceManager.logger.info(16384).append("Clock is true").log();
            } else {
                ServiceManager.logger.info(16384).append("Clock is false, Time/Date menue not available!").log();
            }
            if (carFuncListBap.getValue(522) == 1) {
                ServiceManager.logger.info(16384).append("Unitmaster is true").log();
            } else {
                ServiceManager.logger.info(16384).append("Unitmaster is false, Units menue not available!").log();
            }
            boolean bl2 = bl = carFuncListBap.getValue(506) == 1;
            if (this.rvcFeatureFlag == -1) {
                this.rvcFeatureFlag = bl ? 2 : 0;
            } else {
                this.rvcFeatureFlag = bl ? (this.rvcFeatureFlag |= 2) : (this.rvcFeatureFlag &= 0xFFFFFFFD);
                this.updateRVCState();
            }
            CarFuncListBapSetter carFuncListBapSetter = new CarFuncListBapSetter(ServiceManager.aslPropertyManager, ServiceManager.configManagerDiag);
            carFuncListBapSetter.update(carFuncListBap);
        } else {
            this.systemLogger.error("CarFuncListBap Data could not be read");
        }
    }

    private void processDiagCoding(Coding coding) {
        this.systemLogger.trace("processDiagCoding");
        if (coding != null) {
            String string;
            this.isTableCodingAlreadyRead = true;
            this.writeBrands(coding);
            this.writeDisclaimerData(coding);
            boolean bl = this.getDiagnosisValue(coding, 38);
            boolean bl2 = this.getDiagnosisValue(coding, 39);
            boolean bl3 = this.isSDSCodedAvailable = this.getDiagnosisValue(coding, 104) && (bl || bl2);
            if (this.isSDSCodedAvailable) {
                string = "is active";
                if (!this.sdsServiceListener) {
                    ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$speechrec$DSISpeechRec == null ? (class$org$dsi$ifc$speechrec$DSISpeechRec = AslTargetSystemFeaturesAndCoding.class$("org.dsi.ifc.speechrec.DSISpeechRec")) : class$org$dsi$ifc$speechrec$DSISpeechRec, this);
                    this.sdsServiceListener = true;
                }
            } else {
                string = "is not active";
                this.writeSDSFeatureFlag(false);
            }
            ServiceManager.logger.info(16384).append("DIAGNOSTIC ").append("SDS ").append(string).log();
            boolean bl4 = this.getDiagnosisValue(coding, 82);
            if (this.rvcFeatureFlag == -1) {
                this.rvcFeatureFlag = bl4 ? 1 : 0;
            } else {
                this.rvcFeatureFlag = bl4 ? (this.rvcFeatureFlag |= 1) : (this.rvcFeatureFlag &= 0xFFFFFFFE);
                this.updateRVCState();
            }
            boolean bl5 = coding.contains(47) ? coding.getValue(47) != 0 : false;
            boolean bl6 = coding.contains(48) ? coding.getValue(48) != 0 : false;
            boolean bl7 = bl5 || bl6;
            this.writeDABFeatureFlag(bl7);
            boolean bl8 = this.getDiagnosisValue(coding, 71);
            boolean bl9 = this.getDiagnosisValue(coding, 73);
            this.isBTCodedAvailable = bl8 && bl9;
            boolean bl10 = this.getDiagnosisValue(coding, 74);
            boolean bl11 = this.getDiagnosisValue(coding, 72);
            this.systemLogger.trace(new Object[]{"isBluetoothAvailable: ", new Boolean(bl8)});
            this.systemLogger.trace(new Object[]{"isBluetoothPhoneAvailable: ", new Boolean(bl9)});
            this.systemLogger.trace(new Object[]{"isBluetoothMultimediaFuncAvailable: ", new Boolean(bl11)});
            AslTargetSystemFeaturesAndCoding.writeBooleanToDatapool(1201, bl10 && bl11);
            this.writeExtPhoneFeatureFlag();
            this.isNADCodedAvailable = this.getDiagnosisValue(coding, 69);
            this.systemLogger.trace(new Object[]{"isPhoneNadOn: ", new Boolean(this.isNADCodedAvailable)});
            this.systemLogger.trace(new Object[]{"isMicrophoneConnected(1): ", new Boolean(bl)});
            this.systemLogger.trace(new Object[]{"isMicrophoneConnected(2): ", new Boolean(bl2)});
            boolean bl12 = this.getDiagnosisValue(coding, 105);
            AslTargetSystemFeaturesAndCoding.writeBooleanToDatapool(1654, bl12);
            ServiceManager.configManagerDiag.setFeatureFlagValue("ASL.System.IsNavigationContextAvailableDIAG", bl12);
            if (bl12) {
                ServiceManager.logger.info(16384).append("DIAGNOSTIC ").append("Navigation is active").log();
            } else {
                ServiceManager.logger.info(16384).append("DIAGNOSTIC ").append("Navigation is not active").log();
            }
            this.isWLANCodedActive = this.getDiagnosisValue(coding, 106);
            this.writeWLANFeatureFlag();
            this.isAMICodedActive = this.getDiagnosisValue(coding, 43);
            this.updateAMIState();
            int n = coding.getValue(97);
            this.isFPK = n == 0;
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
            eventGeneric.setBoolean(0, this.isFPK);
            this.triggerObserver(782057728, eventGeneric);
            this.isMOST = this.getDiagnosisValue(coding, 83);
            this.writeTVFeatureFlag();
            AslTargetSystemFeaturesAndCoding.writeFlagVectorToDatapool(1664, this.factorySettingsFlags);
            this.storedCodingData = coding;
            CodingSetter codingSetter = new CodingSetter(this.services.getPropertyManager(), this.services.getConfigManagerDiag(), this.getTextLogger());
            codingSetter.update(coding);
        } else {
            this.systemLogger.error("processDiagCoding Coding Data could not be read");
        }
    }

    private void processDiagIdentification(Identification identification) {
        String string;
        String string2;
        String string3;
        String string4;
        this.systemLogger.trace("processDiagIdentification");
        String string5 = "DIAG INVALID";
        if (identification != null) {
            string4 = new String(identification.getByteArray(839)).trim();
            string3 = new String(identification.getByteArray(840));
            string2 = new String(identification.getByteArray(841)).trim();
            string = new String(identification.getByteArray(842));
        } else {
            this.systemLogger.error("Identification could not be read");
            string4 = "DIAG INVALID";
            string3 = "DIAG INVALID";
            string2 = "DIAG INVALID";
            string = "DIAG INVALID";
        }
        AslTargetSystemFeaturesAndCoding.writeStringToDatapool(1597, string2);
        AslTargetSystemFeaturesAndCoding.writeStringToDatapool(1603, string4);
        AslTargetSystemFeaturesAndCoding.writeStringToDatapool(1606, string);
        AslTargetSystemFeaturesAndCoding.writeStringToDatapool(1613, "N/A");
        AslTargetSystemFeaturesAndCoding.writeStringToDatapool(391, string4);
        AslTargetSystemFeaturesAndCoding.writeStringToDatapool(392, string3);
        ServiceManager.configManagerDiag.setPartNumber(string4);
        ServiceManager.configManagerDiag.setSoftwareMuPartNumber(string2);
    }

    private void processDiagSpeedThresholds(LoadSpeedThreshold loadSpeedThreshold) {
        this.systemLogger.trace("processDiagSpeedThresholds");
        if (loadSpeedThreshold != null) {
            int n = loadSpeedThreshold.getValue(600);
            this.systemLogger.trace(new Object[]{"speedLimitActivateSpellerDisclaimer: ", new Integer(n)});
            if (n == 255) {
                this.spellerDisclaimerDiagMode = 2;
                this.speedThresholdSpellerDeactivatedInTableUpDownLoad = true;
            }
            this.speedLimitSlideshowActive = loadSpeedThreshold.getValue(590);
            this.systemLogger.trace(new Object[]{"speedLimitSlideshowActive: ", new Integer(this.speedLimitSlideshowActive)});
            this.dabSlsDuration1 = loadSpeedThreshold.getValue(592);
            this.dabSlsDuration2 = loadSpeedThreshold.getValue(593);
            this.radiotextDuration = loadSpeedThreshold.getValue(608);
            this.systemLogger.trace(new Object[]{"dabSlsDuration1: ", new Integer(this.dabSlsDuration1)});
            this.systemLogger.trace(new Object[]{"dabSlsDuration2: ", new Integer(this.dabSlsDuration2)});
            this.systemLogger.trace(new Object[]{"radiotextDuration: ", new Integer(this.radiotextDuration)});
            this.diagSpeedThresholdsRead = true;
            this.sendDabSlsData();
            this.sendRadiotextData();
            int n2 = loadSpeedThreshold.getValue(598);
            boolean bl = n2 == 254;
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
            eventGeneric.setBoolean(0, bl);
            this.triggerObserver(933052672, eventGeneric);
            this.storedSpeedThreshold = loadSpeedThreshold;
        } else {
            this.systemLogger.error("UpDownLoad Data / Speed Thresholds could not be read");
        }
    }

    private void sendRadiotextData() {
        if (this.diagSpeedThresholdsRead) {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
            eventGeneric.setInt(0, this.radiotextDuration);
            this.triggerObserver(731726080, eventGeneric);
            this.systemLogger.trace(" sendRadiotextData, trigger Service ASLSystemServiceIds.RADIO_FM_RADIOTEXT_DATA");
        }
    }

    private void writeWLANFeatureFlag() {
        if (this.isTableCodingAlreadyRead && this.isTableAdaptationAlreadyRead) {
            boolean bl = this.isWLANCodedActive && this.isWLANAdaptationModuleActivated;
            AslTargetSystemFeaturesAndCoding.writeBooleanToDatapool(563156992, bl);
            ServiceManager.configManagerDiag.setFeatureFlagValue("ASL.Configuration.isWLANAvailable", bl);
            if (this.isWLANActivationStateAlreadyReceived) {
                boolean bl2 = this.isWLANDetectedInSystem && bl;
                AslTargetSystemFeaturesAndCoding.writeBooleanToDatapool(1671, bl2);
                this.factorySettingsFlags[9] = bl2;
                if (this.isWLANTargetReady) {
                    this.sendWLANAvailabilityToTarget();
                }
            }
            if (this.isWLANDetectedInSystem) {
                if (bl) {
                    ServiceManager.logger.info(16384).append("DIAGNOSTIC ").append("WLAN ").append("is available (and detected via DSI)").log();
                } else {
                    ServiceManager.logger.info(16384).append("DIAGNOSTIC ").append("WLAN ").append("is detected via DSI but not coded!").log();
                }
            } else if (this.isWLANActivationStateAlreadyReceived) {
                if (bl) {
                    ServiceManager.logger.error(16384).append("DIAGNOSTIC ").append("WLAN ").append("is coded but not detected via DSI!").log();
                } else {
                    ServiceManager.logger.info(16384).append("DIAGNOSTIC ").append("WLAN ").append("is not available").log();
                }
            } else if (bl) {
                ServiceManager.logger.info(16384).append("DIAGNOSTIC ").append("WLAN ").append("is coded and not yet detected via DSI").log();
            }
        }
    }

    private void writeNetworkingModuleStatus() {
        AslTargetSystemFeaturesAndCoding.writeBooleanToDatapool(1672, true);
        this.factorySettingsFlags[10] = true;
    }

    private void sendWLANAvailabilityToTarget() {
        boolean bl = this.isWLANCodedActive && this.isWLANAdaptationModuleActivated;
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getTargetId(), 7800, 295518464);
        eventGeneric.setBoolean(0, bl);
        try {
            this.send(eventGeneric);
        }
        catch (GenericEventException genericEventException) {
            this.error(genericEventException);
        }
    }

    private void writeDisclaimerData(Coding coding) {
        boolean bl = this.getDiagnosisValue(coding, 100);
        boolean bl2 = this.getDiagnosisValue(coding, 102);
        if (bl) {
            if (!this.speedThresholdSpellerDeactivatedInTableUpDownLoad) {
                this.spellerDisclaimerDiagMode = bl2 ? 0 : 1;
            }
        } else {
            this.spellerDisclaimerDiagMode = 2;
        }
        this.systemLogger.trace(new Object[]{"isSpellerOn: ", new Boolean(bl)});
        this.systemLogger.trace(new Object[]{"isLegalDisclaimerOn: ", new Boolean(bl2)});
        this.systemLogger.trace(new Object[]{"spellerDisclaimerDiagMode: ", new Integer(this.spellerDisclaimerDiagMode)});
        if (this.getDiagnosisValue(coding, 101)) {
            AslTargetSystemFeaturesAndCoding.writeIntegerToDatapool(1610, 1);
            this.systemLogger.trace("writeDisclaimerData Initial Disclaimer Active!");
        } else {
            AslTargetSystemFeaturesAndCoding.writeIntegerToDatapool(1610, 0);
            this.systemLogger.trace("writeDisclaimerData Initial Disclaimer Inactive!");
        }
    }

    private void writeBrands(Coding coding) {
        String string;
        int n;
        int n2 = coding.getValue(0);
        int n3 = coding.getValue(78);
        boolean bl = n2 == 2 || n2 == 6;
        boolean bl2 = n2 == 4;
        boolean bl3 = n2 == 3;
        StringBuffer stringBuffer = new StringBuffer(10);
        stringBuffer.append("0");
        stringBuffer.append(Integer.toHexString(n2));
        stringBuffer.append("0");
        stringBuffer.append(Integer.toHexString(coding.getValue(1)));
        stringBuffer.append("0");
        stringBuffer.append(Integer.toHexString(coding.getValue(2)));
        stringBuffer.append("0");
        stringBuffer.append(Integer.toHexString(coding.getValue(3)));
        stringBuffer.append(n3 < 12 ? (n3 == 11 ? "0" : Integer.toHexString(n3)) : "0");
        stringBuffer.append(Integer.toHexString(coding.getValue(4)));
        String string2 = stringBuffer.toString();
        ServiceManager.configManagerDiag.setEncodedVehicleType(string2);
        SystemHasBridgeImpl.getInstance().setPropertyEncodedVehicleType(string2);
        if (bl) {
            switch (n3) {
                case 3: {
                    n = 1;
                    break;
                }
                case 6: 
                case 7: {
                    n = 2;
                    break;
                }
                default: {
                    n = 0;
                    break;
                }
            }
        } else {
            n = 0;
        }
        AslTargetSystemFeaturesAndCoding.writeIntegerToDatapool(3698, n);
        if (bl) {
            string = "brand is true";
            SystemHasBridgeImpl.getInstance().setPropertyOriginalEquipmentManufacturer(2);
        } else {
            string = "brand is false";
        }
        ServiceManager.logger.info(16384).append("DIAGNOSTIC ").append("VW ").append(string).log();
        if (bl2) {
            string = "brand is true";
            SystemHasBridgeImpl.getInstance().setPropertyOriginalEquipmentManufacturer(4);
        } else {
            string = "brand is false";
        }
        ServiceManager.logger.info(16384).append("DIAGNOSTIC ").append("Seat ").append(string).log();
        if (bl3) {
            string = "brand is true";
            SystemHasBridgeImpl.getInstance().setPropertyOriginalEquipmentManufacturer(3);
        } else {
            string = "brand is false";
        }
        ServiceManager.logger.info(16384).append("DIAGNOSTIC ").append("Skoda ").append(string).log();
        AslTargetSystemFeaturesAndCoding.writeBooleanToDatapool(346, bl);
        ServiceManager.configManagerDiag.setFeatureFlagValue("ASL.Configuration.isVW", bl);
        AslTargetSystemFeaturesAndCoding.writeBooleanToDatapool(344, bl2);
        ServiceManager.configManagerDiag.setFeatureFlagValue("ASL.Configuration.isSEAT", bl2);
        AslTargetSystemFeaturesAndCoding.writeBooleanToDatapool(579934208, !bl2);
        ServiceManager.configManagerDiag.setFeatureFlagValue("ASL.Configuration.isNotSEAT", !bl2);
        AslTargetSystemFeaturesAndCoding.writeBooleanToDatapool(345, bl3);
        ServiceManager.configManagerDiag.setFeatureFlagValue("ASL.Configuration.isSkoda", bl3);
        AslTargetSystemFeaturesAndCoding.writeBooleanToDatapool(630265856, !bl3);
        ServiceManager.configManagerDiag.setFeatureFlagValue("ASL.Configuration.isNotSkoda", !bl3);
        if (bl) {
            ASLLscFactory.getLscApi().setCodedCarBrand(2);
        } else if (bl2) {
            ASLLscFactory.getLscApi().setCodedCarBrand(4);
        } else {
            ASLLscFactory.getLscApi().setCodedCarBrand(3);
        }
        this.triggerObserver(949829888, null);
    }

    private void writeTestFeatureFlags() {
        AslTargetSystemFeaturesAndCoding.writeBooleanToDatapool(596711424, true);
        AslTargetSystemFeaturesAndCoding.writeBooleanToDatapool(613488640, false);
        ServiceManager.configManagerDiag.setFeatureFlagValue("ASL.Configuration.isTestTrue", true);
        ServiceManager.configManagerDiag.setFeatureFlagValue("ASL.Configuration.isTestFalse", false);
    }

    private void writeExtPhoneFeatureFlag() {
        if (this.isTableCodingAlreadyRead && this.isTableAdaptationAlreadyRead) {
            boolean bl;
            boolean bl2;
            boolean bl3 = false;
            boolean bl4 = false;
            boolean bl5 = bl2 = this.isBTCodedAvailable && this.isBTAdaptationModuleActivated;
            if (this.isBTStateAlreadyReceived) {
                bl = this.isBTDetectedInSystem && bl2;
            } else {
                bl = bl2;
                bl4 = true;
            }
            if (!this.isExtPhoneFeatureFlagAlreadySet) {
                if (!bl4) {
                    this.isExtPhoneFeatureFlagAlreadySet = true;
                }
                bl3 = true;
            } else if (this.extPhoneFeatureFlagValue != bl) {
                bl3 = true;
            }
            if (this.isBTDetectedInSystem) {
                if (bl2) {
                    this.diagnosticTrace("BT PHONE ", "is available (and detected via DSI)");
                } else {
                    this.diagnosticTrace("BT PHONE ", "is detected via DSI but not coded!");
                }
            } else if (this.isBTStateAlreadyReceived) {
                if (bl2) {
                    ServiceManager.logger.error(16384).append("DIAGNOSTIC ").append("BT PHONE ").append("is coded but not detected via DSI!").log();
                } else {
                    this.diagnosticTrace("BT PHONE ", "is not available");
                }
            } else if (bl2) {
                this.diagnosticTrace("BT PHONE ", "is coded and not yet detected via DSI");
            }
            if (bl3) {
                this.setExtPhoneFeatureFlagValue(bl);
                AslTargetSystemFeaturesAndCoding.writeBooleanToDatapool(340, bl);
                AslTargetSystemFeaturesAndCoding.writeBooleanToDatapool(336, bl);
                ServiceManager.configManagerDiag.setFeatureFlagValue("ASL.Configuration.isExtPhoneAvailable", bl);
                this.factorySettingsFlags[8] = bl;
                this.factorySettingsFlags[3] = bl || this.internalPhoneFeatureFlagValue;
            }
        }
    }

    private void diagnosticTrace(String string, String string2) {
        if (this.isTraceEnabled()) {
            ServiceManager.logger.trace(16384).append("DIAGNOSTIC ").append(string).append(string2).log();
        }
    }

    private void updateIntPhoneAvailability(ConfigurationManagerDiag configurationManagerDiag) {
        configurationManagerDiag.addRtMethodListener(new AslTargetSystemFeaturesAndCoding$1(this, configurationManagerDiag));
    }

    void updateInternalPhoneAvailablility(boolean bl) {
        AslTargetSystemFeaturesAndCoding.writeBooleanToDatapool(341, bl);
        AslTargetSystemFeaturesAndCoding.writeBooleanToDatapool(337, bl);
        this.factorySettingsFlags[3] = bl | this.extPhoneFeatureFlagValue;
        AslTargetSystemFeaturesAndCoding.writeFlagVectorToDatapool(1664, this.factorySettingsFlags);
    }

    private void updateRVCState() {
        boolean bl;
        boolean bl2 = bl = this.rvcFeatureFlag != 0;
        if (bl) {
            ServiceManager.logger.info(16384).append("DIAGNOSTIC ").append("RVC ").append("is active").log();
        } else {
            ServiceManager.logger.info(16384).append("DIAGNOSTIC ").append("RVC ").append("is not active").log();
        }
        AslTargetSystemFeaturesAndCoding.writeBooleanToDatapool(342, bl);
        ServiceManager.configManagerDiag.setFeatureFlagValue("ASL.Configuration.isRVC", bl);
        if (this.displayManagementReady) {
            this.sendRVCStateToDisplayManagement();
            this.systemLogger.trace(new Object[]{"updateRVCState, send Event to DisplayManagement: ", new Integer(this.rvcFeatureFlag)});
        } else {
            this.systemLogger.trace("updateRVCState, DisplayManagement not yet ready, message ASL_SYSTEM_DISPLAYMANAGEMENT_RVC pending");
        }
    }

    private void sendRVCStateToDisplayManagement() {
        this.systemLogger.trace("sendRVCStateToDisplayManagement");
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getTargetId(), 0x171100, 634786560);
        eventGeneric.setInt(0, this.rvcFeatureFlag);
        try {
            this.send(eventGeneric);
        }
        catch (GenericEventException genericEventException) {
            this.error(genericEventException);
        }
    }

    private void updateAMIState() {
        if (this.displayManagementReady && this.isTableCodingAlreadyRead) {
            this.systemLogger.trace("updateAMIState");
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getTargetId(), 0x171100, 584454912);
            eventGeneric.setBoolean(0, this.isAMICodedActive);
            try {
                this.send(eventGeneric);
            }
            catch (GenericEventException genericEventException) {
                this.error(genericEventException);
            }
        }
    }

    private void writeDABFeatureFlag(boolean bl) {
        if (bl) {
            ServiceManager.logger.info(16384).append("DIAGNOSTIC ").append("DAB ").append("is available (and detected via DSI)").log();
        } else {
            ServiceManager.logger.info(16384).append("DIAGNOSTIC ").append("DAB ").append("is detected via DSI but not coded!").log();
        }
        this.dabFeatureFlagValue = bl;
        AslTargetSystemFeaturesAndCoding.writeBooleanToDatapool(339, bl);
        AslTargetSystemFeaturesAndCoding.writeBooleanToDatapool(335, bl);
        this.services.getConfigManagerDiag().setFeatureFlagValue("ASL.Configuration.isDABAvailable", bl);
        this.sendDabSlsData();
    }

    private void setNotificationForDab() {
        this.systemLogger.trace("setNotificationForDab");
        DSIProxy dSIProxy = SystemServicesProvider.getSystemServices().getDsiProxy();
        DSIProxyAdapterFactory dSIProxyAdapterFactory = SystemServicesProvider.getSystemServices().getDsiProxyAdapterFactory();
        DSIListener dSIListener = dSIProxyAdapterFactory.createDSIListenerMethodAdapter(this, class$org$dsi$ifc$radio$DSIDABTunerListener == null ? (class$org$dsi$ifc$radio$DSIDABTunerListener = AslTargetSystemFeaturesAndCoding.class$("org.dsi.ifc.radio.DSIDABTunerListener")) : class$org$dsi$ifc$radio$DSIDABTunerListener);
        DSIDABTuner dSIDABTuner = (DSIDABTuner)dSIProxy.getService(this, class$org$dsi$ifc$radio$DSIDABTuner == null ? (class$org$dsi$ifc$radio$DSIDABTuner = AslTargetSystemFeaturesAndCoding.class$("org.dsi.ifc.radio.DSIDABTuner")) : class$org$dsi$ifc$radio$DSIDABTuner);
        dSIDABTuner.setNotification(21, dSIListener);
    }

    private void setNotificationForSDS() {
        this.systemLogger.trace("setNotificationForSDS");
        DSIProxy dSIProxy = SystemServicesProvider.getSystemServices().getDsiProxy();
        DSIProxyAdapterFactory dSIProxyAdapterFactory = SystemServicesProvider.getSystemServices().getDsiProxyAdapterFactory();
        DSIListener dSIListener = dSIProxyAdapterFactory.createDSIListenerMethodAdapter(this, class$org$dsi$ifc$speechrec$DSISpeechRecListener == null ? (class$org$dsi$ifc$speechrec$DSISpeechRecListener = AslTargetSystemFeaturesAndCoding.class$("org.dsi.ifc.speechrec.DSISpeechRecListener")) : class$org$dsi$ifc$speechrec$DSISpeechRecListener);
        DSISpeechRec dSISpeechRec = (DSISpeechRec)dSIProxy.getService(this, class$org$dsi$ifc$speechrec$DSISpeechRec == null ? (class$org$dsi$ifc$speechrec$DSISpeechRec = AslTargetSystemFeaturesAndCoding.class$("org.dsi.ifc.speechrec.DSISpeechRec")) : class$org$dsi$ifc$speechrec$DSISpeechRec);
        dSISpeechRec.setNotification(16, dSIListener);
    }

    private void setNotificationForWLAN() {
        this.systemLogger.trace("setNotificationForWLAN");
        DSIProxy dSIProxy = SystemServicesProvider.getSystemServices().getDsiProxy();
        DSIProxyAdapterFactory dSIProxyAdapterFactory = SystemServicesProvider.getSystemServices().getDsiProxyAdapterFactory();
        DSIListener dSIListener = dSIProxyAdapterFactory.createDSIListenerMethodAdapter(this, class$org$dsi$ifc$networking$DSIWLANListener == null ? (class$org$dsi$ifc$networking$DSIWLANListener = AslTargetSystemFeaturesAndCoding.class$("org.dsi.ifc.networking.DSIWLANListener")) : class$org$dsi$ifc$networking$DSIWLANListener);
        DSIWLAN dSIWLAN = (DSIWLAN)dSIProxy.getService(this, class$org$dsi$ifc$networking$DSIWLAN == null ? (class$org$dsi$ifc$networking$DSIWLAN = AslTargetSystemFeaturesAndCoding.class$("org.dsi.ifc.networking.DSIWLAN")) : class$org$dsi$ifc$networking$DSIWLAN);
        dSIWLAN.setNotification(18, dSIListener);
    }

    private void setNotificationForBT() {
        this.systemLogger.trace("setNotificationForBT");
        DSIProxy dSIProxy = SystemServicesProvider.getSystemServices().getDsiProxy();
        DSIProxyAdapterFactory dSIProxyAdapterFactory = SystemServicesProvider.getSystemServices().getDsiProxyAdapterFactory();
        DSIListener dSIListener = dSIProxyAdapterFactory.createDSIListenerMethodAdapter(this, class$org$dsi$ifc$bluetooth$DSIBluetoothListener == null ? (class$org$dsi$ifc$bluetooth$DSIBluetoothListener = AslTargetSystemFeaturesAndCoding.class$("org.dsi.ifc.bluetooth.DSIBluetoothListener")) : class$org$dsi$ifc$bluetooth$DSIBluetoothListener);
        DSIBluetooth dSIBluetooth = (DSIBluetooth)dSIProxy.getService(this, class$org$dsi$ifc$bluetooth$DSIBluetooth == null ? (class$org$dsi$ifc$bluetooth$DSIBluetooth = AslTargetSystemFeaturesAndCoding.class$("org.dsi.ifc.bluetooth.DSIBluetooth")) : class$org$dsi$ifc$bluetooth$DSIBluetooth);
        dSIBluetooth.setNotification(3, dSIListener);
    }

    private void setNotificationForMediaBase() {
        this.systemLogger.trace("setNotificationForMediaBase");
        DSIProxy dSIProxy = SystemServicesProvider.getSystemServices().getDsiProxy();
        DSIProxyAdapterFactory dSIProxyAdapterFactory = SystemServicesProvider.getSystemServices().getDsiProxyAdapterFactory();
        DSIListener dSIListener = dSIProxyAdapterFactory.createDSIListenerMethodAdapter(this, class$org$dsi$ifc$media$DSIMediaBaseListener == null ? (class$org$dsi$ifc$media$DSIMediaBaseListener = AslTargetSystemFeaturesAndCoding.class$("org.dsi.ifc.media.DSIMediaBaseListener")) : class$org$dsi$ifc$media$DSIMediaBaseListener);
        DSIMediaBase dSIMediaBase = (DSIMediaBase)dSIProxy.getService(this, class$org$dsi$ifc$media$DSIMediaBase == null ? (class$org$dsi$ifc$media$DSIMediaBase = AslTargetSystemFeaturesAndCoding.class$("org.dsi.ifc.media.DSIMediaBase")) : class$org$dsi$ifc$media$DSIMediaBase);
        dSIMediaBase.setNotification(new int[]{7, 8}, dSIListener);
    }

    private void sendDabSlsData() {
        if (this.diagSpeedThresholdsRead && this.dabFeatureFlagValue) {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
            eventGeneric.setBoolean(0, this.speedLimitSlideshowActive != 255);
            eventGeneric.setInt(1, this.dabSlsDuration1);
            eventGeneric.setInt(2, this.dabSlsDuration2);
            this.triggerObserver(580731136, eventGeneric);
            this.systemLogger.trace("sendDabSlsData, send Event");
        }
    }

    private void writeSDSFeatureFlag(boolean bl) {
        boolean bl2;
        boolean bl3 = this.persistableEarlyData.isSDSActive();
        boolean bl4 = bl2 = bl != bl3 || !this.didSetSdsStateAlready;
        if (bl2) {
            AslTargetSystemFeaturesAndCoding.writeBooleanToDatapool(343, bl);
            ServiceManager.configManagerDiag.setFeatureFlagValue("ASL.Configuration.isSDS", bl);
            this.persistableEarlyData.setSDSActive(bl);
            this.didSetSdsStateAlready = true;
        }
    }

    private boolean getDiagnosisValue(Access access, int n) {
        boolean bl = access.contains(n) ? access.getBoolean(n) : false;
        return bl;
    }

    void setExtPhoneFeatureFlagValue(boolean bl) {
        this.extPhoneFeatureFlagValue = bl;
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


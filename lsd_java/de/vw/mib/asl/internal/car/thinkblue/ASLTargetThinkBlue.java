/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.thinkblue;

import de.vw.mib.asl.api.car.thinkblue.TBTService;
import de.vw.mib.asl.api.car.thinkblue.TBTServiceListener;
import de.vw.mib.asl.api.system.ASLSystemAPI;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.framework.api.diagnosis.AdaptionResponse;
import de.vw.mib.asl.framework.api.diagnosis.config.Access;
import de.vw.mib.asl.framework.api.diagnosis.config.EcoHmi;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.car.ASLCarContainer;
import de.vw.mib.asl.internal.car.framework.services.ServiceFactory;
import de.vw.mib.asl.internal.car.thinkblue.BCGeneralData;
import de.vw.mib.asl.internal.car.thinkblue.calc.BlueCalculator;
import de.vw.mib.asl.internal.car.thinkblue.calc.BlueManager;
import de.vw.mib.asl.internal.car.thinkblue.calc.table.ConditionsContainer;
import de.vw.mib.asl.internal.car.thinkblue.calc.table.DrivingTable;
import de.vw.mib.asl.internal.car.thinkblue.calc.table.DrivingTableFactory;
import de.vw.mib.asl.internal.car.thinkblue.skoda.TBTSkodaExtension;
import de.vw.mib.collections.ints.IntIntMap;
import de.vw.mib.collections.ints.IntIntOptHashMap;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.Logger;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carkombi.BCShortTermGeneralData;
import org.dsi.ifc.carkombi.BCViewOptions;
import org.dsi.ifc.carkombi.DSICarKombi;
import org.dsi.ifc.carkombi.DSICarKombiListener;
import org.dsi.ifc.carvehiclestates.DSICarVehicleStates;
import org.dsi.ifc.carvehiclestates.DSICarVehicleStatesListener;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoHighFrequent;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoHighFrequentViewOptions;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoMidFrequent;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoMidFrequentViewOptions;
import org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates;
import org.dsi.ifc.global.CarBCConsumption;
import org.dsi.ifc.global.CarBCDistance;
import org.dsi.ifc.global.CarBCTime;

public class ASLTargetThinkBlue
extends AbstractASLTarget
implements TBTService,
DSIServiceStateListener,
AdaptionResponse {
    private static final int TREND_CONSUMPTION_LIMIT_DEVIATION;
    public static final int INTERNAL_EVENT_START_CORRECT_GEAR_LONG;
    public static final int INTERNAL_EVENT_STOP_CORRECT_GEAR_LONG;
    public static final int INTERNAL_EVENT_TRIGGER_GEM;
    public static final int INTERNAL_EVENT_CLUTCHED_OUT_STATE_TIMEOUT;
    private static final int TIMEOUT_HB;
    private static final int TIMER_EVENT_HB;
    private static final int TIMEOUT_CORRECT_GEAR_LONG;
    private static final int TIMER_EVENT_CORRECT_GEAR_LONG;
    private static final int TIMEOUT_VALUE_SPEED_HINT_SUPPRESSED;
    private static final int TIMER_EVENT_SPEED_HINT_SUPPRESSED;
    private static final int TIMER_EVENT_LOADCHANGE;
    private static final int TIMER_EVENT_TRIGGER_ACC_CALCULATION;
    public static final int TIMEOUT_VALUE_TRIGGER_ACC_CALCULATION;
    private static final int TIMER_EVENT_TRIGGER_CURRENT_CONSUMPTION_CALCULATION;
    public static final int TIMEOUT_VALUE_TRIGGER_CURRENT_CONSUMPTION_CALCULATION;
    private static final int ENGINE_TYPE_NO_ENGINE;
    private static final int ENGINE_TYPE_COMBUSTION;
    private static final int ENGINE_TYPE_HYBRID;
    private static final int ENGINE_TYPE_ELECTRIC;
    public static final int CONFIG_COMBUSTION_MSG;
    public static final int CONFIG_COMBUSTION_ASG_TIP;
    public static final int CONFIG_COMBUSTION_ASG_NOTIP;
    public static final int CONFIG_ELECTRIC;
    private static final int GEAR_TYPE_UNKNOWN;
    private static final int GEAR_TYPE_MSG;
    private static final int GEAR_TYPE_ASG_NOTIP;
    private static final int GEAR_TYPE_ASG_TIP;
    private static final int GEAR_TYPE_EV;
    private static final int STATE_DEEPBLUE_NOTINIT;
    private static final int STATE_DEEPBLUE_STARTED;
    private static final int STATE_DEEPBLUE_STOPPED;
    private static final int HIST_MAX_LP100KM;
    private static final int HIST_MAX_KMPL;
    private static final int HIST_MAX_MPG_UK;
    private static final int HIST_MAX_MPG_US;
    private static final int HIST_MAX_MPG_USE;
    private static final int HIST_MAX_KWHP100KM;
    private static final int HIST_MAX_KMPKWH;
    private static final int HIST_MAX_KWHPMI;
    private static final int HIST_MAX_MIPKWH;
    DrivingTable[] tables = new DrivingTable[4];
    public static Logger logMsg;
    private DSICarVehicleStates dsiVehStates;
    private DSICarVehicleStatesListener dsiVehStatesListener;
    private int currDeepBlueState = 0;
    private BlueManager blueManager;
    private int gearType = 0;
    private boolean gemTargetReady;
    private static final long DEFAULT_LOAD_CHANGE_TIME_INTERVAL;
    private long loadChangeTimeInterval = 0;
    private int engineType = 0;
    private DrivingTable currentDrivingTable;
    public static boolean isHybrid;
    private boolean isCombustionOnly;
    private boolean isElectricOnly;
    private IntIntMap histMaxValues = new IntIntOptHashMap();
    private float currentVehicleSpeed;
    private BlueCalculator calculator;
    private boolean dsiRegistrationDone;
    private boolean initAppDone;
    private float currentConsumption1;
    private float currentConsumption2;
    private int oldSpeedUnit = 0;
    private int consumptionUnit = -1;
    BCGeneralData oldShortTerm = new BCGeneralData();
    private float averageShortTermConsumption;
    public static final int GEARUNIT_NO_RECOMMENDATION_NO_GEAR;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$thinkblue$TBTService;
    static /* synthetic */ Class class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates;
    static /* synthetic */ Class class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$DSICarKombi;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$DSICarKombiListener;
    static /* synthetic */ Class class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$thinkblue$TBTServiceListener;
    static /* synthetic */ Class class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener;

    public ASLTargetThinkBlue(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        if (this.isTraceEnabled()) {
            this.trace().append("TBT.ctor").log();
        }
    }

    @Override
    public int getDefaultTargetId() {
        return -2091970048;
    }

    @Override
    public int getSubClassifier() {
        return 1;
    }

    private void registerAsServiceProvider() {
        ServiceFactory.getInstance().getServiceProviderRegistry().registerServiceProvider(class$de$vw$mib$asl$api$car$thinkblue$TBTService == null ? (class$de$vw$mib$asl$api$car$thinkblue$TBTService = ASLTargetThinkBlue.class$("de.vw.mib.asl.api.car.thinkblue.TBTService")) : class$de$vw$mib$asl$api$car$thinkblue$TBTService, this);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 106: {
                this.requestAppCoding();
                this.registerAsServiceProvider();
                break;
            }
            case 0x200B2B: {
                this.evalResponseAppCoding(eventGeneric);
                break;
            }
            case 100100: {
                this.blueManager.onHB();
                break;
            }
            case 112: {
                this.startTimer(92733696, (long)0, true);
                break;
            }
            case 113: {
                this.stopTimer(92733696);
                ConditionsContainer.getInstance().refreshConditionCorrectGearLong(false);
                break;
            }
            case 100101: {
                if (this.isTraceEnabled()) {
                    this.trace().append("TBT.TIMER_EVENT_CORRECT_GEAR_LONG").log();
                }
                if (this.currDeepBlueState != 1) {
                    return;
                }
                ConditionsContainer.getInstance().refreshConditionCorrectGearLong(true);
                this.updateDrivingState();
                break;
            }
            case 1073744866: {
                int n2 = eventGeneric.getInt(0);
                if (n2 != 12) break;
                if (this.isTraceEnabled()) {
                    this.trace().append("TBT.RESET_TO_FACTORY_SETTING for TBT").log();
                }
                this.resetIris();
                break;
            }
            case 1073744867: {
                if (this.isTraceEnabled()) {
                    this.trace().append("TBT.RESET_BC_MENU1").log();
                }
                this.resetIris();
                break;
            }
            case 41725: {
                if (this.isTraceEnabled()) {
                    this.trace().append("TBT.GEM_TARGET_IS_READY").log();
                }
                this.gemTargetReady = true;
                this.registerService(738926592);
                break;
            }
            case 114: {
                if (!this.gemTargetReady) break;
                this.triggerObserver(738926592, ServiceManager.mGenericEventFactory.newEvent(eventGeneric));
                break;
            }
            case 1073745115: {
                if (this.isTraceEnabled()) {
                    this.trace().append("TBT.SPEED_HINT_SUPPRESS").log();
                }
                this.calculator.setSpeedHintSuppressed(true);
                this.startTimer(109510912, (long)0, false);
                break;
            }
            case 100102: {
                if (this.isTraceEnabled()) {
                    this.trace().append("TBT.SPEED_HINT_CONSIDER").log();
                }
                this.calculator.setSpeedHintSuppressed(false);
                break;
            }
            case 1200004: {
                if (this.isTraceEnabled()) {
                    this.trace().append("TBT.DIAG_PERSIST_CHANGED").log();
                }
                this.requestDiagnosisData();
                break;
            }
            case 100103: {
                if (this.isTraceEnabled()) {
                    this.trace().append("TBT.TIMER_EVENT_LOADCHANGE").log();
                }
                this.calculator.onLoadChangeTimeout();
                break;
            }
            case 116: {
                if (this.isTraceEnabled()) {
                    this.trace().append("TBT.INTERNAL_EVENT_CLUTCHED_OUT_STATE_TIMEOUT").log();
                }
                this.calculator.setTemporalCondition(true);
                this.updateDrivingState();
                break;
            }
            case 1073745128: {
                if (this.isTraceEnabled()) {
                    this.trace().append("TBT.HINT_ICON_TIMER_ELAPSED").log();
                }
                this.calculator.hintIconTimeout();
                break;
            }
            case 100104: {
                this.calculator.onSpeedUpdate(this.currentVehicleSpeed);
                break;
            }
            case 100105: {
                this.blueManager.onShortTermConsumptionValue1(this.averageShortTermConsumption);
                boolean bl = ConditionsContainer.getInstance().refreshConditionsConsumption1(this.currentConsumption1);
                float f2 = this.validateConsumption(this.currentConsumption1);
                this.blueManager.onCurrentConsum1(f2);
                if (isHybrid) {
                    if (ConditionsContainer.getInstance().refreshConditionsConsumption2(this.currentConsumption2)) {
                        bl = true;
                    }
                    f2 = this.validateConsumption(this.currentConsumption2);
                    this.blueManager.onCurrentConsum2(f2);
                }
                if (!bl) break;
                this.updateDrivingState();
                break;
            }
        }
    }

    private void requestAppCoding() {
        if (this.isTraceEnabled()) {
            this.trace().append("TBT.Startup.requestAppCoding").log();
        }
        this.addObserver(0x2B0B2000);
    }

    private void evalResponseAppCoding(EventGeneric eventGeneric) {
        boolean bl = eventGeneric.getBoolean(0);
        if (this.isTraceEnabled()) {
            this.trace().append("TBT.Startup.evalResponseAppCoding ").append(bl).log();
        }
        if (bl) {
            this.readEngineTypes();
        } else {
            this.warn().append("TBT.Startup.evalResponseAppCoding not coded").log();
        }
    }

    private void readEngineTypes() {
        if (this.isTraceEnabled()) {
            this.trace().append("TBT.Startup.readEngineTypes").log();
        }
        ASLSystemAPI aSLSystemAPI = ASLSystemFactory.getSystemApi();
        this.isCombustionOnly = aSLSystemAPI.getFeatureFlagValueCombustion();
        this.isElectricOnly = aSLSystemAPI.getFeatureFlagValueBEV();
        isHybrid = aSLSystemAPI.getFeatureFlagValuePHEV();
        if (this.isCombustionOnly) {
            if (this.isTraceEnabled()) {
                this.trace("TBT.ET: Combustion ", 1);
            }
            this.engineType = 1;
            this.initHistoryMaxValuesCombustion();
        } else if (this.isElectricOnly) {
            if (this.isTraceEnabled()) {
                this.trace("TBT.ET: Electric ", 4);
            }
            this.engineType = 4;
            this.initHistoryMaxValuesElectric();
        } else if (isHybrid) {
            if (this.isTraceEnabled()) {
                this.trace("TBT.ET: Hybrid ", 3);
            }
            this.engineType = 3;
            this.initHistoryMaxValuesHybrid();
        } else {
            this.engineType = 0;
            this.error("TBT.config error. no engine. app stops", -1);
        }
        if (this.engineType != 0) {
            this.requestGearType();
        }
    }

    private void initHistoryMaxValuesHybrid() {
        this.initHistoryMaxValuesCombustion();
        this.initHistoryMaxValuesElectric();
    }

    private void initHistoryMaxValuesElectric() {
        this.histMaxValues.put(18, 30);
        this.histMaxValues.put(19, 15);
        this.histMaxValues.put(20, 10);
        this.histMaxValues.put(21, 10);
    }

    private void initHistoryMaxValuesCombustion() {
        this.histMaxValues.put(0, 15);
        this.histMaxValues.put(1, 50);
        this.histMaxValues.put(3, 145);
        this.histMaxValues.put(4, 120);
        this.histMaxValues.put(25, 50);
    }

    private void requestGearType() {
        if (this.isTraceEnabled()) {
            this.trace().append("TBT.Startup.requestGearType").log();
        }
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiVehStates = (DSICarVehicleStates)dSIProxy.getService(this, class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates == null ? (class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates = ASLTargetThinkBlue.class$("org.dsi.ifc.carvehiclestates.DSICarVehicleStates")) : class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates);
        this.dsiVehStatesListener = (DSICarVehicleStatesListener)dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener == null ? (class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener = ASLTargetThinkBlue.class$("org.dsi.ifc.carvehiclestates.DSICarVehicleStatesListener")) : class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener);
        this.dsiVehStates.setNotification(new int[]{15}, (DSIListener)this.dsiVehStatesListener);
    }

    private void evalResponseGearType(DynamicVehicleInfoMidFrequent dynamicVehicleInfoMidFrequent) {
        DrivingTable drivingTable;
        int n = this.gearType;
        boolean bl = this.evaluateGearType(dynamicVehicleInfoMidFrequent);
        if (bl) {
            return;
        }
        if (!this.validateGearChange(n, this.gearType)) {
            this.error().append("TBT.invalid GT from=").append(n).append(", to=").append(this.gearType).log();
        }
        if ((drivingTable = this.changeDrivingTable()) == null) {
            this.error().append("TBT.DT not found. ET=").append(this.engineType).append(", GT=").append(this.gearType).log();
            return;
        }
        this.initApp();
        this.calculator.setDrivingTable(drivingTable);
    }

    private boolean evaluateGearType(DynamicVehicleInfoMidFrequent dynamicVehicleInfoMidFrequent) {
        int n = this.gearType;
        int n2 = dynamicVehicleInfoMidFrequent.automaticGearShiftTransMode;
        if (this.engineType == 4) {
            this.gearType = 4;
        } else if (n2 > 0 && n2 <= 5 || n2 == 8 || n2 == 9 || n2 == 10 || n2 == 11 || n2 == 12 || n2 == 13) {
            this.gearType = 2;
        } else if (n2 == 7 || n2 == 6) {
            this.gearType = 3;
        } else if (n2 == 0 && dynamicVehicleInfoMidFrequent.getCurrentGear() >= 0 && dynamicVehicleInfoMidFrequent.getCurrentGear() <= 10) {
            this.gearType = 1;
        } else {
            this.error("TBT.GT unknown. use last:", this.gearType);
        }
        return n == this.gearType;
    }

    private boolean validateGearChange(int n, int n2) {
        if (n == 0 && n2 != 0) {
            return true;
        }
        if (n == 3 && n2 == 2) {
            return true;
        }
        return n == 2 && n2 == 3;
    }

    private void requestDiagnosisData() {
        ServiceManager.adaptionApi.requestEcoHmi(this);
    }

    private void readDiagnosisData(EcoHmi ecoHmi) {
        if (this.isTraceEnabled()) {
            this.trace().append("TBT.EcoHmiCoding start reading...").log();
        }
        if (ecoHmi.contains(826)) {
            this.loadChangeTimeInterval = ecoHmi.getValue(826) * 1000;
            if (this.loadChangeTimeInterval == 0L) {
                this.loadChangeTimeInterval = 0;
            }
        }
        this.readHistMaxValues(ecoHmi);
        if (this.tables[0] != null) {
            this.tables[0].setPersistentValues(ecoHmi);
        } else if (this.tables[1] != null && this.tables[2] != null) {
            this.tables[1].setPersistentValues(ecoHmi);
            this.tables[2].setPersistentValues(ecoHmi);
        } else if (this.tables[3] != null) {
            this.tables[3].setPersistentValues(ecoHmi);
        }
        this.calculator.setPersistentValues(ecoHmi);
        this.blueManager.setPersistentValues(ecoHmi);
    }

    private void readHistMaxValues(EcoHmi ecoHmi) {
        if (this.isCombustionOnly) {
            this.setHistMaxCombustion(ecoHmi);
        } else if (this.isElectricOnly) {
            if (ecoHmi.contains(830)) {
                this.histMaxValues.put(18, ecoHmi.getValue(830));
            }
            if (ecoHmi.contains(831)) {
                this.histMaxValues.put(19, ecoHmi.getValue(831));
            }
            if (ecoHmi.contains(832)) {
                this.histMaxValues.put(20, ecoHmi.getValue(832));
            }
            if (ecoHmi.contains(833)) {
                this.histMaxValues.put(21, ecoHmi.getValue(833));
            }
        } else if (isHybrid) {
            this.setHistMaxCombustion(ecoHmi);
            if (ecoHmi.contains(835)) {
                this.histMaxValues.put(18, ecoHmi.getValue(835));
            }
            if (ecoHmi.contains(836)) {
                this.histMaxValues.put(19, ecoHmi.getValue(836));
            }
            if (ecoHmi.contains(837)) {
                this.histMaxValues.put(20, ecoHmi.getValue(837));
            }
            if (ecoHmi.contains(838)) {
                this.histMaxValues.put(21, ecoHmi.getValue(838));
            }
        }
    }

    private void setHistMaxCombustion(EcoHmi ecoHmi) {
        if (ecoHmi.contains(830)) {
            this.histMaxValues.put(0, ecoHmi.getValue(830));
        }
        if (ecoHmi.contains(831)) {
            this.histMaxValues.put(1, ecoHmi.getValue(831));
        }
        if (ecoHmi.contains(832)) {
            this.histMaxValues.put(3, ecoHmi.getValue(832));
        }
        if (ecoHmi.contains(833)) {
            this.histMaxValues.put(4, ecoHmi.getValue(833));
        }
        if (ecoHmi.contains(834)) {
            this.histMaxValues.put(25, ecoHmi.getValue(834));
        }
    }

    private void registerDSI() {
        if (this.dsiRegistrationDone) {
            return;
        }
        this.dsiRegistrationDone = true;
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        DSICarKombi dSICarKombi = (DSICarKombi)dSIProxy.getService(this, class$org$dsi$ifc$carkombi$DSICarKombi == null ? (class$org$dsi$ifc$carkombi$DSICarKombi = ASLTargetThinkBlue.class$("org.dsi.ifc.carkombi.DSICarKombi")) : class$org$dsi$ifc$carkombi$DSICarKombi);
        DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$carkombi$DSICarKombiListener == null ? (class$org$dsi$ifc$carkombi$DSICarKombiListener = ASLTargetThinkBlue.class$("org.dsi.ifc.carkombi.DSICarKombiListener")) : class$org$dsi$ifc$carkombi$DSICarKombiListener);
        dSICarKombi.setNotification(new int[]{11, 13, 6, 16, 19}, (DSIListener)dSICarKombiListener);
        if (isHybrid) {
            dSICarKombi.setNotification(new int[]{12, 7}, (DSIListener)dSICarKombiListener);
        }
        this.dsiVehStates.setNotification(new int[]{12, 14, 13}, (DSIListener)this.dsiVehStatesListener);
        dSIProxy.addServiceStateListener(class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = ASLTargetThinkBlue.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates, this);
    }

    private void initApp() {
        if (this.initAppDone) {
            return;
        }
        this.initAppDone = true;
        logMsg = this.getTextLogger();
        this.calculator = new BlueCalculator();
        this.blueManager = new BlueManager(this);
        this.blueManager.setSkodaHandler(new TBTSkodaExtension());
        this.blueManager.init();
        this.blueManager.setCalculator(this.calculator);
        this.registerModelEvents();
        this.requestDiagnosisData();
    }

    void registerModelEvents() {
        this.addObservers(new int[]{-485818304, -469041088, -502595520, -39714816, -619970496, -401866688});
    }

    private void resetIris() {
        this.calculator.reset();
        this.blueManager.reset();
        this.restartTimer(75956480);
        this.stopTimer(109510912);
        this.calculator.setSpeedHintSuppressed(false);
        this.stopTimer(92733696);
        ConditionsContainer.getInstance().refreshConditionCorrectGearLong(false);
        ASLTargetThinkBlue.writeIntegerToDatapool(10423, 0);
        this.getTBTServiceListener().updateCurrentConsumption(0);
        ASLTargetThinkBlue.writeIntegerToDatapool(10424, 0);
        this.getTBTServiceListener().updateCurrentConsumptionDecimal(0);
    }

    public void dsiCarKombiUpdateBCViewOptions(BCViewOptions bCViewOptions, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("TBT.BCVO.config.primaryEngineType: ").append(bCViewOptions.configuration.getPrimaryEngineType()).append(", secondaryEngineType: ").append(bCViewOptions.configuration.getSecondaryEngineType()).log();
        }
    }

    public void dsiCarKombiUpdateBCShortTermAverageConsumption1(CarBCConsumption carBCConsumption, int n) {
        float f2 = this.getConsumptionMappingValueFor(carBCConsumption.consumptionValue);
        if (this.consumptionUnit != carBCConsumption.getConsumptionUnit()) {
            this.consumptionUnit = carBCConsumption.getConsumptionUnit();
            this.updateHistoryMaxValue(10468, this.consumptionUnit);
            this.blueManager.setConsumptionTrendLimit(5 * this.histMaxValues.get(this.consumptionUnit) / 100);
            this.blueManager.onShortTermConsumptionUnit1Change(this.consumptionUnit);
        }
        if (carBCConsumption.getState() == 0 || (double)f2 >= 6553.5) {
            return;
        }
        this.averageShortTermConsumption = f2;
        ASLTargetThinkBlue.writeIntegerToDatapool(10423, this.getCurrentConsumption());
        this.getTBTServiceListener().updateCurrentConsumption(this.getCurrentConsumption());
        ASLTargetThinkBlue.writeIntegerToDatapool(10424, this.getCurrentConsumptionDecimal());
        this.getTBTServiceListener().updateCurrentConsumptionDecimal(this.getCurrentConsumptionDecimal());
    }

    private float getConsumptionMappingValueFor(float f2) {
        if ((double)f2 == -3276.8 || (double)f2 == -3276.7 || (double)f2 == -3276.6 || (double)f2 == -3276.5) {
            return 0xCCCC45;
        }
        return f2;
    }

    public void dsiCarKombiUpdateBCShortTermAverageConsumption2(CarBCConsumption carBCConsumption, int n) {
        float f2 = this.getConsumptionMappingValueFor(carBCConsumption.consumptionValue);
        this.updateHistoryMaxValue(10490, carBCConsumption.getConsumptionUnit());
        if (carBCConsumption.getState() == 0 || (double)f2 >= 6553.5) {
            return;
        }
        ASLTargetThinkBlue.writeIntegerToDatapool(10433, Math.round(f2));
        this.blueManager.onShortTermConsumptionUnit2(carBCConsumption.getConsumptionUnit());
    }

    private void updateHistoryMaxValue(int n, int n2) {
        ASLTargetThinkBlue.writeIntegerToDatapool(n, this.histMaxValues.get(n2));
    }

    public void dsiCarKombiUpdateBCCurrentConsumption1(CarBCConsumption carBCConsumption, int n) {
        if (this.currDeepBlueState != 1) {
            return;
        }
        this.currentConsumption1 = this.getConsumptionMappingValueFor(carBCConsumption.getConsumptionValue());
    }

    public void dsiCarKombiUpdateBCCurrentConsumption2(CarBCConsumption carBCConsumption, int n) {
        if (this.currDeepBlueState != 1) {
            return;
        }
        this.currentConsumption2 = this.getConsumptionMappingValueFor(carBCConsumption.getConsumptionValue());
    }

    private float validateConsumption(float f2) {
        float f3 = f2;
        if ((double)f3 >= 6553.5) {
            f3 = 0.0f;
        }
        return f3;
    }

    public void dsiCarKombiUpdateBCShortTermGeneral(BCShortTermGeneralData bCShortTermGeneralData, int n) {
        if (ASLTargetThinkBlue.checkForReset(bCShortTermGeneralData.distance, bCShortTermGeneralData.timeValue, this.oldShortTerm)) {
            this.resetIris();
        }
    }

    public static boolean checkForReset(CarBCDistance carBCDistance, CarBCTime carBCTime, BCGeneralData bCGeneralData) {
        boolean bl = false;
        double d2 = carBCDistance.getDistanceValue();
        int n = carBCDistance.getDistanceUnit();
        int n2 = carBCTime.getTimeValue();
        if (n != bCGeneralData.distanceUnit) {
            bCGeneralData.distanceUnit = n;
            bCGeneralData.distanceValue = 0.0;
        }
        if (n2 == 0 && carBCTime.getState() == 1 || d2 == 0.0 && carBCDistance.getDistanceValueState() == 1 || n2 < bCGeneralData.travelTime || d2 < bCGeneralData.distanceValue) {
            if (!bCGeneralData.resetDone) {
                bCGeneralData.resetDone = true;
                bl = true;
            }
        } else {
            bCGeneralData.resetDone = false;
        }
        bCGeneralData.distanceValue = d2;
        bCGeneralData.travelTime = n2;
        return bl;
    }

    public void dsiCarVehicleStatesUpdateDynamicVehicleInfoHighFrequentViewOptions(DynamicVehicleInfoHighFrequentViewOptions dynamicVehicleInfoHighFrequentViewOptions, int n) {
    }

    public void dsiCarVehicleStatesUpdateDynamicVehicleInfoHighFrequent(DynamicVehicleInfoHighFrequent dynamicVehicleInfoHighFrequent, int n) {
        if (dynamicVehicleInfoHighFrequent == null) {
            this.error("TBT.highFreq is null");
            return;
        }
        ConditionsContainer.getInstance().refreshConditions(dynamicVehicleInfoHighFrequent);
        if (this.currDeepBlueState != 1) {
            return;
        }
        if (dynamicVehicleInfoHighFrequent.vehicleSpeed.speedValueState == 1) {
            this.currentVehicleSpeed = dynamicVehicleInfoHighFrequent.vehicleSpeed.speedValue;
            if (this.oldSpeedUnit != dynamicVehicleInfoHighFrequent.vehicleSpeed.speedUnit) {
                this.calculator.onSpeedUnitChange(dynamicVehicleInfoHighFrequent.vehicleSpeed.speedUnit);
                this.oldSpeedUnit = dynamicVehicleInfoHighFrequent.vehicleSpeed.speedUnit;
            }
        }
    }

    public void dsiCarVehicleStatesUpdateDynamicVehicleInfoMidFrequentViewOptions(DynamicVehicleInfoMidFrequentViewOptions dynamicVehicleInfoMidFrequentViewOptions, int n) {
    }

    public void dsiCarVehicleStatesUpdateDynamicVehicleInfoMidFrequent(DynamicVehicleInfoMidFrequent dynamicVehicleInfoMidFrequent, int n) {
        this.evalResponseGearType(dynamicVehicleInfoMidFrequent);
        ConditionsContainer.getInstance().refreshConditions(dynamicVehicleInfoMidFrequent);
        this.calculator.setGears(dynamicVehicleInfoMidFrequent.currentGear, dynamicVehicleInfoMidFrequent.recommendedGear);
        this.blueManager.setGears(dynamicVehicleInfoMidFrequent.currentGear, dynamicVehicleInfoMidFrequent.recommendedGear);
        if (this.currDeepBlueState != 1) {
            return;
        }
        this.updateDrivingState();
    }

    public void dsiGeneralVehicleStatesUpdateCarVelocityThreshold(boolean bl, int n) {
        this.trace().append("TBT.CarVelocityThreshold ").append(bl).append(" flag=").append(n).log();
        ConditionsContainer.getInstance().refreshConditionsStandStill(!bl);
        ASLTargetThinkBlue.writeBooleanToDatapool(10428, bl);
        if (!bl) {
            this.calculator.setCurrentAcceleration(0);
            ASLTargetThinkBlue.writeIntegerToDatapool(10432, this.calculator.getCurrentAcceleration());
            this.getTBTServiceListener().updateCurrentAcceleration(this.calculator.getCurrentAcceleration());
            ASLTargetThinkBlue.writeBooleanToDatapool(10428, bl);
        }
        this.changeCalculatorState();
    }

    public void dsiGeneralVehicleStatesUpdateReverseGear(boolean bl, int n) {
        ConditionsContainer.getInstance().refreshConditionsRGear(bl);
        if (bl) {
            this.calculator.setCurrentAcceleration(0);
            ASLTargetThinkBlue.writeIntegerToDatapool(10432, this.calculator.getCurrentAcceleration());
            this.getTBTServiceListener().updateCurrentAcceleration(this.calculator.getCurrentAcceleration());
        }
        if (ServiceManager.eventMain.getTimerServer().isTimerActive(-2091970048, 126288128)) {
            if (bl) {
                if (!ServiceManager.eventMain.getTimerServer().isTimerSuspended(-2091970048, 126288128)) {
                    this.suspendTimer(126288128);
                    this.trace().append("TBT.ReverseGear.LoadChange timer suspended.").log();
                }
            } else if (ServiceManager.eventMain.getTimerServer().isTimerSuspended(-2091970048, 126288128)) {
                this.resumeTimer(126288128);
                this.trace().append("TBT.ReverseGear.LoadChange timer resumed.").log();
            }
        }
        this.changeCalculatorState();
    }

    private DrivingTable changeDrivingTable() {
        if ((this.engineType == 1 || this.engineType == 3) && this.gearType == 1) {
            if (this.tables[0] == null) {
                this.currentDrivingTable = this.tables[0] = DrivingTableFactory.createDrivingTable(0);
            }
        } else if (!(this.engineType != 1 && this.engineType != 3 || this.gearType != 3 && this.gearType != 2)) {
            if (this.tables[1] == null) {
                this.tables[1] = DrivingTableFactory.createDrivingTable(1);
            }
            if (this.tables[2] == null) {
                this.tables[2] = DrivingTableFactory.createDrivingTable(2);
            }
            this.currentDrivingTable = this.gearType == 2 ? this.tables[2] : this.tables[1];
        } else if (this.engineType == 4 && this.gearType == 4) {
            if (this.tables[3] == null) {
                this.currentDrivingTable = this.tables[3] = DrivingTableFactory.createDrivingTable(3);
            }
        } else {
            if (this.isTraceEnabled()) {
                this.error().append("TBT.wrong ET - GT combination.ET=").append(this.engineType).append(", GT=").append(this.gearType).log();
            }
            return null;
        }
        if (this.isTraceEnabled()) {
            this.trace().append("TBT.ET.GT.DT changed to: ").append(this.engineType).append(", ").append(this.gearType).append(", ").append(this.currentDrivingTable.getTableId()).log();
        }
        return this.currentDrivingTable;
    }

    private void changeCalculatorState() {
        if (this.isTraceEnabled()) {
            this.trace().append("TBT.ET.GT.DT: ").append(this.engineType).append(", ").append(this.gearType).append(", ").append(this.currentDrivingTable.getTableId()).log();
        }
        if (ConditionsContainer.getInstance().conditions[7]) {
            this.startCalculation();
        } else {
            this.stopBPCalculation();
        }
    }

    private void startCalculation() {
        if (this.currDeepBlueState == 1) {
            return;
        }
        if (this.isTraceEnabled()) {
            this.trace().append("TBT.startBPCalculator()").log();
        }
        this.currDeepBlueState = 1;
        this.startTimer(75956480, (long)0, true);
        if (!ServiceManager.eventMain.getTimerServer().isTimerActive(-2091970048, 126288128)) {
            this.startTimer(126288128, this.loadChangeTimeInterval, true);
        }
        this.startTimer(143065344, (long)0, true);
        this.startTimer(159842560, (long)0, true);
    }

    private void stopBPCalculation() {
        if (this.currDeepBlueState == 2) {
            return;
        }
        if (this.isTraceEnabled()) {
            this.trace().append("TBT.stopBPCalculator()").log();
        }
        this.currDeepBlueState = 2;
        this.stopTimer(75956480);
        this.stopTimer(92733696);
        this.stopTimer(143065344);
        this.stopTimer(159842560);
        this.calculator.onStop();
        this.blueManager.onStopBPCalculation();
    }

    public DrivingTable getCurrDrvTable() {
        return this.currentDrivingTable;
    }

    public void setCurrDrvTable(DrivingTable drivingTable) {
        this.currentDrivingTable = drivingTable;
    }

    public void setBlueManagerInstance(BlueManager blueManager) {
        this.blueManager = blueManager;
    }

    private void updateDrivingState() {
        boolean bl = this.calculator.calculateDrivingState();
        if (bl) {
            this.blueManager.updateDrivingState();
        }
    }

    private TBTServiceListener getTBTServiceListener() {
        return (TBTServiceListener)ServiceFactory.getInstance().getServiceProviderRegistry().getServiceListener(class$de$vw$mib$asl$api$car$thinkblue$TBTServiceListener == null ? (class$de$vw$mib$asl$api$car$thinkblue$TBTServiceListener = ASLTargetThinkBlue.class$("de.vw.mib.asl.api.car.thinkblue.TBTServiceListener")) : class$de$vw$mib$asl$api$car$thinkblue$TBTServiceListener);
    }

    @Override
    public boolean getBluePointsTrend() {
        return this.blueManager.isTrendValue();
    }

    @Override
    public int getCurrentAcceleration() {
        return this.calculator.getCurrentAcceleration();
    }

    @Override
    public int getEcoAverageTrip() {
        return this.blueManager.getEcoAverageTrip();
    }

    @Override
    public boolean getConsumptionTrend() {
        return this.blueManager.isTrendConsumValue();
    }

    @Override
    public int getCurrentConsumption() {
        return (int)this.averageShortTermConsumption;
    }

    @Override
    public int getCurrentConsumptionDecimal() {
        float f2 = this.averageShortTermConsumption * 8257 % 8257;
        return (int)(f2 >= 0.0f ? f2 : f2 * 32959);
    }

    @Override
    public int getBluePoints() {
        return this.blueManager.getBluePoints();
    }

    @Override
    public int getCurrentGear() {
        return this.blueManager.getCurrentGear();
    }

    @Override
    public int getCurrentIrisSegment() {
        return this.blueManager.getPersistableFreqHigh().getIrisCursorPos();
    }

    @Override
    public int[] getIrisSegmentsValues() {
        return this.blueManager.getIrisSegmentsList().getList();
    }

    @Override
    public int getMaxAcceleration() {
        return this.calculator.getMaxAcceleration();
    }

    @Override
    public int getRecommendedGear() {
        return this.calculator.getRecommendedGear();
    }

    @Override
    public int getDisplayDurationHintIcon() {
        return this.calculator.getHintDuration();
    }

    @Override
    public int getDrivingBehaviorMode() {
        return this.calculator.getDrivingBehaviorMode();
    }

    @Override
    public void registered(String string, int n) {
        try {
            if ((class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = ASLTargetThinkBlue.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates).getName().equals(string)) {
                DSIGeneralVehicleStates dSIGeneralVehicleStates = (DSIGeneralVehicleStates)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = ASLTargetThinkBlue.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates);
                dSIGeneralVehicleStates.setNotification(new int[]{20, 7}, ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener = ASLTargetThinkBlue.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener));
            }
        }
        catch (Throwable throwable) {
            this.warn("Could not connect to DSIGeneralVehicleStates");
        }
    }

    @Override
    public void unregistered(String string, int n) {
    }

    @Override
    public void hintIconTimerElapsed() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(-401866688);
        try {
            this.gotEvent(eventGeneric);
        }
        catch (Exception exception) {
            this.warn("error with send HINT_ICON_TIMER_ELAPSED");
        }
    }

    @Override
    public void speedHintIconDisplayed() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(-619970496);
        try {
            this.gotEvent(eventGeneric);
        }
        catch (Exception exception) {
            this.warn("error with send SPEED_HINT_ICON_DISPLAYED");
        }
    }

    @Override
    public void onSuccess(Access access) {
        this.readDiagnosisData((EcoHmi)access);
        this.registerDSI();
    }

    @Override
    public void onError() {
        if (this.isTraceEnabled()) {
            ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger().error(1, "ASLTargetThinkBlue: Error requesting ecohmi from adaption api");
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
}


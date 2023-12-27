/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.e_traction;

import de.vw.mib.asl.api.car.logger.CarLogger;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.car.ASLCarContainer;
import de.vw.mib.asl.internal.car.ASLCarUtil;
import de.vw.mib.asl.internal.car.bordcomputer.arrays.consumerlistcommon.ConsumerListContext;
import de.vw.mib.asl.internal.car.bordcomputer.arrays.consumerlistcommon.ConsumerListController;
import de.vw.mib.asl.internal.car.bordcomputer.arrays.consumerlistrange.ConsumerListRangeController;
import de.vw.mib.asl.internal.car.framework.persistence.CarPersistenceData;
import de.vw.mib.asl.internal.car.framework.persistence.RecuperationData;
import de.vw.mib.asl.internal.car.transformer.CarFunctionCollector;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.car.e_traction.transformer.CarE_TractionChargingDistanceCollector;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.cardrivingcharacteristics.CharismaViewOptions;
import org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics;
import org.dsi.ifc.careco.BCmEConsumerListRangeRA0;
import org.dsi.ifc.careco.BCmEConsumerListRangeRA1;
import org.dsi.ifc.careco.BCmEConsumerListRangeRA2;
import org.dsi.ifc.careco.BCmECurrentRange;
import org.dsi.ifc.careco.BCmEListUpdateInfo;
import org.dsi.ifc.careco.BCmEViewOptions;
import org.dsi.ifc.careco.DSICarEco;
import org.dsi.ifc.carhybrid.DSICarHybrid;
import org.dsi.ifc.carhybrid.HybridEnergyFlowState;
import org.dsi.ifc.carhybrid.HybridTargetRange;
import org.dsi.ifc.carhybrid.HybridViewOptions;
import org.dsi.ifc.carkombi.BCShortTermGeneralData;
import org.dsi.ifc.carkombi.BCStatisticsZE;
import org.dsi.ifc.carkombi.BCViewOptions;
import org.dsi.ifc.carkombi.BCZeroEmissionAbsoluteDistance;
import org.dsi.ifc.carkombi.BCZeroEmissionRelative;
import org.dsi.ifc.carkombi.DSICarKombi;
import org.dsi.ifc.cartimeunitslanguage.ClockTime;
import org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage;
import org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates;
import org.dsi.ifc.global.CarBCDistance;
import org.dsi.ifc.global.CarBCSpeed;
import org.dsi.ifc.global.CarBCTime;
import org.dsi.ifc.powermanagement.ClampSignal;
import org.dsi.ifc.powermanagement.DSIPowerManagement;

public class HsmTargetHybridMonitor
extends AbstractASLTarget
implements ConsumerListContext,
CarLogger,
DSIServiceStateListener {
    private DSICarHybrid dsiCarHybrid;
    private DSIListener dsiCarHybirdListener;
    private DSICarKombi dsiCarKombi;
    private DSIListener dsiCarKombiListener;
    private DSICarEco dsiCarEco;
    private DSIListener dsiCarEcoListener;
    private DSICarDrivingCharacteristics dsiCarFpa;
    private DSIListener dsiCarFpaListener;
    private DSICarTimeUnitsLanguage dsiCarClock;
    private DSIListener dsiCarClockListener;
    private DSIPowerManagement dsiPowerManagement;
    private DSIListener dsiPowerManagementListener;
    private CarE_TractionChargingDistanceCollector charingDistanceCollector;
    private int STEP_SIZE_TARGET_RANGE = 0;
    private int MIN_VALUE_TARGET_RANGE = 0;
    private int MAX_VALUE_TARGET_RANGE = 0;
    private boolean isClamp15Active;
    private boolean isReset = false;
    private int myBCDistance;
    private int maxRangeValue = 0;
    private static final int RANG_NOT_CALCULATED;
    private int wholeCalculatedTeppich = 0;
    private boolean activeOperationModeNotificationSet;
    private final boolean[] AVAILABLE_PROFILES_BMA = new boolean[4];
    private static final int PROFILE_BMA_E_MODE;
    private static final int PROFILE_BMA_HYBRID_AUTO;
    private static final int PROFILE_BMA_HYBRID_HOLD;
    private static final int PROFILE_BMA_HYBRID_CHARGE;
    private CarFunctionCollector[] availableState = new CarFunctionCollector[4];
    private ConsumerListRangeController _consumerListRangeController;
    private BCShortTermGeneralData data = new BCShortTermGeneralData(new CarBCDistance(), new CarBCSpeed(), new CarBCTime());
    private int sumValuesStatistic = 0;
    private int[] featureState = new int[4];
    private int FEATURESTATE_BATTERY = 0;
    private int FEATURESTATE_ENGINE = 1;
    private int FEATURESTATE_ELECTRIC = 2;
    private int FEATURESTATE_AC = 3;
    private int FEATURESTATE_NOT_SUPPORTED = -1;
    private int FEATURESTATE_INACTIVE = 0;
    private int FEATURESTATE_ACTIVE = 1;
    private static final int RECUPERATION_VALUE_TYPE_OLD;
    private static final int RECUPERATION_VALUE_TYPE_NEW;
    private RecuperationData recuperationValueTypes = null;
    private boolean isCarMoving = false;
    private static final int STATISTIC_COUNTER;
    private int counterRecoveredEnergy = 0;
    private int zeroEmissionCurrentValue = 0;
    private int oldZeroEmmissionValue = 0;
    private int currentRangeValue = -16842752;
    private int currentRangeGainValue = -16842752;
    private boolean startupCalculation = false;
    private boolean dsiSetNotificationIsDone;
    static /* synthetic */ Class class$org$dsi$ifc$careco$DSICarEcoListener;
    static /* synthetic */ Class class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates;
    static /* synthetic */ Class class$org$dsi$ifc$carhybrid$DSICarHybrid;
    static /* synthetic */ Class class$org$dsi$ifc$carhybrid$DSICarHybridListener;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$DSICarKombi;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$DSICarKombiListener;
    static /* synthetic */ Class class$org$dsi$ifc$careco$DSICarEco;
    static /* synthetic */ Class class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristics;
    static /* synthetic */ Class class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristicsListener;
    static /* synthetic */ Class class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage;
    static /* synthetic */ Class class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener;
    static /* synthetic */ Class class$org$dsi$ifc$powermanagement$DSIPowerManagement;
    static /* synthetic */ Class class$org$dsi$ifc$powermanagement$DSIPowerManagementListener;
    static /* synthetic */ Class class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener;

    private void registerOnHybridViewOptions() {
        this.dsiCarHybrid.setNotification(new int[]{1}, this.dsiCarHybirdListener);
    }

    private void registerOnEcoViewOptions() {
        this.dsiCarEco.setNotification(1, this.dsiCarEcoListener);
        ASLCarContainer.getInstance().getDSIProxy().addResponseListener(this, class$org$dsi$ifc$careco$DSICarEcoListener == null ? (class$org$dsi$ifc$careco$DSICarEcoListener = HsmTargetHybridMonitor.class$("org.dsi.ifc.careco.DSICarEcoListener")) : class$org$dsi$ifc$careco$DSICarEcoListener, ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$careco$DSICarEcoListener == null ? (class$org$dsi$ifc$careco$DSICarEcoListener = HsmTargetHybridMonitor.class$("org.dsi.ifc.careco.DSICarEcoListener")) : class$org$dsi$ifc$careco$DSICarEcoListener));
    }

    private void registerOnCarHybirdFlowCharge() {
        this.dsiCarHybrid.setNotification(new int[]{3, 2}, this.dsiCarHybirdListener);
    }

    private void clearOnCarHybirdFlowCharge() {
        this.dsiCarHybrid.clearNotification(new int[]{3, 2}, this.dsiCarHybirdListener);
    }

    private void registerOnGeneralVehicleState() {
        DSIProxy dSIProxy = ASLCarContainer.getInstance().getDSIProxy();
        dSIProxy.addServiceStateListener(class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = HsmTargetHybridMonitor.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates, this);
    }

    private void registerOnClampSignal() {
        this.dsiPowerManagement.setNotification(new int[]{4}, this.dsiPowerManagementListener);
    }

    private void registerOnClock() {
        this.dsiCarClock.setNotification(new int[]{3}, this.dsiCarClockListener);
    }

    public HsmTargetHybridMonitor(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getDefaultTargetId() {
        return -1873866240;
    }

    @Override
    public int getSubClassifier() {
        return 1;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.charingDistanceCollector = new CarE_TractionChargingDistanceCollector();
                this.initDsi();
                this.addObserver(0x220B2000);
                this.initValues();
                ServiceManager.aslPropertyManager.valueChangedInteger(10362, -1);
                this.addObservers(new int[]{-1207173056, -502595520, -1257504704, -1240727488, -1274281920});
                this.checkingEngine();
                this.readPersistenceValues();
                ServiceManager.aslPropertyManager.valueChangedInteger(10493, 0);
                ServiceManager.aslPropertyManager.valueChangedInteger(10356, 0);
                break;
            }
            case 0x200B22: {
                ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger().info(1, " HsmTargetHybridMonitor: event received ASL_CAR_HYBRID_MONITOR_REGISTER");
                this.registerOnEcoViewOptions();
                this.registerOnGeneralVehicleState();
                this.registerOnClock();
                this.registerOnClampSignal();
                this.removeObserver(0x220B2000);
                break;
            }
            case 1073745080: {
                this.setHybridMode(eventGeneric.getInt(0));
                break;
            }
            case 1073744866: {
                if (eventGeneric.getInt(0) != 8 && eventGeneric.getInt(0) != 0) break;
                this.resetBev();
                break;
            }
            case 1073745077: {
                this.deIncreaseTargetRange(false);
                break;
            }
            case 1073745078: {
                this.deIncreaseTargetRange(true);
                break;
            }
            case 1073745076: {
                this.setHybridTargetRange(eventGeneric.getInt(0));
                break;
            }
        }
    }

    private boolean isBev() {
        return this.getConsumerListRangeController().isBevVehicle();
    }

    private void setIsBev(boolean bl) {
        this.getConsumerListRangeController().setIsBevVehicle(bl);
    }

    private void initDsi() {
        DSIProxy dSIProxy = ASLCarContainer.getInstance().getDSIProxy();
        this.dsiCarHybrid = (DSICarHybrid)dSIProxy.getService(this, class$org$dsi$ifc$carhybrid$DSICarHybrid == null ? (class$org$dsi$ifc$carhybrid$DSICarHybrid = HsmTargetHybridMonitor.class$("org.dsi.ifc.carhybrid.DSICarHybrid")) : class$org$dsi$ifc$carhybrid$DSICarHybrid);
        this.dsiCarHybirdListener = ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$carhybrid$DSICarHybridListener == null ? (class$org$dsi$ifc$carhybrid$DSICarHybridListener = HsmTargetHybridMonitor.class$("org.dsi.ifc.carhybrid.DSICarHybridListener")) : class$org$dsi$ifc$carhybrid$DSICarHybridListener);
        this.dsiCarKombi = (DSICarKombi)dSIProxy.getService(this, class$org$dsi$ifc$carkombi$DSICarKombi == null ? (class$org$dsi$ifc$carkombi$DSICarKombi = HsmTargetHybridMonitor.class$("org.dsi.ifc.carkombi.DSICarKombi")) : class$org$dsi$ifc$carkombi$DSICarKombi);
        this.dsiCarKombiListener = ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$carkombi$DSICarKombiListener == null ? (class$org$dsi$ifc$carkombi$DSICarKombiListener = HsmTargetHybridMonitor.class$("org.dsi.ifc.carkombi.DSICarKombiListener")) : class$org$dsi$ifc$carkombi$DSICarKombiListener);
        this.dsiCarEco = (DSICarEco)dSIProxy.getService(this, class$org$dsi$ifc$careco$DSICarEco == null ? (class$org$dsi$ifc$careco$DSICarEco = HsmTargetHybridMonitor.class$("org.dsi.ifc.careco.DSICarEco")) : class$org$dsi$ifc$careco$DSICarEco);
        this.dsiCarEcoListener = ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$careco$DSICarEcoListener == null ? (class$org$dsi$ifc$careco$DSICarEcoListener = HsmTargetHybridMonitor.class$("org.dsi.ifc.careco.DSICarEcoListener")) : class$org$dsi$ifc$careco$DSICarEcoListener);
        this.dsiCarFpa = (DSICarDrivingCharacteristics)dSIProxy.getService(this, class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristics == null ? (class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristics = HsmTargetHybridMonitor.class$("org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics")) : class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristics);
        this.dsiCarFpaListener = ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristicsListener == null ? (class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristicsListener = HsmTargetHybridMonitor.class$("org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener")) : class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristicsListener);
        this.dsiCarClock = (DSICarTimeUnitsLanguage)dSIProxy.getService(this, class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage == null ? (class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage = HsmTargetHybridMonitor.class$("org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage")) : class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage);
        this.dsiCarClockListener = ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener == null ? (class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener = HsmTargetHybridMonitor.class$("org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener")) : class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener);
        this.dsiPowerManagement = (DSIPowerManagement)dSIProxy.getService(this, class$org$dsi$ifc$powermanagement$DSIPowerManagement == null ? (class$org$dsi$ifc$powermanagement$DSIPowerManagement = HsmTargetHybridMonitor.class$("org.dsi.ifc.powermanagement.DSIPowerManagement")) : class$org$dsi$ifc$powermanagement$DSIPowerManagement);
        this.dsiPowerManagementListener = ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$powermanagement$DSIPowerManagementListener == null ? (class$org$dsi$ifc$powermanagement$DSIPowerManagementListener = HsmTargetHybridMonitor.class$("org.dsi.ifc.powermanagement.DSIPowerManagementListener")) : class$org$dsi$ifc$powermanagement$DSIPowerManagementListener);
    }

    private void checkingEngine() {
        this.dsiCarFpa.setNotification(12, this.dsiCarFpaListener);
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(394)) {
            ServiceManager.aslPropertyManager.valueChangedBoolean(10359, true);
            this.dsiCarKombi.setNotification(4, this.dsiCarKombiListener);
            this.setIsBev(true);
        } else if (ASLSystemFactory.getSystemApi().getFeatureFlagValuePHEV()) {
            ServiceManager.aslPropertyManager.valueChangedBoolean(10359, true);
            this.dsiCarKombi.setNotification(4, this.dsiCarKombiListener);
            this.setIsBev(false);
        } else if (ASLSystemFactory.getSystemApi().getFeatureFlagValueBEV()) {
            ServiceManager.aslPropertyManager.valueChangedBoolean(10359, false);
            this.setIsBev(true);
        }
        this.registerOnHybridViewOptions();
        this.dsiCarKombi.setNotification(13, this.dsiCarKombiListener);
    }

    private void resetBev() {
        CarPersistenceData.getPersistenceService().resetData();
        this.updateRecuperationValuesToModel();
        this.counterRecoveredEnergy = 0;
        this.sumValuesStatistic = 0;
        if (this.isBev()) {
            ServiceManager.aslPropertyManager.valueChangedInteger(10355, 0);
        } else {
            ServiceManager.aslPropertyManager.valueChangedInteger(10356, 0);
        }
    }

    private void setHybridMode(int n) {
        switch (n) {
            case 0: {
                this.dsiCarFpa.setCharismaActiveOperationMode(1);
                break;
            }
            case 1: {
                this.dsiCarFpa.setCharismaActiveOperationMode(3);
                break;
            }
            case 2: {
                this.dsiCarFpa.setCharismaActiveOperationMode(4);
                break;
            }
            case 3: {
                this.dsiCarFpa.setCharismaActiveOperationMode(2);
                break;
            }
        }
    }

    private void deIncreaseTargetRange(boolean bl) {
        int n = ASLCarUtil.durationTimeMinMaxValue(bl, this.charingDistanceCollector.car_e_traction_charging_distance_value, this.STEP_SIZE_TARGET_RANGE, this.MIN_VALUE_TARGET_RANGE, this.MAX_VALUE_TARGET_RANGE);
        if (n != -1) {
            this.setHybridTargetRange(n);
        }
    }

    private void setHybridTargetRange(int n) {
        this.dsiCarHybrid.setHybridTargetRange((short)n, this.charingDistanceCollector.car_e_traction_charging_distance_unit == 0 ? 0 : 1);
    }

    public void dsiCarHybridUpdateHybridViewOptions(HybridViewOptions hybridViewOptions, int n) {
        if (hybridViewOptions.getHybridRecoveredEnergy().getState() == 2) {
            this.dsiCarHybrid.setNotification(4, this.dsiCarHybirdListener);
        } else {
            this.dsiCarHybrid.clearNotification(4, this.dsiCarHybirdListener);
            this.error().append("[ERROR] Car Hybrid Monitor: hyridRecoveredEnergy.ViewOption != NORMAL!").log();
        }
        if (hybridViewOptions.getHybridEnergyFlowState().getState() == 2 && hybridViewOptions.getHybridCharge().getState() == 2) {
            this.registerOnCarHybirdFlowCharge();
        } else {
            this.clearOnCarHybirdFlowCharge();
            this.initValues();
        }
        if (hybridViewOptions.getHybridTargetRange().getState() == 2) {
            this.dsiCarHybrid.setNotification(19, this.dsiCarHybirdListener);
        } else {
            this.dsiCarHybrid.clearNotification(19, this.dsiCarHybirdListener);
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setObject(0, hybridViewOptions);
        this.triggerObserver(789258240, eventGeneric);
    }

    public void dsiCarDrivingCharacteristicsUpdateCharismaViewOptions(CharismaViewOptions charismaViewOptions, int n) {
        if (!this.activeOperationModeNotificationSet) {
            this.dsiCarFpa.setNotification(28, this.dsiCarFpaListener);
            this.activeOperationModeNotificationSet = true;
        }
        this.AVAILABLE_PROFILES_BMA[0] = charismaViewOptions.getConfiguration().getOperationModesAvailable().isEvMode();
        this.AVAILABLE_PROFILES_BMA[1] = charismaViewOptions.getConfiguration().getOperationModesAvailable().isHybridMode();
        this.AVAILABLE_PROFILES_BMA[3] = charismaViewOptions.getConfiguration().getOperationModesAvailable().isChargingMode();
        this.AVAILABLE_PROFILES_BMA[2] = charismaViewOptions.getConfiguration().getOperationModesAvailable().isSustainingMode();
        HsmTargetHybridMonitor.writeFlagVectorToDatapool(10531, this.AVAILABLE_PROFILES_BMA);
        this.availableState[0] = new CarFunctionCollector(charismaViewOptions.getEvMode().getState() == 2, this.getReason(charismaViewOptions.getEvMode().getReason()));
        this.availableState[1] = new CarFunctionCollector(charismaViewOptions.getHybridMode().getState() == 2, this.getReason(charismaViewOptions.getHybridMode().getReason()));
        this.availableState[3] = new CarFunctionCollector(charismaViewOptions.getChargingMode().getState() == 2, this.getReason(charismaViewOptions.getChargingMode().getReason()));
        this.availableState[2] = new CarFunctionCollector(charismaViewOptions.getSustainingMode().getState() == 2, this.getReason(charismaViewOptions.getSustainingMode().getReason()));
        ListManager.getGenericASLList(10530).updateList(this.availableState);
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        this.triggerObserver(906698752, eventGeneric);
    }

    public void dsiCarDrivingCharacteristicsUpdateCharismaActiveOperationMode(int n, int n2) {
        HsmTargetHybridMonitor.writeBooleanToDatapool(10573, 6 == n);
        switch (n) {
            case 4: {
                HsmTargetHybridMonitor.writeIntegerToDatapool(10572, 2);
                break;
            }
            case 1: {
                HsmTargetHybridMonitor.writeIntegerToDatapool(10572, 0);
                break;
            }
            case 2: {
                HsmTargetHybridMonitor.writeIntegerToDatapool(10572, 3);
                break;
            }
            case 5: {
                this.info().append("HybridMonitor SOCControlMode is not implemented for activeOperationMode").log();
                break;
            }
            case 3: {
                HsmTargetHybridMonitor.writeIntegerToDatapool(10572, 1);
                break;
            }
            case 255: {
                break;
            }
            case 6: {
                HsmTargetHybridMonitor.writeBooleanToDatapool(10573, true);
                break;
            }
        }
    }

    public void dsiCarEcoUpdateBCmEConsumerListRangeUpdateInfo(BCmEListUpdateInfo bCmEListUpdateInfo, int n) {
        ServiceManager.dsiServiceLocator.clearWaitingRequests(class$org$dsi$ifc$careco$DSICarEco == null ? (class$org$dsi$ifc$careco$DSICarEco = HsmTargetHybridMonitor.class$("org.dsi.ifc.careco.DSICarEco")) : class$org$dsi$ifc$careco$DSICarEco, "requestBCmEConsumerListRange");
        this.getConsumerListRangeController().getConsumerListDsiListener().updateBCmEConsumerListRangeUpdateInfo(bCmEListUpdateInfo, n);
    }

    public void dsiCarEcoUpdateBCmEConsumerListRangeTotalNumberOfElements(int n, int n2) {
        this.getConsumerListRangeController().getConsumerListDsiListener().updateBCmEConsumerListRangeTotalNumberOfElements(n, n2);
    }

    public void dsiCarEcoResponseBCmEConsumerListRangeRA0(BCmEListUpdateInfo bCmEListUpdateInfo, BCmEConsumerListRangeRA0[] bCmEConsumerListRangeRA0Array) {
        this.getConsumerListRangeController().getConsumerListDsiListener().responseBCmEConsumerListRangeRA0(bCmEListUpdateInfo, bCmEConsumerListRangeRA0Array);
    }

    public void dsiCarEcoResponseBCmEConsumerListRangeRA1(BCmEListUpdateInfo bCmEListUpdateInfo, BCmEConsumerListRangeRA1[] bCmEConsumerListRangeRA1Array) {
        this.getConsumerListRangeController().getConsumerListDsiListener().responseBCmEConsumerListRangeRA1(bCmEListUpdateInfo, bCmEConsumerListRangeRA1Array);
    }

    public void dsiCarEcoResponseBCmEConsumerListRangeRA2(BCmEListUpdateInfo bCmEListUpdateInfo, BCmEConsumerListRangeRA2[] bCmEConsumerListRangeRA2Array) {
        this.getConsumerListRangeController().getConsumerListDsiListener().responseBCmEConsumerListRangeRA2(bCmEListUpdateInfo, bCmEConsumerListRangeRA2Array);
    }

    public void dsiCarEcoResponseBCmEConsumerListRangeRAF(BCmEListUpdateInfo bCmEListUpdateInfo, int[] nArray) {
        this.getConsumerListRangeController().getConsumerListDsiListener().responseBCmEConsumerListRangeRAF(bCmEListUpdateInfo, nArray);
    }

    public void dsiCarKombiUpdateBCViewOptions(BCViewOptions bCViewOptions, int n) {
        if (bCViewOptions.getStatisticsDistanceCurrentIntervallZE().getState() == 2) {
            this.dsiCarKombi.setNotification(new int[]{54, 58}, this.dsiCarKombiListener);
        } else {
            this.dsiCarKombi.clearNotification(new int[]{54, 58}, this.dsiCarKombiListener);
            this.error().append("[ERROR] Car Hybrid Monitor: statisticsTimeCurrentPeriodZE.ViewOption != NORMAL");
        }
    }

    public void dsiCarHybridUpdateHybridEnergyFlowState(HybridEnergyFlowState hybridEnergyFlowState, int n) {
        switch (hybridEnergyFlowState.getMotionState()) {
            case 1: 
            case 2: 
            case 4: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10349, 0);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10349, 1);
                break;
            }
        }
        switch (hybridEnergyFlowState.getBatteryState()) {
            case 0: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10351, 0);
                this.featureState[this.FEATURESTATE_ELECTRIC] = this.FEATURESTATE_INACTIVE;
                break;
            }
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10351, 0);
                this.featureState[this.FEATURESTATE_ELECTRIC] = this.FEATURESTATE_INACTIVE;
                break;
            }
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10351, 0);
                this.featureState[this.FEATURESTATE_ELECTRIC] = this.FEATURESTATE_INACTIVE;
                break;
            }
            case 2: {
                if (hybridEnergyFlowState.getMotionState() != 4) {
                    ServiceManager.aslPropertyManager.valueChangedInteger(10351, 1);
                    this.featureState[this.FEATURESTATE_ELECTRIC] = this.FEATURESTATE_ACTIVE;
                    break;
                }
                ServiceManager.aslPropertyManager.valueChangedInteger(10351, 0);
                this.featureState[this.FEATURESTATE_ELECTRIC] = this.FEATURESTATE_INACTIVE;
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10351, 0);
                this.featureState[this.FEATURESTATE_ELECTRIC] = this.FEATURESTATE_INACTIVE;
                break;
            }
            case 4: {
                if (hybridEnergyFlowState.getMotionState() != 4 && hybridEnergyFlowState.getEe1State() == 3) {
                    ServiceManager.aslPropertyManager.valueChangedInteger(10351, 2);
                    this.featureState[this.FEATURESTATE_ELECTRIC] = this.FEATURESTATE_ACTIVE;
                    break;
                }
                ServiceManager.aslPropertyManager.valueChangedInteger(10351, 0);
                this.featureState[this.FEATURESTATE_ELECTRIC] = this.FEATURESTATE_INACTIVE;
                break;
            }
        }
        switch (hybridEnergyFlowState.getTorqueState()) {
            case 0: 
            case 1: 
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10349, 0);
                ServiceManager.aslPropertyManager.valueChangedInteger(10347, 0);
                break;
            }
            case 3: {
                if (hybridEnergyFlowState.getMotionState() != 4 && hybridEnergyFlowState.getMotionState() != 2) {
                    ServiceManager.aslPropertyManager.valueChangedInteger(10349, 1);
                    ServiceManager.aslPropertyManager.valueChangedInteger(10347, 4);
                    break;
                }
                ServiceManager.aslPropertyManager.valueChangedInteger(10349, 0);
                ServiceManager.aslPropertyManager.valueChangedInteger(10347, 0);
                break;
            }
            case 4: {
                if (hybridEnergyFlowState.getMotionState() != 4 && hybridEnergyFlowState.getMotionState() != 2) {
                    ServiceManager.aslPropertyManager.valueChangedInteger(10349, 1);
                    switch (hybridEnergyFlowState.getEe1State()) {
                        case 3: {
                            ServiceManager.aslPropertyManager.valueChangedInteger(10347, 1);
                            break;
                        }
                    }
                    switch (hybridEnergyFlowState.getICEState()) {
                        case 4: {
                            if (hybridEnergyFlowState.getMotionState() == 2) break;
                            ServiceManager.aslPropertyManager.valueChangedInteger(10347, 2);
                            break;
                        }
                    }
                    if (hybridEnergyFlowState.getICEState() == 4 || hybridEnergyFlowState.getEe1State() == 3) break;
                    ServiceManager.aslPropertyManager.valueChangedInteger(10347, 0);
                    break;
                }
                ServiceManager.aslPropertyManager.valueChangedInteger(10349, 0);
                break;
            }
            case 6: {
                if (hybridEnergyFlowState.getMotionState() != 4 && hybridEnergyFlowState.getMotionState() != 2) {
                    ServiceManager.aslPropertyManager.valueChangedInteger(10349, 1);
                    ServiceManager.aslPropertyManager.valueChangedInteger(10347, 3);
                    break;
                }
                ServiceManager.aslPropertyManager.valueChangedInteger(10349, 0);
                ServiceManager.aslPropertyManager.valueChangedInteger(10347, 0);
                break;
            }
            case 5: {
                if (hybridEnergyFlowState.getMotionState() == 2) {
                    ServiceManager.aslPropertyManager.valueChangedInteger(10349, 0);
                    break;
                }
                ServiceManager.aslPropertyManager.valueChangedInteger(10347, 5);
                break;
            }
        }
        switch (hybridEnergyFlowState.getICEState()) {
            case 0: {
                this.featureState[this.FEATURESTATE_ENGINE] = this.FEATURESTATE_NOT_SUPPORTED;
                break;
            }
            case 1: 
            case 2: {
                this.featureState[this.FEATURESTATE_ENGINE] = this.FEATURESTATE_INACTIVE;
                break;
            }
            case 3: 
            case 4: 
            case 5: {
                this.featureState[this.FEATURESTATE_ENGINE] = this.FEATURESTATE_ACTIVE;
                break;
            }
        }
        this.featureState[this.FEATURESTATE_AC] = hybridEnergyFlowState.getSinkState().isInstallation() ? (hybridEnergyFlowState.getSinkState().isCooling() || hybridEnergyFlowState.getSinkState().isHeating() ? this.FEATURESTATE_ACTIVE : this.FEATURESTATE_INACTIVE) : this.FEATURESTATE_NOT_SUPPORTED;
        this.informingEnergyFlowStates();
    }

    public void dsiCarHybridUpdateHybridCharge(int n, int n2) {
        ServiceManager.aslPropertyManager.valueChangedInteger(10350, n);
    }

    public void dsiCarHybridUpdateHybridRecoveredEnergy(int n, int n2) {
        if (this.isCarMoving) {
            this.sumValuesStatistic = ServiceManager.configManagerDiag.isFeatureFlagSet(394) ? (this.sumValuesStatistic += n / 5) : (this.sumValuesStatistic += n / 10);
        }
        ServiceManager.aslPropertyManager.valueChangedInteger(10355, this.sumValuesStatistic);
    }

    public void dsiCarKombiUpdateBCStatisticsDistanceCurrentIntervalZE(BCZeroEmissionRelative bCZeroEmissionRelative, BCZeroEmissionAbsoluteDistance bCZeroEmissionAbsoluteDistance, int n) {
        if (bCZeroEmissionRelative.getState() == 1 && bCZeroEmissionRelative.getValue() <= 100) {
            this.zeroEmissionCurrentValue = bCZeroEmissionRelative.getValue();
            if (!this.startupCalculation && this.isClamp15Active) {
                this.startupCalculation = true;
                this.dsiCarKombiUpdateBCShortTermGeneral(this.data, n);
            }
        }
    }

    public void dsiCarKombiUpdateBCStatisticsDistanceZE(BCStatisticsZE bCStatisticsZE, BCZeroEmissionAbsoluteDistance bCZeroEmissionAbsoluteDistance, int n) {
        if (bCStatisticsZE.getZeroEmissionRelative().getState() == 1) {
            this.sumValuesStatistic = bCStatisticsZE.getZeroEmissionRelative().getValue();
            this.calculateStatistic();
        }
    }

    public void dsiCarEcoUpdateBCmEViewOptions(BCmEViewOptions bCmEViewOptions, int n) {
        if (bCmEViewOptions.getCurrentRange().getState() == 2) {
            this.getConsumerListRangeController().setListAvailable(true);
            if (!this.dsiSetNotificationIsDone) {
                this.dsiSetNotificationIsDone = true;
                this.dsiCarEco.setNotification(new int[]{38, 37, 41, 46, 45}, this.dsiCarEcoListener);
            }
        } else {
            this.getConsumerListRangeController().setListAvailable(false);
            if (this.dsiSetNotificationIsDone) {
                this.dsiSetNotificationIsDone = false;
                this.dsiCarEco.clearNotification(new int[]{38, 37, 41, 46, 45}, this.dsiCarEcoListener);
                ServiceManager.aslPropertyManager.valueChangedInteger(10361, -1);
                ServiceManager.aslPropertyManager.valueChangedInteger(10364, 0);
            }
        }
        ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger().info(1, new StringBuffer().append(" HsmTargetHybridMonitor: UpdateBCmEViewOptions( BCmEViewOptions viewOptions, int validFlag): ").append(bCmEViewOptions).toString());
        if (2 == bCmEViewOptions.getCurrentRange().getState()) {
            HsmTargetHybridMonitor.writeBooleanToDatapool(10847, true);
        } else {
            HsmTargetHybridMonitor.writeBooleanToDatapool(10847, false);
        }
    }

    public void dsiCarEcoUpdateBCmECurrentRange(BCmECurrentRange bCmECurrentRange, int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(10496, bCmECurrentRange.getRangeUnit() == 0 ? 0 : 1);
        if (this.isBev()) {
            this.currentRangeValue = bCmECurrentRange.getRangeValuePrimary();
            this.currentRangeGainValue = bCmECurrentRange.getRangeGainValuePrimary();
        } else {
            this.currentRangeValue = bCmECurrentRange.getRangeValueSecondary();
            this.currentRangeGainValue = bCmECurrentRange.getRangeGainValueSecondary();
        }
        this.calculateTeppich();
    }

    public void dsiCarEcoUpdateBCmECatalogueRange(int n, int n2, int n3, int n4) {
        this.maxRangeValue = n >= -16842752 ? -1 : n;
        this.evaluateMaxRange();
    }

    private void calculateTeppich(int n, int n2) {
        if (n >= -16842752 && n2 >= -16842752) {
            ServiceManager.aslPropertyManager.valueChangedInteger(10364, 0);
        } else {
            ServiceManager.aslPropertyManager.valueChangedInteger(10364, this.maxRangeValue);
        }
        n = n >= -16842752 ? -1 : n;
        n2 = n2 >= -16842752 ? -1 : n2;
        ServiceManager.aslPropertyManager.valueChangedInteger(10363, n == -1 ? 0 : n);
        ServiceManager.aslPropertyManager.valueChangedInteger(10361, n2);
        this.wholeCalculatedTeppich = n == -1 && n2 == -1 ? 0 : n + n2;
        ServiceManager.aslPropertyManager.valueChangedInteger(10365, this.wholeCalculatedTeppich);
        this.evaluateMaxRange();
        ServiceManager.aslPropertyManager.valueChangedInteger(10362, n);
    }

    private void calculateTeppich() {
        this.calculateTeppich(this.currentRangeValue, this.currentRangeGainValue);
    }

    private void evaluateMaxRange() {
        if (this.wholeCalculatedTeppich != 0 && this.maxRangeValue != -1) {
            if (this.maxRangeValue < this.wholeCalculatedTeppich) {
                ServiceManager.aslPropertyManager.valueChangedInteger(10364, this.wholeCalculatedTeppich);
            } else {
                ServiceManager.aslPropertyManager.valueChangedInteger(10364, this.maxRangeValue);
            }
        }
    }

    public void dsiCarEcoUpdateBCmECurrentRangeSOC(int n, int n2, int n3, int n4) {
        ServiceManager.aslPropertyManager.valueChangedInteger(10528, n >= -16842752 ? -1 : n);
    }

    public void dsiGeneralVehicleStatesUpdateCarVelocityThreshold(boolean bl, int n) {
        this.isCarMoving = bl;
    }

    public void dsiCarHybridUpdateHybridTargetRange(HybridTargetRange hybridTargetRange, int n) {
        if (hybridTargetRange.getRangeUnit() == 0) {
            this.STEP_SIZE_TARGET_RANGE = 5;
            this.MIN_VALUE_TARGET_RANGE = 50;
            this.MAX_VALUE_TARGET_RANGE = 150;
        } else {
            this.STEP_SIZE_TARGET_RANGE = 5;
            this.MIN_VALUE_TARGET_RANGE = 30;
            this.MAX_VALUE_TARGET_RANGE = 90;
        }
        if (hybridTargetRange.getRange() >= this.MIN_VALUE_TARGET_RANGE && hybridTargetRange.getRange() <= this.MAX_VALUE_TARGET_RANGE) {
            this.charingDistanceCollector.car_e_traction_charging_distance_unit = hybridTargetRange.getRangeUnit() == 0 ? 0 : 1;
            this.charingDistanceCollector.car_e_traction_charging_distance_value = hybridTargetRange.getRange();
            ListManager.getGenericASLList(10376).updateList(new CarE_TractionChargingDistanceCollector[]{this.charingDistanceCollector});
        } else {
            hybridTargetRange.range = (short)(Math.round((double)hybridTargetRange.getRange() / 10.0) * 0);
            if (hybridTargetRange.getRange() < this.MIN_VALUE_TARGET_RANGE) {
                hybridTargetRange.range = (short)this.MIN_VALUE_TARGET_RANGE;
            }
            if (hybridTargetRange.getRange() > this.MAX_VALUE_TARGET_RANGE) {
                hybridTargetRange.range = (short)this.MAX_VALUE_TARGET_RANGE;
            }
            this.dsiCarHybrid.setHybridTargetRange(hybridTargetRange.range, hybridTargetRange.getRangeUnit());
        }
    }

    public void dsiCarTimeUnitsLanguageUpdateClockTime(ClockTime clockTime, int n) {
        if (this.isCarMoving) {
            ++this.counterRecoveredEnergy;
            if (60 == this.counterRecoveredEnergy) {
                this.counterRecoveredEnergy = 0;
                this.calculateStatistic();
            }
        }
    }

    public void dsiPowerManagementUpdateClampSignal(ClampSignal clampSignal, int n) {
        this.isClamp15Active = clampSignal.isClamp15();
        if (this.isClamp15Active) {
            this.featureState[this.FEATURESTATE_BATTERY] = this.FEATURESTATE_ACTIVE;
            ServiceManager.aslPropertyManager.valueChangedInteger(10493, this.oldZeroEmmissionValue);
            ServiceManager.aslPropertyManager.valueChangedInteger(10356, this.zeroEmissionCurrentValue);
            ServiceManager.aslPropertyManager.valueChangedInteger(10492, this.myBCDistance);
            this.calculateTeppich();
            if (!this.startupCalculation && this.zeroEmissionCurrentValue > 0) {
                this.startupCalculation = true;
                this.dsiCarKombiUpdateBCShortTermGeneral(this.data, n);
            }
        } else {
            this.featureState[this.FEATURESTATE_BATTERY] = this.FEATURESTATE_INACTIVE;
            ServiceManager.aslPropertyManager.valueChangedInteger(10356, -1);
            ServiceManager.aslPropertyManager.valueChangedInteger(10355, -1);
        }
        this.informingEnergyFlowStates();
    }

    private void updateRecuperationValuesToModel() {
        ServiceManager.aslPropertyManager.valueChangedBoolean(10373, true);
        if (this.isBev()) {
            ServiceManager.aslPropertyManager.valueChangedIntegerArray(10357, CarPersistenceData.getPersistenceService().getRecuperationValues());
        } else {
            ServiceManager.aslPropertyManager.valueChangedIntegerArray(10483, CarPersistenceData.getPersistenceService().getRecuperationValues());
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(10373, false);
        if (this.isBev()) {
            ServiceManager.aslPropertyManager.valueChangedIntegerArray(10358, this.recuperationValueTypes.getData());
            ServiceManager.aslPropertyManager.valueChangedInteger(10355, this.sumValuesStatistic);
        }
    }

    private void calculateStatistic() {
        int n = this.sumValuesStatistic;
        CarPersistenceData.getPersistenceService().addRecuperationValue(n);
        this.recuperationValueTypes.addValue(0);
        this.sumValuesStatistic = 0;
        this.updateRecuperationValuesToModel();
    }

    private void initValues() {
        this.featureState[this.FEATURESTATE_ENGINE] = this.FEATURESTATE_INACTIVE;
        this.featureState[this.FEATURESTATE_ELECTRIC] = this.FEATURESTATE_INACTIVE;
        this.featureState[this.FEATURESTATE_AC] = this.FEATURESTATE_NOT_SUPPORTED;
        this.informingEnergyFlowStates();
    }

    private void readPersistenceValues() {
        CarPersistenceData.getPersistenceService();
        this.recuperationValueTypes = new RecuperationData(1);
        this.updateRecuperationValuesToModel();
        if (this.isBev()) {
            ServiceManager.aslPropertyManager.valueChangedInteger(10355, this.sumValuesStatistic);
        }
    }

    public void dsiCarKombiUpdateBCShortTermGeneral(BCShortTermGeneralData bCShortTermGeneralData, int n) {
        this.data = bCShortTermGeneralData;
        if (bCShortTermGeneralData.getTimeValue().getTimeValue() == 0 && bCShortTermGeneralData.getTimeValue().getState() == 1 && this.isReset) {
            this.recuperationValueTypes.resetAllData(1);
            ServiceManager.aslPropertyManager.valueChangedIntegerArray(10358, this.recuperationValueTypes.getData());
            ServiceManager.aslPropertyManager.valueChangedIntegerArray(10358, this.recuperationValueTypes.getData());
            this.oldZeroEmmissionValue = -1;
            this.zeroEmissionCurrentValue = -1;
            ServiceManager.aslPropertyManager.valueChangedInteger(10493, 0);
            ServiceManager.aslPropertyManager.valueChangedInteger(10356, -1);
            this.isReset = false;
        } else if (bCShortTermGeneralData.getTimeValue().getTimeValue() > 0 && bCShortTermGeneralData.getTimeValue().getState() == 1) {
            this.isReset = true;
        }
        if (bCShortTermGeneralData.getDistance().getDistanceValueState() == 1) {
            this.myBCDistance = (int)bCShortTermGeneralData.getDistance().getDistanceValue();
            ServiceManager.aslPropertyManager.valueChangedInteger(10492, this.myBCDistance);
            if (bCShortTermGeneralData.getDistance().getDistanceValue() > 0.0 && this.zeroEmissionCurrentValue != -1) {
                this.calculateZeroEmmission(bCShortTermGeneralData.getDistance().getDistanceValue());
            }
        }
        if (bCShortTermGeneralData.getDistance().distanceValueState == 1) {
            ServiceManager.aslPropertyManager.valueChangedInteger(10495, bCShortTermGeneralData.getDistance().getDistanceUnit() == 0 ? 0 : 1);
        }
    }

    private void informingEnergyFlowStates() {
        ServiceManager.aslPropertyManager.valueChangedIntegerArray(10348, new int[]{this.featureState[this.FEATURESTATE_BATTERY], this.featureState[this.FEATURESTATE_ENGINE], this.featureState[this.FEATURESTATE_ELECTRIC], this.featureState[this.FEATURESTATE_AC]});
    }

    private void calculateZeroEmmission(double d2) {
        int n = (int)d2 * this.zeroEmissionCurrentValue / 100;
        if (n > this.oldZeroEmmissionValue) {
            this.oldZeroEmmissionValue = n;
            ServiceManager.aslPropertyManager.valueChangedInteger(10493, this.oldZeroEmmissionValue);
        }
        ServiceManager.aslPropertyManager.valueChangedInteger(10356, this.zeroEmissionCurrentValue);
    }

    private int getReason(int n) {
        switch (n) {
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
                return 4;
            }
            case 8: {
                return 5;
            }
            case 30: {
                return 6;
            }
            case 31: {
                return 7;
            }
        }
        return 1;
    }

    @Override
    public CarLogger getCarLogger() {
        return this;
    }

    @Override
    public DSICarEco getDsiCarEco() {
        return this.dsiCarEco;
    }

    private ConsumerListRangeController getConsumerListRangeController() {
        if (this._consumerListRangeController == null) {
            this._consumerListRangeController = new ConsumerListRangeController(this);
        }
        return this._consumerListRangeController;
    }

    @Override
    public ConsumerListController getConsumerListController(int n) {
        ConsumerListRangeController consumerListRangeController;
        switch (n) {
            case 2: {
                consumerListRangeController = this.getConsumerListRangeController();
                break;
            }
            default: {
                throw new UnsupportedOperationException();
            }
        }
        return consumerListRangeController;
    }

    @Override
    public void registered(String string, int n) {
        try {
            if ((class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = HsmTargetHybridMonitor.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates).getName().equals(string)) {
                DSIGeneralVehicleStates dSIGeneralVehicleStates = (DSIGeneralVehicleStates)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = HsmTargetHybridMonitor.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates);
                dSIGeneralVehicleStates.setNotification(new int[]{7}, ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener = HsmTargetHybridMonitor.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener));
            }
        }
        catch (Throwable throwable) {
            this.warn("Could not connect to DSIGeneralVehicleStates");
        }
    }

    @Override
    public void unregistered(String string, int n) {
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


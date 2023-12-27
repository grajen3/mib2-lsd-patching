/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.bordcomputer;

import de.vw.mib.asl.api.car.bordcomputer.BordComputerService;
import de.vw.mib.asl.api.car.bordcomputer.BordComputerServiceListener;
import de.vw.mib.asl.api.car.logger.CarLogger;
import de.vw.mib.asl.car.persistence.CarOffroad;
import de.vw.mib.asl.car.persistence.CarPersistenceServiceImpl;
import de.vw.mib.asl.carearly.persistence.CarEarly;
import de.vw.mib.asl.carearly.persistence.CarEarlyPersistenceServiceImpl;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.car.ASLCarContainer;
import de.vw.mib.asl.internal.car.ASLCarUtil;
import de.vw.mib.asl.internal.car.bordcomputer.arrays.consumer.ConsumerController;
import de.vw.mib.asl.internal.car.bordcomputer.arrays.consumerlistcommon.ConsumerListContext;
import de.vw.mib.asl.internal.car.bordcomputer.arrays.consumerlistcommon.ConsumerListController;
import de.vw.mib.asl.internal.car.bordcomputer.arrays.consumerlistconsumption.ConsumerListConsumptionController;
import de.vw.mib.asl.internal.car.bordcomputer.transformer.CarBCMenuValueHolder;
import de.vw.mib.asl.internal.car.framework.services.ServiceFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.car.bordcomputer.transformer.CarBordComputerEcoComfortConsumptionCollector;
import generated.de.vw.mib.asl.internal.car.transformer.CarCompassInfoCollector;
import java.util.ArrayList;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.careco.BCmEConsumerList;
import org.dsi.ifc.careco.BCmEConsumerListConsumptionRA0;
import org.dsi.ifc.careco.BCmEConsumerListConsumptionRA1;
import org.dsi.ifc.careco.BCmEListUpdateInfo;
import org.dsi.ifc.careco.BCmEViewOptions;
import org.dsi.ifc.careco.DSICarEco;
import org.dsi.ifc.carkombi.BCCycleGeneralData;
import org.dsi.ifc.carkombi.BCLongTermGeneralData;
import org.dsi.ifc.carkombi.BCMenueConfiguration;
import org.dsi.ifc.carkombi.BCShortTermGeneralData;
import org.dsi.ifc.carkombi.BCTankLevel;
import org.dsi.ifc.carkombi.BCViewOptions;
import org.dsi.ifc.carkombi.DSICarKombi;
import org.dsi.ifc.carkombi.DSICarKombiListener;
import org.dsi.ifc.carkombi.HUDContent;
import org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage;
import org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener;
import org.dsi.ifc.carvehiclestates.DSICarVehicleStates;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoHighFrequent;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoHighFrequentViewOptions;
import org.dsi.ifc.global.CarBCConsumption;
import org.dsi.ifc.global.CarBCCurrentRange;
import org.dsi.ifc.global.CarBCDistance;
import org.dsi.ifc.global.CarBCSpeed;
import org.dsi.ifc.global.CarBCTemperature;
import org.dsi.ifc.global.CarBCTime;
import org.dsi.ifc.global.CarViewOption;

public class ASLCarBordComputerHsmTarget
extends AbstractASLTarget
implements ConsumerListContext,
CarLogger,
BordComputerService {
    private static final int TEMPERATURE_FAHRENHEIT_OIL_MAX;
    private static final int TEMPERATURE_FAHRENHEIT_OIL_MIN;
    private static final int TEMPERATURE_FAHRENHEIT_COOLANT_MAX;
    private static final int TEMPERATURE_FAHRENHEIT_COOLANT_MIN;
    private static final int TEMPERATURE_CELCIUS_OIL_MAX;
    private static final int TEMPERATURE_CELCIUS_OIL_MIN;
    private static final int TEMPERATURE_CELCIUS_COOLANT_MAX;
    private static final int TEMPERATURE_CELCIUS_COOLANT_MIN;
    private static final int STEERING_WHEEL_DIVISION_FACTOR;
    private DSICarKombi dsiCarKombi;
    private DSICarKombiListener dsiCarkombiListener;
    private DSICarEco dsiCarEco;
    private DSICarVehicleStates dsiCarVehicleState;
    private DSICarTimeUnitsLanguage dsiCarTimeUnitsLanguage;
    private DSICarTimeUnitsLanguageListener dsiCarTimeUnitsLanguageListener;
    private DSIListener dsiEcoListener;
    private DSIListener dsiCarVehicleStateListener;
    private static int MAX_VALUE_INT_BC;
    private static double MAX_VALUE_DOUBLE_BC;
    private Boolean[] toggleDisplayConfiguration;
    private static final int BC_MENUE_ALL;
    private static final int BC_MENUE_SHORT;
    private static final int BC_MENUE_LONG_TERM;
    private CarBordComputerEcoComfortConsumptionCollector consumptionValues;
    private CarBordComputerEcoComfortConsumptionCollector[] consumptionValueHMI;
    private BCMenueConfiguration bcConfiguration;
    private boolean currentFuelConsumption = false;
    private boolean averageFuelConsumption = false;
    private boolean refuelAmount = false;
    private boolean ecoComfort = false;
    private boolean ecoLifeTips = false;
    private boolean rideTime = false;
    private boolean rideDistance = false;
    private boolean averageSpeed = false;
    private boolean digitalSpeed = false;
    private boolean speedWarn = false;
    private boolean oilTemp = false;
    private boolean towBarLoad = false;
    private boolean tempCoolAgent = false;
    private boolean displaySignAssist = false;
    private static final int SLOT_NUMBER_P0_BEFORE_DOT;
    private static final int SLOT_NUMBER_P1_AFTER_DOT;
    private static final int PRECISION;
    private CarBCMenuValueHolder[] BCMENU1_COLLECTOR;
    private CarBCMenuValueHolder[] BCMENU2_COLLECTOR;
    private CarBCMenuValueHolder[] BCMENU3_COLLECTOR;
    private CarBCMenuValueHolder[] BCMENU1_BI_COLLECTOR;
    private CarBCMenuValueHolder[] BCMENU2_BI_COLLECTOR;
    private CarBCMenuValueHolder[] BCMENU3_BI_COLLECTOR;
    private ArrayList BCMENU1_COLLECTOR_CLIENT;
    private ArrayList BCMENU2_COLLECTOR_CLIENT;
    private ArrayList BCMENU3_COLLECTOR_CLIENT;
    private Boolean[] CURRENTDISPLAYCONFIGURATION;
    private int HUD_BRIGTHNESS_VALUE;
    private int duration;
    private Boolean[] hudContent;
    private HUDContent currentContent;
    private CarBCCurrentRange primaryEngine;
    private CarBCCurrentRange secondaryEngine;
    private boolean isRegistered = false;
    private int colourDesign;
    private boolean startUp;
    private BCCycleGeneralData data;
    private int currentDsiWheelAngle;
    private boolean dynamicVehicleInfoHighFrequentNotificationSet;
    private ConsumerController _consumerListController;
    private ConsumerListConsumptionController _consumerListConsuptionController;
    private int currentAstaState = 0;
    private int tankLevel1 = 100;
    private int tankLevel2 = 100;
    BCViewOptions bcViewOptions;
    private int currentDistanceUnit = 1;
    private int currentMaxConsuptionValue = -1;
    private int currentConsumptionQuanto = 50;
    private int lowerBound = 0;
    private int upperBound = 0;
    private int currentConsumptionUnit = -1;
    private int oldConsumptionValue = 0;
    private int currentConsumptionMaxValue = -1;
    DSIProxy dsiProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
    private int currentSteeringWheelAngle;
    private boolean dsiOilNotificationDone;
    private boolean dsiCoolantNotificationDone;
    private boolean tankLevel1Available;
    private int primaryEngineType;
    private int secondaryEngineType;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$DSICarKombi;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$DSICarKombiListener;
    static /* synthetic */ Class class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage;
    static /* synthetic */ Class class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener;
    static /* synthetic */ Class class$org$dsi$ifc$careco$DSICarEcoListener;
    static /* synthetic */ Class class$org$dsi$ifc$careco$DSICarEco;
    static /* synthetic */ Class class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates;
    static /* synthetic */ Class class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$bordcomputer$BordComputerService;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$bordcomputer$BordComputerServiceListener;

    public ASLCarBordComputerHsmTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getSubClassifier() {
        return 1;
    }

    @Override
    public int getDefaultTargetId() {
        return -1957752320;
    }

    private void registerOnModelEvents() {
        this.addObservers(new int[]{671940672, -485818304, -469041088, 957153344, -284426176, -267648960, -435486656, 1510801472, 1426915392, 1474376448, 755703808, -301203392});
    }

    private void registerOnKombi() {
        this.dsiCarKombi = (DSICarKombi)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$carkombi$DSICarKombi == null ? (class$org$dsi$ifc$carkombi$DSICarKombi = ASLCarBordComputerHsmTarget.class$("org.dsi.ifc.carkombi.DSICarKombi")) : class$org$dsi$ifc$carkombi$DSICarKombi);
        this.dsiCarkombiListener = (DSICarKombiListener)ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$carkombi$DSICarKombiListener == null ? (class$org$dsi$ifc$carkombi$DSICarKombiListener = ASLCarBordComputerHsmTarget.class$("org.dsi.ifc.carkombi.DSICarKombiListener")) : class$org$dsi$ifc$carkombi$DSICarKombiListener);
        this.dsiCarKombi.setNotification(new int[]{4, 11, 12, 13, 14, 15, 16, 17, 18, 19, 27, 28, 29, 8, 9, 30, 94, 31, 22, 21, 42, 43, 39, 40, 23, 24, 81}, (DSIListener)this.dsiCarkombiListener);
    }

    private void registerOnTimeUnitsLanguage() {
        this.dsiCarTimeUnitsLanguage = (DSICarTimeUnitsLanguage)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage == null ? (class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage = ASLCarBordComputerHsmTarget.class$("org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage")) : class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage);
        this.dsiCarTimeUnitsLanguageListener = (DSICarTimeUnitsLanguageListener)ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener == null ? (class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener = ASLCarBordComputerHsmTarget.class$("org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener")) : class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener);
        this.dsiCarTimeUnitsLanguage.setNotification(new int[]{13}, (DSIListener)this.dsiCarTimeUnitsLanguageListener);
    }

    private void registerOnEcoViewOptions() {
        this.isRegistered = true;
        this.dsiCarEco.setNotification(new int[]{1, 3}, this.dsiEcoListener);
        ASLCarContainer.getInstance().getDSIProxy().addResponseListener(this, class$org$dsi$ifc$careco$DSICarEcoListener == null ? (class$org$dsi$ifc$careco$DSICarEcoListener = ASLCarBordComputerHsmTarget.class$("org.dsi.ifc.careco.DSICarEcoListener")) : class$org$dsi$ifc$careco$DSICarEcoListener, this.dsiEcoListener);
        ASLCarContainer.getInstance().getDSIProxy().addResponseListener(this, class$org$dsi$ifc$careco$DSICarEcoListener == null ? (class$org$dsi$ifc$careco$DSICarEcoListener = ASLCarBordComputerHsmTarget.class$("org.dsi.ifc.careco.DSICarEcoListener")) : class$org$dsi$ifc$careco$DSICarEcoListener, ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$careco$DSICarEcoListener == null ? (class$org$dsi$ifc$careco$DSICarEcoListener = ASLCarBordComputerHsmTarget.class$("org.dsi.ifc.careco.DSICarEcoListener")) : class$org$dsi$ifc$careco$DSICarEcoListener));
    }

    private void registerOnEcoConsumersListConsumption() {
        this.dsiCarEco.setNotification(new int[]{34, 40}, this.dsiEcoListener);
    }

    private void registerOnEco() {
        this.dsiCarEco.setNotification(new int[]{2, 39}, this.dsiEcoListener);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.dsiCarEco = (DSICarEco)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$careco$DSICarEco == null ? (class$org$dsi$ifc$careco$DSICarEco = ASLCarBordComputerHsmTarget.class$("org.dsi.ifc.careco.DSICarEco")) : class$org$dsi$ifc$careco$DSICarEco);
                this.dsiCarVehicleState = (DSICarVehicleStates)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates == null ? (class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates = ASLCarBordComputerHsmTarget.class$("org.dsi.ifc.carvehiclestates.DSICarVehicleStates")) : class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates);
                this.dsiEcoListener = ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$careco$DSICarEcoListener == null ? (class$org$dsi$ifc$careco$DSICarEcoListener = ASLCarBordComputerHsmTarget.class$("org.dsi.ifc.careco.DSICarEcoListener")) : class$org$dsi$ifc$careco$DSICarEcoListener);
                this.dsiCarVehicleStateListener = ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener == null ? (class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener = ASLCarBordComputerHsmTarget.class$("org.dsi.ifc.carvehiclestates.DSICarVehicleStatesListener")) : class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener);
                this.consumptionValues = new CarBordComputerEcoComfortConsumptionCollector();
                this.consumptionValueHMI = new CarBordComputerEcoComfortConsumptionCollector[]{this.consumptionValues};
                this.bcConfiguration = new BCMenueConfiguration();
                this.hudContent = new Boolean[11];
                this.currentContent = new HUDContent();
                this.primaryEngine = new CarBCCurrentRange();
                this.secondaryEngine = new CarBCCurrentRange();
                this.toggleDisplayConfiguration = new Boolean[14];
                this.registerOnModelEvents();
                this.registerOnKombi();
                this.registerOnVehicleDsi();
                this.registerOnTimeUnitsLanguage();
                this.initPrivateDPPropertyValues();
                ServiceFactory.getInstance().getServiceProviderRegistry().registerServiceProvider(class$de$vw$mib$asl$api$car$bordcomputer$BordComputerService == null ? (class$de$vw$mib$asl$api$car$bordcomputer$BordComputerService = ASLCarBordComputerHsmTarget.class$("de.vw.mib.asl.api.car.bordcomputer.BordComputerService")) : class$de$vw$mib$asl$api$car$bordcomputer$BordComputerService, this);
                break;
            }
            case 2100013: {
                if (!eventGeneric.getBoolean(0)) break;
                this.info().append("BC: ViewOptions Eco").append(this.isRegistered).log();
                if (this.isRegistered) break;
                this.registerOnEcoViewOptions();
                break;
            }
            case 1073745192: {
                if (this.isTraceEnabled()) {
                    this.trace().append("toggle kombi display configuration");
                }
                this.toggleKombiDisplayConfiguration(eventGeneric.getInt(0));
                break;
            }
            case 1073744867: {
                if (this.isTraceEnabled()) {
                    this.trace().append("ASL ACTION: resetBCMenue_1").log();
                }
                this.dsiCarKombi.resetBCMenue(1);
                break;
            }
            case 1073744868: {
                if (this.isTraceEnabled()) {
                    this.trace().append("ASL ACTION: resetBCMenue_2").log();
                }
                this.dsiCarKombi.resetBCMenue(2);
                break;
            }
            case 1073745209: {
                if (this.isTraceEnabled()) {
                    this.trace().append("ASL ACTION: reset trip counter").log();
                }
                this.dsiCarKombi.resetBCMenue(5);
                break;
            }
            case 1073745135: {
                this.settingUpHUDBrigthness(eventGeneric.getInt(0));
                break;
            }
            case 1073745136: {
                this.deIncreaseHUDBrightness(eventGeneric.getBoolean(0));
                break;
            }
            case 1073744870: {
                this.toggleHudConfiguration(eventGeneric.getInt(0));
                break;
            }
            case 1073745134: {
                this.setColorScheme(eventGeneric.getInt(0));
                break;
            }
            case 3400023: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10443, eventGeneric.getInt(0));
                break;
            }
            case 1073745242: {
                if (this.isTraceEnabled()) {
                    this.trace("BC.SET_OFFROAD_DISPLAY_PERSISTENCE");
                }
                this.persistOffroadSetup(eventGeneric);
                break;
            }
            case 1073745237: {
                if (this.isTraceEnabled()) {
                    this.trace("BC.SET_LAST_PQ_VIEW_PERSISTENCE");
                }
                int n = eventGeneric.getInt(0);
                ServiceManager.aslPropertyManager.valueChangedInteger(10895, n);
                CarEarly carEarly = CarEarlyPersistenceServiceImpl.getInstance().loadCarEarly();
                carEarly.setLastPqView(n);
                break;
            }
        }
    }

    private void registerOnVehicleDsi() {
        this.dsiCarVehicleState.setNotification(new int[]{12}, this.dsiCarVehicleStateListener);
    }

    private void toggleKombiDisplayConfiguration(int n) {
        Boolean[] booleanArray = this.CURRENTDISPLAYCONFIGURATION;
        this.currentFuelConsumption = booleanArray[0];
        this.averageFuelConsumption = booleanArray[1];
        this.refuelAmount = booleanArray[2];
        this.ecoComfort = booleanArray[3];
        this.ecoLifeTips = booleanArray[4];
        this.rideTime = booleanArray[5];
        this.rideDistance = booleanArray[6];
        this.averageSpeed = booleanArray[7];
        this.digitalSpeed = booleanArray[8];
        this.speedWarn = booleanArray[9];
        this.oilTemp = booleanArray[10];
        this.towBarLoad = booleanArray[11];
        this.tempCoolAgent = booleanArray[12];
        this.displaySignAssist = booleanArray[13];
        switch (n) {
            case 8: {
                this.digitalSpeed = !this.digitalSpeed;
                this.dsiCarKombi.setBCDigitalSpeed(this.digitalSpeed);
                break;
            }
            case 10: {
                this.oilTemp = !this.oilTemp;
                this.dsiCarKombi.setBCOilTemperature(this.oilTemp);
                break;
            }
            case 3: {
                this.ecoComfort = !this.ecoComfort;
                this.dsiCarKombi.setBCConsumerDisplay(this.ecoComfort);
                break;
            }
            case 4: {
                this.ecoLifeTips = !this.ecoLifeTips;
                this.dsiCarKombi.setBCLifeTipsDisplay(this.ecoLifeTips);
                break;
            }
            case 13: {
                this.displaySignAssist = !this.displaySignAssist;
                this.dsiCarKombi.setBCVzaMFA(this.displaySignAssist);
                break;
            }
            case 11: {
                this.towBarLoad = !this.towBarLoad;
                this.dsiCarKombi.setBCAstaMFA(this.towBarLoad);
                break;
            }
            default: {
                switch (n) {
                    case 0: {
                        this.currentFuelConsumption = !this.currentFuelConsumption;
                        break;
                    }
                    case 1: {
                        this.averageFuelConsumption = !this.averageFuelConsumption;
                        break;
                    }
                    case 2: {
                        this.refuelAmount = !this.refuelAmount;
                        break;
                    }
                    case 5: {
                        this.rideTime = !this.rideTime;
                        break;
                    }
                    case 6: {
                        this.rideDistance = !this.rideDistance;
                        break;
                    }
                    case 7: {
                        this.averageSpeed = !this.averageSpeed;
                        break;
                    }
                    case 9: {
                        this.speedWarn = !this.speedWarn;
                        break;
                    }
                    case 12: {
                        this.tempCoolAgent = !this.tempCoolAgent;
                        break;
                    }
                }
                this.bcConfiguration.currentConsumption = this.currentFuelConsumption;
                this.bcConfiguration.averageConsumption = this.averageFuelConsumption;
                this.bcConfiguration.refuelVolume = this.refuelAmount;
                this.bcConfiguration.drivenDistance = this.rideDistance;
                this.bcConfiguration.drivingTime = this.rideTime;
                this.bcConfiguration.averageSpeed = this.averageSpeed;
                this.bcConfiguration.speedWarningFIS = this.speedWarn;
                this.bcConfiguration.coolantTemp = this.tempCoolAgent;
                this.dsiCarKombi.setBCMenueConfig(this.bcConfiguration, 0);
            }
        }
    }

    private void settingUpHUDBrigthness(int n) {
        this.dsiCarKombi.setHUDBrightness((byte)n);
    }

    private void deIncreaseHUDBrightness(boolean bl) {
        this.duration = ASLCarUtil.durationTimeMinMaxValue(bl, this.HUD_BRIGTHNESS_VALUE, 5, 0, 100);
        if (this.duration != -1) {
            if (this.isTraceEnabled()) {
                this.trace().append("modified hud brightness. Value: ").append(this.duration).log();
            }
            this.settingUpHUDBrigthness(this.duration);
        } else if (this.isTraceEnabled()) {
            this.trace().append("Can not modified hud brightness. The duration is out of the range: ").append(this.duration).log();
        }
    }

    private void toggleHudConfiguration(int n) {
        switch (n) {
            case 0: {
                this.currentContent.speed = !this.currentContent.speed;
                break;
            }
            case 1: {
                this.currentContent.warning = !this.currentContent.warning;
                break;
            }
            case 2: {
                this.currentContent.acc = !this.currentContent.acc;
                break;
            }
            case 3: {
                this.currentContent.nightvision = !this.currentContent.nightvision;
                break;
            }
            case 4: {
                this.currentContent.roadsign = !this.currentContent.roadsign;
                break;
            }
            case 5: {
                this.currentContent.rgi = !this.currentContent.rgi;
                break;
            }
            case 6: {
                this.currentContent.navInfo = !this.currentContent.navInfo;
                break;
            }
            case 7: {
                this.currentContent.infoList = !this.currentContent.infoList;
                break;
            }
            case 8: {
                this.currentContent.hca = !this.currentContent.hca;
                break;
            }
            case 9: {
                this.currentContent.gra = !this.currentContent.gra;
                break;
            }
            case 10: {
                this.currentContent.telephone = !this.currentContent.telephone;
                break;
            }
        }
        this.dsiCarKombi.setHUDContent(this.currentContent);
    }

    private void setColorScheme(int n) {
        switch (n) {
            case 0: {
                this.dsiCarKombi.setHUDColour(this.colourDesign, 0);
                break;
            }
            case 1: {
                this.dsiCarKombi.setHUDColour(this.colourDesign, 1);
                break;
            }
        }
    }

    private void persistOffroadSetup(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        int n2 = eventGeneric.getInt(1);
        boolean bl = ServiceManager.configManagerDiag.isFeatureFlagSet(360) && !ServiceManager.configManagerDiag.isFeatureFlagSet(441);
        CarOffroad carOffroad = CarPersistenceServiceImpl.getInstance().loadCar().getCarOffroad();
        switch (n) {
            case 0: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10555, n2);
                if (bl) {
                    carOffroad.setOffroadLeftTubeNonNav(n2);
                } else {
                    carOffroad.setOffroadLeftTubeNav(n2);
                }
                carOffroad.setOffroadLeftTubeNav(n2);
                break;
            }
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10556, n2);
                if (bl) {
                    carOffroad.setOffroadMiddleTubeNonNav(n2);
                    break;
                }
                carOffroad.setOffroadMiddleTubeNav(n2);
                break;
            }
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10557, n2);
                if (bl) {
                    carOffroad.setOffroadRightTubeNonNav(n2);
                    break;
                }
                carOffroad.setOffroadRightTubeNav(n2);
                break;
            }
            default: {
                if (!this.isTraceEnabled()) break;
                this.trace(new StringBuffer().append("BC.SET_OFFROAD_DISPLAY_PERSISTENCE: invalid parameter (").append(n).append(")").toString());
            }
        }
    }

    public void dsiCarKombiUpdateBCCurrentRange1(CarBCCurrentRange carBCCurrentRange, int n) {
        this.BCMENU1_COLLECTOR[4].itemUnit = this.bordComputerDistanceUnit(carBCCurrentRange.currentRangeUnit);
        this.BCMENU2_COLLECTOR[4].itemUnit = this.bordComputerDistanceUnit(carBCCurrentRange.currentRangeUnit);
        this.BCMENU3_COLLECTOR[4].itemUnit = this.bordComputerDistanceUnit(carBCCurrentRange.currentRangeUnit);
        this.BCMENU1_BI_COLLECTOR[4].itemUnit = this.bordComputerDistanceUnit(carBCCurrentRange.currentRangeUnit);
        this.BCMENU2_BI_COLLECTOR[4].itemUnit = this.bordComputerDistanceUnit(carBCCurrentRange.currentRangeUnit);
        this.BCMENU3_BI_COLLECTOR[4].itemUnit = this.bordComputerDistanceUnit(carBCCurrentRange.currentRangeUnit);
        this.BCMENU1_BI_COLLECTOR[7].itemUnit = this.bordComputerDistanceUnit(carBCCurrentRange.currentRangeUnit);
        this.BCMENU2_BI_COLLECTOR[7].itemUnit = this.bordComputerDistanceUnit(carBCCurrentRange.currentRangeUnit);
        this.BCMENU3_BI_COLLECTOR[7].itemUnit = this.bordComputerDistanceUnit(carBCCurrentRange.currentRangeUnit);
        this.primaryEngine = carBCCurrentRange;
        this.calcTotalRange();
        if (carBCCurrentRange.currentRangeValue < MAX_VALUE_INT_BC) {
            this.BCMENU1_COLLECTOR[4].value = carBCCurrentRange.currentRangeValue;
            this.BCMENU1_COLLECTOR[4].valueDecimal = 0;
            this.BCMENU2_COLLECTOR[4].value = carBCCurrentRange.currentRangeValue;
            this.BCMENU2_COLLECTOR[4].valueDecimal = 0;
            this.BCMENU3_COLLECTOR[4].value = carBCCurrentRange.currentRangeValue;
            this.BCMENU3_COLLECTOR[4].valueDecimal = 0;
            this.BCMENU1_BI_COLLECTOR[4].value = carBCCurrentRange.currentRangeValue;
            this.BCMENU1_BI_COLLECTOR[4].valueDecimal = 0;
            this.BCMENU2_BI_COLLECTOR[4].value = carBCCurrentRange.currentRangeValue;
            this.BCMENU2_BI_COLLECTOR[4].valueDecimal = 0;
            this.BCMENU3_BI_COLLECTOR[4].value = carBCCurrentRange.currentRangeValue;
            this.BCMENU3_BI_COLLECTOR[4].valueDecimal = 0;
        } else {
            this.BCMENU1_COLLECTOR[4].value = -1;
            this.BCMENU1_COLLECTOR[4].valueDecimal = 0;
            this.BCMENU2_COLLECTOR[4].value = -1;
            this.BCMENU2_COLLECTOR[4].valueDecimal = 0;
            this.BCMENU3_COLLECTOR[4].value = -1;
            this.BCMENU3_COLLECTOR[4].valueDecimal = 0;
            this.BCMENU1_BI_COLLECTOR[4].value = -1;
            this.BCMENU1_BI_COLLECTOR[4].valueDecimal = 0;
            this.BCMENU2_BI_COLLECTOR[4].value = -1;
            this.BCMENU2_BI_COLLECTOR[4].valueDecimal = 0;
            this.BCMENU3_BI_COLLECTOR[4].value = -1;
            this.BCMENU3_BI_COLLECTOR[4].valueDecimal = 0;
        }
        ListManager.getGenericASLList(10136).updateList(this.BCMENU1_COLLECTOR);
        ListManager.getGenericASLList(10137).updateList(this.BCMENU2_COLLECTOR);
        ListManager.getGenericASLList(10138).updateList(this.BCMENU3_COLLECTOR);
        ListManager.getGenericASLList(10139).updateList(this.BCMENU1_BI_COLLECTOR);
        ListManager.getGenericASLList(10140).updateList(this.BCMENU2_BI_COLLECTOR);
        ListManager.getGenericASLList(10141).updateList(this.BCMENU3_BI_COLLECTOR);
        this.BCMENU1_COLLECTOR_CLIENT = this.createClientApiBCList(this.BCMENU1_BI_COLLECTOR);
        this.BCMENU2_COLLECTOR_CLIENT = this.createClientApiBCList(this.BCMENU2_BI_COLLECTOR);
        this.BCMENU3_COLLECTOR_CLIENT = this.createClientApiBCList(this.BCMENU3_BI_COLLECTOR);
        this.getBordComputerServiceListener().updateBCMenu1(this.BCMENU1_COLLECTOR_CLIENT);
        this.getBordComputerServiceListener().updateBCMenu2(this.BCMENU2_COLLECTOR_CLIENT);
        this.getBordComputerServiceListener().updateBCMenu3(this.BCMENU3_COLLECTOR_CLIENT);
    }

    public void dsiCarKombiUpdateBCCurrentRange2(CarBCCurrentRange carBCCurrentRange, int n) {
        this.BCMENU1_BI_COLLECTOR[5].itemUnit = this.bordComputerDistanceUnit(carBCCurrentRange.currentRangeUnit);
        this.BCMENU2_BI_COLLECTOR[5].itemUnit = this.bordComputerDistanceUnit(carBCCurrentRange.currentRangeUnit);
        this.BCMENU3_BI_COLLECTOR[5].itemUnit = this.bordComputerDistanceUnit(carBCCurrentRange.currentRangeUnit);
        this.BCMENU1_BI_COLLECTOR[7].itemUnit = this.bordComputerDistanceUnit(carBCCurrentRange.currentRangeUnit);
        this.BCMENU2_BI_COLLECTOR[7].itemUnit = this.bordComputerDistanceUnit(carBCCurrentRange.currentRangeUnit);
        this.BCMENU3_BI_COLLECTOR[7].itemUnit = this.bordComputerDistanceUnit(carBCCurrentRange.currentRangeUnit);
        this.secondaryEngine = carBCCurrentRange;
        this.calcTotalRange();
        if (carBCCurrentRange.currentRangeValue < MAX_VALUE_INT_BC) {
            this.BCMENU1_BI_COLLECTOR[5].value = carBCCurrentRange.currentRangeValue;
            this.BCMENU1_BI_COLLECTOR[5].valueDecimal = 0;
            this.BCMENU2_BI_COLLECTOR[5].value = carBCCurrentRange.currentRangeValue;
            this.BCMENU2_BI_COLLECTOR[5].valueDecimal = 0;
            this.BCMENU3_BI_COLLECTOR[5].value = carBCCurrentRange.currentRangeValue;
            this.BCMENU3_BI_COLLECTOR[5].valueDecimal = 0;
            ASLCarBordComputerHsmTarget.writeIntegerToDatapool(10849, carBCCurrentRange.currentRangeValue);
            ASLCarBordComputerHsmTarget.writeBooleanToDatapool(10850, true);
        } else {
            this.BCMENU1_BI_COLLECTOR[5].value = -1;
            this.BCMENU1_BI_COLLECTOR[5].valueDecimal = 0;
            this.BCMENU2_BI_COLLECTOR[5].value = -1;
            this.BCMENU2_BI_COLLECTOR[5].valueDecimal = 0;
            this.BCMENU3_BI_COLLECTOR[5].value = -1;
            this.BCMENU3_BI_COLLECTOR[5].valueDecimal = 0;
            ASLCarBordComputerHsmTarget.writeIntegerToDatapool(10849, -1);
            ASLCarBordComputerHsmTarget.writeBooleanToDatapool(10850, false);
        }
        ListManager.getGenericASLList(10139).updateList(this.BCMENU1_BI_COLLECTOR);
        ListManager.getGenericASLList(10140).updateList(this.BCMENU2_BI_COLLECTOR);
        ListManager.getGenericASLList(10141).updateList(this.BCMENU3_BI_COLLECTOR);
        int n2 = 0;
        if (-1 != carBCCurrentRange.getCurrentRangeValue()) {
            if (this.currentDistanceUnit == 0) {
                n2 = carBCCurrentRange.getCurrentRangeValue();
            } else if (this.currentDistanceUnit == 1) {
                n2 = (int)((double)carBCCurrentRange.getCurrentRangeValue() / 0.621371);
            }
        }
        ASLCarBordComputerHsmTarget.writeIntegerToDatapool(10851, n2);
    }

    private void calcTotalRange() {
        if (this.primaryEngine.getCurrentRangeValue() < MAX_VALUE_INT_BC && this.secondaryEngine.getCurrentRangeValue() < MAX_VALUE_INT_BC) {
            this.BCMENU1_BI_COLLECTOR[7].value = this.primaryEngine.getCurrentRangeValue() + this.secondaryEngine.getCurrentRangeValue();
            this.BCMENU1_BI_COLLECTOR[7].valueDecimal = 0;
            this.BCMENU2_BI_COLLECTOR[7].value = this.primaryEngine.getCurrentRangeValue() + this.secondaryEngine.getCurrentRangeValue();
            this.BCMENU2_BI_COLLECTOR[7].valueDecimal = 0;
            this.BCMENU3_BI_COLLECTOR[7].value = this.primaryEngine.getCurrentRangeValue() + this.secondaryEngine.getCurrentRangeValue();
            this.BCMENU3_BI_COLLECTOR[7].valueDecimal = 0;
        } else if (this.primaryEngine.getCurrentRangeValue() < MAX_VALUE_INT_BC) {
            this.BCMENU1_BI_COLLECTOR[7].value = this.primaryEngine.getCurrentRangeValue();
            this.BCMENU1_BI_COLLECTOR[7].valueDecimal = 0;
            this.BCMENU2_BI_COLLECTOR[7].value = this.primaryEngine.getCurrentRangeValue();
            this.BCMENU2_BI_COLLECTOR[7].valueDecimal = 0;
            this.BCMENU3_BI_COLLECTOR[7].value = this.primaryEngine.getCurrentRangeValue();
            this.BCMENU3_BI_COLLECTOR[7].valueDecimal = 0;
        } else if (this.secondaryEngine.getCurrentRangeValue() < MAX_VALUE_INT_BC) {
            this.BCMENU1_BI_COLLECTOR[7].value = this.secondaryEngine.getCurrentRangeValue();
            this.BCMENU1_BI_COLLECTOR[7].valueDecimal = 0;
            this.BCMENU2_BI_COLLECTOR[7].value = this.secondaryEngine.getCurrentRangeValue();
            this.BCMENU2_BI_COLLECTOR[7].valueDecimal = 0;
            this.BCMENU3_BI_COLLECTOR[7].value = this.secondaryEngine.getCurrentRangeValue();
            this.BCMENU3_BI_COLLECTOR[7].valueDecimal = 0;
        } else {
            this.BCMENU1_BI_COLLECTOR[7].value = -1;
            this.BCMENU1_BI_COLLECTOR[7].valueDecimal = 0;
            this.BCMENU2_BI_COLLECTOR[7].value = -1;
            this.BCMENU2_BI_COLLECTOR[7].valueDecimal = 0;
            this.BCMENU3_BI_COLLECTOR[7].value = -1;
            this.BCMENU3_BI_COLLECTOR[7].valueDecimal = 0;
        }
    }

    public void dsiCarKombiUpdateBCShortTermGeneral(BCShortTermGeneralData bCShortTermGeneralData, int n) {
        this.handleBCTermGeneral(bCShortTermGeneralData.getDistance(), bCShortTermGeneralData.getSpeed(), bCShortTermGeneralData.getTimeValue(), this.BCMENU1_COLLECTOR, ListManager.getGenericASLList(10136), false);
        this.handleBCTermGeneral(bCShortTermGeneralData.getDistance(), bCShortTermGeneralData.getSpeed(), bCShortTermGeneralData.getTimeValue(), this.BCMENU1_BI_COLLECTOR, ListManager.getGenericASLList(10139), true);
        this.BCMENU1_COLLECTOR_CLIENT = this.createClientApiBCList(this.BCMENU1_BI_COLLECTOR);
        this.getBordComputerServiceListener().updateBCMenu1(this.BCMENU1_COLLECTOR_CLIENT);
    }

    public void dsiCarKombiUpdateBCShortTermAverageConsumption1(CarBCConsumption carBCConsumption, int n) {
        this.handleNegativeValues(carBCConsumption.getConsumptionValue(), 10821);
        this.handleNegativeValues(carBCConsumption.getConsumptionValue(), 10824);
        this.handleCarBCConsumption(carBCConsumption, this.BCMENU1_COLLECTOR, ListManager.getGenericASLList(10136), 3, 10830);
        this.handleCarBCConsumption(carBCConsumption, this.BCMENU1_BI_COLLECTOR, ListManager.getGenericASLList(10139), 2, 10833);
        this.BCMENU1_COLLECTOR_CLIENT = this.createClientApiBCList(this.BCMENU1_BI_COLLECTOR);
        this.getBordComputerServiceListener().updateBCMenu1(this.BCMENU1_COLLECTOR_CLIENT);
    }

    public void dsiCarKombiUpdateBCShortTermAverageConsumption2(CarBCConsumption carBCConsumption, int n) {
        this.handleNegativeValues(carBCConsumption.getConsumptionValue(), 10827);
        this.handleCarBCConsumption(carBCConsumption, this.BCMENU1_BI_COLLECTOR, ListManager.getGenericASLList(10139), 3, 10836);
    }

    public void dsiCarKombiUpdateBCLongTermGeneral(BCLongTermGeneralData bCLongTermGeneralData, int n) {
        this.handleBCTermGeneral(bCLongTermGeneralData.getDistance(), bCLongTermGeneralData.getSpeed(), bCLongTermGeneralData.getTimeValue(), this.BCMENU2_COLLECTOR, ListManager.getGenericASLList(10137), false);
        this.handleBCTermGeneral(bCLongTermGeneralData.getDistance(), bCLongTermGeneralData.getSpeed(), bCLongTermGeneralData.getTimeValue(), this.BCMENU2_BI_COLLECTOR, ListManager.getGenericASLList(10140), true);
        this.BCMENU2_COLLECTOR_CLIENT = this.createClientApiBCList(this.BCMENU2_BI_COLLECTOR);
        this.getBordComputerServiceListener().updateBCMenu2(this.BCMENU2_COLLECTOR_CLIENT);
    }

    public void dsiCarKombiUpdateBCLongTermAverageConsumption1(CarBCConsumption carBCConsumption, int n) {
        this.handleNegativeValues(carBCConsumption.getConsumptionValue(), 10822);
        this.handleNegativeValues(carBCConsumption.getConsumptionValue(), 10825);
        this.handleCarBCConsumption(carBCConsumption, this.BCMENU2_COLLECTOR, ListManager.getGenericASLList(10137), 3, 10831);
        this.handleCarBCConsumption(carBCConsumption, this.BCMENU2_BI_COLLECTOR, ListManager.getGenericASLList(10140), 2, 10834);
        this.BCMENU2_COLLECTOR_CLIENT = this.createClientApiBCList(this.BCMENU2_BI_COLLECTOR);
        this.getBordComputerServiceListener().updateBCMenu2(this.BCMENU2_COLLECTOR_CLIENT);
    }

    public void dsiCarKombiUpdateBCLongTermAverageConsumption2(CarBCConsumption carBCConsumption, int n) {
        this.handleNegativeValues(carBCConsumption.getConsumptionValue(), 10828);
        this.handleCarBCConsumption(carBCConsumption, this.BCMENU2_BI_COLLECTOR, ListManager.getGenericASLList(10140), 3, 10837);
    }

    public void dsiCarKombiUpdateBCCycleAverageConsumption1(CarBCConsumption carBCConsumption, int n) {
        this.handleNegativeValues(carBCConsumption.getConsumptionValue(), 10823);
        this.handleNegativeValues(carBCConsumption.getConsumptionValue(), 10826);
        this.handleCarBCConsumption(carBCConsumption, this.BCMENU3_COLLECTOR, ListManager.getGenericASLList(10138), 3, 10832);
        this.handleCarBCConsumption(carBCConsumption, this.BCMENU3_BI_COLLECTOR, ListManager.getGenericASLList(10141), 2, 10835);
        this.BCMENU3_COLLECTOR_CLIENT = this.createClientApiBCList(this.BCMENU3_BI_COLLECTOR);
        this.getBordComputerServiceListener().updateBCMenu3(this.BCMENU3_COLLECTOR_CLIENT);
    }

    public void dsiCarKombiUpdateBCCycleAverageConsumption2(CarBCConsumption carBCConsumption, int n) {
        this.handleNegativeValues(carBCConsumption.getConsumptionValue(), 10829);
        this.handleCarBCConsumption(carBCConsumption, this.BCMENU3_BI_COLLECTOR, ListManager.getGenericASLList(10141), 3, 10838);
    }

    public void dsiCarKombiUpdateBCCycleGeneral(BCCycleGeneralData bCCycleGeneralData, int n) {
        this.data = bCCycleGeneralData;
        if (!this.startUp) {
            this.startUp = true;
            if (bCCycleGeneralData.getDistance().getDistanceUnit() == 0) {
                this.info().append("distance.km=").append(bCCycleGeneralData.getDistance().getDistanceValue()).log();
            } else {
                this.info().append("distance.mi=").append(bCCycleGeneralData.getDistance().getDistanceValue()).log();
            }
        }
        this.handleBCTermGeneral(bCCycleGeneralData.getDistance(), bCCycleGeneralData.getSpeed(), bCCycleGeneralData.getTimeValue(), this.BCMENU3_COLLECTOR, ListManager.getGenericASLList(10138), false);
        this.handleBCTermGeneral(bCCycleGeneralData.getDistance(), bCCycleGeneralData.getSpeed(), bCCycleGeneralData.getTimeValue(), this.BCMENU3_BI_COLLECTOR, ListManager.getGenericASLList(10141), true);
        this.BCMENU3_COLLECTOR_CLIENT = this.createClientApiBCList(this.BCMENU3_BI_COLLECTOR);
        this.getBordComputerServiceListener().updateBCMenu3(this.BCMENU3_COLLECTOR_CLIENT);
    }

    private void handleNegativeValues(float f2, int n) {
        if (f2 >= 0.0f) {
            ASLCarBordComputerHsmTarget.writeBooleanToDatapool(n, false);
        } else if ((double)f2 >= -0.9 || (double)f2 >= -0.1) {
            ASLCarBordComputerHsmTarget.writeBooleanToDatapool(n, true);
        } else {
            ASLCarBordComputerHsmTarget.writeBooleanToDatapool(n, false);
        }
    }

    private void handleBCTermGeneral(CarBCDistance carBCDistance, CarBCSpeed carBCSpeed, CarBCTime carBCTime, CarBCMenuValueHolder[] carBCMenuValueHolderArray, GenericASLList genericASLList, boolean bl) {
        this.handleBCTermGeneral(carBCDistance, carBCSpeed, carBCTime.timeValue, carBCMenuValueHolderArray, genericASLList, bl);
    }

    private void handleBCTermGeneral(CarBCDistance carBCDistance, CarBCSpeed carBCSpeed, int n, CarBCMenuValueHolder[] carBCMenuValueHolderArray, GenericASLList genericASLList, boolean bl) {
        Object[] objectArray = carBCMenuValueHolderArray;
        objectArray[0].itemUnit = this.bordComputerDistanceUnit(carBCDistance.distanceUnit);
        int[] nArray = ASLCarUtil.double2IntArray((float)carBCDistance.distanceValue, 1);
        objectArray[0].value = nArray[0];
        objectArray[0].valueDecimal = nArray[1];
        objectArray[1].value = n;
        objectArray[1].valueDecimal = -1;
        objectArray[1].itemUnit = 2;
        float f2 = carBCSpeed.speedValue;
        if ((double)f2 < MAX_VALUE_DOUBLE_BC) {
            if (bl) {
                objectArray[6].itemUnit = this.bordComputerSpeedUnit(carBCSpeed.speedUnit);
                nArray = ASLCarUtil.double2IntArray(f2, 1);
                ((CarBCMenuValueHolder)objectArray[6]).value = nArray[0];
                ((CarBCMenuValueHolder)objectArray[6]).valueDecimal = nArray[1];
            } else {
                objectArray[2].itemUnit = this.bordComputerSpeedUnit(carBCSpeed.speedUnit);
                nArray = ASLCarUtil.double2IntArray(f2, 1);
                ((CarBCMenuValueHolder)objectArray[2]).value = nArray[0];
                ((CarBCMenuValueHolder)objectArray[2]).valueDecimal = nArray[1];
            }
        } else if (bl) {
            objectArray[6].value = -1;
            objectArray[6].valueDecimal = 0;
        } else {
            objectArray[2].value = -1;
            objectArray[2].valueDecimal = 0;
        }
        genericASLList.updateList(objectArray);
    }

    private void handleCarBCConsumption(CarBCConsumption carBCConsumption, CarBCMenuValueHolder[] carBCMenuValueHolderArray, GenericASLList genericASLList, int n, int n2) {
        Object[] objectArray = carBCMenuValueHolderArray;
        objectArray[n].itemUnit = this.bordComputerConsumptionUnit(carBCConsumption.getConsumptionUnit());
        float f2 = this.getConsumptionMappingValueFor(carBCConsumption.getConsumptionValue());
        if ((double)f2 < MAX_VALUE_DOUBLE_BC) {
            ASLCarBordComputerHsmTarget.writeBooleanToDatapool(n2, true);
            int[] nArray = ASLCarUtil.double2IntArray(f2, 1);
            objectArray[n].value = nArray[0];
            ((CarBCMenuValueHolder)objectArray[n]).valueDecimal = nArray[1];
            if (this.isTraceEnabled()) {
                this.trace().append("Consumption Values: ").append(nArray[0]).append(".").append(nArray[1]).log();
            }
        } else {
            ASLCarBordComputerHsmTarget.writeBooleanToDatapool(n2, false);
            objectArray[n].value = -1;
            objectArray[n].valueDecimal = 0;
        }
        genericASLList.updateList(objectArray);
    }

    private float getConsumptionMappingValueFor(float f2) {
        if ((double)f2 == -3276.8 || (double)f2 == -3276.7 || (double)f2 == -3276.6 || (double)f2 == -3276.5) {
            return (float)MAX_VALUE_DOUBLE_BC;
        }
        return f2;
    }

    public void dsiCarKombiUpdateBCMenue1Config(BCMenueConfiguration bCMenueConfiguration, int n) {
        this.handleBCMenueConfig(bCMenueConfiguration);
    }

    public void dsiCarKombiUpdateBCMenue2Config(BCMenueConfiguration bCMenueConfiguration, int n) {
        this.handleBCMenueConfig(bCMenueConfiguration);
    }

    public void dsiCarKombiUpdateBCMenue3Config(BCMenueConfiguration bCMenueConfiguration, int n) {
        this.handleBCMenueConfig(bCMenueConfiguration);
    }

    public void dsiCarKombiUpdateBCOilTemperature(boolean bl, int n) {
        this.toggleDisplayConfiguration[10] = bl;
        this.informHmiMFA();
    }

    public void dsiCarKombiUpdateBCAstaMFA(boolean bl, int n) {
        this.toggleDisplayConfiguration[11] = bl;
        this.informHmiMFA();
    }

    public void dsiCarKombiUpdateBCDigitalSpeed(boolean bl, int n) {
        this.toggleDisplayConfiguration[8] = bl;
        this.informHmiMFA();
    }

    public void dsiCarKombiUpdateBCConsumerDisplay(boolean bl, int n) {
        this.toggleDisplayConfiguration[3] = bl;
        this.informHmiMFA();
    }

    public void dsiCarKombiUpdateBCLifeTipsDisplay(boolean bl, int n) {
        this.toggleDisplayConfiguration[4] = bl;
        this.informHmiMFA();
    }

    public void dsiCarKombiUpdateBCVzaMFA(boolean bl, int n) {
        this.toggleDisplayConfiguration[13] = bl;
        this.informHmiMFA();
    }

    private void handleBCMenueConfig(BCMenueConfiguration bCMenueConfiguration) {
        this.bcConfiguration = bCMenueConfiguration;
        this.toggleDisplayConfiguration[0] = bCMenueConfiguration.currentConsumption;
        this.toggleDisplayConfiguration[5] = bCMenueConfiguration.drivingTime;
        this.toggleDisplayConfiguration[6] = bCMenueConfiguration.drivenDistance;
        this.toggleDisplayConfiguration[7] = bCMenueConfiguration.averageSpeed;
        this.toggleDisplayConfiguration[1] = bCMenueConfiguration.averageConsumption;
        this.toggleDisplayConfiguration[9] = bCMenueConfiguration.speedWarningFIS;
        this.toggleDisplayConfiguration[12] = bCMenueConfiguration.coolantTemp;
        this.toggleDisplayConfiguration[2] = bCMenueConfiguration.refuelVolume;
        this.informHmiMFA();
    }

    public void dsiCarKombiUpdateHUDBrightness(byte by, int n) {
        this.HUD_BRIGTHNESS_VALUE = by;
        ASLCarBordComputerHsmTarget.writeIntegerToDatapool(10522, this.HUD_BRIGTHNESS_VALUE);
    }

    public void dsiCarKombiUpdateHUDContent(HUDContent hUDContent, int n) {
        this.currentContent = hUDContent;
        this.hudContent[0] = hUDContent.isSpeed();
        this.hudContent[1] = hUDContent.isWarning();
        this.hudContent[2] = hUDContent.isAcc();
        this.hudContent[3] = hUDContent.isNightvision();
        this.hudContent[4] = hUDContent.isRoadsign();
        this.hudContent[5] = hUDContent.isRgi();
        this.hudContent[6] = hUDContent.isNavInfo();
        this.hudContent[7] = hUDContent.isInfoList();
        this.hudContent[8] = hUDContent.isHca();
        this.hudContent[9] = hUDContent.isGra();
        this.hudContent[10] = hUDContent.isTelephone();
        ListManager.getGenericASLList(10128).updateList(this.hudContent);
    }

    public void dsiCarKombiUpdateHUDColour(int n, int n2, int n3) {
        n = this.colourDesign;
        switch (n2) {
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10521, 1);
                break;
            }
            case 0: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10521, 0);
                break;
            }
        }
    }

    public void dsiCarKombiUpdateBCTankLevel1(BCTankLevel bCTankLevel, int n) {
        this.tankLevel1 = bCTankLevel.tankLevelValue;
        this.setCombinedTanklevel();
    }

    private void setCombinedTanklevel() {
        ServiceManager.aslPropertyManager.valueChangedInteger(10607, this.secondaryEngineType != 0 ? Math.round(this.tankLevel1 + this.tankLevel2) / 2 : Math.round(this.tankLevel1 + this.tankLevel1) / 2);
    }

    public void dsiCarKombiUpdateBCTankLevel2(BCTankLevel bCTankLevel, int n) {
        this.tankLevel2 = bCTankLevel.tankLevelValue;
        this.setCombinedTanklevel();
    }

    public void dsiCarEcoUpdateBCmEConsumption(int n, int n2, int n3, int n4) {
        if (n <= n2) {
            boolean bl = false;
            if (this.currentMaxConsuptionValue != n2) {
                this.lowerBound = 0;
                this.upperBound = 0;
                this.currentConsumptionQuanto = (int)((double)n2 * 0.05);
                this.currentMaxConsuptionValue = n2;
            }
            while (n > this.upperBound) {
                bl = true;
                this.upperBound += this.currentConsumptionQuanto;
                this.lowerBound = this.upperBound - this.currentConsumptionQuanto;
            }
            while (n < this.lowerBound) {
                bl = true;
                this.lowerBound -= this.currentConsumptionQuanto;
                this.upperBound = this.lowerBound + this.currentConsumptionQuanto;
            }
            if (bl || n3 != this.currentConsumptionUnit || n == 0 || this.oldConsumptionValue == 0 && n > this.oldConsumptionValue) {
                this.oldConsumptionValue = n;
                this.informModelConsumptionValues(n, n2, n3);
            }
        } else if (this.isTraceEnabled()) {
            this.trace().append("ERROR ECO: max-value is smaller than consumption value!").log();
        }
    }

    private void informModelConsumptionValues(int n, int n2, int n3) {
        this.consumptionValues.car_bordcomputer_eco_comfort_consumption_value = n;
        if (n2 != this.currentConsumptionMaxValue) {
            this.currentConsumptionMaxValue = n2;
            this.consumptionValues.car_bordcomputer_eco_comfort_consumption_max = n2;
        }
        if (n3 != this.currentConsumptionUnit) {
            this.currentConsumptionUnit = n3;
            switch (n3) {
                case 2: {
                    this.consumptionValues.car_bordcomputer_eco_comfort_consumption_unit = 0;
                    break;
                }
                case 5: {
                    this.consumptionValues.car_bordcomputer_eco_comfort_consumption_unit = 1;
                    break;
                }
                case 11: {
                    this.consumptionValues.car_bordcomputer_eco_comfort_consumption_unit = 2;
                    break;
                }
                case 8: {
                    this.consumptionValues.car_bordcomputer_eco_comfort_consumption_unit = 3;
                    break;
                }
                case 22: {
                    this.consumptionValues.car_bordcomputer_eco_comfort_consumption_unit = 4;
                    break;
                }
                case 14: {
                    this.consumptionValues.car_bordcomputer_eco_comfort_consumption_unit = 5;
                    break;
                }
                case 17: {
                    this.consumptionValues.car_bordcomputer_eco_comfort_consumption_unit = 6;
                    break;
                }
            }
        }
        ListManager.getGenericASLList(10142).updateList(this.consumptionValueHMI);
    }

    public void dsiCarEcoUpdateBCmEViewOptions(BCmEViewOptions bCmEViewOptions, int n) {
        if (bCmEViewOptions.getConsumerListConsumption().getState() == 0) {
            this.registerOnEco();
            this.dsiCarEco.clearNotification(new int[]{34, 40}, this.dsiEcoListener);
            this.getConsumerListConsumptionController().setListAvailable(false);
        } else {
            this.registerOnEcoConsumersListConsumption();
            this.dsiCarEco.clearNotification(new int[]{2, 39}, this.dsiEcoListener);
            this.getConsumerListConsumptionController().setListAvailable(true);
        }
        if (2 == bCmEViewOptions.getCurrentRange().getState()) {
            ASLCarBordComputerHsmTarget.writeBooleanToDatapool(10847, true);
        } else {
            ASLCarBordComputerHsmTarget.writeBooleanToDatapool(10847, false);
        }
    }

    public void dsiCarEcoUpdateBCmEListUpdateInfo(BCmEListUpdateInfo bCmEListUpdateInfo, int n) {
        this.dsiProxy.clearWaitingRequests(class$org$dsi$ifc$careco$DSICarEco == null ? (class$org$dsi$ifc$careco$DSICarEco = ASLCarBordComputerHsmTarget.class$("org.dsi.ifc.careco.DSICarEco")) : class$org$dsi$ifc$careco$DSICarEco, "requestBCmEConsumerList");
        this.getConsumerListController().getConsumerListDsiListener().updateBCmEListUpdateInfo(bCmEListUpdateInfo, n);
    }

    public void dsiCarEcoUpdateBCmEConsumerListTotalNumberOfElements(int n, int n2) {
        this.getConsumerListController().getConsumerListDsiListener().updateBCmEConsumerListTotalNumberOfElements(n, n2);
    }

    public void dsiCarEcoResponseBCmEConsumerList(BCmEListUpdateInfo bCmEListUpdateInfo, BCmEConsumerList[] bCmEConsumerListArray) {
        this.getConsumerListController().getConsumerListDsiListener().responseBCmEConsumerList(bCmEListUpdateInfo, bCmEConsumerListArray);
    }

    public void dsiCarEcoUpdateBCmEConsumerListConsumptionUpdateInfo(BCmEListUpdateInfo bCmEListUpdateInfo, int n) {
        this.dsiProxy.clearWaitingRequests(class$org$dsi$ifc$careco$DSICarEco == null ? (class$org$dsi$ifc$careco$DSICarEco = ASLCarBordComputerHsmTarget.class$("org.dsi.ifc.careco.DSICarEco")) : class$org$dsi$ifc$careco$DSICarEco, "requestBCmEConsumerListConsumption");
        this.getConsumerListConsumptionController().getConsumerListDsiListener().updateBCmEConsumerListConsumptionUpdateInfo(bCmEListUpdateInfo, n);
    }

    public void dsiCarEcoUpdateBCmEConsumerListConsumptionTotalNumberOfElements(int n, int n2) {
        this.getConsumerListConsumptionController().getConsumerListDsiListener().updateBCmEConsumerListConsumptionTotalNumberOfElements(n, n2);
    }

    public void dsiCarEcoResponseBCmEConsumerListConsumptionRA0(BCmEListUpdateInfo bCmEListUpdateInfo, BCmEConsumerListConsumptionRA0[] bCmEConsumerListConsumptionRA0Array) {
        this.getConsumerListConsumptionController().getConsumerListDsiListener().responseBCmEConsumerListConsumptionRA0(bCmEListUpdateInfo, bCmEConsumerListConsumptionRA0Array);
    }

    public void dsiCarEcoResponseBCmEConsumerListConsumptionRA1(BCmEListUpdateInfo bCmEListUpdateInfo, BCmEConsumerListConsumptionRA1[] bCmEConsumerListConsumptionRA1Array) {
        this.getConsumerListConsumptionController().getConsumerListDsiListener().responseBCmEConsumerListConsumptionRA1(bCmEListUpdateInfo, bCmEConsumerListConsumptionRA1Array);
    }

    public void dsiCarEcoResponseBCmEConsumerListConsumptionRAF(BCmEListUpdateInfo bCmEListUpdateInfo, int[] nArray) {
        this.getConsumerListConsumptionController().getConsumerListDsiListener().responseBCmEConsumerListConsumptionRAF(bCmEListUpdateInfo, nArray);
    }

    private void informHmiMFA() {
        this.CURRENTDISPLAYCONFIGURATION = this.toggleDisplayConfiguration;
        ListManager.getGenericASLList(10129).updateList(this.toggleDisplayConfiguration);
    }

    protected int bordComputerDistanceUnit(int n) {
        switch (n) {
            case 0: {
                return 0;
            }
            case 1: {
                return 1;
            }
        }
        this.error("Bord Computer: Unit does not match with the model");
        return 0;
    }

    protected int bordComputerSpeedUnit(int n) {
        switch (n) {
            case 0: {
                return 3;
            }
            case 1: {
                return 4;
            }
        }
        this.error("Bord Computer: Unit does not match with the model");
        return 0;
    }

    protected int bordComputerConsumptionUnit(int n) {
        switch (n) {
            case 3: {
                return 8;
            }
            case 4: {
                return 7;
            }
            case 0: {
                return 5;
            }
            case 1: {
                return 6;
            }
            case 2: {
                return 9;
            }
            case 10: {
                return 14;
            }
            case 6: {
                return 11;
            }
            case 7: {
                return 12;
            }
            case 9: {
                return 13;
            }
            case 5: {
                return 15;
            }
            case 8: {
                return 16;
            }
            case 11: {
                return 17;
            }
            case 12: {
                return 18;
            }
            case 14: {
                return 19;
            }
            case 15: {
                return 20;
            }
            case 17: {
                return 21;
            }
            case 18: {
                return 22;
            }
            case 19: {
                return 23;
            }
            case 20: {
                return 24;
            }
            case 21: {
                return 25;
            }
            case 22: {
                return 26;
            }
            case 23: {
                return 27;
            }
            case 24: {
                return 28;
            }
            case 25: {
                return 29;
            }
        }
        this.error("Bord Computer: Consumption unit does not match with the model");
        return 5;
    }

    private void initPrivateDPPropertyValues() {
        this.initPrivateDPProperty_DisplayConfigurationList();
        this.initPrivateDPProperty_HUD();
        this.initPrivateDPProperty_BCMenu1();
        this.initPrivateDPProperty_BCMenu2();
        this.initPrivateDPProperty_BCMenu3();
        this.initPrivateDPProerty_BCMenu1_BiValent();
        this.initPrivateDPProerty_BCMenu2_BiValent();
        this.initPrivateDPProerty_BCMenu3_BiValent();
        this.HUD_BRIGTHNESS_VALUE = 50;
    }

    private void initPrivateDPProperty_DisplayConfigurationList() {
        this.toggleDisplayConfiguration[0] = false;
        this.toggleDisplayConfiguration[5] = false;
        this.toggleDisplayConfiguration[6] = false;
        this.toggleDisplayConfiguration[7] = false;
        this.toggleDisplayConfiguration[1] = false;
        this.toggleDisplayConfiguration[3] = false;
        this.toggleDisplayConfiguration[4] = false;
        this.toggleDisplayConfiguration[8] = false;
        this.toggleDisplayConfiguration[10] = false;
        this.toggleDisplayConfiguration[9] = false;
        this.toggleDisplayConfiguration[11] = false;
        this.toggleDisplayConfiguration[12] = false;
        this.toggleDisplayConfiguration[2] = false;
        this.toggleDisplayConfiguration[13] = false;
        ListManager.getGenericASLList(10129).updateList(this.toggleDisplayConfiguration);
        this.CURRENTDISPLAYCONFIGURATION = this.toggleDisplayConfiguration;
    }

    private void initPrivateDPProperty_BCMenu1() {
        Object[] objectArray = new CarBCMenuValueHolder[]{new CarBCMenuValueHolder(-1, 0, 10), new CarBCMenuValueHolder(-1, 0, 10), new CarBCMenuValueHolder(-1, 0, 10), new CarBCMenuValueHolder(-1, 0, 10), new CarBCMenuValueHolder(-1, 0, 10)};
        this.BCMENU1_COLLECTOR = objectArray;
        ListManager.getGenericASLList(10136).updateList(objectArray);
        ASLCarBordComputerHsmTarget.writeBooleanToDatapool(10830, false);
    }

    private void initPrivateDPProperty_BCMenu2() {
        Object[] objectArray = new CarBCMenuValueHolder[]{new CarBCMenuValueHolder(-1, 0, 10), new CarBCMenuValueHolder(-1, 0, 10), new CarBCMenuValueHolder(-1, 0, 10), new CarBCMenuValueHolder(-1, 0, 10), new CarBCMenuValueHolder(-1, 0, 10)};
        this.BCMENU2_COLLECTOR = objectArray;
        ListManager.getGenericASLList(10137).updateList(objectArray);
        ASLCarBordComputerHsmTarget.writeBooleanToDatapool(10831, false);
    }

    private void initPrivateDPProperty_BCMenu3() {
        Object[] objectArray = new CarBCMenuValueHolder[]{new CarBCMenuValueHolder(-1, 0, 10), new CarBCMenuValueHolder(-1, 0, 10), new CarBCMenuValueHolder(-1, 0, 10), new CarBCMenuValueHolder(-1, 0, 10), new CarBCMenuValueHolder(-1, 0, 10)};
        this.BCMENU3_COLLECTOR = objectArray;
        ListManager.getGenericASLList(10138).updateList(objectArray);
        ASLCarBordComputerHsmTarget.writeBooleanToDatapool(10832, false);
    }

    private void initPrivateDPProerty_BCMenu1_BiValent() {
        Object[] objectArray = new CarBCMenuValueHolder[]{new CarBCMenuValueHolder(-1, 0, 10), new CarBCMenuValueHolder(-1, 0, 10), new CarBCMenuValueHolder(-1, 0, 10), new CarBCMenuValueHolder(-1, 0, 10), new CarBCMenuValueHolder(-1, 0, 10), new CarBCMenuValueHolder(-1, 0, 10), new CarBCMenuValueHolder(-1, 0, 10), new CarBCMenuValueHolder(-1, 0, 10)};
        this.BCMENU1_BI_COLLECTOR = objectArray;
        ListManager.getGenericASLList(10139).updateList(objectArray);
        ASLCarBordComputerHsmTarget.writeBooleanToDatapool(10833, false);
    }

    private void initPrivateDPProerty_BCMenu2_BiValent() {
        Object[] objectArray = new CarBCMenuValueHolder[]{new CarBCMenuValueHolder(-1, 0, 10), new CarBCMenuValueHolder(-1, 0, 10), new CarBCMenuValueHolder(-1, 0, 10), new CarBCMenuValueHolder(-1, 0, 10), new CarBCMenuValueHolder(-1, 0, 10), new CarBCMenuValueHolder(-1, 0, 10), new CarBCMenuValueHolder(-1, 0, 10), new CarBCMenuValueHolder(-1, 0, 10)};
        this.BCMENU2_BI_COLLECTOR = objectArray;
        ListManager.getGenericASLList(10140).updateList(objectArray);
        ASLCarBordComputerHsmTarget.writeBooleanToDatapool(10834, false);
    }

    private void initPrivateDPProerty_BCMenu3_BiValent() {
        Object[] objectArray = new CarBCMenuValueHolder[]{new CarBCMenuValueHolder(-1, 0, 10), new CarBCMenuValueHolder(-1, 0, 10), new CarBCMenuValueHolder(-1, 0, 10), new CarBCMenuValueHolder(-1, 0, 10), new CarBCMenuValueHolder(-1, 0, 10), new CarBCMenuValueHolder(-1, 0, 10), new CarBCMenuValueHolder(-1, 0, 10), new CarBCMenuValueHolder(-1, 0, 10)};
        this.BCMENU3_BI_COLLECTOR = objectArray;
        ListManager.getGenericASLList(10141).updateList(objectArray);
        ASLCarBordComputerHsmTarget.writeBooleanToDatapool(10835, false);
    }

    private void initPrivateDPProperty_HUD() {
        this.hudContent[0] = false;
        this.hudContent[1] = false;
        this.hudContent[2] = false;
        this.hudContent[3] = false;
        this.hudContent[4] = false;
        this.hudContent[5] = false;
        this.hudContent[6] = false;
        this.hudContent[7] = false;
        this.hudContent[8] = false;
        this.hudContent[9] = false;
        this.hudContent[10] = false;
        ListManager.getGenericASLList(10128).updateList(this.hudContent);
    }

    public void dsiCarKombiUpdateCompassInfo(int n, int n2, int n3) {
        CarCompassInfoCollector carCompassInfoCollector = new CarCompassInfoCollector();
        carCompassInfoCollector.car_compass_info_angle = n2;
        carCompassInfoCollector.car_compass_info_direction = n;
        ListManager.getGenericASLList(10127).updateListItem(0, carCompassInfoCollector);
    }

    public void dsiCarVehicleStatesUpdateDynamicVehicleInfoHighFrequentViewOptions(DynamicVehicleInfoHighFrequentViewOptions dynamicVehicleInfoHighFrequentViewOptions, int n) {
        if (dynamicVehicleInfoHighFrequentViewOptions.getWheelAngle().getState() == 2) {
            if (!this.dynamicVehicleInfoHighFrequentNotificationSet) {
                this.dsiCarVehicleState.setNotification(new int[]{14}, this.dsiCarVehicleStateListener);
                this.dynamicVehicleInfoHighFrequentNotificationSet = true;
            }
        } else if (this.dynamicVehicleInfoHighFrequentNotificationSet) {
            this.dsiCarVehicleState.clearNotification(new int[]{14}, this.dsiCarVehicleStateListener);
            this.dynamicVehicleInfoHighFrequentNotificationSet = false;
        }
    }

    public void dsiCarVehicleStatesUpdateDynamicVehicleInfoHighFrequent(DynamicVehicleInfoHighFrequent dynamicVehicleInfoHighFrequent, int n) {
        if (this.currentDsiWheelAngle != dynamicVehicleInfoHighFrequent.wheelAngle) {
            this.currentDsiWheelAngle = dynamicVehicleInfoHighFrequent.wheelAngle;
            int n2 = this.currentDsiWheelAngle / 15;
            if (n2 != this.currentSteeringWheelAngle) {
                if (this.isTraceEnabled()) {
                    this.trace().append("BC.vehicleInfoHighFrequent.wheelAngle: ").append(dynamicVehicleInfoHighFrequent.getWheelAngle()).append(", valid").append(n).log();
                }
                this.currentSteeringWheelAngle = n2;
                ASLCarBordComputerHsmTarget.writeIntegerToDatapool(10444, n2);
            }
        }
    }

    public void dsiCarKombiUpdateBCOilTemperatureValue(CarBCTemperature carBCTemperature, int n) {
        int n2;
        if (this.isTraceEnabled()) {
            this.trace().append("BC.oilTemp: ").append(carBCTemperature.temperatureValue).append(", unit").append(carBCTemperature.temperatureUnit).log();
        }
        if ((n2 = carBCTemperature.getTemperatureUnit()) == 0) {
            ASLCarBordComputerHsmTarget.writeIntegerToDatapool(10564, 50);
            ASLCarBordComputerHsmTarget.writeIntegerToDatapool(10565, 150);
        } else {
            ASLCarBordComputerHsmTarget.writeIntegerToDatapool(10566, 120);
            ASLCarBordComputerHsmTarget.writeIntegerToDatapool(10567, 310);
        }
        ASLCarBordComputerHsmTarget.writeIntegerToDatapool(10536, n2 == 0 ? 0 : 1);
        if (carBCTemperature.getState() != 1) {
            ASLCarBordComputerHsmTarget.writeBooleanToDatapool(10537, false);
            return;
        }
        float f2 = carBCTemperature.getTemperatureValue();
        ASLCarBordComputerHsmTarget.writeBooleanToDatapool(10537, ASLCarBordComputerHsmTarget.checkIfTemperatureIsInRangeOil(f2, n2));
        f2 = ASLCarBordComputerHsmTarget.checkTemperatureRangeOil(f2, n2);
        ASLCarBordComputerHsmTarget.writeIntegerToDatapool(10535, (int)f2);
    }

    private static boolean checkIfTemperatureIsInRangeOil(float f2, int n) {
        return !(n == 0 ? f2 < 18498 || f2 > 5699 : n == 1 && (f2 < 61506 || f2 > 39747));
    }

    private static float checkTemperatureRangeOil(float f2, int n) {
        if (n == 0) {
            if (f2 < 18498) {
                f2 = 18498;
            } else if (f2 > 5699) {
                f2 = 5699;
            }
        } else if (n == 1) {
            if (f2 < 61506) {
                f2 = 61506;
            } else if (f2 > 39747) {
                f2 = 39747;
            }
        }
        return f2;
    }

    public void dsiCarKombiUpdateBCCoolantTemperature(CarBCTemperature carBCTemperature, int n) {
        int n2;
        if (this.isTraceEnabled()) {
            this.trace().append("BC.cooleantTemp: ").append(carBCTemperature.temperatureValue).append(", unit").append(carBCTemperature.temperatureUnit).log();
        }
        if ((n2 = carBCTemperature.getTemperatureUnit()) == 0) {
            ASLCarBordComputerHsmTarget.writeIntegerToDatapool(10568, 50);
            ASLCarBordComputerHsmTarget.writeIntegerToDatapool(10569, 130);
        } else {
            ASLCarBordComputerHsmTarget.writeIntegerToDatapool(10570, 120);
            ASLCarBordComputerHsmTarget.writeIntegerToDatapool(10571, 280);
        }
        ASLCarBordComputerHsmTarget.writeIntegerToDatapool(10539, n2 == 0 ? 0 : 1);
        if (carBCTemperature.getState() != 1) {
            ASLCarBordComputerHsmTarget.writeBooleanToDatapool(10540, false);
            return;
        }
        float f2 = carBCTemperature.getTemperatureValue();
        ASLCarBordComputerHsmTarget.writeBooleanToDatapool(10540, ASLCarBordComputerHsmTarget.checkIfTemperatureIsInRangeCoolant(f2, n2));
        f2 = ASLCarBordComputerHsmTarget.checkTemperatureRangeCoolant(f2, n2);
        ASLCarBordComputerHsmTarget.writeIntegerToDatapool(10538, (int)f2);
    }

    private static boolean checkIfTemperatureIsInRangeCoolant(float f2, int n) {
        return !(n == 0 ? f2 < 18498 || f2 > 579 : n == 1 && (f2 < 61506 || f2 > 35907));
    }

    private static float checkTemperatureRangeCoolant(float f2, int n) {
        if (n == 0) {
            if (f2 < 18498) {
                f2 = 18498;
            } else if (f2 > 579) {
                f2 = 579;
            }
        } else if (n == 1) {
            if (f2 < 61506) {
                f2 = 61506;
            } else if (f2 > 35907) {
                f2 = 35907;
            }
        }
        return f2;
    }

    public void dsiCarKombiUpdateBCViewOptions(BCViewOptions bCViewOptions, int n) {
        if (bCViewOptions.getCycleGeneral().getState() == 1 && bCViewOptions.getCycleGeneral().getReason() == 5) {
            if (this.data.getDistance().getDistanceUnit() == 0) {
                this.info().append("distance.km=").append(this.data.getDistance().getDistanceValue()).log();
            } else {
                this.info().append("distance.mi=").append(this.data.getDistance().getDistanceValue()).log();
            }
        }
        this.setDataPoolViewOption(10541, 10537, bCViewOptions.getOilTemperatureValue());
        this.setDataPoolViewOption(10542, 10540, bCViewOptions.getCoolantTemperature());
        if (bCViewOptions.getOilTemperatureValue().getState() != 0) {
            if (!this.dsiOilNotificationDone) {
                this.dsiOilNotificationDone = true;
                this.dsiCarKombi.setNotification(64, (DSIListener)this.dsiCarkombiListener);
            }
        } else if (this.dsiOilNotificationDone) {
            this.dsiOilNotificationDone = false;
            this.dsiCarKombi.clearNotification(64, (DSIListener)this.dsiCarkombiListener);
        }
        if (bCViewOptions.getCoolantTemperature().getState() != 0) {
            if (!this.dsiCoolantNotificationDone) {
                this.dsiCoolantNotificationDone = true;
                this.dsiCarKombi.setNotification(63, (DSIListener)this.dsiCarkombiListener);
            }
        } else if (this.dsiCoolantNotificationDone) {
            this.dsiCoolantNotificationDone = false;
            this.dsiCarKombi.clearNotification(63, (DSIListener)this.dsiCarkombiListener);
        }
        this.tankLevel1Available = bCViewOptions.tankLevel1.getState() == 2;
        ASLCarBordComputerHsmTarget.writeBooleanToDatapool(10606, this.tankLevel1Available);
        this.updateASTAServiceState(bCViewOptions);
        switch (bCViewOptions.getConfiguration().getPrimaryEngineType()) {
            case 0: 
            case 5: {
                this.primaryEngineType = 0;
                this.getBordComputerServiceListener().updatePrimaryEngineType(this.primaryEngineType);
                break;
            }
            case 1: 
            case 6: 
            case 7: {
                this.primaryEngineType = 1;
                this.getBordComputerServiceListener().updatePrimaryEngineType(this.primaryEngineType);
                break;
            }
            case 9: {
                this.primaryEngineType = 5;
                this.getBordComputerServiceListener().updatePrimaryEngineType(this.primaryEngineType);
                break;
            }
            case 2: 
            case 8: {
                this.primaryEngineType = 3;
                this.getBordComputerServiceListener().updatePrimaryEngineType(this.primaryEngineType);
                break;
            }
            case 3: {
                this.primaryEngineType = 4;
                this.getBordComputerServiceListener().updatePrimaryEngineType(this.primaryEngineType);
                break;
            }
        }
        switch (bCViewOptions.getConfiguration().getSecondaryEngineType()) {
            case 0: 
            case 5: {
                this.secondaryEngineType = 0;
                this.getBordComputerServiceListener().updateSecondaryEngineType(this.secondaryEngineType);
                break;
            }
            case 1: 
            case 6: 
            case 7: {
                this.secondaryEngineType = 1;
                this.getBordComputerServiceListener().updateSecondaryEngineType(this.secondaryEngineType);
                break;
            }
            case 9: {
                this.secondaryEngineType = 5;
                this.getBordComputerServiceListener().updateSecondaryEngineType(this.secondaryEngineType);
                break;
            }
            case 2: 
            case 8: {
                this.secondaryEngineType = 3;
                this.getBordComputerServiceListener().updateSecondaryEngineType(this.secondaryEngineType);
                break;
            }
            case 3: {
                this.secondaryEngineType = 4;
                this.getBordComputerServiceListener().updateSecondaryEngineType(this.secondaryEngineType);
                break;
            }
        }
        this.bcViewOptions = bCViewOptions;
        this.getBordComputerServiceListener().updateAvailableStatusRange(this.getAvailableStatusRange());
        this.getBordComputerServiceListener().updateAvailableStatusTripAverageConsumption(this.getAvailableStatusTripAverageConsumption());
        this.getBordComputerServiceListener().updateAvailableStatusTripGeneral(this.getAvailableStatusTripGeneral());
    }

    private void setDataPoolViewOption(int n, int n2, CarViewOption carViewOption) {
        if (carViewOption == null) {
            return;
        }
        boolean bl = true;
        boolean bl2 = true;
        if (carViewOption.getState() == 0) {
            bl2 = false;
            bl = false;
        } else if (carViewOption.getState() == 1) {
            bl2 = false;
        }
        ASLCarBordComputerHsmTarget.writeBooleanToDatapool(n, bl);
        ASLCarBordComputerHsmTarget.writeBooleanToDatapool(n2, bl2);
    }

    @Override
    public CarLogger getCarLogger() {
        return this;
    }

    @Override
    public DSICarEco getDsiCarEco() {
        return this.dsiCarEco;
    }

    private ConsumerController getConsumerListController() {
        if (this._consumerListController == null) {
            this._consumerListController = new ConsumerController(this);
        }
        return this._consumerListController;
    }

    private ConsumerListConsumptionController getConsumerListConsumptionController() {
        if (this._consumerListConsuptionController == null) {
            this._consumerListConsuptionController = new ConsumerListConsumptionController(this);
        }
        return this._consumerListConsuptionController;
    }

    @Override
    public ConsumerListController getConsumerListController(int n) {
        ConsumerListController consumerListController;
        switch (n) {
            case 0: {
                consumerListController = this.getConsumerListController();
                break;
            }
            case 1: {
                consumerListController = this.getConsumerListConsumptionController();
                break;
            }
            default: {
                throw new UnsupportedOperationException();
            }
        }
        return consumerListController;
    }

    private int evaluateBordComputerServiceState(CarViewOption carViewOption) {
        if (carViewOption == null) {
            return 1;
        }
        switch (carViewOption.getState()) {
            case 0: {
                return 1;
            }
            case 1: {
                return 2;
            }
            case 2: {
                return 3;
            }
        }
        return 0;
    }

    @Override
    public int getASTAServiceState() {
        return this.currentAstaState;
    }

    private BordComputerServiceListener getBordComputerServiceListener() {
        return (BordComputerServiceListener)ServiceFactory.getInstance().getServiceProviderRegistry().getServiceListener(class$de$vw$mib$asl$api$car$bordcomputer$BordComputerServiceListener == null ? (class$de$vw$mib$asl$api$car$bordcomputer$BordComputerServiceListener = ASLCarBordComputerHsmTarget.class$("de.vw.mib.asl.api.car.bordcomputer.BordComputerServiceListener")) : class$de$vw$mib$asl$api$car$bordcomputer$BordComputerServiceListener);
    }

    private void updateASTAServiceState(BCViewOptions bCViewOptions) {
        int n = this.evaluateBordComputerServiceState(bCViewOptions.getAstaMFA());
        if (this.currentAstaState != n) {
            this.currentAstaState = n;
            BordComputerServiceListener bordComputerServiceListener = this.getBordComputerServiceListener();
            if (bordComputerServiceListener != null) {
                bordComputerServiceListener.updateASTAServiceState(this.currentAstaState);
            }
        }
    }

    private ArrayList createClientApiBCList(CarBCMenuValueHolder[] carBCMenuValueHolderArray) {
        if (carBCMenuValueHolderArray != null && carBCMenuValueHolderArray.length > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < carBCMenuValueHolderArray.length; ++i2) {
                arrayList.add(new int[]{carBCMenuValueHolderArray[i2].value, carBCMenuValueHolderArray[i2].valueDecimal, carBCMenuValueHolderArray[i2].itemUnit});
            }
            return arrayList;
        }
        return null;
    }

    @Override
    public ArrayList getBCMenu1() {
        return this.BCMENU1_COLLECTOR_CLIENT;
    }

    @Override
    public ArrayList getBCMenu2() {
        return this.BCMENU2_COLLECTOR_CLIENT;
    }

    @Override
    public ArrayList getBCMenu3() {
        return this.BCMENU3_COLLECTOR_CLIENT;
    }

    @Override
    public int getPrimaryEngineType() {
        return this.primaryEngineType;
    }

    @Override
    public boolean getAvailableStatusRange() {
        return this.bcViewOptions.getCurrentRange1().getState() == 2;
    }

    @Override
    public boolean getAvailableStatusTripGeneral() {
        return this.bcViewOptions.getShortTermGeneral().getState() == 2;
    }

    @Override
    public boolean getAvailableStatusTripAverageConsumption() {
        return this.bcViewOptions.getShortTermAverageConsumption1().getState() == 2;
    }

    @Override
    public int getSecondaryEngineType() {
        return this.secondaryEngineType;
    }

    public void dsiCarTimeUnitsLanguageUpdateDistanceUnit(int n, int n2) {
        this.currentDistanceUnit = n;
        if (1 == n) {
            ServiceManager.aslPropertyManager.valueChangedInteger(10848, 1);
        } else {
            ServiceManager.aslPropertyManager.valueChangedInteger(10848, 0);
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
        MAX_VALUE_INT_BC = -65536;
        MAX_VALUE_DOUBLE_BC = 6553.5;
    }
}


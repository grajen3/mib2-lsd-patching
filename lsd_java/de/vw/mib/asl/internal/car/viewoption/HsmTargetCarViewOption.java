/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.viewoption;

import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.car.ASLCarContainer;
import de.vw.mib.asl.internal.car.transformer.CarFunctionCollector;
import de.vw.mib.asl.internal.car.viewoption.FunctionIds;
import de.vw.mib.asl.internal.car.viewoption.StateWork;
import de.vw.mib.asl.internal.car.viewoption.StateWorkMLB;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.caraircondition.DSICarAirCondition;
import org.dsi.ifc.caraircondition.DSICarAirConditionListener;
import org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCooler;
import org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCoolerListener;
import org.dsi.ifc.carcomfort.DSICarComfort;
import org.dsi.ifc.carcomfort.DSICarComfortListener;
import org.dsi.ifc.cardriverassistance.DSICarDriverAssistance;
import org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener;
import org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics;
import org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener;
import org.dsi.ifc.careco.DSICarEco;
import org.dsi.ifc.careco.DSICarEcoListener;
import org.dsi.ifc.carkombi.DSICarKombi;
import org.dsi.ifc.carkombi.DSICarKombiListener;
import org.dsi.ifc.carlight.DSICarLight;
import org.dsi.ifc.carlight.DSICarLightListener;
import org.dsi.ifc.carparkingsystem.DSICarParkingSystem;
import org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener;
import org.dsi.ifc.carseat.DSICarSeat;
import org.dsi.ifc.carseat.DSICarSeatListener;
import org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage;
import org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener;
import org.dsi.ifc.carvehiclestates.DSICarVehicleStates;
import org.dsi.ifc.carvehiclestates.DSICarVehicleStatesListener;
import org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates;
import org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener;
import org.dsi.ifc.powermanagement.DSIPowerManagement;
import org.dsi.ifc.powermanagement.DSIPowerManagementListener;

public class HsmTargetCarViewOption
extends AbstractASLHsmTarget {
    protected DSIPowerManagement dsiPowerManagement;
    private DSIPowerManagementListener dsiPowerManagementListener;
    protected DSICarLight dsiCarLight;
    private DSICarLightListener dsiCarLightListener;
    protected DSICarParkingSystem dsiCarParkingSystem;
    private DSICarParkingSystemListener dsiCarParkingSystemListener;
    protected DSICarDriverAssistance dsiCarDriverAssistance;
    protected DSICarDriverAssistanceListener dsiCarDriverAssistanceListener;
    protected DSICarComfort dsiCarComfort;
    protected DSICarComfortListener dsiCarComfortListener;
    protected DSICarKombi dsiCarKombi;
    private DSICarKombiListener dsiCarKombiListener;
    protected DSICarVehicleStates dsiCarVehicleStates;
    private DSICarVehicleStatesListener dsiCarVehicleStateListener;
    protected DSICarSeat dsiCarSeat;
    private DSICarSeatListener dsiCarSeatListener;
    protected DSICarAirCondition dsiCarAirCondition;
    private DSICarAirConditionListener dsiCarAirConditionListener;
    protected DSICarAuxHeaterCooler dsiCarAuxHeaterCooler;
    private DSICarAuxHeaterCoolerListener dsiCarAuxHeaterCoolerListener;
    protected DSICarEco dsiCarEco;
    private DSICarEcoListener dsiCarEcoListener;
    protected DSICarTimeUnitsLanguage dsiCarTimeUnitsLanguage;
    private DSICarTimeUnitsLanguageListener dsiCarTimeUnitsLanguageListener;
    private DSIGeneralVehicleStates dsiGeneralVehicleState;
    private DSIGeneralVehicleStatesListener dsiGeneralVehicleStateListener;
    protected DSICarDrivingCharacteristics dsiCarDrivingCharacteristics;
    protected DSICarDrivingCharacteristicsListener dsiCarDrivingCharacteristicsListener;
    HsmState stateWork;
    private boolean fakeListActive = false;
    boolean isRgsFactorySetting = false;
    boolean isCentralLocking = false;
    boolean isWindow = false;
    boolean standStillNotificationDone;
    private final int RESTORE_SPEED_THRESHOLD;
    private final int RESTORE_STAND_STILL;
    boolean isStandStillActive = true;
    boolean isSpeedToHighActive = false;
    public boolean isAmbienceLight;
    static /* synthetic */ Class class$org$dsi$ifc$powermanagement$DSIPowerManagement;
    static /* synthetic */ Class class$org$dsi$ifc$powermanagement$DSIPowerManagementListener;
    static /* synthetic */ Class class$org$dsi$ifc$carlight$DSICarLight;
    static /* synthetic */ Class class$org$dsi$ifc$carlight$DSICarLightListener;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$DSICarParkingSystem;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$DSICarParkingSystemListener;
    static /* synthetic */ Class class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistance;
    static /* synthetic */ Class class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistanceListener;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$DSICarComfort;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$DSICarComfortListener;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$DSICarKombi;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$DSICarKombiListener;
    static /* synthetic */ Class class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates;
    static /* synthetic */ Class class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener;
    static /* synthetic */ Class class$org$dsi$ifc$carseat$DSICarSeat;
    static /* synthetic */ Class class$org$dsi$ifc$carseat$DSICarSeatListener;
    static /* synthetic */ Class class$org$dsi$ifc$caraircondition$DSICarAirCondition;
    static /* synthetic */ Class class$org$dsi$ifc$caraircondition$DSICarAirConditionListener;
    static /* synthetic */ Class class$org$dsi$ifc$carauxheatercooler$DSICarAuxHeaterCooler;
    static /* synthetic */ Class class$org$dsi$ifc$carauxheatercooler$DSICarAuxHeaterCoolerListener;
    static /* synthetic */ Class class$org$dsi$ifc$careco$DSICarEco;
    static /* synthetic */ Class class$org$dsi$ifc$careco$DSICarEcoListener;
    static /* synthetic */ Class class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage;
    static /* synthetic */ Class class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener;
    static /* synthetic */ Class class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates;
    static /* synthetic */ Class class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener;
    static /* synthetic */ Class class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristics;
    static /* synthetic */ Class class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristicsListener;

    public HsmTargetCarViewOption(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.RESTORE_SPEED_THRESHOLD = 100;
        this.RESTORE_STAND_STILL = 200;
    }

    @Override
    public int getDefaultTargetId() {
        return -1991306752;
    }

    @Override
    protected HsmState getDefaultState() {
        if (this.stateWork == null) {
            this.stateWork = ServiceManager.configManagerDiag.isFeatureFlagSet(101) ? new StateWorkMLB(this, this.hsm, "stateMainMLB", this.getWorkStateParent()) : new StateWork(this, this.hsm, "stateMain", this.getWorkStateParent());
        }
        return this.stateWork;
    }

    @Override
    public int getSubClassifier() {
        return 1;
    }

    void initDsi() {
        this.dsiPowerManagement = (DSIPowerManagement)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$powermanagement$DSIPowerManagement == null ? (class$org$dsi$ifc$powermanagement$DSIPowerManagement = HsmTargetCarViewOption.class$("org.dsi.ifc.powermanagement.DSIPowerManagement")) : class$org$dsi$ifc$powermanagement$DSIPowerManagement);
        this.dsiPowerManagementListener = (DSIPowerManagementListener)ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$powermanagement$DSIPowerManagementListener == null ? (class$org$dsi$ifc$powermanagement$DSIPowerManagementListener = HsmTargetCarViewOption.class$("org.dsi.ifc.powermanagement.DSIPowerManagementListener")) : class$org$dsi$ifc$powermanagement$DSIPowerManagementListener);
        this.dsiCarLight = (DSICarLight)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$carlight$DSICarLight == null ? (class$org$dsi$ifc$carlight$DSICarLight = HsmTargetCarViewOption.class$("org.dsi.ifc.carlight.DSICarLight")) : class$org$dsi$ifc$carlight$DSICarLight);
        this.dsiCarLightListener = (DSICarLightListener)ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$carlight$DSICarLightListener == null ? (class$org$dsi$ifc$carlight$DSICarLightListener = HsmTargetCarViewOption.class$("org.dsi.ifc.carlight.DSICarLightListener")) : class$org$dsi$ifc$carlight$DSICarLightListener);
        this.dsiCarParkingSystem = (DSICarParkingSystem)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$carparkingsystem$DSICarParkingSystem == null ? (class$org$dsi$ifc$carparkingsystem$DSICarParkingSystem = HsmTargetCarViewOption.class$("org.dsi.ifc.carparkingsystem.DSICarParkingSystem")) : class$org$dsi$ifc$carparkingsystem$DSICarParkingSystem);
        this.dsiCarParkingSystemListener = (DSICarParkingSystemListener)ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$carparkingsystem$DSICarParkingSystemListener == null ? (class$org$dsi$ifc$carparkingsystem$DSICarParkingSystemListener = HsmTargetCarViewOption.class$("org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener")) : class$org$dsi$ifc$carparkingsystem$DSICarParkingSystemListener);
        this.dsiCarDriverAssistance = (DSICarDriverAssistance)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistance == null ? (class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistance = HsmTargetCarViewOption.class$("org.dsi.ifc.cardriverassistance.DSICarDriverAssistance")) : class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistance);
        this.dsiCarDriverAssistanceListener = (DSICarDriverAssistanceListener)ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistanceListener == null ? (class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistanceListener = HsmTargetCarViewOption.class$("org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener")) : class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistanceListener);
        this.dsiCarComfort = (DSICarComfort)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$carcomfort$DSICarComfort == null ? (class$org$dsi$ifc$carcomfort$DSICarComfort = HsmTargetCarViewOption.class$("org.dsi.ifc.carcomfort.DSICarComfort")) : class$org$dsi$ifc$carcomfort$DSICarComfort);
        this.dsiCarComfortListener = (DSICarComfortListener)ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$carcomfort$DSICarComfortListener == null ? (class$org$dsi$ifc$carcomfort$DSICarComfortListener = HsmTargetCarViewOption.class$("org.dsi.ifc.carcomfort.DSICarComfortListener")) : class$org$dsi$ifc$carcomfort$DSICarComfortListener);
        this.dsiCarKombi = (DSICarKombi)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$carkombi$DSICarKombi == null ? (class$org$dsi$ifc$carkombi$DSICarKombi = HsmTargetCarViewOption.class$("org.dsi.ifc.carkombi.DSICarKombi")) : class$org$dsi$ifc$carkombi$DSICarKombi);
        this.dsiCarKombiListener = (DSICarKombiListener)ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$carkombi$DSICarKombiListener == null ? (class$org$dsi$ifc$carkombi$DSICarKombiListener = HsmTargetCarViewOption.class$("org.dsi.ifc.carkombi.DSICarKombiListener")) : class$org$dsi$ifc$carkombi$DSICarKombiListener);
        this.dsiCarVehicleStates = (DSICarVehicleStates)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates == null ? (class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates = HsmTargetCarViewOption.class$("org.dsi.ifc.carvehiclestates.DSICarVehicleStates")) : class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates);
        this.dsiCarVehicleStateListener = (DSICarVehicleStatesListener)ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener == null ? (class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener = HsmTargetCarViewOption.class$("org.dsi.ifc.carvehiclestates.DSICarVehicleStatesListener")) : class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener);
        this.dsiCarSeat = (DSICarSeat)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$carseat$DSICarSeat == null ? (class$org$dsi$ifc$carseat$DSICarSeat = HsmTargetCarViewOption.class$("org.dsi.ifc.carseat.DSICarSeat")) : class$org$dsi$ifc$carseat$DSICarSeat);
        this.dsiCarSeatListener = (DSICarSeatListener)ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$carseat$DSICarSeatListener == null ? (class$org$dsi$ifc$carseat$DSICarSeatListener = HsmTargetCarViewOption.class$("org.dsi.ifc.carseat.DSICarSeatListener")) : class$org$dsi$ifc$carseat$DSICarSeatListener);
        this.dsiCarAirCondition = (DSICarAirCondition)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$caraircondition$DSICarAirCondition == null ? (class$org$dsi$ifc$caraircondition$DSICarAirCondition = HsmTargetCarViewOption.class$("org.dsi.ifc.caraircondition.DSICarAirCondition")) : class$org$dsi$ifc$caraircondition$DSICarAirCondition);
        this.dsiCarAirConditionListener = (DSICarAirConditionListener)ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$caraircondition$DSICarAirConditionListener == null ? (class$org$dsi$ifc$caraircondition$DSICarAirConditionListener = HsmTargetCarViewOption.class$("org.dsi.ifc.caraircondition.DSICarAirConditionListener")) : class$org$dsi$ifc$caraircondition$DSICarAirConditionListener);
        this.dsiCarAuxHeaterCooler = (DSICarAuxHeaterCooler)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$carauxheatercooler$DSICarAuxHeaterCooler == null ? (class$org$dsi$ifc$carauxheatercooler$DSICarAuxHeaterCooler = HsmTargetCarViewOption.class$("org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCooler")) : class$org$dsi$ifc$carauxheatercooler$DSICarAuxHeaterCooler);
        this.dsiCarAuxHeaterCoolerListener = (DSICarAuxHeaterCoolerListener)ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$carauxheatercooler$DSICarAuxHeaterCoolerListener == null ? (class$org$dsi$ifc$carauxheatercooler$DSICarAuxHeaterCoolerListener = HsmTargetCarViewOption.class$("org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCoolerListener")) : class$org$dsi$ifc$carauxheatercooler$DSICarAuxHeaterCoolerListener);
        this.dsiCarEco = (DSICarEco)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$careco$DSICarEco == null ? (class$org$dsi$ifc$careco$DSICarEco = HsmTargetCarViewOption.class$("org.dsi.ifc.careco.DSICarEco")) : class$org$dsi$ifc$careco$DSICarEco);
        this.dsiCarEcoListener = (DSICarEcoListener)ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$careco$DSICarEcoListener == null ? (class$org$dsi$ifc$careco$DSICarEcoListener = HsmTargetCarViewOption.class$("org.dsi.ifc.careco.DSICarEcoListener")) : class$org$dsi$ifc$careco$DSICarEcoListener);
        this.dsiCarTimeUnitsLanguage = (DSICarTimeUnitsLanguage)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage == null ? (class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage = HsmTargetCarViewOption.class$("org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage")) : class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage);
        this.dsiCarTimeUnitsLanguageListener = (DSICarTimeUnitsLanguageListener)ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener == null ? (class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener = HsmTargetCarViewOption.class$("org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener")) : class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener);
        this.dsiGeneralVehicleState = (DSIGeneralVehicleStates)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = HsmTargetCarViewOption.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates);
        this.dsiGeneralVehicleStateListener = (DSIGeneralVehicleStatesListener)ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener = HsmTargetCarViewOption.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener);
        this.dsiCarDrivingCharacteristics = (DSICarDrivingCharacteristics)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristics == null ? (class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristics = HsmTargetCarViewOption.class$("org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics")) : class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristics);
        this.dsiCarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristicsListener == null ? (class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristicsListener = HsmTargetCarViewOption.class$("org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener")) : class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristicsListener);
    }

    void registerOnModelEvents() {
        this.addObservers(new int[]{-502595520, -2075192832, 1108754432, 772481024, 789258240, 839589888});
    }

    void registerOnPowerManagement() {
        this.dsiPowerManagement.setNotification(new int[]{4}, (DSIListener)this.dsiPowerManagementListener);
    }

    void registerOnCarAuxHeaterCooler() {
        this.dsiCarAuxHeaterCooler.setNotification(new int[]{1}, (DSIListener)this.dsiCarAuxHeaterCoolerListener);
    }

    void registerOnCarSpeedThreshold() {
        this.dsiGeneralVehicleState.setNotification(new int[]{22}, (DSIListener)this.dsiGeneralVehicleStateListener);
        this.standStillNotificationDone = true;
    }

    void registerOnFpaViewOptions() {
        this.dsiCarDrivingCharacteristics.setNotification(new int[]{12}, (DSIListener)this.dsiCarDrivingCharacteristicsListener);
    }

    void clearOnFpaViewOptions() {
        this.dsiCarDrivingCharacteristics.clearNotification(new int[]{12}, (DSIListener)this.dsiCarDrivingCharacteristicsListener);
    }

    void informHmi() {
        if (!this.fakeListActive) {
            ListManager.getGenericASLList(10126).updateList(ASLCarContainer.collector);
        } else {
            ListManager.getGenericASLList(10126).updateList(ASLCarContainer.tempCollector);
        }
    }

    void informHmiFPAisAvailable(boolean bl) {
        HsmTargetCarViewOption.writeBooleanToDatapool(10275, bl);
    }

    void registerFunction(int n, boolean bl) {
        switch (n) {
            case 0: {
                if (bl) {
                    this.dsiCarDriverAssistance.setNotification(24, (DSIListener)this.dsiCarDriverAssistanceListener);
                    break;
                }
                this.dsiCarDriverAssistance.clearNotification(24, (DSIListener)this.dsiCarDriverAssistanceListener);
                break;
            }
            case 1: {
                if (bl) {
                    this.dsiCarDriverAssistance.setNotification(30, (DSIListener)this.dsiCarDriverAssistanceListener);
                    break;
                }
                this.dsiCarDriverAssistance.clearNotification(30, (DSIListener)this.dsiCarDriverAssistanceListener);
                break;
            }
            case 16: 
            case 26: {
                if (this.isWindow || this.isCentralLocking) {
                    this.dsiCarComfort.setNotification(5, (DSIListener)this.dsiCarComfortListener);
                    break;
                }
                this.dsiCarComfort.clearNotification(5, (DSIListener)this.dsiCarComfortListener);
                break;
            }
            case 10: {
                if (bl) {
                    this.dsiCarLight.setNotification(12, (DSIListener)this.dsiCarLightListener);
                    break;
                }
                this.dsiCarLight.clearNotification(12, (DSIListener)this.dsiCarLightListener);
                break;
            }
            case 9: {
                if (bl) {
                    this.dsiCarLight.setNotification(1, (DSIListener)this.dsiCarLightListener);
                    break;
                }
                this.dsiCarLight.clearNotification(1, (DSIListener)this.dsiCarLightListener);
                break;
            }
            case 3: {
                if (bl) {
                    this.dsiCarDriverAssistance.setNotification(19, (DSIListener)this.dsiCarDriverAssistanceListener);
                    break;
                }
                this.dsiCarDriverAssistance.clearNotification(19, (DSIListener)this.dsiCarDriverAssistanceListener);
                break;
            }
            case 11: {
                if (bl) {
                    this.dsiCarComfort.setNotification(39, (DSIListener)this.dsiCarComfortListener);
                    break;
                }
                this.dsiCarComfort.clearNotification(39, (DSIListener)this.dsiCarComfortListener);
                break;
            }
            case 8: {
                if (bl) {
                    this.dsiCarParkingSystem.setNotification(1, (DSIListener)this.dsiCarParkingSystemListener);
                    break;
                }
                this.dsiCarParkingSystem.clearNotification(1, (DSIListener)this.dsiCarParkingSystemListener);
                break;
            }
            case 13: {
                if (bl) {
                    this.dsiCarSeat.setNotification(1, (DSIListener)this.dsiCarSeatListener);
                    break;
                }
                this.dsiCarSeat.clearNotification(1, (DSIListener)this.dsiCarSeatListener);
                break;
            }
            case 5: 
            case 29: {
                if (bl) {
                    this.dsiCarComfort.setNotification(1, (DSIListener)this.dsiCarComfortListener);
                    break;
                }
                this.dsiCarComfort.clearNotification(1, (DSIListener)this.dsiCarComfortListener);
                break;
            }
            case 17: {
                if (bl) {
                    this.dsiCarVehicleStates.setNotification(3, (DSIListener)this.dsiCarVehicleStateListener);
                    break;
                }
                this.dsiCarVehicleStates.clearNotification(3, (DSIListener)this.dsiCarVehicleStateListener);
                break;
            }
            case 18: {
                if (bl) {
                    this.dsiCarKombi.setNotification(1, (DSIListener)this.dsiCarKombiListener);
                    break;
                }
                this.dsiCarKombi.clearNotification(1, (DSIListener)this.dsiCarKombiListener);
                break;
            }
            case 2: {
                if (bl) {
                    this.dsiCarDriverAssistance.setNotification(1, (DSIListener)this.dsiCarDriverAssistanceListener);
                    break;
                }
                this.dsiCarDriverAssistance.clearNotification(1, (DSIListener)this.dsiCarDriverAssistanceListener);
                break;
            }
            case 14: {
                if (bl) {
                    this.dsiCarComfort.setNotification(33, (DSIListener)this.dsiCarComfortListener);
                    break;
                }
                this.dsiCarComfort.clearNotification(33, (DSIListener)this.dsiCarComfortListener);
                break;
            }
            case 12: {
                if (bl) {
                    this.dsiCarComfort.setNotification(21, (DSIListener)this.dsiCarComfortListener);
                    break;
                }
                this.dsiCarComfort.clearNotification(21, (DSIListener)this.dsiCarComfortListener);
                break;
            }
            case 15: {
                if (bl) {
                    this.dsiCarKombi.setNotification(4, (DSIListener)this.dsiCarKombiListener);
                    break;
                }
                this.dsiCarKombi.clearNotification(4, (DSIListener)this.dsiCarKombiListener);
                break;
            }
            case 19: {
                if (bl) {
                    this.dsiCarEco.setNotification(1, (DSIListener)this.dsiCarEcoListener);
                    break;
                }
                this.dsiCarEco.clearNotification(1, (DSIListener)this.dsiCarEcoListener);
                break;
            }
            case 21: {
                if (bl) {
                    this.dsiCarEco.setNotification(12, (DSIListener)this.dsiCarEcoListener);
                    break;
                }
                this.dsiCarEco.clearNotification(12, (DSIListener)this.dsiCarEcoListener);
                break;
            }
            case 20: {
                if (bl) {
                    this.dsiCarVehicleStates.setNotification(11, (DSIListener)this.dsiCarVehicleStateListener);
                    break;
                }
                this.dsiCarVehicleStates.clearNotification(11, (DSIListener)this.dsiCarVehicleStateListener);
                break;
            }
            case 7: {
                if (bl) {
                    this.dsiCarDriverAssistance.setNotification(44, (DSIListener)this.dsiCarDriverAssistanceListener);
                    break;
                }
                this.dsiCarDriverAssistance.clearNotification(44, (DSIListener)this.dsiCarDriverAssistanceListener);
                break;
            }
            case 28: {
                if (bl) {
                    this.dsiCarDriverAssistance.setNotification(35, (DSIListener)this.dsiCarDriverAssistanceListener);
                    break;
                }
                this.dsiCarDriverAssistance.clearNotification(35, (DSIListener)this.dsiCarDriverAssistanceListener);
                break;
            }
            case 22: {
                if (bl) {
                    this.dsiCarTimeUnitsLanguage.setNotification(1, (DSIListener)this.dsiCarTimeUnitsLanguageListener);
                    break;
                }
                this.dsiCarTimeUnitsLanguage.clearNotification(1, (DSIListener)this.dsiCarTimeUnitsLanguageListener);
                break;
            }
            case 23: {
                if (bl) {
                    this.dsiCarTimeUnitsLanguage.setNotification(10, (DSIListener)this.dsiCarTimeUnitsLanguageListener);
                    break;
                }
                this.dsiCarTimeUnitsLanguage.clearNotification(10, (DSIListener)this.dsiCarTimeUnitsLanguageListener);
                break;
            }
            case 24: {
                if (bl) {
                    this.dsiCarKombi.setNotification(37, (DSIListener)this.dsiCarKombiListener);
                    break;
                }
                this.dsiCarKombi.clearNotification(37, (DSIListener)this.dsiCarKombiListener);
                break;
            }
            case 27: {
                if (bl) {
                    this.dsiCarDriverAssistance.setNotification(58, (DSIListener)this.dsiCarDriverAssistanceListener);
                    break;
                }
                this.dsiCarDriverAssistance.clearNotification(58, (DSIListener)this.dsiCarDriverAssistanceListener);
                break;
            }
            case 31: {
                break;
            }
            case 32: {
                break;
            }
            case 34: {
                if (bl) {
                    this.dsiCarEco.setNotification(42, (DSIListener)this.dsiCarEcoListener);
                    break;
                }
                this.dsiCarEco.clearNotification(42, (DSIListener)this.dsiCarEcoListener);
                break;
            }
            case 35: {
                if (bl) {
                    this.dsiCarComfort.setNotification(29, (DSIListener)this.dsiCarComfortListener);
                    break;
                }
                this.dsiCarComfort.clearNotification(29, (DSIListener)this.dsiCarComfortListener);
                break;
            }
            case 37: {
                if (bl) {
                    this.dsiCarDrivingCharacteristics.setNotification(1, (DSIListener)this.dsiCarDrivingCharacteristicsListener);
                    break;
                }
                this.dsiCarDrivingCharacteristics.clearNotification(1, (DSIListener)this.dsiCarDrivingCharacteristicsListener);
                break;
            }
            case 36: {
                if (bl) {
                    this.dsiCarDriverAssistance.setNotification(8, (DSIListener)this.dsiCarDriverAssistanceListener);
                    break;
                }
                this.dsiCarDriverAssistance.clearNotification(8, (DSIListener)this.dsiCarDriverAssistanceListener);
                break;
            }
        }
    }

    private boolean availability(int[] nArray, boolean[] blArray, CarFunctionCollector[] carFunctionCollectorArray) {
        for (int i2 = nArray.length - 1; i2 >= 0; --i2) {
            if (!carFunctionCollectorArray[nArray[i2]].functionAvailable || !blArray[nArray[i2]]) continue;
            return true;
        }
        return false;
    }

    private boolean existentSubFunction(boolean[] blArray, int[] nArray) {
        int n = 0;
        for (int i2 = nArray.length - 1; i2 >= 0; --i2) {
            if (blArray[nArray[i2]]) continue;
            ++n;
        }
        return n == nArray.length;
    }

    public void parentChildRelation(int[] nArray, int n, CarFunctionCollector[] carFunctionCollectorArray, boolean[] blArray) {
        if (!this.existentSubFunction(blArray, nArray)) {
            ASLCarContainer.functionExistent[n] = true;
            if (this.availability(nArray, blArray, carFunctionCollectorArray)) {
                this.availabilityReason(carFunctionCollectorArray, n, true, 0);
            } else {
                this.availabilityReason(carFunctionCollectorArray, n, false, this.mainReason(carFunctionCollectorArray, nArray));
            }
        } else {
            ASLCarContainer.functionExistent[n] = false;
        }
        this.factorySettings(n);
        this.informHmi();
    }

    private void factorySettings(int n) {
        switch (n) {
            case 9: {
                this.evaluateFactorySettings(n, 113);
                break;
            }
            case 10: {
                this.evaluateFactorySettings(n, 114);
                break;
            }
            case 11: {
                this.evaluateFactorySettings(n, 115);
                break;
            }
            case 12: {
                this.evaluateFactorySettings(n, 116);
                break;
            }
            case 13: {
                this.evaluateFactorySettings(n, 117);
                break;
            }
            case 14: {
                if (this.isRgsFactorySetting) {
                    this.evaluateFactorySettings(n, 118);
                    break;
                }
                ASLCarContainer.functionExistent[118] = false;
                this.parentChildRelation(FunctionIds.CHILD_FACTORY_SETTINGS, 19, ASLCarContainer.collector, ASLCarContainer.functionExistent);
                break;
            }
            case 15: {
                this.evaluateFactorySettings(n, 119);
                break;
            }
            case 123: {
                break;
            }
            case 152: {
                this.evaluateFactorySettings(n, 171);
                break;
            }
            case 153: {
                this.evaluateFactorySettings(n, 172);
                break;
            }
            case 188: {
                this.evaluateFactorySettings(n, 197);
                break;
            }
            case 187: {
                this.evaluateFactorySettings(n, 136);
                break;
            }
        }
    }

    private void evaluateFactorySettings(int n, int n2) {
        if (!ASLCarContainer.functionExistent[n]) {
            ASLCarContainer.functionExistent[n2] = false;
        } else {
            if (!ASLCarContainer.functionExistent[n2]) {
                ASLCarContainer.functionExistent[n2] = true;
            }
            ASLCarContainer.collector[n2] = ASLCarContainer.collector[n];
        }
        this.parentChildRelation(FunctionIds.CHILD_FACTORY_SETTINGS, 19, ASLCarContainer.collector, ASLCarContainer.functionExistent);
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(101)) {
            ASLCarContainer.functionExistent[n2] = false;
            ASLCarContainer.functionExistent[112] = true;
            ASLCarContainer.collector[112] = new CarFunctionCollector(true, 0);
            ASLCarContainer.functionExistent[19] = true;
            ASLCarContainer.collector[19] = new CarFunctionCollector(true, 0);
        }
    }

    private void availabilityReason(CarFunctionCollector[] carFunctionCollectorArray, int n, boolean bl, int n2) {
        carFunctionCollectorArray[n] = new CarFunctionCollector(bl, n2);
    }

    private int mainReason(CarFunctionCollector[] carFunctionCollectorArray, int[] nArray) {
        int n;
        int[] nArray2 = new int[6];
        block8: for (n = nArray.length - 1; n >= 0; --n) {
            switch (carFunctionCollectorArray[nArray[n]].functionReason) {
                case 2: {
                    return 2;
                }
                case 3: {
                    nArray2[0] = 3;
                    continue block8;
                }
                case 4: {
                    nArray2[1] = 4;
                    continue block8;
                }
                case 5: {
                    nArray2[2] = 5;
                    continue block8;
                }
                case 1: {
                    nArray2[3] = 1;
                    continue block8;
                }
                case 7: {
                    nArray2[4] = 7;
                    continue block8;
                }
                default: {
                    nArray2[5] = 6;
                }
            }
        }
        n = 0;
        for (int i2 = 0; i2 < nArray2.length; ++i2) {
            if (nArray2[i2] == 0) continue;
            n = nArray2[i2];
            break;
        }
        return n;
    }

    void existentParentChild(int n, int[] nArray) {
        ASLCarContainer.functionExistent[n] = this.exists(nArray);
    }

    private boolean exists(int[] nArray) {
        for (int i2 = nArray.length - 1; i2 >= 0; --i2) {
            if (!ASLCarContainer.functionExistent[nArray[i2]]) continue;
            return true;
        }
        return false;
    }

    void informClamp15(boolean bl) {
        if (!bl) {
            for (int i2 = FunctionIds.PARENT_SETUPMENU.length - 1; i2 >= 0; --i2) {
                ASLCarContainer.collector[FunctionIds.PARENT_SETUPMENU[i2]].functionAvailable = bl;
                ASLCarContainer.collector[FunctionIds.PARENT_SETUPMENU[i2]].functionReason = 2;
            }
            ASLCarContainer.tempCollector = (CarFunctionCollector[])ASLCarContainer.collector.clone();
            ListManager.getGenericASLList(10126).updateList(ASLCarContainer.tempCollector);
            this.fakeListActive = true;
        } else {
            for (int i3 = FunctionIds.PARENT_SETUPMENU.length - 1; i3 >= 0; --i3) {
                if (ASLCarContainer.collector[FunctionIds.PARENT_SETUPMENU[i3]].functionReason != 2 || ASLCarContainer.oldSettings[i3] == null) continue;
                ASLCarContainer.collector[FunctionIds.PARENT_SETUPMENU[i3]].functionAvailable = ASLCarContainer.oldSettings[i3].functionAvailable;
                ASLCarContainer.collector[FunctionIds.PARENT_SETUPMENU[i3]].functionReason = ASLCarContainer.oldSettings[i3].functionReason;
            }
            this.fakeListActive = false;
            this.informHmi();
        }
    }

    void rememberOldSettingsSetupMain() {
        for (int i2 = FunctionIds.PARENT_SETUPMENU.length - 1; i2 >= 0; --i2) {
            ASLCarContainer.oldSettings[i2] = new CarFunctionCollector(ASLCarContainer.collector[FunctionIds.PARENT_SETUPMENU[i2]].functionAvailable, ASLCarContainer.collector[FunctionIds.PARENT_SETUPMENU[i2]].functionReason);
        }
    }

    void evaluateCarFunctionSpeedThreshold(boolean bl) {
        this.isSpeedToHighActive = bl;
        if (bl) {
            this.fillHmiList(ASLCarContainer.getInstance().getMenuSpeedThreshold(), 3);
        } else {
            for (int i2 = ASLCarContainer.getInstance().getMenuSpeedThreshold().length - 1; i2 >= 0; --i2) {
                if (!ASLCarContainer.getInstance().getMenuSpeedThreshold()[i2] || !ASLCarContainer.getInstance().isMenuCoded(i2)) continue;
                this.gettingFunctionGroup(i2, 100);
            }
        }
    }

    protected void evaluateCarFunctionStandStill(boolean bl) {
        this.isStandStillActive = bl;
        if (!bl) {
            this.fillHmiList(ASLCarContainer.getInstance().getMenuStandStill(), 7);
        } else {
            for (int i2 = ASLCarContainer.getInstance().getMenuStandStill().length - 1; i2 >= 0; --i2) {
                if (!ASLCarContainer.getInstance().getMenuStandStill()[i2] || !ASLCarContainer.getInstance().isMenuCoded(i2)) continue;
                this.gettingFunctionGroup(i2, 200);
            }
        }
        this.dsiGeneralVehicleState.setNotification(new int[]{7}, (DSIListener)this.dsiGeneralVehicleStateListener);
    }

    private void fillHmiList(boolean[] blArray, int n) {
        for (int i2 = blArray.length - 1; i2 >= 0; --i2) {
            if (!blArray[i2] || !ASLCarContainer.getInstance().isMenuCoded(i2)) continue;
            this.gettingFunctionGroup(i2, n);
        }
    }

    private void gettingFunctionGroup(int n, int n2) {
        switch (n) {
            case 0: {
                this.overwriteViewOptions(FunctionIds.EXISTENT_ACC, n2);
                this.parentChildRelation(FunctionIds.CHILD_ASSISTANTS_DRIVING, 9, ASLCarContainer.collector, ASLCarContainer.functionExistent);
                break;
            }
            case 1: {
                this.overwriteViewOptions(FunctionIds.EXISTENT_AWV, n2);
                this.parentChildRelation(FunctionIds.CHILD_ASSISTANTS_DRIVING, 9, ASLCarContainer.collector, ASLCarContainer.functionExistent);
                break;
            }
            case 2: {
                this.overwriteViewOptions(FunctionIds.EXISTENT_SWA, n2);
                this.parentChildRelation(FunctionIds.CHILD_ASSISTANTS_DRIVING, 9, ASLCarContainer.collector, ASLCarContainer.functionExistent);
                break;
            }
            case 3: {
                this.overwriteViewOptions(FunctionIds.EXISTENT_HCA, n2);
                this.parentChildRelation(FunctionIds.CHILD_ASSISTANTS_DRIVING, 9, ASLCarContainer.collector, ASLCarContainer.functionExistent);
                break;
            }
            case 4: {
                this.overwriteViewOptions(FunctionIds.EXISTENT_BRAKE, n2);
                this.parentChildRelation(FunctionIds.CHILD_PARKING, 10, ASLCarContainer.collector, ASLCarContainer.functionExistent);
                break;
            }
            case 5: {
                this.overwriteViewOptions(FunctionIds.EXISTENT_SEAT_MEMORY, n2);
                this.parentChildRelation(FunctionIds.CHILD_SEATS, 14, ASLCarContainer.collector, ASLCarContainer.functionExistent);
                break;
            }
            case 29: {
                this.overwriteViewOptions(FunctionIds.EXISTENT_PRE_CRASH, n2);
                this.parentChildRelation(FunctionIds.CHILD_ASSISTANTS_DRIVING, 9, ASLCarContainer.collector, ASLCarContainer.functionExistent);
                break;
            }
            case 6: {
                this.overwriteViewOptions(FunctionIds.EXISTENT_VZA, n2);
                this.parentChildRelation(FunctionIds.CHILD_ASSISTANTS_DRIVING, 9, ASLCarContainer.collector, ASLCarContainer.functionExistent);
                break;
            }
            case 7: {
                this.overwriteViewOptions(FunctionIds.EXISTENT_MKE, n2);
                this.parentChildRelation(FunctionIds.CHILD_ASSISTANTS_DRIVING, 9, ASLCarContainer.collector, ASLCarContainer.functionExistent);
                break;
            }
            case 8: {
                this.overwriteViewOptions(FunctionIds.EXISTENT_PARKING_ASSISTANTS, n2);
                this.parentChildRelation(FunctionIds.CHILD_PARKING, 10, ASLCarContainer.collector, ASLCarContainer.functionExistent);
                break;
            }
            case 9: {
                this.overwriteViewOptions(FunctionIds.EXISTENT_INTERIEUR_LIGHT, n2);
                this.parentChildRelation(FunctionIds.CHILD_LIGHT, 11, ASLCarContainer.collector, ASLCarContainer.functionExistent);
                if (!this.isAmbienceLight) break;
                this.overwriteViewOptions(FunctionIds.CHILD_AMBIENCELIGHT, n2);
                this.parentChildRelation(FunctionIds.CHILD_AMBIENCELIGHT, 123, ASLCarContainer.collector, ASLCarContainer.functionExistent);
                break;
            }
            case 10: {
                this.overwriteViewOptions(FunctionIds.EXISTENT_EXTERIEUR_LIGHT, n2);
                this.parentChildRelation(FunctionIds.CHILD_LIGHT, 11, ASLCarContainer.collector, ASLCarContainer.functionExistent);
                break;
            }
            case 11: {
                this.overwriteViewOptions(FunctionIds.EXISTENT_MIRROR, n2);
                this.parentChildRelation(FunctionIds.CHILD_MIRRORWIPER, 12, ASLCarContainer.collector, ASLCarContainer.functionExistent);
                break;
            }
            case 12: {
                this.overwriteViewOptions(FunctionIds.EXISTENT_WIPER, n2);
                this.parentChildRelation(FunctionIds.CHILD_MIRRORWIPER, 12, ASLCarContainer.collector, ASLCarContainer.functionExistent);
                break;
            }
            case 13: {
                this.overwriteViewOptions(FunctionIds.EXISTENT_SEAT_MEMORY, n2);
                this.parentChildRelation(FunctionIds.CHILD_SEATS, 14, ASLCarContainer.collector, ASLCarContainer.functionExistent);
                break;
            }
            case 14: {
                this.overwriteViewOptions(FunctionIds.EXISTENT_RDK_VEHICLESTATUS, n2);
                this.parentChildRelation(FunctionIds.CHILD_TIRES, 8, ASLCarContainer.collector, ASLCarContainer.functionExistent);
                this.parentChildRelation(FunctionIds.CHILD_VEHICLESTATUS, 3, ASLCarContainer.collector, ASLCarContainer.functionExistent);
                break;
            }
            case 15: {
                this.overwriteViewOptions(FunctionIds.EXISTENT_BC_MFA, n2);
                this.parentChildRelation(FunctionIds.CHILD_MFASETUP, 15, ASLCarContainer.collector, ASLCarContainer.functionExistent);
                this.overwriteViewOptions(FunctionIds.EXISTENT_RDK_SPEEDWARNING, n2);
                this.parentChildRelation(FunctionIds.CHILD_TIRES, 8, ASLCarContainer.collector, ASLCarContainer.functionExistent);
                break;
            }
            case 26: {
                this.overwriteViewOptions(FunctionIds.EXISTENT_DOORLOCKING, n2);
                this.parentChildRelation(FunctionIds.CHILD_OPENCLOSE, 13, ASLCarContainer.collector, ASLCarContainer.functionExistent);
                break;
            }
            case 16: {
                this.overwriteViewOptions(FunctionIds.EXISTENT_WINDOW, n2);
                this.parentChildRelation(FunctionIds.CHILD_OPENCLOSE, 13, ASLCarContainer.collector, ASLCarContainer.functionExistent);
                break;
            }
            case 17: {
                break;
            }
            case 18: {
                break;
            }
            case 19: {
                break;
            }
            case 20: {
                break;
            }
            case 21: {
                break;
            }
            case 22: {
                this.overwriteViewOptions(FunctionIds.EXISTENT_CLOCK, n2);
                this.parentChildRelation(FunctionIds.CHILD_CLOCK, 16, ASLCarContainer.collector, ASLCarContainer.functionExistent);
                break;
            }
            case 23: {
                this.overwriteViewOptions(FunctionIds.EXISTENT_UNITMASTER, n2);
                this.parentChildRelation(FunctionIds.CHILD_UNITMASTER, 17, ASLCarContainer.collector, ASLCarContainer.functionExistent);
                break;
            }
            case 33: {
                break;
            }
            case 25: {
                this.overwriteViewOptions(FunctionIds.EXISTENT_PARKHEATING, n2);
                break;
            }
            case 24: {
                this.overwriteViewOptions(FunctionIds.EXISTENT_HUD, n2);
                this.parentChildRelation(FunctionIds.CHILD_HUD, 188, ASLCarContainer.collector, ASLCarContainer.functionExistent);
                break;
            }
            case 27: {
                this.overwriteViewOptions(FunctionIds.EXISTENT_PEDESTRIAN_PROTECTION, n2);
                this.parentChildRelation(FunctionIds.CHILD_ASSISTANTS_DRIVING, 9, ASLCarContainer.collector, ASLCarContainer.functionExistent);
                break;
            }
            case 31: {
                this.overwriteViewOptions(FunctionIds.EXISTENT_CLIMATE, n2);
                this.parentChildRelation(FunctionIds.CHILD_CLIMATE, 152, ASLCarContainer.collector, ASLCarContainer.functionExistent);
                break;
            }
            case 28: {
                this.overwriteViewOptions(FunctionIds.EXISTENT_VZE, n2);
                this.parentChildRelation(FunctionIds.CHILD_ASSISTANTS_DRIVING, 9, ASLCarContainer.collector, ASLCarContainer.functionExistent);
                break;
            }
            case 32: {
                this.overwriteViewOptions(FunctionIds.EXISTENT_BATTERY, n2);
                this.parentChildRelation(FunctionIds.CHILD_CAR_BATTERY_MANAGEMENT, 138, ASLCarContainer.collector, ASLCarContainer.functionExistent);
                break;
            }
            case 34: {
                this.overwriteViewOptions(FunctionIds.EXISTENT_PEA, n2);
                this.parentChildRelation(FunctionIds.CHILD_ASSISTANTS_DRIVING, 9, ASLCarContainer.collector, ASLCarContainer.functionExistent);
                break;
            }
            case 35: {
                this.overwriteViewOptions(FunctionIds.EXISTENT_UGDO, n2);
                this.parentChildRelation(FunctionIds.CHILD_OPENCLOSE, 13, ASLCarContainer.collector, ASLCarContainer.functionExistent);
                break;
            }
            case 30: {
                this.overwriteViewOptions(FunctionIds.EXISTENT_PERSONALIZATION, n2);
                this.parentChildRelation(FunctionIds.CHILD_PERSONALIZATION, 153, ASLCarContainer.collector, ASLCarContainer.functionExistent);
                break;
            }
            case 36: {
                this.overwriteViewOptions(FunctionIds.EXISTENT_NV, n2);
                this.parentChildRelation(FunctionIds.CHILD_ASSISTANTS_DRIVING, 9, ASLCarContainer.collector, ASLCarContainer.functionExistent);
                break;
            }
        }
    }

    private void overwriteViewOptions(int[] nArray, int n) {
        block4: for (int i2 = nArray.length - 1; i2 >= 0; --i2) {
            switch (n) {
                case 100: {
                    if (ASLCarContainer.collector[nArray[i2]].functionAvailable || ASLCarContainer.collector[nArray[i2]].functionReason != 3) continue block4;
                    ASLCarContainer.collector[nArray[i2]].functionAvailable = true;
                    ASLCarContainer.collector[nArray[i2]].functionReason = 0;
                    continue block4;
                }
                case 200: {
                    if (ASLCarContainer.collector[nArray[i2]].functionAvailable || ASLCarContainer.collector[nArray[i2]].functionReason != 7) continue block4;
                    ASLCarContainer.collector[nArray[i2]].functionAvailable = true;
                    ASLCarContainer.collector[nArray[i2]].functionReason = 0;
                    continue block4;
                }
                default: {
                    if (!ASLCarContainer.collector[nArray[i2]].functionAvailable) continue block4;
                    ASLCarContainer.collector[nArray[i2]].functionAvailable = false;
                    ASLCarContainer.collector[nArray[i2]].functionReason = n;
                }
            }
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


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.fpa;

import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.car.ASLCarContainer;
import de.vw.mib.asl.internal.car.ASLCarUtil;
import de.vw.mib.asl.internal.car.fpa.StateWork;
import de.vw.mib.asl.internal.car.fpa.mlb511.StateWork511;
import de.vw.mib.asl.internal.car.fpa.transformer.CarFpaFunctionListCollector;
import de.vw.mib.asl.internal.car.fpa.transformer.CollectorFPASettings;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import generated.de.vw.mib.asl.internal.ListManager;
import java.util.ArrayList;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.cardrivingcharacteristics.CharismaListUpdateInfo;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithOptionMask;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithoutOptionMask;
import org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics;
import org.dsi.ifc.carvehiclestates.DSICarVehicleStates;
import org.dsi.ifc.carvehiclestates.DSICarVehicleStatesListener;
import org.dsi.ifc.powermanagement.DSIPowerManagement;
import org.dsi.ifc.powermanagement.DSIPowerManagementListener;

public class HsmTargetFPA
extends AbstractASLHsmTarget {
    protected DSICarDrivingCharacteristics dsiCarFpa;
    private DSIListener dsiFpaListener;
    protected DSIPowerManagement dsiPowerManagement;
    private DSIPowerManagementListener dsiPowerManagementListener;
    private DSICarVehicleStates dsiCarVehicleStates;
    private DSICarVehicleStatesListener dsiCarVehicleStatesListener;
    ArrayList setupSettingsProfile = new ArrayList();
    ArrayList cachingRequests = new ArrayList();
    int currentProfile;
    private CharismaSetupTableWithoutOptionMask[] currentSettings;
    private static boolean[] optionMask = new boolean[]{false, false, false, false, false, false};
    private CharismaSetupTableWithoutOptionMask values;
    boolean cancelByHmi = false;
    private boolean isDCC = false;
    boolean isContinuousDamperAvailable = false;
    int currentContinuousDamperValue = 0;
    int configDcc = -1;
    private int currentConfigDcc = -1;
    int displayContent = -1;
    boolean isHmiIsReady = false;
    boolean isGTEDetected = false;
    boolean isOffraodFpa = false;
    private HsmState stateWork;
    static /* synthetic */ Class class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristics;
    static /* synthetic */ Class class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristicsListener;
    static /* synthetic */ Class class$org$dsi$ifc$powermanagement$DSIPowerManagement;
    static /* synthetic */ Class class$org$dsi$ifc$powermanagement$DSIPowerManagementListener;
    static /* synthetic */ Class class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates;
    static /* synthetic */ Class class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener;

    public HsmTargetFPA(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getDefaultTargetId() {
        return -1857089024;
    }

    @Override
    protected HsmState getDefaultState() {
        if (this.stateWork == null) {
            if (ServiceManager.configManagerDiag.isFeatureFlagSet(10)) {
                this.stateWork = new StateWork511(this, this.hsm, "stateMain511", this.getWorkStateParent());
                StateWork511.setupInitialCharismaList(this.setupSettingsProfile);
            } else {
                this.stateWork = new StateWork(this, this.hsm, "stateMain", this.getWorkStateParent());
            }
        }
        return this.stateWork;
    }

    @Override
    public int getSubClassifier() {
        return 1;
    }

    void init() {
        this.dsiCarFpa = (DSICarDrivingCharacteristics)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristics == null ? (class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristics = HsmTargetFPA.class$("org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics")) : class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristics);
        this.dsiFpaListener = ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristicsListener == null ? (class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristicsListener = HsmTargetFPA.class$("org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener")) : class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristicsListener);
        this.dsiPowerManagement = (DSIPowerManagement)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$powermanagement$DSIPowerManagement == null ? (class$org$dsi$ifc$powermanagement$DSIPowerManagement = HsmTargetFPA.class$("org.dsi.ifc.powermanagement.DSIPowerManagement")) : class$org$dsi$ifc$powermanagement$DSIPowerManagement);
        this.dsiPowerManagementListener = (DSIPowerManagementListener)ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$powermanagement$DSIPowerManagementListener == null ? (class$org$dsi$ifc$powermanagement$DSIPowerManagementListener = HsmTargetFPA.class$("org.dsi.ifc.powermanagement.DSIPowerManagementListener")) : class$org$dsi$ifc$powermanagement$DSIPowerManagementListener);
        this.dsiCarVehicleStates = (DSICarVehicleStates)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates == null ? (class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates = HsmTargetFPA.class$("org.dsi.ifc.carvehiclestates.DSICarVehicleStates")) : class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates);
        this.dsiCarVehicleStatesListener = (DSICarVehicleStatesListener)ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener == null ? (class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener = HsmTargetFPA.class$("org.dsi.ifc.carvehiclestates.DSICarVehicleStatesListener")) : class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener);
    }

    void registerOnModelEvents() {
        this.addObservers(new int[]{1460404288, 1611399232, 1510735936, 1527513152, 1628176448, 1477181504, 688717888, 705495104, 1242366016, 1259143232, 1594622016, 1745616960, 1544290368, 1225588800, -1962147776, 1644953664, 1963720768, 1846280256, 1812725824, 1879834688, 1712062528, 1695285312, 1678508096, 2030829632, 1980497984, -2046033856, -2029256640, 0x4D0D0040, 1359806528, 1376583744, 2097938496, -2146697152, -1978924992, 1728839744, 1863057472, -1995702208, -2012479424, 1275920448, 2047606848, 1309474880, 1997275200, 1795948608, 2131492928, -2129919936, 1896611904, 1762394176, 2081161280, 1661730880, 1946943552, 1913389120, 1829503040, 2064384064, 1779171392, -2113142720, 2114715712, -317980608, -200540096, -133431232, 906698752});
    }

    void registerOnCarFpaViewOptions() {
        this.dsiCarFpa.setNotification(new int[]{12, 15}, this.dsiFpaListener);
        ASLCarContainer.getInstance().getDSIProxy().addResponseListener(this, class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristicsListener == null ? (class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristicsListener = HsmTargetFPA.class$("org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener")) : class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristicsListener, this.dsiFpaListener);
    }

    void registerActiveProfile() {
        this.dsiCarFpa.setNotification(13, this.dsiFpaListener);
    }

    void clearActiveProfile() {
        this.dsiCarFpa.clearNotification(13, this.dsiFpaListener);
    }

    void registerOnCarFpaListUpdateInfo() {
        this.dsiCarFpa.setNotification(14, this.dsiFpaListener);
    }

    void clearListUpdateInfo() {
        this.dsiCarFpa.clearNotification(14, this.dsiFpaListener);
    }

    void registerOnCarClampSignal() {
        this.dsiPowerManagement.setNotification(4, (DSIListener)this.dsiPowerManagementListener);
    }

    void registerOnVehicleStatesMidFrequent() {
        this.dsiCarVehicleStates.setNotification(15, (DSIListener)this.dsiCarVehicleStatesListener);
    }

    void showCharismaPopup(int n, int n2) {
        this.dsiCarFpa.showCharismaPopup(n, n2);
    }

    void cancelPopup(int n, int n2) {
        this.dsiCarFpa.cancelCharismaPopup(n, n2);
        this.sendHMIEvent(10013);
        this.cancelByHmi = true;
    }

    void setProfile(int n) {
        this.dsiCarFpa.setCharismaActiveProfile(n);
    }

    void requestCharismaList(CharismaListUpdateInfo charismaListUpdateInfo) {
        this.dsiCarFpa.requestCharismaList(charismaListUpdateInfo);
    }

    void requestCharismaFuntion(int n, CharismaSetupTableWithoutOptionMask[] charismaSetupTableWithoutOptionMaskArray) {
        this.dsiCarFpa.requestCharismaProfileFunction(n, charismaSetupTableWithoutOptionMaskArray);
    }

    void informHMIAvailableProfiles(boolean[] blArray) {
        HsmTargetFPA.writeFlagVectorToDatapool(10278, blArray);
    }

    void informHMIActiveProfile(int n) {
        HsmTargetFPA.writeIntegerToDatapool(10277, n);
    }

    void activeProfile(int n) {
        if (!this.isGTEDetected) {
            switch (n) {
                case 1: {
                    this.currentProfile = 1;
                    this.informHMIActiveProfile(1);
                    break;
                }
                case 2: {
                    this.currentProfile = 2;
                    this.informHMIActiveProfile(2);
                    break;
                }
                case 6: {
                    this.currentProfile = 6;
                    this.informHMIActiveProfile(6);
                    break;
                }
                case 4: {
                    this.currentProfile = 4;
                    this.informHMIActiveProfile(this.isOffraodFpa ? 10 : 4);
                    break;
                }
                case 5: {
                    this.currentProfile = 5;
                    this.informHMIActiveProfile(5);
                    break;
                }
                case 7: {
                    this.currentProfile = 7;
                    this.informHMIActiveProfile(7);
                    break;
                }
                case 3: {
                    this.currentProfile = 3;
                    this.informHMIActiveProfile(3);
                    break;
                }
                case 8: {
                    this.currentProfile = 8;
                    this.informHMIActiveProfile(8);
                    break;
                }
                case 10: {
                    this.currentProfile = 10;
                    this.informHMIActiveProfile(9);
                    break;
                }
                case 11: {
                    this.currentProfile = 11;
                    this.informHMIActiveProfile(11);
                    break;
                }
                default: {
                    if (!this.isTraceEnabled()) break;
                    this.trace().append("[ERROR] selection of the active profile not exists!").log();
                }
            }
            this.informHmiAboutCurrentSettings(this.currentProfile);
        }
    }

    CharismaSetupTableWithoutOptionMask[] settingUpCharismaSettings(int n, int n2) {
        for (int i2 = this.currentSettings.length - 1; i2 >= 0; --i2) {
            if (this.currentSettings[i2].functionID != n) continue;
            this.currentSettings[i2].setupValue = n2;
            break;
        }
        return this.currentSettings;
    }

    boolean isToRequest(int n) {
        for (int i2 = this.setupSettingsProfile.size() - 1; i2 >= 0; --i2) {
            if (((CollectorFPASettings)this.setupSettingsProfile.get((int)i2)).profileID != n) continue;
            return false;
        }
        return true;
    }

    boolean isWithoutOptionsMask() {
        return this.cachingRequests.size() == 1 ? ((CharismaListUpdateInfo)this.cachingRequests.get((int)0)).recordContent == 2 : this.cachingRequests.size() == 0;
    }

    void resetFPAFunctionList() {
        Object[] objectArray = new CarFpaFunctionListCollector[53];
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            objectArray[i2] = new CarFpaFunctionListCollector(false, optionMask);
        }
        ListManager.getGenericASLList(10279).updateList(objectArray);
        ListManager.getGenericASLList(10280).updateList(objectArray);
    }

    public static CarFpaFunctionListCollector[] createEmptyFunctionListCollector() {
        CarFpaFunctionListCollector[] carFpaFunctionListCollectorArray = new CarFpaFunctionListCollector[53];
        for (int i2 = 0; i2 < carFpaFunctionListCollectorArray.length; ++i2) {
            carFpaFunctionListCollectorArray[i2] = new CarFpaFunctionListCollector(false, optionMask);
        }
        return carFpaFunctionListCollectorArray;
    }

    void rememberSettings(int n, int n2, CharismaSetupTableWithOptionMask[] charismaSetupTableWithOptionMaskArray) {
        CharismaSetupTableWithoutOptionMask[] charismaSetupTableWithoutOptionMaskArray = new CharismaSetupTableWithoutOptionMask[charismaSetupTableWithOptionMaskArray.length];
        CarFpaFunctionListCollector[] carFpaFunctionListCollectorArray = HsmTargetFPA.createEmptyFunctionListCollector();
        for (int i2 = 0; i2 < charismaSetupTableWithOptionMaskArray.length; ++i2) {
            this.values = new CharismaSetupTableWithoutOptionMask(charismaSetupTableWithOptionMaskArray[i2].getListPosition(), charismaSetupTableWithOptionMaskArray[i2].getFunctionID(), charismaSetupTableWithOptionMaskArray[i2].getSetupValue());
            carFpaFunctionListCollectorArray[charismaSetupTableWithOptionMaskArray[i2].getFunctionID()] = new CarFpaFunctionListCollector(true, ASLCarUtil.hexToBooleanArray(charismaSetupTableWithOptionMaskArray[i2].getMask()));
            charismaSetupTableWithoutOptionMaskArray[i2] = this.values;
        }
        CollectorFPASettings collectorFPASettings = new CollectorFPASettings(n2, carFpaFunctionListCollectorArray, charismaSetupTableWithoutOptionMaskArray);
        if (n == -1) {
            this.setupSettingsProfile.add(collectorFPASettings);
        } else {
            this.setupSettingsProfile.add(n, collectorFPASettings);
        }
    }

    private void copyBit10ToPosition8(CarFpaFunctionListCollector[] carFpaFunctionListCollectorArray, CharismaSetupTableWithOptionMask[] charismaSetupTableWithOptionMaskArray, int n) {
        boolean[] blArray = ASLCarUtil.hexToBooleanArray(charismaSetupTableWithOptionMaskArray[n].getMask());
        blArray[7] = blArray[9];
        carFpaFunctionListCollectorArray[charismaSetupTableWithOptionMaskArray[n].getFunctionID()] = new CarFpaFunctionListCollector(true, blArray);
    }

    void informHmiAboutCurrentSettings(int n) {
        int n2;
        this.isDCC = false;
        for (n2 = this.setupSettingsProfile.size() - 1; n2 >= 0; --n2) {
            if (((CollectorFPASettings)this.setupSettingsProfile.get((int)n2)).profileID != n) continue;
            this.currentSettings = ((CollectorFPASettings)this.setupSettingsProfile.get((int)n2)).setupTable;
            ListManager.getGenericASLList(10279).updateList(((CollectorFPASettings)this.setupSettingsProfile.get((int)n2)).functionList);
            ListManager.getGenericASLList(10280).updateList(((CollectorFPASettings)this.setupSettingsProfile.get((int)n2)).functionList);
            break;
        }
        block54: for (n2 = 0; n2 < this.currentSettings.length; ++n2) {
            switch (this.currentSettings[n2].getFunctionID()) {
                case 1: {
                    this.enginePower(this.currentSettings[n2].getSetupValue());
                    continue block54;
                }
                case 7: {
                    this.damper(n, this.currentSettings[n2].getSetupValue());
                    this.isDCC = true;
                    continue block54;
                }
                case 3: {
                    this.gearBoxDrivingPosition(this.currentSettings[n2].getSetupValue());
                    continue block54;
                }
                case 9: {
                    this.adativeCruiseControl(this.currentSettings[n2].getSetupValue());
                    continue block54;
                }
                case 11: {
                    this.steerableBeam(this.currentSettings[n2].getSetupValue());
                    continue block54;
                }
                case 5: {
                    this.powerSteeringAssist(this.currentSettings[n2].getSetupValue());
                    continue block54;
                }
                case 8: {
                    this.climateControl(this.currentSettings[n2].getSetupValue());
                    continue block54;
                }
                case 10: {
                    this.engineSound(this.currentSettings[n2].getSetupValue());
                    continue block54;
                }
                case 2: {
                    this.engineStartStop(this.currentSettings[n2].getSetupValue());
                    continue block54;
                }
                case 14: {
                    this.pretensioner(this.currentSettings[n2].getSetupValue());
                    continue block54;
                }
                case 16: {
                    this.navigation(this.currentSettings[n2].getSetupValue());
                    continue block54;
                }
                case 21: {
                    this.frontAxleDifferential(this.currentSettings[n2].getSetupValue());
                    continue block54;
                }
                case 30: {
                    this.activeRollBar(this.currentSettings[n2].getSetupValue());
                    continue block54;
                }
                case 13: {
                    this.airSuspension(this.currentSettings[n2].getSetupValue());
                    continue block54;
                }
                case 25: {
                    this.antiSlipControl(this.currentSettings[n2].getSetupValue());
                    continue block54;
                }
                case 28: {
                    this.brakeControlSystem(this.currentSettings[n2].getSetupValue());
                    continue block54;
                }
                case 23: {
                    this.centerAndRearAxleDifferential(this.currentSettings[n2].getSetupValue());
                    continue block54;
                }
                case 22: {
                    this.centerDifferentail(this.currentSettings[n2].getSetupValue());
                    continue block54;
                }
                case 34: {
                    this.chassis(this.currentSettings[n2].getSetupValue());
                    continue block54;
                }
                case 31: {
                    this.curveAssist(this.currentSettings[n2].getSetupValue());
                    continue block54;
                }
                case 47: {
                    this.displaySetup1(this.currentSettings[n2].getSetupValue());
                    continue block54;
                }
                case 48: {
                    this.displaySetup2(this.currentSettings[n2].getSetupValue());
                    continue block54;
                }
                case 45: {
                    this.hillStartAssistant(this.currentSettings[n2].getSetupValue());
                    continue block54;
                }
                case 46: {
                    this.pdc(this.currentSettings[n2].getSetupValue());
                    continue block54;
                }
                case 38: {
                    this.driverSeat(this.currentSettings[n2].getSetupValue());
                    continue block54;
                }
                case 33: {
                    this.driveTrain(this.currentSettings[n2].getSetupValue());
                    continue block54;
                }
                case 41: {
                    this.dynEngineMount(this.currentSettings[n2].getSetupValue());
                    continue block54;
                }
                case 19: {
                    this.ecoLiveTips(this.currentSettings[n2].getSetupValue());
                    continue block54;
                }
                case 24: {
                    this.electronicTorqueVectoring(this.currentSettings[n2].getSetupValue());
                    continue block54;
                }
                case 50: {
                    this.energoAcc(this.currentSettings[n2].getSetupValue());
                    continue block54;
                }
                case 49: {
                    this.energoDisplay(this.currentSettings[n2].getSetupValue());
                    continue block54;
                }
                case 51: {
                    this.eSound(this.currentSettings[n2].getSetupValue());
                    continue block54;
                }
                case 35: {
                    this.exhaustFlap(this.currentSettings[n2].getSetupValue());
                    continue block54;
                }
                case 18: {
                    this.freeRolling(this.currentSettings[n2].getSetupValue());
                    continue block54;
                }
                case 44: {
                    this.hillStepDownAssist(this.currentSettings[n2].getSetupValue());
                    continue block54;
                }
                case 32: {
                    this.hybridComponents(this.currentSettings[n2].getSetupValue());
                    continue block54;
                }
                case 12: {
                    this.interiorLight(this.currentSettings[n2].getSetupValue());
                    continue block54;
                }
                case 40: {
                    this.laneAssist(this.currentSettings[n2].getSetupValue());
                    continue block54;
                }
                case 42: {
                    this.magenticRide(this.currentSettings[n2].getSetupValue());
                    continue block54;
                }
                case 26: {
                    this.matrixBeam(this.currentSettings[n2].getSetupValue());
                    continue block54;
                }
                case 17: {
                    this.navigation2(this.currentSettings[n2].getSetupValue());
                    continue block54;
                }
                case 37: {
                    this.passengerCabin(this.currentSettings[n2].getSetupValue());
                    continue block54;
                }
                case 4: {
                    this.rearAxleDifferential(this.currentSettings[n2].getSetupValue());
                    continue block54;
                }
                case 29: {
                    this.rearAxleStreeringSystem(this.currentSettings[n2].getSetupValue());
                    continue block54;
                }
                case 27: {
                    this.rearSpoiler(this.currentSettings[n2].getSetupValue());
                    continue block54;
                }
                case 15: {
                    this.seatSideBolsterAdjustement(this.currentSettings[n2].getSetupValue());
                    continue block54;
                }
                case 36: {
                    this.soundComponents(this.currentSettings[n2].getSetupValue());
                    continue block54;
                }
                case 6: {
                    this.superPostionSteering(this.currentSettings[n2].getSetupValue());
                    continue block54;
                }
                case 43: {
                    this.switchableDamper(this.currentSettings[n2].getSetupValue());
                    continue block54;
                }
                case 39: {
                    this.tirePressureMonitoring(this.currentSettings[n2].getSetupValue());
                    continue block54;
                }
                case 20: {
                    this.exhaustSystemSound(this.currentSettings[n2].getSetupValue());
                    continue block54;
                }
                default: {
                    this.warn("FPA: FunctionId is not implement!!!");
                }
            }
        }
        this.configDcc = this.isOffraodFpa ? 3 : (this.isDCC ? (this.currentSettings.length == 1 && this.currentSettings[0].getFunctionID() == 7 ? 2 : 1) : 0);
        this.informHMIConfigurationOfFpa();
    }

    private void informHMIConfigurationOfFpa() {
        if (this.currentConfigDcc != this.configDcc) {
            this.currentConfigDcc = this.configDcc;
            HsmTargetFPA.writeIntegerToDatapool(10276, this.configDcc);
        }
    }

    private void enginePower(int n) {
        switch (n) {
            case 1: {
                HsmTargetFPA.writeIntegerToDatapool(10871, 0);
                break;
            }
            case 2: {
                HsmTargetFPA.writeIntegerToDatapool(10871, 1);
                break;
            }
            case 3: {
                HsmTargetFPA.writeIntegerToDatapool(10871, 2);
                break;
            }
            case 4: {
                HsmTargetFPA.writeIntegerToDatapool(10871, 3);
                break;
            }
            case 5: {
                HsmTargetFPA.writeIntegerToDatapool(10871, 4);
                break;
            }
            case 6: {
                HsmTargetFPA.writeIntegerToDatapool(10871, 5);
                break;
            }
            case 7: {
                HsmTargetFPA.writeIntegerToDatapool(10871, 6);
                break;
            }
            case 8: {
                HsmTargetFPA.writeIntegerToDatapool(10871, 7);
                break;
            }
            case 9: {
                HsmTargetFPA.writeIntegerToDatapool(10871, 8);
                break;
            }
            case 10: {
                HsmTargetFPA.writeIntegerToDatapool(10871, 9);
                break;
            }
            default: {
                this.info("FPA: EnginePower: setupValue is not implemented.");
            }
        }
    }

    private void damper(int n, int n2) {
        if (this.isContinuousDamperAvailable && n == 7) {
            this.currentContinuousDamperValue = n2;
            ((StateWork)this.stateWork).updateDCCSlider(n2);
        } else {
            switch (n2) {
                case 1: {
                    HsmTargetFPA.writeIntegerToDatapool(10281, 0);
                    break;
                }
                case 2: {
                    HsmTargetFPA.writeIntegerToDatapool(10281, 1);
                    break;
                }
                case 3: {
                    if (this.isContinuousDamperAvailable) {
                        HsmTargetFPA.writeIntegerToDatapool(10281, 0);
                        break;
                    }
                    HsmTargetFPA.writeIntegerToDatapool(10281, 2);
                    break;
                }
                case 4: {
                    HsmTargetFPA.writeIntegerToDatapool(10281, 3);
                    break;
                }
                case 5: {
                    HsmTargetFPA.writeIntegerToDatapool(10281, 4);
                    break;
                }
                case 6: {
                    HsmTargetFPA.writeIntegerToDatapool(10281, 5);
                    break;
                }
                case 7: {
                    HsmTargetFPA.writeIntegerToDatapool(10281, 6);
                    break;
                }
                case 8: {
                    if (this.isContinuousDamperAvailable) {
                        HsmTargetFPA.writeIntegerToDatapool(10281, 1);
                        break;
                    }
                    HsmTargetFPA.writeIntegerToDatapool(10281, 7);
                    break;
                }
                case 9: {
                    HsmTargetFPA.writeIntegerToDatapool(10281, 8);
                    break;
                }
                case 10: {
                    HsmTargetFPA.writeIntegerToDatapool(10281, 9);
                    break;
                }
                case 13: {
                    if (!this.isContinuousDamperAvailable) break;
                    HsmTargetFPA.writeIntegerToDatapool(10281, 2);
                    break;
                }
                default: {
                    this.info("FPA: Damper: setupValue is not implemented.");
                }
            }
        }
    }

    private void gearBoxDrivingPosition(int n) {
        switch (n) {
            case 1: {
                HsmTargetFPA.writeIntegerToDatapool(10870, 0);
                break;
            }
            case 2: {
                HsmTargetFPA.writeIntegerToDatapool(10870, 1);
                break;
            }
            case 3: {
                HsmTargetFPA.writeIntegerToDatapool(10870, 2);
                break;
            }
            case 4: {
                HsmTargetFPA.writeIntegerToDatapool(10870, 3);
                break;
            }
            case 5: {
                HsmTargetFPA.writeIntegerToDatapool(10870, 4);
                break;
            }
            case 6: {
                HsmTargetFPA.writeIntegerToDatapool(10870, 5);
                break;
            }
            case 7: {
                HsmTargetFPA.writeIntegerToDatapool(10870, 6);
                break;
            }
            case 8: {
                HsmTargetFPA.writeIntegerToDatapool(10870, 7);
                break;
            }
            case 9: {
                HsmTargetFPA.writeIntegerToDatapool(10870, 8);
                break;
            }
            case 10: {
                HsmTargetFPA.writeIntegerToDatapool(10870, 9);
                break;
            }
            default: {
                this.info("FPA: GearDrivingPosition: setupValue is not implemented.");
            }
        }
    }

    private void adativeCruiseControl(int n) {
        switch (n) {
            case 1: {
                HsmTargetFPA.writeIntegerToDatapool(10283, 0);
                break;
            }
            case 2: {
                HsmTargetFPA.writeIntegerToDatapool(10283, 1);
                break;
            }
            case 3: {
                HsmTargetFPA.writeIntegerToDatapool(10283, 2);
                break;
            }
            case 4: {
                HsmTargetFPA.writeIntegerToDatapool(10283, 3);
                break;
            }
            case 5: {
                HsmTargetFPA.writeIntegerToDatapool(10283, 4);
                break;
            }
            case 6: {
                HsmTargetFPA.writeIntegerToDatapool(10283, 5);
                break;
            }
            case 7: {
                HsmTargetFPA.writeIntegerToDatapool(10283, 6);
                break;
            }
            case 8: {
                HsmTargetFPA.writeIntegerToDatapool(10283, 7);
                break;
            }
            case 9: {
                HsmTargetFPA.writeIntegerToDatapool(10283, 8);
                break;
            }
            case 10: {
                HsmTargetFPA.writeIntegerToDatapool(10283, 9);
                break;
            }
            default: {
                this.info("FPA: ACC: setupValue is not implemented.");
            }
        }
    }

    private void steerableBeam(int n) {
        switch (n) {
            case 1: {
                HsmTargetFPA.writeIntegerToDatapool(10284, 0);
                break;
            }
            case 2: {
                HsmTargetFPA.writeIntegerToDatapool(10284, 1);
                break;
            }
            case 3: {
                HsmTargetFPA.writeIntegerToDatapool(10284, 2);
                break;
            }
            case 4: {
                HsmTargetFPA.writeIntegerToDatapool(10284, 3);
                break;
            }
            case 5: {
                HsmTargetFPA.writeIntegerToDatapool(10284, 4);
                break;
            }
            case 6: {
                HsmTargetFPA.writeIntegerToDatapool(10284, 5);
                break;
            }
            case 7: {
                HsmTargetFPA.writeIntegerToDatapool(10284, 6);
                break;
            }
            case 8: {
                HsmTargetFPA.writeIntegerToDatapool(10284, 7);
                break;
            }
            case 9: {
                HsmTargetFPA.writeIntegerToDatapool(10284, 8);
                break;
            }
            case 10: {
                HsmTargetFPA.writeIntegerToDatapool(10284, 9);
                break;
            }
            default: {
                this.info("FPA: SteerableBeam: setupValue is not implemented.");
            }
        }
    }

    private void powerSteeringAssist(int n) {
        switch (n) {
            case 1: {
                HsmTargetFPA.writeIntegerToDatapool(10285, 0);
                break;
            }
            case 2: {
                HsmTargetFPA.writeIntegerToDatapool(10285, 1);
                break;
            }
            case 3: {
                HsmTargetFPA.writeIntegerToDatapool(10285, 2);
                break;
            }
            case 4: {
                HsmTargetFPA.writeIntegerToDatapool(10285, 3);
                break;
            }
            case 5: {
                HsmTargetFPA.writeIntegerToDatapool(10285, 4);
                break;
            }
            case 6: {
                HsmTargetFPA.writeIntegerToDatapool(10285, 5);
                break;
            }
            case 7: {
                HsmTargetFPA.writeIntegerToDatapool(10285, 6);
                break;
            }
            case 8: {
                HsmTargetFPA.writeIntegerToDatapool(10285, 7);
                break;
            }
            case 9: {
                HsmTargetFPA.writeIntegerToDatapool(10285, 8);
                break;
            }
            case 10: {
                HsmTargetFPA.writeIntegerToDatapool(10285, 9);
                break;
            }
            default: {
                this.info("FPA: PowerSteeringAssist: setupValue is not implemented.");
            }
        }
    }

    private void climateControl(int n) {
        switch (n) {
            case 1: {
                HsmTargetFPA.writeIntegerToDatapool(10289, 0);
                break;
            }
            case 2: {
                HsmTargetFPA.writeIntegerToDatapool(10289, 1);
                break;
            }
            case 3: {
                HsmTargetFPA.writeIntegerToDatapool(10289, 2);
                break;
            }
            case 4: {
                HsmTargetFPA.writeIntegerToDatapool(10289, 3);
                break;
            }
            case 5: {
                HsmTargetFPA.writeIntegerToDatapool(10289, 4);
                break;
            }
            case 6: {
                HsmTargetFPA.writeIntegerToDatapool(10289, 5);
                break;
            }
            case 7: {
                HsmTargetFPA.writeIntegerToDatapool(10289, 6);
                break;
            }
            case 8: {
                HsmTargetFPA.writeIntegerToDatapool(10289, 7);
                break;
            }
            case 9: {
                HsmTargetFPA.writeIntegerToDatapool(10289, 8);
                break;
            }
            case 10: {
                HsmTargetFPA.writeIntegerToDatapool(10289, 9);
                break;
            }
            default: {
                this.info("FPA: ClimateControl: setupValue is not implemented.");
            }
        }
    }

    private void engineSound(int n) {
        switch (n) {
            case 1: {
                HsmTargetFPA.writeIntegerToDatapool(10872, 0);
                break;
            }
            case 2: {
                HsmTargetFPA.writeIntegerToDatapool(10872, 1);
                break;
            }
            case 3: {
                HsmTargetFPA.writeIntegerToDatapool(10872, 2);
                break;
            }
            case 4: {
                HsmTargetFPA.writeIntegerToDatapool(10872, 3);
                break;
            }
            case 5: {
                HsmTargetFPA.writeIntegerToDatapool(10872, 4);
                break;
            }
            case 6: {
                HsmTargetFPA.writeIntegerToDatapool(10872, 5);
                break;
            }
            case 7: {
                HsmTargetFPA.writeIntegerToDatapool(10872, 6);
                break;
            }
            case 8: {
                HsmTargetFPA.writeIntegerToDatapool(10872, 7);
                break;
            }
            case 9: {
                HsmTargetFPA.writeIntegerToDatapool(10872, 8);
                break;
            }
            case 10: {
                HsmTargetFPA.writeIntegerToDatapool(10872, 9);
                break;
            }
            default: {
                this.info("FPA: EngineSound: setupValue is not implemented.");
            }
        }
    }

    private void engineStartStop(int n) {
        switch (n) {
            case 1: {
                HsmTargetFPA.writeIntegerToDatapool(10288, 0);
                break;
            }
            case 2: {
                HsmTargetFPA.writeIntegerToDatapool(10288, 1);
                break;
            }
            case 3: {
                HsmTargetFPA.writeIntegerToDatapool(10288, 2);
                break;
            }
            case 4: {
                HsmTargetFPA.writeIntegerToDatapool(10288, 3);
                break;
            }
            case 5: {
                HsmTargetFPA.writeIntegerToDatapool(10288, 4);
                break;
            }
            case 6: {
                HsmTargetFPA.writeIntegerToDatapool(10288, 5);
                break;
            }
            case 7: {
                HsmTargetFPA.writeIntegerToDatapool(10288, 6);
                break;
            }
            case 8: {
                HsmTargetFPA.writeIntegerToDatapool(10288, 7);
                break;
            }
            case 9: {
                HsmTargetFPA.writeIntegerToDatapool(10288, 8);
                break;
            }
            case 10: {
                HsmTargetFPA.writeIntegerToDatapool(10288, 9);
                break;
            }
            default: {
                this.info("FPA: StartStop: setupValue is not implemented.");
            }
        }
    }

    private void pretensioner(int n) {
        switch (n) {
            case 1: {
                HsmTargetFPA.writeIntegerToDatapool(10290, 0);
                break;
            }
            case 2: {
                HsmTargetFPA.writeIntegerToDatapool(10290, 1);
                break;
            }
            case 3: {
                HsmTargetFPA.writeIntegerToDatapool(10290, 2);
                break;
            }
            case 4: {
                HsmTargetFPA.writeIntegerToDatapool(10290, 3);
                break;
            }
            case 5: {
                HsmTargetFPA.writeIntegerToDatapool(10290, 4);
                break;
            }
            case 6: {
                HsmTargetFPA.writeIntegerToDatapool(10290, 5);
                break;
            }
            case 7: {
                HsmTargetFPA.writeIntegerToDatapool(10290, 6);
                break;
            }
            case 8: {
                HsmTargetFPA.writeIntegerToDatapool(10290, 7);
                break;
            }
            case 9: {
                HsmTargetFPA.writeIntegerToDatapool(10290, 8);
                break;
            }
            case 10: {
                HsmTargetFPA.writeIntegerToDatapool(10290, 9);
                break;
            }
            default: {
                this.info("FPA: BeltTensioner: setupValue is not implemented.");
            }
        }
    }

    private void frontAxleDifferential(int n) {
        switch (n) {
            case 1: {
                HsmTargetFPA.writeIntegerToDatapool(10291, 0);
                break;
            }
            case 2: {
                HsmTargetFPA.writeIntegerToDatapool(10291, 1);
                break;
            }
            case 3: {
                HsmTargetFPA.writeIntegerToDatapool(10291, 2);
                break;
            }
            case 4: {
                HsmTargetFPA.writeIntegerToDatapool(10291, 3);
                break;
            }
            case 5: {
                HsmTargetFPA.writeIntegerToDatapool(10291, 4);
                break;
            }
            case 6: {
                HsmTargetFPA.writeIntegerToDatapool(10291, 5);
                break;
            }
            case 7: {
                HsmTargetFPA.writeIntegerToDatapool(10291, 6);
                break;
            }
            case 8: {
                HsmTargetFPA.writeIntegerToDatapool(10291, 7);
                break;
            }
            case 9: {
                HsmTargetFPA.writeIntegerToDatapool(10291, 8);
                break;
            }
            case 10: {
                HsmTargetFPA.writeIntegerToDatapool(10291, 9);
                break;
            }
            default: {
                this.info("FPA: FrontAxleDifferential: setupValue is not implemented.");
            }
        }
    }

    private void navigation(int n) {
        switch (n) {
            case 1: {
                HsmTargetFPA.writeIntegerToDatapool(10297, 0);
                break;
            }
            case 2: {
                HsmTargetFPA.writeIntegerToDatapool(10297, 1);
                break;
            }
            case 3: {
                HsmTargetFPA.writeIntegerToDatapool(10297, 2);
                break;
            }
            case 4: {
                HsmTargetFPA.writeIntegerToDatapool(10297, 3);
                break;
            }
            case 5: {
                HsmTargetFPA.writeIntegerToDatapool(10297, 4);
                break;
            }
            case 6: {
                HsmTargetFPA.writeIntegerToDatapool(10297, 5);
                break;
            }
            case 7: {
                HsmTargetFPA.writeIntegerToDatapool(10297, 6);
                break;
            }
            case 8: {
                HsmTargetFPA.writeIntegerToDatapool(10297, 7);
                break;
            }
            case 9: {
                HsmTargetFPA.writeIntegerToDatapool(10297, 8);
                break;
            }
            case 10: {
                HsmTargetFPA.writeIntegerToDatapool(10297, 9);
                break;
            }
            default: {
                this.info("FPA: FrontAxleDifferential: setupValue is not implemented.");
            }
        }
    }

    private void tirePressureMonitoring(int n) {
        switch (n) {
            case 1: {
                HsmTargetFPA.writeIntegerToDatapool(10320, 0);
                break;
            }
            case 2: {
                HsmTargetFPA.writeIntegerToDatapool(10320, 1);
                break;
            }
            case 3: {
                HsmTargetFPA.writeIntegerToDatapool(10320, 2);
                break;
            }
            case 4: {
                HsmTargetFPA.writeIntegerToDatapool(10320, 3);
                break;
            }
            case 5: {
                HsmTargetFPA.writeIntegerToDatapool(10320, 4);
                break;
            }
            case 6: {
                HsmTargetFPA.writeIntegerToDatapool(10320, 5);
                break;
            }
            case 7: {
                HsmTargetFPA.writeIntegerToDatapool(10320, 6);
                break;
            }
            case 8: {
                HsmTargetFPA.writeIntegerToDatapool(10320, 7);
                break;
            }
            case 9: {
                HsmTargetFPA.writeIntegerToDatapool(10320, 8);
                break;
            }
            case 10: {
                HsmTargetFPA.writeIntegerToDatapool(10320, 9);
                break;
            }
            default: {
                this.info("FPA: TPMS_MODE: setupValue is not implemented.");
            }
        }
    }

    private void switchableDamper(int n) {
        switch (n) {
            case 1: {
                HsmTargetFPA.writeIntegerToDatapool(10324, 0);
                break;
            }
            case 2: {
                HsmTargetFPA.writeIntegerToDatapool(10324, 1);
                break;
            }
            case 3: {
                HsmTargetFPA.writeIntegerToDatapool(10324, 2);
                break;
            }
            case 4: {
                HsmTargetFPA.writeIntegerToDatapool(10324, 3);
                break;
            }
            case 5: {
                HsmTargetFPA.writeIntegerToDatapool(10324, 4);
                break;
            }
            case 6: {
                HsmTargetFPA.writeIntegerToDatapool(10324, 5);
                break;
            }
            case 7: {
                HsmTargetFPA.writeIntegerToDatapool(10324, 6);
                break;
            }
            case 8: {
                HsmTargetFPA.writeIntegerToDatapool(10324, 7);
                break;
            }
            case 9: {
                HsmTargetFPA.writeIntegerToDatapool(10324, 8);
                break;
            }
            case 10: {
                HsmTargetFPA.writeIntegerToDatapool(10324, 9);
                break;
            }
            default: {
                this.info("FPA: SWITCHABLE_DAMPER_MODE: setupValue is not implemented.");
            }
        }
    }

    private void superPostionSteering(int n) {
        switch (n) {
            case 1: {
                HsmTargetFPA.writeIntegerToDatapool(10300, 0);
                break;
            }
            case 2: {
                HsmTargetFPA.writeIntegerToDatapool(10300, 1);
                break;
            }
            case 3: {
                HsmTargetFPA.writeIntegerToDatapool(10300, 2);
                break;
            }
            case 4: {
                HsmTargetFPA.writeIntegerToDatapool(10300, 3);
                break;
            }
            case 5: {
                HsmTargetFPA.writeIntegerToDatapool(10300, 4);
                break;
            }
            case 6: {
                HsmTargetFPA.writeIntegerToDatapool(10300, 5);
                break;
            }
            case 7: {
                HsmTargetFPA.writeIntegerToDatapool(10300, 6);
                break;
            }
            case 8: {
                HsmTargetFPA.writeIntegerToDatapool(10300, 7);
                break;
            }
            case 9: {
                HsmTargetFPA.writeIntegerToDatapool(10300, 8);
                break;
            }
            case 10: {
                HsmTargetFPA.writeIntegerToDatapool(10300, 9);
                break;
            }
            default: {
                this.info("FPA: SUPERPOSITION_STEERING_MODE: setupValue is not implemented.");
            }
        }
    }

    private void soundComponents(int n) {
        switch (n) {
            case 1: {
                HsmTargetFPA.writeIntegerToDatapool(10317, 0);
                break;
            }
            case 2: {
                HsmTargetFPA.writeIntegerToDatapool(10317, 1);
                break;
            }
            case 3: {
                HsmTargetFPA.writeIntegerToDatapool(10317, 2);
                break;
            }
            case 4: {
                HsmTargetFPA.writeIntegerToDatapool(10317, 3);
                break;
            }
            case 5: {
                HsmTargetFPA.writeIntegerToDatapool(10317, 4);
                break;
            }
            case 6: {
                HsmTargetFPA.writeIntegerToDatapool(10317, 5);
                break;
            }
            case 7: {
                HsmTargetFPA.writeIntegerToDatapool(10317, 6);
                break;
            }
            case 8: {
                HsmTargetFPA.writeIntegerToDatapool(10317, 7);
                break;
            }
            case 9: {
                HsmTargetFPA.writeIntegerToDatapool(10317, 8);
                break;
            }
            case 10: {
                HsmTargetFPA.writeIntegerToDatapool(10317, 9);
                break;
            }
            default: {
                this.info("FPA: SOUND_COMPONENTS_MODE: setupValue is not implemented.");
            }
        }
    }

    private void seatSideBolsterAdjustement(int n) {
        switch (n) {
            case 1: {
                HsmTargetFPA.writeIntegerToDatapool(10303, 0);
                break;
            }
            case 2: {
                HsmTargetFPA.writeIntegerToDatapool(10303, 1);
                break;
            }
            case 3: {
                HsmTargetFPA.writeIntegerToDatapool(10303, 2);
                break;
            }
            case 4: {
                HsmTargetFPA.writeIntegerToDatapool(10303, 3);
                break;
            }
            case 5: {
                HsmTargetFPA.writeIntegerToDatapool(10303, 4);
                break;
            }
            case 6: {
                HsmTargetFPA.writeIntegerToDatapool(10303, 5);
                break;
            }
            case 7: {
                HsmTargetFPA.writeIntegerToDatapool(10303, 6);
                break;
            }
            case 8: {
                HsmTargetFPA.writeIntegerToDatapool(10303, 7);
                break;
            }
            case 9: {
                HsmTargetFPA.writeIntegerToDatapool(10303, 8);
                break;
            }
            case 10: {
                HsmTargetFPA.writeIntegerToDatapool(10303, 9);
                break;
            }
            default: {
                this.info("FPA: SEAT_SIDE_BOLSTER_ADJUSTMENT_MODE: setupValue is not implemented.");
            }
        }
    }

    private void rearSpoiler(int n) {
        switch (n) {
            case 1: {
                HsmTargetFPA.writeIntegerToDatapool(10308, 0);
                break;
            }
            case 2: {
                HsmTargetFPA.writeIntegerToDatapool(10308, 1);
                break;
            }
            case 3: {
                HsmTargetFPA.writeIntegerToDatapool(10308, 2);
                break;
            }
            case 4: {
                HsmTargetFPA.writeIntegerToDatapool(10308, 3);
                break;
            }
            case 5: {
                HsmTargetFPA.writeIntegerToDatapool(10308, 4);
                break;
            }
            case 6: {
                HsmTargetFPA.writeIntegerToDatapool(10308, 5);
                break;
            }
            case 7: {
                HsmTargetFPA.writeIntegerToDatapool(10308, 6);
                break;
            }
            case 8: {
                HsmTargetFPA.writeIntegerToDatapool(10289, 7);
                break;
            }
            case 9: {
                HsmTargetFPA.writeIntegerToDatapool(10289, 8);
                break;
            }
            case 10: {
                HsmTargetFPA.writeIntegerToDatapool(10289, 9);
                break;
            }
            default: {
                this.info("FPA: REAR_SPOILER_MODE: setupValue is not implemented.");
            }
        }
    }

    private void rearAxleStreeringSystem(int n) {
        switch (n) {
            case 1: {
                HsmTargetFPA.writeIntegerToDatapool(10310, 0);
                break;
            }
            case 2: {
                HsmTargetFPA.writeIntegerToDatapool(10310, 1);
                break;
            }
            case 3: {
                HsmTargetFPA.writeIntegerToDatapool(10310, 2);
                break;
            }
            case 4: {
                HsmTargetFPA.writeIntegerToDatapool(10310, 3);
                break;
            }
            case 5: {
                HsmTargetFPA.writeIntegerToDatapool(10310, 4);
                break;
            }
            case 6: {
                HsmTargetFPA.writeIntegerToDatapool(10310, 5);
                break;
            }
            case 7: {
                HsmTargetFPA.writeIntegerToDatapool(10310, 6);
                break;
            }
            case 8: {
                HsmTargetFPA.writeIntegerToDatapool(10310, 7);
                break;
            }
            case 9: {
                HsmTargetFPA.writeIntegerToDatapool(10310, 8);
                break;
            }
            case 10: {
                HsmTargetFPA.writeIntegerToDatapool(10310, 9);
                break;
            }
            default: {
                this.info("FPA: REAR_AXLE_STEERING_MODE: setupValue is not implemented.");
            }
        }
    }

    private void rearAxleDifferential(int n) {
        switch (n) {
            case 1: {
                HsmTargetFPA.writeIntegerToDatapool(10292, 0);
                break;
            }
            case 2: {
                HsmTargetFPA.writeIntegerToDatapool(10292, 1);
                break;
            }
            case 3: {
                HsmTargetFPA.writeIntegerToDatapool(10292, 2);
                break;
            }
            case 4: {
                HsmTargetFPA.writeIntegerToDatapool(10292, 3);
                break;
            }
            case 5: {
                HsmTargetFPA.writeIntegerToDatapool(10292, 4);
                break;
            }
            case 6: {
                HsmTargetFPA.writeIntegerToDatapool(10292, 5);
                break;
            }
            case 7: {
                HsmTargetFPA.writeIntegerToDatapool(10292, 6);
                break;
            }
            case 8: {
                HsmTargetFPA.writeIntegerToDatapool(10292, 7);
                break;
            }
            case 9: {
                HsmTargetFPA.writeIntegerToDatapool(10292, 8);
                break;
            }
            case 10: {
                HsmTargetFPA.writeIntegerToDatapool(10292, 9);
                break;
            }
            default: {
                this.info("FPA: REAR_AXLE_DIFFERENTIAL_SETUP: setupValue is not implemented.");
            }
        }
    }

    private void passengerCabin(int n) {
        switch (n) {
            case 1: {
                HsmTargetFPA.writeIntegerToDatapool(10318, 0);
                break;
            }
            case 2: {
                HsmTargetFPA.writeIntegerToDatapool(10318, 1);
                break;
            }
            case 3: {
                HsmTargetFPA.writeIntegerToDatapool(10318, 2);
                break;
            }
            case 4: {
                HsmTargetFPA.writeIntegerToDatapool(10318, 3);
                break;
            }
            case 5: {
                HsmTargetFPA.writeIntegerToDatapool(10318, 4);
                break;
            }
            case 6: {
                HsmTargetFPA.writeIntegerToDatapool(10318, 5);
                break;
            }
            case 7: {
                HsmTargetFPA.writeIntegerToDatapool(10318, 6);
                break;
            }
            case 8: {
                HsmTargetFPA.writeIntegerToDatapool(10318, 7);
                break;
            }
            case 9: {
                HsmTargetFPA.writeIntegerToDatapool(10318, 8);
                break;
            }
            case 10: {
                HsmTargetFPA.writeIntegerToDatapool(10318, 9);
                break;
            }
            default: {
                this.info("FPA: PASSENGER_CABIN_MODE: setupValue is not implemented.");
            }
        }
    }

    private void navigation2(int n) {
        switch (n) {
            case 1: {
                HsmTargetFPA.writeIntegerToDatapool(10299, 0);
                break;
            }
            case 2: {
                HsmTargetFPA.writeIntegerToDatapool(10299, 1);
                break;
            }
            case 3: {
                HsmTargetFPA.writeIntegerToDatapool(10299, 2);
                break;
            }
            case 4: {
                HsmTargetFPA.writeIntegerToDatapool(10299, 3);
                break;
            }
            case 5: {
                HsmTargetFPA.writeIntegerToDatapool(10299, 4);
                break;
            }
            case 6: {
                HsmTargetFPA.writeIntegerToDatapool(10299, 5);
                break;
            }
            case 7: {
                HsmTargetFPA.writeIntegerToDatapool(10299, 6);
                break;
            }
            case 8: {
                HsmTargetFPA.writeIntegerToDatapool(10299, 7);
                break;
            }
            case 9: {
                HsmTargetFPA.writeIntegerToDatapool(10299, 8);
                break;
            }
            case 10: {
                HsmTargetFPA.writeIntegerToDatapool(10299, 9);
                break;
            }
            default: {
                this.info("FPA: NAVIGATION_MODE: setupValue is not implemented.");
            }
        }
    }

    private void matrixBeam(int n) {
        switch (n) {
            case 1: {
                HsmTargetFPA.writeIntegerToDatapool(10307, 0);
                break;
            }
            case 2: {
                HsmTargetFPA.writeIntegerToDatapool(10307, 1);
                break;
            }
            case 3: {
                HsmTargetFPA.writeIntegerToDatapool(10307, 2);
                break;
            }
            case 4: {
                HsmTargetFPA.writeIntegerToDatapool(10307, 3);
                break;
            }
            case 5: {
                HsmTargetFPA.writeIntegerToDatapool(10307, 4);
                break;
            }
            case 6: {
                HsmTargetFPA.writeIntegerToDatapool(10307, 5);
                break;
            }
            case 7: {
                HsmTargetFPA.writeIntegerToDatapool(10307, 6);
                break;
            }
            case 8: {
                HsmTargetFPA.writeIntegerToDatapool(10307, 7);
                break;
            }
            case 9: {
                HsmTargetFPA.writeIntegerToDatapool(10307, 8);
                break;
            }
            case 10: {
                HsmTargetFPA.writeIntegerToDatapool(10307, 9);
                break;
            }
            default: {
                this.info("FPA: MATRIX_BEAM_MODE: setupValue is not implemented.");
            }
        }
    }

    private void magenticRide(int n) {
        switch (n) {
            case 1: {
                HsmTargetFPA.writeIntegerToDatapool(10323, 0);
                break;
            }
            case 2: {
                HsmTargetFPA.writeIntegerToDatapool(10323, 1);
                break;
            }
            case 3: {
                HsmTargetFPA.writeIntegerToDatapool(10323, 2);
                break;
            }
            case 4: {
                HsmTargetFPA.writeIntegerToDatapool(10323, 3);
                break;
            }
            case 5: {
                HsmTargetFPA.writeIntegerToDatapool(10323, 4);
                break;
            }
            case 6: {
                HsmTargetFPA.writeIntegerToDatapool(10323, 5);
                break;
            }
            case 7: {
                HsmTargetFPA.writeIntegerToDatapool(10323, 6);
                break;
            }
            case 8: {
                HsmTargetFPA.writeIntegerToDatapool(10323, 7);
                break;
            }
            case 9: {
                HsmTargetFPA.writeIntegerToDatapool(10323, 8);
                break;
            }
            case 10: {
                HsmTargetFPA.writeIntegerToDatapool(10323, 9);
                break;
            }
            default: {
                this.info("FPA: MAGNETIC_RIDE_MODE: setupValue is not implemented.");
            }
        }
    }

    private void laneAssist(int n) {
        switch (n) {
            case 1: {
                HsmTargetFPA.writeIntegerToDatapool(10321, 0);
                break;
            }
            case 2: {
                HsmTargetFPA.writeIntegerToDatapool(10321, 1);
                break;
            }
            case 3: {
                HsmTargetFPA.writeIntegerToDatapool(10321, 2);
                break;
            }
            case 4: {
                HsmTargetFPA.writeIntegerToDatapool(10321, 3);
                break;
            }
            case 5: {
                HsmTargetFPA.writeIntegerToDatapool(10321, 4);
                break;
            }
            case 6: {
                HsmTargetFPA.writeIntegerToDatapool(10321, 5);
                break;
            }
            case 7: {
                HsmTargetFPA.writeIntegerToDatapool(10321, 6);
                break;
            }
            case 8: {
                HsmTargetFPA.writeIntegerToDatapool(10321, 7);
                break;
            }
            case 9: {
                HsmTargetFPA.writeIntegerToDatapool(10321, 8);
                break;
            }
            case 10: {
                HsmTargetFPA.writeIntegerToDatapool(10321, 9);
                break;
            }
            default: {
                this.info("FPA: LANE_ASSIST_MODE: setupValue is not implemented.");
            }
        }
    }

    private void interiorLight(int n) {
        switch (n) {
            case 1: {
                HsmTargetFPA.writeIntegerToDatapool(10301, 0);
                break;
            }
            case 2: {
                HsmTargetFPA.writeIntegerToDatapool(10301, 1);
                break;
            }
            case 3: {
                HsmTargetFPA.writeIntegerToDatapool(10301, 2);
                break;
            }
            case 4: {
                HsmTargetFPA.writeIntegerToDatapool(10301, 3);
                break;
            }
            case 5: {
                HsmTargetFPA.writeIntegerToDatapool(10301, 4);
                break;
            }
            case 6: {
                HsmTargetFPA.writeIntegerToDatapool(10301, 5);
                break;
            }
            case 7: {
                HsmTargetFPA.writeIntegerToDatapool(10301, 6);
                break;
            }
            case 8: {
                HsmTargetFPA.writeIntegerToDatapool(10301, 7);
                break;
            }
            case 9: {
                HsmTargetFPA.writeIntegerToDatapool(10301, 8);
                break;
            }
            case 10: {
                HsmTargetFPA.writeIntegerToDatapool(10301, 9);
                break;
            }
            default: {
                this.info("FPA: INTERIOR_LIGHT_MODE: setupValue is not implemented.");
            }
        }
    }

    private void hybridComponents(int n) {
        switch (n) {
            case 1: {
                HsmTargetFPA.writeIntegerToDatapool(10313, 0);
                break;
            }
            case 2: {
                HsmTargetFPA.writeIntegerToDatapool(10313, 1);
                break;
            }
            case 3: {
                HsmTargetFPA.writeIntegerToDatapool(10313, 2);
                break;
            }
            case 4: {
                HsmTargetFPA.writeIntegerToDatapool(10313, 3);
                break;
            }
            case 5: {
                HsmTargetFPA.writeIntegerToDatapool(10313, 4);
                break;
            }
            case 6: {
                HsmTargetFPA.writeIntegerToDatapool(10313, 5);
                break;
            }
            case 7: {
                HsmTargetFPA.writeIntegerToDatapool(10313, 6);
                break;
            }
            case 8: {
                HsmTargetFPA.writeIntegerToDatapool(10313, 7);
                break;
            }
            case 9: {
                HsmTargetFPA.writeIntegerToDatapool(10313, 8);
                break;
            }
            case 10: {
                HsmTargetFPA.writeIntegerToDatapool(10313, 9);
                break;
            }
            default: {
                this.info("FPA: HYBRID_COMPONENTS_MODE: setupValue is not implemented.");
            }
        }
    }

    private void hillStepDownAssist(int n) {
        switch (n) {
            case 2: {
                HsmTargetFPA.writeIntegerToDatapool(10875, 1);
                break;
            }
            case 3: {
                HsmTargetFPA.writeIntegerToDatapool(10875, 2);
                break;
            }
            case 4: {
                HsmTargetFPA.writeIntegerToDatapool(10875, 3);
                break;
            }
            case 5: {
                HsmTargetFPA.writeIntegerToDatapool(10875, 4);
                break;
            }
            case 6: {
                HsmTargetFPA.writeIntegerToDatapool(10875, 5);
                break;
            }
            case 7: {
                HsmTargetFPA.writeIntegerToDatapool(10875, 6);
                break;
            }
            case 8: {
                HsmTargetFPA.writeIntegerToDatapool(10875, 7);
                break;
            }
            case 9: {
                HsmTargetFPA.writeIntegerToDatapool(10875, 8);
                break;
            }
            case 10: {
                HsmTargetFPA.writeIntegerToDatapool(10875, 9);
                break;
            }
            default: {
                this.info("FPA: HILL_DESCENT_CONTROL_MODE: setupValue is not implemented.");
            }
        }
    }

    private void exhaustFlap(int n) {
        switch (n) {
            case 1: {
                HsmTargetFPA.writeIntegerToDatapool(10316, 0);
                break;
            }
            case 2: {
                HsmTargetFPA.writeIntegerToDatapool(10316, 1);
                break;
            }
            case 3: {
                HsmTargetFPA.writeIntegerToDatapool(10316, 2);
                break;
            }
            case 4: {
                HsmTargetFPA.writeIntegerToDatapool(10316, 3);
                break;
            }
            case 5: {
                HsmTargetFPA.writeIntegerToDatapool(10316, 4);
                break;
            }
            case 6: {
                HsmTargetFPA.writeIntegerToDatapool(10316, 5);
                break;
            }
            case 7: {
                HsmTargetFPA.writeIntegerToDatapool(10316, 6);
                break;
            }
            case 8: {
                HsmTargetFPA.writeIntegerToDatapool(10316, 7);
                break;
            }
            case 9: {
                HsmTargetFPA.writeIntegerToDatapool(10316, 8);
                break;
            }
            case 10: {
                HsmTargetFPA.writeIntegerToDatapool(10316, 9);
                break;
            }
            default: {
                this.info("FPA: EXHAUST_FLAP_MODE: setupValue is not implemented.");
            }
        }
    }

    private void freeRolling(int n) {
        switch (n) {
            case 1: {
                HsmTargetFPA.writeIntegerToDatapool(10520, 0);
                break;
            }
            case 2: {
                HsmTargetFPA.writeIntegerToDatapool(10520, 1);
                break;
            }
            case 3: {
                HsmTargetFPA.writeIntegerToDatapool(10520, 2);
                break;
            }
            case 4: {
                HsmTargetFPA.writeIntegerToDatapool(10520, 3);
                break;
            }
            case 5: {
                HsmTargetFPA.writeIntegerToDatapool(10520, 4);
                break;
            }
            case 6: {
                HsmTargetFPA.writeIntegerToDatapool(10520, 5);
                break;
            }
            case 7: {
                HsmTargetFPA.writeIntegerToDatapool(10520, 6);
                break;
            }
            case 8: {
                HsmTargetFPA.writeIntegerToDatapool(10520, 7);
                break;
            }
            case 9: {
                HsmTargetFPA.writeIntegerToDatapool(10520, 8);
                break;
            }
            case 10: {
                HsmTargetFPA.writeIntegerToDatapool(10520, 9);
                break;
            }
            default: {
                this.info("FPA: FREE_ROLLING: setupValue is not implemented.");
            }
        }
    }

    private void eSound(int n) {
        switch (n) {
            case 1: {
                HsmTargetFPA.writeIntegerToDatapool(10332, 0);
                break;
            }
            case 2: {
                HsmTargetFPA.writeIntegerToDatapool(10332, 1);
                break;
            }
            case 3: {
                HsmTargetFPA.writeIntegerToDatapool(10332, 2);
                break;
            }
            case 4: {
                HsmTargetFPA.writeIntegerToDatapool(10332, 3);
                break;
            }
            case 5: {
                HsmTargetFPA.writeIntegerToDatapool(10332, 4);
                break;
            }
            case 6: {
                HsmTargetFPA.writeIntegerToDatapool(10332, 5);
                break;
            }
            case 7: {
                HsmTargetFPA.writeIntegerToDatapool(10332, 6);
                break;
            }
            case 8: {
                HsmTargetFPA.writeIntegerToDatapool(10332, 7);
                break;
            }
            case 9: {
                HsmTargetFPA.writeIntegerToDatapool(10332, 8);
                break;
            }
            case 10: {
                HsmTargetFPA.writeIntegerToDatapool(10332, 9);
                break;
            }
            default: {
                this.info("FPA: E_SOUND_MODE: setupValue is not implemented.");
            }
        }
    }

    private void energoDisplay(int n) {
        switch (n) {
            case 1: {
                HsmTargetFPA.writeIntegerToDatapool(10330, 0);
                break;
            }
            case 2: {
                HsmTargetFPA.writeIntegerToDatapool(10330, 1);
                break;
            }
            case 3: {
                HsmTargetFPA.writeIntegerToDatapool(10330, 2);
                break;
            }
            case 4: {
                HsmTargetFPA.writeIntegerToDatapool(10330, 3);
                break;
            }
            case 5: {
                HsmTargetFPA.writeIntegerToDatapool(10330, 4);
                break;
            }
            case 6: {
                HsmTargetFPA.writeIntegerToDatapool(10330, 5);
                break;
            }
            case 7: {
                HsmTargetFPA.writeIntegerToDatapool(10330, 6);
                break;
            }
            case 8: {
                HsmTargetFPA.writeIntegerToDatapool(10330, 7);
                break;
            }
            case 9: {
                HsmTargetFPA.writeIntegerToDatapool(10330, 8);
                break;
            }
            case 10: {
                HsmTargetFPA.writeIntegerToDatapool(10330, 9);
                break;
            }
            default: {
                this.info("FPA: ENERGO_DISPLAY_SETUP_MODE: setupValue is not implemented.");
            }
        }
    }

    private void energoAcc(int n) {
        switch (n) {
            case 1: {
                HsmTargetFPA.writeIntegerToDatapool(10331, 0);
                break;
            }
            case 2: {
                HsmTargetFPA.writeIntegerToDatapool(10331, 1);
                break;
            }
            case 3: {
                HsmTargetFPA.writeIntegerToDatapool(10331, 2);
                break;
            }
            case 4: {
                HsmTargetFPA.writeIntegerToDatapool(10331, 3);
                break;
            }
            case 5: {
                HsmTargetFPA.writeIntegerToDatapool(10331, 4);
                break;
            }
            case 6: {
                HsmTargetFPA.writeIntegerToDatapool(10331, 5);
                break;
            }
            case 7: {
                HsmTargetFPA.writeIntegerToDatapool(10331, 6);
                break;
            }
            case 8: {
                HsmTargetFPA.writeIntegerToDatapool(10331, 7);
                break;
            }
            case 9: {
                HsmTargetFPA.writeIntegerToDatapool(10331, 8);
                break;
            }
            case 10: {
                HsmTargetFPA.writeIntegerToDatapool(10331, 9);
                break;
            }
            default: {
                this.info("FPA: ENERGO_ACC_MODE: setupValue is not implemented.");
            }
        }
    }

    private void electronicTorqueVectoring(int n) {
        switch (n) {
            case 1: {
                HsmTargetFPA.writeIntegerToDatapool(10305, 0);
                break;
            }
            case 2: {
                HsmTargetFPA.writeIntegerToDatapool(10305, 1);
                break;
            }
            case 3: {
                HsmTargetFPA.writeIntegerToDatapool(10305, 2);
                break;
            }
            case 4: {
                HsmTargetFPA.writeIntegerToDatapool(10305, 3);
                break;
            }
            case 5: {
                HsmTargetFPA.writeIntegerToDatapool(10305, 4);
                break;
            }
            case 6: {
                HsmTargetFPA.writeIntegerToDatapool(10305, 5);
                break;
            }
            case 7: {
                HsmTargetFPA.writeIntegerToDatapool(10305, 6);
                break;
            }
            case 8: {
                HsmTargetFPA.writeIntegerToDatapool(10305, 7);
                break;
            }
            case 9: {
                HsmTargetFPA.writeIntegerToDatapool(10305, 8);
                break;
            }
            case 10: {
                HsmTargetFPA.writeIntegerToDatapool(10305, 9);
                break;
            }
            default: {
                this.info("FPA: ELECTRIC_TORQUE_VECTORING_MODE_MODE: setupValue is not implemented.");
            }
        }
    }

    private void ecoLiveTips(int n) {
        switch (n) {
            case 1: {
                HsmTargetFPA.writeIntegerToDatapool(10296, 0);
                break;
            }
            case 2: {
                HsmTargetFPA.writeIntegerToDatapool(10296, 1);
                break;
            }
            case 3: {
                HsmTargetFPA.writeIntegerToDatapool(10296, 2);
                break;
            }
            case 4: {
                HsmTargetFPA.writeIntegerToDatapool(10296, 3);
                break;
            }
            case 5: {
                HsmTargetFPA.writeIntegerToDatapool(10296, 4);
                break;
            }
            case 6: {
                HsmTargetFPA.writeIntegerToDatapool(10296, 5);
                break;
            }
            case 7: {
                HsmTargetFPA.writeIntegerToDatapool(10296, 6);
                break;
            }
            case 8: {
                HsmTargetFPA.writeIntegerToDatapool(10296, 7);
                break;
            }
            case 9: {
                HsmTargetFPA.writeIntegerToDatapool(10296, 8);
                break;
            }
            case 10: {
                HsmTargetFPA.writeIntegerToDatapool(10296, 9);
                break;
            }
            default: {
                this.info("FPA: ECO_ASSIST_SETUP: setupValue is not implemented.");
            }
        }
    }

    private void dynEngineMount(int n) {
        switch (n) {
            case 1: {
                HsmTargetFPA.writeIntegerToDatapool(10322, 0);
                break;
            }
            case 2: {
                HsmTargetFPA.writeIntegerToDatapool(10322, 1);
                break;
            }
            case 3: {
                HsmTargetFPA.writeIntegerToDatapool(10322, 2);
                break;
            }
            case 4: {
                HsmTargetFPA.writeIntegerToDatapool(10322, 3);
                break;
            }
            case 5: {
                HsmTargetFPA.writeIntegerToDatapool(10322, 4);
                break;
            }
            case 6: {
                HsmTargetFPA.writeIntegerToDatapool(10322, 5);
                break;
            }
            case 7: {
                HsmTargetFPA.writeIntegerToDatapool(10322, 6);
                break;
            }
            case 8: {
                HsmTargetFPA.writeIntegerToDatapool(10322, 7);
                break;
            }
            case 9: {
                HsmTargetFPA.writeIntegerToDatapool(10322, 8);
                break;
            }
            case 10: {
                HsmTargetFPA.writeIntegerToDatapool(10322, 9);
                break;
            }
            default: {
                this.info("FPA: DYN_ENGINE_MOUNT_MODE: setupValue is not implemented.");
            }
        }
    }

    private void driveTrain(int n) {
        switch (n) {
            case 1: {
                HsmTargetFPA.writeIntegerToDatapool(10874, 0);
                break;
            }
            case 2: {
                HsmTargetFPA.writeIntegerToDatapool(10874, 1);
                break;
            }
            case 3: {
                HsmTargetFPA.writeIntegerToDatapool(10874, 2);
                break;
            }
            case 4: {
                HsmTargetFPA.writeIntegerToDatapool(10874, 3);
                break;
            }
            case 5: {
                HsmTargetFPA.writeIntegerToDatapool(10874, 4);
                break;
            }
            case 6: {
                HsmTargetFPA.writeIntegerToDatapool(10874, 5);
                break;
            }
            case 7: {
                HsmTargetFPA.writeIntegerToDatapool(10874, 6);
                break;
            }
            case 8: {
                HsmTargetFPA.writeIntegerToDatapool(10874, 7);
                break;
            }
            case 9: {
                HsmTargetFPA.writeIntegerToDatapool(10874, 8);
                break;
            }
            case 10: {
                HsmTargetFPA.writeIntegerToDatapool(10874, 9);
                break;
            }
            default: {
                this.info("FPA: DRIVE_TRAIN_MODE: setupValue is not implemented.");
            }
        }
    }

    private void driverSeat(int n) {
        switch (n) {
            case 1: {
                HsmTargetFPA.writeIntegerToDatapool(10319, 0);
                break;
            }
            case 2: {
                HsmTargetFPA.writeIntegerToDatapool(10319, 1);
                break;
            }
            case 3: {
                HsmTargetFPA.writeIntegerToDatapool(10319, 2);
                break;
            }
            case 4: {
                HsmTargetFPA.writeIntegerToDatapool(10319, 3);
                break;
            }
            case 5: {
                HsmTargetFPA.writeIntegerToDatapool(10319, 4);
                break;
            }
            case 6: {
                HsmTargetFPA.writeIntegerToDatapool(10319, 5);
                break;
            }
            case 7: {
                HsmTargetFPA.writeIntegerToDatapool(10319, 6);
                break;
            }
            case 8: {
                HsmTargetFPA.writeIntegerToDatapool(10319, 7);
                break;
            }
            case 9: {
                HsmTargetFPA.writeIntegerToDatapool(10319, 8);
                break;
            }
            case 10: {
                HsmTargetFPA.writeIntegerToDatapool(10319, 9);
                break;
            }
            default: {
                this.info("FPA: DRIVER_SEAT_MODE: setupValue is not implemented.");
            }
        }
    }

    private void pdc(int n) {
        switch (n) {
            case 2: {
                HsmTargetFPA.writeIntegerToDatapool(10880, 1);
                break;
            }
            case 3: {
                HsmTargetFPA.writeIntegerToDatapool(10880, 2);
                break;
            }
            case 4: {
                HsmTargetFPA.writeIntegerToDatapool(10880, 3);
                break;
            }
            case 5: {
                HsmTargetFPA.writeIntegerToDatapool(10880, 4);
                break;
            }
            case 6: {
                HsmTargetFPA.writeIntegerToDatapool(10880, 5);
                break;
            }
            case 7: {
                HsmTargetFPA.writeIntegerToDatapool(10880, 6);
                break;
            }
            case 8: {
                HsmTargetFPA.writeIntegerToDatapool(10880, 7);
                break;
            }
            case 9: {
                HsmTargetFPA.writeIntegerToDatapool(10880, 8);
                break;
            }
            case 10: {
                HsmTargetFPA.writeIntegerToDatapool(10880, 9);
                break;
            }
            default: {
                this.info("FPA: DRIVER_ASSIST2MODE: setupValue is not implemented.");
            }
        }
    }

    private void hillStartAssistant(int n) {
        switch (n) {
            case 2: {
                HsmTargetFPA.writeIntegerToDatapool(10879, 1);
                break;
            }
            case 3: {
                HsmTargetFPA.writeIntegerToDatapool(10879, 2);
                break;
            }
            case 4: {
                HsmTargetFPA.writeIntegerToDatapool(10879, 3);
                break;
            }
            case 5: {
                HsmTargetFPA.writeIntegerToDatapool(10879, 4);
                break;
            }
            case 6: {
                HsmTargetFPA.writeIntegerToDatapool(10879, 5);
                break;
            }
            case 7: {
                HsmTargetFPA.writeIntegerToDatapool(10879, 6);
                break;
            }
            case 8: {
                HsmTargetFPA.writeIntegerToDatapool(10879, 7);
                break;
            }
            case 9: {
                HsmTargetFPA.writeIntegerToDatapool(10879, 8);
                break;
            }
            case 10: {
                HsmTargetFPA.writeIntegerToDatapool(10879, 9);
                break;
            }
            default: {
                this.info("FPA: DRIVER_ASSIST1MODE: setupValue is not implemented.");
            }
        }
    }

    private void displaySetup2(int n) {
        switch (n) {
            case 1: {
                HsmTargetFPA.writeIntegerToDatapool(10329, 0);
                break;
            }
            case 2: {
                HsmTargetFPA.writeIntegerToDatapool(10329, 1);
                break;
            }
            case 3: {
                HsmTargetFPA.writeIntegerToDatapool(10329, 2);
                break;
            }
            case 4: {
                HsmTargetFPA.writeIntegerToDatapool(10329, 3);
                break;
            }
            case 5: {
                HsmTargetFPA.writeIntegerToDatapool(10329, 4);
                break;
            }
            case 6: {
                HsmTargetFPA.writeIntegerToDatapool(10329, 5);
                break;
            }
            case 7: {
                HsmTargetFPA.writeIntegerToDatapool(10329, 6);
                break;
            }
            case 8: {
                HsmTargetFPA.writeIntegerToDatapool(10329, 7);
                break;
            }
            case 9: {
                HsmTargetFPA.writeIntegerToDatapool(10329, 8);
                break;
            }
            case 10: {
                HsmTargetFPA.writeIntegerToDatapool(10329, 9);
                break;
            }
            default: {
                this.info("FPA: DISPLAY_SETUP2MODE: setupValue is not implemented.");
            }
        }
    }

    private void displaySetup1(int n) {
        switch (n) {
            case 1: {
                HsmTargetFPA.writeIntegerToDatapool(10328, 0);
                break;
            }
            case 2: {
                HsmTargetFPA.writeIntegerToDatapool(10328, 1);
                break;
            }
            case 3: {
                HsmTargetFPA.writeIntegerToDatapool(10328, 2);
                break;
            }
            case 4: {
                HsmTargetFPA.writeIntegerToDatapool(10328, 3);
                break;
            }
            case 5: {
                HsmTargetFPA.writeIntegerToDatapool(10328, 4);
                break;
            }
            case 6: {
                HsmTargetFPA.writeIntegerToDatapool(10328, 5);
                break;
            }
            case 7: {
                HsmTargetFPA.writeIntegerToDatapool(10328, 6);
                break;
            }
            case 8: {
                HsmTargetFPA.writeIntegerToDatapool(10328, 7);
                break;
            }
            case 9: {
                HsmTargetFPA.writeIntegerToDatapool(10328, 8);
                break;
            }
            case 10: {
                HsmTargetFPA.writeIntegerToDatapool(10328, 9);
                break;
            }
            default: {
                this.info("FPA: DISPLAY_SETUP1MODE: setupValue is not implemented.");
            }
        }
    }

    private void curveAssist(int n) {
        switch (n) {
            case 1: {
                HsmTargetFPA.writeIntegerToDatapool(10312, 0);
                break;
            }
            case 2: {
                HsmTargetFPA.writeIntegerToDatapool(10312, 1);
                break;
            }
            case 3: {
                HsmTargetFPA.writeIntegerToDatapool(10312, 2);
                break;
            }
            case 4: {
                HsmTargetFPA.writeIntegerToDatapool(10312, 3);
                break;
            }
            case 5: {
                HsmTargetFPA.writeIntegerToDatapool(10312, 4);
                break;
            }
            case 6: {
                HsmTargetFPA.writeIntegerToDatapool(10312, 5);
                break;
            }
            case 7: {
                HsmTargetFPA.writeIntegerToDatapool(10312, 6);
                break;
            }
            case 8: {
                HsmTargetFPA.writeIntegerToDatapool(10312, 7);
                break;
            }
            case 9: {
                HsmTargetFPA.writeIntegerToDatapool(10312, 8);
                break;
            }
            case 10: {
                HsmTargetFPA.writeIntegerToDatapool(10312, 9);
                break;
            }
            default: {
                this.info("FPA: CURVE_ASSIST_MODE: setupValue is not implemented.");
            }
        }
    }

    private void chassis(int n) {
        switch (n) {
            case 1: {
                HsmTargetFPA.writeIntegerToDatapool(10315, 0);
                break;
            }
            case 2: {
                HsmTargetFPA.writeIntegerToDatapool(10315, 1);
                break;
            }
            case 3: {
                HsmTargetFPA.writeIntegerToDatapool(10315, 2);
                break;
            }
            case 4: {
                HsmTargetFPA.writeIntegerToDatapool(10315, 3);
                break;
            }
            case 5: {
                HsmTargetFPA.writeIntegerToDatapool(10315, 4);
                break;
            }
            case 6: {
                HsmTargetFPA.writeIntegerToDatapool(10315, 5);
                break;
            }
            case 7: {
                HsmTargetFPA.writeIntegerToDatapool(10315, 6);
                break;
            }
            case 8: {
                HsmTargetFPA.writeIntegerToDatapool(10315, 7);
                break;
            }
            case 9: {
                HsmTargetFPA.writeIntegerToDatapool(10315, 8);
                break;
            }
            case 10: {
                HsmTargetFPA.writeIntegerToDatapool(10315, 9);
                break;
            }
            default: {
                this.info("FPA: CHASSIS_MODE: setupValue is not implemented.");
            }
        }
    }

    private void centerDifferentail(int n) {
        switch (n) {
            case 1: {
                HsmTargetFPA.writeIntegerToDatapool(10293, 0);
                break;
            }
            case 2: {
                HsmTargetFPA.writeIntegerToDatapool(10293, 1);
                break;
            }
            case 3: {
                HsmTargetFPA.writeIntegerToDatapool(10293, 2);
                break;
            }
            case 4: {
                HsmTargetFPA.writeIntegerToDatapool(10293, 3);
                break;
            }
            case 5: {
                HsmTargetFPA.writeIntegerToDatapool(10293, 4);
                break;
            }
            case 6: {
                HsmTargetFPA.writeIntegerToDatapool(10293, 5);
                break;
            }
            case 7: {
                HsmTargetFPA.writeIntegerToDatapool(10293, 6);
                break;
            }
            case 8: {
                HsmTargetFPA.writeIntegerToDatapool(10293, 7);
                break;
            }
            case 9: {
                HsmTargetFPA.writeIntegerToDatapool(10293, 8);
                break;
            }
            case 10: {
                HsmTargetFPA.writeIntegerToDatapool(10293, 9);
                break;
            }
            default: {
                this.info("FPA: CENTER_DIFFERENTIAL_SETUP: setupValue is not implemented.");
            }
        }
    }

    private void centerAndRearAxleDifferential(int n) {
        switch (n) {
            case 1: {
                HsmTargetFPA.writeIntegerToDatapool(10294, 0);
                break;
            }
            case 2: {
                HsmTargetFPA.writeIntegerToDatapool(10294, 1);
                break;
            }
            case 3: {
                HsmTargetFPA.writeIntegerToDatapool(10294, 2);
                break;
            }
            case 4: {
                HsmTargetFPA.writeIntegerToDatapool(10294, 3);
                break;
            }
            case 5: {
                HsmTargetFPA.writeIntegerToDatapool(10294, 4);
                break;
            }
            case 6: {
                HsmTargetFPA.writeIntegerToDatapool(10294, 5);
                break;
            }
            case 7: {
                HsmTargetFPA.writeIntegerToDatapool(10294, 6);
                break;
            }
            case 8: {
                HsmTargetFPA.writeIntegerToDatapool(10294, 7);
                break;
            }
            case 9: {
                HsmTargetFPA.writeIntegerToDatapool(10294, 8);
                break;
            }
            case 10: {
                HsmTargetFPA.writeIntegerToDatapool(10294, 9);
                break;
            }
            default: {
                this.info("FPA: CENTER_AND_REAR_AXLE_DIFFERENTIAL_SETUP: setupValue is not implemented.");
            }
        }
    }

    private void brakeControlSystem(int n) {
        switch (n) {
            case 1: {
                HsmTargetFPA.writeIntegerToDatapool(10873, 0);
                break;
            }
            case 2: {
                HsmTargetFPA.writeIntegerToDatapool(10873, 1);
                break;
            }
            case 3: {
                HsmTargetFPA.writeIntegerToDatapool(10873, 2);
                break;
            }
            case 4: {
                HsmTargetFPA.writeIntegerToDatapool(10873, 3);
                break;
            }
            case 5: {
                HsmTargetFPA.writeIntegerToDatapool(10873, 4);
                break;
            }
            case 6: {
                HsmTargetFPA.writeIntegerToDatapool(10873, 5);
                break;
            }
            case 7: {
                HsmTargetFPA.writeIntegerToDatapool(10873, 6);
                break;
            }
            case 8: {
                HsmTargetFPA.writeIntegerToDatapool(10873, 7);
                break;
            }
            case 9: {
                HsmTargetFPA.writeIntegerToDatapool(10873, 8);
                break;
            }
            case 10: {
                HsmTargetFPA.writeIntegerToDatapool(10873, 9);
                break;
            }
            default: {
                this.info("FPA: ESC_MODE: setupValue is not implemented.");
            }
        }
    }

    private void antiSlipControl(int n) {
        switch (n) {
            case 1: {
                HsmTargetFPA.writeIntegerToDatapool(10306, 0);
                break;
            }
            case 2: {
                HsmTargetFPA.writeIntegerToDatapool(10306, 1);
                break;
            }
            case 3: {
                HsmTargetFPA.writeIntegerToDatapool(10306, 2);
                break;
            }
            case 4: {
                HsmTargetFPA.writeIntegerToDatapool(10306, 3);
                break;
            }
            case 5: {
                HsmTargetFPA.writeIntegerToDatapool(10306, 4);
                break;
            }
            case 6: {
                HsmTargetFPA.writeIntegerToDatapool(10306, 5);
                break;
            }
            case 7: {
                HsmTargetFPA.writeIntegerToDatapool(10306, 6);
                break;
            }
            case 8: {
                HsmTargetFPA.writeIntegerToDatapool(10306, 7);
                break;
            }
            case 9: {
                HsmTargetFPA.writeIntegerToDatapool(10306, 8);
                break;
            }
            case 10: {
                HsmTargetFPA.writeIntegerToDatapool(10306, 9);
                break;
            }
            default: {
                this.info("FPA: ANTI_SLIP_CONTROL_MODE: setupValue is not implemented.");
            }
        }
    }

    private void airSuspension(int n) {
        switch (n) {
            case 1: {
                HsmTargetFPA.writeIntegerToDatapool(10302, 0);
                break;
            }
            case 2: {
                HsmTargetFPA.writeIntegerToDatapool(10302, 1);
                break;
            }
            case 3: {
                HsmTargetFPA.writeIntegerToDatapool(10302, 2);
                break;
            }
            case 4: {
                HsmTargetFPA.writeIntegerToDatapool(10302, 3);
                break;
            }
            case 5: {
                HsmTargetFPA.writeIntegerToDatapool(10302, 4);
                break;
            }
            case 6: {
                HsmTargetFPA.writeIntegerToDatapool(10302, 5);
                break;
            }
            case 7: {
                HsmTargetFPA.writeIntegerToDatapool(10302, 6);
                break;
            }
            case 8: {
                HsmTargetFPA.writeIntegerToDatapool(10302, 7);
                break;
            }
            case 9: {
                HsmTargetFPA.writeIntegerToDatapool(10302, 8);
                break;
            }
            case 10: {
                HsmTargetFPA.writeIntegerToDatapool(10302, 9);
                break;
            }
            default: {
                this.info("FPA: AIR_SUSPENSION_MODE: setupValue is not implemented.");
            }
        }
    }

    private void activeRollBar(int n) {
        switch (n) {
            case 1: {
                HsmTargetFPA.writeIntegerToDatapool(10311, 0);
                break;
            }
            case 2: {
                HsmTargetFPA.writeIntegerToDatapool(10311, 1);
                break;
            }
            case 3: {
                HsmTargetFPA.writeIntegerToDatapool(10311, 2);
                break;
            }
            case 4: {
                HsmTargetFPA.writeIntegerToDatapool(10311, 3);
                break;
            }
            case 5: {
                HsmTargetFPA.writeIntegerToDatapool(10311, 4);
                break;
            }
            case 6: {
                HsmTargetFPA.writeIntegerToDatapool(10311, 5);
                break;
            }
            case 7: {
                HsmTargetFPA.writeIntegerToDatapool(10311, 6);
                break;
            }
            case 8: {
                HsmTargetFPA.writeIntegerToDatapool(10311, 7);
                break;
            }
            case 9: {
                HsmTargetFPA.writeIntegerToDatapool(10311, 8);
                break;
            }
            case 10: {
                HsmTargetFPA.writeIntegerToDatapool(10311, 9);
                break;
            }
            default: {
                this.info("FPA: ACTIVE_ANTI_ROLLBAR_MODE: setupValue is not implemented.");
            }
        }
    }

    private void exhaustSystemSound(int n) {
        switch (n) {
            case 1: {
                HsmTargetFPA.writeIntegerToDatapool(10304, 0);
                break;
            }
            case 2: {
                HsmTargetFPA.writeIntegerToDatapool(10304, 1);
                break;
            }
            case 3: {
                HsmTargetFPA.writeIntegerToDatapool(10304, 2);
                break;
            }
            case 4: {
                HsmTargetFPA.writeIntegerToDatapool(10304, 3);
                break;
            }
            case 5: {
                HsmTargetFPA.writeIntegerToDatapool(10304, 4);
                break;
            }
            case 6: {
                HsmTargetFPA.writeIntegerToDatapool(10304, 5);
                break;
            }
            case 7: {
                HsmTargetFPA.writeIntegerToDatapool(10304, 6);
                break;
            }
            case 8: {
                HsmTargetFPA.writeIntegerToDatapool(10304, 7);
                break;
            }
            case 9: {
                HsmTargetFPA.writeIntegerToDatapool(10304, 8);
                break;
            }
            case 10: {
                HsmTargetFPA.writeIntegerToDatapool(10304, 9);
                break;
            }
            default: {
                this.info("FPA: ACTIVE_ANTI_ROLLBAR_MODE: setupValue is not implemented.");
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


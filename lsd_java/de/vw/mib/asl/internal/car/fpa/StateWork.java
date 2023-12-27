/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.fpa;

import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.car.ASLCarContainer;
import de.vw.mib.asl.internal.car.ASLCarUtil;
import de.vw.mib.asl.internal.car.fpa.DCCController;
import de.vw.mib.asl.internal.car.fpa.FPAMainController;
import de.vw.mib.asl.internal.car.fpa.FPAStateWorkServices;
import de.vw.mib.asl.internal.car.fpa.HsmTargetFPA;
import de.vw.mib.asl.internal.car.fpa.service.FPACharismaProfileServiceImpl;
import de.vw.mib.asl.internal.car.fpa.transformer.CollectorFPASettings;
import de.vw.mib.asl.internal.car.transformer.CarFunctionCollector;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import generated.de.vw.mib.asl.internal.ListManager;
import java.util.ArrayList;
import java.util.Arrays;
import org.dsi.ifc.cardrivingcharacteristics.CharismaListUpdateInfo;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithOptionMask;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithoutOptionMask;
import org.dsi.ifc.cardrivingcharacteristics.CharismaViewOptions;
import org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoMidFrequent;
import org.dsi.ifc.powermanagement.ClampSignal;

public class StateWork
extends AbstractHsmState
implements FPAStateWorkServices {
    private final HsmTargetFPA myTarget;
    private final boolean[] AVAILABLE_PROFILES = new boolean[12];
    private boolean fsgIssue = false;
    boolean isPopupRequested = false;
    private CharismaListUpdateInfo charismaInformation = null;
    private int currentActiveProfile = 0;
    private final CarFunctionCollector[] availableState = new CarFunctionCollector[12];
    private boolean isClamp15 = false;
    private boolean hmiIsReady = false;
    private static final int CONTINUOUS_DAMPER_VALUE_MIN;
    private static final int CONTINUOUS_DAMPER_VALUE_MAX;
    private static final int CONTINUOUS_DAMPER_STEP_SIZE;
    private static final int DCC_MASK_VALUE;
    private final DCCController dccArraySliderController;
    private final FPAMainController fpaMainController;
    private int currentHMIDCCSliderValue = 0;
    private boolean targetIsReady = false;
    private boolean isValetParkingActive = false;
    boolean isOffroadRequested = false;

    public StateWork(HsmTargetFPA hsmTargetFPA, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.myTarget = hsmTargetFPA;
        this.dccArraySliderController = new DCCController(this);
        this.fpaMainController = new FPAMainController(this, this.myTarget);
        this.fpaMainController.init();
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (this.myTarget.isTraceEnabled()) {
            this.myTarget.trace().append("Event for FPA: ").append(eventGeneric.getReceiverEventId()).append(" Params: ").append(eventGeneric.getParamString()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.myTarget.init();
                this.myTarget.registerOnModelEvents();
                this.intiModel();
                ASLCarUtil.perfomanceTrigger(12);
                this.myTarget.registerOnCarFpaViewOptions();
                this.myTarget.registerOnCarFpaListUpdateInfo();
                this.myTarget.registerOnCarClampSignal();
                this.myTarget.registerOnVehicleStatesMidFrequent();
                FPACharismaProfileServiceImpl.getInstance().registerServiceProvider();
                break;
            }
            case 1073744983: {
                this.activateSelectedProfile(eventGeneric.getInt(0));
                break;
            }
            case 1073745140: {
                if (eventGeneric.getInt(0) == 1) {
                    this.myTarget.cancelPopup(this.myTarget.displayContent, 1);
                    break;
                }
                if (ServiceManager.configManagerDiag.isFeatureFlagSet(360) && this.currentActiveProfile == 4) {
                    this.myTarget.sendHMIEvent(10013);
                    this.isOffroadRequested = false;
                    break;
                }
                this.myTarget.showCharismaPopup(0, 1);
                break;
            }
            case 1073745144: {
                if (ServiceManager.configManagerDiag.isFeatureFlagSet(360) && (this.myTarget.displayContent == -1 || this.myTarget.displayContent == 0)) break;
                this.myTarget.showCharismaPopup(this.myTarget.displayContent, 0);
                break;
            }
            case 1073744992: {
                this.settingUpAC(eventGeneric.getInt(0));
                break;
            }
            case 1073744986: {
                this.settingUpACC(eventGeneric.getInt(0));
                break;
            }
            case 1073744987: {
                this.settingUpAFS(eventGeneric.getInt(0));
                break;
            }
            case 1073744993: {
                this.settingUpBeltTensioner(eventGeneric.getInt(0));
                break;
            }
            case 1073744984: {
                this.settingUpDCC(eventGeneric.getInt(0));
                break;
            }
            case 1073745193: {
                this.settingContinuousDamperValue(eventGeneric.getInt(0));
                break;
            }
            case 1073745194: {
                this.deIncreaseContinuousDamper(eventGeneric.getBoolean(0));
                break;
            }
            case 1073745226: {
                this.settingUpEngine(eventGeneric.getInt(0));
                break;
            }
            case 1073745227: {
                this.settingUpEngineSound(eventGeneric.getInt(0));
                break;
            }
            case 1073744991: {
                this.settingUpEngineStartStop(eventGeneric.getInt(0));
                break;
            }
            case 1073745000: {
                this.settingUpRouteType(eventGeneric.getInt(0));
                break;
            }
            case 1073744988: {
                this.settingUpSteering(eventGeneric.getInt(0));
                break;
            }
            case 1073745225: {
                this.settingUpTransmission(eventGeneric.getInt(0));
                break;
            }
            case 1073744994: {
                this.settingUpFrontAxleDifferentialMode(eventGeneric.getInt(0));
                break;
            }
            case 1073745035: {
                this.setCharismaSetFactoryDefault(this.myTarget.dsiCarFpa, this.getSetupSettingsProfile());
                break;
            }
            case 1073745013: {
                this.settingUpAntiRollbarMode(eventGeneric.getInt(0));
                break;
            }
            case 1073745006: {
                this.settingUpExhaustSystemSoundMode(eventGeneric.getInt(0));
                break;
            }
            case 1073745004: {
                this.settingUpAirSuspensionMode(eventGeneric.getInt(0));
                break;
            }
            case 1073745008: {
                this.settingUpAntiSlipControlMode(eventGeneric.getInt(0));
                break;
            }
            case 1073744998: {
                this.settingUpAutomaticLightMode(eventGeneric.getInt(0));
                break;
            }
            case 1073744997: {
                this.settingUpCenterAndRearAxleDifferentalMode(eventGeneric.getInt(0));
                break;
            }
            case 1073744996: {
                this.settingUpCenterDifferentialMode(eventGeneric.getInt(0));
                break;
            }
            case 1073745017: {
                this.settingUpChassisMode(eventGeneric.getInt(0));
                break;
            }
            case 1073745014: {
                this.settingUpCurveAssistMode(eventGeneric.getInt(0));
                break;
            }
            case 1073745030: {
                this.settingUpDisplaySetup1(eventGeneric.getInt(0));
                break;
            }
            case 1073745031: {
                this.settingUpDisplaySetup2(eventGeneric.getInt(0));
                break;
            }
            case 0x40000D4D: {
                this.settingUpDriveTrainMode(eventGeneric.getInt(0));
                break;
            }
            case 1073745233: {
                this.settingUpDriverAssist1(eventGeneric.getInt(0));
                break;
            }
            case 1073745234: {
                this.settingUpDriverAssist2(eventGeneric.getInt(0));
                break;
            }
            case 1073745021: {
                this.settingUpDriverSeatMode(eventGeneric.getInt(0));
                break;
            }
            case 1073745024: {
                this.settingUpDynEngineMount(eventGeneric.getInt(0));
                break;
            }
            case 1073745034: {
                this.settingUpESoundMode(eventGeneric.getInt(0));
                break;
            }
            case 1073744999: {
                this.settingUpEcoAssistMode(eventGeneric.getInt(0));
                break;
            }
            case 1073745007: {
                this.settingUpElectricTorqueVectoringMode(eventGeneric.getInt(0));
                break;
            }
            case 1073745033: {
                this.settingUpEnergoAcc(eventGeneric.getInt(0));
                break;
            }
            case 1073745032: {
                this.settingUpEnergoDisplaySetup(eventGeneric.getInt(0));
                break;
            }
            case 1073745228: {
                this.settingUpEscMode(eventGeneric.getInt(0));
                break;
            }
            case 1073745018: {
                this.settingUpExhaustFlapMode(eventGeneric.getInt(0));
                break;
            }
            case 1073745230: {
                this.settingUpHillDescentControlMode(eventGeneric.getInt(0));
                break;
            }
            case 1073745015: {
                this.settingUpHybridComponents(eventGeneric.getInt(0));
                break;
            }
            case 1073745003: {
                this.settingUpInteriorLight(eventGeneric.getInt(0));
                break;
            }
            case 1073745023: {
                this.settingUpLaneAssist(eventGeneric.getInt(0));
                break;
            }
            case 1073745025: {
                this.settingUpMagneticRide(eventGeneric.getInt(0));
                break;
            }
            case 1073745009: {
                this.settingUpMatrixBeam(eventGeneric.getInt(0));
                break;
            }
            case 1073745001: {
                this.settingUpNavigationMode(eventGeneric.getInt(0));
                break;
            }
            case 1073745020: {
                this.settingUpPassengerCabin(eventGeneric.getInt(0));
                break;
            }
            case 1073744995: {
                this.settingUpRearAxleDifferentialMode(eventGeneric.getInt(0));
                break;
            }
            case 1073745012: {
                this.settingUpRearAxleSteeringMode(eventGeneric.getInt(0));
                break;
            }
            case 1073745010: {
                this.settingUpRearSpoiler(eventGeneric.getInt(0));
                break;
            }
            case 1073745005: {
                this.settingUpSeatSideBolsterAdjustement(eventGeneric.getInt(0));
                break;
            }
            case 1073745019: {
                this.settingUpSoundComponents(eventGeneric.getInt(0));
                break;
            }
            case 1073745002: {
                this.settingUpSuperpositionSteering(eventGeneric.getInt(0));
                break;
            }
            case 1073745026: {
                this.settingUpSwitchableDamper(eventGeneric.getInt(0));
                break;
            }
            case 1073745022: {
                this.settingUpTpmsMode(eventGeneric.getInt(0));
                break;
            }
            case 1073745133: {
                this.settingUpFreeRolling(eventGeneric.getInt(0));
                break;
            }
            case 2100022: {
                this.targetIsReady = true;
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    private void activateSelectedProfile(int n) {
        switch (n) {
            case 1: {
                this.myTarget.setProfile(1);
                break;
            }
            case 2: {
                this.myTarget.setProfile(2);
                break;
            }
            case 3: {
                this.myTarget.setProfile(3);
                break;
            }
            case 4: {
                this.myTarget.setProfile(4);
                break;
            }
            case 5: {
                this.myTarget.setProfile(5);
                break;
            }
            case 6: {
                this.myTarget.setProfile(6);
                break;
            }
            case 7: {
                this.myTarget.setProfile(7);
                break;
            }
            case 8: {
                this.myTarget.setProfile(8);
                break;
            }
            case 9: {
                this.myTarget.setProfile(10);
                break;
            }
            default: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("[ERROR] Selection does not exists in FPA!").log();
            }
        }
    }

    private void settingUpAC(int n) {
        switch (n) {
            case 0: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10289, n);
                this.sendingRequest(8, 1);
                break;
            }
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10289, n);
                this.sendingRequest(8, 2);
                break;
            }
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10289, n);
                this.sendingRequest(8, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10289, n);
                this.sendingRequest(8, 4);
                break;
            }
            case 4: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10289, n);
                this.sendingRequest(8, 5);
                break;
            }
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10289, n);
                this.sendingRequest(8, 6);
                break;
            }
            case 6: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10289, n);
                this.sendingRequest(8, 7);
                break;
            }
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10289, n);
                this.sendingRequest(8, 8);
                break;
            }
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10289, n);
                this.sendingRequest(8, 9);
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10289, n);
                this.sendingRequest(8, 10);
                break;
            }
            default: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("[ERROR] FPA AC selection does not implemented!").log();
            }
        }
    }

    private void settingUpACC(int n) {
        switch (n) {
            case 0: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10283, n);
                this.sendingRequest(9, 1);
                break;
            }
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10283, n);
                this.sendingRequest(9, 2);
                break;
            }
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10283, n);
                this.sendingRequest(9, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10283, n);
                this.sendingRequest(9, 4);
                break;
            }
            case 4: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10283, n);
                this.sendingRequest(9, 5);
                break;
            }
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10283, n);
                this.sendingRequest(9, 6);
                break;
            }
            case 6: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10283, n);
                this.sendingRequest(9, 7);
                break;
            }
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10283, n);
                this.sendingRequest(9, 8);
                break;
            }
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10283, n);
                this.sendingRequest(9, 9);
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10283, n);
                this.sendingRequest(9, 10);
                break;
            }
            default: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("[ERROR] FPA ACC selection does not implemented!").log();
            }
        }
    }

    private void settingUpAFS(int n) {
        switch (n) {
            case 0: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10284, n);
                this.sendingRequest(11, 1);
                break;
            }
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10284, n);
                this.sendingRequest(11, 2);
                break;
            }
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10284, n);
                this.sendingRequest(11, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10284, n);
                this.sendingRequest(11, 4);
                break;
            }
            case 4: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10284, n);
                this.sendingRequest(11, 5);
                break;
            }
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10284, n);
                this.sendingRequest(11, 6);
                break;
            }
            case 6: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10284, n);
                this.sendingRequest(11, 7);
                break;
            }
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10284, n);
                this.sendingRequest(11, 8);
                break;
            }
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10284, n);
                this.sendingRequest(11, 9);
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10284, n);
                this.sendingRequest(11, 10);
                break;
            }
            default: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("[ERROR] FPA AFS selection does not implemented!").log();
            }
        }
    }

    private void settingUpBeltTensioner(int n) {
        switch (n) {
            case 0: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10290, n);
                this.sendingRequest(14, 1);
                break;
            }
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10290, n);
                this.sendingRequest(14, 2);
                break;
            }
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10290, n);
                this.sendingRequest(14, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10290, n);
                this.sendingRequest(14, 4);
                break;
            }
            case 4: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10290, n);
                this.sendingRequest(14, 5);
                break;
            }
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10290, n);
                this.sendingRequest(14, 6);
                break;
            }
            case 6: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10290, n);
                this.sendingRequest(14, 7);
                break;
            }
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10290, n);
                this.sendingRequest(14, 8);
                break;
            }
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10290, n);
                this.sendingRequest(14, 9);
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10290, n);
                this.sendingRequest(14, 10);
                break;
            }
            default: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("[ERROR] FPA Belt Tensioner selection does not implemented!").log();
            }
        }
    }

    private void settingUpDCC(int n) {
        switch (n) {
            case 0: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10281, n);
                this.sendingRequest(7, 1);
                break;
            }
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10281, n);
                this.sendingRequest(7, 2);
                break;
            }
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10281, n);
                this.sendingRequest(7, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10281, n);
                this.sendingRequest(7, 4);
                break;
            }
            case 4: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10281, n);
                this.sendingRequest(7, 5);
                break;
            }
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10281, n);
                this.sendingRequest(7, 6);
                break;
            }
            case 6: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10281, n);
                this.sendingRequest(7, 7);
                break;
            }
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10281, n);
                this.sendingRequest(7, 8);
                break;
            }
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10281, n);
                this.sendingRequest(7, 9);
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10281, n);
                this.sendingRequest(7, 10);
                break;
            }
            default: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("[ERROR] FPA DCC selection does not implemented!").log();
            }
        }
    }

    private void settingContinuousDamperValue(int n) {
        int n2 = Math.min(15, Math.max(1, n));
        this.dccArraySliderController.sendDSIValue(new Integer(n2));
    }

    private void deIncreaseContinuousDamper(boolean bl) {
        if (bl) {
            this.settingContinuousDamperValue(this.currentHMIDCCSliderValue + 1);
        } else {
            this.settingContinuousDamperValue(this.currentHMIDCCSliderValue - 1);
        }
    }

    void informDCCSliderHMI(int n) {
        this.currentHMIDCCSliderValue = n;
        AbstractASLHsmTarget.writeIntegerToDatapool(10601, this.currentHMIDCCSliderValue);
    }

    void sendDCCSliderDSI(int n) {
        this.sendingRequest(7, n);
    }

    void updateDCCSlider(int n) {
        this.dccArraySliderController.receiveDSIValue(new Integer(n));
    }

    private void settingUpEngine(int n) {
        switch (n) {
            case 0: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10871, n);
                this.sendingRequest(1, 1);
                break;
            }
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10871, n);
                this.sendingRequest(1, 2);
                break;
            }
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10871, n);
                this.sendingRequest(1, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10871, n);
                this.sendingRequest(1, 4);
                break;
            }
            case 4: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10871, n);
                this.sendingRequest(1, 5);
                break;
            }
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10871, n);
                this.sendingRequest(1, 6);
                break;
            }
            case 6: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10871, n);
                this.sendingRequest(1, 7);
                break;
            }
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10871, n);
                this.sendingRequest(1, 8);
                break;
            }
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10871, n);
                this.sendingRequest(1, 9);
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10871, n);
                this.sendingRequest(1, 10);
                break;
            }
            default: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("[ERROR] FPA Engine selection does not implemented!").log();
            }
        }
    }

    private void settingUpEngineSound(int n) {
        switch (n) {
            case 0: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10872, n);
                this.sendingRequest(10, 1);
                break;
            }
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10872, n);
                this.sendingRequest(10, 2);
                break;
            }
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10872, n);
                this.sendingRequest(10, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10872, n);
                this.sendingRequest(10, 4);
                break;
            }
            case 4: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10872, n);
                this.sendingRequest(10, 5);
                break;
            }
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10872, n);
                this.sendingRequest(10, 6);
                break;
            }
            case 6: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10872, n);
                this.sendingRequest(10, 7);
                break;
            }
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10872, n);
                this.sendingRequest(10, 8);
                break;
            }
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10872, n);
                this.sendingRequest(10, 9);
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10872, n);
                this.sendingRequest(10, 10);
                break;
            }
            default: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("[ERROR] FPA Engine Sound selection does not implemented!").log();
            }
        }
    }

    private void settingUpEngineStartStop(int n) {
        switch (n) {
            case 0: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10288, n);
                this.sendingRequest(2, 1);
                break;
            }
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10288, n);
                this.sendingRequest(2, 2);
                break;
            }
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10288, n);
                this.sendingRequest(2, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10288, n);
                this.sendingRequest(2, 4);
                break;
            }
            case 4: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10288, n);
                this.sendingRequest(2, 5);
                break;
            }
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10288, n);
                this.sendingRequest(2, 6);
                break;
            }
            case 6: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10288, n);
                this.sendingRequest(2, 7);
                break;
            }
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10288, n);
                this.sendingRequest(2, 8);
                break;
            }
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10288, n);
                this.sendingRequest(2, 9);
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10288, n);
                this.sendingRequest(2, 10);
                break;
            }
            default: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("[ERROR] FPA Engine Start Stop selection does not implemented!").log();
            }
        }
    }

    private void settingUpRouteType(int n) {
        switch (n) {
            case 0: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10297, n);
                this.sendingRequest(16, 1);
                break;
            }
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10297, n);
                this.sendingRequest(16, 2);
                break;
            }
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10297, n);
                this.sendingRequest(16, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10297, n);
                this.sendingRequest(16, 4);
                break;
            }
            case 4: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10297, n);
                this.sendingRequest(16, 5);
                break;
            }
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10297, n);
                this.sendingRequest(16, 6);
                break;
            }
            case 6: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10297, n);
                this.sendingRequest(16, 7);
                break;
            }
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10297, n);
                this.sendingRequest(16, 8);
                break;
            }
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10297, n);
                this.sendingRequest(16, 9);
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10297, n);
                this.sendingRequest(16, 10);
                break;
            }
            default: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("[ERROR] FPA Route Type selection does not implemented!").log();
            }
        }
    }

    private void settingUpSteering(int n) {
        switch (n) {
            case 0: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10285, n);
                this.sendingRequest(5, 1);
                break;
            }
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10285, n);
                this.sendingRequest(5, 2);
                break;
            }
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10285, n);
                this.sendingRequest(5, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10285, n);
                this.sendingRequest(5, 4);
                break;
            }
            case 4: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10285, n);
                this.sendingRequest(5, 5);
                break;
            }
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10285, n);
                this.sendingRequest(5, 6);
                break;
            }
            case 6: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10285, n);
                this.sendingRequest(5, 7);
                break;
            }
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10285, n);
                this.sendingRequest(5, 8);
                break;
            }
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10285, n);
                this.sendingRequest(5, 9);
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10285, n);
                this.sendingRequest(5, 10);
                break;
            }
            default: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("[ERROR] FPA Steering selection does not implemented!").log();
            }
        }
    }

    private void settingUpTransmission(int n) {
        switch (n) {
            case 0: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10870, n);
                this.sendingRequest(3, 1);
                break;
            }
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10870, n);
                this.sendingRequest(3, 2);
                break;
            }
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10870, n);
                this.sendingRequest(3, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10870, n);
                this.sendingRequest(3, 4);
                break;
            }
            case 4: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10870, n);
                this.sendingRequest(3, 5);
                break;
            }
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10870, n);
                this.sendingRequest(3, 6);
                break;
            }
            case 6: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10870, n);
                this.sendingRequest(3, 7);
                break;
            }
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10870, n);
                this.sendingRequest(3, 8);
                break;
            }
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10870, n);
                this.sendingRequest(3, 9);
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10870, n);
                this.sendingRequest(3, 10);
                break;
            }
            default: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("[ERROR] FPA TRANSMISSION selection does not implemented!").log();
            }
        }
    }

    private void settingUpFrontAxleDifferentialMode(int n) {
        switch (n) {
            case 0: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10291, n);
                this.sendingRequest(21, 1);
                break;
            }
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10291, n);
                this.sendingRequest(21, 2);
                break;
            }
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10291, n);
                this.sendingRequest(21, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10291, n);
                this.sendingRequest(21, 4);
                break;
            }
            case 4: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10291, n);
                this.sendingRequest(21, 5);
                break;
            }
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10291, n);
                this.sendingRequest(21, 6);
                break;
            }
            case 6: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10291, n);
                this.sendingRequest(21, 7);
                break;
            }
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10291, n);
                this.sendingRequest(21, 8);
                break;
            }
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10291, n);
                this.sendingRequest(21, 9);
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10291, n);
                this.sendingRequest(21, 10);
                break;
            }
            default: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("[ERROR] FPA FrontAxleDifferential selection does not implemented!").log();
            }
        }
    }

    private void settingUpTpmsMode(int n) {
        switch (n) {
            case 0: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10320, n);
                this.sendingRequest(39, 1);
                break;
            }
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10320, n);
                this.sendingRequest(39, 2);
                break;
            }
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10320, n);
                this.sendingRequest(39, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10320, n);
                this.sendingRequest(39, 4);
                break;
            }
            case 4: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10320, n);
                this.sendingRequest(39, 5);
                break;
            }
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10320, n);
                this.sendingRequest(39, 6);
                break;
            }
            case 6: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10320, n);
                this.sendingRequest(39, 7);
                break;
            }
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10320, n);
                this.sendingRequest(39, 8);
                break;
            }
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10320, n);
                this.sendingRequest(39, 9);
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10320, n);
                this.sendingRequest(39, 10);
                break;
            }
            default: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("[ERROR] FPA TPMS selection does not implemented!").log();
            }
        }
    }

    private void settingUpFreeRolling(int n) {
        switch (n) {
            case 0: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10520, n);
                this.sendingRequest(18, 1);
                break;
            }
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10520, n);
                this.sendingRequest(18, 2);
                break;
            }
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10520, n);
                this.sendingRequest(18, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10520, n);
                this.sendingRequest(18, 4);
                break;
            }
            case 4: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10520, n);
                this.sendingRequest(18, 5);
                break;
            }
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10520, n);
                this.sendingRequest(18, 6);
                break;
            }
            case 6: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10520, n);
                this.sendingRequest(18, 7);
                break;
            }
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10520, n);
                this.sendingRequest(18, 8);
                break;
            }
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10520, n);
                this.sendingRequest(18, 9);
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10520, n);
                this.sendingRequest(18, 10);
                break;
            }
            default: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("[ERROR] FPA FREE_ROLLING_MODE selection does not implemented!").log();
            }
        }
    }

    private void settingUpSwitchableDamper(int n) {
        switch (n) {
            case 0: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10324, n);
                this.sendingRequest(43, 1);
                break;
            }
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10324, n);
                this.sendingRequest(43, 2);
                break;
            }
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10324, n);
                this.sendingRequest(43, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10324, n);
                this.sendingRequest(43, 4);
                break;
            }
            case 4: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10324, n);
                this.sendingRequest(43, 5);
                break;
            }
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10324, n);
                this.sendingRequest(43, 6);
                break;
            }
            case 6: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10324, n);
                this.sendingRequest(43, 7);
                break;
            }
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10324, n);
                this.sendingRequest(43, 8);
                break;
            }
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10324, n);
                this.sendingRequest(43, 9);
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10324, n);
                this.sendingRequest(43, 10);
                break;
            }
            default: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("[ERROR] FPA CHARISMAFUNCTIONS_SWITCHABLEDAMPER selection does not implemented!").log();
            }
        }
    }

    private void settingUpSuperpositionSteering(int n) {
        switch (n) {
            case 0: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10300, n);
                this.sendingRequest(6, 1);
                break;
            }
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10300, n);
                this.sendingRequest(6, 2);
                break;
            }
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10300, n);
                this.sendingRequest(6, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10300, n);
                this.sendingRequest(6, 4);
                break;
            }
            case 4: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10300, n);
                this.sendingRequest(6, 5);
                break;
            }
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10300, n);
                this.sendingRequest(6, 6);
                break;
            }
            case 6: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10300, n);
                this.sendingRequest(6, 7);
                break;
            }
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10300, n);
                this.sendingRequest(6, 8);
                break;
            }
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10300, n);
                this.sendingRequest(6, 9);
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10300, n);
                this.sendingRequest(6, 10);
                break;
            }
            default: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("[ERROR] FPA CHARISMAFUNCTIONS_SUPERPOSITIONSTEERING selection does not implemented!").log();
            }
        }
    }

    private void settingUpSoundComponents(int n) {
        switch (n) {
            case 0: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10317, n);
                this.sendingRequest(36, 1);
                break;
            }
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10317, n);
                this.sendingRequest(36, 2);
                break;
            }
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10317, n);
                this.sendingRequest(36, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10317, n);
                this.sendingRequest(36, 4);
                break;
            }
            case 4: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10317, n);
                this.sendingRequest(36, 5);
                break;
            }
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10317, n);
                this.sendingRequest(36, 6);
                break;
            }
            case 6: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10317, n);
                this.sendingRequest(36, 7);
                break;
            }
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10317, n);
                this.sendingRequest(36, 8);
                break;
            }
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10317, n);
                this.sendingRequest(36, 9);
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10317, n);
                this.sendingRequest(36, 10);
                break;
            }
            default: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("[ERROR] FPA CHARISMAFUNCTIONS_SOUNDCOMPONENTS selection does not implemented!").log();
            }
        }
    }

    private void settingUpSeatSideBolsterAdjustement(int n) {
        switch (n) {
            case 0: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10303, n);
                this.sendingRequest(15, 1);
                break;
            }
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10303, n);
                this.sendingRequest(15, 2);
                break;
            }
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10303, n);
                this.sendingRequest(15, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10303, n);
                this.sendingRequest(15, 4);
                break;
            }
            case 4: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10303, n);
                this.sendingRequest(15, 5);
                break;
            }
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10303, n);
                this.sendingRequest(15, 6);
                break;
            }
            case 6: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10303, n);
                this.sendingRequest(15, 7);
                break;
            }
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10303, n);
                this.sendingRequest(15, 8);
                break;
            }
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10303, n);
                this.sendingRequest(15, 9);
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10303, n);
                this.sendingRequest(15, 10);
                break;
            }
            default: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("[ERROR] FPA CHARISMAFUNCTIONS_SEATSIDEBOLSTERADJUSTMENT selection does not implemented!").log();
            }
        }
    }

    private void settingUpRearSpoiler(int n) {
        switch (n) {
            case 0: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10308, n);
                this.sendingRequest(27, 1);
                break;
            }
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10308, n);
                this.sendingRequest(27, 2);
                break;
            }
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10308, n);
                this.sendingRequest(27, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10308, n);
                this.sendingRequest(27, 4);
                break;
            }
            case 4: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10308, n);
                this.sendingRequest(27, 5);
                break;
            }
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10308, n);
                this.sendingRequest(27, 6);
                break;
            }
            case 6: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10308, n);
                this.sendingRequest(27, 7);
                break;
            }
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10308, n);
                this.sendingRequest(27, 8);
                break;
            }
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10308, n);
                this.sendingRequest(27, 9);
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10308, n);
                this.sendingRequest(27, 10);
                break;
            }
            default: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("[ERROR] FPA CHARISMAFUNCTIONS_REARSPOILER selection does not implemented!").log();
            }
        }
    }

    private void settingUpRearAxleSteeringMode(int n) {
        switch (n) {
            case 0: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10310, n);
                this.sendingRequest(29, 1);
                break;
            }
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10310, n);
                this.sendingRequest(29, 2);
                break;
            }
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10310, n);
                this.sendingRequest(29, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10310, n);
                this.sendingRequest(29, 4);
                break;
            }
            case 4: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10310, n);
                this.sendingRequest(29, 5);
                break;
            }
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10310, n);
                this.sendingRequest(29, 6);
                break;
            }
            case 6: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10310, n);
                this.sendingRequest(29, 7);
                break;
            }
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10310, n);
                this.sendingRequest(29, 8);
                break;
            }
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10310, n);
                this.sendingRequest(29, 9);
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10310, n);
                this.sendingRequest(29, 10);
                break;
            }
            default: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("[ERROR] FPA CHARISMAFUNCTIONS_REARAXLESTEERINGSYSTEM selection does not implemented!").log();
            }
        }
    }

    private void settingUpRearAxleDifferentialMode(int n) {
        switch (n) {
            case 0: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10292, n);
                this.sendingRequest(4, 1);
                break;
            }
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10292, n);
                this.sendingRequest(4, 2);
                break;
            }
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10292, n);
                this.sendingRequest(4, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10292, n);
                this.sendingRequest(4, 4);
                break;
            }
            case 4: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10292, n);
                this.sendingRequest(4, 5);
                break;
            }
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10292, n);
                this.sendingRequest(4, 6);
                break;
            }
            case 6: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10292, n);
                this.sendingRequest(4, 7);
                break;
            }
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10292, n);
                this.sendingRequest(4, 8);
                break;
            }
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10292, n);
                this.sendingRequest(4, 9);
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10292, n);
                this.sendingRequest(4, 10);
                break;
            }
            default: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("[ERROR] FPA CHARISMAFUNCTIONS_REARAXLEDIFFERENTIAL selection does not implemented!").log();
            }
        }
    }

    private void settingUpPassengerCabin(int n) {
        switch (n) {
            case 0: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10318, n);
                this.sendingRequest(37, 1);
                break;
            }
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10318, n);
                this.sendingRequest(37, 2);
                break;
            }
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10318, n);
                this.sendingRequest(37, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10318, n);
                this.sendingRequest(37, 4);
                break;
            }
            case 4: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10318, n);
                this.sendingRequest(37, 5);
                break;
            }
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10318, n);
                this.sendingRequest(37, 6);
                break;
            }
            case 6: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10318, n);
                this.sendingRequest(37, 7);
                break;
            }
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10318, n);
                this.sendingRequest(37, 8);
                break;
            }
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10318, n);
                this.sendingRequest(37, 9);
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10318, n);
                this.sendingRequest(37, 10);
                break;
            }
            default: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("[ERROR] FPA CHARISMAFUNCTIONS_PASSENGERCABIN selection does not implemented!").log();
            }
        }
    }

    private void settingUpNavigationMode(int n) {
        switch (n) {
            case 0: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10299, n);
                this.sendingRequest(17, 1);
                break;
            }
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10299, n);
                this.sendingRequest(17, 2);
                break;
            }
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10299, n);
                this.sendingRequest(17, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10299, n);
                this.sendingRequest(17, 4);
                break;
            }
            case 4: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10299, n);
                this.sendingRequest(17, 5);
                break;
            }
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10299, n);
                this.sendingRequest(17, 6);
                break;
            }
            case 6: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10299, n);
                this.sendingRequest(17, 7);
                break;
            }
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10299, n);
                this.sendingRequest(17, 8);
                break;
            }
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10299, n);
                this.sendingRequest(17, 9);
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10299, n);
                this.sendingRequest(17, 10);
                break;
            }
            default: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("[ERROR] FPA CHARISMAFUNCTIONS_NAVIGATION2 selection does not implemented!").log();
            }
        }
    }

    private void settingUpMatrixBeam(int n) {
        switch (n) {
            case 0: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10307, n);
                this.sendingRequest(26, 1);
                break;
            }
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10307, n);
                this.sendingRequest(26, 2);
                break;
            }
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10307, n);
                this.sendingRequest(26, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10307, n);
                this.sendingRequest(26, 4);
                break;
            }
            case 4: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10307, n);
                this.sendingRequest(26, 5);
                break;
            }
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10307, n);
                this.sendingRequest(26, 6);
                break;
            }
            case 6: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10307, n);
                this.sendingRequest(26, 7);
                break;
            }
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10307, n);
                this.sendingRequest(26, 8);
                break;
            }
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10307, n);
                this.sendingRequest(26, 9);
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10307, n);
                this.sendingRequest(26, 10);
                break;
            }
            default: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("[ERROR] FPA CHARISMAFUNCTIONS_MATRIXBEAM selection does not implemented!").log();
            }
        }
    }

    private void settingUpMagneticRide(int n) {
        switch (n) {
            case 0: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10323, n);
                this.sendingRequest(42, 1);
                break;
            }
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10323, n);
                this.sendingRequest(42, 2);
                break;
            }
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10323, n);
                this.sendingRequest(42, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10323, n);
                this.sendingRequest(42, 4);
                break;
            }
            case 4: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10323, n);
                this.sendingRequest(42, 5);
                break;
            }
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10323, n);
                this.sendingRequest(42, 6);
                break;
            }
            case 6: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10323, n);
                this.sendingRequest(42, 7);
                break;
            }
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10323, n);
                this.sendingRequest(42, 8);
                break;
            }
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10323, n);
                this.sendingRequest(42, 9);
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10323, n);
                this.sendingRequest(42, 10);
                break;
            }
            default: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("[ERROR] FPA CHARISMAFUNCTIONS_MAGNETICRIDE selection does not implemented!").log();
            }
        }
    }

    private void settingUpLaneAssist(int n) {
        switch (n) {
            case 0: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10321, n);
                this.sendingRequest(40, 1);
                break;
            }
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10321, n);
                this.sendingRequest(40, 2);
                break;
            }
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10321, n);
                this.sendingRequest(40, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10321, n);
                this.sendingRequest(40, 4);
                break;
            }
            case 4: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10321, n);
                this.sendingRequest(40, 5);
                break;
            }
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10321, n);
                this.sendingRequest(40, 6);
                break;
            }
            case 6: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10321, n);
                this.sendingRequest(40, 7);
                break;
            }
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10321, n);
                this.sendingRequest(40, 8);
                break;
            }
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10321, n);
                this.sendingRequest(40, 9);
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10321, n);
                this.sendingRequest(40, 10);
                break;
            }
            default: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("[ERROR] FPA CHARISMAFUNCTIONS_LANEASSIST selection does not implemented!").log();
            }
        }
    }

    private void settingUpInteriorLight(int n) {
        switch (n) {
            case 0: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10301, n);
                this.sendingRequest(12, 1);
                break;
            }
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10301, n);
                this.sendingRequest(12, 2);
                break;
            }
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10301, n);
                this.sendingRequest(12, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10301, n);
                this.sendingRequest(12, 4);
                break;
            }
            case 4: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10301, n);
                this.sendingRequest(12, 5);
                break;
            }
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10301, n);
                this.sendingRequest(12, 6);
                break;
            }
            case 6: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10301, n);
                this.sendingRequest(12, 7);
                break;
            }
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10301, n);
                this.sendingRequest(12, 8);
                break;
            }
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10301, n);
                this.sendingRequest(12, 9);
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10301, n);
                this.sendingRequest(12, 10);
                break;
            }
            default: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("[ERROR] FPA CHARISMAFUNCTIONS_INTERIORLIGHT selection does not implemented!").log();
            }
        }
    }

    private void settingUpHybridComponents(int n) {
        switch (n) {
            case 0: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10313, n);
                this.sendingRequest(32, 1);
                break;
            }
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10313, n);
                this.sendingRequest(32, 2);
                break;
            }
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10313, n);
                this.sendingRequest(32, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10313, n);
                this.sendingRequest(32, 4);
                break;
            }
            case 4: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10313, n);
                this.sendingRequest(32, 5);
                break;
            }
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10313, n);
                this.sendingRequest(32, 6);
                break;
            }
            case 6: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10313, n);
                this.sendingRequest(32, 7);
                break;
            }
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10313, n);
                this.sendingRequest(32, 8);
                break;
            }
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10313, n);
                this.sendingRequest(32, 9);
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10313, n);
                this.sendingRequest(32, 10);
                break;
            }
            default: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("[ERROR] FPA CHARISMAFUNCTIONS_HYBRIDCOMPONENTS selection does not implemented!").log();
            }
        }
    }

    private void settingUpHillDescentControlMode(int n) {
        switch (n) {
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10875, n);
                this.sendingRequest(44, 2);
                break;
            }
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10875, n);
                this.sendingRequest(44, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10875, n);
                this.sendingRequest(44, 4);
                break;
            }
            case 4: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10875, n);
                this.sendingRequest(44, 5);
                break;
            }
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10875, n);
                this.sendingRequest(44, 6);
                break;
            }
            case 6: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10875, n);
                this.sendingRequest(44, 7);
                break;
            }
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10875, n);
                this.sendingRequest(44, 8);
                break;
            }
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10875, n);
                this.sendingRequest(44, 9);
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10875, n);
                this.sendingRequest(44, 10);
                break;
            }
            default: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("[ERROR] FPA CHARISMAFUNCTIONS_HILLSTEPDOWNASSIST selection does not implemented!").log();
            }
        }
    }

    private void settingUpExhaustFlapMode(int n) {
        switch (n) {
            case 0: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10316, n);
                this.sendingRequest(35, 1);
                break;
            }
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10316, n);
                this.sendingRequest(35, 2);
                break;
            }
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10316, n);
                this.sendingRequest(35, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10316, n);
                this.sendingRequest(35, 4);
                break;
            }
            case 4: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10316, n);
                this.sendingRequest(35, 5);
                break;
            }
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10316, n);
                this.sendingRequest(35, 6);
                break;
            }
            case 6: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10316, n);
                this.sendingRequest(35, 7);
                break;
            }
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10316, n);
                this.sendingRequest(35, 8);
                break;
            }
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10316, n);
                this.sendingRequest(35, 9);
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10316, n);
                this.sendingRequest(35, 10);
                break;
            }
            default: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("[ERROR] FPA CHARISMAFUNCTIONS_EXHAUSTFLAP selection does not implemented!").log();
            }
        }
    }

    private void settingUpEscMode(int n) {
        switch (n) {
            case 0: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10873, n);
                this.sendingRequest(28, 1);
                break;
            }
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10873, n);
                this.sendingRequest(28, 2);
                break;
            }
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10873, n);
                this.sendingRequest(28, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10873, n);
                this.sendingRequest(28, 4);
                break;
            }
            case 4: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10873, n);
                this.sendingRequest(28, 5);
                break;
            }
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10873, n);
                this.sendingRequest(28, 6);
                break;
            }
            case 6: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10873, n);
                this.sendingRequest(28, 7);
                break;
            }
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10873, n);
                this.sendingRequest(28, 8);
                break;
            }
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10873, n);
                this.sendingRequest(28, 9);
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10873, n);
                this.sendingRequest(28, 10);
                break;
            }
            default: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("[ERROR] FPA CHARISMAFUNCTIONS_ESC selection does not implemented!").log();
            }
        }
    }

    private void settingUpEnergoDisplaySetup(int n) {
        switch (n) {
            case 0: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10330, n);
                this.sendingRequest(49, 1);
                break;
            }
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10330, n);
                this.sendingRequest(49, 2);
                break;
            }
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10330, n);
                this.sendingRequest(49, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10330, n);
                this.sendingRequest(49, 4);
                break;
            }
            case 4: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10330, n);
                this.sendingRequest(49, 5);
                break;
            }
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10330, n);
                this.sendingRequest(49, 6);
                break;
            }
            case 6: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10330, n);
                this.sendingRequest(49, 7);
                break;
            }
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10330, n);
                this.sendingRequest(49, 8);
                break;
            }
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10330, n);
                this.sendingRequest(49, 9);
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10330, n);
                this.sendingRequest(49, 10);
                break;
            }
            default: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("[ERROR] FPA CHARISMAFUNCTIONS_BRAKECONTROLSYSTEM selection does not implemented!").log();
            }
        }
    }

    private void settingUpEnergoAcc(int n) {
        switch (n) {
            case 0: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10331, n);
                this.sendingRequest(50, 1);
                break;
            }
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10331, n);
                this.sendingRequest(50, 2);
                break;
            }
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10331, n);
                this.sendingRequest(50, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10331, n);
                this.sendingRequest(50, 4);
                break;
            }
            case 4: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10331, n);
                this.sendingRequest(50, 5);
                break;
            }
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10331, n);
                this.sendingRequest(50, 6);
                break;
            }
            case 6: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10331, n);
                this.sendingRequest(50, 7);
                break;
            }
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10331, n);
                this.sendingRequest(50, 8);
                break;
            }
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10331, n);
                this.sendingRequest(50, 9);
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10331, n);
                this.sendingRequest(50, 10);
                break;
            }
            default: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("[ERROR] FPA CHARISMAFUNCTIONS_ENERGO_ACC selection does not implemented!").log();
            }
        }
    }

    private void settingUpElectricTorqueVectoringMode(int n) {
        switch (n) {
            case 0: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10305, n);
                this.sendingRequest(24, 1);
                break;
            }
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10305, n);
                this.sendingRequest(24, 2);
                break;
            }
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10305, n);
                this.sendingRequest(24, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10305, n);
                this.sendingRequest(24, 4);
                break;
            }
            case 4: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10305, n);
                this.sendingRequest(24, 5);
                break;
            }
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10305, n);
                this.sendingRequest(24, 6);
                break;
            }
            case 6: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10305, n);
                this.sendingRequest(24, 7);
                break;
            }
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10305, n);
                this.sendingRequest(24, 8);
                break;
            }
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10305, n);
                this.sendingRequest(24, 9);
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10305, n);
                this.sendingRequest(24, 10);
                break;
            }
            default: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("[ERROR] FPA CHARISMAFUNCTIONS_ELECTRICTORQUEVECTORING selection does not implemented!").log();
            }
        }
    }

    private void settingUpEcoAssistMode(int n) {
        switch (n) {
            case 0: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10296, n);
                this.sendingRequest(19, 1);
                break;
            }
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10296, n);
                this.sendingRequest(19, 2);
                break;
            }
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10296, n);
                this.sendingRequest(19, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10296, n);
                this.sendingRequest(19, 4);
                break;
            }
            case 4: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10296, n);
                this.sendingRequest(19, 5);
                break;
            }
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10296, n);
                this.sendingRequest(19, 6);
                break;
            }
            case 6: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10296, n);
                this.sendingRequest(19, 7);
                break;
            }
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10296, n);
                this.sendingRequest(19, 8);
                break;
            }
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10296, n);
                this.sendingRequest(19, 9);
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10296, n);
                this.sendingRequest(19, 10);
                break;
            }
            default: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("[ERROR] FPA CHARISMAFUNCTIONS_ECOLIVETIPS selection does not implemented!").log();
            }
        }
    }

    private void settingUpESoundMode(int n) {
        switch (n) {
            case 0: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10332, n);
                this.sendingRequest(51, 1);
                break;
            }
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10332, n);
                this.sendingRequest(51, 2);
                break;
            }
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10332, n);
                this.sendingRequest(51, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10332, n);
                this.sendingRequest(51, 4);
                break;
            }
            case 4: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10332, n);
                this.sendingRequest(51, 5);
                break;
            }
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10332, n);
                this.sendingRequest(51, 6);
                break;
            }
            case 6: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10332, n);
                this.sendingRequest(51, 7);
                break;
            }
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10332, n);
                this.sendingRequest(51, 8);
                break;
            }
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10332, n);
                this.sendingRequest(51, 9);
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10332, n);
                this.sendingRequest(51, 10);
                break;
            }
            default: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("[ERROR] FPA CHARISMAFUNCTIONS_ESOUND selection does not implemented!").log();
            }
        }
    }

    private void settingUpDynEngineMount(int n) {
        switch (n) {
            case 0: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10322, n);
                this.sendingRequest(41, 1);
                break;
            }
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10322, n);
                this.sendingRequest(41, 2);
                break;
            }
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10322, n);
                this.sendingRequest(41, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10322, n);
                this.sendingRequest(41, 4);
                break;
            }
            case 4: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10322, n);
                this.sendingRequest(41, 5);
                break;
            }
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10322, n);
                this.sendingRequest(41, 6);
                break;
            }
            case 6: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10322, n);
                this.sendingRequest(41, 7);
                break;
            }
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10322, n);
                this.sendingRequest(41, 8);
                break;
            }
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10322, n);
                this.sendingRequest(41, 9);
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10322, n);
                this.sendingRequest(41, 10);
                break;
            }
            default: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("[ERROR] FPA CHARISMAFUNCTIONS_DYNENGINEMOUNT selection does not implemented!").log();
            }
        }
    }

    private void settingUpDriverSeatMode(int n) {
        switch (n) {
            case 0: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10319, n);
                this.sendingRequest(38, 1);
                break;
            }
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10319, n);
                this.sendingRequest(38, 2);
                break;
            }
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10319, n);
                this.sendingRequest(38, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10319, n);
                this.sendingRequest(38, 4);
                break;
            }
            case 4: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10319, n);
                this.sendingRequest(38, 5);
                break;
            }
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10319, n);
                this.sendingRequest(38, 6);
                break;
            }
            case 6: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10319, n);
                this.sendingRequest(38, 7);
                break;
            }
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10319, n);
                this.sendingRequest(38, 8);
                break;
            }
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10319, n);
                this.sendingRequest(38, 9);
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10319, n);
                this.sendingRequest(38, 10);
                break;
            }
            default: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("[ERROR] FPA CHARISMAFUNCTIONS_DRIVESEAT selection does not implemented!").log();
            }
        }
    }

    private void settingUpDriverAssist1(int n) {
        switch (n) {
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10879, n);
                this.sendingRequest(45, 2);
                break;
            }
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10879, n);
                this.sendingRequest(45, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10879, n);
                this.sendingRequest(45, 4);
                break;
            }
            case 4: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10879, n);
                this.sendingRequest(45, 5);
                break;
            }
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10879, n);
                this.sendingRequest(45, 6);
                break;
            }
            case 6: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10879, n);
                this.sendingRequest(45, 7);
                break;
            }
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10879, n);
                this.sendingRequest(45, 8);
                break;
            }
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10879, n);
                this.sendingRequest(45, 9);
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10879, n);
                this.sendingRequest(45, 10);
                break;
            }
            default: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("[ERROR] FPA CHARISMAFUNCTIONS_DRIVERASSIST_1 selection does not implemented!").log();
            }
        }
    }

    private void settingUpDriverAssist2(int n) {
        switch (n) {
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10880, n);
                this.sendingRequest(46, 2);
                break;
            }
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10880, n);
                this.sendingRequest(46, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10880, n);
                this.sendingRequest(46, 4);
                break;
            }
            case 4: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10880, n);
                this.sendingRequest(46, 5);
                break;
            }
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10880, n);
                this.sendingRequest(46, 6);
                break;
            }
            case 6: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10880, n);
                this.sendingRequest(46, 7);
                break;
            }
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10880, n);
                this.sendingRequest(46, 8);
                break;
            }
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10880, n);
                this.sendingRequest(46, 9);
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10880, n);
                this.sendingRequest(46, 10);
                break;
            }
            default: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("[ERROR] FPA CHARISMAFUNCTIONS_DRIVERASSIST_2 selection does not implemented!").log();
            }
        }
    }

    private void settingUpDriveTrainMode(int n) {
        switch (n) {
            case 0: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10874, n);
                this.sendingRequest(33, 1);
                break;
            }
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10874, n);
                this.sendingRequest(33, 2);
                break;
            }
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10874, n);
                this.sendingRequest(33, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10874, n);
                this.sendingRequest(33, 4);
                break;
            }
            case 4: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10874, n);
                this.sendingRequest(33, 5);
                break;
            }
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10874, n);
                this.sendingRequest(33, 6);
                break;
            }
            case 6: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10874, n);
                this.sendingRequest(33, 7);
                break;
            }
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10874, n);
                this.sendingRequest(33, 8);
                break;
            }
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10874, n);
                this.sendingRequest(33, 9);
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10874, n);
                this.sendingRequest(33, 10);
                break;
            }
            case 12: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10874, n);
                this.sendingRequest(33, 13);
                break;
            }
            default: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("[ERROR] FPA CHARISMAFUNCTIONS_DRIVETRAIN selection does not implemented!").log();
            }
        }
    }

    private void settingUpDisplaySetup2(int n) {
        switch (n) {
            case 0: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10329, n);
                this.sendingRequest(48, 1);
                break;
            }
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10329, n);
                this.sendingRequest(48, 2);
                break;
            }
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10329, n);
                this.sendingRequest(48, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10329, n);
                this.sendingRequest(48, 4);
                break;
            }
            case 4: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10329, n);
                this.sendingRequest(48, 5);
                break;
            }
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10329, n);
                this.sendingRequest(48, 6);
                break;
            }
            case 6: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10329, n);
                this.sendingRequest(48, 7);
                break;
            }
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10329, n);
                this.sendingRequest(48, 8);
                break;
            }
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10329, n);
                this.sendingRequest(48, 9);
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10329, n);
                this.sendingRequest(48, 10);
                break;
            }
            default: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("[ERROR] FPA CHARISMAFUNCTIONS_DISPLAYSETUP_2 selection does not implemented!").log();
            }
        }
    }

    private void settingUpDisplaySetup1(int n) {
        switch (n) {
            case 0: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10328, n);
                this.sendingRequest(47, 1);
                break;
            }
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10328, n);
                this.sendingRequest(47, 2);
                break;
            }
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10328, n);
                this.sendingRequest(47, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10328, n);
                this.sendingRequest(47, 4);
                break;
            }
            case 4: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10328, n);
                this.sendingRequest(47, 5);
                break;
            }
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10328, n);
                this.sendingRequest(47, 6);
                break;
            }
            case 6: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10328, n);
                this.sendingRequest(47, 7);
                break;
            }
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10328, n);
                this.sendingRequest(47, 8);
                break;
            }
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10328, n);
                this.sendingRequest(47, 9);
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10328, n);
                this.sendingRequest(47, 10);
                break;
            }
            default: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("[ERROR] FPA CHARISMAFUNCTIONS_DISPLAYSETUP_1 selection does not implemented!").log();
            }
        }
    }

    private void settingUpCurveAssistMode(int n) {
        switch (n) {
            case 0: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10312, n);
                this.sendingRequest(31, 1);
                break;
            }
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10312, n);
                this.sendingRequest(31, 2);
                break;
            }
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10312, n);
                this.sendingRequest(31, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10312, n);
                this.sendingRequest(31, 4);
                break;
            }
            case 4: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10312, n);
                this.sendingRequest(31, 5);
                break;
            }
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10312, n);
                this.sendingRequest(31, 6);
                break;
            }
            case 6: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10312, n);
                this.sendingRequest(31, 7);
                break;
            }
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10312, n);
                this.sendingRequest(31, 8);
                break;
            }
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10312, n);
                this.sendingRequest(31, 9);
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10312, n);
                this.sendingRequest(31, 10);
                break;
            }
            default: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("[ERROR] FPA CHARISMAFUNCTIONS_CURVEASSIST selection does not implemented!").log();
            }
        }
    }

    private void settingUpChassisMode(int n) {
        switch (n) {
            case 0: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10315, n);
                this.sendingRequest(34, 1);
                break;
            }
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10315, n);
                this.sendingRequest(34, 2);
                break;
            }
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10315, n);
                this.sendingRequest(34, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10315, n);
                this.sendingRequest(34, 4);
                break;
            }
            case 4: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10315, n);
                this.sendingRequest(34, 5);
                break;
            }
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10315, n);
                this.sendingRequest(34, 6);
                break;
            }
            case 6: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10315, n);
                this.sendingRequest(34, 7);
                break;
            }
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10315, n);
                this.sendingRequest(34, 8);
                break;
            }
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10315, n);
                this.sendingRequest(34, 9);
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10315, n);
                this.sendingRequest(34, 10);
                break;
            }
            default: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("[ERROR] FPA CHARISMAFUNCTIONS_CHASSIS selection does not implemented!").log();
            }
        }
    }

    private void settingUpCenterDifferentialMode(int n) {
        switch (n) {
            case 0: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10293, n);
                this.sendingRequest(22, 1);
                break;
            }
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10293, n);
                this.sendingRequest(22, 2);
                break;
            }
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10293, n);
                this.sendingRequest(22, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10293, n);
                this.sendingRequest(22, 4);
                break;
            }
            case 4: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10293, n);
                this.sendingRequest(22, 5);
                break;
            }
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10293, n);
                this.sendingRequest(22, 6);
                break;
            }
            case 6: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10293, n);
                this.sendingRequest(22, 7);
                break;
            }
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10293, n);
                this.sendingRequest(22, 8);
                break;
            }
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10293, n);
                this.sendingRequest(22, 9);
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10293, n);
                this.sendingRequest(22, 10);
                break;
            }
            default: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("[ERROR] FPA CHARISMAFUNCTIONS_CENTREDIFFERENTIAL selection does not implemented!").log();
            }
        }
    }

    private void settingUpCenterAndRearAxleDifferentalMode(int n) {
        switch (n) {
            case 0: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10294, n);
                this.sendingRequest(23, 1);
                break;
            }
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10294, n);
                this.sendingRequest(23, 2);
                break;
            }
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10294, n);
                this.sendingRequest(23, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10294, n);
                this.sendingRequest(23, 4);
                break;
            }
            case 4: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10294, n);
                this.sendingRequest(23, 5);
                break;
            }
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10294, n);
                this.sendingRequest(23, 6);
                break;
            }
            case 6: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10294, n);
                this.sendingRequest(23, 7);
                break;
            }
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10294, n);
                this.sendingRequest(23, 8);
                break;
            }
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10294, n);
                this.sendingRequest(23, 9);
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10294, n);
                this.sendingRequest(23, 10);
                break;
            }
            default: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("[ERROR] FPA CHARISMAFUNCTIONS_CENTREANDREARAXLEDIFFERENTIAL selection does not implemented!").log();
            }
        }
    }

    private void settingUpAutomaticLightMode(int n) {
        switch (n) {
            case 0: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10295, n);
                this.sendingRequest(11, 1);
                break;
            }
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10295, n);
                this.sendingRequest(11, 2);
                break;
            }
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10295, n);
                this.sendingRequest(11, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10295, n);
                this.sendingRequest(11, 4);
                break;
            }
            case 4: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10295, n);
                this.sendingRequest(11, 5);
                break;
            }
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10295, n);
                this.sendingRequest(11, 6);
                break;
            }
            case 6: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10295, n);
                this.sendingRequest(11, 7);
                break;
            }
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10295, n);
                this.sendingRequest(11, 8);
                break;
            }
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10295, n);
                this.sendingRequest(11, 9);
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10295, n);
                this.sendingRequest(11, 10);
                break;
            }
            default: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("[ERROR] FPA CHARISMAFUNCTIONS_STEERABLEBEAM selection does not implemented!").log();
            }
        }
    }

    private void settingUpAntiSlipControlMode(int n) {
        switch (n) {
            case 0: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10306, n);
                this.sendingRequest(25, 1);
                break;
            }
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10306, n);
                this.sendingRequest(25, 2);
                break;
            }
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10306, n);
                this.sendingRequest(25, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10306, n);
                this.sendingRequest(25, 4);
                break;
            }
            case 4: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10306, n);
                this.sendingRequest(25, 5);
                break;
            }
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10306, n);
                this.sendingRequest(25, 6);
                break;
            }
            case 6: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10306, n);
                this.sendingRequest(25, 7);
                break;
            }
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10306, n);
                this.sendingRequest(25, 8);
                break;
            }
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10306, n);
                this.sendingRequest(25, 9);
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10306, n);
                this.sendingRequest(25, 10);
                break;
            }
            default: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("[ERROR] FPA CHARISMAFUNCTIONS_ANTISLIPCONTROL selection does not implemented!").log();
            }
        }
    }

    private void settingUpAirSuspensionMode(int n) {
        switch (n) {
            case 0: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10302, n);
                this.sendingRequest(13, 1);
                break;
            }
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10302, n);
                this.sendingRequest(13, 2);
                break;
            }
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10302, n);
                this.sendingRequest(13, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10302, n);
                this.sendingRequest(13, 4);
                break;
            }
            case 4: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10302, n);
                this.sendingRequest(13, 5);
                break;
            }
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10302, n);
                this.sendingRequest(13, 6);
                break;
            }
            case 6: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10302, n);
                this.sendingRequest(13, 7);
                break;
            }
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10302, n);
                this.sendingRequest(13, 8);
                break;
            }
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10302, n);
                this.sendingRequest(13, 9);
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10302, n);
                this.sendingRequest(13, 10);
                break;
            }
            default: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("[ERROR] FPA CHARISMAFUNCTIONS_AIRSUSPENSION selection does not implemented!").log();
            }
        }
    }

    private void settingUpExhaustSystemSoundMode(int n) {
        switch (n) {
            case 0: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10304, n);
                this.sendingRequest(20, 1);
                break;
            }
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10304, n);
                this.sendingRequest(20, 2);
                break;
            }
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10304, n);
                this.sendingRequest(20, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10304, n);
                this.sendingRequest(20, 4);
                break;
            }
            case 4: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10304, n);
                this.sendingRequest(20, 5);
                break;
            }
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10304, n);
                this.sendingRequest(20, 6);
                break;
            }
            case 6: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10304, n);
                this.sendingRequest(20, 7);
                break;
            }
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10304, n);
                this.sendingRequest(20, 8);
                break;
            }
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10304, n);
                this.sendingRequest(20, 9);
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10304, n);
                this.sendingRequest(20, 10);
                break;
            }
            default: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("[ERROR] FPA CHARISMAFUNCTIONS_ACTIVEEXHAUSTSYSTEMSOUNDCONTROL selection does not implemented!").log();
            }
        }
    }

    private void settingUpAntiRollbarMode(int n) {
        switch (n) {
            case 0: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10311, n);
                this.sendingRequest(30, 1);
                break;
            }
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10311, n);
                this.sendingRequest(30, 2);
                break;
            }
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10311, n);
                this.sendingRequest(30, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10311, n);
                this.sendingRequest(30, 4);
                break;
            }
            case 4: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10311, n);
                this.sendingRequest(30, 5);
                break;
            }
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10311, n);
                this.sendingRequest(30, 6);
                break;
            }
            case 6: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10311, n);
                this.sendingRequest(30, 7);
                break;
            }
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10311, n);
                this.sendingRequest(30, 8);
                break;
            }
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10311, n);
                this.sendingRequest(30, 9);
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10311, n);
                this.sendingRequest(30, 10);
                break;
            }
            default: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("[ERROR] FPA CHARISMAFUNCTIONS_ACTIVEANTIROLLBAR selection does not implemented!").log();
            }
        }
    }

    void sendingRequest(int n, int n2) {
        this.myTarget.requestCharismaFuntion(this.myTarget.currentProfile, this.computeSetupTableRequestForChangedFunction(n, this.myTarget.settingUpCharismaSettings(n, n2)));
    }

    public void dsiCarDrivingCharacteristicsUpdateCharismaViewOptions(CharismaViewOptions charismaViewOptions, int n) {
        boolean bl = this.myTarget.isGTEDetected = charismaViewOptions.getConfiguration().getScreensAvailable().isHybrid() && !charismaViewOptions.getConfiguration().getScreensAvailable().isDcc() && !charismaViewOptions.getConfiguration().getScreensAvailable().isProfile() && !charismaViewOptions.getConfiguration().getScreensAvailable().isProfiledcc();
        if (this.myTarget.isGTEDetected) {
            this.fsgIssue = charismaViewOptions.getActiveOperationMode().getState() == 2 && charismaViewOptions.getActiveOperationMode().getReason() == 0;
        } else {
            boolean bl2 = this.fsgIssue = charismaViewOptions.getActiveProfile().getState() == 2 && charismaViewOptions.getActiveProfile().getReason() == 0 && charismaViewOptions.getCharismaList().getState() == 2;
        }
        if (this.isPopupRequested && !this.fsgIssue) {
            this.myTarget.cancelPopup(this.myTarget.displayContent, 1);
            this.isPopupRequested = false;
        }
        this.myTarget.isOffraodFpa = charismaViewOptions.getConfiguration().getScreensAvailable().isOffroad();
        if (this.fsgIssue) {
            if (!this.myTarget.isGTEDetected) {
                this.setProfileAvailableState(charismaViewOptions, this.availableState, this.AVAILABLE_PROFILES);
                ListManager.getGenericASLList(10333).updateList(this.availableState);
                this.myTarget.informHMIAvailableProfiles(this.AVAILABLE_PROFILES);
            } else {
                this.myTarget.info("FPA: GTE was detected with BMA!");
                this.setHmiReady(true);
            }
            if (!this.hmiIsReady) {
                this.hmiIsReady = true;
                this.myTarget.dsiCarFpa.setHMIIsReady(true);
            }
        } else if (charismaViewOptions.getActiveProfile().getReason() != 14) {
            this.getSetupSettingsProfile().clear();
            this.myTarget.cachingRequests.clear();
            this.myTarget.clearActiveProfile();
            this.setHmiReady(false);
        }
        this.dccArraySliderController.resetArraySlider();
        this.updateAvailableProfiles(this.AVAILABLE_PROFILES);
    }

    public void dsiPowerManagementUpdateClampSignal(ClampSignal clampSignal, int n) {
        this.isClamp15 = clampSignal.isClamp15();
        if (this.isOffroadRequested && !this.isClamp15 && ServiceManager.configManagerDiag.isFeatureFlagSet(360)) {
            this.myTarget.sendHMIEvent(10013);
        }
    }

    public void dsiCarVehicleStatesUpdateDynamicVehicleInfoMidFrequent(DynamicVehicleInfoMidFrequent dynamicVehicleInfoMidFrequent, int n) {
        this.isValetParkingActive = dynamicVehicleInfoMidFrequent.valetParkingState;
    }

    public void dsiCarDrivingCharacteristicsRequestCharismaPopup(int n) {
        if (this.myTarget.isTraceEnabled()) {
            this.myTarget.trace().append("FPA: requesting PopUp: ").append(n).log();
        }
        if (this.isValetParkingActive) {
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(1832001536);
            this.myTarget.showCharismaPopup(0, 1);
            return;
        }
        boolean bl = this.isPopupRequested = n == 1 || n == 2 || n == 3 || n == 6 || n == 5;
        if (this.isClamp15 && ASLCarContainer.getInstance().isMenuCoded(33)) {
            if (n == 0) {
                this.myTarget.cancelPopup(this.myTarget.displayContent, 0);
            } else if (!this.isHmiReady()) {
                this.myTarget.error("FPA: HMI will cancel popup, because is not ready!");
                this.myTarget.showCharismaPopup(0, 1);
            } else {
                if (ServiceManager.configManagerDiag.isFeatureFlagSet(360) && this.isOffroadRequested) {
                    this.myTarget.sendHMIEvent(10013);
                    this.isOffroadRequested = false;
                }
                block0 : switch (n) {
                    case 1: {
                        switch (this.myTarget.configDcc) {
                            case 2: {
                                ServiceManager.aslPropertyManager.valueChangedInteger(10276, 2);
                                this.myTarget.displayContent = n;
                                this.myTarget.sendHMIEvent(10012);
                                break block0;
                            }
                            case 0: {
                                ServiceManager.aslPropertyManager.valueChangedInteger(10276, 0);
                                this.myTarget.displayContent = n;
                                this.myTarget.sendHMIEvent(10012);
                                break block0;
                            }
                        }
                        this.checkingConfigState(n, 1);
                        break;
                    }
                    case 2: {
                        this.checkingConfigState(n, 0);
                        break;
                    }
                    case 3: {
                        this.checkingConfigState(n, 2);
                        break;
                    }
                    case 6: {
                        ServiceManager.aslPropertyManager.valueChangedInteger(10276, 3);
                        this.myTarget.displayContent = n;
                        if (!ServiceManager.configManagerDiag.isFeatureFlagSet(360)) {
                            this.myTarget.sendHMIEvent(10012);
                        }
                        this.myTarget.sendHMIEvent(10028);
                        break;
                    }
                    case 5: {
                        if (this.targetIsReady) {
                            ServiceManager.aslPropertyManager.valueChangedInteger(10276, 4);
                            this.myTarget.displayContent = n;
                            this.myTarget.sendHMIEvent(10012);
                            break;
                        }
                        this.myTarget.error("FPA: HMI will cancel popup, because HybridTarget is not ready!");
                        this.myTarget.showCharismaPopup(0, 1);
                        break;
                    }
                    default: {
                        this.myTarget.error("FPA: Device is sending the wrong CHARISMACONTENT to HMI!");
                        this.myTarget.showCharismaPopup(0, 1);
                        break;
                    }
                }
            }
        } else {
            this.myTarget.error("CAR FPA: Cancel Popup, because clamp 15 is off or FPA is not coded!");
            this.myTarget.showCharismaPopup(0, 1);
        }
    }

    private void checkingConfigState(int n, int n2) {
        if (this.myTarget.isOffraodFpa) {
            ServiceManager.aslPropertyManager.valueChangedInteger(10276, 3);
        } else {
            ServiceManager.aslPropertyManager.valueChangedInteger(10276, n2);
        }
        this.myTarget.displayContent = n;
        this.myTarget.sendHMIEvent(10012);
    }

    public void dsiCarDrivingCharacteristicsUpdateCharismaContent(int n, int n2) {
        if (this.isPopupRequested && this.myTarget.displayContent != n) {
            block0 : switch (n) {
                case 1: {
                    this.myTarget.displayContent = n;
                    switch (this.myTarget.configDcc) {
                        case 2: {
                            ServiceManager.aslPropertyManager.valueChangedInteger(10276, 2);
                            break block0;
                        }
                        case 0: {
                            ServiceManager.aslPropertyManager.valueChangedInteger(10276, 0);
                            break block0;
                        }
                    }
                    if (this.myTarget.isOffraodFpa) {
                        ServiceManager.aslPropertyManager.valueChangedInteger(10276, 3);
                        break;
                    }
                    ServiceManager.aslPropertyManager.valueChangedInteger(10276, 1);
                    break;
                }
                case 2: {
                    this.myTarget.displayContent = n;
                    if (this.myTarget.isOffraodFpa) {
                        ServiceManager.aslPropertyManager.valueChangedInteger(10276, 3);
                        break;
                    }
                    ServiceManager.aslPropertyManager.valueChangedInteger(10276, 0);
                    break;
                }
                case 3: {
                    this.myTarget.displayContent = n;
                    if (this.myTarget.isOffraodFpa) {
                        ServiceManager.aslPropertyManager.valueChangedInteger(10276, 3);
                        break;
                    }
                    ServiceManager.aslPropertyManager.valueChangedInteger(10276, 2);
                    break;
                }
                case 6: {
                    this.myTarget.displayContent = n;
                    ServiceManager.aslPropertyManager.valueChangedInteger(10276, 3);
                    this.myTarget.sendHMIEvent(10028);
                    break;
                }
                case 5: {
                    this.myTarget.displayContent = n;
                    ServiceManager.aslPropertyManager.valueChangedInteger(10276, 4);
                    break;
                }
                default: {
                    this.myTarget.error("FPA: Device is sending the wrong CHARISMACONTENT to HMI!");
                }
            }
        }
    }

    public void dsiCarDrivingCharacteristicsAcknowledgeCharismaPopup(int n) {
        if (this.myTarget.cancelByHmi) {
            this.myTarget.error("CAR FPA: ignore acknowledge charisma popup sending wrong information");
            this.isPopupRequested = false;
            this.myTarget.cancelByHmi = false;
            if (ServiceManager.configManagerDiag.isFeatureFlagSet(360)) {
                this.myTarget.displayContent = n;
            }
        } else {
            this.isPopupRequested = n == 1 || n == 2 || n == 3 || n == 6 || n == 5;
            switch (n) {
                case 0: {
                    this.myTarget.sendHMIEvent(10013);
                    this.myTarget.displayContent = n;
                    break;
                }
                case 1: 
                case 2: 
                case 3: 
                case 5: 
                case 6: {
                    this.myTarget.displayContent = n;
                    break;
                }
            }
            if (ServiceManager.configManagerDiag.isFeatureFlagSet(360) && this.isOffroadRequested) {
                this.myTarget.sendHMIEvent(10028);
            }
        }
    }

    protected boolean requestProfileInformationNeeded(int n) {
        return this.myTarget.isToRequest(n);
    }

    protected void setHmiReady(boolean bl) {
        this.myTarget.isHmiIsReady = bl;
    }

    private boolean isHmiReady() {
        return this.myTarget.isHmiIsReady;
    }

    private static void initProfileAvailableState(CarFunctionCollector[] carFunctionCollectorArray, boolean[] blArray) {
        carFunctionCollectorArray[0] = new CarFunctionCollector(false, 0);
        carFunctionCollectorArray[1] = new CarFunctionCollector(false, 0);
        carFunctionCollectorArray[2] = new CarFunctionCollector(false, 0);
        carFunctionCollectorArray[3] = new CarFunctionCollector(false, 0);
        carFunctionCollectorArray[4] = new CarFunctionCollector(false, 0);
        carFunctionCollectorArray[5] = new CarFunctionCollector(false, 0);
        carFunctionCollectorArray[6] = new CarFunctionCollector(false, 0);
        carFunctionCollectorArray[7] = new CarFunctionCollector(false, 0);
        carFunctionCollectorArray[8] = new CarFunctionCollector(false, 0);
        carFunctionCollectorArray[9] = new CarFunctionCollector(false, 0);
        carFunctionCollectorArray[10] = new CarFunctionCollector(false, 0);
        carFunctionCollectorArray[11] = new CarFunctionCollector(false, 0);
        Arrays.fill(blArray, false);
    }

    protected void setProfileAvailableState(CharismaViewOptions charismaViewOptions, CarFunctionCollector[] carFunctionCollectorArray, boolean[] blArray) {
        carFunctionCollectorArray[0] = new CarFunctionCollector(false, 0);
        carFunctionCollectorArray[1] = new CarFunctionCollector(charismaViewOptions.getProfileComfort().getState() == 2, this.getReason(charismaViewOptions.getProfileComfort().getReason()));
        carFunctionCollectorArray[2] = new CarFunctionCollector(charismaViewOptions.getProfileAutoNormal().getState() == 2, this.getReason(charismaViewOptions.getProfileAutoNormal().getReason()));
        carFunctionCollectorArray[3] = new CarFunctionCollector(charismaViewOptions.getProfileDynamic().getState() == 2, this.getReason(charismaViewOptions.getProfileDynamic().getReason()));
        if (this.myTarget.isOffraodFpa) {
            carFunctionCollectorArray[4] = new CarFunctionCollector(false, this.getReason(charismaViewOptions.getProfileOffroadAllroad().getReason()));
            carFunctionCollectorArray[10] = new CarFunctionCollector(charismaViewOptions.getProfileOffroadAllroad().getState() == 2, this.getReason(charismaViewOptions.getProfileOffroadAllroad().getReason()));
        } else {
            carFunctionCollectorArray[4] = new CarFunctionCollector(charismaViewOptions.getProfileOffroadAllroad().getState() == 2, this.getReason(charismaViewOptions.getProfileOffroadAllroad().getReason()));
            carFunctionCollectorArray[10] = new CarFunctionCollector(false, this.getReason(charismaViewOptions.getProfileOffroadAllroad().getReason()));
        }
        carFunctionCollectorArray[5] = new CarFunctionCollector(charismaViewOptions.getProfileEfficiency().getState() == 2, this.getReason(charismaViewOptions.getProfileEfficiency().getReason()));
        carFunctionCollectorArray[6] = new CarFunctionCollector(charismaViewOptions.getProfileRaceSport().getState() == 2, this.getReason(charismaViewOptions.getProfileRaceSport().getReason()));
        carFunctionCollectorArray[7] = new CarFunctionCollector(charismaViewOptions.getProfileIndividual().getState() == 2, this.getReason(charismaViewOptions.getProfileIndividual().getReason()));
        carFunctionCollectorArray[8] = new CarFunctionCollector(charismaViewOptions.getProfileRange().getState() == 2, this.getReason(charismaViewOptions.getProfileRange().getReason()));
        carFunctionCollectorArray[9] = new CarFunctionCollector(charismaViewOptions.getProfileOffroadLevel2().getState() == 2, this.getReason(charismaViewOptions.getProfileOffroadLevel2().getReason()));
        carFunctionCollectorArray[11] = new CarFunctionCollector(charismaViewOptions.getProfileOffroadLevel3().getState() == 2, this.getReason(charismaViewOptions.getProfileOffroadLevel3().getReason()));
        blArray[0] = false;
        blArray[1] = charismaViewOptions.getConfiguration().getProfilesAvailable().isComfort();
        blArray[2] = charismaViewOptions.getConfiguration().getProfilesAvailable().isAutonormal();
        blArray[3] = charismaViewOptions.getConfiguration().getProfilesAvailable().isDynamic();
        if (this.myTarget.isOffraodFpa) {
            blArray[4] = false;
            blArray[9] = ServiceManager.configManagerDiag.isFeatureFlagSet(360) ? charismaViewOptions.getConfiguration().getProfilesAvailable().isOffroadlevel2() : false;
            blArray[10] = charismaViewOptions.getConfiguration().getProfilesAvailable().isOffroadallroad();
        } else {
            blArray[4] = charismaViewOptions.getConfiguration().getProfilesAvailable().isOffroadallroad();
            blArray[9] = charismaViewOptions.getConfiguration().getProfilesAvailable().isOffroadlevel2();
            blArray[10] = false;
        }
        blArray[5] = charismaViewOptions.getConfiguration().getProfilesAvailable().isEfficiency();
        blArray[6] = charismaViewOptions.getConfiguration().getProfilesAvailable().isRacesport();
        blArray[7] = charismaViewOptions.getConfiguration().getProfilesAvailable().isIndividual();
        blArray[8] = charismaViewOptions.getConfiguration().getProfilesAvailable().isRange();
        blArray[11] = charismaViewOptions.getConfiguration().getProfilesAvailable().isOffroadlevel3();
    }

    protected void mergeProfileSetupTable(int n, CharismaSetupTableWithoutOptionMask[] charismaSetupTableWithoutOptionMaskArray, CollectorFPASettings collectorFPASettings) {
        collectorFPASettings.setupTable = charismaSetupTableWithoutOptionMaskArray;
    }

    protected CharismaSetupTableWithoutOptionMask[] computeSetupTableRequestForChangedFunction(int n, CharismaSetupTableWithoutOptionMask[] charismaSetupTableWithoutOptionMaskArray) {
        return charismaSetupTableWithoutOptionMaskArray;
    }

    protected void setCharismaSetFactoryDefault(DSICarDrivingCharacteristics dSICarDrivingCharacteristics, ArrayList arrayList) {
        dSICarDrivingCharacteristics.setCharismaSetFactoryDefault();
    }

    private ArrayList getSetupSettingsProfile() {
        return this.myTarget.setupSettingsProfile;
    }

    public void dsiCarDrivingCharacteristicsUpdateCharismaActiveProfile(int n, int n2) {
        if (!this.isHmiReady()) {
            this.setHmiReady(true);
        }
        this.currentActiveProfile = n;
        if (this.requestProfileInformationNeeded(n)) {
            this.charismaInformation.arrayContent = 1;
            this.charismaInformation.recordContent = 1;
            this.charismaInformation.profileID = n;
            if (this.myTarget.cachingRequests.size() == 0) {
                this.myTarget.requestCharismaList(this.charismaInformation);
            }
            this.myTarget.cachingRequests.add(new CharismaListUpdateInfo(n, 1, 1, this.charismaInformation.getStartElement(), this.charismaInformation.getNumOfElements()));
        } else {
            this.myTarget.activeProfile(this.currentActiveProfile);
        }
        this.updateActiveProfile(this.currentActiveProfile);
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(360) && this.isClamp15 && this.myTarget.isOffraodFpa) {
            if (n == 4) {
                if (this.isPopupRequested) {
                    this.myTarget.sendHMIEvent(10013);
                    this.myTarget.dsiCarFpa.cancelCharismaPopup(this.myTarget.displayContent, 1);
                    this.isOffroadRequested = true;
                } else {
                    this.isOffroadRequested = true;
                    this.myTarget.sendHMIEvent(10028);
                }
            } else if (n != 4 && !this.isPopupRequested) {
                this.myTarget.sendHMIEvent(10013);
            }
        }
    }

    public void dsiCarDrivingCharacteristicsUpdateCharismaListUpdateInfo(CharismaListUpdateInfo charismaListUpdateInfo, int n) {
        switch (charismaListUpdateInfo.getProfileID()) {
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 10: {
                this.myTarget.info().append("FPA: ignore change array").log();
                break;
            }
            case 7: {
                if (this.requestProfileInformationNeeded(7)) break;
                charismaListUpdateInfo.recordContent = 2;
                if (this.myTarget.cachingRequests.size() == 0) {
                    this.myTarget.requestCharismaList(charismaListUpdateInfo);
                }
                this.myTarget.cachingRequests.add(charismaListUpdateInfo);
                break;
            }
            case 11: {
                if (this.requestProfileInformationNeeded(11)) break;
                charismaListUpdateInfo.recordContent = 2;
                if (this.myTarget.cachingRequests.size() == 0) {
                    this.myTarget.requestCharismaList(charismaListUpdateInfo);
                }
                this.myTarget.cachingRequests.add(charismaListUpdateInfo);
                break;
            }
            case 255: {
                if (this.myTarget.isGTEDetected) break;
                this.charismaInformation = charismaListUpdateInfo;
                if (this.AVAILABLE_PROFILES[7]) {
                    this.requestIndividualOptionMask();
                    break;
                }
                this.myTarget.registerActiveProfile();
                break;
            }
        }
    }

    private void requestIndividualOptionMask() {
        if (this.requestProfileInformationNeeded(7)) {
            this.charismaInformation.arrayContent = 1;
            this.charismaInformation.recordContent = 1;
            this.charismaInformation.profileID = 7;
            if (this.myTarget.cachingRequests.size() == 0) {
                this.myTarget.requestCharismaList(this.charismaInformation);
            }
            this.myTarget.cachingRequests.add(this.charismaInformation);
        }
    }

    public void dsiCarDrivingCharacteristicsResponseCharismaListWithOptionMask(int n, int n2, int n3, CharismaSetupTableWithOptionMask[] charismaSetupTableWithOptionMaskArray) {
        int n4;
        ArrayList arrayList = this.getSetupSettingsProfile();
        if (arrayList.size() == 0) {
            this.myTarget.rememberSettings(-1, n, charismaSetupTableWithOptionMaskArray);
        } else {
            for (n4 = 0; n4 < arrayList.size(); ++n4) {
                if (((CollectorFPASettings)arrayList.get((int)n4)).profileID == n) {
                    arrayList.remove(n4);
                    this.myTarget.rememberSettings(n4, n, charismaSetupTableWithOptionMaskArray);
                    break;
                }
                if (n4 != arrayList.size() - 1) continue;
                this.myTarget.rememberSettings(-1, n, charismaSetupTableWithOptionMaskArray);
            }
        }
        for (n4 = 0; n4 < this.myTarget.cachingRequests.size(); ++n4) {
            if (((CharismaListUpdateInfo)this.myTarget.cachingRequests.get((int)n4)).profileID != n) continue;
            this.myTarget.cachingRequests.remove(n4);
            if (this.myTarget.cachingRequests.size() == 0) break;
            this.myTarget.requestCharismaList((CharismaListUpdateInfo)this.myTarget.cachingRequests.get(0));
            break;
        }
        if (n == 7) {
            this.myTarget.registerActiveProfile();
            for (n4 = 0; n4 < charismaSetupTableWithOptionMaskArray.length; ++n4) {
                if (charismaSetupTableWithOptionMaskArray[n4].functionID != 7) continue;
                if (charismaSetupTableWithOptionMaskArray[n4].mask < -16842752) {
                    AbstractASLHsmTarget.writeIntegerToDatapool(10602, 0);
                    this.myTarget.isContinuousDamperAvailable = false;
                    continue;
                }
                if (charismaSetupTableWithOptionMaskArray[n4].mask != -16842752) continue;
                AbstractASLHsmTarget.writeIntegerToDatapool(10602, 1);
                this.myTarget.isContinuousDamperAvailable = true;
            }
        }
        if (n == this.currentActiveProfile) {
            this.myTarget.informHmiAboutCurrentSettings(n);
        }
        if (this.myTarget.isWithoutOptionsMask() && this.currentActiveProfile != 0) {
            this.myTarget.activeProfile(this.currentActiveProfile);
            this.setHmiReady(true);
        }
    }

    public void dsiCarDrivingCharacteristicsResponseCharismaListWithoutOptionMask(int n, int n2, int n3, CharismaSetupTableWithoutOptionMask[] charismaSetupTableWithoutOptionMaskArray) {
        int n4;
        ArrayList arrayList = this.getSetupSettingsProfile();
        for (n4 = 0; n4 < arrayList.size(); ++n4) {
            CollectorFPASettings collectorFPASettings = (CollectorFPASettings)arrayList.get(n4);
            if (collectorFPASettings.profileID != n) continue;
            this.mergeProfileSetupTable(n, charismaSetupTableWithoutOptionMaskArray, collectorFPASettings);
            break;
        }
        if (n == this.currentActiveProfile) {
            this.myTarget.informHmiAboutCurrentSettings(n);
        }
        for (n4 = 0; n4 < this.myTarget.cachingRequests.size(); ++n4) {
            if (((CharismaListUpdateInfo)this.myTarget.cachingRequests.get((int)n4)).profileID != n) continue;
            this.myTarget.cachingRequests.remove(n4);
            if (this.myTarget.cachingRequests.size() == 0) break;
            this.myTarget.requestCharismaList((CharismaListUpdateInfo)this.myTarget.cachingRequests.get(0));
            break;
        }
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

    private void intiModel() {
        this.myTarget.resetFPAFunctionList();
        StateWork.initProfileAvailableState(this.availableState, this.AVAILABLE_PROFILES);
        ListManager.getGenericASLList(10333).updateList(this.availableState);
    }

    @Override
    public void requestCharismaListUpdate(CharismaListUpdateInfo charismaListUpdateInfo) {
    }

    @Override
    public void changeActiveProfile(int n) {
        this.activateSelectedProfile(n);
    }

    @Override
    public void changeCharismaSetupTableWithoutOptionMask(int n, CharismaSetupTableWithoutOptionMask[] charismaSetupTableWithoutOptionMaskArray) {
    }

    @Override
    public void changeCharismaSetupTableWithOptionMask(int n, CharismaSetupTableWithOptionMask[] charismaSetupTableWithOptionMaskArray) {
    }

    @Override
    public void updateActiveProfile(int n) {
        this.fpaMainController.updateActiveProfile(n);
    }

    @Override
    public boolean[] getAvailableProfiles() {
        return this.AVAILABLE_PROFILES;
    }

    @Override
    public void updateAvailableProfiles(boolean[] blArray) {
        this.fpaMainController.updateAvailableProfiles(blArray);
    }
}


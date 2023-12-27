/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.parkassistence.opsvps.states;

import de.vw.mib.asl.framework.api.diagnosis.AdaptionResponse;
import de.vw.mib.asl.framework.api.diagnosis.config.Access;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.car.model.ModelDeviceStartupManager;
import de.vw.mib.asl.internal.car.parkassistence.opsvps.OpsVpsHsmTarget;
import de.vw.mib.asl.internal.car.parkassistence.opsvps.states.StateBase;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.car.parkassistence.areaview.transformer.CarParkAssistenceAreaViewBVSupportedModesCollector;
import generated.de.vw.mib.asl.internal.car.parkassistence.areaview.transformer.CarParkAssistenceAreaViewFrontSupportedModesCollector;
import generated.de.vw.mib.asl.internal.car.parkassistence.areaview.transformer.CarParkAssistenceAreaViewRearSupportedModesCollector;
import generated.de.vw.mib.asl.internal.car.parkassistence.areaview.transformer.CarParkAssistenceAreaViewSideSupportedModesCollector;
import generated.de.vw.mib.asl.internal.car.parkassistence.areaview.transformer.CarParkAssistenceAreaViewVPS3DBirdViewPositionCollector;
import generated.de.vw.mib.asl.internal.car.parkassistence.ops.transformer.CarParkAssistenceOPSSteeringInfoWheelRadiusCollector;
import org.dsi.ifc.cardriverassistance.SWARCTASensorData;
import org.dsi.ifc.cardriverassistance.SWAViewOptions;
import org.dsi.ifc.carparkingsystem.DisplayContent;
import org.dsi.ifc.carparkingsystem.PDCConfiguration;
import org.dsi.ifc.carparkingsystem.PDCDistanceValuesFrontRear;
import org.dsi.ifc.carparkingsystem.PDCDistanceValuesRightLeft;
import org.dsi.ifc.carparkingsystem.PDCInfo;
import org.dsi.ifc.carparkingsystem.PDCStatusLevelFrontRear;
import org.dsi.ifc.carparkingsystem.PDCStatusLevelRightLeft;
import org.dsi.ifc.carparkingsystem.PDCSteeringInformation;
import org.dsi.ifc.carparkingsystem.ParkingSystemViewOptions;
import org.dsi.ifc.carparkingsystem.VPSConfiguration;
import org.dsi.ifc.carparkingsystem.VPSSupportedBVModes;
import org.dsi.ifc.carparkingsystem.VPSSupportedFVModes;
import org.dsi.ifc.carparkingsystem.VPSSupportedRVModes;
import org.dsi.ifc.carparkingsystem.VPSSupportedSVModes;
import org.dsi.ifc.carparkingsystem.VPSSupportedViews;
import org.dsi.ifc.carparkingsystem.VPSVideoInfo;
import org.dsi.ifc.powermanagement.ClampSignal;

public class StatePopupOff
extends StateBase
implements AdaptionResponse {
    public static final int ASL_CAR_PARKING_IS_RVCLOW_CODED_TEST_ONLY;
    public static final int OPS_CONFIG_OPS_NOT_INTALLED;
    public static final int OPS_CONFIG_OPS_360;
    public static final int OPS_CONFIG_OPS_FR;
    public static final int OPS_CONFIG_OPS_R;
    private static final int OPS_SENSOR_LEN;
    private static final int SENSOR_FRONT_LEFT_MIDDLE;
    private static final int SENSOR_FRONT_LEFT;
    private static final int SENSOR_FRONT_RIGHT_MIDDLE;
    private static final int SENSOR_FRONT_RIGHT;
    private static final int SENSOR_LEFT_FRONT;
    private static final int SENSOR_LEFT_FRONT_MIDDLE;
    private static final int SENSOR_LEFT_REAR_MIDDLE;
    private static final int SENSOR_LEFT_REAR;
    private static final int SENSOR_REAR_LEFT;
    private static final int SENSOR_REAR_LEFT_MIDDLE;
    private static final int SENSOR_REAR_RIGHT_MIDDLE;
    private static final int SENSOR_REAR_RIGHT;
    private static final int SENSOR_RIGHT_REAR;
    private static final int SENSOR_RIGHT_REAR_MIDDLE;
    private static final int SENSOR_RIGHT_FRONT_MIDDLE;
    private static final int SENSOR_RIGHT_FRONT;
    private static int[] OPS_SENSOR_STATUS;
    private static final int DISTANCE_VALUES_FRONT_LEFT_MIDDLE;
    private static final int DISTANCE_VALUES_FRONT_LEFT;
    private static final int DISTANCE_VALUES_FRONT_RIGHT_MIDDLE;
    private static final int DISTANCE_VALUES_FRONT_RIGHT;
    private static final int DISTANCE_VALUES_LEFT_FRONT;
    private static final int DISTANCE_VALUES_LEFT_FRONT_MIDDLE;
    private static final int DISTANCE_VALUES_LEFT_REAR_MIDDLE;
    private static final int DISTANCE_VALUES_LEFT_REAR;
    private static final int DISTANCE_VALUES_REAR_LEFT;
    private static final int DISTANCE_VALUES_REAR_LEFT_MIDDLE;
    private static final int DISTANCE_VALUES_REAR_RIGHT_MIDDLE;
    private static final int DISTANCE_VALUES_REAR_RIGHT;
    private static final int DISTANCE_VALUES_RIGHT_REAR;
    private static final int DISTANCE_VALUES_RIGHT_REAR_MIDDLE;
    private static final int DISTANCE_VALUES_RIGHT_FRONT_MIDDLE;
    private static final int DISTANCE_VALUES_RIGHT_FRONT;
    private static int[] OPS_SENSOR_VALUES;
    private boolean dsiCommonNotificationsDone;
    public static int opsConfig;
    public static boolean isRvc;
    private static final int PDC_VOLUME_FRONT_SETTINGS;
    private static final int PDC_FREQUENCY_FRONT_SETTINGS;
    private static final int PDC_VOLUME_REAR_SETTINGS;
    private static final int PDC_FREQUENCY_REAR_SETTINGS;
    private int volumeFront = 5;
    private int volumeRear = 5;
    private int freqFront = 5;
    private int freqRear = 5;
    private Object[] pdcAcousticSettingsList = new Object[]{new int[]{5}, new int[]{5}, new int[]{5}, new int[]{5}};
    private boolean pdcMute;
    private boolean autoActivation;
    private int audioConnection = 12;
    private boolean brakeElectricalParking;
    private boolean apsActive;
    private boolean audioMgrAvailable;
    private boolean audioAttenuationDone;
    private EventGeneric audioAttenuationEvent;
    private CarParkAssistenceAreaViewFrontSupportedModesCollector fvSupportedModesCollector;
    private CarParkAssistenceAreaViewFrontSupportedModesCollector[] fvSupportedModesCollectorArray;
    private CarParkAssistenceAreaViewRearSupportedModesCollector rvSupportedModesCollector;
    private CarParkAssistenceAreaViewRearSupportedModesCollector[] rvSupportedModesCollectorArray;
    private CarParkAssistenceAreaViewSideSupportedModesCollector svSupportedModesCollector;
    private CarParkAssistenceAreaViewSideSupportedModesCollector[] svSupportedModesCollectorArray;
    private CarParkAssistenceAreaViewBVSupportedModesCollector bvSupportedModesCollector;
    private CarParkAssistenceAreaViewBVSupportedModesCollector[] bvSupportedModesCollectorArray;
    private CarParkAssistenceAreaViewVPS3DBirdViewPositionCollector bv3DCollector;
    private CarParkAssistenceAreaViewVPS3DBirdViewPositionCollector[] bv3DArray;
    private boolean pdcOffroadState;
    private int apsLoweringLevel;
    private int lastAudioConnectionRequested;
    private boolean pdcSystemOnOff;
    private boolean pleSystemActive;
    private CarParkAssistenceOPSSteeringInfoWheelRadiusCollector wheelRadiusCollector;
    private boolean setHmiReadyDone;
    private boolean maneuverAssist;
    private boolean maneuverSystemOnOff;
    private int[] rtaStatus = new int[2];
    private boolean vpsSystemState;
    private boolean swaExistAssist = true;
    private boolean isTrunkOpenVPS;
    private boolean isTrunkOpenPDC;

    public StatePopupOff(OpsVpsHsmTarget opsVpsHsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(opsVpsHsmTarget, hsm, string, hsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 2: {
                if (this.target.isTraceEnabled()) {
                    this.target.trace().append("OpsVps: HSM_ENTRY in state ").append(this.getName()).log();
                }
                this.initApp();
                break;
            }
            case 3: {
                if (this.target.isTraceEnabled()) {
                    this.target.trace().append("OpsVps: HSM_START in state ").append(this.getName()).log();
                }
                ServiceManager.aslPropertyManager.valueChangedBoolean(10178, false);
                break;
            }
            case 4: {
                if (!this.target.isTraceEnabled()) break;
                this.target.trace().append("OpsVps: HSM_EXIT in state ").append(this.getName()).log();
                break;
            }
            case 1300009: {
                if (this.setHmiReadyDone) break;
                this.setHmiReadyDone = true;
                this.target.info().append("OpsVps: FIRST_CONTEXT_SWITCH_WAS_REQUESTED. Call setHMIStateIsReady true").log();
                this.target.setHMIState(true);
                ModelDeviceStartupManager.start();
                break;
            }
            case 1300010: {
                ServiceManager.aslPropertyManager.valueChangedBoolean(10611, false);
                this.target.setEarlyRVC(false);
                this.target.info().append("OpsVps: FIRST_CONTEXT_SWITCH_WAS_EXECUTED. EarlyRVCActive false").log();
                break;
            }
            case 4300046: {
                if (!this.target.isTraceEnabled()) break;
                this.target.trace().append("OpsVps: SET_HMI_READY in state ").append(this.getName()).log();
                break;
            }
            case 1073744914: {
                this.target.info().append("OpsVps: CLOSE_PARKING_POPUP_ACKNOWLEDGED in state ").append(this.getName()).log();
                this.target.closeParkingPopupByDevice();
                break;
            }
            case 0x40000C04: {
                if (this.target.isTraceEnabled()) {
                    this.target.trace().append("OpsVps: TOGGLE_PDC_MUTE").log();
                }
                this.target.setPDCMute(!this.pdcMute);
                break;
            }
            case 1073744899: {
                if (this.target.isTraceEnabled()) {
                    this.target.trace().append("OpsVps: DE_INSCREASE_PDC_SETTINGS").log();
                }
                int n2 = eventGeneric.getInt(0);
                boolean bl = eventGeneric.getBoolean(1);
                this.incDecPDCSoundSettings(n2, bl);
                break;
            }
            case 0x40000C00: {
                if (this.target.isTraceEnabled()) {
                    this.target.trace().append("OpsVps: TOGGLE_PDC_ACTIVATION").log();
                }
                this.target.setPDCAutoActivation(!this.autoActivation);
                break;
            }
            case 1073744898: {
                if (this.target.isTraceEnabled()) {
                    this.target.trace().append("OpsVps: SET_PDC_SETTINGS").log();
                }
                int n3 = eventGeneric.getInt(1);
                int n4 = eventGeneric.getInt(0);
                this.setPDCSoundSettings(n3, n4);
                break;
            }
            case 1073744902: {
                if (this.target.isTraceEnabled()) {
                    this.target.trace().append("OpsVps: TOGGLE_AUTO_EPB").log();
                }
                this.target.setBrakeElectricalParking(!this.brakeElectricalParking);
                break;
            }
            case 4000021: {
                int n5 = eventGeneric.getInt(0);
                if (this.target.isTraceEnabled()) {
                    this.target.trace().append("OpsVps: ASL_SOUND_AUDIOMNGMNT_STATUS: ").append(n5).append(" in state ").append(this.getName()).log();
                }
                this.evalSoundStatus(n5);
                break;
            }
            case 1073744897: {
                if (this.target.isTraceEnabled()) {
                    this.target.trace().append("OpsVps: SET_PDC_ENTERTAINMENT_LOWERING in state ").append(this.getName()).log();
                }
                this.apsLoweringLevel = eventGeneric.getInt(0);
                this.target.setLoweringEntertainment(this.audioConnection, 1, 1, this.apsLoweringLevel);
                break;
            }
            case 1073744905: {
                if (this.target.isTraceEnabled()) {
                    this.target.trace().append("OpsVps: DE_INSCREASE_PDC_ENTERTAINMENT_LOWERING in state ").append(this.getName()).log();
                }
                boolean bl = eventGeneric.getBoolean(0);
                this.incDecPDCEntLowering(bl);
                break;
            }
            case 1073744907: {
                if (this.target.isTraceEnabled()) {
                    this.target.trace().append("OpsVps: TOGGLE_PDC_SYSTEM_ACTIVE in state ").append(this.getName()).log();
                }
                this.target.setPDCOnOff(!this.pdcSystemOnOff);
                break;
            }
            case 1073744906: {
                if (this.target.isTraceEnabled()) {
                    this.target.trace().append("OpsVps: SET_FIFTH_CAMERA_MODE in state ").append(this.getName()).log();
                }
                int n6 = eventGeneric.getInt(0);
                this.setFifthCameraMode(n6);
                break;
            }
            case 1073744904: {
                if (this.target.isTraceEnabled()) {
                    this.target.trace().append("OpsVps: TOGGLE_PLE_SYSTEM_ACTIVE in state ").append(this.getName()).log();
                }
                this.target.setPLESystemActive(!this.pleSystemActive);
                break;
            }
            case 1073745117: {
                if (this.target.isTraceEnabled()) {
                    this.target.trace().append("OpsVps: EXTCAM_MANUAL_ACTIVATION in state ").append(this.getName()).log();
                }
                int n7 = eventGeneric.getInt(0);
                this.extCamManualActivation(n7);
                break;
            }
            case 1073745122: {
                if (this.target.isTraceEnabled()) {
                    this.target.trace().append("OpsVps: SET_OFFROAD_KOG in state ").append(this.getName()).log();
                }
                boolean bl = eventGeneric.getBoolean(0);
                this.target.setPdcOffroad(bl);
                break;
            }
            case 1073745142: {
                this.target.setManoeuverSystemActive(!this.maneuverSystemOnOff);
                break;
            }
            case 1073745143: {
                this.target.setManoeuverAssist(!this.maneuverAssist);
                break;
            }
            case 1073744866: {
                int n8 = eventGeneric.getInt(0);
                if (n8 != 0 && n8 != 2) break;
                this.target.requestFactoryReset();
                break;
            }
            case 1073745207: {
                this.target.setVPSSystemState(!this.vpsSystemState);
                break;
            }
            case 1073745206: {
                this.target.setExistAssist(!this.swaExistAssist);
                break;
            }
            case 12345678: {
                this.target.setRvcLowCoded(eventGeneric.getBoolean(0));
                break;
            }
            default: {
                if (this.target.isTraceEnabled()) {
                    this.target.trace().append("OpsVps: eventId: ").append(n).append(" not handledin state ").append(this.getName()).log();
                }
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    private void incDecPDCEntLowering(boolean bl) {
        if (bl) {
            ++this.apsLoweringLevel;
        } else if (!bl) {
            --this.apsLoweringLevel;
        }
        this.target.setLoweringEntertainment(this.audioConnection, 1, 1, this.apsLoweringLevel);
    }

    private void evalSoundStatus(int n) {
        if (n == 1 || n == 2) {
            this.audioMgrAvailable = true;
            if (this.apsActive) {
                this.doAudioAttenuation(true);
            }
        } else if (n == 0) {
            this.audioMgrAvailable = false;
        }
    }

    private void initApp() {
        ServiceManager.aslPropertyManager.valueChangedBoolean(10559, true);
        this.fvSupportedModesCollector = new CarParkAssistenceAreaViewFrontSupportedModesCollector();
        this.fvSupportedModesCollectorArray = new CarParkAssistenceAreaViewFrontSupportedModesCollector[]{this.fvSupportedModesCollector};
        this.rvSupportedModesCollector = new CarParkAssistenceAreaViewRearSupportedModesCollector();
        this.rvSupportedModesCollectorArray = new CarParkAssistenceAreaViewRearSupportedModesCollector[]{this.rvSupportedModesCollector};
        this.svSupportedModesCollector = new CarParkAssistenceAreaViewSideSupportedModesCollector();
        this.svSupportedModesCollectorArray = new CarParkAssistenceAreaViewSideSupportedModesCollector[]{this.svSupportedModesCollector};
        this.bvSupportedModesCollector = new CarParkAssistenceAreaViewBVSupportedModesCollector();
        this.bvSupportedModesCollectorArray = new CarParkAssistenceAreaViewBVSupportedModesCollector[]{this.bvSupportedModesCollector};
        this.bv3DCollector = new CarParkAssistenceAreaViewVPS3DBirdViewPositionCollector();
        this.bv3DArray = new CarParkAssistenceAreaViewVPS3DBirdViewPositionCollector[]{this.bv3DCollector};
        this.wheelRadiusCollector = new CarParkAssistenceOPSSteeringInfoWheelRadiusCollector();
        this.initSensorStatus();
        this.target.registerModelEvents();
        this.target.initDsi();
        this.target.registerPowerMgr();
        this.target.registerDSIViewOptionsNotification();
        this.target.requestConfig();
        this.pdcSystemOnOff = true;
        this.pleSystemActive = true;
        ListManager.getGenericASLList(10162).updateList(this.pdcAcousticSettingsList);
    }

    private void evalConfigData(Access access) {
        if (access.contains(82)) {
            boolean bl = access.getBoolean(82);
            if (this.target.isTraceEnabled()) {
                this.target.trace().append("OpsVps: CONFIG_DATA isRvcLowCoded: ").append(bl).append(", ").append(this.getName()).log();
            }
            if (!bl) {
                this.target.registerVPSSettingsModelEvents();
                this.target.registerVPSSettingsDSINotifications();
            }
            this.target.setRvcLowCoded(bl);
            this.updatePDCConfig();
        } else {
            this.target.error().append("OpsVps: RVCLow coding key not exist");
        }
    }

    private void extCamManualActivation(int n) {
        if (n == 1) {
            this.target.activateExtCamera(true);
        } else if (n == 0) {
            this.target.activateExtCamera(false);
        }
    }

    private void setFifthCameraMode(int n) {
        if (n == 0) {
            this.target.setFifthCameraMode(2);
        } else if (n == 1) {
            this.target.setFifthCameraMode(1);
        } else if (n == 2) {
            this.target.setFifthCameraMode(0);
        }
    }

    private void setPDCSoundSettings(int n, int n2) {
        if (n == 0) {
            this.target.setPDCVolumeFront(n2);
        } else if (n == 2) {
            this.target.setPDCVolumeRear(n2);
        } else if (n == 1) {
            this.target.setPDCFreqFront(n2);
        } else if (n == 3) {
            this.target.setPDCFreqRear(n2);
        }
    }

    private void incDecPDCSoundSettings(int n, boolean bl) {
        if (n == 0) {
            if (this.canChange(bl, this.volumeFront)) {
                this.volumeFront = bl ? ++this.volumeFront : --this.volumeFront;
                this.target.setPDCVolumeFront(this.volumeFront);
            }
        } else if (n == 2) {
            if (this.canChange(bl, this.volumeRear)) {
                this.volumeRear = bl ? ++this.volumeRear : --this.volumeRear;
                this.target.setPDCVolumeRear(this.volumeRear);
            }
        } else if (n == 1) {
            if (this.canChange(bl, this.freqFront)) {
                this.freqFront = bl ? ++this.freqFront : --this.freqFront;
                this.target.setPDCFreqFront(this.freqFront);
            }
        } else if (n == 3 && this.canChange(bl, this.freqRear)) {
            this.freqRear = bl ? ++this.freqRear : --this.freqRear;
            this.target.setPDCFreqRear(this.freqRear);
        }
    }

    private void initSensorStatus() {
        int n = OPS_SENSOR_STATUS.length;
        for (int i2 = 0; i2 < n; ++i2) {
            StatePopupOff.OPS_SENSOR_STATUS[i2] = 14;
        }
        ServiceManager.aslPropertyManager.valueChangedIntegerArray(10174, OPS_SENSOR_STATUS);
    }

    private boolean canChange(boolean bl, int n) {
        boolean bl2 = true;
        if (bl && n >= 9) {
            bl2 = false;
        } else if (!bl && n <= 1) {
            bl2 = false;
        }
        return bl2;
    }

    public void dsiCarParkingSystemRequestParkingPopup(DisplayContent displayContent) {
        this.target.info().append("OpsVps: dsiCarParkingSystemRequestParkingPopup ").append(displayContent.toString()).append(" in class ").append(this.getName()).log();
        boolean bl = OpsVpsHsmTarget.isContentToCancel(displayContent);
        if (bl) {
            if (this.target.isTraceEnabled()) {
                this.target.warn().append("OpsVps: req off irgnored ").append(displayContent.toString()).append(" in class ").append(this.getName()).log();
            }
        } else {
            this.target.onRequestToShowClose(displayContent);
            this.target.updateModelDisplayContent(displayContent);
            this.trans(this.target.stateWaitConfirmationToShow);
        }
    }

    public void dsiCarParkingSystemUpdateParkingPopupContent(DisplayContent displayContent, int n) {
        this.target.info().append("OpsVps: dsiCarParkingSystemUpdateParkingPopupContent empty impl ").append(displayContent.toString()).append(n).append(" in class ").append(this.getName()).log();
    }

    public void dsiCarParkingSystemUpdateParkingSystemViewOptions(ParkingSystemViewOptions parkingSystemViewOptions, int n) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("OpsVps: dsiCarParkingSystemUpdateParkingSystemViewOptions").log();
            this.target.trace().append("OpsVps: dsiCarParkingSystemUpdateViewOption offroad state: ").append(parkingSystemViewOptions.pdcOffroadMode.state).log();
        }
        ServiceManager.aslPropertyManager.valueChangedInteger(10193, parkingSystemViewOptions.getPdcConfiguration().getWheelbase());
        this.bvSupportedModesCollector.car_parkassistence_areaview_bv_supported_modes__is_bird_view3d = parkingSystemViewOptions.vps3DBirdview.getState() == 2 ? true : parkingSystemViewOptions.vps3DBirdview.getState() == 1;
        this.evaluatePDCConfig(parkingSystemViewOptions);
        this.evaluateVPSConfig(parkingSystemViewOptions.getVpsConfiguration());
    }

    public void dsiCarParkingSystemUpdateVPSVideoInfo(VPSVideoInfo vPSVideoInfo, int n) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("OpsVps: dsiCarParkingSystemUpdateVPSVideoInfo ").append(vPSVideoInfo.toString()).append(n).log();
        }
        this.isTrunkOpenVPS = vPSVideoInfo.trunkOpen;
        this.updatePDCDisclaimer();
        this.target.setDarkScreenTriggersVPS(vPSVideoInfo.trunkOpen, vPSVideoInfo.isSpeedToHigh());
    }

    public void dsiCarParkingSystemUpdatePDCInfo(PDCInfo pDCInfo, int n) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("OpsVps: dsiCarParkingSystemUpdatePDCInfo ").append(pDCInfo.toString()).append(n).log();
        }
        this.isTrunkOpenPDC = pDCInfo.trunkOpen;
        this.updatePDCDisclaimer();
        this.target.setDarkScreenTriggersPDC(pDCInfo.trunkOpen);
    }

    public void dsiCarParkingSystemAcknowledgeVpsSetFactoryDefault(boolean bl) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("OpsVps: dsiCarParkingSystemAcknowledgeVpsSetFactoryDefault ").append(bl).log();
        }
    }

    public void dsiCarParkingSystemUpdateVPSSystemOnOff(boolean bl, int n) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("OpsVps: dsiCarParkingSystemUpdateVPSSystemOnOff ").append(bl).append(", ").append(n).log();
        }
    }

    public void dsiCarParkingSystemUpdateVPSFailure(boolean bl, int n) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("OpsVps: dsiCarParkingSystemUpdateVPSFailure ").append(bl).append(", ").append(n).log();
        }
        this.target.setVPSFailure(bl);
    }

    public void dsiCarParkingSystemUpdatePDCFailure(boolean bl, int n) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("OpsVps: dsiCarParkingSystemUpdatePDCFailure: ").append(bl).log();
        }
        if (bl) {
            this.initSensorStatus();
        }
        this.target.updatePDCFailure(bl);
    }

    private void evaluatePDCConfig(ParkingSystemViewOptions parkingSystemViewOptions) {
        if (parkingSystemViewOptions == null) {
            if (this.target.isTraceEnabled()) {
                this.target.trace().append("OpsVps: dsiCarParkingSystemUpdateParkingSystemViewOptions OPS not installed").log();
            }
            return;
        }
        opsConfig = this.evalOPSConfig(parkingSystemViewOptions.getPdcConfiguration());
        if (opsConfig != 0) {
            this.updatePDCConfig();
            this.target.registerOPSDSINotifications();
            if (!this.dsiCommonNotificationsDone) {
                this.dsiCommonNotificationsDone = true;
                this.target.registerOPSVPSCommonNotifications();
            }
        } else {
            int n = 0;
            if (parkingSystemViewOptions.getPdcVolumeRear().getState() != 0 && parkingSystemViewOptions.getPdcFrequencyRear().getState() != 0) {
                n = 1;
            }
            if (parkingSystemViewOptions.getPdcVolumeFront().getState() != 0 && parkingSystemViewOptions.getPdcFrequencyFront().getState() != 0) {
                n = 2;
            }
            if (n != 0) {
                this.target.registerAPSnotifications(n == 1);
            }
        }
    }

    private void evaluateVPSConfig(VPSConfiguration vPSConfiguration) {
        if (vPSConfiguration == null) {
            if (this.target.isTraceEnabled()) {
                this.target.trace().append("OpsVps: dsiCarParkingSystemUpdateParkingSystemViewOptions VPS not installed").log();
            }
            return;
        }
        if (StatePopupOff.isAVConfig(vPSConfiguration)) {
            if (this.target.isTraceEnabled()) {
                this.target.trace().append("OpsVps: dsiCarParkingSystemUpdateParkingSystemViewOptions AV installed").log();
            }
            this.target.registerVPSDSINotifications();
            this.target.setAreaViewExistence(true);
            isRvc = false;
            this.setSupportedViews(vPSConfiguration);
        } else if (StatePopupOff.isFRVCConfig(vPSConfiguration)) {
            if (this.target.isTraceEnabled()) {
                this.target.trace().append("OpsVps: dsiCarParkingSystemUpdateParkingSystemViewOptions FRVC installed").log();
            }
            this.target.registerFRVCDSINotifications();
            this.target.setAreaViewExistence(false);
            isRvc = true;
            this.setFVModes(vPSConfiguration.getSupportedFVModes());
            this.setRearVModes(vPSConfiguration.getSupportedRVModes());
        } else if (StatePopupOff.isRVCConfig(vPSConfiguration)) {
            if (this.target.isTraceEnabled()) {
                this.target.trace().append("OpsVps: dsiCarParkingSystemUpdateParkingSystemViewOptions RVC (or RVCLow) installed").log();
            }
            this.target.registerRVCDSINotifications();
            this.target.setAreaViewExistence(false);
            isRvc = true;
            this.setRearVModes(vPSConfiguration.getSupportedRVModes());
        } else if (StatePopupOff.isRSVCConfig(vPSConfiguration)) {
            if (this.target.isTraceEnabled()) {
                this.target.trace().append("OpsVps: dsiCarParkingSystemUpdateParkingSystemViewOptions RSVC installed").log();
            }
            this.target.registerRVCDSINotifications();
            this.target.setAreaViewExistence(false);
            isRvc = true;
            this.setRearVModes(vPSConfiguration.getSupportedRVModes());
            this.setSVModes(vPSConfiguration.getSupportedSVModes());
        } else {
            if (this.target.isTraceEnabled()) {
                this.target.trace().append("OpsVps: dsiCarParkingSystemUpdateParkingSystemViewOptions VPS not installed").log();
            }
            this.target.setAreaViewExistence(false);
            isRvc = false;
        }
        if ((this.target.isAreaViewExist() || isRvc) && !this.dsiCommonNotificationsDone) {
            this.dsiCommonNotificationsDone = true;
            this.target.registerOPSVPSCommonNotifications();
        }
        this.updatePDCConfig();
    }

    private void setSupportedViews(VPSConfiguration vPSConfiguration) {
        VPSSupportedViews vPSSupportedViews = vPSConfiguration.getSupportedViews();
        if (vPSSupportedViews.isBirdview()) {
            this.setBVModes(vPSConfiguration.getSupportedBVModes());
        }
        if (vPSSupportedViews.isFrontview()) {
            this.setFVModes(vPSConfiguration.getSupportedFVModes());
        }
        if (vPSSupportedViews.isRearview()) {
            this.setRearVModes(vPSConfiguration.getSupportedRVModes());
        }
        if (vPSSupportedViews.isLeftsideview()) {
            this.setSVModes(vPSConfiguration.getSupportedSVModes());
        }
        if (vPSSupportedViews.isRightsideview()) {
            this.setSVModes(vPSConfiguration.getSupportedSVModes());
        }
    }

    private void updatePDCConfig() {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("OpsVps: updatePDCConfig. RVClow coded=").append(this.target.isRvcLowCoded()).log();
        }
        if (opsConfig != 0 && (this.target.isRvcLowCoded() || isRvc)) {
            ServiceManager.aslPropertyManager.valueChangedInteger(10180, 4);
        } else if (opsConfig != 0 && this.target.isAreaViewExist()) {
            ServiceManager.aslPropertyManager.valueChangedInteger(10180, 6);
        } else if (this.target.isAreaViewExist()) {
            ServiceManager.aslPropertyManager.valueChangedInteger(10180, 5);
        } else if (this.target.isRvcLowCoded() || isRvc) {
            ServiceManager.aslPropertyManager.valueChangedInteger(10180, 3);
        } else if (opsConfig != 0) {
            ServiceManager.aslPropertyManager.valueChangedInteger(10180, 1);
        } else {
            if (this.target.isTraceEnabled()) {
                this.target.trace().append("OpsVps: dsiCarParkingSystemUpdateParkingSystemViewOptions NO PDC coding").log();
            }
            ServiceManager.aslPropertyManager.valueChangedInteger(10180, 0);
        }
    }

    private void setSVModes(VPSSupportedSVModes vPSSupportedSVModes) {
        this.svSupportedModesCollector.car_parkassistence_areaview_side_supported_modes__is_right = vPSSupportedSVModes.rightSideview;
        this.svSupportedModesCollector.car_parkassistence_areaview_side_supported_modes__is_left = vPSSupportedSVModes.leftSideview;
        this.svSupportedModesCollector.car_parkassistence_areaview_side_supported_modes__is_left_right = vPSSupportedSVModes.leftRightSideview;
        ListManager.getGenericASLList(10454).updateList(this.svSupportedModesCollectorArray);
    }

    private void setRearVModes(VPSSupportedRVModes vPSSupportedRVModes) {
        this.rvSupportedModesCollector.car_parkassistence_areaview_rear_supported_modes__is_parkbox_mode = vPSSupportedRVModes.parkbox;
        this.rvSupportedModesCollector.car_parkassistence_areaview_rear_supported_modes__is_parallel_mode = vPSSupportedRVModes.parallelToRoad;
        this.rvSupportedModesCollector.car_parkassistence_areaview_rear_supported_modes__is_crossing_mode = vPSSupportedRVModes.crossing;
        this.rvSupportedModesCollector.car_parkassistence_areaview_rear_supported_modes__is_trailer_mode = vPSSupportedRVModes.trailerAssist;
        ListManager.getGenericASLList(10453).updateList(this.rvSupportedModesCollectorArray);
    }

    private void setFVModes(VPSSupportedFVModes vPSSupportedFVModes) {
        this.fvSupportedModesCollector.car_parkassistence_areaview_front_supported_modes__is_parkbox_mode = vPSSupportedFVModes.parkbox;
        this.fvSupportedModesCollector.car_parkassistence_areaview_front_supported_modes__is_crossing_mode = vPSSupportedFVModes.crossing;
        this.fvSupportedModesCollector.car_parkassistence_areaview_front_supported_modes__is_top_mode = vPSSupportedFVModes.offroad;
        ListManager.getGenericASLList(10452).updateList(this.fvSupportedModesCollectorArray);
    }

    private void setBVModes(VPSSupportedBVModes vPSSupportedBVModes) {
        this.bvSupportedModesCollector.car_parkassistence_areaview_bv_supported_modes__is_main_mode = vPSSupportedBVModes.mainMode;
        this.bvSupportedModesCollector.car_parkassistence_areaview_bv_supported_modes__is_offroad_kog = vPSSupportedBVModes.offroadKOG;
        ListManager.getGenericASLList(10456).updateList(this.bvSupportedModesCollectorArray);
    }

    private int evalOPSConfig(PDCConfiguration pDCConfiguration) {
        int n = 0;
        if (StatePopupOff.isOPS360(pDCConfiguration)) {
            if (this.target.isTraceEnabled()) {
                this.target.trace().append("OpsVps: dsiCarParkingSystemUpdateParkingSystemViewOptions OPS360 installed.").log();
            }
            ServiceManager.aslPropertyManager.valueChangedBoolean(10176, true);
            ServiceManager.aslPropertyManager.valueChangedBoolean(10175, false);
            n = 1;
        } else if (StatePopupOff.isOPSFrontRear(pDCConfiguration)) {
            if (this.target.isTraceEnabled()) {
                this.target.trace().append("OpsVps: dsiCarParkingSystemUpdateParkingSystemViewOptions OPS FR installed.").log();
            }
            ServiceManager.aslPropertyManager.valueChangedBoolean(10176, false);
            ServiceManager.aslPropertyManager.valueChangedBoolean(10175, false);
            n = 2;
        } else if (StatePopupOff.isOPSRearOnly(pDCConfiguration)) {
            if (this.target.isTraceEnabled()) {
                this.target.trace().append("OpsVps: dsiCarParkingSystemUpdateParkingSystemViewOptions OPS R installed.").log();
            }
            ServiceManager.aslPropertyManager.valueChangedBoolean(10176, false);
            ServiceManager.aslPropertyManager.valueChangedBoolean(10175, true);
            n = 3;
        } else if (this.target.isTraceEnabled()) {
            this.target.trace().append("OpsVps: dsiCarParkingSystemUpdateParkingSystemViewOptions OPS not installed").log();
        }
        return n;
    }

    private static boolean isOPSRearOnly(PDCConfiguration pDCConfiguration) {
        return pDCConfiguration.getNumberRearSectors() != 0;
    }

    private static boolean isOPSFrontRear(PDCConfiguration pDCConfiguration) {
        return pDCConfiguration.getNumberFrontSectors() != 0 && pDCConfiguration.getNumberRearSectors() != 0;
    }

    private static boolean isOPS360(PDCConfiguration pDCConfiguration) {
        return pDCConfiguration.getNumberFrontSectors() != 0 && pDCConfiguration.getNumberLeftSectors() != 0 && pDCConfiguration.getNumberRearSectors() != 0 && pDCConfiguration.getNumberRightSectors() != 0;
    }

    private static boolean isAVConfig(VPSConfiguration vPSConfiguration) {
        return vPSConfiguration.supportedViews.rearview && vPSConfiguration.supportedViews.birdview && vPSConfiguration.supportedViews.frontview && vPSConfiguration.supportedViews.leftsideview && vPSConfiguration.supportedViews.rightsideview;
    }

    private static boolean isFRVCConfig(VPSConfiguration vPSConfiguration) {
        return vPSConfiguration.supportedViews.rearview && vPSConfiguration.supportedViews.frontview && !vPSConfiguration.supportedViews.birdview && !vPSConfiguration.supportedViews.leftsideview && !vPSConfiguration.supportedViews.rightsideview;
    }

    private static boolean isRVCConfig(VPSConfiguration vPSConfiguration) {
        return vPSConfiguration.supportedViews.rearview && !vPSConfiguration.supportedViews.birdview && !vPSConfiguration.supportedViews.frontview && !vPSConfiguration.supportedViews.leftsideview && !vPSConfiguration.supportedViews.rightsideview;
    }

    private static boolean isRSVCConfig(VPSConfiguration vPSConfiguration) {
        return vPSConfiguration.supportedViews.rearview && !vPSConfiguration.supportedViews.frontview && (vPSConfiguration.supportedViews.leftsideview || vPSConfiguration.supportedViews.rightsideview) && !vPSConfiguration.supportedViews.birdview;
    }

    public void dsiCarParkingSystemUpdatePDCMute(boolean bl, int n) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("OpsVps: dsiCarParkingSystemUpdatePDCMute ").append(bl).log();
        }
        this.pdcMute = bl;
        ServiceManager.aslPropertyManager.valueChangedBoolean(10164, bl);
    }

    public void dsiCarParkingSystemUpdatePDCVolumeFront(int n, int n2) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("OpsVps: updatePDCVolumeFront ").append(n).log();
        }
        this.volumeFront = n;
        int[] nArray = (int[])this.pdcAcousticSettingsList[0];
        nArray[0] = n;
        ListManager.getGenericASLList(10162).updateList(this.pdcAcousticSettingsList);
    }

    public void dsiCarParkingSystemUpdatePDCVolumeRear(int n, int n2) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("OpsVps: updatePDCVolumeRear ").append(n).log();
        }
        this.volumeRear = n;
        int[] nArray = (int[])this.pdcAcousticSettingsList[2];
        nArray[0] = n;
        ListManager.getGenericASLList(10162).updateList(this.pdcAcousticSettingsList);
    }

    public void dsiCarParkingSystemUpdatePDCFrequenceFront(int n, int n2) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("OpsVps: updatePDCFrequenceFront ").append(n).log();
        }
        this.freqFront = n;
        int[] nArray = (int[])this.pdcAcousticSettingsList[1];
        nArray[0] = n;
        ListManager.getGenericASLList(10162).updateList(this.pdcAcousticSettingsList);
    }

    public void dsiCarParkingSystemUpdatePDCFrequenceRear(int n, int n2) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("OpsVps: updatePDCFrequenceRear ").append(n).log();
        }
        this.freqRear = n;
        int[] nArray = (int[])this.pdcAcousticSettingsList[3];
        nArray[0] = n;
        ListManager.getGenericASLList(10162).updateList(this.pdcAcousticSettingsList);
    }

    public void dsiCarParkingSystemUpdatePDCOPSAutoActivation(boolean bl, int n) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("OpsVps: updatePDCOPSAutoActivation ").append(bl).log();
        }
        this.autoActivation = bl;
        ServiceManager.aslPropertyManager.valueChangedBoolean(10161, bl);
    }

    public void dsiSoundUpdateLoweringEntertainment(int n, int n2, int n3, short s, int n4) {
        if (n3 == 1) {
            if (this.target.isTraceEnabled()) {
                this.target.trace().append("OpsVps: updateLoweringEnt vol=").append(s).log();
            }
            if (n == 0) {
                this.audioConnection = 12;
            }
            this.audioConnection = n;
            this.apsLoweringLevel = s > 6 ? (short)0 : s;
            ServiceManager.aslPropertyManager.valueChangedInteger(10163, this.apsLoweringLevel);
        }
    }

    public void dsiCarComfortUpdateBrakeElectricalParking(boolean bl, int n) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("OpsVps: updateBrakeElectricalParking ").append(bl).log();
        }
        this.brakeElectricalParking = bl;
        ServiceManager.aslPropertyManager.valueChangedBoolean(10168, bl);
    }

    public void dsiGeneralVehicleStatesUpdateAcousticParkingSystem(boolean bl, int n) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("OpsVps: dsiGeneralVehicleStatesUpdateAcousticParkingSystem: ").append(bl).log();
        }
        this.apsActive = bl;
        if (this.audioMgrAvailable) {
            this.doAudioAttenuation(bl);
        }
    }

    private void doAudioAttenuation(boolean bl) {
        if (bl) {
            if (!this.audioAttenuationDone) {
                this.lastAudioConnectionRequested = this.apsLoweringLevel == 6 ? 5 : 4;
                this.audioAttenuationEvent = ServiceManager.mGenericEventFactory.newEvent();
                this.audioAttenuationEvent.setInt(0, this.lastAudioConnectionRequested);
                this.target.triggerObserver(34159872, this.audioAttenuationEvent);
                this.audioAttenuationDone = true;
            }
        } else if (this.audioAttenuationDone) {
            this.audioAttenuationEvent = ServiceManager.mGenericEventFactory.newEvent();
            this.audioAttenuationEvent.setInt(0, this.lastAudioConnectionRequested);
            this.target.triggerObserver(67714304, this.audioAttenuationEvent);
            this.audioAttenuationDone = false;
        }
    }

    public void dsiCarParkingSystemUpdatePDCOffroadMode(boolean bl, int n) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("OpsVps: dsiCarParkingSystemUpdatePDCOffroadMode").append(bl).append(", ").append(n).log();
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(10450, bl);
        this.pdcOffroadState = bl;
        this.target.setPDCOffroadStatus(bl);
        this.updatePDCDisclaimer();
    }

    public void dsiCarDriverAssistanceUpdateSWAViewOptions(SWAViewOptions sWAViewOptions, int n) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("OpsVps: dsiCarDriverAssistanceUpdateSWAViewOptions: ").append(sWAViewOptions.toString()).log();
        }
        this.target.registerSWADSINotification();
    }

    public void dsiCarParkingSystemUpdateVPSColor(int n, int n2) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("OpsVps: dsiCarParkingSystemUpdateVPSColor ").append(n).append(", ").append(n2).log();
        }
        this.target.updateColorValue(n);
    }

    public void dsiCarParkingSystemUpdateVPSContrast(int n, int n2) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("OpsVps: dsiCarParkingSystemUpdateVPSContrast ").append(n).append(n2).log();
        }
        this.target.updateContrastValue(n);
    }

    public void dsiCarParkingSystemUpdateVPSBrightness(int n, int n2) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("OpsVps: dsiCarParkingSystemUpdateVPSBrightness ").append(n).append(n2).log();
        }
        this.target.updateBrightnessValue(n);
    }

    public void dsiCarParkingSystemUpdatePDCSystemOnOff(boolean bl, int n) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("OpsVps: pdc system:  ").append(bl).append(n).log();
        }
        ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger().info(1, new StringBuffer().append("OpsVps: pdc system:  ").append(bl).toString());
        this.pdcSystemOnOff = bl;
        ServiceManager.aslPropertyManager.valueChangedBoolean(10172, bl);
        this.target.updatePDCSystemOnOff(bl);
    }

    public void dsiCarParkingSystemUpdateVPSExtCamConfig(int n, int n2) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("OpsVps: 5th cam:  ").append(n).log();
        }
        if (n == 2) {
            ServiceManager.aslPropertyManager.valueChangedInteger(10171, 0);
        } else if (n == 1) {
            ServiceManager.aslPropertyManager.valueChangedInteger(10171, 1);
        } else if (n == 0) {
            ServiceManager.aslPropertyManager.valueChangedInteger(10171, 2);
        }
    }

    public void dsiCarParkingSystemUpdatePDCParkboxVisualisation(boolean bl, int n) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("OpsVps: PDCParkboxVisualisation:  ").append(bl).log();
        }
        this.pleSystemActive = bl;
        ServiceManager.aslPropertyManager.valueChangedBoolean(10170, bl);
    }

    public void dsiCarParkingSystemUpdatePDCSteeringInformation(PDCSteeringInformation pDCSteeringInformation, int n) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(10190, pDCSteeringInformation.isDirection());
        ServiceManager.aslPropertyManager.valueChangedInteger(10189, this.mappingToHmiDirections(pDCSteeringInformation.getTrackDisplay()));
        this.wheelRadiusCollector.car_parkassistence_ops_steering_info_wheel_radius_front__1 = pDCSteeringInformation.getRadiusFrontWheel();
        this.wheelRadiusCollector.car_parkassistence_ops_steering_info_wheel_radius_rear__1 = pDCSteeringInformation.getRadiusRearWheel();
        ListManager.getGenericASLList(10197).updateList(new CarParkAssistenceOPSSteeringInfoWheelRadiusCollector[]{this.wheelRadiusCollector});
    }

    private int mappingToHmiDirections(int n) {
        switch (n) {
            case 0: {
                return 0;
            }
            case 1: {
                return 1;
            }
            case 2: {
                return 2;
            }
        }
        if (this.target.isTraceEnabled()) {
            this.target.error().append("OpsVps:Track display. Use NONE. Wrong direction value:").append(n).log();
        }
        return 0;
    }

    public void dsiCarParkingSystemUpdateVPSExtCamManActivation(boolean bl, int n) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("OpsVps: VPSExtCamManActivation: ").append(bl).log();
        }
        if (bl) {
            ServiceManager.aslPropertyManager.valueChangedInteger(10461, 1);
            this.trans(this.target.statePopupOn);
        } else {
            ServiceManager.aslPropertyManager.valueChangedInteger(10461, 0);
            this.trans(this.target.statePopupOff);
        }
    }

    public void dsiCarParkingSystemUpdateVPS3DBirdview(int n, int n2, int n3) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("OpsVps: VPS3DBirdview: p=").append(n).append(", v=").append(n2).log();
        }
        this.bv3DCollector.car_parkassistence_areaview_vps3d_bird_view_position_plain = n;
        this.bv3DCollector.car_parkassistence_areaview_vps3d_bird_view_position_point = n2;
        ListManager.getGenericASLList(10462).updateList(this.bv3DArray);
    }

    public void dsiCarParkingSystemUpdatePDCTrailerHitched(boolean bl, int n) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("OpsVps: dsiCarParkingSystemUpdatePDCTrailerHitched: ").append(bl).log();
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(10179, bl);
    }

    public void dsiCarParkingSystemUpdatePDCStatusLevelFront(PDCStatusLevelFrontRear pDCStatusLevelFrontRear, int n) {
        StatePopupOff.OPS_SENSOR_STATUS[1] = pDCStatusLevelFrontRear.getLeft();
        StatePopupOff.OPS_SENSOR_STATUS[0] = pDCStatusLevelFrontRear.getLeftMiddle();
        StatePopupOff.OPS_SENSOR_STATUS[8] = pDCStatusLevelFrontRear.getRightMiddle();
        StatePopupOff.OPS_SENSOR_STATUS[9] = pDCStatusLevelFrontRear.getRight();
        ServiceManager.aslPropertyManager.valueChangedIntegerArray(10174, OPS_SENSOR_STATUS);
        this.updatePDCDisclaimer();
    }

    public void dsiCarParkingSystemUpdatePDCStatusLevelRear(PDCStatusLevelFrontRear pDCStatusLevelFrontRear, int n) {
        StatePopupOff.OPS_SENSOR_STATUS[6] = pDCStatusLevelFrontRear.getLeft();
        StatePopupOff.OPS_SENSOR_STATUS[7] = pDCStatusLevelFrontRear.getLeftMiddle();
        StatePopupOff.OPS_SENSOR_STATUS[15] = pDCStatusLevelFrontRear.getRightMiddle();
        StatePopupOff.OPS_SENSOR_STATUS[14] = pDCStatusLevelFrontRear.getRight();
        ServiceManager.aslPropertyManager.valueChangedIntegerArray(10174, OPS_SENSOR_STATUS);
        this.updatePDCDisclaimer();
    }

    public void dsiCarParkingSystemUpdatePDCStatusLevelRight(PDCStatusLevelRightLeft pDCStatusLevelRightLeft, int n) {
        StatePopupOff.OPS_SENSOR_STATUS[10] = pDCStatusLevelRightLeft.getFront();
        StatePopupOff.OPS_SENSOR_STATUS[11] = pDCStatusLevelRightLeft.getFrontMiddle();
        StatePopupOff.OPS_SENSOR_STATUS[12] = pDCStatusLevelRightLeft.getRearMiddle();
        StatePopupOff.OPS_SENSOR_STATUS[13] = pDCStatusLevelRightLeft.getRear();
        ServiceManager.aslPropertyManager.valueChangedIntegerArray(10174, OPS_SENSOR_STATUS);
        this.updatePDCDisclaimer();
    }

    public void dsiCarParkingSystemUpdatePDCStatusLevelLeft(PDCStatusLevelRightLeft pDCStatusLevelRightLeft, int n) {
        StatePopupOff.OPS_SENSOR_STATUS[2] = pDCStatusLevelRightLeft.getFront();
        StatePopupOff.OPS_SENSOR_STATUS[3] = pDCStatusLevelRightLeft.getFrontMiddle();
        StatePopupOff.OPS_SENSOR_STATUS[4] = pDCStatusLevelRightLeft.getRearMiddle();
        StatePopupOff.OPS_SENSOR_STATUS[5] = pDCStatusLevelRightLeft.getRear();
        ServiceManager.aslPropertyManager.valueChangedIntegerArray(10174, OPS_SENSOR_STATUS);
        this.updatePDCDisclaimer();
    }

    public void dsiCarParkingSystemUpdatePDCDistanceValuesFront(PDCDistanceValuesFrontRear pDCDistanceValuesFrontRear, int n) {
        StatePopupOff.OPS_SENSOR_VALUES[1] = pDCDistanceValuesFrontRear.getLeft();
        StatePopupOff.OPS_SENSOR_VALUES[0] = pDCDistanceValuesFrontRear.getLeftMiddle();
        StatePopupOff.OPS_SENSOR_VALUES[9] = pDCDistanceValuesFrontRear.getRight();
        StatePopupOff.OPS_SENSOR_VALUES[8] = pDCDistanceValuesFrontRear.getRightMiddle();
        ServiceManager.aslPropertyManager.valueChangedIntegerArray(10173, OPS_SENSOR_VALUES);
    }

    public void dsiCarParkingSystemUpdatePDCDistanceValuesRear(PDCDistanceValuesFrontRear pDCDistanceValuesFrontRear, int n) {
        StatePopupOff.OPS_SENSOR_VALUES[6] = pDCDistanceValuesFrontRear.getLeft();
        StatePopupOff.OPS_SENSOR_VALUES[7] = pDCDistanceValuesFrontRear.getLeftMiddle();
        StatePopupOff.OPS_SENSOR_VALUES[14] = pDCDistanceValuesFrontRear.getRight();
        StatePopupOff.OPS_SENSOR_VALUES[15] = pDCDistanceValuesFrontRear.getRightMiddle();
        ServiceManager.aslPropertyManager.valueChangedIntegerArray(10173, OPS_SENSOR_VALUES);
    }

    public void dsiCarParkingSystemUpdatePDCDistanceValuesRight(PDCDistanceValuesRightLeft pDCDistanceValuesRightLeft, int n) {
        StatePopupOff.OPS_SENSOR_VALUES[10] = pDCDistanceValuesRightLeft.getFront();
        StatePopupOff.OPS_SENSOR_VALUES[11] = pDCDistanceValuesRightLeft.getFrontMiddle();
        StatePopupOff.OPS_SENSOR_VALUES[13] = pDCDistanceValuesRightLeft.getRear();
        StatePopupOff.OPS_SENSOR_VALUES[12] = pDCDistanceValuesRightLeft.getRearMiddle();
        ServiceManager.aslPropertyManager.valueChangedIntegerArray(10173, OPS_SENSOR_VALUES);
    }

    public void dsiCarParkingSystemUpdatePDCDistanceValuesLeft(PDCDistanceValuesRightLeft pDCDistanceValuesRightLeft, int n) {
        StatePopupOff.OPS_SENSOR_VALUES[2] = pDCDistanceValuesRightLeft.getFront();
        StatePopupOff.OPS_SENSOR_VALUES[3] = pDCDistanceValuesRightLeft.getFrontMiddle();
        StatePopupOff.OPS_SENSOR_VALUES[5] = pDCDistanceValuesRightLeft.getRear();
        StatePopupOff.OPS_SENSOR_VALUES[4] = pDCDistanceValuesRightLeft.getRearMiddle();
        ServiceManager.aslPropertyManager.valueChangedIntegerArray(10173, OPS_SENSOR_VALUES);
    }

    public void dsiPowerManagementUpdateClampSignal(ClampSignal clampSignal, int n) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("OpsVps: clamp status").append(clampSignal.toString()).log();
        }
        this.target.setClamp15(clampSignal.clamp15);
    }

    private void updatePDCDisclaimer() {
        if (this.pdcOffroadState) {
            ServiceManager.aslPropertyManager.valueChangedInteger(10465, 3);
        } else if (this.isSensorStatusError()) {
            ServiceManager.aslPropertyManager.valueChangedInteger(10465, 2);
        } else if (this.isSensorStatusObstructed()) {
            ServiceManager.aslPropertyManager.valueChangedInteger(10465, 1);
        } else if (this.isTrunkOpenVPS || this.isTrunkOpenPDC) {
            ServiceManager.aslPropertyManager.valueChangedInteger(10465, 4);
        } else {
            ServiceManager.aslPropertyManager.valueChangedInteger(10465, 0);
        }
    }

    private boolean isSensorStatusError() {
        int n;
        for (n = 0; n < OPS_SENSOR_STATUS.length; ++n) {
            if (OPS_SENSOR_STATUS[n] != 15) continue;
            return true;
        }
        for (n = 0; n < this.rtaStatus.length; ++n) {
            if (this.rtaStatus[n] != 15) continue;
            return true;
        }
        return false;
    }

    private boolean isSensorStatusObstructed() {
        for (int i2 = 0; i2 < OPS_SENSOR_STATUS.length; ++i2) {
            if (OPS_SENSOR_STATUS[i2] != 13) continue;
            return true;
        }
        return false;
    }

    public void dsiCarDriverAssistanceUpdateSWARCTASensorData(SWARCTASensorData sWARCTASensorData, int n) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("OpsVps: dsiSWARCTASensorData RL: ").append(sWARCTASensorData.distanceRearLeft).append(", RR: ").append(sWARCTASensorData.distanceRearRight).log();
        }
        this.rtaStatus = new int[]{0, 0};
        if (sWARCTASensorData.statusLevelRearLeft == 0 && sWARCTASensorData.distanceRearLeft == 15) {
            if (this.target.isTraceEnabled()) {
                this.target.trace().append("OpsVps: RTA RL: ").append(0).log();
            }
            this.rtaStatus[0] = 0;
        } else if (sWARCTASensorData.statusLevelRearLeft == 1 && sWARCTASensorData.distanceRearLeft == 0) {
            if (this.target.isTraceEnabled()) {
                this.target.trace().append("OpsVps: RTA RL: ").append(1).log();
            }
            this.rtaStatus[0] = 1;
        } else if (sWARCTASensorData.statusLevelRearLeft == 2 && sWARCTASensorData.distanceRearLeft == 2) {
            if (this.target.isTraceEnabled()) {
                this.target.trace().append("OpsVps: RTA RL: ").append(2).log();
            }
            this.rtaStatus[0] = 2;
        } else if (sWARCTASensorData.statusLevelRearLeft == 3 && sWARCTASensorData.distanceRearLeft == 3) {
            if (this.target.isTraceEnabled()) {
                this.target.trace().append("OpsVps: RTA RL: ").append(3).log();
            }
            this.rtaStatus[0] = 3;
        } else if (sWARCTASensorData.statusLevelRearLeft == 15 && sWARCTASensorData.distanceRearLeft == 15) {
            if (this.target.isTraceEnabled()) {
                this.target.trace().append("OpsVps: RTA RL: ").append(15).log();
            }
            this.rtaStatus[0] = 15;
        }
        if (sWARCTASensorData.statusLevelRearRight == 0 && sWARCTASensorData.distanceRearRight == 15) {
            if (this.target.isTraceEnabled()) {
                this.target.trace().append("OpsVps: RTA RR: ").append(0).log();
            }
            this.rtaStatus[1] = 0;
        } else if (sWARCTASensorData.statusLevelRearRight == 1 && sWARCTASensorData.distanceRearRight == 0) {
            if (this.target.isTraceEnabled()) {
                this.target.trace().append("OpsVps: RTA RR: ").append(1).log();
            }
            this.rtaStatus[1] = 1;
        } else if (sWARCTASensorData.statusLevelRearRight == 2 && sWARCTASensorData.distanceRearRight == 2) {
            if (this.target.isTraceEnabled()) {
                this.target.trace().append("OpsVps: RTA RR: ").append(2).log();
            }
            this.rtaStatus[1] = 2;
        } else if (sWARCTASensorData.statusLevelRearRight == 3 && sWARCTASensorData.distanceRearRight == 3) {
            if (this.target.isTraceEnabled()) {
                this.target.trace().append("OpsVps: RTA RR: ").append(3).log();
            }
            this.rtaStatus[1] = 3;
        } else if (sWARCTASensorData.statusLevelRearRight == 15 && sWARCTASensorData.distanceRearRight == 15) {
            if (this.target.isTraceEnabled()) {
                this.target.trace().append("OpsVps: RTA RR: ").append(15).log();
            }
            this.rtaStatus[1] = 15;
        }
        ServiceManager.aslPropertyManager.valueChangedIntegerArray(10196, this.rtaStatus);
        this.updatePDCDisclaimer();
    }

    public void dsiCarParkingSystemUpdatePDCManeuverAssistConfig(int n, int n2) {
        boolean bl = n != 0;
        ServiceManager.aslPropertyManager.valueChangedBoolean(10526, bl);
        this.maneuverSystemOnOff = bl;
    }

    public void dsiCarParkingSystemUpdatePDCManeuverAssist(boolean bl, int n) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(10527, bl);
        this.maneuverAssist = bl;
    }

    public void dsiCarParkingSystemAcknowledgePdcSetFactoryDefault(boolean bl) {
        this.target.info().append("OpsVps: reset done").log();
        this.target.resetToFactoryDone(bl);
    }

    public void dsiCarParkingSystemUpdateVPSSystemState(boolean bl, int n) {
        this.target.info().append("OpsVps: VPSSystemState: ").append(bl).log();
        this.vpsSystemState = bl;
    }

    public void dsiCarDriverAssistanceUpdateSWAExitAssist(boolean bl, int n) {
        this.swaExistAssist = bl;
        ServiceManager.aslPropertyManager.valueChangedBoolean(10794, bl);
    }

    @Override
    public void onSuccess(Access access) {
        this.evalConfigData(access);
    }

    @Override
    public void onError() {
        this.target.error().append("OpsVps: Error requesting coding data from adaption api");
    }

    static {
        OPS_SENSOR_STATUS = new int[16];
        OPS_SENSOR_VALUES = new int[16];
    }
}


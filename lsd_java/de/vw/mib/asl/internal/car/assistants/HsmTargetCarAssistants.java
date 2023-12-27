/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.assistants;

import de.vw.mib.asl.car.persistence.CarPersistenceServiceImpl;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.car.ASLCarContainer;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.car.assistants.transformer.CarAssistantsTrailerModeSpeedThresholdCollector;
import generated.de.vw.mib.asl.internal.car.assistants.transformer.CarAssistantsVZESpeedWarningThresholdCollector;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carcomfort.DSICarComfort;
import org.dsi.ifc.cardriverassistance.ACCViewOptions;
import org.dsi.ifc.cardriverassistance.AWVEmergencyBrake;
import org.dsi.ifc.cardriverassistance.AWVViewOptions;
import org.dsi.ifc.cardriverassistance.DSICarDriverAssistance;
import org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener;
import org.dsi.ifc.cardriverassistance.NVObjectDetection;
import org.dsi.ifc.cardriverassistance.SWAViewOptions;
import org.dsi.ifc.cardriverassistance.TSDRoadSignFilter;
import org.dsi.ifc.cardriverassistance.TSDViewOptions;
import org.dsi.ifc.careco.DSICarEco;
import org.dsi.ifc.carkombi.DSICarKombi;
import org.dsi.ifc.global.CarBCSpeed;

public class HsmTargetCarAssistants
extends AbstractASLTarget {
    private DSICarDriverAssistance dsiCarDriverAssistance;
    private DSICarDriverAssistanceListener dsiCarDriverAssistanceListener;
    private DSICarComfort dsiCarComfort;
    private DSICarKombi dsiCarKombi;
    private DSICarEco dsiCarEco;
    public static final int DISTANCE_ACC_VERY_SHORT;
    public static final int DISTANCE_ACC_SHORT;
    public static final int DISTANCE_ACC_MEDIUM;
    public static final int DISTANCE_ACC_LONG;
    public static final int DISTANCE_ACC_VERY_LONG;
    private final int NV_CONTRAST_DSI_MIN;
    private final int NV_CONTRAST_DSI_MAX;
    private final int NV_CONTRAST_MODELL_STEP_SIZE;
    private final int NV_CONTRAST_MODELL_MIDDLE_POSITION;
    private int durationSWA;
    private boolean ACC_IS_LAST_DISTANCE_ACTIVE;
    private boolean AWV_SYSTEM_ACTIVE;
    private boolean TSD_ACTIVE;
    private boolean PRE_CRASH_ACTIVE;
    private boolean SWA_ACTIVE;
    private boolean MKE_ACTIVE;
    private boolean AUTO_EMERGENCY_BRAKE_ACTIVE;
    private boolean CITY_EMERGENCY_BRAKING_ACTIVE;
    private boolean TRAILER_MODE_ROAD_SIGNS;
    private boolean TRAILER_MODE_ROUTE_CALCULATION;
    private boolean AWV_ACOUSTIC_SIGNAL_ACTIVE;
    private boolean AWV_WARNING_ACTIVE;
    private int SWA_BRIGHTNESS_VALUE;
    private boolean HCA_TIME;
    private boolean HDC_ACTIVESTATE;
    private TSDRoadSignFilter myRoadSignFilter;
    private AWVEmergencyBrake myAwvEmergencyBrake;
    private int currentStateAwv = -1;
    private boolean hcaSystemOnOff;
    private int current_hcaInterventionStyle = 0;
    private boolean curveActive;
    private boolean blindeSpotSoundActive;
    private boolean takeOverSpeedActive;
    private boolean pedestrianProtectionActive;
    private boolean pedestrianProtectionInformation;
    private boolean pedestrianProtectionWarning;
    private boolean rearTrafficAlertActive;
    private CarBCSpeed tsdBCSpeed;
    private int duration;
    private CarAssistantsTrailerModeSpeedThresholdCollector trailerModeSpeedLimitTrailerCollector;
    private int SWA_SYSTEM = -1;
    private int VZA_VZE_SYSTEM = -1;
    private boolean isVZEAcousticsActive = false;
    private boolean isVZESpeedWarningThresholdActive = false;
    private static final int SPEED_WARNING_KM_MIN;
    private static final int SPEED_WARNING_KM_MAX;
    private static final int SPEED_WARNING_MILES_MIN;
    private static final int SPEED_WARNING_MILES_MAX;
    private boolean PEA_SYSTEM_ACTIVE;
    private boolean nightVisionActive;
    private int nightVisionContrast = 50;
    private int vzeSpeedWarningThresholdMax;
    private int vzeSpeedWarningThresholdMin;
    private CarAssistantsVZESpeedWarningThresholdCollector vzeSpeedWarningThresholdCollector;
    private boolean dsiNotificationDone;
    private final boolean[] accDrivingPrograms = new boolean[4];
    private int awvSystemMode;
    private int tsdAcousticWarningState;
    private static final int ACC_DRIVING_PROGRAMM_ECO;
    private static final int ACC_DRIVING_PROGRAMM_COMFORT;
    private static final int ACC_DRIVING_PROGRAMM_NORMAL;
    private static final int ACC_DRIVING_PROGRAMM_SPORT;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$DSICarComfort;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$DSICarComfortListener;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$DSICarKombi;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$DSICarKombiListener;
    static /* synthetic */ Class class$org$dsi$ifc$careco$DSICarEco;
    static /* synthetic */ Class class$org$dsi$ifc$careco$DSICarEcoListener;
    static /* synthetic */ Class class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistance;
    static /* synthetic */ Class class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistanceListener;

    public HsmTargetCarAssistants(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.NV_CONTRAST_DSI_MIN = 5;
        this.NV_CONTRAST_DSI_MAX = 95;
        this.NV_CONTRAST_MODELL_STEP_SIZE = 5;
        this.NV_CONTRAST_MODELL_MIDDLE_POSITION = 50;
    }

    @Override
    public int getSubClassifier() {
        return 1;
    }

    @Override
    public int getDefaultTargetId() {
        return -1974529536;
    }

    private void registerModelEvents() {
        this.addObservers(new int[]{604766272, -485752768, 655097920, 688652352, 671875136, 738984000, 722206784, 806092864, 621543488, 940310592, 923533376, 822870080, 856424512, 705429568, 873201728, 1108148288, 889978944, 789315648, 755761216, 957087808, 1175191616, 1191968832, 973865024, 1057751104, 1091305536, 0x400C0040, 118227008, 1024262208, 604831808, 621609024, 688594944, -502595520, 1040515136, 1057292352, -519307200, -536084416, -183762880, -116654016, 386728000, 403505216, 420282432, 856490048, 839712832, 873267264, 890044480, 0x400D0040, 1091371072});
    }

    private void registerOnDriverAssistance() {
        this.dsiCarDriverAssistance.setNotification(new int[]{27, 6, 22, 43, 28, 29, 45, 36, 21, 42, 46, 32, 31, 57, 47, 2, 48, 59, 61, 60, 55, 49, 53, 73, 63, 12, 10, 37, 1, 24, 30, 35, 23}, (DSIListener)this.dsiCarDriverAssistanceListener);
    }

    private void registerOnSwaSystem() {
        if (!this.dsiNotificationDone) {
            this.dsiCarDriverAssistance.setNotification(new int[]{4}, (DSIListener)this.dsiCarDriverAssistanceListener);
            this.dsiNotificationDone = true;
        }
    }

    private void registerOnTrailer() {
        this.addObserver(1558262528);
    }

    private void registerOnComfort() {
        this.dsiCarComfort = (DSICarComfort)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$carcomfort$DSICarComfort == null ? (class$org$dsi$ifc$carcomfort$DSICarComfort = HsmTargetCarAssistants.class$("org.dsi.ifc.carcomfort.DSICarComfort")) : class$org$dsi$ifc$carcomfort$DSICarComfort);
        this.dsiCarComfort.setNotification(new int[]{4, 47, 48, 61}, ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$carcomfort$DSICarComfortListener == null ? (class$org$dsi$ifc$carcomfort$DSICarComfortListener = HsmTargetCarAssistants.class$("org.dsi.ifc.carcomfort.DSICarComfortListener")) : class$org$dsi$ifc$carcomfort$DSICarComfortListener));
    }

    private void registerOnKombi() {
        this.dsiCarKombi = (DSICarKombi)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$carkombi$DSICarKombi == null ? (class$org$dsi$ifc$carkombi$DSICarKombi = HsmTargetCarAssistants.class$("org.dsi.ifc.carkombi.DSICarKombi")) : class$org$dsi$ifc$carkombi$DSICarKombi);
        this.dsiCarKombi.setNotification(new int[]{20}, ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$carkombi$DSICarKombiListener == null ? (class$org$dsi$ifc$carkombi$DSICarKombiListener = HsmTargetCarAssistants.class$("org.dsi.ifc.carkombi.DSICarKombiListener")) : class$org$dsi$ifc$carkombi$DSICarKombiListener));
    }

    private void registerOnEco() {
        this.dsiCarEco = (DSICarEco)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$careco$DSICarEco == null ? (class$org$dsi$ifc$careco$DSICarEco = HsmTargetCarAssistants.class$("org.dsi.ifc.careco.DSICarEco")) : class$org$dsi$ifc$careco$DSICarEco);
        this.dsiCarEco.setNotification(new int[]{43}, ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$careco$DSICarEcoListener == null ? (class$org$dsi$ifc$careco$DSICarEcoListener = HsmTargetCarAssistants.class$("org.dsi.ifc.careco.DSICarEcoListener")) : class$org$dsi$ifc$careco$DSICarEcoListener));
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        if (this.isTraceEnabled()) {
            this.trace().append("Event for CarAssistants ").append(eventGeneric.getReceiverEventId()).log();
        }
        block0 : switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.dsiCarDriverAssistance = (DSICarDriverAssistance)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistance == null ? (class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistance = HsmTargetCarAssistants.class$("org.dsi.ifc.cardriverassistance.DSICarDriverAssistance")) : class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistance);
                this.dsiCarDriverAssistanceListener = (DSICarDriverAssistanceListener)ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistanceListener == null ? (class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistanceListener = HsmTargetCarAssistants.class$("org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener")) : class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistanceListener);
                this.trailerModeSpeedLimitTrailerCollector = new CarAssistantsTrailerModeSpeedThresholdCollector();
                this.vzeSpeedWarningThresholdCollector = new CarAssistantsVZESpeedWarningThresholdCollector();
                this.myRoadSignFilter = new TSDRoadSignFilter();
                this.myAwvEmergencyBrake = new AWVEmergencyBrake();
                this.current_hcaInterventionStyle = 0;
                this.registerModelEvents();
                this.registerOnDriverAssistance();
                this.registerOnComfort();
                this.registerOnKombi();
                this.registerOnEco();
                this.registerOnTrailer();
                this.initDefaultValues();
                this.registerServices(new int[]{705372160, 856367104}, true);
                this.informTrafficSignTrailerRouteCalculation(this.TRAILER_MODE_ROUTE_CALCULATION);
                break;
            }
            case 3400028: {
                if (this.isTraceEnabled()) {
                    this.trace().append("[INFO] Received Event from Nav, Trailer is considered : ").append(eventGeneric.getBoolean(0)).log();
                }
                this.setTrailerRouteCalculation(eventGeneric.getBoolean(0));
                break;
            }
            case 2100009: {
                this.VZA_VZE_SYSTEM = eventGeneric.getInt(0);
                break;
            }
            case 1073744932: {
                this.settingACCDistance(eventGeneric.getInt(0));
                break;
            }
            case 1073745123: {
                this.settingACCDrivingProgram(eventGeneric.getInt(0));
                break;
            }
            case 1073744935: {
                this.toggleAWVSystemActivity(!this.AWV_SYSTEM_ACTIVE);
                break;
            }
            case 1073744937: {
                this.toggleAWVAcoustics(!this.AWV_ACOUSTIC_SIGNAL_ACTIVE);
                break;
            }
            case 1073744936: {
                this.toggleAWVWarning(!this.AWV_WARNING_ACTIVE);
                break;
            }
            case 1073745120: {
                this.setAWVPreWarning(eventGeneric.getInt(0));
                break;
            }
            case 1073744940: {
                this.durationSWA = !eventGeneric.getBoolean(0) ? this.SWA_BRIGHTNESS_VALUE - 1 : this.SWA_BRIGHTNESS_VALUE + 1;
                this.deIncreaseSWABrightness(this.durationSWA);
                break;
            }
            case 1073744939: {
                this.settingSWABrightness(eventGeneric.getInt(0));
                break;
            }
            case 1073744944: {
                this.settingHCAForce(eventGeneric.getInt(0));
                break;
            }
            case 1073744941: {
                this.dsiCarDriverAssistance.setLDWHCASystemOnOff(!this.hcaSystemOnOff);
                break;
            }
            case 0x40000D40: {
                if (this.isTraceEnabled()) {
                    this.trace().append("Toggle HCA Vibration");
                }
                switch (this.current_hcaInterventionStyle) {
                    case 0: {
                        this.dsiCarDriverAssistance.setHCAInterventionStyle(1);
                        break block0;
                    }
                    case 1: {
                        this.dsiCarDriverAssistance.setHCAInterventionStyle(0);
                        break block0;
                    }
                }
                break;
            }
            case 1073744933: {
                this.toggleACCLastDistance(!this.ACC_IS_LAST_DISTANCE_ACTIVE);
                break;
            }
            case 1073744952: {
                this.toggleCityEmergencyBrake(!this.AUTO_EMERGENCY_BRAKE_ACTIVE);
                break;
            }
            case 1073744951: {
                this.toggleMKE(!this.MKE_ACTIVE);
                break;
            }
            case 1073744945: {
                this.toggleVzaInstrumentCluster(!this.TSD_ACTIVE);
                break;
            }
            case 1073744947: {
                this.togglePreCrash(!this.PRE_CRASH_ACTIVE);
                break;
            }
            case 1073744948: {
                this.settingUpAutoHold(eventGeneric.getInt(0));
                break;
            }
            case 1073745218: {
                this.settingUpESP(eventGeneric.getInt(0));
                break;
            }
            case 1073744949: {
                this.toggleAWVSystemActivity(!this.CITY_EMERGENCY_BRAKING_ACTIVE);
                break;
            }
            case 1073744943: {
                this.settingHCATime(!this.HCA_TIME);
                break;
            }
            case 1073744953: {
                if (this.isTraceEnabled()) {
                    this.trace().append("CarAssistants.TOGGLE_CURVES_ASSIST").log();
                }
                this.dsiCarDriverAssistance.setACCCurveAssist(!this.curveActive);
                break;
            }
            case 1073744938: 
            case 1073744966: {
                if (this.isTraceEnabled()) {
                    this.trace().append("CarAssistants.TOGGLE_BLIND_SPOT").log();
                }
                this.toggleSWAActivity(!this.SWA_ACTIVE);
                break;
            }
            case 1073744967: {
                if (this.isTraceEnabled()) {
                    this.trace().append("CarAssistants.TOGGLE_BLIND_SPOT_SOUND").log();
                }
                this.dsiCarDriverAssistance.setSWAGongState(!this.blindeSpotSoundActive);
                break;
            }
            case 1073744954: {
                if (this.isTraceEnabled()) {
                    this.trace().append("CarAssistants.TOGGLE_TAKE_OVER_SPEED").log();
                }
                this.dsiCarDriverAssistance.setACCSpeedLimitAdoption(!this.takeOverSpeedActive);
                break;
            }
            case 1073745217: {
                this.setAccSpeedLimitOffsetType(eventGeneric.getInt(0));
                break;
            }
            case 1073744959: {
                if (this.isTraceEnabled()) {
                    this.trace().append("CarAssistants.TOGGLE_PEDESTRIAN_PROTECTION").log();
                }
                this.dsiCarDriverAssistance.setPASystemOnOff(!this.pedestrianProtectionActive);
                break;
            }
            case 1073744961: {
                if (this.isTraceEnabled()) {
                    this.trace().append("CarAssistants.TOGGLE_PEDESTRIAN_PROTECTION_INFO").log();
                }
                this.dsiCarDriverAssistance.setPAConfigInformation(!this.pedestrianProtectionInformation);
                break;
            }
            case 0x40000C40: {
                if (this.isTraceEnabled()) {
                    this.trace().append("CarAssistants.TOGGLE_PEDESTRIAN_PROTECTION_WARNING").log();
                }
                this.dsiCarDriverAssistance.setPAConfigWarning(!this.pedestrianProtectionWarning);
                break;
            }
            case 1073745121: {
                if (this.isTraceEnabled()) {
                    this.trace().append("CarAssistants.SET_PEDESTRIAN_PROTECTION_PREWARNING").log();
                }
                this.setPedestrainProtectionPreWarning(eventGeneric.getInt(0));
                break;
            }
            case 1073744903: {
                if (this.isTraceEnabled()) {
                    this.trace().append("CarAssistants.TOGGLE_REAR_TRAFFIC_ALERT").log();
                }
                this.dsiCarDriverAssistance.setSWARCTA(!this.rearTrafficAlertActive);
                break;
            }
            case 1073745189: {
                this.vzeSpeedWarningThresholdMin = eventGeneric.getInt(2);
                this.vzeSpeedWarningThresholdMax = eventGeneric.getInt(3);
                this.deIncreaseSpeedWarningThreshold(eventGeneric.getBoolean(0), eventGeneric.getInt(1));
                break;
            }
            case 1073745188: {
                this.setSpeedWarningThreshold(eventGeneric.getInt(0));
                break;
            }
            case 1073745213: {
                this.setSpeedWarning(eventGeneric.getInt(0));
                break;
            }
            case 1073745204: {
                this.setSpeedThresholdTrailer(eventGeneric.getInt(0));
                break;
            }
            case 1073745205: {
                this.deIncreaseSpeedThresholdTrailer(eventGeneric.getBoolean(0), eventGeneric.getInt(1), eventGeneric.getInt(2));
                break;
            }
            case 1073745203: {
                this.setTrailerRouteCalculation(!this.TRAILER_MODE_ROUTE_CALCULATION);
                break;
            }
            case 1073745202: {
                switch (this.VZA_VZE_SYSTEM) {
                    case 2: {
                        this.setTrailerModeRoadSignFilter(!this.TRAILER_MODE_ROAD_SIGNS);
                        break block0;
                    }
                }
                break;
            }
            case 1073744866: {
                switch (eventGeneric.getInt(0)) {
                    case 0: 
                    case 1: {
                        switch (this.VZA_VZE_SYSTEM) {
                            case 2: {
                                this.resetTrailerOptions();
                                break block0;
                            }
                        }
                        break block0;
                    }
                }
                break;
            }
            case 1073743167: {
                switch (this.VZA_VZE_SYSTEM) {
                    case 2: {
                        this.resetTrailerOptions();
                        break block0;
                    }
                }
                break;
            }
            case 1073743166: {
                switch (eventGeneric.getInt(0)) {
                    case 2: {
                        switch (this.VZA_VZE_SYSTEM) {
                            case 2: {
                                this.resetTrailerOptions();
                                break block0;
                            }
                        }
                        break block0;
                    }
                }
                break;
            }
            case 1073745141: {
                this.dsiCarEco.setEASystem(!this.PEA_SYSTEM_ACTIVE);
                break;
            }
            case 1073745145: {
                this.dsiCarComfort.setBrakeHdcMode(!this.HDC_ACTIVESTATE);
                break;
            }
            case 1073745175: {
                this.dsiCarDriverAssistance.setNVObjectDetection(new NVObjectDetection(!this.nightVisionActive, !this.nightVisionActive));
                break;
            }
            case 1073745176: {
                this.settingNVContrast(eventGeneric.getInt(0));
                break;
            }
            case 1073745177: {
                this.increaseDecreaseNVContrast(eventGeneric.getBoolean(0));
                break;
            }
        }
    }

    private void setSpeedWarning(int n) {
        switch (n) {
            case 0: {
                this.dsiCarDriverAssistance.setTSDSpeedWarningThreshold(false, this.tsdBCSpeed);
                this.dsiCarDriverAssistance.setTSDSpeedWarningAcoustics(false);
                break;
            }
            case 1: {
                this.dsiCarDriverAssistance.setTSDSpeedWarningThreshold(true, this.tsdBCSpeed);
                this.dsiCarDriverAssistance.setTSDSpeedWarningAcoustics(false);
                break;
            }
            case 2: {
                this.dsiCarDriverAssistance.setTSDSpeedWarningThreshold(true, this.tsdBCSpeed);
                this.dsiCarDriverAssistance.setTSDSpeedWarningAcoustics(true);
                break;
            }
        }
    }

    private void deIncreaseSpeedWarningThreshold(boolean bl, int n) {
        float f2 = bl ? this.tsdBCSpeed.speedValue + (float)n : this.tsdBCSpeed.speedValue - (float)n;
        f2 = Math.min((float)this.vzeSpeedWarningThresholdMax, Math.max((float)this.vzeSpeedWarningThresholdMin, f2));
        this.setSpeedWarningThreshold(f2);
    }

    private void settingACCDrivingProgram(int n) {
        switch (n) {
            case 0: {
                if (this.isTraceEnabled()) {
                    this.trace().append("[INFO] Driving program is ECO").log();
                }
                this.sendingACCDrivingProgram(3);
                break;
            }
            case 2: {
                if (this.isTraceEnabled()) {
                    this.trace().append("[INFO] Driving program is NORMAL").log();
                }
                this.sendingACCDrivingProgram(1);
                break;
            }
            case 3: {
                if (this.isTraceEnabled()) {
                    this.trace().append("[INFO] Driving program is SPORT").log();
                }
                this.sendingACCDrivingProgram(2);
                break;
            }
            case 1: {
                if (this.isTraceEnabled()) {
                    this.trace().append("[INFO] Driving program is COMFORT").log();
                }
                this.sendingACCDrivingProgram(0);
                break;
            }
            default: {
                if (!this.isTraceEnabled()) break;
                this.trace().append("[INFO] driving program does not exists!").log();
            }
        }
    }

    private void settingNVContrast(int n) {
        int n2 = Math.min(95, Math.max(5, n));
        this.dsiCarDriverAssistance.setNVContrast(n2);
    }

    private void sendingACCDrivingProgram(int n) {
        this.dsiCarDriverAssistance.setACCDrivingProgram(n);
    }

    private void toggleAWVSystemActivity(boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace().append("[INFO] toggle AWV system activity: ").append(bl).log();
        }
        this.dsiCarDriverAssistance.setAWVSystem(bl ? 1 : 0);
    }

    private void toggleAWVAcoustics(boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace().append("[INFO] toggle AWV acoustic: ").append(bl).log();
        }
        this.dsiCarDriverAssistance.setAWVDistanceWarning(bl);
    }

    private void toggleAWVWarning(boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace().append("[INFO] toggle AWV warning: ").append(bl).log();
        }
        this.dsiCarDriverAssistance.setAWVWarning(bl);
    }

    private void setAWVPreWarning(int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("[INFO] setting AWV prewarning: ").append(n).log();
        }
        switch (n) {
            case 0: {
                this.dsiCarDriverAssistance.setAWVWarningTimegap(3);
                break;
            }
            case 1: {
                this.dsiCarDriverAssistance.setAWVWarningTimegap(2);
                break;
            }
            case 2: {
                this.dsiCarDriverAssistance.setAWVWarningTimegap(1);
                break;
            }
            case 3: {
                this.dsiCarDriverAssistance.setAWVWarningTimegap(0);
                break;
            }
        }
    }

    private void settingSWABrightness(int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("[INFO] value for SWA brightness: ").append(n).log();
        }
        this.dsiCarDriverAssistance.setSWABrightness(n - 1);
    }

    private void deIncreaseSWABrightness(int n) {
        if (n >= 1 && n <= 5) {
            this.settingSWABrightness(n);
        }
    }

    private void settingHCATime(boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace().append("[INFO] selected HCA time is: ").append(bl).log();
        }
        this.sendingHCAToleranceLevel(bl ? 0 : 2);
    }

    private void sendingHCAToleranceLevel(int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("[INFO] sending HCA time is: ").append(n).log();
        }
        this.dsiCarDriverAssistance.setHCAToleranceLevel(n);
    }

    private void settingHCAForce(int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("[INFO] selected HCA force is: ").append(n).log();
        }
        switch (n) {
            case 0: {
                this.sendingLDWSteeringWheelVibration(0);
                break;
            }
            case 1: {
                this.sendingLDWSteeringWheelVibration(1);
                break;
            }
            case 2: {
                this.sendingLDWSteeringWheelVibration(2);
                break;
            }
            default: {
                if (!this.isTraceEnabled()) break;
                this.trace().append("[INFO] This selection does not exists!").log();
            }
        }
    }

    private void sendingLDWSteeringWheelVibration(int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("[INFO] selected HCA force is: ").append(n).log();
        }
        this.dsiCarDriverAssistance.setLDWSteeringWheelVibration(n);
    }

    private void setTrailerModeRoadSignFilter(boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace().append("[INFO] Trailer Mode RoadSign Filter: ").append(bl).log();
        }
        this.myRoadSignFilter.trailerLimits = bl;
        this.dsiCarDriverAssistance.setTSDRoadSignFilter(this.myRoadSignFilter);
    }

    private void settingACCDistance(int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("[INFO] acc distance is: ").append(n).log();
        }
        switch (n) {
            case 0: {
                this.sendingACCTimeGap(0);
                break;
            }
            case 1: {
                this.sendingACCTimeGap(1);
                break;
            }
            case 2: {
                this.sendingACCTimeGap(2);
                break;
            }
            case 3: {
                this.sendingACCTimeGap(3);
                break;
            }
            case 4: {
                this.sendingACCTimeGap(4);
                break;
            }
            default: {
                if (!this.isTraceEnabled()) break;
                this.trace().append("ACC distance not in selection").log();
            }
        }
    }

    private void sendingACCTimeGap(int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("[INFO] acc distance is sending: ").append(n).log();
        }
        this.dsiCarDriverAssistance.setACCTimeGap(n);
    }

    private void toggleACCLastDistance(boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace().append("[INFO] acc last distance is sending: ").append(bl).log();
        }
        this.dsiCarDriverAssistance.setACCDefaultMode(bl ? 1 : 0);
    }

    private void togglePreCrash(boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace().append("[INFO] is RGS pre crash system is active: ").append(bl).log();
        }
        this.dsiCarComfort.setRGSPreCrashSystem(bl);
    }

    private void toggleCityEmergencyBrake(boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace().append("[INFO] is AWVEmergencyBrake is active: ").append(bl).log();
        }
        this.myAwvEmergencyBrake.targetBrake = bl;
        this.dsiCarDriverAssistance.setAWVEmergencyBrake(this.myAwvEmergencyBrake);
    }

    private void toggleMKE(boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace().append("[INFO] is mke system is active: ").append(bl).log();
        }
        this.dsiCarDriverAssistance.setMKESystemOnOff(bl);
    }

    private void toggleVzaInstrumentCluster(boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace().append("[INFO] is VZA in instrument cluster is active: ").append(bl).log();
        }
        this.dsiCarKombi.setBCVZADisplay(bl);
    }

    private void toggleSWAActivity(boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace().append("[INFO] is swa active: ").append(bl).log();
        }
        this.dsiCarDriverAssistance.setSWASystem(bl ? 1 : 0);
    }

    private void settingUpAutoHold(int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("[INFO] selection of auto hold: ").append(n).log();
        }
        switch (n) {
            case 0: {
                this.dsiCarComfort.setBrakeAutoHold(1);
                break;
            }
            case 1: {
                this.dsiCarComfort.setBrakeAutoHold(0);
                break;
            }
            case 2: {
                this.dsiCarComfort.setBrakeAutoHold(2);
                break;
            }
        }
    }

    private void settingUpESP(int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("[INFO] selection of ESP: ").append(n).log();
        }
        switch (n) {
            case 0: {
                this.dsiCarComfort.setBrakeEscMode(3);
                break;
            }
            case 1: {
                this.dsiCarComfort.setBrakeEscMode(2);
                break;
            }
            case 2: {
                this.dsiCarComfort.setBrakeEscMode(1);
                break;
            }
            case 4: {
                this.dsiCarComfort.setBrakeEscMode(0);
                break;
            }
            case 3: {
                this.dsiCarComfort.setBrakeEscMode(4);
                break;
            }
        }
    }

    private void setAccSpeedLimitOffsetType(int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("[INFO] setting speed limit offset type: ").append(n).log();
        }
        this.dsiCarDriverAssistance.setACCSpeedLimitOffset(n);
    }

    private void deIncreaseSpeedThresholdTrailer(boolean bl, int n, int n2) {
        if (bl) {
            this.duration = this.trailerModeSpeedLimitTrailerCollector.car_assistants_trailer_mode_speed_threshold_value + n;
            if (this.duration <= n2) {
                this.setSpeedThresholdTrailer(this.duration);
            }
        } else {
            this.duration = this.trailerModeSpeedLimitTrailerCollector.car_assistants_trailer_mode_speed_threshold_value - n;
            if (this.duration >= n2) {
                this.setSpeedThresholdTrailer(this.duration);
            }
        }
    }

    private void setSpeedThresholdTrailer(int n) {
        this.trailerModeSpeedLimitTrailerCollector.car_assistants_trailer_mode_speed_threshold_value = n;
        this.dsiCarDriverAssistance.setTSDTrailerSpeedLimit(new CarBCSpeed(1, this.trailerModeSpeedLimitTrailerCollector.car_assistants_trailer_mode_speed_threshold_value, this.trailerModeSpeedLimitTrailerCollector.car_assistants_trailer_mode_speed_threshold_unit == 0 ? 0 : 1));
    }

    private void setPedestrainProtectionPreWarning(int n) {
        switch (n) {
            case 0: {
                this.dsiCarDriverAssistance.setPAWarningTimegap(3);
                break;
            }
            case 1: {
                this.dsiCarDriverAssistance.setPAWarningTimegap(2);
                break;
            }
            case 2: {
                this.dsiCarDriverAssistance.setPAWarningTimegap(1);
                break;
            }
            case 3: {
                this.dsiCarDriverAssistance.setPAWarningTimegap(0);
                break;
            }
        }
    }

    public void dsiCarDriverAssistanceUpdateACCDrivingProgram(int n, int n2) {
        if (this.isTraceEnabled()) {
            this.trace().append("[INFO] getting update from DSI for DRIVING PROGRAM").log();
        }
        switch (n) {
            case 3: {
                HsmTargetCarAssistants.writeIntegerToDatapool(10477, 0);
                break;
            }
            case 1: {
                HsmTargetCarAssistants.writeIntegerToDatapool(10477, 2);
                break;
            }
            case 2: {
                HsmTargetCarAssistants.writeIntegerToDatapool(10477, 3);
                break;
            }
            case 0: {
                HsmTargetCarAssistants.writeIntegerToDatapool(10477, 1);
                break;
            }
            default: {
                if (!this.isTraceEnabled()) break;
                this.trace().append("[ERROR] wrong update for driving program").log();
            }
        }
    }

    public void dsiCarDriverAssistanceUpdateAWVSystem(int n, int n2) {
        if (this.isTraceEnabled()) {
            this.trace().append("[INFO] getting update from DSI for AWV system is active or not").log();
        }
        this.currentStateAwv = n;
        this.evaluateAwvSystem();
    }

    public void dsiCarDriverAssistanceUpdateAWVDistanceWarning(boolean bl, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("[INFO] getting update from DSI for AWV DISTANCE WARNING").log();
        }
        this.AWV_ACOUSTIC_SIGNAL_ACTIVE = bl;
        HsmTargetCarAssistants.writeBooleanToDatapool(10219, this.AWV_ACOUSTIC_SIGNAL_ACTIVE);
    }

    public void dsiCarDriverAssistanceUpdateAWVWarning(boolean bl, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("[INFO] getting update from DSI for AWV WARNING").log();
        }
        this.AWV_WARNING_ACTIVE = bl;
        HsmTargetCarAssistants.writeBooleanToDatapool(10220, this.AWV_WARNING_ACTIVE);
    }

    public void dsiCarDriverAssistanceUpdateAWVWarningTimegap(int n, int n2) {
        switch (n) {
            case 0: {
                HsmTargetCarAssistants.writeIntegerToDatapool(10478, 3);
                break;
            }
            case 1: {
                HsmTargetCarAssistants.writeIntegerToDatapool(10478, 2);
                break;
            }
            case 2: {
                HsmTargetCarAssistants.writeIntegerToDatapool(10478, 1);
                break;
            }
            case 3: {
                HsmTargetCarAssistants.writeIntegerToDatapool(10478, 0);
                break;
            }
        }
    }

    public void dsiCarDriverAssistanceUpdateSWABrightness(int n, int n2) {
        if (this.isTraceEnabled()) {
            this.trace().append("[INFO] getting update from DSI for SWA BRIGHTNESS").log();
        }
        this.SWA_BRIGHTNESS_VALUE = n + 1;
        HsmTargetCarAssistants.writeIntegerToDatapool(10222, n + 1);
    }

    public void dsiCarDriverAssistanceUpdateHCAToleranceLevel(int n, int n2) {
        if (this.isTraceEnabled()) {
            this.trace().append("[INFO] getting update for HCA TIME").log();
        }
        switch (n) {
            case 0: {
                this.HCA_TIME = true;
                HsmTargetCarAssistants.writeBooleanToDatapool(10225, this.HCA_TIME);
                break;
            }
            case 2: {
                this.HCA_TIME = false;
                HsmTargetCarAssistants.writeBooleanToDatapool(10225, this.HCA_TIME);
                break;
            }
            default: {
                if (!this.isTraceEnabled()) break;
                this.trace().append("[ERROR] wrong update for HCA time").log();
            }
        }
    }

    public void dsiCarDriverAssistanceUpdateLDWSteeringWheelVibration(int n, int n2) {
        if (this.isTraceEnabled()) {
            this.trace().append("[INFO] getting update for LDW Steering Vibration Level").log();
        }
        switch (n) {
            case 0: {
                HsmTargetCarAssistants.writeIntegerToDatapool(10226, 0);
                break;
            }
            case 1: {
                HsmTargetCarAssistants.writeIntegerToDatapool(10226, 1);
                break;
            }
            case 2: {
                HsmTargetCarAssistants.writeIntegerToDatapool(10226, 2);
                break;
            }
            default: {
                if (!this.isTraceEnabled()) break;
                this.trace().append("[ERROR] wrong update for LDW Steering Vibration force").log();
            }
        }
    }

    public void dsiCarDriverAssistanceUpdateHCAInterventionStyle(int n, int n2) {
        if (this.isTraceEnabled()) {
            this.trace().append(new StringBuffer().append("[INFO] getting update for LDW Steering Vibration State. New State = ").append(n).toString()).log();
        }
        switch (n) {
            case 0: {
                this.current_hcaInterventionStyle = n;
                HsmTargetCarAssistants.writeBooleanToDatapool(10841, false);
                break;
            }
            case 1: {
                this.current_hcaInterventionStyle = n;
                HsmTargetCarAssistants.writeBooleanToDatapool(10841, true);
                break;
            }
        }
    }

    public void dsiCarDriverAssistanceUpdateTSDRoadSignFilter(TSDRoadSignFilter tSDRoadSignFilter, int n) {
        this.TRAILER_MODE_ROAD_SIGNS = tSDRoadSignFilter.isTrailerLimits();
        HsmTargetCarAssistants.writeBooleanToDatapool(10621, this.TRAILER_MODE_ROAD_SIGNS);
    }

    public void dsiCarDriverAssistanceUpdateTSDTrailerDetection(boolean bl, int n) {
        this.informTrafficSignTrailerDetectionAvailable(bl);
    }

    public void dsiCarDriverAssistanceUpdateACCTimeGap(int n, int n2) {
        switch (n) {
            case 0: {
                HsmTargetCarAssistants.writeIntegerToDatapool(10215, 0);
                break;
            }
            case 1: {
                HsmTargetCarAssistants.writeIntegerToDatapool(10215, 1);
                break;
            }
            case 2: {
                HsmTargetCarAssistants.writeIntegerToDatapool(10215, 2);
                break;
            }
            case 3: {
                HsmTargetCarAssistants.writeIntegerToDatapool(10215, 3);
                break;
            }
            case 4: {
                HsmTargetCarAssistants.writeIntegerToDatapool(10215, 4);
                break;
            }
            default: {
                if (!this.isTraceEnabled()) break;
                this.trace().append("ACC distance: selection does not match").log();
            }
        }
    }

    public void dsiCarDriverAssistanceUpdateACCDefaultMode(int n, int n2) {
        this.ACC_IS_LAST_DISTANCE_ACTIVE = n != 0;
        HsmTargetCarAssistants.writeBooleanToDatapool(10216, this.ACC_IS_LAST_DISTANCE_ACTIVE);
    }

    public void dsiCarDriverAssistanceUpdateAWVEmergencyBrake(AWVEmergencyBrake aWVEmergencyBrake, int n) {
        this.AUTO_EMERGENCY_BRAKE_ACTIVE = aWVEmergencyBrake.isTargetBrake();
        HsmTargetCarAssistants.writeBooleanToDatapool(10235, this.AUTO_EMERGENCY_BRAKE_ACTIVE);
    }

    public void dsiCarDriverAssistanceUpdateMKESystemOnOff(boolean bl, int n) {
        this.MKE_ACTIVE = bl;
        HsmTargetCarAssistants.writeBooleanToDatapool(10234, this.MKE_ACTIVE);
    }

    public void dsiCarDriverAssistanceUpdateSWASystem(int n, int n2) {
        this.SWA_ACTIVE = n == 1;
        switch (this.SWA_SYSTEM) {
            case 0: {
                HsmTargetCarAssistants.writeBooleanToDatapool(10221, this.SWA_ACTIVE);
                break;
            }
            case 1: {
                HsmTargetCarAssistants.writeBooleanToDatapool(10238, this.SWA_ACTIVE);
                break;
            }
        }
    }

    public void dsiCarDriverAssistanceUpdateLDWHCASystemOnOff(boolean bl, int n) {
        this.hcaSystemOnOff = bl;
        HsmTargetCarAssistants.writeBooleanToDatapool(10223, this.hcaSystemOnOff);
    }

    public void dsiCarDriverAssistanceUpdateACCCurveAssist(boolean bl, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("CarDriveAssist.CurveOn ").append(bl).append(n).log();
        }
        this.curveActive = bl;
        HsmTargetCarAssistants.writeBooleanToDatapool(10236, this.curveActive);
    }

    public void dsiCarDriverAssistanceUpdatePASystemOnOff(boolean bl, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("CarDriveAssist.PASystem ").append(bl).append(n).log();
        }
        this.pedestrianProtectionActive = bl;
        HsmTargetCarAssistants.writeBooleanToDatapool(10241, this.pedestrianProtectionActive);
    }

    public void dsiCarDriverAssistanceUpdatePAConfigInformation(boolean bl, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("CarDriveAssist.PAInfo ").append(bl).append(n).log();
        }
        this.pedestrianProtectionInformation = bl;
        HsmTargetCarAssistants.writeBooleanToDatapool(10243, this.pedestrianProtectionInformation);
    }

    public void dsiCarDriverAssistanceUpdatePAConfigWarning(boolean bl, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("CarDriveAssist.PAWarn ").append(bl).append(n).log();
        }
        this.pedestrianProtectionWarning = bl;
        HsmTargetCarAssistants.writeBooleanToDatapool(10242, this.pedestrianProtectionWarning);
    }

    public void dsiCarDriverAssistanceUpdateSWAGongState(boolean bl, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("CarDriveAssist.SWAGongState ").append(bl).append(n).log();
        }
        this.blindeSpotSoundActive = bl;
        HsmTargetCarAssistants.writeBooleanToDatapool(10239, this.blindeSpotSoundActive);
    }

    public void dsiCarDriverAssistanceUpdateACCSpeedLimitAdoption(boolean bl, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("CarDriveAssist.ACCSpeedLimitAdoption ").append(bl).append(n).log();
        }
        this.takeOverSpeedActive = bl;
        HsmTargetCarAssistants.writeBooleanToDatapool(10237, this.takeOverSpeedActive);
    }

    public void dsiCarDriverAssistanceUpdateSWARCTA(boolean bl, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("CarDriveAssist.rearTrafficAlert ").append(bl).append(n).log();
        }
        this.rearTrafficAlertActive = bl;
        HsmTargetCarAssistants.writeBooleanToDatapool(10169, bl);
    }

    public void dsiCarDriverAssistanceUpdateTSDSpeedWarningThreshold(boolean bl, CarBCSpeed carBCSpeed, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("CarDriveAssist.TSDSpeedWarningThreshold ").append(bl).append((int)carBCSpeed.speedValue).append(n).log();
        }
        this.tsdBCSpeed = carBCSpeed;
        this.isVZESpeedWarningThresholdActive = bl;
        this.evaluateSelectedTSDSpeedWarningEntry();
        this.vzeSpeedWarningThresholdCollector.car_assistants_vze_speed_warning_threshold_value = (int)carBCSpeed.speedValue;
        this.vzeSpeedWarningThresholdCollector.car_assistants_vze_speed_warning_threshold_unit = carBCSpeed.speedUnit;
        ListManager.getGenericASLList(10594).updateList(new CarAssistantsVZESpeedWarningThresholdCollector[]{this.vzeSpeedWarningThresholdCollector});
    }

    public void dsiCarDriverAssistanceUpdateTSDSpeedWarningAcoustics(boolean bl, int n) {
        this.isVZEAcousticsActive = bl;
        this.evaluateSelectedTSDSpeedWarningEntry();
    }

    private void evaluateSelectedTSDSpeedWarningEntry() {
        int n;
        if (!this.isVZESpeedWarningThresholdActive) {
            n = 0;
            HsmTargetCarAssistants.writeBooleanToDatapool(10820, false);
        } else {
            n = this.isVZEAcousticsActive || this.tsdAcousticWarningState != 2 ? 2 : 1;
            HsmTargetCarAssistants.writeBooleanToDatapool(10820, true);
        }
        HsmTargetCarAssistants.writeIntegerToDatapool(10593, n);
    }

    public void dsiCarDriverAssistanceUpdateTSDViewOptions(TSDViewOptions tSDViewOptions, int n) {
        if (tSDViewOptions.getSpeedWarnAcoustics().getState() == 2) {
            this.dsiCarDriverAssistance.setNotification(new int[]{76}, (DSIListener)this.dsiCarDriverAssistanceListener);
        } else {
            this.dsiCarDriverAssistance.clearNotification(new int[]{76}, (DSIListener)this.dsiCarDriverAssistanceListener);
        }
        if (tSDViewOptions.getSpeedWarningThreshold().getState() == 2) {
            this.dsiCarDriverAssistance.setNotification(new int[]{52}, (DSIListener)this.dsiCarDriverAssistanceListener);
        } else {
            this.dsiCarDriverAssistance.clearNotification(new int[]{52}, (DSIListener)this.dsiCarDriverAssistanceListener);
        }
        if (tSDViewOptions.getSpeedWarnAcoustics().getState() != 2 && !this.isVZEAcousticsActive && this.isVZESpeedWarningThresholdActive) {
            this.isVZEAcousticsActive = false;
            HsmTargetCarAssistants.writeIntegerToDatapool(10593, 2);
        }
        this.tsdAcousticWarningState = tSDViewOptions.getSpeedWarnAcoustics().getState();
    }

    public void dsiCarDriverAssistanceUpdateACCSpeedLimitOffset(int n, int n2) {
        HsmTargetCarAssistants.writeIntegerToDatapool(10845, n);
    }

    public void dsiCarDriverAssistanceUpdateTSDTrailerSpeedLimit(CarBCSpeed carBCSpeed, int n) {
        switch (carBCSpeed.getSpeedValueState()) {
            case 1: {
                if (carBCSpeed.getSpeedValue() <= 0.0f) {
                    this.trailerSpeedLimit(carBCSpeed.getSpeedUnit() == 0 ? 28738 : 3138, carBCSpeed.getSpeedUnit() == 0 ? 0 : 1);
                    break;
                }
                if (carBCSpeed.getSpeedUnit() == 0) {
                    if (carBCSpeed.getSpeedValue() % 8257 == 0.0f && carBCSpeed.getSpeedValue() >= 28738 && carBCSpeed.getSpeedValue() <= 579) {
                        this.trailerSpeedLimit(carBCSpeed.getSpeedValue(), carBCSpeed.getSpeedUnit() == 0 ? 0 : 1);
                    } else {
                        carBCSpeed.speedValue = (int)(Math.round((double)carBCSpeed.getSpeedValue() / 10.0) * 0);
                        if (carBCSpeed.getSpeedValue() < 28738) {
                            carBCSpeed.speedValue = 28738;
                        }
                        if (carBCSpeed.getSpeedValue() > 579) {
                            carBCSpeed.speedValue = 579;
                        }
                        this.dsiCarDriverAssistance.setTSDTrailerSpeedLimit(new CarBCSpeed(1, carBCSpeed.getSpeedValue(), carBCSpeed.getSpeedUnit()));
                    }
                } else if ((carBCSpeed.getSpeedValue() % 8257 == 0.0f || carBCSpeed.getSpeedValue() % 8257 == 41024) && carBCSpeed.getSpeedValue() >= 3138 && carBCSpeed.getSpeedValue() <= 41026) {
                    this.trailerSpeedLimit(carBCSpeed.getSpeedValue(), carBCSpeed.getSpeedUnit());
                } else {
                    carBCSpeed.speedValue = (int)(Math.round((double)carBCSpeed.getSpeedValue() / 10.0) * 0);
                    if (carBCSpeed.getSpeedValue() < 3138) {
                        carBCSpeed.speedValue = 3138;
                    }
                    if (carBCSpeed.getSpeedValue() > 41026) {
                        carBCSpeed.speedValue = 41026;
                    }
                    this.dsiCarDriverAssistance.setTSDTrailerSpeedLimit(new CarBCSpeed(1, carBCSpeed.getSpeedValue(), carBCSpeed.getSpeedUnit()));
                }
                this.trailerSpeedLimit(carBCSpeed.getSpeedValue(), carBCSpeed.getSpeedUnit() == 0 ? 0 : 1);
                break;
            }
            default: {
                this.trailerSpeedLimit(41026, 0);
            }
        }
    }

    private void trailerSpeedLimit(float f2, int n) {
        this.trailerModeSpeedLimitTrailerCollector.car_assistants_trailer_mode_speed_threshold_value = (int)f2;
        this.trailerModeSpeedLimitTrailerCollector.car_assistants_trailer_mode_speed_threshold_unit = n;
        ListManager.getGenericASLList(10617).updateList(new CarAssistantsTrailerModeSpeedThresholdCollector[]{this.trailerModeSpeedLimitTrailerCollector});
    }

    public void dsiCarDriverAssistanceUpdatePAWarningTimegap(int n, int n2) {
        switch (n) {
            case 3: {
                HsmTargetCarAssistants.writeIntegerToDatapool(10479, 0);
                break;
            }
            case 2: {
                HsmTargetCarAssistants.writeIntegerToDatapool(10479, 1);
                break;
            }
            case 1: {
                HsmTargetCarAssistants.writeIntegerToDatapool(10479, 2);
                break;
            }
            case 0: {
                HsmTargetCarAssistants.writeIntegerToDatapool(10479, 3);
                break;
            }
        }
    }

    public void dsiCarComfortUpdateBrakeAutoHold(int n, int n2) {
        switch (n) {
            case 2: {
                HsmTargetCarAssistants.writeIntegerToDatapool(10230, 2);
                break;
            }
            case 0: {
                HsmTargetCarAssistants.writeIntegerToDatapool(10230, 1);
                break;
            }
            case 1: {
                HsmTargetCarAssistants.writeIntegerToDatapool(10230, 0);
                break;
            }
        }
    }

    public void dsiCarComfortUpdateBrakeEscMode(int n, int n2) {
        switch (n) {
            case 3: {
                HsmTargetCarAssistants.writeIntegerToDatapool(10853, 0);
                break;
            }
            case 0: {
                HsmTargetCarAssistants.writeIntegerToDatapool(10853, 4);
                break;
            }
            case 1: {
                HsmTargetCarAssistants.writeIntegerToDatapool(10853, 2);
                break;
            }
            case 2: {
                HsmTargetCarAssistants.writeIntegerToDatapool(10853, 1);
                break;
            }
            case 4: {
                HsmTargetCarAssistants.writeIntegerToDatapool(10853, 3);
                break;
            }
        }
    }

    public void dsiCarComfortUpdateRGSPreCrashSystem(boolean bl, int n) {
        this.PRE_CRASH_ACTIVE = bl;
        HsmTargetCarAssistants.writeBooleanToDatapool(10229, this.PRE_CRASH_ACTIVE);
    }

    public void dsiCarKombiUpdateBCVZADisplay(boolean bl, int n) {
        this.TSD_ACTIVE = bl;
        HsmTargetCarAssistants.writeBooleanToDatapool(10227, this.TSD_ACTIVE);
    }

    public void dsiCarEcoUpdateEASystem(boolean bl, int n) {
        this.PEA_SYSTEM_ACTIVE = bl;
        HsmTargetCarAssistants.writeBooleanToDatapool(10525, this.PEA_SYSTEM_ACTIVE);
    }

    public void dsiCarComfortUpdateBrakeHdcMode(boolean bl, int n) {
        this.HDC_ACTIVESTATE = bl;
        HsmTargetCarAssistants.writeBooleanToDatapool(10543, this.HDC_ACTIVESTATE);
    }

    public void dsiCarDriverAssistanceUpdateNVContrast(int n, int n2) {
        this.nightVisionContrast = n;
        HsmTargetCarAssistants.writeIntegerToDatapool(10575, n);
    }

    public void dsiCarDriverAssistanceUpdateNVObjectDetection(NVObjectDetection nVObjectDetection, int n) {
        this.nightVisionActive = nVObjectDetection.pedestrianDetection || nVObjectDetection.animalDetection;
        HsmTargetCarAssistants.writeBooleanToDatapool(10574, this.nightVisionActive);
    }

    private void evaluateAwvSystem() {
        switch (this.currentStateAwv) {
            case 0: {
                if (this.awvSystemMode == 1) {
                    this.AWV_SYSTEM_ACTIVE = false;
                    HsmTargetCarAssistants.writeBooleanToDatapool(10218, false);
                    break;
                }
                this.CITY_EMERGENCY_BRAKING_ACTIVE = false;
                HsmTargetCarAssistants.writeBooleanToDatapool(10231, this.CITY_EMERGENCY_BRAKING_ACTIVE);
                break;
            }
            case 1: {
                if (this.awvSystemMode == 1) {
                    this.AWV_SYSTEM_ACTIVE = true;
                    HsmTargetCarAssistants.writeBooleanToDatapool(10218, true);
                    break;
                }
                this.CITY_EMERGENCY_BRAKING_ACTIVE = true;
                HsmTargetCarAssistants.writeBooleanToDatapool(10231, this.CITY_EMERGENCY_BRAKING_ACTIVE);
                break;
            }
            default: {
                if (!this.isTraceEnabled()) break;
                this.trace().append("[ERROR] wrong update for AWV system (activity)").log();
            }
        }
    }

    private void setTrailerRouteCalculation(boolean bl) {
        CarPersistenceServiceImpl.getInstance().loadCar().setTrailerModeRouteCalculation(bl);
        this.TRAILER_MODE_ROUTE_CALCULATION = CarPersistenceServiceImpl.getInstance().loadCar().isTrailerModeRouteCalculation();
        HsmTargetCarAssistants.writeBooleanToDatapool(10622, this.TRAILER_MODE_ROUTE_CALCULATION);
        this.informTrafficSignTrailerRouteCalculation(this.TRAILER_MODE_ROUTE_CALCULATION);
    }

    private void setSpeedWarningThreshold(float f2) {
        this.tsdBCSpeed.speedValue = (int)f2;
        this.dsiCarDriverAssistance.setTSDSpeedWarningThreshold(this.tsdBCSpeed.speedValueState == 1, this.tsdBCSpeed);
    }

    private void initDefaultValues() {
        this.AWV_SYSTEM_ACTIVE = false;
        this.AWV_ACOUSTIC_SIGNAL_ACTIVE = false;
        this.AWV_WARNING_ACTIVE = false;
        this.SWA_BRIGHTNESS_VALUE = 3;
        this.TRAILER_MODE_ROAD_SIGNS = true;
        this.ACC_IS_LAST_DISTANCE_ACTIVE = false;
        this.PRE_CRASH_ACTIVE = false;
        this.AUTO_EMERGENCY_BRAKE_ACTIVE = false;
        this.MKE_ACTIVE = false;
        this.TSD_ACTIVE = false;
        this.SWA_ACTIVE = false;
        this.CITY_EMERGENCY_BRAKING_ACTIVE = false;
        this.HCA_TIME = false;
        this.HDC_ACTIVESTATE = false;
        ListManager.getGenericASLList(10617).updateList(new CarAssistantsTrailerModeSpeedThresholdCollector[]{this.trailerModeSpeedLimitTrailerCollector});
        this.PEA_SYSTEM_ACTIVE = false;
        this.setTrailerRouteCalculation(CarPersistenceServiceImpl.getInstance().loadCar().isTrailerModeRouteCalculation());
        HsmTargetCarAssistants.writeBooleanToDatapool(10621, this.TRAILER_MODE_ROAD_SIGNS);
    }

    private void increaseDecreaseNVContrast(boolean bl) {
        if (bl) {
            this.settingNVContrast(this.nightVisionContrast + 5);
        } else {
            this.settingNVContrast(this.nightVisionContrast - 5);
        }
    }

    private void informTrafficSignTrailerRouteCalculation(boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace().append("HsmTargetCarAssistants TrailerMode: trailer considered in calculations set to ").append(bl).log();
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setBoolean(0, bl);
        this.triggerObserver(705372160, eventGeneric);
    }

    private void informTrafficSignTrailerDetectionAvailable(boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace().append("HsmTargetCarAssistants TrailerMode: trailer detected is ").append(bl).log();
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setBoolean(0, bl);
        this.triggerObserver(856367104, eventGeneric);
    }

    private void resetTrailerOptions() {
        this.setTrailerRouteCalculation(true);
    }

    public void dsiCarDriverAssistanceUpdateSWAViewOptions(SWAViewOptions sWAViewOptions, int n) {
        this.SWA_SYSTEM = sWAViewOptions.getConfiguration().getSystem();
        if (sWAViewOptions.getSystem().getState() != 0) {
            this.registerOnSwaSystem();
        }
    }

    public void dsiCarDriverAssistanceUpdateACCViewOptions(ACCViewOptions aCCViewOptions, int n) {
        if (!(aCCViewOptions.getConfiguration().getDrivingPrograms().isEco() || aCCViewOptions.getConfiguration().getDrivingPrograms().isComfort() || aCCViewOptions.getConfiguration().getDrivingPrograms().isDynamic())) {
            this.accDrivingPrograms[0] = true;
            this.accDrivingPrograms[2] = true;
            this.accDrivingPrograms[3] = true;
            this.accDrivingPrograms[1] = false;
            ServiceManager.aslPropertyManager.valueChangedFlagVector(10475, this.accDrivingPrograms);
        } else {
            this.accDrivingPrograms[0] = aCCViewOptions.getConfiguration().getDrivingPrograms().isEco();
            this.accDrivingPrograms[2] = aCCViewOptions.getConfiguration().getDrivingPrograms().isStandard();
            this.accDrivingPrograms[3] = aCCViewOptions.getConfiguration().getDrivingPrograms().isDynamic();
            this.accDrivingPrograms[1] = aCCViewOptions.getConfiguration().getDrivingPrograms().isComfort();
            ServiceManager.aslPropertyManager.valueChangedFlagVector(10475, this.accDrivingPrograms);
            int n2 = 0;
            for (int i2 = 0; i2 < this.accDrivingPrograms.length; ++i2) {
                if (!this.accDrivingPrograms[i2]) continue;
                ++n2;
            }
            if (n2 < 2) {
                // empty if block
            }
        }
    }

    public void dsiCarDriverAssistanceUpdateAWVViewOptions(AWVViewOptions aWVViewOptions, int n) {
        this.awvSystemMode = aWVViewOptions.getConfiguration().getSystemMode();
        this.evaluateAwvSystem();
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


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system.ddp;

import de.vw.mib.asl.api.car.vehicle.ASLCarVehicleAPI;
import de.vw.mib.asl.api.car.vehicle.VehicleService;
import de.vw.mib.asl.api.car.vehicle.VehicleServiceListener;
import de.vw.mib.asl.api.system.DriverDistractionPreventionThresholdListener;
import de.vw.mib.asl.api.system.powerstate.ClampSignalListener;
import de.vw.mib.asl.api.system.powerstate.ClampSignalService;
import de.vw.mib.asl.framework.api.diagnosis.ASLDiagnosisAPI;
import de.vw.mib.asl.framework.api.diagnosis.AdaptionApi;
import de.vw.mib.asl.framework.api.diagnosis.AdaptionResponse;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.internal.impl.system.ddp.DdpInfoCollector$1;
import de.vw.mib.asl.internal.impl.system.ddp.DdpInfoCollector$2;
import de.vw.mib.asl.internal.impl.system.ddp.DdpInfoCollector$3;
import de.vw.mib.asl.internal.impl.system.ddp.DdpInfoCollector$4;
import de.vw.mib.asl.internal.system.util.Preconditions;
import de.vw.mib.log4mib.Logger;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates;

public class DdpInfoCollector {
    private final Logger logger;
    private int gearType;
    private int clutchState;
    private boolean isParkingBrakeEngaged;
    private int automaticGearShiftTransMode;
    private boolean isVehicleSpeedAboveThreshold;
    private boolean isStrictModeConfigured;
    private boolean isClamp15Activated;
    private boolean wasDdpRequiredPreviously;
    private DriverDistractionPreventionThresholdListener listener;
    static /* synthetic */ Class class$de$vw$mib$log4mib$Logger;
    static /* synthetic */ Class class$de$vw$mib$asl$framework$api$dsiproxy$DSIProxy;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$vehicle$ASLCarVehicleAPI;
    static /* synthetic */ Class class$de$vw$mib$asl$framework$api$diagnosis$ASLDiagnosisAPI;
    static /* synthetic */ Class class$de$vw$mib$asl$api$system$powerstate$ClampSignalService;
    static /* synthetic */ Class class$de$vw$mib$asl$framework$api$diagnosis$config$HmiFunctionBlockTbl;
    static /* synthetic */ Class class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates;

    public DdpInfoCollector(Logger logger, DSIProxy dSIProxy, ASLCarVehicleAPI aSLCarVehicleAPI, ASLDiagnosisAPI aSLDiagnosisAPI, ClampSignalService clampSignalService) {
        Preconditions.checkArgumentNotNull(logger, new StringBuffer().append("Incoming ").append((class$de$vw$mib$log4mib$Logger == null ? (class$de$vw$mib$log4mib$Logger = DdpInfoCollector.class$("de.vw.mib.log4mib.Logger")) : class$de$vw$mib$log4mib$Logger).getName()).append(" must not be null!").toString());
        Preconditions.checkArgumentNotNull(dSIProxy, new StringBuffer().append("Incoming ").append((class$de$vw$mib$asl$framework$api$dsiproxy$DSIProxy == null ? (class$de$vw$mib$asl$framework$api$dsiproxy$DSIProxy = DdpInfoCollector.class$("de.vw.mib.asl.framework.api.dsiproxy.DSIProxy")) : class$de$vw$mib$asl$framework$api$dsiproxy$DSIProxy).getName()).append(" must not be null!").toString());
        Preconditions.checkArgumentNotNull(aSLCarVehicleAPI, new StringBuffer().append("Incoming ").append((class$de$vw$mib$asl$api$car$vehicle$ASLCarVehicleAPI == null ? (class$de$vw$mib$asl$api$car$vehicle$ASLCarVehicleAPI = DdpInfoCollector.class$("de.vw.mib.asl.api.car.vehicle.ASLCarVehicleAPI")) : class$de$vw$mib$asl$api$car$vehicle$ASLCarVehicleAPI).getName()).append(" must not be null!").toString());
        Preconditions.checkArgumentNotNull(aSLDiagnosisAPI, new StringBuffer().append("Incoming ").append((class$de$vw$mib$asl$framework$api$diagnosis$ASLDiagnosisAPI == null ? (class$de$vw$mib$asl$framework$api$diagnosis$ASLDiagnosisAPI = DdpInfoCollector.class$("de.vw.mib.asl.framework.api.diagnosis.ASLDiagnosisAPI")) : class$de$vw$mib$asl$framework$api$diagnosis$ASLDiagnosisAPI).getName()).append(" must not be null!").toString());
        Preconditions.checkArgumentNotNull(clampSignalService, new StringBuffer().append("Incoming ").append((class$de$vw$mib$asl$api$system$powerstate$ClampSignalService == null ? (class$de$vw$mib$asl$api$system$powerstate$ClampSignalService = DdpInfoCollector.class$("de.vw.mib.asl.api.system.powerstate.ClampSignalService")) : class$de$vw$mib$asl$api$system$powerstate$ClampSignalService).getName()).append(" must not be null!").toString());
        this.logger = logger;
        this.connectDsi(dSIProxy);
        this.loadClampSignals(clampSignalService);
        this.loadVehicleData(aSLCarVehicleAPI);
        this.isStrictModeConfigured = false;
        this.loadStrictModeInfo(aSLDiagnosisAPI);
        this.wasDdpRequiredPreviously = false;
        this.listener = null;
    }

    public void setDriverDistractionPreventionThresholdListener(DriverDistractionPreventionThresholdListener driverDistractionPreventionThresholdListener) {
        this.listener = driverDistractionPreventionThresholdListener;
    }

    public boolean isDdpRequired() {
        if (this.isStrictModeConfigured) {
            if (!this.isClamp15Activated) {
                return false;
            }
            if (this.gearType == 1) {
                return this.automaticGearShiftTransMode != 1;
            }
            return this.isVehicleSpeedAboveThreshold || this.clutchState == 0 || !this.isParkingBrakeEngaged;
        }
        return this.isVehicleSpeedAboveThreshold;
    }

    private VehicleServiceListener createVehicleServiceListener() {
        return new DdpInfoCollector$1(this);
    }

    private ClampSignalListener createClampSignalListener() {
        return new DdpInfoCollector$2(this);
    }

    private DSIListener createDSIListener() {
        return new DdpInfoCollector$3(this);
    }

    private AdaptionResponse createAdaptionResponse() {
        return new DdpInfoCollector$4(this);
    }

    private void notifyListener(boolean bl) {
        if (this.listener == null) {
            this.error("No DriverDistractionPreventionThresholdListener registered, no notification will be sent!");
            return;
        }
        if (bl != this.wasDdpRequiredPreviously) {
            this.wasDdpRequiredPreviously = bl;
            this.listener.onDriverDistractionPreventionRequired(bl);
        }
    }

    private void connectDsi(DSIProxy dSIProxy) {
        DSIGeneralVehicleStates dSIGeneralVehicleStates = (DSIGeneralVehicleStates)dSIProxy.getService(null, class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = DdpInfoCollector.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates);
        dSIGeneralVehicleStates.setNotification(new int[]{19, 28}, this.createDSIListener());
    }

    private void loadClampSignals(ClampSignalService clampSignalService) {
        this.isClamp15Activated = clampSignalService.isCurrentClamp15Activated();
        clampSignalService.addListener(this.createClampSignalListener());
    }

    private void loadVehicleData(ASLCarVehicleAPI aSLCarVehicleAPI) {
        VehicleService vehicleService = aSLCarVehicleAPI.getVehicleService();
        this.gearType = vehicleService.getCarGearType();
        this.clutchState = vehicleService.getClutchState();
        this.automaticGearShiftTransMode = vehicleService.getAutomaticGearShiftTransMode();
        this.isVehicleSpeedAboveThreshold = false;
        this.isParkingBrakeEngaged = true;
        aSLCarVehicleAPI.addVehicleServiceListener(this.createVehicleServiceListener());
    }

    private void loadStrictModeInfo(ASLDiagnosisAPI aSLDiagnosisAPI) {
        AdaptionApi adaptionApi = aSLDiagnosisAPI.getAdaptionApi();
        adaptionApi.requestHmiFuncBlockTbl(this.createAdaptionResponse());
    }

    private void warn(String string) {
        this.logger.warn(2048, string);
    }

    private void error(String string) {
        this.logger.error(2048, string);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ int access$002(DdpInfoCollector ddpInfoCollector, int n) {
        ddpInfoCollector.gearType = n;
        return ddpInfoCollector.gearType;
    }

    static /* synthetic */ void access$100(DdpInfoCollector ddpInfoCollector, boolean bl) {
        ddpInfoCollector.notifyListener(bl);
    }

    static /* synthetic */ int access$202(DdpInfoCollector ddpInfoCollector, int n) {
        ddpInfoCollector.automaticGearShiftTransMode = n;
        return ddpInfoCollector.automaticGearShiftTransMode;
    }

    static /* synthetic */ int access$302(DdpInfoCollector ddpInfoCollector, int n) {
        ddpInfoCollector.clutchState = n;
        return ddpInfoCollector.clutchState;
    }

    static /* synthetic */ boolean access$402(DdpInfoCollector ddpInfoCollector, boolean bl) {
        ddpInfoCollector.isClamp15Activated = bl;
        return ddpInfoCollector.isClamp15Activated;
    }

    static /* synthetic */ void access$500(DdpInfoCollector ddpInfoCollector, String string) {
        ddpInfoCollector.warn(string);
    }

    static /* synthetic */ boolean access$602(DdpInfoCollector ddpInfoCollector, boolean bl) {
        ddpInfoCollector.isVehicleSpeedAboveThreshold = bl;
        return ddpInfoCollector.isVehicleSpeedAboveThreshold;
    }

    static /* synthetic */ boolean access$702(DdpInfoCollector ddpInfoCollector, boolean bl) {
        ddpInfoCollector.isParkingBrakeEngaged = bl;
        return ddpInfoCollector.isParkingBrakeEngaged;
    }

    static /* synthetic */ boolean access$802(DdpInfoCollector ddpInfoCollector, boolean bl) {
        ddpInfoCollector.isStrictModeConfigured = bl;
        return ddpInfoCollector.isStrictModeConfigured;
    }
}


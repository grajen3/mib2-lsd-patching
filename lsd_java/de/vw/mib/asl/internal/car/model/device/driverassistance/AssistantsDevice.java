/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.model.device.driverassistance;

import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.api.car.vo.CarFunctionState;
import de.vw.mib.asl.api.car.vo.drvass.ACCViewOptionsData;
import de.vw.mib.asl.api.car.vo.drvass.AWVViewOptionsData;
import de.vw.mib.asl.api.car.vo.drvass.DriverAssistanceViewOptionAdapter;
import de.vw.mib.asl.api.car.vo.drvass.LdwhcaViewOptionsData;
import de.vw.mib.asl.api.car.vo.drvass.MKEViewOptionsData;
import de.vw.mib.asl.api.car.vo.drvass.NVViewOptionsData;
import de.vw.mib.asl.api.car.vo.drvass.PAViewOptionsData;
import de.vw.mib.asl.api.car.vo.drvass.SWAViewOptionsData;
import de.vw.mib.asl.api.car.vo.drvass.TSDViewOptionsData;
import de.vw.mib.asl.api.car.vo.kombi.BCViewOptionsData;
import de.vw.mib.asl.internal.car.model.CarSetupMenu;
import de.vw.mib.asl.internal.car.model.FunctionState;
import de.vw.mib.asl.internal.car.model.device.MappingList;
import de.vw.mib.asl.internal.car.model.device.driverassistance.AssistantsDevice$1;
import de.vw.mib.asl.internal.car.model.device.driverassistance.AssistantsDevice$2;
import de.vw.mib.asl.internal.car.model.device.driverassistance.AssistantsDevice$3;
import de.vw.mib.asl.internal.car.model.device.driverassistance.AssistantsDevice$4;
import generated.de.vw.mib.asl.internal.ListManager;

public class AssistantsDevice
extends DriverAssistanceViewOptionAdapter {
    MappingList mappingList;
    private CarSetupMenu carSetupMenu;
    private CarFunctionState not_existent = new AssistantsDevice$1(this);
    TSDViewOptionsData tSDViewOptions;
    BCViewOptionsData bcViewOptions;
    int tsdRestriction;
    int bcRestriction;
    boolean tsdReceived;
    boolean bcReceived;

    public AssistantsDevice(CarSetupMenu carSetupMenu) {
        this.carSetupMenu = carSetupMenu;
        this.mappingList = new MappingList(35);
        ASLCarFactory.getCarApi().getDriverAssistanceViewOptionService().addListener(this);
        ASLCarFactory.getCarApi().getKombiViewOptionService().addListener(new AssistantsDevice$2(this));
        ASLCarFactory.getCarApi().getEcoViewOptionService().addListener(new AssistantsDevice$3(this));
        ASLCarFactory.getCarApi().getComfortViewOptionService().addListener(new AssistantsDevice$4(this));
        this.updateModel();
    }

    void updateModel() {
        ListManager.getGenericASLList(10731).updateList(this.mappingList.getFunctionStates());
        ListManager.getGenericASLList(10732).updateList(this.mappingList.getFunctionStates());
        ListManager.getGenericASLList(10753).updateList(this.mappingList.getFunctionStates());
        this.carSetupMenu.updateMenu(3, this.mappingList);
    }

    void updateStabilityProgramState(FunctionState functionState) {
        this.carSetupMenu.updateStabilityProgram(functionState);
    }

    @Override
    public void updateACCViewOptions(ACCViewOptionsData aCCViewOptionsData, int n) {
        if (aCCViewOptionsData.getDrivingProgram() == null) {
            this.mappingList.add(0, this.not_existent, n);
        } else {
            this.mappingList.add(0, aCCViewOptionsData.getDrivingProgram(), n);
        }
        this.mappingList.add(1, aCCViewOptionsData.getDefaultMode(), n);
        this.mappingList.add(2, aCCViewOptionsData.getTimegap(), n);
        this.mappingList.add(3, aCCViewOptionsData.getCurveAssist(), n);
        this.mappingList.add(4, aCCViewOptionsData.getSpeedLimitAdoption(), n);
        this.mappingList.add(5, aCCViewOptionsData.getSpeedLimitOffset(), n);
        this.updateModel();
    }

    @Override
    public void updateACCDevice(int n) {
        this.mappingList.add(0, n);
        this.mappingList.add(1, n);
        this.mappingList.add(2, n);
        this.mappingList.add(3, n);
        this.mappingList.add(4, n);
        this.mappingList.add(5, n);
        this.updateModel();
    }

    @Override
    public void updateAWVViewOptions(AWVViewOptionsData aWVViewOptionsData, int n) {
        this.mappingList.add(6, aWVViewOptionsData.getSystem(), n);
        this.mappingList.add(7, aWVViewOptionsData.getWarning(), n);
        this.mappingList.add(8, aWVViewOptionsData.getWarningTimegap(), n);
        this.mappingList.add(9, aWVViewOptionsData.getDistanceWarning(), n);
        this.mappingList.add(10, aWVViewOptionsData.getEmergencyBrake(), n);
        this.mappingList.add(11, aWVViewOptionsData.getCityBrakeSystem(), n);
        this.updateModel();
    }

    @Override
    public void updateAWVDevice(int n) {
        this.mappingList.add(6, n);
        this.mappingList.add(7, n);
        this.mappingList.add(8, n);
        this.mappingList.add(9, n);
        this.mappingList.add(10, n);
        this.mappingList.add(11, n);
        this.updateModel();
    }

    @Override
    public void updateLDWHCAViewOptions(LdwhcaViewOptionsData ldwhcaViewOptionsData, int n) {
        this.mappingList.add(12, ldwhcaViewOptionsData.getLdwhcaSystemOnOff(), n);
        this.mappingList.add(13, ldwhcaViewOptionsData.getHCAToleranceLevel(), n);
        this.mappingList.add(14, ldwhcaViewOptionsData.getLDWSteeringWheelVibration(), n);
        this.mappingList.add(34, ldwhcaViewOptionsData.getHCAInterventionStyle(), n);
        this.updateModel();
    }

    @Override
    public void updateLDWHCADevice(int n) {
        this.mappingList.add(12, n);
        this.mappingList.add(13, n);
        this.mappingList.add(14, n);
        this.mappingList.add(34, n);
        this.updateModel();
    }

    @Override
    public void updateTSDViewOptions(TSDViewOptionsData tSDViewOptionsData, int n) {
        this.tSDViewOptions = tSDViewOptionsData;
        this.tsdRestriction = n;
        this.tsdReceived = true;
        this.evaluateVzeVzaViewOptions();
    }

    @Override
    public void updateTSDDevice(int n) {
        this.tsdRestriction = n;
        this.tsdReceived = true;
        this.evaluateVzeVzaDevice();
    }

    @Override
    public void updateNVViewOptions(NVViewOptionsData nVViewOptionsData, int n) {
        this.mappingList.add(29, nVViewOptionsData.getObjectDetection(), n);
        this.mappingList.add(30, nVViewOptionsData.getContrast(), n);
        this.updateModel();
    }

    @Override
    public void updateNVDevice(int n) {
        this.mappingList.add(29, n);
        this.mappingList.add(30, n);
        this.updateModel();
    }

    @Override
    public void updateMKEViewOptions(MKEViewOptionsData mKEViewOptionsData, int n) {
        this.mappingList.add(32, mKEViewOptionsData.getSystemOnOff(), n);
        this.updateModel();
    }

    @Override
    public void updateMKEDevice(int n) {
        this.mappingList.add(32, n);
        this.updateModel();
    }

    @Override
    public void updatePAViewOptions(PAViewOptionsData pAViewOptionsData, int n) {
        this.mappingList.add(22, pAViewOptionsData.getPaSystemOnOff(), n);
        this.mappingList.add(23, pAViewOptionsData.getPaConfigWarning(), n);
        this.mappingList.add(24, pAViewOptionsData.getPaWarningTimegap(), n);
        this.mappingList.add(25, pAViewOptionsData.getPaConfigInformation(), n);
        this.updateModel();
    }

    @Override
    public void updatePADevice(int n) {
        this.mappingList.add(22, n);
        this.mappingList.add(23, n);
        this.mappingList.add(24, n);
        this.mappingList.add(25, n);
        this.updateModel();
    }

    @Override
    public void updateSWAViewOptions(SWAViewOptionsData sWAViewOptionsData, int n) {
        this.mappingList.add(15, sWAViewOptionsData.getSwaSystem(), n);
        this.mappingList.add(16, sWAViewOptionsData.getBrightness(), n);
        this.mappingList.add(17, sWAViewOptionsData.getBsdSystem(), n);
        this.mappingList.add(18, sWAViewOptionsData.getGongState(), n);
        this.updateModel();
    }

    @Override
    public void updateSWADevice(int n) {
        this.mappingList.add(15, n);
        this.mappingList.add(16, n);
        this.mappingList.add(17, n);
        this.mappingList.add(18, n);
        this.updateModel();
    }

    void evaluateVzeVzaViewOptions() {
        if (this.tsdReceived && this.tSDViewOptions != null) {
            this.mappingList.add(20, this.tSDViewOptions.getSpeedWarnAcoustics(), this.tsdRestriction);
            this.mappingList.add(21, this.tSDViewOptions.getSpeedWarningThreshold(), this.tsdRestriction);
            this.mappingList.add(26, this.tSDViewOptions.getRoadSignFilter(), this.tsdRestriction);
            this.mappingList.add(27, this.tSDViewOptions.getRoadSignFilter(), this.tsdRestriction);
            this.mappingList.add(28, this.tSDViewOptions.getTrailerSpeedLimit(), this.tsdRestriction);
        }
        if (this.tsdReceived && this.bcReceived && this.bcViewOptions != null) {
            this.mappingList.add(19, this.bcViewOptions.getVZADisplay(), this.bcRestriction);
        }
        this.updateModel();
    }

    void evaluateVzeVzaDevice() {
        if (this.tsdReceived) {
            this.mappingList.add(20, this.tsdRestriction);
            this.mappingList.add(21, this.tsdRestriction);
            this.mappingList.add(26, this.tsdRestriction);
            this.mappingList.add(27, this.tsdRestriction);
            this.mappingList.add(28, this.tsdRestriction);
        }
        if (this.tsdReceived && this.bcReceived) {
            this.mappingList.add(19, this.bcRestriction);
        }
        this.updateModel();
    }
}


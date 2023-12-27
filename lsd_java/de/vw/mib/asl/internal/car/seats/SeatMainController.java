/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.seats;

import de.vw.mib.asl.api.car.seat.SeatMassage;
import de.vw.mib.asl.api.car.seat.SeatPosition;
import de.vw.mib.asl.api.car.seat.SeatServiceListener;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.car.framework.services.ServiceFactory;
import de.vw.mib.asl.internal.car.seats.SeatAdjustmentCollector;
import de.vw.mib.asl.internal.car.seats.SeatTargetService;
import de.vw.mib.asl.internal.car.seats.service.SeatDisplayRequestImpl;
import de.vw.mib.asl.internal.car.seats.service.SeatServiceImpl;
import de.vw.mib.asl.internal.car.seats.service.SeatValueFactoryImpl;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carcomfort.BrakeViewOptions;
import org.dsi.ifc.carcomfort.DSICarComfort;
import org.dsi.ifc.carcomfort.DSICarComfortListener;
import org.dsi.ifc.carcomfort.DoorLockingBootBlindState;
import org.dsi.ifc.carcomfort.DoorLockingComfortOpenSettings;
import org.dsi.ifc.carcomfort.DoorLockingLockStatus;
import org.dsi.ifc.carcomfort.DoorLockingMessage;
import org.dsi.ifc.carcomfort.DoorLockingRearBlind;
import org.dsi.ifc.carcomfort.DoorLockingTheftWarningSettings;
import org.dsi.ifc.carcomfort.DoorLockingUserListRA1;
import org.dsi.ifc.carcomfort.DoorLockingUserListUpdateInfo;
import org.dsi.ifc.carcomfort.DoorLockingUserProfileOnOff;
import org.dsi.ifc.carcomfort.DoorLockingViewOptions;
import org.dsi.ifc.carcomfort.DoorLockingWindowStatus;
import org.dsi.ifc.carcomfort.MirrorViewOptions;
import org.dsi.ifc.carcomfort.RDKResidualBatteryLifetime;
import org.dsi.ifc.carcomfort.RDKTireDisplayData;
import org.dsi.ifc.carcomfort.RDKTireInfo;
import org.dsi.ifc.carcomfort.RDKViewOptions;
import org.dsi.ifc.carcomfort.RDKWheelPressures;
import org.dsi.ifc.carcomfort.RGSBeltPretensionData;
import org.dsi.ifc.carcomfort.RGSLocalHazardDetection;
import org.dsi.ifc.carcomfort.RGSViewOptions;
import org.dsi.ifc.carcomfort.UGDOButtonListRA0;
import org.dsi.ifc.carcomfort.UGDOButtonListRA1;
import org.dsi.ifc.carcomfort.UGDOButtonListRA2;
import org.dsi.ifc.carcomfort.UGDOButtonListRA3;
import org.dsi.ifc.carcomfort.UGDOButtonListRA4;
import org.dsi.ifc.carcomfort.UGDOButtonListRA5;
import org.dsi.ifc.carcomfort.UGDOButtonListUpdateInfo;
import org.dsi.ifc.carcomfort.UGDOContent;
import org.dsi.ifc.carcomfort.UGDODestinationReached;
import org.dsi.ifc.carcomfort.UGDOLearningData;
import org.dsi.ifc.carcomfort.UGDOOpenDoor;
import org.dsi.ifc.carcomfort.UGDOSynchronisation;
import org.dsi.ifc.carcomfort.UGDOVersionData;
import org.dsi.ifc.carcomfort.UGDOViewOptions;
import org.dsi.ifc.carcomfort.WiperViewOptions;
import org.dsi.ifc.carseat.DSICarSeat;
import org.dsi.ifc.carseat.DSICarSeatListener;
import org.dsi.ifc.carseat.MassageData;
import org.dsi.ifc.carseat.RestSeatStatus;
import org.dsi.ifc.carseat.SeatAdjustment;
import org.dsi.ifc.carseat.SeatContent;
import org.dsi.ifc.carseat.SeatPneumaticContent;
import org.dsi.ifc.carseat.SeatPneumaticViewOptions;
import org.dsi.ifc.carseat.SeatSpecialPosition;
import org.dsi.ifc.carseat.SeatViewOptions;
import org.dsi.ifc.carseat.SwitcherDataBackForward;
import org.dsi.ifc.carseat.SwitcherDataUpDown;

public class SeatMainController
implements DSICarSeatListener,
DSICarComfortListener {
    DSICarSeat dsiCarSeat;
    DSICarComfort dsiCarComfort;
    SeatTargetService seatTargetService;
    SeatServiceImpl seatService;
    private boolean isSeatServiceExisting = false;
    private boolean isSeatServiceAvailable = false;
    private boolean isDriverSideLeft = true;
    private boolean isSeatMemoryActive = false;
    MassageData[] massageSettingsAllZones = new MassageData[]{new MassageData(), new MassageData(), new MassageData(), new MassageData()};
    boolean[] seatPretension = new boolean[]{false, false, false, false};
    boolean[] seatEasyEntryExit = new boolean[]{false, false, false, false};
    SeatAdjustmentCollector[] seatAdjustment = new SeatAdjustmentCollector[]{new SeatAdjustmentCollector(), new SeatAdjustmentCollector(), new SeatAdjustmentCollector(), new SeatAdjustmentCollector()};
    static /* synthetic */ Class class$org$dsi$ifc$carseat$DSICarSeat;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$DSICarComfort;
    static /* synthetic */ Class class$org$dsi$ifc$carseat$DSICarSeatListener;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$DSICarComfortListener;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$seat$SeatService;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$seat$SeatServiceListener;

    public SeatMainController(SeatTargetService seatTargetService) {
        this.seatTargetService = seatTargetService;
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiCarSeat = (DSICarSeat)dSIProxy.getService(null, class$org$dsi$ifc$carseat$DSICarSeat == null ? (class$org$dsi$ifc$carseat$DSICarSeat = SeatMainController.class$("org.dsi.ifc.carseat.DSICarSeat")) : class$org$dsi$ifc$carseat$DSICarSeat);
        this.dsiCarComfort = (DSICarComfort)dSIProxy.getService(null, class$org$dsi$ifc$carcomfort$DSICarComfort == null ? (class$org$dsi$ifc$carcomfort$DSICarComfort = SeatMainController.class$("org.dsi.ifc.carcomfort.DSICarComfort")) : class$org$dsi$ifc$carcomfort$DSICarComfort);
        dSIProxy.addResponseListener(null, class$org$dsi$ifc$carseat$DSICarSeatListener == null ? (class$org$dsi$ifc$carseat$DSICarSeatListener = SeatMainController.class$("org.dsi.ifc.carseat.DSICarSeatListener")) : class$org$dsi$ifc$carseat$DSICarSeatListener, this);
        dSIProxy.addResponseListener(null, class$org$dsi$ifc$carcomfort$DSICarComfortListener == null ? (class$org$dsi$ifc$carcomfort$DSICarComfortListener = SeatMainController.class$("org.dsi.ifc.carcomfort.DSICarComfortListener")) : class$org$dsi$ifc$carcomfort$DSICarComfortListener, this);
        this.dsiCarSeat.setNotification(new int[]{2, 1, 19, 20, 21, 22}, (DSIListener)this);
        this.dsiCarComfort.setNotification(new int[]{2, 3}, (DSIListener)this);
        this.registerAsServiceProvider();
    }

    public void setMassageSettings(SeatMassage seatMassage) {
        switch (seatMassage.getSeatMassageZone()) {
            case 0: {
                this.dsiCarSeat.setSeatMassageData(1, new MassageData(seatMassage.getSeatMassageProgram(), seatMassage.getSeatMassageIntensity(), seatMassage.getSeatMassageSpeed()));
                break;
            }
            case 1: {
                this.dsiCarSeat.setSeatMassageData(2, new MassageData(seatMassage.getSeatMassageProgram(), seatMassage.getSeatMassageIntensity(), seatMassage.getSeatMassageSpeed()));
                break;
            }
            case 2: {
                this.dsiCarSeat.setSeatMassageData(3, new MassageData(seatMassage.getSeatMassageProgram(), seatMassage.getSeatMassageIntensity(), seatMassage.getSeatMassageSpeed()));
                break;
            }
            case 3: {
                this.dsiCarSeat.setSeatMassageData(4, new MassageData(seatMassage.getSeatMassageProgram(), seatMassage.getSeatMassageIntensity(), seatMassage.getSeatMassageSpeed()));
                break;
            }
        }
    }

    public void setSeatAdjustmentBackFoward(int n, int n2, SwitcherDataBackForward switcherDataBackForward) {
        switch (n2) {
            case 1: {
                this.dsiCarSeat.setSeatSwitcherDataForward(n, switcherDataBackForward);
                break;
            }
            case 2: {
                this.dsiCarSeat.setSeatSwitcherDataBack(n, switcherDataBackForward);
                break;
            }
            default: {
                this.seatTargetService.writeToLog(0, "Error: setSeatAdjustmentBackFoward:Error Invalid seatMovement Direction");
            }
        }
    }

    public void setSeatAdjustmentUpDown(int n, int n2, SwitcherDataUpDown switcherDataUpDown) {
        switch (n2) {
            case 3: {
                this.dsiCarSeat.setSeatSwitcherDataUp(n, switcherDataUpDown);
                break;
            }
            case 4: {
                this.dsiCarSeat.setSeatSwitcherDataDown(n, switcherDataUpDown);
                break;
            }
            default: {
                this.seatTargetService.writeToLog(0, "Error: setSeatAdjustmentUpDown: Invalid seatMovement Direction");
            }
        }
    }

    public void setSeatSpeicalPosition(SeatSpecialPosition seatSpecialPosition) {
        this.dsiCarSeat.setSeatSpecialPosition(seatSpecialPosition);
    }

    public void setSeatFoldHeadRest(int n, boolean bl) {
        this.dsiCarSeat.setSeatFoldHeadRestRearDriver(bl);
        this.dsiCarSeat.setSeatFoldHeadRestRearCoDriver(bl);
    }

    public void setCoDriverSettingsFromDriver(boolean bl) {
        this.dsiCarSeat.setSeatCodriverSettingsFromDriver(bl);
    }

    public void cancelSeatPopup(SeatContent seatContent, int n) {
        this.dsiCarSeat.cancelSeatPopup(seatContent, n);
    }

    public void showSeatPopup(SeatContent seatContent) {
        this.dsiCarSeat.showSeatPopup(seatContent);
    }

    public void setSeatMemory(boolean bl) {
        this.dsiCarSeat.setSeatRadioKeyAutomatic(bl);
    }

    public void setSeatEasyEntryExit(int n, boolean bl) {
        switch (n) {
            case 0: {
                this.dsiCarSeat.setSeatEasyEntryFrontLeft(bl);
                break;
            }
            case 1: {
                this.dsiCarSeat.setSeatEasyEntryFrontRight(bl);
                break;
            }
            case 2: {
                this.dsiCarSeat.setSeatEasyEntryRearLeft(bl);
                break;
            }
            case 3: {
                this.dsiCarSeat.setSeatEasyEntryRearRight(bl);
                break;
            }
        }
    }

    public void setSeatBeltPretension(int n, boolean bl) {
        RGSBeltPretensionData rGSBeltPretensionData = null;
        switch (n) {
            case 0: {
                rGSBeltPretensionData = new RGSBeltPretensionData(bl, this.seatPretension[1]);
                this.dsiCarComfort.setRGSBeltPretensionerDataFront(rGSBeltPretensionData);
                break;
            }
            case 1: {
                rGSBeltPretensionData = new RGSBeltPretensionData(this.seatPretension[0], bl);
                this.dsiCarComfort.setRGSBeltPretensionerDataFront(rGSBeltPretensionData);
                break;
            }
            case 2: {
                rGSBeltPretensionData = new RGSBeltPretensionData(bl, this.seatPretension[3]);
                this.dsiCarComfort.setRGSBeltPretensionerDataRear(rGSBeltPretensionData);
                break;
            }
            case 3: {
                rGSBeltPretensionData = new RGSBeltPretensionData(this.seatPretension[2], bl);
                this.dsiCarComfort.setRGSBeltPretensionerDataRear(rGSBeltPretensionData);
                break;
            }
        }
    }

    void toggleBeltTensionerFront(int n) {
        switch (n) {
            case 0: {
                this.dsiCarComfort.setRGSBeltPretensionerDataFront(new RGSBeltPretensionData(!this.seatPretension[0], this.seatPretension[1]));
                break;
            }
            case 1: {
                this.dsiCarComfort.setRGSBeltPretensionerDataFront(new RGSBeltPretensionData(this.seatPretension[0], !this.seatPretension[1]));
                break;
            }
            default: {
                this.seatTargetService.writeToLog(0, new StringBuffer().append("SeatMainController: receive unknown seat position value: ").append(SeatPosition.toString(n)).append(" for seat -> ").append(!this.seatPretension[n]).toString());
                return;
            }
        }
        this.seatTargetService.writeToLog(0, new StringBuffer().append("SeatMainController: toggle belt tensioner status of ").append(SeatPosition.toString(n)).append(" for seat -> ").append(!this.seatPretension[n]).toString());
    }

    void toggleDriverSeatPositionStorage() {
        this.dsiCarSeat.setSeatRadioKeyAutomatic(!this.isSeatMemoryActive);
        this.seatTargetService.writeToLog(0, "SeatMainController: toggle seat memory of driver seat. New value: ");
        this.seatTargetService.writeToLog(0, new Boolean(!this.isSeatMemoryActive));
    }

    void toggleEasyEntryExitPassengerSeat() {
        if (this.isDriverSideLeft()) {
            this.dsiCarSeat.setSeatEasyEntryFrontRight(!this.seatEasyEntryExit[1]);
            this.seatTargetService.writeToLog(0, new StringBuffer().append("SeatMainController: toggle easy entry&exit status of ").append(SeatPosition.toString(1)).toString());
        } else {
            this.dsiCarSeat.setSeatEasyEntryFrontLeft(!this.seatEasyEntryExit[0]);
            this.seatTargetService.writeToLog(0, new StringBuffer().append("SeatMainController: toggle easy entry&exit status of ").append(SeatPosition.toString(0)).toString());
        }
    }

    void toggleEasyEntryExitDriverSeat() {
        if (this.isDriverSideLeft()) {
            this.dsiCarSeat.setSeatEasyEntryFrontLeft(!this.seatEasyEntryExit[0]);
            this.seatTargetService.writeToLog(0, new StringBuffer().append("SeatMainController: toggle easy entry&exit status of ").append(SeatPosition.toString(0)).toString());
        } else {
            this.dsiCarSeat.setSeatEasyEntryFrontRight(!this.seatEasyEntryExit[1]);
            this.seatTargetService.writeToLog(0, new StringBuffer().append("SeatMainController: toggle easy entry&exit status of ").append(SeatPosition.toString(1)).toString());
        }
    }

    public void resetRestingAndWorkingPosition() {
        this.dsiCarSeat.startSeatDeleteSpecialPosition(false, false);
    }

    public boolean getSeatBeltPretensionOfSeatPosition(int n) {
        return this.seatPretension[n];
    }

    public boolean getSeatEasyEntryExitOfSeatPosition(int n) {
        return this.seatEasyEntryExit[n];
    }

    public boolean isDriverSideLeft() {
        return this.isDriverSideLeft;
    }

    public boolean isSeatMemory() {
        return this.isSeatMemoryActive;
    }

    public void updateSeatAdjustmentForwardBack(int n, SwitcherDataBackForward switcherDataBackForward) {
        this.seatAdjustment[n].cushionDepth = switcherDataBackForward.sitztiefe;
        this.seatAdjustment[n].lateralBack = switcherDataBackForward.lehnenwangen;
        this.seatAdjustment[n].upperBack = switcherDataBackForward.lehnenkopf;
    }

    public void updateSeatAdjustmentUpDown(int n, SwitcherDataUpDown switcherDataUpDown) {
        this.seatAdjustment[n].lateralCushion = switcherDataUpDown.sitzflaechenwangen;
    }

    private MassageData getCopyOfSeatMassage(MassageData massageData) {
        MassageData massageData2 = new MassageData(massageData.program, massageData.intensity, massageData.speed);
        return massageData2;
    }

    private void evaluateSeatMassageExistence(SeatViewOptions seatViewOptions) {
        if (seatViewOptions.seatSettings1RL.seatMassage.state == 2) {
            this.dsiCarSeat.setNotification(8, (DSIListener)this);
        }
        if (seatViewOptions.seatSettings1RR.seatMassage.state == 2) {
            this.dsiCarSeat.setNotification(9, (DSIListener)this);
        }
        if (seatViewOptions.seatSettings2RL.seatMassage.state == 2) {
            this.dsiCarSeat.setNotification(38, (DSIListener)this);
        }
        if (seatViewOptions.seatSettings2RR.seatMassage.state == 2) {
            this.dsiCarSeat.setNotification(39, (DSIListener)this);
        }
    }

    public MassageData getSeatMassageOfZone(int n) {
        return this.getCopyOfSeatMassage(this.massageSettingsAllZones[n]);
    }

    public MassageData[] getSeatMassageOfAllZones() {
        MassageData[] massageDataArray = new MassageData[]{this.getCopyOfSeatMassage(this.massageSettingsAllZones[0]), this.getCopyOfSeatMassage(this.massageSettingsAllZones[0]), this.getCopyOfSeatMassage(this.massageSettingsAllZones[2]), this.getCopyOfSeatMassage(this.massageSettingsAllZones[3])};
        return massageDataArray;
    }

    public SeatAdjustmentCollector getSeatAdjustmentOfPosition(int n) {
        SeatAdjustmentCollector seatAdjustmentCollector = null;
        if (n >= 0 && n <= 3) {
            seatAdjustmentCollector = new SeatAdjustmentCollector(this.seatAdjustment[n].cushionDepth, this.seatAdjustment[n].lateralCushion, this.seatAdjustment[n].lateralBack, this.seatAdjustment[n].upperBack);
        }
        return seatAdjustmentCollector;
    }

    public void registerAsServiceProvider() {
        ServiceFactory.getInstance().getServiceProviderRegistry().registerServiceProvider(class$de$vw$mib$asl$api$car$seat$SeatService == null ? (class$de$vw$mib$asl$api$car$seat$SeatService = SeatMainController.class$("de.vw.mib.asl.api.car.seat.SeatService")) : class$de$vw$mib$asl$api$car$seat$SeatService, this.getSeatService());
        this.isSeatServiceExisting = true;
        this.isSeatServiceAvailable = true;
        this.getSeatServiceListener().updateSeatServiceExisting(this.isSeatServiceExisting);
        this.getSeatServiceListener().updateSeatServiceAvailable(this.isSeatServiceAvailable);
    }

    private SeatServiceImpl getSeatService() {
        if (this.seatService == null) {
            this.seatService = new SeatServiceImpl(this);
        }
        return this.seatService;
    }

    private SeatServiceListener getSeatServiceListener() {
        return (SeatServiceListener)ServiceFactory.getInstance().getServiceProviderRegistry().getServiceListener(class$de$vw$mib$asl$api$car$seat$SeatServiceListener == null ? (class$de$vw$mib$asl$api$car$seat$SeatServiceListener = SeatMainController.class$("de.vw.mib.asl.api.car.seat.SeatServiceListener")) : class$de$vw$mib$asl$api$car$seat$SeatServiceListener);
    }

    public boolean isSeatServiceExisiting() {
        return this.isSeatServiceExisting;
    }

    public boolean isSeatServiceAvailable() {
        return this.isSeatServiceAvailable;
    }

    @Override
    public void asyncException(int n, String string, int n2) {
    }

    @Override
    public void updateSeatViewOptions(SeatViewOptions seatViewOptions, int n) {
        this.isDriverSideLeft = seatViewOptions.seatmemoryConfig.driversideLeft;
        this.seatTargetService.writeToLog(0, new StringBuffer().append("SeatMainController: Driver side is left =").append(this.isDriverSideLeft).toString());
        this.evaluateSeatMassageExistence(seatViewOptions);
    }

    @Override
    public void updateSeatContent(SeatContent seatContent, int n) {
        SeatDisplayRequestImpl seatDisplayRequestImpl = new SeatDisplayRequestImpl(seatContent.getContent1RL(), seatContent.getContent1RR(), seatContent.getContent2RL(), seatContent.getContent2RR(), seatContent.memoryDetail1RL, seatContent.memoryDetail1RR, seatContent.memoryDetail2RL, seatContent.memoryDetail2RR);
        this.getSeatServiceListener().updateSeatDisplayContent(seatDisplayRequestImpl);
    }

    @Override
    public void updateSeatEasyEntryFrontLeft(boolean bl, int n) {
        this.updateSeatEasyEntryExit(1, bl);
    }

    @Override
    public void updateSeatEasyEntryFrontRight(boolean bl, int n) {
        this.updateSeatEasyEntryExit(2, bl);
    }

    @Override
    public void updateSeatEasyEntryRearLeft(boolean bl, int n) {
        this.updateSeatEasyEntryExit(3, bl);
    }

    @Override
    public void updateSeatEasyEntryRearRight(boolean bl, int n) {
        this.updateSeatEasyEntryExit(4, bl);
    }

    public void updateSeatEasyEntryExit(int n, boolean bl) {
        switch (n) {
            case 1: {
                this.seatEasyEntryExit[0] = bl;
                this.getSeatServiceListener().updateSeatSetupSetting(new SeatValueFactoryImpl().creatSeatSettings(1, 0, bl));
                SeatMainController.writeBooleanToDatapool(this.isDriverSideLeft ? 10839 : 10840, bl);
                break;
            }
            case 2: {
                this.seatEasyEntryExit[1] = bl;
                this.getSeatServiceListener().updateSeatSetupSetting(new SeatValueFactoryImpl().creatSeatSettings(1, 1, bl));
                SeatMainController.writeBooleanToDatapool(this.isDriverSideLeft ? 10840 : 10839, bl);
                break;
            }
            case 3: {
                this.seatEasyEntryExit[2] = bl;
                this.getSeatServiceListener().updateSeatSetupSetting(new SeatValueFactoryImpl().creatSeatSettings(1, 2, bl));
                break;
            }
            case 4: {
                this.seatEasyEntryExit[3] = bl;
                this.getSeatServiceListener().updateSeatSetupSetting(new SeatValueFactoryImpl().creatSeatSettings(1, 3, bl));
                break;
            }
            default: {
                this.seatTargetService.writeToLog(0, "cannot update easy entry&exit -> unknown seatposition");
            }
        }
    }

    @Override
    public void requestSeatPopup(SeatContent seatContent) {
        SeatDisplayRequestImpl seatDisplayRequestImpl = new SeatDisplayRequestImpl(seatContent.getContent1RL(), seatContent.getContent1RR(), seatContent.getContent2RL(), seatContent.getContent2RR(), seatContent.memoryDetail1RL, seatContent.memoryDetail1RR, seatContent.memoryDetail2RL, seatContent.memoryDetail2RR);
        this.getSeatServiceListener().requestSeatPopup(seatDisplayRequestImpl);
    }

    @Override
    public void updateSeatMassageData1RL(MassageData massageData, int n) {
        this.updateSeatMassage(1, massageData);
    }

    @Override
    public void updateSeatMassageData1RR(MassageData massageData, int n) {
        this.updateSeatMassage(2, massageData);
    }

    @Override
    public void updateSeatMassageData2RL(MassageData massageData, int n) {
        this.updateSeatMassage(3, massageData);
    }

    @Override
    public void updateSeatMassageData2RR(MassageData massageData, int n) {
        this.updateSeatMassage(4, massageData);
    }

    public void updateSeatMassage(int n, MassageData massageData) {
        switch (n) {
            case 1: {
                this.massageSettingsAllZones[0] = massageData;
                this.getSeatServiceListener().updateSeatMassage(new SeatValueFactoryImpl().createSeatMassage(0, massageData.program, massageData.intensity, massageData.speed));
                break;
            }
            case 2: {
                this.massageSettingsAllZones[1] = massageData;
                this.getSeatServiceListener().updateSeatMassage(new SeatValueFactoryImpl().createSeatMassage(1, massageData.program, massageData.intensity, massageData.speed));
                break;
            }
            case 3: {
                this.massageSettingsAllZones[2] = massageData;
                this.getSeatServiceListener().updateSeatMassage(new SeatValueFactoryImpl().createSeatMassage(2, massageData.program, massageData.intensity, massageData.speed));
                break;
            }
            case 4: {
                this.massageSettingsAllZones[3] = massageData;
                this.getSeatServiceListener().updateSeatMassage(new SeatValueFactoryImpl().createSeatMassage(3, massageData.program, massageData.intensity, massageData.speed));
                break;
            }
            default: {
                this.seatTargetService.writeToLog(0, "cannot update massage setting -> unknown seat position");
            }
        }
    }

    @Override
    public void updateSeatRadioKeyAutomatic(boolean bl, int n) {
        this.seatTargetService.writeToLog(0, "DSI UPDATE: Storage on Radio key. Value: ");
        this.seatTargetService.writeToLog(0, new Boolean(bl));
        this.isSeatMemoryActive = bl;
        SeatMainController.writeBooleanToDatapool(10274, bl);
        this.getSeatServiceListener().updateSeatSetupSetting(new SeatValueFactoryImpl().creatSeatSettings(2, this.isDriverSideLeft ? 0 : 1, bl));
    }

    public static void writeBooleanToDatapool(int n, boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(n, bl);
    }

    @Override
    public void updateRGSBeltPretensionDataFront(RGSBeltPretensionData rGSBeltPretensionData, int n) {
        this.seatTargetService.writeToLog(0, "DSI UPDATE: RGSBeltPretensionDataFront. Values: ");
        this.seatTargetService.writeToLog(0, rGSBeltPretensionData.toString());
        SeatMainController.writeBooleanToDatapool(10272, rGSBeltPretensionData.isLeft());
        SeatMainController.writeBooleanToDatapool(10273, rGSBeltPretensionData.isRight());
        this.seatPretension[0] = rGSBeltPretensionData.isLeft();
        this.getSeatServiceListener().updateSeatSetupSetting(new SeatValueFactoryImpl().creatSeatSettings(3, 0, rGSBeltPretensionData.isLeft()));
        this.seatPretension[1] = rGSBeltPretensionData.isRight();
        this.getSeatServiceListener().updateSeatSetupSetting(new SeatValueFactoryImpl().creatSeatSettings(3, 1, rGSBeltPretensionData.isRight()));
    }

    @Override
    public void updateRGSBeltPretensionDataRear(RGSBeltPretensionData rGSBeltPretensionData, int n) {
        this.seatTargetService.writeToLog(0, "DSI UPDATE: RGSBeltPretensionDataFront. Values: ");
        this.seatTargetService.writeToLog(0, rGSBeltPretensionData.toString());
        this.seatPretension[2] = rGSBeltPretensionData.isLeft();
        this.getSeatServiceListener().updateSeatSetupSetting(new SeatValueFactoryImpl().creatSeatSettings(3, 2, rGSBeltPretensionData.isLeft()));
        this.seatPretension[3] = rGSBeltPretensionData.isRight();
        this.getSeatServiceListener().updateSeatSetupSetting(new SeatValueFactoryImpl().creatSeatSettings(3, 3, rGSBeltPretensionData.isRight()));
    }

    @Override
    public void updateSeatSpecialPosition(SeatSpecialPosition seatSpecialPosition, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSeatSpecialPositionRearCoDriver(SeatSpecialPosition seatSpecialPosition, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSeatFrontLeftStopButton(boolean bl, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSeatFrontRightStopButton(boolean bl, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSeatRearLeftStopButton(boolean bl, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSeatRearRightStopButton(boolean bl, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSeatCodriverSettingsFromDriver(boolean bl, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSeatCodriverSettingsFromRear(boolean bl, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSeatSwitcherDataUp1RL(SwitcherDataUpDown switcherDataUpDown, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSeatSwitcherDataDown1RL(SwitcherDataUpDown switcherDataUpDown, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSeatSwitcherDataForward1RL(SwitcherDataBackForward switcherDataBackForward, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSeatSwitcherDataBack1RL(SwitcherDataBackForward switcherDataBackForward, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSeatSwitcherDataUp1RR(SwitcherDataUpDown switcherDataUpDown, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSeatSwitcherDataDown1RR(SwitcherDataUpDown switcherDataUpDown, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSeatSwitcherDataForward1RR(SwitcherDataBackForward switcherDataBackForward, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSeatSwitcherDataBack1RR(SwitcherDataBackForward switcherDataBackForward, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSeatSwitcherDataUp2RL(SwitcherDataUpDown switcherDataUpDown, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSeatSwitcherDataDown2RL(SwitcherDataUpDown switcherDataUpDown, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSeatSwitcherDataForward2RL(SwitcherDataBackForward switcherDataBackForward, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSeatSwitcherDataBack2RL(SwitcherDataBackForward switcherDataBackForward, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSeatSwitcherDataUp2RR(SwitcherDataUpDown switcherDataUpDown, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSeatSwitcherDataDown2RR(SwitcherDataUpDown switcherDataUpDown, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSeatSwitcherDataForward2RR(SwitcherDataBackForward switcherDataBackForward, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSeatSwitcherDataBack2RR(SwitcherDataBackForward switcherDataBackForward, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void acknowledgeSeatPopup(SeatContent seatContent) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSeatPneumaticViewOptions(SeatPneumaticViewOptions seatPneumaticViewOptions, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSeatPneumaticCodriverSettingsFromDriver(boolean bl, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSeatPneumaticMassageData1RL(MassageData massageData, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSeatPneumaticMassageData1RR(MassageData massageData, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSeatPneumaticSwitcherDataUp1RL(SwitcherDataUpDown switcherDataUpDown, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSeatPneumaticSwitcherDataDown1RL(SwitcherDataUpDown switcherDataUpDown, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSeatPneumaticSwitcherDataForward1RL(SwitcherDataBackForward switcherDataBackForward, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSeatPneumaticSwitcherDataBack1RL(SwitcherDataBackForward switcherDataBackForward, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSeatPneumaticSwitcherDataUp1RR(SwitcherDataUpDown switcherDataUpDown, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSeatPneumaticSwitcherDataDown1RR(SwitcherDataUpDown switcherDataUpDown, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSeatPneumaticSwitcherDataForward1RR(SwitcherDataBackForward switcherDataBackForward, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSeatPneumaticSwitcherDataBack1RR(SwitcherDataBackForward switcherDataBackForward, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSeatPneumaticContent(SeatPneumaticContent seatPneumaticContent, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void requestSeatPneumaticPopup(SeatPneumaticContent seatPneumaticContent) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void acknowledgeSeatPneumaticPopup(SeatPneumaticContent seatPneumaticContent) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void acknowledgeSeatSetFactoryDefault(boolean bl) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void acknowledgeSeatPneumaticSetFactoryDefault(boolean bl) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void acknowledgeSeatDeleteSpecialPosition(boolean bl) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void acknowledgeSeatMoveRearSeatDisplay(boolean bl) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSeatAdjustment1RL(SeatAdjustment seatAdjustment, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSeatAdjustment1RR(SeatAdjustment seatAdjustment, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSeatAdjustment2RL(SeatAdjustment seatAdjustment, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSeatAdjustment2RR(SeatAdjustment seatAdjustment, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSeatCoDriverSettingsFromRearActivation(boolean bl, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSeatRestSeatStatus(RestSeatStatus restSeatStatus, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSeatFoldHeadRestRearDriver(boolean bl, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSeatFoldHeadRestRearCoDriver(boolean bl, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSeatPremiumMassageData1RL(MassageData massageData, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSeatPremiumMassageData1RR(MassageData massageData, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSeatPremiumMassageData2RL(MassageData massageData, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSeatPremiumMassageData2RR(MassageData massageData, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSeatPremiumMassageSwitcher1RL(boolean bl, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSeatPremiumMassageSwitcher1RR(boolean bl, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSeatPremiumMassageSwitcher2RL(boolean bl, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSeatPremiumMassageSwitcher2RR(boolean bl, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSeatMassageSwitcher1RL(boolean bl, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSeatMassageSwitcher1RR(boolean bl, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSeatMassageSwitcher2RL(boolean bl, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSeatMassageSwitcher2RR(boolean bl, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateRGSViewOptions(RGSViewOptions rGSViewOptions, int n) {
    }

    @Override
    public void updateRGSPreCrashSystem(boolean bl, int n) {
    }

    @Override
    public void acknowledgeRgsSetFactoryDefault(boolean bl) {
    }

    @Override
    public void updateRGSPreSenseSystem(boolean bl, int n) {
    }

    @Override
    public void updateRGSPreSenseWarning(int n, int n2) {
    }

    @Override
    public void updateRGSLocalHazardDetection(RGSLocalHazardDetection rGSLocalHazardDetection, int n) {
    }

    @Override
    public void updateDoorLockingViewOptions(DoorLockingViewOptions doorLockingViewOptions, int n) {
    }

    @Override
    public void updateDoorLockingMessage(DoorLockingMessage doorLockingMessage, int n) {
    }

    @Override
    public void updateDoorLockingLockStatus(DoorLockingLockStatus doorLockingLockStatus, int n) {
    }

    @Override
    public void updateDoorLockingWindowStatus(DoorLockingWindowStatus doorLockingWindowStatus, int n) {
    }

    @Override
    public void updateDoorLockingComfortOpenSettings(DoorLockingComfortOpenSettings doorLockingComfortOpenSettings, int n) {
    }

    @Override
    public void updateDoorLockingTheftWarningSettings(DoorLockingTheftWarningSettings doorLockingTheftWarningSettings, int n) {
    }

    @Override
    public void updateDoorLockingClBootOpen(boolean bl, int n) {
    }

    @Override
    public void updateDoorLockingBootOpen(boolean bl, int n) {
    }

    @Override
    public void updateDoorLockingBootClose(boolean bl, int n) {
    }

    @Override
    public void updateDoorLockingUnlockingMode(int n, int n2) {
    }

    @Override
    public void updateDoorLockingAutoLock(int n, int n2) {
    }

    @Override
    public void updateDoorLockingAutoUnlock(boolean bl, int n) {
    }

    @Override
    public void updateDoorLockingClBootLock(boolean bl, int n) {
    }

    @Override
    public void updateDoorLockingMirrorProtection(boolean bl, int n) {
    }

    @Override
    public void updateDoorLockingConfirmation(boolean bl, int n) {
    }

    @Override
    public void updateDoorLockingRainClosing(boolean bl, int n) {
    }

    @Override
    public void updateDoorLockingRearBlind(DoorLockingRearBlind doorLockingRearBlind, int n) {
    }

    @Override
    public void acknowledgeDoorLockingSetFactoryDefault(boolean bl) {
    }

    @Override
    public void acknowledgeDoorLockingRemoteLockUnlock(String string, boolean bl) {
    }

    @Override
    public void acknowledgeDoorLockingRemoteBlinking(boolean bl) {
    }

    @Override
    public void acknowledgeDoorLockingRemoteHorn(boolean bl) {
    }

    @Override
    public void receivedDoorLockingRemoteLockUnlockSignatureVerification(String string) {
    }

    @Override
    public void receivedDoorLockingRemoteLockUnlockAuthentification(String string, int n) {
    }

    @Override
    public void responseDoorLockingUserListRA1(DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo, DoorLockingUserListRA1[] doorLockingUserListRA1Array) {
    }

    @Override
    public void responseDoorLockingUserListRAF(DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo, int[] nArray) {
    }

    @Override
    public void updateDoorLockingUserListUpdateInfo(DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo, int n) {
    }

    @Override
    public void updateDoorLockingUserListTotalNumberOfElements(int n, int n2) {
    }

    @Override
    public void updateDoorLockingActiveUser(int n, int n2) {
    }

    @Override
    public void updateDoorLockingUserProfileOnOff(DoorLockingUserProfileOnOff doorLockingUserProfileOnOff, int n) {
    }

    @Override
    public void acknowledgeDoorLockingUserProfileControl(int n, boolean bl) {
    }

    @Override
    public void updateDoorLockingUserProfileControlProcessing(boolean bl, int n, boolean bl2, int n2) {
    }

    @Override
    public void updateDoorLockingWindowAutoClose(boolean bl, int n) {
    }

    @Override
    public void updateDoorLockingBlindsControl(int n, int n2) {
    }

    @Override
    public void updateDoorLockingTurnIndRepeat(boolean bl, int n) {
    }

    @Override
    public void updateWiperViewOptions(WiperViewOptions wiperViewOptions, int n) {
    }

    @Override
    public void updateWiperServicePosition(boolean bl, int n) {
    }

    @Override
    public void updateWiperRainSensorOnOff(boolean bl, int n) {
    }

    @Override
    public void updateWiperRainSensorConfig(int n, int n2) {
    }

    @Override
    public void updateWiperRearWiping(boolean bl, int n) {
    }

    @Override
    public void updateWiperTearsWiping(boolean bl, int n) {
    }

    @Override
    public void updateWiperWinterPosition(boolean bl, int n) {
    }

    @Override
    public void updateEasyEntrySteeringColumn(boolean bl, int n) {
    }

    @Override
    public void acknowledgeWiperSetFactoryDefault(boolean bl) {
    }

    @Override
    public void updateUGDOViewOptions(UGDOViewOptions uGDOViewOptions, int n) {
    }

    @Override
    public void updateUGDOLearningData(UGDOLearningData uGDOLearningData, int n) {
    }

    @Override
    public void updateUGDODestinationReached(UGDODestinationReached uGDODestinationReached, int n) {
    }

    @Override
    public void updateUGDOOpenDoor(UGDOOpenDoor uGDOOpenDoor, int n) {
    }

    @Override
    public void updateUGDOContent(UGDOContent uGDOContent, int n) {
    }

    @Override
    public void updateUGDOVersionData(UGDOVersionData uGDOVersionData, int n) {
    }

    @Override
    public void acknowledgeUGDOSetFactoryDefault(boolean bl) {
    }

    @Override
    public void updateUGDOButtonListUpdateInfo(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, int n) {
    }

    @Override
    public void updateUGDOButtonListTotalNumberOfElements(int n, int n2) {
    }

    @Override
    public void requestUGDOPopup(UGDOContent uGDOContent) {
    }

    @Override
    public void acknowledgeUGDOPopup(UGDOContent uGDOContent) {
    }

    @Override
    public void acknowledgeUGDODeleteButton(boolean bl) {
    }

    @Override
    public void acknowledgeUGDOSynchronisation(UGDOSynchronisation uGDOSynchronisation) {
    }

    @Override
    public void acknowledgeUGDOLearning(int n, int n2) {
    }

    @Override
    public void requestUGDOSynchronisation(UGDOSynchronisation uGDOSynchronisation) {
    }

    @Override
    public void responseUGDOButtonListRA0(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA0[] uGDOButtonListRA0Array) {
    }

    @Override
    public void responseUGDOButtonListRA1(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA1[] uGDOButtonListRA1Array) {
    }

    @Override
    public void responseUGDOButtonListRA2(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA2[] uGDOButtonListRA2Array) {
    }

    @Override
    public void responseUGDOButtonListRA3(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA3[] uGDOButtonListRA3Array) {
    }

    @Override
    public void responseUGDOButtonListRA4(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA4[] uGDOButtonListRA4Array) {
    }

    @Override
    public void responseUGDOButtonListRA5(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA5[] uGDOButtonListRA5Array) {
    }

    @Override
    public void responseUGDOButtonListRAF(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, int[] nArray) {
    }

    @Override
    public void updateRDKViewOptions(RDKViewOptions rDKViewOptions, int n) {
    }

    @Override
    public void updateRDKSystemOnOff(boolean bl, int n) {
    }

    @Override
    public void updateRDKTireSetupTireList(RDKTireInfo[] rDKTireInfoArray, int n) {
    }

    @Override
    public void updateRDKTireSetupSelectedTire(int n, int n2) {
    }

    @Override
    public void updateRDKTireDisplay(RDKTireDisplayData rDKTireDisplayData, int n) {
    }

    @Override
    public void updateRDKSpeedLimit(int n, int n2) {
    }

    @Override
    public void responseRDKTireChanged(int n) {
    }

    @Override
    public void responseRDKPressureChanged(int n) {
    }

    @Override
    public void responseRDKLifeMonitoring() {
    }

    @Override
    public void updateRDKPressureLevel(byte by, int n) {
    }

    @Override
    public void acknowledgeRDKSetFactoryDefault(boolean bl) {
    }

    @Override
    public void acknowledgeRDKPressureChanged(boolean bl) {
    }

    @Override
    public void updateMirrorViewOptions(MirrorViewOptions mirrorViewOptions, int n) {
    }

    @Override
    public void updateMirrorLowering(boolean bl, int n) {
    }

    @Override
    public void updateMirrorSyncAdjust(boolean bl, int n) {
    }

    @Override
    public void updateMirrorFolding(boolean bl, int n) {
    }

    @Override
    public void updateMirrorDimming(boolean bl, int n) {
    }

    @Override
    public void updateMirrorHeating(boolean bl, int n) {
    }

    @Override
    public void acknowledgeMirrorSetFactoryDefault(boolean bl) {
    }

    @Override
    public void updateBrakeViewOptions(BrakeViewOptions brakeViewOptions, int n) {
    }

    @Override
    public void updateBrakeElectricalParking(boolean bl, int n) {
    }

    @Override
    public void updateBrakeAutoHold(int n, int n2) {
    }

    @Override
    public void updateBrakeEscMode(int n, int n2) {
    }

    @Override
    public void updateBrakeHdcMode(boolean bl, int n) {
    }

    @Override
    public void updateRDKDifferentialPressure(RDKWheelPressures rDKWheelPressures, int n) {
    }

    @Override
    public void updateRDKResidualBatteryLifetime(RDKResidualBatteryLifetime rDKResidualBatteryLifetime, int n) {
    }

    @Override
    public void acknowledgeDoorLockingPrompt(int n) {
    }

    @Override
    public void requestDoorLockingPrompt(int n) {
    }

    @Override
    public void updateDoorLockingPromptContent(int n, int n2) {
    }

    @Override
    public void updateDoorLockingLeftSideBlindControl(int n, int n2) {
    }

    @Override
    public void updateDoorLockingRightSideBlindControl(int n, int n2) {
    }

    @Override
    public void updateDoorLockingKeyless(boolean bl, int n) {
    }

    @Override
    public void updateDoorLockingBlindsControlExtended(DoorLockingBootBlindState doorLockingBootBlindState, int n) {
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


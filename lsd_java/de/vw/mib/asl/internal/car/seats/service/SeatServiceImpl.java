/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.seats.service;

import de.vw.mib.asl.api.car.seat.SeatAdjustment;
import de.vw.mib.asl.api.car.seat.SeatDisplayRequest;
import de.vw.mib.asl.api.car.seat.SeatMassage;
import de.vw.mib.asl.api.car.seat.SeatService;
import de.vw.mib.asl.api.car.seat.SeatSetupSetting;
import de.vw.mib.asl.api.car.seat.SeatValueFactory;
import de.vw.mib.asl.internal.car.seats.SeatMainController;
import de.vw.mib.asl.internal.car.seats.service.SeatSettingsImpl;
import de.vw.mib.asl.internal.car.seats.service.SeatValueFactoryImpl;
import de.vw.mib.asl.internal.car.seats.transformer.SeatServiceTransformer;
import org.dsi.ifc.carseat.MassageData;
import org.dsi.ifc.carseat.SeatContent;
import org.dsi.ifc.carseat.SeatSpecialPosition;
import org.dsi.ifc.carseat.SwitcherDataBackForward;
import org.dsi.ifc.carseat.SwitcherDataUpDown;

public class SeatServiceImpl
implements SeatService {
    SeatMainController seatMainController;
    SeatValueFactory seatValueFactory = new SeatValueFactoryImpl();

    public SeatServiceImpl(SeatMainController seatMainController) {
        this.seatMainController = seatMainController;
    }

    public SeatMainController getSeatMainController() {
        return this.seatMainController;
    }

    @Override
    public void changeSeatMassage(SeatMassage seatMassage) {
        this.getSeatMainController().setMassageSettings(seatMassage);
    }

    @Override
    public SeatMassage getSeatMassageForZone(int n) {
        SeatMassage seatMassage;
        MassageData massageData = this.getSeatMainController().getSeatMassageOfZone(n);
        switch (n) {
            case 0: {
                seatMassage = new SeatValueFactoryImpl().createSeatMassage(0, massageData.program, massageData.intensity, massageData.speed);
                break;
            }
            case 1: {
                seatMassage = new SeatValueFactoryImpl().createSeatMassage(1, massageData.program, massageData.intensity, massageData.speed);
                break;
            }
            case 2: {
                seatMassage = new SeatValueFactoryImpl().createSeatMassage(2, massageData.program, massageData.intensity, massageData.speed);
                break;
            }
            case 3: {
                seatMassage = new SeatValueFactoryImpl().createSeatMassage(3, massageData.program, massageData.intensity, massageData.speed);
                break;
            }
            default: {
                seatMassage = null;
            }
        }
        return seatMassage;
    }

    @Override
    public SeatMassage[] getSeatMassageForAllZones() {
        MassageData[] massageDataArray = this.getSeatMainController().getSeatMassageOfAllZones();
        SeatMassage[] seatMassageArray = new SeatMassage[]{new SeatServiceTransformer().getSeatMassageFromDSIMassageData(0, massageDataArray[0]), new SeatServiceTransformer().getSeatMassageFromDSIMassageData(0, massageDataArray[0]), new SeatServiceTransformer().getSeatMassageFromDSIMassageData(0, massageDataArray[0]), new SeatServiceTransformer().getSeatMassageFromDSIMassageData(0, massageDataArray[0])};
        return seatMassageArray;
    }

    @Override
    public void changeSeatDisplayRequest(SeatDisplayRequest seatDisplayRequest, int n) {
        SeatContent seatContent = new SeatContent(seatDisplayRequest.getSeatDisplayRequestForSeatPosition(0), seatDisplayRequest.getSeatMemoryAdviceForSeatPosition(0), seatDisplayRequest.getSeatDisplayRequestForSeatPosition(1), seatDisplayRequest.getSeatMemoryAdviceForSeatPosition(1), seatDisplayRequest.getSeatDisplayRequestForSeatPosition(2), seatDisplayRequest.getSeatMemoryAdviceForSeatPosition(2), seatDisplayRequest.getSeatDisplayRequestForSeatPosition(3), seatDisplayRequest.getSeatMemoryAdviceForSeatPosition(3));
        switch (n) {
            case 2: {
                this.getSeatMainController().showSeatPopup(seatContent);
                break;
            }
            case 1: {
                this.getSeatMainController().cancelSeatPopup(seatContent, 1);
                break;
            }
            case 0: {
                this.getSeatMainController().cancelSeatPopup(seatContent, 0);
                break;
            }
        }
    }

    @Override
    public int getSeatDriverPosition() {
        int n = 0;
        if (!this.getSeatMainController().isDriverSideLeft()) {
            n = 1;
        }
        return n;
    }

    @Override
    public int getSeatFrontPassengerPosition() {
        int n = 1;
        if (!this.getSeatMainController().isDriverSideLeft()) {
            n = 0;
        }
        return n;
    }

    @Override
    public SeatSetupSetting getSeatSetupSetting(int n, int n2) {
        SeatSettingsImpl seatSettingsImpl = null;
        switch (n2) {
            case 1: {
                seatSettingsImpl = new SeatSettingsImpl(n2, n, this.getSeatMainController().getSeatEasyEntryExitOfSeatPosition(n));
                break;
            }
            case 3: {
                seatSettingsImpl = new SeatSettingsImpl(n2, n, this.getSeatMainController().getSeatBeltPretensionOfSeatPosition(n));
                break;
            }
            case 2: {
                seatSettingsImpl = new SeatSettingsImpl(n2, n, this.getSeatMainController().isSeatMemory());
                break;
            }
        }
        return seatSettingsImpl;
    }

    @Override
    public void changeSeatSetupSetting(SeatSetupSetting seatSetupSetting) {
        switch (seatSetupSetting.getSeatSettingType()) {
            case 1: {
                this.getSeatMainController().setSeatEasyEntryExit(seatSetupSetting.getSeatPosition(), seatSetupSetting.getSeatSettingValue());
                break;
            }
            case 3: {
                this.getSeatMainController().setSeatBeltPretension(seatSetupSetting.getSeatPosition(), seatSetupSetting.getSeatSettingValue());
                break;
            }
            case 2: {
                this.getSeatMainController().setSeatMemory(seatSetupSetting.getSeatSettingValue());
                break;
            }
        }
    }

    @Override
    public void resetRestingAndWorkingPosition() {
        this.getSeatMainController().resetRestingAndWorkingPosition();
    }

    @Override
    public SeatAdjustment getSeatAdjustment(int n, int n2, int n3) {
        SeatAdjustment seatAdjustment = null;
        return seatAdjustment;
    }

    @Override
    public void changeSeatAdjustment(SeatAdjustment seatAdjustment) {
        SwitcherDataBackForward switcherDataBackForward = new SwitcherDataBackForward();
        SwitcherDataUpDown switcherDataUpDown = new SwitcherDataUpDown();
        switch (seatAdjustment.getIntValue(4)) {
            case 1: {
                switcherDataBackForward.sitztiefe = seatAdjustment.getBooleanvalue(3);
                this.getSeatMainController().setSeatAdjustmentBackFoward(seatAdjustment.getIntValue(1), seatAdjustment.getIntValue(2), switcherDataBackForward);
                break;
            }
            case 3: {
                switcherDataBackForward.lehnenwangen = seatAdjustment.getBooleanvalue(3);
                this.getSeatMainController().setSeatAdjustmentBackFoward(seatAdjustment.getIntValue(1), seatAdjustment.getIntValue(2), switcherDataBackForward);
                break;
            }
            case 4: {
                switcherDataBackForward.lehnenkopf = seatAdjustment.getBooleanvalue(3);
                this.getSeatMainController().setSeatAdjustmentBackFoward(seatAdjustment.getIntValue(1), seatAdjustment.getIntValue(2), switcherDataBackForward);
                break;
            }
            case 2: {
                switcherDataBackForward.lehnenkopf = seatAdjustment.getBooleanvalue(3);
                this.getSeatMainController().setSeatAdjustmentUpDown(seatAdjustment.getIntValue(1), seatAdjustment.getIntValue(2), switcherDataUpDown);
                break;
            }
        }
    }

    @Override
    public void changeSeatExtra(int n, int n2, boolean bl) {
        switch (n2) {
            case 1: {
                SeatSpecialPosition seatSpecialPosition = new SeatSpecialPosition(n, !this.getSeatMainController().isDriverSideLeft(), this.getSeatMainController().isDriverSideLeft(), true, true, false, false);
                this.getSeatMainController().setSeatSpeicalPosition(seatSpecialPosition);
                break;
            }
            case 2: {
                this.getSeatMainController().setSeatFoldHeadRest(n, bl);
                break;
            }
            case 3: {
                this.getSeatMainController().setCoDriverSettingsFromDriver(bl);
                break;
            }
        }
    }

    @Override
    public SeatValueFactory getSeatValueFactory() {
        return this.seatValueFactory;
    }
}


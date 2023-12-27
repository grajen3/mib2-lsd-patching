/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carseat;

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

public interface DSICarSeatReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updateSeatViewOptions(SeatViewOptions seatViewOptions, int n) {
    }

    default public void updateSeatRadioKeyAutomatic(boolean bl, int n) {
    }

    default public void updateSeatSpecialPosition(SeatSpecialPosition seatSpecialPosition, int n) {
    }

    default public void updateSeatSpecialPositionRearCoDriver(SeatSpecialPosition seatSpecialPosition, int n) {
    }

    default public void updateSeatFrontLeftStopButton(boolean bl, int n) {
    }

    default public void updateSeatFrontRightStopButton(boolean bl, int n) {
    }

    default public void updateSeatRearLeftStopButton(boolean bl, int n) {
    }

    default public void updateSeatRearRightStopButton(boolean bl, int n) {
    }

    default public void updateSeatCodriverSettingsFromDriver(boolean bl, int n) {
    }

    default public void updateSeatCodriverSettingsFromRear(boolean bl, int n) {
    }

    default public void updateSeatMassageData1RL(MassageData massageData, int n) {
    }

    default public void updateSeatMassageData1RR(MassageData massageData, int n) {
    }

    default public void updateSeatMassageData2RL(MassageData massageData, int n) {
    }

    default public void updateSeatMassageData2RR(MassageData massageData, int n) {
    }

    default public void updateSeatSwitcherDataUp1RL(SwitcherDataUpDown switcherDataUpDown, int n) {
    }

    default public void updateSeatSwitcherDataDown1RL(SwitcherDataUpDown switcherDataUpDown, int n) {
    }

    default public void updateSeatSwitcherDataForward1RL(SwitcherDataBackForward switcherDataBackForward, int n) {
    }

    default public void updateSeatSwitcherDataBack1RL(SwitcherDataBackForward switcherDataBackForward, int n) {
    }

    default public void updateSeatSwitcherDataUp1RR(SwitcherDataUpDown switcherDataUpDown, int n) {
    }

    default public void updateSeatSwitcherDataDown1RR(SwitcherDataUpDown switcherDataUpDown, int n) {
    }

    default public void updateSeatSwitcherDataForward1RR(SwitcherDataBackForward switcherDataBackForward, int n) {
    }

    default public void updateSeatSwitcherDataBack1RR(SwitcherDataBackForward switcherDataBackForward, int n) {
    }

    default public void updateSeatSwitcherDataUp2RL(SwitcherDataUpDown switcherDataUpDown, int n) {
    }

    default public void updateSeatSwitcherDataDown2RL(SwitcherDataUpDown switcherDataUpDown, int n) {
    }

    default public void updateSeatSwitcherDataForward2RL(SwitcherDataBackForward switcherDataBackForward, int n) {
    }

    default public void updateSeatSwitcherDataBack2RL(SwitcherDataBackForward switcherDataBackForward, int n) {
    }

    default public void updateSeatSwitcherDataUp2RR(SwitcherDataUpDown switcherDataUpDown, int n) {
    }

    default public void updateSeatSwitcherDataDown2RR(SwitcherDataUpDown switcherDataUpDown, int n) {
    }

    default public void updateSeatSwitcherDataForward2RR(SwitcherDataBackForward switcherDataBackForward, int n) {
    }

    default public void updateSeatSwitcherDataBack2RR(SwitcherDataBackForward switcherDataBackForward, int n) {
    }

    default public void updateSeatContent(SeatContent seatContent, int n) {
    }

    default public void updateSeatEasyEntryFrontLeft(boolean bl, int n) {
    }

    default public void updateSeatEasyEntryFrontRight(boolean bl, int n) {
    }

    default public void updateSeatEasyEntryRearLeft(boolean bl, int n) {
    }

    default public void updateSeatEasyEntryRearRight(boolean bl, int n) {
    }

    default public void requestSeatPopup(SeatContent seatContent) {
    }

    default public void acknowledgeSeatPopup(SeatContent seatContent) {
    }

    default public void updateSeatPneumaticViewOptions(SeatPneumaticViewOptions seatPneumaticViewOptions, int n) {
    }

    default public void updateSeatPneumaticCodriverSettingsFromDriver(boolean bl, int n) {
    }

    default public void updateSeatPneumaticMassageData1RL(MassageData massageData, int n) {
    }

    default public void updateSeatPneumaticMassageData1RR(MassageData massageData, int n) {
    }

    default public void updateSeatPneumaticSwitcherDataUp1RL(SwitcherDataUpDown switcherDataUpDown, int n) {
    }

    default public void updateSeatPneumaticSwitcherDataDown1RL(SwitcherDataUpDown switcherDataUpDown, int n) {
    }

    default public void updateSeatPneumaticSwitcherDataForward1RL(SwitcherDataBackForward switcherDataBackForward, int n) {
    }

    default public void updateSeatPneumaticSwitcherDataBack1RL(SwitcherDataBackForward switcherDataBackForward, int n) {
    }

    default public void updateSeatPneumaticSwitcherDataUp1RR(SwitcherDataUpDown switcherDataUpDown, int n) {
    }

    default public void updateSeatPneumaticSwitcherDataDown1RR(SwitcherDataUpDown switcherDataUpDown, int n) {
    }

    default public void updateSeatPneumaticSwitcherDataForward1RR(SwitcherDataBackForward switcherDataBackForward, int n) {
    }

    default public void updateSeatPneumaticSwitcherDataBack1RR(SwitcherDataBackForward switcherDataBackForward, int n) {
    }

    default public void updateSeatPneumaticContent(SeatPneumaticContent seatPneumaticContent, int n) {
    }

    default public void requestSeatPneumaticPopup(SeatPneumaticContent seatPneumaticContent) {
    }

    default public void acknowledgeSeatPneumaticPopup(SeatPneumaticContent seatPneumaticContent) {
    }

    default public void acknowledgeSeatSetFactoryDefault(boolean bl) {
    }

    default public void acknowledgeSeatPneumaticSetFactoryDefault(boolean bl) {
    }

    default public void acknowledgeSeatDeleteSpecialPosition(boolean bl) {
    }

    default public void acknowledgeSeatMoveRearSeatDisplay(boolean bl) {
    }

    default public void updateSeatAdjustment1RL(SeatAdjustment seatAdjustment, int n) {
    }

    default public void updateSeatAdjustment1RR(SeatAdjustment seatAdjustment, int n) {
    }

    default public void updateSeatAdjustment2RL(SeatAdjustment seatAdjustment, int n) {
    }

    default public void updateSeatAdjustment2RR(SeatAdjustment seatAdjustment, int n) {
    }

    default public void updateSeatCoDriverSettingsFromRearActivation(boolean bl, int n) {
    }

    default public void updateSeatRestSeatStatus(RestSeatStatus restSeatStatus, int n) {
    }

    default public void updateSeatFoldHeadRestRearDriver(boolean bl, int n) {
    }

    default public void updateSeatFoldHeadRestRearCoDriver(boolean bl, int n) {
    }

    default public void updateSeatPremiumMassageData1RL(MassageData massageData, int n) {
    }

    default public void updateSeatPremiumMassageData1RR(MassageData massageData, int n) {
    }

    default public void updateSeatPremiumMassageData2RL(MassageData massageData, int n) {
    }

    default public void updateSeatPremiumMassageData2RR(MassageData massageData, int n) {
    }

    default public void updateSeatPremiumMassageSwitcher1RL(boolean bl, int n) {
    }

    default public void updateSeatPremiumMassageSwitcher1RR(boolean bl, int n) {
    }

    default public void updateSeatPremiumMassageSwitcher2RL(boolean bl, int n) {
    }

    default public void updateSeatPremiumMassageSwitcher2RR(boolean bl, int n) {
    }

    default public void updateSeatMassageSwitcher1RL(boolean bl, int n) {
    }

    default public void updateSeatMassageSwitcher1RR(boolean bl, int n) {
    }

    default public void updateSeatMassageSwitcher2RL(boolean bl, int n) {
    }

    default public void updateSeatMassageSwitcher2RR(boolean bl, int n) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}


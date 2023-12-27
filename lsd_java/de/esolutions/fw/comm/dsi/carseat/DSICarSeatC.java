/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carseat;

import org.dsi.ifc.carseat.MassageData;
import org.dsi.ifc.carseat.SeatAdjustment;
import org.dsi.ifc.carseat.SeatContent;
import org.dsi.ifc.carseat.SeatPneumaticContent;
import org.dsi.ifc.carseat.SeatSpecialPosition;
import org.dsi.ifc.carseat.SwitcherDataBackForward;
import org.dsi.ifc.carseat.SwitcherDataUpDown;

public interface DSICarSeatC {
    default public void setSeatRadioKeyAutomatic(boolean bl) {
    }

    default public void setSeatCodriverSettingsFromRear(boolean bl) {
    }

    default public void setSeatCodriverSettingsFromDriver(boolean bl) {
    }

    default public void setSeatEasyEntryFrontLeft(boolean bl) {
    }

    default public void setSeatEasyEntryFrontRight(boolean bl) {
    }

    default public void setSeatEasyEntryRearLeft(boolean bl) {
    }

    default public void setSeatEasyEntryRearRight(boolean bl) {
    }

    default public void setSeatSpecialPosition(SeatSpecialPosition seatSpecialPosition) {
    }

    default public void setSeatSpecialPositionRearCoDriver(SeatSpecialPosition seatSpecialPosition) {
    }

    default public void showSeatPopup(SeatContent seatContent) {
    }

    default public void cancelSeatPopup(SeatContent seatContent, int n) {
    }

    default public void setSeatHMIIsReady(boolean bl) {
    }

    default public void setSeatPneumaticCodriverSettingsFromDriver(boolean bl) {
    }

    default public void showSeatPneumaticPopup(SeatPneumaticContent seatPneumaticContent) {
    }

    default public void cancelSeatPneumaticPopup(SeatPneumaticContent seatPneumaticContent, int n) {
    }

    default public void setSeatSetFactoryDefault() {
    }

    default public void setSeatPneumaticSetFactoryDefault() {
    }

    default public void startSeatMoveRearSeatDisplay() {
    }

    default public void abortSeatMoveRearSeatDisplay() {
    }

    default public void setSeatMassageData(int n, MassageData massageData) {
    }

    default public void setSeatSwitcherDataUp(int n, SwitcherDataUpDown switcherDataUpDown) {
    }

    default public void setSeatSwitcherDataDown(int n, SwitcherDataUpDown switcherDataUpDown) {
    }

    default public void setSeatSwitcherDataForward(int n, SwitcherDataBackForward switcherDataBackForward) {
    }

    default public void setSeatSwitcherDataBack(int n, SwitcherDataBackForward switcherDataBackForward) {
    }

    default public void setSeatAdjustment(int n, SeatAdjustment seatAdjustment) {
    }

    default public void startSeatDeleteSpecialPosition(boolean bl, boolean bl2) {
    }

    default public void setSeatCoDriverSettingsFromRearActivation(boolean bl) {
    }

    default public void setSeatFoldHeadRestRearDriver(boolean bl) {
    }

    default public void setSeatFoldHeadRestRearCoDriver(boolean bl) {
    }

    default public void setSeatStopButton(int n, boolean bl) {
    }

    default public void setSeatPremiumMassageData(int n, MassageData massageData) {
    }

    default public void setSeatPremiumMassageSwitcher(int n, boolean bl) {
    }

    default public void setSeatMassageSwitcher(int n, boolean bl) {
    }

    default public void setNotification(int[] nArray) {
    }

    default public void setNotification(int n) {
    }

    default public void setNotification() {
    }

    default public void clearNotification(int[] nArray) {
    }

    default public void clearNotification(int n) {
    }

    default public void clearNotification() {
    }

    default public void yySet(String string, String string2) {
    }
}


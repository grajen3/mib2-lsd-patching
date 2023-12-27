/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carseat;

import org.dsi.ifc.global.CarViewOption;

public class SeatZoneViewOptions {
    public CarViewOption seatSwitcherUp;
    public CarViewOption seatSwitcherDown;
    public CarViewOption seatSwitcherBackward;
    public CarViewOption seatSwitcherForward;
    public CarViewOption seatAdjustment;
    public CarViewOption seatStopButton;
    public CarViewOption seatMassage;
    public CarViewOption seatMassageSwitcher;
    public CarViewOption seatPremiumMassage;
    public CarViewOption seatPremiumMassageSwitcher;

    public SeatZoneViewOptions() {
        this.seatSwitcherUp = null;
        this.seatSwitcherDown = null;
        this.seatSwitcherBackward = null;
        this.seatSwitcherForward = null;
        this.seatAdjustment = null;
        this.seatStopButton = null;
        this.seatMassage = null;
        this.seatMassageSwitcher = null;
        this.seatPremiumMassage = null;
        this.seatPremiumMassageSwitcher = null;
    }

    public SeatZoneViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2, CarViewOption carViewOption3, CarViewOption carViewOption4, CarViewOption carViewOption5, CarViewOption carViewOption6, CarViewOption carViewOption7, CarViewOption carViewOption8, CarViewOption carViewOption9, CarViewOption carViewOption10) {
        this.seatSwitcherUp = carViewOption;
        this.seatSwitcherDown = carViewOption2;
        this.seatSwitcherBackward = carViewOption3;
        this.seatSwitcherForward = carViewOption4;
        this.seatAdjustment = carViewOption5;
        this.seatStopButton = carViewOption6;
        this.seatMassage = carViewOption7;
        this.seatMassageSwitcher = carViewOption8;
        this.seatPremiumMassage = carViewOption9;
        this.seatPremiumMassageSwitcher = carViewOption10;
    }

    public CarViewOption getSeatSwitcherUp() {
        return this.seatSwitcherUp;
    }

    public CarViewOption getSeatSwitcherDown() {
        return this.seatSwitcherDown;
    }

    public CarViewOption getSeatSwitcherBackward() {
        return this.seatSwitcherBackward;
    }

    public CarViewOption getSeatSwitcherForward() {
        return this.seatSwitcherForward;
    }

    public CarViewOption getSeatAdjustment() {
        return this.seatAdjustment;
    }

    public CarViewOption getSeatStopButton() {
        return this.seatStopButton;
    }

    public CarViewOption getSeatMassage() {
        return this.seatMassage;
    }

    public CarViewOption getSeatMassageSwitcher() {
        return this.seatMassageSwitcher;
    }

    public CarViewOption getSeatPremiumMassage() {
        return this.seatPremiumMassage;
    }

    public CarViewOption getSeatPremiumMassageSwitcher() {
        return this.seatPremiumMassageSwitcher;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(10450);
        stringBuffer.append("SeatZoneViewOptions");
        stringBuffer.append('(');
        stringBuffer.append("seatSwitcherUp");
        stringBuffer.append('=');
        stringBuffer.append(this.seatSwitcherUp);
        stringBuffer.append(',');
        stringBuffer.append("seatSwitcherDown");
        stringBuffer.append('=');
        stringBuffer.append(this.seatSwitcherDown);
        stringBuffer.append(',');
        stringBuffer.append("seatSwitcherBackward");
        stringBuffer.append('=');
        stringBuffer.append(this.seatSwitcherBackward);
        stringBuffer.append(',');
        stringBuffer.append("seatSwitcherForward");
        stringBuffer.append('=');
        stringBuffer.append(this.seatSwitcherForward);
        stringBuffer.append(',');
        stringBuffer.append("seatAdjustment");
        stringBuffer.append('=');
        stringBuffer.append(this.seatAdjustment);
        stringBuffer.append(',');
        stringBuffer.append("seatStopButton");
        stringBuffer.append('=');
        stringBuffer.append(this.seatStopButton);
        stringBuffer.append(',');
        stringBuffer.append("seatMassage");
        stringBuffer.append('=');
        stringBuffer.append(this.seatMassage);
        stringBuffer.append(',');
        stringBuffer.append("seatMassageSwitcher");
        stringBuffer.append('=');
        stringBuffer.append(this.seatMassageSwitcher);
        stringBuffer.append(',');
        stringBuffer.append("seatPremiumMassage");
        stringBuffer.append('=');
        stringBuffer.append(this.seatPremiumMassage);
        stringBuffer.append(',');
        stringBuffer.append("seatPremiumMassageSwitcher");
        stringBuffer.append('=');
        stringBuffer.append(this.seatPremiumMassageSwitcher);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


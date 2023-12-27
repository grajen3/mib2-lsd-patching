/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carseat;

import org.dsi.ifc.carseat.MassageConfig;
import org.dsi.ifc.carseat.SeatZoneViewOptions;
import org.dsi.ifc.carseat.SeatmemoryConfig;
import org.dsi.ifc.carseat.VisualizationConfig;
import org.dsi.ifc.global.CarViewOption;

public class SeatViewOptions {
    public CarViewOption seatRadioKeyAutomatic;
    public CarViewOption seatCoDriverSettingsFromDriver;
    public CarViewOption seatCoDriverSettingsFromRear;
    public CarViewOption seatEasyEntryFrontLeft;
    public CarViewOption seatEasyEntryFrontRight;
    public CarViewOption seatEasyEntryRearLeft;
    public CarViewOption seatEasyEntryRearRight;
    public CarViewOption seatSpecialPosition;
    public CarViewOption seatSetFactoryDefault;
    public SeatmemoryConfig seatmemoryConfig;
    public MassageConfig massageConfig1RL;
    public MassageConfig massageConfig1RR;
    public VisualizationConfig visualizationConfig1RL;
    public VisualizationConfig visualizationConfig1RR;
    public VisualizationConfig visualizationConfig2RL;
    public VisualizationConfig visualizationConfig2RR;
    public MassageConfig massageConfig2RL;
    public MassageConfig massageConfig2RR;
    public CarViewOption seatSpecialPositionRearCoDriver;
    public CarViewOption seatDeleteSpecialPosition;
    public CarViewOption seatCoDriverSettingsFromRearActivation;
    public CarViewOption seatRestSeatStatus;
    public CarViewOption seatMoveRearSeatDisplay;
    public CarViewOption seatFoldHeadRestRearDriver;
    public CarViewOption seatFoldHeadRestRearCoDriver;
    public SeatZoneViewOptions seatSettings1RL;
    public SeatZoneViewOptions seatSettings1RR;
    public SeatZoneViewOptions seatSettings2RL;
    public SeatZoneViewOptions seatSettings2RR;
    public MassageConfig premiumMassageConfig1RL;
    public MassageConfig premiumMassageConfig1RR;
    public MassageConfig premiumMassageConfig2RL;
    public MassageConfig premiumMassageConfig2RR;

    public SeatViewOptions() {
        this.seatRadioKeyAutomatic = null;
        this.seatCoDriverSettingsFromDriver = null;
        this.seatCoDriverSettingsFromRear = null;
        this.seatEasyEntryFrontLeft = null;
        this.seatEasyEntryFrontRight = null;
        this.seatEasyEntryRearLeft = null;
        this.seatEasyEntryRearRight = null;
        this.seatSpecialPosition = null;
        this.seatSetFactoryDefault = null;
        this.seatmemoryConfig = null;
        this.massageConfig1RL = null;
        this.massageConfig1RR = null;
        this.visualizationConfig1RL = null;
        this.visualizationConfig1RR = null;
        this.visualizationConfig2RL = null;
        this.visualizationConfig2RR = null;
        this.massageConfig2RL = null;
        this.massageConfig2RR = null;
        this.seatSpecialPositionRearCoDriver = null;
        this.seatDeleteSpecialPosition = null;
        this.seatCoDriverSettingsFromRearActivation = null;
        this.seatRestSeatStatus = null;
        this.seatMoveRearSeatDisplay = null;
        this.seatFoldHeadRestRearDriver = null;
        this.seatFoldHeadRestRearCoDriver = null;
        this.seatSettings1RL = null;
        this.seatSettings1RR = null;
        this.seatSettings2RL = null;
        this.seatSettings2RR = null;
        this.premiumMassageConfig1RL = null;
        this.premiumMassageConfig1RR = null;
        this.premiumMassageConfig2RL = null;
        this.premiumMassageConfig2RR = null;
    }

    public SeatViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2, CarViewOption carViewOption3, CarViewOption carViewOption4, CarViewOption carViewOption5, CarViewOption carViewOption6, CarViewOption carViewOption7, CarViewOption carViewOption8, CarViewOption carViewOption9, SeatmemoryConfig seatmemoryConfig, MassageConfig massageConfig, MassageConfig massageConfig2, VisualizationConfig visualizationConfig, VisualizationConfig visualizationConfig2) {
        this.seatRadioKeyAutomatic = carViewOption;
        this.seatCoDriverSettingsFromDriver = carViewOption2;
        this.seatCoDriverSettingsFromRear = carViewOption3;
        this.seatEasyEntryFrontLeft = carViewOption4;
        this.seatEasyEntryFrontRight = carViewOption5;
        this.seatEasyEntryRearLeft = carViewOption6;
        this.seatEasyEntryRearRight = carViewOption7;
        this.seatSpecialPosition = carViewOption8;
        this.seatSetFactoryDefault = carViewOption9;
        this.seatmemoryConfig = seatmemoryConfig;
        this.massageConfig1RL = massageConfig;
        this.massageConfig1RR = massageConfig2;
        this.visualizationConfig1RL = visualizationConfig;
        this.visualizationConfig1RR = visualizationConfig2;
        this.visualizationConfig2RL = null;
        this.visualizationConfig2RR = null;
        this.massageConfig2RL = null;
        this.massageConfig2RR = null;
        this.seatSpecialPositionRearCoDriver = null;
        this.seatDeleteSpecialPosition = null;
        this.seatCoDriverSettingsFromRearActivation = null;
        this.seatRestSeatStatus = null;
        this.seatMoveRearSeatDisplay = null;
        this.seatFoldHeadRestRearDriver = null;
        this.seatFoldHeadRestRearCoDriver = null;
        this.seatSettings1RL = null;
        this.seatSettings1RR = null;
        this.seatSettings2RL = null;
        this.seatSettings2RR = null;
        this.premiumMassageConfig1RL = null;
        this.premiumMassageConfig1RR = null;
        this.premiumMassageConfig2RL = null;
        this.premiumMassageConfig2RR = null;
    }

    public SeatViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2, CarViewOption carViewOption3, CarViewOption carViewOption4, CarViewOption carViewOption5, CarViewOption carViewOption6, CarViewOption carViewOption7, CarViewOption carViewOption8, CarViewOption carViewOption9, SeatmemoryConfig seatmemoryConfig, MassageConfig massageConfig, MassageConfig massageConfig2, VisualizationConfig visualizationConfig, VisualizationConfig visualizationConfig2, VisualizationConfig visualizationConfig3, VisualizationConfig visualizationConfig4, MassageConfig massageConfig3, MassageConfig massageConfig4, CarViewOption carViewOption10, CarViewOption carViewOption11, CarViewOption carViewOption12, CarViewOption carViewOption13, CarViewOption carViewOption14, CarViewOption carViewOption15, CarViewOption carViewOption16, SeatZoneViewOptions seatZoneViewOptions, SeatZoneViewOptions seatZoneViewOptions2, SeatZoneViewOptions seatZoneViewOptions3, SeatZoneViewOptions seatZoneViewOptions4, MassageConfig massageConfig5, MassageConfig massageConfig6, MassageConfig massageConfig7, MassageConfig massageConfig8) {
        this.seatRadioKeyAutomatic = carViewOption;
        this.seatCoDriverSettingsFromDriver = carViewOption2;
        this.seatCoDriverSettingsFromRear = carViewOption3;
        this.seatEasyEntryFrontLeft = carViewOption4;
        this.seatEasyEntryFrontRight = carViewOption5;
        this.seatEasyEntryRearLeft = carViewOption6;
        this.seatEasyEntryRearRight = carViewOption7;
        this.seatSpecialPosition = carViewOption8;
        this.seatSetFactoryDefault = carViewOption9;
        this.seatmemoryConfig = seatmemoryConfig;
        this.massageConfig1RL = massageConfig;
        this.massageConfig1RR = massageConfig2;
        this.visualizationConfig1RL = visualizationConfig;
        this.visualizationConfig1RR = visualizationConfig2;
        this.visualizationConfig2RL = visualizationConfig3;
        this.visualizationConfig2RR = visualizationConfig4;
        this.massageConfig2RL = massageConfig3;
        this.massageConfig2RR = massageConfig4;
        this.seatSpecialPositionRearCoDriver = carViewOption10;
        this.seatDeleteSpecialPosition = carViewOption11;
        this.seatCoDriverSettingsFromRearActivation = carViewOption12;
        this.seatRestSeatStatus = carViewOption13;
        this.seatMoveRearSeatDisplay = carViewOption14;
        this.seatFoldHeadRestRearDriver = carViewOption15;
        this.seatFoldHeadRestRearCoDriver = carViewOption16;
        this.seatSettings1RL = seatZoneViewOptions;
        this.seatSettings1RR = seatZoneViewOptions2;
        this.seatSettings2RL = seatZoneViewOptions3;
        this.seatSettings2RR = seatZoneViewOptions4;
        this.premiumMassageConfig1RL = massageConfig5;
        this.premiumMassageConfig1RR = massageConfig6;
        this.premiumMassageConfig2RL = massageConfig7;
        this.premiumMassageConfig2RR = massageConfig8;
    }

    public CarViewOption getSeatRadioKeyAutomatic() {
        return this.seatRadioKeyAutomatic;
    }

    public CarViewOption getSeatCoDriverSettingsFromDriver() {
        return this.seatCoDriverSettingsFromDriver;
    }

    public CarViewOption getSeatCoDriverSettingsFromRear() {
        return this.seatCoDriverSettingsFromRear;
    }

    public CarViewOption getSeatEasyEntryFrontLeft() {
        return this.seatEasyEntryFrontLeft;
    }

    public CarViewOption getSeatEasyEntryFrontRight() {
        return this.seatEasyEntryFrontRight;
    }

    public CarViewOption getSeatEasyEntryRearLeft() {
        return this.seatEasyEntryRearLeft;
    }

    public CarViewOption getSeatEasyEntryRearRight() {
        return this.seatEasyEntryRearRight;
    }

    public CarViewOption getSeatSpecialPosition() {
        return this.seatSpecialPosition;
    }

    public CarViewOption getSeatSetFactoryDefault() {
        return this.seatSetFactoryDefault;
    }

    public SeatmemoryConfig getSeatmemoryConfig() {
        return this.seatmemoryConfig;
    }

    public MassageConfig getMassageConfig1RL() {
        return this.massageConfig1RL;
    }

    public MassageConfig getMassageConfig1RR() {
        return this.massageConfig1RR;
    }

    public VisualizationConfig getVisualizationConfig1RL() {
        return this.visualizationConfig1RL;
    }

    public VisualizationConfig getVisualizationConfig1RR() {
        return this.visualizationConfig1RR;
    }

    public VisualizationConfig getVisualizationConfig2RL() {
        return this.visualizationConfig2RL;
    }

    public VisualizationConfig getVisualizationConfig2RR() {
        return this.visualizationConfig2RR;
    }

    public MassageConfig getMassageConfig2RL() {
        return this.massageConfig2RL;
    }

    public MassageConfig getMassageConfig2RR() {
        return this.massageConfig2RR;
    }

    public CarViewOption getSeatSpecialPositionRearCoDriver() {
        return this.seatSpecialPositionRearCoDriver;
    }

    public CarViewOption getSeatDeleteSpecialPosition() {
        return this.seatDeleteSpecialPosition;
    }

    public CarViewOption getSeatCoDriverSettingsFromRearActivation() {
        return this.seatCoDriverSettingsFromRearActivation;
    }

    public CarViewOption getSeatRestSeatStatus() {
        return this.seatRestSeatStatus;
    }

    public CarViewOption getSeatMoveRearSeatDisplay() {
        return this.seatMoveRearSeatDisplay;
    }

    public CarViewOption getSeatFoldHeadRestRearDriver() {
        return this.seatFoldHeadRestRearDriver;
    }

    public CarViewOption getSeatFoldHeadRestRearCoDriver() {
        return this.seatFoldHeadRestRearCoDriver;
    }

    public SeatZoneViewOptions getSeatSettings1RL() {
        return this.seatSettings1RL;
    }

    public SeatZoneViewOptions getSeatSettings1RR() {
        return this.seatSettings1RR;
    }

    public SeatZoneViewOptions getSeatSettings2RL() {
        return this.seatSettings2RL;
    }

    public SeatZoneViewOptions getSeatSettings2RR() {
        return this.seatSettings2RR;
    }

    public MassageConfig getPremiumMassageConfig1RL() {
        return this.premiumMassageConfig1RL;
    }

    public MassageConfig getPremiumMassageConfig1RR() {
        return this.premiumMassageConfig1RR;
    }

    public MassageConfig getPremiumMassageConfig2RL() {
        return this.premiumMassageConfig2RL;
    }

    public MassageConfig getPremiumMassageConfig2RR() {
        return this.premiumMassageConfig2RR;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(-259588096);
        stringBuffer.append("SeatViewOptions");
        stringBuffer.append('(');
        stringBuffer.append("seatRadioKeyAutomatic");
        stringBuffer.append('=');
        stringBuffer.append(this.seatRadioKeyAutomatic);
        stringBuffer.append(',');
        stringBuffer.append("seatCoDriverSettingsFromDriver");
        stringBuffer.append('=');
        stringBuffer.append(this.seatCoDriverSettingsFromDriver);
        stringBuffer.append(',');
        stringBuffer.append("seatCoDriverSettingsFromRear");
        stringBuffer.append('=');
        stringBuffer.append(this.seatCoDriverSettingsFromRear);
        stringBuffer.append(',');
        stringBuffer.append("seatEasyEntryFrontLeft");
        stringBuffer.append('=');
        stringBuffer.append(this.seatEasyEntryFrontLeft);
        stringBuffer.append(',');
        stringBuffer.append("seatEasyEntryFrontRight");
        stringBuffer.append('=');
        stringBuffer.append(this.seatEasyEntryFrontRight);
        stringBuffer.append(',');
        stringBuffer.append("seatEasyEntryRearLeft");
        stringBuffer.append('=');
        stringBuffer.append(this.seatEasyEntryRearLeft);
        stringBuffer.append(',');
        stringBuffer.append("seatEasyEntryRearRight");
        stringBuffer.append('=');
        stringBuffer.append(this.seatEasyEntryRearRight);
        stringBuffer.append(',');
        stringBuffer.append("seatSpecialPosition");
        stringBuffer.append('=');
        stringBuffer.append(this.seatSpecialPosition);
        stringBuffer.append(',');
        stringBuffer.append("seatSetFactoryDefault");
        stringBuffer.append('=');
        stringBuffer.append(this.seatSetFactoryDefault);
        stringBuffer.append(',');
        stringBuffer.append("seatmemoryConfig");
        stringBuffer.append('=');
        stringBuffer.append(this.seatmemoryConfig);
        stringBuffer.append(',');
        stringBuffer.append("massageConfig1RL");
        stringBuffer.append('=');
        stringBuffer.append(this.massageConfig1RL);
        stringBuffer.append(',');
        stringBuffer.append("massageConfig1RR");
        stringBuffer.append('=');
        stringBuffer.append(this.massageConfig1RR);
        stringBuffer.append(',');
        stringBuffer.append("visualizationConfig1RL");
        stringBuffer.append('=');
        stringBuffer.append(this.visualizationConfig1RL);
        stringBuffer.append(',');
        stringBuffer.append("visualizationConfig1RR");
        stringBuffer.append('=');
        stringBuffer.append(this.visualizationConfig1RR);
        stringBuffer.append(',');
        stringBuffer.append("visualizationConfig2RL");
        stringBuffer.append('=');
        stringBuffer.append(this.visualizationConfig2RL);
        stringBuffer.append(',');
        stringBuffer.append("visualizationConfig2RR");
        stringBuffer.append('=');
        stringBuffer.append(this.visualizationConfig2RR);
        stringBuffer.append(',');
        stringBuffer.append("massageConfig2RL");
        stringBuffer.append('=');
        stringBuffer.append(this.massageConfig2RL);
        stringBuffer.append(',');
        stringBuffer.append("massageConfig2RR");
        stringBuffer.append('=');
        stringBuffer.append(this.massageConfig2RR);
        stringBuffer.append(',');
        stringBuffer.append("seatSpecialPositionRearCoDriver");
        stringBuffer.append('=');
        stringBuffer.append(this.seatSpecialPositionRearCoDriver);
        stringBuffer.append(',');
        stringBuffer.append("seatDeleteSpecialPosition");
        stringBuffer.append('=');
        stringBuffer.append(this.seatDeleteSpecialPosition);
        stringBuffer.append(',');
        stringBuffer.append("seatCoDriverSettingsFromRearActivation");
        stringBuffer.append('=');
        stringBuffer.append(this.seatCoDriverSettingsFromRearActivation);
        stringBuffer.append(',');
        stringBuffer.append("seatRestSeatStatus");
        stringBuffer.append('=');
        stringBuffer.append(this.seatRestSeatStatus);
        stringBuffer.append(',');
        stringBuffer.append("seatMoveRearSeatDisplay");
        stringBuffer.append('=');
        stringBuffer.append(this.seatMoveRearSeatDisplay);
        stringBuffer.append(',');
        stringBuffer.append("seatFoldHeadRestRearDriver");
        stringBuffer.append('=');
        stringBuffer.append(this.seatFoldHeadRestRearDriver);
        stringBuffer.append(',');
        stringBuffer.append("seatFoldHeadRestRearCoDriver");
        stringBuffer.append('=');
        stringBuffer.append(this.seatFoldHeadRestRearCoDriver);
        stringBuffer.append(',');
        stringBuffer.append("seatSettings1RL");
        stringBuffer.append('=');
        stringBuffer.append(this.seatSettings1RL);
        stringBuffer.append(',');
        stringBuffer.append("seatSettings1RR");
        stringBuffer.append('=');
        stringBuffer.append(this.seatSettings1RR);
        stringBuffer.append(',');
        stringBuffer.append("seatSettings2RL");
        stringBuffer.append('=');
        stringBuffer.append(this.seatSettings2RL);
        stringBuffer.append(',');
        stringBuffer.append("seatSettings2RR");
        stringBuffer.append('=');
        stringBuffer.append(this.seatSettings2RR);
        stringBuffer.append(',');
        stringBuffer.append("premiumMassageConfig1RL");
        stringBuffer.append('=');
        stringBuffer.append(this.premiumMassageConfig1RL);
        stringBuffer.append(',');
        stringBuffer.append("premiumMassageConfig1RR");
        stringBuffer.append('=');
        stringBuffer.append(this.premiumMassageConfig1RR);
        stringBuffer.append(',');
        stringBuffer.append("premiumMassageConfig2RL");
        stringBuffer.append('=');
        stringBuffer.append(this.premiumMassageConfig2RL);
        stringBuffer.append(',');
        stringBuffer.append("premiumMassageConfig2RR");
        stringBuffer.append('=');
        stringBuffer.append(this.premiumMassageConfig2RR);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carseat.impl;

import de.esolutions.fw.comm.dsi.carseat.impl.MassageConfigSerializer;
import de.esolutions.fw.comm.dsi.carseat.impl.SeatZoneViewOptionsSerializer;
import de.esolutions.fw.comm.dsi.carseat.impl.SeatmemoryConfigSerializer;
import de.esolutions.fw.comm.dsi.carseat.impl.VisualizationConfigSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarViewOptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carseat.MassageConfig;
import org.dsi.ifc.carseat.SeatViewOptions;
import org.dsi.ifc.carseat.SeatZoneViewOptions;
import org.dsi.ifc.carseat.SeatmemoryConfig;
import org.dsi.ifc.carseat.VisualizationConfig;
import org.dsi.ifc.global.CarViewOption;

public class SeatViewOptionsSerializer {
    public static void putOptionalSeatViewOptions(ISerializer iSerializer, SeatViewOptions seatViewOptions) {
        boolean bl = seatViewOptions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarViewOption carViewOption = seatViewOptions.getSeatRadioKeyAutomatic();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption);
            CarViewOption carViewOption2 = seatViewOptions.getSeatCoDriverSettingsFromDriver();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption2);
            CarViewOption carViewOption3 = seatViewOptions.getSeatCoDriverSettingsFromRear();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption3);
            CarViewOption carViewOption4 = seatViewOptions.getSeatEasyEntryFrontLeft();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption4);
            CarViewOption carViewOption5 = seatViewOptions.getSeatEasyEntryFrontRight();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption5);
            CarViewOption carViewOption6 = seatViewOptions.getSeatEasyEntryRearLeft();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption6);
            CarViewOption carViewOption7 = seatViewOptions.getSeatEasyEntryRearRight();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption7);
            CarViewOption carViewOption8 = seatViewOptions.getSeatSpecialPosition();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption8);
            CarViewOption carViewOption9 = seatViewOptions.getSeatSetFactoryDefault();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption9);
            SeatmemoryConfig seatmemoryConfig = seatViewOptions.getSeatmemoryConfig();
            SeatmemoryConfigSerializer.putOptionalSeatmemoryConfig(iSerializer, seatmemoryConfig);
            MassageConfig massageConfig = seatViewOptions.getMassageConfig1RL();
            MassageConfigSerializer.putOptionalMassageConfig(iSerializer, massageConfig);
            MassageConfig massageConfig2 = seatViewOptions.getMassageConfig1RR();
            MassageConfigSerializer.putOptionalMassageConfig(iSerializer, massageConfig2);
            VisualizationConfig visualizationConfig = seatViewOptions.getVisualizationConfig1RL();
            VisualizationConfigSerializer.putOptionalVisualizationConfig(iSerializer, visualizationConfig);
            VisualizationConfig visualizationConfig2 = seatViewOptions.getVisualizationConfig1RR();
            VisualizationConfigSerializer.putOptionalVisualizationConfig(iSerializer, visualizationConfig2);
            VisualizationConfig visualizationConfig3 = seatViewOptions.getVisualizationConfig2RL();
            VisualizationConfigSerializer.putOptionalVisualizationConfig(iSerializer, visualizationConfig3);
            VisualizationConfig visualizationConfig4 = seatViewOptions.getVisualizationConfig2RR();
            VisualizationConfigSerializer.putOptionalVisualizationConfig(iSerializer, visualizationConfig4);
            MassageConfig massageConfig3 = seatViewOptions.getMassageConfig2RL();
            MassageConfigSerializer.putOptionalMassageConfig(iSerializer, massageConfig3);
            MassageConfig massageConfig4 = seatViewOptions.getMassageConfig2RR();
            MassageConfigSerializer.putOptionalMassageConfig(iSerializer, massageConfig4);
            CarViewOption carViewOption10 = seatViewOptions.getSeatSpecialPositionRearCoDriver();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption10);
            CarViewOption carViewOption11 = seatViewOptions.getSeatDeleteSpecialPosition();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption11);
            CarViewOption carViewOption12 = seatViewOptions.getSeatCoDriverSettingsFromRearActivation();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption12);
            CarViewOption carViewOption13 = seatViewOptions.getSeatRestSeatStatus();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption13);
            CarViewOption carViewOption14 = seatViewOptions.getSeatMoveRearSeatDisplay();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption14);
            CarViewOption carViewOption15 = seatViewOptions.getSeatFoldHeadRestRearDriver();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption15);
            CarViewOption carViewOption16 = seatViewOptions.getSeatFoldHeadRestRearCoDriver();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption16);
            SeatZoneViewOptions seatZoneViewOptions = seatViewOptions.getSeatSettings1RL();
            SeatZoneViewOptionsSerializer.putOptionalSeatZoneViewOptions(iSerializer, seatZoneViewOptions);
            SeatZoneViewOptions seatZoneViewOptions2 = seatViewOptions.getSeatSettings1RR();
            SeatZoneViewOptionsSerializer.putOptionalSeatZoneViewOptions(iSerializer, seatZoneViewOptions2);
            SeatZoneViewOptions seatZoneViewOptions3 = seatViewOptions.getSeatSettings2RL();
            SeatZoneViewOptionsSerializer.putOptionalSeatZoneViewOptions(iSerializer, seatZoneViewOptions3);
            SeatZoneViewOptions seatZoneViewOptions4 = seatViewOptions.getSeatSettings2RR();
            SeatZoneViewOptionsSerializer.putOptionalSeatZoneViewOptions(iSerializer, seatZoneViewOptions4);
            MassageConfig massageConfig5 = seatViewOptions.getPremiumMassageConfig1RL();
            MassageConfigSerializer.putOptionalMassageConfig(iSerializer, massageConfig5);
            MassageConfig massageConfig6 = seatViewOptions.getPremiumMassageConfig1RR();
            MassageConfigSerializer.putOptionalMassageConfig(iSerializer, massageConfig6);
            MassageConfig massageConfig7 = seatViewOptions.getPremiumMassageConfig2RL();
            MassageConfigSerializer.putOptionalMassageConfig(iSerializer, massageConfig7);
            MassageConfig massageConfig8 = seatViewOptions.getPremiumMassageConfig2RR();
            MassageConfigSerializer.putOptionalMassageConfig(iSerializer, massageConfig8);
        }
    }

    public static void putOptionalSeatViewOptionsVarArray(ISerializer iSerializer, SeatViewOptions[] seatViewOptionsArray) {
        boolean bl = seatViewOptionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(seatViewOptionsArray.length);
            for (int i2 = 0; i2 < seatViewOptionsArray.length; ++i2) {
                SeatViewOptionsSerializer.putOptionalSeatViewOptions(iSerializer, seatViewOptionsArray[i2]);
            }
        }
    }

    public static SeatViewOptions getOptionalSeatViewOptions(IDeserializer iDeserializer) {
        SeatViewOptions seatViewOptions = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            MassageConfig massageConfig;
            MassageConfig massageConfig2;
            MassageConfig massageConfig3;
            MassageConfig massageConfig4;
            SeatZoneViewOptions seatZoneViewOptions;
            SeatZoneViewOptions seatZoneViewOptions2;
            SeatZoneViewOptions seatZoneViewOptions3;
            SeatZoneViewOptions seatZoneViewOptions4;
            CarViewOption carViewOption;
            CarViewOption carViewOption2;
            CarViewOption carViewOption3;
            CarViewOption carViewOption4;
            CarViewOption carViewOption5;
            CarViewOption carViewOption6;
            CarViewOption carViewOption7;
            MassageConfig massageConfig5;
            MassageConfig massageConfig6;
            VisualizationConfig visualizationConfig;
            VisualizationConfig visualizationConfig2;
            VisualizationConfig visualizationConfig3;
            VisualizationConfig visualizationConfig4;
            MassageConfig massageConfig7;
            MassageConfig massageConfig8;
            SeatmemoryConfig seatmemoryConfig;
            CarViewOption carViewOption8;
            CarViewOption carViewOption9;
            CarViewOption carViewOption10;
            CarViewOption carViewOption11;
            CarViewOption carViewOption12;
            CarViewOption carViewOption13;
            CarViewOption carViewOption14;
            CarViewOption carViewOption15;
            CarViewOption carViewOption16;
            seatViewOptions = new SeatViewOptions();
            seatViewOptions.seatRadioKeyAutomatic = carViewOption16 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            seatViewOptions.seatCoDriverSettingsFromDriver = carViewOption15 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            seatViewOptions.seatCoDriverSettingsFromRear = carViewOption14 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            seatViewOptions.seatEasyEntryFrontLeft = carViewOption13 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            seatViewOptions.seatEasyEntryFrontRight = carViewOption12 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            seatViewOptions.seatEasyEntryRearLeft = carViewOption11 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            seatViewOptions.seatEasyEntryRearRight = carViewOption10 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            seatViewOptions.seatSpecialPosition = carViewOption9 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            seatViewOptions.seatSetFactoryDefault = carViewOption8 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            seatViewOptions.seatmemoryConfig = seatmemoryConfig = SeatmemoryConfigSerializer.getOptionalSeatmemoryConfig(iDeserializer);
            seatViewOptions.massageConfig1RL = massageConfig8 = MassageConfigSerializer.getOptionalMassageConfig(iDeserializer);
            seatViewOptions.massageConfig1RR = massageConfig7 = MassageConfigSerializer.getOptionalMassageConfig(iDeserializer);
            seatViewOptions.visualizationConfig1RL = visualizationConfig4 = VisualizationConfigSerializer.getOptionalVisualizationConfig(iDeserializer);
            seatViewOptions.visualizationConfig1RR = visualizationConfig3 = VisualizationConfigSerializer.getOptionalVisualizationConfig(iDeserializer);
            seatViewOptions.visualizationConfig2RL = visualizationConfig2 = VisualizationConfigSerializer.getOptionalVisualizationConfig(iDeserializer);
            seatViewOptions.visualizationConfig2RR = visualizationConfig = VisualizationConfigSerializer.getOptionalVisualizationConfig(iDeserializer);
            seatViewOptions.massageConfig2RL = massageConfig6 = MassageConfigSerializer.getOptionalMassageConfig(iDeserializer);
            seatViewOptions.massageConfig2RR = massageConfig5 = MassageConfigSerializer.getOptionalMassageConfig(iDeserializer);
            seatViewOptions.seatSpecialPositionRearCoDriver = carViewOption7 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            seatViewOptions.seatDeleteSpecialPosition = carViewOption6 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            seatViewOptions.seatCoDriverSettingsFromRearActivation = carViewOption5 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            seatViewOptions.seatRestSeatStatus = carViewOption4 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            seatViewOptions.seatMoveRearSeatDisplay = carViewOption3 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            seatViewOptions.seatFoldHeadRestRearDriver = carViewOption2 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            seatViewOptions.seatFoldHeadRestRearCoDriver = carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            seatViewOptions.seatSettings1RL = seatZoneViewOptions4 = SeatZoneViewOptionsSerializer.getOptionalSeatZoneViewOptions(iDeserializer);
            seatViewOptions.seatSettings1RR = seatZoneViewOptions3 = SeatZoneViewOptionsSerializer.getOptionalSeatZoneViewOptions(iDeserializer);
            seatViewOptions.seatSettings2RL = seatZoneViewOptions2 = SeatZoneViewOptionsSerializer.getOptionalSeatZoneViewOptions(iDeserializer);
            seatViewOptions.seatSettings2RR = seatZoneViewOptions = SeatZoneViewOptionsSerializer.getOptionalSeatZoneViewOptions(iDeserializer);
            seatViewOptions.premiumMassageConfig1RL = massageConfig4 = MassageConfigSerializer.getOptionalMassageConfig(iDeserializer);
            seatViewOptions.premiumMassageConfig1RR = massageConfig3 = MassageConfigSerializer.getOptionalMassageConfig(iDeserializer);
            seatViewOptions.premiumMassageConfig2RL = massageConfig2 = MassageConfigSerializer.getOptionalMassageConfig(iDeserializer);
            seatViewOptions.premiumMassageConfig2RR = massageConfig = MassageConfigSerializer.getOptionalMassageConfig(iDeserializer);
        }
        return seatViewOptions;
    }

    public static SeatViewOptions[] getOptionalSeatViewOptionsVarArray(IDeserializer iDeserializer) {
        SeatViewOptions[] seatViewOptionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            seatViewOptionsArray = new SeatViewOptions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                seatViewOptionsArray[i2] = SeatViewOptionsSerializer.getOptionalSeatViewOptions(iDeserializer);
            }
        }
        return seatViewOptionsArray;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.comm.dsi.carkombi.impl.BCConfigurationSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarViewOptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.BCConfiguration;
import org.dsi.ifc.carkombi.BCViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class BCViewOptionsSerializer {
    public static void putOptionalBCViewOptions(ISerializer iSerializer, BCViewOptions bCViewOptions) {
        boolean bl = bCViewOptions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarViewOption carViewOption = bCViewOptions.getCurrentConsumption1();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption);
            CarViewOption carViewOption2 = bCViewOptions.getCurrentConsumption2();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption2);
            CarViewOption carViewOption3 = bCViewOptions.getCurrentRange1();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption3);
            CarViewOption carViewOption4 = bCViewOptions.getCurrentRange2();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption4);
            CarViewOption carViewOption5 = bCViewOptions.getTotalDistance();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption5);
            CarViewOption carViewOption6 = bCViewOptions.getShortTermAverageConsumption1();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption6);
            CarViewOption carViewOption7 = bCViewOptions.getShortTermAverageConsumption2();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption7);
            CarViewOption carViewOption8 = bCViewOptions.getShortTermGeneral();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption8);
            CarViewOption carViewOption9 = bCViewOptions.getLongTermAverageConsumption1();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption9);
            CarViewOption carViewOption10 = bCViewOptions.getLongTermAverageConsumption2();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption10);
            CarViewOption carViewOption11 = bCViewOptions.getLongTermGeneral();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption11);
            CarViewOption carViewOption12 = bCViewOptions.getCycleAverageConsumption1();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption12);
            CarViewOption carViewOption13 = bCViewOptions.getCycleAverageConsumption2();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption13);
            CarViewOption carViewOption14 = bCViewOptions.getCycleGeneral();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption14);
            CarViewOption carViewOption15 = bCViewOptions.getVZADisplay();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption15);
            CarViewOption carViewOption16 = bCViewOptions.getLifeTipsDisplay();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption16);
            CarViewOption carViewOption17 = bCViewOptions.getConsumerDisplay();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption17);
            CarViewOption carViewOption18 = bCViewOptions.getTankLevel1();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption18);
            CarViewOption carViewOption19 = bCViewOptions.getTankLevel2();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption19);
            CarViewOption carViewOption20 = bCViewOptions.getRefuelVolume1();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption20);
            CarViewOption carViewOption21 = bCViewOptions.getRefuelVolume2();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption21);
            CarViewOption carViewOption22 = bCViewOptions.getMenue1Config();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption22);
            CarViewOption carViewOption23 = bCViewOptions.getMenue2Config();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption23);
            CarViewOption carViewOption24 = bCViewOptions.getMenue3Config();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption24);
            CarViewOption carViewOption25 = bCViewOptions.getResetMenue1();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption25);
            CarViewOption carViewOption26 = bCViewOptions.getResetMenue2();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption26);
            CarViewOption carViewOption27 = bCViewOptions.getResetMenue3();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption27);
            CarViewOption carViewOption28 = bCViewOptions.getOilTemperature();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption28);
            CarViewOption carViewOption29 = bCViewOptions.getDigitalSpeed();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption29);
            CarViewOption carViewOption30 = bCViewOptions.getStopwatch();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption30);
            CarViewOption carViewOption31 = bCViewOptions.getVzaMFA();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption31);
            CarViewOption carViewOption32 = bCViewOptions.getSpeedWarning();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption32);
            CarViewOption carViewOption33 = bCViewOptions.getGearRecommendation();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption33);
            CarViewOption carViewOption34 = bCViewOptions.getRearSeatbeltWarning();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption34);
            CarViewOption carViewOption35 = bCViewOptions.getIndications();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption35);
            CarViewOption carViewOption36 = bCViewOptions.getOutsideTemperature();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption36);
            CarViewOption carViewOption37 = bCViewOptions.getBcSetFactoryDefault();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption37);
            CarViewOption carViewOption38 = bCViewOptions.getVehicleStateList();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption38);
            CarViewOption carViewOption39 = bCViewOptions.getStatisticsTimeAC1();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption39);
            CarViewOption carViewOption40 = bCViewOptions.getStatisticsTimeAC2();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption40);
            CarViewOption carViewOption41 = bCViewOptions.getStatisticsTimeRE();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption41);
            CarViewOption carViewOption42 = bCViewOptions.getStatisticsTimeZE();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption42);
            CarViewOption carViewOption43 = bCViewOptions.getStatisticsTimeCurrentPeriodAC1();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption43);
            CarViewOption carViewOption44 = bCViewOptions.getStatisticsTimeCurrentPeriodAC2();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption44);
            CarViewOption carViewOption45 = bCViewOptions.getStatisticsTimeCurrentPeriodRE();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption45);
            CarViewOption carViewOption46 = bCViewOptions.getStatisticsTimeCurrentPeriodZE();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption46);
            CarViewOption carViewOption47 = bCViewOptions.getStatisticsDistanceAC1();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption47);
            CarViewOption carViewOption48 = bCViewOptions.getStatisticsDistanceAC2();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption48);
            CarViewOption carViewOption49 = bCViewOptions.getStatisticsDistanceRE();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption49);
            CarViewOption carViewOption50 = bCViewOptions.getStatisticsDistanceZE();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption50);
            CarViewOption carViewOption51 = bCViewOptions.getStatisticsDistanceCurrentIntervallAC1();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption51);
            CarViewOption carViewOption52 = bCViewOptions.getStatisticsDistanceCurrentIntervallAC2();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption52);
            CarViewOption carViewOption53 = bCViewOptions.getStatisticsDistanceCurrentIntervallRE();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption53);
            CarViewOption carViewOption54 = bCViewOptions.getStatisticsDistanceCurrentIntervallZE();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption54);
            CarViewOption carViewOption55 = bCViewOptions.getStatisticsReset();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption55);
            CarViewOption carViewOption56 = bCViewOptions.getStatisticsConfig();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption56);
            CarViewOption carViewOption57 = bCViewOptions.getOilTemperatureValue();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption57);
            CarViewOption carViewOption58 = bCViewOptions.getCoolantTemperature();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption58);
            CarViewOption carViewOption59 = bCViewOptions.getComfortPowerConsumptionST();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption59);
            CarViewOption carViewOption60 = bCViewOptions.getStatisticDistanceEUkm();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption60);
            CarViewOption carViewOption61 = bCViewOptions.getStatisticDistanceEUmls();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption61);
            CarViewOption carViewOption62 = bCViewOptions.getTotalCurrentRange();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption62);
            CarViewOption carViewOption63 = bCViewOptions.getResetMaxValues();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption63);
            CarViewOption carViewOption64 = bCViewOptions.getZeroEmissionDistanceST();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption64);
            CarViewOption carViewOption65 = bCViewOptions.getZeroEmissionTimeST();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption65);
            CarViewOption carViewOption66 = bCViewOptions.getZeroEmissionDistanceLT();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption66);
            CarViewOption carViewOption67 = bCViewOptions.getZeroEmissionTimeLT();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption67);
            CarViewOption carViewOption68 = bCViewOptions.getZeroEmissionDistanceCY();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption68);
            CarViewOption carViewOption69 = bCViewOptions.getZeroEmissionTimeCY();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption69);
            CarViewOption carViewOption70 = bCViewOptions.getMaxValues();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption70);
            CarViewOption carViewOption71 = bCViewOptions.getResetTimeStampST();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption71);
            CarViewOption carViewOption72 = bCViewOptions.getResetTimeStampLT();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption72);
            CarViewOption carViewOption73 = bCViewOptions.getResetTimeStampCY();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption73);
            CarViewOption carViewOption74 = bCViewOptions.getComfortPowerConsumptionLT();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption74);
            CarViewOption carViewOption75 = bCViewOptions.getComfortPowerConsumptionCY();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption75);
            CarViewOption carViewOption76 = bCViewOptions.getAstaMFA();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption76);
            CarViewOption carViewOption77 = bCViewOptions.getResetTrip();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption77);
            BCConfiguration bCConfiguration = bCViewOptions.getConfiguration();
            BCConfigurationSerializer.putOptionalBCConfiguration(iSerializer, bCConfiguration);
        }
    }

    public static void putOptionalBCViewOptionsVarArray(ISerializer iSerializer, BCViewOptions[] bCViewOptionsArray) {
        boolean bl = bCViewOptionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(bCViewOptionsArray.length);
            for (int i2 = 0; i2 < bCViewOptionsArray.length; ++i2) {
                BCViewOptionsSerializer.putOptionalBCViewOptions(iSerializer, bCViewOptionsArray[i2]);
            }
        }
    }

    public static BCViewOptions getOptionalBCViewOptions(IDeserializer iDeserializer) {
        BCViewOptions bCViewOptions = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            BCConfiguration bCConfiguration;
            CarViewOption carViewOption;
            CarViewOption carViewOption2;
            CarViewOption carViewOption3;
            CarViewOption carViewOption4;
            CarViewOption carViewOption5;
            CarViewOption carViewOption6;
            CarViewOption carViewOption7;
            CarViewOption carViewOption8;
            CarViewOption carViewOption9;
            CarViewOption carViewOption10;
            CarViewOption carViewOption11;
            CarViewOption carViewOption12;
            CarViewOption carViewOption13;
            CarViewOption carViewOption14;
            CarViewOption carViewOption15;
            CarViewOption carViewOption16;
            CarViewOption carViewOption17;
            CarViewOption carViewOption18;
            CarViewOption carViewOption19;
            CarViewOption carViewOption20;
            CarViewOption carViewOption21;
            CarViewOption carViewOption22;
            CarViewOption carViewOption23;
            CarViewOption carViewOption24;
            CarViewOption carViewOption25;
            CarViewOption carViewOption26;
            CarViewOption carViewOption27;
            CarViewOption carViewOption28;
            CarViewOption carViewOption29;
            CarViewOption carViewOption30;
            CarViewOption carViewOption31;
            CarViewOption carViewOption32;
            CarViewOption carViewOption33;
            CarViewOption carViewOption34;
            CarViewOption carViewOption35;
            CarViewOption carViewOption36;
            CarViewOption carViewOption37;
            CarViewOption carViewOption38;
            CarViewOption carViewOption39;
            CarViewOption carViewOption40;
            CarViewOption carViewOption41;
            CarViewOption carViewOption42;
            CarViewOption carViewOption43;
            CarViewOption carViewOption44;
            CarViewOption carViewOption45;
            CarViewOption carViewOption46;
            CarViewOption carViewOption47;
            CarViewOption carViewOption48;
            CarViewOption carViewOption49;
            CarViewOption carViewOption50;
            CarViewOption carViewOption51;
            CarViewOption carViewOption52;
            CarViewOption carViewOption53;
            CarViewOption carViewOption54;
            CarViewOption carViewOption55;
            CarViewOption carViewOption56;
            CarViewOption carViewOption57;
            CarViewOption carViewOption58;
            CarViewOption carViewOption59;
            CarViewOption carViewOption60;
            CarViewOption carViewOption61;
            CarViewOption carViewOption62;
            CarViewOption carViewOption63;
            CarViewOption carViewOption64;
            CarViewOption carViewOption65;
            CarViewOption carViewOption66;
            CarViewOption carViewOption67;
            CarViewOption carViewOption68;
            CarViewOption carViewOption69;
            CarViewOption carViewOption70;
            CarViewOption carViewOption71;
            CarViewOption carViewOption72;
            CarViewOption carViewOption73;
            CarViewOption carViewOption74;
            CarViewOption carViewOption75;
            CarViewOption carViewOption76;
            CarViewOption carViewOption77;
            bCViewOptions = new BCViewOptions();
            bCViewOptions.currentConsumption1 = carViewOption77 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.currentConsumption2 = carViewOption76 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.currentRange1 = carViewOption75 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.currentRange2 = carViewOption74 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.totalDistance = carViewOption73 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.shortTermAverageConsumption1 = carViewOption72 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.shortTermAverageConsumption2 = carViewOption71 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.shortTermGeneral = carViewOption70 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.longTermAverageConsumption1 = carViewOption69 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.longTermAverageConsumption2 = carViewOption68 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.longTermGeneral = carViewOption67 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.cycleAverageConsumption1 = carViewOption66 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.cycleAverageConsumption2 = carViewOption65 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.cycleGeneral = carViewOption64 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.vZADisplay = carViewOption63 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.lifeTipsDisplay = carViewOption62 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.consumerDisplay = carViewOption61 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.tankLevel1 = carViewOption60 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.tankLevel2 = carViewOption59 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.refuelVolume1 = carViewOption58 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.refuelVolume2 = carViewOption57 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.menue1Config = carViewOption56 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.menue2Config = carViewOption55 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.menue3Config = carViewOption54 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.resetMenue1 = carViewOption53 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.resetMenue2 = carViewOption52 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.resetMenue3 = carViewOption51 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.oilTemperature = carViewOption50 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.digitalSpeed = carViewOption49 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.stopwatch = carViewOption48 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.vzaMFA = carViewOption47 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.speedWarning = carViewOption46 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.gearRecommendation = carViewOption45 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.rearSeatbeltWarning = carViewOption44 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.indications = carViewOption43 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.outsideTemperature = carViewOption42 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.bcSetFactoryDefault = carViewOption41 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.vehicleStateList = carViewOption40 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.statisticsTimeAC1 = carViewOption39 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.statisticsTimeAC2 = carViewOption38 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.statisticsTimeRE = carViewOption37 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.statisticsTimeZE = carViewOption36 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.statisticsTimeCurrentPeriodAC1 = carViewOption35 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.statisticsTimeCurrentPeriodAC2 = carViewOption34 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.statisticsTimeCurrentPeriodRE = carViewOption33 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.statisticsTimeCurrentPeriodZE = carViewOption32 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.statisticsDistanceAC1 = carViewOption31 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.statisticsDistanceAC2 = carViewOption30 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.statisticsDistanceRE = carViewOption29 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.statisticsDistanceZE = carViewOption28 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.statisticsDistanceCurrentIntervallAC1 = carViewOption27 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.statisticsDistanceCurrentIntervallAC2 = carViewOption26 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.statisticsDistanceCurrentIntervallRE = carViewOption25 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.statisticsDistanceCurrentIntervallZE = carViewOption24 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.statisticsReset = carViewOption23 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.statisticsConfig = carViewOption22 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.oilTemperatureValue = carViewOption21 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.coolantTemperature = carViewOption20 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.comfortPowerConsumptionST = carViewOption19 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.statisticDistanceEUkm = carViewOption18 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.statisticDistanceEUmls = carViewOption17 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.totalCurrentRange = carViewOption16 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.resetMaxValues = carViewOption15 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.zeroEmissionDistanceST = carViewOption14 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.zeroEmissionTimeST = carViewOption13 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.zeroEmissionDistanceLT = carViewOption12 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.zeroEmissionTimeLT = carViewOption11 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.zeroEmissionDistanceCY = carViewOption10 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.zeroEmissionTimeCY = carViewOption9 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.maxValues = carViewOption8 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.resetTimeStampST = carViewOption7 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.resetTimeStampLT = carViewOption6 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.resetTimeStampCY = carViewOption5 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.comfortPowerConsumptionLT = carViewOption4 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.comfortPowerConsumptionCY = carViewOption3 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.astaMFA = carViewOption2 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.resetTrip = carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCViewOptions.configuration = bCConfiguration = BCConfigurationSerializer.getOptionalBCConfiguration(iDeserializer);
        }
        return bCViewOptions;
    }

    public static BCViewOptions[] getOptionalBCViewOptionsVarArray(IDeserializer iDeserializer) {
        BCViewOptions[] bCViewOptionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            bCViewOptionsArray = new BCViewOptions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                bCViewOptionsArray[i2] = BCViewOptionsSerializer.getOptionalBCViewOptions(iDeserializer);
            }
        }
        return bCViewOptionsArray;
    }
}


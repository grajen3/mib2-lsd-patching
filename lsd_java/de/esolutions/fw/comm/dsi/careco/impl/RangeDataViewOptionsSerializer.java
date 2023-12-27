/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.careco.impl;

import de.esolutions.fw.comm.dsi.careco.impl.RangeDataConfigurationSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarViewOptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.careco.RangeDataConfiguration;
import org.dsi.ifc.careco.RangeDataViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class RangeDataViewOptionsSerializer {
    public static void putOptionalRangeDataViewOptions(ISerializer iSerializer, RangeDataViewOptions rangeDataViewOptions) {
        boolean bl = rangeDataViewOptions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarViewOption carViewOption = rangeDataViewOptions.getRdSetFactoryDefault();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption);
            CarViewOption carViewOption2 = rangeDataViewOptions.getRdConsumptionMotorway1();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption2);
            CarViewOption carViewOption3 = rangeDataViewOptions.getRdConsumptionMotorway2();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption3);
            CarViewOption carViewOption4 = rangeDataViewOptions.getRdConsumptionHighway1();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption4);
            CarViewOption carViewOption5 = rangeDataViewOptions.getRdConsumptionHighway2();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption5);
            CarViewOption carViewOption6 = rangeDataViewOptions.getRdConsumptionCountryRoad1();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption6);
            CarViewOption carViewOption7 = rangeDataViewOptions.getRdConsumptionCountryRoad2();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption7);
            CarViewOption carViewOption8 = rangeDataViewOptions.getRdConsumptionDistrictRoad1();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption8);
            CarViewOption carViewOption9 = rangeDataViewOptions.getRdConsumptionDistrictRoad2();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption9);
            CarViewOption carViewOption10 = rangeDataViewOptions.getRdConsumptionLocalRoad1();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption10);
            CarViewOption carViewOption11 = rangeDataViewOptions.getRdConsumptionLocalRoad2();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption11);
            CarViewOption carViewOption12 = rangeDataViewOptions.getRdConsumptionRuralRoad1();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption12);
            CarViewOption carViewOption13 = rangeDataViewOptions.getRdConsumptionRuralRoad2();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption13);
            CarViewOption carViewOption14 = rangeDataViewOptions.getRdConsumptionUnclassifiedRoad1();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption14);
            CarViewOption carViewOption15 = rangeDataViewOptions.getRdConsumptionUnclassifiedRoad2();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption15);
            CarViewOption carViewOption16 = rangeDataViewOptions.getRdMaxRange1();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption16);
            CarViewOption carViewOption17 = rangeDataViewOptions.getRdMaxRange2();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption17);
            CarViewOption carViewOption18 = rangeDataViewOptions.getRdResidualEnergy1();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption18);
            CarViewOption carViewOption19 = rangeDataViewOptions.getRdResidualEnergy2();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption19);
            RangeDataConfiguration rangeDataConfiguration = rangeDataViewOptions.getConfiguration();
            RangeDataConfigurationSerializer.putOptionalRangeDataConfiguration(iSerializer, rangeDataConfiguration);
        }
    }

    public static void putOptionalRangeDataViewOptionsVarArray(ISerializer iSerializer, RangeDataViewOptions[] rangeDataViewOptionsArray) {
        boolean bl = rangeDataViewOptionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(rangeDataViewOptionsArray.length);
            for (int i2 = 0; i2 < rangeDataViewOptionsArray.length; ++i2) {
                RangeDataViewOptionsSerializer.putOptionalRangeDataViewOptions(iSerializer, rangeDataViewOptionsArray[i2]);
            }
        }
    }

    public static RangeDataViewOptions getOptionalRangeDataViewOptions(IDeserializer iDeserializer) {
        RangeDataViewOptions rangeDataViewOptions = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            RangeDataConfiguration rangeDataConfiguration;
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
            rangeDataViewOptions = new RangeDataViewOptions();
            rangeDataViewOptions.rdSetFactoryDefault = carViewOption19 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            rangeDataViewOptions.rdConsumptionMotorway1 = carViewOption18 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            rangeDataViewOptions.rdConsumptionMotorway2 = carViewOption17 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            rangeDataViewOptions.rdConsumptionHighway1 = carViewOption16 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            rangeDataViewOptions.rdConsumptionHighway2 = carViewOption15 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            rangeDataViewOptions.rdConsumptionCountryRoad1 = carViewOption14 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            rangeDataViewOptions.rdConsumptionCountryRoad2 = carViewOption13 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            rangeDataViewOptions.rdConsumptionDistrictRoad1 = carViewOption12 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            rangeDataViewOptions.rdConsumptionDistrictRoad2 = carViewOption11 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            rangeDataViewOptions.rdConsumptionLocalRoad1 = carViewOption10 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            rangeDataViewOptions.rdConsumptionLocalRoad2 = carViewOption9 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            rangeDataViewOptions.rdConsumptionRuralRoad1 = carViewOption8 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            rangeDataViewOptions.rdConsumptionRuralRoad2 = carViewOption7 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            rangeDataViewOptions.rdConsumptionUnclassifiedRoad1 = carViewOption6 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            rangeDataViewOptions.rdConsumptionUnclassifiedRoad2 = carViewOption5 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            rangeDataViewOptions.rdMaxRange1 = carViewOption4 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            rangeDataViewOptions.rdMaxRange2 = carViewOption3 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            rangeDataViewOptions.rdResidualEnergy1 = carViewOption2 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            rangeDataViewOptions.rdResidualEnergy2 = carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            rangeDataViewOptions.configuration = rangeDataConfiguration = RangeDataConfigurationSerializer.getOptionalRangeDataConfiguration(iDeserializer);
        }
        return rangeDataViewOptions;
    }

    public static RangeDataViewOptions[] getOptionalRangeDataViewOptionsVarArray(IDeserializer iDeserializer) {
        RangeDataViewOptions[] rangeDataViewOptionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            rangeDataViewOptionsArray = new RangeDataViewOptions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                rangeDataViewOptionsArray[i2] = RangeDataViewOptionsSerializer.getOptionalRangeDataViewOptions(iDeserializer);
            }
        }
        return rangeDataViewOptionsArray;
    }
}


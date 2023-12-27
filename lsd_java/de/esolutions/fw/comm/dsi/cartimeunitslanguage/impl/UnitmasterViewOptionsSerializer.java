/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cartimeunitslanguage.impl;

import de.esolutions.fw.comm.dsi.cartimeunitslanguage.impl.UnitmasterConfigurationSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarViewOptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cartimeunitslanguage.UnitmasterConfiguration;
import org.dsi.ifc.cartimeunitslanguage.UnitmasterViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class UnitmasterViewOptionsSerializer {
    public static void putOptionalUnitmasterViewOptions(ISerializer iSerializer, UnitmasterViewOptions unitmasterViewOptions) {
        boolean bl = unitmasterViewOptions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarViewOption carViewOption = unitmasterViewOptions.getDateFormat();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption);
            CarViewOption carViewOption2 = unitmasterViewOptions.getClockFormat();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption2);
            CarViewOption carViewOption3 = unitmasterViewOptions.getLanguage();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption3);
            CarViewOption carViewOption4 = unitmasterViewOptions.getTemperatureUnit();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption4);
            CarViewOption carViewOption5 = unitmasterViewOptions.getDistanceUnit();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption5);
            CarViewOption carViewOption6 = unitmasterViewOptions.getSpeedUnit();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption6);
            CarViewOption carViewOption7 = unitmasterViewOptions.getPressureUnit();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption7);
            CarViewOption carViewOption8 = unitmasterViewOptions.getVolumeUnit();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption8);
            CarViewOption carViewOption9 = unitmasterViewOptions.getConsumptionPetrolUnit();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption9);
            CarViewOption carViewOption10 = unitmasterViewOptions.getConsumptionGasUnit();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption10);
            CarViewOption carViewOption11 = unitmasterViewOptions.getUmSetFactoryDefault();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption11);
            CarViewOption carViewOption12 = unitmasterViewOptions.getConsumptionElectricUnit();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption12);
            CarViewOption carViewOption13 = unitmasterViewOptions.getSkin();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption13);
            CarViewOption carViewOption14 = unitmasterViewOptions.getWeightUnit();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption14);
            UnitmasterConfiguration unitmasterConfiguration = unitmasterViewOptions.getUmConfiguration();
            UnitmasterConfigurationSerializer.putOptionalUnitmasterConfiguration(iSerializer, unitmasterConfiguration);
        }
    }

    public static void putOptionalUnitmasterViewOptionsVarArray(ISerializer iSerializer, UnitmasterViewOptions[] unitmasterViewOptionsArray) {
        boolean bl = unitmasterViewOptionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(unitmasterViewOptionsArray.length);
            for (int i2 = 0; i2 < unitmasterViewOptionsArray.length; ++i2) {
                UnitmasterViewOptionsSerializer.putOptionalUnitmasterViewOptions(iSerializer, unitmasterViewOptionsArray[i2]);
            }
        }
    }

    public static UnitmasterViewOptions getOptionalUnitmasterViewOptions(IDeserializer iDeserializer) {
        UnitmasterViewOptions unitmasterViewOptions = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            UnitmasterConfiguration unitmasterConfiguration;
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
            unitmasterViewOptions = new UnitmasterViewOptions();
            unitmasterViewOptions.dateFormat = carViewOption14 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            unitmasterViewOptions.clockFormat = carViewOption13 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            unitmasterViewOptions.language = carViewOption12 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            unitmasterViewOptions.temperatureUnit = carViewOption11 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            unitmasterViewOptions.distanceUnit = carViewOption10 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            unitmasterViewOptions.speedUnit = carViewOption9 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            unitmasterViewOptions.pressureUnit = carViewOption8 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            unitmasterViewOptions.volumeUnit = carViewOption7 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            unitmasterViewOptions.consumptionPetrolUnit = carViewOption6 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            unitmasterViewOptions.consumptionGasUnit = carViewOption5 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            unitmasterViewOptions.umSetFactoryDefault = carViewOption4 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            unitmasterViewOptions.consumptionElectricUnit = carViewOption3 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            unitmasterViewOptions.skin = carViewOption2 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            unitmasterViewOptions.weightUnit = carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            unitmasterViewOptions.umConfiguration = unitmasterConfiguration = UnitmasterConfigurationSerializer.getOptionalUnitmasterConfiguration(iDeserializer);
        }
        return unitmasterViewOptions;
    }

    public static UnitmasterViewOptions[] getOptionalUnitmasterViewOptionsVarArray(IDeserializer iDeserializer) {
        UnitmasterViewOptions[] unitmasterViewOptionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            unitmasterViewOptionsArray = new UnitmasterViewOptions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                unitmasterViewOptionsArray[i2] = UnitmasterViewOptionsSerializer.getOptionalUnitmasterViewOptions(iDeserializer);
            }
        }
        return unitmasterViewOptionsArray;
    }
}


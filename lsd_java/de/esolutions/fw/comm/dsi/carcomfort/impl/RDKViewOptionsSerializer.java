/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.comm.dsi.carcomfort.impl.RDKConfigurationSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarViewOptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.RDKConfiguration;
import org.dsi.ifc.carcomfort.RDKViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class RDKViewOptionsSerializer {
    public static void putOptionalRDKViewOptions(ISerializer iSerializer, RDKViewOptions rDKViewOptions) {
        boolean bl = rDKViewOptions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarViewOption carViewOption = rDKViewOptions.getTireDisplay();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption);
            CarViewOption carViewOption2 = rDKViewOptions.getTireChanged();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption2);
            CarViewOption carViewOption3 = rDKViewOptions.getPressureChanged();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption3);
            CarViewOption carViewOption4 = rDKViewOptions.getSystemOnOff();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption4);
            CarViewOption carViewOption5 = rDKViewOptions.getSpeedLimit();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption5);
            CarViewOption carViewOption6 = rDKViewOptions.getTireSetup();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption6);
            RDKConfiguration rDKConfiguration = rDKViewOptions.getConfiguration();
            RDKConfigurationSerializer.putOptionalRDKConfiguration(iSerializer, rDKConfiguration);
            CarViewOption carViewOption7 = rDKViewOptions.getPressureLevel();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption7);
            CarViewOption carViewOption8 = rDKViewOptions.getDifferentialPressure();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption8);
            CarViewOption carViewOption9 = rDKViewOptions.getResidualBatteryLifetime();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption9);
            CarViewOption carViewOption10 = rDKViewOptions.getActualState();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption10);
            CarViewOption carViewOption11 = rDKViewOptions.getActualPressure();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption11);
            CarViewOption carViewOption12 = rDKViewOptions.getRequiredPressure();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption12);
            CarViewOption carViewOption13 = rDKViewOptions.getActualTemperature();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption13);
            CarViewOption carViewOption14 = rDKViewOptions.getSetFactoryDefault();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption14);
        }
    }

    public static void putOptionalRDKViewOptionsVarArray(ISerializer iSerializer, RDKViewOptions[] rDKViewOptionsArray) {
        boolean bl = rDKViewOptionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(rDKViewOptionsArray.length);
            for (int i2 = 0; i2 < rDKViewOptionsArray.length; ++i2) {
                RDKViewOptionsSerializer.putOptionalRDKViewOptions(iSerializer, rDKViewOptionsArray[i2]);
            }
        }
    }

    public static RDKViewOptions getOptionalRDKViewOptions(IDeserializer iDeserializer) {
        RDKViewOptions rDKViewOptions = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            CarViewOption carViewOption;
            CarViewOption carViewOption2;
            CarViewOption carViewOption3;
            CarViewOption carViewOption4;
            CarViewOption carViewOption5;
            CarViewOption carViewOption6;
            CarViewOption carViewOption7;
            CarViewOption carViewOption8;
            RDKConfiguration rDKConfiguration;
            CarViewOption carViewOption9;
            CarViewOption carViewOption10;
            CarViewOption carViewOption11;
            CarViewOption carViewOption12;
            CarViewOption carViewOption13;
            CarViewOption carViewOption14;
            rDKViewOptions = new RDKViewOptions();
            rDKViewOptions.tireDisplay = carViewOption14 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            rDKViewOptions.tireChanged = carViewOption13 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            rDKViewOptions.pressureChanged = carViewOption12 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            rDKViewOptions.systemOnOff = carViewOption11 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            rDKViewOptions.speedLimit = carViewOption10 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            rDKViewOptions.tireSetup = carViewOption9 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            rDKViewOptions.configuration = rDKConfiguration = RDKConfigurationSerializer.getOptionalRDKConfiguration(iDeserializer);
            rDKViewOptions.pressureLevel = carViewOption8 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            rDKViewOptions.differentialPressure = carViewOption7 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            rDKViewOptions.residualBatteryLifetime = carViewOption6 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            rDKViewOptions.actualState = carViewOption5 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            rDKViewOptions.actualPressure = carViewOption4 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            rDKViewOptions.requiredPressure = carViewOption3 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            rDKViewOptions.actualTemperature = carViewOption2 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            rDKViewOptions.setFactoryDefault = carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
        }
        return rDKViewOptions;
    }

    public static RDKViewOptions[] getOptionalRDKViewOptionsVarArray(IDeserializer iDeserializer) {
        RDKViewOptions[] rDKViewOptionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            rDKViewOptionsArray = new RDKViewOptions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                rDKViewOptionsArray[i2] = RDKViewOptionsSerializer.getOptionalRDKViewOptions(iDeserializer);
            }
        }
        return rDKViewOptionsArray;
    }
}


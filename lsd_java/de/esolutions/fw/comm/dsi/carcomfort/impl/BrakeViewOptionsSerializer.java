/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.comm.dsi.carcomfort.impl.BrakeConfigurationSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarViewOptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.BrakeConfiguration;
import org.dsi.ifc.carcomfort.BrakeViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class BrakeViewOptionsSerializer {
    public static void putOptionalBrakeViewOptions(ISerializer iSerializer, BrakeViewOptions brakeViewOptions) {
        boolean bl = brakeViewOptions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarViewOption carViewOption = brakeViewOptions.getBrakeElectricalParking();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption);
            CarViewOption carViewOption2 = brakeViewOptions.getBrakeAutoHold();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption2);
            CarViewOption carViewOption3 = brakeViewOptions.getBrakeEscMode();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption3);
            BrakeConfiguration brakeConfiguration = brakeViewOptions.getConfiguration();
            BrakeConfigurationSerializer.putOptionalBrakeConfiguration(iSerializer, brakeConfiguration);
            CarViewOption carViewOption4 = brakeViewOptions.getBrakeHdcMode();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption4);
        }
    }

    public static void putOptionalBrakeViewOptionsVarArray(ISerializer iSerializer, BrakeViewOptions[] brakeViewOptionsArray) {
        boolean bl = brakeViewOptionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(brakeViewOptionsArray.length);
            for (int i2 = 0; i2 < brakeViewOptionsArray.length; ++i2) {
                BrakeViewOptionsSerializer.putOptionalBrakeViewOptions(iSerializer, brakeViewOptionsArray[i2]);
            }
        }
    }

    public static BrakeViewOptions getOptionalBrakeViewOptions(IDeserializer iDeserializer) {
        BrakeViewOptions brakeViewOptions = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            CarViewOption carViewOption;
            BrakeConfiguration brakeConfiguration;
            CarViewOption carViewOption2;
            CarViewOption carViewOption3;
            CarViewOption carViewOption4;
            brakeViewOptions = new BrakeViewOptions();
            brakeViewOptions.brakeElectricalParking = carViewOption4 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            brakeViewOptions.brakeAutoHold = carViewOption3 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            brakeViewOptions.brakeEscMode = carViewOption2 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            brakeViewOptions.configuration = brakeConfiguration = BrakeConfigurationSerializer.getOptionalBrakeConfiguration(iDeserializer);
            brakeViewOptions.brakeHdcMode = carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
        }
        return brakeViewOptions;
    }

    public static BrakeViewOptions[] getOptionalBrakeViewOptionsVarArray(IDeserializer iDeserializer) {
        BrakeViewOptions[] brakeViewOptionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            brakeViewOptionsArray = new BrakeViewOptions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                brakeViewOptionsArray[i2] = BrakeViewOptionsSerializer.getOptionalBrakeViewOptions(iDeserializer);
            }
        }
        return brakeViewOptionsArray;
    }
}


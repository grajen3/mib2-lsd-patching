/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.comm.dsi.global.impl.CarViewOptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.WiperViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class WiperViewOptionsSerializer {
    public static void putOptionalWiperViewOptions(ISerializer iSerializer, WiperViewOptions wiperViewOptions) {
        boolean bl = wiperViewOptions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarViewOption carViewOption = wiperViewOptions.getWiperServicePosition();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption);
            CarViewOption carViewOption2 = wiperViewOptions.getWiperRainSensorOnOff();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption2);
            CarViewOption carViewOption3 = wiperViewOptions.getWiperRainSensorConfig();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption3);
            CarViewOption carViewOption4 = wiperViewOptions.getWiperRearWiping();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption4);
            CarViewOption carViewOption5 = wiperViewOptions.getWiperTearsWiping();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption5);
            CarViewOption carViewOption6 = wiperViewOptions.getWiperWinterPosition();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption6);
            CarViewOption carViewOption7 = wiperViewOptions.getEasyEntrySteeringColumn();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption7);
            CarViewOption carViewOption8 = wiperViewOptions.getWiperSetFactoryDefault();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption8);
        }
    }

    public static void putOptionalWiperViewOptionsVarArray(ISerializer iSerializer, WiperViewOptions[] wiperViewOptionsArray) {
        boolean bl = wiperViewOptionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(wiperViewOptionsArray.length);
            for (int i2 = 0; i2 < wiperViewOptionsArray.length; ++i2) {
                WiperViewOptionsSerializer.putOptionalWiperViewOptions(iSerializer, wiperViewOptionsArray[i2]);
            }
        }
    }

    public static WiperViewOptions getOptionalWiperViewOptions(IDeserializer iDeserializer) {
        WiperViewOptions wiperViewOptions = null;
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
            wiperViewOptions = new WiperViewOptions();
            wiperViewOptions.wiperServicePosition = carViewOption8 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            wiperViewOptions.wiperRainSensorOnOff = carViewOption7 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            wiperViewOptions.wiperRainSensorConfig = carViewOption6 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            wiperViewOptions.wiperRearWiping = carViewOption5 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            wiperViewOptions.wiperTearsWiping = carViewOption4 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            wiperViewOptions.wiperWinterPosition = carViewOption3 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            wiperViewOptions.easyEntrySteeringColumn = carViewOption2 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            wiperViewOptions.wiperSetFactoryDefault = carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
        }
        return wiperViewOptions;
    }

    public static WiperViewOptions[] getOptionalWiperViewOptionsVarArray(IDeserializer iDeserializer) {
        WiperViewOptions[] wiperViewOptionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            wiperViewOptionsArray = new WiperViewOptions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                wiperViewOptionsArray[i2] = WiperViewOptionsSerializer.getOptionalWiperViewOptions(iDeserializer);
            }
        }
        return wiperViewOptionsArray;
    }
}


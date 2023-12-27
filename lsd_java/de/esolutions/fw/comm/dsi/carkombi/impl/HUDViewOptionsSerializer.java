/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.comm.dsi.carkombi.impl.HUDConfigurationSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarViewOptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.HUDConfiguration;
import org.dsi.ifc.carkombi.HUDViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class HUDViewOptionsSerializer {
    public static void putOptionalHUDViewOptions(ISerializer iSerializer, HUDViewOptions hUDViewOptions) {
        boolean bl = hUDViewOptions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarViewOption carViewOption = hUDViewOptions.getHeightAdjustment();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption);
            CarViewOption carViewOption2 = hUDViewOptions.getBrightness();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption2);
            CarViewOption carViewOption3 = hUDViewOptions.getContent();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption3);
            CarViewOption carViewOption4 = hUDViewOptions.getRotationAdjustment();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption4);
            CarViewOption carViewOption5 = hUDViewOptions.getColour();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption5);
            CarViewOption carViewOption6 = hUDViewOptions.getSetFactoryDefault();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption6);
            CarViewOption carViewOption7 = hUDViewOptions.getSystemOnOff();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption7);
            HUDConfiguration hUDConfiguration = hUDViewOptions.getConfiguration();
            HUDConfigurationSerializer.putOptionalHUDConfiguration(iSerializer, hUDConfiguration);
            CarViewOption carViewOption8 = hUDViewOptions.getLicense();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption8);
        }
    }

    public static void putOptionalHUDViewOptionsVarArray(ISerializer iSerializer, HUDViewOptions[] hUDViewOptionsArray) {
        boolean bl = hUDViewOptionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(hUDViewOptionsArray.length);
            for (int i2 = 0; i2 < hUDViewOptionsArray.length; ++i2) {
                HUDViewOptionsSerializer.putOptionalHUDViewOptions(iSerializer, hUDViewOptionsArray[i2]);
            }
        }
    }

    public static HUDViewOptions getOptionalHUDViewOptions(IDeserializer iDeserializer) {
        HUDViewOptions hUDViewOptions = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            CarViewOption carViewOption;
            HUDConfiguration hUDConfiguration;
            CarViewOption carViewOption2;
            CarViewOption carViewOption3;
            CarViewOption carViewOption4;
            CarViewOption carViewOption5;
            CarViewOption carViewOption6;
            CarViewOption carViewOption7;
            CarViewOption carViewOption8;
            hUDViewOptions = new HUDViewOptions();
            hUDViewOptions.heightAdjustment = carViewOption8 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            hUDViewOptions.brightness = carViewOption7 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            hUDViewOptions.content = carViewOption6 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            hUDViewOptions.rotationAdjustment = carViewOption5 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            hUDViewOptions.colour = carViewOption4 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            hUDViewOptions.setFactoryDefault = carViewOption3 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            hUDViewOptions.systemOnOff = carViewOption2 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            hUDViewOptions.configuration = hUDConfiguration = HUDConfigurationSerializer.getOptionalHUDConfiguration(iDeserializer);
            hUDViewOptions.license = carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
        }
        return hUDViewOptions;
    }

    public static HUDViewOptions[] getOptionalHUDViewOptionsVarArray(IDeserializer iDeserializer) {
        HUDViewOptions[] hUDViewOptionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            hUDViewOptionsArray = new HUDViewOptions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                hUDViewOptionsArray[i2] = HUDViewOptionsSerializer.getOptionalHUDViewOptions(iDeserializer);
            }
        }
        return hUDViewOptionsArray;
    }
}


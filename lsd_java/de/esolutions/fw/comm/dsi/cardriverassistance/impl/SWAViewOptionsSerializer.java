/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardriverassistance.impl;

import de.esolutions.fw.comm.dsi.cardriverassistance.impl.SWAConfigurationSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarViewOptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardriverassistance.SWAConfiguration;
import org.dsi.ifc.cardriverassistance.SWAViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class SWAViewOptionsSerializer {
    public static void putOptionalSWAViewOptions(ISerializer iSerializer, SWAViewOptions sWAViewOptions) {
        boolean bl = sWAViewOptions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarViewOption carViewOption = sWAViewOptions.getBrightness();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption);
            CarViewOption carViewOption2 = sWAViewOptions.getWarningTime();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption2);
            CarViewOption carViewOption3 = sWAViewOptions.getFrequence();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption3);
            CarViewOption carViewOption4 = sWAViewOptions.getSystem();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption4);
            CarViewOption carViewOption5 = sWAViewOptions.getGongState();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption5);
            CarViewOption carViewOption6 = sWAViewOptions.getGongVolume();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption6);
            CarViewOption carViewOption7 = sWAViewOptions.getRcta();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption7);
            CarViewOption carViewOption8 = sWAViewOptions.getExitAssist();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption8);
            SWAConfiguration sWAConfiguration = sWAViewOptions.getConfiguration();
            SWAConfigurationSerializer.putOptionalSWAConfiguration(iSerializer, sWAConfiguration);
        }
    }

    public static void putOptionalSWAViewOptionsVarArray(ISerializer iSerializer, SWAViewOptions[] sWAViewOptionsArray) {
        boolean bl = sWAViewOptionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sWAViewOptionsArray.length);
            for (int i2 = 0; i2 < sWAViewOptionsArray.length; ++i2) {
                SWAViewOptionsSerializer.putOptionalSWAViewOptions(iSerializer, sWAViewOptionsArray[i2]);
            }
        }
    }

    public static SWAViewOptions getOptionalSWAViewOptions(IDeserializer iDeserializer) {
        SWAViewOptions sWAViewOptions = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            SWAConfiguration sWAConfiguration;
            CarViewOption carViewOption;
            CarViewOption carViewOption2;
            CarViewOption carViewOption3;
            CarViewOption carViewOption4;
            CarViewOption carViewOption5;
            CarViewOption carViewOption6;
            CarViewOption carViewOption7;
            CarViewOption carViewOption8;
            sWAViewOptions = new SWAViewOptions();
            sWAViewOptions.brightness = carViewOption8 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            sWAViewOptions.warningTime = carViewOption7 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            sWAViewOptions.frequence = carViewOption6 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            sWAViewOptions.system = carViewOption5 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            sWAViewOptions.gongState = carViewOption4 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            sWAViewOptions.gongVolume = carViewOption3 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            sWAViewOptions.rcta = carViewOption2 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            sWAViewOptions.exitAssist = carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            sWAViewOptions.configuration = sWAConfiguration = SWAConfigurationSerializer.getOptionalSWAConfiguration(iDeserializer);
        }
        return sWAViewOptions;
    }

    public static SWAViewOptions[] getOptionalSWAViewOptionsVarArray(IDeserializer iDeserializer) {
        SWAViewOptions[] sWAViewOptionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sWAViewOptionsArray = new SWAViewOptions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sWAViewOptionsArray[i2] = SWAViewOptionsSerializer.getOptionalSWAViewOptions(iDeserializer);
            }
        }
        return sWAViewOptionsArray;
    }
}


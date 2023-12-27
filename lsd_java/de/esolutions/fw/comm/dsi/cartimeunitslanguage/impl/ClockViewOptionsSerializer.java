/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cartimeunitslanguage.impl;

import de.esolutions.fw.comm.dsi.cartimeunitslanguage.impl.ClockConfigSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarViewOptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cartimeunitslanguage.ClockConfig;
import org.dsi.ifc.cartimeunitslanguage.ClockViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class ClockViewOptionsSerializer {
    public static void putOptionalClockViewOptions(ISerializer iSerializer, ClockViewOptions clockViewOptions) {
        boolean bl = clockViewOptions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarViewOption carViewOption = clockViewOptions.getTime();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption);
            CarViewOption carViewOption2 = clockViewOptions.getDate();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption2);
            CarViewOption carViewOption3 = clockViewOptions.getTimeZone();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption3);
            CarViewOption carViewOption4 = clockViewOptions.getDayLightSaving();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption4);
            CarViewOption carViewOption5 = clockViewOptions.getDayLightSavingData();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption5);
            CarViewOption carViewOption6 = clockViewOptions.getClockSource();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption6);
            CarViewOption carViewOption7 = clockViewOptions.getGpsSyncData();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption7);
            ClockConfig clockConfig = clockViewOptions.getClockConfig();
            ClockConfigSerializer.putOptionalClockConfig(iSerializer, clockConfig);
        }
    }

    public static void putOptionalClockViewOptionsVarArray(ISerializer iSerializer, ClockViewOptions[] clockViewOptionsArray) {
        boolean bl = clockViewOptionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(clockViewOptionsArray.length);
            for (int i2 = 0; i2 < clockViewOptionsArray.length; ++i2) {
                ClockViewOptionsSerializer.putOptionalClockViewOptions(iSerializer, clockViewOptionsArray[i2]);
            }
        }
    }

    public static ClockViewOptions getOptionalClockViewOptions(IDeserializer iDeserializer) {
        ClockViewOptions clockViewOptions = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            ClockConfig clockConfig;
            CarViewOption carViewOption;
            CarViewOption carViewOption2;
            CarViewOption carViewOption3;
            CarViewOption carViewOption4;
            CarViewOption carViewOption5;
            CarViewOption carViewOption6;
            CarViewOption carViewOption7;
            clockViewOptions = new ClockViewOptions();
            clockViewOptions.time = carViewOption7 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            clockViewOptions.date = carViewOption6 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            clockViewOptions.timeZone = carViewOption5 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            clockViewOptions.dayLightSaving = carViewOption4 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            clockViewOptions.dayLightSavingData = carViewOption3 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            clockViewOptions.clockSource = carViewOption2 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            clockViewOptions.gpsSyncData = carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            clockViewOptions.clockConfig = clockConfig = ClockConfigSerializer.getOptionalClockConfig(iDeserializer);
        }
        return clockViewOptions;
    }

    public static ClockViewOptions[] getOptionalClockViewOptionsVarArray(IDeserializer iDeserializer) {
        ClockViewOptions[] clockViewOptionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            clockViewOptionsArray = new ClockViewOptions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                clockViewOptionsArray[i2] = ClockViewOptionsSerializer.getOptionalClockViewOptions(iDeserializer);
            }
        }
        return clockViewOptionsArray;
    }
}


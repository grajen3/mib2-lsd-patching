/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cartimeunitslanguage.impl;

import de.esolutions.fw.comm.dsi.cartimeunitslanguage.impl.ClockSourcesSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cartimeunitslanguage.ClockConfig;
import org.dsi.ifc.cartimeunitslanguage.ClockSources;

public class ClockConfigSerializer {
    public static void putOptionalClockConfig(ISerializer iSerializer, ClockConfig clockConfig) {
        boolean bl = clockConfig == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = clockConfig.getDayLightSavingMode();
            iSerializer.putInt32(n);
            ClockSources clockSources = clockConfig.getTimeSourcesInstallation();
            ClockSourcesSerializer.putOptionalClockSources(iSerializer, clockSources);
        }
    }

    public static void putOptionalClockConfigVarArray(ISerializer iSerializer, ClockConfig[] clockConfigArray) {
        boolean bl = clockConfigArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(clockConfigArray.length);
            for (int i2 = 0; i2 < clockConfigArray.length; ++i2) {
                ClockConfigSerializer.putOptionalClockConfig(iSerializer, clockConfigArray[i2]);
            }
        }
    }

    public static ClockConfig getOptionalClockConfig(IDeserializer iDeserializer) {
        ClockConfig clockConfig = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            ClockSources clockSources;
            int n;
            clockConfig = new ClockConfig();
            clockConfig.dayLightSavingMode = n = iDeserializer.getInt32();
            clockConfig.timeSourcesInstallation = clockSources = ClockSourcesSerializer.getOptionalClockSources(iDeserializer);
        }
        return clockConfig;
    }

    public static ClockConfig[] getOptionalClockConfigVarArray(IDeserializer iDeserializer) {
        ClockConfig[] clockConfigArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            clockConfigArray = new ClockConfig[n];
            for (int i2 = 0; i2 < n; ++i2) {
                clockConfigArray[i2] = ClockConfigSerializer.getOptionalClockConfig(iDeserializer);
            }
        }
        return clockConfigArray;
    }
}


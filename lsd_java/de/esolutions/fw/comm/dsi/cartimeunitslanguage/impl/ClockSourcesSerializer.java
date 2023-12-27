/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cartimeunitslanguage.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cartimeunitslanguage.ClockSources;

public class ClockSourcesSerializer {
    public static void putOptionalClockSources(ISerializer iSerializer, ClockSources clockSources) {
        boolean bl = clockSources == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = clockSources.isQuartz();
            iSerializer.putBool(bl2);
            boolean bl3 = clockSources.isDcf77();
            iSerializer.putBool(bl3);
            boolean bl4 = clockSources.isGps();
            iSerializer.putBool(bl4);
        }
    }

    public static void putOptionalClockSourcesVarArray(ISerializer iSerializer, ClockSources[] clockSourcesArray) {
        boolean bl = clockSourcesArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(clockSourcesArray.length);
            for (int i2 = 0; i2 < clockSourcesArray.length; ++i2) {
                ClockSourcesSerializer.putOptionalClockSources(iSerializer, clockSourcesArray[i2]);
            }
        }
    }

    public static ClockSources getOptionalClockSources(IDeserializer iDeserializer) {
        ClockSources clockSources = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            clockSources = new ClockSources();
            clockSources.quartz = bl4 = iDeserializer.getBool();
            clockSources.dcf77 = bl3 = iDeserializer.getBool();
            clockSources.gps = bl2 = iDeserializer.getBool();
        }
        return clockSources;
    }

    public static ClockSources[] getOptionalClockSourcesVarArray(IDeserializer iDeserializer) {
        ClockSources[] clockSourcesArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            clockSourcesArray = new ClockSources[n];
            for (int i2 = 0; i2 < n; ++i2) {
                clockSourcesArray[i2] = ClockSourcesSerializer.getOptionalClockSources(iDeserializer);
            }
        }
        return clockSourcesArray;
    }
}


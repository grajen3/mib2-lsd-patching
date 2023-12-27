/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cartimeunitslanguage.impl;

import de.esolutions.fw.comm.dsi.cartimeunitslanguage.impl.ClockDateSerializer;
import de.esolutions.fw.comm.dsi.cartimeunitslanguage.impl.ClockTimeSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cartimeunitslanguage.ClockDate;
import org.dsi.ifc.cartimeunitslanguage.ClockGPSSyncData;
import org.dsi.ifc.cartimeunitslanguage.ClockTime;

public class ClockGPSSyncDataSerializer {
    public static void putOptionalClockGPSSyncData(ISerializer iSerializer, ClockGPSSyncData clockGPSSyncData) {
        boolean bl = clockGPSSyncData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            ClockTime clockTime = clockGPSSyncData.getTime();
            ClockTimeSerializer.putOptionalClockTime(iSerializer, clockTime);
            ClockDate clockDate = clockGPSSyncData.getDate();
            ClockDateSerializer.putOptionalClockDate(iSerializer, clockDate);
        }
    }

    public static void putOptionalClockGPSSyncDataVarArray(ISerializer iSerializer, ClockGPSSyncData[] clockGPSSyncDataArray) {
        boolean bl = clockGPSSyncDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(clockGPSSyncDataArray.length);
            for (int i2 = 0; i2 < clockGPSSyncDataArray.length; ++i2) {
                ClockGPSSyncDataSerializer.putOptionalClockGPSSyncData(iSerializer, clockGPSSyncDataArray[i2]);
            }
        }
    }

    public static ClockGPSSyncData getOptionalClockGPSSyncData(IDeserializer iDeserializer) {
        ClockGPSSyncData clockGPSSyncData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            ClockDate clockDate;
            ClockTime clockTime;
            clockGPSSyncData = new ClockGPSSyncData();
            clockGPSSyncData.time = clockTime = ClockTimeSerializer.getOptionalClockTime(iDeserializer);
            clockGPSSyncData.date = clockDate = ClockDateSerializer.getOptionalClockDate(iDeserializer);
        }
        return clockGPSSyncData;
    }

    public static ClockGPSSyncData[] getOptionalClockGPSSyncDataVarArray(IDeserializer iDeserializer) {
        ClockGPSSyncData[] clockGPSSyncDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            clockGPSSyncDataArray = new ClockGPSSyncData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                clockGPSSyncDataArray[i2] = ClockGPSSyncDataSerializer.getOptionalClockGPSSyncData(iDeserializer);
            }
        }
        return clockGPSSyncDataArray;
    }
}


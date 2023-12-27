/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cartimeunitslanguage.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cartimeunitslanguage.ClockDayLightSavingData;

public class ClockDayLightSavingDataSerializer {
    public static void putOptionalClockDayLightSavingData(ISerializer iSerializer, ClockDayLightSavingData clockDayLightSavingData) {
        boolean bl = clockDayLightSavingData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = clockDayLightSavingData.getState();
            iSerializer.putInt32(n);
            byte by = clockDayLightSavingData.getMonth();
            iSerializer.putInt8(by);
            byte by2 = clockDayLightSavingData.getDay();
            iSerializer.putInt8(by2);
            byte by3 = clockDayLightSavingData.getHour();
            iSerializer.putInt8(by3);
            byte by4 = clockDayLightSavingData.getMinute();
            iSerializer.putInt8(by4);
            byte by5 = clockDayLightSavingData.getSecond();
            iSerializer.putInt8(by5);
        }
    }

    public static void putOptionalClockDayLightSavingDataVarArray(ISerializer iSerializer, ClockDayLightSavingData[] clockDayLightSavingDataArray) {
        boolean bl = clockDayLightSavingDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(clockDayLightSavingDataArray.length);
            for (int i2 = 0; i2 < clockDayLightSavingDataArray.length; ++i2) {
                ClockDayLightSavingDataSerializer.putOptionalClockDayLightSavingData(iSerializer, clockDayLightSavingDataArray[i2]);
            }
        }
    }

    public static ClockDayLightSavingData getOptionalClockDayLightSavingData(IDeserializer iDeserializer) {
        ClockDayLightSavingData clockDayLightSavingData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            byte by;
            byte by2;
            byte by3;
            byte by4;
            byte by5;
            int n;
            clockDayLightSavingData = new ClockDayLightSavingData();
            clockDayLightSavingData.state = n = iDeserializer.getInt32();
            clockDayLightSavingData.month = by5 = iDeserializer.getInt8();
            clockDayLightSavingData.day = by4 = iDeserializer.getInt8();
            clockDayLightSavingData.hour = by3 = iDeserializer.getInt8();
            clockDayLightSavingData.minute = by2 = iDeserializer.getInt8();
            clockDayLightSavingData.second = by = iDeserializer.getInt8();
        }
        return clockDayLightSavingData;
    }

    public static ClockDayLightSavingData[] getOptionalClockDayLightSavingDataVarArray(IDeserializer iDeserializer) {
        ClockDayLightSavingData[] clockDayLightSavingDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            clockDayLightSavingDataArray = new ClockDayLightSavingData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                clockDayLightSavingDataArray[i2] = ClockDayLightSavingDataSerializer.getOptionalClockDayLightSavingData(iDeserializer);
            }
        }
        return clockDayLightSavingDataArray;
    }
}


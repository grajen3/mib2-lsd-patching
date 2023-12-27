/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cartimeunitslanguage.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cartimeunitslanguage.ClockSummerTimeData;

public class ClockSummerTimeDataSerializer {
    public static void putOptionalClockSummerTimeData(ISerializer iSerializer, ClockSummerTimeData clockSummerTimeData) {
        boolean bl = clockSummerTimeData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = clockSummerTimeData.isValidity();
            iSerializer.putBool(bl2);
            short s = clockSummerTimeData.getYearFrom();
            iSerializer.putInt16(s);
            byte by = clockSummerTimeData.getMonthFrom();
            iSerializer.putInt8(by);
            byte by2 = clockSummerTimeData.getDayFrom();
            iSerializer.putInt8(by2);
            byte by3 = clockSummerTimeData.getHourFrom();
            iSerializer.putInt8(by3);
            short s2 = clockSummerTimeData.getYearTo();
            iSerializer.putInt16(s2);
            byte by4 = clockSummerTimeData.getMonthTo();
            iSerializer.putInt8(by4);
            byte by5 = clockSummerTimeData.getDayTo();
            iSerializer.putInt8(by5);
            byte by6 = clockSummerTimeData.getHourTo();
            iSerializer.putInt8(by6);
        }
    }

    public static void putOptionalClockSummerTimeDataVarArray(ISerializer iSerializer, ClockSummerTimeData[] clockSummerTimeDataArray) {
        boolean bl = clockSummerTimeDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(clockSummerTimeDataArray.length);
            for (int i2 = 0; i2 < clockSummerTimeDataArray.length; ++i2) {
                ClockSummerTimeDataSerializer.putOptionalClockSummerTimeData(iSerializer, clockSummerTimeDataArray[i2]);
            }
        }
    }

    public static ClockSummerTimeData getOptionalClockSummerTimeData(IDeserializer iDeserializer) {
        ClockSummerTimeData clockSummerTimeData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            byte by;
            byte by2;
            byte by3;
            short s;
            byte by4;
            byte by5;
            byte by6;
            short s2;
            boolean bl2;
            clockSummerTimeData = new ClockSummerTimeData();
            clockSummerTimeData.validity = bl2 = iDeserializer.getBool();
            clockSummerTimeData.yearFrom = s2 = iDeserializer.getInt16();
            clockSummerTimeData.monthFrom = by6 = iDeserializer.getInt8();
            clockSummerTimeData.dayFrom = by5 = iDeserializer.getInt8();
            clockSummerTimeData.hourFrom = by4 = iDeserializer.getInt8();
            clockSummerTimeData.yearTo = s = iDeserializer.getInt16();
            clockSummerTimeData.monthTo = by3 = iDeserializer.getInt8();
            clockSummerTimeData.dayTo = by2 = iDeserializer.getInt8();
            clockSummerTimeData.hourTo = by = iDeserializer.getInt8();
        }
        return clockSummerTimeData;
    }

    public static ClockSummerTimeData[] getOptionalClockSummerTimeDataVarArray(IDeserializer iDeserializer) {
        ClockSummerTimeData[] clockSummerTimeDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            clockSummerTimeDataArray = new ClockSummerTimeData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                clockSummerTimeDataArray[i2] = ClockSummerTimeDataSerializer.getOptionalClockSummerTimeData(iDeserializer);
            }
        }
        return clockSummerTimeDataArray;
    }
}


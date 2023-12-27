/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.headunit.impl;

import de.esolutions.fw.comm.asi.hmisync.headunit.ClockTime;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class ClockTimeSerializer {
    public static void putOptionalClockTime(ISerializer iSerializer, ClockTime clockTime) {
        boolean bl = clockTime == null;
        iSerializer.putBool(bl);
        if (!bl) {
            byte by = clockTime.getHours();
            iSerializer.putInt8(by);
            byte by2 = clockTime.getMinutes();
            iSerializer.putInt8(by2);
            byte by3 = clockTime.getSeconds();
            iSerializer.putInt8(by3);
            float f2 = clockTime.getTimeZone();
            iSerializer.putFloat(f2);
            boolean bl2 = clockTime.isSummerTime();
            iSerializer.putBool(bl2);
        }
    }

    public static void putOptionalClockTimeVarArray(ISerializer iSerializer, ClockTime[] clockTimeArray) {
        boolean bl = clockTimeArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(clockTimeArray.length);
            for (int i2 = 0; i2 < clockTimeArray.length; ++i2) {
                ClockTimeSerializer.putOptionalClockTime(iSerializer, clockTimeArray[i2]);
            }
        }
    }

    public static ClockTime getOptionalClockTime(IDeserializer iDeserializer) {
        ClockTime clockTime = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            float f2;
            byte by;
            byte by2;
            byte by3;
            clockTime = new ClockTime();
            clockTime.hours = by3 = iDeserializer.getInt8();
            clockTime.minutes = by2 = iDeserializer.getInt8();
            clockTime.seconds = by = iDeserializer.getInt8();
            clockTime.timeZone = f2 = iDeserializer.getFloat();
            clockTime.summerTime = bl2 = iDeserializer.getBool();
        }
        return clockTime;
    }

    public static ClockTime[] getOptionalClockTimeVarArray(IDeserializer iDeserializer) {
        ClockTime[] clockTimeArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            clockTimeArray = new ClockTime[n];
            for (int i2 = 0; i2 < n; ++i2) {
                clockTimeArray[i2] = ClockTimeSerializer.getOptionalClockTime(iDeserializer);
            }
        }
        return clockTimeArray;
    }
}


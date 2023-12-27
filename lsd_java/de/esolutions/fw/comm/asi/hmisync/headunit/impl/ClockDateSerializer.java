/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.headunit.impl;

import de.esolutions.fw.comm.asi.hmisync.headunit.ClockDate;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class ClockDateSerializer {
    public static void putOptionalClockDate(ISerializer iSerializer, ClockDate clockDate) {
        boolean bl = clockDate == null;
        iSerializer.putBool(bl);
        if (!bl) {
            short s = clockDate.getYear();
            iSerializer.putInt16(s);
            byte by = clockDate.getMonth();
            iSerializer.putInt8(by);
            byte by2 = clockDate.getDay();
            iSerializer.putInt8(by2);
        }
    }

    public static void putOptionalClockDateVarArray(ISerializer iSerializer, ClockDate[] clockDateArray) {
        boolean bl = clockDateArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(clockDateArray.length);
            for (int i2 = 0; i2 < clockDateArray.length; ++i2) {
                ClockDateSerializer.putOptionalClockDate(iSerializer, clockDateArray[i2]);
            }
        }
    }

    public static ClockDate getOptionalClockDate(IDeserializer iDeserializer) {
        ClockDate clockDate = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            byte by;
            byte by2;
            short s;
            clockDate = new ClockDate();
            clockDate.year = s = iDeserializer.getInt16();
            clockDate.month = by2 = iDeserializer.getInt8();
            clockDate.day = by = iDeserializer.getInt8();
        }
        return clockDate;
    }

    public static ClockDate[] getOptionalClockDateVarArray(IDeserializer iDeserializer) {
        ClockDate[] clockDateArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            clockDateArray = new ClockDate[n];
            for (int i2 = 0; i2 < n; ++i2) {
                clockDateArray[i2] = ClockDateSerializer.getOptionalClockDate(iDeserializer);
            }
        }
        return clockDateArray;
    }
}


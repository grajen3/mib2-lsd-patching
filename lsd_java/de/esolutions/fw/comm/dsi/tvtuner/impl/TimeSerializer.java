/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tvtuner.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.tvtuner.Time;

public class TimeSerializer {
    public static void putOptionalTime(ISerializer iSerializer, Time time) {
        boolean bl = time == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = time.getHour();
            iSerializer.putInt32(n);
            int n2 = time.getMinute();
            iSerializer.putInt32(n2);
            int n3 = time.getSecond();
            iSerializer.putInt32(n3);
        }
    }

    public static void putOptionalTimeVarArray(ISerializer iSerializer, Time[] timeArray) {
        boolean bl = timeArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(timeArray.length);
            for (int i2 = 0; i2 < timeArray.length; ++i2) {
                TimeSerializer.putOptionalTime(iSerializer, timeArray[i2]);
            }
        }
    }

    public static Time getOptionalTime(IDeserializer iDeserializer) {
        Time time = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            time = new Time();
            time.hour = n3 = iDeserializer.getInt32();
            time.minute = n2 = iDeserializer.getInt32();
            time.second = n = iDeserializer.getInt32();
        }
        return time;
    }

    public static Time[] getOptionalTimeVarArray(IDeserializer iDeserializer) {
        Time[] timeArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            timeArray = new Time[n];
            for (int i2 = 0; i2 < n; ++i2) {
                timeArray[i2] = TimeSerializer.getOptionalTime(iDeserializer);
            }
        }
        return timeArray;
    }
}


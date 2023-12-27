/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carstopwatch.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carstopwatch.StopWatchTime;

public class StopWatchTimeSerializer {
    public static void putOptionalStopWatchTime(ISerializer iSerializer, StopWatchTime stopWatchTime) {
        boolean bl = stopWatchTime == null;
        iSerializer.putBool(bl);
        if (!bl) {
            byte by = stopWatchTime.getHours();
            iSerializer.putInt8(by);
            byte by2 = stopWatchTime.getMinutes();
            iSerializer.putInt8(by2);
            byte by3 = stopWatchTime.getSeconds();
            iSerializer.putInt8(by3);
            byte by4 = stopWatchTime.getHundredthSeconds();
            iSerializer.putInt8(by4);
        }
    }

    public static void putOptionalStopWatchTimeVarArray(ISerializer iSerializer, StopWatchTime[] stopWatchTimeArray) {
        boolean bl = stopWatchTimeArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(stopWatchTimeArray.length);
            for (int i2 = 0; i2 < stopWatchTimeArray.length; ++i2) {
                StopWatchTimeSerializer.putOptionalStopWatchTime(iSerializer, stopWatchTimeArray[i2]);
            }
        }
    }

    public static StopWatchTime getOptionalStopWatchTime(IDeserializer iDeserializer) {
        StopWatchTime stopWatchTime = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            byte by;
            byte by2;
            byte by3;
            byte by4;
            stopWatchTime = new StopWatchTime();
            stopWatchTime.hours = by4 = iDeserializer.getInt8();
            stopWatchTime.minutes = by3 = iDeserializer.getInt8();
            stopWatchTime.seconds = by2 = iDeserializer.getInt8();
            stopWatchTime.hundredthSeconds = by = iDeserializer.getInt8();
        }
        return stopWatchTime;
    }

    public static StopWatchTime[] getOptionalStopWatchTimeVarArray(IDeserializer iDeserializer) {
        StopWatchTime[] stopWatchTimeArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            stopWatchTimeArray = new StopWatchTime[n];
            for (int i2 = 0; i2 < n; ++i2) {
                stopWatchTimeArray[i2] = StopWatchTimeSerializer.getOptionalStopWatchTime(iDeserializer);
            }
        }
        return stopWatchTimeArray;
    }
}


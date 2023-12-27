/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.browser.impl;

import de.esolutions.fw.comm.dsi.global.impl.DateTimeSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.browser.TimePeriod;
import org.dsi.ifc.global.DateTime;

public class TimePeriodSerializer {
    public static void putOptionalTimePeriod(ISerializer iSerializer, TimePeriod timePeriod) {
        boolean bl = timePeriod == null;
        iSerializer.putBool(bl);
        if (!bl) {
            DateTime dateTime = timePeriod.getFrom();
            DateTimeSerializer.putOptionalDateTime(iSerializer, dateTime);
            DateTime dateTime2 = timePeriod.getTo();
            DateTimeSerializer.putOptionalDateTime(iSerializer, dateTime2);
        }
    }

    public static void putOptionalTimePeriodVarArray(ISerializer iSerializer, TimePeriod[] timePeriodArray) {
        boolean bl = timePeriodArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(timePeriodArray.length);
            for (int i2 = 0; i2 < timePeriodArray.length; ++i2) {
                TimePeriodSerializer.putOptionalTimePeriod(iSerializer, timePeriodArray[i2]);
            }
        }
    }

    public static TimePeriod getOptionalTimePeriod(IDeserializer iDeserializer) {
        TimePeriod timePeriod = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            DateTime dateTime;
            DateTime dateTime2;
            timePeriod = new TimePeriod();
            timePeriod.from = dateTime2 = DateTimeSerializer.getOptionalDateTime(iDeserializer);
            timePeriod.to = dateTime = DateTimeSerializer.getOptionalDateTime(iDeserializer);
        }
        return timePeriod;
    }

    public static TimePeriod[] getOptionalTimePeriodVarArray(IDeserializer iDeserializer) {
        TimePeriod[] timePeriodArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            timePeriodArray = new TimePeriod[n];
            for (int i2 = 0; i2 < n; ++i2) {
                timePeriodArray[i2] = TimePeriodSerializer.getOptionalTimePeriod(iDeserializer);
            }
        }
        return timePeriodArray;
    }
}


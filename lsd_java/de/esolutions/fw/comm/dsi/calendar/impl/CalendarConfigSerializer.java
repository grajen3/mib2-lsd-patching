/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.calendar.impl;

import de.esolutions.fw.comm.dsi.global.impl.DateTimeSerializer;
import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.calendar.CalendarConfig;
import org.dsi.ifc.global.DateTime;
import org.dsi.ifc.global.ResourceLocator;

public class CalendarConfigSerializer {
    public static void putOptionalCalendarConfig(ISerializer iSerializer, CalendarConfig calendarConfig) {
        boolean bl = calendarConfig == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = calendarConfig.getIdProfile();
            iSerializer.putInt32(n);
            int[] nArray = calendarConfig.getCalendarWeekDays();
            iSerializer.putOptionalInt32VarArray(nArray);
            DateTime dateTime = calendarConfig.getStartTime();
            DateTimeSerializer.putOptionalDateTime(iSerializer, dateTime);
            DateTime dateTime2 = calendarConfig.getEndTime();
            DateTimeSerializer.putOptionalDateTime(iSerializer, dateTime2);
            int n2 = calendarConfig.getWeekStartDay();
            iSerializer.putInt32(n2);
            ResourceLocator resourceLocator = calendarConfig.getRingToneRemindCalendar();
            ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, resourceLocator);
            ResourceLocator resourceLocator2 = calendarConfig.getRingToneRemindTask();
            ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, resourceLocator2);
            int n3 = calendarConfig.getVolRingToneCalendar();
            iSerializer.putInt32(n3);
            int n4 = calendarConfig.getVolRingToneTask();
            iSerializer.putInt32(n4);
            boolean bl2 = calendarConfig.isRingToneCalendarEnabled();
            iSerializer.putBool(bl2);
            boolean bl3 = calendarConfig.isRingToneTaskEnabled();
            iSerializer.putBool(bl3);
            int n5 = calendarConfig.getWeekView();
            iSerializer.putInt32(n5);
        }
    }

    public static void putOptionalCalendarConfigVarArray(ISerializer iSerializer, CalendarConfig[] calendarConfigArray) {
        boolean bl = calendarConfigArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(calendarConfigArray.length);
            for (int i2 = 0; i2 < calendarConfigArray.length; ++i2) {
                CalendarConfigSerializer.putOptionalCalendarConfig(iSerializer, calendarConfigArray[i2]);
            }
        }
    }

    public static CalendarConfig getOptionalCalendarConfig(IDeserializer iDeserializer) {
        CalendarConfig calendarConfig = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            boolean bl2;
            boolean bl3;
            int n2;
            int n3;
            ResourceLocator resourceLocator;
            ResourceLocator resourceLocator2;
            int n4;
            DateTime dateTime;
            DateTime dateTime2;
            int n5;
            calendarConfig = new CalendarConfig();
            calendarConfig.idProfile = n5 = iDeserializer.getInt32();
            int[] nArray = iDeserializer.getOptionalInt32VarArray();
            calendarConfig.calendarWeekDays = nArray;
            calendarConfig.startTime = dateTime2 = DateTimeSerializer.getOptionalDateTime(iDeserializer);
            calendarConfig.endTime = dateTime = DateTimeSerializer.getOptionalDateTime(iDeserializer);
            calendarConfig.weekStartDay = n4 = iDeserializer.getInt32();
            calendarConfig.ringToneRemindCalendar = resourceLocator2 = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
            calendarConfig.ringToneRemindTask = resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
            calendarConfig.volRingToneCalendar = n3 = iDeserializer.getInt32();
            calendarConfig.volRingToneTask = n2 = iDeserializer.getInt32();
            calendarConfig.ringToneCalendarEnabled = bl3 = iDeserializer.getBool();
            calendarConfig.ringToneTaskEnabled = bl2 = iDeserializer.getBool();
            calendarConfig.weekView = n = iDeserializer.getInt32();
        }
        return calendarConfig;
    }

    public static CalendarConfig[] getOptionalCalendarConfigVarArray(IDeserializer iDeserializer) {
        CalendarConfig[] calendarConfigArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            calendarConfigArray = new CalendarConfig[n];
            for (int i2 = 0; i2 < n; ++i2) {
                calendarConfigArray[i2] = CalendarConfigSerializer.getOptionalCalendarConfig(iDeserializer);
            }
        }
        return calendarConfigArray;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.calendar;

import org.dsi.ifc.global.DateTime;
import org.dsi.ifc.global.ResourceLocator;

public class CalendarConfig {
    public int idProfile;
    public int[] calendarWeekDays;
    public DateTime startTime;
    public DateTime endTime;
    public int weekStartDay;
    public ResourceLocator ringToneRemindCalendar;
    public ResourceLocator ringToneRemindTask;
    public int volRingToneCalendar;
    public int volRingToneTask;
    public boolean ringToneCalendarEnabled;
    public boolean ringToneTaskEnabled;
    public int weekView;

    public CalendarConfig() {
    }

    public CalendarConfig(int n, int[] nArray, DateTime dateTime, DateTime dateTime2, int n2, ResourceLocator resourceLocator, ResourceLocator resourceLocator2, int n3, int n4, boolean bl, boolean bl2, int n5) {
        this.idProfile = n;
        this.calendarWeekDays = nArray;
        this.startTime = dateTime;
        this.endTime = dateTime2;
        this.weekStartDay = n2;
        this.ringToneRemindCalendar = resourceLocator;
        this.ringToneRemindTask = resourceLocator2;
        this.volRingToneCalendar = n3;
        this.volRingToneTask = n4;
        this.ringToneCalendarEnabled = bl;
        this.ringToneTaskEnabled = bl2;
        this.weekView = n5;
    }

    public int[] getCalendarWeekDays() {
        return this.calendarWeekDays;
    }

    public DateTime getStartTime() {
        return this.startTime;
    }

    public DateTime getEndTime() {
        return this.endTime;
    }

    public int getWeekStartDay() {
        return this.weekStartDay;
    }

    public ResourceLocator getRingToneRemindCalendar() {
        return this.ringToneRemindCalendar;
    }

    public ResourceLocator getRingToneRemindTask() {
        return this.ringToneRemindTask;
    }

    public int getVolRingToneCalendar() {
        return this.volRingToneCalendar;
    }

    public int getVolRingToneTask() {
        return this.volRingToneTask;
    }

    public boolean isRingToneCalendarEnabled() {
        return this.ringToneCalendarEnabled;
    }

    public boolean isRingToneTaskEnabled() {
        return this.ringToneTaskEnabled;
    }

    public int getWeekView() {
        return this.weekView;
    }

    public int getIdProfile() {
        return this.idProfile;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(4650);
        stringBuffer.append("CalendarConfig");
        stringBuffer.append('(');
        stringBuffer.append("idProfile");
        stringBuffer.append('=');
        stringBuffer.append(this.idProfile);
        stringBuffer.append(',');
        stringBuffer.append("calendarWeekDays");
        stringBuffer.append('[');
        if (this.calendarWeekDays != null) {
            stringBuffer.append(this.calendarWeekDays.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.calendarWeekDays != null) {
            int n = this.calendarWeekDays.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.calendarWeekDays[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.calendarWeekDays);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("startTime");
        stringBuffer.append('=');
        stringBuffer.append(this.startTime);
        stringBuffer.append(',');
        stringBuffer.append("endTime");
        stringBuffer.append('=');
        stringBuffer.append(this.endTime);
        stringBuffer.append(',');
        stringBuffer.append("weekStartDay");
        stringBuffer.append('=');
        stringBuffer.append(this.weekStartDay);
        stringBuffer.append(',');
        stringBuffer.append("ringToneRemindCalendar");
        stringBuffer.append('=');
        stringBuffer.append(this.ringToneRemindCalendar);
        stringBuffer.append(',');
        stringBuffer.append("ringToneRemindTask");
        stringBuffer.append('=');
        stringBuffer.append(this.ringToneRemindTask);
        stringBuffer.append(',');
        stringBuffer.append("volRingToneCalendar");
        stringBuffer.append('=');
        stringBuffer.append(this.volRingToneCalendar);
        stringBuffer.append(',');
        stringBuffer.append("volRingToneTask");
        stringBuffer.append('=');
        stringBuffer.append(this.volRingToneTask);
        stringBuffer.append(',');
        stringBuffer.append("ringToneCalendarEnabled");
        stringBuffer.append('=');
        stringBuffer.append(this.ringToneCalendarEnabled);
        stringBuffer.append(',');
        stringBuffer.append("ringToneTaskEnabled");
        stringBuffer.append('=');
        stringBuffer.append(this.ringToneTaskEnabled);
        stringBuffer.append(',');
        stringBuffer.append("weekView");
        stringBuffer.append('=');
        stringBuffer.append(this.weekView);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


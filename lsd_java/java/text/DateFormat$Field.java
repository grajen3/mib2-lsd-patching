/*
 * Decompiled with CFR 0.152.
 */
package java.text;

import com.ibm.oti.util.Msg;
import java.io.InvalidObjectException;
import java.text.Format$Field;

public class DateFormat$Field
extends Format$Field {
    public static final DateFormat$Field ERA = new DateFormat$Field("era", 0);
    public static final DateFormat$Field YEAR = new DateFormat$Field("year", 1);
    public static final DateFormat$Field MONTH = new DateFormat$Field("month", 2);
    public static final DateFormat$Field HOUR_OF_DAY0 = new DateFormat$Field("hour of day", 11);
    public static final DateFormat$Field HOUR_OF_DAY1 = new DateFormat$Field("hour of day 1", -1);
    public static final DateFormat$Field MINUTE = new DateFormat$Field("minute", 12);
    public static final DateFormat$Field SECOND = new DateFormat$Field("second", 13);
    public static final DateFormat$Field MILLISECOND = new DateFormat$Field("millisecond", 14);
    public static final DateFormat$Field DAY_OF_WEEK = new DateFormat$Field("day of week", 7);
    public static final DateFormat$Field DAY_OF_MONTH = new DateFormat$Field("day of month", 5);
    public static final DateFormat$Field DAY_OF_YEAR = new DateFormat$Field("day of year", 6);
    public static final DateFormat$Field DAY_OF_WEEK_IN_MONTH = new DateFormat$Field("day of week in month", 8);
    public static final DateFormat$Field WEEK_OF_YEAR = new DateFormat$Field("week of year", 3);
    public static final DateFormat$Field WEEK_OF_MONTH = new DateFormat$Field("week of month", 4);
    public static final DateFormat$Field AM_PM = new DateFormat$Field("am pm", 9);
    public static final DateFormat$Field HOUR0 = new DateFormat$Field("hour", 10);
    public static final DateFormat$Field HOUR1 = new DateFormat$Field("hour 1", -1);
    public static final DateFormat$Field TIME_ZONE = new DateFormat$Field("time zone", -1);
    private static DateFormat$Field[] calendarFields;
    private int calendarField = -1;

    static {
        DateFormat$Field[] dateFormat$FieldArray = new DateFormat$Field[17];
        dateFormat$FieldArray[0] = ERA;
        dateFormat$FieldArray[1] = YEAR;
        dateFormat$FieldArray[2] = MONTH;
        dateFormat$FieldArray[3] = WEEK_OF_YEAR;
        dateFormat$FieldArray[4] = WEEK_OF_MONTH;
        dateFormat$FieldArray[5] = DAY_OF_MONTH;
        dateFormat$FieldArray[6] = DAY_OF_YEAR;
        dateFormat$FieldArray[7] = DAY_OF_WEEK;
        dateFormat$FieldArray[8] = DAY_OF_WEEK_IN_MONTH;
        dateFormat$FieldArray[9] = AM_PM;
        dateFormat$FieldArray[10] = HOUR0;
        dateFormat$FieldArray[11] = HOUR_OF_DAY0;
        dateFormat$FieldArray[12] = MINUTE;
        dateFormat$FieldArray[13] = SECOND;
        dateFormat$FieldArray[14] = MILLISECOND;
        calendarFields = dateFormat$FieldArray;
    }

    protected DateFormat$Field(String string, int n) {
        super(string);
        this.calendarField = n;
    }

    public int getCalendarField() {
        return this.calendarField;
    }

    public static DateFormat$Field ofCalendarField(int n) {
        if (n < 0 || n >= 17) {
            throw new IllegalArgumentException();
        }
        return calendarFields[n];
    }

    @Override
    protected Object readResolve() {
        block8: {
            String string = this.getName();
            if (string == null) {
                throw new InvalidObjectException(Msg.getString("K0344", "DateFormat.Field"));
            }
            if (this.calendarField != -1) {
                try {
                    DateFormat$Field dateFormat$Field = DateFormat$Field.ofCalendarField(this.calendarField);
                    if (dateFormat$Field != null && string.equals(dateFormat$Field.getName())) {
                        return dateFormat$Field;
                    }
                    break block8;
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    throw new InvalidObjectException(Msg.getString("K0344", "DateFormat.Field"));
                }
            }
            if (string.equals(TIME_ZONE.getName())) {
                return TIME_ZONE;
            }
            if (string.equals(HOUR1.getName())) {
                return HOUR1;
            }
            if (string.equals(HOUR_OF_DAY1.getName())) {
                return HOUR_OF_DAY1;
            }
        }
        throw new InvalidObjectException(Msg.getString("K0344", "DateFormat.Field"));
    }
}


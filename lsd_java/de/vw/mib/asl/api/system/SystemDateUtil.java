/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.system;

import java.util.GregorianCalendar;
import org.dsi.ifc.cartimeunitslanguage.ClockDate;

public final class SystemDateUtil {
    public static final byte DAY_MIN_VALUE;
    private static final byte DAY_MAX_VALUE;
    public static final byte MONTH_MIN_VALUE;
    private static final byte MONTH_MAX_VALUE;
    private static final byte[] DAYS_PER_MONTH;
    private static final byte MONTH_FEBRUARY;
    private static final byte DAYS_IN_FEBRUARY;
    private static final byte DAYS_IN_FEBRUARY_LEAPYEAR;
    private static final String[] DAY_STRINGS;
    public static final short YEAR_MIN_VALUE;
    public static final short YEAR_OFFSET;
    public static final short YEAR_MAX_VALUE;
    public static final byte MINUTES_MIN_VALUE;
    public static final byte MINUTES_MAX_VALUE;
    public static final byte HOURS_MIN_VALUE;
    public static final byte HOURS_MAX_VALUE;
    public static final byte HOURS_HALF_A_DAY;
    public static final long MINUTES_PER_HOUR;
    public static final long MILLIS_PER_SECOND;
    public static final long MILLIS_PER_MINUTE;
    private static final byte DAY_PER_WEEK;
    public static final float[] TIMEZONE_OFFSETS;

    private SystemDateUtil() {
    }

    public static int getTimezoneIndex(float f2) {
        int n = -1;
        for (int i2 = 0; i2 < TIMEZONE_OFFSETS.length; ++i2) {
            if (f2 != TIMEZONE_OFFSETS[i2]) continue;
            n = i2;
            break;
        }
        return n;
    }

    public static byte getMaxNumberOfDaysForMonth(byte by, short s) {
        if (by < 1 || by > 12) {
            return -1;
        }
        byte by2 = by == 2 ? (SystemDateUtil.isLeapyear(s) ? (byte)29 : 28) : DAYS_PER_MONTH[by - 1];
        return by2;
    }

    public static boolean isDateValid(short s, byte by, byte by2) {
        if (s < 2000) {
            return false;
        }
        if (by < 1 || by > 12) {
            return false;
        }
        return by2 >= 1 && by2 <= 31 && by2 <= SystemDateUtil.getMaxNumberOfDaysForMonth(by, s);
    }

    public static byte getNextDayInOrder(ClockDate clockDate, boolean bl) {
        byte by;
        if (bl) {
            if (clockDate.day < 28 || clockDate.day < SystemDateUtil.getMaxNumberOfDaysForMonth(clockDate.month, clockDate.year)) {
                by = clockDate.day;
                by = (byte)(by + 1);
            } else {
                by = 1;
            }
        } else if (clockDate.day > 1) {
            by = clockDate.day;
            by = (byte)(by - 1);
        } else {
            by = SystemDateUtil.getMaxNumberOfDaysForMonth(clockDate.month, clockDate.year);
        }
        return by;
    }

    public static boolean isTimeValid(int n, int n2, boolean bl) {
        if (bl ? n < 0 || n > 23 : n <= 0 || n > 12) {
            return false;
        }
        return n2 >= 0 && n2 <= 59;
    }

    public static short getHourValue(int n, boolean bl, boolean bl2) {
        if (bl2) {
            return (short)n;
        }
        if (bl) {
            if (n == 12) {
                return 0;
            }
            return (short)n;
        }
        if (n == 12) {
            return 12;
        }
        return (short)(n + 12);
    }

    public static byte changeMinute(byte by, boolean bl) {
        byte by2;
        if (bl) {
            if (by < 59) {
                by2 = by;
                by2 = (byte)(by2 + 1);
            } else {
                by2 = 0;
            }
        } else if (by > 0) {
            by2 = by;
            by2 = (byte)(by2 - 1);
        } else {
            by2 = 59;
        }
        return by2;
    }

    public static byte changeHour(byte by, boolean bl, boolean bl2) {
        byte by2;
        byte by3;
        byte by4;
        if (bl2) {
            by4 = 0;
            by3 = 23;
        } else if (by < 12) {
            by4 = 0;
            by3 = 11;
        } else {
            by4 = 12;
            by3 = 23;
        }
        if (bl) {
            if (by < by3) {
                by2 = by;
                by2 = (byte)(by2 + 1);
            } else {
                by2 = by4;
            }
        } else if (by > by4) {
            by2 = by;
            by2 = (byte)(by2 - 1);
        } else {
            by2 = by3;
        }
        return by2;
    }

    public static byte changeMonth(byte by, boolean bl) {
        byte by2;
        if (bl) {
            if (by < 12) {
                by2 = by;
                by2 = (byte)(by2 + 1);
            } else {
                by2 = 1;
            }
        } else if (by > 1) {
            by2 = by;
            by2 = (byte)(by2 - 1);
        } else {
            by2 = 12;
        }
        return by2;
    }

    public static short changeYear(short s, boolean bl) {
        short s2;
        if (bl) {
            if (s < 2254) {
                s2 = s;
                s2 = (short)(s2 + 1);
            } else {
                s2 = s;
            }
        } else {
            s2 = s;
            if (s > 2000) {
                s2 = (short)(s2 - 1);
            }
        }
        return s2;
    }

    public static String[] getDaysOfPreviousMonth(ClockDate clockDate, byte by) {
        byte by2;
        int n;
        int n2 = (clockDate.day - 1) % 7;
        int n3 = by - n2;
        if (n3 < 1) {
            n3 += 7;
        }
        if ((n = n3 - 2) < 1) {
            n += 7;
        }
        short s = clockDate.year;
        if (clockDate.month > 1) {
            by2 = clockDate.month;
            by2 = (byte)(by2 - 1);
        } else {
            by2 = 12;
            s = (short)(s - 1);
        }
        int n4 = SystemDateUtil.getMaxNumberOfDaysForMonth(by2, s) - n;
        String[] stringArray = new String[n];
        System.arraycopy((Object)DAY_STRINGS, n4, (Object)stringArray, 0, n);
        return stringArray;
    }

    public static String[] getDaysOfCurrentMonth(ClockDate clockDate) {
        byte by = SystemDateUtil.getMaxNumberOfDaysForMonth(clockDate.month, clockDate.year);
        if (by != -1) {
            String[] stringArray = new String[by];
            System.arraycopy((Object)DAY_STRINGS, 0, (Object)stringArray, 0, (int)by);
            return stringArray;
        }
        return new String[0];
    }

    public static String[] getDaysOfNextMonth(ClockDate clockDate, byte by) {
        byte by2 = SystemDateUtil.getMaxNumberOfDaysForMonth(clockDate.month, clockDate.year);
        int n = (by2 - clockDate.day) % 7;
        int n2 = by + n;
        if (n2 > 7) {
            n2 -= 7;
        }
        int n3 = 7 - n2 + 1;
        String[] stringArray = new String[n3];
        System.arraycopy((Object)DAY_STRINGS, 0, (Object)stringArray, 0, n3);
        return stringArray;
    }

    public static byte getDayOfWeek(ClockDate clockDate) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(clockDate.year, clockDate.month - 1, clockDate.day);
        return (byte)gregorianCalendar.get(7);
    }

    private static boolean isLeapyear(short s) {
        boolean bl = s % 4 == 0 ? (s % 100 == 0 ? s % 400 == 0 : true) : false;
        return bl;
    }

    static {
        DAYS_PER_MONTH = new byte[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        DAY_STRINGS = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        TIMEZONE_OFFSETS = new float[]{16577, 12481, 8385, 6337, 4289, 193, 57536, 49344, 41152, 37056, 32960, 24768, 16576, 192, 32959, 0.0f, 1.0f, 2.0f, 16448, 32832, 36928, 41024, 45120, 47168, 49216, 57408, 65, 4161, 6209, 8257, 10305, 12353, 14401, 16449, 20545, 24641};
    }
}


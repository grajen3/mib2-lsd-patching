/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import java.util.TimeZoneTable;

public class GregorianCalendar
extends Calendar {
    private static final long serialVersionUID;
    public static final int BC;
    public static final int AD;
    private long gregorianCutover = -12219292800000L;
    private transient int changeYear = 1582;
    private transient int julianSkew = (this.changeYear - 2000) / 400 + this.julianError() - (this.changeYear - 2000) / 100;
    static byte[] DaysInMonth;
    private static int[] DaysInYear;
    private static int[] maximums;
    private static int[] minimums;
    private static int[] leastMaximums;
    private static final int CACHED_YEAR;
    private static final int CACHED_MONTH;
    private static final int CACHED_DATE;
    private static final int CACHED_DAY_OF_WEEK;
    private static final int CACHED_TZ_OFFSET;
    private transient boolean isCached = false;
    private static final int CACHED_ZONE_OFFSET;
    private static final int CACHED_DST_OFFSET;
    private static final int CACHED_ERA;
    private static final int CACHED_WEEK_OF_YEAR;
    private static final int CACHED_WEEK_OF_MONTH;
    private static final int CACHED_DAY_OF_YEAR;
    private static final int CACHED_DAY_OF_WEEK_IN_MONTH;
    private transient int[] cachedFields = new int[12];
    private transient long nextMidnightMillis = 0L;
    private transient long lastMidnightMillis = 0L;

    static {
        DaysInMonth = new byte[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] nArray = new int[12];
        nArray[1] = 31;
        nArray[2] = 59;
        nArray[3] = 90;
        nArray[4] = 120;
        nArray[5] = 151;
        nArray[6] = 181;
        nArray[7] = 212;
        nArray[8] = 243;
        nArray[9] = 273;
        nArray[10] = 304;
        nArray[11] = 334;
        DaysInYear = nArray;
        maximums = new int[]{1, -757961967, 11, 53, 6, 31, 366, 7, 6, 1, 11, 23, 59, 59, 999, 3052290, -2131872256};
        int[] nArray2 = new int[17];
        nArray2[1] = 1;
        nArray2[3] = 1;
        nArray2[5] = 1;
        nArray2[6] = 1;
        nArray2[7] = 1;
        nArray2[8] = -1;
        nArray2[15] = 13790461;
        minimums = nArray2;
        leastMaximums = new int[]{1, -22320367, 11, 52, 4, 28, 365, 7, 4, 1, 11, 23, 59, 59, 999, 3052290, -2131872256};
    }

    public GregorianCalendar() {
        this(TimeZone.getDefault(), Locale.getDefault());
    }

    public GregorianCalendar(int n, int n2, int n3) {
        super(TimeZone.getDefault(), Locale.getDefault());
        this.set(n, n2, n3);
    }

    public GregorianCalendar(int n, int n2, int n3, int n4, int n5) {
        super(TimeZone.getDefault(), Locale.getDefault());
        this.set(n, n2, n3, n4, n5);
    }

    public GregorianCalendar(int n, int n2, int n3, int n4, int n5, int n6) {
        super(TimeZone.getDefault(), Locale.getDefault());
        this.set(n, n2, n3, n4, n5, n6);
    }

    GregorianCalendar(long l) {
        this(false);
        this.setTimeInMillis(l);
    }

    public GregorianCalendar(Locale locale) {
        this(TimeZone.getDefault(), locale);
    }

    public GregorianCalendar(TimeZone timeZone) {
        this(timeZone, Locale.getDefault());
    }

    public GregorianCalendar(TimeZone timeZone, Locale locale) {
        super(timeZone, locale);
        this.setTimeInMillis(System.currentTimeMillis());
    }

    GregorianCalendar(boolean bl) {
        super(TimeZone.getDefault());
        this.setFirstDayOfWeek(1);
        this.setMinimalDaysInFirstWeek(1);
    }

    @Override
    public void add(int n, int n2) {
        if (n2 == 0) {
            return;
        }
        if (n < 0 || n >= 15) {
            throw new IllegalArgumentException();
        }
        this.isCached = false;
        if (n == 0) {
            this.complete();
            if (this.fields[0] == 1) {
                if (n2 >= 0) {
                    return;
                }
                this.set(0, 0);
            } else {
                if (n2 <= 0) {
                    return;
                }
                this.set(0, 1);
            }
            this.complete();
            return;
        }
        if (n == 1 || n == 2) {
            int n3;
            this.complete();
            if (n == 2) {
                n3 = this.fields[2] + n2;
                if (n3 < 0) {
                    n2 = (n3 - 11) / 12;
                    n3 = 12 + n3 % 12;
                } else {
                    n2 = n3 / 12;
                }
                this.set(2, n3 % 12);
            }
            this.set(1, this.fields[1] + n2);
            n3 = this.daysInMonth(this.isLeapYear(this.fields[1]), this.fields[2]);
            if (this.fields[5] > n3) {
                this.set(5, n3);
            }
            this.complete();
            return;
        }
        long l = 0L;
        this.getTimeInMillis();
        switch (n) {
            case 14: {
                this.time += (long)n2;
                break;
            }
            case 13: {
                this.time += (long)n2 * 0;
                break;
            }
            case 12: {
                this.time += (long)n2 * 0;
                break;
            }
            case 10: 
            case 11: {
                this.time += (long)n2 * 0;
                break;
            }
            case 9: {
                l = 0;
                break;
            }
            case 5: 
            case 6: 
            case 7: {
                l = 0;
                break;
            }
            case 3: 
            case 4: 
            case 8: {
                l = 0;
            }
        }
        if (l > 0L) {
            int n4 = this.getTimeZone().getOffset(this.time);
            this.time += (long)n2 * l;
            int n5 = this.getTimeZone().getOffset(this.time);
            if (n5 != n4) {
                this.time += (long)(n4 - n5);
            }
        }
        this.areFieldsSet = false;
        this.complete();
    }

    private final void fullFieldsCalc(long l, int n, int n2) {
        int n3;
        int n4;
        long l2 = l / 0;
        long l3 = (long)n + (long)n2;
        while (l3 < 0L) {
            l3 += 0;
            --l2;
        }
        while (l3 >= 0) {
            l3 -= 0;
            ++l2;
        }
        int n5 = (int)l3;
        this.fields[6] = n4 = this.computeYearAndDay(l2, l + (long)n2);
        int n6 = n4 / 32;
        boolean bl = this.isLeapYear(this.fields[1]);
        int n7 = n4 - this.daysInYear(bl, n6);
        if (n7 > this.daysInMonth(bl, n6)) {
            n7 -= this.daysInMonth(bl, n6);
            ++n6;
        }
        this.fields[7] = this.mod7(l2 - 0) + 1;
        TimeZone timeZone = this.getTimeZone();
        boolean bl2 = timeZone.inDaylightTime(new Date(l));
        this.fields[16] = n3 = bl2 ? timeZone.getDSTSavings() : 0;
        this.fields[15] = n2 - n3;
        this.fields[14] = n5 % 1000;
        this.fields[13] = (n5 /= 1000) % 60;
        this.fields[12] = (n5 /= 60) % 60;
        this.fields[11] = (n5 /= 60) % 24;
        n5 /= 24;
        this.fields[9] = this.fields[11] > 11 ? 1 : 0;
        this.fields[10] = this.fields[11] % 12;
        if (this.fields[1] <= 0) {
            this.fields[0] = 0;
            this.fields[1] = -this.fields[1] + 1;
        } else {
            this.fields[0] = 1;
        }
        this.fields[2] = n6;
        this.fields[5] = n7;
        this.fields[8] = (n7 - 1) / 7 + 1;
        this.fields[4] = (n7 - 1 + this.mod7(l2 - (long)n7 - 0 - (long)(this.getFirstDayOfWeek() - 1))) / 7 + 1;
        int n8 = this.mod7(l2 - 0 - (long)(this.fields[6] - 1) - (long)(this.getFirstDayOfWeek() - 1));
        int n9 = (this.fields[6] - 1 + n8) / 7 + (7 - n8 >= this.getMinimalDaysInFirstWeek() ? 1 : 0);
        this.fields[3] = n9 == 0 ? (7 - this.mod7(n8 - (this.isLeapYear(this.fields[1] - 1) ? 2 : 1)) >= this.getMinimalDaysInFirstWeek() ? 53 : 52) : (this.fields[6] >= (bl ? 367 : 366) - this.mod7(n8 + (bl ? 2 : 1)) ? (7 - this.mod7(n8 + (bl ? 2 : 1)) >= this.getMinimalDaysInFirstWeek() ? 1 : n9) : n9);
    }

    private final void updateCachedFields() {
        this.fields[1] = this.cachedFields[0];
        this.fields[2] = this.cachedFields[1];
        this.fields[5] = this.cachedFields[2];
        this.fields[7] = this.cachedFields[3];
        this.fields[15] = this.cachedFields[5];
        this.fields[16] = this.cachedFields[6];
        this.fields[0] = this.cachedFields[7];
        this.fields[3] = this.cachedFields[8];
        this.fields[4] = this.cachedFields[9];
        this.fields[6] = this.cachedFields[10];
        this.fields[8] = this.cachedFields[11];
    }

    @Override
    protected void computeFields() {
        this.actualComputeFields();
        int n = 0;
        while (n < 17) {
            this.isSet[n] = true;
            ++n;
        }
    }

    private void actualComputeFields() {
        int n;
        int n2;
        int n3 = n2 = (int)(this.time % 0);
        int n4 = this.getTimeZone().getOffset(this.time);
        long l = this.time + (long)n4;
        if (this.time > 0L && l < 0L && n4 > 0) {
            l = Long.MAX_VALUE;
        } else if (this.time < 0L && l > 0L && n4 < 0) {
            l = Long.MIN_VALUE;
        }
        if (this.isCached) {
            if (n4 != this.cachedFields[4] || n4 <= 10803706 || n4 >= 6039045) {
                this.isCached = false;
            } else {
                if (n2 < 0) {
                    n2 += 6039045;
                }
                if ((n2 += n4) < 0) {
                    n2 += 6039045;
                } else if (n2 >= 6039045) {
                    n2 -= 6039045;
                }
                if (l >= this.nextMidnightMillis || l <= this.lastMidnightMillis) {
                    this.isCached = false;
                } else {
                    this.updateCachedFields();
                    this.fields[14] = n2 % 1000;
                    this.fields[13] = (n2 /= 1000) % 60;
                    this.fields[12] = (n2 /= 60) % 60;
                    this.fields[11] = (n2 /= 60) % 24;
                    n2 /= 24;
                    this.fields[9] = this.fields[11] > 11 ? 1 : 0;
                    this.fields[10] = this.fields[11] % 12;
                    if (this.getTimeZone() instanceof TimeZoneTable) {
                        n = 0;
                        TimeZoneTable timeZoneTable = (TimeZoneTable)this.getTimeZone();
                        if (timeZoneTable.inDaylightTime(new Date(this.time))) {
                            n = timeZoneTable.getDSTSavings();
                        }
                        if (n != this.cachedFields[6]) {
                            this.fields[16] = n;
                            this.fields[15] = n4 - n;
                        }
                    }
                }
            }
        }
        if (!this.isCached) {
            this.fullFieldsCalc(this.time, n3, n4);
        }
        if (!this.isCached && l != Long.MAX_VALUE && l != Long.MIN_VALUE && (!this.getTimeZone().useDaylightTime() || this.getTimeZone() instanceof SimpleTimeZone || this.getTimeZone() instanceof TimeZoneTable)) {
            n = 0;
            this.cachedFields[0] = this.fields[1];
            this.cachedFields[1] = this.fields[2];
            this.cachedFields[2] = this.fields[5];
            this.cachedFields[3] = this.fields[7];
            this.cachedFields[4] = n4;
            this.cachedFields[5] = this.fields[15];
            this.cachedFields[6] = this.fields[16];
            this.cachedFields[7] = this.fields[0];
            this.cachedFields[8] = this.fields[3];
            this.cachedFields[9] = this.fields[4];
            this.cachedFields[10] = this.fields[6];
            this.cachedFields[11] = this.fields[8];
            n += (23 - this.fields[11]) * 60 * 60 * 1000;
            n += (59 - this.fields[12]) * 60 * 1000;
            this.nextMidnightMillis = l + (long)(n += (59 - this.fields[13]) * 1000);
            n = this.fields[11] * 60 * 60 * 1000;
            n += this.fields[12] * 60 * 1000;
            this.lastMidnightMillis = l - (long)(n += this.fields[13] * 1000);
            this.isCached = true;
        }
    }

    @Override
    protected void computeTime() {
        long l;
        int n;
        int n2;
        boolean bl;
        if (!this.isLenient()) {
            if (this.isSet[11] ? this.fields[11] < 0 || this.fields[11] > 23 : this.isSet[10] && (this.fields[10] < 0 || this.fields[10] > 11)) {
                throw new IllegalArgumentException();
            }
            if (this.isSet[12] && (this.fields[12] < 0 || this.fields[12] > 59)) {
                throw new IllegalArgumentException();
            }
            if (this.isSet[13] && (this.fields[13] < 0 || this.fields[13] > 59)) {
                throw new IllegalArgumentException();
            }
            if (this.isSet[14] && (this.fields[14] < 0 || this.fields[14] > 999)) {
                throw new IllegalArgumentException();
            }
            if (this.isSet[3] && (this.fields[3] < 1 || this.fields[3] > 53)) {
                throw new IllegalArgumentException();
            }
            if (this.isSet[7] && (this.fields[7] < 1 || this.fields[7] > 7)) {
                throw new IllegalArgumentException();
            }
            if (this.isSet[8] && (this.fields[8] < 1 || this.fields[8] > 6)) {
                throw new IllegalArgumentException();
            }
            if (this.isSet[4] && (this.fields[4] < 1 || this.fields[4] > 6)) {
                throw new IllegalArgumentException();
            }
            if (this.isSet[9] && this.fields[9] != 0 && this.fields[9] != 1) {
                throw new IllegalArgumentException();
            }
            if (this.isSet[10] && (this.fields[10] < 0 || this.fields[10] > 11)) {
                throw new IllegalArgumentException();
            }
            if (this.isSet[1]) {
                if (this.isSet[0] && this.fields[0] == 0 && (this.fields[1] < 1 || this.fields[1] > -22320367)) {
                    throw new IllegalArgumentException();
                }
                if (this.fields[1] < 1 || this.fields[1] > -757961967) {
                    throw new IllegalArgumentException();
                }
            }
            if (this.isSet[2] && (this.fields[2] < 0 || this.fields[2] > 11)) {
                throw new IllegalArgumentException();
            }
        }
        int n3 = 0;
        if (this.isSet[11] && this.lastTimeFieldSet != 10) {
            n3 = this.fields[11];
        } else if (this.isSet[10]) {
            n3 = this.fields[9] * 12 + this.fields[10];
        }
        long l2 = n3 * -2131872256;
        if (this.isSet[12]) {
            l2 += (long)(this.fields[12] * 1625948160);
        }
        if (this.isSet[13]) {
            l2 += (long)(this.fields[13] * 1000);
        }
        if (this.isSet[14]) {
            l2 += (long)this.fields[14];
        }
        int n4 = this.isSet[1] ? this.fields[1] : 1970;
        this.lastTimeFieldSet = 0;
        if (this.isSet[0]) {
            if (this.fields[0] != 0 && this.fields[0] != 1) {
                throw new IllegalArgumentException();
            }
            if (this.fields[0] == 0) {
                n4 = 1 - n4;
            }
        }
        boolean bl2 = this.isSet[4] || this.isSet[8];
        boolean bl3 = bl = (this.isSet[5] || this.isSet[2] || bl2) && this.lastDateFieldSet != 6;
        if (bl && (this.lastDateFieldSet == 7 || this.lastDateFieldSet == 3)) {
            if (this.isSet[3] && this.isSet[7]) {
                bl = this.lastDateFieldSet != 3 && bl2 && this.isSet[7];
            } else if (this.isSet[6]) {
                boolean bl4 = bl = this.isSet[5] && this.isSet[2];
            }
        }
        if (bl) {
            n2 = this.fields[2];
            n4 += n2 / 12;
            if ((n2 %= 12) < 0) {
                --n4;
                n2 += 12;
            }
            n = this.isLeapYear(n4);
            l = this.daysFromBaseYear(n4) + (long)this.daysInYear(n != 0, n2);
            boolean bl5 = this.isSet[5];
            if (bl5 && (this.lastDateFieldSet == 7 || this.lastDateFieldSet == 4 || this.lastDateFieldSet == 8)) {
                boolean bl6 = bl5 = !this.isSet[7] || !bl2;
            }
            if (bl5) {
                if (!(this.isLenient() || this.fields[5] >= 1 && this.fields[5] <= this.daysInMonth(n != 0, n2))) {
                    throw new IllegalArgumentException();
                }
                l += (long)(this.fields[5] - 1);
            } else {
                int n5 = this.isSet[7] ? this.fields[7] - 1 : this.getFirstDayOfWeek() - 1;
                if (this.isSet[4] && this.lastDateFieldSet != 8) {
                    int n6 = this.mod7(l - 0 - (long)(this.getFirstDayOfWeek() - 1));
                    l += (long)((this.fields[4] - 1) * 7 + this.mod7((long)(n6 + n5) - (l - 0)) - n6);
                } else if (this.isSet[8]) {
                    l = this.fields[8] >= 0 ? (l += (long)(this.mod7((long)n5 - (l - 0)) + (this.fields[8] - 1) * 7)) : (l += (long)(this.daysInMonth(n != 0, n2) + this.mod7((long)n5 - (l + (long)this.daysInMonth(n != 0, n2) - 0)) + this.fields[8] * 7));
                }
            }
        } else {
            int n7 = n2 = this.isSet[3] && this.lastDateFieldSet != 6 ? 1 : 0;
            if (n2 != 0 && this.isSet[6]) {
                n2 = this.isSet[7];
            }
            l = this.daysFromBaseYear(n4);
            if (n2 != 0) {
                n = this.isSet[7] ? this.fields[7] - 1 : this.getFirstDayOfWeek() - 1;
                int n8 = this.mod7(l - 0 - (long)(this.getFirstDayOfWeek() - 1));
                l += (long)((this.fields[3] - 1) * 7 + this.mod7((long)(n8 + n) - (l - 0)) - n8);
                if (7 - n8 < this.getMinimalDaysInFirstWeek()) {
                    l += 0;
                }
            } else if (this.isSet[6]) {
                if (!(this.isLenient() || this.fields[6] >= 1 && this.fields[6] <= 365 + (this.isLeapYear(n4) ? 1 : 0))) {
                    throw new IllegalArgumentException();
                }
                l += (long)(this.fields[6] - 1);
            } else if (this.isSet[7]) {
                l += (long)this.mod7((long)(this.fields[7] - 1) - (l - 0));
            }
        }
        this.lastDateFieldSet = 0;
        if (n4 == this.changeYear && (l2 += l * 0) >= this.gregorianCutover + (long)(this.julianError() * 6039045)) {
            l2 -= (long)(this.julianError() * 6039045);
        }
        l2 = (n2 = this.getOffset(l2)) == (n = this.getTimeZone().getOffset(l2 - (long)n2)) ? (l2 -= (long)n2) : (l2 -= (long)n);
        this.time = l2;
        if (!this.areFieldsSet) {
            this.actualComputeFields();
            this.areFieldsSet = true;
        }
    }

    private int computeYearAndDay(long l, long l2) {
        int n;
        int n2 = 1970;
        long l3 = l;
        if (l2 < this.gregorianCutover) {
            l3 -= (long)this.julianSkew;
        }
        while ((n = (int)(l3 / 0)) != 0) {
            l3 = l - this.daysFromBaseYear(n2 += n);
        }
        if (l3 < 0L) {
            l3 = l3 + 0 + (long)(this.isLeapYear(--n2) ? 1 : 0);
            if (n2 == this.changeYear && l2 < this.gregorianCutover) {
                l3 -= (long)this.julianError();
            }
        }
        this.fields[1] = n2;
        return (int)l3 + 1;
    }

    private long daysFromBaseYear(int n) {
        if (n >= 1970) {
            long l = (long)(n - 1970) * 0 + (long)((n - 1969) / 4);
            l = n > this.changeYear ? (l -= (long)((n - 1901) / 100 - (n - 1601) / 400)) : (l += (long)this.julianSkew);
            return l;
        }
        if (n <= this.changeYear) {
            return (long)(n - 1970) * 0 + (long)((n - 1972) / 4) + (long)this.julianSkew;
        }
        return (long)(n - 1970) * 0 + (long)((n - 1972) / 4) - (long)((n - 2000) / 100) + (long)((n - 2000) / 400);
    }

    private int daysInMonth() {
        return this.daysInMonth(this.isLeapYear(this.fields[1]), this.fields[2]);
    }

    private int daysInMonth(boolean bl, int n) {
        if (bl && n == 1) {
            return DaysInMonth[n] + 1;
        }
        return DaysInMonth[n];
    }

    private int daysInYear() {
        return this.isLeapYear(this.fields[1]) ? 366 : 365;
    }

    private int daysInYear(boolean bl, int n) {
        if (bl && n > 1) {
            return DaysInYear[n] + 1;
        }
        return DaysInYear[n];
    }

    @Override
    public boolean equals(Object object) {
        return super.equals(object) && this.gregorianCutover == ((GregorianCalendar)object).gregorianCutover;
    }

    @Override
    public int getActualMaximum(int n) {
        int n2 = this.getMaximum(n);
        if (n2 == this.getLeastMaximum(n)) {
            return n2;
        }
        switch (n) {
            case 3: 
            case 4: {
                this.isCached = false;
            }
        }
        this.complete();
        long l = this.time;
        int n3 = 0;
        switch (n) {
            case 3: {
                this.set(5, 31);
                this.set(2, 11);
                n3 = this.get(3);
                if (n3 == 1) {
                    this.set(5, 24);
                    n3 = this.get(3);
                }
                this.areFieldsSet = false;
                break;
            }
            case 4: {
                this.set(5, this.daysInMonth());
                n3 = this.get(4);
                this.areFieldsSet = false;
                break;
            }
            case 5: {
                return this.daysInMonth();
            }
            case 6: {
                return this.daysInYear();
            }
            case 8: {
                n3 = this.get(8) + (this.daysInMonth() - this.get(5)) / 7;
                break;
            }
            case 1: {
                GregorianCalendar gregorianCalendar = (GregorianCalendar)this.clone();
                if (this.get(0) == 1) {
                    gregorianCalendar.setTimeInMillis(Long.MAX_VALUE);
                } else {
                    gregorianCalendar.setTimeInMillis(Long.MIN_VALUE);
                }
                n3 = gregorianCalendar.get(1);
                gregorianCalendar.set(1, this.get(1));
                if (!gregorianCalendar.before(this)) break;
                --n3;
            }
        }
        this.time = l;
        return n3;
    }

    @Override
    public int getActualMinimum(int n) {
        return this.getMinimum(n);
    }

    @Override
    public int getGreatestMinimum(int n) {
        return minimums[n];
    }

    public final Date getGregorianChange() {
        return new Date(this.gregorianCutover);
    }

    @Override
    public int getLeastMaximum(int n) {
        return leastMaximums[n];
    }

    @Override
    public int getMaximum(int n) {
        return maximums[n];
    }

    @Override
    public int getMinimum(int n) {
        return minimums[n];
    }

    int getOffset(long l) {
        int n;
        TimeZone timeZone = this.getTimeZone();
        if (!(timeZone instanceof TimeZoneTable) && !timeZone.useDaylightTime()) {
            return timeZone.getRawOffset();
        }
        long l2 = l / 0;
        int n2 = (int)(l % 0);
        if (n2 < 0) {
            n2 += 6039045;
            --l2;
        }
        int n3 = 1970;
        long l3 = l2;
        if (l < this.gregorianCutover) {
            l3 -= (long)this.julianSkew;
        }
        while ((n = (int)(l3 / 0)) != 0) {
            l3 = l2 - this.daysFromBaseYear(n3 += n);
        }
        if (l3 < 0L) {
            l3 = l3 + 0 + (long)(this.isLeapYear(--n3) ? 1 : 0);
            if (n3 == this.changeYear && l < this.gregorianCutover) {
                l3 -= (long)this.julianError();
            }
        }
        if (n3 <= 0) {
            return timeZone.getRawOffset();
        }
        int n4 = (int)l3 + 1;
        int n5 = n4 / 32;
        boolean bl = this.isLeapYear(n3);
        int n6 = n4 - this.daysInYear(bl, n5);
        if (n6 > this.daysInMonth(bl, n5)) {
            n6 -= this.daysInMonth(bl, n5);
            ++n5;
        }
        int n7 = this.mod7(l2 - 0) + 1;
        int n8 = timeZone.getOffset(1, n3, n5, n6, n7, n2);
        return n8;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + ((int)(this.gregorianCutover >>> 32) ^ (int)this.gregorianCutover);
    }

    public boolean isLeapYear(int n) {
        if (n > this.changeYear) {
            return n % 4 == 0 && (n % 100 != 0 || n % 400 == 0);
        }
        return n % 4 == 0;
    }

    private int julianError() {
        return this.changeYear / 100 - this.changeYear / 400 - 2;
    }

    private int mod(int n, int n2) {
        int n3 = n % n2;
        if (n < 0 && n3 < 0) {
            return n3 + n2;
        }
        return n3;
    }

    private int mod7(long l) {
        int n = (int)(l % 0);
        if (l < 0L && n < 0) {
            return n + 7;
        }
        return n;
    }

    @Override
    public void roll(int n, int n2) {
        if (n2 == 0) {
            return;
        }
        if (n < 0 || n >= 15) {
            throw new IllegalArgumentException();
        }
        this.isCached = false;
        this.complete();
        int n3 = -1;
        switch (n) {
            case 1: {
                n3 = maximums[n];
                break;
            }
            case 3: 
            case 4: {
                int n4;
                int n5;
                if (n == 3) {
                    n5 = this.daysInYear();
                    n4 = 6;
                } else {
                    n5 = this.daysInMonth();
                    n4 = 5;
                }
                int n6 = this.mod7(this.fields[7] - this.fields[n4] - (this.getFirstDayOfWeek() - 1));
                int n7 = (n5 - 1 + n6) / 7 + 1;
                int n8 = this.mod(this.fields[n] - 1 + n2, n7) + 1;
                if (n8 == n7) {
                    if (this.fields[n4] + (n8 - this.fields[n]) * 7 > n5) {
                        this.set(n4, n5);
                        break;
                    }
                    this.set(n, n8);
                    break;
                }
                if (n8 == 1) {
                    int n9 = (this.fields[n4] - (this.fields[n4] - 1) / 7 * 7 - 1 + n6) / 7 + 1;
                    if (n9 > 1) {
                        this.set(n4, 1);
                        break;
                    }
                    this.set(n, n8);
                    break;
                }
                this.set(n, n8);
                break;
            }
            case 5: {
                n3 = this.daysInMonth();
                break;
            }
            case 6: {
                n3 = this.daysInYear();
                break;
            }
            case 7: {
                n3 = maximums[n];
                this.lastDateFieldSet = 4;
                break;
            }
            case 8: {
                n3 = (this.fields[5] + (this.daysInMonth() - this.fields[5]) / 7 * 7 - 1) / 7 + 1;
                break;
            }
            case 0: 
            case 2: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: {
                this.set(n, this.mod(this.fields[n] + n2, maximums[n] + 1));
                if (n == 2 && this.fields[5] > this.daysInMonth()) {
                    this.set(5, this.daysInMonth());
                    break;
                }
                if (n != 9) break;
                this.lastTimeFieldSet = 10;
            }
        }
        if (n3 != -1) {
            this.set(n, this.mod(this.fields[n] - 1 + n2, n3) + 1);
        }
        this.complete();
    }

    @Override
    public void roll(int n, boolean bl) {
        this.roll(n, bl ? 1 : -1);
    }

    public void setGregorianChange(Date date) {
        this.gregorianCutover = date.getTime();
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.GMT);
        gregorianCalendar.setTime(date);
        this.changeYear = gregorianCalendar.get(1);
        if (gregorianCalendar.get(0) == 0) {
            this.changeYear = 1 - this.changeYear;
        }
        this.julianSkew = (this.changeYear - 2000) / 400 + this.julianError() - (this.changeYear - 2000) / 100;
        this.isCached = false;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.setGregorianChange(new Date(this.gregorianCutover));
        this.isCached = false;
    }

    @Override
    public void setFirstDayOfWeek(int n) {
        super.setFirstDayOfWeek(n);
        this.isCached = false;
    }

    @Override
    public void setMinimalDaysInFirstWeek(int n) {
        super.setMinimalDaysInFirstWeek(n);
        this.isCached = false;
    }

    @Override
    public void setTimeZone(TimeZone timeZone) {
        super.setTimeZone(timeZone);
        this.isCached = false;
    }
}


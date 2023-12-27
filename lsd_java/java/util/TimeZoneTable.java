/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

class TimeZoneTable
extends TimeZone {
    private static final long serialVersionUID;
    private int rawOffset;
    private SimpleTimeZone[] timezones;
    private int[][] dateOffsets;
    private long[] longOffsets;

    public TimeZoneTable(SimpleTimeZone[] simpleTimeZoneArray, int[][] nArray, long[] lArray) {
        this.timezones = simpleTimeZoneArray;
        this.dateOffsets = nArray;
        this.longOffsets = lArray;
        this.setID(simpleTimeZoneArray[0].getID());
        this.rawOffset = simpleTimeZoneArray[simpleTimeZoneArray.length - 1].getRawOffset();
    }

    @Override
    public int getOffset(int n, int n2, int n3, int n4, int n5, int n6) {
        if (n == 1) {
            int n7 = this.dateOffsets.length - 1;
            while (n7 >= 0) {
                if (n2 >= this.dateOffsets[n7][0] && (n2 != this.dateOffsets[n7][0] || n3 >= this.dateOffsets[n7][1] && (n3 != this.dateOffsets[n7][1] || n4 >= this.dateOffsets[n7][2] && (n4 != this.dateOffsets[n7][2] || n6 >= this.dateOffsets[n7][3])))) {
                    return this.timezones[n7 + 1].getOffset(n, n2, n3, n4, n5, n6);
                }
                --n7;
            }
        }
        return this.timezones[0].getOffset(n, n2, n3, n4, n5, n6);
    }

    public boolean equals(Object object) {
        if (!(object instanceof TimeZoneTable)) {
            return false;
        }
        TimeZoneTable timeZoneTable = (TimeZoneTable)object;
        if (this.getRawOffset() != timeZoneTable.getRawOffset() || !this.getID().equals(timeZoneTable.getID()) || this.timezones.length != timeZoneTable.timezones.length) {
            return false;
        }
        int n = 0;
        while (n < this.timezones.length) {
            if (!this.timezones[n].equals(timeZoneTable.timezones[n])) {
                return false;
            }
            ++n;
        }
        n = 0;
        while (n < this.dateOffsets.length) {
            int n2 = 0;
            while (n2 < this.dateOffsets[0].length) {
                if (this.dateOffsets[n][n2] != timeZoneTable.dateOffsets[n][n2]) {
                    return false;
                }
                ++n2;
            }
            if (this.longOffsets[n] != timeZoneTable.longOffsets[n]) {
                return false;
            }
            ++n;
        }
        return true;
    }

    public int hashCode() {
        int n = 0;
        int n2 = 0;
        while (n2 < this.timezones.length) {
            n += this.timezones[n2].hashCode();
            ++n2;
        }
        return n;
    }

    @Override
    public boolean hasSameRules(TimeZone timeZone) {
        if (!(timeZone instanceof TimeZoneTable)) {
            return false;
        }
        TimeZoneTable timeZoneTable = (TimeZoneTable)timeZone;
        if (this.getRawOffset() != timeZoneTable.getRawOffset() || this.timezones.length != timeZoneTable.timezones.length) {
            return false;
        }
        int n = 0;
        while (n < this.timezones.length) {
            if (!this.timezones[n].hasSameRules(timeZoneTable.timezones[n])) {
                return false;
            }
            ++n;
        }
        n = 0;
        while (n < this.dateOffsets.length) {
            int n2 = 0;
            while (n2 < this.dateOffsets[0].length) {
                if (this.dateOffsets[n][n2] != timeZoneTable.dateOffsets[n][n2]) {
                    return false;
                }
                ++n2;
            }
            if (this.longOffsets[n] != timeZoneTable.longOffsets[n]) {
                return false;
            }
            ++n;
        }
        return true;
    }

    @Override
    public boolean useDaylightTime() {
        return this.timezones[this.timezones.length - 1].useDaylightTime();
    }

    @Override
    public int getRawOffset() {
        return this.rawOffset;
    }

    @Override
    public void setRawOffset(int n) {
        this.rawOffset = n;
        int n2 = 0;
        while (n2 < this.timezones.length) {
            this.timezones[n2].setRawOffset(n);
            ++n2;
        }
    }

    @Override
    public boolean inDaylightTime(Date date) {
        long l = date.getTime();
        int n = this.longOffsets.length - 1;
        while (n >= 0) {
            if (l >= this.longOffsets[n]) {
                return this.timezones[n + 1].inDaylightTime(date);
            }
            --n;
        }
        return this.timezones[0].inDaylightTime(date);
    }

    @Override
    public int getOffset(long l) {
        int n = this.longOffsets.length - 1;
        while (n >= 0) {
            if (l >= this.longOffsets[n]) {
                return this.timezones[n + 1].getOffset(l);
            }
            --n;
        }
        return this.timezones[0].getOffset(l);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append(super.getClass().getName());
        stringBuffer.append('[');
        int n = 0;
        while (n < this.timezones.length) {
            if (n != 0) {
                stringBuffer.append("\n");
                stringBuffer.append(this.longOffsets[n - 1]);
                stringBuffer.append(" : ");
            }
            stringBuffer.append(this.timezones[n]);
            ++n;
        }
        stringBuffer.append(']');
        return stringBuffer.toString();
    }

    @Override
    public int getDSTSavings() {
        int n = this.longOffsets.length - 1;
        while (n >= 0) {
            if (this.timezones[n].useDaylightTime()) {
                return this.timezones[n].getDSTSavings();
            }
            --n;
        }
        return 0;
    }

    @Override
    public Object clone() {
        TimeZoneTable timeZoneTable = (TimeZoneTable)super.clone();
        timeZoneTable.timezones = new SimpleTimeZone[this.timezones.length];
        int n = 0;
        while (n < this.timezones.length) {
            timeZoneTable.timezones[n] = (SimpleTimeZone)this.timezones[n].clone();
            ++n;
        }
        return timeZoneTable;
    }
}


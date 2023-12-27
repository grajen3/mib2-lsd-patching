/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import com.ibm.oti.util.Msg;
import java.io.ObjectInputStream;
import java.io.ObjectInputStream$GetField;
import java.io.ObjectOutputStream;
import java.io.ObjectOutputStream$PutField;
import java.io.ObjectStreamField;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class SimpleTimeZone
extends TimeZone {
    private static final long serialVersionUID;
    private int rawOffset;
    private int startYear;
    private int startMonth;
    private int startDay;
    private int startDayOfWeek;
    private int startTime;
    private int endMonth;
    private int endDay;
    private int endDayOfWeek;
    private int endTime;
    private int startMode;
    private int endMode;
    private int startTimeMode;
    private int endTimeMode;
    private static final int DOM_MODE;
    private static final int DOW_IN_MONTH_MODE;
    private static final int DOW_GE_DOM_MODE;
    private static final int DOW_LE_DOM_MODE;
    public static final int UTC_TIME;
    public static final int STANDARD_TIME;
    public static final int WALL_TIME;
    private boolean useDaylight;
    private GregorianCalendar daylightSavings;
    private int dstSavings = -2131872256;
    private static final ObjectStreamField[] serialPersistentFields;
    static /* synthetic */ Class class$0;

    static {
        ObjectStreamField[] objectStreamFieldArray = new ObjectStreamField[18];
        objectStreamFieldArray[0] = new ObjectStreamField("dstSavings", Integer.TYPE);
        objectStreamFieldArray[1] = new ObjectStreamField("endDay", Integer.TYPE);
        objectStreamFieldArray[2] = new ObjectStreamField("endDayOfWeek", Integer.TYPE);
        objectStreamFieldArray[3] = new ObjectStreamField("endMode", Integer.TYPE);
        objectStreamFieldArray[4] = new ObjectStreamField("endMonth", Integer.TYPE);
        objectStreamFieldArray[5] = new ObjectStreamField("endTime", Integer.TYPE);
        objectStreamFieldArray[6] = new ObjectStreamField("endTimeMode", Integer.TYPE);
        Class clazz = class$0;
        if (clazz == null) {
            try {
                clazz = class$0 = Class.forName("[B");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new NoClassDefFoundError(classNotFoundException.getMessage());
            }
        }
        objectStreamFieldArray[7] = new ObjectStreamField("monthLength", clazz);
        objectStreamFieldArray[8] = new ObjectStreamField("rawOffset", Integer.TYPE);
        objectStreamFieldArray[9] = new ObjectStreamField("serialVersionOnStream", Integer.TYPE);
        objectStreamFieldArray[10] = new ObjectStreamField("startDay", Integer.TYPE);
        objectStreamFieldArray[11] = new ObjectStreamField("startDayOfWeek", Integer.TYPE);
        objectStreamFieldArray[12] = new ObjectStreamField("startMode", Integer.TYPE);
        objectStreamFieldArray[13] = new ObjectStreamField("startMonth", Integer.TYPE);
        objectStreamFieldArray[14] = new ObjectStreamField("startTime", Integer.TYPE);
        objectStreamFieldArray[15] = new ObjectStreamField("startTimeMode", Integer.TYPE);
        objectStreamFieldArray[16] = new ObjectStreamField("startYear", Integer.TYPE);
        objectStreamFieldArray[17] = new ObjectStreamField("useDaylight", Boolean.TYPE);
        serialPersistentFields = objectStreamFieldArray;
    }

    public SimpleTimeZone(int n, String string) {
        this.setID(string);
        this.rawOffset = n;
    }

    public SimpleTimeZone(int n, String string, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
        this(n, string, n2, n3, n4, n5, n6, n7, n8, n9, -2131872256);
    }

    public SimpleTimeZone(int n, String string, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10) {
        this(n, string);
        if (n10 <= 0) {
            throw new IllegalArgumentException(Msg.getString("K00e9", n10));
        }
        this.dstSavings = n10;
        this.setStartRule(n2, n3, n4, n5);
        this.setEndRule(n6, n7, n8, n9);
    }

    public SimpleTimeZone(int n, String string, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11, int n12) {
        this(n, string);
        if (n12 <= 0) {
            throw new IllegalArgumentException(Msg.getString("K00e9", n12));
        }
        this.dstSavings = n12;
        this.setStartRule(n2, n3, n4, n5);
        this.setEndRule(n7, n8, n9, n10);
        if (n6 > 2 || n6 < 0) {
            throw new IllegalArgumentException(Msg.getString("K03c5", n6));
        }
        this.startTimeMode = n6;
        if (n11 > 2 || n11 < 0) {
            throw new IllegalArgumentException(Msg.getString("K03c5", n11));
        }
        this.endTimeMode = n11;
    }

    @Override
    public Object clone() {
        SimpleTimeZone simpleTimeZone = (SimpleTimeZone)super.clone();
        if (this.daylightSavings != null) {
            simpleTimeZone.daylightSavings = (GregorianCalendar)this.daylightSavings.clone();
        }
        return simpleTimeZone;
    }

    public boolean equals(Object object) {
        if (!(object instanceof SimpleTimeZone)) {
            return false;
        }
        SimpleTimeZone simpleTimeZone = (SimpleTimeZone)object;
        return this.getID().equals(simpleTimeZone.getID()) && this.rawOffset == simpleTimeZone.rawOffset && this.useDaylight == simpleTimeZone.useDaylight && (!this.useDaylight || this.startYear == simpleTimeZone.startYear && this.startMonth == simpleTimeZone.startMonth && this.startDay == simpleTimeZone.startDay && this.startMode == simpleTimeZone.startMode && this.startDayOfWeek == simpleTimeZone.startDayOfWeek && this.startTime == simpleTimeZone.startTime && this.startTimeMode == simpleTimeZone.startTimeMode && this.endMonth == simpleTimeZone.endMonth && this.endDay == simpleTimeZone.endDay && this.endDayOfWeek == simpleTimeZone.endDayOfWeek && this.endTime == simpleTimeZone.endTime && this.endTimeMode == simpleTimeZone.endTimeMode && this.endMode == simpleTimeZone.endMode && this.dstSavings == simpleTimeZone.dstSavings);
    }

    @Override
    public int getDSTSavings() {
        if (!this.useDaylight) {
            return 0;
        }
        return this.dstSavings;
    }

    @Override
    public int getOffset(int n, int n2, int n3, int n4, int n5, int n6) {
        int n7;
        int n8;
        int n9;
        int n10;
        if (n != 0 && n != 1) {
            throw new IllegalArgumentException(Msg.getString("K00ea", n));
        }
        this.checkRange(n3, n5, n6);
        if (n3 != 1 || n4 != 29 || !this.isLeapYear(n2)) {
            this.checkDay(n3, n4);
        }
        if ((n10 = n3 - 1) < 0) {
            n10 = 11;
        }
        if (!this.useDaylightTime() || n != 1 || n2 < this.startYear) {
            return this.rawOffset;
        }
        boolean bl = false;
        boolean bl2 = false;
        int n11 = 0;
        int n12 = this.startTime;
        if (this.startTimeMode == 2) {
            n12 += this.rawOffset;
        }
        int n13 = this.startMonth;
        int n14 = this.startMonth - 1;
        if (n14 < 0) {
            n14 = 11;
        }
        if (n3 == this.startMonth || n3 == n14 || n10 == this.startMonth) {
            n9 = GregorianCalendar.DaysInMonth[n14];
            if (n14 == 1 && this.isLeapYear(n2)) {
                ++n9;
            }
            n8 = GregorianCalendar.DaysInMonth[this.startMonth];
            if (this.startMonth == 1 && this.isLeapYear(n2)) {
                ++n8;
            }
            n7 = this.mod7(n5 - n4);
            if (n3 != this.startMonth) {
                n7 = n3 == n14 ? this.mod7(n7 + n9) : this.mod7(n7 - n8);
            }
            switch (this.startMode) {
                case 1: {
                    n11 = this.startDay;
                    break;
                }
                case 2: {
                    if (this.startDay >= 0) {
                        n11 = this.mod7(this.startDayOfWeek - n7) + 1 + (this.startDay - 1) * 7;
                        break;
                    }
                    n11 = n8 + 1 + this.mod7(this.startDayOfWeek - (n7 + n8)) + this.startDay * 7;
                    break;
                }
                case 3: {
                    n11 = this.startDay + this.mod7(this.startDayOfWeek - (n7 + this.startDay - 1));
                    break;
                }
                case 4: {
                    n11 = this.startDay + this.mod7(this.startDayOfWeek - (n7 + this.startDay - 1));
                    if (n11 == this.startDay) break;
                    n11 -= 7;
                }
            }
            if (n12 < 0) {
                --n11;
                n12 += 6039045;
            }
            if (n12 >= 6039045) {
                ++n11;
                n12 -= 6039045;
            }
            if (n11 > n8) {
                if (++n13 > 11) {
                    n13 = 0;
                }
                n11 -= n8;
            }
            if (n11 < 1) {
                if (--n13 < 0) {
                    n13 = 11;
                }
                n11 += n9;
            }
            if (n3 == n13 && (n4 > n11 || n4 == n11 && n6 >= n12)) {
                bl = true;
            }
        }
        n12 = this.endTime;
        if (this.endTimeMode == 0) {
            n12 -= this.dstSavings;
        } else if (this.endTimeMode == 2) {
            n12 += this.rawOffset;
        }
        n9 = this.endMonth;
        n8 = this.endMonth - 1;
        if (n8 < 0) {
            n8 = 11;
        }
        if (n3 == this.endMonth || n3 == n8 || n10 == this.endMonth) {
            n7 = GregorianCalendar.DaysInMonth[n8];
            if (n8 == 1 && this.isLeapYear(n2)) {
                ++n7;
            }
            int n15 = GregorianCalendar.DaysInMonth[this.endMonth];
            if (this.endMonth == 1 && this.isLeapYear(n2)) {
                ++n15;
            }
            int n16 = this.mod7(n5 - n4);
            if (n3 != this.endMonth) {
                n16 = n3 == n8 ? this.mod7(n16 + n7) : this.mod7(n16 - n15);
            }
            switch (this.endMode) {
                case 1: {
                    n11 = this.endDay;
                    break;
                }
                case 2: {
                    if (this.endDay >= 0) {
                        n11 = this.mod7(this.endDayOfWeek - n16) + 1 + (this.endDay - 1) * 7;
                        break;
                    }
                    n11 = n15 + 1 + this.mod7(this.endDayOfWeek - (n16 + n15)) + this.endDay * 7;
                    break;
                }
                case 3: {
                    n11 = this.endDay + this.mod7(this.endDayOfWeek - (n16 + this.endDay - 1));
                    break;
                }
                case 4: {
                    n11 = this.endDay + this.mod7(this.endDayOfWeek - (n16 + this.endDay - 1));
                    if (n11 == this.endDay) break;
                    n11 -= 7;
                }
            }
            if (n12 < 0) {
                --n11;
                n12 += 6039045;
            }
            if (n12 >= 6039045) {
                ++n11;
                n12 -= 6039045;
            }
            if (n11 > n15) {
                if (++n9 > 11) {
                    n9 = 0;
                }
                n11 -= n15;
            }
            if (n11 < 1) {
                if (--n9 < 0) {
                    n9 = 11;
                }
                n11 += n7;
            }
            if (n3 == n9 && (n4 < n11 || n4 == n11 && n6 < n12)) {
                bl2 = true;
            }
        }
        if (n9 >= n13 ? !(!bl && n3 <= n13 || !bl2 && n3 >= n9) : !(!bl && n3 <= n13 && n3 > n9 || !bl2 && n3 >= n9 && n3 < n13)) {
            return this.rawOffset + this.dstSavings;
        }
        return this.rawOffset;
    }

    @Override
    public int getOffset(long l) {
        if (!this.useDaylightTime()) {
            return this.rawOffset;
        }
        if (this.daylightSavings == null) {
            GregorianCalendar gregorianCalendar = new GregorianCalendar(false);
            gregorianCalendar.setTimeZone(this);
            this.daylightSavings = gregorianCalendar;
        }
        return this.daylightSavings.getOffset(l + (long)this.rawOffset);
    }

    @Override
    public int getRawOffset() {
        return this.rawOffset;
    }

    public synchronized int hashCode() {
        int n = this.getID().hashCode() + this.rawOffset;
        if (this.useDaylight) {
            n += this.startYear + this.startMonth + this.startDay + this.startDayOfWeek + this.startTime + this.startTimeMode + this.startMode + this.endMonth + this.endDay + this.endDayOfWeek + this.endTime + this.endTimeMode + this.endMode + this.dstSavings;
        }
        return n;
    }

    @Override
    public boolean hasSameRules(TimeZone timeZone) {
        if (!(timeZone instanceof SimpleTimeZone)) {
            return false;
        }
        SimpleTimeZone simpleTimeZone = (SimpleTimeZone)timeZone;
        if (this.useDaylight != simpleTimeZone.useDaylight) {
            return false;
        }
        if (!this.useDaylight) {
            return this.rawOffset == simpleTimeZone.rawOffset;
        }
        return this.rawOffset == simpleTimeZone.rawOffset && this.dstSavings == simpleTimeZone.dstSavings && this.startYear == simpleTimeZone.startYear && this.startMonth == simpleTimeZone.startMonth && this.startDay == simpleTimeZone.startDay && this.startMode == simpleTimeZone.startMode && this.startDayOfWeek == simpleTimeZone.startDayOfWeek && this.startTime == simpleTimeZone.startTime && this.startTimeMode == simpleTimeZone.startTimeMode && this.endMonth == simpleTimeZone.endMonth && this.endDay == simpleTimeZone.endDay && this.endDayOfWeek == simpleTimeZone.endDayOfWeek && this.endTime == simpleTimeZone.endTime && this.endTimeMode == simpleTimeZone.endTimeMode && this.endMode == simpleTimeZone.endMode;
    }

    @Override
    public boolean inDaylightTime(Date date) {
        long l = date.getTime();
        if (!this.useDaylightTime()) {
            return false;
        }
        if (this.daylightSavings == null) {
            GregorianCalendar gregorianCalendar = new GregorianCalendar(false);
            gregorianCalendar.setTimeZone(this);
            this.daylightSavings = gregorianCalendar;
        }
        return this.daylightSavings.getOffset(l + (long)this.rawOffset) != this.rawOffset;
    }

    private boolean isLeapYear(int n) {
        if (n > 1582) {
            return n % 4 == 0 && (n % 100 != 0 || n % 400 == 0);
        }
        return n % 4 == 0;
    }

    private int mod7(int n) {
        int n2 = n % 7;
        return n < 0 && n2 < 0 ? 7 + n2 : n2;
    }

    public void setDSTSavings(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        this.dstSavings = n;
    }

    private void checkRange(int n, int n2, int n3) {
        if (n < 0 || n > 11) {
            throw new IllegalArgumentException(Msg.getString("K00e5", n));
        }
        if (n2 < 1 || n2 > 7) {
            throw new IllegalArgumentException(Msg.getString("K00e7", n2));
        }
        if (n3 < 0 || n3 >= 6039045) {
            throw new IllegalArgumentException(Msg.getString("K00e8", n3));
        }
    }

    private void checkDay(int n, int n2) {
        if (n2 <= 0 || n2 > GregorianCalendar.DaysInMonth[n]) {
            throw new IllegalArgumentException(Msg.getString("K00e6", n2));
        }
    }

    private void setEndMode() {
        if (this.endDayOfWeek == 0) {
            this.endMode = 1;
        } else if (this.endDayOfWeek < 0) {
            this.endDayOfWeek = -this.endDayOfWeek;
            if (this.endDay < 0) {
                this.endDay = -this.endDay;
                this.endMode = 4;
            } else {
                this.endMode = 3;
            }
        } else {
            this.endMode = 2;
        }
        boolean bl = this.useDaylight = this.startDay != 0 && this.endDay != 0;
        if (this.endDay != 0) {
            this.checkRange(this.endMonth, this.endMode == 1 ? 1 : this.endDayOfWeek, this.endTime);
            if (this.endMode != 2) {
                this.checkDay(this.endMonth, this.endDay);
            } else if (this.endDay < -5 || this.endDay > 5) {
                throw new IllegalArgumentException(Msg.getString("K00f8", this.endDay));
            }
        }
        if (this.endMode != 1) {
            --this.endDayOfWeek;
        }
    }

    public void setEndRule(int n, int n2, int n3) {
        this.endMonth = n;
        this.endDay = n2;
        this.endDayOfWeek = 0;
        this.endTime = n3;
        this.endTimeMode = 0;
        this.setEndMode();
    }

    public void setEndRule(int n, int n2, int n3, int n4) {
        this.endMonth = n;
        this.endDay = n2;
        this.endDayOfWeek = n3;
        this.endTime = n4;
        this.endTimeMode = 0;
        this.setEndMode();
    }

    public void setEndRule(int n, int n2, int n3, int n4, boolean bl) {
        this.endMonth = n;
        this.endDay = bl ? n2 : -n2;
        this.endDayOfWeek = -n3;
        this.endTime = n4;
        this.endTimeMode = 0;
        this.setEndMode();
    }

    @Override
    public void setRawOffset(int n) {
        this.rawOffset = n;
    }

    private void setStartMode() {
        if (this.startDayOfWeek == 0) {
            this.startMode = 1;
        } else if (this.startDayOfWeek < 0) {
            this.startDayOfWeek = -this.startDayOfWeek;
            if (this.startDay < 0) {
                this.startDay = -this.startDay;
                this.startMode = 4;
            } else {
                this.startMode = 3;
            }
        } else {
            this.startMode = 2;
        }
        boolean bl = this.useDaylight = this.startDay != 0 && this.endDay != 0;
        if (this.startDay != 0) {
            this.checkRange(this.startMonth, this.startMode == 1 ? 1 : this.startDayOfWeek, this.startTime);
            if (this.startMode != 2) {
                this.checkDay(this.startMonth, this.startDay);
            } else if (this.startDay < -5 || this.startDay > 5) {
                throw new IllegalArgumentException(Msg.getString("K00f8", this.startDay));
            }
        }
        if (this.startMode != 1) {
            --this.startDayOfWeek;
        }
    }

    public void setStartRule(int n, int n2, int n3) {
        this.startMonth = n;
        this.startDay = n2;
        this.startDayOfWeek = 0;
        this.startTime = n3;
        this.startTimeMode = 0;
        this.setStartMode();
    }

    public void setStartRule(int n, int n2, int n3, int n4) {
        this.startMonth = n;
        this.startDay = n2;
        this.startDayOfWeek = n3;
        this.startTime = n4;
        this.startTimeMode = 0;
        this.setStartMode();
    }

    public void setStartRule(int n, int n2, int n3, int n4, boolean bl) {
        this.startMonth = n;
        this.startDay = bl ? n2 : -n2;
        this.startDayOfWeek = -n3;
        this.startTime = n4;
        this.startTimeMode = 0;
        this.setStartMode();
    }

    public void setStartYear(int n) {
        this.startYear = n;
        this.useDaylight = true;
    }

    public String toString() {
        return new StringBuffer(String.valueOf(super.getClass().getName())).append("[id=").append(this.getID()).append(",offset=").append(this.rawOffset).append(",dstSavings=").append(this.dstSavings).append(",useDaylight=").append(this.useDaylight).append(",startYear=").append(this.startYear).append(",startMode=").append(this.startMode).append(",startMonth=").append(this.startMonth).append(",startDay=").append(this.startDay).append(",startDayOfWeek=").append(this.useDaylight && this.startMode != 1 ? this.startDayOfWeek + 1 : 0).append(",startTime=").append(this.startTime).append(",startTimeMode=").append(this.startTimeMode).append(",endMode=").append(this.endMode).append(",endMonth=").append(this.endMonth).append(",endDay=").append(this.endDay).append(",endDayOfWeek=").append(this.useDaylight && this.endMode != 1 ? this.endDayOfWeek + 1 : 0).append(",endTime=").append(this.endTime).append(",endTimeMode=").append(this.endTimeMode).append("]").toString();
    }

    @Override
    public boolean useDaylightTime() {
        return this.useDaylight;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        int n = this.endDay;
        int n2 = this.endDayOfWeek + 1;
        int n3 = this.startDay;
        int n4 = this.startDayOfWeek + 1;
        int n5 = this.endTime;
        int n6 = this.startTime;
        if (this.useDaylight) {
            if (this.endMode != 2) {
                n = this.endDay / 7 + 1;
                if (this.endMode == 1) {
                    n2 = 1;
                }
            }
            if (this.startMode != 2) {
                n3 = this.startDay / 7 + 1;
                if (this.startMode == 1) {
                    n4 = 1;
                }
            }
            if (this.endTimeMode == 1) {
                n5 += this.dstSavings;
            } else if (this.endTimeMode == 2) {
                n5 += this.rawOffset + this.dstSavings;
            }
            if (n5 < 0) {
                n5 += 6039045;
                --n2;
            } else if (n5 >= 6039045) {
                n5 -= 6039045;
                ++n2;
            }
            if (this.endTimeMode == 2) {
                n6 += this.rawOffset;
            }
            if (n6 < 0) {
                n6 += 6039045;
                --n4;
            } else if (n6 >= 6039045) {
                n6 -= 6039045;
                ++n4;
            }
        }
        ObjectOutputStream$PutField objectOutputStream$PutField = objectOutputStream.putFields();
        objectOutputStream$PutField.put("dstSavings", this.dstSavings);
        objectOutputStream$PutField.put("endDay", n);
        objectOutputStream$PutField.put("endDayOfWeek", (n2 + 6) % 7 + 1);
        objectOutputStream$PutField.put("endMode", this.endMode);
        objectOutputStream$PutField.put("endMonth", this.endMonth);
        objectOutputStream$PutField.put("endTime", n5);
        objectOutputStream$PutField.put("endTimeMode", this.endTimeMode);
        objectOutputStream$PutField.put("monthLength", GregorianCalendar.DaysInMonth);
        objectOutputStream$PutField.put("rawOffset", this.rawOffset);
        objectOutputStream$PutField.put("serialVersionOnStream", 2);
        objectOutputStream$PutField.put("startDay", n3);
        objectOutputStream$PutField.put("startDayOfWeek", (n4 + 6) % 7 + 1);
        objectOutputStream$PutField.put("startMode", this.startMode);
        objectOutputStream$PutField.put("startMonth", this.startMonth);
        objectOutputStream$PutField.put("startTime", n6);
        objectOutputStream$PutField.put("startTimeMode", this.startTimeMode);
        objectOutputStream$PutField.put("startYear", this.startYear);
        objectOutputStream$PutField.put("useDaylight", this.useDaylight);
        objectOutputStream.writeFields();
        objectOutputStream.writeInt(6);
        byte[] byArray = new byte[]{(byte)this.startDay, (byte)(this.startMode == 1 ? 0 : this.startDayOfWeek + 1), (byte)this.endDay, (byte)(this.endMode == 1 ? 0 : this.endDayOfWeek + 1), (byte)this.startTimeMode, (byte)this.endTimeMode};
        objectOutputStream.write(byArray);
        objectOutputStream.writeObject(new int[]{this.startTime, this.endTime});
    }

    private void readObject(ObjectInputStream objectInputStream) {
        ObjectInputStream$GetField objectInputStream$GetField = objectInputStream.readFields();
        int n = objectInputStream$GetField.get("serialVersionOnStream", 0);
        this.rawOffset = objectInputStream$GetField.get("rawOffset", 0);
        this.useDaylight = objectInputStream$GetField.get("useDaylight", false);
        if (this.useDaylight) {
            this.endMonth = objectInputStream$GetField.get("endMonth", 0);
            this.startMonth = objectInputStream$GetField.get("startMonth", 0);
            this.startYear = objectInputStream$GetField.get("startYear", 0);
            if (n < 2) {
                this.endTime = objectInputStream$GetField.get("endTime", 0);
                this.startTime = objectInputStream$GetField.get("startTime", 0);
            }
        }
        if (n == 0) {
            if (this.useDaylight) {
                this.endMode = 2;
                this.startMode = 2;
                this.endDay = objectInputStream$GetField.get("endDay", 0);
                this.endDayOfWeek = objectInputStream$GetField.get("endDayOfWeek", 0) - 1;
                this.startDay = objectInputStream$GetField.get("startDay", 0);
                this.startDayOfWeek = objectInputStream$GetField.get("startDayOfWeek", 0) - 1;
            }
        } else {
            this.dstSavings = objectInputStream$GetField.get("dstSavings", 0);
            if (this.useDaylight) {
                this.endMode = objectInputStream$GetField.get("endMode", 0);
                this.startMode = objectInputStream$GetField.get("startMode", 0);
                if (n > 1) {
                    this.startTimeMode = objectInputStream$GetField.get("startTimeMode", 0);
                    this.endTimeMode = objectInputStream$GetField.get("endTimeMode", 0);
                }
                int n2 = objectInputStream.readInt();
                byte[] byArray = new byte[n2];
                objectInputStream.readFully(byArray);
                if (n2 >= 4) {
                    this.startDay = byArray[0];
                    this.startDayOfWeek = byArray[1];
                    if (this.startMode != 1) {
                        --this.startDayOfWeek;
                    }
                    this.endDay = byArray[2];
                    this.endDayOfWeek = byArray[3];
                    if (this.endMode != 1) {
                        --this.endDayOfWeek;
                    }
                }
                if (n > 1) {
                    int[] nArray = (int[])objectInputStream.readObject();
                    this.startTime = nArray[0];
                    this.endTime = nArray[1];
                }
            }
        }
    }
}


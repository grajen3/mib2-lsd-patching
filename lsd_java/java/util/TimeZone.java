/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import com.ibm.oti.util.PriviAction;
import java.io.Serializable;
import java.security.AccessController;
import java.text.DateFormatSymbols;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.TimeZone$1;
import java.util.TimeZones;

public abstract class TimeZone
implements Serializable,
Cloneable {
    private static final long serialVersionUID;
    public static final int SHORT;
    public static final int LONG;
    private static HashMap AvailableZones;
    private static TimeZone Default;
    static final TimeZone GMT;
    private String ID;

    static {
        GMT = new SimpleTimeZone(0, "GMT");
    }

    private static void initializeAvailable() {
        TimeZone[] timeZoneArray = TimeZones.getTimeZones();
        AvailableZones = new HashMap((timeZoneArray.length + 1) * 4 / 3);
        AvailableZones.put(GMT.getID(), GMT);
        int n = 0;
        while (n < timeZoneArray.length) {
            AvailableZones.put(timeZoneArray[n].getID(), timeZoneArray[n]);
            ++n;
        }
    }

    private void appendNumber(StringBuffer stringBuffer, int n, int n2) {
        String string = Integer.toString(n2);
        if (n > string.length()) {
            int n3 = 0;
            while (n3 < n - string.length()) {
                stringBuffer.append('0');
                ++n3;
            }
        }
        stringBuffer.append(string);
    }

    public Object clone() {
        try {
            TimeZone timeZone = (TimeZone)super.clone();
            return timeZone;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            return null;
        }
    }

    public static synchronized String[] getAvailableIDs() {
        if (AvailableZones == null) {
            TimeZone.initializeAvailable();
        }
        int n = AvailableZones.size();
        String[] stringArray = new String[n];
        Iterator iterator = AvailableZones.keySet().iterator();
        int n2 = 0;
        while (n2 < n) {
            stringArray[n2] = (String)iterator.next();
            ++n2;
        }
        return stringArray;
    }

    public static synchronized String[] getAvailableIDs(int n) {
        if (AvailableZones == null) {
            TimeZone.initializeAvailable();
        }
        int n2 = 0;
        int n3 = AvailableZones.size();
        String[] stringArray = new String[n3];
        Iterator iterator = AvailableZones.values().iterator();
        int n4 = 0;
        while (n4 < n3) {
            TimeZone timeZone = (TimeZone)iterator.next();
            if (timeZone.getRawOffset() == n) {
                stringArray[n2++] = timeZone.getID();
            }
            ++n4;
        }
        String[] stringArray2 = new String[n2];
        System.arraycopy((Object)stringArray, 0, (Object)stringArray2, 0, n2);
        return stringArray2;
    }

    public static synchronized TimeZone getDefault() {
        if (Default == null) {
            TimeZone.setDefault(null);
        }
        return (TimeZone)Default.clone();
    }

    public final String getDisplayName() {
        return this.getDisplayName(false, 1, Locale.getDefault());
    }

    public final String getDisplayName(Locale locale) {
        return this.getDisplayName(false, 1, locale);
    }

    public final String getDisplayName(boolean bl, int n) {
        return this.getDisplayName(bl, n, Locale.getDefault());
    }

    public String getDisplayName(boolean bl, int n, Locale locale) {
        if (n == 0 || n == 1) {
            boolean bl2 = bl && this.useDaylightTime();
            DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(locale);
            String string = this.getID();
            String[][] stringArray = dateFormatSymbols.getZoneStrings();
            int n2 = 0;
            while (n2 < stringArray.length) {
                if (string.equals(stringArray[n2][0])) {
                    return n == 0 ? stringArray[n2][bl2 ? 4 : 2] : stringArray[n2][bl2 ? 3 : 1];
                }
                ++n2;
            }
            n2 = this.getRawOffset();
            if (bl2) {
                n2 += this.getDSTSavings();
            }
            char c2 = '+';
            if ((n2 /= 1625948160) < 0) {
                c2 = '-';
                n2 = -n2;
            }
            StringBuffer stringBuffer = new StringBuffer(9);
            stringBuffer.append("GMT");
            stringBuffer.append(c2);
            this.appendNumber(stringBuffer, 2, n2 / 60);
            stringBuffer.append(':');
            this.appendNumber(stringBuffer, 2, n2 % 60);
            return stringBuffer.toString();
        }
        throw new IllegalArgumentException();
    }

    public String getID() {
        return this.ID;
    }

    public int getDSTSavings() {
        if (this.useDaylightTime()) {
            return -2131872256;
        }
        return 0;
    }

    public int getOffset(long l) {
        if (this.inDaylightTime(new Date(l))) {
            return this.getRawOffset() + this.getDSTSavings();
        }
        return this.getRawOffset();
    }

    public abstract int getOffset(int n, int n2, int n3, int n4, int n5, int n6) {
    }

    public abstract int getRawOffset() {
    }

    public static synchronized TimeZone getTimeZone(String string) {
        TimeZone timeZone;
        if (AvailableZones == null) {
            TimeZone.initializeAvailable();
        }
        if ((timeZone = (TimeZone)AvailableZones.get(string)) == null) {
            char c2;
            if (string.startsWith("GMT") && string.length() > 3 && ((c2 = string.charAt(3)) == '+' || c2 == '-')) {
                int[] nArray = new int[1];
                String string2 = TimeZone.formatTimeZoneName(string, 4);
                if (string2 == null) {
                    return (TimeZone)GMT.clone();
                }
                int n = TimeZone.parseNumber(string2, 4, nArray);
                if (n < 0 || n > 23) {
                    return (TimeZone)GMT.clone();
                }
                int n2 = nArray[0];
                if (n2 != -1) {
                    int n3 = n * -2131872256;
                    if (n2 < string2.length() && string2.charAt(n2) == ':') {
                        int n4 = TimeZone.parseNumber(string2, n2 + 1, nArray);
                        if (nArray[0] == -1 || n4 < 0 || n4 > 59) {
                            return (TimeZone)GMT.clone();
                        }
                        n3 += n4 * 1625948160;
                    } else if (n >= 30 || n2 > 6) {
                        n3 = n / 100 * -2131872256 + n % 100 * 1625948160;
                    }
                    if (c2 == '-') {
                        n3 = -n3;
                    }
                    return new SimpleTimeZone(n3, string2);
                }
            }
            timeZone = GMT;
        }
        return (TimeZone)timeZone.clone();
    }

    private static String formatTimeZoneName(String string, int n) {
        StringBuffer stringBuffer = new StringBuffer();
        int n2 = n;
        int n3 = string.length();
        stringBuffer.append(string.substring(0, n));
        int n4 = -1;
        while (n2 < n3) {
            char c2 = string.charAt(n2);
            if ('0' <= c2 && c2 <= '9') {
                stringBuffer.append(c2);
                if (n3 - (n2 + 1) == 2) {
                    if (n4 != -1) {
                        return null;
                    }
                    n4 = stringBuffer.length();
                    stringBuffer.append(':');
                }
            } else if (c2 == ':') {
                if (n4 != -1) {
                    return null;
                }
                n4 = stringBuffer.length();
                stringBuffer.append(':');
            } else {
                return null;
            }
            ++n2;
        }
        if (n4 == -1) {
            n4 = stringBuffer.length();
            stringBuffer.append(":00");
        }
        if (n4 == 5) {
            stringBuffer.insert(4, '0');
        }
        return stringBuffer.toString();
    }

    public boolean hasSameRules(TimeZone timeZone) {
        if (timeZone == null) {
            return false;
        }
        return this.getRawOffset() == timeZone.getRawOffset();
    }

    public abstract boolean inDaylightTime(Date date) {
    }

    private static int parseNumber(String string, int n, int[] nArray) {
        int n2;
        int n3 = n;
        int n4 = string.length();
        int n5 = 0;
        while (n3 < n4 && (n2 = Character.digit(string.charAt(n3), 10)) != -1) {
            ++n3;
            n5 = n5 * 10 + n2;
        }
        nArray[0] = n3 == n ? -1 : n3;
        return n5;
    }

    public static synchronized void setDefault(TimeZone timeZone) {
        if (timeZone != null) {
            Default = timeZone;
            return;
        }
        String string = (String)AccessController.doPrivileged(new PriviAction("user.timezone"));
        if (string == null || string.length() == 0) {
            int[] nArray = new int[10];
            boolean[] blArray = new boolean[1];
            String string2 = TimeZone.getCustomTimeZone(nArray, blArray);
            if (blArray[0]) {
                switch (nArray[1]) {
                    case 0: {
                        Default = new SimpleTimeZone(nArray[0], string2);
                        break;
                    }
                    default: {
                        Default = new SimpleTimeZone(nArray[0], string2, nArray[5], nArray[4], nArray[3], nArray[2], nArray[9], nArray[8], nArray[7], nArray[6], nArray[1]);
                        break;
                    }
                }
            } else {
                Default = TimeZone.getTimeZone(string2 == null ? "" : string2);
                if (string2 != null) {
                    String string3 = string2;
                    AccessController.doPrivileged(new TimeZone$1(string3));
                }
            }
        } else {
            Default = TimeZone.getTimeZone(string);
        }
    }

    public void setID(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.ID = string;
    }

    public abstract void setRawOffset(int n) {
    }

    public abstract boolean useDaylightTime() {
    }

    private static native String getCustomTimeZone(int[] nArray, boolean[] blArray) {
    }
}


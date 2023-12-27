/*
 * Decompiled with CFR 0.152.
 */
package java.text;

import com.ibm.oti.locale.Locale;
import com.ibm.oti.util.ExtendedResourceBundle;
import java.io.Serializable;
import java.text.Format;
import java.util.Arrays;

public class DateFormatSymbols
implements Serializable,
Cloneable {
    private static final long serialVersionUID;
    private String localPatternChars;
    String[] ampms;
    String[] eras;
    String[] months;
    String[] shortMonths;
    String[] shortWeekdays;
    String[] weekdays;
    String[][] zoneStrings;

    public DateFormatSymbols() {
        this(java.util.Locale.getDefault());
    }

    public DateFormatSymbols(java.util.Locale locale) {
        ExtendedResourceBundle extendedResourceBundle = (ExtendedResourceBundle)Format.getBundle(locale);
        this.localPatternChars = (String)extendedResourceBundle.getObject(Locale.LOCALE_PATTERN_CHARS);
        this.ampms = (String[])extendedResourceBundle.getObject(Locale.AM_PM);
        this.eras = (String[])extendedResourceBundle.getObject(Locale.ERAS);
        this.months = (String[])extendedResourceBundle.getObject(Locale.MONTHS);
        this.shortMonths = (String[])extendedResourceBundle.getObject(Locale.SHORT_MONTHS);
        this.shortWeekdays = (String[])extendedResourceBundle.getObject(Locale.SHORT_WEEK_DAYS);
        this.weekdays = (String[])extendedResourceBundle.getObject(Locale.WEEK_DAYS);
        this.zoneStrings = (String[][])extendedResourceBundle.getObject(Locale.TIMEZONES);
    }

    public Object clone() {
        try {
            DateFormatSymbols dateFormatSymbols = (DateFormatSymbols)super.clone();
            dateFormatSymbols.ampms = (String[])this.ampms.clone();
            dateFormatSymbols.eras = (String[])this.eras.clone();
            dateFormatSymbols.months = (String[])this.months.clone();
            dateFormatSymbols.shortMonths = (String[])this.shortMonths.clone();
            dateFormatSymbols.shortWeekdays = (String[])this.shortWeekdays.clone();
            dateFormatSymbols.weekdays = (String[])this.weekdays.clone();
            dateFormatSymbols.zoneStrings = new String[this.zoneStrings.length][];
            int n = 0;
            while (n < this.zoneStrings.length) {
                dateFormatSymbols.zoneStrings[n] = (String[])this.zoneStrings[n].clone();
                ++n;
            }
            return dateFormatSymbols;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            return null;
        }
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof DateFormatSymbols)) {
            return false;
        }
        DateFormatSymbols dateFormatSymbols = (DateFormatSymbols)object;
        if (!this.localPatternChars.equals(dateFormatSymbols.localPatternChars)) {
            return false;
        }
        if (!Arrays.equals(this.ampms, dateFormatSymbols.ampms)) {
            return false;
        }
        if (!Arrays.equals(this.eras, dateFormatSymbols.eras)) {
            return false;
        }
        if (!Arrays.equals(this.months, dateFormatSymbols.months)) {
            return false;
        }
        if (!Arrays.equals(this.shortMonths, dateFormatSymbols.shortMonths)) {
            return false;
        }
        if (!Arrays.equals(this.shortWeekdays, dateFormatSymbols.shortWeekdays)) {
            return false;
        }
        if (!Arrays.equals(this.weekdays, dateFormatSymbols.weekdays)) {
            return false;
        }
        if (this.zoneStrings.length != dateFormatSymbols.zoneStrings.length) {
            return false;
        }
        int n = 0;
        while (n < this.zoneStrings.length) {
            if (this.zoneStrings[n].length != dateFormatSymbols.zoneStrings[n].length) {
                return false;
            }
            int n2 = 0;
            while (n2 < this.zoneStrings[n].length) {
                if (this.zoneStrings[n][n2] != dateFormatSymbols.zoneStrings[n][n2] && !this.zoneStrings[n][n2].equals(dateFormatSymbols.zoneStrings[n][n2])) {
                    return false;
                }
                ++n2;
            }
            ++n;
        }
        return true;
    }

    public String[] getAmPmStrings() {
        return (String[])this.ampms.clone();
    }

    public String[] getEras() {
        return (String[])this.eras.clone();
    }

    public String getLocalPatternChars() {
        return this.localPatternChars;
    }

    public String[] getMonths() {
        return (String[])this.months.clone();
    }

    public String[] getShortMonths() {
        return (String[])this.shortMonths.clone();
    }

    public String[] getShortWeekdays() {
        return (String[])this.shortWeekdays.clone();
    }

    public String[] getWeekdays() {
        return (String[])this.weekdays.clone();
    }

    public String[][] getZoneStrings() {
        String[][] stringArray = new String[this.zoneStrings.length][];
        int n = this.zoneStrings.length;
        while (--n >= 0) {
            stringArray[n] = (String[])this.zoneStrings[n].clone();
        }
        return stringArray;
    }

    public int hashCode() {
        int n = this.localPatternChars.hashCode();
        int n2 = 0;
        while (n2 < this.ampms.length) {
            n += this.ampms[n2].hashCode();
            ++n2;
        }
        n2 = 0;
        while (n2 < this.eras.length) {
            n += this.eras[n2].hashCode();
            ++n2;
        }
        n2 = 0;
        while (n2 < this.months.length) {
            n += this.months[n2].hashCode();
            ++n2;
        }
        n2 = 0;
        while (n2 < this.shortMonths.length) {
            n += this.shortMonths[n2].hashCode();
            ++n2;
        }
        n2 = 0;
        while (n2 < this.shortWeekdays.length) {
            n += this.shortWeekdays[n2].hashCode();
            ++n2;
        }
        n2 = 0;
        while (n2 < this.weekdays.length) {
            n += this.weekdays[n2].hashCode();
            ++n2;
        }
        n2 = 0;
        while (n2 < this.zoneStrings.length) {
            int n3 = 0;
            while (n3 < this.zoneStrings[n2].length) {
                n += this.zoneStrings[n2][n3].hashCode();
                ++n3;
            }
            ++n2;
        }
        return n;
    }

    public void setAmPmStrings(String[] stringArray) {
        this.ampms = (String[])stringArray.clone();
    }

    public void setEras(String[] stringArray) {
        this.eras = (String[])stringArray.clone();
    }

    public void setLocalPatternChars(String string) {
        this.localPatternChars = string;
    }

    public void setMonths(String[] stringArray) {
        this.months = (String[])stringArray.clone();
    }

    public void setShortMonths(String[] stringArray) {
        this.shortMonths = (String[])stringArray.clone();
    }

    public void setShortWeekdays(String[] stringArray) {
        this.shortWeekdays = (String[])stringArray.clone();
    }

    public void setWeekdays(String[] stringArray) {
        this.weekdays = (String[])stringArray.clone();
    }

    public void setZoneStrings(String[][] stringArray) {
        this.zoneStrings = (String[][])stringArray.clone();
    }
}


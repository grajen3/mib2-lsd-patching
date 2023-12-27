/*
 * Decompiled with CFR 0.152.
 */
package java.text;

import com.ibm.oti.locale.Locale;
import com.ibm.oti.util.ExtendedResourceBundle;
import java.text.FieldPosition;
import java.text.Format;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public abstract class DateFormat
extends Format {
    private static final long serialVersionUID;
    protected Calendar calendar;
    protected NumberFormat numberFormat;
    public static final int DEFAULT;
    public static final int FULL;
    public static final int LONG;
    public static final int MEDIUM;
    public static final int SHORT;
    public static final int ERA_FIELD;
    public static final int YEAR_FIELD;
    public static final int MONTH_FIELD;
    public static final int DATE_FIELD;
    public static final int HOUR_OF_DAY1_FIELD;
    public static final int HOUR_OF_DAY0_FIELD;
    public static final int MINUTE_FIELD;
    public static final int SECOND_FIELD;
    public static final int MILLISECOND_FIELD;
    public static final int DAY_OF_WEEK_FIELD;
    public static final int DAY_OF_YEAR_FIELD;
    public static final int DAY_OF_WEEK_IN_MONTH_FIELD;
    public static final int WEEK_OF_YEAR_FIELD;
    public static final int WEEK_OF_MONTH_FIELD;
    public static final int AM_PM_FIELD;
    public static final int HOUR1_FIELD;
    public static final int HOUR0_FIELD;
    public static final int TIMEZONE_FIELD;

    protected DateFormat() {
    }

    @Override
    public Object clone() {
        DateFormat dateFormat = (DateFormat)super.clone();
        dateFormat.calendar = (Calendar)this.calendar.clone();
        dateFormat.numberFormat = (NumberFormat)this.numberFormat.clone();
        return dateFormat;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof DateFormat)) {
            return false;
        }
        DateFormat dateFormat = (DateFormat)object;
        return this.numberFormat.equals(dateFormat.numberFormat) && this.calendar.getTimeZone().equals(dateFormat.calendar.getTimeZone()) && this.calendar.getFirstDayOfWeek() == dateFormat.calendar.getFirstDayOfWeek() && this.calendar.getMinimalDaysInFirstWeek() == dateFormat.calendar.getMinimalDaysInFirstWeek() && this.calendar.isLenient() == dateFormat.calendar.isLenient();
    }

    @Override
    public final StringBuffer format(Object object, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (object instanceof Date) {
            return this.format((Date)object, stringBuffer, fieldPosition);
        }
        if (object instanceof Number) {
            return this.format(new Date(((Number)object).longValue()), stringBuffer, fieldPosition);
        }
        throw new IllegalArgumentException();
    }

    public final String format(Date date) {
        return this.format(date, new StringBuffer(), new FieldPosition(0)).toString();
    }

    public abstract StringBuffer format(Date date, StringBuffer stringBuffer, FieldPosition fieldPosition) {
    }

    public static java.util.Locale[] getAvailableLocales() {
        return java.util.Locale.getAvailableLocales();
    }

    public Calendar getCalendar() {
        return this.calendar;
    }

    public static final DateFormat getDateInstance() {
        return DateFormat.getDateInstance(2);
    }

    public static final DateFormat getDateInstance(int n) {
        return DateFormat.getDateInstance(n, java.util.Locale.getDefault());
    }

    public static final DateFormat getDateInstance(int n, java.util.Locale locale) {
        ExtendedResourceBundle extendedResourceBundle = (ExtendedResourceBundle)DateFormat.getBundle(locale);
        String string = "";
        switch (n) {
            case 3: {
                string = (String)extendedResourceBundle.getObject(Locale.DATE_SHORT);
                break;
            }
            case 2: {
                string = (String)extendedResourceBundle.getObject(Locale.DATE_MEDIUM);
                break;
            }
            case 1: {
                string = (String)extendedResourceBundle.getObject(Locale.DATE_LONG);
                break;
            }
            case 0: {
                string = (String)extendedResourceBundle.getObject(Locale.DATE_FULL);
                break;
            }
            default: {
                string = (String)extendedResourceBundle.getObject(Locale.DATE_MEDIUM);
            }
        }
        return new SimpleDateFormat(string, locale);
    }

    public static final DateFormat getDateTimeInstance() {
        return DateFormat.getDateTimeInstance(2, 2);
    }

    public static final DateFormat getDateTimeInstance(int n, int n2) {
        return DateFormat.getDateTimeInstance(n, n2, java.util.Locale.getDefault());
    }

    public static final DateFormat getDateTimeInstance(int n, int n2, java.util.Locale locale) {
        ExtendedResourceBundle extendedResourceBundle = (ExtendedResourceBundle)DateFormat.getBundle(locale);
        StringBuffer stringBuffer = new StringBuffer();
        switch (n) {
            case 3: {
                stringBuffer.append((String)extendedResourceBundle.getObject(Locale.DATE_SHORT));
                break;
            }
            case 2: {
                stringBuffer.append((String)extendedResourceBundle.getObject(Locale.DATE_MEDIUM));
                break;
            }
            case 1: {
                stringBuffer.append((String)extendedResourceBundle.getObject(Locale.DATE_LONG));
                break;
            }
            case 0: {
                stringBuffer.append((String)extendedResourceBundle.getObject(Locale.DATE_FULL));
                break;
            }
            default: {
                stringBuffer.append((String)extendedResourceBundle.getObject(Locale.DATE_MEDIUM));
            }
        }
        stringBuffer.append(" ");
        switch (n2) {
            case 3: {
                stringBuffer.append((String)extendedResourceBundle.getObject(Locale.TIME_SHORT));
                break;
            }
            case 2: {
                stringBuffer.append((String)extendedResourceBundle.getObject(Locale.TIME_MEDIUM));
                break;
            }
            case 1: {
                stringBuffer.append((String)extendedResourceBundle.getObject(Locale.TIME_LONG));
                break;
            }
            case 0: {
                stringBuffer.append((String)extendedResourceBundle.getObject(Locale.TIME_FULL));
                break;
            }
            default: {
                stringBuffer.append((String)extendedResourceBundle.getObject(Locale.TIME_MEDIUM));
            }
        }
        return new SimpleDateFormat(stringBuffer.toString(), locale);
    }

    public static final DateFormat getInstance() {
        return DateFormat.getDateTimeInstance(3, 3);
    }

    public NumberFormat getNumberFormat() {
        return this.numberFormat;
    }

    static String getStyleName(int n) {
        String string;
        switch (n) {
            case 3: {
                string = "SHORT";
                break;
            }
            case 2: {
                string = "MEDIUM";
                break;
            }
            case 1: {
                string = "LONG";
                break;
            }
            case 0: {
                string = "FULL";
                break;
            }
            default: {
                string = "";
            }
        }
        return string;
    }

    public static final DateFormat getTimeInstance() {
        return DateFormat.getTimeInstance(2);
    }

    public static final DateFormat getTimeInstance(int n) {
        return DateFormat.getTimeInstance(n, java.util.Locale.getDefault());
    }

    public static final DateFormat getTimeInstance(int n, java.util.Locale locale) {
        ExtendedResourceBundle extendedResourceBundle = (ExtendedResourceBundle)DateFormat.getBundle(locale);
        String string = "";
        switch (n) {
            case 3: {
                string = (String)extendedResourceBundle.getObject(Locale.TIME_SHORT);
                break;
            }
            case 2: {
                string = (String)extendedResourceBundle.getObject(Locale.TIME_MEDIUM);
                break;
            }
            case 1: {
                string = (String)extendedResourceBundle.getObject(Locale.TIME_LONG);
                break;
            }
            case 0: {
                string = (String)extendedResourceBundle.getObject(Locale.TIME_FULL);
                break;
            }
            default: {
                string = (String)extendedResourceBundle.getObject(Locale.TIME_MEDIUM);
            }
        }
        return new SimpleDateFormat(string, locale);
    }

    public TimeZone getTimeZone() {
        return this.calendar.getTimeZone();
    }

    public int hashCode() {
        return this.calendar.getFirstDayOfWeek() + this.calendar.getMinimalDaysInFirstWeek() + this.calendar.getTimeZone().hashCode() + (this.calendar.isLenient() ? 1231 : 1237) + this.numberFormat.hashCode();
    }

    public boolean isLenient() {
        return this.calendar.isLenient();
    }

    public Date parse(String string) {
        ParsePosition parsePosition = new ParsePosition(0);
        Date date = this.parse(string, parsePosition);
        if (parsePosition.getErrorIndex() != -1 || parsePosition.getIndex() == 0) {
            throw new ParseException(null, parsePosition.getErrorIndex());
        }
        return date;
    }

    public abstract Date parse(String string, ParsePosition parsePosition) {
    }

    @Override
    public Object parseObject(String string, ParsePosition parsePosition) {
        return this.parse(string, parsePosition);
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public void setLenient(boolean bl) {
        this.calendar.setLenient(bl);
    }

    public void setNumberFormat(NumberFormat numberFormat) {
        this.numberFormat = numberFormat;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.calendar.setTimeZone(timeZone);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package java.text;

import com.ibm.oti.locale.Locale;
import com.ibm.oti.util.ExtendedResourceBundle;
import com.ibm.oti.util.Msg;
import java.io.ObjectInputStream;
import java.io.ObjectInputStream$GetField;
import java.io.ObjectOutputStream;
import java.io.ObjectOutputStream$PutField;
import java.io.ObjectStreamField;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.text.DateFormat;
import java.text.DateFormat$Field;
import java.text.DateFormatSymbols;
import java.text.FieldPosition;
import java.text.Format$Field;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import java.util.Vector;

public class SimpleDateFormat
extends DateFormat {
    private static final long serialVersionUID;
    private static final String patternChars;
    private String pattern;
    private DateFormatSymbols formatData;
    private transient int creationYear;
    private Date defaultCenturyStart;
    private static final ObjectStreamField[] serialPersistentFields;
    static /* synthetic */ Class class$0;
    static /* synthetic */ Class class$1;
    static /* synthetic */ Class class$2;

    static {
        ObjectStreamField[] objectStreamFieldArray = new ObjectStreamField[4];
        Class clazz = class$0;
        if (clazz == null) {
            try {
                clazz = class$0 = Class.forName("java.util.Date");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new NoClassDefFoundError(classNotFoundException.getMessage());
            }
        }
        objectStreamFieldArray[0] = new ObjectStreamField("defaultCenturyStart", clazz);
        Class clazz2 = class$1;
        if (clazz2 == null) {
            try {
                clazz2 = class$1 = Class.forName("java.text.DateFormatSymbols");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new NoClassDefFoundError(classNotFoundException.getMessage());
            }
        }
        objectStreamFieldArray[1] = new ObjectStreamField("formatData", clazz2);
        Class clazz3 = class$2;
        if (clazz3 == null) {
            try {
                clazz3 = class$2 = Class.forName("java.lang.String");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new NoClassDefFoundError(classNotFoundException.getMessage());
            }
        }
        objectStreamFieldArray[2] = new ObjectStreamField("pattern", clazz3);
        objectStreamFieldArray[3] = new ObjectStreamField("serialVersionOnStream", Integer.TYPE);
        serialPersistentFields = objectStreamFieldArray;
    }

    public SimpleDateFormat() {
        this(java.util.Locale.getDefault());
        this.pattern = SimpleDateFormat.defaultPattern();
        this.formatData = new DateFormatSymbols(java.util.Locale.getDefault());
    }

    public SimpleDateFormat(String string) {
        this(string, java.util.Locale.getDefault());
    }

    public SimpleDateFormat(String string, DateFormatSymbols dateFormatSymbols) {
        this(java.util.Locale.getDefault());
        this.validatePattern(string);
        this.pattern = string;
        this.formatData = (DateFormatSymbols)dateFormatSymbols.clone();
    }

    public SimpleDateFormat(String string, java.util.Locale locale) {
        this(locale);
        this.validatePattern(string);
        this.pattern = string;
        this.formatData = new DateFormatSymbols(locale);
    }

    private SimpleDateFormat(java.util.Locale locale) {
        this.numberFormat = NumberFormat.getInstance(locale);
        this.numberFormat.setParseIntegerOnly(true);
        this.numberFormat.setGroupingUsed(false);
        this.calendar = new GregorianCalendar(locale);
        this.calendar.add(1, -80);
        this.creationYear = this.calendar.get(1);
        this.defaultCenturyStart = this.calendar.getTime();
    }

    private void append(StringBuffer stringBuffer, FieldPosition fieldPosition, Vector vector, char c2, int n) {
        int n2 = -1;
        int n3 = "GyMdkHmsSEDFwWahKzZ".indexOf(c2);
        if (n3 == -1) {
            throw new IllegalArgumentException(Msg.getString("K002b", c2));
        }
        int n4 = stringBuffer.length();
        DateFormat$Field dateFormat$Field = null;
        switch (n3) {
            case 0: {
                dateFormat$Field = DateFormat$Field.ERA;
                stringBuffer.append(this.formatData.eras[this.calendar.get(0)]);
                break;
            }
            case 1: {
                dateFormat$Field = DateFormat$Field.YEAR;
                int n5 = this.calendar.get(1);
                if (n < 4) {
                    this.appendNumber(stringBuffer, 2, n5 %= 100);
                    break;
                }
                this.appendNumber(stringBuffer, 4, n5);
                break;
            }
            case 2: {
                dateFormat$Field = DateFormat$Field.MONTH;
                int n6 = this.calendar.get(2);
                if (n <= 2) {
                    this.appendNumber(stringBuffer, n, n6 + 1);
                    break;
                }
                if (n == 3) {
                    stringBuffer.append(this.formatData.shortMonths[n6]);
                    break;
                }
                stringBuffer.append(this.formatData.months[n6]);
                break;
            }
            case 3: {
                dateFormat$Field = DateFormat$Field.DAY_OF_MONTH;
                n2 = 5;
                break;
            }
            case 4: {
                dateFormat$Field = DateFormat$Field.HOUR_OF_DAY1;
                int n7 = this.calendar.get(11);
                this.appendNumber(stringBuffer, n, n7 == 0 ? 24 : n7);
                break;
            }
            case 5: {
                dateFormat$Field = DateFormat$Field.HOUR_OF_DAY0;
                n2 = 11;
                break;
            }
            case 6: {
                dateFormat$Field = DateFormat$Field.MINUTE;
                n2 = 12;
                break;
            }
            case 7: {
                dateFormat$Field = DateFormat$Field.SECOND;
                n2 = 13;
                break;
            }
            case 8: {
                dateFormat$Field = DateFormat$Field.MILLISECOND;
                int n8 = this.calendar.get(14);
                this.appendNumber(stringBuffer, n, n8);
                break;
            }
            case 9: {
                dateFormat$Field = DateFormat$Field.DAY_OF_WEEK;
                int n9 = this.calendar.get(7);
                if (n < 4) {
                    stringBuffer.append(this.formatData.shortWeekdays[n9]);
                    break;
                }
                stringBuffer.append(this.formatData.weekdays[n9]);
                break;
            }
            case 10: {
                dateFormat$Field = DateFormat$Field.DAY_OF_YEAR;
                n2 = 6;
                break;
            }
            case 11: {
                dateFormat$Field = DateFormat$Field.DAY_OF_WEEK_IN_MONTH;
                n2 = 8;
                break;
            }
            case 12: {
                dateFormat$Field = DateFormat$Field.WEEK_OF_YEAR;
                n2 = 3;
                break;
            }
            case 13: {
                dateFormat$Field = DateFormat$Field.WEEK_OF_MONTH;
                n2 = 4;
                break;
            }
            case 14: {
                dateFormat$Field = DateFormat$Field.AM_PM;
                stringBuffer.append(this.formatData.ampms[this.calendar.get(9)]);
                break;
            }
            case 15: {
                dateFormat$Field = DateFormat$Field.HOUR1;
                int n10 = this.calendar.get(10);
                this.appendNumber(stringBuffer, n, n10 == 0 ? 12 : n10);
                break;
            }
            case 16: {
                dateFormat$Field = DateFormat$Field.HOUR0;
                n2 = 10;
                break;
            }
            case 17: {
                dateFormat$Field = DateFormat$Field.TIME_ZONE;
                this.appendTimeZone(stringBuffer, n, true);
                break;
            }
            case 18: {
                dateFormat$Field = DateFormat$Field.TIME_ZONE;
                this.appendTimeZone(stringBuffer, n, false);
            }
        }
        if (n2 != -1) {
            this.appendNumber(stringBuffer, n, this.calendar.get(n2));
        }
        if (vector != null) {
            fieldPosition = new FieldPosition(dateFormat$Field);
            fieldPosition.setBeginIndex(n4);
            fieldPosition.setEndIndex(stringBuffer.length());
            vector.add(fieldPosition);
        } else if ((fieldPosition.getFieldAttribute() == dateFormat$Field || fieldPosition.getFieldAttribute() == null && fieldPosition.getField() == n3) && fieldPosition.getEndIndex() == 0) {
            fieldPosition.setBeginIndex(n4);
            fieldPosition.setEndIndex(stringBuffer.length());
        }
    }

    private void appendTimeZone(StringBuffer stringBuffer, int n, boolean bl) {
        if (bl) {
            String string = this.calendar.getTimeZone().getID();
            String[][] stringArray = this.formatData.zoneStrings;
            String[] stringArray2 = null;
            int n2 = 0;
            while (n2 < stringArray.length) {
                if (string.equals(stringArray[n2][0])) {
                    stringArray2 = stringArray[n2];
                    break;
                }
                ++n2;
            }
            if (stringArray2 == null) {
                n2 = this.calendar.get(15) + this.calendar.get(16);
                char c2 = '+';
                if (n2 < 0) {
                    c2 = '-';
                    n2 = -n2;
                }
                stringBuffer.append("GMT");
                stringBuffer.append(c2);
                this.appendNumber(stringBuffer, 2, n2 / -2131872256);
                stringBuffer.append(':');
                this.appendNumber(stringBuffer, 2, n2 % -2131872256 / 1625948160);
            } else {
                int n3 = n2 = this.calendar.get(16) == 0 ? 0 : 2;
                if (n < 4) {
                    stringBuffer.append(stringArray2[2 + n2]);
                } else {
                    stringBuffer.append(stringArray2[1 + n2]);
                }
            }
        } else {
            int n4 = this.calendar.get(15) + this.calendar.get(16);
            char c3 = '+';
            if (n4 < 0) {
                c3 = '-';
                n4 = -n4;
            }
            stringBuffer.append(c3);
            this.appendNumber(stringBuffer, 2, n4 / -2131872256);
            this.appendNumber(stringBuffer, 2, n4 % -2131872256 / 1625948160);
        }
    }

    private void appendNumber(StringBuffer stringBuffer, int n, int n2) {
        int n3 = this.numberFormat.getMinimumIntegerDigits();
        this.numberFormat.setMinimumIntegerDigits(n);
        this.numberFormat.format(new Integer(n2), stringBuffer, new FieldPosition(0));
        this.numberFormat.setMinimumIntegerDigits(n3);
    }

    public void applyLocalizedPattern(String string) {
        this.pattern = this.convertPattern(string, this.formatData.getLocalPatternChars(), "GyMdkHmsSEDFwWahKzZ", true);
    }

    public void applyPattern(String string) {
        this.validatePattern(string);
        this.pattern = string;
    }

    @Override
    public Object clone() {
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat)super.clone();
        simpleDateFormat.formatData = (DateFormatSymbols)this.formatData.clone();
        simpleDateFormat.defaultCenturyStart = new Date(this.defaultCenturyStart.getTime());
        return simpleDateFormat;
    }

    private static String defaultPattern() {
        ExtendedResourceBundle extendedResourceBundle = (ExtendedResourceBundle)SimpleDateFormat.getBundle(java.util.Locale.getDefault());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append((String)extendedResourceBundle.getObject(Locale.DATE_SHORT));
        stringBuffer.append(" ");
        stringBuffer.append((String)extendedResourceBundle.getObject(Locale.TIME_SHORT));
        return stringBuffer.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof SimpleDateFormat)) {
            return false;
        }
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat)object;
        return super.equals(object) && this.pattern.equals(simpleDateFormat.pattern) && this.formatData.equals(simpleDateFormat.formatData);
    }

    private Date error(ParsePosition parsePosition, int n, TimeZone timeZone) {
        parsePosition.setErrorIndex(n);
        this.calendar.setTimeZone(timeZone);
        return null;
    }

    @Override
    public AttributedCharacterIterator formatToCharacterIterator(Object object) {
        if (object instanceof Date) {
            return this.formatToCharacterIteratorImpl((Date)object);
        }
        if (object instanceof Number) {
            return this.formatToCharacterIteratorImpl(new Date(((Number)object).longValue()));
        }
        throw new IllegalArgumentException();
    }

    private AttributedCharacterIterator formatToCharacterIteratorImpl(Date date) {
        StringBuffer stringBuffer = new StringBuffer();
        Vector vector = new Vector();
        this.formatImpl(date, stringBuffer, null, vector);
        AttributedString attributedString = new AttributedString(stringBuffer.toString());
        int n = 0;
        while (n < vector.size()) {
            FieldPosition fieldPosition = (FieldPosition)vector.elementAt(n);
            Format$Field format$Field = fieldPosition.getFieldAttribute();
            attributedString.addAttribute(format$Field, format$Field, fieldPosition.getBeginIndex(), fieldPosition.getEndIndex());
            ++n;
        }
        return attributedString.getIterator();
    }

    @Override
    public StringBuffer format(Date date, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        return this.formatImpl(date, stringBuffer, fieldPosition, null);
    }

    private void validateFormat(char c2) {
        int n = "GyMdkHmsSEDFwWahKzZ".indexOf(c2);
        if (n == -1) {
            throw new IllegalArgumentException(Msg.getString("K002b", c2));
        }
    }

    private void validatePattern(String string) {
        boolean bl = false;
        int n = -1;
        int n2 = 0;
        int n3 = string.length();
        int n4 = 0;
        while (n4 < n3) {
            int n5 = string.charAt(n4);
            if (n5 == 39) {
                if (n2 > 0) {
                    this.validateFormat((char)n);
                    n2 = 0;
                }
                n = n == n5 ? -1 : n5;
                bl = !bl;
            } else if (!bl && (n == n5 || n5 >= 97 && n5 <= 122 || n5 >= 65 && n5 <= 90)) {
                if (n == n5) {
                    ++n2;
                } else {
                    if (n2 > 0) {
                        this.validateFormat((char)n);
                    }
                    n = n5;
                    n2 = 1;
                }
            } else {
                if (n2 > 0) {
                    this.validateFormat((char)n);
                    n2 = 0;
                }
                n = -1;
            }
            ++n4;
        }
        if (n2 > 0) {
            this.validateFormat((char)n);
        }
        if (bl) {
            throw new IllegalArgumentException(Msg.getString("K0019"));
        }
    }

    private StringBuffer formatImpl(Date date, StringBuffer stringBuffer, FieldPosition fieldPosition, Vector vector) {
        boolean bl = false;
        int n = -1;
        int n2 = 0;
        this.calendar.setTime(date);
        if (fieldPosition != null) {
            fieldPosition.clear();
        }
        int n3 = this.pattern.length();
        int n4 = 0;
        while (n4 < n3) {
            int n5 = this.pattern.charAt(n4);
            if (n5 == 39) {
                if (n2 > 0) {
                    this.append(stringBuffer, fieldPosition, vector, (char)n, n2);
                    n2 = 0;
                }
                if (n == n5) {
                    stringBuffer.append('\'');
                    n = -1;
                } else {
                    n = n5;
                }
                bl = !bl;
            } else if (!bl && (n == n5 || n5 >= 97 && n5 <= 122 || n5 >= 65 && n5 <= 90)) {
                if (n == n5) {
                    ++n2;
                } else {
                    if (n2 > 0) {
                        this.append(stringBuffer, fieldPosition, vector, (char)n, n2);
                    }
                    n = n5;
                    n2 = 1;
                }
            } else {
                if (n2 > 0) {
                    this.append(stringBuffer, fieldPosition, vector, (char)n, n2);
                    n2 = 0;
                }
                n = -1;
                stringBuffer.append((char)n5);
            }
            ++n4;
        }
        if (n2 > 0) {
            this.append(stringBuffer, fieldPosition, vector, (char)n, n2);
        }
        return stringBuffer;
    }

    public Date get2DigitYearStart() {
        return this.defaultCenturyStart;
    }

    public DateFormatSymbols getDateFormatSymbols() {
        return (DateFormatSymbols)this.formatData.clone();
    }

    @Override
    public int hashCode() {
        return super.hashCode() + this.pattern.hashCode() + this.formatData.hashCode() + this.creationYear;
    }

    private int parse(String string, int n, char c2, int n2) {
        int n3 = "GyMdkHmsSEDFwWahKzZ".indexOf(c2);
        if (n3 == -1) {
            throw new IllegalArgumentException(Msg.getString("K002b", c2));
        }
        int n4 = -1;
        int n5 = 0;
        if (n2 < 0) {
            n5 = n2 = -n2;
        }
        switch (n3) {
            case 0: {
                return this.parseText(string, n, this.formatData.eras, 0);
            }
            case 1: {
                if (n2 >= 3) {
                    n4 = 1;
                    break;
                }
                ParsePosition parsePosition = new ParsePosition(n);
                Number number = this.parseNumber(n5, string, parsePosition);
                if (number == null) {
                    return -parsePosition.getErrorIndex() - 1;
                }
                int n6 = number.intValue();
                if (parsePosition.getIndex() - n == 2 && n6 >= 0 && (n6 += this.creationYear / 100 * 100) < this.creationYear) {
                    n6 += 100;
                }
                this.calendar.set(1, n6);
                return parsePosition.getIndex();
            }
            case 2: {
                if (n2 <= 2) {
                    return this.parseNumber(n5, string, n, 2, -1);
                }
                n3 = this.parseText(string, n, this.formatData.months, 2);
                if (n3 < 0) {
                    return this.parseText(string, n, this.formatData.shortMonths, 2);
                }
                return n3;
            }
            case 3: {
                n4 = 5;
                break;
            }
            case 4: {
                ParsePosition parsePosition = new ParsePosition(n);
                Number number = this.parseNumber(n5, string, parsePosition);
                if (number == null) {
                    return -parsePosition.getErrorIndex() - 1;
                }
                int n7 = number.intValue();
                if (n7 == 24) {
                    n7 = 0;
                }
                this.calendar.set(11, n7);
                return parsePosition.getIndex();
            }
            case 5: {
                n4 = 11;
                break;
            }
            case 6: {
                n4 = 12;
                break;
            }
            case 7: {
                n4 = 13;
                break;
            }
            case 8: {
                n4 = 14;
                break;
            }
            case 9: {
                n3 = this.parseText(string, n, this.formatData.weekdays, 7);
                if (n3 < 0) {
                    return this.parseText(string, n, this.formatData.shortWeekdays, 7);
                }
                return n3;
            }
            case 10: {
                n4 = 6;
                break;
            }
            case 11: {
                n4 = 8;
                break;
            }
            case 12: {
                n4 = 3;
                break;
            }
            case 13: {
                n4 = 4;
                break;
            }
            case 14: {
                return this.parseText(string, n, this.formatData.ampms, 9);
            }
            case 15: {
                ParsePosition parsePosition = new ParsePosition(n);
                Number number = this.parseNumber(n5, string, parsePosition);
                if (number == null) {
                    return -parsePosition.getErrorIndex() - 1;
                }
                int n8 = number.intValue();
                if (n8 == 12) {
                    n8 = 0;
                }
                this.calendar.set(10, n8);
                return parsePosition.getIndex();
            }
            case 16: {
                n4 = 10;
                break;
            }
            case 17: {
                return this.parseTimeZone(string, n);
            }
            case 18: {
                return this.parseTimeZone(string, n);
            }
        }
        if (n4 != -1) {
            return this.parseNumber(n5, string, n, n4, 0);
        }
        return n;
    }

    @Override
    public Date parse(String string, ParsePosition parsePosition) {
        Date date;
        boolean bl = false;
        int n = -1;
        int n2 = 0;
        int n3 = parsePosition.getIndex();
        int n4 = string.length();
        this.calendar.clear();
        TimeZone timeZone = this.calendar.getTimeZone();
        int n5 = this.pattern.length();
        int n6 = 0;
        while (n6 < n5) {
            int n7 = this.pattern.charAt(n6);
            if (n7 == 39) {
                if (n2 > 0) {
                    if ((n3 = this.parse(string, n3, (char)n, n2)) < 0) {
                        return this.error(parsePosition, -n3 - 1, timeZone);
                    }
                    n2 = 0;
                }
                if (n == n7) {
                    if (n3 >= n4 || string.charAt(n3) != '\'') {
                        return this.error(parsePosition, n3, timeZone);
                    }
                    ++n3;
                    n = -1;
                } else {
                    n = n7;
                }
                bl = !bl;
            } else if (!bl && (n == n7 || n7 >= 97 && n7 <= 122 || n7 >= 65 && n7 <= 90)) {
                if (n == n7) {
                    ++n2;
                } else {
                    if (n2 > 0 && (n3 = this.parse(string, n3, (char)n, -n2)) < 0) {
                        return this.error(parsePosition, -n3 - 1, timeZone);
                    }
                    n = n7;
                    n2 = 1;
                }
            } else {
                if (n2 > 0) {
                    if ((n3 = this.parse(string, n3, (char)n, n2)) < 0) {
                        return this.error(parsePosition, -n3 - 1, timeZone);
                    }
                    n2 = 0;
                }
                n = -1;
                if (n3 >= n4 || string.charAt(n3) != n7) {
                    return this.error(parsePosition, n3, timeZone);
                }
                ++n3;
            }
            ++n6;
        }
        if (n2 > 0 && (n3 = this.parse(string, n3, (char)n, n2)) < 0) {
            return this.error(parsePosition, -n3 - 1, timeZone);
        }
        try {
            date = this.calendar.getTime();
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return this.error(parsePosition, n3, timeZone);
        }
        parsePosition.setIndex(n3);
        this.calendar.setTimeZone(timeZone);
        return date;
    }

    private Number parseNumber(int n, String string, ParsePosition parsePosition) {
        int n2;
        if (n == 0) {
            return this.numberFormat.parse(string, parsePosition);
        }
        int n3 = string.length();
        int n4 = 0;
        int n5 = parsePosition.getIndex();
        if (n > 0 && n < n3 - n5) {
            n3 = n5 + n;
        }
        while (n5 < n3 && (n2 = Character.digit(string.charAt(n5), 10)) != -1) {
            ++n5;
            n4 = n4 * 10 + n2;
        }
        if (n5 == parsePosition.getIndex()) {
            parsePosition.setErrorIndex(n5);
            return null;
        }
        parsePosition.setIndex(n5);
        return new Integer(n4);
    }

    private int parseNumber(int n, String string, int n2, int n3, int n4) {
        ParsePosition parsePosition = new ParsePosition(n2);
        Number number = this.parseNumber(n, string, parsePosition);
        if (number == null) {
            return -parsePosition.getErrorIndex() - 1;
        }
        this.calendar.set(n3, number.intValue() + n4);
        return parsePosition.getIndex();
    }

    private int parseText(String string, int n, String[] stringArray, int n2) {
        int n3 = -1;
        int n4 = 0;
        while (n4 < stringArray.length) {
            if (stringArray[n4].length() != 0 && string.regionMatches(true, n, stringArray[n4], 0, stringArray[n4].length()) && (n3 == -1 || stringArray[n4].length() > stringArray[n3].length())) {
                n3 = n4;
            }
            ++n4;
        }
        if (n3 != -1) {
            this.calendar.set(n2, n3);
            return n + stringArray[n3].length();
        }
        return -n - 1;
    }

    private int parseTimeZone(String string, int n) {
        char c2;
        String[][] stringArray = this.formatData.zoneStrings;
        boolean bl = string.regionMatches(n, "GMT", 0, 3);
        if (bl) {
            n += 3;
        }
        if (n < string.length() && ((c2 = string.charAt(n)) == '+' || c2 == '-')) {
            ParsePosition parsePosition = new ParsePosition(n + 1);
            Number number = this.numberFormat.parse(string, parsePosition);
            if (number == null) {
                return -parsePosition.getErrorIndex() - 1;
            }
            int n2 = number.intValue();
            int n3 = n2 * -2131872256;
            int n4 = parsePosition.getIndex();
            if (n4 < string.length() && string.charAt(n4) == ':') {
                parsePosition.setIndex(n4 + 1);
                number = this.numberFormat.parse(string, parsePosition);
                if (number == null) {
                    return -parsePosition.getErrorIndex() - 1;
                }
                int n5 = number.intValue();
                n3 += n5 * 1625948160;
            } else if (n2 >= 24) {
                n3 = n2 / 100 * -2131872256 + n2 % 100 * 1625948160;
            }
            if (c2 == '-') {
                n3 = -n3;
            }
            this.calendar.setTimeZone(new SimpleTimeZone(n3, ""));
            return parsePosition.getIndex();
        }
        if (bl) {
            this.calendar.setTimeZone(TimeZone.getTimeZone("GMT"));
            return n;
        }
        int n6 = -1;
        TimeZone timeZone = null;
        String string2 = this.calendar.getTimeZone().getID();
        int n7 = 0;
        while (n7 < stringArray.length) {
            if (string2.equals(stringArray[n7][0])) {
                timeZone = TimeZone.getTimeZone(stringArray[n7][0]);
                if (!this.calendar.getTimeZone().hasSameRules(timeZone)) break;
                n6 = n7;
                break;
            }
            ++n7;
        }
        if (n6 >= 0 && (n7 = this.matchTZ(string, n, n6, timeZone)) > 0) {
            return n + n7;
        }
        n7 = 0;
        while (n7 < stringArray.length) {
            int n8 = this.matchTZ(string, n, n7, null);
            if (n8 > 0) {
                return n + n8;
            }
            ++n7;
        }
        return -n - 1;
    }

    private int matchTZ(String string, int n, int n2, TimeZone timeZone) {
        int n3 = 1;
        while (n3 < 5) {
            if (string.regionMatches(true, n, this.formatData.zoneStrings[n2][n3], 0, this.formatData.zoneStrings[n2][n3].length())) {
                if (timeZone == null) {
                    timeZone = TimeZone.getTimeZone(this.formatData.zoneStrings[n2][0]);
                }
                if (timeZone == null) {
                    return 0;
                }
                int n4 = timeZone.getRawOffset();
                if (n3 >= 3 && timeZone.useDaylightTime()) {
                    n4 += -2131872256;
                }
                this.calendar.setTimeZone(new SimpleTimeZone(n4, ""));
                return this.formatData.zoneStrings[n2][n3].length();
            }
            ++n3;
        }
        return 0;
    }

    public void set2DigitYearStart(Date date) {
        this.defaultCenturyStart = date;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        this.creationYear = gregorianCalendar.get(1);
    }

    public void setDateFormatSymbols(DateFormatSymbols dateFormatSymbols) {
        this.formatData = (DateFormatSymbols)dateFormatSymbols.clone();
    }

    public String toLocalizedPattern() {
        return this.convertPattern(this.pattern, "GyMdkHmsSEDFwWahKzZ", this.formatData.getLocalPatternChars(), false);
    }

    public String toPattern() {
        return this.pattern;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        ObjectOutputStream$PutField objectOutputStream$PutField = objectOutputStream.putFields();
        objectOutputStream$PutField.put("defaultCenturyStart", this.defaultCenturyStart);
        objectOutputStream$PutField.put("formatData", this.formatData);
        objectOutputStream$PutField.put("pattern", this.pattern);
        objectOutputStream$PutField.put("serialVersionOnStream", 1);
        objectOutputStream.writeFields();
    }

    private void readObject(ObjectInputStream objectInputStream) {
        ObjectInputStream$GetField objectInputStream$GetField = objectInputStream.readFields();
        int n = objectInputStream$GetField.get("serialVersionOnStream", 0);
        Date date = n > 0 ? (Date)objectInputStream$GetField.get("defaultCenturyStart", new Date()) : new Date();
        this.set2DigitYearStart(date);
        this.formatData = (DateFormatSymbols)objectInputStream$GetField.get("formatData", null);
        this.pattern = (String)objectInputStream$GetField.get("pattern", "");
    }
}


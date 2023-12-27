/*
 * Decompiled with CFR 0.152.
 */
package java.text;

import com.ibm.oti.locale.Locale;
import com.ibm.oti.util.ExtendedResourceBundle;
import com.ibm.oti.util.Msg;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectInputStream$GetField;
import java.io.ObjectOutputStream;
import java.io.ObjectOutputStream$PutField;
import java.io.ObjectStreamField;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Currency;

public abstract class NumberFormat
extends Format {
    private static final long serialVersionUID;
    public static final int INTEGER_FIELD;
    public static final int FRACTION_FIELD;
    private boolean groupingUsed = true;
    private boolean parseIntegerOnly = false;
    private int maximumIntegerDigits = 40;
    private int minimumIntegerDigits = 1;
    private int maximumFractionDigits = 3;
    private int minimumFractionDigits = 0;
    private static final ObjectStreamField[] serialPersistentFields;

    static {
        serialPersistentFields = new ObjectStreamField[]{new ObjectStreamField("groupingUsed", Boolean.TYPE), new ObjectStreamField("maxFractionDigits", Byte.TYPE), new ObjectStreamField("maximumFractionDigits", Integer.TYPE), new ObjectStreamField("maximumIntegerDigits", Integer.TYPE), new ObjectStreamField("maxIntegerDigits", Byte.TYPE), new ObjectStreamField("minFractionDigits", Byte.TYPE), new ObjectStreamField("minimumFractionDigits", Integer.TYPE), new ObjectStreamField("minimumIntegerDigits", Integer.TYPE), new ObjectStreamField("minIntegerDigits", Byte.TYPE), new ObjectStreamField("parseIntegerOnly", Boolean.TYPE), new ObjectStreamField("serialVersionOnStream", Integer.TYPE)};
    }

    @Override
    public Object clone() {
        return super.clone();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof NumberFormat)) {
            return false;
        }
        NumberFormat numberFormat = (NumberFormat)object;
        return this.groupingUsed == numberFormat.groupingUsed && this.parseIntegerOnly == numberFormat.parseIntegerOnly && this.maximumFractionDigits == numberFormat.maximumFractionDigits && this.maximumIntegerDigits == numberFormat.maximumIntegerDigits && this.minimumFractionDigits == numberFormat.minimumFractionDigits && this.minimumIntegerDigits == numberFormat.minimumIntegerDigits;
    }

    public final String format(double d2) {
        return this.format(d2, new StringBuffer(), new FieldPosition(0)).toString();
    }

    public abstract StringBuffer format(double d2, StringBuffer stringBuffer, FieldPosition fieldPosition) {
    }

    public final String format(long l) {
        return this.format(l, new StringBuffer(), new FieldPosition(0)).toString();
    }

    public abstract StringBuffer format(long l, StringBuffer stringBuffer, FieldPosition fieldPosition) {
    }

    @Override
    public final StringBuffer format(Object object, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (object instanceof Number) {
            long l;
            double d2 = ((Number)object).doubleValue();
            if (d2 == (double)(l = ((Number)object).longValue())) {
                return this.format(l, stringBuffer, fieldPosition);
            }
            return this.format(d2, stringBuffer, fieldPosition);
        }
        throw new IllegalArgumentException();
    }

    public static java.util.Locale[] getAvailableLocales() {
        return java.util.Locale.getAvailableLocales();
    }

    public Currency getCurrency() {
        throw new UnsupportedOperationException();
    }

    public static final NumberFormat getCurrencyInstance() {
        return NumberFormat.getCurrencyInstance(java.util.Locale.getDefault());
    }

    public static NumberFormat getCurrencyInstance(java.util.Locale locale) {
        return NumberFormat.getInstance(locale, Locale.CURRENCY);
    }

    public static final NumberFormat getIntegerInstance() {
        return NumberFormat.getIntegerInstance(java.util.Locale.getDefault());
    }

    public static NumberFormat getIntegerInstance(java.util.Locale locale) {
        NumberFormat numberFormat = NumberFormat.getInstance(locale, Locale.INTEGER);
        numberFormat.setParseIntegerOnly(true);
        return numberFormat;
    }

    public static final NumberFormat getInstance() {
        return NumberFormat.getNumberInstance();
    }

    public static NumberFormat getInstance(java.util.Locale locale) {
        return NumberFormat.getNumberInstance(locale);
    }

    static NumberFormat getInstance(java.util.Locale locale, Integer n) {
        return new DecimalFormat(NumberFormat.getPattern(locale, n), new DecimalFormatSymbols(locale));
    }

    public int getMaximumFractionDigits() {
        return this.maximumFractionDigits;
    }

    public int getMaximumIntegerDigits() {
        return this.maximumIntegerDigits;
    }

    public int getMinimumFractionDigits() {
        return this.minimumFractionDigits;
    }

    public int getMinimumIntegerDigits() {
        return this.minimumIntegerDigits;
    }

    public static final NumberFormat getNumberInstance() {
        return NumberFormat.getNumberInstance(java.util.Locale.getDefault());
    }

    public static NumberFormat getNumberInstance(java.util.Locale locale) {
        return NumberFormat.getInstance(locale, Locale.NUMBER);
    }

    static String getPattern(java.util.Locale locale, Integer n) {
        ExtendedResourceBundle extendedResourceBundle = (ExtendedResourceBundle)NumberFormat.getBundle(locale);
        return (String)extendedResourceBundle.getObject(n);
    }

    public static final NumberFormat getPercentInstance() {
        return NumberFormat.getPercentInstance(java.util.Locale.getDefault());
    }

    public static NumberFormat getPercentInstance(java.util.Locale locale) {
        return NumberFormat.getInstance(locale, Locale.PERCENT);
    }

    public int hashCode() {
        return (this.groupingUsed ? 1231 : 1237) + (this.parseIntegerOnly ? 1231 : 1237) + this.maximumFractionDigits + this.maximumIntegerDigits + this.minimumFractionDigits + this.minimumIntegerDigits;
    }

    public boolean isGroupingUsed() {
        return this.groupingUsed;
    }

    public boolean isParseIntegerOnly() {
        return this.parseIntegerOnly;
    }

    public Number parse(String string) {
        ParsePosition parsePosition = new ParsePosition(0);
        Number number = this.parse(string, parsePosition);
        if (parsePosition.getErrorIndex() != -1 || parsePosition.getIndex() == 0) {
            throw new ParseException(null, parsePosition.getErrorIndex());
        }
        return number;
    }

    public abstract Number parse(String string, ParsePosition parsePosition) {
    }

    @Override
    public final Object parseObject(String string, ParsePosition parsePosition) {
        return this.parse(string, parsePosition);
    }

    public void setCurrency(Currency currency) {
        throw new UnsupportedOperationException();
    }

    public void setGroupingUsed(boolean bl) {
        this.groupingUsed = bl;
    }

    public void setMaximumFractionDigits(int n) {
        int n2 = this.maximumFractionDigits = n < 0 ? 0 : n;
        if (this.maximumFractionDigits < this.minimumFractionDigits) {
            this.minimumFractionDigits = this.maximumFractionDigits;
        }
    }

    public void setMaximumIntegerDigits(int n) {
        int n2 = this.maximumIntegerDigits = n < 0 ? 0 : n;
        if (this.maximumIntegerDigits < this.minimumIntegerDigits) {
            this.minimumIntegerDigits = this.maximumIntegerDigits;
        }
    }

    public void setMinimumFractionDigits(int n) {
        int n2 = this.minimumFractionDigits = n < 0 ? 0 : n;
        if (this.maximumFractionDigits < this.minimumFractionDigits) {
            this.maximumFractionDigits = this.minimumFractionDigits;
        }
    }

    public void setMinimumIntegerDigits(int n) {
        int n2 = this.minimumIntegerDigits = n < 0 ? 0 : n;
        if (this.maximumIntegerDigits < this.minimumIntegerDigits) {
            this.maximumIntegerDigits = this.minimumIntegerDigits;
        }
    }

    public void setParseIntegerOnly(boolean bl) {
        this.parseIntegerOnly = bl;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        ObjectOutputStream$PutField objectOutputStream$PutField = objectOutputStream.putFields();
        objectOutputStream$PutField.put("groupingUsed", this.groupingUsed);
        objectOutputStream$PutField.put("maxFractionDigits", this.maximumFractionDigits < 127 ? (byte)this.maximumFractionDigits : (byte)127);
        objectOutputStream$PutField.put("maximumFractionDigits", this.maximumFractionDigits);
        objectOutputStream$PutField.put("maximumIntegerDigits", this.maximumIntegerDigits);
        objectOutputStream$PutField.put("maxIntegerDigits", this.maximumIntegerDigits < 127 ? (byte)this.maximumIntegerDigits : (byte)127);
        objectOutputStream$PutField.put("minFractionDigits", this.minimumFractionDigits < 127 ? (byte)this.minimumFractionDigits : (byte)127);
        objectOutputStream$PutField.put("minimumFractionDigits", this.minimumFractionDigits);
        objectOutputStream$PutField.put("minimumIntegerDigits", this.minimumIntegerDigits);
        objectOutputStream$PutField.put("minIntegerDigits", this.minimumIntegerDigits < 127 ? (byte)this.minimumIntegerDigits : (byte)127);
        objectOutputStream$PutField.put("parseIntegerOnly", this.parseIntegerOnly);
        objectOutputStream$PutField.put("serialVersionOnStream", 1);
        objectOutputStream.writeFields();
    }

    private void readObject(ObjectInputStream objectInputStream) {
        ObjectInputStream$GetField objectInputStream$GetField = objectInputStream.readFields();
        this.groupingUsed = objectInputStream$GetField.get("groupingUsed", true);
        this.parseIntegerOnly = objectInputStream$GetField.get("parseIntegerOnly", false);
        if (objectInputStream$GetField.get("serialVersionOnStream", 0) == 0) {
            this.maximumFractionDigits = objectInputStream$GetField.get("maxFractionDigits", (byte)3);
            this.maximumIntegerDigits = objectInputStream$GetField.get("maxIntegerDigits", (byte)40);
            this.minimumFractionDigits = objectInputStream$GetField.get("minFractionDigits", (byte)0);
            this.minimumIntegerDigits = objectInputStream$GetField.get("minIntegerDigits", (byte)1);
        } else {
            this.maximumFractionDigits = objectInputStream$GetField.get("maximumFractionDigits", 3);
            this.maximumIntegerDigits = objectInputStream$GetField.get("maximumIntegerDigits", 40);
            this.minimumFractionDigits = objectInputStream$GetField.get("minimumFractionDigits", 0);
            this.minimumIntegerDigits = objectInputStream$GetField.get("minimumIntegerDigits", 1);
        }
        if (this.minimumIntegerDigits > this.maximumIntegerDigits || this.minimumFractionDigits > this.maximumFractionDigits) {
            throw new InvalidObjectException(Msg.getString("K00fa"));
        }
        if (this.minimumIntegerDigits < 0 || this.maximumIntegerDigits < 0 || this.minimumFractionDigits < 0 || this.maximumFractionDigits < 0) {
            throw new InvalidObjectException(Msg.getString("K00fb"));
        }
    }
}


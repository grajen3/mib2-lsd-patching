/*
 * Decompiled with CFR 0.152.
 */
package java.text;

import com.ibm.oti.locale.Locale;
import com.ibm.oti.util.ExtendedResourceBundle;
import java.io.ObjectInputStream;
import java.io.ObjectInputStream$GetField;
import java.io.ObjectOutputStream;
import java.io.ObjectOutputStream$PutField;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.text.Format;
import java.util.Arrays;
import java.util.Currency;

public final class DecimalFormatSymbols
implements Cloneable,
Serializable {
    private static final long serialVersionUID;
    private final int ZeroDigit;
    private final int Digit;
    private final int DecimalSeparator;
    private final int GroupingSeparator;
    private final int PatternSeparator;
    private final int Percent;
    private final int PerMill;
    private final int Exponent;
    private final int MonetaryDecimalSeparator;
    private final int MinusSign;
    transient char[] patternChars;
    private transient Currency currency;
    private transient java.util.Locale locale;
    private String infinity;
    private String NaN;
    private String currencySymbol;
    private String intlCurrencySymbol;
    private static final ObjectStreamField[] serialPersistentFields;
    static /* synthetic */ Class class$0;

    static {
        ObjectStreamField[] objectStreamFieldArray = new ObjectStreamField[15];
        Class clazz = class$0;
        if (clazz == null) {
            try {
                clazz = class$0 = Class.forName("java.lang.String");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new NoClassDefFoundError(classNotFoundException.getMessage());
            }
        }
        objectStreamFieldArray[0] = new ObjectStreamField("currencySymbol", clazz);
        objectStreamFieldArray[1] = new ObjectStreamField("decimalSeparator", Character.TYPE);
        objectStreamFieldArray[2] = new ObjectStreamField("digit", Character.TYPE);
        objectStreamFieldArray[3] = new ObjectStreamField("exponential", Character.TYPE);
        objectStreamFieldArray[4] = new ObjectStreamField("groupingSeparator", Character.TYPE);
        Class clazz2 = class$0;
        if (clazz2 == null) {
            try {
                clazz2 = class$0 = Class.forName("java.lang.String");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new NoClassDefFoundError(classNotFoundException.getMessage());
            }
        }
        objectStreamFieldArray[5] = new ObjectStreamField("infinity", clazz2);
        Class clazz3 = class$0;
        if (clazz3 == null) {
            try {
                clazz3 = class$0 = Class.forName("java.lang.String");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new NoClassDefFoundError(classNotFoundException.getMessage());
            }
        }
        objectStreamFieldArray[6] = new ObjectStreamField("intlCurrencySymbol", clazz3);
        objectStreamFieldArray[7] = new ObjectStreamField("minusSign", Character.TYPE);
        objectStreamFieldArray[8] = new ObjectStreamField("monetarySeparator", Character.TYPE);
        Class clazz4 = class$0;
        if (clazz4 == null) {
            try {
                clazz4 = class$0 = Class.forName("java.lang.String");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new NoClassDefFoundError(classNotFoundException.getMessage());
            }
        }
        objectStreamFieldArray[9] = new ObjectStreamField("NaN", clazz4);
        objectStreamFieldArray[10] = new ObjectStreamField("patternSeparator", Character.TYPE);
        objectStreamFieldArray[11] = new ObjectStreamField("percent", Character.TYPE);
        objectStreamFieldArray[12] = new ObjectStreamField("perMill", Character.TYPE);
        objectStreamFieldArray[13] = new ObjectStreamField("serialVersionOnStream", Integer.TYPE);
        objectStreamFieldArray[14] = new ObjectStreamField("zeroDigit", Character.TYPE);
        serialPersistentFields = objectStreamFieldArray;
    }

    public DecimalFormatSymbols() {
        this(java.util.Locale.getDefault());
    }

    public DecimalFormatSymbols(java.util.Locale locale) {
        this.ZeroDigit = 0;
        this.Digit = 1;
        this.DecimalSeparator = 2;
        this.GroupingSeparator = 3;
        this.PatternSeparator = 4;
        this.Percent = 5;
        this.PerMill = 6;
        this.Exponent = 7;
        this.MonetaryDecimalSeparator = 8;
        this.MinusSign = 9;
        ExtendedResourceBundle extendedResourceBundle = (ExtendedResourceBundle)Format.getBundle(locale);
        this.patternChars = ((String)extendedResourceBundle.getObject(Locale.DECIMAL_PATTERN_CHARS)).toCharArray();
        this.infinity = (String)extendedResourceBundle.getObject(Locale.INFINITY);
        this.NaN = (String)extendedResourceBundle.getObject(Locale.NAN);
        this.locale = locale;
        try {
            this.currency = Currency.getInstance(locale);
            this.currencySymbol = this.currency.getSymbol(locale);
            this.intlCurrencySymbol = this.currency.getCurrencyCode();
        }
        catch (IllegalArgumentException illegalArgumentException) {
            this.currency = Currency.getInstance("XXX");
            this.currencySymbol = (String)extendedResourceBundle.getObject(Locale.CURRENCY_SYMBOL);
            this.intlCurrencySymbol = (String)extendedResourceBundle.getObject(Locale.INTL_CURRENCY_SYMBOL);
        }
    }

    public Object clone() {
        try {
            DecimalFormatSymbols decimalFormatSymbols = (DecimalFormatSymbols)super.clone();
            decimalFormatSymbols.patternChars = (char[])this.patternChars.clone();
            return decimalFormatSymbols;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            return null;
        }
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof DecimalFormatSymbols)) {
            return false;
        }
        DecimalFormatSymbols decimalFormatSymbols = (DecimalFormatSymbols)object;
        return Arrays.equals(this.patternChars, decimalFormatSymbols.patternChars) && this.infinity.equals(decimalFormatSymbols.infinity) && this.NaN.equals(decimalFormatSymbols.NaN) && this.currencySymbol.equals(decimalFormatSymbols.currencySymbol) && this.intlCurrencySymbol.equals(decimalFormatSymbols.intlCurrencySymbol);
    }

    public Currency getCurrency() {
        return this.currency;
    }

    public String getInternationalCurrencySymbol() {
        return this.intlCurrencySymbol;
    }

    public String getCurrencySymbol() {
        return this.currencySymbol;
    }

    public char getDecimalSeparator() {
        return this.patternChars[2];
    }

    public char getDigit() {
        return this.patternChars[1];
    }

    public char getGroupingSeparator() {
        return this.patternChars[3];
    }

    public String getInfinity() {
        return this.infinity;
    }

    String getLocalPatternChars() {
        return new String(this.patternChars, 0, this.patternChars.length - 2);
    }

    public char getMinusSign() {
        return this.patternChars[9];
    }

    public char getMonetaryDecimalSeparator() {
        return this.patternChars[8];
    }

    public String getNaN() {
        return this.NaN;
    }

    public char getPatternSeparator() {
        return this.patternChars[4];
    }

    public char getPercent() {
        return this.patternChars[5];
    }

    public char getPerMill() {
        return this.patternChars[6];
    }

    public char getZeroDigit() {
        return this.patternChars[0];
    }

    char getExponential() {
        return this.patternChars[7];
    }

    public int hashCode() {
        return new String(this.patternChars).hashCode() + this.infinity.hashCode() + this.NaN.hashCode() + this.currencySymbol.hashCode() + this.intlCurrencySymbol.hashCode();
    }

    public void setCurrency(Currency currency) {
        if (currency == null) {
            throw new NullPointerException();
        }
        if (currency == this.currency) {
            return;
        }
        this.currency = currency;
        this.intlCurrencySymbol = currency.getCurrencyCode();
        this.currencySymbol = currency.getSymbol(this.locale);
    }

    public void setInternationalCurrencySymbol(String string) {
        if (string == null) {
            this.currency = null;
            this.intlCurrencySymbol = null;
            return;
        }
        if (string.equals(this.intlCurrencySymbol)) {
            return;
        }
        try {
            this.currency = Currency.getInstance(string);
            this.currencySymbol = this.currency.getSymbol(this.locale);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            this.currency = null;
        }
        this.intlCurrencySymbol = string;
    }

    public void setCurrencySymbol(String string) {
        this.currencySymbol = string;
    }

    public void setDecimalSeparator(char c2) {
        this.patternChars[2] = c2;
    }

    public void setDigit(char c2) {
        this.patternChars[1] = c2;
    }

    public void setGroupingSeparator(char c2) {
        this.patternChars[3] = c2;
    }

    public void setInfinity(String string) {
        this.infinity = string;
    }

    public void setMinusSign(char c2) {
        this.patternChars[9] = c2;
    }

    public void setMonetaryDecimalSeparator(char c2) {
        this.patternChars[8] = c2;
    }

    public void setNaN(String string) {
        this.NaN = string;
    }

    public void setPatternSeparator(char c2) {
        this.patternChars[4] = c2;
    }

    public void setPercent(char c2) {
        this.patternChars[5] = c2;
    }

    public void setPerMill(char c2) {
        this.patternChars[6] = c2;
    }

    public void setZeroDigit(char c2) {
        this.patternChars[0] = c2;
    }

    void setExponential(char c2) {
        this.patternChars[7] = c2;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        ObjectOutputStream$PutField objectOutputStream$PutField = objectOutputStream.putFields();
        objectOutputStream$PutField.put("currencySymbol", this.currencySymbol);
        objectOutputStream$PutField.put("decimalSeparator", this.getDecimalSeparator());
        objectOutputStream$PutField.put("digit", this.getDigit());
        objectOutputStream$PutField.put("exponential", this.getExponential());
        objectOutputStream$PutField.put("groupingSeparator", this.getGroupingSeparator());
        objectOutputStream$PutField.put("infinity", this.infinity);
        objectOutputStream$PutField.put("intlCurrencySymbol", this.intlCurrencySymbol);
        objectOutputStream$PutField.put("minusSign", this.getMinusSign());
        objectOutputStream$PutField.put("monetarySeparator", this.getMonetaryDecimalSeparator());
        objectOutputStream$PutField.put("NaN", this.NaN);
        objectOutputStream$PutField.put("patternSeparator", this.getPatternSeparator());
        objectOutputStream$PutField.put("percent", this.getPercent());
        objectOutputStream$PutField.put("perMill", this.getPerMill());
        objectOutputStream$PutField.put("serialVersionOnStream", 1);
        objectOutputStream$PutField.put("zeroDigit", this.getZeroDigit());
        objectOutputStream.writeFields();
    }

    private void readObject(ObjectInputStream objectInputStream) {
        ObjectInputStream$GetField objectInputStream$GetField = objectInputStream.readFields();
        this.patternChars = new char[10];
        this.currencySymbol = (String)objectInputStream$GetField.get("currencySymbol", "");
        this.setDecimalSeparator(objectInputStream$GetField.get("decimalSeparator", '.'));
        this.setDigit(objectInputStream$GetField.get("digit", '#'));
        this.setGroupingSeparator(objectInputStream$GetField.get("groupingSeparator", ','));
        this.infinity = (String)objectInputStream$GetField.get("infinity", "");
        this.intlCurrencySymbol = (String)objectInputStream$GetField.get("intlCurrencySymbol", "");
        this.setMinusSign(objectInputStream$GetField.get("minusSign", '-'));
        this.NaN = (String)objectInputStream$GetField.get("NaN", "");
        this.setPatternSeparator(objectInputStream$GetField.get("patternSeparator", ';'));
        this.setPercent(objectInputStream$GetField.get("percent", '%'));
        this.setPerMill(objectInputStream$GetField.get("perMill", '\u2030'));
        this.setZeroDigit(objectInputStream$GetField.get("zeroDigit", '0'));
        if (objectInputStream$GetField.get("serialVersionOnStream", 0) == 0) {
            this.setMonetaryDecimalSeparator(this.getDecimalSeparator());
            this.setExponential('E');
        } else {
            this.setMonetaryDecimalSeparator(objectInputStream$GetField.get("monetarySeparator", '.'));
            this.setExponential(objectInputStream$GetField.get("exponential", 'E'));
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package java.text;

import com.ibm.oti.locale.Locale;
import com.ibm.oti.util.Msg;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.text.DecimalFormatSymbols;
import java.text.FieldPosition;
import java.text.Format$Field;
import java.text.NumberFormat;
import java.text.NumberFormat$Field;
import java.text.ParsePosition;
import java.util.Currency;
import java.util.Vector;

public class DecimalFormat
extends NumberFormat {
    private static final long serialVersionUID;
    private static final String patternChars;
    private static final char CURRENCY_SYMBOL;
    private static final int DOUBLE_INTEGER_DIGITS;
    private static final int DOUBLE_FRACTION_DIGITS;
    private byte groupingSize = (byte)3;
    private int multiplier = 1;
    private String positivePrefix = "";
    private String positiveSuffix = "";
    private String negativePrefix = "-";
    private String negativeSuffix = "";
    private String posPrefixPattern;
    private String posSuffixPattern;
    private String negPrefixPattern;
    private String negSuffixPattern;
    private boolean decimalSeparatorAlwaysShown = false;
    private transient boolean posPrefixMonetary = false;
    private transient boolean posSuffixMonetary = false;
    private transient boolean negPrefixMonetary = false;
    private transient boolean negSuffixMonetary = false;
    private DecimalFormatSymbols symbols;
    private boolean useExponentialNotation = false;
    private byte minExponentDigits;
    private int serialVersionOnStream = 2;
    private transient char zero;
    private static final double log10;

    static {
        log10 = Math.log(10.0);
    }

    public DecimalFormat() {
        this(DecimalFormat.getPattern(java.util.Locale.getDefault(), Locale.NUMBER));
    }

    public DecimalFormat(String string) {
        this.symbols = new DecimalFormatSymbols();
        this.zero = this.symbols.getZeroDigit();
        this.applyPattern(string);
    }

    public DecimalFormat(String string, DecimalFormatSymbols decimalFormatSymbols) {
        this.symbols = (DecimalFormatSymbols)decimalFormatSymbols.clone();
        this.zero = this.symbols.getZeroDigit();
        this.applyPattern(string);
    }

    public void applyLocalizedPattern(String string) {
        this.applyPattern(this.convertPattern(string, this.symbols.getLocalPatternChars(), "0#.,;%\u2030E", false));
    }

    public void applyPattern(String string) {
        if (string.length() == 0) {
            return;
        }
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 1;
        int n7 = 0;
        boolean bl = true;
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = false;
        boolean bl5 = false;
        boolean bl6 = false;
        StringBuffer stringBuffer = new StringBuffer();
        String string2 = "";
        String string3 = "";
        String string4 = "";
        String string5 = "";
        String string6 = null;
        boolean bl7 = false;
        boolean bl8 = false;
        int n8 = string.length();
        int n9 = 0;
        while (n9 < n8) {
            char c2 = string.charAt(n9);
            if (!(bl7 || "0#,.".indexOf(c2) == -1 && (bl3 || bl || bl6 || c2 != 'E'))) {
                if (bl) {
                    if (bl5) {
                        string4 = stringBuffer.toString();
                    } else {
                        string2 = stringBuffer.toString();
                    }
                    stringBuffer.setLength(0);
                    bl = false;
                }
                if (bl6) {
                    throw new IllegalArgumentException(Msg.getString("K0014", String.valueOf(c2), string));
                }
                stringBuffer.append(c2);
                if (c2 == 'E') {
                    bl3 = true;
                }
                if (!bl5) {
                    switch (c2) {
                        case '0': {
                            if (bl2) {
                                ++n;
                            }
                            if (bl3) {
                                ++n7;
                                break;
                            }
                            if (n5 > 0) {
                                throw new IllegalArgumentException(Msg.getString("K0015", String.valueOf(c2), string));
                            }
                            if (bl4) {
                                ++n4;
                                break;
                            }
                            ++n3;
                            break;
                        }
                        case '#': {
                            if (!bl4 && n3 > 0 || bl3) {
                                throw new IllegalArgumentException(Msg.getString("K0016", String.valueOf(c2), string));
                            }
                            if (bl2) {
                                ++n;
                            }
                            if (bl4) {
                                ++n5;
                                break;
                            }
                            ++n2;
                            break;
                        }
                        case ',': {
                            if (bl4 || bl3) {
                                throw new IllegalArgumentException(Msg.getString("K0016", String.valueOf(c2), string));
                            }
                            n = 0;
                            bl2 = true;
                            break;
                        }
                        case '.': {
                            if (bl4 || bl3) {
                                throw new IllegalArgumentException(Msg.getString("K0016", String.valueOf(c2), string));
                            }
                            bl2 = false;
                            bl4 = true;
                            break;
                        }
                        case 'E': {
                            bl2 = false;
                        }
                        default: {
                            break;
                        }
                    }
                }
            } else {
                if (!bl && !bl6) {
                    if (!bl5) {
                        string6 = stringBuffer.toString();
                    }
                    stringBuffer.setLength(0);
                }
                if (!bl) {
                    bl6 = true;
                }
                if (c2 == '\'') {
                    if (bl8) {
                        stringBuffer.append('\'');
                    }
                    bl7 = !bl7;
                    bl8 = true;
                } else {
                    bl8 = false;
                    if (c2 == ';' && !bl7) {
                        if (string6 == null || string6.length() == 0) {
                            throw new IllegalArgumentException(Msg.getString("K0017", String.valueOf(c2), string));
                        }
                        if (bl3 && n7 == 0) {
                            throw new IllegalArgumentException(Msg.getString("K0018", string));
                        }
                        string3 = stringBuffer.toString();
                        stringBuffer.setLength(0);
                        bl = true;
                        bl5 = true;
                        bl3 = false;
                        bl6 = false;
                    } else {
                        if (!(bl5 || c2 != '%' && c2 != '\u2030' || bl7)) {
                            if (n6 != 1) {
                                throw new IllegalArgumentException(Msg.getString("K0016", String.valueOf(c2), string));
                            }
                            n6 = c2 == '%' ? 100 : 1000;
                        }
                        stringBuffer.append(c2);
                    }
                }
            }
            ++n9;
        }
        if (bl7) {
            throw new IllegalArgumentException(Msg.getString("K0019", string));
        }
        if (bl2 && n == 0) {
            throw new IllegalArgumentException(Msg.getString("K001a", string));
        }
        if (!bl5 && bl3 && n7 == 0) {
            throw new IllegalArgumentException(Msg.getString("K0018", string));
        }
        if (n7 > 0 && n2 + n3 + n4 + n5 == 0) {
            throw new IllegalArgumentException(Msg.getString("K001b", string));
        }
        if (bl) {
            if (bl5) {
                string4 = stringBuffer.toString();
            } else {
                string2 = stringBuffer.toString();
            }
        }
        if (bl6) {
            if (bl5) {
                string5 = stringBuffer.toString();
            } else {
                string3 = stringBuffer.toString();
            }
        }
        n5 += n4;
        if (bl4 && n4 == 0 && n3 == 0 && n2 > 0) {
            n3 = 1;
            --n2;
        } else if (n5 > 0 && n3 + n2 == 0 && n4 == 0) {
            n4 = 1;
        }
        boolean bl9 = this.useExponentialNotation = n7 > 0;
        if (this.useExponentialNotation) {
            this.setMaximumIntegerDigits(n2 + n3);
        } else {
            this.setMaximumIntegerDigits(-129);
        }
        this.setMinimumIntegerDigits(n3);
        this.setMaximumFractionDigits(n5);
        this.setMinimumFractionDigits(n4);
        this.setGroupingSize(n);
        this.setGroupingUsed(n > 0);
        this.setPositivePrefix(string2.toString());
        this.setPositiveSuffix(string3.toString());
        this.posPrefixMonetary = this.positivePrefix.indexOf(164) > -1;
        this.posPrefixPattern = this.expandAffix(this.positivePrefix);
        this.posSuffixMonetary = this.positiveSuffix.indexOf(164) > -1;
        this.posSuffixPattern = this.expandAffix(this.positiveSuffix);
        byte by = this.minExponentDigits = (byte)(n7 > 127 ? 127 : (byte)n7);
        if (!bl5) {
            string4 = new StringBuffer(String.valueOf(this.symbols.getMinusSign())).append(string2).toString();
            string5 = string3;
        }
        this.setNegativePrefix(string4);
        this.setNegativeSuffix(string5);
        this.negPrefixMonetary = string4.indexOf(164) > -1;
        this.negPrefixPattern = this.expandAffix(string4);
        this.negSuffixMonetary = string5.indexOf(164) > -1;
        this.negSuffixPattern = this.expandAffix(string5);
        this.setDecimalSeparatorAlwaysShown(bl4 && (n3 + n2 == 0 || n4 + n5 == 0));
        this.setMultiplier(n6);
    }

    @Override
    public Object clone() {
        DecimalFormat decimalFormat = (DecimalFormat)super.clone();
        decimalFormat.symbols = (DecimalFormatSymbols)this.symbols.clone();
        return decimalFormat;
    }

    private String convertCurrencySymbols(String string) {
        StringBuffer stringBuffer = null;
        int n = 0;
        while (n < string.length()) {
            char c2 = string.charAt(n);
            if (c2 == '\u00a4') {
                if (stringBuffer == null) {
                    stringBuffer = new StringBuffer(string.substring(0, n));
                }
                if (n + 1 < string.length() && string.charAt(n + 1) == '\u00a4') {
                    ++n;
                    stringBuffer.append(this.symbols.getInternationalCurrencySymbol());
                } else {
                    stringBuffer.append(this.symbols.getCurrencySymbol());
                }
            } else if (stringBuffer != null) {
                stringBuffer.append(c2);
            }
            ++n;
        }
        if (stringBuffer == null) {
            return string;
        }
        return stringBuffer.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof DecimalFormat)) {
            return false;
        }
        DecimalFormat decimalFormat = (DecimalFormat)object;
        return super.equals(object) && this.symbols.equals(decimalFormat.symbols) && this.groupingSize == decimalFormat.groupingSize && this.multiplier == decimalFormat.multiplier && this.positivePrefix.equals(decimalFormat.positivePrefix) && this.positiveSuffix.equals(decimalFormat.positiveSuffix) && this.negativePrefix.equals(decimalFormat.negativePrefix) && this.negativeSuffix.equals(decimalFormat.negativeSuffix) && this.decimalSeparatorAlwaysShown == decimalFormat.decimalSeparatorAlwaysShown && this.isCurrency() == decimalFormat.isCurrency();
    }

    private Number error(ParsePosition parsePosition, int n) {
        parsePosition.setErrorIndex(n);
        return null;
    }

    @Override
    public AttributedCharacterIterator formatToCharacterIterator(Object object) {
        long l;
        if (!(object instanceof Number)) {
            throw new IllegalArgumentException();
        }
        StringBuffer stringBuffer = new StringBuffer();
        Vector vector = new Vector();
        double d2 = ((Number)object).doubleValue();
        if (d2 == (double)(l = ((Number)object).longValue())) {
            this.formatImpl(l, stringBuffer, new FieldPosition(0), vector);
        } else {
            this.formatImpl(d2, stringBuffer, new FieldPosition(0), vector);
        }
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
    public StringBuffer format(double d2, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        return this.formatImpl(d2, stringBuffer, fieldPosition, null);
    }

    private StringBuffer formatImpl(double d2, StringBuffer stringBuffer, FieldPosition fieldPosition, Vector vector) {
        if (this.multiplier != 1) {
            d2 *= (double)this.multiplier;
        }
        fieldPosition.clear();
        if (Double.isNaN((double)d2)) {
            return stringBuffer.append(this.symbols.getNaN());
        }
        long l = Double.doubleToLongBits((double)d2);
        String string = l < 0L ? this.getNegativePrefix() : this.getPositivePrefix();
        this.formatPrefixSuffix(string, stringBuffer, fieldPosition, vector);
        FieldPosition fieldPosition2 = null;
        fieldPosition2 = new FieldPosition(NumberFormat$Field.INTEGER);
        this.handleIntegerBegin(stringBuffer.length(), fieldPosition, vector, fieldPosition2);
        if (Double.isInfinite((double)d2)) {
            stringBuffer.append(this.symbols.getInfinity());
            this.handleIntegerEnd(stringBuffer.length(), fieldPosition, vector, fieldPosition2);
        } else {
            int n;
            long l2;
            int n2;
            double d3 = d2 == 0.0 ? 0.0 : (d2 < 0.0 ? -d2 : d2);
            boolean bl = false;
            int n3 = 0;
            int n4 = 0;
            int n5 = 0;
            int n6 = 0;
            if (this.useExponentialNotation) {
                n4 = this.scale(d3);
                n5 = this.getMinimumIntegerDigits() + this.getMinimumFractionDigits();
                boolean bl2 = bl = this.getMinimumIntegerDigits() == this.getMaximumIntegerDigits();
                if (bl) {
                    n5 -= this.getMinimumIntegerDigits();
                    n3 = this.getMinimumIntegerDigits() - 1;
                    if (d2 != 0.0) {
                        n4 -= n3;
                    }
                } else {
                    n3 = n4 % this.getMaximumIntegerDigits();
                    if (n4 < -1 && n3 + this.getMaximumIntegerDigits() < this.getMaximumIntegerDigits()) {
                        n3 += this.getMaximumIntegerDigits();
                    }
                    if (this.getMinimumIntegerDigits() == 0) {
                        --n3;
                    }
                    if (d2 != 0.0) {
                        n4 -= n3;
                    }
                    if (n3 >= 0) {
                        n5 -= n3 + 1;
                    }
                }
                if (n4 != 0) {
                    d3 /= Math.pow(10.0, n4);
                }
                n6 = this.getMaximumIntegerDigits() + this.getMaximumFractionDigits();
                if (n3 >= 0) {
                    n6 -= n3 + 1;
                }
            } else {
                n3 = this.scale(d3);
                n5 = this.getMinimumFractionDigits();
                n6 = this.getMaximumFractionDigits();
            }
            if (-n6 - 1 >= n3 - 16) {
                d3 += Math.pow(10.0, -n6 - 1) * 5.0;
            }
            if ((n2 = this.scale(d3)) > n3) {
                if (this.useExponentialNotation) {
                    if (bl || this.getMinimumIntegerDigits() == 0) {
                        d3 /= 10.0;
                        ++n4;
                    } else if (n3 + 1 == this.getMaximumIntegerDigits() || n4 + this.getMaximumIntegerDigits() == 0 && n3 + 2 == this.getMaximumIntegerDigits()) {
                        d3 /= Math.pow(10.0, this.getMaximumIntegerDigits());
                        int n7 = (n4 += this.getMaximumIntegerDigits()) == 0 ? -1 : 0;
                        n5 += n3 - n7;
                        n6 += n3 - n7;
                        n3 = n7;
                    } else {
                        ++n3;
                        --n5;
                        --n6;
                    }
                } else {
                    n3 = n2;
                }
            }
            int n8 = 0;
            String string2 = Double.toString((double)d3);
            int n9 = string2.lastIndexOf(69);
            if (n9 > -1) {
                n8 = Integer.parseInt(string2.substring(n9 + 1));
            } else {
                n9 = string2.length();
            }
            int n10 = string2.indexOf(46);
            if (n10 > -1) {
                String string3 = string2.substring(n10 + 1, n9);
                String string4 = string2.substring(0, n10);
                if (string3.equals("0")) {
                    string2 = string4;
                    n9 -= 2;
                } else {
                    n8 -= string3.length();
                    if (string4.equals("0")) {
                        int n11 = 0;
                        while (string3.charAt(n11) == '0') {
                            ++n11;
                        }
                        string2 = string3.substring(n11);
                        n9 -= n11 + 2;
                    } else {
                        string2 = new StringBuffer(String.valueOf(string4)).append(string3).toString();
                        --n9;
                    }
                }
            } else {
                string2 = string2.substring(0, n9);
            }
            long l3 = Long.parseLong(string2);
            int n12 = n9;
            long l4 = l3;
            if (n8 < 0) {
                if (-n8 < n9) {
                    n12 = n9 + n8;
                    l2 = this.intPow(-n8);
                    l3 -= (l4 /= l2) * l2;
                    n9 = -n8;
                } else {
                    l4 = 0L;
                    n12 = 1;
                }
            } else {
                n12 += n8;
                l3 = 0L;
                n9 = 0;
            }
            if (n6 != 0 && n6 < n9) {
                l2 = this.intPow(n9 - n6);
                l3 /= l2;
                n8 += n9 - n6;
                n9 = n6;
            }
            int n13 = stringBuffer.length();
            StringBuffer stringBuffer2 = new StringBuffer();
            if (n3 < 0 && !this.useExponentialNotation) {
                this.formatInteger("0", stringBuffer, fieldPosition, vector);
            } else {
                stringBuffer2.append(Long.toString(l4));
                n = stringBuffer2.length();
                while (n < n12) {
                    stringBuffer2.append('0');
                    ++n;
                }
                if (this.useExponentialNotation) {
                    n = 0;
                    while (n <= n3) {
                        if (n >= stringBuffer2.length()) {
                            stringBuffer.append(this.zero);
                        } else {
                            stringBuffer.append((char)(this.zero + (stringBuffer2.charAt(n) - 48)));
                        }
                        ++n;
                    }
                } else {
                    this.formatInteger(stringBuffer2.toString(), stringBuffer, fieldPosition, vector);
                }
            }
            if (n6 == 0) {
                if (n13 == stringBuffer.length()) {
                    stringBuffer.append(this.zero);
                }
                this.handleIntegerEnd(stringBuffer.length(), fieldPosition, vector, fieldPosition2);
                this.formatFraction(new StringBuffer(), stringBuffer, fieldPosition, vector);
            } else {
                stringBuffer2.setLength(0);
                n = 0;
                int n14 = -n8 - n9;
                if (l3 > 0L && n6 > n14) {
                    String string5 = Long.toString(l3);
                    if (n9 > string5.length()) {
                        n14 += n9 - string5.length();
                    }
                    int n15 = 0;
                    while (n15 < n14) {
                        stringBuffer2.append(this.zero);
                        ++n15;
                    }
                    n15 = n14;
                    while (n15 < n6) {
                        int n16 = n15 - n14 >= string5.length() ? 0 : string5.charAt(n15 - n14) - 48;
                        stringBuffer2.append((char)(this.zero + n16));
                        if (n16 > 0) {
                            n = stringBuffer2.length();
                        }
                        ++n15;
                    }
                }
                if (stringBuffer2.length() < n5) {
                    int n17 = stringBuffer2.length();
                    while (n17 < n5) {
                        stringBuffer2.append(this.zero);
                        ++n17;
                    }
                } else {
                    stringBuffer2.setLength(n < n5 ? n5 : n);
                }
                if (stringBuffer2.length() == 0 && n13 == stringBuffer.length()) {
                    stringBuffer.append(this.zero);
                }
                this.handleIntegerEnd(stringBuffer.length(), fieldPosition, vector, fieldPosition2);
                this.formatFraction(stringBuffer2, stringBuffer, fieldPosition, vector);
            }
            if (this.useExponentialNotation) {
                this.formatExponent(n4, stringBuffer, fieldPosition, vector);
            }
        }
        String string6 = l < 0L ? this.getNegativeSuffix() : this.getPositiveSuffix();
        this.formatPrefixSuffix(string6, stringBuffer, fieldPosition, vector);
        return stringBuffer;
    }

    @Override
    public StringBuffer format(long l, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        return this.formatImpl(l, stringBuffer, fieldPosition, (Vector)null);
    }

    private StringBuffer formatImpl(long l, StringBuffer stringBuffer, FieldPosition fieldPosition, Vector vector) {
        CharSequence charSequence;
        int n;
        int n2;
        int n3;
        if (this.multiplier != 1) {
            int n4 = 1;
            if (l < 0L) {
                n4 *= -1;
            }
            if (this.multiplier < 0) {
                n4 *= -1;
            }
            long l2 = l;
            if (n4 > 0 && l2 >= (l *= (long)this.multiplier) || n4 < 0 && l2 <= l) {
                return this.formatImpl((double)l2, stringBuffer, fieldPosition, vector);
            }
            double d2 = (double)l * (double)this.multiplier;
            if (d2 > 9.223372036854776E18 || d2 < -9.223372036854776E18) {
                return this.formatImpl((double)l, stringBuffer, fieldPosition, vector);
            }
        }
        String string = l < 0L ? this.getNegativePrefix() : this.getPositivePrefix();
        this.formatPrefixSuffix(string, stringBuffer, fieldPosition, vector);
        FieldPosition fieldPosition2 = null;
        fieldPosition2 = new FieldPosition(NumberFormat$Field.INTEGER);
        this.handleIntegerBegin(stringBuffer.length(), fieldPosition, vector, fieldPosition2);
        int n5 = stringBuffer.length();
        String string2 = Long.toString(l);
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        if (this.useExponentialNotation) {
            if (l < 0L) {
                string2 = string2.substring(1, string2.length());
            }
            int n9 = string2.length();
            n8 = this.getMinimumIntegerDigits() + this.getMinimumFractionDigits();
            n6 = n9 - 1;
            int n10 = n3 = this.getMinimumIntegerDigits() == this.getMaximumIntegerDigits() ? 1 : 0;
            if (n3 != 0) {
                n8 -= this.getMinimumIntegerDigits();
                n7 = this.getMinimumIntegerDigits() - 1;
                if (l != 0L) {
                    n6 -= n7;
                }
                ++n7;
            } else {
                n7 = n6 % this.getMaximumIntegerDigits();
                if (l != 0L) {
                    n6 -= n7;
                }
                if (this.getMinimumIntegerDigits() > 0) {
                    ++n7;
                } else if (l != 0L) {
                    ++n6;
                }
                n8 -= n7;
            }
            if (this.getMaximumIntegerDigits() + this.getMaximumFractionDigits() < n9) {
                n = n2 = n9 - (this.getMaximumIntegerDigits() + this.getMaximumFractionDigits()) - 1;
                while (--n >= 0) {
                    l /= 0;
                }
                l = l < 0L ? (l -= 0) : (l += 0);
                string2 = Long.toString(l);
                if (l < 0L) {
                    string2 = string2.substring(1, string2.length());
                }
                n = 1;
                if (string2.length() > n9 - n2) {
                    if (n3 != 0 || this.getMinimumIntegerDigits() == 0) {
                        ++n;
                        ++n6;
                    } else if (n7 == this.getMaximumIntegerDigits()) {
                        n6 += this.getMaximumIntegerDigits();
                        n += this.getMaximumIntegerDigits();
                        n8 += n7 - 1;
                        n7 = 1;
                    } else {
                        ++n7;
                        --n8;
                    }
                }
                string2 = string2.substring(0, string2.length() - n);
            }
            n2 = 0;
            while (n2 < n7) {
                if (n2 >= string2.length()) {
                    stringBuffer.append(this.zero);
                } else {
                    stringBuffer.append((char)(this.zero + (string2.charAt(n2) - 48)));
                }
                ++n2;
            }
        } else {
            this.formatInteger(string2, stringBuffer, fieldPosition, vector);
        }
        if (!this.useExponentialNotation && n5 == stringBuffer.length()) {
            stringBuffer.append(this.zero);
        }
        this.handleIntegerEnd(stringBuffer.length(), fieldPosition, vector, fieldPosition2);
        if (this.useExponentialNotation) {
            charSequence = new StringBuffer();
            n3 = 0;
            n2 = 0;
            while (n2 < string2.length() - n7) {
                n = string2.charAt(n7 + n2) - 48;
                if (n > 0) {
                    n3 = n2 + 1;
                }
                charSequence.append((char)(this.zero + n));
                ++n2;
            }
            n2 = charSequence.length();
            while (n2 < n8) {
                charSequence.append(this.zero);
                ++n2;
            }
            charSequence.setLength(n3 < n8 ? n8 : n3);
            this.formatFraction((StringBuffer)charSequence, stringBuffer, fieldPosition, vector);
        } else {
            charSequence = new StringBuffer();
            n3 = 0;
            while (n3 < this.getMinimumFractionDigits()) {
                charSequence.append(this.zero);
                ++n3;
            }
            this.formatFraction((StringBuffer)charSequence, stringBuffer, fieldPosition, vector);
        }
        if (this.useExponentialNotation) {
            this.formatExponent(n6, stringBuffer, fieldPosition, vector);
        }
        charSequence = l < 0L ? this.getNegativeSuffix() : this.getPositiveSuffix();
        this.formatPrefixSuffix((String)charSequence, stringBuffer, fieldPosition, vector);
        return stringBuffer;
    }

    private void formatPrefixSuffix(String string, StringBuffer stringBuffer, FieldPosition fieldPosition, Vector vector) {
        int n = stringBuffer.length();
        stringBuffer.append(string);
        if (string.length() > 0) {
            DecimalFormatSymbols decimalFormatSymbols = this.getDecimalFormatSymbols();
            String string2 = decimalFormatSymbols.getCurrencySymbol();
            int n2 = string.indexOf(string2);
            if (n2 > -1) {
                this.handleField(NumberFormat$Field.CURRENCY, n + n2, n + n2 + string2.length(), fieldPosition, vector);
            }
            if ((n2 = string.indexOf(decimalFormatSymbols.getMinusSign())) > -1) {
                this.handleField(NumberFormat$Field.SIGN, n + n2, n + n2 + 1, fieldPosition, vector);
            }
            if ((n2 = string.indexOf(decimalFormatSymbols.getPercent())) > -1) {
                this.handleField(NumberFormat$Field.PERCENT, n + n2, n + n2 + 1, fieldPosition, vector);
            }
            if ((n2 = string.indexOf(decimalFormatSymbols.getPerMill())) > -1) {
                this.handleField(NumberFormat$Field.PERMILLE, n + n2, n + n2 + 1, fieldPosition, vector);
            }
        }
    }

    private void formatInteger(String string, StringBuffer stringBuffer, FieldPosition fieldPosition, Vector vector) {
        int n;
        int n2;
        int n3 = 0;
        int n4 = string.length();
        if (string.charAt(0) == '-') {
            n3 = 1;
            --n4;
        }
        boolean bl = false;
        int n5 = this.getGroupingSize();
        if (!this.isGroupingUsed()) {
            n5 = 0;
        }
        if (this.getMinimumIntegerDigits() > n4) {
            n2 = this.getMinimumIntegerDigits() - n4;
            n4 = this.getMinimumIntegerDigits();
            n = 0;
            while (n < n2) {
                stringBuffer.append(this.zero);
                if (n5 > 0 && --n4 > 0 && n4 % n5 == 0) {
                    stringBuffer.append(this.symbols.getGroupingSeparator());
                    int n6 = stringBuffer.length();
                    if (vector != null) {
                        this.addToFields(vector, NumberFormat$Field.GROUPING_SEPARATOR, n6 - 1, n6);
                    } else if (!bl && fieldPosition.getFieldAttribute() == NumberFormat$Field.GROUPING_SEPARATOR) {
                        fieldPosition.setBeginIndex(n6 - 1);
                        fieldPosition.setEndIndex(n6);
                        bl = true;
                    }
                }
                ++n;
            }
        }
        if (n4 > this.getMaximumIntegerDigits()) {
            n3 += n4 - this.getMaximumIntegerDigits();
            n4 = this.getMaximumIntegerDigits();
        }
        if (this.getMinimumIntegerDigits() == 0 && n4 == 1 && string.charAt(n3) == '0') {
            return;
        }
        n2 = n3;
        while (n2 < string.length()) {
            stringBuffer.append((char)(this.zero + (string.charAt(n2) - 48)));
            if (n5 > 0 && --n4 > 0 && n4 % n5 == 0) {
                stringBuffer.append(this.symbols.getGroupingSeparator());
                n = stringBuffer.length();
                if (vector != null) {
                    this.addToFields(vector, NumberFormat$Field.GROUPING_SEPARATOR, n - 1, n);
                } else if (!bl && fieldPosition.getFieldAttribute() == NumberFormat$Field.GROUPING_SEPARATOR) {
                    fieldPosition.setBeginIndex(n - 1);
                    fieldPosition.setEndIndex(n);
                    bl = true;
                }
            }
            ++n2;
        }
    }

    private void formatFraction(StringBuffer stringBuffer, StringBuffer stringBuffer2, FieldPosition fieldPosition, Vector vector) {
        int n;
        int n2 = stringBuffer.length();
        if (this.isDecimalSeparatorAlwaysShown() || n2 > 0) {
            stringBuffer2.append(this.getDecimalSeparator());
            n = stringBuffer2.length();
            this.handleField(NumberFormat$Field.DECIMAL_SEPARATOR, n - 1, n, fieldPosition, vector);
        }
        if (n2 > 0) {
            stringBuffer2.append(stringBuffer);
            n = stringBuffer2.length();
            if (vector != null) {
                this.addToFields(vector, NumberFormat$Field.FRACTION, n - n2, n);
            } else if (fieldPosition.getFieldAttribute() == NumberFormat$Field.FRACTION || fieldPosition.getFieldAttribute() == null && fieldPosition.getField() == 1) {
                fieldPosition.setBeginIndex(n - n2);
                fieldPosition.setEndIndex(n);
            }
        }
    }

    private void formatExponent(int n, StringBuffer stringBuffer, FieldPosition fieldPosition, Vector vector) {
        int n2;
        int n3;
        String string = Integer.toString(n);
        int n4 = 0;
        int n5 = string.length();
        stringBuffer.append(this.symbols.getExponential());
        int n6 = stringBuffer.length();
        this.handleField(NumberFormat$Field.EXPONENT_SYMBOL, n6 - 1, n6, fieldPosition, vector);
        if (n < 0) {
            stringBuffer.append(this.getNegativePrefix());
            n4 = 1;
            --n5;
        } else {
            stringBuffer.append(this.getPositivePrefix());
        }
        int n7 = n3 = n < 0 ? this.getNegativePrefix().length() : this.getPositivePrefix().length();
        if (n3 > 0) {
            n6 = stringBuffer.length();
            this.handleField(NumberFormat$Field.EXPONENT_SIGN, n6 - n3, n6, fieldPosition, vector);
        }
        if (this.minExponentDigits > n5) {
            n2 = this.minExponentDigits - n5;
            while (--n2 >= 0) {
                stringBuffer.append(this.zero);
            }
        }
        n2 = n4;
        while (n2 < string.length()) {
            stringBuffer.append((char)(this.zero + (string.charAt(n2) - 48)));
            ++n2;
        }
        this.handleField(NumberFormat$Field.EXPONENT, n6, stringBuffer.length(), fieldPosition, vector);
        if (n < 0) {
            stringBuffer.append(this.getNegativeSuffix());
        } else {
            stringBuffer.append(this.getPositiveSuffix());
        }
        int n8 = n2 = n < 0 ? this.getNegativeSuffix().length() : this.getPositiveSuffix().length();
        if (n2 > 0) {
            n6 = stringBuffer.length();
            this.handleField(NumberFormat$Field.EXPONENT_SIGN, n6 - n2, n6, fieldPosition, vector);
        }
    }

    private void handleField(NumberFormat$Field numberFormat$Field, int n, int n2, FieldPosition fieldPosition, Vector vector) {
        if (vector != null) {
            this.addToFields(vector, numberFormat$Field, n, n2);
        } else if (fieldPosition.getFieldAttribute() == numberFormat$Field) {
            fieldPosition.setBeginIndex(n);
            fieldPosition.setEndIndex(n2);
        }
    }

    private void addToFields(Vector vector, NumberFormat$Field numberFormat$Field, int n, int n2) {
        FieldPosition fieldPosition = new FieldPosition(numberFormat$Field);
        fieldPosition.setBeginIndex(n);
        fieldPosition.setEndIndex(n2);
        vector.add(fieldPosition);
    }

    private void handleIntegerBegin(int n, FieldPosition fieldPosition, Vector vector, FieldPosition fieldPosition2) {
        if (vector != null) {
            fieldPosition2.setBeginIndex(n);
        } else if (fieldPosition.getFieldAttribute() == NumberFormat$Field.INTEGER || fieldPosition.getFieldAttribute() == null && fieldPosition.getField() == 0) {
            fieldPosition.setBeginIndex(n);
        }
    }

    private void handleIntegerEnd(int n, FieldPosition fieldPosition, Vector vector, FieldPosition fieldPosition2) {
        if (vector != null) {
            fieldPosition2.setEndIndex(n);
            vector.add(fieldPosition2);
        } else if (fieldPosition.getFieldAttribute() == NumberFormat$Field.INTEGER || fieldPosition.getFieldAttribute() == null && fieldPosition.getField() == 0) {
            fieldPosition.setEndIndex(n);
        }
    }

    public DecimalFormatSymbols getDecimalFormatSymbols() {
        return (DecimalFormatSymbols)this.symbols.clone();
    }

    private char getDecimalSeparator() {
        if (this.isCurrency()) {
            return this.symbols.getMonetaryDecimalSeparator();
        }
        return this.symbols.getDecimalSeparator();
    }

    @Override
    public Currency getCurrency() {
        return this.symbols.getCurrency();
    }

    public int getGroupingSize() {
        return this.groupingSize;
    }

    public int getMultiplier() {
        return this.multiplier;
    }

    public String getNegativePrefix() {
        return this.negPrefixPattern == null ? this.negativePrefix : this.negPrefixPattern;
    }

    public String getNegativeSuffix() {
        return this.negSuffixPattern == null ? this.negativeSuffix : this.negSuffixPattern;
    }

    public String getPositivePrefix() {
        return this.posPrefixPattern == null ? this.positivePrefix : this.posPrefixPattern;
    }

    public String getPositiveSuffix() {
        return this.posSuffixPattern == null ? this.positiveSuffix : this.posSuffixPattern;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + this.symbols.hashCode() + this.groupingSize + this.multiplier + this.positivePrefix.hashCode() + this.positiveSuffix.hashCode() + this.negativePrefix.hashCode() + this.negativeSuffix.hashCode() + (this.decimalSeparatorAlwaysShown ? 1231 : 1237) + (this.isCurrency() ? 1231 : 1237);
    }

    private boolean isCurrency() {
        return this.posPrefixMonetary || this.posSuffixMonetary || this.negPrefixMonetary || this.negSuffixMonetary;
    }

    public boolean isDecimalSeparatorAlwaysShown() {
        return this.decimalSeparatorAlwaysShown;
    }

    private int parseExponent(String string, ParsePosition parsePosition) {
        String string2;
        String string3;
        int n = 0;
        int n2 = parsePosition.getIndex();
        parsePosition.setIndex(-1);
        String string4 = this.posPrefixPattern != null ? this.posPrefixPattern : this.positivePrefix;
        String string5 = string3 = this.negPrefixPattern != null ? this.negPrefixPattern : this.negativePrefix;
        if (string4.length() != 0 && string.startsWith(string4, n2)) {
            n = 1;
            n2 += string4.length();
        } else if (string3.length() != 0 && string.startsWith(string3, n2)) {
            n = -1;
            n2 += string3.length();
        } else if (string4.length() != 0 && string3.length() != 0) {
            return 0;
        }
        boolean bl = false;
        int n3 = 0;
        int n4 = n2;
        int n5 = string.length();
        while (n2 < n5) {
            char c2 = string.charAt(n2);
            int n6 = this.getDigit(c2);
            if (n6 == -1) break;
            int n7 = n3 * 10 - n6;
            if (n7 > n3) {
                bl = true;
            }
            n3 = n7;
            ++n2;
        }
        if (n2 == n4) {
            return 0;
        }
        String string6 = this.posSuffixPattern != null ? this.posSuffixPattern : this.positiveSuffix;
        String string7 = string2 = this.negSuffixPattern != null ? this.negSuffixPattern : this.negativeSuffix;
        if (n >= 0) {
            if (string6.length() == 0) {
                parsePosition.setIndex(n2);
                n = 1;
            } else if (string.startsWith(string6, n2)) {
                parsePosition.setIndex(n2 + string6.length());
                n = 1;
            } else if (n == 1) {
                return 0;
            }
        }
        if (n <= 0) {
            if (string2.length() == 0) {
                parsePosition.setIndex(n2);
                n = -1;
            } else if (string.startsWith(string2, n2)) {
                parsePosition.setIndex(n2 + string2.length());
                n = -1;
            } else {
                return 0;
            }
        }
        if (n != -1 && (n3 = -n3) < 0) {
            bl = true;
        }
        if (bl) {
            return 1024;
        }
        return n3;
    }

    @Override
    public Number parse(String string, ParsePosition parsePosition) {
        String string2;
        int n = parsePosition.getIndex();
        if (n < 0) {
            return this.error(parsePosition, n);
        }
        if (string.startsWith(this.symbols.getNaN(), n)) {
            parsePosition.setIndex(n + this.symbols.getNaN().length());
            return new Double(Double.NaN);
        }
        int n2 = 0;
        String string3 = this.posPrefixPattern != null ? this.posPrefixPattern : this.positivePrefix;
        String string4 = this.negPrefixPattern != null ? this.negPrefixPattern : this.negativePrefix;
        boolean bl = string.startsWith(string3, n);
        if (string3.equals(string4)) {
            if (!bl) {
                return this.error(parsePosition, n);
            }
            n += string3.length();
        } else {
            boolean bl2 = string.startsWith(string4, n);
            if (bl || bl2) {
                if (bl && bl2) {
                    if (string4.length() > string3.length()) {
                        bl = false;
                    } else {
                        bl2 = false;
                    }
                }
                if (bl) {
                    n2 = 1;
                    n += string3.length();
                } else if (bl2) {
                    n2 = -1;
                    n += string4.length();
                }
            } else {
                return this.error(parsePosition, n);
            }
        }
        double d2 = 0.0;
        long l = -922337203685477580L;
        boolean bl3 = false;
        boolean bl4 = false;
        long l2 = 0L;
        long l3 = 0L;
        int n3 = string.length();
        int n4 = -1;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        if (string.startsWith(this.symbols.getInfinity(), n)) {
            n4 = n += this.symbols.getInfinity().length();
            d2 = Double.POSITIVE_INFINITY;
        } else {
            boolean bl5 = false;
            while (n < n3) {
                char c2 = string.charAt(n);
                if (c2 == this.getDecimalSeparator()) {
                    if (this.isParseIntegerOnly()) break;
                    n4 = ++n;
                    StringBuffer stringBuffer = new StringBuffer();
                    while (n < n3) {
                        c2 = string.charAt(n);
                        if (this.getDigit(c2) == -1) break;
                        stringBuffer.append(c2);
                        n4 = ++n;
                    }
                    int n8 = stringBuffer.length() - 1;
                    while (n8 >= 0 && this.getDigit(stringBuffer.charAt(n8)) == 0) {
                        bl5 = true;
                        --n8;
                    }
                    int n9 = 0;
                    while (n9 <= n8) {
                        bl5 = true;
                        int n10 = this.getDigit(stringBuffer.charAt(n9));
                        if (!bl3) {
                            if (l > l3) {
                                bl3 = true;
                                break;
                            }
                            long l4 = l3 * 0 - (long)n10;
                            if (l4 <= l3) {
                                l3 = l4;
                                ++n6;
                            } else {
                                bl3 = true;
                                break;
                            }
                        }
                        ++n9;
                    }
                    if (c2 != this.symbols.getExponential()) break;
                    ParsePosition parsePosition2 = new ParsePosition(n + 1);
                    n7 = this.parseExponent(string, parsePosition2);
                    if (parsePosition2.getIndex() == -1) break;
                    n4 = parsePosition2.getIndex();
                    break;
                }
                int n11 = this.getDigit(c2);
                if (n11 != -1) {
                    bl5 = true;
                    if (l2 != 0L || n11 > 0) {
                        ++n5;
                        if (bl4) {
                            d2 = d2 * 10.0 - (double)n11;
                        } else if (l <= l2) {
                            long l5 = l2 * 0 - (long)n11;
                            if (l5 > l2) {
                                d2 = (double)l2 * 10.0 - (double)n11;
                                bl4 = true;
                            } else {
                                l2 = l5;
                            }
                        } else {
                            d2 = (double)l2 * 10.0 - (double)n11;
                            bl4 = true;
                        }
                    }
                    n4 = n + 1;
                } else {
                    if (c2 == this.symbols.getExponential()) {
                        ParsePosition parsePosition3 = new ParsePosition(n + 1);
                        n7 = this.parseExponent(string, parsePosition3);
                        if (parsePosition3.getIndex() == -1) break;
                        n4 = parsePosition3.getIndex();
                        break;
                    }
                    if (c2 != this.symbols.getGroupingSeparator() || !this.isGroupingUsed()) break;
                }
                ++n;
            }
            if (!bl5) {
                return this.error(parsePosition, parsePosition.getIndex());
            }
        }
        String string5 = this.posSuffixPattern != null ? this.posSuffixPattern : this.positiveSuffix;
        String string6 = string2 = this.negSuffixPattern != null ? this.negSuffixPattern : this.negativeSuffix;
        if (n2 == 0) {
            boolean bl6;
            boolean bl7 = string5.length() > 0 && string.startsWith(string5, n);
            boolean bl8 = bl6 = string2.length() > 0 && string.startsWith(string2, n);
            if (bl7 != bl6) {
                n2 = bl7 ? 1 : -1;
            } else if (string5.equals(string2)) {
                return this.error(parsePosition, n4);
            }
        }
        if (n2 >= 0) {
            if (string5.length() == 0) {
                parsePosition.setIndex(n4);
                n2 = 1;
            } else if (n == n4 && string.startsWith(string5, n)) {
                parsePosition.setIndex(n + string5.length());
                n2 = 1;
            } else if (n2 == 1) {
                return this.error(parsePosition, n4);
            }
        }
        if (n2 <= 0) {
            if (string2.length() == 0) {
                parsePosition.setIndex(n4);
                n2 = -1;
            } else if (n == n4 && string.startsWith(string2, n)) {
                parsePosition.setIndex(n + string2.length());
                n2 = -1;
            } else {
                return this.error(parsePosition, n4);
            }
        }
        if (!bl4 && (l3 != 0L && n7 == 0 || n7 < 0 || n7 + n5 - 1 > 19 || n7 < n6 || bl3)) {
            d2 = l2;
            bl4 = true;
        }
        if (!bl4 && l2 != 0L) {
            long l6 = l2;
            int n12 = n7;
            while (--n12 >= 0) {
                if (l > l6) {
                    d2 = l2;
                    bl4 = true;
                    break;
                }
                l6 *= 0;
            }
            l2 = l6;
        }
        if (l3 != 0L && !bl4) {
            long l7 = l3;
            int n13 = n7 - n6;
            while (--n13 >= 0) {
                l7 *= 0;
            }
            long l8 = l2 + l7;
            if (l7 < l2) {
                l2 = l8;
            } else {
                d2 = l2;
                n7 = 0;
                l3 = l7;
                n6 = 0;
                bl4 = true;
            }
        }
        if (bl4) {
            if (l3 != 0L) {
                d2 += (double)l3 / Math.pow(10.0, n6);
            }
            if (n7 != 0) {
                d2 *= Math.pow(10.0, n7);
            }
        }
        if (!bl4 && l2 == 0L && n2 == -1 && !this.isParseIntegerOnly()) {
            d2 = -0.0;
            bl4 = true;
        }
        if (this.multiplier != 1) {
            if (d2 != 0.0) {
                d2 /= (double)this.multiplier;
            } else {
                double d3 = (double)l2 / (double)this.multiplier;
                long l9 = l2 % (long)this.multiplier;
                long l10 = l2 / (long)this.multiplier + Math.round((double)l9 / (double)this.multiplier);
                if (d3 == (double)l10) {
                    l2 = l10;
                } else {
                    d2 = d3;
                    bl4 = true;
                }
            }
        }
        if (l2 == Long.MIN_VALUE && n2 == 1) {
            d2 = l2;
            bl4 = true;
        }
        if (bl4) {
            return new Double(n2 < 0 ? d2 : -d2);
        }
        return new Long(n2 < 0 ? l2 : -l2);
    }

    private String quote(String string, String string2) {
        int n = 0;
        while (n < string2.length()) {
            char c2 = string2.charAt(n);
            if (string.indexOf(c2) != -1 && (n < 5 || c2 != "0#.,;%\u2030E".charAt(n))) {
                return new StringBuffer(String.valueOf('\'')).append(string).append('\'').toString();
            }
            ++n;
        }
        return string;
    }

    private int scale(double d2) {
        if (d2 == 0.0) {
            return 0;
        }
        int n = (int)Math.floor(Math.log(d2) / log10);
        return Math.pow(10.0, n) > d2 ? n - 1 : n;
    }

    private String expandAffix(String string) {
        String string2 = this.convertPattern(string, "0#.,;%\u2030E", new String(this.symbols.patternChars), false);
        return this.convertCurrencySymbols(string2);
    }

    public void setDecimalFormatSymbols(DecimalFormatSymbols decimalFormatSymbols) {
        if (decimalFormatSymbols != null) {
            this.symbols = (DecimalFormatSymbols)decimalFormatSymbols.clone();
            this.zero = this.symbols.getZeroDigit();
            if (this.posPrefixPattern != null) {
                this.posPrefixPattern = this.expandAffix(this.positivePrefix);
            }
            if (this.posSuffixPattern != null) {
                this.posSuffixPattern = this.expandAffix(this.positiveSuffix);
            }
            if (this.negPrefixPattern != null) {
                this.negPrefixPattern = this.expandAffix(this.negativePrefix);
            }
            if (this.negSuffixPattern != null) {
                this.negSuffixPattern = this.expandAffix(this.negativeSuffix);
            }
        }
    }

    @Override
    public void setCurrency(Currency currency) {
        this.symbols.setCurrency(currency);
    }

    public void setDecimalSeparatorAlwaysShown(boolean bl) {
        this.decimalSeparatorAlwaysShown = bl;
    }

    public void setGroupingSize(int n) {
        this.groupingSize = (byte)n;
    }

    @Override
    public void setMaximumFractionDigits(int n) {
        super.setMaximumFractionDigits(n > 340 ? 340 : n);
    }

    @Override
    public void setMaximumIntegerDigits(int n) {
        super.setMaximumIntegerDigits(n > 309 ? 309 : n);
    }

    @Override
    public void setMinimumFractionDigits(int n) {
        super.setMinimumFractionDigits(n > 340 ? 340 : n);
    }

    @Override
    public void setMinimumIntegerDigits(int n) {
        super.setMinimumIntegerDigits(n > 309 ? 309 : n);
    }

    public void setMultiplier(int n) {
        this.multiplier = n;
    }

    public void setNegativePrefix(String string) {
        this.negativePrefix = string;
        this.negPrefixMonetary = false;
        this.negPrefixPattern = null;
    }

    public void setNegativeSuffix(String string) {
        this.negativeSuffix = string;
        this.negSuffixMonetary = false;
        this.negSuffixPattern = null;
    }

    public void setPositivePrefix(String string) {
        this.positivePrefix = string;
        this.posPrefixMonetary = false;
        this.posPrefixPattern = null;
    }

    public void setPositiveSuffix(String string) {
        this.positiveSuffix = string;
        this.posSuffixMonetary = false;
        this.posSuffixPattern = null;
    }

    public String toLocalizedPattern() {
        return this.toPatternString(this.symbols.getLocalPatternChars());
    }

    public String toPattern() {
        return this.toPatternString("0#.,;%\u2030E");
    }

    private String toPatternString(String string) {
        int n;
        boolean bl;
        StringBuffer stringBuffer = new StringBuffer();
        boolean bl2 = bl = this.isGroupingUsed() && this.getGroupingSize() > 0;
        if (!bl || this.groupingSize > this.getMinimumIntegerDigits()) {
            if (bl) {
                if (this.useExponentialNotation) {
                    n = 0;
                    while (n < this.getMaximumIntegerDigits() - this.groupingSize - 1) {
                        stringBuffer.append('#');
                        ++n;
                    }
                }
                stringBuffer.append("#,");
                n = 0;
                while (n < this.groupingSize - this.getMinimumIntegerDigits()) {
                    stringBuffer.append('#');
                    ++n;
                }
            } else if (this.useExponentialNotation) {
                n = 0;
                while (n < this.getMaximumIntegerDigits() - this.getMinimumIntegerDigits()) {
                    stringBuffer.append('#');
                    ++n;
                }
            } else {
                stringBuffer.append('#');
            }
            n = 0;
            while (n < this.getMinimumIntegerDigits()) {
                stringBuffer.append('0');
                ++n;
            }
        } else {
            if (this.useExponentialNotation) {
                n = 0;
                while (n < this.getMaximumIntegerDigits() - this.getMinimumIntegerDigits()) {
                    stringBuffer.append('#');
                    ++n;
                }
            } else {
                stringBuffer.append('#');
            }
            n = 0;
            while (n < this.getMinimumIntegerDigits() - this.groupingSize) {
                stringBuffer.append('0');
                ++n;
            }
            stringBuffer.append(',');
            n = 0;
            while (n < this.groupingSize) {
                stringBuffer.append('0');
                ++n;
            }
        }
        if (this.getMaximumFractionDigits() > 0 || this.isDecimalSeparatorAlwaysShown()) {
            stringBuffer.append('.');
            n = 0;
            while (n < this.getMinimumFractionDigits()) {
                stringBuffer.append('0');
                ++n;
            }
            n = 0;
            while (n < this.getMaximumFractionDigits() - this.getMinimumFractionDigits()) {
                stringBuffer.append('#');
                ++n;
            }
        }
        if (this.useExponentialNotation) {
            stringBuffer.append('E');
            n = 0;
            while (n < this.minExponentDigits) {
                stringBuffer.append('0');
                ++n;
            }
        }
        String string2 = stringBuffer.toString();
        String string3 = new StringBuffer(String.valueOf(this.quote(this.positivePrefix, string))).append(string2).append(this.quote(this.positiveSuffix, string)).toString();
        if (!this.negativePrefix.equals(new StringBuffer(String.valueOf(this.symbols.getMinusSign())).append(this.positivePrefix).toString()) || !this.negativeSuffix.equals(this.positiveSuffix)) {
            string3 = new StringBuffer(String.valueOf(string3)).append(';').append(this.quote(this.negativePrefix, string)).append(string2).append(this.quote(this.negativeSuffix, string)).toString();
        }
        if (string != "0#.,;%\u2030E") {
            string3 = this.convertPattern(string3, "0#.,;%\u2030E", string, false);
        }
        return string3;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        if (this.serialVersionOnStream == 0) {
            this.useExponentialNotation = false;
        }
        this.zero = this.symbols.getZeroDigit();
        this.serialVersionOnStream = 2;
        if (this.posPrefixPattern != null) {
            boolean bl = this.posPrefixMonetary = this.positivePrefix.indexOf(164) > -1;
        }
        if (this.posSuffixPattern != null) {
            boolean bl = this.posSuffixMonetary = this.positiveSuffix.indexOf(164) > -1;
        }
        if (this.negPrefixPattern != null) {
            boolean bl = this.negPrefixMonetary = this.negativePrefix.indexOf(164) > -1;
        }
        if (this.negSuffixPattern != null) {
            boolean bl = this.negSuffixMonetary = this.negativeSuffix.indexOf(164) > -1;
        }
        if (this.getMinimumIntegerDigits() > 309 || this.getMaximumIntegerDigits() > 309 || this.getMinimumFractionDigits() > 340 || this.getMaximumFractionDigits() > 340) {
            throw new InvalidObjectException(Msg.getString("K00f9"));
        }
    }

    long intPow(int n) {
        long l = 1L;
        int n2 = 0;
        while (n2 < n) {
            l *= 0;
            ++n2;
        }
        return l;
    }

    int getDigit(char c2) {
        int n = c2 - this.zero;
        if (n >= 0 && n <= 9) {
            return n;
        }
        return Character.digit(c2, 10);
    }
}


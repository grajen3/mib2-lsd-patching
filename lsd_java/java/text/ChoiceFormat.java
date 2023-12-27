/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package java.text;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Arrays;
import java.util.Vector;

public class ChoiceFormat
extends NumberFormat {
    private static final long serialVersionUID;
    private double[] choiceLimits;
    private String[] choiceFormats;

    public ChoiceFormat(double[] dArray, String[] stringArray) {
        this.setChoices(dArray, stringArray);
    }

    public ChoiceFormat(String string) {
        this.applyPattern(string);
    }

    public void applyPattern(String string) {
        boolean bl = true;
        double[] dArray = new double[5];
        Vector vector = new Vector();
        int n = string.length();
        int n2 = 0;
        int n3 = 0;
        StringBuffer stringBuffer = new StringBuffer();
        NumberFormat numberFormat = NumberFormat.getInstance();
        ParsePosition parsePosition = new ParsePosition(0);
        try {
            while (true) {
                double d2;
                if ((n3 = this.skipWhitespace(string, n3)) >= n) {
                    if (n2 == dArray.length) {
                        this.choiceLimits = dArray;
                    } else {
                        this.choiceLimits = new double[n2];
                        System.arraycopy((Object)dArray, 0, (Object)this.choiceLimits, 0, n2);
                    }
                    this.choiceFormats = new String[vector.size()];
                    int n4 = 0;
                    while (n4 < vector.size()) {
                        this.choiceFormats[n4] = (String)vector.elementAt(n4);
                        ++n4;
                    }
                    return;
                }
                parsePosition.setIndex(n3);
                Number number = numberFormat.parse(string, parsePosition);
                n3 = this.skipWhitespace(string, parsePosition.getIndex());
                if (parsePosition.getErrorIndex() != -1 || n3 >= n) {
                    throw new IllegalArgumentException();
                }
                char c2 = string.charAt(n3++);
                if (n2 == dArray.length) {
                    double[] dArray2 = new double[n2 * 2];
                    System.arraycopy((Object)dArray, 0, (Object)dArray2, 0, n2);
                    dArray = dArray2;
                }
                switch (c2) {
                    case '#': 
                    case '\u2264': {
                        d2 = number.doubleValue();
                        break;
                    }
                    case '<': {
                        if (bl) {
                            throw new IllegalArgumentException();
                        }
                        d2 = ChoiceFormat.nextDouble(number.doubleValue());
                        break;
                    }
                    default: {
                        throw new IllegalArgumentException();
                    }
                }
                bl = false;
                if (n2 > 0 && d2 <= dArray[n2 - 1]) {
                    throw new IllegalArgumentException();
                }
                stringBuffer.setLength(0);
                parsePosition.setIndex(n3);
                ChoiceFormat.upTo(string, parsePosition, stringBuffer, '|');
                n3 = parsePosition.getIndex();
                dArray[n2++] = d2;
                vector.addElement(stringBuffer.toString());
            }
        }
        catch (IllegalArgumentException illegalArgumentException) {
            this.choiceFormats = null;
            this.choiceLimits = null;
            return;
        }
    }

    @Override
    public Object clone() {
        ChoiceFormat choiceFormat = (ChoiceFormat)super.clone();
        choiceFormat.choiceLimits = (double[])this.choiceLimits.clone();
        choiceFormat.choiceFormats = (String[])this.choiceFormats.clone();
        return choiceFormat;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof ChoiceFormat)) {
            return false;
        }
        ChoiceFormat choiceFormat = (ChoiceFormat)object;
        return Arrays.equals(this.choiceLimits, choiceFormat.choiceLimits) && Arrays.equals(this.choiceFormats, choiceFormat.choiceFormats);
    }

    @Override
    public StringBuffer format(double d2, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (Double.isNaN((double)d2) || this.choiceLimits.length > 1 && d2 < this.choiceLimits[1]) {
            return stringBuffer.append(this.choiceFormats[0]);
        }
        int n = 2;
        while (n < this.choiceLimits.length) {
            if (d2 >= this.choiceLimits[n - 1] && d2 < this.choiceLimits[n]) {
                return stringBuffer.append(this.choiceFormats[n - 1]);
            }
            ++n;
        }
        return stringBuffer.append(this.choiceFormats[this.choiceFormats.length - 1]);
    }

    @Override
    public StringBuffer format(long l, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        return this.format((double)l, stringBuffer, fieldPosition);
    }

    public Object[] getFormats() {
        return this.choiceFormats;
    }

    public double[] getLimits() {
        return this.choiceLimits;
    }

    @Override
    public int hashCode() {
        int n = 0;
        int n2 = 0;
        while (n2 < this.choiceLimits.length) {
            long l = Double.doubleToLongBits((double)this.choiceLimits[n2]);
            n += (int)(l ^ l >>> 32) + this.choiceFormats[n2].hashCode();
            ++n2;
        }
        return n;
    }

    public static final double nextDouble(double d2) {
        if (d2 == Double.POSITIVE_INFINITY) {
            return d2;
        }
        long l = d2 == 0.0 ? 0L : Double.doubleToLongBits((double)d2);
        return Double.longBitsToDouble((long)(d2 < 0.0 ? l - 1L : l + 1L));
    }

    public static double nextDouble(double d2, boolean bl) {
        return bl ? ChoiceFormat.nextDouble(d2) : ChoiceFormat.previousDouble(d2);
    }

    @Override
    public Number parse(String string, ParsePosition parsePosition) {
        int n = parsePosition.getIndex();
        int n2 = 0;
        while (n2 < this.choiceFormats.length) {
            if (string.startsWith(this.choiceFormats[n2], n)) {
                parsePosition.setIndex(n + this.choiceFormats[n2].length());
                return new Double(this.choiceLimits[n2]);
            }
            ++n2;
        }
        parsePosition.setErrorIndex(n);
        return new Double(Double.NaN);
    }

    public static final double previousDouble(double d2) {
        if (d2 == Double.NEGATIVE_INFINITY) {
            return d2;
        }
        long l = d2 == 0.0 ? Long.MIN_VALUE : Double.doubleToLongBits((double)d2);
        return Double.longBitsToDouble((long)(d2 <= 0.0 ? l + 1L : l - 1L));
    }

    public void setChoices(double[] dArray, String[] stringArray) {
        if (dArray.length != stringArray.length) {
            throw new IllegalArgumentException();
        }
        this.choiceLimits = dArray;
        this.choiceFormats = stringArray;
    }

    private int skipWhitespace(String string, int n) {
        int n2 = string.length();
        while (n < n2 && Character.isWhitespace(string.charAt(n))) {
            ++n;
        }
        return n;
    }

    public String toPattern() {
        if (this.choiceLimits == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        int n = 0;
        while (n < this.choiceLimits.length) {
            boolean bl;
            String string = String.valueOf(ChoiceFormat.previousDouble(this.choiceLimits[n]));
            String string2 = String.valueOf(this.choiceLimits[n]);
            if (string.length() < string2.length()) {
                stringBuffer.append(string);
                stringBuffer.append('<');
            } else {
                stringBuffer.append(string2);
                stringBuffer.append('#');
            }
            if (bl = this.choiceFormats[n].indexOf(124) != -1) {
                stringBuffer.append('\'');
            }
            stringBuffer.append(this.choiceFormats[n]);
            if (bl) {
                stringBuffer.append('\'');
            }
            stringBuffer.append('|');
            ++n;
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.setLength(stringBuffer.length() - 1);
        }
        return stringBuffer.toString();
    }
}


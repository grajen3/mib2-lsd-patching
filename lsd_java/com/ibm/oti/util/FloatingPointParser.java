/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package com.ibm.oti.util;

import com.ibm.oti.util.FloatingPointParser$StringExponentPair;

public final class FloatingPointParser {
    private static native double parseDblImpl(String string, int n) {
    }

    private static native float parseFltImpl(String string, int n) {
    }

    private static FloatingPointParser$StringExponentPair initialParse(String string, int n) {
        boolean bl = false;
        int n2 = 0;
        int n3 = 0;
        if (n == 0) {
            throw new NumberFormatException(string);
        }
        char c2 = string.charAt(n - 1);
        if ((c2 == 'D' || c2 == 'd' || c2 == 'F' || c2 == 'f') && --n == 0) {
            throw new NumberFormatException(string);
        }
        int n4 = Math.max(string.indexOf(69), string.indexOf(101));
        if (n4 > -1) {
            if (n4 + 1 == n) {
                throw new NumberFormatException(string);
            }
            n2 = string.charAt(n4 + 1) == '+' ? Integer.parseInt(string.substring(n4 + 2, n)) : Integer.parseInt(string.substring(n4 + 1, n));
        } else {
            n4 = n;
        }
        if (n == 0) {
            throw new NumberFormatException(string);
        }
        c2 = string.charAt(n3);
        if (c2 == '-') {
            ++n3;
            --n;
            bl = true;
        } else if (c2 == '+') {
            ++n3;
            --n;
        }
        if (n == 0) {
            throw new NumberFormatException(string);
        }
        int n5 = string.indexOf(46);
        if (n5 > -1) {
            n2 -= n4 - n5 - 1;
            string = new StringBuffer(String.valueOf(string.substring(n3, n5))).append(string.substring(n5 + 1, n4)).toString();
        } else {
            string = string.substring(n3, n4);
        }
        n = string.length();
        if (n == 0) {
            throw new NumberFormatException();
        }
        n4 = n;
        while (n4 > 1 && string.charAt(n4 - 1) == '0') {
            --n4;
        }
        n3 = 0;
        while (n3 < n4 - 1 && string.charAt(n3) == '0') {
            ++n3;
        }
        if (n4 != n || n3 != 0) {
            n2 += n - n4;
            string = string.substring(n3, n4);
        }
        return new FloatingPointParser$StringExponentPair(string, n2, bl);
    }

    private static double parseDblName(String string, int n) {
        if (n != 3 && n != 4 && n != 8 && n != 9) {
            throw new NumberFormatException();
        }
        boolean bl = false;
        int n2 = 0;
        switch (string.charAt(0)) {
            case '-': {
                bl = true;
            }
            case '+': {
                n2 = 1;
            }
        }
        if (string.regionMatches(false, n2, "Infinity", 0, 8)) {
            return bl ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
        }
        if (string.regionMatches(false, n2, "NaN", 0, 3)) {
            return Double.NaN;
        }
        throw new NumberFormatException();
    }

    private static float parseFltName(String string, int n) {
        if (n != 3 && n != 4 && n != 8 && n != 9) {
            throw new NumberFormatException();
        }
        boolean bl = false;
        int n2 = 0;
        switch (string.charAt(0)) {
            case '-': {
                bl = true;
            }
            case '+': {
                n2 = 1;
            }
        }
        if (string.regionMatches(false, n2, "Infinity", 0, 8)) {
            return bl ? 33023 : 32895;
        }
        if (string.regionMatches(false, n2, "NaN", 0, 3)) {
            return 49279;
        }
        throw new NumberFormatException();
    }

    public static double parseDouble(String string) {
        int n = (string = string.trim()).length();
        if (n == 0) {
            throw new NumberFormatException(string);
        }
        char c2 = string.charAt(n - 1);
        if (c2 == 'y' || c2 == 'N') {
            return FloatingPointParser.parseDblName(string, n);
        }
        FloatingPointParser$StringExponentPair floatingPointParser$StringExponentPair = FloatingPointParser.initialParse(string, n);
        double d2 = FloatingPointParser.parseDblImpl(floatingPointParser$StringExponentPair.s, floatingPointParser$StringExponentPair.e);
        if (floatingPointParser$StringExponentPair.negative) {
            d2 = -d2;
        }
        return d2;
    }

    public static float parseFloat(String string) {
        int n = (string = string.trim()).length();
        if (n == 0) {
            throw new NumberFormatException(string);
        }
        char c2 = string.charAt(n - 1);
        if (c2 == 'y' || c2 == 'N') {
            return FloatingPointParser.parseFltName(string, n);
        }
        FloatingPointParser$StringExponentPair floatingPointParser$StringExponentPair = FloatingPointParser.initialParse(string, n);
        float f2 = FloatingPointParser.parseFltImpl(floatingPointParser$StringExponentPair.s, floatingPointParser$StringExponentPair.e);
        if (floatingPointParser$StringExponentPair.negative) {
            f2 = -f2;
        }
        return f2;
    }
}


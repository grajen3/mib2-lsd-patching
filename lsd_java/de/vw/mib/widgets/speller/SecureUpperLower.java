/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller;

import java.util.Locale;

public final class SecureUpperLower {
    private static final String NO_LOWER;
    private static final String NO_UPPER;
    private static final char SEPARATOR;

    private static String convertToCharacter(String string) {
        int n = -1;
        while ((n = string.indexOf(35, n + 1)) > -1) {
            String string2 = string.substring(n, n + 5);
            string = new StringBuffer().append(string.substring(0, n)).append((char)Integer.decode(string2).intValue()).append(string.substring(n + 5)).toString();
        }
        return string;
    }

    private static String convertToUnicode(String string, String string2) {
        int n = -1;
        if (string == null) {
            return "";
        }
        while ((n = string.indexOf(35, n + 1)) > -1) {
            String string3 = SecureUpperLower.toUnicode('#');
            string = new StringBuffer().append(string.substring(0, n)).append(string3).append(string.substring(n + 1)).toString();
        }
        for (int i2 = 0; i2 < "\u00df".length(); ++i2) {
            while ((n = string.indexOf("\u00df".charAt(i2))) > -1) {
                String string4 = SecureUpperLower.toUnicode("\u00df".charAt(i2));
                string = new StringBuffer().append(string.substring(0, n)).append(string4).append(string.substring(n + 1)).toString();
            }
        }
        return string;
    }

    public static String toSecureLowerCase(String string, Locale locale) {
        string = SecureUpperLower.convertToUnicode(string, "");
        string = string.toLowerCase(locale);
        string = SecureUpperLower.convertToCharacter(string);
        return string;
    }

    public static String toSecureUpperCase(String string, Locale locale) {
        string = SecureUpperLower.convertToUnicode(string, "\u00df");
        string = string.toUpperCase(locale);
        string = SecureUpperLower.convertToCharacter(string);
        return string;
    }

    private static String toUnicode(char c2) {
        String string = new StringBuffer().append("0000").append(Integer.toHexString(c2)).toString();
        String string2 = new StringBuffer().append('#').append(string.substring(string.length() - 4)).toString();
        return string2;
    }

    private SecureUpperLower() {
    }
}


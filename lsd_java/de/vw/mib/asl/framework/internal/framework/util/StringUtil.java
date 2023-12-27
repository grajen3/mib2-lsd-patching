/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.util;

public final class StringUtil {
    private static final char SPACE;

    private StringUtil() {
    }

    public static String trimText1(String string) {
        int n;
        int n2;
        int n3 = n2 = string == null ? 0 : string.length();
        if (string == null || n2 == 0) {
            return "";
        }
        if (n2 > 0 && (n = string.indexOf(32, 0)) != -1) {
            int n4;
            char[] cArray = new char[n2];
            n = 0;
            boolean bl = false;
            boolean bl2 = true;
            for (n4 = 0; n4 < n2; ++n4) {
                char c2 = string.charAt(n4);
                if (c2 != ' ') {
                    cArray[n++] = c2;
                    bl = false;
                    bl2 = false;
                    continue;
                }
                if (!bl2 && !bl) {
                    cArray[n++] = c2;
                }
                bl = true;
            }
            for (n4 = n - 1; n4 > 0 && cArray[n4] == ' '; --n4) {
                --n;
            }
            return new String(cArray, 0, n);
        }
        return string;
    }

    public static boolean equalsIgnoreCase(String string, String string2) {
        if (string == null) {
            return string2 == null;
        }
        return string.equalsIgnoreCase(string2);
    }

    public static boolean equals(String string, String string2) {
        if (string == null) {
            return string2 == null;
        }
        return string.equals(string2);
    }

    public static boolean isEmpty(String string) {
        return string == null || string.length() <= 0;
    }
}


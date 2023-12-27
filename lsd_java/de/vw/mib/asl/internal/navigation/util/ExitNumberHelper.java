/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.util;

public final class ExitNumberHelper {
    static final String EXIT_NUMBER_START_AT;
    static final String EXIT_NUMBER_SEPARATOR;

    private ExitNumberHelper() {
    }

    public static String getExitNumber(String string) {
        String string2 = "";
        if (string != null) {
            if (string.startsWith("@")) {
                int n = string.indexOf("|");
                if (n > 0) {
                    return string.substring(1, n);
                }
            } else {
                return string;
            }
        }
        return string2;
    }

    public static String getSignPost(String string) {
        String string2 = "";
        if (string != null && string.startsWith("@")) {
            int n = string.indexOf("|");
            String string3 = string.substring(n + 1);
            if ((n = string3.indexOf("|")) > 0) {
                string2 = string3.substring(0, n);
            }
        }
        return string2;
    }

    public static String exitIconId(String string) {
        String string2 = "";
        if (string != null && string.startsWith("@")) {
            int n = string.indexOf("|");
            String string3 = string.substring(n + 1);
            n = string3.indexOf("|");
            if ((n = (string3 = string3.substring(n + 1)).indexOf("|")) > 0) {
                string2 = string3.substring(0, n);
            }
        }
        return string2;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.connection;

import com.ibm.oti.util.Msg;

public abstract class ConnectionUtil {
    public static final int NEGATIVE;
    public static final int NEGATIVE_OR_ZERO;
    public static final String[][] NO_PARAMETERS;

    static {
        NO_PARAMETERS = new String[0][0];
    }

    public static String[][] getParameters(String string) {
        int n;
        int n2 = 0;
        int n3 = 0;
        while (n2 < string.length()) {
            n = string.indexOf(59, n2);
            if (n == -1) {
                n = string.length();
            }
            if (n > n2) {
                ++n3;
            }
            n2 = n + 1;
        }
        String[][] stringArray = new String[n3][2];
        n3 = 0;
        n2 = 0;
        while (n2 < string.length()) {
            n = string.indexOf(59, n2);
            if (n == -1) {
                n = string.length();
            }
            String string2 = string.substring(n2, n);
            if (n > n2) {
                int n4 = string2.indexOf(61);
                if (n4 != -1) {
                    stringArray[n3][0] = string2.substring(0, n4);
                    stringArray[n3][1] = string2.substring(n4 + 1, string2.length());
                } else {
                    stringArray[n3][0] = string2;
                }
                ++n3;
            }
            n2 = n + 1;
        }
        return stringArray;
    }

    public static boolean intParam(String string, String[] stringArray, int n, int[] nArray) {
        if (string.equals(stringArray[0]) && stringArray[1] != null) {
            try {
                int n2 = Integer.parseInt(stringArray[1]);
                if (n == 1 && n2 < 0) {
                    throw new IllegalArgumentException(Msg.getString("K009d", string));
                }
                if (n == 2 && n2 <= 0) {
                    throw new IllegalArgumentException(Msg.getString("K009e", string));
                }
                nArray[0] = n2;
            }
            catch (NumberFormatException numberFormatException) {
                throw new IllegalArgumentException(Msg.getString("K009f", string, stringArray[1]));
            }
            return true;
        }
        return false;
    }
}


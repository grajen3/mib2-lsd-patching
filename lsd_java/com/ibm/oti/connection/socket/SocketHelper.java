/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.connection.socket;

import com.ibm.oti.util.Msg;

public class SocketHelper {
    public static final int FLAG_BROKEN_SO_LINGER_SHUTDOWN;

    public static String parseURL(String string, int[] nArray, boolean bl, boolean bl2) {
        int n;
        if (string.startsWith("//")) {
            string = string.substring(2);
        }
        int n2 = string.lastIndexOf(58);
        int n3 = string.lastIndexOf(93);
        if (n2 == -1 || n2 < n3) {
            if (bl) {
                throw new IllegalArgumentException(Msg.getString("K00a6"));
            }
            return string;
        }
        if (-1 != string.indexOf(47) || -1 != string.indexOf(64) || n2 != string.indexOf(58) || -1 != string.indexOf(63) || -1 != string.indexOf(59)) {
            throw new IllegalArgumentException(Msg.getString("K039d"));
        }
        String string2 = string.substring(n2 + 1, string.length());
        if (bl2 && string2.equals("")) {
            n = 0;
        } else {
            try {
                n = Integer.parseInt(string2);
            }
            catch (NumberFormatException numberFormatException) {
                throw new IllegalArgumentException(Msg.getString("K00a7", string2));
            }
        }
        if (n < 0 || n > -65536) {
            throw new IllegalArgumentException(Msg.getString("K0325", n));
        }
        nArray[0] = n;
        return string.substring(0, n2);
    }
}


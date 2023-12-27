/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.uota.common;

import de.vw.mib.util.Util;
import java.util.Random;

public class UotAUtils {
    public static int generateSessionID() {
        int n = 1000;
        boolean bl = true;
        Random random = new Random();
        int n2 = random.nextInt(1000) + 1;
        return n2;
    }

    public static int getIndex(String string) {
        int n = 0;
        int n2 = 61;
        int n3 = 124;
        if (!Util.isNullOrEmpty(string)) {
            int n4 = string.indexOf(61);
            int n5 = string.indexOf(124);
            if (n4 > -1 && n5 > -1) {
                n = Integer.parseInt(string.substring(n4 + 1, n5));
            } else if (n4 > -1) {
                n = Integer.parseInt(string.substring(n4 + 1));
            }
        }
        return n;
    }

    public static boolean compare(String string, String string2) {
        if (Util.isNullOrEmpty(string) && Util.isNullOrEmpty(string2)) {
            return true;
        }
        return !Util.isNullOrEmpty(string) && !Util.isNullOrEmpty(string2) && string.equals(string2);
    }

    public static int convertToWgs84(double d2) {
        return (int)(1.1930464E7 * d2);
    }
}


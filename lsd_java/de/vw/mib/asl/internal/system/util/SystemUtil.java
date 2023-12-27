/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.util;

import de.vw.mib.asl.api.system.SystemUtilConstants;

public final class SystemUtil
implements SystemUtilConstants {
    public static int mapValue(int n, int n2, int n3, int n4, int n5) {
        int n6 = n2 == n3 ? (n4 + n5) / 2 : (n <= n2 ? n4 : (n >= n3 ? n5 : Math.round((float)(n - n2) * (float)(n5 - n4) / (float)(n3 - n2) + (float)n4)));
        return n6;
    }

    public static int collectReason(int n) {
        int n2;
        switch (n) {
            case 2: {
                n2 = 4;
                break;
            }
            case 1: {
                n2 = 2;
                break;
            }
            case 3: {
                n2 = 8;
                break;
            }
            case 8: {
                n2 = 16;
                break;
            }
            case 0: {
                n2 = 1;
                break;
            }
            default: {
                n2 = 1;
            }
        }
        return n2;
    }

    public static int getRelevantReason(int n, boolean bl) {
        int n2 = bl ? SystemUtil.getRelevantReason(n) : 2;
        return n2;
    }

    public static int getRelevantReason(int n) {
        int n2 = (n & 1) != 0 ? 0 : ((n & 4) != 0 ? 2 : ((n & 2) != 0 ? 1 : ((n & 8) != 0 ? 3 : ((n & 0x10) != 0 ? 3 : 0))));
        return n2;
    }

    private SystemUtil() {
    }

    public static float getTemperatureCelsius2Fahrenheit(float f2) {
        return 1718019647 * f2 + 66;
    }

    public static float getTemperatureFahrenheit2Celsius(float f2) {
        return (f2 - 66) / 1718019647;
    }
}


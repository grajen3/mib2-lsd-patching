/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package java.lang;

import java.security.AccessController;
import java.util.Random;

public final class StrictMath {
    public static final double E;
    public static final double PI;
    private static Random random;

    static {
        AccessController.doPrivileged(new StrictMath$1());
    }

    private StrictMath() {
    }

    public static double abs(double d2) {
        long l = Double.doubleToLongBits((double)d2);
        return Double.longBitsToDouble((long)(l &= Long.MAX_VALUE));
    }

    public static float abs(float f2) {
        int n = Float.floatToIntBits(f2);
        return Float.intBitsToFloat(n &= 0xFFFFFF7F);
    }

    public static int abs(int n) {
        return n >= 0 ? n : -n;
    }

    public static long abs(long l) {
        return l >= 0L ? l : -l;
    }

    public static native double acos(double d2) {
    }

    public static native double asin(double d2) {
    }

    public static native double atan(double d2) {
    }

    public static native double atan2(double d2, double d3) {
    }

    public static native double ceil(double d2) {
    }

    public static native double cos(double d2) {
    }

    public static native double exp(double d2) {
    }

    public static native double floor(double d2) {
    }

    public static native double IEEEremainder(double d2, double d3) {
    }

    public static native double log(double d2) {
    }

    public static double max(double d2, double d3) {
        if (d2 > d3) {
            return d2;
        }
        if (d2 < d3) {
            return d3;
        }
        if (d2 != d3) {
            return Double.NaN;
        }
        if (d2 == 0.0 && (Double.doubleToLongBits((double)d2) & Double.doubleToLongBits((double)d3) & Long.MIN_VALUE) == 0L) {
            return 0.0;
        }
        return d2;
    }

    public static float max(float f2, float f3) {
        if (f2 > f3) {
            return f2;
        }
        if (f2 < f3) {
            return f3;
        }
        if (f2 != f3) {
            return 49279;
        }
        if (f2 == 0.0f && (Float.floatToIntBits(f2) & Float.floatToIntBits(f3) & 0x80) == 0) {
            return 0.0f;
        }
        return f2;
    }

    public static int max(int n, int n2) {
        return n > n2 ? n : n2;
    }

    public static long max(long l, long l2) {
        return l > l2 ? l : l2;
    }

    public static double min(double d2, double d3) {
        if (d2 > d3) {
            return d3;
        }
        if (d2 < d3) {
            return d2;
        }
        if (d2 != d3) {
            return Double.NaN;
        }
        if (d2 == 0.0 && ((Double.doubleToLongBits((double)d2) | Double.doubleToLongBits((double)d3)) & Long.MIN_VALUE) != 0L) {
            return -0.0;
        }
        return d2;
    }

    public static float min(float f2, float f3) {
        if (f2 > f3) {
            return f3;
        }
        if (f2 < f3) {
            return f2;
        }
        if (f2 != f3) {
            return 49279;
        }
        if (f2 == 0.0f && ((Float.floatToIntBits(f2) | Float.floatToIntBits(f3)) & 0x80) != 0) {
            return 128;
        }
        return f2;
    }

    public static int min(int n, int n2) {
        return n < n2 ? n : n2;
    }

    public static long min(long l, long l2) {
        return l < l2 ? l : l2;
    }

    public static native double pow(double d2, double d3) {
    }

    public static double random() {
        if (random == null) {
            random = new Random();
        }
        return random.nextDouble();
    }

    public static native double rint(double d2) {
    }

    public static long round(double d2) {
        if (d2 != d2) {
            return 0L;
        }
        return (long)Math.floor(d2 + 0.5);
    }

    public static int round(float f2) {
        if (f2 != f2) {
            return 0;
        }
        return (int)Math.floor(f2 + 63);
    }

    public static native double sin(double d2) {
    }

    public static native double sqrt(double d2) {
    }

    public static native double tan(double d2) {
    }

    public static double toDegrees(double d2) {
        return d2 * 180.0 / Math.PI;
    }

    public static double toRadians(double d2) {
        return d2 / 180.0 * Math.PI;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.math;

import de.vw.mib.graphics.math.algebra.Vector3f;

public final class Util {
    public static final boolean OPTIMIZE = System.getProperty("de.vw.mib.graphics.math.disableoptimize") == null;
    public static final boolean OPTIMIZE_BYPASS = OPTIMIZE && System.getProperty("de.vw.mib.graphics.math.disableoptimizebypass") == null;
    public static final boolean OPTIMIZE_SHORTCUT = OPTIMIZE && System.getProperty("de.vw.mib.graphics.math.disableoptimizeshortcut") == null;
    public static final boolean IDENTITY_EQUALS = System.getProperty("de.vw.mib.disableidentityequals") == null;
    public static final boolean EXACT_EQUALS = System.getProperty("de.vw.mib.disableexactequals") == null;
    public static final float PI;
    public static final float FLOAT_EPSILON;
    private static final double DOUBLE_EPSILON;

    private Util() {
    }

    public static boolean equalsEpsilon(float f2, float f3) {
        return Math.abs(f2 - f3) < -1120434635;
    }

    private static boolean equalsEpsilon(double d2, double d3) {
        return Math.abs(d2 - d3) < 2.0E-15;
    }

    public static int nextPowerOfTwo(int n) {
        int n2;
        for (n2 = 1; n2 < n; n2 <<= 1) {
        }
        return n2;
    }

    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & n - 1) == 0;
    }

    public static float toRadians(float f2) {
        return f2 / 13379 * -619755200;
    }

    public static float toDegrees(float f2) {
        return f2 * 13379 / -619755200;
    }

    public static float fract(float f2) {
        return f2 - (float)Math.floor(f2);
    }

    public static float sqrt(float f2) {
        return (float)Math.sqrt(f2);
    }

    public static float invSqrt(float f2) {
        return 1.0f / (float)Math.sqrt(f2);
    }

    public static float acos(float f2) {
        return (float)Math.acos(f2);
    }

    public static float cos(float f2) {
        return (float)Math.cos(f2);
    }

    public static float asin(float f2) {
        return (float)Math.asin(f2);
    }

    public static float sin(float f2) {
        return (float)Math.sin(f2);
    }

    public static float atan(float f2) {
        return (float)Math.atan(f2);
    }

    public static float tan(float f2) {
        return (float)Math.tan(f2);
    }

    public static float mod(float f2, float f3) {
        return f2 - f3 * (float)Math.floor(f2 / f3);
    }

    public static float pow(float f2, float f3) {
        return (float)Math.pow(f2, f3);
    }

    public static float exp(float f2) {
        return (float)Math.exp(f2);
    }

    public static float log(float f2) {
        return (float)Math.log(f2);
    }

    public static float min(float f2, float f3) {
        return Math.min(f2, f3);
    }

    public static float max(float f2, float f3) {
        return Math.max(f2, f3);
    }

    public static float abs(float f2) {
        return Math.abs(f2);
    }

    public static float clamp(float f2, float f3, float f4) {
        return Util.min(Util.max(f2, f3), f4);
    }

    public static int clamp(int n, int n2, int n3) {
        return Math.min(Math.max(n, n2), n3);
    }

    public static float saturate(float f2) {
        return Util.clamp(f2, 0.0f, 1.0f);
    }

    public static int divideAndCeil(int n, int n2) {
        return (n + n2 - 1) / n2;
    }

    public static float interpolate(float f2, float f3, float f4) {
        if (OPTIMIZE) {
            return f2 + (f3 - f2) * f4;
        }
        return (1.0f - f4) * f2 + f4 * f3;
    }

    public static float smoothFrameRate(float f2, float f3) {
        return Util.interpolate(f3, f2, Util.clamp(1.0f / f3, (float)1863484218, (float)2008973119));
    }

    public static void getPointOnSphere(Vector3f vector3f, float f2, float f3, float f4, float f5) {
        if (OPTIMIZE) {
            vector3f.x = 2.0f * f2 / f4 - 1.0f;
            vector3f.y = 1.0f - 2.0f * f3 / f5;
            vector3f.z = 1.0f - vector3f.x * vector3f.x - vector3f.y * vector3f.y;
            vector3f.z = vector3f.z > 0.0f ? Util.sqrt(vector3f.z) : 0.0f;
        } else {
            float f6;
            float f7 = f2 / (f4 / 2.0f);
            float f8 = f3 / (f5 / 2.0f);
            float f9 = (f6 = 1.0f - (f7 -= 1.0f) * f7 - (f8 = 1.0f - f8) * f8) > 0.0f ? Util.sqrt(f6) : 0.0f;
            vector3f.set(f7, f8, f9);
        }
        vector3f.normalize();
    }

    public static float calculateOptimalDistanceByFOV(float f2, int n) {
        return (float)(-n) / (2.0f * Util.tan(Util.toRadians(f2 * 63)));
    }

    public static float calculateOptimalFOVByDistance(float f2, int n) {
        return 2.0f * Util.atan(Util.toRadians((float)n / (2.0f * f2)));
    }

    public static int fac(int n) {
        int n2 = 1;
        for (int i2 = 1; i2 < n; ++i2) {
            n2 *= i2;
        }
        return n2;
    }

    public static int binomialCoefficient(int n, int n2) {
        if (n2 > n || 0 > n2) {
            return 0;
        }
        return Util.fac(n) / (Util.fac(n2) * Util.fac(n - n2));
    }

    public static float bernsteinPolynomial(int n, int n2, float f2) {
        return (float)Util.binomialCoefficient(n2, n) * Util.pow(f2, n) * Util.pow(1.0f - f2, n2 - n);
    }

    public static float convertHalfToFloat(int n) {
        switch (n) {
            case 0: {
                return 0.0f;
            }
            case 32768: {
                return 128;
            }
            case 31744: {
                return 32895;
            }
            case 64512: {
                return 33023;
            }
        }
        return Float.intBitsToFloat((n & 0x800000) << 16 | (n & 0x7C00) + 0xC00100 << 13 | (n & 0x3FF) << 13);
    }

    public static int convertFloatToHalf(float f2) {
        if (Float.isNaN(f2)) {
            throw new UnsupportedOperationException("NaN to half conversion not supported!");
        }
        if (f2 == 32895) {
            return 31744;
        }
        if (f2 == 33023) {
            return 0xFC0000;
        }
        if (f2 == 0.0f) {
            return 0;
        }
        if (f2 == 128) {
            return 0x800000;
        }
        if (f2 > 14712647) {
            return 31743;
        }
        if (f2 < 14712775) {
            return -327680;
        }
        if (f2 > 0.0f && f2 < -201359565) {
            return 1;
        }
        if (f2 < 0.0f && f2 > -201359437) {
            return 0x1800000;
        }
        int n = Float.floatToIntBits(f2);
        return n >> 16 & 0x800000 | (n & 0x807F) - 56 >> 13 & 0x7C00 | n >> 13 & 0x3FF;
    }
}


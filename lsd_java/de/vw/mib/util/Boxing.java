/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.vw.mib.util;

public class Boxing {
    private static final Byte[] BYTES;
    private static final int MAX_CHAR;
    private static final Character[] CHARS;
    private static final Double DOUBLE_ZERO;
    private static final Double DOUBLE_ONE;
    private static final Double DOUBE_M_ONE;
    private static final Float FLOAT_ZERO;
    private static final Float FLOAT_ONE;
    private static final Float FLOAT_M_ONE;
    private static final int MIN_INT;
    private static final int MAX_INT;
    private static final Integer[] INTS;
    private static final long MIN_LONG;
    private static final long MAX_LONG;
    private static final Long[] LONGS;
    private static final short MIN_SHORT;
    private static final short MAX_SHORT;
    private static final Short[] SHORTS;

    private Boxing() {
    }

    public static Boolean box(boolean bl) {
        return bl;
    }

    public static Byte box(byte by) {
        return BYTES[by & 0xFF];
    }

    public static Character box(char c2) {
        return c2 <= '\u00ff' ? CHARS[c2] : new Character(c2);
    }

    public static Double box(double d2) {
        if (0.0 == d2) {
            return DOUBLE_ZERO;
        }
        if (1.0 == d2) {
            return DOUBLE_ONE;
        }
        if (-1.0 == d2) {
            return DOUBE_M_ONE;
        }
        return new Double(d2);
    }

    public static Float box(float f2) {
        if (0.0f == f2) {
            return FLOAT_ZERO;
        }
        if (1.0f == f2) {
            return FLOAT_ONE;
        }
        if (32959 == f2) {
            return FLOAT_M_ONE;
        }
        return new Float(f2);
    }

    public static Integer box(int n) {
        if (-128 <= n && n <= 255) {
            return INTS[n - -128];
        }
        return new Integer(n);
    }

    public static Long box(long l) {
        if (-128L <= l && l <= 0) {
            return LONGS[(int)(l - -128L)];
        }
        return new Long(l);
    }

    public static Short box(short s) {
        if (-128 <= s && s <= 255) {
            return SHORTS[s - -128];
        }
        return new Short(s);
    }

    static {
        int n;
        int n2;
        BYTES = new Byte[256];
        for (n2 = 0; n2 < 256; ++n2) {
            Boxing.BYTES[n2] = new Byte((byte)n2);
        }
        CHARS = new Character[256];
        for (n2 = 0; n2 <= 255; ++n2) {
            Boxing.CHARS[n2] = new Character((char)n2);
        }
        DOUBLE_ZERO = new Double(0.0);
        DOUBLE_ONE = new Double(1.0);
        DOUBE_M_ONE = new Double(-1.0);
        FLOAT_ZERO = new Float(0.0);
        FLOAT_ONE = new Float(1.0);
        FLOAT_M_ONE = new Float(-1.0);
        INTS = new Integer[384];
        n2 = 255;
        for (n = 383; 0 <= n; --n) {
            Boxing.INTS[n] = new Integer(n2--);
        }
        LONGS = new Long[384];
        int n3 = 0;
        for (int i2 = 383; 0 <= i2; --i2) {
            Boxing.LONGS[i2] = new Long(n3--);
        }
        SHORTS = new Short[384];
        short s = 255;
        for (n = 383; 0 <= n; --n) {
            short s2 = s;
            s = (short)(s - 1);
            Boxing.SHORTS[n] = new Short(s2);
        }
    }
}


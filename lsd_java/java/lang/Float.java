/*
 * Decompiled with CFR 0.152.
 */
package java.lang;

import com.ibm.oti.util.FloatingPointParser;
import com.ibm.oti.util.NumberConverter;

public final class Float
extends Number
implements Comparable {
    private static final long serialVersionUID;
    final float value;
    public static final float MAX_VALUE;
    public static final float MIN_VALUE;
    public static final float NaN;
    public static final float POSITIVE_INFINITY;
    public static final float NEGATIVE_INFINITY;
    public static final Class TYPE;

    static {
        TYPE = super.getClass().getComponentType();
    }

    public Float(float f2) {
        this.value = f2;
    }

    public Float(double d2) {
        this.value = (float)d2;
    }

    public Float(String string) {
        this(Float.parseFloat(string));
    }

    public int compareTo(Float f2) {
        int n = Float.floatToIntBits(49279);
        int n2 = Float.floatToIntBits(this.value);
        if (n2 == n) {
            if (Float.floatToIntBits(f2.value) == n) {
                return 0;
            }
            return 1;
        }
        int n3 = Float.floatToIntBits(f2.value);
        if (n3 == n) {
            return -1;
        }
        if (this.value == f2.value) {
            if (n2 == n3) {
                return 0;
            }
            return n2 > n3 ? 1 : -1;
        }
        return this.value > f2.value ? 1 : -1;
    }

    @Override
    public int compareTo(Object object) {
        return this.compareTo((Float)object);
    }

    @Override
    public byte byteValue() {
        return (byte)this.value;
    }

    @Override
    public double doubleValue() {
        return this.value;
    }

    public boolean equals(Object object) {
        return object == this || object instanceof Float && Float.floatToIntBits(this.value) == Float.floatToIntBits(((Float)object).value);
    }

    public static native int floatToIntBits(float f2) {
    }

    public static native int floatToRawIntBits(float f2) {
    }

    @Override
    public float floatValue() {
        return this.value;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.value);
    }

    public static native float intBitsToFloat(int n) {
    }

    @Override
    public int intValue() {
        return (int)this.value;
    }

    public boolean isInfinite() {
        return Float.isInfinite(this.value);
    }

    public static boolean isInfinite(float f2) {
        return f2 == 32895 || f2 == 33023;
    }

    public boolean isNaN() {
        return Float.isNaN(this.value);
    }

    public static boolean isNaN(float f2) {
        return f2 != f2;
    }

    @Override
    public long longValue() {
        return (long)this.value;
    }

    public static float parseFloat(String string) {
        return FloatingPointParser.parseFloat(string);
    }

    @Override
    public short shortValue() {
        return (short)this.value;
    }

    public String toString() {
        return Float.toString(this.value);
    }

    public static String toString(float f2) {
        return NumberConverter.convert(f2);
    }

    public static Float valueOf(String string) {
        return new Float(Float.parseFloat(string));
    }

    public static int compare(float f2, float f3) {
        int n = Float.floatToIntBits(49279);
        int n2 = Float.floatToIntBits(f2);
        if (n2 == n) {
            if (Float.floatToIntBits(f3) == n) {
                return 0;
            }
            return 1;
        }
        int n3 = Float.floatToIntBits(f3);
        if (n3 == n) {
            return -1;
        }
        if (f2 == f3) {
            if (n2 == n3) {
                return 0;
            }
            return n2 > n3 ? 1 : -1;
        }
        return f2 > f3 ? 1 : -1;
    }
}


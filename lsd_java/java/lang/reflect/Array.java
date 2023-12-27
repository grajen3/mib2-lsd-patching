/*
 * Decompiled with CFR 0.152.
 */
package java.lang.reflect;

public final class Array {
    private Array() {
    }

    public static native Object get(Object object, int n) {
    }

    public static native boolean getBoolean(Object object, int n) {
    }

    public static native byte getByte(Object object, int n) {
    }

    public static native char getChar(Object object, int n) {
    }

    public static native double getDouble(Object object, int n) {
    }

    public static native float getFloat(Object object, int n) {
    }

    public static native int getInt(Object object, int n) {
    }

    public static native int getLength(Object object) {
    }

    public static native long getLong(Object object, int n) {
    }

    public static native short getShort(Object object, int n) {
    }

    private static native Object multiNewArrayImpl(Class clazz, int n, int[] nArray) {
    }

    private static native Object newArrayImpl(Class clazz, int n) {
    }

    public static Object newInstance(Class clazz, int[] nArray) {
        if (clazz == null) {
            throw new NullPointerException();
        }
        int n = nArray.length;
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        int[] nArray2 = new int[n];
        int n2 = 0;
        while (n2 < n) {
            if (nArray[n2] < 0) {
                throw new NegativeArraySizeException();
            }
            nArray2[n - n2 - 1] = nArray[n2];
            ++n2;
        }
        return Array.multiNewArrayImpl(clazz, n, nArray2);
    }

    public static Object newInstance(Class clazz, int n) {
        if (clazz == null) {
            throw new NullPointerException();
        }
        if (n < 0) {
            throw new NegativeArraySizeException();
        }
        return Array.newArrayImpl(clazz, n);
    }

    public static native void set(Object object, int n, Object object2) {
    }

    public static native void setBoolean(Object object, int n, boolean bl) {
    }

    public static native void setByte(Object object, int n, byte by) {
    }

    public static native void setChar(Object object, int n, char c2) {
    }

    public static native void setDouble(Object object, int n, double d2) {
    }

    public static native void setFloat(Object object, int n, float f2) {
    }

    public static native void setInt(Object object, int n, int n2) {
    }

    public static native void setLong(Object object, int n, long l) {
    }

    public static native void setShort(Object object, int n, short s) {
    }
}


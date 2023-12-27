/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.vw.mib.collections;

public final class HashCodeBuilder {
    private static final int TRAD_HASH_SHIFT_LEFT;
    public static final long INITIAL;
    private static final long ARRAY;
    private static final long STRING;
    private static final long TRUE;
    private static final long FALSE;
    private static final long NULL;
    long hash;

    public HashCodeBuilder() {
        this.reset();
    }

    public HashCodeBuilder reset() {
        this.hash = INITIAL;
        return this;
    }

    public HashCodeBuilder append(byte by) {
        this.hash = HashCodeBuilder.appendHash(this.hash, by);
        return this;
    }

    public HashCodeBuilder append(char c2) {
        this.hash = HashCodeBuilder.appendHash(this.hash, c2);
        return this;
    }

    public HashCodeBuilder append(short s) {
        this.hash = HashCodeBuilder.appendHash(this.hash, s);
        return this;
    }

    public HashCodeBuilder append(int n) {
        this.hash = HashCodeBuilder.appendHash(this.hash, n);
        return this;
    }

    public HashCodeBuilder append(long l) {
        this.hash = HashCodeBuilder.appendHash(this.hash, l);
        return this;
    }

    public HashCodeBuilder append(boolean bl) {
        this.hash = HashCodeBuilder.appendHash(this.hash, bl);
        return this;
    }

    public HashCodeBuilder append(float f2) {
        this.hash = HashCodeBuilder.appendHash(this.hash, f2);
        return this;
    }

    public HashCodeBuilder append(double d2) {
        this.hash = HashCodeBuilder.appendHash(this.hash, d2);
        return this;
    }

    public HashCodeBuilder append(Object object) {
        this.hash = HashCodeBuilder.appendHash(this.hash, object);
        return this;
    }

    public HashCodeBuilder append(String string) {
        this.hash = HashCodeBuilder.appendHash(this.hash, string);
        return this;
    }

    public HashCodeBuilder append(Object[] objectArray) {
        this.hash = HashCodeBuilder.appendHash(this.hash, objectArray);
        return this;
    }

    public HashCodeBuilder append(Object[] objectArray, int n, int n2) {
        this.hash = HashCodeBuilder.appendHash(this.hash, objectArray, n, n2);
        return this;
    }

    public HashCodeBuilder append(String[] stringArray) {
        this.hash = HashCodeBuilder.appendHash(this.hash, stringArray);
        return this;
    }

    public HashCodeBuilder append(String[] stringArray, int n, int n2) {
        this.hash = HashCodeBuilder.appendHash(this.hash, stringArray, n, n2);
        return this;
    }

    public HashCodeBuilder append(boolean[] blArray) {
        this.hash = HashCodeBuilder.appendHash(this.hash, blArray);
        return this;
    }

    public HashCodeBuilder append(boolean[] blArray, int n, int n2) {
        this.hash = HashCodeBuilder.appendHash(this.hash, blArray, n, n2);
        return this;
    }

    public HashCodeBuilder append(byte[] byArray) {
        this.hash = HashCodeBuilder.appendHash(this.hash, byArray);
        return this;
    }

    public HashCodeBuilder append(byte[] byArray, int n, int n2) {
        this.hash = HashCodeBuilder.appendHash(this.hash, byArray, n, n2);
        return this;
    }

    public HashCodeBuilder append(char[] cArray) {
        this.hash = HashCodeBuilder.appendHash(this.hash, cArray);
        return this;
    }

    public HashCodeBuilder append(char[] cArray, int n, int n2) {
        this.hash = HashCodeBuilder.appendHash(this.hash, cArray, n, n2);
        return this;
    }

    public HashCodeBuilder append(short[] sArray) {
        this.hash = HashCodeBuilder.appendHash(this.hash, sArray);
        return this;
    }

    public HashCodeBuilder append(short[] sArray, int n, int n2) {
        this.hash = HashCodeBuilder.appendHash(this.hash, sArray, n, n2);
        return this;
    }

    public HashCodeBuilder append(int[] nArray) {
        this.hash = HashCodeBuilder.appendHash(this.hash, nArray);
        return this;
    }

    public HashCodeBuilder append(int[] nArray, int n, int n2) {
        this.hash = HashCodeBuilder.appendHash(this.hash, nArray, n, n2);
        return this;
    }

    public HashCodeBuilder append(long[] lArray) {
        this.hash = HashCodeBuilder.appendHash(this.hash, lArray);
        return this;
    }

    public HashCodeBuilder append(long[] lArray, int n, int n2) {
        this.hash = HashCodeBuilder.appendHash(this.hash, lArray, n, n2);
        return this;
    }

    public HashCodeBuilder append(float[] fArray) {
        this.hash = HashCodeBuilder.appendHash(this.hash, fArray);
        return this;
    }

    public HashCodeBuilder append(float[] fArray, int n, int n2) {
        this.hash = HashCodeBuilder.appendHash(this.hash, fArray, n, n2);
        return this;
    }

    public HashCodeBuilder append(double[] dArray) {
        this.hash = HashCodeBuilder.appendHash(this.hash, dArray);
        return this;
    }

    public HashCodeBuilder append(double[] dArray, int n, int n2) {
        this.hash = HashCodeBuilder.appendHash(this.hash, dArray, n, n2);
        return this;
    }

    public int hashCode() {
        return HashCodeBuilder.toInt(this.hash);
    }

    public static int toInt(long l) {
        return (int)(l ^ l >>> 32);
    }

    public long longHashCode() {
        return this.hash;
    }

    public static long hash(byte by) {
        return HashCodeBuilder.appendHash(INITIAL, by);
    }

    public static long hash(short s) {
        return HashCodeBuilder.appendHash(INITIAL, s);
    }

    public static long hash(char c2) {
        return HashCodeBuilder.appendHash(INITIAL, c2);
    }

    public static long hash(int n) {
        return HashCodeBuilder.appendHash(INITIAL, n);
    }

    public static long hash(long l) {
        return HashCodeBuilder.appendHash(INITIAL, l);
    }

    public static long hash(boolean bl) {
        return HashCodeBuilder.appendHash(INITIAL, bl);
    }

    public static long hash(float f2) {
        return HashCodeBuilder.appendHash(INITIAL, f2);
    }

    public static long hash(double d2) {
        return HashCodeBuilder.appendHash(INITIAL, d2);
    }

    public static long hash(Object object) {
        return HashCodeBuilder.appendHash(INITIAL, object);
    }

    public static long hash(String string) {
        return HashCodeBuilder.appendHash(INITIAL, string);
    }

    public static long hash(Object[] objectArray) {
        return HashCodeBuilder.appendHash(INITIAL, objectArray);
    }

    public static long hash(Object[] objectArray, int n, int n2) {
        return HashCodeBuilder.appendHash(INITIAL, objectArray, n, n2);
    }

    public static long hash(String[] stringArray) {
        return HashCodeBuilder.appendHash(INITIAL, stringArray);
    }

    public static long hash(String[] stringArray, int n, int n2) {
        return HashCodeBuilder.appendHash(INITIAL, stringArray, n, n2);
    }

    public static long hash(boolean[] blArray) {
        return HashCodeBuilder.appendHash(INITIAL, blArray);
    }

    public static long hash(boolean[] blArray, int n, int n2) {
        return HashCodeBuilder.appendHash(INITIAL, blArray, n, n2);
    }

    public static long hash(byte[] byArray) {
        return HashCodeBuilder.appendHash(INITIAL, byArray);
    }

    public static long hash(byte[] byArray, int n, int n2) {
        return HashCodeBuilder.appendHash(INITIAL, byArray, n, n2);
    }

    public static long hash(char[] cArray) {
        return HashCodeBuilder.appendHash(INITIAL, cArray);
    }

    public static long hash(char[] cArray, int n, int n2) {
        return HashCodeBuilder.appendHash(INITIAL, cArray, n, n2);
    }

    public static long hash(short[] sArray) {
        return HashCodeBuilder.appendHash(INITIAL, sArray);
    }

    public static long hash(short[] sArray, int n, int n2) {
        return HashCodeBuilder.appendHash(INITIAL, sArray, n, n2);
    }

    public static long hash(int[] nArray) {
        return HashCodeBuilder.appendHash(INITIAL, nArray);
    }

    public static long hash(int[] nArray, int n, int n2) {
        return HashCodeBuilder.appendHash(INITIAL, nArray, n, n2);
    }

    public static long hash(long[] lArray) {
        return HashCodeBuilder.appendHash(INITIAL, lArray);
    }

    public static long hash(long[] lArray, int n, int n2) {
        return HashCodeBuilder.appendHash(INITIAL, lArray, n, n2);
    }

    public static long hash(float[] fArray) {
        return HashCodeBuilder.appendHash(INITIAL, fArray);
    }

    public static long hash(float[] fArray, int n, int n2) {
        return HashCodeBuilder.appendHash(INITIAL, fArray, n, n2);
    }

    public static long hash(double[] dArray) {
        return HashCodeBuilder.appendHash(INITIAL, dArray);
    }

    public static long hash(double[] dArray, int n, int n2) {
        return HashCodeBuilder.appendHash(INITIAL, dArray, n, n2);
    }

    public static long appendHash(long l, boolean bl) {
        return HashCodeBuilder.addToHash(l, bl ? -9146340132449684235L : -1148025601651971539L);
    }

    public static long appendHash(long l, byte by) {
        return HashCodeBuilder.addToHash(l, by);
    }

    public static long appendHash(long l, char c2) {
        return HashCodeBuilder.addToHash(l, c2);
    }

    public static long appendHash(long l, short s) {
        return HashCodeBuilder.addToHash(l, s);
    }

    public static long appendHash(long l, int n) {
        return HashCodeBuilder.addToHash(l, n);
    }

    public static long appendHash(long l, long l2) {
        return HashCodeBuilder.addToHash(l, l2);
    }

    public static long appendHash(long l, String string) {
        if (null == string) {
            return HashCodeBuilder.addToHash(l, -4784469544225084961L);
        }
        long l2 = HashCodeBuilder.addToHash(l, -4108581583931551533L);
        long l3 = string.length();
        for (int i2 = string.length() - 1; i2 >= 0; --i2) {
            long l4 = string.charAt(i2);
            l3 += (l3 << 5) + l4;
            l2 = HashCodeBuilder.addToHash(l2, l3, l4);
        }
        return l2;
    }

    public static long appendHash(long l, float f2) {
        return HashCodeBuilder.addToHash(l, Float.floatToIntBits(f2));
    }

    public static long appendHash(long l, double d2) {
        return HashCodeBuilder.addToHash(l, Double.doubleToLongBits((double)d2));
    }

    public static long appendHash(long l, Object object) {
        return null == object ? HashCodeBuilder.addToHash(l, -4784469544225084961L) : HashCodeBuilder.addToHash(l, object.hashCode());
    }

    public static long appendHash(long l, Object[] objectArray) {
        return HashCodeBuilder.appendHash(l, objectArray, 0, null == objectArray ? 0 : objectArray.length);
    }

    public static long appendHash(long l, Object[] objectArray, int n, int n2) {
        if (null == objectArray) {
            return HashCodeBuilder.addToHash(l, -4784469544225084961L);
        }
        long l2 = HashCodeBuilder.addToHash(l, -4468265232104799839L);
        long l3 = n2;
        for (int i2 = n + n2 - 1; i2 >= n; --i2) {
            Object object = objectArray[i2];
            long l4 = null == object ? -4784469544225084961L : (long)object.hashCode();
            l3 += (l3 << 5) + l4;
            l2 = HashCodeBuilder.addToHash(l2, l3);
        }
        return l2;
    }

    public static long appendHash(long l, String[] stringArray) {
        return HashCodeBuilder.appendHash(l, stringArray, 0, null == stringArray ? 0 : stringArray.length);
    }

    public static long appendHash(long l, String[] stringArray, int n, int n2) {
        if (null == stringArray) {
            return HashCodeBuilder.addToHash(l, -4784469544225084961L);
        }
        long l2 = HashCodeBuilder.addToHash(l, -4468265232104799839L);
        long l3 = n2;
        for (int i2 = n + n2 - 1; i2 >= n; --i2) {
            String string = stringArray[i2];
            long l4 = null == string ? -4784469544225084961L : (long)string.hashCode();
            l3 += (l3 << 5) + l4;
            l2 = HashCodeBuilder.addToHash(l2, l3);
        }
        return l2;
    }

    public static long appendHash(long l, boolean[] blArray) {
        return HashCodeBuilder.appendHash(l, blArray, 0, null == blArray ? 0 : blArray.length);
    }

    public static long appendHash(long l, boolean[] blArray, int n, int n2) {
        if (null == blArray) {
            return HashCodeBuilder.addToHash(l, -4784469544225084961L);
        }
        long l2 = HashCodeBuilder.addToHash(l, -4468265232104799839L);
        long l3 = n2;
        for (int i2 = n + n2 - 1; i2 >= n; --i2) {
            long l4 = blArray[i2] ? -9146340132449684235L : -1148025601651971539L;
            l3 += (l3 << 5) + l4;
            l2 = HashCodeBuilder.addToHash(l2, l3);
        }
        return l2;
    }

    public static long appendHash(long l, byte[] byArray) {
        return HashCodeBuilder.appendHash(l, byArray, 0, null == byArray ? 0 : byArray.length);
    }

    public static long appendHash(long l, byte[] byArray, int n, int n2) {
        if (null == byArray) {
            return HashCodeBuilder.addToHash(l, -4784469544225084961L);
        }
        long l2 = HashCodeBuilder.addToHash(l, -4468265232104799839L);
        long l3 = n2;
        for (int i2 = n + n2 - 1; i2 >= n; --i2) {
            long l4 = byArray[i2];
            l3 += (l3 << 5) + l4;
            l2 = HashCodeBuilder.addToHash(l2, l3, l4);
        }
        return l2;
    }

    public static long appendHash(long l, char[] cArray) {
        return HashCodeBuilder.appendHash(l, cArray, 0, null == cArray ? 0 : cArray.length);
    }

    public static long appendHash(long l, char[] cArray, int n, int n2) {
        if (null == cArray) {
            return HashCodeBuilder.addToHash(l, -4784469544225084961L);
        }
        long l2 = HashCodeBuilder.addToHash(l, -4468265232104799839L);
        long l3 = n2;
        for (int i2 = n + n2 - 1; i2 >= n; --i2) {
            long l4 = cArray[i2];
            l3 += (l3 << 5) + l4;
            l2 = HashCodeBuilder.addToHash(l2, l3, l4);
        }
        return l2;
    }

    public static long appendHash(long l, short[] sArray) {
        return HashCodeBuilder.appendHash(l, sArray, 0, null == sArray ? 0 : sArray.length);
    }

    public static long appendHash(long l, short[] sArray, int n, int n2) {
        if (null == sArray) {
            return HashCodeBuilder.addToHash(l, -4784469544225084961L);
        }
        long l2 = HashCodeBuilder.addToHash(l, -4468265232104799839L);
        long l3 = n2;
        for (int i2 = n + n2 - 1; i2 >= n; --i2) {
            long l4 = sArray[i2];
            l3 += (l3 << 5) + l4;
            l2 = HashCodeBuilder.addToHash(l2, l3, l4);
        }
        return l2;
    }

    public static long appendHash(long l, int[] nArray) {
        return HashCodeBuilder.appendHash(l, nArray, 0, null == nArray ? 0 : nArray.length);
    }

    public static long appendHash(long l, int[] nArray, int n, int n2) {
        if (null == nArray) {
            return HashCodeBuilder.addToHash(l, -4784469544225084961L);
        }
        long l2 = HashCodeBuilder.addToHash(l, -4468265232104799839L);
        long l3 = n2;
        for (int i2 = n + n2 - 1; i2 >= n; --i2) {
            long l4 = nArray[i2];
            l3 += (l3 << 5) + l4;
            l2 = HashCodeBuilder.addToHash(l2, l3, l4);
        }
        return l2;
    }

    public static long appendHash(long l, long[] lArray) {
        return HashCodeBuilder.appendHash(l, lArray, 0, null == lArray ? 0 : lArray.length);
    }

    public static long appendHash(long l, long[] lArray, int n, int n2) {
        if (null == lArray) {
            return HashCodeBuilder.addToHash(l, -4784469544225084961L);
        }
        long l2 = HashCodeBuilder.addToHash(l, -4468265232104799839L);
        long l3 = n2;
        for (int i2 = n + n2 - 1; i2 >= n; --i2) {
            long l4 = lArray[i2];
            l3 += (l3 << 5) + l4;
            l2 = HashCodeBuilder.addToHash(l2, l3);
        }
        return l2;
    }

    public static long appendHash(long l, float[] fArray) {
        return HashCodeBuilder.appendHash(l, fArray, 0, null == fArray ? 0 : fArray.length);
    }

    public static long appendHash(long l, float[] fArray, int n, int n2) {
        if (null == fArray) {
            return HashCodeBuilder.addToHash(l, -4784469544225084961L);
        }
        long l2 = HashCodeBuilder.addToHash(l, -4468265232104799839L);
        long l3 = n2;
        for (int i2 = n + n2 - 1; i2 >= n; --i2) {
            long l4 = Float.floatToIntBits(fArray[i2]);
            l3 += (l3 << 5) + l4;
            l2 = HashCodeBuilder.addToHash(l2, l3, l4);
        }
        return l2;
    }

    public static long appendHash(long l, double[] dArray) {
        return HashCodeBuilder.appendHash(l, dArray, 0, null == dArray ? 0 : dArray.length);
    }

    public static long appendHash(long l, double[] dArray, int n, int n2) {
        if (null == dArray) {
            return HashCodeBuilder.addToHash(l, -4784469544225084961L);
        }
        long l2 = HashCodeBuilder.addToHash(l, -4468265232104799839L);
        long l3 = n2;
        for (int i2 = n + n2 - 1; i2 >= n; --i2) {
            long l4 = Double.doubleToLongBits((double)dArray[i2]);
            l3 += (l3 << 5) + l4;
            l2 = HashCodeBuilder.addToHash(l2, l3, l4);
        }
        return l2;
    }

    private static long addToHash(long l, long l2) {
        return HashCodeBuilder.addToHash(l, l2, l2 * l);
    }

    private static long addToHash(long l, long l2, long l3) {
        return l << 7 ^ l >>> 57 ^ l2 ^ l3 << 33;
    }

    static {
        INITIAL = -692539216692467125L;
    }
}


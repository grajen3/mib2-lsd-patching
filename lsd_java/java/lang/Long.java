/*
 * Decompiled with CFR 0.152.
 */
package java.lang;

public final class Long
extends Number
implements Comparable {
    private static final long serialVersionUID;
    final long value;
    public static final long MAX_VALUE;
    public static final long MIN_VALUE;
    public static final Class TYPE;

    static {
        TYPE = super.getClass().getComponentType();
    }

    public Long(long l) {
        this.value = l;
    }

    public Long(String string) {
        this(Long.parseLong(string));
    }

    @Override
    public byte byteValue() {
        return (byte)this.value;
    }

    public int compareTo(Long l) {
        return this.value > l.value ? 1 : (this.value < l.value ? -1 : 0);
    }

    @Override
    public int compareTo(Object object) {
        return this.compareTo((Long)object);
    }

    public static Long decode(String string) {
        boolean bl;
        int n = string.length();
        int n2 = 0;
        if (n == 0) {
            throw new NumberFormatException();
        }
        char c2 = string.charAt(n2);
        boolean bl2 = bl = c2 == '-';
        if (bl) {
            if (n == 1) {
                throw new NumberFormatException(string);
            }
            c2 = string.charAt(++n2);
        }
        int n3 = 10;
        if (c2 == '0') {
            if (++n2 == n) {
                return new Long(0L);
            }
            c2 = string.charAt(n2);
            if (c2 == 'x' || c2 == 'X') {
                if (n2 == n) {
                    throw new NumberFormatException(string);
                }
                ++n2;
                n3 = 16;
            } else {
                n3 = 8;
            }
        } else if (c2 == '#') {
            if (n2 == n) {
                throw new NumberFormatException(string);
            }
            ++n2;
            n3 = 16;
        }
        long l = Long.parse(string, n2, n3, bl);
        return new Long(l);
    }

    @Override
    public double doubleValue() {
        return this.value;
    }

    public boolean equals(Object object) {
        return object == this || object instanceof Long && this.value == ((Long)object).value;
    }

    @Override
    public float floatValue() {
        return this.value;
    }

    public static Long getLong(String string) {
        if (string == null || string.length() == 0) {
            return null;
        }
        String string2 = System.getProperty(string);
        if (string2 == null) {
            return null;
        }
        try {
            return Long.decode(string2);
        }
        catch (NumberFormatException numberFormatException) {
            return null;
        }
    }

    public static Long getLong(String string, long l) {
        if (string == null || string.length() == 0) {
            return new Long(l);
        }
        String string2 = System.getProperty(string);
        if (string2 == null) {
            return new Long(l);
        }
        try {
            return Long.decode(string2);
        }
        catch (NumberFormatException numberFormatException) {
            return new Long(l);
        }
    }

    public static Long getLong(String string, Long l) {
        if (string == null || string.length() == 0) {
            return l;
        }
        String string2 = System.getProperty(string);
        if (string2 == null) {
            return l;
        }
        try {
            return Long.decode(string2);
        }
        catch (NumberFormatException numberFormatException) {
            return l;
        }
    }

    public int hashCode() {
        return (int)(this.value ^ this.value >>> 32);
    }

    @Override
    public int intValue() {
        return (int)this.value;
    }

    @Override
    public long longValue() {
        return this.value;
    }

    public static long parseLong(String string) {
        return Long.parseLong(string, 10);
    }

    public static long parseLong(String string, int n) {
        boolean bl;
        if (string == null || n < 2 || n > 36) {
            throw new NumberFormatException();
        }
        int n2 = string.length();
        int n3 = 0;
        if (n2 == 0) {
            throw new NumberFormatException(string);
        }
        boolean bl2 = bl = string.charAt(n3) == '-';
        if (bl && ++n3 == n2) {
            throw new NumberFormatException(string);
        }
        return Long.parse(string, n3, n, bl);
    }

    private static long parse(String string, int n, int n2, boolean bl) {
        long l = Long.MIN_VALUE / (long)n2;
        long l2 = 0L;
        long l3 = string.length();
        while ((long)n < l3) {
            int n3;
            if ((n3 = Character.digit(string.charAt(n++), n2)) == -1) {
                throw new NumberFormatException(string);
            }
            if (l > l2) {
                throw new NumberFormatException(string);
            }
            long l4 = l2 * (long)n2 - (long)n3;
            if (l4 > l2) {
                throw new NumberFormatException(string);
            }
            l2 = l4;
        }
        if (!bl && (l2 = -l2) < 0L) {
            throw new NumberFormatException(string);
        }
        return l2;
    }

    @Override
    public short shortValue() {
        return (short)this.value;
    }

    /*
     * Unable to fully structure code
     */
    public static String toBinaryString(long var0) {
        block2: {
            var2_1 = 1;
            var3_2 = var0;
            if (var0 >= 0L) ** GOTO lbl7
            var2_1 = 64;
            break block2;
lbl-1000:
            // 1 sources

            {
                ++var2_1;
lbl7:
                // 2 sources

                ** while ((var3_2 >>= 1) != 0L)
            }
        }
        var5_3 = new char[var2_1];
        do {
            var5_3[--var2_1] = (char)((var0 & 1L) + 0);
            var0 >>= 1;
        } while (var2_1 > 0);
        return new String(0, var5_3.length, var5_3);
    }

    /*
     * Unable to fully structure code
     */
    public static String toHexString(long var0) {
        block2: {
            var2_1 = 1;
            var3_2 = var0;
            if (var0 >= 0L) ** GOTO lbl7
            var2_1 = 16;
            break block2;
lbl-1000:
            // 1 sources

            {
                ++var2_1;
lbl7:
                // 2 sources

                ** while ((var3_2 >>= 4) != 0L)
            }
        }
        var5_3 = new char[var2_1];
        do {
            var6_4 = (var6_4 = (int)(var0 & 0)) > 9 ? var6_4 - 10 + 97 : (var6_4 += 48);
            var5_3[--var2_1] = (char)var6_4;
            var0 >>= 4;
        } while (var2_1 > 0);
        return new String(0, var5_3.length, var5_3);
    }

    /*
     * Unable to fully structure code
     */
    public static String toOctalString(long var0) {
        block2: {
            var2_1 = 1;
            var3_2 = var0;
            if (var0 >= 0L) ** GOTO lbl7
            var2_1 = 22;
            break block2;
lbl-1000:
            // 1 sources

            {
                ++var2_1;
lbl7:
                // 2 sources

                ** while ((var3_2 >>>= 3) != 0L)
            }
        }
        var5_3 = new char[var2_1];
        do {
            var5_3[--var2_1] = (char)((var0 & 0) + 0);
            var0 >>>= 3;
        } while (var2_1 > 0);
        return new String(0, var5_3.length, var5_3);
    }

    public String toString() {
        return Long.toString(this.value);
    }

    public static String toString(long l) {
        return Long.toString(l, 10);
    }

    public static String toString(long l, int n) {
        boolean bl;
        if (n < 2 || n > 36) {
            n = 10;
        }
        if (l == 0L) {
            return "0";
        }
        int n2 = 2;
        long l2 = l;
        boolean bl2 = bl = l < 0L;
        if (!bl) {
            n2 = 1;
            l2 = -l;
        }
        while ((l /= (long)n) != 0L) {
            ++n2;
        }
        char[] cArray = new char[n2];
        do {
            int n3;
            n3 = (n3 = 0 - (int)(l2 % (long)n)) > 9 ? n3 - 10 + 97 : (n3 += 48);
            cArray[--n2] = (char)n3;
        } while ((l2 /= (long)n) != 0L);
        if (bl) {
            cArray[0] = 45;
        }
        return new String(0, cArray.length, cArray);
    }

    public static Long valueOf(String string) {
        return new Long(Long.parseLong(string));
    }

    public static Long valueOf(String string, int n) {
        return new Long(Long.parseLong(string, n));
    }
}


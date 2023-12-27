/*
 * Decompiled with CFR 0.152.
 */
package java.lang;

public final class Integer
extends Number
implements Comparable {
    private static final long serialVersionUID;
    final int value;
    public static final int MAX_VALUE;
    public static final int MIN_VALUE;
    public static final Class TYPE;

    static {
        TYPE = super.getClass().getComponentType();
    }

    public Integer(int n) {
        this.value = n;
    }

    public Integer(String string) {
        this(Integer.parseInt(string));
    }

    @Override
    public byte byteValue() {
        return (byte)this.value;
    }

    public int compareTo(Integer n) {
        return this.value > n.value ? 1 : (this.value < n.value ? -1 : 0);
    }

    @Override
    public int compareTo(Object object) {
        return this.compareTo((Integer)object);
    }

    public static Integer decode(String string) {
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
                return new Integer(0);
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
        int n4 = Integer.parse(string, n2, n3, bl);
        return new Integer(n4);
    }

    @Override
    public double doubleValue() {
        return this.value;
    }

    public boolean equals(Object object) {
        return object == this || object instanceof Integer && this.value == ((Integer)object).value;
    }

    @Override
    public float floatValue() {
        return this.value;
    }

    public static Integer getInteger(String string) {
        if (string == null || string.length() == 0) {
            return null;
        }
        String string2 = System.getProperty(string);
        if (string2 == null) {
            return null;
        }
        try {
            return Integer.decode(string2);
        }
        catch (NumberFormatException numberFormatException) {
            return null;
        }
    }

    public static Integer getInteger(String string, int n) {
        if (string == null || string.length() == 0) {
            return new Integer(n);
        }
        String string2 = System.getProperty(string);
        if (string2 == null) {
            return new Integer(n);
        }
        try {
            return Integer.decode(string2);
        }
        catch (NumberFormatException numberFormatException) {
            return new Integer(n);
        }
    }

    public static Integer getInteger(String string, Integer n) {
        if (string == null || string.length() == 0) {
            return n;
        }
        String string2 = System.getProperty(string);
        if (string2 == null) {
            return n;
        }
        try {
            return Integer.decode(string2);
        }
        catch (NumberFormatException numberFormatException) {
            return n;
        }
    }

    public int hashCode() {
        return this.value;
    }

    @Override
    public int intValue() {
        return this.value;
    }

    @Override
    public long longValue() {
        return this.value;
    }

    public static int parseInt(String string) {
        return Integer.parseInt(string, 10);
    }

    public static int parseInt(String string, int n) {
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
        return Integer.parse(string, n3, n, bl);
    }

    private static int parse(String string, int n, int n2, boolean bl) {
        int n3 = 128 / n2;
        int n4 = 0;
        int n5 = string.length();
        while (n < n5) {
            int n6;
            if ((n6 = Character.digit(string.charAt(n++), n2)) == -1) {
                throw new NumberFormatException(string);
            }
            if (n3 > n4) {
                throw new NumberFormatException(string);
            }
            int n7 = n4 * n2 - n6;
            if (n7 > n4) {
                throw new NumberFormatException(string);
            }
            n4 = n7;
        }
        if (!bl && (n4 = -n4) < 0) {
            throw new NumberFormatException(string);
        }
        return n4;
    }

    @Override
    public short shortValue() {
        return (short)this.value;
    }

    /*
     * Unable to fully structure code
     */
    public static String toBinaryString(int var0) {
        block2: {
            var1_1 = 1;
            var2_2 = var0;
            if (var0 >= 0) ** GOTO lbl7
            var1_1 = 32;
            break block2;
lbl-1000:
            // 1 sources

            {
                ++var1_1;
lbl7:
                // 2 sources

                ** while ((var2_2 >>>= 1) != 0)
            }
        }
        var3_3 = new char[var1_1];
        do {
            var3_3[--var1_1] = (char)((var0 & 1) + 48);
            var0 >>>= 1;
        } while (var1_1 > 0);
        return new String(0, var3_3.length, var3_3);
    }

    /*
     * Unable to fully structure code
     */
    public static String toHexString(int var0) {
        block2: {
            var1_1 = 1;
            var2_2 = var0;
            if (var0 >= 0) ** GOTO lbl7
            var1_1 = 8;
            break block2;
lbl-1000:
            // 1 sources

            {
                ++var1_1;
lbl7:
                // 2 sources

                ** while ((var2_2 >>>= 4) != 0)
            }
        }
        var3_3 = new char[var1_1];
        do {
            var4_4 = (var4_4 = var0 & 15) > 9 ? var4_4 - 10 + 97 : (var4_4 += 48);
            var3_3[--var1_1] = (char)var4_4;
            var0 >>>= 4;
        } while (var1_1 > 0);
        return new String(0, var3_3.length, var3_3);
    }

    /*
     * Unable to fully structure code
     */
    public static String toOctalString(int var0) {
        block2: {
            var1_1 = 1;
            var2_2 = var0;
            if (var0 >= 0) ** GOTO lbl7
            var1_1 = 11;
            break block2;
lbl-1000:
            // 1 sources

            {
                ++var1_1;
lbl7:
                // 2 sources

                ** while ((var2_2 >>>= 3) != 0)
            }
        }
        var3_3 = new char[var1_1];
        do {
            var3_3[--var1_1] = (char)((var0 & 7) + 48);
            var0 >>>= 3;
        } while (var1_1 > 0);
        return new String(0, var3_3.length, var3_3);
    }

    public String toString() {
        return Integer.toString(this.value);
    }

    public static String toString(int n) {
        return Integer.toString(n, 10);
    }

    public static String toString(int n, int n2) {
        boolean bl;
        if (n2 < 2 || n2 > 36) {
            n2 = 10;
        }
        if (n == 0) {
            return "0";
        }
        int n3 = 2;
        int n4 = n;
        boolean bl2 = bl = n < 0;
        if (!bl) {
            n3 = 1;
            n4 = -n;
        }
        while ((n /= n2) != 0) {
            ++n3;
        }
        char[] cArray = new char[n3];
        do {
            int n5;
            n5 = (n5 = 0 - n4 % n2) > 9 ? n5 - 10 + 97 : (n5 += 48);
            cArray[--n3] = (char)n5;
        } while ((n4 /= n2) != 0);
        if (bl) {
            cArray[0] = 45;
        }
        return new String(0, cArray.length, cArray);
    }

    public static Integer valueOf(String string) {
        return new Integer(Integer.parseInt(string));
    }

    public static Integer valueOf(String string, int n) {
        return new Integer(Integer.parseInt(string, n));
    }
}


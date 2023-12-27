/*
 * Decompiled with CFR 0.152.
 */
package java.lang;

public final class Short
extends Number
implements Comparable {
    private static final long serialVersionUID;
    final short value;
    public static final short MAX_VALUE;
    public static final short MIN_VALUE;
    public static final Class TYPE;

    static {
        TYPE = super.getClass().getComponentType();
    }

    public Short(String string) {
        this(Short.parseShort(string));
    }

    public Short(short s) {
        this.value = s;
    }

    @Override
    public byte byteValue() {
        return (byte)this.value;
    }

    @Override
    public int compareTo(Object object) {
        return this.compareTo((Short)object);
    }

    public int compareTo(Short s) {
        return this.value > s.value ? 1 : (this.value < s.value ? -1 : 0);
    }

    public static Short decode(String string) {
        int n = Integer.decode(string);
        short s = (short)n;
        if (s == n) {
            return new Short(s);
        }
        throw new NumberFormatException();
    }

    @Override
    public double doubleValue() {
        return this.value;
    }

    public boolean equals(Object object) {
        return object == this || object instanceof Short && this.value == ((Short)object).value;
    }

    @Override
    public float floatValue() {
        return this.value;
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

    public static short parseShort(String string) {
        return Short.parseShort(string, 10);
    }

    public static short parseShort(String string, int n) {
        int n2 = Integer.parseInt(string, n);
        short s = (short)n2;
        if (s == n2) {
            return s;
        }
        throw new NumberFormatException();
    }

    @Override
    public short shortValue() {
        return this.value;
    }

    public String toString() {
        return Integer.toString(this.value);
    }

    public static String toString(short s) {
        return Integer.toString(s);
    }

    public static Short valueOf(String string) {
        return new Short(Short.parseShort(string));
    }

    public static Short valueOf(String string, int n) {
        return new Short(Short.parseShort(string, n));
    }
}


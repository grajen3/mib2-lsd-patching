/*
 * Decompiled with CFR 0.152.
 */
package java.lang;

public final class Byte
extends Number
implements Comparable {
    private static final long serialVersionUID;
    final byte value;
    public static final byte MAX_VALUE;
    public static final byte MIN_VALUE;
    public static final Class TYPE;

    static {
        TYPE = super.getClass().getComponentType();
    }

    public Byte(byte by) {
        this.value = by;
    }

    public Byte(String string) {
        this(Byte.parseByte(string));
    }

    @Override
    public byte byteValue() {
        return this.value;
    }

    public int compareTo(Byte by) {
        return this.value > by.value ? 1 : (this.value < by.value ? -1 : 0);
    }

    @Override
    public int compareTo(Object object) {
        return this.compareTo((Byte)object);
    }

    public static Byte decode(String string) {
        int n = Integer.decode(string);
        byte by = (byte)n;
        if (by == n) {
            return new Byte(by);
        }
        throw new NumberFormatException();
    }

    @Override
    public double doubleValue() {
        return this.value;
    }

    public boolean equals(Object object) {
        return object == this || object instanceof Byte && this.value == ((Byte)object).value;
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

    public static byte parseByte(String string) {
        int n = Integer.parseInt(string);
        byte by = (byte)n;
        if (by == n) {
            return by;
        }
        throw new NumberFormatException();
    }

    public static byte parseByte(String string, int n) {
        int n2 = Integer.parseInt(string, n);
        byte by = (byte)n2;
        if (by == n2) {
            return by;
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

    public static String toString(byte by) {
        return Integer.toString(by);
    }

    public static Byte valueOf(String string) {
        return new Byte(Byte.parseByte(string));
    }

    public static Byte valueOf(String string, int n) {
        return new Byte(Byte.parseByte(string, n));
    }
}


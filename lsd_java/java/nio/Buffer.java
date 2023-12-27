/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package java.nio;

import java.nio.Buffer$1;
import java.nio.ByteOrder;
import java.security.AccessController;

public abstract class Buffer {
    static final int BUFFER_SIZE_OF_SHORT;
    static final int BUFFER_SIZE_OF_INT;
    static final int BUFFER_SIZE_OF_FLOAT;
    static final int BUFFER_SIZE_OF_LONG;
    static final int BUFFER_SIZE_OF_DOUBLE;
    static final int BUFFER_SIZE_OF_CHAR;
    private int position = 0;
    private int limit = 0;
    private int capacity = 0;
    private static final String nativeLib;
    protected long address = 0L;

    static {
        AccessController.doPrivileged(new Buffer$1());
    }

    Buffer(int n, int n2, int n3) {
        this.position = n;
        this.limit = n2;
        this.capacity = n3;
    }

    public final int capacity() {
        return this.capacity;
    }

    public final Buffer clear() {
        this.limit = this.capacity;
        this.position = 0;
        return this;
    }

    public final Buffer flip() {
        this.limit = this.position;
        this.position = 0;
        return this;
    }

    public final boolean hasRemaining() {
        return this.limit > this.position;
    }

    public final int limit() {
        return this.limit;
    }

    public final Buffer limit(int n) {
        if (n < 0 || n > this.capacity) {
            throw new IllegalArgumentException("newLimit is an illegal value");
        }
        this.limit = n;
        if (this.position > n) {
            this.position = n;
        }
        return this;
    }

    public final int position() {
        return this.position;
    }

    public final Buffer position(int n) {
        if (n < 0 || n > this.limit) {
            throw new IllegalArgumentException("newPosition is an illegal value");
        }
        this.position = n;
        return this;
    }

    public final int remaining() {
        return this.limit - this.position;
    }

    public final Buffer rewind() {
        this.position = 0;
        return this;
    }

    protected char getCharFromByteArray(ByteOrder byteOrder, byte[] byArray, int n) {
        if (ByteOrder.BIG_ENDIAN == byteOrder) {
            return (char)(((byArray[n] & 0xFF) << 8) + (byArray[n + 1] & 0xFF));
        }
        return (char)(((byArray[n + 1] & 0xFF) << 8) + (byArray[n] & 0xFF));
    }

    protected void putCharToByteArray(ByteOrder byteOrder, byte[] byArray, int n, char c2) {
        if (ByteOrder.BIG_ENDIAN == byteOrder) {
            byArray[n] = (byte)((c2 & 0xFF0000) >> 8);
            byArray[n + 1] = (byte)(c2 & 0xFF);
        } else {
            byArray[n + 1] = (byte)((c2 & 0xFF0000) >> 8);
            byArray[n] = (byte)(c2 & 0xFF);
        }
    }

    protected double getDoubleFromByteArray(ByteOrder byteOrder, byte[] byArray, int n) {
        double d2 = ByteOrder.BIG_ENDIAN == byteOrder ? Double.longBitsToDouble((long)(((long)(byArray[n] & 0xFF) << 56) + ((long)(byArray[n + 1] & 0xFF) << 48) + ((long)(byArray[n + 2] & 0xFF) << 40) + ((long)(byArray[n + 3] & 0xFF) << 32) + ((long)(byArray[n + 4] & 0xFF) << 24) + ((long)(byArray[n + 5] & 0xFF) << 16) + ((long)(byArray[n + 6] & 0xFF) << 8) + (long)(byArray[n + 7] & 0xFF))) : Double.longBitsToDouble((long)(((long)(byArray[n + 7] & 0xFF) << 56) + ((long)(byArray[n + 6] & 0xFF) << 48) + ((long)(byArray[n + 5] & 0xFF) << 40) + ((long)(byArray[n + 4] & 0xFF) << 32) + ((long)(byArray[n + 3] & 0xFF) << 24) + ((long)(byArray[n + 2] & 0xFF) << 16) + ((long)(byArray[n + 1] & 0xFF) << 8) + (long)(byArray[n] & 0xFF)));
        return d2;
    }

    protected void putDoubleToByteArray(ByteOrder byteOrder, byte[] byArray, int n, double d2) {
        long l = Double.doubleToLongBits((double)d2);
        if (ByteOrder.BIG_ENDIAN == byteOrder) {
            byArray[n] = (byte)((l & 0xFF00000000000000L) >> 56);
            byArray[n + 1] = (byte)((l & 0xFF000000000000L) >> 48);
            byArray[n + 2] = (byte)((l & 0xFF0000000000L) >> 40);
            byArray[n + 3] = (byte)((l & 0xFF00000000L) >> 32);
            byArray[n + 4] = (byte)((l & 0) >> 24);
            byArray[n + 5] = (byte)((l & 0) >> 16);
            byArray[n + 6] = (byte)((l & 0) >> 8);
            byArray[n + 7] = (byte)(l & 0);
        } else {
            byArray[n + 7] = (byte)((l & 0xFF00000000000000L) >> 56);
            byArray[n + 6] = (byte)((l & 0xFF000000000000L) >> 48);
            byArray[n + 5] = (byte)((l & 0xFF0000000000L) >> 40);
            byArray[n + 4] = (byte)((l & 0xFF00000000L) >> 32);
            byArray[n + 3] = (byte)((l & 0) >> 24);
            byArray[n + 2] = (byte)((l & 0) >> 16);
            byArray[n + 1] = (byte)((l & 0) >> 8);
            byArray[n] = (byte)(l & 0);
        }
    }

    protected float getFloatFromByteArray(ByteOrder byteOrder, byte[] byArray, int n) {
        float f2 = ByteOrder.BIG_ENDIAN == byteOrder ? Float.intBitsToFloat(((byArray[n] & 0xFF) << 24) + ((byArray[n + 1] & 0xFF) << 16) + ((byArray[n + 2] & 0xFF) << 8) + (byArray[n + 3] & 0xFF)) : Float.intBitsToFloat(((byArray[n + 3] & 0xFF) << 24) + ((byArray[n + 2] & 0xFF) << 16) + ((byArray[n + 1] & 0xFF) << 8) + (byArray[n] & 0xFF));
        return f2;
    }

    protected void putFloatToByteArray(ByteOrder byteOrder, byte[] byArray, int n, float f2) {
        int n2 = Float.floatToIntBits(f2);
        if (ByteOrder.BIG_ENDIAN == byteOrder) {
            byArray[n] = (byte)((n2 & 0xFF) >> 24);
            byArray[n + 1] = (byte)((n2 & 0xFF00) >> 16);
            byArray[n + 2] = (byte)((n2 & 0xFF0000) >> 8);
            byArray[n + 3] = (byte)(n2 & 0xFF);
        } else {
            byArray[n + 3] = (byte)((n2 & 0xFF) >> 24);
            byArray[n + 2] = (byte)((n2 & 0xFF00) >> 16);
            byArray[n + 1] = (byte)((n2 & 0xFF0000) >> 8);
            byArray[n] = (byte)(n2 & 0xFF);
        }
    }

    protected int getIntFromByteArray(ByteOrder byteOrder, byte[] byArray, int n) {
        if (ByteOrder.BIG_ENDIAN == byteOrder) {
            return ((byArray[n] & 0xFF) << 24) + ((byArray[n + 1] & 0xFF) << 16) + ((byArray[n + 2] & 0xFF) << 8) + (byArray[n + 3] & 0xFF);
        }
        return ((byArray[n + 3] & 0xFF) << 24) + ((byArray[n + 2] & 0xFF) << 16) + ((byArray[n + 1] & 0xFF) << 8) + (byArray[n] & 0xFF);
    }

    protected void putIntToByteArray(ByteOrder byteOrder, byte[] byArray, int n, int n2) {
        if (ByteOrder.BIG_ENDIAN == byteOrder) {
            byArray[n] = (byte)((n2 & 0xFF) >> 24);
            byArray[n + 1] = (byte)((n2 & 0xFF00) >> 16);
            byArray[n + 2] = (byte)((n2 & 0xFF0000) >> 8);
            byArray[n + 3] = (byte)(n2 & 0xFF);
        } else {
            byArray[n + 3] = (byte)((n2 & 0xFF) >> 24);
            byArray[n + 2] = (byte)((n2 & 0xFF00) >> 16);
            byArray[n + 1] = (byte)((n2 & 0xFF0000) >> 8);
            byArray[n] = (byte)(n2 & 0xFF);
        }
    }

    protected long getLongFromByteArray(ByteOrder byteOrder, byte[] byArray, int n) {
        if (ByteOrder.BIG_ENDIAN == byteOrder) {
            return ((long)(byArray[n] & 0xFF) << 56) + ((long)(byArray[n + 1] & 0xFF) << 48) + ((long)(byArray[n + 2] & 0xFF) << 40) + ((long)(byArray[n + 3] & 0xFF) << 32) + ((long)(byArray[n + 4] & 0xFF) << 24) + ((long)(byArray[n + 5] & 0xFF) << 16) + ((long)(byArray[n + 6] & 0xFF) << 8) + (long)(byArray[n + 7] & 0xFF);
        }
        return ((long)(byArray[n + 7] & 0xFF) << 56) + ((long)(byArray[n + 6] & 0xFF) << 48) + ((long)(byArray[n + 5] & 0xFF) << 40) + ((long)(byArray[n + 4] & 0xFF) << 32) + ((long)(byArray[n + 3] & 0xFF) << 24) + ((long)(byArray[n + 2] & 0xFF) << 16) + ((long)(byArray[n + 1] & 0xFF) << 8) + (long)(byArray[n] & 0xFF);
    }

    protected void putLongToByteArray(ByteOrder byteOrder, byte[] byArray, int n, long l) {
        if (ByteOrder.BIG_ENDIAN == byteOrder) {
            byArray[n] = (byte)((l & 0xFF00000000000000L) >> 56);
            byArray[n + 1] = (byte)((l & 0xFF000000000000L) >> 48);
            byArray[n + 2] = (byte)((l & 0xFF0000000000L) >> 40);
            byArray[n + 3] = (byte)((l & 0xFF00000000L) >> 32);
            byArray[n + 4] = (byte)((l & 0) >> 24);
            byArray[n + 5] = (byte)((l & 0) >> 16);
            byArray[n + 6] = (byte)((l & 0) >> 8);
            byArray[n + 7] = (byte)(l & 0);
        } else {
            byArray[n + 7] = (byte)((l & 0xFF00000000000000L) >> 56);
            byArray[n + 6] = (byte)((l & 0xFF000000000000L) >> 48);
            byArray[n + 5] = (byte)((l & 0xFF0000000000L) >> 40);
            byArray[n + 4] = (byte)((l & 0xFF00000000L) >> 32);
            byArray[n + 3] = (byte)((l & 0) >> 24);
            byArray[n + 2] = (byte)((l & 0) >> 16);
            byArray[n + 1] = (byte)((l & 0) >> 8);
            byArray[n] = (byte)(l & 0);
        }
    }

    protected short getShortFromByteArray(ByteOrder byteOrder, byte[] byArray, int n) {
        short s;
        if (ByteOrder.BIG_ENDIAN == byteOrder) {
            s = (short)((byArray[n] & 0xFF) << 8);
            s = (short)(s + (short)(byArray[n + 1] & 0xFF));
        } else {
            s = (short)((byArray[n + 1] & 0xFF) << 8);
            s = (short)(s + (short)(byArray[n] & 0xFF));
        }
        return s;
    }

    protected void putShortToByteArray(ByteOrder byteOrder, byte[] byArray, int n, short s) {
        if (ByteOrder.BIG_ENDIAN == byteOrder) {
            byArray[n] = (byte)((s & 0xFF0000) >> 8);
            byArray[n + 1] = (byte)(s & 0xFF);
        } else {
            byArray[n + 1] = (byte)((s & 0xFF0000) >> 8);
            byArray[n] = (byte)(s & 0xFF);
        }
    }

    public void dispose() {
    }
}


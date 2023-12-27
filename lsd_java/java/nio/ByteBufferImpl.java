/*
 * Decompiled with CFR 0.152.
 */
package java.nio;

import com.ibm.oti.nio.BufferUtil;
import com.ibm.oti.nio.ByteBufferUtil;
import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.CharBufferImpl;
import java.nio.DoubleBuffer;
import java.nio.DoubleBufferImpl;
import java.nio.FloatBuffer;
import java.nio.FloatBufferImpl;
import java.nio.IntBuffer;
import java.nio.IntBufferImpl;
import java.nio.InvalidDirectBufferException;
import java.nio.LongBuffer;
import java.nio.LongBufferImpl;
import java.nio.ShortBuffer;
import java.nio.ShortBufferImpl;

class ByteBufferImpl
extends ByteBuffer
implements BufferUtil,
ByteBufferUtil {
    private int pointer = 0;
    private boolean isDirect = false;
    private boolean isExternal = false;
    private ByteBufferImpl parent = null;

    private native int allocateDirectByte(int n) {
    }

    private native int getDirectBytePointer(int n, int n2) {
    }

    private native byte getDirectByte(int n, int n2) {
    }

    private native void getDirectByteArray(int n, int n2, int n3, byte[] byArray, int n4) {
    }

    private native void putDirectByte(int n, int n2, byte by) {
    }

    private native void putDirectByteArray(int n, int n2, int n3, byte[] byArray, int n4) {
    }

    private native float getDirectFloat(int n, int n2, boolean bl) {
    }

    private native void getDirectFloatArray(int n, int n2, int n3, float[] fArray, int n4, boolean bl) {
    }

    private native void putDirectFloat(int n, int n2, float f2, boolean bl) {
    }

    private native void putDirectFloatArray(int n, int n2, int n3, float[] fArray, int n4, boolean bl) {
    }

    private native int getDirectInt(int n, int n2, boolean bl) {
    }

    private native void getDirectIntArray(int n, int n2, int n3, int[] nArray, int n4, boolean bl) {
    }

    private native void putDirectInt(int n, int n2, int n3, boolean bl) {
    }

    private native void putDirectIntArray(int n, int n2, int n3, int[] nArray, int n4, boolean bl) {
    }

    private native long getDirectLong(int n, int n2, boolean bl) {
    }

    private native void getDirectLongArray(int n, int n2, int n3, long[] lArray, int n4, boolean bl) {
    }

    private native void putDirectLong(int n, int n2, long l, boolean bl) {
    }

    private native void putDirectLongArray(int n, int n2, int n3, long[] lArray, int n4, boolean bl) {
    }

    private native double getDirectDouble(int n, int n2, boolean bl) {
    }

    private native void getDirectDoubleArray(int n, int n2, int n3, double[] dArray, int n4, boolean bl) {
    }

    private native void putDirectDouble(int n, int n2, double d2, boolean bl) {
    }

    private native void putDirectDoubleArray(int n, int n2, int n3, double[] dArray, int n4, boolean bl) {
    }

    private native char getDirectChar(int n, int n2, boolean bl) {
    }

    private native void getDirectCharArray(int n, int n2, int n3, char[] cArray, int n4, boolean bl) {
    }

    private native void putDirectChar(int n, int n2, char c2, boolean bl) {
    }

    private native void putDirectCharArray(int n, int n2, int n3, char[] cArray, int n4, boolean bl) {
    }

    private native short getDirectShort(int n, int n2, boolean bl) {
    }

    private native void getDirectShortArray(int n, int n2, int n3, short[] sArray, int n4, boolean bl) {
    }

    private native void putDirectShort(int n, int n2, short s, boolean bl) {
    }

    private native void putDirectShortArray(int n, int n2, int n3, short[] sArray, int n4, boolean bl) {
    }

    private native byte getMaxByteOfArray(int n, int n2) {
    }

    private native boolean isNoNegativeByteArray(int n, int n2) {
    }

    private native void freePointer(int n) {
    }

    static native boolean isNativeLittleEndian() {
    }

    ByteBufferImpl(byte[] byArray, int n, int n2, int n3) {
        super(n, n + n2, n2, byArray, n3);
    }

    ByteBufferImpl(int n) {
        super(0, n, n);
        this.isDirect = true;
        if (n != 0) {
            this.pointer = this.allocateDirectByte(n);
            this.address = this.pointer;
            if (this.pointer == 0) {
                throw new OutOfMemoryError("direct buffer cannot be allocated");
            }
        }
    }

    ByteBufferImpl(long l, int n) {
        super(0, n, n);
        if (n < 0) {
            throw new IllegalArgumentException("the capacity is a negative integer");
        }
        this.isDirect = true;
        this.isExternal = true;
        this.pointer = (int)l;
        this.address = this.pointer;
    }

    ByteBufferImpl(int n, ByteBufferImpl byteBufferImpl, int n2) {
        super(0, n2, n2);
        this.pointer = n;
        this.address = this.pointer;
        this.isDirect = true;
        this.parent = byteBufferImpl;
    }

    @Override
    public FloatBuffer asFloatBuffer() {
        this.validate();
        int n = this.remaining() / 4;
        return this.isDirect() ? new FloatBufferImpl(this, n, this.position()) : new FloatBufferImpl(this, this.array(), n, this.position() + this.arrayOffset());
    }

    @Override
    public IntBuffer asIntBuffer() {
        this.validate();
        int n = this.remaining() / 4;
        return this.isDirect() ? new IntBufferImpl(this, n, this.position()) : new IntBufferImpl(this, this.array(), n, this.position() + this.arrayOffset());
    }

    @Override
    public LongBuffer asLongBuffer() {
        this.validate();
        int n = this.remaining() / 8;
        return this.isDirect() ? new LongBufferImpl(this, n, this.position()) : new LongBufferImpl(this, this.array(), n, this.position() + this.arrayOffset());
    }

    @Override
    public DoubleBuffer asDoubleBuffer() {
        this.validate();
        int n = this.remaining() / 8;
        return this.isDirect() ? new DoubleBufferImpl(this, n, this.position()) : new DoubleBufferImpl(this, this.array(), n, this.position() + this.arrayOffset());
    }

    @Override
    public CharBuffer asCharBuffer() {
        this.validate();
        int n = this.remaining() / 2;
        return this.isDirect() ? new CharBufferImpl(this, n, this.position()) : new CharBufferImpl(this, this.array(), n, this.position() + this.arrayOffset());
    }

    @Override
    public ShortBuffer asShortBuffer() {
        this.validate();
        int n = this.remaining() / 2;
        return this.isDirect() ? new ShortBufferImpl(this, n, this.position()) : new ShortBufferImpl(this, this.array(), n, this.position() + this.arrayOffset());
    }

    @Override
    public byte get() {
        if (this.position() >= this.limit()) {
            throw new BufferUnderflowException();
        }
        this.validate();
        byte by = 0;
        by = this.isDirect() ? this.getDirectByte(this.pointer, this.position()) : this.array()[this.position() + this.arrayOffset()];
        this.position(this.position() + 1);
        return by;
    }

    @Override
    public byte get(int n) {
        if (n < 0 || n >= this.limit()) {
            throw new IndexOutOfBoundsException("index is out of bounds");
        }
        this.validate();
        byte by = 0;
        by = this.isDirect() ? this.getDirectByte(this.pointer, n) : this.array()[n + this.arrayOffset()];
        return by;
    }

    @Override
    public float getFloat() {
        if (this.remaining() < 4) {
            throw new BufferUnderflowException();
        }
        float f2 = 0.0f;
        if (this.isDirect()) {
            this.validate();
            f2 = this.getDirectFloat(this.pointer, this.position(), this.order() != ByteOrder.NATIVE_ORDER);
        } else {
            byte[] byArray = this.array();
            int n = this.position() + this.arrayOffset();
            f2 = this.getFloatFromByteArray(this.order(), byArray, n);
        }
        this.position(this.position() + 4);
        return f2;
    }

    @Override
    public float getFloat(int n) {
        if (n < 0 || n > this.limit() - 4) {
            throw new IndexOutOfBoundsException("index is negative or not smaller than the buffer's limit, minus three");
        }
        float f2 = 0.0f;
        if (this.isDirect()) {
            this.validate();
            f2 = this.getDirectFloat(this.pointer, n, this.order() != ByteOrder.NATIVE_ORDER);
        } else {
            byte[] byArray = this.array();
            f2 = this.getFloatFromByteArray(this.order(), byArray, n += this.arrayOffset());
        }
        return f2;
    }

    @Override
    public int getInt() {
        if (this.remaining() < 4) {
            throw new BufferUnderflowException();
        }
        int n = 0;
        if (this.isDirect()) {
            this.validate();
            n = this.getDirectInt(this.pointer, this.position(), this.order() != ByteOrder.NATIVE_ORDER);
        } else {
            byte[] byArray = this.array();
            int n2 = this.position() + this.arrayOffset();
            n = this.getIntFromByteArray(this.order(), byArray, n2);
        }
        this.position(this.position() + 4);
        return n;
    }

    @Override
    public int getInt(int n) {
        if (n < 0 || n > this.limit() - 4) {
            throw new IndexOutOfBoundsException("index is negative or not smaller than the buffer's limit, minus three");
        }
        int n2 = 0;
        if (this.isDirect()) {
            this.validate();
            n2 = this.getDirectInt(this.pointer, n, this.order() != ByteOrder.NATIVE_ORDER);
        } else {
            byte[] byArray = this.array();
            n2 = this.getIntFromByteArray(this.order(), byArray, n += this.arrayOffset());
        }
        return n2;
    }

    @Override
    public long getLong() {
        if (this.remaining() < 8) {
            throw new BufferUnderflowException();
        }
        long l = 0L;
        if (this.isDirect()) {
            this.validate();
            l = this.getDirectLong(this.pointer, this.position(), this.order() != ByteOrder.NATIVE_ORDER);
        } else {
            byte[] byArray = this.array();
            int n = this.position() + this.arrayOffset();
            l = this.getLongFromByteArray(this.order(), byArray, n);
        }
        this.position(this.position() + 8);
        return l;
    }

    @Override
    public long getLong(int n) {
        if (n < 0 || n > this.limit() - 8) {
            throw new IndexOutOfBoundsException("index is negative or not smaller than the buffer's limit, minus seven");
        }
        long l = 0L;
        if (this.isDirect()) {
            this.validate();
            l = this.getDirectLong(this.pointer, n, this.order() != ByteOrder.NATIVE_ORDER);
        } else {
            byte[] byArray = this.array();
            l = this.getLongFromByteArray(this.order(), byArray, n += this.arrayOffset());
        }
        return l;
    }

    @Override
    public double getDouble() {
        if (this.remaining() < 8) {
            throw new BufferUnderflowException();
        }
        double d2 = 0.0;
        if (this.isDirect()) {
            this.validate();
            d2 = this.getDirectDouble(this.pointer, this.position(), this.order() != ByteOrder.NATIVE_ORDER);
        } else {
            byte[] byArray = this.array();
            int n = this.position() + this.arrayOffset();
            d2 = this.getDoubleFromByteArray(this.order(), byArray, n);
        }
        this.position(this.position() + 8);
        return d2;
    }

    @Override
    public double getDouble(int n) {
        if (n < 0 || n > this.limit() - 8) {
            throw new IndexOutOfBoundsException("index is negative or not smaller than the buffer's limit, minus seven");
        }
        double d2 = 0.0;
        if (this.isDirect()) {
            this.validate();
            d2 = this.getDirectDouble(this.pointer, n, this.order() != ByteOrder.NATIVE_ORDER);
        } else {
            byte[] byArray = this.array();
            d2 = this.getDoubleFromByteArray(this.order(), byArray, n += this.arrayOffset());
        }
        return d2;
    }

    @Override
    public char getChar() {
        if (this.remaining() < 2) {
            throw new BufferUnderflowException();
        }
        char c2 = '\u0000';
        if (this.isDirect()) {
            this.validate();
            c2 = this.getDirectChar(this.pointer, this.position(), this.order() != ByteOrder.NATIVE_ORDER);
        } else {
            byte[] byArray = this.array();
            int n = this.position() + this.arrayOffset();
            c2 = this.getCharFromByteArray(this.order(), byArray, n);
        }
        this.position(this.position() + 2);
        return c2;
    }

    @Override
    public char getChar(int n) {
        if (n < 0 || n > this.limit() - 2) {
            throw new IndexOutOfBoundsException("index is negative or not smaller than the buffer's limit, minus three");
        }
        char c2 = '\u0000';
        if (this.isDirect()) {
            this.validate();
            c2 = this.getDirectChar(this.pointer, n, this.order() != ByteOrder.NATIVE_ORDER);
        } else {
            byte[] byArray = this.array();
            c2 = this.getCharFromByteArray(this.order(), byArray, n += this.arrayOffset());
        }
        return c2;
    }

    @Override
    public short getShort() {
        if (this.remaining() < 2) {
            throw new BufferUnderflowException();
        }
        short s = 0;
        if (this.isDirect()) {
            this.validate();
            s = this.getDirectShort(this.pointer, this.position(), this.order() != ByteOrder.NATIVE_ORDER);
        } else {
            byte[] byArray = this.array();
            int n = this.position() + this.arrayOffset();
            s = this.getShortFromByteArray(this.order(), byArray, n);
        }
        this.position(this.position() + 2);
        return s;
    }

    @Override
    public short getShort(int n) {
        if (n < 0 || n > this.limit() - 2) {
            throw new IndexOutOfBoundsException("index is out of bounds");
        }
        short s = 0;
        if (this.isDirect()) {
            this.validate();
            s = this.getDirectShort(this.pointer, n, this.order() != ByteOrder.NATIVE_ORDER);
        } else {
            byte[] byArray = this.array();
            s = this.getShortFromByteArray(this.order(), byArray, n += this.arrayOffset());
        }
        return s;
    }

    @Override
    public boolean isDirect() {
        return this.isDirect;
    }

    @Override
    public ByteBuffer put(byte by) {
        if (this.position() >= this.limit()) {
            throw new BufferOverflowException();
        }
        if (this.isDirect()) {
            this.validate();
            this.putDirectByte(this.pointer, this.position(), by);
        } else {
            this.array()[this.position() + this.arrayOffset()] = by;
        }
        this.position(this.position() + 1);
        return this;
    }

    @Override
    public ByteBuffer put(int n, byte by) {
        if (n < 0 || n >= this.limit()) {
            throw new IndexOutOfBoundsException("index is out of bounds");
        }
        if (this.isDirect()) {
            this.validate();
            this.putDirectByte(this.pointer, n, by);
        } else {
            this.array()[n + this.arrayOffset()] = by;
        }
        return this;
    }

    @Override
    public ByteBuffer putFloat(float f2) {
        if (this.remaining() < 4) {
            throw new BufferOverflowException();
        }
        if (this.isDirect()) {
            this.validate();
            this.putDirectFloat(this.pointer, this.position(), f2, this.order() != ByteOrder.NATIVE_ORDER);
        } else {
            byte[] byArray = this.array();
            int n = this.position() + this.arrayOffset();
            this.putFloatToByteArray(this.order(), byArray, n, f2);
        }
        this.position(this.position() + 4);
        return this;
    }

    @Override
    public ByteBuffer putFloat(int n, float f2) {
        if (n < 0 || n > this.limit() - 4) {
            throw new IndexOutOfBoundsException("index is out of bounds");
        }
        if (this.isDirect()) {
            this.validate();
            this.putDirectFloat(this.pointer, n, f2, this.order() != ByteOrder.NATIVE_ORDER);
        } else {
            byte[] byArray = this.array();
            this.putFloatToByteArray(this.order(), byArray, n += this.arrayOffset(), f2);
        }
        return this;
    }

    @Override
    public ByteBuffer putInt(int n) {
        if (this.remaining() < 4) {
            throw new BufferOverflowException();
        }
        if (this.isDirect()) {
            this.validate();
            this.putDirectInt(this.pointer, this.position(), n, this.order() != ByteOrder.NATIVE_ORDER);
        } else {
            byte[] byArray = this.array();
            int n2 = this.position() + this.arrayOffset();
            this.putIntToByteArray(this.order(), byArray, n2, n);
        }
        this.position(this.position() + 4);
        return this;
    }

    @Override
    public ByteBuffer putInt(int n, int n2) {
        if (n < 0 || n > this.limit() - 4) {
            throw new IndexOutOfBoundsException("index is out of bounds");
        }
        if (this.isDirect()) {
            this.validate();
            this.putDirectInt(this.pointer, n, n2, this.order() != ByteOrder.NATIVE_ORDER);
        } else {
            byte[] byArray = this.array();
            this.putIntToByteArray(this.order(), byArray, n += this.arrayOffset(), n2);
        }
        return this;
    }

    @Override
    public ByteBuffer putLong(long l) {
        if (this.remaining() < 8) {
            throw new BufferOverflowException();
        }
        if (this.isDirect()) {
            this.validate();
            this.putDirectLong(this.pointer, this.position(), l, this.order() != ByteOrder.NATIVE_ORDER);
        } else {
            byte[] byArray = this.array();
            int n = this.position() + this.arrayOffset();
            this.putLongToByteArray(this.order(), byArray, n, l);
        }
        this.position(this.position() + 8);
        return this;
    }

    @Override
    public ByteBuffer putLong(int n, long l) {
        if (n < 0 || n > this.limit() - 8) {
            throw new IndexOutOfBoundsException("index is out of bounds");
        }
        if (this.isDirect()) {
            this.validate();
            this.putDirectLong(this.pointer, n, l, this.order() != ByteOrder.NATIVE_ORDER);
        } else {
            byte[] byArray = this.array();
            this.putLongToByteArray(this.order(), byArray, n += this.arrayOffset(), l);
        }
        return this;
    }

    @Override
    public ByteBuffer putDouble(double d2) {
        if (this.remaining() < 8) {
            throw new BufferOverflowException();
        }
        if (this.isDirect()) {
            this.validate();
            this.putDirectDouble(this.pointer, this.position(), d2, this.order() != ByteOrder.NATIVE_ORDER);
        } else {
            byte[] byArray = this.array();
            int n = this.position() + this.arrayOffset();
            this.putDoubleToByteArray(this.order(), byArray, n, d2);
        }
        this.position(this.position() + 8);
        return this;
    }

    @Override
    public ByteBuffer putDouble(int n, double d2) {
        if (n < 0 || n > this.limit() - 8) {
            throw new IndexOutOfBoundsException("index is out of bounds");
        }
        if (this.isDirect()) {
            this.validate();
            this.putDirectDouble(this.pointer, n, d2, this.order() != ByteOrder.NATIVE_ORDER);
        } else {
            byte[] byArray = this.array();
            this.putDoubleToByteArray(this.order(), byArray, n += this.arrayOffset(), d2);
        }
        return this;
    }

    @Override
    public ByteBuffer putChar(char c2) {
        if (this.remaining() < 2) {
            throw new BufferOverflowException();
        }
        if (this.isDirect()) {
            this.validate();
            this.putDirectChar(this.pointer, this.position(), c2, this.order() != ByteOrder.NATIVE_ORDER);
        } else {
            byte[] byArray = this.array();
            int n = this.position() + this.arrayOffset();
            this.putCharToByteArray(this.order(), byArray, n, c2);
        }
        this.position(this.position() + 2);
        return this;
    }

    @Override
    public ByteBuffer putChar(int n, char c2) {
        if (n < 0 || n > this.limit() - 2) {
            throw new IndexOutOfBoundsException("index is out of bounds");
        }
        if (this.isDirect()) {
            this.validate();
            this.putDirectChar(this.pointer, n, c2, this.order() != ByteOrder.NATIVE_ORDER);
        } else {
            byte[] byArray = this.array();
            this.putCharToByteArray(this.order(), byArray, n += this.arrayOffset(), c2);
        }
        return this;
    }

    @Override
    public ByteBuffer putShort(short s) {
        if (this.remaining() < 2) {
            throw new BufferOverflowException();
        }
        if (this.isDirect()) {
            this.validate();
            this.putDirectShort(this.pointer, this.position(), s, this.order() != ByteOrder.NATIVE_ORDER);
        } else {
            byte[] byArray = this.array();
            int n = this.position() + this.arrayOffset();
            this.putShortToByteArray(this.order(), byArray, n, s);
        }
        this.position(this.position() + 2);
        return this;
    }

    @Override
    public ByteBuffer putShort(int n, short s) {
        if (n < 0 || n > this.limit() - 2) {
            throw new IndexOutOfBoundsException("index is out of bounds");
        }
        if (this.isDirect()) {
            this.validate();
            this.putDirectShort(this.pointer, n, s, this.order() != ByteOrder.NATIVE_ORDER);
        } else {
            byte[] byArray = this.array();
            this.putShortToByteArray(this.order(), byArray, n += this.arrayOffset(), s);
        }
        return this;
    }

    @Override
    public ByteBuffer slice() {
        if (this.isDirect()) {
            this.validate();
            return new ByteBufferImpl(this.getDirectBytePointer(this.pointer, this.position()), this, this.remaining());
        }
        return new ByteBufferImpl(this.array(), 0, this.remaining(), this.position() + this.arrayOffset());
    }

    @Override
    public synchronized void dispose() {
        if (this.pointer != 0 && this.parent == null && !this.isExternal) {
            this.freePointer(this.pointer);
            this.pointer = 0;
        }
    }

    protected void finalize() {
        try {
            this.dispose();
        }
        finally {
            super.finalize();
        }
    }

    @Override
    public int getDirectPointer() {
        this.validate();
        return this.getDirectBytePointer(this.pointer, this.position());
    }

    public boolean isByteArray() {
        return this.hasArray();
    }

    @Override
    public byte getMaxOfArray(int n) {
        if (this.isDirect()) {
            this.validate();
            return this.getMaxByteOfArray(this.getDirectPointer(), n);
        }
        byte[] byArray = this.array();
        int n2 = this.position();
        byte by = byArray[n2];
        int n3 = n2 + 1;
        while (n3 < n2 + n) {
            if (byArray[n3] > by) {
                by = byArray[n3];
            }
            ++n3;
        }
        return by;
    }

    @Override
    public boolean isNoNegativeArray(int n) {
        int n2;
        if (this.isDirect()) {
            this.validate();
            return this.isNoNegativeByteArray(this.position(), n);
        }
        byte[] byArray = this.array();
        int n3 = n2 = this.position();
        while (n3 < n2 + n) {
            if (byArray[n3] < 0) {
                return false;
            }
            ++n3;
        }
        return true;
    }

    void getDirectByteArray(byte[] byArray, int n, int n2) {
        this.validate();
        this.getDirectByteArray(this.pointer, this.position(), n2, byArray, n);
    }

    float getDirectFloat(int n) {
        this.validate();
        return this.getDirectFloat(this.pointer, n, this.order() != ByteOrder.NATIVE_ORDER);
    }

    int getDirectInt(int n) {
        this.validate();
        return this.getDirectInt(this.pointer, n, this.order() != ByteOrder.NATIVE_ORDER);
    }

    long getDirectLong(int n) {
        this.validate();
        return this.getDirectLong(this.pointer, n, this.order() != ByteOrder.NATIVE_ORDER);
    }

    double getDirectDouble(int n) {
        this.validate();
        return this.getDirectDouble(this.pointer, n, this.order() != ByteOrder.NATIVE_ORDER);
    }

    char getDirectChar(int n) {
        this.validate();
        return this.getDirectChar(this.pointer, n, this.order() != ByteOrder.NATIVE_ORDER);
    }

    short getDirectShort(int n) {
        this.validate();
        return this.getDirectShort(this.pointer, n, this.order() != ByteOrder.NATIVE_ORDER);
    }

    void putDirectByteArray(byte[] byArray, int n, int n2) {
        this.validate();
        this.putDirectByteArray(this.pointer, this.position(), n2, byArray, n);
    }

    int getDirectPointer(int n) {
        this.validate();
        return this.getDirectBytePointer(this.pointer, n);
    }

    void putDirectFloat(int n, float f2) {
        this.validate();
        this.putDirectFloat(this.pointer, n, f2, this.order() != ByteOrder.NATIVE_ORDER);
    }

    void putDirectInt(int n, int n2) {
        this.validate();
        this.putDirectInt(this.pointer, n, n2, this.order() != ByteOrder.NATIVE_ORDER);
    }

    void putDirectLong(int n, long l) {
        this.validate();
        this.putDirectLong(this.pointer, n, l, this.order() != ByteOrder.NATIVE_ORDER);
    }

    void putDirectDouble(int n, double d2) {
        this.validate();
        this.putDirectDouble(this.pointer, n, d2, this.order() != ByteOrder.NATIVE_ORDER);
    }

    void putDirectChar(int n, char c2) {
        this.validate();
        this.putDirectChar(this.pointer, n, c2, this.order() != ByteOrder.NATIVE_ORDER);
    }

    void putDirectShort(int n, short s) {
        this.validate();
        this.putDirectShort(this.pointer, n, s, this.order() != ByteOrder.NATIVE_ORDER);
    }

    void getDirectFloatArray(int n, int n2, float[] fArray, int n3) {
        this.validate();
        this.getDirectFloatArray(this.pointer, n, n2, fArray, n3, this.order() != ByteOrder.NATIVE_ORDER);
    }

    void getDirectIntArray(int n, int n2, int[] nArray, int n3) {
        this.validate();
        this.getDirectIntArray(this.pointer, n, n2, nArray, n3, this.order() != ByteOrder.NATIVE_ORDER);
    }

    void getDirectLongArray(int n, int n2, long[] lArray, int n3) {
        this.validate();
        this.getDirectLongArray(this.pointer, n, n2, lArray, n3, this.order() != ByteOrder.NATIVE_ORDER);
    }

    void getDirectDoubleArray(int n, int n2, double[] dArray, int n3) {
        this.validate();
        this.getDirectDoubleArray(this.pointer, n, n2, dArray, n3, this.order() != ByteOrder.NATIVE_ORDER);
    }

    void getDirectCharArray(int n, int n2, char[] cArray, int n3) {
        this.validate();
        this.getDirectCharArray(this.pointer, n, n2, cArray, n3, this.order() != ByteOrder.NATIVE_ORDER);
    }

    void getDirectShortArray(int n, int n2, short[] sArray, int n3) {
        this.validate();
        this.getDirectShortArray(this.pointer, n, n2, sArray, n3, this.order() != ByteOrder.NATIVE_ORDER);
    }

    void putDirectFloatArray(int n, int n2, float[] fArray, int n3) {
        this.validate();
        this.putDirectFloatArray(this.pointer, n, n2, fArray, n3, this.order() != ByteOrder.NATIVE_ORDER);
    }

    void putDirectIntArray(int n, int n2, int[] nArray, int n3) {
        this.validate();
        this.putDirectIntArray(this.pointer, n, n2, nArray, n3, this.order() != ByteOrder.NATIVE_ORDER);
    }

    void putDirectLongArray(int n, int n2, long[] lArray, int n3) {
        this.validate();
        this.putDirectLongArray(this.pointer, n, n2, lArray, n3, this.order() != ByteOrder.NATIVE_ORDER);
    }

    void putDirectDoubleArray(int n, int n2, double[] dArray, int n3) {
        this.validate();
        this.putDirectDoubleArray(this.pointer, n, n2, dArray, n3, this.order() != ByteOrder.NATIVE_ORDER);
    }

    void putDirectCharArray(int n, int n2, char[] cArray, int n3) {
        this.validate();
        this.putDirectCharArray(this.pointer, n, n2, cArray, n3, this.order() != ByteOrder.NATIVE_ORDER);
    }

    void putDirectShortArray(int n, int n2, short[] sArray, int n3) {
        this.validate();
        this.putDirectShortArray(this.pointer, n, n2, sArray, n3, this.order() != ByteOrder.NATIVE_ORDER);
    }

    private void validate() {
        if (!this.isDirect()) {
            return;
        }
        if (this.parent != null) {
            this.parent.validate();
        } else if (this.pointer == 0) {
            throw new InvalidDirectBufferException();
        }
    }
}


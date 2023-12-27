/*
 * Decompiled with CFR 0.152.
 */
package java.nio;

import java.nio.Buffer;
import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBufferImpl;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

public abstract class ByteBuffer
extends Buffer
implements Comparable {
    private byte[] array = null;
    private int arrayOffset = 0;
    private ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;

    ByteBuffer(int n, int n2, int n3, byte[] byArray, int n4) {
        super(n, n2, n3);
        this.array = byArray;
        this.arrayOffset = n4;
    }

    ByteBuffer(int n, int n2, int n3) {
        super(n, n2, n3);
    }

    public static ByteBuffer allocateDirect(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("the capacity is a negative integer");
        }
        return new ByteBufferImpl(n);
    }

    public final byte[] array() {
        if (!this.hasArray()) {
            throw new UnsupportedOperationException("this buffer is not backed by an accessible array");
        }
        return this.array;
    }

    public final int arrayOffset() {
        if (!this.hasArray()) {
            throw new UnsupportedOperationException("this buffer is not backed by an accessible array");
        }
        return this.arrayOffset;
    }

    public abstract FloatBuffer asFloatBuffer() {
    }

    public abstract IntBuffer asIntBuffer() {
    }

    public abstract LongBuffer asLongBuffer() {
    }

    public abstract DoubleBuffer asDoubleBuffer() {
    }

    public abstract CharBuffer asCharBuffer() {
    }

    public abstract ShortBuffer asShortBuffer() {
    }

    @Override
    public int compareTo(Object object) {
        int n;
        if (object == null) {
            throw new NullPointerException("ob is null");
        }
        if (!(object instanceof ByteBuffer)) {
            throw new ClassCastException("the argument is not an byte buffer");
        }
        ByteBuffer byteBuffer = (ByteBuffer)object;
        int n2 = 0;
        int n3 = 0;
        int n4 = this.remaining();
        if (n4 > (n = byteBuffer.remaining())) {
            n2 = n;
            n3 = 1;
        } else if (n4 < n) {
            n2 = n4;
            n3 = -1;
        } else {
            n2 = n4;
            n3 = 0;
        }
        int n5 = this.position();
        int n6 = byteBuffer.position();
        int n7 = 0;
        while (n7 < n2) {
            if (this.get(n5 + n7) > byteBuffer.get(n6 + n7)) {
                return 1;
            }
            if (this.get(n5 + n7) < byteBuffer.get(n6 + n7)) {
                return -1;
            }
            ++n7;
        }
        return n3;
    }

    public boolean equals(Object object) {
        if (object == null) {
            throw new NullPointerException("ob is null");
        }
        return object instanceof ByteBuffer && this.compareTo(object) == 0;
    }

    public abstract byte get() {
    }

    public ByteBuffer get(byte[] byArray) {
        if (byArray == null) {
            throw new NullPointerException("dst is null");
        }
        if (this.remaining() < byArray.length) {
            throw new BufferUnderflowException();
        }
        this.get(byArray, 0, byArray.length);
        return this;
    }

    public ByteBuffer get(byte[] byArray, int n, int n2) {
        if (byArray == null) {
            throw new NullPointerException("dst is null");
        }
        if (this.remaining() < n2) {
            throw new BufferUnderflowException();
        }
        if (n < 0 || n > byArray.length) {
            throw new IndexOutOfBoundsException("offset is out of bounds");
        }
        if (n2 < 0 || n2 > byArray.length - n) {
            throw new IndexOutOfBoundsException("length is out of bounds");
        }
        if (this.isDirect()) {
            ((ByteBufferImpl)this).getDirectByteArray(byArray, n, n2);
        } else {
            System.arraycopy((Object)this.array, this.position() + this.arrayOffset, (Object)byArray, n, n2);
        }
        this.position(this.position() + n2);
        return this;
    }

    public abstract byte get(int n) {
    }

    public abstract float getFloat() {
    }

    public abstract float getFloat(int n) {
    }

    public abstract int getInt() {
    }

    public abstract int getInt(int n) {
    }

    public abstract long getLong() {
    }

    public abstract long getLong(int n) {
    }

    public abstract double getDouble() {
    }

    public abstract double getDouble(int n) {
    }

    public abstract char getChar() {
    }

    public abstract char getChar(int n) {
    }

    public abstract short getShort() {
    }

    public abstract short getShort(int n) {
    }

    public final boolean hasArray() {
        return this.array != null;
    }

    public int hashCode() {
        int n = 0;
        int n2 = 0;
        int n3 = this.remaining();
        int n4 = 0;
        while (n4 < n3) {
            n += this.get(n4 + this.position()) << (n2 += 4);
            if (n2 > 20) {
                n2 = 0;
            }
            ++n4;
        }
        return n;
    }

    public abstract boolean isDirect() {
    }

    public abstract ByteBuffer put(byte by) {
    }

    public final ByteBuffer put(byte[] byArray) {
        if (byArray == null) {
            throw new NullPointerException("src is null");
        }
        return this.put(byArray, 0, byArray.length);
    }

    public ByteBuffer put(byte[] byArray, int n, int n2) {
        if (byArray == null) {
            throw new NullPointerException("src is null");
        }
        if (this.remaining() < n2) {
            throw new BufferOverflowException();
        }
        if (n < 0 || n > byArray.length) {
            throw new IndexOutOfBoundsException("offset is out of bounds");
        }
        if (n2 < 0 || n2 > byArray.length - n) {
            throw new IndexOutOfBoundsException("length is out of bounds");
        }
        if (this.isDirect()) {
            ((ByteBufferImpl)this).putDirectByteArray(byArray, n, n2);
        } else {
            System.arraycopy((Object)byArray, n, (Object)this.array(), this.position() + this.arrayOffset, n2);
        }
        this.position(this.position() + n2);
        return this;
    }

    public ByteBuffer put(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            throw new NullPointerException("src is null");
        }
        int n = byteBuffer.remaining();
        if (n > this.remaining()) {
            throw new BufferOverflowException();
        }
        if (this == byteBuffer) {
            throw new IllegalArgumentException("the source buffer is this buffer");
        }
        byte[] byArray = new byte[n];
        byteBuffer.get(byArray);
        return this.put(byArray);
    }

    public abstract ByteBuffer put(int n, byte by) {
    }

    public abstract ByteBuffer putFloat(float f2) {
    }

    public abstract ByteBuffer putFloat(int n, float f2) {
    }

    public abstract ByteBuffer putInt(int n) {
    }

    public abstract ByteBuffer putInt(int n, int n2) {
    }

    public abstract ByteBuffer putLong(long l) {
    }

    public abstract ByteBuffer putLong(int n, long l) {
    }

    public abstract ByteBuffer putDouble(double d2) {
    }

    public abstract ByteBuffer putDouble(int n, double d2) {
    }

    public abstract ByteBuffer putChar(char c2) {
    }

    public abstract ByteBuffer putChar(int n, char c2) {
    }

    public abstract ByteBuffer putShort(int n, short s) {
    }

    public abstract ByteBuffer putShort(short s) {
    }

    public abstract ByteBuffer slice() {
    }

    public String toString() {
        return new StringBuffer("java.nio.ByteBuffer[pos=").append(this.position()).append(" lim=").append(this.limit()).append(" cap=").append(this.capacity()).append("]").toString();
    }

    public static ByteBuffer wrap(byte[] byArray) {
        if (byArray == null) {
            throw new NullPointerException("array is null");
        }
        return new ByteBufferImpl(byArray, 0, byArray.length, 0);
    }

    public static ByteBuffer wrap(byte[] byArray, int n, int n2) {
        if (byArray == null) {
            throw new NullPointerException("array is null");
        }
        if (n < 0 || n > byArray.length) {
            throw new IndexOutOfBoundsException("offset is out of bounds");
        }
        if (n2 < 0 || n2 > byArray.length - n) {
            throw new IndexOutOfBoundsException("length is out of bounds");
        }
        return new ByteBufferImpl(byArray, n, n2, 0);
    }

    public ByteBuffer order(ByteOrder byteOrder) {
        this.byteOrder = ByteOrder.BIG_ENDIAN.equals(byteOrder) ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN;
        return this;
    }

    public ByteOrder order() {
        return this.byteOrder;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package java.nio;

import java.nio.Buffer;
import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteOrder;
import java.nio.ShortBufferImpl;

public abstract class ShortBuffer
extends Buffer
implements Comparable {
    private short[] array = null;
    private int arrayOffset = 0;

    ShortBuffer(int n, int n2, int n3, short[] sArray, int n4) {
        super(n, n2, n3);
        this.array = sArray;
        this.arrayOffset = n4;
    }

    ShortBuffer(int n, int n2, int n3) {
        super(n, n2, n3);
    }

    public final short[] array() {
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

    @Override
    public int compareTo(Object object) {
        if (object == null) {
            throw new NullPointerException("ob is null");
        }
        if (!(object instanceof ShortBuffer)) {
            throw new ClassCastException("the argument is not an short buffer");
        }
        ShortBuffer shortBuffer = (ShortBuffer)object;
        int n = 0;
        int n2 = 0;
        if (this.remaining() > shortBuffer.remaining()) {
            n = shortBuffer.remaining();
            n2 = 1;
        } else if (this.remaining() < shortBuffer.remaining()) {
            n = this.remaining();
            n2 = -1;
        } else {
            n = this.remaining();
            n2 = 0;
        }
        int n3 = this.position();
        int n4 = shortBuffer.position();
        int n5 = 0;
        while (n5 < n) {
            if (this.get(n3 + n5) > shortBuffer.get(n4 + n5)) {
                return 1;
            }
            if (this.get(n3 + n5) < shortBuffer.get(n4 + n5)) {
                return -1;
            }
            ++n5;
        }
        return n2;
    }

    public boolean equals(Object object) {
        if (object == null) {
            throw new NullPointerException("ob is null");
        }
        return object instanceof ShortBuffer && this.compareTo(object) == 0;
    }

    public abstract short get() {
    }

    public ShortBuffer get(short[] sArray) {
        if (sArray == null) {
            throw new NullPointerException("dst is null");
        }
        if (this.remaining() < sArray.length) {
            throw new BufferUnderflowException();
        }
        this.get(sArray, 0, sArray.length);
        return this;
    }

    public ShortBuffer get(short[] sArray, int n, int n2) {
        if (sArray == null) {
            throw new NullPointerException("dst is null");
        }
        if (n < 0 || n > sArray.length) {
            throw new IndexOutOfBoundsException("offset is out of bounds");
        }
        if (n2 < 0 || n2 > sArray.length - n) {
            throw new IndexOutOfBoundsException("length is out of bounds");
        }
        if (this.remaining() < n2) {
            throw new BufferUnderflowException();
        }
        if (this.hasArray()) {
            System.arraycopy((Object)this.array, this.position() + this.arrayOffset(), (Object)sArray, n, n2);
        } else {
            ((ShortBufferImpl)this).getShortArray(sArray, n, n2);
        }
        this.position(this.position() + n2);
        return this;
    }

    public abstract short get(int n) {
    }

    public final boolean hasArray() {
        return this.array != null;
    }

    public int hashCode() {
        int n = 0;
        int n2 = 0;
        int n3 = this.remaining();
        int n4 = this.position();
        int n5 = 0;
        while (n5 < n3) {
            n += this.get(n5 + n4) << (n2 += 4);
            if (n2 > 20) {
                n2 = 0;
            }
            ++n5;
        }
        return n;
    }

    public abstract boolean isDirect() {
    }

    public abstract ShortBuffer put(short s) {
    }

    public final ShortBuffer put(short[] sArray) {
        if (sArray == null) {
            throw new NullPointerException("src is null");
        }
        return this.put(sArray, 0, sArray.length);
    }

    public ShortBuffer put(short[] sArray, int n, int n2) {
        if (sArray == null) {
            throw new NullPointerException("src is null");
        }
        if (n < 0 || n > sArray.length) {
            throw new IndexOutOfBoundsException("offset is out of bounds");
        }
        if (n2 < 0 || n2 > sArray.length - n) {
            throw new IndexOutOfBoundsException("length is out of bounds");
        }
        if (this.remaining() < n2) {
            throw new BufferOverflowException();
        }
        if (this.hasArray()) {
            System.arraycopy((Object)sArray, n, (Object)this.array(), this.position() + this.arrayOffset(), n2);
        } else {
            ((ShortBufferImpl)this).putShortArray(sArray, n, n2);
        }
        this.position(this.position() + n2);
        return this;
    }

    public ShortBuffer put(ShortBuffer shortBuffer) {
        if (shortBuffer == null) {
            throw new NullPointerException("srci is null");
        }
        if (shortBuffer.remaining() > this.remaining()) {
            throw new BufferOverflowException();
        }
        if (this == shortBuffer) {
            throw new IllegalArgumentException("the source buffer is this buffer");
        }
        short[] sArray = new short[shortBuffer.remaining()];
        shortBuffer.get(sArray);
        return this.put(sArray);
    }

    public abstract ShortBuffer put(int n, short s) {
    }

    public abstract ShortBuffer slice() {
    }

    public String toString() {
        return new StringBuffer("java.nio.ShortBuffer[pos=").append(this.position()).append(" lim=").append(this.limit()).append(" cap=").append(this.capacity()).append("]").toString();
    }

    public static ShortBuffer wrap(short[] sArray) {
        return new ShortBufferImpl(sArray, 0, sArray.length, sArray.length, 0);
    }

    public static ShortBuffer wrap(short[] sArray, int n, int n2) {
        if (n < 0 || n > sArray.length) {
            throw new IndexOutOfBoundsException("offset is out of bounds");
        }
        if (n2 < 0 || n2 > sArray.length - n) {
            throw new IndexOutOfBoundsException("length is out of bounds");
        }
        return new ShortBufferImpl(sArray, n, n2, sArray.length, 0);
    }

    public abstract ByteOrder order() {
    }
}


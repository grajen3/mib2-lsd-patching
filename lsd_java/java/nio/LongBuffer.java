/*
 * Decompiled with CFR 0.152.
 */
package java.nio;

import java.nio.Buffer;
import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteOrder;
import java.nio.LongBufferImpl;

public abstract class LongBuffer
extends Buffer
implements Comparable {
    private long[] array = null;
    private int arrayOffset = 0;

    LongBuffer(int n, int n2, int n3, long[] lArray, int n4) {
        super(n, n2, n3);
        this.array = lArray;
        this.arrayOffset = n4;
    }

    LongBuffer(int n, int n2, int n3) {
        super(n, n2, n3);
    }

    public final long[] array() {
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
        if (!(object instanceof LongBuffer)) {
            throw new ClassCastException("the argument is not an int buffer");
        }
        LongBuffer longBuffer = (LongBuffer)object;
        int n = 0;
        int n2 = 0;
        if (this.remaining() > longBuffer.remaining()) {
            n = longBuffer.remaining();
            n2 = 1;
        } else if (this.remaining() < longBuffer.remaining()) {
            n = this.remaining();
            n2 = -1;
        } else {
            n = this.remaining();
            n2 = 0;
        }
        int n3 = this.position();
        int n4 = longBuffer.position();
        int n5 = 0;
        while (n5 < n) {
            if (this.get(n3 + n5) > longBuffer.get(n4 + n5)) {
                return 1;
            }
            if (this.get(n3 + n5) < longBuffer.get(n4 + n5)) {
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
        return object instanceof LongBuffer && this.compareTo(object) == 0;
    }

    public abstract long get() {
    }

    public LongBuffer get(long[] lArray) {
        if (lArray == null) {
            throw new NullPointerException("dst is null");
        }
        if (this.remaining() < lArray.length) {
            throw new BufferUnderflowException();
        }
        this.get(lArray, 0, lArray.length);
        return this;
    }

    public LongBuffer get(long[] lArray, int n, int n2) {
        if (lArray == null) {
            throw new NullPointerException("dst is null");
        }
        if (n < 0 || n > lArray.length) {
            throw new IndexOutOfBoundsException("offset is out of bounds");
        }
        if (n2 < 0 || n2 > lArray.length - n) {
            throw new IndexOutOfBoundsException("length is out of bounds");
        }
        if (this.remaining() < n2) {
            throw new BufferUnderflowException();
        }
        if (this.hasArray()) {
            System.arraycopy((Object)this.array, this.position() + this.arrayOffset(), (Object)lArray, n, n2);
            this.position(this.position() + n2);
        } else {
            ((LongBufferImpl)this).getLongArray(lArray, n, n2);
        }
        return this;
    }

    public abstract long get(int n) {
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
            n = (int)((long)n + (this.get(n5 + n4) << (n2 += 4)));
            if (n2 > 20) {
                n2 = 0;
            }
            ++n5;
        }
        return n;
    }

    public abstract boolean isDirect() {
    }

    public abstract LongBuffer put(long l) {
    }

    public final LongBuffer put(long[] lArray) {
        if (lArray == null) {
            throw new NullPointerException("src is null");
        }
        return this.put(lArray, 0, lArray.length);
    }

    public LongBuffer put(long[] lArray, int n, int n2) {
        if (lArray == null) {
            throw new NullPointerException("src is null");
        }
        if (n < 0 || n > lArray.length) {
            throw new IndexOutOfBoundsException("offset is out of bounds");
        }
        if (n2 < 0 || n2 > lArray.length - n) {
            throw new IndexOutOfBoundsException("length is out of bounds");
        }
        if (this.remaining() < n2) {
            throw new BufferOverflowException();
        }
        if (this.hasArray()) {
            System.arraycopy((Object)lArray, n, (Object)this.array(), this.position() + this.arrayOffset(), n2);
            this.position(this.position() + n2);
        } else {
            ((LongBufferImpl)this).putLongArray(lArray, n, n2);
        }
        return this;
    }

    public LongBuffer put(LongBuffer longBuffer) {
        if (longBuffer == null) {
            throw new NullPointerException("src is null");
        }
        if (longBuffer.remaining() > this.remaining()) {
            throw new BufferOverflowException();
        }
        if (this == longBuffer) {
            throw new IllegalArgumentException("the source buffer is this buffer");
        }
        long[] lArray = new long[longBuffer.remaining()];
        longBuffer.get(lArray);
        return this.put(lArray);
    }

    public abstract LongBuffer put(int n, long l) {
    }

    public abstract LongBuffer slice() {
    }

    public String toString() {
        return new StringBuffer("java.nio.LongBuffer[pos=").append(this.position()).append(" lim=").append(this.limit()).append(" cap=").append(this.capacity()).append("]").toString();
    }

    public static LongBuffer wrap(long[] lArray) {
        if (lArray == null) {
            throw new NullPointerException("array is null");
        }
        return new LongBufferImpl(lArray, 0, lArray.length, lArray.length, 0);
    }

    public static LongBuffer wrap(long[] lArray, int n, int n2) {
        if (lArray == null) {
            throw new NullPointerException("array is null");
        }
        if (n < 0 || n > lArray.length) {
            throw new IndexOutOfBoundsException("offset is out of bounds");
        }
        if (n2 < 0 || n2 > lArray.length - n) {
            throw new IndexOutOfBoundsException("length is negative");
        }
        return new LongBufferImpl(lArray, n, n2, lArray.length, 0);
    }

    public abstract ByteOrder order() {
    }
}


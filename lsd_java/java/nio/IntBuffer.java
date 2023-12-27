/*
 * Decompiled with CFR 0.152.
 */
package java.nio;

import java.nio.Buffer;
import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteOrder;
import java.nio.IntBufferImpl;

public abstract class IntBuffer
extends Buffer
implements Comparable {
    private int[] array = null;
    private int arrayOffset = 0;

    IntBuffer(int n, int n2, int n3, int[] nArray, int n4) {
        super(n, n2, n3);
        this.array = nArray;
        this.arrayOffset = n4;
    }

    IntBuffer(int n, int n2, int n3) {
        super(n, n2, n3);
    }

    public final int[] array() {
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
        if (!(object instanceof IntBuffer)) {
            throw new ClassCastException("the argument is not an int buffer");
        }
        IntBuffer intBuffer = (IntBuffer)object;
        int n = 0;
        int n2 = 0;
        if (this.remaining() > intBuffer.remaining()) {
            n = intBuffer.remaining();
            n2 = 1;
        } else if (this.remaining() < intBuffer.remaining()) {
            n = this.remaining();
            n2 = -1;
        } else {
            n = this.remaining();
            n2 = 0;
        }
        int n3 = this.position();
        int n4 = intBuffer.position();
        int n5 = 0;
        while (n5 < n) {
            if (this.get(n3 + n5) > intBuffer.get(n4 + n5)) {
                return 1;
            }
            if (this.get(n3 + n5) < intBuffer.get(n4 + n5)) {
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
        return object instanceof IntBuffer && this.compareTo(object) == 0;
    }

    public abstract int get() {
    }

    public IntBuffer get(int[] nArray) {
        if (nArray == null) {
            throw new NullPointerException("dst is null");
        }
        if (this.remaining() < nArray.length) {
            throw new BufferUnderflowException();
        }
        this.get(nArray, 0, nArray.length);
        return this;
    }

    public IntBuffer get(int[] nArray, int n, int n2) {
        if (nArray == null) {
            throw new NullPointerException("dst is null");
        }
        if (n < 0 || n > nArray.length) {
            throw new IndexOutOfBoundsException("offset is out of bounds");
        }
        if (n2 < 0 || n2 > nArray.length - n) {
            throw new IndexOutOfBoundsException("length is out of bounds");
        }
        if (this.remaining() < n2) {
            throw new BufferUnderflowException();
        }
        if (this.hasArray()) {
            System.arraycopy((Object)this.array, this.position() + this.arrayOffset(), (Object)nArray, n, n2);
            this.position(this.position() + n2);
        } else {
            ((IntBufferImpl)this).getIntArray(nArray, n, n2);
        }
        return this;
    }

    public abstract int get(int n) {
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

    public abstract IntBuffer put(int n) {
    }

    public final IntBuffer put(int[] nArray) {
        if (nArray == null) {
            throw new NullPointerException("src is null");
        }
        return this.put(nArray, 0, nArray.length);
    }

    public IntBuffer put(int[] nArray, int n, int n2) {
        if (nArray == null) {
            throw new NullPointerException("src is null");
        }
        if (n < 0 || n > nArray.length) {
            throw new IndexOutOfBoundsException("offset is out of bounds");
        }
        if (n2 < 0 || n2 > nArray.length - n) {
            throw new IndexOutOfBoundsException("length is out of bounds");
        }
        if (this.remaining() < n2) {
            throw new BufferOverflowException();
        }
        if (this.hasArray()) {
            System.arraycopy((Object)nArray, n, (Object)this.array(), this.position() + this.arrayOffset(), n2);
            this.position(this.position() + n2);
        } else {
            ((IntBufferImpl)this).putIntArray(nArray, n, n2);
        }
        return this;
    }

    public IntBuffer put(IntBuffer intBuffer) {
        if (intBuffer == null) {
            throw new NullPointerException("src is null");
        }
        if (intBuffer.remaining() > this.remaining()) {
            throw new BufferOverflowException();
        }
        if (this == intBuffer) {
            throw new IllegalArgumentException("the source buffer is this buffer");
        }
        int[] nArray = new int[intBuffer.remaining()];
        intBuffer.get(nArray);
        return this.put(nArray);
    }

    public abstract IntBuffer put(int n, int n2) {
    }

    public abstract IntBuffer slice() {
    }

    public String toString() {
        return new StringBuffer("java.nio.IntBuffer[pos=").append(this.position()).append(" lim=").append(this.limit()).append(" cap=").append(this.capacity()).append("]").toString();
    }

    public static IntBuffer wrap(int[] nArray) {
        if (nArray == null) {
            throw new NullPointerException("array is null");
        }
        return new IntBufferImpl(nArray, 0, nArray.length, nArray.length, 0);
    }

    public static IntBuffer wrap(int[] nArray, int n, int n2) {
        if (nArray == null) {
            throw new NullPointerException("array is null");
        }
        if (n < 0 || n > nArray.length) {
            throw new IndexOutOfBoundsException("offset is out of bounds");
        }
        if (n2 < 0 || n2 > nArray.length - n) {
            throw new IndexOutOfBoundsException("length is negative");
        }
        return new IntBufferImpl(nArray, n, n2, nArray.length, 0);
    }

    public abstract ByteOrder order() {
    }
}


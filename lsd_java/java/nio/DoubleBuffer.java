/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package java.nio;

import java.nio.Buffer;
import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteOrder;
import java.nio.DoubleBufferImpl;

public abstract class DoubleBuffer
extends Buffer
implements Comparable {
    private double[] array = null;
    private int arrayOffset = 0;

    DoubleBuffer(int n, int n2, int n3, double[] dArray, int n4) {
        super(n, n2, n3);
        this.array = dArray;
        this.arrayOffset = n4;
    }

    DoubleBuffer(int n, int n2, int n3) {
        super(n, n2, n3);
    }

    public final double[] array() {
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
        int n;
        if (object == null) {
            throw new NullPointerException("ob is null");
        }
        if (!(object instanceof DoubleBuffer)) {
            throw new ClassCastException("the argument is not an double buffer");
        }
        DoubleBuffer doubleBuffer = (DoubleBuffer)object;
        int n2 = 0;
        int n3 = 0;
        int n4 = this.remaining();
        if (n4 > (n = doubleBuffer.remaining())) {
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
        int n6 = doubleBuffer.position();
        int n7 = 0;
        while (n7 < n2) {
            double d2;
            double d3 = this.get(n5 + n7);
            if (d3 != (d2 = doubleBuffer.get(n6 + n7)) && (d3 == d3 || d2 == d2)) {
                if (d3 < d2) {
                    return -1;
                }
                return 1;
            }
            ++n7;
        }
        return n3;
    }

    public boolean equals(Object object) {
        if (object == null) {
            throw new NullPointerException("ob is null");
        }
        return object instanceof DoubleBuffer && this.compareTo(object) == 0;
    }

    public abstract double get() {
    }

    public DoubleBuffer get(double[] dArray) {
        if (dArray == null) {
            throw new NullPointerException("dst is null");
        }
        if (this.remaining() < dArray.length) {
            throw new BufferUnderflowException();
        }
        this.get(dArray, 0, dArray.length);
        return this;
    }

    public DoubleBuffer get(double[] dArray, int n, int n2) {
        if (dArray == null) {
            throw new NullPointerException("dst is null");
        }
        if (n < 0 || n > dArray.length) {
            throw new IndexOutOfBoundsException("offset is out of bounds");
        }
        if (n2 < 0 || n2 > dArray.length - n) {
            throw new IndexOutOfBoundsException("length is out of bounds");
        }
        if (this.remaining() < n2) {
            throw new BufferUnderflowException();
        }
        if (this.hasArray()) {
            System.arraycopy((Object)this.array, this.position() + this.arrayOffset(), (Object)dArray, n, n2);
            this.position(this.position() + n2);
        } else {
            ((DoubleBufferImpl)this).getDoubleArray(dArray, n, n2);
        }
        return this;
    }

    public abstract double get(int n) {
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
            n = (int)((long)n + (Double.doubleToLongBits((double)this.get(n4 + this.position())) << (n2 += 4)));
            if (n2 > 20) {
                n2 = 0;
            }
            ++n4;
        }
        return n;
    }

    public abstract boolean isDirect() {
    }

    public abstract DoubleBuffer put(double d2) {
    }

    public final DoubleBuffer put(double[] dArray) {
        if (dArray == null) {
            throw new NullPointerException("src is null");
        }
        return this.put(dArray, 0, dArray.length);
    }

    public DoubleBuffer put(double[] dArray, int n, int n2) {
        if (dArray == null) {
            throw new NullPointerException("src is null");
        }
        if (n < 0 || n > dArray.length) {
            throw new IndexOutOfBoundsException("offset is out of bounds");
        }
        if (n2 < 0 || n2 > dArray.length - n) {
            throw new IndexOutOfBoundsException("length is out of bounds");
        }
        if (this.remaining() < n2) {
            throw new BufferOverflowException();
        }
        if (this.hasArray()) {
            System.arraycopy((Object)dArray, n, (Object)this.array(), this.position() + this.arrayOffset(), n2);
            this.position(this.position() + n2);
        } else {
            ((DoubleBufferImpl)this).putDoubleArray(dArray, n, n2);
        }
        return this;
    }

    public DoubleBuffer put(DoubleBuffer doubleBuffer) {
        if (doubleBuffer == null) {
            throw new NullPointerException("src is null");
        }
        if (doubleBuffer.remaining() > this.remaining()) {
            throw new BufferOverflowException();
        }
        if (this == doubleBuffer) {
            throw new IllegalArgumentException("the source buffer is this buffer");
        }
        double[] dArray = new double[doubleBuffer.remaining()];
        doubleBuffer.get(dArray);
        return this.put(dArray);
    }

    public abstract DoubleBuffer put(int n, double d2) {
    }

    public abstract DoubleBuffer slice() {
    }

    public String toString() {
        return new StringBuffer("java.nio.DoubleBuffer[pos=").append(this.position()).append(" lim=").append(this.limit()).append(" cap=").append(this.capacity()).append("]").toString();
    }

    public static DoubleBuffer wrap(double[] dArray) {
        if (dArray == null) {
            throw new NullPointerException("array is null");
        }
        return new DoubleBufferImpl(dArray, 0, dArray.length, dArray.length, 0);
    }

    public static DoubleBuffer wrap(double[] dArray, int n, int n2) {
        if (dArray == null) {
            throw new NullPointerException("array is null");
        }
        if (n < 0) {
            throw new IndexOutOfBoundsException("offset is negative");
        }
        if (n > dArray.length) {
            throw new IndexOutOfBoundsException("offset is larger than array.length");
        }
        if (n2 < 0) {
            throw new IndexOutOfBoundsException("length is negative");
        }
        if (n2 > dArray.length - n) {
            throw new IndexOutOfBoundsException("length is larger than array.length - offset");
        }
        return new DoubleBufferImpl(dArray, n, n2, dArray.length, 0);
    }

    public abstract ByteOrder order() {
    }
}


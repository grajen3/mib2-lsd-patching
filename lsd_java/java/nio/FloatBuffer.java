/*
 * Decompiled with CFR 0.152.
 */
package java.nio;

import java.nio.Buffer;
import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteOrder;
import java.nio.FloatBufferImpl;

public abstract class FloatBuffer
extends Buffer
implements Comparable {
    private float[] array = null;
    private int arrayOffset = 0;

    FloatBuffer(int n, int n2, int n3, float[] fArray, int n4) {
        super(n, n2, n3);
        this.array = fArray;
        this.arrayOffset = n4;
    }

    FloatBuffer(int n, int n2, int n3) {
        super(n, n2, n3);
    }

    public final float[] array() {
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
        if (!(object instanceof FloatBuffer)) {
            throw new ClassCastException("the argument is not an float buffer");
        }
        FloatBuffer floatBuffer = (FloatBuffer)object;
        int n2 = 0;
        int n3 = 0;
        int n4 = this.remaining();
        if (n4 > (n = floatBuffer.remaining())) {
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
        int n6 = floatBuffer.position();
        int n7 = 0;
        while (n7 < n2) {
            float f2;
            float f3 = this.get(n5 + n7);
            if (f3 != (f2 = floatBuffer.get(n6 + n7)) && (f3 == f3 || f2 == f2)) {
                if (f3 < f2) {
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
        return object instanceof FloatBuffer && this.compareTo(object) == 0;
    }

    public abstract float get() {
    }

    public FloatBuffer get(float[] fArray) {
        if (fArray == null) {
            throw new NullPointerException("dst is null");
        }
        if (this.remaining() < fArray.length) {
            throw new BufferUnderflowException();
        }
        this.get(fArray, 0, fArray.length);
        return this;
    }

    public FloatBuffer get(float[] fArray, int n, int n2) {
        if (fArray == null) {
            throw new NullPointerException("dst is null");
        }
        if (n < 0 || n > fArray.length) {
            throw new IndexOutOfBoundsException("offset is out of bounds");
        }
        if (n2 < 0 || n2 > fArray.length - n) {
            throw new IndexOutOfBoundsException("length is out of bounds");
        }
        if (this.remaining() < n2) {
            throw new BufferUnderflowException();
        }
        if (this.hasArray()) {
            System.arraycopy((Object)this.array, this.position() + this.arrayOffset(), (Object)fArray, n, n2);
            this.position(this.position() + n2);
        } else {
            ((FloatBufferImpl)this).getFloatArray(fArray, n, n2);
        }
        return this;
    }

    public abstract float get(int n) {
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
            n += Float.floatToIntBits(this.get(n4 + this.position())) << (n2 += 4);
            if (n2 > 20) {
                n2 = 0;
            }
            ++n4;
        }
        return n;
    }

    public abstract boolean isDirect() {
    }

    public abstract FloatBuffer put(float f2) {
    }

    public final FloatBuffer put(float[] fArray) {
        if (fArray == null) {
            throw new NullPointerException("src is null");
        }
        return this.put(fArray, 0, fArray.length);
    }

    public FloatBuffer put(float[] fArray, int n, int n2) {
        if (fArray == null) {
            throw new NullPointerException("src is null");
        }
        if (n < 0 || n > fArray.length) {
            throw new IndexOutOfBoundsException("offset is out of bounds");
        }
        if (n2 < 0 || n2 > fArray.length - n) {
            throw new IndexOutOfBoundsException("length is out of bounds");
        }
        if (this.remaining() < n2) {
            throw new BufferOverflowException();
        }
        if (this.hasArray()) {
            System.arraycopy((Object)fArray, n, (Object)this.array(), this.position() + this.arrayOffset(), n2);
            this.position(this.position() + n2);
        } else {
            ((FloatBufferImpl)this).putFloatArray(fArray, n, n2);
        }
        return this;
    }

    public FloatBuffer put(FloatBuffer floatBuffer) {
        if (floatBuffer == null) {
            throw new NullPointerException("src is null");
        }
        if (floatBuffer.remaining() > this.remaining()) {
            throw new BufferOverflowException();
        }
        if (this == floatBuffer) {
            throw new IllegalArgumentException("the source buffer is this buffer");
        }
        float[] fArray = new float[floatBuffer.remaining()];
        floatBuffer.get(fArray);
        return this.put(fArray);
    }

    public abstract FloatBuffer put(int n, float f2) {
    }

    public abstract FloatBuffer slice() {
    }

    public String toString() {
        return new StringBuffer("java.nio.FloatBuffer[pos=").append(this.position()).append(" lim=").append(this.limit()).append(" cap=").append(this.capacity()).append("]").toString();
    }

    public static FloatBuffer wrap(float[] fArray) {
        if (fArray == null) {
            throw new NullPointerException("array is null");
        }
        return new FloatBufferImpl(fArray, 0, fArray.length, fArray.length, 0);
    }

    public static FloatBuffer wrap(float[] fArray, int n, int n2) {
        if (fArray == null) {
            throw new NullPointerException("array is null");
        }
        if (n < 0) {
            throw new IndexOutOfBoundsException("offset is negative");
        }
        if (n > fArray.length) {
            throw new IndexOutOfBoundsException("offset is larger than array.length");
        }
        if (n2 < 0) {
            throw new IndexOutOfBoundsException("length is negative");
        }
        if (n2 > fArray.length - n) {
            throw new IndexOutOfBoundsException("length is larger than array.length - offset");
        }
        return new FloatBufferImpl(fArray, n, n2, fArray.length, 0);
    }

    public abstract ByteOrder order() {
    }
}


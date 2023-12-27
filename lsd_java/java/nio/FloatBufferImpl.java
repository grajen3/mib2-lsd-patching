/*
 * Decompiled with CFR 0.152.
 */
package java.nio;

import com.ibm.oti.nio.BufferUtil;
import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBufferImpl;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

class FloatBufferImpl
extends FloatBuffer
implements BufferUtil {
    private ByteBufferImpl byteBuf = null;
    private byte[] byteArray = null;
    private int byteOffset = 0;

    FloatBufferImpl(float[] fArray, int n, int n2, int n3, int n4) {
        super(n, n + n2, n3, fArray, n4);
    }

    FloatBufferImpl(ByteBufferImpl byteBufferImpl, int n, int n2) {
        super(0, n, n);
        this.byteBuf = byteBufferImpl;
        this.address = byteBufferImpl.address + (long)n2;
        this.byteOffset = n2;
    }

    FloatBufferImpl(ByteBufferImpl byteBufferImpl, byte[] byArray, int n, int n2) {
        super(0, n, n);
        this.byteBuf = byteBufferImpl;
        this.byteArray = byArray;
        this.byteOffset = n2;
    }

    @Override
    public float get() {
        if (this.position() >= this.limit()) {
            throw new BufferUnderflowException();
        }
        float f2 = 0.0f;
        if (this.isDirect()) {
            f2 = this.byteBuf.getDirectFloat(this.byteOffset + this.position() * 4);
        } else if (this.hasArray()) {
            f2 = this.array()[this.position() + this.arrayOffset()];
        } else {
            int n = this.byteOffset + this.position() * 4;
            f2 = this.getFloatFromByteArray(this.order(), this.byteArray, n);
        }
        this.position(this.position() + 1);
        return f2;
    }

    @Override
    public float get(int n) {
        if (n < 0 || n >= this.limit()) {
            throw new IndexOutOfBoundsException("index is out of bounds");
        }
        float f2 = 0.0f;
        if (this.isDirect()) {
            f2 = this.byteBuf.getDirectFloat(this.byteOffset + n * 4);
        } else if (this.hasArray()) {
            f2 = this.array()[n + this.arrayOffset()];
        } else {
            int n2 = this.byteOffset + n * 4;
            f2 = this.getFloatFromByteArray(this.order(), this.byteArray, n2);
        }
        return f2;
    }

    @Override
    public boolean isDirect() {
        return this.byteBuf != null ? this.byteBuf.isDirect() : false;
    }

    @Override
    public FloatBuffer put(float f2) {
        if (this.position() >= this.limit()) {
            throw new BufferOverflowException();
        }
        if (this.isDirect()) {
            this.byteBuf.putDirectFloat(this.byteOffset + this.position() * 4, f2);
        } else if (this.hasArray()) {
            this.array()[this.position()] = f2;
        } else {
            int n = this.byteOffset + this.position() * 4;
            this.putFloatToByteArray(this.order(), this.byteArray, n, f2);
        }
        this.position(this.position() + 1);
        return this;
    }

    @Override
    public FloatBuffer put(int n, float f2) {
        if (n < 0 || n >= this.limit()) {
            throw new IndexOutOfBoundsException("index is out of bounds");
        }
        if (this.isDirect()) {
            this.byteBuf.putDirectFloat(this.byteOffset + n * 4, f2);
        } else if (this.hasArray()) {
            this.array()[n + this.arrayOffset()] = f2;
        } else {
            int n2 = this.byteOffset + n * 4;
            this.putFloatToByteArray(this.order(), this.byteArray, n2, f2);
        }
        return this;
    }

    @Override
    public FloatBuffer slice() {
        if (this.isDirect()) {
            return new FloatBufferImpl(this.byteBuf, this.remaining(), this.byteOffset + this.position() * 4);
        }
        if (this.hasArray()) {
            return new FloatBufferImpl(this.array(), 0, this.remaining(), this.remaining(), this.position() + this.arrayOffset());
        }
        return new FloatBufferImpl(this.byteBuf, this.byteArray, this.remaining(), this.byteOffset + this.position() * 4);
    }

    @Override
    public int getDirectPointer() {
        return this.isDirect() ? this.byteBuf.getDirectPointer(this.byteOffset + this.position() * 4) : 0;
    }

    void getFloatArray(float[] fArray, int n, int n2) {
        if (this.isDirect()) {
            this.byteBuf.getDirectFloatArray(this.byteOffset + this.position() * 4, n2, fArray, n);
        } else if (!this.hasArray()) {
            int n3 = this.byteOffset + this.position() * 4;
            int n4 = n;
            while (n4 < n + n2) {
                fArray[n4] = this.getFloatFromByteArray(this.order(), this.byteArray, n3);
                n3 += 4;
                ++n4;
            }
        }
        this.position(this.position() + n2);
    }

    void putFloatArray(float[] fArray, int n, int n2) {
        if (this.isDirect()) {
            this.byteBuf.putDirectFloatArray(this.byteOffset + this.position() * 4, n2, fArray, n);
        } else if (!this.hasArray()) {
            int n3 = this.byteOffset + this.position() * 4;
            int n4 = n;
            while (n4 < n + n2) {
                this.putFloatToByteArray(this.order(), this.byteArray, n3, fArray[n4]);
                n3 += 4;
                ++n4;
            }
        }
        this.position(this.position() + n2);
    }

    @Override
    public ByteOrder order() {
        if (this.byteBuf != null) {
            return this.byteBuf.order();
        }
        return ByteOrder.nativeOrder();
    }
}


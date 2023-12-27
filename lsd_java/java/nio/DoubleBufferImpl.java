/*
 * Decompiled with CFR 0.152.
 */
package java.nio;

import com.ibm.oti.nio.BufferUtil;
import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBufferImpl;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;

class DoubleBufferImpl
extends DoubleBuffer
implements BufferUtil {
    private ByteBufferImpl byteBuf = null;
    private byte[] byteArray = null;
    private int byteOffset = 0;

    DoubleBufferImpl(double[] dArray, int n, int n2, int n3, int n4) {
        super(n, n + n2, n3, dArray, n4);
    }

    DoubleBufferImpl(ByteBufferImpl byteBufferImpl, int n, int n2) {
        super(0, n, n);
        this.byteBuf = byteBufferImpl;
        this.address = byteBufferImpl.address + (long)n2;
        this.byteOffset = n2;
    }

    DoubleBufferImpl(ByteBufferImpl byteBufferImpl, byte[] byArray, int n, int n2) {
        super(0, n, n);
        this.byteBuf = byteBufferImpl;
        this.byteArray = byArray;
        this.byteOffset = n2;
    }

    @Override
    public double get() {
        if (this.position() >= this.limit()) {
            throw new BufferUnderflowException();
        }
        double d2 = 0.0;
        if (this.isDirect()) {
            d2 = this.byteBuf.getDirectDouble(this.byteOffset + this.position() * 8);
        } else if (this.hasArray()) {
            d2 = this.array()[this.position() + this.arrayOffset()];
        } else {
            int n = this.byteOffset + this.position() * 8;
            d2 = this.getDoubleFromByteArray(this.order(), this.byteArray, n);
        }
        this.position(this.position() + 1);
        return d2;
    }

    @Override
    public double get(int n) {
        if (n < 0 || n >= this.limit()) {
            throw new IndexOutOfBoundsException("index is out of bounds");
        }
        double d2 = 0.0;
        if (this.isDirect()) {
            d2 = this.byteBuf.getDirectDouble(this.byteOffset + n * 8);
        } else if (this.hasArray()) {
            d2 = this.array()[n + this.arrayOffset()];
        } else {
            int n2 = this.byteOffset + n * 8;
            d2 = this.getDoubleFromByteArray(this.order(), this.byteArray, n2);
        }
        return d2;
    }

    @Override
    public boolean isDirect() {
        return this.byteBuf != null ? this.byteBuf.isDirect() : false;
    }

    @Override
    public DoubleBuffer put(double d2) {
        if (this.position() >= this.limit()) {
            throw new BufferOverflowException();
        }
        if (this.isDirect()) {
            this.byteBuf.putDirectDouble(this.byteOffset + this.position() * 8, d2);
        } else if (this.hasArray()) {
            this.array()[this.position()] = d2;
        } else {
            int n = this.byteOffset + this.position() * 8;
            this.putDoubleToByteArray(this.order(), this.byteArray, n, d2);
        }
        this.position(this.position() + 1);
        return this;
    }

    @Override
    public DoubleBuffer put(int n, double d2) {
        if (n < 0 || n >= this.limit()) {
            throw new IndexOutOfBoundsException("index is out of bounds");
        }
        if (this.isDirect()) {
            this.byteBuf.putDirectDouble(this.byteOffset + n * 8, d2);
        } else if (this.hasArray()) {
            this.array()[n + this.arrayOffset()] = d2;
        } else {
            int n2 = this.byteOffset + n * 8;
            this.putDoubleToByteArray(this.order(), this.byteArray, n2, d2);
        }
        return this;
    }

    @Override
    public DoubleBuffer slice() {
        if (this.isDirect()) {
            return new DoubleBufferImpl(this.byteBuf, this.remaining(), this.byteOffset + this.position() * 8);
        }
        if (this.hasArray()) {
            return new DoubleBufferImpl(this.array(), 0, this.remaining(), this.remaining(), this.position() + this.arrayOffset());
        }
        return new DoubleBufferImpl(this.byteBuf, this.byteArray, this.remaining(), this.byteOffset + this.position() * 8);
    }

    @Override
    public int getDirectPointer() {
        return this.isDirect() ? this.byteBuf.getDirectPointer(this.byteOffset + this.position() * 8) : 0;
    }

    void getDoubleArray(double[] dArray, int n, int n2) {
        if (this.isDirect()) {
            this.byteBuf.getDirectDoubleArray(this.byteOffset + this.position() * 8, n2, dArray, n);
        } else if (!this.hasArray()) {
            int n3 = this.byteOffset + this.position() * 8;
            int n4 = n;
            while (n4 < n + n2) {
                dArray[n4] = this.getDoubleFromByteArray(this.order(), this.byteArray, n3);
                n3 += 8;
                ++n4;
            }
        }
        this.position(this.position() + n2);
    }

    void putDoubleArray(double[] dArray, int n, int n2) {
        if (this.isDirect()) {
            this.byteBuf.putDirectDoubleArray(this.byteOffset + this.position() * 8, n2, dArray, n);
        } else if (!this.hasArray()) {
            int n3 = this.byteOffset + this.position() * 8;
            int n4 = n;
            while (n4 < n + n2) {
                this.putDoubleToByteArray(this.order(), this.byteArray, n3, dArray[n4]);
                n3 += 8;
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


/*
 * Decompiled with CFR 0.152.
 */
package java.nio;

import com.ibm.oti.nio.BufferUtil;
import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBufferImpl;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

class ShortBufferImpl
extends ShortBuffer
implements BufferUtil {
    private ByteBufferImpl byteBuf = null;
    private byte[] byteArray = null;
    private int byteOffset = 0;

    private native short getMaxShortOfArray(int n, int n2) {
    }

    private native boolean isNoNegativeShortArray(int n, int n2) {
    }

    ShortBufferImpl(short[] sArray, int n, int n2, int n3, int n4) {
        super(n, n + n2, n3, sArray, n4);
    }

    ShortBufferImpl(ByteBufferImpl byteBufferImpl, int n, int n2) {
        super(0, n, n);
        this.byteBuf = byteBufferImpl;
        this.address = byteBufferImpl.address + (long)n2;
        this.byteOffset = n2;
    }

    ShortBufferImpl(ByteBufferImpl byteBufferImpl, byte[] byArray, int n, int n2) {
        super(0, n, n);
        this.byteBuf = byteBufferImpl;
        this.byteArray = byArray;
        this.byteOffset = n2;
    }

    @Override
    public short get() {
        if (this.position() >= this.limit()) {
            throw new BufferUnderflowException();
        }
        short s = 0;
        if (this.isDirect()) {
            s = this.byteBuf.getDirectShort(this.byteOffset + this.position() * 2);
        } else if (this.hasArray()) {
            s = this.array()[this.position() + this.arrayOffset()];
        } else {
            int n = this.byteOffset + this.position() * 2;
            s = this.getShortFromByteArray(this.order(), this.byteArray, n);
        }
        this.position(this.position() + 1);
        return s;
    }

    @Override
    public short get(int n) {
        if (n < 0 || n >= this.limit()) {
            throw new IndexOutOfBoundsException("index is out of bounds");
        }
        short s = 0;
        if (this.isDirect()) {
            s = this.byteBuf.getDirectShort(this.byteOffset + n * 2);
        } else if (this.hasArray()) {
            s = this.array()[n + this.arrayOffset()];
        } else {
            int n2 = this.byteOffset + n * 2;
            s = this.getShortFromByteArray(this.order(), this.byteArray, n2);
        }
        return s;
    }

    @Override
    public boolean isDirect() {
        if (this.byteBuf != null) {
            return this.byteBuf.isDirect();
        }
        return false;
    }

    @Override
    public ShortBuffer put(short s) {
        if (this.position() >= this.limit()) {
            throw new BufferOverflowException();
        }
        if (this.isDirect()) {
            this.byteBuf.putDirectShort(this.byteOffset + this.position() * 2, s);
        } else if (this.hasArray()) {
            this.array()[this.position() + this.arrayOffset()] = s;
        } else {
            int n = this.byteOffset + this.position() * 2;
            this.putShortToByteArray(this.order(), this.byteArray, n, s);
        }
        this.position(this.position() + 1);
        return this;
    }

    @Override
    public ShortBuffer put(int n, short s) {
        if (n < 0 || n >= this.limit()) {
            throw new IndexOutOfBoundsException("index is out of bounds");
        }
        if (this.isDirect()) {
            this.byteBuf.putDirectShort(this.byteOffset + n * 2, s);
        } else if (this.hasArray()) {
            this.array()[n + this.arrayOffset()] = s;
        } else {
            int n2 = this.byteOffset + n * 2;
            this.putShortToByteArray(this.order(), this.byteArray, n2, s);
        }
        return this;
    }

    @Override
    public ShortBuffer slice() {
        if (this.isDirect()) {
            return new ShortBufferImpl(this.byteBuf, this.remaining(), this.byteOffset + this.position() * 2);
        }
        if (this.hasArray()) {
            return new ShortBufferImpl(this.array(), 0, this.remaining(), this.remaining(), this.position() + this.arrayOffset());
        }
        return new ShortBufferImpl(this.byteBuf, this.byteArray, this.remaining(), this.byteOffset + this.position() * 2);
    }

    @Override
    public int getDirectPointer() {
        return this.isDirect() ? this.byteBuf.getDirectPointer(this.byteOffset + this.position() * 2) : 0;
    }

    public short getMaxOfArray(int n) {
        if (this.isDirect()) {
            return this.getMaxShortOfArray(this.getDirectPointer(), n);
        }
        if (this.hasArray()) {
            int n2 = this.position();
            short s = this.array()[n2];
            int n3 = n2 + 1;
            while (n3 < n2 + n) {
                if (this.array()[n3] > s) {
                    s = this.array()[n3];
                }
                ++n3;
            }
            return s;
        }
        int n4 = this.position();
        short s = this.get(n4);
        int n5 = n4 + 1;
        while (n5 < n4 + n) {
            if (this.get(n5) > s) {
                s = this.get(n5);
            }
            ++n5;
        }
        return s;
    }

    public boolean isNoNegativeArray(int n) {
        if (this.isDirect()) {
            return this.isNoNegativeShortArray(this.position(), n);
        }
        if (this.hasArray()) {
            int n2;
            int n3 = n2 = this.position();
            while (n3 < n2 + n) {
                if (this.array()[n3] < 0) {
                    return false;
                }
                ++n3;
            }
        } else {
            int n4;
            int n5 = n4 = this.position();
            while (n5 < n4 + n) {
                if (this.get(n5) < 0) {
                    return false;
                }
                ++n5;
            }
        }
        return true;
    }

    void getShortArray(short[] sArray, int n, int n2) {
        if (this.isDirect()) {
            this.byteBuf.getDirectShortArray(this.byteOffset + this.position() * 2, n2, sArray, n);
        } else if (!this.hasArray()) {
            int n3 = this.byteOffset + this.position() * 2;
            int n4 = n;
            while (n4 < n + n2) {
                sArray[n4] = this.getShortFromByteArray(this.order(), this.byteArray, n3);
                n3 += 2;
                ++n4;
            }
        }
    }

    void putShortArray(short[] sArray, int n, int n2) {
        if (this.isDirect()) {
            this.byteBuf.putDirectShortArray(this.byteOffset + this.position() * 2, n2, sArray, n);
        } else if (!this.hasArray()) {
            int n3 = this.byteOffset + this.position() * 2;
            int n4 = n;
            while (n4 < n + n2) {
                this.putShortToByteArray(this.order(), this.byteArray, n3, sArray[n4]);
                n3 += 2;
                ++n4;
            }
        }
    }

    @Override
    public ByteOrder order() {
        if (this.byteBuf != null) {
            return this.byteBuf.order();
        }
        return ByteOrder.nativeOrder();
    }
}


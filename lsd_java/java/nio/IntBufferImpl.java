/*
 * Decompiled with CFR 0.152.
 */
package java.nio;

import com.ibm.oti.nio.BufferUtil;
import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBufferImpl;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

class IntBufferImpl
extends IntBuffer
implements BufferUtil {
    private ByteBufferImpl byteBuf = null;
    private byte[] byteArray = null;
    private int byteOffset = 0;

    IntBufferImpl(int[] nArray, int n, int n2, int n3, int n4) {
        super(n, n + n2, n3, nArray, n4);
    }

    IntBufferImpl(ByteBufferImpl byteBufferImpl, int n, int n2) {
        super(0, n, n);
        this.byteBuf = byteBufferImpl;
        this.address = byteBufferImpl.address + (long)n2;
        this.byteOffset = n2;
    }

    IntBufferImpl(ByteBufferImpl byteBufferImpl, byte[] byArray, int n, int n2) {
        super(0, n, n);
        this.byteBuf = byteBufferImpl;
        this.byteArray = byArray;
        this.byteOffset = n2;
    }

    @Override
    public int get() {
        if (this.position() >= this.limit()) {
            throw new BufferUnderflowException();
        }
        int n = 0;
        if (this.isDirect()) {
            n = this.byteBuf.getDirectInt(this.byteOffset + this.position() * 4);
        } else if (this.hasArray()) {
            n = this.array()[this.position() + this.arrayOffset()];
        } else {
            int n2 = this.byteOffset + this.position() * 4;
            n = this.getIntFromByteArray(this.order(), this.byteArray, n2);
        }
        this.position(this.position() + 1);
        return n;
    }

    @Override
    public int get(int n) {
        if (n < 0 || n >= this.limit()) {
            throw new IndexOutOfBoundsException("index is out of bounds");
        }
        int n2 = 0;
        if (this.isDirect()) {
            n2 = this.byteBuf.getDirectInt(this.byteOffset + n * 4);
        } else if (this.hasArray()) {
            n2 = this.array()[n + this.arrayOffset()];
        } else {
            int n3 = this.byteOffset + n * 4;
            n2 = this.getIntFromByteArray(this.order(), this.byteArray, n3);
        }
        return n2;
    }

    @Override
    public boolean isDirect() {
        if (this.byteBuf != null) {
            return this.byteBuf.isDirect();
        }
        return false;
    }

    @Override
    public IntBuffer put(int n) {
        if (this.position() >= this.limit()) {
            throw new BufferOverflowException();
        }
        if (this.isDirect()) {
            this.byteBuf.putDirectInt(this.byteOffset + this.position() * 4, n);
        } else if (this.hasArray()) {
            this.array()[this.position() + this.arrayOffset()] = n;
        } else {
            int n2 = this.byteOffset + this.position() * 4;
            this.putIntToByteArray(this.order(), this.byteArray, n2, n);
        }
        this.position(this.position() + 1);
        return this;
    }

    @Override
    public IntBuffer put(int n, int n2) {
        if (n < 0 || n >= this.limit()) {
            throw new IndexOutOfBoundsException("index is out of bounds");
        }
        if (this.isDirect()) {
            this.byteBuf.putDirectInt(this.byteOffset + n * 4, n2);
        } else if (this.hasArray()) {
            this.array()[n + this.arrayOffset()] = n2;
        } else {
            int n3 = this.byteOffset + n * 4;
            this.putIntToByteArray(this.order(), this.byteArray, n3, n2);
        }
        return this;
    }

    @Override
    public IntBuffer slice() {
        if (this.isDirect()) {
            return new IntBufferImpl(this.byteBuf, this.remaining(), this.byteOffset + this.position() * 4);
        }
        if (this.hasArray()) {
            return new IntBufferImpl(this.array(), 0, this.remaining(), this.remaining(), this.position() + this.arrayOffset());
        }
        return new IntBufferImpl(this.byteBuf, this.byteArray, this.remaining(), this.byteOffset + this.position() * 4);
    }

    @Override
    public int getDirectPointer() {
        return this.isDirect() ? this.byteBuf.getDirectPointer(this.byteOffset + this.position() * 4) : 0;
    }

    void getIntArray(int[] nArray, int n, int n2) {
        if (this.isDirect()) {
            this.byteBuf.getDirectIntArray(this.byteOffset + this.position() * 4, n2, nArray, n);
        } else if (!this.hasArray()) {
            int n3 = this.byteOffset + this.position() * 4;
            int n4 = n;
            while (n4 < n + n2) {
                nArray[n4] = this.getIntFromByteArray(this.order(), this.byteArray, n3);
                n3 += 4;
                ++n4;
            }
        }
        this.position(this.position() + n2);
    }

    void putIntArray(int[] nArray, int n, int n2) {
        if (this.isDirect()) {
            this.byteBuf.putDirectIntArray(this.byteOffset + this.position() * 4, n2, nArray, n);
        } else if (!this.hasArray()) {
            int n3 = this.byteOffset + this.position() * 4;
            int n4 = n;
            while (n4 < n + n2) {
                this.putIntToByteArray(this.order(), this.byteArray, n3, nArray[n4]);
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


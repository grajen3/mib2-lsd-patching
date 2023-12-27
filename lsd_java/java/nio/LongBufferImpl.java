/*
 * Decompiled with CFR 0.152.
 */
package java.nio;

import com.ibm.oti.nio.BufferUtil;
import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBufferImpl;
import java.nio.ByteOrder;
import java.nio.LongBuffer;

class LongBufferImpl
extends LongBuffer
implements BufferUtil {
    private ByteBufferImpl byteBuf = null;
    private byte[] byteArray = null;
    private int byteOffset = 0;

    LongBufferImpl(long[] lArray, int n, int n2, int n3, int n4) {
        super(n, n + n2, n3, lArray, n4);
    }

    LongBufferImpl(ByteBufferImpl byteBufferImpl, int n, int n2) {
        super(0, n, n);
        this.byteBuf = byteBufferImpl;
        this.address = byteBufferImpl.address + (long)n2;
        this.byteOffset = n2;
    }

    LongBufferImpl(ByteBufferImpl byteBufferImpl, byte[] byArray, int n, int n2) {
        super(0, n, n);
        this.byteBuf = byteBufferImpl;
        this.byteArray = byArray;
        this.byteOffset = n2;
    }

    @Override
    public long get() {
        if (this.position() >= this.limit()) {
            throw new BufferUnderflowException();
        }
        long l = 0L;
        if (this.isDirect()) {
            l = this.byteBuf.getDirectLong(this.byteOffset + this.position() * 8);
        } else if (this.hasArray()) {
            l = this.array()[this.position() + this.arrayOffset()];
        } else {
            int n = this.byteOffset + this.position() * 8;
            l = this.getLongFromByteArray(this.order(), this.byteArray, n);
        }
        this.position(this.position() + 1);
        return l;
    }

    @Override
    public long get(int n) {
        if (n < 0 || n >= this.limit()) {
            throw new IndexOutOfBoundsException("index is out of bounds");
        }
        long l = 0L;
        if (this.isDirect()) {
            l = this.byteBuf.getDirectLong(this.byteOffset + n * 8);
        } else if (this.hasArray()) {
            l = this.array()[n + this.arrayOffset()];
        } else {
            int n2 = this.byteOffset + n * 8;
            l = this.getLongFromByteArray(this.order(), this.byteArray, n2);
        }
        return l;
    }

    @Override
    public boolean isDirect() {
        if (this.byteBuf != null) {
            return this.byteBuf.isDirect();
        }
        return false;
    }

    @Override
    public LongBuffer put(long l) {
        if (this.position() >= this.limit()) {
            throw new BufferOverflowException();
        }
        if (this.isDirect()) {
            this.byteBuf.putDirectLong(this.byteOffset + this.position() * 8, l);
        } else if (this.hasArray()) {
            this.array()[this.position() + this.arrayOffset()] = l;
        } else {
            int n = this.byteOffset + this.position() * 8;
            this.putLongToByteArray(this.order(), this.byteArray, n, l);
        }
        this.position(this.position() + 1);
        return this;
    }

    @Override
    public LongBuffer put(int n, long l) {
        if (n < 0 || n >= this.limit()) {
            throw new IndexOutOfBoundsException("index is out of bounds");
        }
        if (this.isDirect()) {
            this.byteBuf.putDirectLong(this.byteOffset + n * 8, l);
        } else if (this.hasArray()) {
            this.array()[n + this.arrayOffset()] = l;
        } else {
            int n2 = this.byteOffset + n * 8;
            this.putLongToByteArray(this.order(), this.byteArray, n2, l);
        }
        return this;
    }

    @Override
    public LongBuffer slice() {
        if (this.isDirect()) {
            return new LongBufferImpl(this.byteBuf, this.remaining(), this.byteOffset + this.position() * 8);
        }
        if (this.hasArray()) {
            return new LongBufferImpl(this.array(), 0, this.remaining(), this.remaining(), this.position() + this.arrayOffset());
        }
        return new LongBufferImpl(this.byteBuf, this.byteArray, this.remaining(), this.byteOffset + this.position() * 8);
    }

    @Override
    public int getDirectPointer() {
        return this.isDirect() ? this.byteBuf.getDirectPointer(this.byteOffset + this.position() * 8) : 0;
    }

    void getLongArray(long[] lArray, int n, int n2) {
        if (this.isDirect()) {
            this.byteBuf.getDirectLongArray(this.byteOffset + this.position() * 8, n2, lArray, n);
        } else if (!this.hasArray()) {
            int n3 = this.byteOffset + this.position() * 8;
            int n4 = n;
            while (n4 < n + n2) {
                lArray[n4] = this.getLongFromByteArray(this.order(), this.byteArray, n3);
                n3 += 8;
                ++n4;
            }
        }
        this.position(this.position() + n2);
    }

    void putLongArray(long[] lArray, int n, int n2) {
        if (this.isDirect()) {
            this.byteBuf.putDirectLongArray(this.byteOffset + this.position() * 8, n2, lArray, n);
        } else if (!this.hasArray()) {
            int n3 = this.byteOffset + this.position() * 8;
            int n4 = n;
            while (n4 < n + n2) {
                this.putLongToByteArray(this.order(), this.byteArray, n3, lArray[n4]);
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


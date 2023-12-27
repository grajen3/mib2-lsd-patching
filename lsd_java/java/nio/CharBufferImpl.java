/*
 * Decompiled with CFR 0.152.
 */
package java.nio;

import com.ibm.oti.nio.BufferUtil;
import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBufferImpl;
import java.nio.ByteOrder;
import java.nio.CharBuffer;

class CharBufferImpl
extends CharBuffer
implements BufferUtil {
    private ByteBufferImpl byteBuf = null;
    private byte[] byteArray = null;
    private int byteOffset = 0;

    CharBufferImpl(char[] cArray, int n, int n2, int n3, int n4) {
        super(n, n + n2, n3, cArray, n4);
    }

    CharBufferImpl(ByteBufferImpl byteBufferImpl, int n, int n2) {
        super(0, n, n);
        this.byteBuf = byteBufferImpl;
        this.address = byteBufferImpl.address + (long)n2;
        this.byteOffset = n2;
    }

    CharBufferImpl(ByteBufferImpl byteBufferImpl, byte[] byArray, int n, int n2) {
        super(0, n, n);
        this.byteBuf = byteBufferImpl;
        this.byteArray = byArray;
        this.byteOffset = n2;
    }

    @Override
    public char get() {
        if (this.position() >= this.limit()) {
            throw new BufferUnderflowException();
        }
        char c2 = '\u0000';
        if (this.isDirect()) {
            c2 = this.byteBuf.getDirectChar(this.byteOffset + this.position() * 2);
        } else if (this.hasArray()) {
            c2 = this.array()[this.position() + this.arrayOffset()];
        } else {
            int n = this.byteOffset + this.position() * 2;
            c2 = this.getCharFromByteArray(this.order(), this.byteArray, n);
        }
        this.position(this.position() + 1);
        return c2;
    }

    @Override
    public char get(int n) {
        if (n < 0 || n >= this.limit()) {
            throw new IndexOutOfBoundsException("index is out of bounds");
        }
        char c2 = '\u0000';
        if (this.isDirect()) {
            c2 = this.byteBuf.getDirectChar(this.byteOffset + n * 2);
        } else if (this.hasArray()) {
            c2 = this.array()[n + this.arrayOffset()];
        } else {
            int n2 = this.byteOffset + n * 2;
            c2 = this.getCharFromByteArray(this.order(), this.byteArray, n2);
        }
        return c2;
    }

    @Override
    public boolean isDirect() {
        if (this.byteBuf != null) {
            return this.byteBuf.isDirect();
        }
        return false;
    }

    @Override
    public CharBuffer put(char c2) {
        if (this.position() >= this.limit()) {
            throw new BufferOverflowException();
        }
        if (this.isDirect()) {
            this.byteBuf.putDirectChar(this.byteOffset + this.position() * 2, c2);
        } else if (this.hasArray()) {
            this.array()[this.position() + this.arrayOffset()] = c2;
        } else {
            int n = this.byteOffset + this.position() * 2;
            this.putCharToByteArray(this.order(), this.byteArray, n, c2);
        }
        this.position(this.position() + 1);
        return this;
    }

    @Override
    public CharBuffer put(int n, char c2) {
        if (n < 0 || n >= this.limit()) {
            throw new IndexOutOfBoundsException("index is out of bounds");
        }
        if (this.isDirect()) {
            this.byteBuf.putDirectChar(this.byteOffset + n * 2, c2);
        } else if (this.hasArray()) {
            this.array()[n + this.arrayOffset()] = c2;
        } else {
            int n2 = this.byteOffset + n * 2;
            this.putCharToByteArray(this.order(), this.byteArray, n2, c2);
        }
        return this;
    }

    @Override
    public CharBuffer slice() {
        if (this.isDirect()) {
            return new CharBufferImpl(this.byteBuf, this.remaining(), this.byteOffset + this.position() * 2);
        }
        if (this.hasArray()) {
            return new CharBufferImpl(this.array(), 0, this.remaining(), this.remaining(), this.position() + this.arrayOffset());
        }
        return new CharBufferImpl(this.byteBuf, this.byteArray, this.remaining(), this.byteOffset + this.position() * 2);
    }

    @Override
    public int getDirectPointer() {
        return this.isDirect() ? this.byteBuf.getDirectPointer(this.byteOffset + this.position() * 2) : 0;
    }

    void getCharArray(char[] cArray, int n, int n2) {
        if (this.isDirect()) {
            this.byteBuf.getDirectCharArray(this.byteOffset + this.position() * 2, n2, cArray, n);
        } else if (!this.hasArray()) {
            int n3 = this.byteOffset + this.position() * 2;
            int n4 = n;
            while (n4 < n + n2) {
                cArray[n4] = this.getCharFromByteArray(this.order(), this.byteArray, n3);
                n3 += 2;
                ++n4;
            }
        }
        this.position(this.position() + n2);
    }

    void putCharArray(char[] cArray, int n, int n2) {
        if (this.isDirect()) {
            this.byteBuf.putDirectCharArray(this.byteOffset + this.position() * 2, n2, cArray, n);
        } else if (!this.hasArray()) {
            int n3 = this.byteOffset + this.position() * 2;
            int n4 = n;
            while (n4 < n + n2) {
                this.putCharToByteArray(this.order(), this.byteArray, n3, cArray[n4]);
                n3 += 2;
                ++n4;
            }
        }
        this.position(this.position() + n2);
    }

    @Override
    public CharSequence subSequence(int n, int n2) {
        if (n < 0 || n2 < n || n2 > this.remaining()) {
            throw new IndexOutOfBoundsException();
        }
        CharBufferImpl charBufferImpl = this.isDirect() ? new CharBufferImpl(this.byteBuf, this.capacity(), this.byteOffset) : (this.hasArray() ? new CharBufferImpl(this.array(), 0, this.capacity(), this.capacity(), this.arrayOffset()) : new CharBufferImpl(this.byteBuf, this.byteArray, this.capacity(), this.byteOffset));
        charBufferImpl.position(this.position() + n);
        charBufferImpl.limit(this.position() + n2);
        return charBufferImpl;
    }

    @Override
    public String toString() {
        if (this.isDirect()) {
            char[] cArray = new char[this.limit() - this.position()];
            this.byteBuf.getDirectCharArray(this.byteOffset + this.position() * 2, cArray.length, cArray, 0);
            return new String(cArray);
        }
        if (this.hasArray()) {
            return new String(this.array(), this.arrayOffset() + this.position(), this.remaining());
        }
        char[] cArray = new char[this.limit() - this.position()];
        int n = this.byteOffset + this.position() * 2;
        int n2 = 0;
        while (n2 < cArray.length) {
            cArray[n2] = this.getCharFromByteArray(this.order(), this.byteArray, n);
            n += 2;
            ++n2;
        }
        return new String(cArray);
    }

    @Override
    public ByteOrder order() {
        if (this.byteBuf != null) {
            return this.byteBuf.order();
        }
        return ByteOrder.nativeOrder();
    }
}


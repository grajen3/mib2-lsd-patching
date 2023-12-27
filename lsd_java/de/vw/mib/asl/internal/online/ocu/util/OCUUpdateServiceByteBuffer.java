/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.ocu.util;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;

public class OCUUpdateServiceByteBuffer {
    private int _mark = -1;
    private int _position = 0;
    private int _limit;
    private int _capacity;
    final byte[] _buffer;
    final int _offset;
    boolean _isReadOnly;

    public OCUUpdateServiceByteBuffer(int n) {
        this._limit = n;
        this._buffer = new byte[n];
        this._offset = 0;
    }

    byte _get(int n) {
        return this._buffer[n];
    }

    void _put(int n, byte by) {
        this._buffer[n] = by;
    }

    int index(int n) {
        return n + this._offset;
    }

    int getNextIndex() {
        if (this._position >= this._limit) {
            throw new BufferUnderflowException();
        }
        return this._position++;
    }

    int getNextIndex(int n) {
        if (this._limit - this._position < n) {
            throw new BufferUnderflowException();
        }
        int n2 = this._position;
        this._position += n;
        return n2;
    }

    int checkIndexAt(int n) {
        if (n < 0 || n >= this._limit) {
            throw new IndexOutOfBoundsException();
        }
        return n;
    }

    int checkIndexAt(int n, int n2) {
        if (n < 0 || n2 > this._limit - n) {
            throw new IndexOutOfBoundsException();
        }
        return n;
    }

    int markValue() {
        return this._mark;
    }

    void checkBounds(int n, int n2, int n3) {
        if ((n | n2 | n + n2 | n3 - (n + n2)) < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    public byte[] array() {
        if (this._buffer == null) {
            throw new UnsupportedOperationException();
        }
        if (this._isReadOnly) {
            throw new UnsupportedOperationException();
        }
        return this._buffer;
    }

    public int remaining() {
        return this._limit - this._position;
    }

    public int position() {
        return this._position;
    }

    public OCUUpdateServiceByteBuffer position(int n) {
        if (n > this._limit || n < 0) {
            throw new IllegalArgumentException();
        }
        this._position = n;
        if (this._mark > this._position) {
            this._mark = -1;
        }
        return this;
    }

    public byte get() {
        return this._buffer[this.index(this.getNextIndex())];
    }

    public byte get(int n) {
        return this._buffer[this.index(this.checkIndexAt(n))];
    }

    public OCUUpdateServiceByteBuffer get(byte[] byArray, int n, int n2) {
        this.checkBounds(n, n2, byArray.length);
        if (n2 > this.remaining()) {
            throw new BufferUnderflowException();
        }
        System.arraycopy((Object)this._buffer, this.index(this.position()), (Object)byArray, n, n2);
        this.position(this.position() + n2);
        return this;
    }

    public boolean isDirect() {
        return false;
    }

    public boolean isReadOnly() {
        return false;
    }

    public int capacityOf() {
        return this._capacity;
    }

    int nextPutIndex() {
        if (this._position >= this._limit) {
            throw new BufferOverflowException();
        }
        return this._position++;
    }

    int putNextIndex(int n) {
        if (this._limit - this._position < n) {
            throw new BufferOverflowException();
        }
        int n2 = this._position;
        this._position += n;
        return n2;
    }

    public OCUUpdateServiceByteBuffer put(byte[] byArray) {
        return this.put(byArray, 0, byArray.length);
    }

    public OCUUpdateServiceByteBuffer put(byte by) {
        this._buffer[this.index((int)this.nextPutIndex())] = by;
        return this;
    }

    public OCUUpdateServiceByteBuffer put(int n, byte by) {
        this._buffer[this.index((int)this.checkIndexAt((int)n))] = by;
        return this;
    }

    public OCUUpdateServiceByteBuffer put(byte[] byArray, int n, int n2) {
        this.checkBounds(n, n2, byArray.length);
        if (n2 > this.remaining()) {
            throw new BufferOverflowException();
        }
        System.arraycopy((Object)byArray, n, (Object)this._buffer, this.index(this.position()), n2);
        this.position(this.position() + n2);
        return this;
    }

    public OCUUpdateServiceByteBuffer put(OCUUpdateServiceByteBuffer oCUUpdateServiceByteBuffer) {
        if (oCUUpdateServiceByteBuffer instanceof OCUUpdateServiceByteBuffer) {
            if (oCUUpdateServiceByteBuffer == this) {
                throw new IllegalArgumentException();
            }
            OCUUpdateServiceByteBuffer oCUUpdateServiceByteBuffer2 = oCUUpdateServiceByteBuffer;
            int n = oCUUpdateServiceByteBuffer2.remaining();
            if (n > this.remaining()) {
                throw new BufferOverflowException();
            }
            System.arraycopy((Object)oCUUpdateServiceByteBuffer2._buffer, oCUUpdateServiceByteBuffer2.index(oCUUpdateServiceByteBuffer2.position()), (Object)this._buffer, this.index(this.position()), n);
            oCUUpdateServiceByteBuffer2.position(oCUUpdateServiceByteBuffer2.position() + n);
            this.position(this.position() + n);
        } else if (oCUUpdateServiceByteBuffer.isDirect()) {
            int n = oCUUpdateServiceByteBuffer.remaining();
            if (n > this.remaining()) {
                throw new BufferOverflowException();
            }
            oCUUpdateServiceByteBuffer.get(this._buffer, this.index(this.position()), n);
            this.position(this.position() + n);
        }
        return this;
    }

    public OCUUpdateServiceByteBuffer compact() {
        System.arraycopy((Object)this._buffer, this.index(this.position()), (Object)this._buffer, this.index(0), this.remaining());
        this.position(this.remaining());
        this.limit(this.capacityOf());
        return this;
    }

    public int limit() {
        return this._limit;
    }

    public OCUUpdateServiceByteBuffer limit(int n) {
        if (n > this._capacity || n < 0) {
            throw new IllegalArgumentException();
        }
        this._limit = n;
        if (this._position > this._limit) {
            this._position = this._limit;
        }
        if (this._mark > this._limit) {
            this._mark = -1;
        }
        return this;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package java.nio;

import java.nio.Buffer;
import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteOrder;
import java.nio.CharBufferImpl;

public abstract class CharBuffer
extends Buffer
implements Comparable,
CharSequence {
    private char[] array = null;
    private int arrayOffset = 0;

    CharBuffer(int n, int n2, int n3, char[] cArray, int n4) {
        super(n, n2, n3);
        this.array = cArray;
        this.arrayOffset = n4;
    }

    CharBuffer(int n, int n2, int n3) {
        super(n, n2, n3);
    }

    public final char[] array() {
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
        if (!(object instanceof CharBuffer)) {
            throw new ClassCastException("the argument is not an int buffer");
        }
        CharBuffer charBuffer = (CharBuffer)object;
        int n = 0;
        int n2 = 0;
        if (this.remaining() > charBuffer.remaining()) {
            n = charBuffer.remaining();
            n2 = 1;
        } else if (this.remaining() < charBuffer.remaining()) {
            n = this.remaining();
            n2 = -1;
        } else {
            n = this.remaining();
            n2 = 0;
        }
        int n3 = this.position();
        int n4 = charBuffer.position();
        int n5 = 0;
        while (n5 < n) {
            if (this.get(n3 + n5) > charBuffer.get(n4 + n5)) {
                return 1;
            }
            if (this.get(n3 + n5) < charBuffer.get(n4 + n5)) {
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
        return object instanceof CharBuffer && this.compareTo(object) == 0;
    }

    public abstract char get() {
    }

    public CharBuffer get(char[] cArray) {
        if (cArray == null) {
            throw new NullPointerException("dst is null");
        }
        if (this.remaining() < cArray.length) {
            throw new BufferUnderflowException();
        }
        this.get(cArray, 0, cArray.length);
        return this;
    }

    public CharBuffer get(char[] cArray, int n, int n2) {
        if (cArray == null) {
            throw new NullPointerException("dst is null");
        }
        if (n < 0 || n > cArray.length) {
            throw new IndexOutOfBoundsException("offset is out of bounds");
        }
        if (n2 < 0 || n2 > cArray.length - n) {
            throw new IndexOutOfBoundsException("length is out of bounds");
        }
        if (this.remaining() < n2) {
            throw new BufferUnderflowException();
        }
        if (this.hasArray()) {
            System.arraycopy((Object)this.array, this.position() + this.arrayOffset(), (Object)cArray, n, n2);
            this.position(this.position() + n2);
        } else {
            ((CharBufferImpl)this).getCharArray(cArray, n, n2);
        }
        return this;
    }

    public abstract char get(int n) {
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

    public abstract CharBuffer put(char c2) {
    }

    public final CharBuffer put(char[] cArray) {
        if (cArray == null) {
            throw new NullPointerException("src is null");
        }
        return this.put(cArray, 0, cArray.length);
    }

    public CharBuffer put(char[] cArray, int n, int n2) {
        if (cArray == null) {
            throw new NullPointerException("src is null");
        }
        if (n < 0 || n > cArray.length) {
            throw new IndexOutOfBoundsException("offset is out of bounds");
        }
        if (n2 < 0 || n2 > cArray.length - n) {
            throw new IndexOutOfBoundsException("length is out of bounds");
        }
        if (this.remaining() < n2) {
            throw new BufferOverflowException();
        }
        if (this.hasArray()) {
            System.arraycopy((Object)cArray, n, (Object)this.array(), this.position() + this.arrayOffset(), n2);
            this.position(this.position() + n2);
        } else {
            ((CharBufferImpl)this).putCharArray(cArray, n, n2);
        }
        return this;
    }

    public CharBuffer put(CharBuffer charBuffer) {
        if (charBuffer == null) {
            throw new NullPointerException("src is null");
        }
        if (charBuffer.remaining() > this.remaining()) {
            throw new BufferOverflowException();
        }
        if (this == charBuffer) {
            throw new IllegalArgumentException("the source buffer is this buffer");
        }
        char[] cArray = new char[charBuffer.remaining()];
        charBuffer.get(cArray);
        return this.put(cArray);
    }

    public abstract CharBuffer put(int n, char c2) {
    }

    public abstract CharBuffer slice() {
    }

    @Override
    public String toString() {
        return new StringBuffer("java.nio.CharBuffer[pos=").append(this.position()).append(" lim=").append(this.limit()).append(" cap=").append(this.capacity()).append("]").toString();
    }

    public static CharBuffer wrap(char[] cArray) {
        if (cArray == null) {
            throw new NullPointerException("array is null");
        }
        return new CharBufferImpl(cArray, 0, cArray.length, cArray.length, 0);
    }

    public static CharBuffer wrap(char[] cArray, int n, int n2) {
        if (cArray == null) {
            throw new NullPointerException("array is null");
        }
        if (n < 0 || n > cArray.length) {
            throw new IndexOutOfBoundsException("offset is out of bounds");
        }
        if (n2 < 0 || n2 > cArray.length - n) {
            throw new IndexOutOfBoundsException("length is negative");
        }
        return new CharBufferImpl(cArray, n, n2, cArray.length, 0);
    }

    @Override
    public char charAt(int n) {
        return this.get(this.position() + n);
    }

    @Override
    public int length() {
        return this.remaining();
    }

    public CharBuffer put(String string) {
        return this.put(string, 0, string.length());
    }

    public CharBuffer put(String string, int n, int n2) {
        if (string == null) {
            throw new NullPointerException();
        }
        if (n2 < n || n < 0 || n2 > string.length()) {
            throw new IndexOutOfBoundsException();
        }
        try {
            char[] cArray = new char[n2 - n];
            string.getChars(n, n2, cArray, 0);
            this.put(cArray);
        }
        catch (StringIndexOutOfBoundsException stringIndexOutOfBoundsException) {
            throw new IndexOutOfBoundsException(stringIndexOutOfBoundsException.getMessage());
        }
        return this;
    }

    public abstract ByteOrder order() {
    }
}


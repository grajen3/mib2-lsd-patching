/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons;

import java.io.OutputStream;
import java.io.Writer;

public final class Buffer {
    private char[] value;
    private int count;

    public Buffer() {
        this(100);
    }

    public Buffer(int n) {
        this.value = new char[n];
    }

    public Buffer(String string) {
        this(string.length());
        this.append(string);
    }

    public int length() {
        return this.count;
    }

    public void clear() {
        this.count = 0;
    }

    public int capacity() {
        return this.value.length;
    }

    public char charAt(int n) {
        if (n < 0 || n >= this.count) {
            throw new StringIndexOutOfBoundsException(n);
        }
        return this.value[n];
    }

    private void expandCapacity(int n) {
        int n2 = (this.value.length + 1) * 2;
        if (n2 < 0) {
            n2 = -129;
        } else if (n > n2) {
            n2 = n;
        }
        char[] cArray = new char[n2];
        System.arraycopy((Object)this.value, 0, (Object)cArray, 0, this.count);
        this.value = cArray;
    }

    public Buffer append(String string) {
        if (string == null) {
            return this;
        }
        int n = string.length();
        int n2 = this.count + n;
        if (n2 > this.value.length) {
            this.expandCapacity(n2);
        }
        string.getChars(0, n, this.value, this.count);
        this.count = n2;
        return this;
    }

    public Buffer append(Object object) {
        return this.append(String.valueOf(object));
    }

    public Buffer append(char c2) {
        int n = this.count + 1;
        if (n > this.value.length) {
            this.expandCapacity(n);
        }
        this.value[this.count++] = c2;
        return this;
    }

    public Buffer append(boolean bl) {
        if (bl) {
            int n = this.count + 4;
            if (n > this.value.length) {
                this.expandCapacity(n);
            }
            this.value[this.count++] = 116;
            this.value[this.count++] = 114;
            this.value[this.count++] = 117;
            this.value[this.count++] = 101;
        } else {
            int n = this.count + 5;
            if (n > this.value.length) {
                this.expandCapacity(n);
            }
            this.value[this.count++] = 102;
            this.value[this.count++] = 97;
            this.value[this.count++] = 108;
            this.value[this.count++] = 115;
            this.value[this.count++] = 101;
        }
        return this;
    }

    public Buffer append(int n) {
        return this.append(Integer.toString(n));
    }

    public Buffer append(long l) {
        return this.append(Long.toString(l));
    }

    public Buffer append(float f2) {
        return this.append(Float.toString(f2));
    }

    public Buffer delete(int n, int n2) {
        if (n < 0) {
            throw new StringIndexOutOfBoundsException(n);
        }
        if (n2 > this.count) {
            n2 = this.count;
        }
        if (n > n2) {
            throw new StringIndexOutOfBoundsException();
        }
        int n3 = n2 - n;
        if (n3 > 0) {
            System.arraycopy((Object)this.value, n + n3, (Object)this.value, n, this.count - n2);
            this.count -= n3;
        }
        return this;
    }

    public Buffer deleteCharAt(int n) {
        if (n < 0 || n >= this.count) {
            throw new StringIndexOutOfBoundsException(n);
        }
        System.arraycopy((Object)this.value, n + 1, (Object)this.value, n, this.count - n - 1);
        --this.count;
        return this;
    }

    public Buffer insert(int n, String string) {
        int n2;
        int n3;
        if (n < 0 || n > this.length()) {
            throw new StringIndexOutOfBoundsException(n);
        }
        if (string == null) {
            string = "null";
        }
        if ((n3 = this.count + (n2 = string.length())) > this.value.length) {
            this.expandCapacity(n3);
        }
        System.arraycopy((Object)this.value, n, (Object)this.value, n + n2, this.count - n);
        System.arraycopy((Object)string.toCharArray(), 0, (Object)this.value, n, n2);
        this.count = n3;
        return this;
    }

    public Buffer insert(int n, char c2) {
        int n2 = this.count + 1;
        if (n2 > this.value.length) {
            this.expandCapacity(n2);
        }
        System.arraycopy((Object)this.value, n, (Object)this.value, n + 1, this.count - n);
        this.value[n] = c2;
        this.count = n2;
        return this;
    }

    public String toString() {
        return new String(this.value, 0, this.count);
    }

    public char[] toCharArray() {
        char[] cArray = new char[this.count];
        System.arraycopy((Object)this.value, 0, (Object)cArray, 0, this.count);
        return cArray;
    }

    public void writeTo(Writer writer, String string) {
        writer.write(this.value, 0, this.count);
        writer.write(string);
    }

    public void writeBytesTo(OutputStream outputStream) {
        for (int i2 = 0; i2 < this.count; ++i2) {
            outputStream.write((byte)this.value[i2]);
        }
    }

    public String substring(int n) {
        return this.substring(n, this.count);
    }

    public String substring(int n, int n2) {
        if (n < 0) {
            throw new StringIndexOutOfBoundsException(n);
        }
        if (n2 > this.count) {
            throw new StringIndexOutOfBoundsException(n2);
        }
        if (n > n2) {
            throw new StringIndexOutOfBoundsException(n2 - n);
        }
        return new String(this.value, n, n2 - n);
    }
}


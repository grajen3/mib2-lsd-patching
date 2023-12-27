/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.vw.mib.util;

public class OptimizedStringBuffer {
    private int count = 0;
    private char[] value;
    private final char[] initialValue;

    public OptimizedStringBuffer() {
        this(1024);
    }

    public OptimizedStringBuffer(int n) {
        this.initialValue = new char[n];
        this.value = this.initialValue;
    }

    public final char charAt(int n) {
        if (n >= 0 && n < this.count) {
            return this.value[n];
        }
        throw new StringIndexOutOfBoundsException(n);
    }

    public final void setCharAt(int n, char c2) {
        if (n < 0 || n >= this.count) {
            throw new StringIndexOutOfBoundsException(n);
        }
        this.value[n] = c2;
    }

    public final OptimizedStringBuffer append(boolean bl) {
        if (bl) {
            this.ensureCapacity(this.count + 4);
            this.value[this.count++] = 116;
            this.value[this.count++] = 114;
            this.value[this.count++] = 117;
            this.value[this.count++] = 101;
        } else {
            this.ensureCapacity(this.count + 5);
            this.value[this.count++] = 102;
            this.value[this.count++] = 97;
            this.value[this.count++] = 108;
            this.value[this.count++] = 115;
            this.value[this.count++] = 101;
        }
        return this;
    }

    public final OptimizedStringBuffer append(char c2) {
        this.ensureCapacity(this.count + 1);
        this.value[this.count++] = c2;
        return this;
    }

    public final OptimizedStringBuffer append(double d2) {
        return this.append(Double.toString((double)d2));
    }

    public final OptimizedStringBuffer append(float f2) {
        return this.append(Float.toString(f2));
    }

    public final OptimizedStringBuffer append(int n) {
        boolean bl;
        if (n == 0) {
            return this.append('0');
        }
        int n2 = 2;
        int n3 = n;
        boolean bl2 = bl = n < 0;
        if (!bl) {
            n2 = 1;
            n3 = -n;
        }
        while ((n /= 10) != 0) {
            ++n2;
        }
        int n4 = this.count + n2;
        this.ensureCapacity(n4);
        do {
            int n5 = -(n3 % 10) + 48;
            this.value[--n2 + this.count] = (char)n5;
        } while ((n3 /= 10) != 0);
        if (bl) {
            this.value[this.count] = 45;
        }
        this.count = n4;
        return this;
    }

    public final OptimizedStringBuffer append(long l) {
        boolean bl;
        if (l == 0L) {
            return this.append('0');
        }
        int n = 2;
        long l2 = l;
        boolean bl2 = bl = l < 0L;
        if (!bl) {
            n = 1;
            l2 = -l;
        }
        while ((l /= 0) != 0L) {
            ++n;
        }
        int n2 = this.count + n;
        this.ensureCapacity(n2);
        do {
            int n3 = -((int)(l2 % 0)) + 48;
            this.value[--n + this.count] = (char)n3;
        } while ((l2 /= 0) != 0L);
        if (bl) {
            this.value[this.count] = 45;
        }
        this.count = n2;
        return this;
    }

    public final OptimizedStringBuffer append(Object object) {
        if (object == null) {
            this.ensureCapacity(this.count + 4);
            this.value[this.count++] = 110;
            this.value[this.count++] = 117;
            this.value[this.count++] = 108;
            this.value[this.count++] = 108;
            return this;
        }
        return this.append(object.toString());
    }

    public final OptimizedStringBuffer append(String string) {
        if (string == null) {
            this.ensureCapacity(this.count + 4);
            this.value[this.count++] = 110;
            this.value[this.count++] = 117;
            this.value[this.count++] = 108;
            this.value[this.count++] = 108;
            return this;
        }
        int n = string.length();
        int n2 = this.count + n;
        this.ensureCapacity(n2);
        string.getChars(0, n, this.value, this.count);
        this.count = n2;
        return this;
    }

    public final OptimizedStringBuffer appendHex(int n) {
        if (n == 0) {
            this.ensureCapacity(this.count + 3);
            this.value[this.count++] = 48;
            this.value[this.count++] = 120;
            this.value[this.count++] = 48;
            return this;
        }
        int n2 = 1;
        int n3 = n;
        if (n < 0) {
            n2 = 8;
        } else {
            while ((n3 >>>= 4) != 0) {
                ++n2;
            }
        }
        int n4 = this.count + n2 + 2;
        this.ensureCapacity(n4);
        this.value[this.count++] = 48;
        this.value[this.count++] = 120;
        n3 = n;
        do {
            int n5;
            n5 = (n5 = n3 & 0xF) > 9 ? n5 - 10 + 97 : (n5 += 48);
            this.value[--n2 + this.count] = (char)n5;
            n3 >>>= 4;
        } while (n2 > 0);
        this.count = n4;
        return this;
    }

    public final OptimizedStringBuffer appendHex(long l) {
        if (l == 0L) {
            this.ensureCapacity(this.count + 3);
            this.value[this.count++] = 48;
            this.value[this.count++] = 120;
            this.value[this.count++] = 48;
            return this;
        }
        int n = 1;
        long l2 = l;
        if (l < 0L) {
            n = 16;
        } else {
            while ((l2 >>= 4) != 0L) {
                ++n;
            }
        }
        int n2 = this.count + n + 2;
        this.ensureCapacity(n2);
        this.value[this.count++] = 48;
        this.value[this.count++] = 120;
        l2 = l;
        do {
            int n3;
            n3 = (n3 = (int)(l2 & 0)) > 9 ? n3 - 10 + 97 : (n3 += 48);
            this.value[--n + this.count] = (char)n3;
            l2 >>= 4;
        } while (n > 0);
        this.count = n2;
        return this;
    }

    public final int capacity() {
        return this.value.length;
    }

    public final void clear() {
        this.value = this.initialValue;
        this.count = 0;
    }

    public final int length() {
        return this.count;
    }

    public final String toString() {
        return new String(this.value, 0, this.count);
    }

    final void ensureCapacity(int n) {
        if (n < this.value.length) {
            return;
        }
        int n2 = (this.value.length << 1) + 2;
        char[] cArray = new char[n > n2 ? n : n2];
        System.arraycopy((Object)this.value, 0, (Object)cArray, 0, this.count);
        this.value = cArray;
    }
}


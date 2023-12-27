/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.vw.mib.debug.common.core;

import de.vw.mib.debug.common.core.Util;
import java.util.Arrays;

public class StringBuilder
implements CharSequence {
    private static final int MIN_RADIX;
    private static final int MAX_RADIX;
    private static final int DEFAULT_RADIX;
    private static final String NULL_REPLACEMENT;
    public static final int INITIAL_SIZE;
    private int length;
    private char[] buffer;
    private final char[] initial;

    public StringBuilder() {
        this(INITIAL_SIZE);
    }

    public StringBuilder(int n) {
        this.length = 0;
        this.buffer = new char[n];
        this.initial = this.buffer;
    }

    public StringBuilder(String string) {
        this.length = string.length();
        this.buffer = new char[this.length + INITIAL_SIZE];
        this.initial = this.buffer;
        string.getChars(0, this.length, this.buffer, 0);
    }

    public StringBuilder append(char[] cArray) {
        int n = this.length + cArray.length;
        this.ensureCapacity(n);
        System.arraycopy((Object)cArray, 0, (Object)this.buffer, this.length, cArray.length);
        this.length = n;
        return this;
    }

    public StringBuilder append(char[] cArray, int n, int n2) {
        if (n >= 0 && 0 <= n2 && n2 <= cArray.length - n) {
            int n3 = this.length + n2;
            this.ensureCapacity(n3);
            System.arraycopy((Object)cArray, n, (Object)this.buffer, this.length, n2);
            this.length = n3;
            return this;
        }
        throw new IndexOutOfBoundsException();
    }

    public StringBuilder append(char c2) {
        this.ensureCapacity(this.length + 1);
        this.buffer[this.length] = c2;
        ++this.length;
        return this;
    }

    public StringBuilder append(double d2) {
        return this.append(Double.toString((double)d2));
    }

    public StringBuilder append(float f2) {
        return this.append(Float.toString(f2));
    }

    public StringBuilder append(int n) {
        return this.append(n, 10);
    }

    public StringBuilder appendHex(int n) {
        if (0 == n) {
            this.increaseCapacity(3);
            this.buffer[this.length] = 48;
            this.buffer[this.length + 1] = 120;
            this.buffer[this.length + 2] = 48;
            this.length += 3;
            return this;
        }
        int n2 = (Util.log2(n) >>> 2) + 1;
        this.increaseCapacity(n2 + 2);
        this.buffer[this.length] = 48;
        this.buffer[this.length + 1] = 120;
        this.length += 2;
        int n3 = n;
        for (int i2 = this.length + n2 - 1; i2 >= this.length; --i2) {
            this.buffer[i2] = this.getCharForRemainder(0 - (n3 & 0xF));
            n3 >>>= 4;
        }
        this.length += n2;
        return this;
    }

    private StringBuilder append(int n, int n2) {
        int n3;
        if (n2 < 2 || n2 > 36) {
            n2 = 10;
        }
        if (n == 0) {
            return this.append('0');
        }
        if (n < 0) {
            this.append('-');
            n3 = n;
        } else {
            n3 = -n;
        }
        int n4 = this.countDigits(n, n2);
        this.increaseCapacity(n4);
        for (int i2 = this.length + n4 - 1; i2 >= this.length; --i2) {
            this.buffer[i2] = this.getCharForRemainder(n3 % n2);
            n3 /= n2;
        }
        this.length += n4;
        return this;
    }

    private char getCharForRemainder(int n) {
        n = n < -9 ? 97 - n - 10 : 48 - n;
        return (char)n;
    }

    private int countDigits(int n, int n2) {
        int n3 = 0;
        do {
            ++n3;
        } while ((n /= n2) != 0);
        return n3;
    }

    public StringBuilder append(long l) {
        return this.append(l, 10);
    }

    private StringBuilder append(long l, int n) {
        long l2;
        if (n < 2 || n > 36) {
            n = 10;
        }
        if (l == 0L) {
            return this.append('0');
        }
        boolean bl = l < 0L;
        long l3 = l2 = bl ? l : -l;
        if (bl) {
            this.append('-');
            l2 = l;
        } else {
            l2 = -l;
        }
        int n2 = this.countDigits(l, n);
        this.increaseCapacity(n2);
        for (int i2 = this.length + n2 - 1; i2 >= this.length; --i2) {
            this.buffer[i2] = this.getCharForRemainder((int)(l2 % (long)n));
            l2 /= (long)n;
        }
        this.length += n2;
        return this;
    }

    private int countDigits(long l, int n) {
        int n2 = 0;
        do {
            ++n2;
        } while ((l /= (long)n) != 0L);
        return n2;
    }

    public StringBuilder append(Object object) {
        return this.append(object == null ? null : object.toString());
    }

    public StringBuilder append(String string) {
        if (string == null) {
            string = "null";
        }
        int n = string.length();
        int n2 = this.length + n;
        this.ensureCapacity(n2);
        string.getChars(0, n, this.buffer, this.length);
        this.length = n2;
        return this;
    }

    public StringBuilder append(boolean bl) {
        if (bl) {
            int n = this.length + 4;
            this.ensureCapacity(n);
            this.buffer[this.length] = 116;
            this.buffer[this.length + 1] = 114;
            this.buffer[this.length + 2] = 117;
            this.buffer[this.length + 3] = 101;
            this.length = n;
        } else {
            int n = this.length + 5;
            this.ensureCapacity(n);
            this.buffer[this.length] = 102;
            this.buffer[this.length + 1] = 97;
            this.buffer[this.length + 2] = 108;
            this.buffer[this.length + 3] = 115;
            this.buffer[this.length + 4] = 101;
            this.length = n;
        }
        return this;
    }

    public int capacity() {
        return this.buffer.length;
    }

    @Override
    public char charAt(int n) {
        if (n < 0 || n >= this.length) {
            throw new IndexOutOfBoundsException();
        }
        return this.buffer[n];
    }

    public StringBuilder delete(int n, int n2) {
        if (n >= 0) {
            if (n2 > this.length) {
                n2 = this.length;
            }
            if (n2 > n) {
                int n3 = this.length - n2;
                if (n3 > 0) {
                    System.arraycopy((Object)this.buffer, n2, (Object)this.buffer, n, n3);
                }
                this.length -= n2 - n;
                return this;
            }
            if (n == n2) {
                return this;
            }
        }
        throw new IndexOutOfBoundsException();
    }

    public StringBuilder deleteCharAt(int n) {
        if (0 <= n && n < this.length) {
            int n2 = this.length - n - 1;
            if (n2 > 0) {
                System.arraycopy((Object)this.buffer, n + 1, (Object)this.buffer, n, n2);
            }
            --this.length;
            return this;
        }
        throw new IndexOutOfBoundsException();
    }

    public void increaseCapacity(int n) {
        this.ensureCapacity(this.length + n);
    }

    public void ensureCapacity(int n) {
        if (n < this.buffer.length) {
            return;
        }
        int n2 = (this.buffer.length << 1) + 2;
        char[] cArray = new char[n > n2 ? n : n2];
        System.arraycopy((Object)this.buffer, 0, (Object)cArray, 0, this.length);
        this.buffer = cArray;
    }

    public void getChars(int n, int n2, char[] cArray, int n3) {
        if (n > this.length || n2 > this.length) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy((Object)this.buffer, n, (Object)cArray, n3, n2 - n);
    }

    public StringBuilder insert(int n, char[] cArray) {
        if (0 <= n && n <= this.length) {
            this.move(cArray.length, n);
            System.arraycopy((Object)cArray, 0, (Object)this.buffer, n, cArray.length);
            this.length += cArray.length;
            return this;
        }
        throw new IndexOutOfBoundsException();
    }

    public StringBuilder insert(int n, char[] cArray, int n2, int n3) {
        if (0 <= n && n <= this.length && 0 <= n2 && 0 <= n3 && n3 <= cArray.length - n2) {
            this.move(n3, n);
            System.arraycopy((Object)cArray, n2, (Object)this.buffer, n, n3);
            this.length += n3;
            return this;
        }
        throw new IndexOutOfBoundsException();
    }

    public StringBuilder insert(int n, char c2) {
        if (0 <= n && n <= this.length) {
            this.move(1, n);
            this.buffer[n] = c2;
            ++this.length;
            return this;
        }
        throw new IndexOutOfBoundsException();
    }

    public StringBuilder insert(int n, double d2) {
        return this.insert(n, String.valueOf(d2));
    }

    public StringBuilder insert(int n, float f2) {
        return this.insert(n, String.valueOf(f2));
    }

    public StringBuilder insert(int n, int n2) {
        return this.insert(n, Integer.toString(n2));
    }

    public StringBuilder insert(int n, long l) {
        return this.insert(n, Long.toString(l));
    }

    public StringBuilder insert(int n, Object object) {
        return this.insert(n, String.valueOf(object));
    }

    public StringBuilder insert(int n, String string) {
        if (0 <= n && n <= this.length) {
            if (string == null) {
                string = "null";
            }
            int n2 = string.length();
            this.move(n2, n);
            string.getChars(0, n2, this.buffer, n);
            this.length += n2;
            return this;
        }
        throw new IndexOutOfBoundsException();
    }

    public StringBuilder insert(int n, boolean bl) {
        return this.insert(n, String.valueOf(bl));
    }

    @Override
    public int length() {
        return this.length;
    }

    private void move(int n, int n2) {
        if (this.buffer.length - this.length >= n) {
            System.arraycopy((Object)this.buffer, n2, (Object)this.buffer, n2 + n, this.length - n2);
            return;
        }
        int n3 = this.length + n;
        int n4 = (this.buffer.length << 1) + 2;
        char[] cArray = new char[n3 > n4 ? n3 : n4];
        System.arraycopy((Object)this.buffer, 0, (Object)cArray, 0, n2);
        System.arraycopy((Object)this.buffer, n2, (Object)cArray, n2 + n, this.length - n2);
        this.buffer = cArray;
    }

    public StringBuilder replace(int n, int n2, String string) {
        if (n >= 0) {
            if (n2 > this.length) {
                n2 = this.length;
            }
            if (n2 > n) {
                int n3 = string.length();
                int n4 = n2 - n - n3;
                if (n4 > 0) {
                    System.arraycopy((Object)this.buffer, n2, (Object)this.buffer, n + n3, this.length - n2);
                } else if (n4 < 0) {
                    this.move(-n4, n2);
                }
                string.getChars(0, n3, this.buffer, n);
                this.length -= n4;
                return this;
            }
            if (n == n2) {
                if (string == null) {
                    throw new NullPointerException();
                }
                return this.insert(n, string);
            }
        }
        throw new IndexOutOfBoundsException();
    }

    public StringBuilder reverse() {
        if (this.length < 2) {
            return this;
        }
        int n = this.length;
        int n2 = this.length / 2;
        for (int i2 = 0; i2 < n2; ++i2) {
            char c2 = this.buffer[--n];
            this.buffer[n] = this.buffer[i2];
            this.buffer[i2] = c2;
        }
        return this;
    }

    public void setCharAt(int n, char c2) {
        if (n < 0 || n >= this.length) {
            throw new IndexOutOfBoundsException();
        }
        this.buffer[n] = c2;
    }

    public void setLength(int n) {
        if (n < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (n <= this.initial.length) {
            if (this.buffer != this.initial) {
                System.arraycopy((Object)this.buffer, 0, (Object)this.initial, 0, n < this.length ? n : this.length);
                this.buffer = this.initial;
            }
        } else {
            this.ensureCapacity(n);
        }
        if (n > this.length) {
            Arrays.fill(this.buffer, this.length, n, '\u0000');
        }
        this.length = n;
    }

    public void clear() {
        this.buffer = this.initial;
        this.length = 0;
    }

    public String substring(int n) {
        if (0 <= n && n <= this.length) {
            return new String(this.buffer, n, this.length - n);
        }
        throw new IndexOutOfBoundsException();
    }

    public String substring(int n, int n2) {
        if (0 <= n && n <= n2 && n2 <= this.length) {
            return new String(this.buffer, n, n2 - n);
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public String toString() {
        return new String(this.buffer, 0, this.length);
    }

    @Override
    public CharSequence subSequence(int n, int n2) {
        return this.substring(n, n2);
    }

    public int indexOf(String string) {
        return this.indexOf(string, 0);
    }

    public int indexOf(String string, int n) {
        int n2;
        if (n < 0) {
            n = 0;
        }
        if ((n2 = string.length()) == 0) {
            return n < this.length || n == 0 ? n : this.length;
        }
        if (n2 + n > this.length) {
            return -1;
        }
        char c2 = string.charAt(0);
        while (true) {
            int n3;
            boolean bl = false;
            for (n3 = n; n3 < this.length; ++n3) {
                if (this.buffer[n3] != c2) continue;
                bl = true;
                break;
            }
            if (!bl || n2 + n3 > this.length) {
                return -1;
            }
            int n4 = n3;
            int n5 = 0;
            while (++n5 < n2 && this.buffer[++n4] == string.charAt(n5)) {
            }
            if (n5 == n2) {
                return n3;
            }
            n = n3 + 1;
        }
    }

    public int lastIndexOf(String string) {
        return this.lastIndexOf(string, this.length);
    }

    public int lastIndexOf(String string, int n) {
        int n2 = string.length();
        if (n2 > this.length || n < 0) {
            return -1;
        }
        if (n2 == 0) {
            return n < this.length ? n : this.length;
        }
        if (n > this.length - n2) {
            n = this.length - n2;
        }
        char c2 = string.charAt(0);
        while (true) {
            int n3;
            boolean bl = false;
            for (n3 = n; n3 >= 0; --n3) {
                if (this.buffer[n3] != c2) continue;
                bl = true;
                break;
            }
            if (!bl) {
                return -1;
            }
            int n4 = n3;
            int n5 = 0;
            while (++n5 < n2 && this.buffer[++n4] == string.charAt(n5)) {
            }
            if (n5 == n2) {
                return n3;
            }
            n = n3 - 1;
        }
    }

    static {
        INITIAL_SIZE = 1024;
    }
}


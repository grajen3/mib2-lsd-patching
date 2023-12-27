/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.util;

import de.vw.mib.asl.framework.internal.framework.util.LogUtil;
import java.io.PrintStream;
import java.util.Arrays;

public final class BitField {
    private static final int BITS_PER_BYTE;
    private static final int BITS_PER_LINE;
    private final byte[] mBytes;
    private final int mSize;

    public BitField() {
        this(8);
    }

    public BitField(byte[] byArray) {
        if (byArray != null) {
            this.mSize = byArray.length * 8;
            this.mBytes = byArray;
        } else {
            this.mSize = 8;
            this.mBytes = new byte[1];
        }
    }

    public BitField(byte by) {
        this.mBytes = new byte[1];
        this.mBytes[0] = by;
        this.mSize = 8;
    }

    public BitField(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException(new StringBuffer().append("Bit Count not okay: BitCount=").append(n).toString());
        }
        int n2 = n / 8;
        if (n % 8 > 0) {
            ++n2;
        }
        this.mBytes = new byte[n2];
        this.mSize = n;
    }

    private void check(int n) {
        if (n < 0 || n >= this.mSize) {
            throw new IndexOutOfBoundsException(new StringBuffer().append("Index out of range: Index=").append(n).append(" Size=").append(this.mSize).toString());
        }
    }

    public void dump(PrintStream printStream) {
        StringBuffer stringBuffer = new StringBuffer(24);
        int n = 0;
        for (int i2 = 0; i2 < this.mSize; ++i2) {
            if (n == 0) {
                stringBuffer.append(LogUtil.fixLength(Integer.toString(i2), 5, true));
                stringBuffer.append(" [");
            } else {
                stringBuffer.append("-");
            }
            stringBuffer.append(this.getPriv(i2) ? 1 : 0);
            if (n == 7) {
                stringBuffer.append("]");
                printStream.println(stringBuffer.toString());
                stringBuffer.delete(0, stringBuffer.length());
                n = 0;
                continue;
            }
            ++n;
        }
        if (n != 0) {
            stringBuffer.append("]");
            printStream.println(stringBuffer.toString());
        }
    }

    public boolean get(int n) {
        this.check(n);
        return this.getPriv(n);
    }

    public int get(int n, int n2) {
        this.check(n);
        this.check(n + n2);
        return this.getPriv(n, n2);
    }

    public byte[] getBytes() {
        return this.mBytes;
    }

    private boolean getPriv(int n) {
        return (this.mBytes[n >> 3] & 1 << (n & 7)) != 0;
    }

    private int getPriv(int n, int n2) {
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            boolean bl = this.getPriv(n + n2 - 1 - i2);
            if (!bl) continue;
            n3 |= 1 << i2;
        }
        return n3;
    }

    public void on(int n) {
        this.check(n);
        int n2 = n >> 3;
        this.mBytes[n2] = (byte)(this.mBytes[n2] | 1 << (n & 7));
    }

    public void set(int n, boolean bl) {
        this.check(n);
        if (bl) {
            this.on(n);
        } else {
            this.off(n);
        }
    }

    public void set(int n, int n2, int n3) {
        this.check(n);
        this.check(n + n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            this.set(n + n2 - i2 - 1, (n3 & 1 << i2) > 0);
        }
    }

    public void on() {
        Arrays.fill(this.mBytes, (byte)1);
    }

    public void flip(int n) {
        this.check(n);
        int n2 = n >> 3;
        this.mBytes[n2] = (byte)(this.mBytes[n2] ^ 1 << (n & 7));
    }

    public void flip() {
        int n = 0;
        while (n < this.mBytes.length) {
            int n2 = n++;
            this.mBytes[n2] = (byte)(this.mBytes[n2] ^ 0xFF);
        }
    }

    public void off(int n) {
        this.check(n);
        int n2 = n >> 3;
        this.mBytes[n2] = (byte)(this.mBytes[n2] & ~(1 << (n & 7)));
    }

    public void off() {
        Arrays.fill(this.mBytes, (byte)0);
    }

    public int size() {
        return this.mSize;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("BitField Len=");
        stringBuffer.append(this.size());
        stringBuffer.append("bits [");
        for (int i2 = 0; i2 < this.mSize; ++i2) {
            if (i2 > 0) {
                stringBuffer.append("-");
            }
            stringBuffer.append(this.getPriv(i2) ? 1 : 0);
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}


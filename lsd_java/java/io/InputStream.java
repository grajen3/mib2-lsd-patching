/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import java.io.IOException;

public abstract class InputStream {
    private static byte[] skipBuf;

    public int available() {
        return 0;
    }

    public void close() {
    }

    public void mark(int n) {
    }

    public boolean markSupported() {
        return false;
    }

    public abstract int read() {
    }

    public int read(byte[] byArray) {
        return this.read(byArray, 0, byArray.length);
    }

    public int read(byte[] byArray, int n, int n2) {
        if (n <= byArray.length && n >= 0 && n2 >= 0 && n2 <= byArray.length - n) {
            int n3 = 0;
            while (n3 < n2) {
                int n4;
                try {
                    n4 = this.read();
                    if (n4 == -1) {
                        return n3 == 0 ? -1 : n3;
                    }
                }
                catch (IOException iOException) {
                    if (n3 != 0) {
                        return n3;
                    }
                    throw iOException;
                }
                byArray[n + n3] = (byte)n4;
                ++n3;
            }
            return n2;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public synchronized void reset() {
        throw new IOException();
    }

    public long skip(long l) {
        int n;
        if (l <= 0L) {
            return 0L;
        }
        long l2 = 0L;
        int n2 = n = l < 0 ? (int)l : 4096;
        if (skipBuf == null || skipBuf.length < n) {
            skipBuf = new byte[n];
        }
        while (l2 < l) {
            int n3 = this.read(skipBuf, 0, n);
            if (n3 == -1) {
                return l2;
            }
            l2 += (long)n3;
            if (n3 < n) {
                return l2;
            }
            if (l - l2 >= (long)n) continue;
            n = (int)(l - l2);
        }
        return l2;
    }
}


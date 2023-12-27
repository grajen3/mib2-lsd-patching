/*
 * Decompiled with CFR 0.152.
 */
package java.util.zip;

import java.io.FilterInputStream;
import java.io.InputStream;
import java.util.zip.Checksum;

public class CheckedInputStream
extends FilterInputStream {
    private Checksum check;

    public CheckedInputStream(InputStream inputStream, Checksum checksum) {
        super(inputStream);
        this.check = checksum;
    }

    @Override
    public int read() {
        int n = this.in.read();
        if (n != -1) {
            this.check.update(n);
        }
        return n;
    }

    @Override
    public int read(byte[] byArray, int n, int n2) {
        int n3 = this.in.read(byArray, n, n2);
        if (n3 != -1) {
            this.check.update(byArray, n, n3);
        }
        return n3;
    }

    public Checksum getChecksum() {
        return this.check;
    }

    @Override
    public long skip(long l) {
        if (l < 1L) {
            return 0L;
        }
        long l2 = 0L;
        byte[] byArray = new byte[2048];
        while (l2 != l) {
            int n = (int)(l - l2);
            int n2 = this.in.read(byArray, 0, n > byArray.length ? byArray.length : n);
            if (n2 == -1) {
                return l2;
            }
            this.check.update(byArray, 0, n2);
            l2 += (long)n2;
        }
        return l2;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package java.util.jar;

import java.io.FilterInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.jar.JarVerifier;
import java.util.jar.JarVerifier$VerifierEntry;
import java.util.zip.ZipEntry;

final class JarFile$JarFileInputStream
extends FilterInputStream {
    private long count;
    private ZipEntry zipEntry;
    private JarVerifier verifier;
    private JarVerifier$VerifierEntry entry;
    private MessageDigest digest;

    JarFile$JarFileInputStream(InputStream inputStream, ZipEntry zipEntry, JarVerifier jarVerifier) {
        super(inputStream);
        if (jarVerifier != null) {
            this.zipEntry = zipEntry;
            this.verifier = jarVerifier;
            this.count = this.zipEntry.getSize();
            this.entry = this.verifier.initEntry(zipEntry.getName());
            if (this.entry != null) {
                this.digest = this.entry.digest;
            }
        }
    }

    @Override
    public int read() {
        int n = super.read();
        if (this.entry != null) {
            if (n != -1) {
                this.digest.update((byte)n);
                --this.count;
            }
            if (n == -1 || this.count <= 0L) {
                JarVerifier$VerifierEntry jarVerifier$VerifierEntry = this.entry;
                this.entry = null;
                this.verifier.verifySignatures(jarVerifier$VerifierEntry, this.zipEntry);
            }
        }
        return n;
    }

    @Override
    public int read(byte[] byArray, int n, int n2) {
        int n3 = super.read(byArray, n, n2);
        if (this.entry != null) {
            if (n3 != -1) {
                int n4 = n3;
                if (this.count < (long)n4) {
                    n4 = (int)this.count;
                }
                this.digest.update(byArray, n, n4);
                this.count -= (long)n3;
            }
            if (n3 == -1 || this.count <= 0L) {
                JarVerifier$VerifierEntry jarVerifier$VerifierEntry = this.entry;
                this.entry = null;
                this.verifier.verifySignatures(jarVerifier$VerifierEntry, this.zipEntry);
            }
        }
        return n3;
    }

    @Override
    public long skip(long l) {
        long l2 = 0L;
        long l3 = 0L;
        byte[] byArray = new byte[4096];
        while (l2 < l) {
            l3 = l - l2;
            int n = this.read(byArray, 0, l3 > (long)byArray.length ? byArray.length : (int)l3);
            if (n == -1) {
                return l2;
            }
            l2 += (long)n;
        }
        return l2;
    }
}


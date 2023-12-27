/*
 * Decompiled with CFR 0.152.
 */
package java.util.jar;

import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.cert.Certificate;

class JarVerifier$VerifierEntry
extends OutputStream {
    MessageDigest digest;
    byte[] hash;
    Certificate[] certificates;

    JarVerifier$VerifierEntry(MessageDigest messageDigest, byte[] byArray, Certificate[] certificateArray) {
        this.digest = messageDigest;
        this.hash = byArray;
        this.certificates = certificateArray;
    }

    @Override
    public void write(int n) {
        this.digest.update((byte)n);
    }

    @Override
    public void write(byte[] byArray, int n, int n2) {
        this.digest.update(byArray, n, n2);
    }
}


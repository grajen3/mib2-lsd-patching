/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.util;

import java.io.FilterInputStream;
import java.io.InputStream;

public class PasswordProtectedInputStream
extends FilterInputStream {
    private byte[] password;
    private int pwdIndex = 0;

    public PasswordProtectedInputStream(InputStream inputStream, byte[] byArray) {
        super(inputStream);
        this.password = byArray;
    }

    @Override
    public int read() {
        int n = this.in.read();
        if (n >= 0) {
            n ^= this.password[this.pwdIndex];
            this.pwdIndex = (this.pwdIndex + 1) % this.password.length;
        }
        return n;
    }

    @Override
    public int read(byte[] byArray, int n, int n2) {
        int n3 = this.in.read(byArray, n, n2);
        if (n3 > 0) {
            int n4 = n + n3;
            int n5 = n;
            while (n5 < n4) {
                int n6 = n5++;
                byArray[n6] = (byte)(byArray[n6] ^ this.password[this.pwdIndex]);
                this.pwdIndex = (this.pwdIndex + 1) % this.password.length;
            }
        }
        return n3;
    }

    @Override
    public long skip(long l) {
        long l2 = super.skip(l);
        this.pwdIndex = (int)((long)this.pwdIndex + l2);
        return l2;
    }
}


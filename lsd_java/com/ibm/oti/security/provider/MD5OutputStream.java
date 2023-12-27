/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.j9.bluez.crypto.CL3MD5;
import java.io.OutputStream;

public class MD5OutputStream
extends OutputStream {
    CL3MD5 state = CL3MD5.md5Init(null);

    public MD5OutputStream() {
    }

    public MD5OutputStream(byte[] byArray) {
        this();
        CL3MD5.md5(this.state, byArray, 0, byArray.length, null, 0);
    }

    @Override
    public void write(byte[] byArray, int n, int n2) {
        CL3MD5.md5(this.state, byArray, n, n2, null, 0);
    }

    @Override
    public void write(int n) {
        byte[] byArray = new byte[]{(byte)n};
        this.write(byArray, 0, 1);
    }

    public byte[] getHashAsBytes() {
        byte[] byArray = new byte[16];
        CL3MD5.md5(this.state, new byte[0], 0, 0, byArray, 0);
        this.reset();
        return byArray;
    }

    public void reset() {
        this.state = CL3MD5.md5Init(null);
    }

    public MD5OutputStream copyOf() {
        MD5OutputStream mD5OutputStream = new MD5OutputStream();
        mD5OutputStream.state = CL3MD5.md5CopyState(this.state);
        return mD5OutputStream;
    }
}


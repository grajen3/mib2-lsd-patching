/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.crypto;

import com.ibm.j9.bluez.crypto.CL3;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class SHAOutputStream
extends OutputStream {
    private ByteArrayOutputStream byteStream = null;

    public SHAOutputStream(byte[] byArray) {
        this.byteStream = new ByteArrayOutputStream(byArray.length);
        try {
            this.byteStream.write(byArray);
        }
        catch (IOException iOException) {}
    }

    public SHAOutputStream() {
        this.byteStream = new ByteArrayOutputStream();
    }

    @Override
    public void write(byte[] byArray, int n, int n2) {
        this.byteStream.write(byArray, n, n2);
    }

    @Override
    public void write(int n) {
        this.byteStream.write(n);
    }

    public byte[] getHashAsBytes() {
        byte[] byArray = this.byteStream.toByteArray();
        byte[] byArray2 = new byte[20];
        CL3.sha(null, byArray, 0, byArray.length, byArray2, 0);
        this.reset();
        return byArray2;
    }

    public void reset() {
        this.byteStream = new ByteArrayOutputStream();
        CL3.shaInit(null);
    }

    public SHAOutputStream copyOf() {
        return new SHAOutputStream(this.byteStream.toByteArray());
    }
}


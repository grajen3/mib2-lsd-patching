/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

final class BaseAlphabet$ByteBuffer {
    private byte[] buffer = new byte[0];
    private int readPosition = 0;

    public void write2ByteInt(int n) {
        int n2 = this.increaseLength(2);
        byte[] byArray = this.convertIntToByteArray(n);
        this.buffer[n2] = byArray[2];
        this.buffer[n2 + 1] = byArray[3];
    }

    public int read2ByteInt() {
        byte[] byArray = new byte[4];
        byArray[2] = this.buffer[this.readPosition];
        byArray[3] = this.buffer[this.readPosition + 1];
        this.readPosition += 2;
        return this.convertByteArrayToInt(byArray);
    }

    public void writeUTF16String(String string) {
        if (string.length() > 512) {
            throw new UnsupportedEncodingException("String too long!!!");
        }
        byte[] byArray = this.convertIntToByteArray(string.length());
        byte[] byArray2 = string.getBytes("UTF-16");
        int n = this.increaseLength(byArray2.length + 2);
        this.buffer[n] = byArray[2];
        this.buffer[n + 1] = byArray[3];
        for (int i2 = 0; i2 < byArray2.length; ++i2) {
            this.buffer[n + 2 + i2] = byArray2[i2];
        }
    }

    public String readUTF16String() {
        byte[] byArray = new byte[4];
        byArray[2] = this.buffer[this.readPosition];
        byArray[3] = this.buffer[this.readPosition + 1];
        int n = this.convertByteArrayToInt(byArray) * 2 + 2;
        this.readPosition += 2;
        byte[] byArray2 = new byte[n];
        for (int i2 = 0; i2 < n; ++i2) {
            byArray2[i2] = this.buffer[this.readPosition + i2];
        }
        this.readPosition += n;
        String string = new String(byArray2, "UTF-16");
        return string;
    }

    public int increaseLength(int n) {
        this.buffer = this.copyArray(this.buffer, this.buffer.length + n);
        return this.buffer.length - n;
    }

    public byte[] convertIntToByteArray(int n) {
        byte[] byArray = new byte[]{(byte)(n >>> 24), (byte)(n >>> 16), (byte)(n >>> 8), (byte)n};
        return byArray;
    }

    public int convertByteArrayToInt(byte[] byArray) {
        int n = (0xFF & byArray[0]) << 24;
        n += (0xFF & byArray[1]) << 16;
        n += (0xFF & byArray[2]) << 8;
        return n += 0xFF & byArray[3];
    }

    public byte[] copyArray(byte[] byArray, int n) {
        byte[] byArray2 = new byte[n];
        System.arraycopy((Object)byArray, 0, (Object)byArray2, 0, Math.min(byArray.length, n));
        return byArray2;
    }

    public void read(InputStream inputStream) {
        int n = 0;
        while ((n = inputStream.available()) != 0) {
            byte[] byArray = new byte[n];
            inputStream.read(byArray);
            this.buffer = this.copyArray(this.buffer, this.buffer.length + n);
            for (int i2 = 0; i2 < this.buffer.length; ++i2) {
                this.buffer[this.buffer.length - n + i2] = byArray[i2];
            }
        }
    }

    public void write(OutputStream outputStream) {
        outputStream.write(this.buffer);
        outputStream.flush();
    }
}


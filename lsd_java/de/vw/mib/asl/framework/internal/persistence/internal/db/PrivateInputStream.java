/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.db;

import de.vw.mib.asl.framework.api.persistence.PersistenceInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

final class PrivateInputStream
implements PersistenceInputStream {
    private final ByteArrayInputStream mBis;
    private final DataInputStream mOis;
    private static final String ENCODING;
    private boolean isValid = false;

    public PrivateInputStream(byte[] byArray) {
        if (byArray != null) {
            this.mBis = new ByteArrayInputStream(byArray);
            this.mOis = new DataInputStream(this.mBis);
            this.isValid = true;
        } else {
            this.mBis = null;
            this.mOis = null;
        }
    }

    @Override
    public void matchVersion(short s) {
        short s2 = this.mOis.readShort();
        if (s2 != s) {
            throw new IOException(new StringBuffer().append("New version found: awaited=").append(s).append(" ,found=").append(s2).toString());
        }
    }

    @Override
    public String readString() {
        int n;
        int n2 = this.mOis.readInt();
        if (n2 < 0 || n2 > this.mBis.available()) {
            throw new IOException("Illegal string length");
        }
        byte[] byArray = new byte[n2];
        int n3 = 0;
        do {
            if ((n = this.mOis.read(byArray, n3, n2 - n3)) <= 0) continue;
            n3 += n;
        } while (n != -1 && n3 < n2);
        if (n != -1) {
            return new String(byArray, "UTF-8");
        }
        return "";
    }

    @Override
    public int read(byte[] byArray, int n, int n2) {
        return this.mOis.read(byArray, n, n2);
    }

    @Override
    public int read(byte[] byArray) {
        return this.mOis.read(byArray);
    }

    @Override
    public boolean readBoolean() {
        return this.mOis.readBoolean();
    }

    @Override
    public byte readByte() {
        return this.mOis.readByte();
    }

    @Override
    public char readChar() {
        return this.mOis.readChar();
    }

    @Override
    public double readDouble() {
        return this.mOis.readDouble();
    }

    @Override
    public float readFloat() {
        return this.mOis.readFloat();
    }

    @Override
    public void readFully(byte[] byArray, int n, int n2) {
        this.mOis.readFully(byArray, n, n2);
    }

    @Override
    public void readFully(byte[] byArray) {
        this.mOis.readFully(byArray);
    }

    @Override
    public int readInt() {
        return this.mOis.readInt();
    }

    @Override
    public long readLong() {
        return this.mOis.readLong();
    }

    @Override
    public short readShort() {
        return this.mOis.readShort();
    }

    @Override
    public int readUnsignedByte() {
        return this.mOis.readUnsignedByte();
    }

    @Override
    public int readUnsignedShort() {
        return this.mOis.readUnsignedShort();
    }

    public String toString() {
        return this.mOis.toString();
    }

    @Override
    public void close() {
        this.mOis.close();
    }

    @Override
    public int available() {
        return this.mBis.available();
    }

    @Override
    public boolean isValid() {
        return this.isValid;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.db;

import de.vw.mib.asl.framework.api.persistence.PersistenceOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

final class PrivateOutputStream
implements PersistenceOutputStream {
    private final ByteArrayOutputStream mBos = new ByteArrayOutputStream();
    private final DataOutputStream mOos = new DataOutputStream(this.mBos);
    private static final String ENCODING;

    @Override
    public void writeString(String string) {
        if (string == null || string.length() == 0) {
            this.mOos.writeInt(0);
        } else {
            byte[] byArray = string.getBytes("UTF-8");
            this.mOos.writeInt(byArray.length);
            this.mOos.write(byArray);
        }
    }

    @Override
    public byte[] toByteArray() {
        this.mOos.flush();
        this.mOos.close();
        this.mBos.close();
        return this.mBos.toByteArray();
    }

    public String toString() {
        return this.mOos.toString();
    }

    @Override
    public void write(byte[] byArray, int n, int n2) {
        this.mOos.write(byArray, n, n2);
    }

    @Override
    public void write(byte[] byArray) {
        this.mOos.write(byArray);
    }

    @Override
    public void write(int n) {
        throw new UnsupportedOperationException("Don't use generic write method, but e.g. writeInt()");
    }

    @Override
    public void writeBoolean(boolean bl) {
        this.mOos.writeBoolean(bl);
    }

    @Override
    public void writeByte(int n) {
        this.mOos.writeByte(n);
    }

    @Override
    public void writeBytes(String string) {
        this.mOos.writeBytes(string);
    }

    @Override
    public void writeChar(int n) {
        this.mOos.writeChar(n);
    }

    @Override
    public void writeChars(String string) {
        this.mOos.writeChars(string);
    }

    @Override
    public void writeDouble(double d2) {
        this.mOos.writeDouble(d2);
    }

    @Override
    public void writeFloat(float f2) {
        this.mOos.writeFloat(f2);
    }

    @Override
    public void writeInt(int n) {
        this.mOos.writeInt(n);
    }

    @Override
    public void writeLong(long l) {
        this.mOos.writeLong(l);
    }

    @Override
    public void writeShort(int n) {
        this.mOos.writeShort(n);
    }
}


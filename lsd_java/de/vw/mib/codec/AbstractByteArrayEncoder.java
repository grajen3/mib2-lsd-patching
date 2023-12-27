/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.codec;

import de.vw.mib.codec.ByteArrayWriter;

public abstract class AbstractByteArrayEncoder
extends ByteArrayWriter {
    protected AbstractByteArrayEncoder() {
    }

    protected AbstractByteArrayEncoder(int n) {
        super(n);
    }

    public AbstractByteArrayEncoder appendBoolean(boolean bl) {
        this.writeByte(1);
        this.writeBoolean(bl);
        return this;
    }

    public AbstractByteArrayEncoder appendChar(char c2) {
        this.writeByte(2);
        this.writeChar(c2);
        return this;
    }

    public AbstractByteArrayEncoder appendDouble(double d2) {
        this.writeByte(3);
        this.writeDouble(d2);
        return this;
    }

    public AbstractByteArrayEncoder appendFloat(float f2) {
        this.writeByte(4);
        this.writeFloat(f2);
        return this;
    }

    public AbstractByteArrayEncoder appendInt(int n) {
        this.writeByte(5);
        this.writeInt(n);
        return this;
    }

    public AbstractByteArrayEncoder appendNull() {
        this.writeByte(8);
        return this;
    }

    public AbstractByteArrayEncoder appendLong(long l) {
        this.writeByte(6);
        this.writeLong(l);
        return this;
    }

    public AbstractByteArrayEncoder appendObject(Object object) {
        if (object == null) {
            this.writeByte(8);
        } else {
            this.writeByte(11);
            this.writeObject(object);
        }
        return this;
    }

    public AbstractByteArrayEncoder appendString(String string) {
        if (string == null) {
            this.writeByte(8);
        } else {
            this.writeByte(7);
            this.writeString(string);
        }
        return this;
    }

    protected abstract void writeObject(Object object) {
    }
}


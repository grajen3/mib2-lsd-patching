/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.log4mib.internal;

import de.vw.mib.log4mib.BinaryMessage;
import de.vw.mib.log4mib.internal.AbstractMessage;
import de.vw.mib.pool.PooledObject;

final class PooledBinaryMessage
extends AbstractMessage
implements BinaryMessage,
PooledObject {
    private long timestamp;
    private short type;
    private int marker;

    PooledBinaryMessage() {
        this.resetMessage();
    }

    @Override
    public BinaryMessage append(boolean bl) {
        this.checkLifecyleState((byte)2);
        this.writeBoolean(bl);
        return this;
    }

    @Override
    public BinaryMessage append(byte by) {
        this.checkLifecyleState((byte)2);
        this.writeByte(by);
        return this;
    }

    @Override
    public BinaryMessage append(byte[] byArray) {
        this.checkLifecyleState((byte)2);
        this.writeByteArray(byArray);
        return this;
    }

    @Override
    public BinaryMessage append(char c2) {
        this.checkLifecyleState((byte)2);
        this.writeChar(c2);
        return this;
    }

    @Override
    public BinaryMessage append(double d2) {
        this.checkLifecyleState((byte)2);
        this.writeDouble(d2);
        return this;
    }

    @Override
    public BinaryMessage append(float f2) {
        this.checkLifecyleState((byte)2);
        this.writeFloat(f2);
        return this;
    }

    @Override
    public BinaryMessage append(int n) {
        this.checkLifecyleState((byte)2);
        this.writeInt(n);
        return this;
    }

    @Override
    public BinaryMessage append(long l) {
        this.checkLifecyleState((byte)2);
        this.writeLong(l);
        return this;
    }

    @Override
    public BinaryMessage append(short s) {
        this.checkLifecyleState((byte)2);
        this.writeShort(s);
        return this;
    }

    @Override
    public BinaryMessage append(String string) {
        this.checkLifecyleState((byte)2);
        this.writeString(string);
        return this;
    }

    @Override
    public BinaryMessage appendData(byte[] byArray) {
        this.checkLifecyleState((byte)2);
        this.write(byArray);
        return this;
    }

    @Override
    public void backToPool() {
        this.resetMessage();
        this.checkLifecyleState((byte)1, (byte)0);
    }

    @Override
    public short getType() {
        return this.type;
    }

    @Override
    void dispatchMessage() {
        logWriter.dispatch(this);
    }

    @Override
    long getTime() {
        return this.timestamp;
    }

    void setMetaData(short s, long l) {
        this.checkLifecyleState((byte)0, (byte)2);
        this.type = s;
        this.timestamp = l;
    }

    @Override
    public int beginElement() {
        this.checkLifecyleState((byte)2);
        this.append(0);
        return this.count;
    }

    @Override
    public void endElement(int n) {
        this.checkLifecyleState((byte)2);
        int n2 = this.count - n;
        this.writeInt(n - 4, n2);
    }

    @Override
    public void mark() {
        this.checkLifecyleState((byte)2);
        this.marker = this.count;
    }

    @Override
    public void rollback() {
        this.checkLifecyleState((byte)2);
        this.count = this.marker;
        this.marker = 0;
        if (this.count == 0) {
            this.reset();
        }
    }

    @Override
    public void send() {
        this.checkLifecyleState((byte)2, (byte)1);
        loggingThread.addToQueue(this);
    }
}


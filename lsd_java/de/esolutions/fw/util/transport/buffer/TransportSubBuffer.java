/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.buffer;

import de.esolutions.fw.util.transport.IReadable;
import de.esolutions.fw.util.transport.buffer.TransportBuffer;
import de.esolutions.fw.util.transport.exception.TransportBufferException;

public class TransportSubBuffer
implements IReadable {
    protected TransportBuffer buffer;
    protected int offset;
    protected int size;

    public TransportSubBuffer(TransportBuffer transportBuffer, int n, int n2) {
        this.buffer = transportBuffer;
        this.offset = n;
        this.size = n2;
    }

    @Override
    public byte[] getData() {
        return this.buffer.getData(this.offset, this.size);
    }

    @Override
    public byte[] getData(int n, int n2) {
        return this.buffer.getData(this.offset + n, n2);
    }

    @Override
    public byte[] getDirectData() {
        return this.buffer.getDirectData();
    }

    @Override
    public int getDirectOffset() {
        return this.offset;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public IReadable createSubBuffer(int n, int n2) {
        if (n + n2 > this.size) {
            throw new TransportBufferException(new StringBuffer().append("Invalid window (").append(n).append(",").append(this.size).append(") current=(").append(this.offset).append(",").append(this.size()).append(")").toString());
        }
        return new TransportSubBuffer(this.buffer, this.offset + n, n2);
    }

    @Override
    public void setDebugTag(Object object) {
        this.buffer.setDebugTag(object);
    }

    @Override
    public Object getDebugTag() {
        return this.buffer.getDebugTag();
    }
}


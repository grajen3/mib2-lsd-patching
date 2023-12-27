/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.file.spi;

import java.nio.ByteBuffer;

public final class ContentChunk {
    public final int id;
    public final int type;
    public final ByteBuffer header;
    public final ByteBuffer data;

    public ContentChunk(int n, int n2, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        this.id = n;
        this.type = n2;
        this.header = byteBuffer;
        this.data = byteBuffer2;
    }

    public int getId() {
        return this.id;
    }

    public int getType() {
        return this.type;
    }

    public ByteBuffer getHeader() {
        return this.header;
    }

    public ByteBuffer getData() {
        return this.data;
    }

    public boolean hasData() {
        return this.data != null;
    }
}


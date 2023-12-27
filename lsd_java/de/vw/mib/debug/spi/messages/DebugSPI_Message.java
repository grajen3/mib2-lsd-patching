/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.spi.messages;

public final class DebugSPI_Message {
    private final byte[] content;
    private final int length;
    private final short type;
    private final int module;

    public DebugSPI_Message(short s, byte[] byArray, int n) {
        this(0, s, byArray, n);
    }

    public DebugSPI_Message(int n, short s, byte[] byArray, int n2) {
        this.module = n;
        this.type = s;
        this.content = byArray;
        this.length = n2;
    }

    public byte[] getContent() {
        return this.content;
    }

    public short getType() {
        return this.type;
    }

    public int getLength() {
        return this.length;
    }

    public int getModule() {
        return this.module;
    }
}


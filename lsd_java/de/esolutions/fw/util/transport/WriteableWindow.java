/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport;

public class WriteableWindow {
    protected int offset;
    protected int size;

    public WriteableWindow(int n, int n2) {
        this.offset = n;
        this.size = n2;
    }

    public int getOffset() {
        return this.offset;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isInside(int n) {
        return this.offset + this.size <= n;
    }
}


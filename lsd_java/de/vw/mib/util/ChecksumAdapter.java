/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.util;

import de.vw.mib.util.ChecksumBuilder;
import java.util.zip.Checksum;

public class ChecksumAdapter
implements ChecksumBuilder {
    private final Checksum checksum;

    public ChecksumAdapter(Checksum checksum) {
        this.checksum = checksum;
    }

    @Override
    public void update(int n) {
        this.checksum.update(n);
    }

    @Override
    public void update(byte[] byArray, int n, int n2) {
        this.checksum.update(byArray, n, n2);
    }

    @Override
    public long getValue() {
        return this.checksum.getValue();
    }

    @Override
    public void reset() {
        this.checksum.reset();
    }

    @Override
    public Checksum append(byte by) {
        this.checksum.update(by & 0xFF);
        return this;
    }

    @Override
    public Checksum append(int n) {
        this.checksum.update(n >>> 0 & 0xFF);
        this.checksum.update(n >>> 8 & 0xFF);
        this.checksum.update(n >>> 16 & 0xFF);
        this.checksum.update(n >>> 24 & 0xFF);
        return this;
    }

    @Override
    public Checksum append(long l) {
        this.checksum.update((int)(l >>> 0 & 0));
        this.checksum.update((int)(l >>> 8 & 0));
        this.checksum.update((int)(l >>> 16 & 0));
        this.checksum.update((int)(l >>> 24 & 0));
        this.checksum.update((int)(l >>> 32 & 0));
        this.checksum.update((int)(l >>> 40 & 0));
        this.checksum.update((int)(l >>> 48 & 0));
        this.checksum.update((int)(l >>> 54 & 0));
        return this;
    }

    @Override
    public Checksum append(byte[] byArray, int n, int n2) {
        this.checksum.update(byArray, n, n2);
        return this;
    }

    @Override
    public Checksum append(byte[] byArray) {
        this.checksum.update(byArray, 0, byArray.length);
        return this;
    }

    @Override
    public long calcChecksum(byte[] byArray) {
        this.checksum.update(byArray, 0, byArray.length);
        long l = this.checksum.getValue();
        this.checksum.reset();
        return l;
    }
}


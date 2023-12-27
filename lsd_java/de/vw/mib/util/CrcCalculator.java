/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.util;

import de.vw.mib.util.ChecksumAdapter;
import de.vw.mib.util.ChecksumBuilder;
import de.vw.mib.util.CrcCalculator$1;
import de.vw.mib.util.Util;
import java.util.zip.Checksum;

public final class CrcCalculator
implements ChecksumBuilder {
    private final int crcPolynom;
    private final int revPolynom;
    private final int startingValue;
    private final int finalXorMask;
    private int shiftRegister;

    public CrcCalculator(int n, int n2, int n3) {
        this.crcPolynom = n;
        this.revPolynom = Util.reverse(n);
        this.startingValue = n2;
        this.shiftRegister = n2;
        this.finalXorMask = n3;
    }

    public CrcCalculator(int n, int n2) {
        this(n, n2, n2);
    }

    public static ChecksumBuilder getCrc32Calculator() {
        return new ChecksumAdapter(new CrcCalculator$1());
    }

    @Override
    public void update(int n) {
        this.appendByte(n);
    }

    @Override
    public void update(byte[] byArray, int n, int n2) {
        this.append(byArray, n, n2);
    }

    @Override
    public long getValue() {
        return this.shiftRegister ^ this.finalXorMask;
    }

    @Override
    public void reset() {
        this.shiftRegister = this.startingValue;
    }

    @Override
    public Checksum append(byte by) {
        return this.appendByte(by & 0xFF);
    }

    @Override
    public Checksum append(int n) {
        return this.appendInt(n);
    }

    @Override
    public Checksum append(long l) {
        return this.appendInt((int)l).appendInt((int)(l >>> 32));
    }

    @Override
    public Checksum append(byte[] byArray) {
        return this.append(byArray, 0, byArray.length);
    }

    @Override
    public Checksum append(byte[] byArray, int n, int n2) {
        int n3 = n + n2;
        for (int i2 = n; i2 < n3; ++i2) {
            this.appendByte(byArray[i2]);
        }
        return this;
    }

    @Override
    public long calcChecksum(byte[] byArray) {
        this.reset();
        this.append(byArray, 0, byArray.length);
        int n = (int)this.getValue();
        this.reset();
        return n;
    }

    public int getCrcPolynom() {
        return this.crcPolynom;
    }

    private Checksum appendByte(int n) {
        this.shiftRegister = this.shiftRegister >>> 8 ^ this.addInternal((this.shiftRegister ^ n) & 0xFF, 8);
        return this;
    }

    private CrcCalculator appendInt(int n) {
        this.shiftRegister = this.addInternal(this.shiftRegister ^ n, 32);
        return this;
    }

    private int addInternal(int n, int n2) {
        int n3 = n;
        for (int i2 = n2; i2 > 0; --i2) {
            if ((n3 & 1) == 1) {
                n3 = n3 >>> 1 ^ this.revPolynom;
                continue;
            }
            n3 >>>= 1;
        }
        return n3;
    }
}


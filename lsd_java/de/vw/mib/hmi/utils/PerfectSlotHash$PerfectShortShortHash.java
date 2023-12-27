/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.hmi.utils;

import de.vw.mib.hmi.utils.PerfectSlotHash;

class PerfectSlotHash$PerfectShortShortHash
extends PerfectSlotHash {
    private final short[] keys;
    private final short[] data;
    private final int size;

    public PerfectSlotHash$PerfectShortShortHash(short[] sArray, short[] sArray2) {
        this.keys = sArray;
        this.data = sArray2;
        this.size = sArray.length;
    }

    @Override
    public int getSlot(int n) {
        short s = this.data[PerfectSlotHash$PerfectShortShortHash.H0(n) % this.size];
        int n2 = s < 0 ? s + this.size : PerfectSlotHash$PerfectShortShortHash.H1(s, n) % this.size;
        return this.keys[n2] == n ? n2 : -1;
    }
}


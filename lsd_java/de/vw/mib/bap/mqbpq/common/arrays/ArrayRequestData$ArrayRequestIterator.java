/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.common.arrays;

import de.vw.mib.bap.mqbpq.common.arrays.ArrayRequestData;

public class ArrayRequestData$ArrayRequestIterator {
    private int start;
    private int end;
    private int direction;

    public ArrayRequestData$ArrayRequestIterator(ArrayRequestData arrayRequestData) {
        this.start = arrayRequestData.getStartOfList();
        this.end = arrayRequestData.getEndOfList();
        this.direction = arrayRequestData.getDirectionIncrement();
    }

    public boolean hasNext() {
        return this.start != this.end;
    }

    public int next() {
        int n = this.start;
        this.start += this.direction;
        return n;
    }
}


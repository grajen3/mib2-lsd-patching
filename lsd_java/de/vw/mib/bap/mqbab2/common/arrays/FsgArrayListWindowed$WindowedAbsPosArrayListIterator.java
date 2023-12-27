/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.arrays;

import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayPosIdIterator;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayRequestData;

class FsgArrayListWindowed$WindowedAbsPosArrayListIterator
implements FsgArrayPosIdIterator {
    private int _start;
    private int _end;
    private int _direction;

    public FsgArrayListWindowed$WindowedAbsPosArrayListIterator(int n, int n2, int n3) {
        this._start = n;
        this._end = n + n3 * n2;
        this._direction = n3;
    }

    public FsgArrayListWindowed$WindowedAbsPosArrayListIterator(FsgArrayRequestData fsgArrayRequestData) {
        this._start = fsgArrayRequestData.getStartOfList();
        this._end = fsgArrayRequestData.getEndOfList();
        this._direction = fsgArrayRequestData.getDirectionIncrement();
    }

    @Override
    public boolean hasNext() {
        return this._start != this._end;
    }

    @Override
    public int next() {
        int n = this._start;
        this._start += this._direction;
        return n;
    }
}


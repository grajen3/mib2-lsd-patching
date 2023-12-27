/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.arrays;

import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListWindowed;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayPosIdIterator;

final class FsgArrayListWindowed$WindowedArbitraryArrayListIterator
implements FsgArrayPosIdIterator {
    private final boolean _forward;
    private int _currentBapPosId;
    private final /* synthetic */ FsgArrayListWindowed this$0;

    protected FsgArrayListWindowed$WindowedArbitraryArrayListIterator(FsgArrayListWindowed fsgArrayListWindowed, int n, boolean bl) {
        this.this$0 = fsgArrayListWindowed;
        this._currentBapPosId = n;
        this._forward = bl;
    }

    @Override
    public boolean hasNext() {
        return this._currentBapPosId > 0;
    }

    @Override
    public int next() {
        int n = this._currentBapPosId;
        this._currentBapPosId = this._forward ? this.this$0.nextBapPosID(this._currentBapPosId) : this.this$0.previousBapPosID(this._currentBapPosId);
        return n;
    }
}


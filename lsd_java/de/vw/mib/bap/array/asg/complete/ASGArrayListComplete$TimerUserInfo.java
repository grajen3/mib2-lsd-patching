/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.array.asg.complete;

final class ASGArrayListComplete$TimerUserInfo {
    private final int _transactionId;
    private int _counter;

    ASGArrayListComplete$TimerUserInfo(int n) {
        this._transactionId = n;
    }

    public int getTransactionId() {
        return this._transactionId;
    }

    public void incrementCounter() {
        ++this._counter;
    }

    public int getCounter() {
        return this._counter;
    }
}


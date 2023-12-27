/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.array.asg.complete;

import de.vw.mib.bap.array.asg.complete.ASGArrayListData;
import de.vw.mib.bap.array.requests.BAPGetArray;
import de.vw.mib.bap.array.timer.Timer;

final class ASGArrayPendingRequests$PendingRequestEntry {
    private BAPGetArray _request;
    private ASGArrayListData _pendingElements;
    private int _pendingRequestType;
    private Timer _timer;

    protected ASGArrayPendingRequests$PendingRequestEntry(BAPGetArray bAPGetArray, int n, ASGArrayListData aSGArrayListData) {
        this._request = bAPGetArray;
        this._pendingRequestType = n;
        this._pendingElements = aSGArrayListData;
    }

    public BAPGetArray getBapGetArray() {
        return this._request;
    }

    public void setBapGetArray(BAPGetArray bAPGetArray) {
        this._request = bAPGetArray;
    }

    public void setPendingElements(ASGArrayListData aSGArrayListData) {
        this._pendingElements = aSGArrayListData;
    }

    public ASGArrayListData getPendingElements() {
        return this._pendingElements;
    }

    public int getPendingRequestType() {
        return this._pendingRequestType;
    }

    public void setPendigRequestType(int n) {
        this._pendingRequestType = n;
    }

    public void setTimer(Timer timer) {
        this._timer = timer;
    }

    public Timer getTimer() {
        return this._timer;
    }
}


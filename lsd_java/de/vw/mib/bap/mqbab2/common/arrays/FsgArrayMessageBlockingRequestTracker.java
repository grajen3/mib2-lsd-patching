/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.arrays;

import de.vw.mib.bap.array.requests.BAPChangedArray;
import de.vw.mib.bap.array.requests.BAPGetArray;
import de.vw.mib.bap.array.requests.BAPStatusArray;
import de.vw.mib.bap.array.timer.Timer;
import de.vw.mib.bap.array.timer.TimerNotifier;
import de.vw.mib.bap.datatypes.BAPArray;
import de.vw.mib.bap.functions.Array;
import de.vw.mib.bap.functions.ArrayListener;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayMessageBlockingTracker;
import de.vw.mib.bap.mqbab2.common.timer.TimerObj;

public class FsgArrayMessageBlockingRequestTracker
implements TimerNotifier,
FsgArrayMessageBlockingTracker {
    private static final int REQUEST_MAX_NUMBER;
    private int numberRepeatedRequests = 0;
    private int prevLcuId = -1;
    private int prevTaId = -1;
    private static final int INVALID_ID;
    private final Array _array;
    private final ArrayListener _arrayListener;
    private BAPArray _lastReport;
    private BAPGetArray _lastRequest;
    private Timer _timer;
    private static final long TRANSMIT_TIMEOUT;

    public FsgArrayMessageBlockingRequestTracker(Array array, ArrayListener arrayListener) {
        this._array = array;
        this._arrayListener = arrayListener;
    }

    private boolean isRequestPending(int n, int n2) {
        boolean bl;
        boolean bl2 = bl = n == this.prevLcuId && n2 == this.prevTaId;
        if (!bl || ++this.numberRepeatedRequests >= 4) {
            this.resetPreviousRequest();
        }
        return bl;
    }

    private void trackRequest(int n, int n2) {
        this.numberRepeatedRequests = 0;
        this.prevLcuId = n;
        this.prevTaId = n2;
    }

    private void resetPreviousRequest() {
        this.numberRepeatedRequests = 0;
        this.prevLcuId = -1;
        this.prevTaId = -1;
    }

    private Array getArray() {
        return this._array;
    }

    private ArrayListener getArrayListener() {
        return this._arrayListener;
    }

    private Timer getTimer() {
        if (this._timer == null) {
            this._timer = new TimerObj(this, 0);
        }
        return this._timer;
    }

    private boolean isReportInProgress() {
        return this.getTimer().isRunning();
    }

    private boolean isReportQueueEmpty() {
        return this.getLastQueuedReport() == null;
    }

    private boolean isRequestQueueEmpty() {
        return this._lastRequest == null;
    }

    private boolean isReportChangedQueued() {
        return !this.isReportQueueEmpty() && this.getLastQueuedReport() instanceof BAPChangedArray;
    }

    private void enqueRequest(BAPGetArray bAPGetArray) {
        this._lastRequest = bAPGetArray;
    }

    private void enqueReport(BAPStatusArray bAPStatusArray) {
        if (this.isReportQueueEmpty() || !this.isReportChangedQueued()) {
            this._lastReport = bAPStatusArray;
        }
    }

    private void enqueReport(BAPChangedArray bAPChangedArray) {
        this._lastReport = bAPChangedArray;
    }

    private BAPGetArray dequeueRequest() {
        BAPGetArray bAPGetArray = this.getLastQueuedRequest();
        this.clearRequestQueue();
        return bAPGetArray;
    }

    private BAPArray dequeueReport() {
        BAPArray bAPArray = this.getLastQueuedReport();
        this.clearReportQueue();
        return bAPArray;
    }

    private BAPArray getLastQueuedReport() {
        return this._lastReport;
    }

    private BAPGetArray getLastQueuedRequest() {
        return this._lastRequest;
    }

    private void clearReportQueue() {
        this._lastReport = null;
    }

    private void clearRequestQueue() {
        this._lastRequest = null;
    }

    @Override
    public void reset() {
        this.resetPreviousRequest();
        this.stopTimer();
    }

    @Override
    public boolean requestGetArray(BAPGetArray bAPGetArray) {
        boolean bl;
        if (this.isReportInProgress()) {
            if (!this.isRequestPending(bAPGetArray.getAsgId(), bAPGetArray.getTransactionId())) {
                this.enqueRequest(bAPGetArray);
            }
            bl = false;
        } else {
            bl = true;
        }
        return bl;
    }

    @Override
    public void reportChangedArray(BAPChangedArray bAPChangedArray) {
        if (this.isReportInProgress()) {
            this.enqueReport(bAPChangedArray);
        } else {
            this.getArrayListener().changedArray(bAPChangedArray, this.getArray());
            this.startTimer();
        }
    }

    @Override
    public void reportStatusArray(BAPStatusArray bAPStatusArray) {
        if (this.isReportInProgress()) {
            this.enqueReport(bAPStatusArray);
        } else {
            this.getArrayListener().statusArray(bAPStatusArray, this.getArray());
            this.trackRequest(bAPStatusArray.getAsgId(), bAPStatusArray.getTransactionId());
            this.startTimer();
        }
    }

    @Override
    public void requestAcknowledge() {
        this.reset();
        if (this.isReportChangedQueued()) {
            this.clearRequestQueue();
            BAPChangedArray bAPChangedArray = (BAPChangedArray)this.dequeueReport();
            this.reportChangedArray(bAPChangedArray);
        } else if (!this.isRequestQueueEmpty()) {
            this.clearReportQueue();
            BAPGetArray bAPGetArray = this.dequeueRequest();
            this.getArray().getArray(bAPGetArray, this.getArrayListener());
        } else if (!this.isReportQueueEmpty()) {
            BAPStatusArray bAPStatusArray = (BAPStatusArray)this.dequeueReport();
            this.reportStatusArray(bAPStatusArray);
        }
    }

    @Override
    public void indicationError(int n) {
        if (n == 55 && this.isReportInProgress()) {
            this.getArrayListener().requestError(67, this.getArray());
        }
        this.reset();
    }

    private void stopTimer() {
        this.getTimer().stop();
    }

    private void startTimer() {
        this.getTimer().retrigger(null);
    }

    @Override
    public void timerFired(Timer timer) {
        this.requestAcknowledge();
    }
}


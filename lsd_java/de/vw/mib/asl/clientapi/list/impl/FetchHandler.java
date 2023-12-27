/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.clientapi.list.impl;

import de.vw.mib.asl.clientapi.list.ASLClientListFetcher;
import de.vw.mib.asl.clientapi.list.impl.ASLClientListImpl;
import de.vw.mib.asl.clientapi.list.impl.FetchDelegator;
import de.vw.mib.asl.clientapi.list.impl.FetchHandler$ViewRangesImpl;
import de.vw.mib.asl.clientapi.list.impl.FetchTimeoutHandler;
import de.vw.mib.asl.clientapi.list.impl.FetchTimer;
import de.vw.mib.asl.clientapi.list.impl.FetchTimerImpl;
import de.vw.mib.asl.clientapi.list.impl.LogUtil;
import de.vw.mib.asl.clientapi.list.impl.Services;
import de.vw.mib.list.Coverage;
import de.vw.mib.list.HMIList;
import de.vw.mib.list.HMIListDataFactory;
import de.vw.mib.list.Range;
import de.vw.mib.log4mib.LogMessage;

class FetchHandler
implements FetchTimeoutHandler {
    private static final String LOG_PREFIX;
    private final ASLClientListImpl list;
    private final Object semaphore;
    private final ASLClientListFetcher fetcher;
    private final int maxFetchSize;
    private final Services services;
    private final Coverage invalids;
    private final FetchHandler$ViewRangesImpl viewRanges;
    private final FetchTimer timer;
    private static final int DEFAULT_MAX_FETCH_TRIES;
    private int maxFetchTries = 5;
    private int cntFetchTries;
    private Range activeFetchRange;

    FetchHandler(ASLClientListImpl aSLClientListImpl, ASLClientListFetcher aSLClientListFetcher, int n) {
        this.list = aSLClientListImpl;
        this.semaphore = aSLClientListImpl.getSemaphore();
        this.fetcher = aSLClientListFetcher;
        this.maxFetchSize = n;
        this.services = aSLClientListImpl.getServices();
        HMIListDataFactory hMIListDataFactory = this.services.getFactory();
        this.invalids = hMIListDataFactory.createCoverage();
        this.viewRanges = FetchHandler$ViewRangesImpl.create(hMIListDataFactory);
        this.timer = new FetchTimerImpl(aSLClientListImpl, this.services, this);
    }

    private boolean isFetchingPossible() {
        return !this.isWaitingForUpdate();
    }

    private boolean isWaitingForUpdate() {
        return this.activeFetchRange != null;
    }

    private void startFetchTimer(Range range) {
        Range range2 = (Range)this.timer.startFetchTimer(range = null != range ? range.copy() : null);
        if (null != range2) {
            range2.release();
        }
    }

    private void stopFetchTimer() {
        Range range = (Range)this.timer.stopFetchTimer();
        if (null != range) {
            range.release();
        }
        this.cntFetchTries = 0;
        if (null != this.activeFetchRange) {
            this.activeFetchRange.release();
            this.activeFetchRange = null;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void fetchTimedOut(Object object) {
        Range range = (Range)object;
        Object object2 = this.semaphore;
        synchronized (object2) {
            boolean bl;
            if (null != range) {
                bl = range.intersects(this.activeFetchRange);
                range.release();
            } else {
                bl = false;
            }
            if (bl) {
                range = this.activeFetchRange;
                this.activeFetchRange = null;
                int n = range.getStart();
                int n2 = range.getEnd();
                range.release();
                if (++this.cntFetchTries > this.maxFetchTries) {
                    LogMessage logMessage = this.services.getLogger().error();
                    if (null != logMessage) {
                        LogUtil.appendPrefixAndMethod(logMessage, "FetchHandler", "fetchTimedOut", true);
                        LogUtil.appendRange(logMessage, n, n2 - n + 1, false).append(", max fetch retries reached - giving up");
                        LogUtil.appendListConfig(logMessage, this.list, true).log();
                    }
                    this.invalids.clearRange(n, n2);
                    this.cntFetchTries = 0;
                } else {
                    LogMessage logMessage = this.services.getLogger().warn();
                    if (null != logMessage) {
                        LogUtil.appendPrefixAndMethod(logMessage, "FetchHandler", "fetchTimedOut", true);
                        LogUtil.appendRange(logMessage, n, n2 - n + 1, false);
                        LogUtil.appendIntProperty(logMessage, "try", this.cntFetchTries, true);
                        LogUtil.appendListConfig(logMessage, this.list, true).log();
                    }
                }
                range = this.getNextFetchRange();
                if (null == range || range.getStart() != n || range.getEnd() != n2) {
                    this.cntFetchTries = 0;
                }
                if (null != range) {
                    this.fetch(range);
                }
            }
            this.list.fetchTimedOut();
        }
    }

    void setMaxFetchTries(int n) {
        this.maxFetchTries = n;
    }

    void initialFetch(int n) {
        this.stopFetchTimer();
        Range range = this.services.getFactory().createRange(0, Math.min(this.maxFetchSize, n) - 1);
        this.fetch(range);
    }

    void fetchAt(int n) {
        if (this.isFetchingPossible()) {
            Range range = this.invalids.getRangeAt(n);
            this.fetch(range);
        }
    }

    void addInvalidRange(int n, int n2) {
        this.invalids.addRange(n, n);
    }

    void clearInvalidRange(int n, int n2) {
        if (null != this.activeFetchRange && this.activeFetchRange.intersects(n, n2)) {
            this.stopFetchTimer();
        }
        this.invalids.clearRange(n, n2);
    }

    void clearInvalids() {
        this.stopFetchTimer();
        this.invalids.clear();
    }

    void fetch(Range range) {
        block12: {
            if (!this.isFetchingPossible()) {
                if (null != range) {
                    range.release();
                    range = null;
                }
            } else if (null == range) {
                range = this.getNextFetchRange();
            }
            if (null != range) {
                int n = range.getStart();
                int n2 = range.getEnd();
                if (n2 - n >= this.maxFetchSize) {
                    n2 = n + this.maxFetchSize - 1;
                    Range range2 = this.services.getFactory().createRange(n, n2);
                    range.release();
                    range = range2;
                }
                int n3 = n2 - n + 1;
                this.list.traceListRange("fetchItems", n, n3);
                this.activeFetchRange = range;
                this.startFetchTimer(range);
                Object object = 0 < n ? this.list.getItem(n - 1) : null;
                try {
                    if (FetchHandler.isValidItem(object)) {
                        FetchDelegator.fetchNextPage(this.services.getASLInvoker(), this.fetcher, this.list, object, n, n3);
                    } else {
                        Object object2 = object = n2 + 1 < this.list.getListSize() ? this.list.getItem(n2 + 1) : null;
                    }
                    if (FetchHandler.isValidItem(object)) {
                        FetchDelegator.fetchPreviousPage(this.services.getASLInvoker(), this.fetcher, this.list, object, n, n3);
                    } else {
                        FetchDelegator.fetchItems(this.services.getASLInvoker(), this.fetcher, this.list, n, n3);
                    }
                }
                catch (Exception exception) {
                    LogMessage logMessage = this.services.getLogger().error();
                    if (null == logMessage) break block12;
                    LogUtil.appendPrefixAndMethod(logMessage, "FetchHandler", "fetch", true).append("fetcher execution failed");
                    LogUtil.appendListConfig(logMessage, this.list, true).attachThrowable(exception).log();
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private Range getNextFetchRange() {
        Range range;
        if (this.invalids.isEmpty()) {
            range = null;
        } else {
            try {
                this.list.fillViewRanges(this.viewRanges);
                range = this.viewRanges.getNextFetchRange(this.invalids);
            }
            finally {
                this.viewRanges.clear();
            }
        }
        return range;
    }

    private static boolean isValidItem(Object object) {
        return null != object && HMIList.ITEM_NOT_LOADED != object;
    }
}


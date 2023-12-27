/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.has.internal;

import de.vw.mib.has.HASListRequest;
import de.vw.mib.has.internal.HASConfig;
import de.vw.mib.has.internal.Range;
import de.vw.mib.pool.PoorMansPool;

final class HASListControlImpl$PendingRequest {
    private static final int MAX_POOL_SIZE;
    private static final PoorMansPool POOL;
    private Range range;
    private HASListRequest request;
    private int ttl;

    private HASListControlImpl$PendingRequest() {
    }

    private static HASListControlImpl$PendingRequest borrow() {
        HASListControlImpl$PendingRequest hASListControlImpl$PendingRequest = (HASListControlImpl$PendingRequest)POOL.borrow();
        if (null == hASListControlImpl$PendingRequest) {
            hASListControlImpl$PendingRequest = new HASListControlImpl$PendingRequest();
        }
        return hASListControlImpl$PendingRequest;
    }

    static HASListControlImpl$PendingRequest create(HASListRequest hASListRequest) {
        HASListControlImpl$PendingRequest hASListControlImpl$PendingRequest = HASListControlImpl$PendingRequest.borrow();
        int n = hASListRequest.getOffset();
        int n2 = n + hASListRequest.getData().length - 1;
        hASListControlImpl$PendingRequest.range = Range.create(n, n2, null);
        hASListControlImpl$PendingRequest.request = hASListRequest;
        hASListControlImpl$PendingRequest.resetTTL();
        return hASListControlImpl$PendingRequest;
    }

    Range getRange() {
        return this.range;
    }

    HASListRequest getRequest() {
        return this.request;
    }

    boolean decreaseTTL(int n) {
        return 0 >= (this.ttl -= n);
    }

    void resetTTL() {
        this.ttl = HASConfig.getListRequestTTL();
    }

    void release() {
        this.range.release();
        this.range = null;
        this.request = null;
        POOL.release(this);
    }

    static {
        POOL = new PoorMansPool("HASList.PendingRequest", 5);
    }
}


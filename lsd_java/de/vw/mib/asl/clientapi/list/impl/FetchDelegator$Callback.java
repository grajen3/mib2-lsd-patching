/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.clientapi.list.impl;

import de.vw.mib.asl.clientapi.list.ASLClientList;
import de.vw.mib.asl.clientapi.list.ASLClientListFetcher;
import de.vw.mib.pool.PoorMansPool;

final class FetchDelegator$Callback
implements Runnable {
    private static final int MAX_POOL_SIZE;
    private static final PoorMansPool POOL;
    private static final int FETCHTYPE_ITEMS;
    private static final int FETCHTYPE_NEXTPAGE;
    private static final int FETCHTYPE_PREVIOUSPAGE;
    private int fetchType;
    private ASLClientListFetcher fetcher;
    private ASLClientList list;
    private Object item;
    private int index;
    private int count;

    private FetchDelegator$Callback() {
    }

    private static FetchDelegator$Callback borrow() {
        FetchDelegator$Callback fetchDelegator$Callback = (FetchDelegator$Callback)POOL.borrow();
        if (null == fetchDelegator$Callback) {
            fetchDelegator$Callback = new FetchDelegator$Callback();
        }
        return fetchDelegator$Callback;
    }

    private FetchDelegator$Callback init(int n, ASLClientListFetcher aSLClientListFetcher, ASLClientList aSLClientList, Object object, int n2, int n3) {
        this.fetchType = n;
        this.fetcher = aSLClientListFetcher;
        this.list = aSLClientList;
        this.item = object;
        this.index = n2;
        this.count = n3;
        return this;
    }

    private void release() {
        this.fetcher = null;
        this.list = null;
        this.item = null;
        POOL.release(this);
    }

    static FetchDelegator$Callback fetchItemsCallback(ASLClientListFetcher aSLClientListFetcher, ASLClientList aSLClientList, int n, int n2) {
        return FetchDelegator$Callback.borrow().init(0, aSLClientListFetcher, aSLClientList, null, n, n2);
    }

    static FetchDelegator$Callback fetchNextPageCallback(ASLClientListFetcher aSLClientListFetcher, ASLClientList aSLClientList, Object object, int n, int n2) {
        return FetchDelegator$Callback.borrow().init(1, aSLClientListFetcher, aSLClientList, object, n, n2);
    }

    static FetchDelegator$Callback fetchPreviousPageCallback(ASLClientListFetcher aSLClientListFetcher, ASLClientList aSLClientList, Object object, int n, int n2) {
        return FetchDelegator$Callback.borrow().init(2, aSLClientListFetcher, aSLClientList, object, n, n2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void run() {
        try {
            switch (this.fetchType) {
                case 0: {
                    this.fetcher.fetchItems(this.list, this.index, this.count);
                    return;
                }
                case 1: {
                    this.fetcher.fetchNextPage(this.list, this.item, this.index, this.count);
                    return;
                }
                case 2: {
                    this.fetcher.fetchPrevPage(this.list, this.item, this.index, this.count);
                    return;
                }
                default: {
                    throw new RuntimeException(new StringBuffer().append("Unknown fetch type: ").append(this.fetchType).toString());
                }
            }
        }
        finally {
            this.release();
        }
    }

    static {
        POOL = new PoorMansPool("ASLClientList.FetcherCallback", 3);
    }
}

